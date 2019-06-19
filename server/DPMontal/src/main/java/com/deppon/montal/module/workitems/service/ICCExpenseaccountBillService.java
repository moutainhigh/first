/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import java.util.Map;

/** 
* @Title: ICCEntertainmentExpenseService.java
* @Description:(物资资产采购报销申请Service) 
* @author yin 
* @date 2013-5-28 上午9:19:35 
* @version V1.0 
*/
public interface ICCExpenseaccountBillService {

	/**
	 * 获取应酬费用报销申请详情
	 * @param processinstid
	 * @return
	 */
	public Map<String,Object> getCCExpenseaccountBill(String processinstid);
}
