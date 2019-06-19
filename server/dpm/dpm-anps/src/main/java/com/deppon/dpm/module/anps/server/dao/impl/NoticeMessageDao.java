package com.deppon.dpm.module.anps.server.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.anps.server.dao.INoticeMessageDao;
import com.deppon.dpm.module.anps.shared.domain.NoticeAuthorty;
import com.deppon.dpm.module.anps.shared.domain.NoticeComment;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessage;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadSolution;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

@SuppressWarnings("all")
public class NoticeMessageDao extends iBatis3DaoImpl implements
		INoticeMessageDao {

	private Map<String, Object> map = new HashMap<String, Object>();
	private String NAME_SPACE = "com.deppon.dpm.module.anps.server.dao.impl.NoticeMessageDao.";

	/**
	 * 插入发件表
	 */
	public int saveNoticeMentDetail(Map<String, Object> map) {
		return getSqlSession().insert(NAME_SPACE + "insertNoticeMessageDetail",
				map);
	}

	/**
	 * 插入收件箱
	 */
	@Override
	public int saveNoticeMent(Map<String, Object> map) {
		return getSqlSession().insert(NAME_SPACE + "insertNoticeMessage", map);
	}

	/**
	 * 获取公文消息详情
	 */
	@Override
	public NoticeMessageDetail selectNoticeMessageDetailById(int noticeMessageId) {

		return (NoticeMessageDetail) getSqlSession().selectOne(
				NAME_SPACE + "getNoticeMessageById", noticeMessageId);
	}

	/**
	 * 获取信息列表
	 * 
	 * @param map
	 */
	@Override
	public List<NoticeMessage> selectNoticeMessage(Map<String, Object> map) {
		return getSqlSession().selectList(NAME_SPACE + "getNoticeMessage", map);

	}

	/**
	 * 获取信息数量
	 * 
	 * @param userId
	 */
	@Override
	public int selectNoticeMessageCount(Map<String, Object> map) {
		return (Integer) getSqlSession().selectOne(
				NAME_SPACE + "getNoticeMessageCount", map);

	}

	/**
	 * 获取已发布信息列表
	 */
	@Override
	public List<NoticeMessage> selecPublicMessage(Map<String, Object> map) {
		return getSqlSession().selectList(
				NAME_SPACE + "getPublicNoticeMessage", map);

	}

	/**
	 * 获取已发布信息数量
	 * 
	 * @param userId
	 */
	@Override
	public int selectPublicNoticeMessageCount(Map<String, Object> map) {
		return (Integer) getSqlSession().selectOne(
				NAME_SPACE + "getPublicNoticeMessageCount", map);

	}

	/**
	 * 获取公文消息ID
	 * 
	 * @param userId
	 */
	@Override
	public int getNoticeMessageByUserID(String userId, Date createTime) {
		map.put("userId", userId);
		map.put("createTime", createTime);

		return (Integer) getSqlSession().selectOne(
				NAME_SPACE + "getNoticeMessageByUserID", map);
	}

	/**
	 * 获取阅读情况
	 * 
	 * @param noticeMessageId
	 */
	@Override
	public ReadSolution getReadSoluting(int noticeMessageId,
			Integer secondOrgid, Integer isRead) {
		map.put("noticeMessageId", noticeMessageId);
		map.put("secondOrgid", secondOrgid);
		map.put("isRead", isRead);
		return (ReadSolution) getSqlSession().selectOne(
				NAME_SPACE + "getReadSoluting", map);
	}

	@Override
	public Integer getTotalReadNum(Integer secondOrgid) {
		map.put("secondOrgid", secondOrgid);
		return (Integer) getSqlSession().selectOne(
				NAME_SPACE + "getTotalReadNum", map);
	}

	/**
	 * 保存文件内容
	 */
	@Override
	public int saveNoticeContent(Integer noticeMessageId, String noticeContent) {
		map.put("noticeMessageId", noticeMessageId);
		map.put("noticeContent", noticeContent);
		return getSqlSession().insert(NAME_SPACE + "insertNoticeContent", map);

	}

	/**
	 * 更新状态
	 */
	@Override
	public void updateIsRead(String userId, int noticeMessageId, int isRead) {
		map.put("noticeMessageId", noticeMessageId);
		map.put("isRead", isRead);
		map.put("userId", userId);
		getSqlSession().update(NAME_SPACE + "updateIsRead", map);

	}

	/**
	 * 获取阅读详情
	 */
	@Override
	public List<ReadPeopleDetail> getNoticeMessageReadDetail(
			int noticeMessageId, int isRead, int startNo, int pageSize) {

		map.put("noticeMessageId", noticeMessageId);
		map.put("isRead", isRead);
		map.put("startNo", startNo);
		map.put("pageSize", pageSize);
		return getSqlSession().selectList(
				NAME_SPACE + "getNoticeMessageReadDetail", map);

	}

	/**
	 * 获取阅读详情个数
	 */
	@Override
	public int getNoticeMessageReadDetailCount(int noticeMessageId, int isRead) {
		map.put("noticeMessageId", noticeMessageId);
		map.put("isRead", isRead);
		return (Integer) getSqlSession().selectOne(
				NAME_SPACE + "getNoticeMessageReadDetailCount", map);
	}
	
	@Override
	public List<ReadPeopleDetail> getNoticeMessageReadDetailAll(int noticeId) {
		map.put("noticeMessageId", noticeId);
		return getSqlSession().selectList(
				NAME_SPACE + "getNoticeMessageReadDetailAll", map);
	}

	// 判断是否有发布公文权限
	@Override
	public List<NoticeAuthorty> getNoticeAuthorty(String userId) {
		return getSqlSession().selectList(NAME_SPACE + "getNoticeAuthorty",
				userId);

	}

	// 获取读取的人 数量
	@Override
	public int getReadNum(Integer noticeId) {

		return (Integer) getSqlSession().selectOne(NAME_SPACE + "getReadNum",
				noticeId);
	}

	// 获取没有读取的人 数量
	@Override
	public int getNoReadNum(Integer noticeId) {
		return (Integer) getSqlSession().selectOne(NAME_SPACE + "getNoReadNum",
				noticeId);

	}

	// 获取发件人所在组织
	@Override
	public List<Integer> getSendManOrg(int noticeMessageId) {

		return (List<Integer>) getSqlSession().selectList(
				NAME_SPACE + "getSendManOrg", noticeMessageId);
	}
	// 获取组织下面分支组织
	@Override
	public List<Integer> getSendOrg(int orgId) {
		
		return (List<Integer>) getSqlSession().selectList(
				NAME_SPACE + "getSendOrg", orgId);
	}

	// 获取公文评论
	@Override
	public List<NoticeComment> getNoticeComment(int noticeMessageId) {
		return getSqlSession().selectList(NAME_SPACE + "getNoticeComment",
				noticeMessageId);
	}

	// 插入公文评论
	@Override
	public Integer saveNoticeMessageComment(String userId, int noticeId,
			String noticeComment, String toCommentEmployId, Integer commentType) {
		map.put("noticeMessageId", noticeId);
		map.put("noticeComment", noticeComment);
		map.put("userId", userId);
		map.put("toCommentEmployId", toCommentEmployId);
		map.put("commentType", commentType);

		return getSqlSession().insert(NAME_SPACE + "saveNoticeMessageComment",
				map);
	}

	// 跟新点赞状态
	@Override
	public int updateIsParse(int noticeId, String userId,int isParise) {
		map.put("noticeId", noticeId);
		map.put("userId", userId);
		map.put("isParise", isParise);

		return getSqlSession().update(NAME_SPACE + "updateIsParse", map);
	}

	// 获取点赞状态
	@Override
	public Integer getIsPariseStatus(int noticeId, String userId ) {

		map.put("noticeId", noticeId);
		map.put("userId", userId);
		return (Integer) getSqlSession().selectOne(
				NAME_SPACE + "getIsPariseStatus", map);
	}
    //删除已读消息
	@Override
	public int deletIsReadMessage(int noticeId, String userId) {
		map.put("noticeId", noticeId);
		map.put("userId", userId);
		
		return getSqlSession().delete(NAME_SPACE +"deletIsReadMessage", map);
	}

	@Override
	public List<NoticeMessageDetail> getNoticeMessageDetail() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAME_SPACE + "getNoticeMessageDetail");
	}
	/**
     * 获取当天发布的公文
     * @return
     */
	@Override
	public List<NoticeMessage> getTodayPublicNoticMessage() {
		return getSqlSession().selectList(NAME_SPACE + "getTodayPublicNoticMessage");
	}
	/**
     * 获取当天发布的公文数量
     * @return
     */
	@Override
	public int getTodayPublicNoticMessageCount() {
		return (Integer) getSqlSession().selectOne(NAME_SPACE + "getTodayPublicNoticMessageCount");
	}

	@Override
	public Integer getOrgIdByNoticeId(int noticeId) {
		map.put("noticeId", noticeId);
		return (Integer) getSqlSession().selectOne(NAME_SPACE + "getOrgIdByNoticeId", map);
	}
	//公文已经发送了提醒 状态变为1
	@Override
	public int updateIsSend(int noticeId) {
		map.put("noticeId", noticeId);
		return getSqlSession().update(NAME_SPACE + "updateIsSend", map);
	}
	//判断公文收件表是否存在
	@Override
	public List<NoticeMessage> getReceiveMessage(String userId, Integer id) {
		map.put("noticeId", id);
		map.put("userId", userId);
		return getSqlSession().selectList(NAME_SPACE + "getReceiveMessage", map);
	}
	//获取阅读人员详情
	@Override
	public ReadPeopleDetail getReadPeopleDetail(String userId) {
		map.put("userId", userId);
		return (ReadPeopleDetail) getSqlSession().selectOne(NAME_SPACE + "getReadPeopleDetail", map);
	}

	

}
