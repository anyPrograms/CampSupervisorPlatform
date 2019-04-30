package src.main.java.com.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import src.main.java.com.csp.entity.Bunk;
@Repository
@Mapper
public interface BunkMapper {

    @Select("SELECT * FROM bunk WHERE bunk_id = #{bunkId};")
    public Bunk findBunkById(@Param("bunkId") String bunkId);

	@Select("SELECT * FROM bunk;")
	public List<Bunk> findAllBunks();
	
    @Select("SELECT * FROM bunk ORDER BY bunk_id LIMIT #{offset}, #{limit};")
    public List<Bunk> findBunks(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO bunk (bunk_id,bunk_name) VALUES (#{bunkId},#{bunkName});")
    public void addBunk(@Param("bunkId") String bunkId,@Param("bunkName") String bunkName);

    @Delete("DELETE FROM bunk WHERE bunk_id = #{bunkId};")
    public void deleteBunk(@Param("bunkId") String bunkId);


}
