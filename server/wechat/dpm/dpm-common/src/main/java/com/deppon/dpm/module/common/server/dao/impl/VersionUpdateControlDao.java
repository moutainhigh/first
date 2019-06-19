package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.common.server.dao.IVersionUpdateControlDao;
import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 系统版本更新权限控制
 */
public class VersionUpdateControlDao extends iBatis3DaoImpl implements IVersionUpdateControlDao{

	// 常量
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.VersionUpdateControlDao.";
	
	// 列表查询
	@SuppressWarnings("unchecked")
	@Override
	public List<VersionUpdateControlEntity> list() {
		return this.getSqlSession().selectList(NAME_SPACE + "list");
	}

	// 保存
	@Override
	public void save(VersionUpdateControlEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save",entity);
	}

	// 根据id查询
	@Override
	public VersionUpdateControlEntity queryById(int id) {
		return (VersionUpdateControlEntity) this.getSqlSession().selectOne(NAME_SPACE + "queryById", id);
	}

	// 根据id删除
	@Override
	public void delById(int id) {
		this.getSqlSession().delete(NAME_SPACE + "delById", id);
	}

	// 根据id更新
	@Override
	public void update(VersionUpdateControlEntity entity) {
		this.getSqlSession().update(NAME_SPACE + "update", entity);
	}
	
	// 根据type查询
	@SuppressWarnings("unchecked")
	@Override
	public List<VersionUpdateControlEntity> queryByType(String type) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryByType", type);
	}

}
