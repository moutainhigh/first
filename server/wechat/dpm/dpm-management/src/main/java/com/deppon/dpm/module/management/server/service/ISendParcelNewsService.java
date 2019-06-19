package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.SendParcelNewsEntity;

/**
 * @author 268101
 * 
 *收发室推送消息接口
 */
public interface ISendParcelNewsService {
	/**
	 * @return 得到未发送的消息数据
	 * @throws Exception 抛出异常
	 */
	public List<SendParcelNewsEntity> getNews(String userNo) throws Exception;
	
	/**
	 * @param userNo 用户工号
	 * @return str
	 * @throws Exception 抛出异常
	 */
	public String getPushNews(String userNo) throws Exception;
	
	/**
	 * @param listNews 消息list
	 * @return 是否更新成功
	 */
	public int updateNews(String userNo) ;
	

}
