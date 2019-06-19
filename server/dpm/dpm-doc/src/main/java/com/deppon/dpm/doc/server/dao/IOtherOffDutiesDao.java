package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;

/**
 * 其他公务接口
 * @author Administrator
 *
 */
public interface IOtherOffDutiesDao {
	
	/**
	 * 新增其他公务审核数据
	 */
	public int insertOtherMethod(OtherOffDutiesEntity entity);
	
	/**
	 * 用户查询审核结果(用户筛选)
	 * @param aa 
	 * @param beginNum 
	 */
	public List<OtherOffDutiesEntity> userQueryMethod(String userId,String recordstate, int beginNum, int aa);
	/**
	 * 员工所有数据
	 */
	public List<OtherOffDutiesEntity> auditedQueryMethod(String userId,String recordstate);
	
	/**
	 * 员工审核结果
	 */
	public List<OtherOffDutiesEntity> empQueryResult(String userId,String recordstate, int beginNum, int aa);
	
	/**
	 * 领导查询所有数据
	 */
	public List<OtherOffDutiesEntity> leaderQueryResult(String userId,String recordstate);
	
	/**
	 * 部门管理组群查询审核结果（管理族群筛选）
	 */
	public List<OtherOffDutiesEntity> leaderQueryMethod(String userId,String recordstate, int beginNum, int aa);
	
	/**
	 * 管理族群点击我审核，默认带出‘待我审核’数据,筛选
	 */
	public List<OtherOffDutiesEntity> auditedMinMethod(String userId,String recordstate, int beginNum, int aa);
	
	/**
	 * 其他公务管理族群点击我审核更新
	 */
	public int auditedMethodUpdate(String userId,String recordstate);
	
	public List<OtherOffDutiesEntity> allAuditedDataScreen(String userId,String recordstate, String subordinate);
	
	public List<OtherOffDutiesEntity> auditedDataScreen(String userId,String recordstate, String subordinate, int beginNum, int aa);
	/**
	 * 其他公务转办功能
	 */
	public int transferMethod(String userId , String leadernum ,String leadernumName);

	/**
	 * 跟新错误状态
	 */
	public int updateRecordErrorStatus();
	
	/**
	 * 根据如期查询出当月的未审核数据
	 * @return List<OtherOffDutiesEntity>
	 */
	public List<OtherOffDutiesEntity> queryBydate(String date);
	
	//查询该用户所有数据（待审核和带我审核）
	public List<OtherOffDutiesEntity> allList(String userId);
	
	/**
	 * 查询某个领导超过三天未审批的疑似异常数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval1(String userId);
	
	/**
	 * 查询某个领导超过三天未审批的其他公务数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval2(String userId);

	/**
	 * 查询某个领导未审批的疑似异常数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval01(String userId);
	
	/**
	 * 查询某个领导未审批的其他公务数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval02(String userId);
}
