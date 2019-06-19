package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IUserFuncStatusDao;
import com.deppon.dpm.module.common.shared.domain.UserFuncStatusEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UserFuncStatusDao extends iBatis3DaoImpl implements IUserFuncStatusDao{
	
	private static final String NAMESPACE = "com.deppon.dpm.module.common.server.dao.impl.UserFuncStatusDao.";

	/**
	 * 删除
	 */
	public void delete(Integer id) {
		this.getSqlSession().delete(NAMESPACE + "delete", id);
	}
	
	/**
	 * 更新
	 */
	public void update(UserFuncStatusEntity entity) {
		this.getSqlSession().delete(NAMESPACE + "update", entity);
	}
	
	/**
	 * 保存
	 */
	public void insert(UserFuncStatusEntity entity) {
		this.getSqlSession().insert(NAMESPACE + "insert", entity);
	}
	
	/**
	 * 根据工号查询
	 */
	@SuppressWarnings("unchecked")
	public List<UserFuncStatusEntity> queryByUserId(String userId) {
		return this.getSqlSession().selectList(NAMESPACE + "queryByUserId", userId);
	}
}
