/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.util.List;

import com.deppon.montal.model.CCExpenseaccountBill;
import com.deppon.montal.model.CCFenlumingxiTable;

/** 
* @Title: ICCEntertainmentExpenseDao.java
* @Description:(物资资产采购报销申请数据操作类) 
* @author yin 
* @date 2013-5-28 上午9:19:35 
* @version V1.0 
*/
public interface ICCExpenseaccountBillDao {

	/**
	 * 获取物资资产采购报销申请信息
	 * @return
	 */
	public CCExpenseaccountBill getCCExpenseaccountBill(String processinstid);
	
	/**
	 * 获取物资资产采购报销申请详情
	 * @return
	 */
	public List<CCFenlumingxiTable> getCCExpenseaccountBillEntry(String processinstid); 
}
