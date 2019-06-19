package com.deppon.dpm.module.common.server.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;


public interface IAutoPunchGlobalAddressService {

	/**
	 *查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin, int limit);

	/**
	 *查询总数据条数 
	 */
	public long queryCount();

	/**
	 * 新增appPermission信息
	 */
	public int insert(JSONObject appPermission);

	/**
	 * 修改appPermission信息
	 */
	public int update(JSONObject appPermission);

	/**
	 * 根据应用编号删除信息
	 */
	public void deleteByApplyCodes(String applyCodes);
}
