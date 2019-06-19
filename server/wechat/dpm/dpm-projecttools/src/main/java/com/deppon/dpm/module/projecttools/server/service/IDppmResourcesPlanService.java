package com.deppon.dpm.module.projecttools.server.service;

import java.util.Map;


public interface IDppmResourcesPlanService {
   /**
    * 资源计划-部门人员占比
    * @param userId
    * @param date
    * @return
    * @throws Exception
    */
    public Map<String,Object> getDeptPeopleInfo(String userId,String date)throws Exception;
}
