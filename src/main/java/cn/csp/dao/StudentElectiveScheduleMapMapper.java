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
public interface StudentElectiveScheduleMapMapper {

    @Select("SELECT * FROM ElectiveSchedule el JOIN student_elective_map semap ON el.student_id = semap.student_id AND semap.student_id = #{studentId};")
    public List<ElectiveSchedule> findElectiveSchedulesByStudentId(@Param("studentId") String studentId);

	@Insert("INSERT INTO student_elective_schedule_map (student_id,schedule_id) VALUES (#{studentId},#{scheduleId});")
	public void addScheduleToStudentScheduleMap(@Param("studentId") String studentId,@Param("scheduleId") String scheduleId);
	
	@Delete("DELETE FROM student_elective_schedule_map WHERE schedule_id = #{scheduleId} AND student_id = #{studentId};")
	public void deleteScheduleToStudentScheduleMap(@Param("scheduleId") String scheduleId,@Param("studentId") String studentId);

}
