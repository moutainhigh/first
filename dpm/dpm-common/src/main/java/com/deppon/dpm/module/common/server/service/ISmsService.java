package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.SmsEntity;

/**
 * 短信开关
 *
 */
public interface ISmsService {

	// 根据工号查询
	List<SmsEntity> queryByEmpcode(String userId);

	// 删除
	void delete(int id);

	// 更新
	void update(SmsEntity entity);

	// 新增
	void insert(SmsEntity entity);

}
