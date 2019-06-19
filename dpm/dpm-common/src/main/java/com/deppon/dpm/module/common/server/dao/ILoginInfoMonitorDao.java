package com.deppon.dpm.module.common.server.dao;

import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.MobileInfoVo;

public interface ILoginInfoMonitorDao {

	void saveLoginInfo(LoginInfoMonitorEntity entity);
	
	void saveMobileInfo(MobileInfoVo moVo);

}
