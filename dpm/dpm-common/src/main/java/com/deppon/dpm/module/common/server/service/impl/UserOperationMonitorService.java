package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IUserOperationMonitorDao;
import com.deppon.dpm.module.common.server.service.IUserOperationMonitorService;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorTypeEntity;

public class UserOperationMonitorService implements IUserOperationMonitorService{
	
	// service
	private IUserOperationMonitorDao userOperationMonitorDao;

	// 保存
	public void save(UserOperationMonitorEntity entity) {
		userOperationMonitorDao.save(entity);
	}
	
	// 查询
	public List<UserOperationMonitorEntity> queryByUserIdAndTime(
			int start, int rows, UserOperationMonitorEntity entity) {
		return userOperationMonitorDao.queryByUserIdAndTime(start,rows,entity);
	}
	
	public List<UserOperationMonitorTypeEntity> queryUserOperationMonitorType() {
		return userOperationMonitorDao.queryUserOperationMonitorType();
	}
	
	public long queryCount(UserOperationMonitorEntity entity) {
		return userOperationMonitorDao.queryCount(entity);
	}
	
	// setter
	public void setUserOperationMonitorDao(
			IUserOperationMonitorDao userOperationMonitorDao) {
		this.userOperationMonitorDao = userOperationMonitorDao;
	}

}
