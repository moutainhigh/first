package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public interface IKeepOnRecordDao {
	/**
	 * 根据备案人ID查询
	 * @param userId
	 * @return
	 */
	List<DiDiRecordVO> queryKeepRecordById(String userId);
	/**
	 * 查询全部备案人
	 * @return
	 */
	List<DiDiRecordVO> queryAllDidiRecord();
	
	/**
	 * Mobile端根据条件和起始位置查询备案人
	 * @param diDiRecord
	 * @param requestbeginnum 
	 * @return
	 */
	List<DiDiRecordVO> queryRecordByConditionMobile(DiDiRecordVO diDiRecord, int requestbeginnum,int limit);
	/**
	 * PC端根据条件查询
	 * @param diDiRecord
	 * @param requestbeginNum
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	List<DiDiRecordVO> queryRecordByConditionPC(DiDiRecordVO diDiRecord,
			int requestbeginNum, String starttime, String endtime,int limit);
	/**
	 * Mobile端根据条件返回list(无时间条件)
	 * @param diDiRecord
	 * @return
	 */
	List<DiDiRecordVO> queryAllDidiRecordByConditionIntMobile(DiDiRecordVO diDiRecord);
	/**
	 * PC端根据条件返回list(有时间条件)
	 * @param diDiRecord
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	List<DiDiRecordVO> queryAllDidiRecordByConditionIntPC(DiDiRecordVO diDiRecord, String starttime, String endtime);
	public List<DiDiRecordVO> queryRecordAll(String userId , String recordtype,String recordstate);
	public List<DiDiRecordVO> query(String userId , String recordtype,String recordstate,int beginNum,int limit);
}
