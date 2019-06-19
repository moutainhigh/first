/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OALoanPaymentInfo;

/** 
* @Title: ILoanPaymentService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(借支申请Service接口) 
* @author yin
* @date 2013-7-18 下午3:23:31 
* @version V1.0 
*/
public interface ILoanPaymentService {

	/**
	 * 获取借支申请信息
	 * @param processinstid
	 * @return
	 */
	public OALoanPaymentInfo getLoanPaymentInfo(String processinstid);
}
