package cn.csp.controller;

import cn.csp.entity.ElectiveSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.csp.service.ElectiveScheduleService;

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
@RequestMapping("/con/electiveSchedule/")
public class ElectiveScheduleController {

    @Autowired
    private ElectiveScheduleService electiveScheduleService;

    @RequestMapping(value = "findbyId/{electiveScheduleId}", method = RequestMethod.GET)
    public @ResponseBody
    ElectiveSchedule findElectiveScheduleById(Model model, HttpServletRequest request, @PathVariable String electiveScheduleId) throws Exception {
        if (electiveScheduleId != null) {
            return electiveScheduleService.findElectiveScheduleById(electiveScheduleId);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody
    List<ElectiveSchedule> findAllElectiveSchedules(Model model, HttpServletRequest request) throws Exception {
        return electiveScheduleService.findAllElectiveSchedules();
    }

    @RequestMapping(value = "totalNum", method = RequestMethod.GET)
    public @ResponseBody
    int totalNumberOfElectiveSchedules(Model model, HttpServletRequest request) throws Exception {
        return electiveScheduleService.totalNumberOfElectiveSchedules();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody
    Object addElectiveSchedule(Model model, HttpServletRequest request,
    		@RequestParam(value = "electiveId", defaultValue = "") final String electiveId,
    		@RequestParam(value = "period", defaultValue = "") final String period,
    		@RequestParam(value = "ageGroup", defaultValue = "") final String ageGroup,
    		@RequestParam(value = "date", defaultValue = "") final String date,
    		@RequestParam(value = "scheduleVol", defaultValue = "") final String scheduleVol,
    		@RequestParam(value = "locationId", defaultValue = "") final String locationId
    		) throws Exception {
        String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            ElectiveSchedule scheduleRe = electiveScheduleService.addElectiveSchedule(electiveId, period,ageGroup,date,scheduleVol,locationId);
            responseMessage.put("schedule", scheduleRe);
        } catch (Exception e) {
            e.printStackTrace();
            responseBody = "添加失败! " + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "deleteByName/{electiveScheduleId}", method = RequestMethod.GET)
    public @ResponseBody
    Object deleteElectiveSchedule(Model model, HttpServletRequest request, @PathVariable String electiveScheduleId) throws Exception {
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            electiveScheduleService.deleteElectiveScheduleById(electiveScheduleId);
        } catch (Exception e) {
            e.printStackTrace();
            String responseBody = "操作失败！" + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }
}
