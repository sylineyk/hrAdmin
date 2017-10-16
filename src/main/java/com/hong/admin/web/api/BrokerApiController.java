package com.hong.admin.web.api;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.hong.admin.dao.entity.broker.Broker;
import com.hong.admin.dao.entity.nurse.Nurse;
import com.hong.admin.dao.entity.nurse.NurseImport;
import com.hong.admin.query.entity.nurse.NurseQueryParam;
import com.hong.admin.security.domain.UserInfo;
import com.hong.admin.service.broker.BorkerService;
import com.hong.admin.service.nurse.NurseService;
import com.hong.admin.service.order.OrderService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yk
 * @version 1.0.0
 */
@RestController
@RequestMapping("/broker")
public class BrokerApiController {
    private static final Logger BROKER_LOG = LoggerFactory.getLogger("BrokerLog");

    @Autowired
    private NurseService nurseService;


    @Autowired
    private BorkerService brokerService;

    @Autowired
    private OrderService orderService;


    @ModelAttribute("brokerId")
    public int getBrokerId(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id = ((UserInfo) auth.getPrincipal()).getId();
        request.getSession().setAttribute("brokerId", id);
        return ((UserInfo) auth.getPrincipal()).getId();
    }


    /**
     * form表单提交 Date类型数据绑定
     * <功能详细描述>
     *
     * @param binder
     * @see [类、类#方法、类#成员]
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 阿姨列表查询根据条件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/nurseList/param/api", method = RequestMethod.GET)
    public Map nurseListByParam(@SessionAttribute int brokerId, @ModelAttribute NurseQueryParam queryParam, BindingResult bindingResult, HttpServletRequest request
    ) {
        int flag = 0;
        Nurse nurse = new Nurse();


        String nurseType = queryParam.getNurseType();
        String area = queryParam.getArea();
        String salaryType = queryParam.getSalaryType();
        Date fromDate = queryParam.getFromDate();
        Date endDate = queryParam.getEndDate();
        String paramStr = queryParam.getParamStr();


        if (!StringUtils.isEmpty(nurseType)) {
            if (!"5".equals(nurseType)) {
                nurse.setType("%" + nurseType + "%");
            } else {
                nurse.setNurseZdgType(nurseType);
            }
        }
        if (!StringUtils.isEmpty(area)) {
            nurse.setServiceArea("%" + area + "%");
        }
        if (!StringUtils.isEmpty(paramStr)) {
            nurse.setParamStr("%" + paramStr + "%");
        }
        if (!StringUtils.isEmpty(salaryType)) {
            nurse.setSalaryType(salaryType);
        }
//        if (fromDate != null && endDate != null) {
//            nurse.setDataIds(nurseService.getDateIds(fromDate, endDate));
//        }
        nurse.setBrokerId(brokerId);
        Map result = nurseService.selectNurseInfos(nurse, brokerId, queryParam.getCurrentPage());
        return result;
    }


    /**
     * 删除阿姨
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurse/param/api", method = RequestMethod.POST)
    public Map deleteNurse(HttpServletRequest request, String nurseIds) {
        Map map = new HashMap<>();
        int flag = 0;
        if (nurseIds.indexOf(",") < 0) {
            flag = nurseService.deleteNurseById(Integer.parseInt(nurseIds));
        } else {
            flag = nurseService.deleteNurseByIds(nurseIds);
        }
        map.put("flag", flag);
        return map;
    }

    @RequestMapping("/3/getSignStr")
    public Map getNurseSign(HttpServletResponse response) {
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
        String accessId = "LTAI0noMDsM9RYEq";
        String accessKey = "xU2GhpdOY1rQohLpG7zK4jfAd8CS2r";
        String bucket = "chouguanjia";
        String dir = "nurse/";
        String host = "http://" + bucket + "." + endpoint;
        OSSClient client = new OSSClient(endpoint, accessId, accessKey);

        Map<String, String> respMap = new LinkedHashMap<String, String>();
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMap;
    }


    @RequestMapping("/2/getSignStr")
    public Map getBrokerSign(HttpServletResponse response) {
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
        String accessId = "LTAI0noMDsM9RYEq";
        String accessKey = "xU2GhpdOY1rQohLpG7zK4jfAd8CS2r";
        String bucket = "chouguanjia";
        String dir = "broker/";
        String host = "http://" + bucket + "." + endpoint;
        OSSClient client = new OSSClient(endpoint, accessId, accessKey);

        Map<String, String> respMap = new LinkedHashMap<String, String>();
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMap;
    }


    /**
     * 修改头像
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/updaetHeaderImg/api", method = RequestMethod.POST)
    public Map updateHeaderImg(@RequestParam("imgPath") String imgPath, @RequestParam("nurseId") int nurseId, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        int flag = nurseService.updateImagePath(nurseId, imgPath);
        if (flag > 0) {
            result.put("flag", 1);
        } else {
            result.put("flag", 0);
        }
        return result;
    }


    /**
     * 修改阿姨信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurse/update/api", method = RequestMethod.POST)
    public Map nurseImgUpdate(@ModelAttribute Nurse nurse, BindingResult bindingResult, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        if (nurseService.editNurseInfo(nurse, "1") > 0) {
            result.put("flag", 1);
        } else {
            result.put("flag", 0);
        }
        return result;
    }


    /**
     * 新增阿姨信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurse/addNew/api", method = RequestMethod.POST)
    public Map nurseAdd(@SessionAttribute int brokerId, @ModelAttribute Nurse nurse, BindingResult bindingResult, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        nurse.setBrokerId(brokerId);
        if (nurseService.addNurseInfo(nurse) > 0) {
            result.put("flag", 1);
        } else {
            result.put("flag", 0);
        }
        return result;
    }

    /**
     * 是否已经存在
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/isNurseExists/api/{phoneNumber}/{idCard}", method = RequestMethod.GET)
    public Map isNurseExists(@PathVariable String idCard, @PathVariable String phoneNumber, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        if (nurseService.isNurseExistsByIdcard(idCard)) {
            result.put("idFlag", 0);
        } else {
            result.put("idFlag", 1);
        }
        if (nurseService.isNurseExists(phoneNumber)) {
            result.put("phoneFlag", 0);
        } else {
            result.put("phoneFlag", 1);
        }
        return result;
    }


    /**
     * 根据条件查询导入数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/nurseImportList/param/api", method = RequestMethod.GET)
    public Map nurseImportList(@SessionAttribute int brokerId, @ModelAttribute NurseQueryParam queryParam, BindingResult bindingResult, HttpServletRequest request
    ) {
        Date fromDate = queryParam.getFromDate();
        Date endDate = queryParam.getEndDate();
        String submitFlag = queryParam.getFlag();

        Map result = nurseService.selectNurseImportInfos(fromDate, endDate, submitFlag, brokerId, queryParam.getCurrentPage());


        return result;
    }


    /**
     * 删除导入的阿姨信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurseImport/delete/api", method = RequestMethod.POST)
    public Map deleteImportNurse(HttpServletRequest request, String ids) {
        Map map = new HashMap<>();
        int flag = 0;
        if (ids.indexOf(",") < 0) {
            flag = nurseService.deleteImportNurseById(Integer.parseInt(ids));
        } else {
            flag = nurseService.deleteImportNurseByIds(ids);
        }
        map.put("flag", flag);
        return map;
    }


    /**
     * 阿姨列表查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/shList/param/api", method = RequestMethod.GET)
    public Map shList(@SessionAttribute int brokerId, @ModelAttribute NurseQueryParam queryParam, BindingResult bindingResult, HttpServletRequest request
    ) {
        PageList<Map> nurses = nurseService.selectShList(queryParam.getCurrentPage(), brokerId, queryParam.getStatus());
        int currpage = nurses.getPaginator().getPage();
        int total = nurses.getPaginator().getTotalPages();
        Map result = new HashMap<>();
        for (Map obj : nurses) {
            int nurseId = (int) obj.get("id");
            List<String> pics = nurseService.selectShPicsList(brokerId, nurseId, queryParam.getStatus());
            obj.put("pics", pics);
        }
        result.put("results", nurses);
        result.put("total", total);
        result.put("currpage", currpage);
        result.put("status", queryParam.getStatus());
        return result;
    }


    /**
     * 照片审核
     *
     * @param type
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("op/shPic/{type}/api")
    public Map doPicture(@PathVariable String type, String ids, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map result = new HashMap<>();
        nurseService.updateImgStatus(Integer.parseInt(ids), type);
        result.put("msg", "1");
        return result;
    }


    /**
     * 阿姨列表查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/updateBrokerInfo/api", method = RequestMethod.POST)
    public Map updateBrokerInfo(@SessionAttribute int brokerId, @ModelAttribute Broker broker, BindingResult bindingResult, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        broker.setId(brokerId);
        brokerService.updateInfo(broker);
        result.put("flag", "1");
        return result;
    }


    /**
     * 检查密码是否正确并修改密码
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/resetPwd/api", method = RequestMethod.POST)
    public Map checkPwd(@SessionAttribute int brokerId, HttpServletRequest request, @RequestParam("pwd") String pwd, @RequestParam("newPwd") String newPwd
    ) {
        Map result = new HashMap<>();
        if (brokerService.isPwdOk(brokerId, pwd)) {
            if (brokerService.updatePwdByBrokerId(brokerId, newPwd) > 0) {
                BROKER_LOG.info("broker" + brokerId + "change pwd");
                result.put("flag", 1);
            } else {
                result.put("flag", 0);
            }
        } else {
            result.put("flag", 2);
        }
        return result;
    }


    /**
     * 选择上传导入的阿姨信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurseImportSubmit/select/api", method = RequestMethod.POST)
    public Map submitImportBySelect(@SessionAttribute int brokerId, HttpServletRequest request, @RequestParam("ids") String ids
    ) {
        Map result = new HashMap<>();
        brokerService.submitImportBySelect(ids);
        result.put("flag", "1");
        return result;
    }


    /**
     * 全部上传导入的阿姨信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurseImportSubmit/all/api", method = RequestMethod.POST)
    public Map submitImportByAll(@SessionAttribute int brokerId, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        brokerService.submitImportByAll(brokerId);
        result.put("flag", "1");
        return result;
    }


    /**
     * 平台结算中心
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/jsInfo/param/api", method = RequestMethod.GET)
    public Map jsCenter(@ModelAttribute NurseQueryParam queryParam, BindingResult bindingResult, @SessionAttribute int brokerId, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        Date fromDate = queryParam.getFromDate();
        Date toDate = queryParam.getEndDate();
        String nurseName = queryParam.getParamStr();

        Map zjMap = orderService.selectJsInfo(brokerId, fromDate, toDate, nurseName);
        Map detail = orderService.selectJsDetailInfo(brokerId, fromDate, toDate, queryParam.getCurrentPage(), nurseName);


        result.put("zje", zjMap.get("zje"));
        result.put("pdsr", zjMap.get("pdsr"));
        result.put("aygz", zjMap.get("aygz"));
        result.put("ysje", zjMap.get("ysje"));

        result.put("results", detail.get("results"));
        result.put("total", detail.get("total"));
        result.put("currpage", detail.get("currpage"));

        return result;
    }


    /**
     * 平台结算中心
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/jsInfoPage/param/api", method = RequestMethod.GET)
    public Map jsInfoPage(@ModelAttribute NurseQueryParam queryParam, BindingResult bindingResult, @SessionAttribute int brokerId, HttpServletRequest request
    ) {
        Date fromDate = queryParam.getFromDate();
        Date toDate = queryParam.getEndDate();
        String nurseName = queryParam.getParamStr();

        Map detail = orderService.selectJsDetailInfo(brokerId, fromDate, toDate, queryParam.getCurrentPage(), nurseName);
        return detail;
    }


    /**
     * 修改阿姨导入信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/nurseImport/update/api", method = RequestMethod.POST)
    public Map nurseImportUpdate(@ModelAttribute NurseImport nurseImport, BindingResult bindingResult, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        if (nurseService.updateImport(nurseImport) > 0) {
            result.put("flag", 1);
        } else {
            result.put("flag", 0);
        }
        return result;
    }

}