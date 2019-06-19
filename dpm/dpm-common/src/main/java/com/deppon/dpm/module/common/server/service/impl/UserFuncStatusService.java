package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IUserFuncStatusDao;
import com.deppon.dpm.module.common.server.service.IUserFuncStatusService;
import com.deppon.dpm.module.common.shared.domain.UserFuncStatusEntity;

public class UserFuncStatusService implements IUserFuncStatusService{
	
	// dao
	private IUserFuncStatusDao userFuncStatusDao;

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		userFuncStatusDao.delete(id);
	}
	
	/**
	 * 更新
	 */
	public void update(UserFuncStatusEntity entity) {
		userFuncStatusDao.update(entity);
	}
	
	/**
	 * 保存
	 */
	public void insert(UserFuncStatusEntity entity) {
		userFuncStatusDao.insert(entity);
	}
	
	/**
	 * 根据工号查询
	 */
	public List<UserFuncStatusEntity> queryByUserId(String userId) {
		return userFuncStatusDao.queryByUserId(userId);
	}
	
	// setter
	public void setUserFuncStatusDao(IUserFuncStatusDao userFuncStatusDao) {
		this.userFuncStatusDao = userFuncStatusDao;
	}

}
