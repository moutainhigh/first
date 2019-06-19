package com.deppon.dpm.module.management.server.service;

import java.util.Map;

/**
 * 显示用户评价表与开线建议表中间表的总数、评价管理建议回复表总数、评价管理评价回复表总数的service层接口
 * @author 曹嵩
 * @date 2015.7.3
 */
public interface IBusRedPointService {

	/**
	 * 得到小红点的总数
	 * @param isAdmin 是否是管理员
	 * @return 总数
	 * @throws Exception
	 */
	public Map<String, Integer> getCount(String isAdmin,String userId) throws Exception;
}
