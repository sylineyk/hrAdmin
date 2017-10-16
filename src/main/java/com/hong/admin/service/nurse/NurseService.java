package com.hong.admin.service.nurse;

import com.hong.admin.dao.entity.nurse.*;
import com.hong.admin.dao.entity.order.OrderFormal;
import com.hong.admin.dao.entity.order.OrderFormalExample;
import com.hong.admin.dao.mapper.broker.BrokerMapper;
import com.hong.admin.dao.mapper.nurse.NurseImgMapper;
import com.hong.admin.dao.mapper.nurse.NurseImportMapper;
import com.hong.admin.dao.mapper.nurse.NurseMapper;
import com.hong.admin.dao.mapper.order.OrderFormalMapper;
import com.hong.admin.util.Constant;
import com.hong.admin.util.GeneralUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * Created by syline on 2017/7/22.
 */
@Service
public class NurseService {

    @Autowired
    private NurseMapper nurseMapper;

    @Autowired
    private NurseImgMapper nurseImgMapper;


    @Autowired
    private NurseImportMapper importMapper;

    @Autowired
    private BrokerMapper brokerMapper;

    @Autowired
    private OrderFormalMapper orderFormalMapper;


    /**
     * 获取阿姨信息
     *
     * @return
     */
    public Map selectNurseInfos(Nurse nurse, int brokerId, int currPage) {
        Map result = new HashMap<>();
        PageList<Map> map = nurseMapper.selectNurseInfoByParam(nurse, brokerId, new PageBounds(currPage, Constant.PageKey.LIMIT));
        int currpage = map.getPaginator().getPage();
        int total = map.getPaginator().getTotalPages();

        for (Map obj : map) {
            String type = String.valueOf(obj.get("type"));
            int nurseId = (int) obj.get("id");
            if (org.apache.commons.lang3.StringUtils.isEmpty(type) || type.equals("null")) {
                obj.put("type", "");
            } else {
                obj.put("type", GeneralUtil.getNamesByTypes("service", type));
            }
            String city = String.valueOf(obj.get("service_area"));
            if (org.apache.commons.lang3.StringUtils.isEmpty(city) || city.equals("null")) {
                obj.put("service_area", "");
            } else {
                obj.put("service_area", GeneralUtil.getNamesByTypes("city", city));
            }
            if (isCanDeleteNurseById(nurseId)) {
                obj.put("delFlag", "1");
            } else {
                obj.put("delFlag", "0");
            }
        }
        result.put("results", (List) map);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public int getIdByPhone(String phone) {
        int id = 0;
        NurseExample example = new NurseExample();
        example.createCriteria().andPhoneNumberEqualTo(phone);
        List<Nurse> list = nurseMapper.selectByExample(example, new PageBounds(1, 2));
        if (list.size() > 0) {
            id = list.get(0).getId();
        }
        return id;
    }


    /**
     * 根据阿姨ID查询阿姨详细信息
     *
     * @param id
     * @return
     */
    public Map selectNurseDetailInfoById(int id) {
        Map map = new HashMap<>();
        Nurse nurse = nurseMapper.selectByPrimaryKey(id);

        String service = nurse.getType();
        String city = nurse.getServiceArea();

        if (StringUtils.isEmpty(service) || service.equals("null")) {
            nurse.setTypeNames("");
        } else {
            nurse.setTypeNames(GeneralUtil.getNamesByTypes("service", nurse.getType()));
        }

        if (StringUtils.isEmpty(city) || city.equals("null")) {
            nurse.setServiceAreaNames("");
        } else {
            nurse.setServiceAreaNames(GeneralUtil.getNamesByTypes("city", nurse.getServiceArea()));
        }


        Date startDate = nurse.getHtStartDate();
        Date endDate = nurse.getHtEndDate();

        if (startDate == null) {
            nurse.setHtStartDateStr("");
        } else {
            nurse.setHtStartDateStr(GeneralUtil.getDateStr(startDate));
        }


        if (endDate == null) {
            nurse.setHtEndDateStr("");
        } else {
            nurse.setHtEndDateStr(GeneralUtil.getDateStr(endDate));
        }


        map.put("nurse", nurse);


        NurseImgExample example = new NurseImgExample();
        example.createCriteria().andNurseIdEqualTo(id).andStatusEqualTo("1");
        List<NurseImg> imgs = nurseImgMapper.selectByExample(example);


        List<Map> ryzsList = new ArrayList<>();
        List<Map> cardList = new ArrayList<>();
        List<Map> liveList = new ArrayList<>();

        for (NurseImg img : imgs) {
            String type = img.getType();
            Map m1 = new HashMap<>();
            m1.put("id", img.getId());
            m1.put("path", img.getPath());
            if (type.equals("1")) {
                cardList.add(m1);
            } else if (type.equals("2")) {
                ryzsList.add(m1);
            } else if (type.equals("3")) {
                liveList.add(m1);
            }
        }
        map.put("ryzs", ryzsList);
        map.put("card", cardList);
        map.put("live", liveList);
        return map;
    }


    public int deleteNurseById(int nurseId) {
        Nurse nurse = new Nurse();
        nurse.setId(nurseId);
        nurse.setStatus("99");
        int flag = nurseMapper.updateByPrimaryKeySelective(nurse);
        return flag;
    }


    public int deleteNurseByIds(String nurseIds) {
        int flag = 0;
        String[] ids = nurseIds.split(",");
        for (String id : ids) {
            Nurse nurse = new Nurse();
            nurse.setId(Integer.parseInt(id));
            nurse.setStatus("99");
            flag += nurseMapper.updateByPrimaryKeySelective(nurse);
        }
        return flag;
    }


    /**
     * 修改阿姨头像
     *
     * @param path
     * @return
     */
    public int updateImagePath(int id, String path) {
        Nurse nurse = new Nurse();
        nurse.setId(id);
        nurse.setImgPath(path);
        return nurseMapper.updateByPrimaryKeySelective(nurse);
    }


    public boolean isNurseExists(String phone) {
        boolean flag = false;
        NurseExample example = new NurseExample();
        example.createCriteria().andPhoneNumberEqualTo(phone).andStatusNotEqualTo("99");
        List<Nurse> list = nurseMapper.selectByExample(example, new PageBounds(0, 100));
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }


    public boolean isNurseExistsByIdcard(String idCard) {
        boolean flag = false;
        NurseExample example = new NurseExample();
        example.createCriteria().andIdcardEqualTo(idCard).andStatusNotEqualTo("99");
        List<Nurse> list = nurseMapper.selectByExample(example, new PageBounds(0, 100));
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }


    public int addNurseInfo(Nurse nurse) {
        int flag = 0;
        String phone = nurse.getPhoneNumber();
        String pwdmw = phone.substring(phone.length() - 4, phone.length());
        String pwd = DigestUtils.md5DigestAsHex(pwdmw.getBytes());
        nurse.setPassword(pwd);
        if (StringUtils.isEmpty(nurse.getImgPath())) {
            nurse.setImgPath("http://chouguanjia.oss-cn-shanghai.aliyuncs.com/user-dir/user.png");
        }
        flag = nurseMapper.insertSelective(nurse);
        if (flag > 0) {
            List<NurseImg> list = new ArrayList<>();
            String pathRys = nurse.getPathRy();
            if (!StringUtils.isEmpty(pathRys)) {
                String[] pathRy = pathRys.split(",");
                for (int i = 1; i < pathRy.length; i++) {
                    NurseImg img = new NurseImg();
                    img.setNurseId(nurse.getId());
                    img.setStatus("1");
                    img.setType("2");
                    img.setPath(pathRy[i]);
                    nurseImgMapper.insertSelective(img);
                }
            }
            String pathCards = nurse.getPathCard();
            if (!StringUtils.isEmpty(pathCards)) {
                String[] pathCard = pathCards.split(",");
                for (int i = 1; i < pathCard.length; i++) {
                    NurseImg img = new NurseImg();
                    img.setNurseId(nurse.getId());
                    img.setStatus("1");
                    img.setType("1");
                    img.setPath(pathCard[i]);
                    nurseImgMapper.insertSelective(img);
                }
            }
            String pathLives = nurse.getPathLive();
            if (!StringUtils.isEmpty(pathLives)) {
                String[] pathLive = pathLives.split(",");
                for (int i = 1; i < pathLive.length; i++) {
                    NurseImg img = new NurseImg();
                    img.setNurseId(nurse.getId());
                    img.setStatus("2");
                    img.setType("3");
                    img.setPath(pathLive[i]);
                    nurseImgMapper.insertSelective(img);
                }
            }
        }
        return flag;
    }


    public int editNurseInfo(Nurse nurse, String status) {
        int flag = 0;
        int nurseId = nurse.getId();
        flag = nurseMapper.updateByPrimaryKeySelective(nurse);
        String pathRys = nurse.getPathRy();
        String pathCards = nurse.getPathCard();
        String pathLives = nurse.getPathLive();
        String delRys = nurse.getDelRy();
        String delCards = nurse.getDelCard();
        String delLives = nurse.getDelLive();

        if (!org.apache.commons.lang3.StringUtils.isEmpty(pathRys)) {
            String[] pathRy = pathRys.split(",");
            for (int i = 1; i < pathRy.length; i++) {
                NurseImg img = new NurseImg();
                img.setNurseId(nurseId);
                img.setStatus(status);
                img.setType("2");
                img.setPath(pathRy[i]);
                flag += nurseImgMapper.insertSelective(img);
            }
        }
        if (!org.apache.commons.lang3.StringUtils.isEmpty(pathCards)) {
            String[] pathCard = pathCards.split(",");
            for (int i = 1; i < pathCard.length; i++) {
                NurseImg img = new NurseImg();
                img.setNurseId(nurseId);
                img.setStatus(status);
                img.setType("1");
                img.setPath(pathCard[i]);
                flag += nurseImgMapper.insertSelective(img);
            }
        }
        if (!org.apache.commons.lang3.StringUtils.isEmpty(pathLives)) {
            String[] pathLive = pathLives.split(",");
            for (int i = 1; i < pathLive.length; i++) {
                NurseImg img = new NurseImg();
                img.setNurseId(nurseId);
                img.setStatus("0");
                img.setType("3");
                img.setPath(pathLive[i]);
                flag += nurseImgMapper.insertSelective(img);
            }
        }

        if (!org.apache.commons.lang3.StringUtils.isEmpty(delRys)) {
            String[] pathRy = delRys.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < pathRy.length; i++) {
                list.add(Integer.parseInt(pathRy[i]));
            }
            NurseImgExample example = new NurseImgExample();
            example.createCriteria().andIdIn(list);
            flag += nurseImgMapper.deleteByExample(example);
        }

        if (!org.apache.commons.lang3.StringUtils.isEmpty(delCards)) {
            String[] pathRy = delCards.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < pathRy.length; i++) {
                list.add(Integer.parseInt(pathRy[i]));
            }
            NurseImgExample example = new NurseImgExample();
            example.createCriteria().andIdIn(list);
            flag += nurseImgMapper.deleteByExample(example);
        }
        if (!org.apache.commons.lang3.StringUtils.isEmpty(delLives)) {
            String[] pathRy = delLives.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < pathRy.length; i++) {
                list.add(Integer.parseInt(pathRy[i]));
            }
            NurseImgExample example = new NurseImgExample();
            example.createCriteria().andIdIn(list);
            flag += nurseImgMapper.deleteByExample(example);
        }

        return flag;
    }


    /**
     * 获取导入的阿姨信息
     *
     * @return
     */
    public Map selectNurseImportInfos(Date startDate, Date endDate, String flag, int brokerId, int currPage) {
        Map result = new HashMap<>();

        NurseImportExample example = new NurseImportExample();
        example.setOrderByClause("create_time DESC");
        NurseImportExample.Criteria criteria = example.createCriteria();

        if (startDate != null && endDate != null) {
            criteria.andCreateTimeBetween(startDate, endDate);
        }
        if (!org.apache.commons.lang3.StringUtils.isEmpty(flag)) {
            criteria.andFlagEqualTo(flag);
        }
        criteria.andBrokerIdEqualTo(brokerId);


        PageList<NurseImport> map = importMapper.selectByExample(example, new PageBounds(currPage, Constant.PageKey.LIMIT));
        int currpage = map.getPaginator().getPage();
        int total = map.getPaginator().getTotalPages();

        result.put("results", (List) map);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public int deleteImportNurseById(int id) {
        int flag = importMapper.deleteByPrimaryKey(id);
        return flag;
    }


    public int deleteImportNurseByIds(String nurseIds) {
        int flag = 0;
        String[] ids = nurseIds.split(",");
        for (String id : ids) {
            flag += importMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return flag;
    }


    /**
     * 根据阿姨ID查询阿姨详细信息
     *
     * @param id
     * @return
     */
    public Map selectImportDetailInfoById(int id) {
        Map map = new HashMap<>();
        NurseImport nurse = importMapper.selectByPrimaryKey(id);
        nurse.setStartDate(GeneralUtil.getDateStr(nurse.getHtStartDate()));
        nurse.setEndDate(GeneralUtil.getDateStr(nurse.getHtEndDate()));
        map.put("nurse", nurse);
        return map;
    }


    /**
     * 审核照片所属阿姨查询
     *
     * @param status
     * @param page
     * @return
     */
    public PageList<Map> selectShList(int page, int brokerId, String status) {
        PageList<Map> nurses = nurseMapper.selectShNurseByParam(brokerId, status, new PageBounds(page, 5));
        return nurses;
    }


    /**
     * 审核照片列表查询
     *
     * @param status
     * @return
     */
    public List<String> selectShPicsList(int brokerId, int nurseId, String status) {
        List<String> pics = nurseMapper.selectShPicsByParam(brokerId, nurseId, status);
        return pics;
    }


    public Nurse getNurseById(int id) {
        return nurseMapper.selectByPrimaryKey(id);
    }


    public List<String> getPicturePathListByNurseIdAndType(int nurseId, String type, String status) {
        NurseImgExample example = new NurseImgExample();
        example.createCriteria().andNurseIdEqualTo(nurseId).andTypeEqualTo(type).andStatusEqualTo(status);
        List<NurseImg> infos = nurseImgMapper.selectByExample(example);
        List<String> paths = new ArrayList<>();
        for (NurseImg img : infos) {
            paths.add(img.getPath());
        }
        return paths;
    }


    public void updateImgStatus(int nurseId, String type) {
        NurseImg img = new NurseImg();
        String status = "1";
        if (type.equals("reject")) {
            status = "2";
        }
        img.setStatus(status);
        NurseImgExample example = new NurseImgExample();
        example.createCriteria().andNurseIdEqualTo(nurseId).andStatusEqualTo("0");
        nurseImgMapper.updateByExampleSelective(img, example);
    }

    /**
     * 生活审核照片所属阿姨查询
     *
     * @param status
     * @param page
     * @return
     */
    public PageList<Map> selectShShList(int page, String status) {
        PageList<Map> nurses = nurseMapper.selectShShNurseByParam(status, new PageBounds(page, 5));
        return nurses;
    }


    /**
     * 生活审核照片列表查询
     *
     * @param status
     * @return
     */
    public List<String> selectShShPicsList(int nurseId, String status) {
        List<String> pics = nurseMapper.selectShShPicsByParam(nurseId, status);
        return pics;
    }


    public boolean isCanDeleteNurseById(int nurseId) {
        boolean flag = true;

        OrderFormalExample example = new OrderFormalExample();
        example.createCriteria().andNurseIdEqualTo(nurseId);

        List<OrderFormal> list = orderFormalMapper.selectByExample(example);
        if (list.size() > 0) {
            List<String> sl = new ArrayList<>();
            sl.add("9");
            sl.add("0");
            example = new OrderFormalExample();
            example.createCriteria().andNurseIdEqualTo(nurseId).andStatusNotIn(sl);
            list = orderFormalMapper.selectByExample(example);
            if (list.size() > 0) {
                flag = false;
            }
        }
        return flag;
    }

    public int updateImport(NurseImport nurseImport) {
        return importMapper.updateByPrimaryKeySelective(nurseImport);
    }
}
