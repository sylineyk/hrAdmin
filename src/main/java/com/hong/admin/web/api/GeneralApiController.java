package com.hong.admin.web.api;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hong.admin.service.broker.BorkerService;
import com.hong.admin.util.Constant;
import com.hong.admin.util.GeneralUtil;
import com.hong.admin.util.SmsUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yk
 * @version 1.0.0
 */
@RestController
@RequestMapping("/broker")
public class GeneralApiController {
    private static final Logger BROKER_LOG = LoggerFactory.getLogger("BrokerLog");


    @Autowired
    private BorkerService brokerService;


    @RequestMapping(value = "/sendSms")
    public Map sendSMS(@RequestParam("phone") String phone, HttpServletRequest request) {
        Map map = new HashMap<>();
        String code = "";
        long time = System.currentTimeMillis();
        HttpSession session = request.getSession();
        int flag = 0;
        String oldPhone = (String) session.getAttribute(Constant.HttpKey.VALIDATE_PHONE);
        //第一次申请验证码
        if (StringUtils.isEmpty(oldPhone)) {
            code = GeneralUtil.getVerifyCode();
            //发短信
            SendSmsResponse response = null;
            try {
                response = SmsUtil.sendSms(phone, code);
                System.out.println("短信接口返回的数据----------------");
                System.out.println("Code=" + response.getCode());
            } catch (ClientException e) {
                e.printStackTrace();
            }
            if (response != null && response.getCode().equals("OK")) {
                session.setAttribute(Constant.HttpKey.VALIDATE_PHONE, phone);
                session.setAttribute(Constant.HttpKey.CLICK_TIME, System.currentTimeMillis());
                session.setAttribute(Constant.HttpKey.VALIDATE_PHONE_CODE, code.toString());
                session.setAttribute(Constant.HttpKey.SEND_CODE_TIME, time);
                flag = 0;
            } else {
                flag = 2;
            }
        } else {
            long oldTime = (long) session.getAttribute(Constant.HttpKey.CLICK_TIME);
            long nowTime = System.currentTimeMillis();

            System.out.println(nowTime - oldTime);
            if (nowTime - oldTime < 120000) {
                flag = 1;
            } else {
                code = GeneralUtil.getVerifyCode();
                //发短信
                SendSmsResponse response = null;
                try {
                    response = SmsUtil.sendSms(phone, code);
                } catch (ClientException e) {
                    e.printStackTrace();
                }
                if (response != null && response.getCode().equals("OK")) {
                    session.setAttribute(Constant.HttpKey.CLICK_TIME, System.currentTimeMillis());
                    session.setAttribute(Constant.HttpKey.VALIDATE_PHONE_CODE, code.toString());
                    session.setAttribute(Constant.HttpKey.SEND_CODE_TIME, time);
                    //发送验证码
                    //        SmsUtil.send(phone, smsText);
                    flag = 0;
                } else {
                    flag = 2;
                }
            }
        }
        String smsText = "您的验证码是:" + code;
        System.out.println("smsText--" + smsText);
        map.put("errorCode", flag);
        return map;
    }


    @RequestMapping("/findPwd")
    protected Map validate(HttpServletRequest request, @RequestParam("phone") String inputPhone, @RequestParam("code") String inputCode, @RequestParam("pwd") String pwd) {
        Map map = new HashMap<>();
        String flag = "";
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Constant.HttpKey.VALIDATE_PHONE_CODE);
        if (code == null) {
            flag = "errorCode";//验证码失效
        } else {
            String phone = (String) session.getAttribute(Constant.HttpKey.VALIDATE_PHONE);
            long oldTime = (long) session.getAttribute(Constant.HttpKey.SEND_CODE_TIME);
            long nowTime = System.currentTimeMillis();
            if (nowTime - oldTime > 1800000) {
                flag = "errorCode";//验证码失效
                session.removeAttribute("VALIDATE_PHONE");
                session.removeAttribute("CLICK_TIME");
            } else {
                if (phone.equals(inputPhone) && code.equalsIgnoreCase(inputCode)) {
                    brokerService.updatePwd(phone, pwd);
                    flag = "success";
                } else {
                    flag = "other";//手机号或者验证码不对，请核对后再输入
                }
            }
        }
        map.put("flag", flag);
        return map;
    }


}