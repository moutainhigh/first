/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAExterNaltraining;
import com.deppon.montal.module.workitems.dao.EducateOutsideDao;
import com.deppon.montal.module.workitems.dao.IEducateOutsideDao;

/** 
 * @Title: EducateOutsideService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (外训申请) 
 * @author yin
 * @date 2013-7-19 上午11:44:35 
 * @version V1.0 
 */
public class EducateOutsideService implements IEducateOutsideService {

	private static IEducateOutsideDao  educateOutsideDao = new EducateOutsideDao();
	
	/**
	 * 获取外训申请信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAExterNaltraining getExterNaltrainingInfo(String processinstid) {
		return educateOutsideDao.getExterNaltrainingInfo(processinstid);
	}

}
