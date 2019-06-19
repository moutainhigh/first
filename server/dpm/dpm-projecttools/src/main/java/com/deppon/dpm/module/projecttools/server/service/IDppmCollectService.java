package com.deppon.dpm.module.projecttools.server.service;

import com.deppon.dpm.module.projecttools.shared.vo.CollectVo;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 项目管理 我的关注 service
 * @author gcl
 */
public interface IDppmCollectService {
	
	/**
	 * 收藏
	 * @return
	 * @throws BusinessException
	 */
	public int dppmCollect(CollectVo vo) throws BusinessException;
	
}
