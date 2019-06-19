package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.common.server.dao.IAutoPunchClockMonitorDao;
import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 自动打卡监控dao
 */
public class AutoPunchClockMonitorDao extends iBatis3DaoImpl implements IAutoPunchClockMonitorDao{

	// NAME_SPACE
	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.impl.AutoPunchClockMonitorDao.";
	
	// 保存
	public void save(AutoPunchClockMonitorEntity entity) {
		this.getSqlSession().insert(NAME_SPACE + "save", entity);
	}

	// 分页查询
	@SuppressWarnings("unchecked")
	public List<NativePushCfgEntity> queryByPage(int start, int rows,String empCode) {
		RowBounds rowBounds = new RowBounds(start, rows);
		return this.getSqlSession().selectList(NAME_SPACE + "queryByPage", empCode, rowBounds);
	}

	// 查询数量
	public long queryCount(String empCode) {
		return (Long) this.getSqlSession().selectOne(NAME_SPACE + "queryCount",empCode);
	}
}
