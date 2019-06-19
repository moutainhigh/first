
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OATrainRequest;
   /** 
 * @Title: IOATrainRequestDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 培训需求申请数据操作层接口
 * @author yinrongping 
 * @date 2013-8-21 上午8:18:44 
 * @version V1.0 
 */
public interface IOATrainRequestDao {

	/**
	 * 
	   * @Title: getTrainRequestInfo 
	   * @Description:获取需求申请信息
	   * @date 2013-8-21 上午8:19:55
	 */
	public OATrainRequest getTrainRequestInfo(String processinstid);
	
}

