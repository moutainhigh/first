package com.deppon.dpm.store.server.service.impl;

import com.deppon.dpm.store.server.dao.IStoreDynamicsDao;
import com.deppon.dpm.store.server.entity.StoreDynamics;
import com.deppon.dpm.store.server.service.IStoreDynamicsService;
/**
 * 
 * @author RY
 *
 */
public class StoreDynamicsService implements IStoreDynamicsService {
	//注入Dao
	private IStoreDynamicsDao storeDynamicsDao;
	/**
	 * 
	 * @return
	 */
	public IStoreDynamicsDao getStoreDynamicsDao() {
		return storeDynamicsDao;
	}
	/**
	 * 
	 * @param storeDynamicsDao
	 */
	public void setStoreDynamicsDao(IStoreDynamicsDao storeDynamicsDao) {
		this.storeDynamicsDao = storeDynamicsDao;
	}

	
	/**
	 * @author XiaoTian
	 * 添加任务操作日志
	 */
	@Override
	public int insertSelective(StoreDynamics record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
