package src.main.java.com.csp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import src.main.java.com.csp.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/con/student/") 
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService studentService;


	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<Student> findAllStudents(Model model,
			HttpServletRequest request) throws Exception {
		return studentService.findAllStudents();
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody Object addStudent(Model model,HttpServletRequest request,
			@RequestParam (value = "studentName", defaultValue = "") final String studentName,
			@RequestParam (value = "studentGender", defaultValue = "") final String studentGender,
			@RequestParam (value = "studentYear", defaultValue = "") final String studentYear,
			@RequestParam (value = "studentStatus", defaultValue = "") final String studentStatus,
			@RequestParam (value = "studentAge", defaultValue = "") final String studentAge
			) throws Exception {
		String responseBody = "";
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try{
			Student stuRe =studentService.addStudent(studentName, studentGender, studentYear, studentStatus, studentAge);
			responseMessage.put("stu", stuRe);
		}catch(Exception e) {
			e.printStackTrace();
			responseBody = "添加失败! "+e.getMessage();
			responseMessage.put("msg",responseBody);
			responseMessage.put("success", false);
		}		
		return responseMessage;
	}

	@RequestMapping(value = "deleteById/{studentId}", method = RequestMethod.POST)
	public Object deleteById(Model model,
			HttpServletRequest request,@PathVariable String studentId) throws Exception {
		Map responseMessage = new HashMap();
		responseMessage.put("success", true);
		try {
			studentService.deleteStudentById(studentId);
		} catch (Exception e) {
			e.printStackTrace();
			String responseBody = "操作失败！"+e.getMessage();
			responseMessage.put("msg", responseBody);
			responseMessage.put("success", false);
		}
		return responseMessage;
	}
}
