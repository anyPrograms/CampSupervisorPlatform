package src.main.java.com.csp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.csp.dao.StudentBunkMapDao;
import src.main.java.com.csp.dao.StudentDao;
import src.main.java.com.csp.entity.Student;

@Service
public class StudentBunkMapService {
	@Autowired
	private StudentBunkMapDao stuBkMapDao;

	
	public List<Student> findStudentsByBunkId(String bunkId) {
		List<Student> stus = stuBkMapDao.findStudentsByBunkId(bunkId);
		return stus;
	}
	
	@Transactional
	public String addStudentToBunk(String studentId,String bunkId) {
		if(stuBkMapDao.findStudentIfExists(studentId)!=null) {
			return "已经分配过房间";
		}else {
			stuBkMapDao.addStudentToBunk(studentId, bunkId);
			return "分配成功";
		}
	}
	
	@Transactional
	public String deleteStudentFromBunk(String studentId) {
		if(stuBkMapDao.findStudentIfExists(studentId)!=null) {
			stuBkMapDao.deleteStudentFromBunk(studentId);
			return "删除成功";
		}else {
			return "房间无此人";
		}
	}
	
	
	@Transactional
	public String deleteAllStudentsByBunk(String bunkId) {
		stuBkMapDao.deleteAllStudentsByBunk(bunkId);
		return "清空房间成功";
	}
}
	
	

