package cn.csp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.csp.entity.Location;

@Repository
@Mapper
public interface LocationMapper {


    @Select("SELECT * FROM location WHERE location_id = #{locationId};")
    public Location findLocationById(@Param("locationId") String locationId);

    @Select("SELECT * FROM location WHERE location_name = #{locationName};")
    public Location findLocationByName(@Param("locationName") String locationName);

    @Select("SELECT * FROM location;")
    public List<Location> findAllLocations();

    @Insert("INSERT INTO location (location_name) VALUES (#{locationName};")
    public void addLocation(@Param("locationName") String locationName);

    @Update("Update location SET location_name VALUES #{locationName} WHERE location_id = #{locationId};")
    public void updateLocation(@Param("locationId") String locationId,@Param("locationName") String locationName);
    
    @Delete("DELETE FROM location WHERE location_name = #{locationName};")
    public void deleteLocation(@Param("locationName") String locationName);

}
