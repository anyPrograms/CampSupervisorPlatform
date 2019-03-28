package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import src.main.java.com.csp.entity.Counselor;
import src.main.java.com.csp.entity.Student;

public interface CounselorDao {


    @Select("SELECT * FROM Counselor WHERE c_id = #{c_id};")
    public Counselor findCounselorById(@Param("c_id") String c_id);

    @Select("SELECT * FROM Counselor ORDER BY c_id LIMIT #{offset},#{limit};")
    public List<Counselor> findCounselors(@Param("offset") int offset,@Param("limit") int limit);

    @Insert("INSERT INTO Counselor (c_id,c_name,c_bunk,c_intro) VALUES (#{c_id},#{c_name},#{c_bunk},#{c_intro})")
    public void addCounselor(@Param("c_id") String c_id,@Param("c_name") String c_name,@Param("c_bunk") String c_bunk,@Param("c_id") String c_intro);

    @Delete("DELETE FROM Counselor WHERE c_id = #{c_id};")
    public void deleteCounselor(@Param("c_id") String c_id);

}
