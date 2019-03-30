package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Staff;

@Repository
@Mapper
public interface StaffDao {


    @Select("SELECT * FROM staff WHERE st_id = #{st_id};")
    public Staff findStaffById(@Param("st_id") String st_id);

    @Select("SELECT * FROM staff ORDER BY st_id LIMIT #{offset}, #{limit};")
    public List<Staff> findStaffs(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO staff (st_id,st_name) VALUES (#{st_id},#{st_name});")
    public void addStaff(@Param("st_id") String st_id,@Param("st_name") String st_name);

    @Delete("DELETE FROM staff WHERE st_id = #{st_id};")
    public void deleteStaff(@Param("st_id") String st_id);


}
