package cn.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.csp.entity.Counselor;
import cn.csp.entity.Student;
@Repository
@Mapper
public interface CounselorMapper {


    @Select("SELECT * FROM counselor WHERE counselor_id = #{counselorId};")
    public Counselor findCounselorById(@Param("counselorId") String counselorId);

    @Select("SELECT MAX(CAST(counselor_id as UNSIGNED INTEGER)) FROM counselor;")
    public String findLastCounselorId();

	@Select("SELECT * FROM counselor c JOIN counselor_bunk_map cbm ON c.counselor_id = cbm.counselor_id;")
	public List<Counselor> findUndistributedCounselors();

	@Select("SELECT count(*) counselor c JOIN counselor_bunk_map cbm ON c.counselor_id = cbm.counselor_id;")
	public int countUndistributedCounselors();
	
	@Update("Update student SET student_bunk = #{bunkName} WHERE student_id = #{studentId};")
	public void distributeBunk(@Param("bunkName") String bunkName,@Param("studentId") String studentId);

    @Select("SELECT * FROM counselor;")
    public List<Counselor> findAllCounselors();

    @Select("SELECT * FROM counselor ORDER BY counselor_id LIMIT #{offset},#{limit};")
    public List<Counselor> findCounselors(@Param("offset") int offset,@Param("limit") int limit);

    @Insert("INSERT INTO counselor (counselor_id,counselor_name,counselor_bunk,counselor_intro) VALUES (#{counselorId},#{counselorName},#{counselorBunk},#{counselorIntro})")
    public void addCounselor(@Param("counselorId") String counselorId,@Param("counselorName") String counselorName,@Param("counselorBunk") String counselorBunk,@Param("counselorIntro") String counselorIntro);

    @Delete("DELETE FROM counselor WHERE counselor_id = #{counselorId};")
    public void deleteCounselor(@Param("counselorId") String counselorId);

}
