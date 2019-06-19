package com.deppon.dpm.module.management.server.dao;

import java.util.Date;
import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcCheckPCEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;
import com.deppon.dpm.module.management.shared.domain.TaskCheckEntity;

/**
 * 
 * @author 王亚男
 * 任何与记录查询相关的
 */
public interface IProcRecordDao {
	
	/**
	 * 分页查询task数据
	 * @return
	 */
	public List<ProcCheckTaskEntity> getTaskList(int pageNum,int pageSize,String deptName,String userId);
	
	/**
	 * 推送任务总数
	 * @return
	 */
	public int getCount(String deptName,String userId);
	
	/**
	 * 根据项目编码获得扣分详细
	 * @param number 项目编码
	 * @return
	 */
	public List<ProcCheckPCEntity> getProcCheckList(String number);
	
	/**
	 * 获得初次更新时间
	 * @param number 项目编码
	 * @return
	 */
	public Date getFirstUpdateTime(String number);
	
	/**
	 * 获得最终更新时间
	 * @param number 项目编码
	 * @return
	 */
	public Date getLastUpdateTime(String number);
	
	/**
	 * 获得每次提交的总分
	 * @param submitNub 1--初次提交,2--最终提交
	 * @param number 项目编码
	 * @return 总分
	 */
	public int getScoreFirstOrLast(int submitNub,String number);
	
	/**
	 * 查询任务是否存在
	 * @param deptCode 项目编号
	 * @return true 存在; false 不存在
	 */
	public int hasTask(String deptCode);
	
	/**
	 * 添加任务信息
	 * @param entity
	 */
	public int addTask(TaskCheckEntity entity);
	
	/**
	 * 最终提交修改时间
	 * @param date 修改时间
	 */
	public void updateLastTime(Date date,String number);
	
	/**
	 * 查询项目编号是否已经提交给PC端
	 * @param number
	 * @return
	 */
	public int getTaskStatus(String number);
	
	/**
	 * 修改历史记录最终提交状态
	 * @param number 项目编号
	 * @return
	 */
	public boolean updateRecordStatus(String number);
}
