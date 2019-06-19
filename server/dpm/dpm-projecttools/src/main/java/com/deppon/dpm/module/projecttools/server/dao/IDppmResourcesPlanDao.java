package com.deppon.dpm.module.projecttools.server.dao;

import java.util.List;

import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesDeptEntity;
import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesPeoEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 资源计划Dao
 * @author 251624
 *
 */
public interface IDppmResourcesPlanDao {
    /**
     * 资源计划-部门人员占比和任务工时(有子部门)
     * @param userId
     * @param date
     * @return
     * @throws BusinessException
     */
    public List<DppmResourcesDeptEntity> getDeptResourcesInfo(String userId,String date) throws BusinessException;
    
    /**
     * 资源计划-部门人员占比和任务工时(无子部门或普通员工)
     * @param userId
     * @param date
     * @param flag
     * @return
     * @throws BusinessException
     */
    public List<DppmResourcesPeoEntity> getPeoResourcesInfo(String userId,String date) throws BusinessException;
    
    /**
     * 获取工号管理部门数
     * @param userId
     * @return
     * @throws BusinessException
     */
    public int getSubDeptCount(String userId) throws BusinessException;
    
    /**
     * 获取工号所属的部门的资源信息
     * @param userId
     * @param date
     * @return
     * @throws BusinessException
     */
    public DppmResourcesDeptEntity getDeptStaInfoByUser(String userId,String date) throws BusinessException;
}
