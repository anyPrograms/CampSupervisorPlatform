package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Elective;

@Repository
@Mapper
public interface ElectiveDao {


    @Select("SELECT * FROM elective WHERE elective_id = #{electiveId};")
    public Elective findElectiveById(@Param("electiveId") String electiveId);

    @Select("SELECT * FROM elective;")
    public List<Elective> findAllElectives();

    @Select("SELECT * FROM elective ORDER BY elective_id LIMIT #{offset}, #{limit};")
    public List<Elective> findElectives(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO elective (elective_id,elective_name,elective_vol) VALUES (#{electiveId},#{electiveName},#{electiveVol});")
    public void addElective(@Param("electiveId") String electiveId,@Param("electiveName") String electiveName,@Param("electiveVol") String electiveVol);

    @Delete("DELETE FROM elective WHERE elective_id = #{electiveId};")
    public void deleteElective(@Param("electiveId") String electiveId);

}
