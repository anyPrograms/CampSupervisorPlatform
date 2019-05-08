package cn.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.csp.entity.Elective;

@Repository
@Mapper
public interface ElectiveMapper {


    @Select("SELECT * FROM elective WHERE elective_id = #{electiveId};")
    public Elective findElectiveById(@Param("electiveId") String electiveId);

    @Select("SELECT * FROM elective WHERE elective_name = #{electiveName};")
    public Elective findElectiveByName(@Param("electiveName") String electiveName);

    @Select("SELECT * FROM elective;")
    public List<Elective> findAllElectives();

    @Select("SELECT * FROM elective ORDER BY elective_id LIMIT #{offset}, #{limit};")
    public List<Elective> findElectives(@Param("offset") int offset, @Param("limit") int limit);


    @Select("SELECT COUNT(*)  FROM elective;")
    public int totalNumberOfElectives();

    @Insert("INSERT INTO elective (elective_name,elective_intro) VALUES (#{electiveName},#{electiveIntro});")
    public void addElective(@Param("electiveName") String electiveName,@Param("electiveIntro") String electiveIntro);

    @Delete("DELETE FROM elective WHERE elective_name = #{electiveName};")
    public void deleteElective(@Param("electiveName") String electiveName);

}
