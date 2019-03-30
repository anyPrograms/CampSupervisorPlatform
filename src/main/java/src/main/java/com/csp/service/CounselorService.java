package src.main.java.com.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.main.java.com.csp.dao.CounselorDao;
import src.main.java.com.csp.entity.Counselor;

import java.util.List;

@Service
public class CounselorService {
    @Autowired
    private CounselorDao counselorDao;

    public Counselor findCounselorById(String counID) {
        Counselor coun = counselorDao.findCounselorById(counID);
        return coun;
    }

    public List<Counselor> findAllCounselors() {
        List<Counselor> allCoun = counselorDao.findAllCounselors();
        return allCoun;
    }

    @Transactional
    public Counselor addCounselor(String counselorId,String counselorName,String counselorBunk,String counselorIntro){
        Counselor coun = new Counselor();
        coun.setCounselorName(counselorName);
        coun.setCounselorIntro(counselorIntro);
    }
}
