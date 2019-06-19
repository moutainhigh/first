package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.SmsEntity;

/**
 * 短信开关
 *
 */
public interface ISmsDao {

	// 根据工号查询
	List<SmsEntity> queryByEmpcode(String userId);

	// 删除
	void delete(int id);

	void update(SmsEntity entity);

	void insert(SmsEntity entity);

}
