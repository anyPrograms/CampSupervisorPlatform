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
public interface ElectiveScheduleMapper {


    @Select("SELECT * FROM elective_schedule WHERE schedule_id = #{scheduleId};")
    public ElectiveSchedule findElectiveScheduleById(@Param("scheduleId") String scheduleId);

    @Select("SELECT * FROM elective_schedule WHERE elective_name = #{electiveName} AND period = #{period} AND date = #{date};")
    public ElectiveSchedule findElectiveSchedule(@Param("electiveName") String electiveId,@Param("period") String period,@Param("date") String date);
    
    @Select("SELECT * FROM elective_schedule;")
    public List<ElectiveSchedule> findAllElectiveSchedules();

    @Select("SELECT * FROM elective_schedule ORDER BY schedule_id LIMIT #{offset}, #{limit};")
    public List<ElectiveSchedule> findElectiveSchedules(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*)  FROM schedule;")
    public int totalNumberOfElectiveSchedules();

    @Insert("INSERT INTO elective_schedule (schedule_id,period,elective_name,age_group,date,schedule_vol,location_id) VALUES (#{electiveName},#{period},#{ageGroup},#{date},#{scheduleVol}),#{locationId};")
    public void addElectiveSchedule(@Param("electiveName") String electiveName,@Param("period") String period,@Param("ageGroup") String ageGroup,@Param("date") String date,@Param("scheduleVol") String scheduleVol,@Param("locationId") String locationId);

    @Delete("DELETE FROM elective_schedule WHERE schedule_id = #{scheduleId};")
    public void deleteElectiveSchedule(@Param("scheduleId") String scheduleId);

}
