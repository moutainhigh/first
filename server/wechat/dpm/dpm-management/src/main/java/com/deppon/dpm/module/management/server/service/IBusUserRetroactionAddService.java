package com.deppon.dpm.module.management.server.service;


/**
 * 添加用户评价的service层接口
 * @author 曹嵩
 * @date 2015.6.30
 */
public interface IBusUserRetroactionAddService {

	/**
	 * 添加用户评价方法
	 * @param strJson 前台发过来的json数据
	 * @return
	 * @throws Exception
	 */
	public int saveBusUserRetroaction(String strJson) throws Exception;
}

