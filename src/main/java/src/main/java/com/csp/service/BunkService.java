package src.main.java.com.csp.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.csp.dao.BunkDao;
import src.main.java.com.csp.entity.Bunk;

@Service
public class BunkService {
	@Autowired
	private BunkDao bunkDao;
	
	public Bunk findBunkById(String s_id) {
		Bunk st = bunkDao.findBunkById(s_id);
		return st;
	}
	
	public List<Bunk> findAllBunk() {
		List<Bunk> allSt = bunkDao.findAllBunks();
		return allSt;
	}
	
	public Bunk addBunk(String b_name) {
		Bunk bk = new Bunk();
		bk.setB_name(b_name);
		
		/*  b_id 生成策略
			时间戳
		*/
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String b_id = df.format(d.getTime());
		bk.setB_id(b_id);
		bunkDao.addBunk(b_id, b_name);
		return bk;
	}
	
	@Transactional
	public void deleteBunk(String s_id) {
		bunkDao.deleteBunk(s_id);//待改 增加判断  bunk下挂有stu counselor的不能删除
	}
	
	//待加 模糊查询
}
