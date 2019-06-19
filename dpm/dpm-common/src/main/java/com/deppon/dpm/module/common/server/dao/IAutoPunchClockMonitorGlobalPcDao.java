package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;

/**
 * 自动打卡监控dao
 */
public interface IAutoPunchClockMonitorGlobalPcDao {

	// 保存
	void save(AutoPunchClockMonitorEntity entity);

	// 分页查询
	List<AutoPunchClockMonitorEntity> queryByPage(int start, int rows,String empCode);

	// 查询数量
	long queryCount(String empCode);
}
