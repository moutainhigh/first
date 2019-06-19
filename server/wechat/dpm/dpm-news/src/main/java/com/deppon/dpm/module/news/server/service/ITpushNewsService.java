package com.deppon.dpm.module.news.server.service;

import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.foss.framework.service.IService;

/**
 * @author zzwjrl
 * 
 */
public interface ITpushNewsService extends IService {

	/**
	 * 对指定用户进行应用系统消息提醒推送
	 * */
	String pushUserNews(String empCode, String messageTitle,
			String messageContent, NewsCenterEntity newsCenterEntity);

	/**
	 * 对所有用户进行应用系统消息提醒推送
	 */
	void pushAllUserNew(String messageTitle, String messageContent,
			NewsCenterEntity newsCenterEntity);

	/**
	 * 根据uuid获取对应信息
	 * 
	 * @param uuid
	 * @return
	 */
	public Object getMessage(String uuid);

}
