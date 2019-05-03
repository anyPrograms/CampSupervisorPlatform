package cn.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.csp.entity.Student;

@Repository
@Mapper
public interface StudentMapper {

	@Select("SELECT * FROM student WHERE student_id = #{studentId};")
	public Student findStudentById(@Param("studentId") String studentId);

	@Select("SELECT * FROM student WHERE student_bunk = #{bunkId};")
	public List<Student> findStudentsByBunkId(@Param("bunkId") String bunkId);
	
//	@Select("SELECT MAX(CAST(student_id as UNSIGNED INTEGER)) FROM student;")
	@Select("select student_id from student order by substring(student_id,8) desc limit 1;")
	public String findLastStudentId();
	
	@Select("SELECT * FROM student WHERE student_name LIKE '%${studentName}%' AND student_bunk LIKE '%${studentBunk}%' AND student_status LIKE '%${studentStatus}%';")
	public List<Student> findStudentsByFilters(@Param("studentName") String name,@Param("studentBunk") String bunk,@Param("studentStatus") String status);
	
	@Select("SELECT * FROM student WHERE student_bunk ='';")
	public List<Student> findUndistributedStudents();
	
	@Select("SELECT count(*) FROM student WHERE student_bunk ='';")
	public int countUndistributedStudents();
	
	@Select("SELECT * FROM student;")
	public List<Student> findAllStudents();
	
	@Update("Update student SET student_bunk = #{bunkId} WHERE student_id = #{studentId};")
	public void distributeBunk(@Param("bunkId") String bunkId,@Param("studentId") String studentId);

	@Select("SELECT * FROM student ORDER BY student_id LIMIT #{offset}, #{limit};")
	public List<Student> findStudents(@Param("offset") int offset, @Param("limit") int limit);

	@Insert("INSERT INTO student (student_id,student_name,student_age,student_bunk,student_status) VALUES (#{studentId},#{studentName},#{studentAge},#{studentBunk},#{studentStatus});")
	public void addStudent(@Param("studentId") String studentId,@Param("studentName") String studentName,@Param("studentAge") String studentAge,@Param("studentBunk") String studentBunk,@Param("studentStatus") String studentStatus);
	
	@Delete("DELETE FROM student WHERE student_id = #{studentId};")
	public void deleteStudent(@Param("studentId") String studentId);
	
	@Delete("DELETE FROM student WHERE student_bunk = #{bunkId};")
	public void deleteStudentsByBunk(@Param("bunkId") String bunkId);

}
