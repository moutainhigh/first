package com.deppon.dpm.module.wfs.server.dao;

import com.deppon.dpm.module.wfs.shared.domain.EmployeeInfo;

/**
 * 根据工号查人员信息
 * @author 276344
 *
 */
public interface IEmployeeInfoDao {
	/**
	 * 根据工号查人员信息
	 * @param empCode
	 * @return
	 */
	public EmployeeInfo getEmployeeInfoByEmpcode(String empCode);
}
