package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.DepEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmpEntity;

public interface IDepartmentDao{
    /**
     * 根据名称模糊查询部门信息
     * @param text
     * @return
     * @throws Exception
     */
    public List<DepEntity> getOrgList(String text) ;
    //根据工号或者姓名模糊查询合同部门人员
    public List<EmpEntity> getEmpList(String emp);
    //查询部门code
    public String getDeptCode(String userId);
}
