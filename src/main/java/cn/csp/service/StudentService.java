package cn.csp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csp.dao.StudentBunkMapMapper;
import cn.csp.dao.StudentElectiveScheduleMapMapper;
import cn.csp.dao.StudentMapper;
import cn.csp.entity.Bunk;
import cn.csp.entity.Student;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentDao;

    @Autowired
    private StudentElectiveScheduleMapMapper SESMapDao;
    
    @Autowired
    private StudentBunkMapMapper stuBkMapDao;


    public Student findStudentById(String studentId) {
        Student st = studentDao.findStudentById(studentId);
        return st;
    }

    public List<Student> findAllStudents() {
        List<Student> allSt = studentDao.findAllStudents();
        return allSt;
    }
    
    public List<Student> findStudentsByFilters(String name,String bunk,String status) {
    	
        List<Student> students = studentDao.findStudentsByFilters(name,bunk,status);
        return students;
    }

    public int countUndistributedStudents() {
        int disStu = studentDao.countUndistributedStudents();
        return disStu;
    }
    public List<Student> findUndistributedStudents() {
        List<Student> undisStu = studentDao.findUndistributedStudents();
        return undisStu;
    }
    
    @Transactional
    public Student addStudent(String studentName, String studentGender,String studentGrade, String studentYear, String studentStatus, String studentAge) {
        Student st = new Student();
        st.setStudentName(studentName);
        st.setStudentStatus(studentStatus);
		st.setStudentAge(studentAge);
		/*  studentId 生成策略
			年份 2019
			年龄段 1 2 3
			性别 0 1
			序号 001
			
		例：S201911001  2019年小龄段男生01号
		*/
        String id = studentDao.findLastStudentId();
        if (id.equals(null)||id.equals("")) {
            id = "001";
        } else {
            int tmp = Integer.parseInt(id) + 1;
            id = String.valueOf(tmp);
            while (3 - id.length() > 0) {
                id = "0" + id;
            }
        }
        String studentId = "S" + studentYear + studentGrade + studentGender + id;
        st.setStudentId(studentId);
        studentDao.addStudent(studentId, studentName,studentAge, "", studentStatus);
        return st;
    }

    @Transactional
    public void deleteStudentById(String studentId) {
        studentDao.deleteStudent(studentId);//待改 需删除挂在sb se map下的student
        stuBkMapDao.deleteStudentFromBunk(studentId);        
        SESMapDao.deleteStudentRecords(studentId);
    }

    public List<Student> findStudentsByBunkId(String bunkId) {
		List<Student> stus = studentDao.findStudentsByBunkId(bunkId);
		return stus;
	}
	
	@Transactional
	public void addStudentToBunk(String bunkId,String studentId) {
		studentDao.distributeBunk(bunkId,studentId);		
	}
	
	@Transactional
	public void deleteStudentFromBunk(String studentId) {
		studentDao.distributeBunk("",studentId);
	}
	
	@Transactional
	public String deleteStudentsByBunk(String bunkId) {
		studentDao.deleteStudentsByBunk(bunkId);
		return "清空房间成功";
	}

}
