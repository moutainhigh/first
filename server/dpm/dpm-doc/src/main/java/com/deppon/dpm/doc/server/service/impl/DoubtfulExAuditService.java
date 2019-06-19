package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDoubtfulExAuditDao;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;

/**
 * 疑似异常审核接口
 * @author Administrator
 *
 */

public class DoubtfulExAuditService implements IDoubtfulExAuditService{
	
	private IDoubtfulExAuditDao doubtfulExAuditDao;

	@Override
	public int insertExceptionMethod(AbnormalOrderEntity entity) {
		return doubtfulExAuditDao.insertExceptionMethod(entity);
	}

	@Override
	public List<AbnormalOrderEntity> userQueryMethod(String userId,
			String recordstate, String remark, int beginNum, int aa) {
		return doubtfulExAuditDao.userQueryMethod(userId, recordstate,remark, beginNum, aa);
	}

	@Override
	public List<AbnormalOrderEntity> auditedQueryMethod(String userId,
			String recordstate) {
		return doubtfulExAuditDao.auditedQueryMethod(userId, recordstate);
	}

	@Override
	public List<AbnormalOrderEntity> empQueryResult(String userId,
			String recordstate, int beginNum, int aa) {
		return doubtfulExAuditDao.empQueryResult(userId, recordstate, beginNum, aa);
	}

	@Override
	public List<AbnormalOrderEntity> leaderQueryMethod(String userId,
			String recordstate) {
		return doubtfulExAuditDao.leaderQueryMethod(userId, recordstate);
	}

	@Override
	public List<AbnormalOrderEntity> auditedMinMethod(String userId,
			String recordstate, int beginNum, int aa) {
		return doubtfulExAuditDao.auditedMinMethod(userId, recordstate, beginNum, aa);
	}

	@Override
	public List<AbnormalOrderEntity> auditedMethodResult(String userId,
			String recordstate, int beginNum, int aa) {
		return doubtfulExAuditDao.auditedMethodResult(userId, recordstate, beginNum, aa);
	}

	@Override
	public int auditedMethodUpdate(String id, String recordstate) {
		return doubtfulExAuditDao.auditedMethodUpdate(id, recordstate);
	}

	/**
	 * @return the doubtfulExAuditDao
	 */
	public IDoubtfulExAuditDao getDoubtfulExAuditDao() {
		return doubtfulExAuditDao;
	}

	/**
	 * @param doubtfulExAuditDao the doubtfulExAuditDao to set
	 */
	public void setDoubtfulExAuditDao(IDoubtfulExAuditDao doubtfulExAuditDao) {
		this.doubtfulExAuditDao = doubtfulExAuditDao;
	}

	@Override
	public List<AbnormalOrderEntity> allAuditedDataScreen(String userId,
			String recordstate, String subordinate) {
		return doubtfulExAuditDao.allAuditedDataScreen(userId, recordstate, subordinate);
	}

	@Override
	public List<AbnormalOrderEntity> auditedDataScreen(String userId,
			String recordstate, String subordinate, int beginNum, int aa) {
		return doubtfulExAuditDao.auditedDataScreen(userId, recordstate, subordinate, beginNum, aa);
	}

	@Override
	public int auditedUpdateById(String id, String comment, String recordpic) {
		return doubtfulExAuditDao.auditedUpdateById(id, comment, recordpic);
	}

	@Override
	public List<AbnormalOrderEntity> auditedQuertInitial(String userId,
			int beginNum, int aa) {
		return doubtfulExAuditDao.auditedQuertInitial(userId, beginNum, aa);
	}
	@Override
	public int transferMethod(String userId , String leadernum , String leadernumName) {
		
		return doubtfulExAuditDao.transferMethod(userId, leadernum, leadernumName);
	}
	
	@Override
	public int updateRecordErrorStatus() {
		
		return doubtfulExAuditDao.updateErrorStatus();
	}
	@Override
	public List<AbnormalOrderEntity> queryBydate(String date) {
		// TODO Auto-generated method stub
		return doubtfulExAuditDao.queryBydate(date);
	}

	@Override
	public List<AbnormalOrderEntity> allList(String userId) {
		// TODO Auto-generated method stub
		return doubtfulExAuditDao.allList(userId);
	}

	@Override
	public String queryScheduleState(String userId) {
		
		return doubtfulExAuditDao.queryScheduleState(userId);
	}

	@Override
	public int insertScheduleState(List stateList) {
		
		return doubtfulExAuditDao.insertScheduleState(stateList);
	}

	@Override
	public int selectScheduleState() {

		return doubtfulExAuditDao.selectScheduleState();
	}

	@Override
	public void deleteScheduleState() {
		doubtfulExAuditDao.deleteScheduleState();
		
	}
}
