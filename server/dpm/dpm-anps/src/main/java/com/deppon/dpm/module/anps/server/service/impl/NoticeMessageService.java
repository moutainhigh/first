package com.deppon.dpm.module.anps.server.service.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.module.anps.server.dao.INoticeMessageDao;
import com.deppon.dpm.module.anps.server.dao.INoticeSearchDao;
import com.deppon.dpm.module.anps.server.service.INoticeGroupService;
import com.deppon.dpm.module.anps.server.service.INoticeMessageService;
import com.deppon.dpm.module.anps.shared.define.AnpsConstants;
import com.deppon.dpm.module.anps.shared.domain.NoticeAuthorty;
import com.deppon.dpm.module.anps.shared.domain.NoticeComment;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessage;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadSolution;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.server.dao.IOrganizationDao;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;


public class NoticeMessageService implements INoticeMessageService {

	/**
	 * 日志
	 */
	@SuppressWarnings("all")
	private static final Logger log = LoggerFactory
			.getLogger(NoticeMessageService.class);

	private INoticeMessageDao noticeMessageDao;

	private IOrganizationDao orgDao;

	private IEmployeeDao empDao;

	private String webUrl;

	private INoticeSearchDao searchDao;
	
	private INoticeGroupService noticeGroupService;

	/**
	 * 插入公告信息详情
	 * 
	 * @param noticeTitle
	 * @param level
	 * @param noticeContent
	 * @return
	 */
	@Transactional
	public int saveNoticeMessageDetail(String noticeTitle, String level,
			String userId, String recivNames, String attactFile,
			String noticeContent, List<String> listTemp, int isPariseComment,
			String userName, String reciverObject, int receiveSize,String reciveUserDetail) {
		int result = 0;
		//Map<String, Object> hashMap = new HashMap<String, Object>();
		// Map<String, Object> userMap = new HashMap<String, Object>();
		try {
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmpCode(userId);
			EmployeeEntity employeeEntity = empDao.queryEmployeeByCode(employeeVO);

			OrganizationVO organizationVO = new OrganizationVO();
			organizationVO.setOrgId(employeeEntity.getOrgId());
			OrganizationEntity queryOrganizationByOrgEntity = orgDao
					.queryOrganizationByOrgEntity(organizationVO);
			// 用以拼接参数
			Map<String, Object> map = new HashMap<String, Object>();
			// 公文对应id
			map.put("noticeTitle", noticeTitle);
			// 应用对象
			map.put("reciveNames", recivNames);
			// 应用附件
			map.put("noticePhoto", attactFile);
			// 重要等级
			map.put("level", level);
			// 发件人姓名
			map.put("userName", userName);
			// 接收对象所属组织
			map.put("jobGroup", queryOrganizationByOrgEntity.getOrgName());
			// 发件人员工号
			map.put("employId", userId);
			// 是否可以评论点赞
			map.put("isPariseComment", isPariseComment);
			// 是否可以评论点赞
			map.put("noticeContent", noticeContent);

			map.put("receiveSize", receiveSize);
			// 接收对象
			map.put("reciverObject", reciverObject);
			// 接收对象详情
			map.put("reciveUserDetail", reciveUserDetail);
			// 插入应用详情信息
			result = noticeMessageDao.saveNoticeMentDetail(map);

			/*
			 * Integer noticeMessageId = noticeMessageDao
			 * .getNoticeMessageByUserID(userId, createTime);
			 * 
			 * 
			 * // 每个收件人插入收件表 for (String employeeId : listTemp) {
			 * 
			 * hashMap.put("noticeId", noticeMessageId);
			 * hashMap.put("receiveUserId", employeeId); result =
			 * noticeMessageDao.saveNoticeMent(hashMap); }
			 */

			// result =
			// noticeMessageDao.saveNoticeContent(noticeMessageId,noticeContent);

			// 推送的userId集合
			/*
			 * List<String> userIds = new ArrayList<String>(); // 每个收件人插入收件表 for
			 * (String employeeId : listTemp) { if
			 * (StringUtils.isBlank(employeeId)) { continue; }
			 * userIds.add(employeeId); // 每一1000条插入一次 if (userIds.size() ==
			 * MagicNumber.NUM1000) { try { for (String userMapFirst : userIds)
			 * { hashMap.put("noticeId", noticeMessageId);
			 * hashMap.put("receiveUserId", userMapFirst); result =
			 * noticeMessageDao.saveNoticeMent(hashMap); } } catch (Exception e)
			 * { log.error("根据工号每1000条插入收件表出错!!!", e); } // 清空 userIds.clear();
			 * } } // 不足1000条的 if (userIds.size() > 0) { for (String
			 * userMapFirst : userIds) { userMap.put("noticeId",
			 * noticeMessageId); userMap.put("receiveUserId", userMapFirst); //
			 * 每一1000条插入一次 result = noticeMessageDao.saveNoticeMent(userMap); }
			 * }
			 */

		} catch (Exception e) {
			log.error("插入收件表失败:" + e);
		}
		return result;

	}

	/**
	 * 插入收件人信息表
	 */
	/*
	 * @Transactional
	 * 
	 * @Override public int saveNoticeMessage(Integer noticeId, String
	 * reciverUserId) { int result = 0; try { // 用以拼接参数 Map<String, Object> map
	 * = new HashMap<String, Object>();
	 * 
	 * // 接收对象 map.put("noticeId", noticeId); map.put("receiveUserId",
	 * reciverUserId);
	 * 
	 * // 插入应用详情信息 result = noticeMessageDao.saveNoticeMent(map); } catch
	 * (Exception e) { log.info("saveNoticeMessage:" + e); } return result; }
	 */

	/**
	 * 查询公文详情
	 */
	@Override
	public NoticeMessageDetail selectNoticeMessageDetailById(int noticeId) {
		List<NoticeComment> messageList = new ArrayList<NoticeComment>();
		NoticeMessageDetail result = noticeMessageDao
				.selectNoticeMessageDetailById(noticeId);
		// 获取附件图片
		String noticePhoto = result.getNoticePhoto();
		String[] photoFiles = noticePhoto.split("@AS@P");
		StringBuffer photoBuffer = new StringBuffer();
		String path = null;
		for (String photoFile : photoFiles) {
			StringBuffer sb = new StringBuffer();
			sb.append(webUrl + "/" + "dpmfile" + "/");
			sb.append("noticeattachment/");
			if (null != photoFile && !photoFile.equals("")) {
				// 拼接文件名
				path = sb.append(photoFile).append(",").toString();

			} else {
				path = "";
			}
			photoBuffer.append(path);

		}
		result.setNoticePhoto(photoBuffer.toString().replaceAll(",$", ""));
		int readNum=result.getReadNum();
		Integer receiveSize = result.getReceiveSize();
		int noReadNum=receiveSize-readNum;
		if(noReadNum<0){
			noReadNum=0;
		}
		result.setNoReadNum(noReadNum);
		result.setReadNum(readNum);
		
		if (result.getIsPariseComment() == 1) {
			List<NoticeComment> noticeComments = noticeMessageDao
					.getNoticeComment(noticeId);
			if (null != noticeComments && noticeComments.size() > 0) {
				for (NoticeComment noticeComment : noticeComments) {
					boolean bo = isNow(noticeComment.getCreateTime());
					if (bo) {
						noticeComment.setListTime(new SimpleDateFormat("HH:mm")
								.format(noticeComment.getCreateTime()));
					} else {
						noticeComment.setListTime(new SimpleDateFormat(
								"yyyy-MM-dd").format(noticeComment
								.getCreateTime()));
					}
					messageList.add(noticeComment);

				}
			}

			result.setNoticeComments(messageList);
		}
		return result;
	}

	/**
	 * 查询公文接收消息列表
	 */
	public List<NoticeMessage> getNoticMessage(String userId, int isRead,
			int startNo, int pageSize) {
		List<NoticeMessage> messageList = new ArrayList<NoticeMessage>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("isRead", isRead);
		map.put("startNo", startNo);
		map.put("pageSize", pageSize);
		List<NoticeMessage> result = (List<NoticeMessage>) noticeMessageDao
				.selectNoticeMessage(map);

		// 遍历集合
		if (null != result && result.size() > 0) {
			for (NoticeMessage noticeMessage : result) {
				String path = getPath(noticeMessage);
				noticeMessage.setHeadPath(path);
				Integer noticeId = noticeMessage.getNoticeId();
				int readNum = noticeMessageDao.getReadNum(noticeId);
				Integer receiveSize = noticeMessage.getReceiveSize();
				int noReadNum = receiveSize-readNum;
				if(noReadNum<0){
					noReadNum=0;
				}
				noticeMessage.setNoReadNum(noReadNum);
				noticeMessage.setReadNum(readNum);

				boolean bo = isNow(noticeMessage.getCreateTime());
				if (bo) {
					noticeMessage.setListTime(new SimpleDateFormat("HH:mm")
							.format(noticeMessage.getCreateTime()));
				} else {
					noticeMessage
							.setListTime(new SimpleDateFormat("yyyy-MM-dd")
									.format(noticeMessage.getCreateTime()));
				}

				messageList.add(noticeMessage);
			}
		}

		return messageList;

	}

	/**
	 * 判断时间是不是今天
	 * 
	 * @param date
	 * @return 是返回true，不是返回false
	 */
	private static boolean isNow(Date date) {
		// 当前时间
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		// 获取今天的日期
		String nowDay = sf.format(now);

		// 对比的时间
		String day = sf.format(date);

		return day.equals(nowDay);

	}

	/**
	 * 获取接收的公文列表数量
	 */
	@Override
	public int getNoticMessageCount(String userId, int isRead) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("isRead", isRead);
		int result = noticeMessageDao.selectNoticeMessageCount(map);

		return result;
	}

	/**
	 * 获取已发布公告
	 */
	public List<NoticeMessage> getPublicNoticMessage(String userId,
			int startNo, int pageSize) {
		List<NoticeMessage> messageList = new ArrayList<NoticeMessage>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("startNo", startNo);
		map.put("pageSize", pageSize);
		List<NoticeMessage> result = (List<NoticeMessage>) noticeMessageDao
				.selecPublicMessage(map);
		// 遍历集合
		if (null != result && result.size() > 0) {
			for (NoticeMessage noticeMessage : result) {
				String path = getPath(noticeMessage);
				noticeMessage.setHeadPath(path);

				Integer noticeId = noticeMessage.getNoticeId();
				int readNum = noticeMessageDao.getReadNum(noticeId);
				Integer receiveSize = noticeMessage.getReceiveSize();
				int noReadNum = receiveSize-readNum;
                if(noReadNum<0){
                	noReadNum=0;
                }
				noticeMessage.setNoReadNum(noReadNum);
				noticeMessage.setReadNum(readNum);

				boolean bo = isNow(noticeMessage.getCreateTime());
				if (bo) {
					noticeMessage.setListTime(new SimpleDateFormat("HH:mm")
							.format(noticeMessage.getCreateTime()));
				} else {
					noticeMessage
							.setListTime(new SimpleDateFormat("yyyy-MM-dd")
									.format(noticeMessage.getCreateTime()));
				}

				messageList.add(noticeMessage);
			}
		}

		return messageList;
	}

	/**
	 * 获取已发布公告
	 */
	public int getPublicNoticMessageCount(String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		int result = (int) noticeMessageDao.selectPublicNoticeMessageCount(map);
		return result;
	}

	/*
	 * // 获取公文消息id
	 * 
	 * @Override public Integer getNoticeMessageByUserID(String userId, Date
	 * createTime) { return noticeMessageDao.getNoticeMessageByUserID(userId,
	 * createTime); }
	 */

	// 获取阅读情况
	@Override
	public List<ReadSolution> getReadSoluting(int noticeId) {
		// 获取发件人的zuzhi ID

		List<ReadSolution> readSoluList = new ArrayList<ReadSolution>();
		Integer orgId = noticeMessageDao.getOrgIdByNoticeId(noticeId);
		// 获取发件人下属分组的组织
		getReadSolt(readSoluList, noticeId, orgId);

		return readSoluList;

	}

	// 获取下属组织阅读情况
	@Override
	public List<ReadSolution> getSecondReadSoluting(int noticeId, Integer orgId) {
		// 获取发件人的zuzhi ID

		List<ReadSolution> readSoluList = new ArrayList<ReadSolution>();
		// 获取发件人下属分组的组织
		List<Integer> sendOrgId = noticeMessageDao.getSendOrg(orgId);
		for (Integer secondOrgid : sendOrgId) {
			getReadSolt(readSoluList, noticeId, secondOrgid);

		}

		return readSoluList;
	}

	// 保存公文内容
	@Transactional
	@Override
	public int saveNoticeContent(Integer noticeId, String noticeContent) {
		return noticeMessageDao.saveNoticeContent(noticeId, noticeContent);

	}

	// 保存公文评论
	@Override
	@Transactional
	public Integer saveNoticeMessageComment(String userId, int noticeId,
			String noticeComment, String toCommentEmployId, Integer commentType) {

		return noticeMessageDao.saveNoticeMessageComment(userId, noticeId,
				noticeComment, toCommentEmployId, commentType);
	}

	/**
	 * 更新是否读取
	 */
	@Override
	@Transactional
	public void updateIsRead(String userId, int noticeId, int isRead) {
		noticeMessageDao.updateIsRead(userId, noticeId, isRead);
	}

	/**
	 * 获取公文读者读取详情
	 */
	@Override
	public List<ReadPeopleDetail> getNoticeMessageReadDetail(int isRead,
			int noticeId, int startNo, int pageSize) {
		List<ReadPeopleDetail> list = new ArrayList<ReadPeopleDetail>();

		List<ReadPeopleDetail> noticeMessageReadDetail = noticeMessageDao
				.getNoticeMessageReadDetail(noticeId, isRead, startNo, AnpsConstants.pageSize);

		for (ReadPeopleDetail map : noticeMessageReadDetail) {

			StringBuffer sb = new StringBuffer();
			sb.append(webUrl + "/" + "dpmfile" + "/");
			sb.append("headPhoto/");
			// 获取文件名
			String path = (String) map.getHeadPath();
			if (null != path && !path.equals("")) {
				// 拼接文件名
				path = sb.append(path).toString();

			} else {
				path = "";
			}
			map.setHeadPath(path);
			list.add(map);
		}

		return list;
	}

	@Override
	public List<ReadPeopleDetail> getNoticeMessageReadDetailAll(int noticeId) {
		List<ReadPeopleDetail> list = new ArrayList<ReadPeopleDetail>();

		List<ReadPeopleDetail> noticeMessageReadDetail = noticeMessageDao
				.getNoticeMessageReadDetailAll(noticeId);

		for (ReadPeopleDetail map : noticeMessageReadDetail) {
			int orgLevel = map.getOrgLevel();
			String deptseq = map.getDeptseq();
			String[] orgIdList = deptseq.split("\\.");
			String orgName = map.getOrgName();

			if (orgLevel == AnpsConstants.orgLEVEL_SIX) {
				map.setCommunity(orgName);
				map.setRegion(searchDao.getEmpDetailByOrgId(orgIdList[AnpsConstants.FIVE])
						.getOrgName());
				map.setDivision(searchDao.getEmpDetailByOrgId(orgIdList[AnpsConstants.FOUR])
						.getOrgName());
			} else if (orgLevel == AnpsConstants.orgLEVEL_FIVE) {
				map.setRegion(orgName);
				map.setDivision(searchDao.getEmpDetailByOrgId(orgIdList[AnpsConstants.FOUR])
						.getOrgName());
			} else if (orgLevel == AnpsConstants.orgLEVEL_FOUR) {
				map.setDivision(orgName);
			} else {
				map.setCommunity(searchDao.getEmpDetailByOrgId(orgIdList[AnpsConstants.FIVE])
						.getOrgName());
				map.setRegion(searchDao.getEmpDetailByOrgId(orgIdList[AnpsConstants.FIVE])
						.getOrgName());
				map.setDivision(searchDao.getEmpDetailByOrgId(orgIdList[AnpsConstants.FOUR])
						.getOrgName());
			}

			// deptseq.substring(arg0, deptseq.lastIndexOf("."));

			StringBuffer sb = new StringBuffer();
			sb.append(webUrl + "/" + "dpmfile" + "/");
			sb.append("headPhoto/");
			// 获取文件名
			String path = (String) map.getHeadPath();
			if (null != path && !path.equals("")) {
				// 拼接文件名
				path = sb.append(path).toString();

			} else {
				path = "";
			}
			map.setHeadPath(path);
			list.add(map);
		}

		return list;
	}

	/**
	 * 获取公文读者读取列表人员数量
	 */
	@Override
	public int getNoticeMessageReadDetailCount(int isRead, int noticeId) {
		return noticeMessageDao.getNoticeMessageReadDetailCount(noticeId,
				isRead);

	}

	// 判断有否有发布公文权限
	@Override
	public List<NoticeAuthorty> getNoticeAuthorty(String userId) {
		return (List<NoticeAuthorty>) noticeMessageDao
				.getNoticeAuthorty(userId);

	}

	// 更新点赞状态
	@Override
	@Transactional
	public int updateIsParse(int noticeId, String userId, int isParise) {
		return noticeMessageDao.updateIsParse(noticeId, userId, isParise);
	}

	@Override
	public Integer getIsPariseStatus(String userId, int noticeId) {
		Integer isParise = noticeMessageDao.getIsPariseStatus(noticeId, userId);
		if (null == isParise) {
			isParise = 0;
		}
		return isParise;
	}

	// 获取头像路径
	public String getPath(NoticeMessage noticeMessage) {
		StringBuffer sb = new StringBuffer();
		sb.append(webUrl + "/" + "dpmfile" + "/");
		sb.append("headPhoto/");
		// 获取文件名
		String path = noticeMessage.getHeadPath();
		if (null != path && !path.equals("")) {
			// 拼接文件名
			path = sb.append(path).toString();
		} else {
			path = "";
		}
		return path;
	}

	// 获取阅读情况
	public void getReadSolt(List<ReadSolution> readSoluList, Integer noticeId,
			Integer secondOrgid) {

		// 获取该组织已读人员数量
		ReadSolution readSoluting = (ReadSolution) noticeMessageDao
				.getReadSoluting(noticeId, secondOrgid, 1);
		// 获取每个组织的人员总数
		Integer totalNum = noticeMessageDao.getTotalReadNum(
				secondOrgid);
		readSoluting.setOrgId(secondOrgid);
		if (totalNum > 0) {
			double readRateSolu = (double) readSoluting.getReadNum()
					/ (double) totalNum;
			if (readRateSolu >= AnpsConstants.read_maxrate) {
				readSoluting.setReadRateColour("green");
			} else if (readRateSolu >= AnpsConstants.read_minrate && readRateSolu < AnpsConstants.read_maxrate) {
				readSoluting.setReadRateColour("orange");
			} else {
				readSoluting.setReadRateColour("red");
			}
			String readRate = NumberFormat.getPercentInstance().format(
					readRateSolu);

			readSoluting.setReadRate(readRate);
			readSoluting.setReadRateSort(readRateSolu * AnpsConstants.hundred);

		} else {
			readSoluting.setReadRate("0%");
			readSoluting.setReadRateColour("red");
			readSoluting.setReadRateSort(0.0 * AnpsConstants.hundred);
		}
		readSoluting.setTotalNum(totalNum);
		readSoluList.add(readSoluting);

	}

	// 删除已读消息
	@Override
	public int deletIsReadMessage(int noticeId, String userId) {
		return noticeMessageDao.deletIsReadMessage(noticeId, userId);
	}

	// 获取所有的公文
	@Override
	public List<NoticeMessageDetail> getNoticeMessageDetail() {
		return noticeMessageDao.getNoticeMessageDetail();
	}

	/**
	 * 获取当天发布的公文
	 * 
	 * @return
	 */
	@Override
	public List<NoticeMessage> getTodayPublicNoticMessage() {
		List<NoticeMessage> messageList = new ArrayList<NoticeMessage>();
		List<NoticeMessage> result = noticeMessageDao
				.getTodayPublicNoticMessage();
		// 遍历集合
		if (null != result && result.size() > 0) {
			for (NoticeMessage noticeMessage : result) {
				Integer noticeId = noticeMessage.getNoticeId();
				int readNum = noticeMessageDao.getReadNum(noticeId);
				Integer receiveSize = noticeMessage.getReceiveSize();
				int noReadNum = receiveSize-readNum;
                if(noReadNum<0){
                	noReadNum=0;
                }
				noticeMessage.setNoReadNum(noReadNum);
				noticeMessage.setReadNum(readNum);

				noticeMessage.setListTime(new SimpleDateFormat(
						"yyyy-mm-dd HH:mm:ss").format(noticeMessage
						.getCreateTime()));

				messageList.add(noticeMessage);
			}
		}
		return messageList;

	}

	/**
	 * 获取当天发布的公文数量
	 * 
	 * @return
	 */
	@Override
	public int getTodayPublicNoticMessageCount() {
		// TODO Auto-generated method stub
		return noticeMessageDao.getTodayPublicNoticMessageCount();
	}
	
	@Override
	public int saveNoticeReciveMessage(String userId,
			Integer noticeId) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("noticeId", noticeId);
		hashMap.put("receiveUserId", userId);
		
		return noticeMessageDao.saveNoticeMent(hashMap);
	}

	// 公文已经发送了提醒 状态变为1
	@Override
	public int updateIsSend(Integer noticeId) {
		// TODO Auto-generated method stub
		return noticeMessageDao.updateIsSend(noticeId);
	}
	//判断公文收件表是否存在
	@Override
	public List<NoticeMessage> getReceiveMessage(String userId, Integer id) {
		// TODO Auto-generated method stub
		return noticeMessageDao.getReceiveMessage(userId,id);
	}
	
	//获取阅读人员详情
	@Override
	public ReadPeopleDetail getReadPeopleDetail(String userId) {
		return noticeMessageDao.getReadPeopleDetail(userId);
	}
	
	
	//获取阅读人员详情
	@Override
	public List<NoticeMessage> getNoReadNotice(String userId) {
		String deptSeq=null;
		List<NoticeMessageDetail> noticList = this.getNoticeMessageDetail();
		com.deppon.dpm.module.anps.shared.domain.OrganizationEntity org = searchDao.getOrgByEmpCode(userId);
		if(null!=org){
		 deptSeq = org.getDeptSeq();
		}
		if (null != noticList && noticList.size() > 0) {
			for (NoticeMessageDetail noticeMessage : noticList) {
				if (null != noticeMessage.getReciverObject()) {
					Boolean bol = isInReceiverObject(noticeMessage, deptSeq ,userId);
					if (bol) {
						List<NoticeMessage> noticeReceList = this
								.getReceiveMessage(userId,
										noticeMessage.getId());
						if (userId.equalsIgnoreCase(this
								.selectNoticeMessageDetailById(
										noticeMessage.getId()).getSendUserId())) {
							continue;
						}
						if ( null == noticeReceList
								|| noticeReceList.size() == 0) {
							this.saveNoticeReciveMessage(userId,
											noticeMessage.getId());
						}
					}
				}
			}
		}
		
		// 获得未读公告信息列表
		List<NoticeMessage> noticeMessageList = this.getNoticMessage(userId,
				0, 0, 0);
		
		// 获得公告信息个数
		//int noticeMessageListCount = this.getNoticMessageCount(userId, 0);
		
		return noticeMessageList;
	}
	
	// 是否在接收对象里面
		public Boolean isInReceiverObject(NoticeMessageDetail noticeMessage,
				String deptSeq ,String userId) {
			String[] reciverObjects = noticeMessage.getReciverObject().split(",");
			Boolean flag = false;
			for (String reciverObject : reciverObjects) {
				// 接收对象为员工
				if (reciverObject.contains("per")) {
					if (reciverObject.replace("per:", "").equalsIgnoreCase(userId)) {
						flag = true;
						break;
					}
				}
				// 接收对象为组织
				else if (reciverObject.contains("org")) {
					if(null!=deptSeq){
					if (deptSeq.contains(reciverObject.replace("org:", ""))) {
						flag = true;
						break;
					}
					}
				}
					// 接收对象为群组
				else if (reciverObject.contains("group")) {
					List<NoticeGroupEntity> groupMemberList = noticeGroupService
							.getGroupMember(reciverObject.replace("group:", ""));
					if (null != groupMemberList && groupMemberList.size() > 0) {
					   flag=isInGroup(groupMemberList,deptSeq, userId);
					}
				}
			}
			return flag;
		}
	    //判断接收对象是否在群组中
		private Boolean isInGroup(List<NoticeGroupEntity> groupMemberList , String deptSeq,String userId) {
			Boolean flag = false;
			for (NoticeGroupEntity noticeGroup : groupMemberList) {
				// 群组人员
				if (noticeGroup.getMemberType().equals("0")) {
					if (userId.equalsIgnoreCase(noticeGroup.getMemberCode())) {
						flag = true;
						break;
					}
				} else if (noticeGroup.getMemberType().equals("1")) {
					if(null!=deptSeq){
					if (deptSeq.contains(noticeGroup.getMemberCode())) {
						flag = true;
						break;
					}
					}
					// 群组岗位
				} else if (noticeGroup.getMemberType().equals("2")) {
					if (null == noticeGroup.getCodeType()) {
						continue;
					} else if (noticeGroup.getCodeType()
							.equalsIgnoreCase("orgId")) {
						if (deptSeq.contains(noticeGroup
								.getMemberCode())) {
							flag = true;
							break;
						}
					} else if (noticeGroup.getCodeType()
							.equalsIgnoreCase("empid")) {
						if (userId.equalsIgnoreCase(noticeGroup
								.getMemberCode())) {
							flag = true;
							break;
						}
					}
				}
			}
			return flag;
		}
		
	public List<String> getUserIdsByLowVersion(){
		return empDao.getUserIdsByLowVersion();
	}

	public INoticeMessageDao getNoticeMessageDao() {
		return noticeMessageDao;
	}

	public void setNoticeMessageDao(INoticeMessageDao noticeMessageDao) {
		this.noticeMessageDao = noticeMessageDao;
	}

	public IOrganizationDao getOrgDao() {
		return orgDao;
	}

	public void setOrgDao(IOrganizationDao orgDao) {
		this.orgDao = orgDao;
	}

	public IEmployeeDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IEmployeeDao empDao) {
		this.empDao = empDao;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public INoticeSearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(INoticeSearchDao searchDao) {
		this.searchDao = searchDao;
	}

	public INoticeGroupService getNoticeGroupService() {
		return noticeGroupService;
	}

	public void setNoticeGroupService(INoticeGroupService noticeGroupService) {
		this.noticeGroupService = noticeGroupService;
	}

	

	

}
