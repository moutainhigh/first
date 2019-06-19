package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;

/**
 * 系统版本更新控制
 */
public interface IVersionUpdateControlService {

	// 列表查询
	List<VersionUpdateControlEntity> list();

	// 保存
	void save(VersionUpdateControlEntity entity);

	// 根据id删除
	void deleteById(int id);

	// 根据id更新
	void update(VersionUpdateControlEntity versionUpdateControlEntity);

}
