package com.deppon.dpm.module.projecttools.server.service;


/**
 * 报表管理  
 * 任务工时上报、需求上线时效、需求点均成本 service
 * @author gcl
 */
public interface IDppmReportService {
	
	/**
	 * 任务工时上报
	 * @param date 日期
	 * @return
	 */
	public String taskTimeReport(String userId,String date);
	/**
	 * 任务工时上报(最近一周工时上报)查询
	 * @return
	 */
	public String taskWeekReport(String userId,String date);
	/**
	 * 需求上线时效
	 * @param bdate 开始日期
	 * @param edate 结束日期
	 * @return
	 */
	public String demandOnlineAging(String bdate,String edate);
	/**
	 * 需求点击成本
	 * @param bdate 开始日期
	 * @param edate 结束日期
	 * @return
	 */
	public String demandPointMoney(String bdate,String edate);
	/**
	 * 需求点击成本 (最近一年整体点均成本)
	 * @return
	 */
	public String demandPointAging();
	/**
	 * 功能点完成率（日常需求人均功能点数）
	 * 2015-08-27
	 * @param bdate 起始日期
	 * @param edate 结束日期
	 * @param date 月
	 * @return
	 */
	public String funcCompleteRate(String bdate,String edate,String date);
	
	/**
	 * 权限判断
	 * @param userId 用户工号
	 * @return
	 */
	public String powerReport(String userId) throws Exception ;
	/**
	 * 项目进度成本    9.12
	 * @param json 搜索条件
	 * @return
	 */
	public String projectCostQuery(String json);
	/**
	 * 项目进度成本高级搜索默认加载数据字典数据
	 * 项目类型，项目级别，所属本部
	 * @return
	 */
	public String proTypeQuery();
	/**
	 * 项目进度成本 高级搜索  按名称模糊搜索 项目名称，承接部门
	 * @param type 搜索类型
	 * @param name 搜索条件
	 * @return
	 */
	public String proDeptQuery(int type, String name);
	/**
	 * kPi数据统计 
	 * 0：项目管理 6：报表管理 11：任务管理 15：年度规划
	 * @param date 统计日期---统计日期默认为昨天
	 * @return
	 */
	public String queryKpi(String date);
	
}
