package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.GestureEntity;

/**
 * 手势密码
 *
 */
public interface IGestureDao {

	// 根据工号查询
	GestureEntity queryByEmpcode(String userId);

	// 根据工号删除
	void deleteByEmpcode(String userId);

	// 更新
	void update(GestureEntity entity);

}
