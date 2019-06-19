
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OACheckFileApply;
   /** 
 * @Title: IOACheckFileApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 发文审核申请service接口
 * @author yinrongping 
 * @date 2013-8-22 上午9:34:13 
 * @version V1.0 
 */
public interface IOACheckFileApplyService {

	/**
	 * 
	   * @Title: getCheckFileApplyInfo 
	   * @Description:获取发文审核申请
	   * @date 2013-8-22 上午9:06:15
	 */
	public OACheckFileApply getCheckFileApplyInfo(String processinstid);
	
}

