package com.deppon.dpm.module.wfs.server.service.impl;

import com.deppon.dpm.module.wfs.server.dao.IEmployeeInfoDao;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.shared.domain.EmployeeInfo;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;

/**
 * 根据工号查找人员姓名
 * @author 276344
 *
 */
public class QueryEmployeeInfoService implements IQueryEmployeeInfoService {
	private IEmployeeInfoDao employeeDao;
	@Override
	public EmployeeInfo queryEmployeeInfoByEmpcode(String empCode) {
		
		return employeeDao.getEmployeeInfoByEmpcode(empCode);
	}
	/**
	 * set
	 * @param employeeDao
	 */
	public void setEmployeeDao(IEmployeeInfoDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
