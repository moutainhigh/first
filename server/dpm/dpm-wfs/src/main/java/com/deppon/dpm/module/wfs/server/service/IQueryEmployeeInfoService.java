package com.deppon.dpm.module.wfs.server.service;

import com.deppon.dpm.module.wfs.shared.domain.EmployeeInfo;

/**
 * 根据工号查找人员姓名
 * @author 276344
 *
 */
public interface IQueryEmployeeInfoService {
	/**
	 * 根据工号查找人员姓名
	 * @param empCode
	 * @return
	 */
	public EmployeeInfo queryEmployeeInfoByEmpcode(String empCode);
	/**
	 * 根据工号查等级
	 * @param userId
	 * @return
	 */
	public String getJoblevel(String userId);
	
	/**
	 * 根据工号查部门
	 * @param userId
	 * @return
	 */
	public String getJobName(String userid);
}
