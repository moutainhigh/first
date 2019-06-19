package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDidiTicketDao;
import com.deppon.dpm.doc.server.entity.DidiTicketEntity;
import com.deppon.dpm.doc.server.service.IDidiTicketService;

public class DidiTicketService implements IDidiTicketService {

	private IDidiTicketDao didiTicketDao;
	
	@Override
	public Integer insert(DidiTicketEntity didiTicket) {
		return didiTicketDao.insert(didiTicket);
	}

	@Override
	public DidiTicketEntity find(DidiTicketEntity didiTicket) {
		return didiTicketDao.find(didiTicket);
	}

	@Override
	public Integer update(DidiTicketEntity didiTicket) {
		return didiTicketDao.update(didiTicket);
	}

	@Override
	public int delete(DidiTicketEntity didiTicket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBatch(String ids) {
		return didiTicketDao.deleteBatch(ids);
	}

	public IDidiTicketDao getDidiTicketDao() {
		return didiTicketDao;
	}

	public void setDidiTicketDao(IDidiTicketDao didiTicketDao) {
		this.didiTicketDao = didiTicketDao;
	}

	@Override
	public List<DidiTicketEntity> queryByFlag(String userId) {
		// TODO Auto-generated method stub
		return didiTicketDao.queryByFlag(userId);
	}

	
}
