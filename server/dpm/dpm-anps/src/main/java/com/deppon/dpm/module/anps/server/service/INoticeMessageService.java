package com.deppon.dpm.module.anps.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.shared.domain.NoticeAuthorty;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessage;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadSolution;

public interface INoticeMessageService {
    //通过id
	public NoticeMessageDetail selectNoticeMessageDetailById(int noticeId);

	public List<NoticeMessage> getNoticMessage(String userId, int isRead,
			int startNo, int pageSize);

	public int getNoticMessageCount(String userId, int isRead);

	public List<NoticeMessage> getPublicNoticMessage(String userId,
			int startNo, int pageSize);

	public int getPublicNoticMessageCount(String userId);

	/**
	 * 插入公文信息
	 * 
	 * @param noticeTitle
	 * @param level
	 * @param userName
	 * @param noticeContent
	 * @param photos
	 * @param photosFileName
	 * @param receiveUserId
	 * @param userId
	 * @param createTime
	 * @param recivNames 
	 * @param attactFile 
	 * @param noticeContent 
	 * @param listTemp 
	 * @param isParise 
	 * @param userName 
	 * @param reciverObject 
	 * @param receiveSize 
	 * @param reciveUserDetail 
	 * @param sendUserId 
	 * @return
	 */
	public int saveNoticeMessageDetail( String noticeTitle,
			String level, String userId,  String recivNames,
			String attactFile, String noticeContent, List<String> listTemp, int isParise, String userName, String reciverObject, int receiveSize, String reciveUserDetail);

	/**
	 * 插入公文信息
	 * 
	 * @param noticeTitle
	 * @param level
	 * @param userName
	 * @param receiveUserId
	 * @return
	 */
	//public int saveNoticeMessage(Integer noticeId, String reciverUserId);

	//public Integer getNoticeMessageByUserID(String userId, Date createTime);

	public List<ReadSolution> getReadSoluting(int noticeId);
	public List<ReadSolution> getSecondReadSoluting(int noticeId, Integer orgId);

	// public List<EmployeeVO> getEmpByOrgId(String pid, int start, int
	// pageSize);

	public int saveNoticeContent(Integer noticeId, String noticeContent);

	public void updateIsRead(String userId, int noticeId, int isRead);

	public List<ReadPeopleDetail> getNoticeMessageReadDetail(int isRead,
			int noticeId, int i, int pageSize);

	public int getNoticeMessageReadDetailCount(int isRead, int noticeId);

	// 判断有否有发布公文权限
	public List<NoticeAuthorty> getNoticeAuthorty(String userId);

	// 插入评论
	public Integer saveNoticeMessageComment(String userId, int noticeId, String noticeComment, String toCommentEmployId, Integer commentType);
    //更新点赞状态
	public int updateIsParse(int noticeId, String userId, int isParise);
    //获取点赞状态
	public Integer getIsPariseStatus(String userId, int noticeId);
    //删除已读消息
	public int deletIsReadMessage(int noticeId, String userId);
    /**
     * 获取所有公文列表
     * @return
     */
	public List<NoticeMessageDetail> getNoticeMessageDetail();
    /**
     * 获取当天发布的公文
     * @return
     */
	public List<NoticeMessage> getTodayPublicNoticMessage();
	/**
     * 获取当天发布的公文数量
     * @return
     */
	public int getTodayPublicNoticMessageCount();
    
	public List<ReadPeopleDetail> getNoticeMessageReadDetailAll(int noticeId);
    //公文已经发送了提醒 状态变为1
	public int updateIsSend(Integer id);
    //保存公文接收信息
	public int saveNoticeReciveMessage(String userId,
			Integer integer);
    //判断公文是否存在
	public List<NoticeMessage> getReceiveMessage(String userId, Integer id);
    //获取阅读人员详情
	public ReadPeopleDetail getReadPeopleDetail(String userId);

	public List<NoticeMessage> getNoReadNotice(String userId);
	//获取低版本用户的工号
	public List<String> getUserIdsByLowVersion();

}
