package cn.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csp.dao.LocationMapper;
import cn.csp.entity.Location;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationMapper locationDao;


    /**
     * 查找所有地点
     * @return 返回地点列表
     */
    public List<Location> findAllLocations() {
        List<Location> allLocs = locationDao.findAllLocations();
        return allLocs;
    }


    @Transactional
    /**
     * 添加地点
     * @param locationName 地点名称
     * @return 返回一个地点实体
     */
    public Location addLocation(String locationName) {
        Location loc = new Location();
        if (locationDao.findLocationByName(locationName) != null) {
            loc.setLocationName(locationName);
            Date date = new Date();
            SimpleDateFormat SDF=new SimpleDateFormat("yyyyMMddHHmmss");
            String locationId=SDF.format(date);
            locationDao.addLocation(locationId,locationName);
            return loc;
        } else {
            return null;
        }
    }
    
    @Transactional
    /**
     * 编辑地点
     * @param locationName 地点名称
     * @return 返回一个地点实体
     */
    public Location updateLocation(String locationId,String locationName) {
        Location loc = new Location();
        if (locationDao.findLocationByName(locationId) != null) {
        	loc.setLocationName(locationName);
            locationDao.updateLocation(locationId,locationName);
            return loc;
        } else {
            return null;
        }
    }
    @Transactional
    /**
     * 通过地点名字删除地点
     * @param locationName 地点名称
     */
    public void deleteLocationByName(String locationName) {
        locationDao.deleteLocation(locationName);
    }

}
