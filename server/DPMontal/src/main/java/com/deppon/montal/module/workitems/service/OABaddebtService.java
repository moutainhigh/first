
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.OABaddebtApply;
import com.deppon.montal.model.OABaddebtChild;
import com.deppon.montal.module.workitems.dao.IOABaddebtDao;
import com.deppon.montal.module.workitems.dao.OABaddebtDao;
   /** 
 * @Title: OADaddebtService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author yinrongping 
 * @date 2013-8-2 下午3:36:05 
 * @version V1.0 
 */
public class OABaddebtService implements IOABaddebtService {

	private static IOABaddebtDao baddebtDao = new OABaddebtDao();
	
	/**
	 * 
	   * @Title: getBaddebtApply 
	   * @Description:TODO(获取非业务类坏账申请信息) 
	   * @param @param processinstid
	   * @throws 
	   * @date 2013-8-2 上午11:08:27
	 */
	@Override
	public OABaddebtApply getBaddebtApply(String processinstid) {

		return baddebtDao.getBaddebtApply(processinstid);
	}

	/**
	 * 
	   * @Title: getBaddebtChild 
	   * @Description:TODO(获取非业务类坏账申请详情)
	   * @date 2013-8-2 上午11:10:55
	 */
	@Override
	public List<OABaddebtChild> getBaddebtChild(String processinstid) {

		return baddebtDao.getBaddebtChild(processinstid);
	}

}

