/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAReturnDomOfOrigin;

/** 
 * @Title: IReturnOriginService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(回原籍service接口) 
 * @author yin
 * @date 2013-7-17 上午9:10:37 
 * @version V1.0 
 */
public interface IReturnOriginService {

	
	/**
	 * 获取回原籍申请信息
	 * @param processinstid
	 * @return
	 */
	public OAReturnDomOfOrigin getReturnOriginInfo(String processinstid);
}
