package cn.csp.controller;

import cn.csp.entity.Elective;
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

}
