package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IpunchClockDao;
import com.deppon.dpm.module.management.server.service.IpunchClockService;
import com.deppon.dpm.module.management.shared.domain.PunchClockEntity;

public class PunchClockService implements IpunchClockService {
    
	private IpunchClockDao punchClockDao;
	/**
	 * 打卡考勤
	 * @author 276344
	 *
	 */
	@Override
	public int syncRecord() {
		// TODO Auto-generated method stub
		return punchClockDao.syncRecord();
	}
	/**
	 * 查询打卡记录
	 * @author 276344
	 *
	 */
	@Override
	public PunchClockEntity getPunchClockRecord(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return punchClockDao.getPunchClockRecord(map);
	}
	@Override
	public int createRecord(Map<String,Object> map) {
		return punchClockDao.createRecord(map);
	}
	@Override
	public int updateRecord(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return punchClockDao.updateRecord(map);
	}
	
	@Override
	public List<PunchClockEntity> getPunchClockRecordList(String userId) {
		// TODO Auto-generated method stub
		return punchClockDao.getPunchClockRecordList(userId);
	}
	public IpunchClockDao getPunchClockDao() {
		return punchClockDao;
	}
	public void setPunchClockDao(IpunchClockDao punchClockDao) {
		this.punchClockDao = punchClockDao;
	}
	
	
	

}
