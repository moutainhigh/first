/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OAMuchRecompensate;

/** 
 * @Title: IOAMuchRecompensateDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (多赔工作流数据层) 
 * @author yin 
 * @date 2013-6-06 上午9:58:54 
 * @version V1.0 
 */
public interface IOAMuchRecompensateDao {

	/**
	 * 获取多赔详情
	 * @return
	 */
	public OAMuchRecompensate getMuchRecompensate(String processinstid);
}
