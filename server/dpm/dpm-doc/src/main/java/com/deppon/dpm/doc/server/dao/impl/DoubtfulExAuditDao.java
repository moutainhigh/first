package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IDoubtfulExAuditDao;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DoubtfulExAuditDao extends iBatis3DaoImpl implements IDoubtfulExAuditDao{

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.entity.abnormalorderentity.";
	/**
	 * 新增疑似异常数据
	 */
	@Override
	public int insertExceptionMethod(AbnormalOrderEntity entity) {
    	return getSqlSession().insert(NAME_SPACE+"insertmethod",entity);
	}
	
	/**
	 * 用户查询审核结果(用户筛选)
	 * 查询结果筛选，默认数据
	 * @param aa 
	 * @param beginNum 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> userQueryMethod(String userId,
			String recordstate,String remark , int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("remark", remark);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"userquerymethod",map);
	}
	
	/**
	 * 员工所有数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> auditedQueryMethod(String userId,
			String recordstate) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	return getSqlSession().selectList(NAME_SPACE+"auditedquerymethod",map);
	}
	/**
	 * 员工审核结果
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> empQueryResult(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"empqueryresult",map);
	}
	
	
	/**
	 * 领导查询所有数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> leaderQueryMethod(String userId,
			String recordstate) {
//		List<AbnormalOrderEntity> otherEntityList = new ArrayList<AbnormalOrderEntity>();
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	return getSqlSession().selectList(NAME_SPACE+"leaderquerymethod",map);
	}
	
	/**
	 * 管理族群点击我审核，默认带出‘待我审核’数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> auditedMinMethod(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"auditedminmethod",map);
	}
	
	/**
	 * 管理族群我审核结果页签
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> auditedMethodResult(String userId,
			String recordstate, int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
    	return getSqlSession().selectList(NAME_SPACE+"auditedmethodresult",map);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> allAuditedDataScreen(String userId,
			String recordstate, String subordinate) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("recordstate", recordstate);
    	map.put("subordinate", subordinate);
    	return getSqlSession().selectList(NAME_SPACE+"allauditeddatascreen",map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> auditedDataScreen(String userId,
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
	public int auditedUpdateById(String id, String comment, String recordpic) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("comment", comment);
    	map.put("id", id);
    	map.put("recordpicArray", recordpic);
		
		return getSqlSession().update(NAME_SPACE+"updatebyid",map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> auditedQuertInitial(String userId,
			int beginNum, int aa) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("beginNum", beginNum);
    	map.put("aa", aa);
		return getSqlSession().selectList(NAME_SPACE+"userQueryInitial",map);
	}
	
	@Override
	public int transferMethod(String userId , String leadernum , String leadernumName) {
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("leadernum", leadernum);
    	map.put("leadernumName", leadernumName);
		return getSqlSession().update(NAME_SPACE+"transferMethod",map);
	}
	
	@Override
	public int updateErrorStatus() {
    	
		return getSqlSession().update(NAME_SPACE+"updateRecordState");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbnormalOrderEntity> queryBydate(String date) {
		return getSqlSession().selectList(NAME_SPACE+"queryBydate",date+"%");
	}

	@Override
	public List<AbnormalOrderEntity> allList(String userId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE+"allList",userId);
	}

	@Override
	public String queryScheduleState(String userId) {
		
		return (String) getSqlSession().selectOne(NAME_SPACE+"queryScheduleState",userId);
	}

	@Override
	public int insertScheduleState(List stateList) {
		
		return (Integer) getSqlSession().insert(NAME_SPACE+"insertScheduleState",stateList);
	}

	@Override
	public int selectScheduleState() {
		return (Integer) getSqlSession().selectOne(NAME_SPACE+"selectScheduleState");
	}

	@Override
	public void deleteScheduleState() {
		getSqlSession().delete(NAME_SPACE+"deleteScheduleState");
		
	}
	
}
