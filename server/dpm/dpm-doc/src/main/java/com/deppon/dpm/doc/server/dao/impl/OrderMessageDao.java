package com.deppon.dpm.doc.server.dao.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IOrderMessageDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class OrderMessageDao extends iBatis3DaoImpl implements IOrderMessageDao{
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiOrderDao";
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> findOrderMessage(String userId) {
		
		return getSqlSession().selectList(NAME_SPACE+".findordermessage",userId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderEntity> findTodayOrder(String userId) {
		
		return getSqlSession().selectList(NAME_SPACE+".findtodayorder",userId);
	}

}
