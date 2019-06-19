/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OASystempowerApply;

/** 
* @Title: IOASystempowerApplyDao.java
* @Description:(系统权限申请数据操作类) 
* @author yin 
* @date 2013-5-14 上午9:19:35 
* @version V1.0 
*/
public interface IOASystempowerApplyDao {

	/**
	 * 获取系统权限申请
	 * @return
	 */
	public OASystempowerApply getOASystempowerApply(String processinstid);
}
