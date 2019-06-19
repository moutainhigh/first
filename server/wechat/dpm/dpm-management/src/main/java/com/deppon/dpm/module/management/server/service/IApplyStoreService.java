package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ApplyDevice;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.ApplyStoreAppraise;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;

/**
 * 应用商店service
 * 
 * @author 245968
 * 
 */
public interface IApplyStoreService {

	/**
	 * 根据工号获取用户的应用商店列表--安装状态和下载数量
	 */
	public List<ApplyStore> list(EmployeeEntity employee,List<String> rolesList,String osType,String appVersion);

	/**
	 * 安装下载应用模块
	 */
	public void download(String userId, int id);

	/**
	 * 保存应用模块排序
	 */
	public void sort(String userId, String sortStr);

	/**
	 * 获取应用模块排序
	 */
	public String getSort(String userId);

	/**
	 * 获取应用商店列表
	 */
	public List<ApplyStore> getApplyStoreList(int appId, int begin, int pageSize);

	/**
	 * 获取应用商店列表总数
	 */
	public Long getApplyStoreCount();

	/**
	 * 插入应用商店
	 */
	public int insertApplyStore(ApplyStore entity);

	/**
	 * 更新应用商店
	 */
	public int updateApplyStore(ApplyStore entity);

	/**
	 * 删除应用商店
	 * 
	 */
	public int deleteApplyStore(ApplyStore entity);
	
	/**
	 * 切换应用下载平台
	 */
	public void updateDLoadLine(int line);

	/**
	 * 获取设备、应用版本号信息列表
	 */
	public List<ApplyDevice> getApplyDeviceList(ApplyDevice entity);

	/**
	 * 根据设备号与应用编号保存 设备应用版本号
	 */
	public void saveApplyDeviceByAppId(ApplyDevice device, int newVersion);

	/**
	 * 删除设备应用版本号
	 * 
	 */
	public int deleteApplyDevice(ApplyDevice device);
	
	/**
	 * 获取应用商店详情信息
	 * 
	 * @param appId
	 * @return
	 */
	public ApplyStore getApplyStoreById(int appId, String userId, int begin, int pageSize);

	/**
	 * 获取应用评论列表
	 */
	public List<ApplyStoreAppraise> getApplyStoreAppraiseList(
			ApplyStoreAppraise entity, int begin, int pageSize);

	/**
	 * 插入应用评论信息
	 * 
	 * @param entity
	 * @return
	 */
	public int insertApplyStoreAppraise(ApplyStoreAppraise entity);

	/**
	 * 屏蔽用户评论
	 * 
	 * @param entity
	 * @return
	 */
	public int updateApplyStoreAppraise(ApplyStoreAppraise entity);

	/**
	 * 查询该应用是否有更新
	 * @param appId
	 * @param deviceToken
	 * @param osType
	 * @return
	 */
	public boolean queryHasUpdate(int appId, String deviceToken, String osType);

}
