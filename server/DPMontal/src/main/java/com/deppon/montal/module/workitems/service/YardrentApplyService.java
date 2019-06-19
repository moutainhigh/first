/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAYardrentApply;
import com.deppon.montal.module.workitems.dao.YardrentApplyDao;

/** 
* @Title: YardrentApplyService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description: (场地租赁申请工作流数据层) 
* @author yin 
* @date 2013-6-27 上午9:58:20 
* @version V1.0 
*/
public class YardrentApplyService implements IYardrentApplyService {

	private static YardrentApplyDao applyDao = new YardrentApplyDao(); 
	
	/**
	 * 获取场地租赁申请
	 */
	@Override
	public OAYardrentApply getYardrentApplyInfo(String processinstid) {
		return applyDao.getYardrentApplyInfo(processinstid);
	}

}
