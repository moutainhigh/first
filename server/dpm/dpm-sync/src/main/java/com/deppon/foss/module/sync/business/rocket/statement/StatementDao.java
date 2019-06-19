package com.deppon.foss.module.sync.business.rocket.statement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class StatementDao extends iBatis3DaoImpl{
	private static final String NAME_SPACE="com.deppon.foss.module.sync.business.rocket.statement.StatementDao";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int updateStatementSummary(String workflowNum,String workflowStatus,String company,String offTime){
		Map map = new HashMap();
		map.put("workflowNum", workflowNum);
		map.put("workflowStatus", workflowStatus);
		map.put("company", company);
		map.put("offTime", offTime);
		return getSqlSession().update(NAME_SPACE+".updateStatementSummary",map);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List queryStatement(String company,String offTime) {
		Map map = new HashMap();
		map.put("company", company);
		map.put("offTime", offTime);
		return getSqlSession().selectList(NAME_SPACE+".queryStatement",map);
	} 
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int updateStatementSummaryByWF(String workflowNum,String workflowStatus,String company){
		Map map = new HashMap();
		map.put("workflowNum", workflowNum);
		map.put("workflowStatus", workflowStatus);
		map.put("company", company);
		return getSqlSession().update(NAME_SPACE+".updateStatementSummaryByWF",map);
	}
	
	public int queryStatementSummaryByNum(String workflowNum){
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".queryStatementSummaryByNum",workflowNum);
				
	}
	
	public int updateStatementSummaryByMessage(String workflowNum,String bizDataUUID,String workflowStatus){
		Map<String,String> map = new HashMap<String,String>();
		map.put("workflowNum", workflowNum);
		map.put("bizDataUUID", bizDataUUID);
		map.put("workflowStatus", workflowStatus);
		return getSqlSession().update(NAME_SPACE+".updateStatementSummaryByMessage",map);
	}
}
