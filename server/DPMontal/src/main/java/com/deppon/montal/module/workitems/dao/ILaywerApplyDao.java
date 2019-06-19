/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.LaywerApply;

/** 
* @Title: ILaywerApplyDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(诉讼案件立案/外请律师申请工作流数据层) 
* @author yin 
* @date 2013-06-24 上午11:40:38 
* @version V1.0 
*/
public interface ILaywerApplyDao {

	/**
	 * 获取申请详细
	 * @param processinstid
	 * @return
	 */
	public LaywerApply getLaywerApplyInfo(String processinstid);
	
}
