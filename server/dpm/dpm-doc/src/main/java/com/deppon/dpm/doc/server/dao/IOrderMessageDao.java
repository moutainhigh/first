package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;

/**
 * @author Administrator
 *
 */
public interface IOrderMessageDao {
	
	/**
	 *查询服务中及预约订单信息
	 */
	public List<DidiOrderEntity> findOrderMessage(String userId);
	/**
	 *查询用户当天的订单信息
	 */
	public List<DidiOrderEntity> findTodayOrder(String userId);
	
}
