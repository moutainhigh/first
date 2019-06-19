package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OATrainRequest;
import com.deppon.montal.module.workitems.dao.IOATrainRequestDao;
import com.deppon.montal.module.workitems.dao.OATrainRequestDao;
   /** 
 * @Title: OATrainRequestService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 培训需求申请service
 * @author yinrongping 
 * @date 2013-8-21 上午9:14:11 
 * @version V1.0 
 */
public class OATrainRequestService implements IOATrainRequestService {

	private static IOATrainRequestDao trainRequestDao = new OATrainRequestDao();
	
	/**
	   * @Title: getTrainRequestInfo 
	   * @Description:获取需求申请信息
	   * @date 2013-8-21 上午8:19:55
	 */
	@Override
	public OATrainRequest getTrainRequestInfo(String processinstid) {

		return trainRequestDao.getTrainRequestInfo(processinstid);
		
	}

}

