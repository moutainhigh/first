/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OaContractApply;

/** 
* @Title: IAdminContractApplyDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(行政类合同申请工作流数据层) 
* @author yin 
* @date 2013-06-20 上午11:40:38 
* @version V1.0 
*/
public interface IAdminContractApplyDao {

	/**
	 * 获取合同申请
	 * @param processinstid
	 * @return
	 */
	public OaContractApply queryContractApply(String processinstid);
}
