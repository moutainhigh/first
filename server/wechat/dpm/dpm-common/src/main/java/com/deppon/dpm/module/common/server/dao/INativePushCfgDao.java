package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;

/**
 * dao
 */
public interface INativePushCfgDao {

	// 分页查询
	List<NativePushCfgEntity> list(int start, int rows);

	// 查询总条数
	long queryCount();

	// 根据id删除
	void deleteByIds(String[] ids);

	void update(NativePushCfgEntity entity);

	void save(NativePushCfgEntity entity);

	// 查询所有有效的
	List<NativePushCfgEntity> queryUsableAll();

}
