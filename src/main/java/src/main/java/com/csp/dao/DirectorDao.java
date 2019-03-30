package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Director;
@Repository
@Mapper
public interface DirectorDao {


    @Select("SELECT * FROM Director WHERE d_id = #{d_id};")
    public Director findDirectorById(@Param("d_id") String d_id);

    @Select("SELECT * FROM Director ORDER BY d_id LIMIT #{offset}, #{limit};")
    public List<Director> findDirectors(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO Director (d_id,d_name) VALUES (#{d_id},#{d_name});")
    public void addDirector(@Param("d_id") String d_id,@Param("d_name") String d_name);

    @Delete("DELETE FROM Director WHERE d_id = #{d_id};")
    public void deleteDirector(@Param("d_id") String d_id);


}
