
package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OATrainRequest;
   /** 
 * @Title: IOATrainRequestService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 培训需求申请service接口 
 * @author yinrongping 
 * @date 2013-8-21 上午9:12:32 
 * @version V1.0 
 */
public interface IOATrainRequestService {
	/**
	 * 
	   * @Title: getTrainRequestInfo 
	   * @Description:获取需求申请信息
	   * @date 2013-8-21 上午8:19:55
	 */
	public OATrainRequest getTrainRequestInfo(String processinstid);
	
}

