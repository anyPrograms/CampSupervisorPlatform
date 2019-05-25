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
import cn.csp.entity.StudentTimeLocationMap;

@Repository
@Mapper
public interface StudentTimeLocationMapMapper {

    @Insert("INSERT IGNORE INTO student_time_location_map (student_id,location_id,period,date) " + 
    		"SELECT a.student_id,b.location_id,b.period ,b.date "+
    		"FROM student_elective_schedule_map a, elective_schedule b "+
    		"WHERE a.schedule_id=b.schedule_id AND student_id = #{studentId};")
    public void addMapByStudentId(@Param("studentId") String studentId);

    @Insert("INSERT IGNORE INTO student_time_location_map (student_id,location_id,period,date) " + 
    		"SELECT a.student_id,b.location_id,b.period ,b.date "+
    		"FROM student_elective_schedule_map a, elective_schedule b "+
    		"WHERE a.schedule_id=b.schedule_id;")
    public void addMap();
    
    @Select("SELECT * "+
    		"FROM  student_time_location_map"+
    		"WHERE location_id=#{locationId} AND date = #{date};")
    public List<StudentTimeLocationMap> findMapByLocation(@Param("locationId") String locationId,@Param("date") String date);
}
