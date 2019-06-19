package com.deppon.dpm.module.lsp.server.service;

import com.deppon.dpm.module.lsp.shared.domain.FixedAssetsCheckReEntity;

/**
 * 固定资产列表服务接口
 * @author 233357
 * @date 2015/03/19
 */
public interface IFixedAssetsCheckService {
	
	/**
	 * 获取固定资产列表信息接口服务.
	 * @param assetsCheckReEntity 传入实体
	 * @return
	 */
	public String getFixedAssets(FixedAssetsCheckReEntity assetsCheckReEntity);

}
