package com.deppon.dpm.module.announce.server.service;

import java.util.List;

import com.deppon.dpm.module.announce.shared.domain.DpmExpress;

/**
 * 早安快递service接口
 * 
 * @author 231586
 * 
 */
public interface IDpmExpressService {

	/**
	 * 从oa同步早安快递
	 */
	public void syncFromOa(DpmExpress dpmExpress);

	/**
	 * 根据id获取早安快递
	 */
	public DpmExpress getExpressById(String userId, int id, String morningType);

	/**
	 * 获取历史数据
	 */
	public List<DpmExpress> getHistory(String userId, String morningType);

	/**
	 * 完成学习模块
	 */
	public void study(String userId, int id, int part);

	/**
	 * 获取今天的早安快递数据
	 * 
	 * @param userId
	 * @param morningType
	 * @return
	 */
	public DpmExpress getExpressToday(String userId, String morningType);
}
