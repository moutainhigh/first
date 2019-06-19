/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAQualificationAuth;
import com.deppon.montal.module.workitems.dao.IOAQualificationAuthDao;
import com.deppon.montal.module.workitems.dao.OAQualificationAuthDao;

/** 
* @Title: OAQualificationAuthService.java
* @Package com.deppon.montal.module.workitems.service 
* @Description:(任职资格申请流数据操作) 
* @author yin 
* @date 2013-6-29 上午9:59:06 
* @version V1.0 
*/
public class OAQualificationAuthService implements IOAQualificationAuthService {

	private static IOAQualificationAuthDao authDao = new OAQualificationAuthDao(); 
	
	/**
	 * 获取任职资格申请
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAQualificationAuth getQualificationAuth(String processinstid) {
		
		return authDao.getQualificationAuth(processinstid);
		
	}

}
