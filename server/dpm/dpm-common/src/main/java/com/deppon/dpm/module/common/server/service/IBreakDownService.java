package com.deppon.dpm.module.common.server.service;

import com.deppon.dpm.module.common.shared.domain.BreakDownEntity;

/**
 * app崩溃监控记录service接口
 */
public interface IBreakDownService {

	/**
	 * 保存app崩溃监控记录
	 */
	public int saveBreakBownInfo(BreakDownEntity entity);
}
