package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IAppToUseTimeMonitorService;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.AppToUseTimeMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.opensymphony.xwork2.ModelDriven;

public class AppToUseTimeMonitorAction extends BaseAction implements ModelDriven<AppToUseTimeMonitorEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(AppToUseTimeMonitorAction.class);
	
	private AppToUseTimeMonitorEntity entity = new AppToUseTimeMonitorEntity();
	
	private IAppToUseTimeMonitorService appToUseTimeMonitorService;
	
	/**
	 * getModel
	 */
	@Override
	public AppToUseTimeMonitorEntity getModel() {
		return entity;
	}
	
	/**
	 * 保存用户使用app时长监控
	 */
	public void save() {
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			EmpExtensionEntity empExtensionEntity = loginResult.getEmpExtensionEntity();
			entity.setOsType(loginResult.getOsType());
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setDeviceToken(empExtensionEntity == null ? null : empExtensionEntity.getDeviceToken());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setOsVersion(loginResult.getOsVersion());
		} catch (Exception e) {
			LOG.error("AppToUseTimeMonitorAction保存用户使用时长监控获取登录结果集出错>>>>",e);
		}
		try {
			appToUseTimeMonitorService.save(entity);
		} catch (Exception e) {
			LOG.error("保存用户使用时长监控出错>>>> " + entity.toString(), e);
		}
	}

	/**
	 * setter
	 */
	public void setAppToUseTimeMonitorService(
			IAppToUseTimeMonitorService appToUseTimeMonitorService) {
		this.appToUseTimeMonitorService = appToUseTimeMonitorService;
	}
	
}
