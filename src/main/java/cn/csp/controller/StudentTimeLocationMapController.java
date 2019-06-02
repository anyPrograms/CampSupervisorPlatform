package cn.csp.controller;

import cn.csp.entity.Elective;
import cn.csp.entity.Student;
import cn.csp.entity.StudentTimeLocationMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.csp.service.ElectiveService;
import cn.csp.service.StuTimeLocMapService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan
 * @description:
 */

@Controller
@RequestMapping("/con/studentTimeLocationMap/")
public class StudentTimeLocationMapController {

    @Autowired
    private StuTimeLocMapService stuTimeLocMapService;

    @RequestMapping(value = "generate", method = RequestMethod.POST)
    public @ResponseBody Object genarateMap(Model model, HttpServletRequest request
    		) throws Exception {
    	String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true); 
        try {
        	stuTimeLocMapService.generateMap();
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.put("reason", "系统错误"+e.getMessage());
            responseMessage.put("success", false);
        }
        return responseMessage;
    }
    
    @RequestMapping(value = "cleanByDate/{date}", method = RequestMethod.POST)
    public @ResponseBody Object cleanMapByDate(Model model, HttpServletRequest request,
    		 @PathVariable String date
    		) throws Exception {
    	String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true); 
        try {
        	stuTimeLocMapService.cleanMapByDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.put("reason", "系统错误"+e.getMessage());
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "findByLocation", method = RequestMethod.GET)
    public @ResponseBody
    List<StudentTimeLocationMap> findMapByLocation(Model model,HttpServletRequest request,
    		@RequestParam(value = "locationId", defaultValue = "") final String locationId,
    		@RequestParam(value = "date", defaultValue = "") final String date
    		) throws Exception {
        if (locationId != null) {
            return stuTimeLocMapService.findMapByLocation(locationId,date);
        } else {
            return null;
        }
    }
    
    @RequestMapping(value = "show/{date}", method = RequestMethod.GET)
    public @ResponseBody
    List<StudentTimeLocationMap> showMap(Model model,HttpServletRequest request,
    		 @PathVariable String date
    		) throws Exception {
        if (date != null) {
            return stuTimeLocMapService.showMap(date);
        } else {
            return null;
        }
    }
    
    @RequestMapping(value = "findByFilters", method = RequestMethod.GET)
    public @ResponseBody List<StudentTimeLocationMap> findMapByFilters(Model model,HttpServletRequest request,
                    @RequestParam(value = "studentName", defaultValue = "") final String studentName,
                    @RequestParam(value = "studentBunk", defaultValue = "") final String studentBunk,
                    @RequestParam(value = "period", defaultValue = "") final String period,
                    @RequestParam(value = "date", defaultValue = "") final String date
    ) {
        List<StudentTimeLocationMap> stlMaps = stuTimeLocMapService.findStudentMapByFilters(studentName, studentBunk, period, date);
        return stlMaps;
    }
}
