package com.deppon.dpm.module.anps.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.anps.server.service.INoticeGroupService;
import com.deppon.dpm.module.anps.server.service.INoticeMessageService;
import com.deppon.dpm.module.anps.server.service.INoticeSearchService;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.module.anps.shared.define.AnpsConstants;
import com.deppon.dpm.module.anps.shared.domain.NoticeAuthorty;
import com.deppon.dpm.module.anps.shared.domain.NoticeComment;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessage;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.NoticeSendInfo;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadSolution;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.foss.framework.shared.encypt.base64.BASE64Decoder;

/**
 * 公告信息action
 * 
 * @author 500612
 * 
 */

public class NoticeMessageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	private static final Logger log = LoggerFactory
			.getLogger(NoticeMessageAction.class);
	/**
	 * 公告信息详情实体类
	 */
	private NoticeMessageDetail noticeMessageDetail = new NoticeMessageDetail();
	/**
	 * 公告信息实体类
	 */
	private NoticeMessage noticeMessage = new NoticeMessage();
	private List<NoticeMessage> noticeMessageList = null;
	private static final int PAGESIZE_10 = 10;
	private static final int PAGESIZE_30 = 30;
	private INoticeMessageService noticeMessageService;
	private IJPushNewService jPushNewService;
	private INoticeSearchService searchService;
	private INoticeGroupService noticeGroupService;
	private IReceiveObjectService receiveService;
	private JPushParam jpushParam = new JPushParam();

	/**
	 * 公告信息id
	 */
	private int noticeId;

	/**
	 * 是否从未读消息列表进入详情 0：需要更新读取状态 ， 1：不需要 直接点击进入详情
	 */
	private int state;

	// 公文评论内容
	private String noticeComment;

	/**
	 * 是否已读. 0未读 1 已读
	 */
	private int isRead;

	/**
	 * 是否点赞. 0未点赞 1 已点赞
	 */
	private int isParise;

	/**
	 * 员工id
	 */
	private String userId;

	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 起始评论编号
	 */
	private int startNo;

	/**
	 * 人员阅读详情开始页
	 */
	private int startNoRead;
	/**
	 * 每页条数
	 */
	private int pageSize = PAGESIZE_10;
	private int pageSizeRead = PAGESIZE_30;

	// 接收对象
	//private List<String> receiveUserId;

	private File[] files;

	private String[] fileNames;

	private String webUrl;
	/**
	 * 组织ID
	 */
	private Integer orgId;
	/**
	 * 公文图片存储地址
	 */
	private static String filePath = "/dpmfile/noticeattachment/";

	/**
	 * 发件人插入公文信息并且发送信息
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	/*public void saveNoticeMessageDetail() {
		// 消息发送实体
		JPushParam entity = new JPushParam();
		int count = 0;
		Result<Object> result = new Result<Object>();
		// 收件人员工工号
		List<String> reciverUserId = new ArrayList<String>();
		List<String> reciverUser = new ArrayList<String>();
		List<String> reciverName = new ArrayList<String>();
		List<String> reciverObjects = new ArrayList<String>();
		String sendUserId = null;
		String noticeTitle = null;
		String noticeContent = null;
		String level = null;
		String userName = null;
		String sendUser = null;
		int isPariseComment = 0;
		// 接收参数
		BufferedReader bu;

		long start = System.currentTimeMillis();
		try {
			bu = ServletActionContext.getRequest().getReader();
			StringBuffer fileNameList = new StringBuffer();
			// 编码转换
			String str = java.net.URLDecoder.decode(
					StringUtil.bufferString(bu), "utf-8");
			// json转换得到数据
			if (StringUtils.isNotBlank(str)) {
				String sendInfo = JSONObject.parseObject(str).getString(
						"sendInfo");
				NoticeSendInfo mailSenderInfo = JSONObject.parseObject(
						sendInfo, NoticeSendInfo.class);
				// 塞入数据
				noticeContent = mailSenderInfo.getNoticeContent();
				noticeTitle = mailSenderInfo.getNoticeTitle();
				level = mailSenderInfo.getNoticeLevel();
				isPariseComment = mailSenderInfo.getIsPariseComment();
				userName = mailSenderInfo.getUserName();
				String[] filesParam = mailSenderInfo.getFiles();
				if (null != filesParam) {
					for (String filePaths : filesParam) {
						String imgName = JSONObject.parseObject(filePaths)
								.getString("imgName");
						String imgCode = JSONObject.parseObject(filePaths)
								.getString("imgCode");
						if (null != imgName && null != imgCode) {
							String fileName = getFileName(imgName);
							OutputStream out = null;
							byte[] buffer = new BASE64Decoder()
									.decodeBuffer(imgCode.replaceAll(
											"(?s)'.*'", "")
											.replaceAll(" ", "+"));
							out = new FileOutputStream(new File(filePath,
									fileName));
							out.write(buffer);
							fileNameList.append(fileName);
							fileNameList.append("@AS@P");
						}
					}
				}
				sendUserId = mailSenderInfo.getSendUserID();
				reciverUser = mailSenderInfo.getReciverUserId();
				for (String reuserID : reciverUser) {
					JSONObject jsonObj = JSONObject.parseObject(reuserID);
					String empCode = jsonObj.getString("empCode");
					String empName = jsonObj.getString("empName");
					String orgName = jsonObj.getString("orgName");
					String groupName = jsonObj.getString("groupName");
					String orgId = jsonObj.getString("orgId");
					String typeChecked = jsonObj.getString("typeChecked");
					String groupId = jsonObj.getString("groupId");
					String memberType = jsonObj.getString("memberType");
					String memberCode = jsonObj.getString("memberCode");
					String memberName = jsonObj.getString("memberName");
					// 选择的是人员，直接取工号
					if (typeChecked.equalsIgnoreCase("per")) {
						reciverUserId.add(empCode);
						reciverName.add(empName);
						reciverObjects.add("per:" + empCode);
						// 选择的是部门，根据组织id获取所有员工工号
					} else if (typeChecked.equalsIgnoreCase("org")) {
						List<EmployeeVO> employeeVO = searchService
								.getEmpByOrgId(orgId);
						reciverName.add(orgName);
						reciverObjects.add("org:" + orgId);
						if (null != employeeVO && employeeVO.size() > 0) {
							for (EmployeeVO emp : employeeVO) {
								reciverUserId.add(emp.getEmpCode());
							}
						}
						// 选择的是群组里面的部门
					} else if (typeChecked.equalsIgnoreCase("group")
							&& StringUtils.isNotBlank(memberType)) {
						getEmp(memberType, memberCode, memberName,
								reciverUserId);
						reciverName.add(groupName);
						reciverObjects.add("group:" + groupId);
						// 选择的是群组的所有人
					} else if (typeChecked.equalsIgnoreCase("group")
							&& StringUtils.isBlank(memberType)) {
						List<NoticeGroupEntity> groupMemberList = noticeGroupService
								.getGroupMember(groupId);
						reciverName.add(groupName);
						reciverObjects.add("group:" + groupId);
						if (null != groupMemberList
								&& groupMemberList.size() > 0) {
							for (NoticeGroupEntity noticeGroup : groupMemberList) {
								getEmp(noticeGroup.getMemberType(),
										noticeGroup.getMemberCode(),
										noticeGroup.getMemberName(),
										reciverUserId);
							}
						}
					}
				}
			}
			// 去除重复工号
			List<String> listTemp = new ArrayList<String>();
			Set<String> tmSet = new HashSet<String>();
			for (String string : reciverUserId) {
				if (string.equalsIgnoreCase(sendUserId)) {
					sendUser = string;
					continue;
				}
				tmSet.add(string);
			}
			for (String tmp : tmSet) {
				listTemp.add(tmp);
			}
			// 推送消息工号集合

			String userIds = getStringBuffer(listTemp);
			// 接收对象的集合
			StringBuffer sb = new StringBuffer();
			for (String reciveUserDetails : reciverUser) {
				sb.append(reciveUserDetails);
				sb.append("@AP");
			}
			String reciveUserDetail = sb.toString().replaceAll("@AP$", "");
			// 接收对象的总人数
			int receiveSize = listTemp.size();
			// 接收对象的名称
			String recivNames = getStringBuffer(reciverName);
			// 封装接收对象的标识
			String reciverObject = getStringBuffer(reciverObjects);
			// 封装附件图片路径
			String attactFile = fileNameList.toString()
					.replaceAll("@AS@P$", "");

			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			if (null != sendUser) {
				if (sendUser.equalsIgnoreCase(sendUserId)) {
					result.setErrorMessage("公文发布成功，但您不能收到此公文");
				}
			} else {
				result.setErrorMessage("公文发布成功!");
			}
			writeToPage(result);
			// 设置消息推送的参数
			entity.setUserIds(userIds);
			entity.setAlert(noticeTitle);
			entity.setContent(noticeContent);
			entity.setIntoMC(false);
			entity.setIsEcc(false);
			// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
			entity.setLinktype(2);
			entity.setLinkaddr("app_package/ANPS/index.html");
			// 根据工号进行推送
			pushByUserIds(entity);
			// 插入发件表 收件表
			count = noticeMessageService.saveNoticeMessageDetail(noticeTitle,
					level, sendUserId, recivNames, attactFile, noticeContent,
					listTemp, isPariseComment, userName, reciverObject,
					receiveSize, reciveUserDetail);
		} catch (Exception e) {
			log.error("提交公文发生错误 {}", e);
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
			writeToPage(result);
			return;
		}
	}*/

	/**
	 * 获取附件名
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFileName(String fileName) {
		StringBuilder sb = new StringBuilder();
		// 文件名用UUID防止重复
		sb.append(UUID.randomUUID().toString());
		// 拼接后缀名，如果存在的话
		if (fileName.indexOf(".") != -1) {
			// 拼接
			sb.append(fileName.substring(fileName.lastIndexOf(".")));
		}
		return sb.toString();
	}

	// 获取群组所有员工组织岗位的工号
	public void getEmp(String memberType, String memberCode, String memberName,
			List<String> reciverUserId) {
		// 群组人员
		if (memberType.equals("0")) {
			reciverUserId.add(memberCode);
			// 群组组织
		} else if (memberType.equals("1")) {
			List<EmployeeVO> employeeVO = searchService
					.getEmpByOrgId(memberCode);
			if (null != employeeVO && employeeVO.size() > 0) {
				for (EmployeeVO emp : employeeVO) {
					reciverUserId.add(emp.getEmpCode());
				}
			}
			// 群组岗位
		} else if (memberType.equals("2")) {
			List<EmployeeVO> empByJobName = receiveService.getJobEmp(
					memberCode, memberName);
			if (null != empByJobName && empByJobName.size() > 0) {
				for (EmployeeVO employeeVO : empByJobName) {
					reciverUserId.add(employeeVO.getEmpCode());
				}
			}
		}
	}

	/**
	 * 根据工号推送
	 */
	public Boolean pushByUserIds(JPushParam entity) {
		try {
			// 推送
			jPushNewService.pushByUserIds(entity);
			return true;
			// writeToPage("success");
		} catch (Exception e) {
			log.error("根据工号推送失败!!! " + entity.toString(), e);
			return false;
		}
	}
	
	/**
	 * 根据工号推送
	 */
	@CookieNotCheckedRequired
	public void pushByUserIdsWithNoStop(){
		BufferedReader bu;
		try {
			
			bu = ServletActionContext.getRequest().getReader();
			// 编码转换
			String str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			// json转换得到数据
			//{	"userIds": "276344",	"alert": "111",	"content": "0",	"intoMC": "0",	"isEcc": "0"}
			// 链接类型 0：无链接  1：外部链接  2：内部链接 3:消息反馈 4:意见反馈 5：Pda 6：智慧收派
			 
			if (StringUtils.isNotBlank(str)) {
				JSONObject sendInfo = JSONObject.parseObject(str);
				jpushParam.setUserIds(sendInfo.getString("userIds").replaceAll(",$", ""));
				jpushParam.setLinkaddr(sendInfo.getString("linkAddr"));
				jpushParam.setAlert(sendInfo.getString("alert"));
				jpushParam.setLinktype(Integer.parseInt(sendInfo.getString("linktype")));
				String extras = sendInfo.getString("extras");
				@SuppressWarnings("unchecked")
				Map<String,String> extrasMap = (Map<String, String>) JSONObject.parse(extras);
				
				jpushParam.setExtras(extrasMap);
			}
			// 推送
			jPushNewService.pushByUserIds(jpushParam);	
			// 保存推送记录到消息中心
			jpushParam.setPushConditionValue(jpushParam.getUserIds());
			jPushNewService.saveToMsgCentre(jpushParam, 0);
			writeToPage("success");
		} catch (Exception e) {
			log.error("根据工号推送失败!!! " + jpushParam.toString(),e);
		}
		writeToPage("error");
	}
	
	/**
	 * 根据工号推送低版本用户更新信息
	 */
	@CookieNotCheckedRequired
	public void pushByUserIdsWithNoStop4LowVersion(){
		this.solveCrossDomain();
		JPushParam entity = new JPushParam();
		//StringBuilder userIds = new StringBuilder();
		HashSet<String> hashSet = new HashSet<String>();
		try{
			List<String> list = noticeMessageService.getUserIdsByLowVersion();
				
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
					sb.append(",");
				}
				String string = sb.toString();
			
			//String userIdsTemp = string.replaceAll(",$", "");
			String userIdsTemp = "129255";
			entity.setUserIds(userIdsTemp);
			//entity.setAlert("各位同事好,移动办公修改密码的功能已经关闭,如需修改密码请到OA进行修改密码.");
			entity.setAlert("同事你好，如果出现移动办公登录报'网络不给力,请检查网络',重新扫描OA重新下载.");
			entity.setContent("");
			entity.setIntoMC(false);
			entity.setIsEcc(false);
			// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
			entity.setLinktype(0);
			// entity.setLinkaddr("app_package/ANPS/index.html");
			jPushNewService.pushByUserIds(entity);
		} catch(Exception e){
			LOG.error("根据工号推送失败!!! " + entity.toString(),e);
		}
		writeToPage("error");
	}
	

	/**
	 * 查询公告信息详情
	 */
	//@CookieNotCheckedRequired
	public void selectNoticeMessageDetailById() {
		this.solveCrossDomain();
		// 前端输出
		Result<Object> result = new Result<Object>();
		if (StringUtils.isBlank(userId)) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入搜索参数错误：" + userId);
			writeToPage(result);
			return;
		}
		if (noticeId == 0) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入搜索参数错误：" + noticeId);
			writeToPage(result);
			return;
		}
		if (state == 0) {
			noticeMessageService.updateIsRead(userId, noticeId, 1);
		}
		noticeMessageDetail = noticeMessageService
				.selectNoticeMessageDetailById(noticeId);
		// 获取当前员工是否点赞
		Integer isParise = noticeMessageService.getIsPariseStatus(userId,
				noticeId);
		if (log.isDebugEnabled()) {
			log.debug("分页查询数据,noticeMessageDetail = {}", noticeMessageDetail);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		map.put("noticeMessageDetail", noticeMessageDetail);
		map.put("isParise", isParise);
		result.setData(map);
		writeToPage(result);
	}

	/**
	 * 保存公文评论
	 */
	//@CookieNotCheckedRequired
	/*public void saveNoticeMessageComment() {
		// 接收参数
		BufferedReader bu;
		try {
			bu = ServletActionContext.getRequest().getReader();
			String bufferString = StringUtil.bufferString(bu);
			// json转换得到数据
			if (StringUtils.isNotBlank(bufferString)) {
				NoticeComment noticeComments = JSONObject.parseObject(
						bufferString, NoticeComment.class);
				Integer lc = noticeMessageService.saveNoticeMessageComment(
						noticeComments.getCommentEmployId(),
						noticeComments.getNoticeId(),
						noticeComments.getConTent(),
						noticeComments.getToCommentEmployId(),
						noticeComments.getCommentType());
				// 前端输出
				Result<Object> result = new Result<Object>();
				if (lc != 1) {
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					result.setErrorMessage(Constants.ACTIVE_NO);
				}
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage(Constants.ACTIVE_YES);
				writeToPage(result);
			}
		} catch (IOException e) {
			log.error("保存公文评论!!!+{} ", e);
		}
	}*/

	/**
	 * 分页展示公告列表(默认未读信息)
	 */
	//@CookieNotCheckedRequired
	public void getNoticeMessageList() {
		// 前端输出
		Result<Object> result = new Result<Object>();
		if (StringUtils.isBlank(userId) || currentPage == 0) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入参数错误：" + userId + "currentPage不能传0");
			writeToPage(result);
			return;
		}
		// 获取所有的已发布公文
		List<NoticeMessageDetail> noticList = noticeMessageService
				.getNoticeMessageDetail();
		OrganizationEntity org = searchService.getOrgByEmpCode(userId);
		String deptSeq = org.getDeptSeq();
		if (null != noticList && noticList.size() > 0) {
			for (NoticeMessageDetail noticeMessage : noticList) {
				if (null != noticeMessage.getReciverObject()) {
					Boolean bol = isInReceiverObject(noticeMessage, deptSeq);
					if (bol) {
						List<NoticeMessage> noticeReceList = noticeMessageService
								.getReceiveMessage(userId,
										noticeMessage.getId());
						if (userId.equalsIgnoreCase(noticeMessageService
								.selectNoticeMessageDetailById(
										noticeMessage.getId()).getSendUserId())) {
							continue;
						}
						if ( null == noticeReceList
								|| noticeReceList.size() == 0) {
							noticeMessageService
									.saveNoticeReciveMessage(userId,
											noticeMessage.getId());
						}
					}
				}
			}
		}
		// 通过员工号判断是否有发布权限
		Boolean facatity = isFacatity(userId);
		// 分页获得公告信息列表
		noticeMessageList = noticeMessageService.getNoticMessage(userId,
				isRead, getStartNo(), pageSize);
		if (log.isDebugEnabled()) {
			log.debug("分页查询数据,noticeMessageList = {}", noticeMessageList);
		}
		// 获得公告信息个数
		int noticeMessageListCount = noticeMessageService.getNoticMessageCount(
				userId, isRead);
		// 获得总页数
		totalPage = getTotalPage(noticeMessageListCount);
		// 存入map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("noticeMessageList", noticeMessageList);
		map.put("noticeMessageListCount", noticeMessageListCount);
		map.put("totalPage", totalPage);
		map.put("facatity", facatity);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(map);
		writeToPage(result);
	}

	// 是否在接收对象里面
	public Boolean isInReceiverObject(NoticeMessageDetail noticeMessage,
			String deptSeq) {
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
				if (deptSeq.contains(reciverObject.replace("org:", ""))) {
					flag = true;
					break;
				}
			}
				// 接收对象为群组
			else if (reciverObject.contains("group")) {
				List<NoticeGroupEntity> groupMemberList = noticeGroupService
						.getGroupMember(reciverObject.replace("group:", ""));
				if (null != groupMemberList && groupMemberList.size() > 0) {
				   flag=isInGroup(groupMemberList,deptSeq);
				}
			}
		}
		return flag;
	}
    //判断接收对象是否在群组中
	private Boolean isInGroup(List<NoticeGroupEntity> groupMemberList , String deptSeq) {
		Boolean flag = false;
		for (NoticeGroupEntity noticeGroup : groupMemberList) {
			// 群组人员
			if (noticeGroup.getMemberType().equals("0")) {
				if (userId.equalsIgnoreCase(noticeGroup.getMemberCode())) {
					flag = true;
					break;
				}
			} else if (noticeGroup.getMemberType().equals("1")) {
				if (deptSeq.contains(noticeGroup.getMemberCode())) {
					flag = true;
					break;
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

	/**
	 * 获取发件人角色
	 */
	//@CookieNotCheckedRequired
	public void getSendRole() {
		Result<Object> result = new Result<Object>();
		List<String> arrayList = new ArrayList<String>();
		// 获取发件人角色
		List<NoticeAuthorty> authorty = noticeMessageService
				.getNoticeAuthorty(userId);
		if (null != authorty && authorty.size() > 0) {
			for (NoticeAuthorty noticeAuthorty : authorty) {
				int sendType = noticeAuthorty.getNoticeSendType();
				if (sendType == 0) {
					EmployeeVO emp = searchService.getEmpByEmpCode(userId);
					arrayList.add(emp.getEmpName());
				} else if (sendType == 1) {
					OrganizationEntity org = searchService
							.getOrgByEmpCode(userId);
					arrayList.add(org.getOrgName());
				}
			}
		}
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(arrayList);
		writeToPage(result);
	}

	/**
	 * 判断是否有权限
	 * 
	 * @param userId2
	 */

	private Boolean isFacatity(String userId) {
		List<NoticeAuthorty> authorty = noticeMessageService
				.getNoticeAuthorty(userId);
		if (authorty.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 分页展示已发布公告列表
	 */
	//@CookieNotCheckedRequired
	public void getPublicNoticeMessageList() {
		// 前端传值：appId(详情表的主键), currentPage
		// 前端输出
		Result<Object> result = new Result<Object>();
		if (StringUtils.isBlank(userId)) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入搜索参数错误：" + userId
					+ "currentPage不能传0,必须大于0");
			writeToPage(result);
			return;
		}
		OrganizationEntity org = searchService.getOrgByEmpCode(userId);
		// 分页获得公告信息列表
		noticeMessageList = noticeMessageService.getPublicNoticMessage(userId,
				getStartNo(), pageSize);
		if (log.isDebugEnabled()) {
			log.debug("分页查询数据,noticeMessageList = {}", noticeMessageList);
		}
		// 获得公告信息个数
		int noticeMessageListCount = noticeMessageService
				.getPublicNoticMessageCount(userId);

		// 获得总页数
		totalPage = getTotalPage(noticeMessageListCount);
		// 存入map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("noticeMessageList", noticeMessageList);
		map.put("noticeMessageListCount", noticeMessageListCount);
		map.put("totalPage", totalPage);
		map.put("org", org);
		// 传入前端
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(map);
		writeToPage(result);
	}

	/**
	 * 查询今天所有的发布的公文
	 */
	//@CookieNotCheckedRequired
	public void getTodayPublicNoticMessageList() {
		// 前端传值：appId(详情表的主键), currentPage
		// 前端输出
		Result<Object> result = new Result<Object>();

		// 分页获得公告信息列表
		noticeMessageList = noticeMessageService.getTodayPublicNoticMessage();

		// 获得公告信息个数
		int noticeMessageListCount = noticeMessageService
				.getTodayPublicNoticMessageCount();

		// 存入map
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("noticeMessageList", noticeMessageList);
		map.put("noticeMessageListCount", noticeMessageListCount);

		// 传入前端
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(map);
		writeToPage(result);
	}

	/**
	 * 更新点赞次数
	 * 
	 * @param noticeMessageId
	 */
	//@CookieNotCheckedRequired
	public void updateIsParse() {

		Result<Object> result = new Result<Object>();
		int count = noticeMessageService.updateIsParse(noticeId, userId,
				isParise);
		// 传入前duan
		if (count != 1) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);

		writeToPage(result);
	}

	/**
	 * 删除已读消息列表
	 * 
	 * @param noticeMessageId
	 */
	//@CookieNotCheckedRequired
	public void deletIsReadMessage() {

		Result<Object> result = new Result<Object>();
		int count = noticeMessageService.deletIsReadMessage(noticeId, userId);
		// 传入前duan
		if (count != 1) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);

		writeToPage(result);
	}

	/**
	 * 获取阅读情况统计
	 * 
	 * @param noticeMessageId
	 */
	//@CookieNotCheckedRequired
	public void getReadSolutingList() {

		Result<Object> result = new Result<Object>();
		List<ReadSolution> list = noticeMessageService
				.getReadSoluting(noticeId);

		// 传入前段
		result.setData(list);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		writeToPage(result);
	}

	/**
	 * 获取下级组织阅读情况统计
	 * 
	 * @param noticeMessageId
	 */
	//@CookieNotCheckedRequired
	public void getSecondReadSolutingList() {

		Result<Object> result = new Result<Object>();
		List<ReadSolution> list = noticeMessageService.getSecondReadSoluting(
				noticeId, orgId);

		// 传入前段
		if (null != list && list.size() > 0) {
			result.setData(list);
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			writeToPage(result);
		} else {
			result.setErrorMessage("没有下级组织了");
			writeToPage(result);

		}
	}

	/**
	 * 该条公告人员读取详情
	 */
	//@CookieNotCheckedRequired
	/*public void getNoticeMessageReadDetail() {
		// 前端输出
		//long start = System.currentTimeMillis();

		List<ReadPeopleDetail> readDetailList = new ArrayList<ReadPeopleDetail>();
		List<ReadPeopleDetail> readDetailLists = new ArrayList<ReadPeopleDetail>();
		List<ReadPeopleDetail> readDetail = new ArrayList<ReadPeopleDetail>();
		List<String> reciverUserId = new ArrayList<String>();
		List<String> newReciverUserId = new ArrayList<String>();
		List<String> reciverNewUserIds = new ArrayList<String>();
		int readDetailListCount = 0;
		Result<Object> result = new Result<Object>();
		if (currentPage == 0) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入搜索参数错误：currentPage不能传0");
			writeToPage(result);
			return;
		}

		if (isRead == 1) {
			readDetailList = noticeMessageService.getNoticeMessageReadDetail(
					isRead, noticeId, getStartNoRead(), pageSizeRead);
			readDetailListCount = noticeMessageService
					.getNoticeMessageReadDetailCount(isRead, noticeId);

			// 获得总页数
			totalPage = getTotalPage(readDetailListCount);
			// 存入map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("readDetailList", readDetailList);
			map.put("readDetailListCount", readDetailListCount);
			// map.put("noReadUserId", noReadUserId);
			map.put("totalPage", totalPage);
			// 传入前端
			// Result<Map<Object, Object>> result = new Result<Map<Object,
			// Object>>();
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			result.setData(map);
			writeToPage(result);

		} else {
			noticeMessageDetail = noticeMessageService
					.selectNoticeMessageDetailById(noticeId);

			readDetailListCount = noticeMessageService
					.getNoticeMessageReadDetailCount(1, noticeId);
			String[] reciverUser = noticeMessageDetail.getReciveUserDetail()
					.split("@AP");

			List<String> reciverEmpCode = getReciveEmpCode(reciverUserId,
					reciverUser);
			String sendUserId = noticeMessageService
					.selectNoticeMessageDetailById(noticeId).getSendUserId();

			Set<String> tmSet = new HashSet<String>();
			for (String string : reciverEmpCode) {

				if (string.equalsIgnoreCase(sendUserId)) {
					continue;
				}
				tmSet.add(string);

			}

			for (String tmp : tmSet) {
				newReciverUserId.add(tmp);
			}

			// 获取已读人员详情
			readDetailLists = noticeMessageService.getNoticeMessageReadDetail(
					1, noticeId, 0, 0);

			// 过滤已读人员
			for (String user : newReciverUserId) {

				for (ReadPeopleDetail readPeople : readDetailLists) {
					if (user.equals(readPeople.getReciveUserId())) {
						reciverNewUserIds.add(user);
					}
				}
			}
			newReciverUserId.removeAll(reciverNewUserIds);

			int startNo = (currentPage - 1) * pageSizeRead;
			int length = startNo + pageSizeRead;
			if (newReciverUserId.size() < pageSizeRead) {
				length = newReciverUserId.size();
			}
			long end = System.currentTimeMillis();
			float excTime = (float) (end - start) / 1000;
			System.out.println("执行时间：" + excTime + "s");

			for (int i = startNo; i < length; i++) {
				// ReadPeopleDetail readPeopleDetail = new ReadPeopleDetail();
				ReadPeopleDetail readPeopleDetail = noticeMessageService
						.getReadPeopleDetail(newReciverUserId.get(i));

				StringBuffer sb = new StringBuffer();
				sb.append(webUrl + "/" + "dpmfile" + "/");
				sb.append("headPhoto/");
				// 获取文件名
				String path = (String) readPeopleDetail.getHeadPath();
				if (null != path && !path.equals("")) {
					// 拼接文件名
					path = sb.append(path).toString();

				} else {
					path = "";
				}

				readPeopleDetail.setHeadPath(path);
				readDetail.add(readPeopleDetail);
			}

			// 获得总页数
			totalPage = getTotalPage(newReciverUserId.size());
			// 存入map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("readDetailList", readDetail);
			map.put("readDetailListCount", newReciverUserId.size());
			// map.put("noReadUserId", noReadUserId);
			map.put("totalPage", totalPage);
			// 传入前端
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			result.setData(map);

			writeToPage(result);

		}

	}*/

	/**
	 * 该条公告人员读取详情
	 */
	//@CookieNotCheckedRequired
	/*public void getNoticeMessageReadDetailAll() {
		// 前端输出

		List<ReadPeopleDetail> readDetailList = new ArrayList<ReadPeopleDetail>();
		List<ReadPeopleDetail> readDetailLists = new ArrayList<ReadPeopleDetail>();
		List<ReadPeopleDetail> readDetail = new ArrayList<ReadPeopleDetail>();
		List<String> reciverUserId = new ArrayList<String>();
		List<String> newReciverUserId = new ArrayList<String>();
		List<String> reciverNewUserIds = new ArrayList<String>();
		int readDetailListCount = 0;
		Result<Object> result = new Result<Object>();
		if (currentPage == 0) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入搜索参数错误：currentPage不能传0");
			writeToPage(result);
			return;
		}

		if (isRead == 1) {
			readDetailList = noticeMessageService.getNoticeMessageReadDetail(
					isRead, noticeId, getStartNoRead(), pageSizeRead);
			readDetailListCount = noticeMessageService
					.getNoticeMessageReadDetailCount(isRead, noticeId);

			// 获得总页数
			totalPage = getTotalPage(readDetailListCount);
			// 存入map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("readDetailList", readDetailList);
			map.put("readDetailListCount", readDetailListCount);
			// map.put("noReadUserId", noReadUserId);
			map.put("totalPage", totalPage);
			// 传入前端
			// Result<Map<Object, Object>> result = new Result<Map<Object,
			// Object>>();
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			result.setData(map);
			writeToPage(result);

		} else {
			noticeMessageDetail = noticeMessageService
					.selectNoticeMessageDetailById(noticeId);

			readDetailListCount = noticeMessageService
					.getNoticeMessageReadDetailCount(1, noticeId);
			String[] reciverUser = noticeMessageDetail.getReciveUserDetail()
					.split("@AP");

			List<String> reciverEmpCode = getReciveEmpCode(reciverUserId,
					reciverUser);

			
			String sendUserId = noticeMessageService
					.selectNoticeMessageDetailById(noticeId).getSendUserId();

			Set<String> tmSet = new HashSet<String>();

			for (String string : reciverEmpCode) {

				if (string.equalsIgnoreCase(sendUserId)) {
					continue;
				}
				tmSet.add(string);
			}
			for (String tmp : tmSet) {
				newReciverUserId.add(tmp);
			}

			// 获取已读人员详情
			readDetailLists = noticeMessageService.getNoticeMessageReadDetail(
					1, noticeId, 0, 0);

			// 过滤已读人员
			for (String user : newReciverUserId) {

				for (ReadPeopleDetail readPeople : readDetailLists) {
					if (user.equals(readPeople.getReciveUserId())) {
						reciverNewUserIds.add(user);
					}
				}
			}
			newReciverUserId.removeAll(reciverNewUserIds);

			int startNo = (currentPage - 1) * AnpsConstants.pageSize_FIFTH;
			int length = startNo + AnpsConstants.pageSize_FIFTH;
			if (newReciverUserId.size() < AnpsConstants.pageSize_FIFTH) {
	
				length = newReciverUserId.size();
			}

			for (int i = startNo; i < length; i++) {
				// ReadPeopleDetail readPeopleDetail = new ReadPeopleDetail();
				ReadPeopleDetail readPeopleDetail = noticeMessageService
						.getReadPeopleDetail(newReciverUserId.get(i));

				int orgLevel = readPeopleDetail.getOrgLevel();
				String deptseq = readPeopleDetail.getDeptseq();
				String[] orgIdList = deptseq.split("\\.");
				String orgName = readPeopleDetail.getOrgName();

				if (orgLevel == AnpsConstants.orgLEVEL_SIX) {
					readPeopleDetail.setCommunity(orgName);
					readPeopleDetail.setRegion(searchService
							.getEmpDetailByOrgId(orgIdList[AnpsConstants.FIVE]).getOrgName());
					readPeopleDetail.setDivision(searchService
							.getEmpDetailByOrgId(orgIdList[AnpsConstants.FOUR]).getOrgName());
				} else if (orgLevel == AnpsConstants.orgLEVEL_FIVE) {
					readPeopleDetail.setRegion(orgName);
					readPeopleDetail.setDivision(searchService
							.getEmpDetailByOrgId(orgIdList[AnpsConstants.FOUR]).getOrgName());
				} else if (orgLevel == AnpsConstants.orgLEVEL_FOUR) {
					readPeopleDetail.setDivision(orgName);
				} else {
					readPeopleDetail.setCommunity(searchService
							.getEmpDetailByOrgId(orgIdList[AnpsConstants.FIVE]).getOrgName());
					readPeopleDetail.setRegion(searchService
							.getEmpDetailByOrgId(orgIdList[AnpsConstants.FIVE]).getOrgName());
					readPeopleDetail.setDivision(searchService
							.getEmpDetailByOrgId(orgIdList[AnpsConstants.FOUR]).getOrgName());

				}

				StringBuffer sb = new StringBuffer();
				sb.append(webUrl + "/" + "dpmfile" + "/");
				sb.append("headPhoto/");
				// 获取文件名
				String path = (String) readPeopleDetail.getHeadPath();
				if (null != path && !path.equals("")) {
					// 拼接文件名
					path = sb.append(path).toString();
				} else {
					path = "";
				}
				readPeopleDetail.setHeadPath(path);
				readPeopleDetail.setIsRead(0);
				readDetail.add(readPeopleDetail);
			}

			// 获得总页数
			totalPage = getTotalPage(newReciverUserId.size());
			// 存入map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("readDetailList", readDetail);
			map.put("readDetailListCount", newReciverUserId.size());
			// map.put("noReadUserId", noReadUserId);
			map.put("totalPage", totalPage);
			// 传入前端
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			result.setData(map);
			writeToPage(result);

		}

	}
*/
	/**
	 * 提醒未读人员点击消息
	 * 
	 * @param count
	 * @return
	 */
	//@CookieNotCheckedRequired
	/*public void remindNoReadPeoPle() {
		// 前端输出
		List<ReadPeopleDetail> readDetailLists = new ArrayList<ReadPeopleDetail>();
		//List<ReadPeopleDetail> readDetail = new ArrayList<ReadPeopleDetail>();
		List<String> reciverUserId = new ArrayList<String>();
		List<String> newReciverUserId = new ArrayList<String>();
		List<String> reciverNewUserIds = new ArrayList<String>();

		Result<Object> result = new Result<Object>();
		noticeMessageDetail = noticeMessageService.selectNoticeMessageDetailById(noticeId);

		String[] reciverUser = noticeMessageDetail.getReciveUserDetail().split("@AP");

		List<String> reciverEmpCode = getReciveEmpCode(reciverUserId,reciverUser);
		String sendUserId = noticeMessageService.selectNoticeMessageDetailById(
				noticeId).getSendUserId();

		Set<String> tmSet = new HashSet<String>();
		for (String string : reciverEmpCode) {

			if (string.equalsIgnoreCase(sendUserId)) {
				continue;
			}
			tmSet.add(string);

		}

		for (String tmp : tmSet) {
			newReciverUserId.add(tmp);
		}

		// 获取已读人员详情
		readDetailLists = noticeMessageService.getNoticeMessageReadDetail(1,
				noticeId, 0, 0);

		// 过滤已读人员
		for (String user : newReciverUserId) {

			for (ReadPeopleDetail readPeople : readDetailLists) {
				if (user.equals(readPeople.getReciveUserId())) {
					reciverNewUserIds.add(user);
				}
			}
		}
		newReciverUserId.removeAll(reciverNewUserIds);

		// 消息发送实体
		StringBuffer sb = new StringBuffer();
		
			for (String noReadUser : newReciverUserId) {

				sb.append(noReadUser);
				sb.append(",");

			}

		
		String noReadUserId = sb.toString().replaceAll(",$", "");
		JPushParam entity = new JPushParam();

		// 设置消息推送的参数
		entity.setUserIds(noReadUserId);
		entity.setAlert("您有未读的公文消息，请阅读");
		entity.setContent("");
		entity.setIntoMC(false);
		entity.setIsEcc(false);
		// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
		entity.setLinktype(2);
		entity.setLinkaddr("app_package/ANPS/index.html");
		// 根据工号进行推送
		Boolean bol = pushByUserIds(entity);

		if (bol) {
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
		} else {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);

		}
		writeToPage(result);

	}*/

	/**
	 * 处理接收对象
	 * 
	 * @param reciverUserId
	 * @param reciverUser
	 * @return
	 */
	/*public List<String> getReciveEmpCode(List<String> reciverUserId,
			String[] reciverUser) {
		for (String reuserID : reciverUser) {
			JSONObject jsonObj = JSONObject.parseObject(reuserID);

			String empCode = jsonObj.getString("empCode");			
			String orgId = jsonObj.getString("orgId");
			String typeChecked = jsonObj.getString("typeChecked");
			String groupId = jsonObj.getString("groupId");
			String memberType = jsonObj.getString("memberType");
			String memberCode = jsonObj.getString("memberCode");
			String memberName = jsonObj.getString("memberName");
			// 选择的是人员，直接取工号
			if (typeChecked.equalsIgnoreCase("per")) {
				reciverUserId.add(empCode);
				// 选择的是部门，根据组织id获取所有员工工号
			} else if (typeChecked.equalsIgnoreCase("org")) {
				List<EmployeeVO> employeeVO = searchService
						.getEmpByOrgId(orgId);
				if (null != employeeVO && employeeVO.size() > 0) {
					for (EmployeeVO emp : employeeVO) {
						reciverUserId.add(emp.getEmpCode());
					}
				}
				// 选择的是群组里面的部门
			} else if (typeChecked.equalsIgnoreCase("group")
					&& StringUtils.isNotBlank(memberType)) {
				getEmp(memberType, memberCode, memberName, reciverUserId);
				// 选择的是群组的所有人
			} else if (typeChecked.equalsIgnoreCase("group")
					&& StringUtils.isBlank(memberType)) {
				List<NoticeGroupEntity> groupMemberList = noticeGroupService
						.getGroupMember(groupId);
				if (null != groupMemberList && groupMemberList.size() > 0) {
					for (NoticeGroupEntity noticeGroup : groupMemberList) {
						getEmp(noticeGroup.getMemberType(),
								noticeGroup.getMemberCode(),
								noticeGroup.getMemberName(), reciverUserId);
					}
				}
			}
		}

		return reciverUserId;

	}*/

	public String getStringBuffer(List<String> list) {
		// 推送消息工号集合
		StringBuffer stringBuffer = new StringBuffer();
		for (String revicerUser : list) {
			stringBuffer.append(revicerUser);
			stringBuffer.append(",");
		}
		String userIds = stringBuffer.toString().replaceAll(",$", "");
		return userIds;
	}

	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public int getTotalPage(int count) {
		// 总页数
		if (count % pageSize == 0) {
			totalPage = count % pageSize;
		} else {
			totalPage = count / pageSize + 1;
		}
		return totalPage;
	}

	public void getNoticeReceiveDetail() {
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartNo() {
		// 起始评论编号
		startNo = (currentPage - 1) * pageSize;
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getStartNoRead() {
		// 起始评论编号
		startNoRead = (currentPage - 1) * pageSizeRead;
		return startNoRead;
	}

	public void setStartNoRead(int startNoRead) {
		this.startNoRead = startNoRead;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public NoticeMessageDetail getNoticeMessageDetail() {
		return noticeMessageDetail;
	}

	public void setNoticeMessageDetail(NoticeMessageDetail noticeMessageDetail) {
		this.noticeMessageDetail = noticeMessageDetail;
	}

	public NoticeMessage getNoticeMessage() {
		return noticeMessage;
	}

	public void setNoticeMessage(NoticeMessage noticeMessage) {
		this.noticeMessage = noticeMessage;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public INoticeMessageService getNoticeMessageService() {
		return noticeMessageService;
	}

	public void setNoticeMessageService(
			INoticeMessageService noticeMessageService) {
		this.noticeMessageService = noticeMessageService;
	}

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}
	
	public static int getPagesize10() {
		return PAGESIZE_10;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public String getNoticeComment() {
		return noticeComment;
	}

	public void setNoticeComment(String noticeComment) {
		this.noticeComment = noticeComment;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPageSizeRead() {
		return pageSizeRead;
	}

	public void setPageSizeRead(int pageSizeRead) {
		this.pageSizeRead = pageSizeRead;
	}

	public INoticeSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(INoticeSearchService searchService) {
		this.searchService = searchService;
	}

	public INoticeGroupService getNoticeGroupService() {
		return noticeGroupService;
	}

	public void setNoticeGroupService(INoticeGroupService noticeGroupService) {
		this.noticeGroupService = noticeGroupService;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		NoticeMessageAction.filePath = filePath;
	}

	public IReceiveObjectService getReceiveService() {
		return receiveService;
	}

	public void setReceiveService(IReceiveObjectService receiveService) {
		this.receiveService = receiveService;
	}

	public int getIsParise() {
		return isParise;
	}

	public void setIsParise(int isParise) {
		this.isParise = isParise;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public JPushParam getJpushParam() {
		return jpushParam;
	}

	public void setJpushParam(JPushParam jpushParam) {
		this.jpushParam = jpushParam;
	}

	
	
}
