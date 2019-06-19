package com.deppon.dpm.store.server.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.store.server.dao.ITaskManageDao;
import com.deppon.dpm.store.server.service.ITaskManageService;
@Transactional
public class TaskManageService implements ITaskManageService{
	
	//注入Dao
	private ITaskManageDao taskManageDao;
	
	/**
	 * 删除任务(修改状态)
	 * @author lvdefu
	 * @date   2018年8月3日16:04:08
	 * @param  taskId
	 * @return null
	 */
	@Override
	public void deleteTaskByTaskId(String taskId) {
		try {
			//修改主任务状态
			taskManageDao.deleteTaskByTaskId(taskId);
			//修改子任务状态
			taskManageDao.deleteSubTaskByTaskId(taskId);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	/**
	 * 查询主任务下所有子任务状态,只有子任务全部为待考评的任务才能删除
	 * @author lvdf
	 * @date   2018年8月3日16:56:27
	 * @param  taskId
	 * @return
	 */
	@Override
	public boolean querySubTaskState(String taskId) {
		boolean state=taskManageDao.querySubTaskState(taskId);
		return state;
	}

	public ITaskManageDao getTaskManageDao() {
		return taskManageDao;
	}

	public void setTaskManageDao(ITaskManageDao taskManageDao) {
		this.taskManageDao = taskManageDao;
	}

}
