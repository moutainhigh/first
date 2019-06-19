package com.deppon.dpm.doc.server.service.impl;

import com.deppon.dpm.doc.server.dao.IVisitCustomerDao;
import com.deppon.dpm.doc.server.service.IVisitCustomerService;

public class VisitCustomerService implements IVisitCustomerService {
	
	//注入Dao
	private IVisitCustomerDao visitCustomerDao;

	public IVisitCustomerDao getVisitCustomerDao() {
		return visitCustomerDao;
	}

	public void setVisitCustomerDao(IVisitCustomerDao visitCustomerDao) {
		this.visitCustomerDao = visitCustomerDao;
	}
}
