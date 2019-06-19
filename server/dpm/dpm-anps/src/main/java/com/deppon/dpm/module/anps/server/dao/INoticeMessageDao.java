package com.deppon.dpm.module.anps.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.shared.domain.NoticeAuthorty;
import com.deppon.dpm.module.anps.shared.domain.NoticeComment;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessage;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadSolution;

public interface INoticeMessageDao {
	// 保存公文发件表
	public int saveNoticeMentDetail(Map<String, Object> map);

	// 保存公文内容
	public int saveNoticeMent(Map<String, Object> map);

	// 获取公文详情
	public NoticeMessageDetail selectNoticeMessageDetailById(int noticeId);

	// 获取收件表列表
	public List<NoticeMessage> selectNoticeMessage(Map<String, Object> map);

	// 获取已发布消息列表
	public List<NoticeMessage> selecPublicMessage(Map<String, Object> map);

	// 获取收件表数量
	public int selectNoticeMessageCount(Map<String, Object> map);

	// 获取已发布消息列表数量
	public int selectPublicNoticeMessageCount(Map<String, Object> map);

	// 获取公文id
	public int getNoticeMessageByUserID(String userId, Date createTime);

	// 每个组织 已读人员数量
	public ReadSolution getReadSoluting(int noticeId, Integer secondOrgid,
			Integer isRead);

	// 每个组织人员总数量
	public Integer getTotalReadNum( Integer secondOrgid);

	// 保存公文内容
	public int saveNoticeContent(Integer noticeId, String noticeContent);

	// 跟新是否已读
	public void updateIsRead(String userId, int noticeId, int isRead);

	// 获取消息阅读详情
	public List<ReadPeopleDetail> getNoticeMessageReadDetail(int noticeId,
			int isRead, int startNo, int pageSize);

	// 获取消息阅读详情数量
	public int getNoticeMessageReadDetailCount(int noticeId, int isRead);

	// 判断是否有发布公文权限
	public List<NoticeAuthorty> getNoticeAuthorty(String userId);

	// 获取公文读取人数
	public int getReadNum(Integer noticeId);

	// 获取公文未读取人数
	public int getNoReadNum(Integer noticeId);

	// 获取发件人组织
	public List<Integer> getSendManOrg(int noticeMessageId);
	// 获取发件人组织
	public List<Integer> getSendOrg(int orgId);

	// 获取公文评论
	public List<NoticeComment> getNoticeComment(int noticeMessageId);

	// 保存公文评论
	public Integer saveNoticeMessageComment(String userId, int noticeMessageId,
			String noticeComment, String toCommentEmployId, Integer commentType);

	// 更新点赞状态
	public int updateIsParse(int noticeId, String userId, int isParise);

	// 获取点赞状态
	public Integer getIsPariseStatus(int noticeId, String userId);
    //删除已读消息
	public int deletIsReadMessage(int noticeId, String userId);
    //获取所有公文
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
	/**
	 * 根据组织ID获取部门信息
	 * @param orgId
	 */
	public List<ReadPeopleDetail> getNoticeMessageReadDetailAll(int noticeId);
    //
	public Integer getOrgIdByNoticeId(int noticeId);
	//公文已经发送了提醒 状态变为1
	public int updateIsSend(int noticeId);
	//判断公文收件表是否存在
	public List<NoticeMessage> getReceiveMessage(String userId, Integer id);
	//获取阅读人员详情
	public ReadPeopleDetail getReadPeopleDetail(String userId);

}
