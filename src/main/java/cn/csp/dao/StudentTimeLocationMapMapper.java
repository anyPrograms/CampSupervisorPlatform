package cn.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.csp.entity.ElectiveSchedule;

@Repository
@Mapper
public interface StudentTimeLocationMapMapper {

    @Insert("INSERT IGNORE INTO student_time_location_map (student_id,location_id,period,date) " + 
    		"SELECT a.student_id,b.location_id,b.period ,b.date "+
    		"FROM student_elective_schedule_map a, elective_schedule b "+
    		"WHERE a.schedule_id=b.schedule_id AND student_id = #{studentId};")
    public void addMap(@Param("studentId") String studentId);


}
