
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OABankAccountOpencl;
import com.deppon.montal.module.workitems.dao.IOABankAccountOpenClDao;
import com.deppon.montal.module.workitems.dao.OABankAccountOpenClDao;
   /** 
 * @Title: OABankAccountOpenClService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 银行开户/销户申请service
 * @author yinrongping 
 * @date 2013-8-23 上午11:02:41 
 * @version V1.0 
 */
public class OABankAccountOpenClService implements IOABankAccountOpenClService {

	private static IOABankAccountOpenClDao openCldao = new OABankAccountOpenClDao();
	
	/**
	   * @Title: getBankAccountOpenClInfo 
	   * @Description:获取银行开户/销户申请信息
	   * @date 2013-8-23 上午9:22:49
	 */
	@Override
	public OABankAccountOpencl getBankAccountOpenClInfo(String processinstid) {
		return openCldao.getBankAccountOpenClInfo(processinstid);
	}

}

