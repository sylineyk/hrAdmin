package com.hong.admin.service.order;

import com.hong.admin.dao.entity.order.JsJjrInfo;
import com.hong.admin.dao.entity.order.PayOrder;
import com.hong.admin.dao.entity.order.PayOrderExample;
import com.hong.admin.dao.mapper.broker.BrokerMapper;
import com.hong.admin.dao.mapper.nurse.NurseMapper;
import com.hong.admin.dao.mapper.order.*;
import com.hong.admin.util.Constant;
import com.hong.admin.util.GeneralUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by syline on 2017/7/22.
 */
@Service
public class OrderService {

    @Autowired
    private OrderFormalMapper orderFormalMapper;

    @Autowired
    private OnceOrderAppDetailMapper onceOrderAppDetailMapper;

    @Autowired
    private MultiOrderAppDetailMapper multiOrderAppDetailMapper;

    @Autowired
    private NonStandardOrderAppDetailMapper nonMapper;

    @Autowired
    private NurseMapper nurseMapper;

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private BrokerMapper brokerMapper;

    public Map selectJsInfo(int brokerId, Date fromDate, Date toDate, String nurseName) {
        Map result = new HashMap<>();
        if (!StringUtils.isEmpty(nurseName)) {
            nurseName = "%" + nurseName + "%";
        }
//        List<Map> list = orderFormalMapper.selectJsInfoByParam(brokerId, nurseName, fromDate, toDate);

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andBrokerIdEqualTo(brokerId).andPayTimeBetween(fromDate, toDate);
        if (!StringUtils.isEmpty(nurseName)) {
            criteria.andNurseNameLike(nurseName);
        }
        List<PayOrder> list = payOrderMapper.selectByExample(example);

        int zje = 0;
        int js = 0;//非标准和包月的总额
        double pdsr = 0;
        int aygz = 0;
        double ysje = 0;
        if (list.size() > 0) {
            for (PayOrder entity : list) {
                String type = entity.getType();
                if (type.equals(Constant.OrderKey.TYPE_ZDG)) {
                    aygz += entity.getGz();
                    zje += entity.getGz();
                } else if (type.equals(Constant.OrderKey.TYPE_BYZDG)) {
                    js += entity.getFwf();
                    zje += entity.getFwf();
                } else {
                    js += entity.getKhzf();
                    zje += entity.getKhzf();
                }
            }
        }
        pdsr = js * 0.1;
        ysje = js * 0.9;

        DecimalFormat df = new DecimalFormat("#.00");

        result.put("zje", zje);
        result.put("pdsr", df.format(pdsr));
        result.put("aygz", aygz);
        result.put("ysje", df.format(ysje));
        return result;
    }


    public Map selectJsDetailInfo(int brokerId, Date fromDate, Date toDate, int currentPage, String nurseName) {
        Map result = new HashMap<>();
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andBrokerIdEqualTo(brokerId).andPayTimeBetween(fromDate, toDate);
        if (!StringUtils.isEmpty(nurseName)) {
            criteria.andNurseNameLike("%" + nurseName + "%");
        }

        PageList<PayOrder> list = payOrderMapper.selectByExamplePage(example, new PageBounds(currentPage, Constant.PageKey.LIMIT));
        int currpage = list.getPaginator().getPage();
        int total = list.getPaginator().getTotalPages();


        List<JsJjrInfo> jsJjrInfos = new ArrayList<>();
        for (PayOrder entity : list) {
            String type = entity.getType();

            JsJjrInfo ob = new JsJjrInfo();
            ob.setCode(entity.getCode());
            ob.setType(GeneralUtil.getOrderTypeName(type));
            ob.setNurseName(entity.getNurseName());
            ob.setPhone(entity.getNursePhone());
            if (type.equals(Constant.OrderKey.TYPE_ZDG)) {
                ob.setGz(String.valueOf(entity.getKhzf()));
                ob.setFwf("");
                ob.setDj("");
                ob.setKhzf("");
            } else if (type.equals(Constant.OrderKey.TYPE_BYZDG)) {
                ob.setGz("");
                ob.setFwf(String.valueOf(entity.getKhzf()));
                ob.setDj("");
                ob.setKhzf(String.valueOf(entity.getKhzf()));
            } else {
                ob.setGz("");
                ob.setFwf(String.valueOf(entity.getFwf()));
                ob.setDj(String.valueOf(entity.getDj()));
                ob.setKhzf(String.valueOf(entity.getKhzf()));
            }
            jsJjrInfos.add(ob);
        }

        result.put("results", jsJjrInfos);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public Map selectJsCenterInfo(Date fromDate, Date toDate) {
        Map result = new HashMap<>();
//        List<Map> list = orderFormalMapper.selectJsInfoByParam(0, null, fromDate, toDate);

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate);
        List<PayOrder> list = payOrderMapper.selectByExample(example);

        float js = 0;//非标准和包月的总额
        double pdsr = 0;
        int aygz = 0;
        double ysje = 0;
        if (list.size() > 0) {
            for (PayOrder entity : list) {
                String type = entity.getType();
                if (type.equals(Constant.OrderKey.TYPE_ZDG)) {
                    aygz += entity.getGz();
                } else {
                    js += entity.getKhzf();
                }
            }
        }
        pdsr = js * 0.1;
        ysje = js * 0.9;

        DecimalFormat df = new DecimalFormat("#.00");

        result.put("pdsr", df.format(pdsr));
        result.put("aygz", aygz);
        result.put("ysje", df.format(ysje));
        return result;
    }


    /**
     * 平台收入明细查询
     *
     * @param busType
     * @param fromDate
     * @param toDate
     * @param name
     * @return
     */
    public Map selectJsPtDetailInfo(String busType, Date fromDate, Date toDate, String name) {
        Map result = new HashMap<>();
        if (!StringUtils.isEmpty(name)) {
            name = "%" + name + "%";
        }
//        List<Map> list = orderFormalMapper.selectJsInfoByParam(brokerId, nurseName, fromDate, toDate);

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate);

        if (busType.equals("1") && !StringUtils.isEmpty(name)) {
            criteria.andNurseNameLike(name);
        } else if (busType.equals("2") && !StringUtils.isEmpty(name)) {
            criteria.andBrokerNameLike(name);
        }
        List<PayOrder> list = payOrderMapper.selectByExample(example);

        int zje = 0;
        int js = 0;//非标准和包月的总额
        double pdsr = 0;
        int aygz = 0;
        double ysje = 0;
        if (list.size() > 0) {
            for (PayOrder entity : list) {
                String type = entity.getType();
                if (type.equals(Constant.OrderKey.TYPE_ZDG)) {
                    aygz += entity.getGz();
                    zje += entity.getGz();
                } else if (type.equals(Constant.OrderKey.TYPE_BYZDG)) {
                    js += entity.getFwf();
                    zje += entity.getFwf();
                } else {
                    js += entity.getKhzf();
                    zje += entity.getKhzf();
                }
            }
        }
        pdsr = js * 0.1;
        ysje = js * 0.9;

        DecimalFormat df = new DecimalFormat("#.00");

        result.put("zje", zje);
        result.put("pdsr", df.format(pdsr));
        result.put("aygz", aygz);
        result.put("ysje", df.format(ysje));
        return result;
    }


    public Map selectJsPtDetailPageInfo(String busType, Date fromDate, Date toDate, int currentPage, String name) {
        Map result = new HashMap<>();
        if (!StringUtils.isEmpty(name)) {
            name = "%" + name + "%";
        }
//        List<Map> list = orderFormalMapper.selectJsInfoByParam(brokerId, nurseName, fromDate, toDate);

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate);

        if (busType.equals("1") && !StringUtils.isEmpty(name)) {
            criteria.andNurseNameLike(name);
        } else if (busType.equals("2") && !StringUtils.isEmpty(name)) {
            criteria.andBrokerNameLike(name);
        }

        PageList<PayOrder> list = payOrderMapper.selectByExamplePage(example, new PageBounds(currentPage, Constant.PageKey.LIMIT));
        int currpage = list.getPaginator().getPage();
        int total = list.getPaginator().getTotalPages();


        List<JsJjrInfo> jsJjrInfos = new ArrayList<>();
        for (PayOrder entity : list) {
            String type = entity.getType();

            JsJjrInfo ob = new JsJjrInfo();
            ob.setCode(entity.getCode());
            ob.setType(GeneralUtil.getOrderTypeName(type));
            ob.setNurseName(entity.getNurseName());
            ob.setPhone(entity.getNursePhone());
            ob.setBrokerName(entity.getBrokerName());
            if (type.equals(Constant.OrderKey.TYPE_ZDG)) {
                ob.setGz(String.valueOf(entity.getKhzf()));
                ob.setFwf("");
                ob.setDj("");
                ob.setKhzf("");
            } else if (type.equals(Constant.OrderKey.TYPE_BYZDG)) {
                ob.setGz("");
                ob.setFwf(String.valueOf(entity.getKhzf()));
                ob.setDj("");
                ob.setKhzf(String.valueOf(entity.getKhzf()));
            } else {
                ob.setGz("");
                ob.setFwf(String.valueOf(entity.getFwf()));
                ob.setDj(String.valueOf(entity.getDj()));
                ob.setKhzf(String.valueOf(entity.getKhzf()));
            }
            jsJjrInfos.add(ob);
        }

        result.put("results", jsJjrInfos);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public Map selectJsJjrDetailPageInfo(Date fromDate, Date toDate, int currentPage) {
        Map result = new HashMap<>();

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate);

        PageList<Map> list = payOrderMapper.selectJjrDetailByDate(fromDate, toDate, new PageBounds(currentPage, Constant.PageKey.LIMIT));
        int currpage = list.getPaginator().getPage();
        int total = list.getPaginator().getTotalPages();


        List<Map> resultList = new ArrayList<>();
        for (Map entity : list) {
            String phone = String.valueOf(entity.get("broker_phone"));
            String name = brokerMapper.selectBrokerNmaeByPhone(phone);
            double zje = (double) entity.get("zje");
            Map map = new HashMap<>();
            map.put("name", name);
            map.put("phone", phone);
            map.put("bankCode", "");

            double yfje = zje * 0.9;

            DecimalFormat df = new DecimalFormat("#.00");

            map.put("yfje", df.format(yfje));
            resultList.add(map);
        }


        result.put("results", resultList);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public Map selectJsAyDetailPageInfo(Date fromDate, Date toDate, int currentPage) {
        Map result = new HashMap<>();

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate);

        PageList<Map> list = payOrderMapper.selectAyDetailByDate(fromDate, toDate, new PageBounds(currentPage, Constant.PageKey.LIMIT));
        int currpage = list.getPaginator().getPage();
        int total = list.getPaginator().getTotalPages();


        List<Map> resultList = new ArrayList<>();
        for (Map entity : list) {
            String phone = String.valueOf(entity.get("nurse_phone"));
            Map info = nurseMapper.selectInfoByPhone(phone);
            String name = String.valueOf(info.get("name"));
            String bankCode = String.valueOf(info.get("bank_code"));
            double zje = (double) entity.get("zje");
            Map map = new HashMap<>();
            map.put("name", name);
            map.put("phone", phone);
            map.put("bankCode", bankCode.equals("null") ? "" : bankCode);
            DecimalFormat df = new DecimalFormat("#.00");
            map.put("yfje", df.format(zje));
            resultList.add(map);
        }

        result.put("results", resultList);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public Map selectJsJjrJsDetailPageInfo(String phone, Date fromDate, Date toDate, int currentPage) {
        Map result = new HashMap<>();
//        List<Map> list = orderFormalMapper.selectJsInfoByParam(brokerId, nurseName, fromDate, toDate);

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate).andBrokerPhoneEqualTo(phone).andTypeNotEqualTo("5");


        PageList<PayOrder> list = payOrderMapper.selectByExamplePage(example, new PageBounds(currentPage, Constant.PageKey.LIMIT));
        int currpage = list.getPaginator().getPage();
        int total = list.getPaginator().getTotalPages();


        List<JsJjrInfo> jsJjrInfos = new ArrayList<>();
        for (PayOrder entity : list) {
            String type = entity.getType();

            JsJjrInfo ob = new JsJjrInfo();
            ob.setCode(entity.getCode());
            ob.setType(GeneralUtil.getOrderTypeName(type));
            ob.setNurseName(entity.getNurseName());
            ob.setPhone(entity.getNursePhone());
            ob.setBrokerName(entity.getBrokerName());
            if (type.equals(Constant.OrderKey.TYPE_BYZDG)) {
                ob.setGz("");
                ob.setFwf(String.valueOf(entity.getKhzf()));
                ob.setDj("");
                ob.setKhzf(String.valueOf(entity.getKhzf()));
            } else {
                ob.setGz("");
                ob.setFwf(String.valueOf(entity.getFwf()));
                ob.setDj(String.valueOf(entity.getDj()));
                ob.setKhzf(String.valueOf(entity.getKhzf()));
            }
            jsJjrInfos.add(ob);
        }

        result.put("results", jsJjrInfos);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public Map selectJsAyJsDetailPageInfo(String phone, Date fromDate, Date toDate, int currentPage) {
        Map result = new HashMap<>();
//        List<Map> list = orderFormalMapper.selectJsInfoByParam(brokerId, nurseName, fromDate, toDate);

        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayTimeBetween(fromDate, toDate).andNursePhoneEqualTo(phone).andTypeEqualTo("5");


        PageList<PayOrder> list = payOrderMapper.selectByExamplePage(example, new PageBounds(currentPage, Constant.PageKey.LIMIT));
        int currpage = list.getPaginator().getPage();
        int total = list.getPaginator().getTotalPages();


        List<JsJjrInfo> jsJjrInfos = new ArrayList<>();
        for (PayOrder entity : list) {
            String type = entity.getType();

            JsJjrInfo ob = new JsJjrInfo();
            ob.setCode(entity.getCode());
            ob.setType(GeneralUtil.getOrderTypeName(type));
            ob.setNurseName(entity.getNurseName());
            ob.setPhone(entity.getNursePhone());
            ob.setBrokerName(entity.getBrokerName());
            ob.setGz(String.valueOf(entity.getGz()));
            jsJjrInfos.add(ob);
        }

        result.put("results", jsJjrInfos);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }
}

