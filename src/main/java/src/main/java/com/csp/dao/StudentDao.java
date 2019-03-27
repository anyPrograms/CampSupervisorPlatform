package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import src.main.java.com.csp.entity.Student;

public interface StudentDao {

	@Select("SELECT * FROM Student WHERE s_id = #{s_id};")
	public Student findStudentById(@Param("s_id") String s_id);

	@Select("SELECT MAX(CAST(s_id as UNSIGNED INTEGER)) FROM Student;")
	public String findLastStudentId();
	
	@Select("SELECT * FROM Student;")
	public List<Student> findAllStudents();

	@Select("SELECT * FROM Student ORDER BY s_id LIMIT #{offset}, #{limit};")
	public List<Student> findStudents(@Param("offset") int offset, @Param("limit") int limit);

	@Insert("INSERT INTO Student (s_id,s_name,s_bunk,s_status) VALUES (#{s_id},#{s_name},#{s_bunk},#{s_status});")
	public void addStudent(@Param("s_id") String s_id,@Param("s_name") String s_name,@Param("s_bunk") String s_bunk,@Param("s_id") String s_status);
	
	@Delete("DELETE FROM Student WHERE s_id = #{s_id};")
	public void deleteStudent(@Param("s_id") String s_id);

}
