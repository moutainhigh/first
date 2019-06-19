package com.deppon.dpm.store.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.store.server.dao.ICheckEvaluateDao;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.ICheckEvaluateService;

public class CheckEvaluateService implements ICheckEvaluateService{

	/**
	 * 注入考核评价Dao
	 */
	private ICheckEvaluateDao CheckEvaluateDao;
	
	/**
	 * 根据主任务ID查询主任务
	 * @author lvdefu
	 * @date   2018年6月4日19:34:22
	 * @param  taskid
	 * @return StoreTask
	 */
	@Override
	public StoreTask queryTaskByTaskid(Integer taskid) {
		return CheckEvaluateDao.queryTaskByTaskid(taskid);
	}
	/**
	 * 据营业部ID数组查询子任务
	 * @@author lvdefu
	 * @date    2018年6月6日14:34:43
	 * @param   listBusiness
	 * @return  List<StoreTaskSublist>
	 */
	@Override
	public List<StoreTaskSublist> querySubTasksByArray(ArrayList<String> listBusiness, String userId,String deptName){
		return CheckEvaluateDao.querySubTasksByArray(listBusiness,userId,deptName);
	}
	
	public ICheckEvaluateDao getCheckEvaluateDao() {
		return CheckEvaluateDao;
	}

	public void setCheckEvaluateDao(ICheckEvaluateDao checkEvaluateDao) {
		CheckEvaluateDao = checkEvaluateDao;
	}
}
