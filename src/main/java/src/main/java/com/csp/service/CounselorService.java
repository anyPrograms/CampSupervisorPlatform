package src.main.java.com.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.main.java.com.csp.dao.CounselorDao;
import src.main.java.com.csp.entity.Counselor;
import src.main.java.com.csp.entity.Student;

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

    public int countUndistributedCounselors() {
        int disCoun = counselorDao.countUndistributedCounselors();
        return disCoun;
    }
    public List<Counselor> findUndistributedCounselors() {
        List<Counselor> undisCoun = counselorDao.findUndistributedCounselors();
        return undisCoun;
    }
    
    @Transactional
    public Counselor addCounselor(String counselorName, String counselorGender, String counselorYear, String counselorAgeType, String counselorIntro) {
        Counselor coun = new Counselor();
        coun.setCounselorName(counselorName);
        coun.setCounselorIntro(counselorIntro);

        //counselorId生成策略与学生Id生成策略一致
        String lastId = counselorDao.findLastCounselorId();//当前最后一个Id
        if (lastId.equals(null)) {
            lastId = "001";
        } else {
            lastId = lastId.substring(lastId.length() - 3, lastId.length());
            int newIdTemp = Integer.parseInt(lastId) + 1;
            lastId = String.valueOf(newIdTemp);
            //补足尾3位
            while (3 - lastId.length() > 0) {
                lastId = "0" + lastId;
            }
        }
        //添加前缀
        String counselorId = "C" + counselorYear + counselorAgeType + counselorGender + lastId;
        coun.setCounselorId(counselorId);
        counselorDao.addCounselor(counselorId,counselorName,"",counselorIntro);
        return coun;
    }

    @Transactional
    public void deleteCounselorById(String counselorId){
    	counselorDao.deleteCounselor(counselorId);
    }
}
