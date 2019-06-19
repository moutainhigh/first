package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.INativePushCfgDao;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class NativePushCfgDao extends iBatis3DaoImpl implements INativePushCfgDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.NativePushCfgDao.";

	// 分页查询
	@SuppressWarnings("unchecked")
	public List<NativePushCfgEntity> list(int start, int rows) {
		// 分页参数
		RowBounds rowBounds = new RowBounds(start, rows);
		return this.getSqlSession().selectList(NAME_SPACE + "list", null, rowBounds);
	}
	
	// 查询总条数
	public long queryCount() {
		return (Long) this.getSqlSession().selectOne(NAME_SPACE + "queryCount");
	}
	
	// 根据id删除
	public void deleteByIds(String[] ids) {
		this.getSqlSession().delete(NAME_SPACE + "deleteByIds", ids);
	}
	
	// 更新
	public void update(NativePushCfgEntity entity) {
		this.getSqlSession().update(NAME_SPACE + "update", entity);
	}
	
	// 保存
	public void save(NativePushCfgEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}
	
	// 查询所有有效的
	@SuppressWarnings("unchecked")
	public List<NativePushCfgEntity> queryUsableAll() {
		return this.getSqlSession().selectList(NAME_SPACE + "queryUsableAll");
	}
}
