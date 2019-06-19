package com.deppon.dpm.module.projecttools.server.dao;

/**
 * 
 * 项目评级 dao Interface
 *
 * @author 195406 高春玲
 * @date 2015-9-25 下午1:45:08
 **/
public interface IProjectGradeDao {
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
