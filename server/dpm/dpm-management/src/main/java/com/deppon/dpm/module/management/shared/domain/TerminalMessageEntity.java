package com.deppon.dpm.module.management.shared.domain;
/**
 * 移动办公IT服务台终端消息实体
 * 移动办公IT服务台图标当有任务下发时，右上方显示任务数量
 * @author 237986
 * @date 2015-04-07 15:24:30
 *
 */
public class TerminalMessageEntity {
	private String orderCode;//事件编码
	private String dealUserCode;//处理人
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getDealUserCode() {
		return dealUserCode;
	}
	public void setDealUserCode(String dealUserCode) {
		this.dealUserCode = dealUserCode;
	}
	
}
