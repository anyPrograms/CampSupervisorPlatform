package src.main.java.com.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.main.java.com.csp.dao.ElectiveMapper;
import src.main.java.com.csp.entity.Elective;

import java.util.List;

@Service
public class ElectiveService {
    @Autowired
    private ElectiveMapper electiveDao;

    public Elective findElectiveById(String electiveId) {
        Elective elec = electiveDao.findElectiveById(electiveId);
        return elec;
    }

    public List<Elective> findAllElectives() {
        List<Elective> allElec = electiveDao.findAllElectives();
        return allElec;
    }

    public int totalNumberOfElectives() {
        return electiveDao.totalNumberOfElectives();
    }

    @Transactional
    /**
     * 添加课程
     * @param electiveName 课程名称
     * @param electiveVolume 课程总人数
     * @return 返回一个课程实体
     *
     */
    public Object addElective(String electiveName,String electiveVolume){
        Elective elec=new Elective();
        if(electiveDao.findElectiveByName(electiveName)!=null) {
        	elec.setElectiveName(electiveName);
            elec.setElectiveVolume(electiveVolume);
            electiveDao.addElective(electiveName,electiveVolume);
            return elec;
        }else {
        	return null;
        }
        
    }

    @Transactional
    public void deleteElectiveByName(String electiveName){
        electiveDao.deleteElective(electiveName);
    }

}
