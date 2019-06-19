package com.deppon.dpm.module.projecttools.server.service;

import java.util.Map;

import com.deppon.foss.framework.exception.BusinessException;


public interface IDppmResourcesPlanService {
   /**
    * 资源计划-部门人员占比
    * @param userId
    * @param date
    * @return
    * @throws BusinessException
    */
    public Map<String,Object> getDeptPeopleInfo(String userId,String date)throws BusinessException;
}
