/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OaContractApply;

/** 
* @Title: IAdminContractApplyService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(行政类合同申请Service层) 
* @author yin 
* @date 2013-06-20 上午11:40:38 
* @version V1.0 
*/
public interface IAdminContractApplyService {

	/**
	 * 获取合同申请
	 * @param processinstid
	 * @return
	 */
	public OaContractApply queryContractApply(String processinstid);
}
