package cn.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csp.dao.ElectiveScheduleMapper;
import cn.csp.entity.ElectiveSchedule;

import java.util.List;

@Service
public class ElectiveScheduleService {
    @Autowired
    private ElectiveScheduleMapper electiveScheduleDao;


    /**
     * 根据Id查找课程计划
     * @param electiveScheduleId 课程计划Id
     * @return 返回一个课程计划实体
     */
    public ElectiveSchedule findElectiveScheduleById(String electiveScheduleId) {
        ElectiveSchedule elec = electiveScheduleDao.findElectiveScheduleById(electiveScheduleId);
        return elec;
    }


    /**
     * 查找所有课程计划
     * @return 返回课程计划实体列表
     */
    public List<ElectiveSchedule> findAllElectiveSchedules() {
        List<ElectiveSchedule> allElec = electiveScheduleDao.findAllElectiveSchedules();
        return allElec;
    }

    /**
     * 统计课程计划总数
     * @return 返回课程计划数量(int类型)
     */
    public int totalNumberOfElectiveSchedules() {
        return electiveScheduleDao.totalNumberOfElectiveSchedules();
    }

    @Transactional
    /**
     * 添加课程计划
     * @param electiveId 课程Id
     * @param period 阶段
     * @param ageGroup 可选年龄段
     * @param date 日期
     * @param scheculeVol 课程计划容量
     * @return 返回一个课程计划实体
     */
    public ElectiveSchedule addElectiveSchedule(String electiveId,String period,String ageGroup,String date,String scheduleVol,String locationId) {
        ElectiveSchedule schedule = new ElectiveSchedule();
        if (electiveScheduleDao.findElectiveSchedule(electiveId,period,date) != null) {
        	schedule.setElectiveId(electiveId);
        	schedule.setAgeGroup(ageGroup);
        	schedule.setScheduleVol(scheduleVol);
        	schedule.setPeriod(period);
        	String scheduleId="";
        	scheduleId = electiveId+date+period;
        	schedule.setScheduleId(scheduleId);
        	electiveScheduleDao.addElectiveSchedule(electiveId, period,ageGroup,date,scheduleVol,locationId);
            return schedule;
        } else {
            return null;
        }

    }

    @Transactional
    /**
     * 通过课程计划名字删除课程计划
     * @param electiveScheduleName 课程计划名称
     */
    public void deleteElectiveScheduleById(String electiveScheduleId) {
        electiveScheduleDao.deleteElectiveSchedule(electiveScheduleId);
    }

}
