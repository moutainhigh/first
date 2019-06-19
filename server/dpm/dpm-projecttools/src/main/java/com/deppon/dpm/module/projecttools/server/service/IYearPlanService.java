package com.deppon.dpm.module.projecttools.server.service;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 项目管理 年度规划 service
 * @author gcl
 */
public interface IYearPlanService {
	
	/**
     * 查询年度规划项目列表
     */
    public String projList(String userId) throws BusinessException;
    /**
     * 根据项目编号 获得项目规划详情和资源信息
     * @param projectId 项目编号
     * @param ghType 项目类型
     * @return
     */
	public String projInfo(int projectId,int ghType);
}
