package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.deppon.dpm.module.management.server.dao.IApplyDeviceDao;
import com.deppon.dpm.module.management.shared.domain.ApplyDevice;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 设备、应用版本号信息Dao
 * 
 */
public class ApplyDeviceDao extends iBatis3DaoImpl implements IApplyDeviceDao {
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.applyStore.";

	/**
	 * 获取设备、应用版本号信息列表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ApplyDevice> getApplyDeviceList(ApplyDevice entity) {
		// 定义返回map
		Map<String, Object> map = new HashMap<String, Object>();
		if (entity.getApplyStoreId() != 0) {
			map.put("applyStoreId", entity.getApplyStoreId());
		}
		if (StringUtils.isNotEmpty(entity.getDeviceToken())) {
			map.put("deviceToken", entity.getDeviceToken());
		}
		// 获取
		List<ApplyDevice> selectList = getSqlSession().selectList(
				NAME_SPACE + "applyDeviceList", map);
		// 返回
		return selectList;
	}

	/**
	 * 插入设备、应用版本号信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertApplyDevice(ApplyDevice entity) {
		// 插入设备、应用版本号信息
		return getSqlSession().insert(NAME_SPACE + "insertApplyDevice", entity);
	}

	/**
	 * 更新设备、应用版本号信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int updateApplyDevice(ApplyDevice entity) {
		// 更新设备、应用版本号信息
		return getSqlSession().update(NAME_SPACE + "updateApplyDevice", entity);
	}

	/**
	 * 删除设备、应用版本号信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int deleteApplyDevice(ApplyDevice entity) {
		// 定义返回map
		Map map = new HashMap();
		if (entity != null && entity.getAppIdList() != null && entity.getAppIdList().size() > 0
				&& StringUtils.isNotEmpty(entity.getDeviceToken())) {
			map.put("deviceToken", entity.getDeviceToken());
			map.put("appIdList", entity.getAppIdList());
			// 删除信息
			return getSqlSession()
					.delete(NAME_SPACE + "deleteApplyDevice", map);
		} else if(entity != null && StringUtils.isNotEmpty(entity.getDeviceToken())){
			map.put("deviceToken", entity.getDeviceToken());
			// 删除所有信息
			return getSqlSession().delete(NAME_SPACE + "deleteAllApplyDevice", map);
		} else {
			return 0;
		}
	}
	
	/**
	 * 查询指定应用是否有更新
	 * @param params
	 */
	@Override
	public String queryVersionByCondition(Map<String, Object> params) {
		// 查询
		return (String) getSqlSession().selectOne(
				NAME_SPACE + "queryVersionByCondition", params);
		
	}

}
