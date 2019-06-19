package com.deppon.dpm.doc.server.dao.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDidiTicketDao;
import com.deppon.dpm.doc.server.entity.DidiTicketEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DidiTicketDao extends iBatis3DaoImpl  implements IDidiTicketDao {

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.impl.DidiTicketDao";
	
	@Override
	public Integer insert(DidiTicketEntity didiTicket) {
		this.getSqlSession().insert(NAME_SPACE+".insertDidiTicket", didiTicket);
		return 0;
	}

	@Override
	public DidiTicketEntity find(DidiTicketEntity didiTicket) {
		DidiTicketEntity list =  (DidiTicketEntity) this.getSqlSession().selectOne(NAME_SPACE+".listDidiTicket", didiTicket);
		return list;
	}

	@Override
	public Integer update(DidiTicketEntity didiTicket) {
		this.getSqlSession().update(NAME_SPACE+".updateDidiTicket", didiTicket);
		return 0;
	}

	@Override
	public int delete(DidiTicketEntity didiTicket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBatch(String ids) {
		this.getSqlSession().delete(NAME_SPACE+".deleteDidiTicket", ids);
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DidiTicketEntity> queryByFlag(String userId) {
		List<DidiTicketEntity> entityList = this.getSqlSession().selectList(NAME_SPACE+".listEntityByFlag", userId);
		return entityList;
	}

}
