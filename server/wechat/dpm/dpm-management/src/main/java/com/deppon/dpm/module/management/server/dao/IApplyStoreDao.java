package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.ApplyStoreAppraise;

/**
 * 应用商店dao层
 * 
 * @author 245968
 * 
 */
public interface IApplyStoreDao {

	/**
	 * 根据工号获取用户的应用商店列表--安装状态和下载数量
	 */
	public List<ApplyStore> list(String userId);

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
	 * 
	 * @param entity
	 * @return
	 */
	public int insertApplyStore(ApplyStore entity);

	/**
	 * 更新应用商店
	 * 
	 * @param entity
	 * @return
	 */
	public int updateApplyStore(ApplyStore entity);

	/**
	 * 删除应用商店
	 * 
	 * @param entity
	 * @return
	 */
	public int deleteApplyStore(ApplyStore entity);
	
	/**
	 * 切换应用下载平台
	 */
	public void updateDLoadLine(int line);
	
	/**
	 * 获取应用商店详情信息
	 * 
	 * @param appId
	 * @return
	 */
	public ApplyStore getApplyStoreById(int appId);

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

}
