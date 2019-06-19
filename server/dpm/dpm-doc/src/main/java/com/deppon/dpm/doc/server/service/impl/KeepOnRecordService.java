package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IKeepOnRecordDao;
import com.deppon.dpm.doc.server.service.IKeepOnRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class KeepOnRecordService implements IKeepOnRecordService{
	
	//注入Dao
	private IKeepOnRecordDao keepOnRecordDao;
	

	public IKeepOnRecordDao getKeepOnRecordDao() {
		return keepOnRecordDao;
	}
	
	public void setKeepOnRecordDao(IKeepOnRecordDao keepOnRecordDao) {
		this.keepOnRecordDao = keepOnRecordDao;
	}

	
	/**
	 * 根据备案人ID查询
	 * lvdf
	 */
	@Override
	public List<DiDiRecordVO>  queryKeepRecordById(String userId) {
		return keepOnRecordDao.queryKeepRecordById(userId);
	}


	/**
	 * 查询全部
	 */
	@Override
	public List<DiDiRecordVO> queryAllDidiRecord() {	
		return keepOnRecordDao.queryAllDidiRecord();
	}


	/**
	 * Mobile根据条件和起始位置查询
	 */
	@Override
	public List<DiDiRecordVO> queryRecordByConditionMobile(DiDiRecordVO diDiRecord,int requestbeginNum,int limit) {
		return keepOnRecordDao.queryRecordByConditionMobile(diDiRecord,requestbeginNum,limit);
	}

	
	/**
	 * pc端根据条件查询和起始位置查询
	 */
	@Override
	public List<DiDiRecordVO> queryRecordByConditionPC(DiDiRecordVO diDiRecord,int requestbeginNum, String starttime, String endtime,int limit) {
		return keepOnRecordDao.queryRecordByConditionPC(diDiRecord,requestbeginNum,starttime,endtime,limit);
	}


	/**
	 * Mobile端根据条件返回list(无时间条件)
	 */
	@Override
	public List<DiDiRecordVO> queryAllDidiRecordByConditionIntMobile(DiDiRecordVO diDiRecord) {
		return keepOnRecordDao.queryAllDidiRecordByConditionIntMobile(diDiRecord);
	}

	/**
	 * PC端根据条件返回list(有时间条件)
	 */
	@Override
	public List<DiDiRecordVO> queryAllDidiRecordByConditionIntPC(DiDiRecordVO diDiRecord, String starttime, String endtime) {
		return keepOnRecordDao.queryAllDidiRecordByConditionIntPC(diDiRecord,starttime,endtime);
	}

	@Override
	public List<DiDiRecordVO> queryRecordAll(String userId, String recordtype,
			String recordstate) {
		// TODO Auto-generated method stub
		return keepOnRecordDao.queryRecordAll(userId, recordtype, recordstate);
	}

	@Override
	public List<DiDiRecordVO> query(String userId, String recordtype,
			String recordstate, int beginNum, int limit) {
		// TODO Auto-generated method stub
		return keepOnRecordDao.query(userId, recordtype, recordstate, beginNum, limit);
	}



	

	


	

}
