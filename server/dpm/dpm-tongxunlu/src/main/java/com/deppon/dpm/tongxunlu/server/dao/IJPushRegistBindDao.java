package com.deppon.dpm.tongxunlu.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.JPushRegistBindEntity;

public interface IJPushRegistBindDao {

	List<String> queryRegistIdByUserIds(String[] userIdArr);

	JPushRegistBindEntity queryByRegistId(String registId);

	void save(JPushRegistBindEntity entity);

	void update(JPushRegistBindEntity entity);

	List<String> queryJpushRegistIdsByJoblevels(String[] joblevelArr);

	List<String> queryJpushRegistIdsByJobnames(String[] jobnameArr);

	List<String> queryJpushRegistIdsByPrimaryDepts(String[] split);
	
	void saveLogoutInfo(Map<String,String> param);

}
