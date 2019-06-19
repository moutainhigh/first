package com.deppon.dpm.tongxunlu.server.dao.impl;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.tongxunlu.server.dao.IPersonlyImageDao;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 个人头像dao层实现
 * 
 * @author 231586
 * 
 */
public class PersonlyImageDao extends iBatis3DaoImpl implements
		IPersonlyImageDao {
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.employee.";

	/**
	 * 个人头像新增
	 */
	@Override
	public int addPersonlyImage(EmpExtensionEntity entity) {
		// 新增
		return this.getSqlSession().insert(NAMESPACE + "addPersonlyImage", entity);
	}

	/**
	 * 个人头像更新
	 */
	@Override
	public int updateImageAddress(EmpExtensionEntity entity) {
		// 更新
		return this.getSqlSession().update(NAMESPACE + "updateImageAddress", entity);
	}

	/**
	 * 查询
	 */
	@Override
	public String queryImageByEmpCode(String empCode) {
		// 查询
		return (String) this.getSqlSession().selectOne(NAMESPACE + "queryImageByEmpCode", empCode);
	}
}
