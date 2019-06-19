/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.util.List;
import java.util.Map;

import com.deppon.montal.model.CCEntertainmentExpense;
import com.deppon.montal.model.CCEntertainmentExpenseEntry;

/** 
* @Title: ICCEntertainmentExpenseDao.java
* @Description:(应酬费用报销申请数据操作类) 
* @author yin 
* @date 2013-5-14 上午9:19:35 
* @version V1.0 
*/
public interface ICCEntertainmentExpenseDao {

	/**
	 * 获取应酬费用报销申请信息
	 * @return
	 */
	public CCEntertainmentExpense getCCEntertainmentExpense(String processinstid);
	
	/**
	 * 获取应酬费用报销申请详情
	 * @return
	 */
	public List<CCEntertainmentExpenseEntry> getCCEntertainmentExpenseEntry(String processinstid); 
}
