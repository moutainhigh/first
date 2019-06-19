package com.deppon.dpm.doc.server.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.StatementSummaryEntity;

public interface IFileDao {
	String upload(String originalFilename,String contentType,long size,InputStream is , String getDate) throws IOException;
	//查询传入月份的数据，分页显示
	public List<DidiOrderEntity> queryByPage(String getDate , int pageNum);
	//查询传入月份的总数
	public List<DidiOrderEntity> queryAllByDate(String getDate );
	//查询当月订单总数
	public int getCountOfMonth(String getDate);
	
	public int getStatementCount(String getDate);
	/**
	 * 更新
	 */
	public int updateOrder(String id,String amount);
	/**
	 *删除
	 */
	public int deleteOrder(String id);
	/*
	 * 添加对账单信息
	 * */
	public int addStatement(List<Map<String,String>> list);
	
	public int addStatement2(List<Map<String,String>> list);
	
	/**
	 * 直接插入滴滴订单信息到对账表
	 * */
	public int addStatement4Didi(List<Map<String,String>> list);
	
	/**
	 * 利用update语句更新对账表执行对账，匹配逻辑是与didi_order表里面的数据根据订单号码匹配
	 * 参数：月份、财务子公司
	 * */
	public int statementInDpm(Map<String,String> params);
	
	public int statementNotInDpm(Map<String,String> params);
	
	/*
	 * 把传入的Excal表格添加到数据库中
	 * */
	public int addDidiExcal(String billno,String amount);
	
	/*
	 * 验证是否重复上传excal
	 * */
	public int check(String billno);
	
	/*
	 * 验证对账单中是否有重复订单号
	 * */
	public int checkStatement(String billno);
	/*
	 * 添加财务信息excel至对账单
	 * */
	public int addFinancialExcel(Map<String,String> map,String invoiceTitle,String getDate);
	/*
	 * 查询全部对账单分页
	 * */
	public List queryStatement (int pageNum,String getDate);
	/*
	 * 根据删除对账单明细
	 * */
	public int deleteStatement(String id);
	/*
	 * 修改对账单明细
	 * */
	public int updateStatement(String id,String depponPrice,String lowerPrice);
	/*
	 * 模糊查询对账单
	 * */
	public List fuzzySearchStatement(String company,String workFlowStatus,String offTime);
	/*
	 * 根据公司查对账单明细
	 * */
	public List queryAllStatementByCompany(String company,String offTime);
	/*
	 * 把对账单明细汇总
	 * */
	public int addStatementSummary(String company,String money,String offTime);
	/*
	 * 查询对账汇总用来验证是否添加重复
	 * */
	public List queryStatementSummary(String getDate);
	/*
	 * 在汇总表中查询对账单汇总
	 * */
	public int SearchStatementSummary(String company,String offTime);
	/*
	 * 在汇总表中查询对账单汇总不包含状态
	 * */
	public int SearchStatementSummary2(String company,String offTime);
	/*
	 * 查询工作流状态
	 * */
	public String queryWorkFlowStatus(String company,String offTime);
	/*
	 * 查询全部对账单分页
	 * */
	public List queryAllStatement();
	/*
	 * 模糊查询分页
	 * */
	public List fuzzySearchStatementFenYe(String company,String workFlowStatus,String offTime,int pageNum);
	/*
	 * 根据id包含的月份删除对账单明细
	 * */
	public int deleteStatementByTime(String offTime);
	
	public int deleteStatementSummaryByTime(String offTime);
	/*
	 * 更改状态
	 * */
	public int updateStatementSummary(String company,String offTime,String bizDataUUID);
	/*
	 * 验证对账单是否全部改完，即same_or_difference全部是否为0
	 * */
	public List queryStatus(String getDate);
	
	/**
	 * 查询对账汇总明细
	 * */
	public List<StatementSummaryEntity> queryStatementSummaryDetails(String offTime);
}
