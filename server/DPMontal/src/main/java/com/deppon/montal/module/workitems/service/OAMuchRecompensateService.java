package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAMuchRecompensate;
import com.deppon.montal.module.workitems.dao.IOAMuchRecompensateDao;
import com.deppon.montal.module.workitems.dao.OAMuchRecompensateDao;

/** 
 * @Title: OAMuchRecompensateService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (多赔工作流Service层) 
 * @author yin 
 * @date 2013-6-06 上午9:58:54 
 * @version V1.0 
 */
public class OAMuchRecompensateService implements IOAMuchRecompensateService{

	public static IOAMuchRecompensateDao muchRecompensateDao = new OAMuchRecompensateDao();
	
	@Override
	public OAMuchRecompensate getMuchRecompensate(String processinstid) {
		
		return muchRecompensateDao.getMuchRecompensate(processinstid);
	}

}
