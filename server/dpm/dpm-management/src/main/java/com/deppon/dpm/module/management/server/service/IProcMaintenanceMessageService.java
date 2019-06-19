package com.deppon.dpm.module.management.server.service;

/**
 * 工程维修消息推送service层.
 * @author 曹嵩
 * <p>时间:2015.10.9</p>
 */
public interface IProcMaintenanceMessageService {

	/**
	 * 工程维修消息推送.
	 * @param self 0:非自行维修,1:自行维修
	 * @param bill 单号
	 * @param status -1:退回,0:审核中
	 */
	public void getProcMainMessage(int self,String bill,int status);
}
