package com.deppon.montal.module.workitems.dao;

import com.deppon.montal.model.OAReturnDomOfOrigin;


/** 
 * @Title: IReturnOriginDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(回原籍申请dao层接口) 
 * @author yin
 * @date 2013-7-16 上午12:04:48 
 * @version V1.0 
 */
public interface IReturnOriginDao {

	/**
	 * 获取回原籍申请信息
	 * @param processinstid
	 * @return
	 */
	public OAReturnDomOfOrigin getReturnOriginInfo(String processinstid);
	
}
