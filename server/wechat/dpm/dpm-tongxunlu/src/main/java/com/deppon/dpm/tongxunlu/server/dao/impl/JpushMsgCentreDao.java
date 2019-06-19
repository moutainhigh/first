package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.server.dao.IJpushMsgCentreDao;
import com.deppon.dpm.tongxunlu.shared.domain.JpushMsgCentreEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class JpushMsgCentreDao extends iBatis3DaoImpl implements IJpushMsgCentreDao{

	private static final String NAME_SPACE = "com.deppon.dpm.tongxunlu.server.dao.impl.JpushMsgCentreDao.";
	
	@Override
	public void save(JpushMsgCentreEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save",entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JpushMsgCentreEntity> queryMsgByEmp(EmployeeEntity employee) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryMsgByEmp", employee);
	}

	@Override
	public void cleanExpireData() {
		this.getSqlSession().delete(NAME_SPACE + "cleanExpireData");
	}

}
