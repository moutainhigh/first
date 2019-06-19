package com.deppon.dpm.doc.server.service.impl;

import com.deppon.dpm.doc.server.dao.IDiDiRecordDao;
import com.deppon.dpm.doc.server.service.IDiDiRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class DiDiRecordService implements IDiDiRecordService{

	private IDiDiRecordDao didirecordDao;
	
	@Override
	public int insert(DiDiRecordVO didirecordvo) {
		return didirecordDao.insert(didirecordvo);
	}

	@Override
	public int update(int id , String recordstate , String comment) {
		return didirecordDao.update(id,recordstate,comment);
	}

	/**
	 * @param didirecordDao the didirecordDao to set
	 */
	public void setDidirecordDao(IDiDiRecordDao didirecordDao) {
		this.didirecordDao = didirecordDao;
	}

}
