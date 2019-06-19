package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.ILoginInfoMonitorDao;
import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.MobileInfoVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class LoginInfoMonitorDao extends iBatis3DaoImpl implements ILoginInfoMonitorDao {

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.LoginInfoMonitorDao.";
	
	/**
	 * 保存登录信息
	 */
	public void saveLoginInfo(LoginInfoMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "saveLoginInfo", entity);
	}
	
	/**
	 * 保存登录信息
	 */
	public void saveMobileInfo(MobileInfoVo moVo) {
		this.getSqlSession().insert(NAME_SPACE + "saveMobileInfo", moVo);
	}

}
