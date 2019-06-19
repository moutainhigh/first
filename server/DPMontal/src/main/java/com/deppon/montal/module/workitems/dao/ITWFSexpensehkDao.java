/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.util.List;
import java.util.Map;

import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.model.TWFSexpensehkSub;

/** 
* @Title: ITWFSexpensehkDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description: 付款申请（香港）/费用报销申请 数据库操作类
* @author yin
* @date 2013-7-16 上午10:16:25 
* @version V1.0 
*/
public interface ITWFSexpensehkDao {

	/**
	 * 获取付款申请信息
	 * @param processinstid
	 * @return
	 */
	public TWFSexpensehk getWFSexpensehkInfo(String processinstid);
	
	/**
	 * 获取付款申请详细信息
	 * @param processinstid
	 * @return
	 */
	public List<TWFSexpensehkSub> getWFSexpensehkSub(String processinstid);
	
}
