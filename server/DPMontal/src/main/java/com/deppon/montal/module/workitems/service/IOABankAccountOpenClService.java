
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OABankAccountOpencl;
   /** 
 * @Title: IOABankAccountOpenClService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 银行开户/销户申请service接口 
 * @author yinrongping 
 * @date 2013-8-23 上午11:02:16 
 * @version V1.0 
 */
public interface IOABankAccountOpenClService {

	/**
	   * @Title: getBankAccountOpenClInfo 
	   * @Description:获取银行开户/销户申请信息
	   * @date 2013-8-23 上午9:22:49
	 */
	public OABankAccountOpencl getBankAccountOpenClInfo(String processinstid);
}

