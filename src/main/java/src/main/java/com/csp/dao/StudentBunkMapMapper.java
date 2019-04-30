package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Bunk;
import src.main.java.com.csp.entity.Student;
@Repository
@Mapper
public interface StudentBunkMapMapper {

    @Select("SELECT * FROM student st JOIN student_bunk_map sbmap ON st.student_id = sbmap.student_id AND sbmap.bunk_id = #{bunkId};")
    public List<Student> findStudentsByBunkId(@Param("bunkId") String bunkId);

	@Insert("INSERT INTO student_bunk_map (student_id,bunk_id) VALUES (#{studentId},#{bunkId});")
	public void addStudentToBunk(@Param("studentId") String studentId,@Param("bunkId") String bunkId);
	
	@Delete("DELETE FROM student_bunk_map WHERE student_id = #{studentId};")
	public void deleteStudentFromBunk(@Param("studentId") String studentId);

	@Delete("DELETE FROM student_bunk_map WHERE bunk_id = #{bunkId};")
	public void deleteAllStudentsByBunk(@Param("bunkId") String bunkId);

	@Select("SELECT student_id FROM student_bunk_map WHERE student_id = #{studentId};")
	public String findStudentIfExists(@Param("studentId") String studentId);

}
