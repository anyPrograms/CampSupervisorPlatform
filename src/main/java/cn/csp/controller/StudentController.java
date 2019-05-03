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
import cn.csp.entity.Student;
import cn.csp.enums.StudentStateEnum;
import cn.csp.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/con/student/")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "findStudentsByBunk/{bunkId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Student> findStudentsByBunk(Model model,
                                     HttpServletRequest request, @PathVariable String bunkId) throws Exception {
        if (bunkId != null) {
            return studentService.findStudentsByBunkId(bunkId);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "findById/{studentId}", method = RequestMethod.GET)
    public @ResponseBody
    Student findStudentById(Model model,
                            HttpServletRequest request, @PathVariable String studentId) throws Exception {
        if (studentId != null) {
            return studentService.findStudentById(studentId);
        } else {
            return null;
        }

    }

    @RequestMapping(value = "addStudentToBunk", method = RequestMethod.POST)
    public @ResponseBody
    Object addStudentToBunk(Model model, HttpServletRequest request,
                            @RequestParam(value = "studentId", defaultValue = "") final String studentId,
                            @RequestParam(value = "bunkId", defaultValue = "") final String bunkId
    ) throws Exception {
        String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            studentService.addStudentToBunk(bunkId, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "deleteStudent/{studentId}", method = RequestMethod.POST)
    public Object deleteStudent(Model model,
                                HttpServletRequest request, @PathVariable String studentId) throws Exception {
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            studentService.deleteStudentFromBunk(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            String responseBody = "操作失败！" + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "deleteStudentsByBunk/{bunkId}", method = RequestMethod.POST)
    public Object deleteStudentsByBunk(Model model,
                                       HttpServletRequest request, @PathVariable String bunkId) throws Exception {
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            studentService.deleteStudentsByBunk(bunkId);
        } catch (Exception e) {
            e.printStackTrace();
            String responseBody = "操作失败！" + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody
    List<Student> findAllStudents(Model model,
                                  HttpServletRequest request) throws Exception {
        return studentService.findAllStudents();
    }

    @RequestMapping(value = "findByFilters", method = RequestMethod.GET)
    public List<Student> findStudentsByFilters(Model model, HttpServletRequest request,
                                               @RequestParam(value = "name", defaultValue = "") final String name,
                                               @RequestParam(value = "bunk", defaultValue = "") final String bunk,
                                               @RequestParam(value = "status", defaultValue = "") final String status
    ) {
        List<Student> students = studentService.findStudentsByFilters(name, bunk, status);
        return students;
    }

    @RequestMapping(value = "countUndistributed", method = RequestMethod.GET)
    public @ResponseBody
    int countUndistributedStudents(Model model,
                                   HttpServletRequest request) throws Exception {
        return studentService.countUndistributedStudents();
    }

    @RequestMapping(value = "undistributed", method = RequestMethod.GET)
    public @ResponseBody
    List<Student> findUndistributedStudents(Model model,
                                            HttpServletRequest request) throws Exception {
        return studentService.findUndistributedStudents();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody
    Object addStudent(Model model, HttpServletRequest request,
                      @RequestParam(value = "studentName", defaultValue = "")final String studentName,
                      @RequestParam(value = "studentGender", defaultValue = "") final String studentGender,
                      @RequestParam(value = "studentGrade", defaultValue = "") final String studentGrade,
                      @RequestParam(value = "studentYear", defaultValue = "") final String studentYear,
                      @RequestParam(value = "studentStatus", defaultValue = "1") final String studentStatus,
                      @RequestParam(value = "studentAge", defaultValue = "") final String studentAge
    ) throws Exception {
        String responseBody = "";
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            Student stuRe = studentService.addStudent(studentName, studentGender, studentGrade, studentYear, studentStatus, studentAge);
            responseMessage.put("stu", stuRe);
        } catch (Exception e) {
            e.printStackTrace();
            responseBody = "添加失败! " + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }

    @RequestMapping(value = "deleteById/{studentId}", method = RequestMethod.POST)
    public Object deleteById(Model model,
                             HttpServletRequest request, @PathVariable String studentId) throws Exception {
        Map responseMessage = new HashMap();
        responseMessage.put("success", true);
        try {
            studentService.deleteStudentById(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            String responseBody = "操作失败！" + e.getMessage();
            responseMessage.put("msg", responseBody);
            responseMessage.put("success", false);
        }
        return responseMessage;
    }
}
