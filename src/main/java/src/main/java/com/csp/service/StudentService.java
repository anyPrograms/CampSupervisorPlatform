package src.main.java.com.csp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.csp.dao.StudentBunkMapDao;
import src.main.java.com.csp.dao.StudentDao;
import src.main.java.com.csp.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private StudentBunkMapDao stuBkMapDao;

	
	public Student findStudentById(String studentId) {
		Student st = studentDao.findStudentById(studentId);
		return st;
	}
	
	public List<Student> findAllStudents() {
		List<Student> allSt = studentDao.findAllStudents();
		return allSt;
	}
	
	@Transactional
	public Student addStudent(String studentName,String studentGender,String studentYear,String studentStatus,String studentAge) {
		Student st = new Student();
		st.setStudentName(studentName);
		st.setStudentStatus(studentStatus);
		
		/*  studentId 生成策略
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
		String studentId = "S"+studentYear+studentAge+studentGender+id;
		st.setStudentId(studentId);
		studentDao.addStudent(studentId, studentName, "", studentStatus);
		return st;
	}
	
	@Transactional
	public void deleteStudentById(String studentId) {
		studentDao.deleteStudent(studentId);//待改 需删除挂在sb se map下的student
		stuBkMapDao.deleteStudentFromBunk(studentId);
	}
	
	
}
