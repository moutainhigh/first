package com.deppon.dpm.module.projecttools.server.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;

public interface IDppmTaskDao {
    
    /**
     * 判断工号是不是PMO
     * @param emCode
     *         工号
     * @return
     * @throws Exception
     */
    public boolean isPMOByEmCode(String emCode)throws Exception;
    
    /**
     * 获取项目的信息
     * @param isPmo
     * @param emCode
     * @return
     * @throws Exception
     */
    public Map<String,JSONObject> getProjectInfoMap(boolean isPmo, String emCode)throws Exception;
    
    /**
     * 获取首次进入任务列表的任务信息
     * @param isPmo
     * @param emCode
     * @throws Exception
     */
    public List<JSONObject> getTaskList(boolean isPmo, String emCode)throws Exception;
    
    /**
     * 获取我的任务
     * @param emCode
     * @return
     * @throws Exception
     */
    public List<JSONObject> getMyTask(String emCode)throws Exception;
    
    /**
     * 根据任务的Id查询此任务下的两层子集
     * @param taskIds
     * @param taskCategory
     * @return
     * @throws Exception
     */
    public Map<String,JSONObject> getSubTaskMap(String taskId)throws Exception;
    
    /**
     *  获取需要审核的任务数
     * @return
     * @throws Exception
     */
    public int getTaskCommitCount(String emCode)throws Exception;
    
    /**
     * 获取部门领导下的员工的任务
     * @return
     * @throws Exception
     */
    public Map<String,JSONObject> getDeptMemberTask(String emCode)throws Exception;
    /**
	 * 任务新建
	 * 2015-10-21  高春玲
	 * @param task 任务实体
	 * @return
	 */
	public int addTask(TasksEntity task) throws Exception ;
	/**
	 *  2015-11-04
	 *  Title:暂存查询
	 *  @param taskId
	 * */
	public List<TasksEntity> queryTask(String taskId);
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
	
	/** 
	 * 根据项目编码获取问题风险任务可分配工时
	 * 
	 * 2016-03-24
	 */
	public String getAssignableHour(String projCode);
	
	/**
	 * 更新问题风险状态
	 * 2016-3-29
	 * @param riskId
	 * @return
	 */
	public int updateRiskStatus(int riskId);
}
