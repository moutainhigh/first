package com.deppon.dpm.module.management.server.service;


public interface IMainPageService {
	/**
	 * 每个人所拥有的卡片
	 * @return
	 */
	public String cardDetailByUserId(String userId);
	/**
	 * 获取消息类型
	 * @return
	 */
	//public List<NoticeCenterEntity> getType();
}
