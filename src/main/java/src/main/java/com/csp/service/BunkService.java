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
	
	public Bunk findBunkById(String bunkId) {
		Bunk st = bunkDao.findBunkById(bunkId);
		return st;
	}
	
	public List<Bunk> findAllBunks() {
		List<Bunk> allSt = bunkDao.findAllBunks();
		return allSt;
	}
	
	public Bunk addBunk(String bunkName) {
		Bunk bk = new Bunk();
		bk.setBunkName(bunkName);
		
		/*  bunkId 生成策略
			时间戳
		*/
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String bunkId = df.format(d.getTime());
		bk.setBunkId(bunkId);
		bunkDao.addBunk(bunkId, bunkName);
		return bk;
	}
	
	@Transactional
	public void deleteBunkById(String bunkId) {
		bunkDao.deleteBunk(bunkId);//待改 增加判断  bunk下挂有stu counselor的不能删除
	}
	
	//待加 模糊查询
}
