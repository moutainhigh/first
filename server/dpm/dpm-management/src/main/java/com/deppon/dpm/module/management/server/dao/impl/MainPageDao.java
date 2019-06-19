package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IMainPageDao;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class MainPageDao extends iBatis3DaoImpl implements IMainPageDao{
	
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.mainPage.";
	
	/**
	 * 获取消息类型
	 */
	/*@SuppressWarnings("unchecked")
	public List<NoticeCenterEntity> getType(){
		
		return this.getSqlSession().selectList(NAME_SPACE + "getType");
	}
*/
}
