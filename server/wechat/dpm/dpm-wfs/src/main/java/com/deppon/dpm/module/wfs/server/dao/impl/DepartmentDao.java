package com.deppon.dpm.module.wfs.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.IDepartmentDao;
import com.deppon.dpm.module.wfs.shared.domain.DepEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmpEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DepartmentDao extends iBatis3DaoImpl  implements IDepartmentDao{
    private static String nameSpace = "com.deppon.dpm.module.wfs.server.dao.workitems.";
    /**
     * 根据名称模糊查询部门信息
     * @param text
     * @return
     * @throws Exception
     */
    @Override
    public List<DepEntity> getOrgList(String text) throws Exception {
        // TODO Auto-generated method stub
        return (List<DepEntity>)this.getSqlSession().selectList(nameSpace  + "selectDepartment", text);
    }
  //根据工号或者姓名模糊查询合同部门人员
	@Override
	public List<EmpEntity> getEmpList(String emp) throws Exception {
		// TODO Auto-generated method stub
		return (List<EmpEntity>)this.getSqlSession().selectList(nameSpace  + "selectEmp", emp);
	}
	   /**
     * 根据userId查询部门信息
     * @return
     * @throws Exception
     */
	@Override
	public String getDeptCode(String userId) {
		// TODO Auto-generated method stub
		return (String) this.getSqlSession().selectOne(nameSpace+"getDeptCode",userId);
	}
	
}
