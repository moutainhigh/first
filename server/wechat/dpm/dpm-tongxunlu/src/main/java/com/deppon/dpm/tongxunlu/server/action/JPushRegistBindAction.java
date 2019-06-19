package com.deppon.dpm.tongxunlu.server.action;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;

import com.deppon.dpm.tongxunlu.server.service.IJPushRegistBindService;
import com.deppon.dpm.tongxunlu.shared.domain.JPushRegistBindEntity;
import com.opensymphony.xwork2.ModelDriven;

public class JPushRegistBindAction extends BaseAction implements ModelDriven<JPushRegistBindEntity>{

	private static final Logger LOG  = LoggerFactory.getLogger(JPushRegistBindAction.class);
	
	private JPushRegistBindEntity entity = new JPushRegistBindEntity();
	
	private IJPushRegistBindService jPushRegistBindService;
	
	private JPushClient jpushClient;
	
	// getModel
	public JPushRegistBindEntity getModel() {
		return entity;
	}
	
	// 登录时绑定工号与注册id的关系
	public void saveOrUpdate() {
		try {
			String operateType = ServletActionContext.getRequest().getParameter("operateType");
			// 如果是登出，设置userId为null，解除绑定关系
			if("logout".equals(operateType)){
				try {
					// 修改该注册id对应的别名
					jpushClient.updateDeviceTagAlias(entity.getRegistId(), "", null, null);
				} catch (Exception e) {
					LOG.error("登出解除别名出错!!! " + entity.toString() ,e);
				}
				entity.setUserId(null);
			} else {
				try {
					// 修改该注册id对应的别名
					jpushClient.updateDeviceTagAlias(entity.getRegistId(), entity.getUserId(), null, null);
				} catch (Exception e) {
					LOG.error("登录绑定更新别名出错!!! " + entity.toString() ,e);
				}
			}
			
			JPushRegistBindEntity jPushRegistBindEntity  = jPushRegistBindService.queryByRegistId(entity.getRegistId());
			if(null == jPushRegistBindEntity) {
				jPushRegistBindService.save(entity);
			} else {
				jPushRegistBindService.update(entity);
			}
		} catch (Exception e) {
			LOG.error("绑定或解除工号与注册id的关系出错!!! " + entity.toString() ,e);
		}
	}
	
	// setter
	public void setjPushRegistBindService(
			IJPushRegistBindService jPushRegistBindService) {
		this.jPushRegistBindService = jPushRegistBindService;
	}

	public void setJpushClient(JPushClient jpushClient) {
		this.jpushClient = jpushClient;
	}

}
