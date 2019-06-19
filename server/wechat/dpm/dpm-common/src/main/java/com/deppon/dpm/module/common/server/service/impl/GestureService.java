package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.IGestureDao;
import com.deppon.dpm.module.common.server.service.IGestureService;
import com.deppon.dpm.module.common.shared.domain.GestureEntity;

/**
 * 手势密码
 *
 */
public class GestureService implements IGestureService{
	
	// dao
	private IGestureDao gestureDao;

	// 根据工号查询
	public GestureEntity queryByEmpcode(String userId) {
		return gestureDao.queryByEmpcode(userId);
	}

	// 根据工号删除
	public void deleteByEmpcode(String userId) {
		gestureDao.deleteByEmpcode(userId);
	}
	
	// 更新
	public void update(GestureEntity entity) {
		gestureDao.update(entity);
	}
	
	// setter
	public void setGestureDao(IGestureDao gestureDao) {
		this.gestureDao = gestureDao;
	}

}
