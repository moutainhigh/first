package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IOtherOffDutiesDao;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;

public class OtherOffDutiesService implements IOtherOffDutiesService{
	
	private IOtherOffDutiesDao otherOffDutiesDao;
	/**
	 * 用户查询审核结果(用户筛选)
	 * 查询结果筛选，默认数据
	 * @param aa 
	 * @param beginNum 
	 */
	@Override
	public List<OtherOffDutiesEntity> userQueryMethod(String userId,
			String recordstate, int beginNum, int aa) {

		return otherOffDutiesDao.userQueryMethod(userId, recordstate, beginNum, aa);
	}
	/**
	 * 员工所有数据
	 */
	@Override
	public List<OtherOffDutiesEntity> auditedQueryMethod(String userId,
			String recordstate) {

		return otherOffDutiesDao.auditedQueryMethod(userId, recordstate);
	}
	/**
	 * 员工审核结果
	 */
	@Override
	public List<OtherOffDutiesEntity> empQueryResult(String userId,
			String recordstate, int beginNum, int aa) {
		return otherOffDutiesDao.empQueryResult(userId, recordstate, beginNum, aa);
	}

	@Override
	public List<OtherOffDutiesEntity> leaderQueryResult(String userId,
			String recordstate) {
		return otherOffDutiesDao.leaderQueryResult(userId, recordstate);
	}

	@Override
	public List<OtherOffDutiesEntity> leaderQueryMethod(String userId,
			String recordstate, int beginNum, int aa) {
		return otherOffDutiesDao.leaderQueryMethod(userId, recordstate, beginNum, aa);
	}

	@Override
	public List<OtherOffDutiesEntity> auditedMinMethod(String userId,
			String recordstate, int beginNum, int aa) {
		return otherOffDutiesDao.auditedMinMethod(userId, recordstate, beginNum, aa);
	}
	/**
	 * 更新
	 */
	@Override
	public int auditedMethodUpdate(String id, String recordstate) {
		
		return otherOffDutiesDao.auditedMethodUpdate(id, recordstate);
	}
	/**
	 * 新增
	 */
	@Override
	public int insertOtherMethod(OtherOffDutiesEntity entity) {
		return otherOffDutiesDao.insertOtherMethod(entity);
	}

	/**
	 * @return the otherOffDutiesDao
	 */
	public IOtherOffDutiesDao getOtherOffDutiesDao() {
		return otherOffDutiesDao;
	}

	/**
	 * @param otherOffDutiesDao the otherOffDutiesDao to set
	 */
	public void setOtherOffDutiesDao(IOtherOffDutiesDao otherOffDutiesDao) {
		this.otherOffDutiesDao = otherOffDutiesDao;
	}
	@Override
	public List<OtherOffDutiesEntity> allAuditedDataScreen(String userId,
			String recordstate, String subordinate) {
		// TODO Auto-generated method stub
		return otherOffDutiesDao.allAuditedDataScreen(userId, recordstate, subordinate);
	}
	@Override
	public List<OtherOffDutiesEntity> auditedDataScreen(String userId,
			String recordstate, String subordinate, int beginNum, int aa) {
		// TODO Auto-generated method stub
		return otherOffDutiesDao.auditedDataScreen(userId, recordstate, subordinate, beginNum, aa);
	}
	
	public int transferMethod(String userId, String leadernum, String leadernumName) {
		return otherOffDutiesDao.transferMethod(userId, leadernum, leadernumName);
	}
	
	@Override
	public int updateRecordErrorStatus() {
		
		return otherOffDutiesDao.updateRecordErrorStatus();
	}
	@Override
	public List<OtherOffDutiesEntity> queryBydate(String date) {
		// TODO Auto-generated method stub
		return otherOffDutiesDao.queryBydate(date);
	}
	@Override
	public List<OtherOffDutiesEntity> allList(String userId) {
		// TODO Auto-generated method stub
		return otherOffDutiesDao.allList(userId);
	}
	
	/**
	 * 查询某个领导超过三天未审批的疑似异常数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval1(String userId){
		
		return otherOffDutiesDao.getNoApproval1(userId);
	}
	
	/**
	 * 查询某个领导超过三天未审批的其他公务数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval2(String userId){
		
		return otherOffDutiesDao.getNoApproval2(userId);
	}
	
	/**
	 * 查询某个领导未审批的疑似异常数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval01(String userId){
		
		return otherOffDutiesDao.getNoApproval01(userId);
	}
	
	/**
	 * 查询某个领导未审批的其他公务数量
	 * @param userId
	 * @return
	 */
	public int getNoApproval02(String userId){
		
		return otherOffDutiesDao.getNoApproval02(userId);
	}
}
