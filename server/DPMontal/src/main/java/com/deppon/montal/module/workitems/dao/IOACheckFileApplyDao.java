
package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OACheckFileApply;
   /** 
 * @Title: IOACheckFileApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 发文审核申请数据操作接口
 * @author yinrongping 
 * @date 2013-8-22 上午9:04:52 
 * @version V1.0 
 */
public interface IOACheckFileApplyDao {

	/**
	 * 
	   * @Title: getCheckFileApplyInfo 
	   * @Description:获取发文审核申请
	   * @date 2013-8-22 上午9:06:15
	 */
	public OACheckFileApply getCheckFileApplyInfo(String processinstId);
}

