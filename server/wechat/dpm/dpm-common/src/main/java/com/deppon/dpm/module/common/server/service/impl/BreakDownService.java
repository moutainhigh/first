package com.deppon.dpm.module.common.server.service.impl;

import com.deppon.dpm.module.common.server.dao.IBreakDownDao;
import com.deppon.dpm.module.common.server.service.IBreakDownService;
import com.deppon.dpm.module.common.shared.domain.BreakDownEntity;

/**
 * app崩溃监控记录service
 */
public class BreakDownService implements IBreakDownService{
	
	/**
	 * dao
	 */
	private IBreakDownDao breakDownDao; 
	
	/**
	 * setter
	 */
	public void setBreakDownDao(IBreakDownDao breakDownDao) {
		this.breakDownDao = breakDownDao;
	}

	/**
	 * 保存app崩溃监控记录
	 */
	@Override
	public int saveBreakBownInfo(BreakDownEntity entity) {
		//保存
		return breakDownDao.saveBreakDownInfo(entity);
	}

}
