package com.deppon.dpm.module.projecttools.server.service;

/**
 * 项目评级 service
 * @author gcl
 * 2015-09-25
 */
public interface IProjectGradeService {
	
	/**
	 * 根据项目编号获得项目四个评级信息
	 * @param projectCode 项目编号
	 * @return 评级信息
	 * @throws Exception
	 */
	public String gradeInfo(int projectCode);
	/**
	 * 根据评级编号获得项目评级详情
	 * @param gradeId 评级编号
	 * @return 评级详情
	 * @throws Exception
	 */
	public String gradeBillInfo(String gradeId);
}
