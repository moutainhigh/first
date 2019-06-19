package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.IUserOperationMonitorDao;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.UserOperationMonitorTypeEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UserOperationMonitorDao extends iBatis3DaoImpl implements IUserOperationMonitorDao{

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.UserOperationMonitorDao.";
	
	// 保存
	public void save(UserOperationMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	// 条件查询
	@SuppressWarnings("unchecked")
	public List<UserOperationMonitorEntity> queryByUserIdAndTime(
			int start, int rows, UserOperationMonitorEntity entity) {
		return this.getSqlSession().selectList(NAME_SPACE + "queryByUserIdAndTime", entity, new RowBounds(start,rows));
	}

	@SuppressWarnings("unchecked")
	public List<UserOperationMonitorTypeEntity> queryUserOperationMonitorType() {
		return this.getSqlSession().selectList(NAME_SPACE + "queryUserOperationMonitorType");
	}

	public long queryCount(UserOperationMonitorEntity entity) {
		return (Long) this.getSqlSession().selectOne(NAME_SPACE + "queryCount", entity);
	}
}
