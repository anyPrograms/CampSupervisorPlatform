package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import src.main.java.com.csp.entity.Student;

public interface StudentDao {

	/**
	 * 通过ID查询学生
	 * 
	 * @param id
	 * @return
	 */
	Student findStudentById(String id);

	/**
	 * 查询部分学生
	 * 
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return
	 */
	List<Student> findStudents(@Param("offset") int offset, @Param("limit") int limit);


}
