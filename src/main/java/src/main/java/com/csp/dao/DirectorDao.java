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


    @Select("SELECT * FROM director WHERE director_id = #{directorId};")
    public Director findDirectorById(@Param("directorId") String directorId);

    @Select("SELECT * FROM director ORDER BY director_id LIMIT #{offset}, #{limit};")
    public List<Director> findDirectors(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO director (director_id,director_name) VALUES (#{directorId},#{directorName});")
    public void addDirector(@Param("directorId") String directorId,@Param("directorName") String directorName);

    @Delete("DELETE FROM director WHERE director_id = #{directorId};")
    public void deleteDirector(@Param("directorId") String directorId);


}
