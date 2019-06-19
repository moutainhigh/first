package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IProjectManageDeptDao;
import com.deppon.dpm.module.common.server.service.IProjectManageDeptService;
import com.deppon.dpm.module.common.shared.domain.ProjectManageDeptEntity;

/**
 * 工程管理部门Service
 */
public class ProjectManageDeptService implements IProjectManageDeptService{

	// dao
	private IProjectManageDeptDao projectManageDeptDao;


	// 查询
	public List<ProjectManageDeptEntity> list(int page, int rows) {
		return projectManageDeptDao.list(page,rows);
	}

	// 删除
	public void delete(ProjectManageDeptEntity entity) {
		String orgcode = entity.getOrgcode();
		String[] orgcodeArray = orgcode.split(",");
		projectManageDeptDao.delete(orgcodeArray);
	}

	// 新增
	public void save(ProjectManageDeptEntity entity) {
		projectManageDeptDao.save(entity);
	}
	
	// 查询总记录数
	public long queryCount() {
		return projectManageDeptDao.queryCount();
	}
	
	// setter
	public void setProjectManageDeptDao(IProjectManageDeptDao projectManageDeptDao) {
		this.projectManageDeptDao = projectManageDeptDao;
	}
}
