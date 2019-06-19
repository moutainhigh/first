package com.deppon.dpm.module.management.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.ApplyDevice;

public interface IApplyDeviceDao {
	/**
	 * 获取设备、应用版本号信息列表
	 */
	public List<ApplyDevice> getApplyDeviceList(ApplyDevice entity);

	/**
	 * 插入设备、应用版本号信息
	 * 
	 * @param entity
	 * @return
	 */
	public int insertApplyDevice(ApplyDevice entity);

	/**
	 * 更新设备、应用版本号信息
	 * 
	 * @param entity
	 * @return
	 */
	public int updateApplyDevice(ApplyDevice entity);

	/**
	 * 删除设备、应用版本号信息
	 * 
	 * @param entity
	 * @return
	 */
	public int deleteApplyDevice(ApplyDevice entity);

	/**
	 * 查询指定应用是否有更新
	 * @param params
	 */
	public String queryVersionByCondition(Map<String, Object> params);

}
