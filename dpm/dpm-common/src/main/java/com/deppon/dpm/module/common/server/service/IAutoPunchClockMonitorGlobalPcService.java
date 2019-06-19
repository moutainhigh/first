package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;

/**
 * 自动打卡监控service
 */
public interface IAutoPunchClockMonitorGlobalPcService {

	// 保存
	void save(AutoPunchClockMonitorEntity entity);

	// 分页查询
	List<AutoPunchClockMonitorEntity> queryByPage(int start, int rows,String empCode);

	// 查询数量
	long queryCount(String empCode);

}
