package com.deppon.dmp.module.sdk.server.dao;

import java.util.List;

public interface IUserDao {
	
	List<String> queryAllUser(String sysCode);
	
}
