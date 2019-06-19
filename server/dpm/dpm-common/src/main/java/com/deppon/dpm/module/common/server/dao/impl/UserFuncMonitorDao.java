package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.IUserFuncMonitorDao;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.domain.UserFuncMonitorEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UserFuncMonitorDao extends iBatis3DaoImpl implements IUserFuncMonitorDao{
	
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.UserFuncMonitorDao.";

	/**
	 * 保存
	 */
	public void save(UserFuncMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	/**
	 * 根据工号分页查询
	 */
	@SuppressWarnings("unchecked")
	public List<NativePushCfgEntity> queryByPage(int start, int rows,
			String userId) {
		RowBounds rowBounds = new RowBounds(start, rows);
		return this.getSqlSession().selectList(NAME_SPACE + "queryByPage", userId, rowBounds);
	}
	
	/**
	 * 查询总数
	 */
	public long queryCount(String userId) {
		return (Long) this.getSqlSession().selectOne(NAME_SPACE + "queryCount",userId);
	}
}
