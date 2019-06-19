package com.deppon.dpm.doc.server.service;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public interface IPcKeepRecordService {
	/**
	 * 查询符合条件记录的全部
	 * @param diDiRecord
	 * @param starttime
	 * @param endtime
	 * @return List<DiDiRecordVO>
	 */
	List<DiDiRecordVO> queryRecordAll(DiDiRecordVO diDiRecord,String starttime, String endtime);
	/**
	 * 无条件查询全部备案的记录
	 * @return List<DiDiRecordVO>
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
