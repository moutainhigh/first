
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAElectroniContractBorrow;
   /** 
 * @Title: IEleContractBorrowService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 电子合同借阅申请Service接口 
 * @author yinrongping 
 * @date 2013-8-5 上午11:04:43 
 * @version V1.0 
 */
public interface IEleContractBorrowService {

	/**
	 * 
	   * @Title: getEleContractBorrowInfo 
	   * @Description:获取电子合同借阅申请
	   * @date 2013-8-5 上午11:05:26
	 */
	public OAElectroniContractBorrow getEleContractBorrowInfo(
			String processinstid);
}

