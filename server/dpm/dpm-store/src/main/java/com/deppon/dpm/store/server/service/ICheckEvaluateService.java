package com.deppon.dpm.store.server.service;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;

public interface ICheckEvaluateService {
	/**
	 * 根据主任务ID查询主任务
	 * @author lvdefu
	 * @date   2018年6月4日19:34:22
	 * @param  integer
	 * @return StoreTask
	 */
	StoreTask queryTaskByTaskid(Integer taskId);
	/**
	 * 据营业部ID数组查询子任务
	 * @author lvdefu
	 * @date    2018年6月6日14:34:43
	 * @param   listBusiness
	 * @param userId 
	 * @param deptName 
	 * @return  List<StoreTaskSublist>
	 */
	List<StoreTaskSublist> querySubTasksByArray(ArrayList<String> listBusiness, String userId, String deptName);
}
