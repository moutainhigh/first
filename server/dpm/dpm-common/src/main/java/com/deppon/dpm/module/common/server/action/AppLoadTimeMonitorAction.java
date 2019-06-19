package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IAppLoadTimeMonitorService;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.AppLoadTimeMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 各应用模块加载时长监控
 */
public class AppLoadTimeMonitorAction extends BaseAction implements ModelDriven<AppLoadTimeMonitorEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(AppLoadTimeMonitorAction.class);
	
	private AppLoadTimeMonitorEntity entity = new AppLoadTimeMonitorEntity();
	
	private IAppLoadTimeMonitorService appLoadTimeMonitorService; 
	
	/**
	 * getModel
	 */
	@Override
	public AppLoadTimeMonitorEntity getModel() {
		return entity;
	}
	
	public void save() {
		Result<Object> result = new Result<Object>();
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			EmpExtensionEntity empExtensionEntity = loginResult.getEmpExtensionEntity();
			entity.setOsType(loginResult.getOsType());
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setDeviceToken(empExtensionEntity == null ? null : empExtensionEntity.getDeviceToken());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setOsVersion(loginResult.getOsVersion());
		} catch (Exception e) {
			LOG.error("AppLoadTimeMonitorAction保存应用模块加载时长监控获取登录结果集出错>>>>",e);
		}
		
		try {
			appLoadTimeMonitorService.save(entity);
			result.setErrorCode(0);
			result.setErrorMessage("保存成功");
		} catch (Exception e) {
			result.setErrorCode(1);
			result.setErrorMessage("保存失败");
			LOG.error("保存应用模块加载时长监控出错>>>> " + entity.toString(), e);
		}
		writeToPage(result);
	}

	public void setAppLoadTimeMonitorService(
			IAppLoadTimeMonitorService appLoadTimeMonitorService) {
		this.appLoadTimeMonitorService = appLoadTimeMonitorService;
	}

}
