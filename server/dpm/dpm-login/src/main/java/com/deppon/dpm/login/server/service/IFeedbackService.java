package com.deppon.dpm.login.server.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.HxQuestionEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackHxRecordEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackPushEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackProblemListEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackSearch;

/**
 * 意见反馈service层
 * 
 * @author 231586
 * 
 */
public interface IFeedbackService {

	/**
	 * 意见反馈
	 * 
	 * @param files
	 * @param fileName
	 * @param content
	 * @param userId
	 * @param osType
	 * @param type
	 */
	public void feedback(File[] files, String[] fileName, String content,
			String userId, String osType, String type);
	
	/**
	 * 欢行意见反馈
	 * 
	 * @param files
	 * @param fileName
	 * @param content
	 * @param userId
	 * @param osType
	 * @param type
	 */
	public List<String> feedbackHx(File[] files, String[] fileName, String content,
			String userId, String osType, String type);

	/**
	 * 获取意见反馈，用于页面展示
	 * 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<FeedBackDetailsEntity> getFeedbackDetails(int start,
			int pageSize,FeedbackSearch search);

	/**
	 * 意见反馈总条数
	 * 
	 * @return
	 */
	public int feedBackCount(FeedbackSearch search);
	
	/**
	 * 判断是否是意见反馈负责人
	 * @param excEmpCode
	 * @return
	 */
	public boolean checkExcEmpCode(String excEmpCode);

	/**
	 * 更新意见反馈回复
	 * 
	 * @param feedBackDetailsEntity
	 * @return
	 */
	public String updateFeedbackReply(FeedBackDetailsEntity feedBackDetailsEntity);
	
	/**
	 * 更新意见反馈
	 * 
	 * @param feedBackDetailsEntity
	 * @return
	 */
	public String updateFeedback(FeedBackDetailsEntity feedBackDetailsEntity);

	/**
	 * 根据id获取提交时间
	 * 
	 * @param id
	 * @return
	 */
	public Date getSubmitTimeById(int id);

	/**
	 * 根据员工id获取意见反馈列表
	 * 
	 * @param start
	 * @param pageSize
	 * @param empCode
	 * @return
	 */
	public Map<String, List<FeedBackDetailsEntity>> getFeedbackByEmpcode(
			int start, int pageSize, String empCode);
	
	/**
	 * 意见反馈 问题类型列表
	 */
	public List<FeedbackProblemListEntity> problemList();

	/**
	 * 根据id返回问题反馈详情
	 * @param id
	 * @return
	 */
	public FeedBackDetailsEntity getFeedBackDetailsById(int id);

	/**
	 * 根据上报人工号，查询最新上报的数据对应处理人
	 * @param userId
	 * @return
	 */
	public FeedBackPushEntity getSloverById(String userId);

	/**
	 * 获取对应用户的待处理列表
	 * @param userId
	 * @param current 当前页
	 * @param pageSize 一页的条数
	 * @return
	 */
	public List<FeedBackDetailsEntity> getReportListByHandleId(String userId, int current, int pageSize, FeedbackSearch search);

	/**
	 * 获取该工号收到的问题反馈的条数
	 * @param userId
	 * @return
	 */
	public int getReportListSize(String userId, FeedbackSearch search);
	
	/**
	 * 判断userId指定员工是否还有【指定类型】的意见反馈
	 * @param type 意见反馈类型
	 * @param userId 工号
	 * */
	public boolean hasUnsolvedProblem(String type,String userId);
	
	/**
	 * 获取欢行小服务台问题列表
	 * @since 2019-04-12
	 * */
	public List<HxQuestionEntity> getHxQuestions();
	
	/**
	 * 根据工号获取小服务台聊天记录
	 * @since 2019-04-13
	 * */
	public FeedBackHxRecordEntity getHxChatRecordByUserId(String userId);
	
	/**
	 * 根据工号新增小服务台聊天记录
	 * @since 2019-04-13
	 * */
	public void insertHxChatRecord(String userId,String content,String type) throws Exception;
	
	/**
	 * 根据工号更新小服务台聊天记录
	 * @since 2019-04-13
	 * */
	public void updateHxChatRecord(String userId,String content) throws Exception;
}
