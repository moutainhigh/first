package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IUserFuncMonitorDao;
import com.deppon.dpm.module.common.server.service.IUserFuncMonitorService;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.domain.UserFuncMonitorEntity;

public class UserFuncMonitorService implements IUserFuncMonitorService{
	
	// dao
	private IUserFuncMonitorDao userFuncMonitorDao;
	
	/**
	 * 保存
	 */
	public void save(UserFuncMonitorEntity entity) {
		userFuncMonitorDao.save(entity);
	}
	
	/**
	 * 根据工号分页查询
	 */
	public List<NativePushCfgEntity> queryByPage(int start, int rows,
			String userId) {
		return userFuncMonitorDao.queryByPage(start,rows,userId);
	}
	
	/**
	 * 查询总数
	 */
	public long queryCount(String userId) {
		return userFuncMonitorDao.queryCount(userId);
	}
	
	// setter
	public void setUserFuncMonitorDao(IUserFuncMonitorDao userFuncMonitorDao) {
		this.userFuncMonitorDao = userFuncMonitorDao;
	}

}
