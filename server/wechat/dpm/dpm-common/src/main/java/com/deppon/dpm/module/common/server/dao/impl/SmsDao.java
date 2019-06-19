package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.ISmsDao;
import com.deppon.dpm.module.common.shared.domain.SmsEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 短信开关
 *
 */
public class SmsDao extends iBatis3DaoImpl implements ISmsDao{

	private static final String NAMESPACE = "com.deppon.dpm.module.common.server.dao.impl.SmsDao.";

	// 根据工号查询
	@SuppressWarnings("unchecked")
	public List<SmsEntity> queryByEmpcode(String userId) {
		return this.getSqlSession().selectList(NAMESPACE + "queryByEmpcode", userId);
	}
	
	// 删除
	public void delete(int id) {
		this.getSqlSession().delete(NAMESPACE + "delete", id);
	}
	
	// 更新
	public void update(SmsEntity entity) {
		this.getSqlSession().update(NAMESPACE + "update", entity);
	}
	
	// 新增
	public void insert(SmsEntity entity) {
		this.getSqlSession().insert(NAMESPACE + "insert", entity);
	}
}
