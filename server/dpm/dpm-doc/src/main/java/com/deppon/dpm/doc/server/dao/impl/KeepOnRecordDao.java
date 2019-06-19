package com.deppon.dpm.doc.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.doc.server.dao.IKeepOnRecordDao;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class KeepOnRecordDao extends iBatis3DaoImpl implements IKeepOnRecordDao{
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiRecordDAO";

	/**
	 * 根据备案人ID查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO>  queryKeepRecordById(String userId) {
		List<DiDiRecordVO> list=getSqlSession().selectList(NAME_SPACE+".queryKeepRecordById",userId);
		if(list==null){
			return null;
		}else{
			return list;
		}
		
	}
	
	/**
	 * 查全部
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryAllDidiRecord() {
		List<DiDiRecordVO> list = getSqlSession().selectList(NAME_SPACE+".queryDidiRecordAll");
		return list;
	}
	
	/**
	 * Mobile端根据条件和起始位置查询备案人
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryRecordByConditionMobile(DiDiRecordVO diDiRecord, int requestbeginNum,int limit) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", diDiRecord.getUserId());
		map.put("userName", diDiRecord.getUserName());
		map.put("dept", diDiRecord.getDept());
		map.put("recordtime", diDiRecord.getRecordtime());
		map.put("recordtype", diDiRecord.getRecordtype());
		map.put("recordstate", diDiRecord.getRecordstate());
		map.put("requestbeginNum", requestbeginNum);
		map.put("limit", limit);
		List<DiDiRecordVO> list = getSqlSession().selectList(NAME_SPACE+".queryRecordByConditionMobile", map);
		return list;
	}
	
	/**
	 * PC根据条件和起始位置查询备案人
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryRecordByConditionPC(DiDiRecordVO diDiRecord,int requestbeginNum, String starttime, String endtime,int limit) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", diDiRecord.getUserId());
		map.put("userName", diDiRecord.getUserName());
		map.put("dept", diDiRecord.getDept());
		map.put("recordtime", diDiRecord.getRecordtime());
		map.put("recordtype", diDiRecord.getRecordtype());
		map.put("recordstate", diDiRecord.getRecordstate());
		map.put("requestbeginNum", requestbeginNum);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("limit", limit);
		List<DiDiRecordVO>  list=getSqlSession().selectList(NAME_SPACE+".queryRecordByConditionPC", map);
		return list;
	}
	
	/**
	 * Mobile端根据条件返回list(无时间条件)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryAllDidiRecordByConditionIntMobile(DiDiRecordVO diDiRecord) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", diDiRecord.getUserId());
		map.put("userName", diDiRecord.getUserName());
		map.put("dept", diDiRecord.getDept());
		map.put("recordtime", diDiRecord.getRecordtime());
		map.put("recordtype", diDiRecord.getRecordtype());
		map.put("recordstate", diDiRecord.getRecordstate());
		return getSqlSession().selectList(NAME_SPACE+".queryRecordByConditionMobileInt", map);
	}

	/**
	 * PC端根据条件返回list(有时间条件)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryAllDidiRecordByConditionIntPC(DiDiRecordVO diDiRecord, String starttime, String endtime) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", diDiRecord.getUserId());
		map.put("userName", diDiRecord.getUserName());
		map.put("dept", diDiRecord.getDept());
		map.put("recordtime", diDiRecord.getRecordtime());
		map.put("recordtype", diDiRecord.getRecordtype());
		map.put("recordstate", diDiRecord.getRecordstate());
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		return getSqlSession().selectList(NAME_SPACE+".queryRecordByConditionPCInt", map);
	}

	@Override
	public List<DiDiRecordVO> queryRecordAll(String userId, String recordtype,String recordstate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<String> recordtypeList = new ArrayList<String>();
		List<String> recordstateList = new ArrayList<String>();
		if(recordtype == null || "".equals(recordtype) || "null".equals(recordtype)){
			recordtypeList.add("0");
			recordtypeList.add("1");
			map.put("recordtypeList", recordtypeList);
		}else{
			recordtypeList.add(recordtype);
			map.put("recordtypeList", recordtypeList);
		}
		if(recordstate == null || "".equals(recordstate) || "null".equals(recordstate)){
			recordstateList.add("1");
			recordstateList.add("2");
			map.put("recordstateList", recordstateList);
		}else{
			recordstateList.add(recordstate);
			map.put("recordstateList", recordstateList);
		}
		return getSqlSession().selectList(NAME_SPACE+".queryrecordall", map);
	}

	@Override
	public List<DiDiRecordVO> query(String userId, String recordtype, String recordstate, int beginNum, int limit) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		
		List<String> recordtypeList = new ArrayList<String>();
		List<String> recordstateList = new ArrayList<String>();
		if(recordtype == null || "".equals(recordtype) || "null".equals(recordtype)){
			recordtypeList.add("0");
			recordtypeList.add("1");
			map.put("recordtypeList", recordtypeList);
		}else{
			recordtypeList.add(recordtype);
			map.put("recordtypeList", recordtypeList);
		}
		if(recordstate == null || "".equals(recordstate) || "null".equals(recordstate)){
			recordstateList.add("1");
			recordstateList.add("2");
			map.put("recordstateList", recordstateList);
		}else{
			recordstateList.add(recordstate);
			map.put("recordstateList", recordstateList);
		}
		map.put("beginNum", beginNum);
		map.put("limit", limit);
		return getSqlSession().selectList(NAME_SPACE+".query", map);
	}
	

}
