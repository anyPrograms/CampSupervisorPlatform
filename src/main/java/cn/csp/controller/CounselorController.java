package cn.csp.controller;

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

import cn.csp.dto.Result;
import cn.csp.entity.Counselor;
import cn.csp.service.CounselorService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/con/counselor/") 
public class CounselorController {


	@Autowired
	private CounselorService counselorService;


	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<Counselor> findAllCounselors(Model model,
			HttpServletRequest request) throws Exception {
		return counselorService.findAllCounselors();
	}
	
	@RequestMapping(value = "countUndistributed", method = RequestMethod.GET)
	public @ResponseBody int countUndistributedCounselors(Model model,
			HttpServletRequest request) throws Exception {
		return counselorService.countUndistributedCounselors();
	}
	
	@RequestMapping(value = "undistributed", method = RequestMethod.GET)
	public @ResponseBody List<Counselor> findUndistributedCounselors(Model model,
			HttpServletRequest request) throws Exception {
		return counselorService.findUndistributedCounselors();
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody Object addCounselor(Model model,HttpServletRequest request,
			@RequestParam (value = "counselorName", defaultValue = "") final String counselorName,
			@RequestParam (value = "counselorGender", defaultValue = "") final String counselorGender,
			@RequestParam (value = "counselorAgeType", defaultValue = "") final String counselorAgeType,
			@RequestParam (value = "counselorYear", defaultValue = "") final String counselorYear,
			@RequestParam (value = "counselorIntro", defaultValue = "1") final String counselorIntro
			) throws Exception {
		String responseBody = "";
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try{
			Counselor stuRe =counselorService.addCounselor(counselorName, counselorGender,counselorYear, counselorAgeType, counselorIntro);
			responseMessage.put("stu", stuRe);
		}catch(Exception e) {
			e.printStackTrace();
			responseBody = "添加失败! "+e.getMessage();
			responseMessage.put("msg",responseBody);
			responseMessage.put("success", false);
		}		
		return responseMessage;
	}

	@RequestMapping(value = "deleteById/{counselorId}", method = RequestMethod.POST)
	public Object deleteById(Model model,
			HttpServletRequest request,@PathVariable String counselorId) throws Exception {
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try {
			counselorService.deleteCounselorById(counselorId);
		} catch (Exception e) {
			e.printStackTrace();
			String responseBody = "操作失败！"+e.getMessage();
			responseMessage.put("msg", responseBody);
			responseMessage.put("success", false);
		}
		return responseMessage;
	}
}
