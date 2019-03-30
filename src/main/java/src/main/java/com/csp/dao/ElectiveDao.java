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


    @Select("SELECT * FROM Elective WHERE e_id = #{e_id};")
    public Elective findElectiveById(@Param("e_id") String e_id);

    @Select("SELECT * FROM Elective ORDER BY e_id LIMIT #{offset}, #{limit};")
    public List<Elective> findElectives(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO Elective (e_id,e_name,e_vol) VALUES (#{e_id},#{e_name},#{e_vol});")
    public void addElective(@Param("e_id") String e_id,@Param("e_name") String e_name,@Param("e_vol") String e_vol);

    @Delete("DELETE FROM Elective WHERE e_id = #{e_id};")
    public void deleteElective(@Param("e_id") String e_id);

}
