package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.JPushRegistBindEntity;

public interface IJPushRegistBindService {

	List<String> queryRegistIdByUserIds(String[] userIdArr);

	JPushRegistBindEntity queryByRegistId(String registId);

	void save(JPushRegistBindEntity entity);

	void update(JPushRegistBindEntity entity);

	List<String> queryJpushRegistIdsByJoblevels(String trim);

	List<String> queryJpushRegistIdsByJobnames(String trim);

	List<String> queryJpushRegistIdsByPrimaryDepts(String trim);
	
	void saveLogoutInfo(Map<String, String> param);

}
