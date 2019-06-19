/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.montal.model.CCEntertainmentExpense;
import com.deppon.montal.model.CCEntertainmentExpenseEntry;
import com.deppon.montal.module.workitems.dao.CCEntertainmentExpenseDao;
import com.deppon.montal.module.workitems.dao.ICCEntertainmentExpenseDao;

/** 
* @Title: CCEntertainmentExpenseService.java
* @Description:(应酬费用报销申请Service) 
* @author yin 
* @date 2013-5-14 上午9:19:35 
* @version V1.0 
*/
public class CCEntertainmentExpenseService implements
		ICCEntertainmentExpenseService {
	
	public static ICCEntertainmentExpenseDao expenseDao = new CCEntertainmentExpenseDao();
	
	@Override
	public Map<String, Object> getEntertainmentExpense(String processinstid) {
		
		CCEntertainmentExpense expense = expenseDao.getCCEntertainmentExpense(processinstid);
		List<CCEntertainmentExpenseEntry> expenseEntryList = expenseDao.getCCEntertainmentExpenseEntry(processinstid);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("expense", expense);
		map.put("expenseEntryList", expenseEntryList);
		
		return map;
	}

}
