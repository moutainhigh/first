package com.deppon.dpm.doc.server.service;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public interface IKeepOnRecordService {
	/**
	 * 根绝userID获取备案人全部信息
	 */
	List<DiDiRecordVO> queryKeepRecordById(String userId);
	/**
	 * 获取全部信息
	 * @param diDiRecord 
	 * @return
	 */
	List<DiDiRecordVO> queryAllDidiRecord();
	/**
	 * Mobile端根据条件查询和起始位置查询
	 * @param diDiRecord
	 * @param requestbeginnum 
	 * @return
	 */
	List<DiDiRecordVO> queryRecordByConditionMobile(DiDiRecordVO diDiRecord, int requestbeginnum,int limit);
	/**
	 * PC端根据条件查询和起始位置查询
	 * @param diDiRecord
	 * @param requestbeginNum
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	List<DiDiRecordVO> queryRecordByConditionPC(DiDiRecordVO diDiRecord,int requestbeginNum, String starttime, String endtime,int limit);
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
