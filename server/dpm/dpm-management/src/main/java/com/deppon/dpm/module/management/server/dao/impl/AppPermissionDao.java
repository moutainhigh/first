package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IAppPermissionDao;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class AppPermissionDao extends iBatis3DaoImpl implements IAppPermissionDao {
	/**
	 * namespace
	 */
	private static final String NAME_SPACE =  "com.deppon.dpm.module.management.server.dao.impl.AppPermissionDao.";
	@SuppressWarnings("unchecked")
	@Override
	public List<AppPermissionEntity> getAppPermission(
			int appid) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectPermission", appid);
	}
	@Override
	public String getDeptSeqByUserId(String userId) {
		// TODO Auto-generated method stub
		return (String)this.getSqlSession().selectOne(NAME_SPACE + "selectDeptseq", userId);
	}
 
}
