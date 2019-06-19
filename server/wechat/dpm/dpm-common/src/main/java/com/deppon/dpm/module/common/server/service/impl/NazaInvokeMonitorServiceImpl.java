package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.INazaInvokeMonitorDao;
import com.deppon.dpm.module.common.server.service.INazaInvokeMonitorService;
import com.deppon.dpm.module.common.shared.domain.NazaInvokeMonitorEntity;

/**
 * Naza接口调用监控的Service
 */
public class NazaInvokeMonitorServiceImpl implements INazaInvokeMonitorService{
	
	// dao
	private INazaInvokeMonitorDao nazaInvokeMonitorDao;

	/**
	 * 保存
	 */
	public int save(NazaInvokeMonitorEntity entity) {
		return nazaInvokeMonitorDao.save(entity);
	}

	/**
	 * 条件查询
	 */
	public List<NazaInvokeMonitorEntity> queryByCondition(
			NazaInvokeMonitorEntity entity) {
		return nazaInvokeMonitorDao.queryByCondition(entity);
	}
	
	/**
	 * setter
	 */
	public void setNazaInvokeMonitorDao(INazaInvokeMonitorDao nazaInvokeMonitorDao) {
		this.nazaInvokeMonitorDao = nazaInvokeMonitorDao;
	}
}
