package com.deppon.dpm.module.main.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.main.server.dao.IAutoPunchClockMonitorGlobalDao;
import com.deppon.dpm.module.main.server.service.IAutoPunchClockMonitorGlobalService;

/**
 * 自动打卡监控service
 */
public class AutoPunchClockMonitorGlobalService implements IAutoPunchClockMonitorGlobalService{
	
	// dao
	private IAutoPunchClockMonitorGlobalDao autoPunchClockMonitorDao;
	
	// 保存
	public void save(AutoPunchClockMonitorEntity entity) {
		autoPunchClockMonitorDao.save(entity);
	}
	
	// 分页查询
	public List<NativePushCfgEntity> queryByPage(int start, int rows,String empCode) {
		return autoPunchClockMonitorDao.queryByPage(start,rows,empCode);
	}
	
	// 查询数量
	public long queryCount(String empCode) {
		return autoPunchClockMonitorDao.queryCount(empCode);
	}

	// setter
	public void setAutoPunchClockMonitorDao(
			IAutoPunchClockMonitorGlobalDao autoPunchClockMonitorDao) {
		this.autoPunchClockMonitorDao = autoPunchClockMonitorDao;
	}
}
