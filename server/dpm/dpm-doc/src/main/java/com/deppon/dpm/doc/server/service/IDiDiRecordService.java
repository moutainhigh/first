package com.deppon.dpm.doc.server.service;

import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public interface IDiDiRecordService {

	/*
	 * 新增备案
	 */
	public int insert(DiDiRecordVO didirecordvo);
	/*
	 * 批复备案
	 */
	public int update(int id , String recordstate , String comment);
	
}
