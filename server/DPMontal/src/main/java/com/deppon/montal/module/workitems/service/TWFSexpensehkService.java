/**
 * 
 */
package com.deppon.montal.module.workitems.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.model.TWFSexpensehkSub;
import com.deppon.montal.module.workitems.dao.TWFSexpensehkDao;

/** 
* @Title: TWFSexpensehkService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description: 付款申请（香港）/费用报销申请 Service
* @author yin
* @date 2013-7-16 上午10:16:25 
* @version V1.0 
*/
public class TWFSexpensehkService implements ITWFSexpensehkService{

	private static TWFSexpensehkDao expensehkDao  = new TWFSexpensehkDao();
	
	
	/**
	 * 获取付款申请的详细
	 */
	@Override
	public Map<String,Object> getWFSexpensehkInfo(String processinstid) {
		TWFSexpensehk expensehk = expensehkDao.getWFSexpensehkInfo(processinstid);
		List<TWFSexpensehkSub> expensehkSubList = expensehkDao.getWFSexpensehkSub(processinstid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("expensehk", expensehk);
		map.put("expensehkSubList", expensehkSubList);
		
		return map;
	}

}
