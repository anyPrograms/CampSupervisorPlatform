package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Counselor;
@Repository
@Mapper
public interface CounselorDao {


    @Select("SELECT * FROM counselor WHERE counselor_id = #{counselorId};")
    public Counselor findCounselorById(@Param("counselorId") String counselorId);

    @Select("SELECT MAX(CAST(counselor_id as UNSIGNED INTEGER)) FROM counselor;")
    public String findLastCounselorId();

    @Select("SELECT * FROM counselor;")
    public List<Counselor> findAllCounselors();

    @Select("SELECT * FROM counselor ORDER BY counselor_id LIMIT #{offset},#{limit};")
    public List<Counselor> findCounselors(@Param("offset") int offset,@Param("limit") int limit);

    @Insert("INSERT INTO counselor (counselor_id,counselor_name,counselor_bunk,counselor_intro) VALUES (#{counselorId},#{counselorName},#{counselorBunk},#{counselorIntro})")
    public void addCounselor(@Param("counselorId") String counselorId,@Param("counselorName") String counselorName,@Param("counselorBunk") String counselorBunk,@Param("counselorIntro") String counselorIntro);

    @Delete("DELETE FROM counselor WHERE counselor_id = #{counselorId};")
    public void deleteCounselor(@Param("counselorId") String counselorId);

}
