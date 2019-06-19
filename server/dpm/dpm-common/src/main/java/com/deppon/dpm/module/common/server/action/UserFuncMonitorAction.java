package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.common.server.service.IUserFuncMonitorService;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.domain.UserFuncMonitorEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户模块异常监控Action
 */
public class UserFuncMonitorAction extends BaseAction implements ModelDriven<UserFuncMonitorEntity>{

	private UserFuncMonitorEntity entity = new UserFuncMonitorEntity();
	
	// service
	private IUserFuncMonitorService userFuncMonitorService;
	
	// getModel
	public UserFuncMonitorEntity getModel() {
		return entity;
	}
	
	/**
	 * 保存
	 */
	public void save(){
		userFuncMonitorService.save(entity);
	}
	
	/**
	 * 分页查询
	 */
	public void queryByPage(){
		String userId = entity.getUserId();
		if(StringUtils.isEmpty(userId)){
			return;
		}
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			// 当前页
			int page = entity.getPage();
			// 每页条数
			int rows = entity.getRows();
			int start = 0;
			if(page != 0) {
				start = (page -1) * rows;
			}
			// 查询
			List<NativePushCfgEntity> list = userFuncMonitorService.queryByPage(start,rows,userId);
			// 总条数
			long count = userFuncMonitorService.queryCount(userId);
			result.put("total", count);
			result.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回
		writeToPage(result);
	}
	

	// setter
	public void setUserFuncMonitorService(
			IUserFuncMonitorService userFuncMonitorService) {
		this.userFuncMonitorService = userFuncMonitorService;
	}
}
