package com.deppon.dpm.doc.server.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.StatementSummaryEntity;

public interface IFileService {

	String upload(String originalFilename,String contentType,long size,InputStream is,String getDate) throws IOException;
	//查询传入月份的数据，分页显示
	public List<DidiOrderEntity> queryByPage(String getDate , int pageNum);
	//查询传入月份的总数
	public List<DidiOrderEntity> queryAllByDate(String getDate );
	//查询当月订单总数
	public int getCountOfMonth(String getDate );
	/**
	 * 更新
	 */
	public int updateOrder(String id,String amount);
	/**
	 *删除
	 */
	public int deleteOrder(String id);
	/*
	 * 读取财务信息excel表格
	 * */
	public String readFinancialFile(InputStream is,String getDate);
	
	/*
	 * 查询对账单分页
	 * */
	public List queryStatement(int pageNum,String getDate);
	
	public int getStatementCount(String getDate);
	
	/*
	 * 根据id删除对账单明细
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
	 * 模糊查询对账单分页
	 * */
	public List fuzzySearchStatementFenYe(String company,String workFlowStatus,String offTime,int pageNum);
	/*
	 * 根据公司查询对账单明细
	 * */
	public List queryAllStatementByCompany(String company,String offTime);
	/*
	 * 把对账单明细汇总
	 * */
	public int addStatementSummary(String company,String money,String offTime);
	/*
	 * 查询汇总验证重复
	 * */
	public List queryStatementSummary(String getDate);
	/*
	 * 查询所有汇总
	 * */
	public int searchStatementSummary(String company,String offTime);
	/*
	 * 查询对账单
	 * */
	public List queryAllStatement();
	/*
	 * 根据id包含的月份删除对账单明细
	 * */
	public int deleteStatementByTime(String offTime);
	
	public int deleteStatementSummaryByTime(String offTime);
	
	/*
	 * 根据月份对账
	 * */
	public int statementByTime(String offTime);
	
	/*
	 * 更新是否发送的状态
	 * */
	public int updateStatementSummary(String company,String offTime,String bizDataUUID);
	/*
	 * 查询所有汇总不包含状态
	 * */
	public int searchStatementSummary2(String company,String offTime);
	/*
	 * 验证对账单是否全部改完，即same_or_difference全部是否为0
	 * */
	public List queryStatus(String getDate);
	/*
	 * 查询工作流状态
	 * */
	public String queryWorkFlowStatus(String company,String offTime);
	
	/**
	 * 查询对账汇总明细
	 * */
	public List<StatementSummaryEntity> queryStatementSummaryDetails(String offTime);
}
