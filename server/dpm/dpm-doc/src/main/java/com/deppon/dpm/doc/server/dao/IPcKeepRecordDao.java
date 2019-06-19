package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public interface IPcKeepRecordDao {
	/**
	 * 查询符合条件记录的条数
	 * @param diDiRecord
	 * @param starttime
	 * @param endtime
	 * @return List<DiDiRecordVO>
	 */
	List<DiDiRecordVO> queryRecordAll(DiDiRecordVO diDiRecord,String starttime, String endtime);
	/**
	 * 查询全部备案记录
	 * @return 
	 */
	List<DiDiRecordVO> queryAllDidiRecord();
	/**
	 * 根据条件和起始位置进行查询
	 * @param diDiRecord
	 * @param requestbeginNum
	 * @param starttime
	 * @param endtime
	 * @param limit
	 * @return
	 */
	List<DiDiRecordVO> queryRecordByCondition(DiDiRecordVO diDiRecord,int requestbeginNum, String starttime, String endtime, int limit);
	/**
	 * 删除UserId为空的
	 */
	void deleteByUserId();

}
