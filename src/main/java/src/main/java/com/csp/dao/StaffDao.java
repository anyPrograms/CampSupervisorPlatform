package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import src.main.java.com.csp.entity.Staff;
import src.main.java.com.csp.entity.Student;

public interface StaffDao {


    @Select("SELECT * FROM Staff WHERE st_id = #{st_id};")
    public Staff findStaffById(@Param("st_id") String st_id);

    @Select("SELECT * FROM Staff ORDER BY st_id LIMIT #{offset}, #{limit};")
    public List<Staff> findStaffs(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO Staff (st_id,st_name) VALUES (#{st_id},#{st_name});")
    public void addStaff(@Param("st_id") String st_id,@Param("st_name") String st_name);

    @Delete("DELETE FROM Staff WHERE st_id = #{st_id};")
    public void deleteStaff(@Param("st_id") String st_id);


}
