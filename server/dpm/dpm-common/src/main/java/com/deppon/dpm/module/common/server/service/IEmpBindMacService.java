package com.deppon.dpm.module.common.server.service;

import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;

/**
 * 用户绑定mac信息service
 */
public interface IEmpBindMacService {

	// 保存
	void save(EmpBindMacEntity entity);
	
	// 根据mac和osType查询
	String queryEmpCodeByMacAndOstype(EmpBindMacEntity entity);

}
