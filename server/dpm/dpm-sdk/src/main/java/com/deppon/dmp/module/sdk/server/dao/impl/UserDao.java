package com.deppon.dmp.module.sdk.server.dao.impl;

import java.util.List;

import com.deppon.dmp.module.sdk.server.dao.IUserDao;
import com.deppon.dmp.module.sdk.shared.SDKConstants;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UserDao extends iBatis3DaoImpl implements IUserDao {

	@Override
	public List<String> queryAllUser(String sysCode) {
		List<String> list = getSqlSession().selectList(SDKConstants.USER_PREDIX + "queryAllUser", sysCode);
		return list;
	}

}
