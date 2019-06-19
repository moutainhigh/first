package com.deppon.dpm.store.server.dao.impl;

import java.util.List;

import com.deppon.dpm.store.server.dao.ITaskManageDao;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class TaskManageDao extends iBatis3DaoImpl implements ITaskManageDao{
	
	//主任务名称空间
	private static final String NAME_SPACE_TASK="com.deppon.dpm.store.server.dao.IStoreTaskDao.";
	
	//子任务名称空间
	private static final String NAME_SPACE_SUBTASK="com.deppon.dpm.store.server.dao.IStoreTaskSublistDao.";
	
	/**
	 * 删除任务(修改主任务状态)
	 * @author lvdefu
	 * @date   2018年8月3日16:04:08
	 * @param  taskId
	 * @return null
	 */
	@Override
	public void deleteTaskByTaskId(String taskId) {
		getSqlSession().update(NAME_SPACE_TASK+"deleteTaskByTaskId", Integer.parseInt(taskId));
	}

	/**
	 * 删除任务(修改子任务任务状态)
	 * @author lvdefu
	 * @date   2018年8月3日16:04:08
	 * @param  taskId
	 * @return null
	 */
	@Override
	public void deleteSubTaskByTaskId(String taskId) {
		getSqlSession().update(NAME_SPACE_SUBTASK+"deleteSubTaskByTaskId", Integer.parseInt(taskId));
		
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
		int stateCount=(Integer) getSqlSession().selectOne(NAME_SPACE_SUBTASK+"querySubTaskState", Integer.parseInt(taskId));
		if(stateCount==0){
			return true;
		}else{
			return false;
		}
	}

}
