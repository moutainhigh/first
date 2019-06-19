package com.deppon.dpm.module.projecttools.server.service.impl;

import com.deppon.dpm.module.projecttools.server.dao.ICommonDao;
import com.deppon.dpm.module.projecttools.server.service.ICommonService;
/**
 * dppm 公共 service
 * @author gcl
 */
public class CommonService implements ICommonService {
	// 引入 dao层
	private ICommonDao dao;
	
	/**
	 * 查询人员信息
	 * @param code 工号或者姓名
	 * @return
	 * @throws Exception
	 */
	public String chooseEmp(String code,int status) throws Exception {
		return this.dao.chooseEmp(code,status);
	}
	/**
	 * 查询验收模块信息
	 * @return
	 */
	public String checkmodule() {
		return this.dao.checkmodule();
	}
	/**
	 * 查询任务类别
	 * @return
	 */
	public String taskType() {
		return this.dao.taskType();
	}
	/**
	 * 任务新建时   关联的项目选择器  
	 * 查询我的项目数据 ( 项目管理办公室 DP08466, IT项目管理组 DP10556 )
	 * @param userId 当前用户工号
	 * @param projName 搜索的项目名称
	 */
	public String searchProjList(String userId,String projName) {
		return this.dao.searchProjList(userId, projName);
	}
	/**
	 * 用户需求选择器
	 * 根据需求名称 进行模糊搜素
	 * @param demandName
	 * @return
	 */
	public String searchUserDemand(String demandName) {
		return this.dao.searchUserDemand(demandName);
	}
	/**
	 * 任务新建时   关联的父任务选择器  
	 * 查询当前用户是任务分配者或处理者，根据任务类别或项目名称查询出 任务状态是已分配或者进行中的任务集合
	 * @param userId 当前用户工号
	 * @param projCode 项目编号
	 * @param type 任务类别 项目类任务：1    管理事务类任务：2    日常需求类任务：3      常规工作类任务：4
	 */
	public String searchPtaskList(String userId,String projCode,int type) {
		return this.dao.searchPtaskList(userId, projCode, type);
	}
	/**
	 * 系统需求选择器
	 * 根据需求编号 进行模糊搜素
	 * @param demandCode
	 * @return
	 */
	public String searchSysDemand(String demandCode,String userDemandCode) {
		return this.dao.searchSysDemand(demandCode, userDemandCode);
	}
	/**
	 * 任务开发语言
	 * 当任务类型是开发任务时 需要填写开发语言
	 * @return
	 */
	public String searchDevLang() {
		return this.dao.searchDevLang();
	}
	
	/**
	 * @param dao
	 */
	public void setDao(ICommonDao dao) {
		this.dao = dao;
	}

}
