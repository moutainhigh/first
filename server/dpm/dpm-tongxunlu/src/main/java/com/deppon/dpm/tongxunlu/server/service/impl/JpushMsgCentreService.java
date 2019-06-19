package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.server.dao.IJpushMsgCentreDao;
import com.deppon.dpm.tongxunlu.server.service.IJpushMsgCentreService;
import com.deppon.dpm.tongxunlu.shared.domain.JpushMsgCentreEntity;

public class JpushMsgCentreService implements IJpushMsgCentreService{
	
	private IJpushMsgCentreDao jpushMsgCentreDao;

	@Override
	public void save(JpushMsgCentreEntity entity) {
		jpushMsgCentreDao.save(entity);
	}
	
	@Override
	public List<JpushMsgCentreEntity> queryMsgByEmp(EmployeeEntity employee) {
		return jpushMsgCentreDao.queryMsgByEmp(employee);
	}
	
	@Override
	public void cleanExpireData() {
		jpushMsgCentreDao.cleanExpireData();
	}

	public void setJpushMsgCentreDao(IJpushMsgCentreDao jpushMsgCentreDao) {
		this.jpushMsgCentreDao = jpushMsgCentreDao;
	}

}
