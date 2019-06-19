package com.deppon.dpm.module.common.server.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


public interface IHxQuestionPcService {
	
	/**
	 *查询所有数据 
	 */
	public List<Map<String,Object>> queryList(int begin,int limit);

	/**
	 *查询总数据条数 
	 */
	public long queryCount();

	/**
	 * 新增问题信息
	 */
	public int insert(JSONObject question);

	/**
	 * 修改问题信息
	 */
	public int update(JSONObject question);

	/**
	 * 根据问题编号删除信息
	 */
	public void deleteByApplyCodes(String questionIds);
}
