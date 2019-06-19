/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.montal.model.CCExpenseaccountBill;
import com.deppon.montal.model.CCFenlumingxiTable;
import com.deppon.montal.module.workitems.dao.CCExpenseaccountBillDao;
import com.deppon.montal.module.workitems.dao.ICCExpenseaccountBillDao;

/** 
* @Title: ICCEntertainmentExpenseService.java
* @Description:(物资资产采购报销申请Service) 
* @author yin 
* @date 2013-5-28 上午9:19:35 
* @version V1.0 
*/
public class CCExpenseaccountBillService implements
		ICCExpenseaccountBillService {

	public static ICCExpenseaccountBillDao  expenseaccountBillDao = new CCExpenseaccountBillDao(); 
	
	@Override
	public Map<String, Object> getCCExpenseaccountBill(String processinstid) {
		
		CCExpenseaccountBill bill = expenseaccountBillDao.getCCExpenseaccountBill(processinstid);
		
		List<CCFenlumingxiTable> billEntryList = expenseaccountBillDao.getCCExpenseaccountBillEntry(processinstid);

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bill", bill);
		map.put("billEntryList", billEntryList);
		
		return map;
	}

}
