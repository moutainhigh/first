package com.deppon.dpm.module.projecttools.server.dao;


/**
 * 
 * 报表管理  权限判断 Interface
 *
 * @author 195406 高春玲
 * @date 2015-8-24 下午1:45:08
 **/
public interface IDppmReportDao {
	/**
	 * 权限判断
	 * @author 195406 高春玲
	 * @date 2015-8-24 下午1:45:08
	 */
	public int powerReport(String userId);
	/**
	 * 项目进度成本高级搜索默认加载数据字典数据
	 * 项目类型，项目级别，所属本部
	 * @return
	 */
	public String proTypeQuery();
	/**
	 * 项目进度成本 高级搜索  按名称模糊搜索 项目名称，承接部门
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
	/**
	 * 查询用户 级别
	 * @return
	 */
	public int queryJobLevel(String userId);
}
