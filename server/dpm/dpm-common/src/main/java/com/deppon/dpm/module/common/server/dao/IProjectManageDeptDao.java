package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.ProjectManageDeptEntity;

public interface IProjectManageDeptDao {

	// 删除
	void delete(String[] orgcodes);

	// 分页查询
	List<ProjectManageDeptEntity> list(int page, int rows);

	// 新增
	void save(ProjectManageDeptEntity entity);

	// 查询总记录数
	long queryCount();

}
