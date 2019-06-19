package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IVisitorSmsSendLogDao;
import com.deppon.dpm.module.common.shared.domain.VisitorSmsSendInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 访客系统日志保存dao实现类
 * 
 */
public class VisitorSmsSendLogDaoImpl extends iBatis3DaoImpl implements
		IVisitorSmsSendLogDao {

	// NAME_SPACE
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.shared.domain.VisitorSmsSendInfo.";

	/**
	 * 保存访客系统短信发送日志记录
	 * 
	 * @param entity
	 */
	@Override
	public void saveSmsSendLog(VisitorSmsSendInfo entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

}
