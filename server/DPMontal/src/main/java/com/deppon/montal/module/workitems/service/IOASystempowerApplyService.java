/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OASystempowerApply;

/**
 * 系统权限申请
 * @author Administrator
 *
 */
public interface IOASystempowerApplyService {

	/**
	 * 获取系统权限申请
	 * @return
	 */
	public OASystempowerApply getOASystempowerApply(String processinstid);
}
