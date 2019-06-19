package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IMyFavoritesDao;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 常用联系人dao层
 * 
 * @author 231586
 * 
 */
public class MyFavoritesDao extends iBatis3DaoImpl implements IMyFavoritesDao {
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.employee.";

	/**
	 * 收藏常用联系人
	 */
	@Override
	public int collectOne(Map<String, String> map) {
		// 收藏一个
		return getSqlSession().insert(NAMESPACE + "collectOne", map);
	}

	/**
	 * 获取
	 */
	@Override
	public String getFavorites(String userId) {
		// 获取常用联系人
		return (String) getSqlSession().selectOne(NAMESPACE + "getFavorites", userId);
	}
}