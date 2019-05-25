package cn.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csp.dao.ElectiveMapper;
import cn.csp.entity.Elective;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ElectiveService {
    @Autowired
    private ElectiveMapper electiveDao;


    /**
     * 根据Id查找课程
     * @param electiveId 课程Id
     * @return 返回一个课程实体
     */
    public Elective findElectiveById(String electiveId) {
        Elective elec = electiveDao.findElectiveById(electiveId);
        return elec;
    }

    /**
     * 根据Name查找课程
     * @param electiveName 课程Name
     * @return 返回一个课程实体
     */
    public Elective findElectiveByName(String electiveName) {
        Elective elec = electiveDao.findElectiveByName(electiveName);
        return elec;
    }

    /**
     * 查找所有课程
     * @return 返回课程实体列表
     */
    public List<Elective> findAllElectives() {
        List<Elective> allElec = electiveDao.findAllElectives();
        return allElec;
    }

    /**
     * 统计课程总数
     * @return 返回课程数量(int类型)
     */
    public int totalNumberOfElectives() {
        return electiveDao.totalNumberOfElectives();
    }

    @Transactional
    /**
     * 添加课程
     * @param electiveName 课程名称
     * @param electiveIntro 课程介绍
     * @return 返回一个课程实体
     */
    public Elective addElective(String electiveName, String electiveIntro) {
        Elective elec = new Elective();
        if (electiveDao.findElectiveByName(electiveName) != null) {
            elec.setElectiveName(electiveName);
            Date date = new Date();
            SimpleDateFormat SDF=new SimpleDateFormat("yyyyMMddHHmmss");
            String electiveId=SDF.format(date);
            elec.setElectiveIntro(electiveIntro);
            electiveDao.addElective(electiveId,electiveName, electiveIntro);
            return elec;
        } else {
            return null;
        }

    }

    @Transactional
    /**
     * 通过课程名字删除课程
     * @param electiveName 课程名称
     */
    public void deleteElectiveByName(String electiveName) {
        electiveDao.deleteElective(electiveName);
    }

}
