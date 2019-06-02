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
    public void generateMap();
    
    @Delete("Delete FROM student_time_location_map WHERE date = #{date};")
    public void cleanMapByDate(@Param("date")String date);
    
    @Select("SELECT * "+
    		"FROM  student_time_location_map"+
    		"WHERE location_id=#{locationId} AND date = #{date};")
    public List<StudentTimeLocationMap> findMapByLocation(@Param("locationId") String locationId,@Param("date") String date);
    
    @Select("SELECT * FROM student_time_location_map WHERE date = #{date};")
    public List<StudentTimeLocationMap> showMap(@Param("date")String date);
    
    
    @Select("SELECT * FROM student_time_location_map a JOIN student b ON a.student_id = b.student_id WHERE b.student_name LIKE '%${studentName}%' AND b.student_bunk LIKE '%${studentBunk}%' AND a.period LIKE '%${period}%' AND a.date = #{date};")
    public List<StudentTimeLocationMap> findStudentMapByFilters(@Param("studentName")String studentName,@Param("studentBunk")String studentBunk,@Param("period")String period,@Param("date")String date);
}
