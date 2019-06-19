package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.BreakDownEntity;

/**
 * app崩溃监控记录dao接口
 */
public interface IBreakDownDao {
	
	/**
	 * 保存app崩溃监控记录
	 */
	public int saveBreakDownInfo(BreakDownEntity entity);
}
