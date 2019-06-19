package com.deppon.dpm.module.common.server.action;

import com.deppon.dpm.module.common.server.service.IGestureService;
import com.deppon.dpm.module.common.shared.domain.GestureEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 手势密码Action
 *
 */
public class GestureAction extends BaseAction implements ModelDriven<GestureEntity>{
	
	// 实例
	private GestureEntity entity = new GestureEntity();
	
	// service
	private IGestureService gestureService;

	// 复写方法
	@Override
	public GestureEntity getModel() {
		return entity;
	}
	
	/**
	 * 根据工号查询
	 */
	public void queryByEmpcode(){
		GestureEntity gestureEntity = gestureService.queryByEmpcode(entity.getUserId());
		writeToPage(gestureEntity);
	}
	
	/**
	 * 删除
	 */
	public void deleteByEmpcode(){
		try {
			gestureService.deleteByEmpcode(entity.getUserId());
			// 返回成功
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}
	
	/**
	 * 根据工号更新
	 */
	public void update(){
		try {
			gestureService.update(entity);
			// 返回成功
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}
	
	// setter
	public void setGestureService(IGestureService gestureService) {
		this.gestureService = gestureService;
	}

}
