package com.deppon.dpm.module.projecttools.server.service.impl;

import com.deppon.dpm.module.projecttools.server.dao.IProjectGradeDao;
import com.deppon.dpm.module.projecttools.server.service.IProjectGradeService;
/**
 * 项目评级 service
 * @author gcl
 * 2015-09-25
 */
public class ProjectGradeService implements IProjectGradeService {
	// 引入 dao层
	private IProjectGradeDao dao;
	
	/**
	 * 根据项目编号获得项目四个评级信息
	 * @param projectCode 项目编号
	 * @return 评级信息
	 * @throws Exception
	 */
	public String gradeInfo(int projectCode) {
		return this.dao.gradeInfo(projectCode);
	}
	/**
	 * 根据评级编号获得项目评级详情
	 * @param gradeId 评级编号
	 * @return 评级详情
	 * @throws Exception
	 */
	public String gradeBillInfo(String gradeId) {
		return this.dao.gradeBillInfo(gradeId);
	}

	/**
	 * @param dao
	 */
	public void setDao(IProjectGradeDao dao) {
		this.dao = dao;
	}
	
}
