package com.deppon.dpm.module.wfs.server.dao.impl;

import com.deppon.dpm.module.wfs.server.dao.IEmployeeInfoDao;
import com.deppon.dpm.module.wfs.shared.domain.EmployeeInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 根据工号查询员工信息
 * @author 276344
 *
 */
public class EmployeeInfoDao extends iBatis3DaoImpl implements IEmployeeInfoDao {
	private static final String NAME_SPACE="com.deppon.dpm.module.wfs.server.dao.workitems.";
	@Override
	public EmployeeInfo getEmployeeInfoByEmpcode(String empCode) {
		
		return (EmployeeInfo) getSqlSession().selectOne(NAME_SPACE + "queryEmployeeInfo", empCode);

	}

}
