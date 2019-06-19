package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.ProjectManageDeptEntity;

/**
 * 工程管理部门Service
 */
public interface IProjectManageDeptService {

	// 分页查询
	List<ProjectManageDeptEntity> list(int page, int rows);

	// 删除
	void delete(ProjectManageDeptEntity entity);

	// 保存
	void save(ProjectManageDeptEntity entity);

	// 查询总记录数
	long queryCount();

}
