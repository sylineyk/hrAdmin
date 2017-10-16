package com.hong.admin.security.controller;

import com.hong.admin.service.broker.BorkerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

/**
 * Created by yk
 */
@Controller
@SessionAttributes({"brokerId", "name"})
public class HomeController {
    @Autowired
    private BorkerService brokerService;

    @RequestMapping("/index")
    public String index(ModelMap model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> grantedAuthorities = auth.getAuthorities();
        String path = "";
        String name = "";
        for (GrantedAuthority ob : grantedAuthorities) {
            String authName = ob.getAuthority();
            if (!StringUtils.isEmpty(authName)) {
                if (authName.equals("ROLE_ADMIN")) {
                    path = "/admin/index";
                    name = auth.getName();
                } else if (authName.equals("ROLE_NORMAL")) {
                    Map map = brokerService.getIdByPhone(auth.getName());
                    int id = (int) map.get("id");
                    name = String.valueOf(map.get("name"));
                    model.put("brokerId", id);
                    path = "/normal/index";
                }
            }
        }
        model.put("name", name);
        model.put("flag", "index");
        return path;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        return "login";
    }


}
