package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
/**
 * 根据传入的工号集合查询头像地址
 * @author 276344
 *
 */
public interface INwfsPicpathDao {
	/**
	 * 根据传入的工号集合查询头像地址
	 * @param userIds
	 * @return
	 */
	public List<NwfsPicPathEntity> picturePaths(List<String> userIds);
}
