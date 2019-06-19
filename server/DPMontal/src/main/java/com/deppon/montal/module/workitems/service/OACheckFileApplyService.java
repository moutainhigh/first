
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OACheckFileApply;
import com.deppon.montal.module.workitems.dao.IOACheckFileApplyDao;
import com.deppon.montal.module.workitems.dao.OACheckFileApplyDao;
   /** 
 * @Title: OACheckFileApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: 发文审核申请service
 * @author yinrongping 
 * @date 2013-8-22 上午9:35:31 
 * @version V1.0 
 */
public class OACheckFileApplyService implements IOACheckFileApplyService {

	private static IOACheckFileApplyDao fileApplyDao = new OACheckFileApplyDao();
	
	/**
	 * 获取发文申请信息
	 */
	@Override
	public OACheckFileApply getCheckFileApplyInfo(String processinstid) {

		return fileApplyDao.getCheckFileApplyInfo(processinstid);

	}

}

