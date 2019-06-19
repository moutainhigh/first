package com.deppon.dpm.module.wfs.server.service;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
/**
 * 根据工号数组查询头像地址
 * @author 276344
 *
 */

public interface INwfsPicpathService {
	/**
	 * 根据工号数组查询头像地址
	 * @param userIds
	 * @return
	 */
	public List<NwfsPicPathEntity> picturePaths(List<String> userIds);
}
