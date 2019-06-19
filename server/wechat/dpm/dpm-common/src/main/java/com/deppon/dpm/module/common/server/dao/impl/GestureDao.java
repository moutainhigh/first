package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IGestureDao;
import com.deppon.dpm.module.common.shared.domain.GestureEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 手势密码
 *
 */
public class GestureDao extends iBatis3DaoImpl implements IGestureDao{
	
	private static final String NAMESPACE = "com.deppon.dpm.module.common.server.dao.impl.GestureDao.";

	// 根据工号查询
	public GestureEntity queryByEmpcode(String userId) {
		return (GestureEntity) this.getSqlSession().selectOne(NAMESPACE + "queryByEmpcode", userId);
	}

	// 根据工号删除
	public void deleteByEmpcode(String userId) {
		this.getSqlSession().delete(NAMESPACE + "deleteByEmpcode", userId);
	}
	
	// 更新
	public void update(GestureEntity entity) {
		this.getSqlSession().update(NAMESPACE + "update", entity);
	}

}
