package com.deppon.dpm.module.common.server.action;

import java.util.List;

import com.deppon.dpm.module.common.server.service.ISmsService;
import com.deppon.dpm.module.common.shared.domain.SmsEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 短信开关
 *
 */
public class SmsAction extends BaseAction implements ModelDriven<SmsEntity>{
	
	// 构造实体
	private SmsEntity entity = new SmsEntity();
	
	// 注入
	private ISmsService smsService;

	// 复写方法
	public SmsEntity getModel() {
		return entity;
	}
	
	// 根据工号查询
	public void queryByEmpcode() {
		List<SmsEntity> list = smsService.queryByEmpcode(entity.getUserId());
		writeToPage(list);
	}
	
	// 根据工号删除
	public void delete() {
		 try {
			smsService.delete(entity.getId());
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
				smsService.update(entity);
			} else {
				// 新增
				smsService.insert(entity);
			}
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}

	// setter
	public void setSmsService(ISmsService smsService) {
		this.smsService = smsService;
	}

}
