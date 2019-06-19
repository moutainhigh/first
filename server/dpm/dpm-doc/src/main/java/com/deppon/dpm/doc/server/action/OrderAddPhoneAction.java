package com.deppon.dpm.doc.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IDidiOrderService;
import com.deppon.dpm.doc.server.service.IPersonalCenterService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

public class OrderAddPhoneAction extends BaseAction{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(OrderAddPhoneAction.class);
	
	private IDidiOrderService didiOrderService;
	private IPersonalCenterService personalCenterService;
	private String userId;
	private String phone;
	/**
	 * 构造方法
	 */
	public OrderAddPhoneAction() {
		super();
	}
	/**
	 * 更新订单中电话字段
	 */
	@CookieNotCheckedRequired
	public void updatePhoneNum(){
		JSONObject jonum = new JSONObject();
		logger.info("订单更新手机号开始>>>>>>>>>>>>>>>");
		// 调用接口查询方法根据ID查询电话号码并返回
		logger.info("获取手机号>>>>>>>>>>>>>>>");
		EmployeeEntity empentity = personalCenterService.queryPersonIDByID(userId);
		if (empentity != null) {
			phone = empentity.getMobileNo();
		}
		logger.info("获取手机号结束>>>>>>>>>>>>>>>");
		
		if(userId != null && phone != null){
			int updatePhone = didiOrderService.updatePhone(userId, phone);
			logger.info("订单更新手机号结束>>>>>>>>>>>>>>>" + updatePhone);
			jonum.put("msg", "success");
			jonum.put("state", updatePhone);
		}
		
		writeToPage(jonum);
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the didiOrderService
	 */
	public IDidiOrderService getDidiOrderService() {
		return didiOrderService;
	}
	/**
	 * @param didiOrderService the didiOrderService to set
	 */
	public void setDidiOrderService(IDidiOrderService didiOrderService) {
		this.didiOrderService = didiOrderService;
	}
	/**
	 * @return the personalCenterService
	 */
	public IPersonalCenterService getPersonalCenterService() {
		return personalCenterService;
	}
	/**
	 * @param personalCenterService the personalCenterService to set
	 */
	public void setPersonalCenterService(
			IPersonalCenterService personalCenterService) {
		this.personalCenterService = personalCenterService;
	}
	
}
