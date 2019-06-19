package com.deppon.dpm.module.projecttools.server.service;

import com.deppon.dpm.module.projecttools.shared.vo.CollectVo;

/**
 * 项目管理 我的关注 service
 * @author gcl
 */
public interface IDppmCollectService {
	
	/**
	 * 收藏
	 * @return
	 * @throws Exception
	 */
	public int dppmCollect(CollectVo vo) throws Exception;
	
}
