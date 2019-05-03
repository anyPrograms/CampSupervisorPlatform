package cn.csp.controller;

import cn.csp.entity.Elective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.csp.service.ElectiveService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shichao Qiao
 * @description:
 * @created 2019/5/3 15:53
 */

@Controller
@RequestMapping("/con/elective/")
public class ElectiveController {

    @Autowired
    private ElectiveService electiveService;

    @RequestMapping(value = "findbyId/{electiveId}", method = RequestMethod.GET)
    public @ResponseBody
    Elective findElectiveById(Model model, HttpServletRequest request, @PathVariable String electiveId) throws Exception {
        if (electiveId != null) {
            return electiveService.findElectiveById(electiveId);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "findbyName/{electiveName}", method = RequestMethod.GET)
    public @ResponseBody
    Elective findElectiveName(Model model, HttpServletRequest request, @PathVariable String electiveName) throws Exception {
        if (electiveName != null) {
            return electiveService.findElectiveByName(electiveName);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody
    List<Elective> findAllElectives(Model model, HttpServletRequest request) throws Exception {
        return electiveService.findAllElectives();
    }

    @RequestMapping(value = "totalNum", method = RequestMethod.GET)
    public @ResponseBody
    int totalNumberOfElectives(Model model, HttpServletRequest request) throws Exception {
        return electiveService.totalNumberOfElectives();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody
    Object addElective(Model model, HttpServletRequest request, @RequestParam(value = "electiveName", defaultValue = "") final String electiveName, @RequestParam(value = "electiveVol", defaultValue = "") final String electiveVol) throws Exception {
        String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            Elective elecRe = electiveService.addElective(electiveName, electiveVol);
            responseMessage.put("elec", elecRe);
        } catch (Exception e) {
            e.printStackTrace();
            responseBody = "添加失败! " + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "deleteByName/{electiveName}", method = RequestMethod.GET)
    public @ResponseBody
    Object deleteElective(Model model, HttpServletRequest request, @PathVariable String electiveName) throws Exception {
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            electiveService.deleteElectiveByName(electiveName);
        } catch (Exception e) {
            e.printStackTrace();
            String responseBody = "操作失败！" + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }
}
