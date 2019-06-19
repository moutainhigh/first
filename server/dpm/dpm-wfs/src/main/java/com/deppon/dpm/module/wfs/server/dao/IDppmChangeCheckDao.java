package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.projecttools.shared.domain.EmployeeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeCheckEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeEntity;

/**
 * dppm 项目管理 项目变更审批工作流，年度规划路径变更申请工作流 Interface
 * 195406 高春玲
 **/
public interface IDppmChangeCheckDao {
 	/**
	 * 项目变更审核信息获得
	 * @param wfsid 工作流号
	 * @return
	 */
	public Map<String, Object> queryChangeCheckInfo(String wfsid);
	/**
	 * 根据工作流号获得项目变更审核信息
	 * @param wfsid 工作流号
	 * @return
	 */
	public ChangeCheckEntity querychangeCheck(Long wfsid);
	/**
	 * 审批项目变更成功后，如果是年度规划项目新增，就复制变更的数据到正式库
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public int insertYearPlanProj(int aiId)  ;
	/**
	 * 修改年度规划项目表数据
	 * @param aiId
	 * @param oldAiId
	 * @return
	 */
	public int updateTempYearPlan(int aiId,int oldAiId,int ghType);
	/**
	 * 删除年度规划项目信息
	 * @param aiId
	 * @return
	 */
	public int delYearPlan(int aiId);
	/**
	 * 根据版本号
	 * @param version
	 * @param newVersion
	 * @return
	 */
	public int updateProjVersion(String version,String newVersion);
	/**
	 * 删除临时表数据
	 * @param aiids
	 * @return
	 */
	public int delTempYearPlan(int[] aiids);
	/**
	 * 项目状态变为已终止，对应的任务也要终止 终止任务
	 * @param projectCode
	 * @return
	 */
	public int terminateTask(int projectCode);
	/**
	 * 更新项目信息
	 * @param entity
	 * @return
	 */
	public int updateProjInfo(int newAiId,int oldAiId);
	/**
	 * 调用存储过程来更新项目的其他信息
	 * @param oldAiId
	 * @param newAiId
	 */
	public void updateProjOtherInfo(int oldAiId,int newAiId) ;
	/**
	 * 查询是否需要发邮件(是否涉及里程碑、关键节点或结项时间的变更)
	 * @param changeId
	 * @return
	 */
	public int checkIsSendMail(int changeId);
	/**
	 * 获取项目组织中所有的执行个人的邮箱地址
	 * @param aiId
	 * @return
	 */
	public List<String> getOrgsPersonEmails(int aiId);
	/**
	 * 修改变更信息
	 * @param entity
	 * @return
	 */
	public int updateChange(ChangeEntity entity);
	/**
	 * 获取年度规划项目级别 
	 * @param processid
	 * @return
	 */
	public int queryGhLevel(long processid);
	/**
	 * 判断项目是否管理咨询 
	 * @param processid
	 * @return
	 */
	public int queryGhType(long processid);
	/**
	 * 判断项目是否重大变更
	 * @param processid
	 * @return
	 */
	public int queryChangeState(long processid);
	/**
	 * 获取项目发起人
	 * @param processid
	 * @return
	 */
	public EmployeeEntity queryProjectSponsor(long processid);
}
