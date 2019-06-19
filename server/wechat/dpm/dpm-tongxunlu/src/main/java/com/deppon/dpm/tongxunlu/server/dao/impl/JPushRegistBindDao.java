package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.List;

import com.deppon.dpm.tongxunlu.server.dao.IJPushRegistBindDao;
import com.deppon.dpm.tongxunlu.shared.domain.JPushRegistBindEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class JPushRegistBindDao extends iBatis3DaoImpl implements IJPushRegistBindDao{
	
	private static final String NAME_SPACE = "com.deppon.dpm.tongxunlu.server.dao.impl.JPushRegistBindDao.";

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryRegistIdByUserIds(String[] userIdArr) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryRegistIdByUserIds", userIdArr);
	}

	@Override
	public JPushRegistBindEntity queryByRegistId(String registId) {
		return (JPushRegistBindEntity) this.getSqlSession().selectOne(NAME_SPACE + "queryByRegistId", registId);
	}

	public void save(JPushRegistBindEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	@Override
	public void update(JPushRegistBindEntity entity) {
		this.getSqlSession().update(NAME_SPACE + "update", entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryJpushRegistIdsByJoblevels(String[] joblevelArr) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryJpushRegistIdsByJoblevels", joblevelArr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryJpushRegistIdsByJobnames(String[] jobnameArr) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryJpushRegistIdsByJobnames", jobnameArr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryJpushRegistIdsByPrimaryDepts(String[] primaryDeptArr) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryJpushRegistIdsByPrimaryDepts", primaryDeptArr);
	}
	
}
