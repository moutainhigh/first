package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.INazaInvokeMonitorDao;
import com.deppon.dpm.module.common.shared.domain.NazaInvokeMonitorEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class NazaInvokeMonitorDaoImpl extends iBatis3DaoImpl implements INazaInvokeMonitorDao{
	
	//mapper.xml的名称空间
	private static final String NAMESPASE = "com.deppon.dpm.module.common.server.dao.impl.NazaInvokeMonitorDaoImpl.";
	
	// 保存
	public int save(NazaInvokeMonitorEntity entity) {
		// 返回
		return this.getSqlSession().insert(NAMESPASE + "insert", entity);
	}

	/**
	 * 条件查询
	 */
	@SuppressWarnings("unchecked")
	public List<NazaInvokeMonitorEntity> queryByCondition(
			NazaInvokeMonitorEntity entity) {
		// 返回
		return this.getSqlSession().selectList(NAMESPASE + "queryByCondition", entity);
	}

}
