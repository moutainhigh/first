package com.deppon.dpm.module.projecttools.server.dao;

import java.util.Map;

import com.deppon.dpm.module.projecttools.shared.domain.TaskLogEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;


/**
 * 
 * 任务管理 任务详情  任务跟踪日志 Interface
 *
 * @author 195406 高春玲
 * @date 2015-8-8 下午1:45:08
 **/
public interface ITaskLogDao {
	/**
	 * @author 195406 高春玲
	 * @date 2015-8-8 下午1:45:08
	 */
	public Map<String, Object> queryLog(int taskid);
	/**
	 * 新增任务跟踪日志
	 * @param e 日志实体
	 * @return 是否保存成功
	 */
	public int addtasklog(TaskLogEntity e);
	/**
	 * 我的待办任务
	 * @param userId 用户工号
	 */
	public String queryMytask(String userId);
	/**
	 * 根据任务编号 获得任务名称和任务所属项目名称
	 * @param taskid
	 * @return
	 */
	public TasksEntity queryTaskById(int taskid);
}
