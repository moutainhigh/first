package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IReportDao;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * IT上报数据库操作类
 * 
 * @author 237986
 * 
 */
public class ReportDao extends iBatis3DaoImpl implements IReportDao {

	/**
	 * 根据工号查询部门ID
	 * 
	 * @return
	 */
	public int queryDeptByEmpCode(String empCode) {
		return (Integer) this
				.getSqlSession()
				.selectOne(
						"com.deppon.dpm.module.management.server.dao.report.selectDeptId",
						empCode);
	}

}
