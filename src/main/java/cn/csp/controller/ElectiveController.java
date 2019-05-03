package src.main.java.com.csp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.csp.service.ElectiveService;

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

    @RequestMapping(value="",method=RequestMethod.GET)
    public @ResponseBody ? find(Model){}

}
