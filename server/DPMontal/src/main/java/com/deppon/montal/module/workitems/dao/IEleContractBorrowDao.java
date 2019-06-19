
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAElectroniContractBorrow;
   /** 
 * @Title: IEleContractBorrowDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 电子合同借阅申请数据操作层接口 
 * @author yinrongping 
 * @date 2013-8-5 上午9:34:13 
 * @version V1.0 
 */
public interface IEleContractBorrowDao {

	/**
	 * 
	   * @Title: getEleContractBorrowInfo 
	   * @Description:获取电子合同借阅申请
	   * @date 2013-8-5 上午9:35:33
	 */
	public OAElectroniContractBorrow getEleContractBorrowInfo(String processinstid);
	
}

