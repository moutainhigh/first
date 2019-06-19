package com.deppon.dpm.module.management.server.service;

import com.deppon.dpm.module.management.shared.domain.OrderAddRequest;


/**
 * 上报问题上传附件service
 * @author 237986
 *
 */
public interface IReportService {
	public String submitReport( OrderAddRequest order);
	/**
	 * 查询权限
	 * @param userCode
	 * @return
	 */
	public String queryAuthority(String userCode);
	/**
	 * 查询部门ID
	 * @return
	 */
	public int queryDeptByEmpCode(String empCode);
}
