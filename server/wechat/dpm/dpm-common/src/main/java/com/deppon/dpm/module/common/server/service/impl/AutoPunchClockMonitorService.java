package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IAutoPunchClockMonitorDao;
import com.deppon.dpm.module.common.server.service.IAutoPunchClockMonitorService;
import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;

/**
 * 自动打卡监控service
 */
public class AutoPunchClockMonitorService implements IAutoPunchClockMonitorService{
	
	// dao
	private IAutoPunchClockMonitorDao autoPunchClockMonitorDao;
	
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
			IAutoPunchClockMonitorDao autoPunchClockMonitorDao) {
		this.autoPunchClockMonitorDao = autoPunchClockMonitorDao;
	}
}
