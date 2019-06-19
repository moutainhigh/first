/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OALoanPaymentInfo;

/** 
* @Title: ILessonApplyDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(借支申请数据层接口) 
* @author yin
* @date 2013-7-18 下午3:23:31 
* @version V1.0 
*/
public interface ILoanPaymentDao {

	/**
	 * 获取借支申请信息
	 * @param processinstid
	 * @return
	 */
	public OALoanPaymentInfo getLoanPaymentInfo(String processinstid);
}
