package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IEmpBindMacDao;
import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 用户绑定mac信息
 */
public class EmpBindMacDao extends iBatis3DaoImpl implements IEmpBindMacDao{
	
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.EmpBindMacDao.";

	// 保存
	public void save(EmpBindMacEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	// 根据mac和osType查询
	public String queryEmpCodeByMacAndOstype(EmpBindMacEntity entity) {
		return (String) this.getSqlSession().selectOne(NAME_SPACE + "queryEmpCodeByMacAndOstype", entity);
	}

}
