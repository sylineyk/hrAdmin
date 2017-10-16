package com.hong.admin.web.web;

import com.hong.admin.dao.entity.admin.SysUser;
import com.hong.admin.security.domain.UserInfo;
import com.hong.admin.service.admin.AdminService;
import com.hong.admin.service.broker.BorkerService;
import com.hong.admin.service.nurse.NurseService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger CUSTOMER_LOG = LoggerFactory.getLogger("BrokerLog");

    @Autowired
    private NurseService nurseService;


    @Autowired
    private BorkerService brokerService;

    @Autowired
    private AdminService sysUserMapper;

    @ModelAttribute("brokerId")
    public int getBrokerId(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id = ((UserInfo) auth.getPrincipal()).getId();
        request.getSession().setAttribute("brokerId", id);
        return ((UserInfo) auth.getPrincipal()).getId();
    }


    @RequestMapping("/view/nurseDetail/{nurseId}")
    public String toNurseAdd(@PathVariable int nurseId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map result = nurseService.selectNurseDetailInfoById(nurseId);
        model.put("result", result);
        return "/admin/nurseDetail";
    }


    @RequestMapping("/view/toNurseList")
    public String toNurseList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        model.put("flag", "nurseList");
        return "/admin/nurseList";
    }

    @RequestMapping("/view/toCustomerList")
    public String toCustomerList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        model.put("flag", "cusList");
        return "/admin/customerList";
    }


    @RequestMapping("/view/toAddNurse")
    public String toAddNurse() {
        return "/broker/nurseAdd";
    }

    @RequestMapping("/view/toNurseImport")
    public String toNurseImport(ModelMap model, @ModelAttribute("msg") String msg) {
        model.put("flag", "import");
        if (msg != null) {
            model.put("msg", msg);
        } else {
            model.put("msg", "");
        }
        return "/broker/nurseImport";
    }


    @RequestMapping("/view/toZpsh")
    public String toZpsh(ModelMap model) {
        model.put("flag", "zpsh");
        return "/admin/zpsh";
    }


    @RequestMapping("/view/shDetail/{nurseId}/{status}")
    public String toShDetail(@PathVariable int nurseId, @PathVariable String status, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String name = nurseService.getNurseById(nurseId).getName();
        List<String> shInfos = nurseService.getPicturePathListByNurseIdAndType(nurseId, "3", status);

        model.put("picName", name);
        model.put("nurseId", nurseId);
        model.put("shInfos", shInfos);
        model.put("status", status);

        return "/admin/picShDetail";
    }


    @RequestMapping("/view/changePwd")
    public String toChangePwd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "/admin/changePwd";
    }


    @RequestMapping("/view/brokerDetail/{brokerId}")
    public String toBrokerDetail(@PathVariable int brokerId, ModelMap model) {
        Map map = brokerService.getBrokerInfo(brokerId);
        model.put("info", map);
        return "/admin/brokerDetail";
    }


    @RequestMapping("/view/brokerEdit/{brokerId}")
    public String toBrokerEdit(@PathVariable int brokerId, ModelMap model) {
        Map map = brokerService.getBrokerInfo(brokerId);
        model.put("info", map);
        return "/admin/brokerEdit";
    }


    @RequestMapping("/view/toAddBroker")
    public String toAddBroker() {
        return "/admin/brokerAdd";
    }

    @RequestMapping("/view/toAdminInfo")
    public String toAdminInfo(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SysUser map = sysUserMapper.selectAdminInfo(auth.getName());
        model.put("flag", "center");
        model.put("info", map);
        return "/admin/adminAccount";
    }

    @RequestMapping("/view/toAdminInfoEdit")
    public String toAdminInfoEdit(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SysUser map = sysUserMapper.selectAdminInfo(auth.getName());
        model.put("flag", "center");
        model.put("info", map);
        return "/admin/adminAccountEdit";
    }

    @RequestMapping("/view/toJs")
    public String toJs(ModelMap model, @RequestParam(value = "fromDate", required = false) String fromDate, @RequestParam(value = "endDate", required = false) String endDate) {
        model.put("flag", "jszx");
        if (!StringUtils.isEmpty(fromDate)) {
            model.put("fromDate", fromDate);
        }
        if (!StringUtils.isEmpty(endDate)) {
            model.put("endDate", endDate);
        }
        return "/admin/js";
    }

    /**
     * 平台结算明细
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/toJsPtDetail", method = RequestMethod.GET)
    public String toJsPtDetail(ModelMap model, @RequestParam("fromDate") String fromDate, @RequestParam("endDate") String endDate, HttpServletRequest request
    ) {
        model.put("fromDate", fromDate);
        model.put("endDate", endDate);
        model.put("flag", "jszx");

        return "/admin/jsPtDetail";
    }

    /**
     * 阿姨结算明细
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/toJsAyDetail", method = RequestMethod.GET)
    public String toJsAyDetail(ModelMap model, @RequestParam("fromDate") String fromDate, @RequestParam("endDate") String endDate, HttpServletRequest request
    ) {

        model.put("fromDate", fromDate);
        model.put("endDate", endDate);
        model.put("flag", "jszx");
        return "/admin/jsAyDetail";
    }

    /**
     * 经纪人结算明细
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/toJsJjrDetail", method = RequestMethod.GET)
    public String toJsJjrDetail(ModelMap model, @RequestParam("fromDate") String fromDate, @RequestParam("endDate") String endDate, HttpServletRequest request
    ) {
        model.put("fromDate", fromDate);
        model.put("endDate", endDate);
        model.put("flag", "jszx");
        return "/admin/jsJjrDetail";
    }


    /**
     * 经纪人结算明细的明细
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/jsJjrjsDetail", method = RequestMethod.GET)
    public String jsJjrjsDetail(ModelMap model, @RequestParam("phone") String phone, @RequestParam("fromDate") String fromDate, @RequestParam("endDate") String endDate, HttpServletRequest request
    ) {
        model.put("fromDate", fromDate);
        model.put("endDate", endDate);
        model.put("phone", phone);
        return "/admin/jsJjrJsDetail";
    }


    /**
     * 阿姨结算明细的明细
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/jsAyjsDetail", method = RequestMethod.GET)
    public String jsAyjsDetail(ModelMap model, @RequestParam("phone") String phone, @RequestParam("fromDate") String fromDate, @RequestParam("endDate") String endDate, HttpServletRequest request
    ) {
        model.put("fromDate", fromDate);
        model.put("endDate", endDate);
        model.put("phone", phone);
        return "/admin/jsAyJsDetail";
    }
}
