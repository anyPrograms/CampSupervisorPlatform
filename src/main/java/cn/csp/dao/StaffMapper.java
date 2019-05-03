package cn.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import cn.csp.entity.Staff;

@Repository
@Mapper
public interface StaffMapper {


    @Select("SELECT * FROM staff WHERE staff_id = #{staffId};")
    public Staff findStaffById(@Param("staffId") String staffId);

    @Select("SELECT * FROM staff;")
    public List<Staff> findAllStaffs();

    //在service里没有实现该方法
    @Select("SELECT * FROM staff ORDER BY staff_id LIMIT #{offset}, #{limit};")
    public List<Staff> findStaffs(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO staff (staff_id,staff_name) VALUES (#{staffId},#{staffName});")
    public void addStaff(@Param("staffId") String staffId,@Param("staffName") String staffName);

    @Delete("DELETE FROM staff WHERE staff_id = #{staffId};")
    public void deleteStaff(@Param("staffId") String staffId);

    @Select("select * from staff order by substring(staff_id,7) desc;")
    public String findLastStaffId();


}
