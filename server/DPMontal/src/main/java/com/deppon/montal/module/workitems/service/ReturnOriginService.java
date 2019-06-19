/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OAReturnDomOfOrigin;
import com.deppon.montal.module.workitems.dao.IReturnOriginDao;
import com.deppon.montal.module.workitems.dao.ReturnOriginDao;

/** 
 * @Title: IReturnOriginService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(回原籍service接口) 
 * @author yin
 * @date 2013-7-17 上午9:10:37 
 * @version V1.0 
 */
public class ReturnOriginService implements IReturnOriginService {

	private static IReturnOriginDao originDao = new ReturnOriginDao();
	
	/**
	 * 获取回原籍申请信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAReturnDomOfOrigin getReturnOriginInfo(String processinstid) {
		// TODO Auto-generated method stub
		return originDao.getReturnOriginInfo(processinstid);
	}

}
