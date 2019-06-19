package com.deppon.dpm.module.projecttools.server.service.impl;

import com.deppon.dpm.module.projecttools.server.dao.IYearPlanDao;
import com.deppon.dpm.module.projecttools.server.service.IYearPlanService;
/**
 * 项目管理 年度规划 service
 * @author gcl
 * @date 2015-10-16
 */
public class YearPlanService implements IYearPlanService {
	// 引入 dao层
	private IYearPlanDao dao;
	
	/**
     * 查询年度规划项目列表
     */
    public String projList(String userId) throws Exception {
		// 调用 查询方法
        return this.dao.projList(userId);
	}
    /**
     * 根据项目编号 获得项目规划详情和资源信息
     * @param projectId 项目编号
     * @param ghType 项目类型
     * @return
     */
	public String projInfo(int projectId,int ghType) {
		return this.dao.projInfo(projectId, ghType);
	}

	/**
	 * @param dao
	 */
	public void setDao(IYearPlanDao dao) {
		this.dao = dao;
	}

	
}
