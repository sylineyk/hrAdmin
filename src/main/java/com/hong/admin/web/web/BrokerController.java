package com.hong.admin.web.web;

import com.hong.admin.security.domain.UserInfo;
import com.hong.admin.service.broker.BorkerService;
import com.hong.admin.service.nurse.NurseService;
import com.hong.admin.util.GeneralUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @version 1.0.0
 */
@Controller
@RequestMapping("/broker")
public class BrokerController {
    private static final Logger CUSTOMER_LOG = LoggerFactory.getLogger("BrokerLog");

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


    @RequestMapping("/view/nurseDetail/{nurseId}")
    public String toNurseAdd(@PathVariable int nurseId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map result = nurseService.selectNurseDetailInfoById(nurseId);
        model.put("result", result);
        return "/broker/nurseDetail";
    }

    @RequestMapping("/view/nurseEdit/{nurseId}")
    public String toNurseEdit(@PathVariable int nurseId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map result = nurseService.selectNurseDetailInfoById(nurseId);
        model.put("result", result);
        return "/broker/nurseEdit";
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
        return "/broker/zpsh";
    }


    @RequestMapping("/view/toBrokerInfo")
    public String toBrokerinfo(@SessionAttribute int brokerId, ModelMap model) {
        Map map = brokerService.getBrokerInfo(brokerId);
        model.put("flag", "nurseManage");
        model.put("info", map);
        return "/broker/account";
    }

    @RequestMapping("/view/toBrokerEdit")
    public String toBrokerEdit(@SessionAttribute int brokerId, ModelMap model) {
        Map map = brokerService.getBrokerInfo(brokerId);
        model.put("flag", "nurseManage");
        model.put("info", map);
        return "/broker/accountEdit";
    }


    @RequestMapping("/op/importExcel")
    public String importExcel(RedirectAttributes redModel, @SessionAttribute int brokerId, @RequestParam(value = "filename") MultipartFile file, ModelMap model) {
        model.put("flag", "import");

        String msg = "";
        //判断文件是否为空
        if (file == null) {
            msg = "文件不能为空！";
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)) {
            msg = "文件不能为空！";
        } else if (!GeneralUtil.validateExcel(fileName)) {
            msg = "文件必须是excel格式！";
        } else {
            //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
            long size = file.getSize();
            if (size == 0) {
                msg = "文件内容不能为空！";
            }
        }

        if (StringUtils.isEmpty(msg)) {
            //批量导入
            String message = brokerService.batchImport(fileName, file, brokerId);
            redModel.addFlashAttribute("msg", message);
        } else {
            redModel.addFlashAttribute("msg", msg);
        }
        return "redirect:/broker/view/toNurseImport";
    }


    @RequestMapping("/view/importDetail/{id}")
    public String toImportDetail(@PathVariable int id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map result = nurseService.selectImportDetailInfoById(id);
        model.put("result", result);
        return "/broker/importDetail";
    }

    @RequestMapping("/view/importEdit/{id}")
    public String toImportEdit(@PathVariable int id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map result = nurseService.selectImportDetailInfoById(id);
        model.put("result", result);
        return "/broker/importEdit";
    }


    @RequestMapping("/view/shDetail/{nurseId}/{status}")
    public String toShDetail(@PathVariable int nurseId, @PathVariable String status, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String name = nurseService.getNurseById(nurseId).getName();
        List<String> cardInfos = nurseService.getPicturePathListByNurseIdAndType(nurseId, "1", status);
        List<String> pictureInfos = nurseService.getPicturePathListByNurseIdAndType(nurseId, "2", status);

        model.put("picName", name);
        model.put("nurseId", nurseId);
        model.put("cardInfos", cardInfos);
        model.put("pictureInfos", pictureInfos);
        model.put("status", status);

        return "/broker/picShDetail";
    }


    @RequestMapping("/view/changePwd")
    public String toChangePwd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "/broker/changePwd";
    }


    @RequestMapping("/view/toJs")
    public String toJs(ModelMap model) {
        model.put("flag", "js");
        return "/broker/js";
    }


    @RequestMapping(value = "/get/excelTemplae")
    public Resource getTxt(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return new FileSystemResource("/template.xlsx");
    }


    @RequestMapping("/download")
    public void download(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        request.setCharacterEncoding("UTF-8");
        String rootpath = request.getSession().getServletContext().getRealPath(
                "/resources/static/assets");
        String fileName = "template.xlsx";

        try {
            File f = new File(rootpath + "/" + fileName);  //将服务器上的文件下载下来
            response.setContentType("application/x-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Content-Length", String.valueOf(f.length()));
            in = new BufferedInputStream(new FileInputStream(f));
            out = new BufferedOutputStream(response.getOutputStream());
            byte[] data = new byte[1024];
            int len = 0;
            while (-1 != (len = in.read(data, 0, data.length))) {
                out.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
