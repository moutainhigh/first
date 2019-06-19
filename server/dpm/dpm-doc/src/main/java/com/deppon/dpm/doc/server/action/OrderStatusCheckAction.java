package com.deppon.dpm.doc.server.action;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IDidiOrderService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 订单状态检查类
 * @author wanc
 *	20171205
 */
public class OrderStatusCheckAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IDidiOrderService didiOrderService;
	
	/**
	 * 检查订单状态
	 */
	@CookieNotCheckedRequired
	public void statusCheck(){
		
		//调用检查订单状态接口
		boolean bisnocomp = didiOrderService.statusCheck(userId);
		
		// 构造页面返回json数据
		JSONObject jsonObject = new JSONObject();
		if (bisnocomp) {// 如果存在未完成的订单
			jsonObject.put("flag", "0");
		}else {
			jsonObject.put("flag", "1");
		}
		jsonObject.put("msg", "success");
		
		// 返回页面数据
		writeToPage(jsonObject);
	}

	public void setDidiOrderService(IDidiOrderService didiOrderService) {
		this.didiOrderService = didiOrderService;
	}
	
	
	
}
