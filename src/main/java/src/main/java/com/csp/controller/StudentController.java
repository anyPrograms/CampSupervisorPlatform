package src.main.java.com.csp.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import src.main.java.com.csp.dto.Result;
import src.main.java.com.csp.entity.Student;
import src.main.java.com.csp.enums.StudentStateEnum;
import src.main.java.com.csp.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/book") 
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService bookService;





}
