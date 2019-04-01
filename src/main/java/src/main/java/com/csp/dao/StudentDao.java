package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Student;

@Repository
@Mapper
public interface StudentDao {

	@Select("SELECT * FROM student WHERE student_id = #{studentId};")
	public Student findStudentById(@Param("studentId") String studentId);

	@Select("SELECT MAX(CAST(student_id as UNSIGNED INTEGER)) FROM student;")
	public String findLastStudentId();
	
	@Select("SELECT * FROM student;")
	public List<Student> findAllStudents();

	@Select("SELECT * FROM student ORDER BY student_id LIMIT #{offset}, #{limit};")
	public List<Student> findStudents(@Param("offset") int offset, @Param("limit") int limit);

	@Insert("INSERT INTO student (student_id,student_name,student_age,student_bunk,student_status) VALUES (#{studentId},#{studentName},#{studentAge},#{studentBunk},#{studentStatus});")
	public void addStudent(@Param("studentId") String studentId,@Param("studentName") String studentName,@Param("studentAge") String studentAge,@Param("studentBunk") String studentBunk,@Param("studentStatus") String studentStatus);
	
	@Delete("DELETE FROM student WHERE student_id = #{studentId};")
	public void deleteStudent(@Param("studentId") String studentId);

}
