package com.deppon.dpm.tongxunlu.server.dao;

import java.util.Map;

/**
 * 常用联系人DAO层
 * @author 231586
 *
 */
public interface IMyFavoritesDao {
	// 新增
	public int collectOne(Map<String, String> map);

	// 获取
	public String getFavorites(String userId);
}
