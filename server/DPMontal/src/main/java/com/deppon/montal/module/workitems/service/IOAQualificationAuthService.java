/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAQualificationAuth;

/** 
* @Title: IOAQualificationAuthService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(任职资格申请流数据操作) 
* @author yin 
* @date 2013-6-29 上午9:59:06 
* @version V1.0 
*/
public interface IOAQualificationAuthService {

	/**
	 * 获取任职资格申请
	 * @param processinstid
	 * @return
	 */
	public OAQualificationAuth getQualificationAuth(String processinstid);
	
}
