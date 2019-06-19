package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IPcKeepRecordDao;
import com.deppon.dpm.doc.server.service.IPcKeepRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class PcKeepRecordService implements IPcKeepRecordService{
	
	/**
	 * 注入Dao
	 */
	private IPcKeepRecordDao pcKeepRecordDao;

	public IPcKeepRecordDao getPcKeepRecordDao() {
		return pcKeepRecordDao;
	}

	public void setPcKeepRecordDao(IPcKeepRecordDao pcKeepRecordDao) {
		this.pcKeepRecordDao = pcKeepRecordDao;
	}
	/**
	 * 查询符合条件的记录条数
	 */
	@Override
	public List<DiDiRecordVO> queryRecordAll(DiDiRecordVO diDiRecord,
			String starttime, String endtime) {
		return pcKeepRecordDao.queryRecordAll(diDiRecord,starttime,endtime);
	}
	/**
	 * 无条件查询全部备案的记录
	 */
	@Override
	public List<DiDiRecordVO> queryAllDidiRecord() {
		return pcKeepRecordDao.queryAllDidiRecord();
	}
	/**
	 * 根据条件和起始位置进行查询
	 */
	@Override
	public List<DiDiRecordVO> queryRecordByCondition(DiDiRecordVO diDiRecord,
			int requestbeginNum, String starttime, String endtime, int limit) {
		return pcKeepRecordDao.queryRecordByCondition(diDiRecord,requestbeginNum,starttime,endtime,limit);
	}

	/**
	 * 删除UserId为空的
	 */
	@Override
	public void deleteByUserId() {
		pcKeepRecordDao.deleteByUserId();
		
	}
}
