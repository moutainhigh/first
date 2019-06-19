/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OAQualificationAuth;

/** 
* @Title: IOAQualificationAuthDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(任职资格申请流数据操作) 
* @author yin 
* @date 2013-6-29 上午9:59:06 
* @version V1.0 
*/
public interface IOAQualificationAuthDao {

	/**
	 * 获取任职资格申请
	 * @param processinstid
	 * @return
	 */
	public OAQualificationAuth getQualificationAuth(String processinstid);
	
}
