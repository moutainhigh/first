package com.deppon.dpm.module.projecttools.server.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 
 * @author 251624
 *
 */
public interface IDppmTaskService {
    /**
     * 获取任务列表
     * @param emCode
     * @param taskId
     * @param taskCategory
     * @return
     * @throws BusinessException
     */
    public Map<String,Object> taskList(String emCode) throws BusinessException;
    
    /**
     * 获取我的任务
     * @param emCode
     * @return
     * @throws BusinessException
     */
    public List<JSONObject> myTask(String emCode)throws BusinessException;
    
    /**
     * 根据任务Id查询2层子任务
     * @param taskIds
     * @return
     * @throws BusinessException
     */
    public List<JSONObject> getSubTaskList(String taskIds)throws BusinessException;
    /**
	 * 任务新建
	 * 2015-10-21  高春玲
	 * @param task 任务实体
	 * @return
	 */
	public int addTask(TasksEntity task) throws BusinessException ;
	
	/**
	 *  2015-11-04
	 *  Title:暂存查询
	 *  @param taskId
	 * */
	public String queryTask(String taskId);
	/**
	 * 任务更新信息
	 * 2015-11-13 高春玲
	 * @param task
	 * @return
	 */
	public int updateTask(TasksEntity task);
	/**
     * 删除任务 修改状态为 1
     * @param taskid
     * @return
     */
	public int delTask(String taskid);
	/**
     * 终止任务 修改状态为 5
     * @param taskid
     * @return
     */
	public int stopTask(String taskid);
}
