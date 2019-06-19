package com.deppon.dpm.tongxunlu.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.HxQuestionEntity;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackHxRecordEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackPushEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackProblemListEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackSearch;

/**
 * 意见反馈
 * 
 * @author 245968
 * 
 */
public interface IFeedbackDao {
	

	/**
	 * 意见反馈
	 * 
	 * @param map
	 */
	public void feedback(Map<String, String> map);

	/**
	 * 获取意见反馈
	 * 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<FeedBackDetailsEntity> getFeedbackDetails(int start,
			int pageSize,FeedbackSearch search);

	/**
	 * 获取意见反馈见的数量
	 * 
	 * @return
	 */
	public int getTotalCounts(FeedbackSearch search);

	/**
	 * 获取负责人ID条数
	 * @param excEmpCode
	 * @return
	 */
	public int getExcEmpCodeCount(String excEmpCode);
	
	/**
	 * 意见反馈回复更新
	 * 
	 * @param feedBackDetailsEntity
	 * @return
	 */
	public int updateFeedbackReply(FeedBackDetailsEntity feedBackDetailsEntity);
	
	/**
	 * 意见反馈更新
	 * 
	 * @param feedBackDetailsEntity
	 * @return
	 */
	public int updateFeedback(FeedBackDetailsEntity feedBackDetailsEntity);

	/**
	 * 根据id获取意见反馈时间
	 * 
	 * @param id
	 * @return
	 */
	public Date getSubmitTimeById(int id);

	/**
	 * 根据员工id获取意见反馈列表
	 */
	public List<FeedBackDetailsEntity> getFeedbackByEmpcode(int start,
			int pageSize, String empCode);
	
	/**
	 * 意见反馈 问题类型列表
	 */
	public List<FeedbackProblemListEntity> problemList();

	/**
	 * 获取问题反馈详情
	 * @param id
	 * @return
	 */
	public FeedBackDetailsEntity getFeedBackDetailsById(int id);
	
	/**
	 * 获取反馈负责人信息
	 * @param id
	 * @return
	 */
	public EmployeeEntity getExecuteEntById(int id);

	/**
	 * 根据上报这工号，获取最新上报问题及对应处理人
	 * @param empCode
	 * @return
	 */
	public FeedBackPushEntity getSloverById(String empCode);

	/**
	 * 根据工号查询对应的问题反馈
	 * @param userId
	 * @param start 从第几条开始
	 * @param size  查询多少条
	 * @return
	 */
	public List<FeedBackDetailsEntity> getReportListByHandleId(String userId, int start, int size, FeedbackSearch search);

	/**
	 * 获取查询结果一共多少条
	 * @param userId
	 * @param search
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
