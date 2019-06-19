package com.deppon.dpm.module.management.server.dao;
/**
 * IT上报数据库操作类
 * @author 237986
 *
 */
public interface IReportDao {
	/**
	 * 根据工号查询部门ID
	 * @return
	 */
	public int queryDeptByEmpCode(String empCode);
}
