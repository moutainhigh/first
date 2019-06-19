package com.deppon.dpm.module.common.server.service;

import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.MobileInfoVo;

public interface ILoginInfoMonitorService {

	void saveLoginInfo(LoginInfoMonitorEntity entity);
	
	void saveMobileInfo(MobileInfoVo moVo);

}
