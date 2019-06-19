/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.LaywerApply;
import com.deppon.montal.module.workitems.dao.ILaywerApplyDao;
import com.deppon.montal.module.workitems.dao.LaywerApplyDao;

/** 
* @Title: LaywerApplyService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(诉讼案件立案/外请律师申请工作流数据层) 
* @author yin 
* @date 2013-06-24 上午12:40:38 
* @version V1.0 
*/
public class LaywerApplyService implements ILaywerApplyService {

	private static ILaywerApplyDao applyDao = new LaywerApplyDao();
	
	/**
	 * 获取申请详细
	 * @param processinstid
	 * @return
	 */
	@Override
	public LaywerApply getLaywerApplyInfo(String processinstid) {
		// TODO Auto-generated method stub
		return applyDao.getLaywerApplyInfo(processinstid);
	}

}
