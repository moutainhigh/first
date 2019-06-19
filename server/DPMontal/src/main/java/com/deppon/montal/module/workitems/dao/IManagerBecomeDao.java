/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OAManagerRegularizationApply;

/** 
* @Title: IManagerBecomeDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(管理人员转正/成长期通过申请工作流申请数据层) 
* @author yin 
* @date 2013-7-22 下午3:23:31 
* @version V1.0 
*/
public interface IManagerBecomeDao {

	/**
	 * 获取管理人员转正/成长期通过申请工作流申请信息
	 * @param processinstid
	 * @return
	 */
	public OAManagerRegularizationApply getManagerRegApply(String processinstid);
	
}
