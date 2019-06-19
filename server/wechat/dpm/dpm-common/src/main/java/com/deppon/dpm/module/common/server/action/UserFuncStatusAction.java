package com.deppon.dpm.module.common.server.action;

import java.util.List;

import com.deppon.dpm.module.common.server.service.IUserFuncStatusService;
import com.deppon.dpm.module.common.shared.domain.UserFuncStatusEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户功能开关状态Action
 */
public class UserFuncStatusAction extends BaseAction implements ModelDriven<UserFuncStatusEntity>{

	private UserFuncStatusEntity entity = new UserFuncStatusEntity();
	
	private IUserFuncStatusService userFuncStatusService;
	
	// getModel
	public UserFuncStatusEntity getModel() {
		return entity;
	}
	
	// 根据工号查询
	public void queryByEmpcode() {
		List<UserFuncStatusEntity> list = userFuncStatusService.queryByUserId(entity.getUserId());
		writeToPage(list);
	}
	
	// 删除
	public void delete() {
		 try {
			 userFuncStatusService.delete(entity.getId());
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 writeToPage("{\"success\":false}");
	}
	
	// 更新或新增
	public void updateOrInsert() {
		try {
			if(entity.getId() != null) {
				// 更新
				userFuncStatusService.update(entity);
			} else {
				// 新增
				userFuncStatusService.insert(entity);
			}
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}

	// setter
	public void setUserFuncStatusService(
			IUserFuncStatusService userFuncStatusService) {
		this.userFuncStatusService = userFuncStatusService;
	}
	
}
