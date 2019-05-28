package cn.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csp.dao.ElectiveScheduleMapper;
import cn.csp.dao.StudentTimeLocationMapMapper;
import cn.csp.entity.ElectiveSchedule;

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
    	stuTimeLocMapMapper.addMap();
    }
}
