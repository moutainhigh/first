package com.deppon.dpm.module.management.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.AppCommentEntity;
import com.deppon.dpm.module.management.shared.domain.AppDetailEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;

/**
 * 应用详情Dao接口层
 * 
 * @author 491275
 *
 */
public interface IAppDetailDao{
	
	/**
	 * 查询应用商店所有app的id和名字 
	 * @return
	 */
	public List<ApplyStore> selectAllAppId();
	/**
	 * 根据id查询app名字
	 * @param appId
	 * @return
	 */
	public String selectAppNameById(int appId);
	/**
	 * 插入应用详情
	 * @param map
	 * @return
	 */
	public int insertAppDetail(Map<Object, Object> map);
	/**
	 * 查询应用详情
	 * @param appId
	 * @return
	 */
	public AppDetailEntity selectAppDetailById(int appstoreId);
	/**
	 * 计算应用评分
	 * @param appId
	 * @return
	 */
	public Double getAppScore(int appId);
	/**
	 * 插入应用评论
	 * @param appCommentEntity
	 * @return
	 */
	public int insertAppComment(AppCommentEntity appCommentEntity);
	/**
	 * 获取应用评分
	 * @param appId
	 * @return
	 */
	public Double getAppScoreById(int appId);
	/**
	 * 更新应用评分
	 * @param map
	 * @return
	 */
	public int updateTotalScore(Map<Object, Object> map);
	/**
	 * 获得该工号的评论数
	 * @param empCode
	 * @return
	 */
	public int getEmpCodeCount(String empCode);
	/**
	 * 分页展示评论列表
	 * @return
	 */
	public List<AppCommentEntity> getCommentList(int appId,int startNo,int pageSize);
	/**
	 * 获取有回复权限的工号
	 * @return
	 */
	public List<String> getExcEmpcodeList();
	/**
	 * 获得该应用的评论条数
	 * @param appId
	 * @return
	 */
	public int getCommentCount(int appId);
	/**
	 * 添加评论回复
	 * @return
	 */
	public int updateCommentReply(AppCommentEntity appCommentEntity);

}
