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
import src.main.java.com.csp.entity.Student;
import src.main.java.com.csp.enums.StudentStateEnum;
import src.main.java.com.csp.service.StudentBunkMapService;
import src.main.java.com.csp.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/con/studentBunkMap/") 
public class StudentBunkMapController {


	@Autowired
	private StudentBunkMapService stuBkMapService;


	@RequestMapping(value = "findStudentsByBunk/{bunkId}", method = RequestMethod.GET)
	public @ResponseBody List<Student> findStudentsByBunk(Model model,
			HttpServletRequest request,@PathVariable String bunkId) throws Exception {
		if(bunkId!=null) {
			return stuBkMapService.findStudentsByBunkId(bunkId);
		}else {
			return null;
		}
		
	}

	@RequestMapping(value = "addStudentToBunk", method = RequestMethod.POST)
	public @ResponseBody Object addStudentToBunk(Model model,HttpServletRequest request,
			@RequestParam (value = "studentId", defaultValue = "") final String studentId,
			@RequestParam (value = "bunkId", defaultValue = "") final String bunkId
			) throws Exception {
		String responseBody = "";
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try{
			String stuRe =stuBkMapService.addStudentToBunk(studentId, bunkId);
			responseMessage.put("msg", stuRe);
		}catch(Exception e) {
			e.printStackTrace();
			responseMessage.put("success", false);
		}		
		return responseMessage;
	}

	@RequestMapping(value = "deleteStudent/{studentId}", method = RequestMethod.POST)
	public Object deleteStudent(Model model,
			HttpServletRequest request,@PathVariable String studentId) throws Exception {
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try {
			String bk=stuBkMapService.deleteStudentFromBunk(studentId);
			responseMessage.put("msg", bk);
		} catch (Exception e) {
			e.printStackTrace();
			String responseBody = "操作失败！"+e.getMessage();
			responseMessage.put("msg", responseBody);
			responseMessage.put("success", false);
		}
		return responseMessage;
	}
	
	@RequestMapping(value = "deleteStudentsByBunk/{bunkId}", method = RequestMethod.POST)
	public Object deleteStudentsByBunk(Model model,
			HttpServletRequest request,@PathVariable String bunkId) throws Exception {
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try {
			stuBkMapService.deleteAllStudentsByBunk(bunkId);
		} catch (Exception e) {
			e.printStackTrace();
			String responseBody = "操作失败！"+e.getMessage();
			responseMessage.put("msg", responseBody);
			responseMessage.put("success", false);
		}
		return responseMessage;
	}
}
