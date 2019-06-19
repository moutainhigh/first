/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import java.util.Map;
/** 
* @Title: TWFSexpensehkService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description: 付款申请（香港）/费用报销申请 Service
* @author yin
* @date 2013-7-16 上午10:16:25 
* @version V1.0 
*/
public interface ITWFSexpensehkService {

	/**
	 * 获取付款申请信息
	 * @param processinstid
	 * @return
	 */
	public Map<String,Object> getWFSexpensehkInfo(String processinstid);
	
}
