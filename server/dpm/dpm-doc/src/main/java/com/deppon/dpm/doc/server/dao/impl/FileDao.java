package com.deppon.dpm.doc.server.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IFileDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.StatementSummaryEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class FileDao extends iBatis3DaoImpl  implements IFileDao  {
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiOrderDao";
	@Override
	public String upload(String originalFilename, String contentType,
			long size, InputStream is , String getDate) throws IOException {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> queryByPage(String getDate, int pageNum) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("getDate", getDate);
    	map.put("pageNum", String.valueOf(pageNum+0));
		return getSqlSession().selectList(NAME_SPACE+".selectFileMsgBydate",map);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> queryAllByDate(String getDate) {
		return getSqlSession().selectList(NAME_SPACE+".fileSelectFile",getDate);
	}
	
	@Override
	public int getCountOfMonth(String getDate){
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".getCountOfMonth",getDate);
	}
	
	@Override
	public int getStatementCount(String getDate){
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".queryStatementCount",getDate);
	}
	
	@Override
	public int updateOrder(String id, String amount) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("id", id);
    	map.put("amount", amount);
		return getSqlSession().update(NAME_SPACE+".updateFileOrder",map);
	}
	@Override
	public int deleteOrder(String id) {
		return getSqlSession().delete(NAME_SPACE+".deleteFileOrder",id);
	}
	@Override
	//业务单中含滴滴订单号，添加至对账单
	public int addStatement(List<Map<String,String>> list) {
		return getSqlSession().insert(NAME_SPACE+".addStatement",list);
	}
	@Override
	//业务单中不含滴滴订单号，添加至对账单
	public int addStatement2(List<Map<String,String>> list){
		return getSqlSession().insert(NAME_SPACE+".addStatement2",list);
	}
	@Override
	//添加滴滴订单信息
	public int addStatement4Didi(List<Map<String,String>> list){
		return getSqlSession().insert(NAME_SPACE+".addStatement4Didi",list);
	}
	@Override
	//对账存在于德邦的订单
	public int statementInDpm(Map<String,String> map){
		return getSqlSession().update(NAME_SPACE+".statementInDpm",map);
	}
	@Override
	//对账不存在于德邦的订单
	public int statementNotInDpm(Map<String,String> map){
		return getSqlSession().update(NAME_SPACE+".statementNotInDpm",map);
	}
	@Override
	//把滴滴excal存入表中
	public int addDidiExcal(String billno,String didi_price) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("billno", billno);
		map.put("didi_price", didi_price);
		return getSqlSession().insert(NAME_SPACE+".addDidiExcal",map);
	}
	@Override
	//验证订单号是否重复
	public int check(String billno) {		
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".checkExcal",billno);
	}
	@Override
	public int checkStatement(String billno) {
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".checkStatement",billno);
	}
	@Override
	public  int addFinancialExcel(Map<String,String> map,String company,String getDate) {
		map.put("company", company);
		map.put("getDate", getDate);
		return getSqlSession().update(NAME_SPACE+".addFinancialInfo",map);
	}
	@Override
	public List queryStatement (int pageNum,String getDate){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("getDate", getDate);
		return getSqlSession().selectList(NAME_SPACE+".queryStatement",map);
	}
	@Override
	public int deleteStatement(String id) {
		return getSqlSession().delete(NAME_SPACE+".deleteStatement",id);
	}
	@Override
	public int updateStatement(String id,String depponPrice,String lowerPrice) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("depponPrice", depponPrice);
		map.put("lowerPrice", lowerPrice);
		return getSqlSession().update(NAME_SPACE+".updateStatement",map);
	}
	@Override
	public List fuzzySearchStatement(String company, String workFlowStatus,String offTime) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("company", company);
		map.put("workFlowStatus",workFlowStatus);
		map.put("offTime", offTime);
		return getSqlSession().selectList(NAME_SPACE+".fuzzySearchStatement",map);
	}
	@Override
	public List queryAllStatementByCompany(String company,String offTime) {
		Map map = new HashMap();
		map.put("company", company);
		map.put("offTime", offTime);
		return getSqlSession().selectList(NAME_SPACE+".queryAllStatementByCompany",map);
	}
	@Override
	public int addStatementSummary(String company,String money,String offTime) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("company", company);
		map.put("money", money);
		map.put("offTime", offTime);
		return getSqlSession().insert(NAME_SPACE+".addStatementSummary",map);
	}
	@Override
	public List queryStatementSummary(String getDate) {
		return getSqlSession().selectList(NAME_SPACE+".queryStatementSummary",getDate);
	}
	@Override
	public int SearchStatementSummary(String company,String offTime) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("company", company);
		map.put("offTime", offTime);
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".SearchStatementSummary",map);
	}
	@Override
	public List queryAllStatement() {
		return getSqlSession().selectList(NAME_SPACE+".queryAllStatement");
	}
	@Override
	public List fuzzySearchStatementFenYe(String company,
			String workFlowStatus, String offTime, int pageNum) {
		Map map = new HashMap();
		map.put("company", company);
		map.put("workFlowStatus", workFlowStatus);
		map.put("offTime", offTime);
		map.put("pageNum", pageNum);
			return getSqlSession().selectList(NAME_SPACE+".fuzzySearchStatementFenYe",map);
	}
	@Override
	public int deleteStatementByTime(String offTime) {
		return getSqlSession().delete(NAME_SPACE+".deleteStatementByTime",offTime);
	}
	@Override
	public int deleteStatementSummaryByTime(String offTime) {
		return getSqlSession().delete(NAME_SPACE+".deleteStatementSummaryByTime",offTime);
	}
	@Override
	public int updateStatementSummary(String company, String offTime,String bizDataUUID) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("company", company);
		map.put("offTime", offTime);
		map.put("bizDataUUID", bizDataUUID);
		return (Integer) getSqlSession().update(NAME_SPACE+".updateStatementSummary",map);
	}
	@Override
	public int SearchStatementSummary2(String company, String offTime) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("company", company);
		map.put("offTime", offTime);
		return (Integer) getSqlSession().selectOne(NAME_SPACE+".SearchStatementSummary2",map);
	}
	@Override
	public List queryStatus(String getDate) {
		return getSqlSession().selectList(NAME_SPACE+".queryStatus",getDate);
	}
	@Override
	public String queryWorkFlowStatus(String company, String offTime) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("company", company);
		map.put("offTime", offTime);
		return  (String)getSqlSession().selectOne(NAME_SPACE+".queryWorkFlowStatus",map);
	}
	
	/**
	 * 查询对账汇总明细
	 * */
	@SuppressWarnings("unchecked")
	public List<StatementSummaryEntity> queryStatementSummaryDetails(String offTime){
		return this.getSqlSession().selectList(NAME_SPACE+".queryStatementSummaryDetails",offTime);
	}
}
