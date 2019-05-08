package cn.csp.controller;

import cn.csp.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.csp.service.LocationService;

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
@RequestMapping("/con/location/")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody
    List<Location> findAllLocations(Model model, HttpServletRequest request) throws Exception {
        return locationService.findAllLocations();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody
    Object addLocation(Model model, HttpServletRequest request,
    		@RequestParam(value = "locationName", defaultValue = "") final String locationName) throws Exception {
        String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            Location locRe = locationService.addLocation(locationName);
            responseMessage.put("loc", locRe);
        } catch (Exception e) {
            e.printStackTrace();
            responseBody = "添加失败! " + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody
    Object updateLocation(Model model, HttpServletRequest request,
    		@RequestParam(value = "locationId", defaultValue = "") final String locationId,
    		@RequestParam(value = "locationName", defaultValue = "") final String locationName) throws Exception {
        String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
        	Location locRe = locationService.updateLocation(locationId,locationName);
            responseMessage.put("loc", locRe);
        } catch (Exception e) {
            e.printStackTrace();
            responseBody = "添加失败! " + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "deleteByName/{locationName}", method = RequestMethod.GET)
    public @ResponseBody
    Object deleteLocation(Model model, HttpServletRequest request, @PathVariable String locationName) throws Exception {
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            locationService.deleteLocationByName(locationName);
        } catch (Exception e) {
            e.printStackTrace();
            String responseBody = "操作失败！" + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }
}
