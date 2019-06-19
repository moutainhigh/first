package com.deppon.dpm.module.projecttools.server.dao;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * 
 * 项目管理 年度规划 Interface
 *
 * @author 195406 高春玲
 * @date 2015-10-16
 **/
public interface IYearPlanDao {
	/**
     * 查询年度规划项目列表
     */
    public String projList(String userId) throws BusinessException ;
    /**
     * 根据项目编号 获得项目规划详情和资源信息
     * @param project_id 项目编号
     * @param gh_type 项目类型
     * @return
     */
	public String projInfo(int projectId,int ghType) ;
}
