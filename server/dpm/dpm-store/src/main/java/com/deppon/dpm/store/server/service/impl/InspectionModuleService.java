package com.deppon.dpm.store.server.service.impl;

import java.util.List;

import com.deppon.dpm.store.server.dao.IInspectionModuleDao;
import com.deppon.dpm.store.server.dao.IStoreMarkDao;
import com.deppon.dpm.store.server.dao.IStoreTaskSublistDao;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.IInspectionModuleService;

public class InspectionModuleService implements IInspectionModuleService{
	
	//注入InspectionModuleDao 
	private IInspectionModuleDao InspectionModuleDao;
	
	//注入IStoreMarkDao模块打分
	private IStoreMarkDao StoreMarkDao;

	//注入子任务Dao
	private IStoreTaskSublistDao StoreTaskSublistDao;
	
	/**
	 * 查询主任务
	 */
	@Override
	public StoreTask querTask(Integer taskId) {
		return InspectionModuleDao.querTask(taskId);
	}
	/**
	 * 根据执行id查询主任务id
	 */
	@Override
	public String queryTaskidByExeid(Long exeid) {
		return InspectionModuleDao.queryTaskidByExeid(exeid);
	}
	
	/**
	 * 根据子任务的执行id查询巡检模块
	 * @author lvdefu
	 * @date   2018年5月31日11:41:24
	 * @param  exeid
	 * @return List<StoreMod>
	 */
	@Override
	public List<StoreMark> queryModule(Long exeid) {
		return InspectionModuleDao.queryModule(exeid);
	}
	/**
	 * 根据主任务Id查询子任务,根据执行人分组
	 * @author lvdefu
	 * @date   2018年6月5日17:12:09
	 * @param  taskId
	 * @return List<StoreTaskSublist>
	 */
	@Override
	public List<StoreTaskSublist> querySubtasksGroup(Integer taskId) {
		return InspectionModuleDao.querySubtasksGroup(taskId);
	}
	
	/**
	 * 根据执行人Id查询子任务
	 * @author lvdefu
	 * @date   2018年6月5日17:12:19
	 * @param  exeerId
	 * @return List<StoreTaskSublist>
	 */
	@Override
	public List<StoreTaskSublist> querySubtasksByExeerId(String exeerId, Integer taskId) {
		return InspectionModuleDao.querySubtasksByExeerId(exeerId,taskId);
	}
	/**
	 * 根据执行ID查询巡检模块
	 * @author lvdefu
	 * @date   2018年6月5日17:25:25
	 * @param  exeid
	 * @return List<StoreMod>
	 */
	@Override
	public List<StoreMark> queryModByExeid(Long exeid) {
		return InspectionModuleDao.queryModByExeid(exeid);
	}
	
	
	public IInspectionModuleDao getInspectionModuleDao() {
		return InspectionModuleDao;
	}

	public void setInspectionModuleDao(IInspectionModuleDao inspectionModuleDao) {
		InspectionModuleDao = inspectionModuleDao;
	}



	public IStoreMarkDao getStoreMarkDao() {
		return StoreMarkDao;
	}

	public void setStoreMarkDao(IStoreMarkDao storeMarkDao) {
		StoreMarkDao = storeMarkDao;
	}

	public IStoreTaskSublistDao getStoreTaskSublistDao() {
		return StoreTaskSublistDao;
	}

	public void setStoreTaskSublistDao(IStoreTaskSublistDao storeTaskSublistDao) {
		StoreTaskSublistDao = storeTaskSublistDao;
	}

}
