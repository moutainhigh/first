package com.deppon.dpm.module.management.server.service;

import java.io.File;
import java.util.List;

import com.deppon.dpm.module.management.shared.domain.AppCommentEntity;
import com.deppon.dpm.module.management.shared.domain.AppDetailEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;

public interface IAppDetailService {
	
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
	public String selectAppNameById(int appstoreId);
	
	/**
	 * 插入应用详情
	 * @param appdetailEntity
	 * @return
	 */
	public int insertAppDetail(int appstoreId,String appName,String appIntroduce,String newFeature,String detailMessage,File[] photos,String[] photosName);
	
	/**
	 * 查询应用详情
	 * @param appId
	 * @return
	 */
	public AppDetailEntity selectAppDetailById(int appId);
	
	/**
	 * 计算应用评分
	 * @param appId
	 * @return
	 */
	public Double getAppScore(int appId) throws Exception;
	
	/**
	 * 插入应用评论
	 * @param appId
	 * @param empId
	 * @param content
	 * @param score
	 * @return
	 */
	public int insertAppComment(int appstoreId,String empCode,String content,int score);
	
	/**
	 * 分页展示评论列表
	 * @param appId
	 * @param startNo
	 * @param pageSize
	 * @return
	 */
	public List<AppCommentEntity> getCommentList(int appstoreId,int startNo,int pageSize);
	
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
	public int getCommentCount(int appstoreId);
	
	/**
	 * 添加评论回复
	 * @param commentId
	 * @param replyContent
	 * @param replyEmpCode
	 * @return
	 */
	public int updateCommentReply(int commentId, String replyContent, String replyEmpCode);

}
