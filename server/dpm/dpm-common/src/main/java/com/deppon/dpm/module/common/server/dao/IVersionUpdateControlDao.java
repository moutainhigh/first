package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;

/**
 * 系统版本更新权限控制
 */
public interface IVersionUpdateControlDao {

	// 列表查询
	List<VersionUpdateControlEntity> list();

	// 保存
	void save(VersionUpdateControlEntity entity);

	// 根据id查询
	VersionUpdateControlEntity queryById(int id);

	// 根据id删除
	void delById(int id);

	// 根据id更新
	void update(VersionUpdateControlEntity entity);

	// 根据type查询
	List<VersionUpdateControlEntity> queryByType(String type);

}
