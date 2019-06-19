/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.module.workitems.dao.AdminContractApplyDao;
import com.deppon.montal.module.workitems.dao.IAdminContractApplyDao;

/** 
* @Title: IAdminContractApplyService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(行政类合同申请Service层) 
* @author yin 
* @date 2013-06-20 上午11:40:38 
* @version V1.0 
*/
public class AdminContractApplyService implements IAdminContractApplyService{

	private static IAdminContractApplyDao contractApplyDao =  new AdminContractApplyDao();
	
	/**
	 * 获取合同申请
	 * @param processinstid
	 * @return
	 */
	public OaContractApply queryContractApply(String processinstid){
		
		return contractApplyDao.queryContractApply(processinstid);
		
	}
}
