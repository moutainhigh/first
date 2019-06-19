package com.deppon.dpm.module.common.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;

/**
 * service
 */
public interface INativePushCfgService {

	// 分页查询
	List<NativePushCfgEntity> list(int start, int rows);

	// 查询总条数
	long queryCount();

	// 根据id删除
	void deleteByIds(String ids);

	// 更新
	void update(NativePushCfgEntity entity);

	// 保存
	void save(NativePushCfgEntity entity);

	// 根据名称查询部门信息
	List<Map<String, String>> queryOrgByName(String orgName);

	// 查询所有有效的
	List<NativePushCfgEntity> queryUsableAll();

}
