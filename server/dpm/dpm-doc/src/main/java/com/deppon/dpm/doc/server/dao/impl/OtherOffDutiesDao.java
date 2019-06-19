package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IOtherOffDutiesDao;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class OtherOffDutiesDao extends iBatis3DaoImpl implements
		IOtherOffDutiesDao {
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.domain.OtherOffDutiesEntity.";
	/**
	 * 用户查询审核结果(用户筛选)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> userQueryMethod(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"userquerymethod",map);
	}
	/**
	 * 其他公务员工点击，默认带出‘待审核’数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> auditedQueryMethod(String userId,
			String recordstate) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	return getSqlSession().selectList(NAME_SPACE+"auditedquerymethod",map);
	}
	/**
	 * 其他公务管理族群点击我审核更新
	 */
	@Override
	public int auditedMethodUpdate(String id, String recordstate) {

		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
    	map.put("recordstate", recordstate);
    	return getSqlSession().update(NAME_SPACE+"auditedupdatemethod",map);
	}

	@Override
	public int insertOtherMethod(OtherOffDutiesEntity entity) {
    	return getSqlSession().insert(NAME_SPACE+"insertmethod",entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> empQueryResult(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"empqueryresult",map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> leaderQueryResult(String userId,
			String recordstate) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	return getSqlSession().selectList(NAME_SPACE+"leaderqueryresult",map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> leaderQueryMethod(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"leaderquerymethod",map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> auditedMinMethod(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"auditedminmethod",map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> allAuditedDataScreen(String userId,
			String recordstate, String subordinate) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("subordinate", subordinate);
    	return getSqlSession().selectList(NAME_SPACE+"allauditeddatascreen",map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherOffDutiesEntity> auditedDataScreen(String userId,
			String recordstate, String subordinate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("subordinate", subordinate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"auditeddatascreen",map);
	}
	@Override
	public int transferMethod(String userId, String leadernum, String leadernumName) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("leadernum", leadernum);
    	map.put("leadernumName", leadernumName);
		return getSqlSession().update(NAME_SPACE+"transferMethod",map);
	}
	
	@Override
	public int updateRecordErrorStatus() {
    	
		return getSqlSession().update(NAME_SPACE+"updateRecordState");
	}
	@Override
	public List<OtherOffDutiesEntity> queryBydate(String date) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE+"queryBydate",date+"%");
	}
	@Override
	public List<OtherOffDutiesEntity> allList(String userId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE+"allList",userId);
	}
	
	@Override
	public int getNoApproval1(String userId) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().selectOne(NAME_SPACE+"getNoApproval1",userId);
	}
	
	@Override
	public int getNoApproval2(String userId) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().selectOne(NAME_SPACE+"getNoApproval2",userId);
	}
	
	@Override
	public int getNoApproval01(String userId) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().selectOne(NAME_SPACE+"getNoApproval01",userId);
	}
	
	@Override
	public int getNoApproval02(String userId) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().selectOne(NAME_SPACE+"getNoApproval02",userId);
	}
	
}
