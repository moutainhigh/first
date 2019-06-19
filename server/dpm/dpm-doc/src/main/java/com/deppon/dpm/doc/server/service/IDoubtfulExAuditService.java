package com.deppon.dpm.doc.server.service;

import java.util.List;

import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;

public interface IDoubtfulExAuditService {

	/**
	 * 新增疑似异常数据
	 */
	public int insertExceptionMethod(AbnormalOrderEntity entity);
	
	/**
	 * 用户查询审核结果(用户筛选)
	 * 查询结果筛选，默认数据
	 * @param aa 
	 * @param beginNum 
	 */
	public List<AbnormalOrderEntity> userQueryMethod(String userId,String recordstate, String remark ,int beginNum, int aa);
	
	/**
	 * 员工所有数据
	 */
	public List<AbnormalOrderEntity> auditedQueryMethod(String userId,String recordstate);
	/**
	 * 员工审核结果
	 */
	public List<AbnormalOrderEntity> empQueryResult(String userId,String recordstate, int beginNum, int aa);
	
	/**
	 * 领导查询所有数据
	 */
	public List<AbnormalOrderEntity> leaderQueryMethod(String userId,String recordstate);
	
	/**
	 * 管理族群点击我审核，默认带出‘待我审核’数据
	 */
	public List<AbnormalOrderEntity> auditedMinMethod(String userId,String recordstate, int beginNum, int aa);
	
	/**
	 * 管理族群我审核结果页签
	 */
	public List<AbnormalOrderEntity> auditedMethodResult(String userId,String recordstate, int beginNum, int aa);
	
	/**
	 * 管理族群点击我审核更新
	 */
	public int auditedMethodUpdate(String id,String recordstate);
	
	public List<AbnormalOrderEntity> allAuditedDataScreen(String userId,String recordstate, String subordinate);
	
	public List<AbnormalOrderEntity> auditedDataScreen(String userId,String recordstate, String subordinate, int beginNum, int aa);
	/**
	 * 员工反馈接口
	 */
	public int auditedUpdateById(String id , String comment , String recordpic);
	
	public List<AbnormalOrderEntity> auditedQuertInitial(String userId, int beginNum, int aa);
	
	/**
	 * 其他公务转办功能
	 */
	public int transferMethod(String userId , String leadernum , String leadernumName);
	/**
	 * 跟新异常数据的状态
	 */
	public int updateRecordErrorStatus();
	
	/**
	 * 根据如期查询出当月的未审核数据
	 * @return List<OtherOffDutiesEntity>
	 */
	public List<AbnormalOrderEntity> queryBydate(String date);
	//查询该用户所有数据（待审核和带我审核）
	public List<AbnormalOrderEntity> allList(String userId);
	
	//查询用户排班状态
	public String queryScheduleState(String userId);
	
	//插入用户排班信息
	public int insertScheduleState(List stateList);
	
	//查询当天是否有推送消息
	public int selectScheduleState();
	
	//删除前15天的排班数据
	public void deleteScheduleState();
}
