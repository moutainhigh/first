package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.SendParcelNewsEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 268101
 * 
 *收发室推送消息接口
 */
public interface ISendParcelNewsService {
	/**
	 * @return 得到未发送的消息数据
	 * @throws BusinessException 抛出异常
	 */
	public List<SendParcelNewsEntity> getNews(String userNo) throws BusinessException;
	
	/**
	 * @param userNo 用户工号
	 * @return str
	 * @throws BusinessException 抛出异常
	 */
	public String getPushNews(String userNo) throws BusinessException;
	
	/**
	 * @param listNews 消息list
	 * @return 是否更新成功
	 */
	public int updateNews(String userNo) ;
	

}
