package com.deppon.dpm.doc.server.dao;

import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

/**
 * 备案功能DAO（新增，修改）
 * @author Administrator
 *
 */
public interface IDiDiRecordDao {

	/*
	 * 新增备案
	 */
	public int insert(DiDiRecordVO didirecordvo);
	/*
	 * 批复备案
	 */
	public int update(int id , String recordstate , String comment);
	
}
