package com.deppon.dpm.store.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.dao.IStoreTaskSublistDao;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.IStoreTaskSublistService;
/**
 * 
 * @author XiaoTian
 *
 */
public class StoreTaskSublistService implements IStoreTaskSublistService {
	//注入dao
	private IStoreTaskSublistDao storeTaskSublistDao;
	
	/**
	 * 
	 * @return
	 */
	public IStoreTaskSublistDao getStoreTaskSublistDao() {
		return storeTaskSublistDao;
	}
	/**
	 * 
	 * @param storeTaskSublistDao
	 */
	public void setStoreTaskSublistDao(IStoreTaskSublistDao storeTaskSublistDao) {
		this.storeTaskSublistDao = storeTaskSublistDao;
	}
	@Override
	public int updateByPrimaryKeySelective(StoreTaskSublist record) {
		// TODO Auto-generated method stub
		return storeTaskSublistDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<StoreTaskSublist> insertSelectives(
			ArrayList<StoreTaskSublist> record) {
		// TODO Auto-generated method stub
		return storeTaskSublistDao.insertSelectives(record);
	}
}
