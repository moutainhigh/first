/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAManagerRegularizationApply;

/** 
* @Title: IManagerBecomeService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(管理人员转正/成长期通过申请工作流Service接口) 
* @author yin
* @date 2013-7-18 下午3:23:31 
* @version V1.0 
*/
public interface IManagerBecomeService {

	/**
	 * 获取管理人员转正/成长期通过申请工作流申请信息
	 * @param processinstid
	 * @return
	 */
	public OAManagerRegularizationApply getManagerRegApply(String processinstid);
	
}
