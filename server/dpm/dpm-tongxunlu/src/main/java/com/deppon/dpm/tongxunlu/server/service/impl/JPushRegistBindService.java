package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IJPushRegistBindDao;
import com.deppon.dpm.tongxunlu.server.service.IJPushRegistBindService;
import com.deppon.dpm.tongxunlu.shared.domain.JPushRegistBindEntity;

public class JPushRegistBindService implements IJPushRegistBindService{

	private IJPushRegistBindDao jPushRegistBindDao;

	public List<String> queryRegistIdByUserIds(String[] userIdArr) {
		return jPushRegistBindDao.queryRegistIdByUserIds(userIdArr);
	}
	
	public JPushRegistBindEntity queryByRegistId(String registId) {
		return jPushRegistBindDao.queryByRegistId(registId);
	}
	
	public void save(JPushRegistBindEntity entity) {
		jPushRegistBindDao.save(entity);
	}
	
	public void update(JPushRegistBindEntity entity) {
		jPushRegistBindDao.update(entity);
	}
	
	@Override
	public List<String> queryJpushRegistIdsByJoblevels(String joblevels) {
		return jPushRegistBindDao.queryJpushRegistIdsByJoblevels(joblevels.split(","));
	}
	
	@Override
	public List<String> queryJpushRegistIdsByJobnames(String jobnames) {
		return jPushRegistBindDao.queryJpushRegistIdsByJobnames(jobnames.split(","));
	}
	
	@Override
	public List<String> queryJpushRegistIdsByPrimaryDepts(String primaryDepts) {
		return jPushRegistBindDao.queryJpushRegistIdsByPrimaryDepts(primaryDepts.split(","));
	}
	
	// setter
	public void setjPushRegistBindDao(IJPushRegistBindDao jPushRegistBindDao) {
		this.jPushRegistBindDao = jPushRegistBindDao;
	}

	@Override
	public void saveLogoutInfo(Map<String, String> param) {
		jPushRegistBindDao.saveLogoutInfo(param);
	}
	
}
