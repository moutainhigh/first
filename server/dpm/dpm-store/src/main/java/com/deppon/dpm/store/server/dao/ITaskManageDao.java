package com.deppon.dpm.store.server.dao;

public interface ITaskManageDao {
	/**
	 * 删除任务(修改主状态)
	 * @author lvdefu
	 * @date   2018年8月3日16:04:08
	 * @param  taskId
	 * @return null
	 */
	void deleteTaskByTaskId(String taskId);
	/**
	 * 删除任务(修改子状态)
	 * @author lvdefu
	 * @date   2018年8月3日16:04:08
	 * @param  taskId
	 * @return null
	 */
	void deleteSubTaskByTaskId(String taskId);
	/**
	 * 查询主任务下所有子任务状态,只有子任务全部为待考评的任务才能删除
	 * @author lvdf
	 * @date   2018年8月3日16:56:27
	 * @param  taskId
	 * @return
	 */
	boolean querySubTaskState(String taskId);

}
