/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAExterNaltraining;

/** 
 * @Title: IEducateOutsideService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (外训申请) 
 * @author yin
 * @date 2013-7-19 上午11:44:35 
 * @version V1.0 
 */
public interface IEducateOutsideService {
	
	/**
	 * 获取外训申请信息
	 * @param processinstid
	 * @return
	 */
	public OAExterNaltraining getExterNaltrainingInfo(String processinstid);

}
