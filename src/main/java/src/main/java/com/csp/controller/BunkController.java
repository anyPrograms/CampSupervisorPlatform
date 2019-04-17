package src.main.java.com.csp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import src.main.java.com.csp.dto.Result;
import src.main.java.com.csp.entity.Bunk;
import src.main.java.com.csp.service.BunkService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/con/bunk/") 
public class BunkController {


	@Autowired
	private BunkService bunkService;


	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<Bunk> findAllBunks(Model model,
			HttpServletRequest request) throws Exception {
		return bunkService.findAllBunks();
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody Object addBunk(Model model,HttpServletRequest request,
			@RequestParam (value = "bunkName", defaultValue = "") final String bunkName
			) throws Exception {
		String responseBody = "";
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try{
			Bunk bkRe =bunkService.addBunk(bunkName);
			responseMessage.put("bunk", bkRe);
		}catch(Exception e) {
			e.printStackTrace();
			responseBody = "添加失败! "+e.getMessage();
			responseMessage.put("msg",responseBody);
			responseMessage.put("success", false);
		}		
		return responseMessage;
	}

	@RequestMapping(value = "deleteById/{bunkId}", method = RequestMethod.POST)
	public Object deleteBunkById(Model model,
			HttpServletRequest request,@PathVariable String bunkId) throws Exception {
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try {
			bunkService.deleteBunkById(bunkId);
		} catch (Exception e) {
			e.printStackTrace();
			String responseBody = "操作失败！"+e.getMessage();
			responseMessage.put("msg", responseBody);
			responseMessage.put("success", false);
		}
		return responseMessage;
	}
}
