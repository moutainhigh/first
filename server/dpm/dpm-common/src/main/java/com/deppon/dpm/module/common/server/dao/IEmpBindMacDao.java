package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;

/**
 * dao
 */
public interface IEmpBindMacDao {

	// 保存
	void save(EmpBindMacEntity entity);

	// 根据mac和osType查询
	String queryEmpCodeByMacAndOstype(EmpBindMacEntity entity);

}
