package cn.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csp.dao.ElectiveScheduleMapper;
import cn.csp.dao.StudentTimeLocationMapMapper;
import cn.csp.entity.ElectiveSchedule;
import cn.csp.entity.StudentTimeLocationMap;

import java.util.List;

@Service
public class StuTimeLocMapService {
    @Autowired
    private StudentTimeLocationMapMapper stuTimeLocMapMapper;

    @Transactional
    /**
     * 生成人-时间-地点表
     */
    public void generateMap() {
    	stuTimeLocMapMapper.generateMap();
    }
    
    @Transactional
    public void cleanMapByDate(String date) {
    	stuTimeLocMapMapper.cleanMapByDate(date);
    }
    
    public List<StudentTimeLocationMap> showMap(String date){
    	List<StudentTimeLocationMap> stlMaps=stuTimeLocMapMapper.showMap(date);
    	return stlMaps;
    }
    
    public List<StudentTimeLocationMap> findMapByLocation(String locationId,String date){
    	List<StudentTimeLocationMap> stlMaps=stuTimeLocMapMapper.findMapByLocation(locationId, date);
    	return stlMaps;
    }
    
    public List<StudentTimeLocationMap> findStudentMapByFilters(String studentName,String studentBunk,String period,String date){
    	List<StudentTimeLocationMap> stlMaps=stuTimeLocMapMapper.findStudentMapByFilters(studentName, studentBunk, period, date);
    	return stlMaps;
    }
}
