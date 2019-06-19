package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IOrderMessageDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IOrderMessageService;

public class OrderMessageService implements IOrderMessageService{

	private IOrderMessageDao orderMessageDao;
	
	@Override
	public List<DidiOrderEntity> findOrderMessage(String userId) {
		return orderMessageDao.findOrderMessage(userId);
	}
	
	@Override
	public List<DidiOrderEntity> findTodayOrder(String userId) {

		return orderMessageDao.findTodayOrder(userId);
	}

	/**
	 * @return the orderMessageDao
	 */
	public IOrderMessageDao getOrderMessageDao() {
		return orderMessageDao;
	}

	/**
	 * @param orderMessageDao the orderMessageDao to set
	 */
	public void setOrderMessageDao(IOrderMessageDao orderMessageDao) {
		this.orderMessageDao = orderMessageDao;
	}

}
