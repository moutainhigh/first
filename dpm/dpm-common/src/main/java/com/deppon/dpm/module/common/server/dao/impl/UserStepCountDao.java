package com.deppon.dpm.module.common.server.dao.impl;

import com.deppon.dpm.module.common.server.dao.IUserStepCountDao;
import com.deppon.dpm.module.common.shared.domain.UserStepCountEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UserStepCountDao extends iBatis3DaoImpl implements IUserStepCountDao{
	
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.UserStepCountDao.";

	/**
	 * 保存
	 */
	@Override
	public void save(UserStepCountEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(UserStepCountEntity entity) {
		this.getSqlSession().update(NAME_SPACE + "update", entity);
	}

	/**
	 * 根据userId和dayTime查询
	 */
	@Override
	public UserStepCountEntity queryByUserIdAndDayTime(
			UserStepCountEntity entity) {
		return (UserStepCountEntity) this.getSqlSession().selectOne(NAME_SPACE + "queryByUserIdAndDayTime", entity);
	}

}
