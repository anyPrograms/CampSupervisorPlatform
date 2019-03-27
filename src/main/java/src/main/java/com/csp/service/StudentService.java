package src.main.java.com.csp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.csp.dao.StudentDao;
import src.main.java.com.csp.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public Student findStudentById(String s_id) {
		Student st = studentDao.findStudentById(s_id);
		return st;
	}
	
	public List<Student> findAllStudent() {
		List<Student> allSt = studentDao.findAllStudents();
		return allSt;
	}
	
	public Student addStudent(String s_name,String s_gender,String s_year,String s_status,String s_age) {
		Student st = new Student();
		st.setS_name(s_name);
		st.setS_status(s_status);
		
		/*  s_id 生成策略
			年份 2019
			年龄段 1 2 3
			性别 0 1
			序号 001
			
		例：201911001  2019年小龄段男生01号
		*/
		String id = studentDao.findLastStudentId();
		if(id.equals(null)) {
			id="001";
		}else {
			id=id.substring(id.length()-3, id.length());
			int tmp = Integer.parseInt(id)+1;
			id = String.valueOf(tmp);
			while(3-id.length()>0){
				id="0"+id;
			}
		}
		String s_id = "S"+s_year+s_age+s_gender+id;
		st.setS_id(s_id);
		studentDao.addStudent(s_id, s_name, "", s_status);
		return st;
	}
	
}
