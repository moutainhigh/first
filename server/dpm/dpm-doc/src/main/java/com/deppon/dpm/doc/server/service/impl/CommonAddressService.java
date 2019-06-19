package com.deppon.dpm.doc.server.service.impl;

import com.deppon.dpm.doc.server.dao.ICommonAddressDao;
import com.deppon.dpm.doc.server.service.ICommonAddressService;

public class CommonAddressService implements ICommonAddressService{

	/**
	 * 注入DAO
	 */
	private ICommonAddressDao commonAddressDao;

	public ICommonAddressDao getCommonAddressDao() {
		return commonAddressDao;
	}

	public void setCommonAddressDao(ICommonAddressDao commonAddressDao) {
		this.commonAddressDao = commonAddressDao;
	}
}
