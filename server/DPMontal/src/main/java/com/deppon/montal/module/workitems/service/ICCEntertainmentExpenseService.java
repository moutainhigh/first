/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import java.util.Map;

/** 
* @Title: ICCEntertainmentExpenseService.java
* @Description:(应酬费用报销申请Service) 
* @author yin 
* @date 2013-5-14 上午9:19:35 
* @version V1.0 
*/
public interface ICCEntertainmentExpenseService {

	/**
	 * 获取应酬费用报销申请详情
	 * @param processinstid
	 * @return
	 */
	public Map<String,Object> getEntertainmentExpense(String processinstid);
}
