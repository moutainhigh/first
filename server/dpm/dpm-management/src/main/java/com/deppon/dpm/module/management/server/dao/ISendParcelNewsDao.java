package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.SendParcelNewsEntity;
import com.deppon.foss.framework.exception.BusinessException;

public interface ISendParcelNewsDao {
	/**
	 * @return 得到未发送的消息数据
	 * @throws BusinessException 抛出异常
	 */
	public List<SendParcelNewsEntity> getNews(String userNo) throws BusinessException;
	
	/**
	 * @param listNews 消息list
	 * @return 是否更新成功
	 */
	public int updateNews(String userNo) ;

}
