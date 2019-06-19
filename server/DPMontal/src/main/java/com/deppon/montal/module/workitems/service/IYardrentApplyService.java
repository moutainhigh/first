/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAYardrentApply;

/** 
* @Title: IYardrentApplyService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description: (场地租赁申请工作流数据层) 
* @author yin 
* @date 2013-6-27 上午9:58:20 
* @version V1.0 
*/
public interface IYardrentApplyService {

	/**
	 * 获取场地租赁申请
	 * @param processinstid
	 * @return
	 */
	public OAYardrentApply getYardrentApplyInfo(String processinstid);
}
