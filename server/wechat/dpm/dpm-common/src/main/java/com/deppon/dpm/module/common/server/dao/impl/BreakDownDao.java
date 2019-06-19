package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IBreakDownDao;
import com.deppon.dpm.module.common.shared.domain.BreakDownEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * app崩溃监控记录dao
 */
public class BreakDownDao extends iBatis3DaoImpl implements IBreakDownDao{
	
	//mapper.xml的名称空间
	private static final String NAMESPASE = "com.deppon.dpm.module.common.server.dao.impl.BreakDownDao.";
	
	/**
	 * 保存app崩溃监控记录
	 */
	@Override
	public int saveBreakDownInfo(BreakDownEntity entity) {
		//保存
		return this.getSqlSession().insert(NAMESPASE + "insert", entity);
	}

}
