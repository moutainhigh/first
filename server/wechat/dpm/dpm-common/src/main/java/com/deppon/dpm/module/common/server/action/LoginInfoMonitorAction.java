package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.ILoginInfoMonitorService;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 登录信息（含登录地点）
 */
public class LoginInfoMonitorAction extends BaseAction implements ModelDriven<LoginInfoMonitorEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(LoginInfoMonitorAction.class);
	
	private LoginInfoMonitorEntity entity = new LoginInfoMonitorEntity();
	
	private ILoginInfoMonitorService loginInfoMonitorService;
	
	@Override
	public LoginInfoMonitorEntity getModel() {
		return entity;
	}

	public void saveLoginInfo(){
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			EmpExtensionEntity empExtensionEntity = loginResult.getEmpExtensionEntity();
			entity.setOsType(loginResult.getOsType());
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setDeviceToken(empExtensionEntity == null ? null : empExtensionEntity.getDeviceToken());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setOsVersion(loginResult.getOsVersion());
			entity.setPhoneMac(empExtensionEntity == null ? null : empExtensionEntity.getPhoneMac());
			entity.setLoginTime(empExtensionEntity == null ? null : empExtensionEntity.getLoginTime());
		} catch (Exception e) {
			LOG.error("LoginInfoMonitorAction保存登录信息获取登录结果集出错>>>>",e);
		}
		try {
			loginInfoMonitorService.saveLoginInfo(entity);
		} catch (Exception e) {
			LOG.error("LoginInfoMonitorAction保存登录信息出错>>>>" + entity.toString(),e);
		}
	}

	// setter
	public void setLoginInfoMonitorService(
			ILoginInfoMonitorService loginInfoMonitorService) {
		this.loginInfoMonitorService = loginInfoMonitorService;
	}

}
