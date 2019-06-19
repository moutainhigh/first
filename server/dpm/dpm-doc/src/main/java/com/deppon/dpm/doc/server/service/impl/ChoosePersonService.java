package com.deppon.dpm.doc.server.service.impl;

import com.deppon.dpm.doc.server.dao.IChoosePersonDao;
import com.deppon.dpm.doc.server.service.IChoosePersonService;

public class ChoosePersonService implements IChoosePersonService{
	
	//选择人员Dao
	private IChoosePersonDao choosePersonDao;

	public IChoosePersonDao getChoosePersonDao() {
		return choosePersonDao;
	}

	public void setChoosePersonDao(IChoosePersonDao choosePersonDao) {
		this.choosePersonDao = choosePersonDao;
	}

	
}
