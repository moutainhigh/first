package com.deppon.dpm.module.projecttools.server.service;

import com.deppon.dpm.module.projecttools.shared.domain.TaskLogEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 任务管理 任务详情======任务日志跟踪和任务详细信息查询 service
 * @author gcl
 */
public interface ITaskLogService {
	
	/**
	 * 任务详情信息查询
	 * @return
	 * @throws BusinessException
	 */
	public String queryLog(int taskid) throws BusinessException;
	
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
	 * 邮件 提醒    新增任务跟踪日志后发送给提醒人
	 * @param log
	 */
	public void mailSend(TaskLogEntity log);
	/**
	 * 邮件 提醒    新增任务时分配任务给任务处理人发送给处理人
	 * @param task
	 */
	public void mailSendTask(TasksEntity task);
	/**
	 * 项目变更
	 * 审批同意后 变更内容为里程碑、关键节点或结项时间系统自动发邮件至项目组织中所有的执行个人
	 * @param toEmail
	 * @param title
	 * @param info
	 */
	public void mailToExecutor(String[] toEmail,String title,String info);
}
