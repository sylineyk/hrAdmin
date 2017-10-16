package com.hong.admin.web.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yk
 * @version 1.0.0
 */
@Controller
@RequestMapping("/broker")
public class GeneralController {
    private static final Logger CUSTOMER_LOG = LoggerFactory.getLogger("BrokerLog");


    @RequestMapping("/view/toGetPwd")
    public String toGetPwd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "/broker/getPwd";
    }


}
