
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OABankAccountOpencl;
   /** 
 * @Title: IOABankAccountOpenClDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 银行开户/销户申请数据操作层接口
 * @author yinrongping 
 * @date 2013-8-23 上午9:21:07 
 * @version V1.0 
 */
public interface IOABankAccountOpenClDao {

	/**
	   * @Title: getBankAccountOpenClInfo 
	   * @Description:获取银行开户/销户申请信息
	   * @date 2013-8-23 上午9:22:49
	 */
	public OABankAccountOpencl getBankAccountOpenClInfo(String processinstid);
	
}

