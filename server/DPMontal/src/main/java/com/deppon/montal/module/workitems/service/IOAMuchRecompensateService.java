/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAMuchRecompensate;

/** 
 * @Title: IOAMuchRecompensateService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (多赔工作流Service层) 
 * @author yin 
 * @date 2013-6-06 上午9:58:54 
 * @version V1.0 
 */
public interface IOAMuchRecompensateService {

	/**
	 * 获取多赔信息
	 * @param processinstid
	 * @return
	 */
	public OAMuchRecompensate getMuchRecompensate(String processinstid);
}
