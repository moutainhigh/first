package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IUserStepCountService;
import com.deppon.dpm.module.common.shared.domain.UserStepCountEntity;
import com.opensymphony.xwork2.ModelDriven;


/**
 *	计步器，保存更新用户每天的步数
 */
public class UserStepCountAction extends BaseAction implements ModelDriven<UserStepCountEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(UserStepCountAction.class);
	
	private UserStepCountEntity entity = new UserStepCountEntity();
	
	private IUserStepCountService userStepCountService;
	
	/**
	 * geModel
	 */
	public UserStepCountEntity getModel() {
		return entity;
	}
	
	/**
	 * 保存或更新
	 */
	public void saveOrUpdate() {
		try {
			userStepCountService.saveOrUpdate(entity);
		} catch (Exception e) {
			LOG.error("计步器保存更新用户每天步数出错!!! " + entity.toString(),e);
		}
	}

	public void setUserStepCountService(IUserStepCountService userStepCountService) {
		this.userStepCountService = userStepCountService;
	}

}
