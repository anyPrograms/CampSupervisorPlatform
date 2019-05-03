package cn.csp.service;

import cn.csp.dao.StaffMapper;
import cn.csp.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Title   : StaffService.java
 * Author  : Shichao Qiao
 * Created : 2019/5/3 21:42
 * Version : 1.0
 */
public class StaffService {
    @Autowired
    private StaffMapper staffDao;

    /**
     * 根据Id查找职员
     *
     * @param staffId 职员Id
     * @return 返回一个职员实体
     */
    public Staff findStaffById(String staffId) {
        Staff staff = staffDao.findStaffById(staffId);
        return staff;
    }

    /**
     * 查找所有职员
     *
     * @return 返回职员实体列表
     */
    public List<Staff> findAllStaffs() {
        return staffDao.findAllStaffs();
    }

    /**
     * 新增一个职员
     *
     * @param staffYear 职员所属年份
     * @param staffName 职员名称
     * @return 返回一个职员实体
     */
    public Staff addStaff(String staffYear,String staffName) {
        Staff st=new Staff();
        st.setStaffName(staffName);
        /* staff_id 生成策略
	    身份 ST
	    年份 2019
	    序号 001

        例：ST2019001 Staff2019年001号
        */
        String id=staffDao.findLastStaffId();
        if(id.equals(null)){
            id="001";
        }else{
            id=id.substring(id.length()-3,id.length());
            int tmp=Integer.parseInt(id)+1;
            id=String.valueOf(tmp);
            while(3-id.length()>0){
                id='0'+id;
            }
        }
        String staffId="ST"+staffYear+id;
        st.setStaffId(staffId);
        return st;
    }
}
