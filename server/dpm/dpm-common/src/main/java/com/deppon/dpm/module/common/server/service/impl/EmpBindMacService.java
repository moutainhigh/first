package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.IEmpBindMacDao;
import com.deppon.dpm.module.common.server.service.IEmpBindMacService;
import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;

/**
 * 用户绑定mac信息service
 *
 */
public class EmpBindMacService implements IEmpBindMacService{

	// 注入dao
	private IEmpBindMacDao empBindMacDao;

	// setter
	public void setEmpBindMacDao(IEmpBindMacDao empBindMacDao) {
		this.empBindMacDao = empBindMacDao;
	}

	// 保存
	public void save(EmpBindMacEntity entity) {
		empBindMacDao.save(entity);
	}
	
	// 根据mac和osType查询绑定的工号
	public String queryEmpCodeByMacAndOstype(EmpBindMacEntity entity){
		return empBindMacDao.queryEmpCodeByMacAndOstype(entity);
	}
	
}
