package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import src.main.java.com.csp.entity.Bunk;
import src.main.java.com.csp.entity.Director;
import src.main.java.com.csp.entity.Staff;
import src.main.java.com.csp.entity.Student;

public interface BunkDao {

    @Select("SELECT * FROM Bunk WHERE b_id = #{b_id};")
    public Bunk findBunkById(@Param("b_id") String b_id);

    @Select("SELECT * FROM Bunk ORDER BY b_id LIMIT #{offset}, #{limit};")
    public List<Bunk> findBunks(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO Bunk (b_id,b_name) VALUES (#{b_id},#{b_name});")
    public void addBunk(@Param("b_id") String b_id,@Param("b_name") String b_name);

    @Delete("DELETE FROM Bunk WHERE b_id = #{b_id};")
    public void deleteBunk(@Param("b_id") String b_id);


}
