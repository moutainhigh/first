/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OALoanPaymentInfo;
import com.deppon.montal.module.workitems.dao.ILoanPaymentDao;
import com.deppon.montal.module.workitems.dao.LoanPaymentDao;

/** 
* @Title: LoanPaymentService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(借支申请Service接口) 
* @author yin
* @date 2013-7-18 下午3:23:31 
* @version V1.0 
*/
public class LoanPaymentService implements ILoanPaymentService {

	private static ILoanPaymentDao  paymentDao = new LoanPaymentDao();
	
	/**
	 * 获取借支申请信息
	 * @param processinstid
	 * @return
	 */
	public OALoanPaymentInfo getLoanPaymentInfo(String processinstid) {
		
		return paymentDao.getLoanPaymentInfo(processinstid);
	}

}
