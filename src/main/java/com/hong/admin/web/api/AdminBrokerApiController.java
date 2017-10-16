package com.hong.admin.web.api;

import com.hong.admin.dao.entity.broker.Broker;
import com.hong.admin.security.domain.UserInfo;
import com.hong.admin.service.broker.BorkerService;
import com.hong.admin.service.nurse.NurseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yk
 * @version 1.0.0
 */
@RestController
@RequestMapping("/admin")
public class AdminBrokerApiController {
    private static final Logger BROKER_LOG = LoggerFactory.getLogger("BrokerLog");

    @Autowired
    private NurseService nurseService;


    @Autowired
    private BorkerService brokerService;


    @ModelAttribute("brokerId")
    public int getBrokerId(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id = ((UserInfo) auth.getPrincipal()).getId();
        request.getSession().setAttribute("brokerId", id);
        return ((UserInfo) auth.getPrincipal()).getId();
    }

    /**
     * 经纪人列表查询根据条件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/view/brokerList/param/api", method = RequestMethod.GET)
    public Map nurseListByParam(@RequestParam(required = false) String searchInfo, @RequestParam int currentPage, HttpServletRequest request
    ) {
        if (searchInfo != null) {
            searchInfo = "%" + searchInfo + "%";
        }
        Map result = brokerService.selectBrokerInfos(searchInfo, currentPage);
        return result;
    }


    /**
     * 删除经纪人
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/brokerDelete/param/api", method = RequestMethod.POST)
    public Map deleteBroker(HttpServletRequest request, String ids) {
        Map map = new HashMap<>();
        int flag = 0;
        if (ids.indexOf(",") < 0) {
            flag = brokerService.deleteBrokerById(Integer.parseInt(ids));
        } else {
            flag = brokerService.deleteBrokderByIds(ids);
        }
        map.put("flag", flag);
        return map;
    }


    /**
     * 修改经纪人信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/updateBrokerInfo/api", method = RequestMethod.POST)
    public Map updateBrokerInfo(@ModelAttribute Broker broker, BindingResult bindingResult, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        brokerService.updateInfo(broker);
        result.put("flag", "1");
        return result;
    }


    /**
     * 新增经纪人信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/op/addBrokerInfo/api", method = RequestMethod.POST)
    public Map addBrokerInfo(@ModelAttribute Broker broker, BindingResult bindingResult, HttpServletRequest request
    ) {
        Map result = new HashMap<>();
        brokerService.addInfo(broker);
        result.put("flag", "1");
        return result;
    }

}