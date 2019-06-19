package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.JpushMsgCentreEntity;

public interface IJpushMsgCentreService {

	public void save(JpushMsgCentreEntity entity);

	public List<JpushMsgCentreEntity> queryMsgByEmp(EmployeeEntity employee);

	public void cleanExpireData();
}
