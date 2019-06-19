package com.deppon.dmp.module.sdk.server.service.impl;

import java.util.List;

import com.deppon.dmp.module.sdk.server.dao.IUserDao;
import com.deppon.dmp.module.sdk.server.service.IUserService;

public class UserService implements IUserService {

	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<String> queryAllUser(String sysCode) {
		return userDao.queryAllUser(sysCode);
	}

}
