package com.deppon.dpm.module.anps.server.job;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.anps.server.service.INoticeGroupService;
import com.deppon.dpm.module.anps.server.service.INoticeMessageService;
import com.deppon.dpm.module.anps.server.service.INoticeSearchService;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.management.server.service.IEmailService;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

@SuppressWarnings("all")
public class NoticeMessageJob {

	private static final Logger LOG = LoggerFactory
			.getLogger(NoticeMessageJob.class);

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private INoticeMessageService noticeMessageService;

	private INoticeSearchService searchService;

	private INoticeGroupService noticeGroupService;

	private IReceiveObjectService receiveService;

	// private String userId;

	/**
	 * emailService 注入
	 */
	private IEmailService emailService;

	/**
	 * fasong 邮件
	 */
	public void execute() {
		LOG.info("开始发送邮件提醒..." + DATE_FORMAT.format(new Date()));
		try {
			InetAddress address = InetAddress.getLocalHost();
			// 获取主机地址
			String hostAddress = address.getHostAddress();
			System.out.println(hostAddress);
			if (hostAddress.equals("10.249.5.99")) {

				// 前端输出
				List<ReadPeopleDetail> readDetailList = new ArrayList<ReadPeopleDetail>();
				List<ReadPeopleDetail> readDetailLists = new ArrayList<ReadPeopleDetail>();
				List<ReadPeopleDetail> readDetail = new ArrayList<ReadPeopleDetail>();
				List<String> reciverUserId = new ArrayList<String>();
				List<String> newReciverUserId = new ArrayList<String>();
				List<String> reciverNewUserIds = new ArrayList<String>();
				int readDetailListCount = 0;

				File file = null;
				List<String> toSendAdd = new ArrayList<String>();
				// 获取所有公文列表
				List<NoticeMessageDetail> noticeList = noticeMessageService
						.getNoticeMessageDetail();
				MailSenderInfo info = new MailSenderInfo();

				if (null != noticeList && noticeList.size() > 0) {

					for (NoticeMessageDetail noticeMessageDetail : noticeList) {
						// 设置邮件
						if (noticeMessageDetail.getIsSend() == 0) {
							info.setContent("您有超24小时未读公文,请及时阅读查看。查看路径：移动办公平台--公文--未读公文列表"
									+ "（备注：如果没安装公文应用，请在应用商店内下载）");
							info.setSubject("您有超24小时未读公文");
							// info.setContent(noticeMessageDetail.getNoticeContent());
							// info.setSubject(noticeMessageDetail.getNoticeTitle());

							String[] reciverUser = noticeMessageDetail
									.getReciveUserDetail().split("@AP");

							List<String> reciverEmpCode = getReciveEmpCode(
									reciverUserId, reciverUser);
							String sendUserId = noticeMessageDetail
									.getSendUserId();

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
							readDetailLists = noticeMessageService
									.getNoticeMessageReadDetail(1,
											noticeMessageDetail.getId(), 0, 0);

							// 过滤已读人员
							for (String user : newReciverUserId) {

								for (ReadPeopleDetail readPeople : readDetailLists) {
									if (user.equals(readPeople
											.getReciveUserId())) {
										reciverNewUserIds.add(user);
									}
								}
							}
							newReciverUserId.removeAll(reciverNewUserIds);

							for (String noReadUser : newReciverUserId) {
								EmployeeVO emp = searchService
										.getEmpByEmpCode(noReadUser);
								toSendAdd.add(emp.getEmail());
							}
							info.setToAddress(toSendAdd);
							emailService.sendEmail(info,
									noticeMessageDetail.getSendUserId(), file);
							int result = noticeMessageService
									.updateIsSend(noticeMessageDetail.getId());

						}
					}
				}
			}
		} catch (Exception e) {
			LOG.error("发送邮件提醒出错!!!", e);
		}
		LOG.info("邮件发送成功");
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
	 * 处理接收对象
	 * 
	 * @param reciverUserId
	 * @param reciverUser
	 * @return
	 */
	public List<String> getReciveEmpCode(List<String> reciverUserId,
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

	}

	public INoticeGroupService getNoticeGroupService() {
		return noticeGroupService;
	}

	public void setNoticeGroupService(INoticeGroupService noticeGroupService) {
		this.noticeGroupService = noticeGroupService;
	}

	public IReceiveObjectService getReceiveService() {
		return receiveService;
	}

	public void setReceiveService(IReceiveObjectService receiveService) {
		this.receiveService = receiveService;
	}

	public INoticeMessageService getNoticeMessageService() {
		return noticeMessageService;
	}

	public IEmailService getEmailService() {
		return emailService;
	}

	public void setNoticeMessageService(
			INoticeMessageService noticeMessageService) {
		this.noticeMessageService = noticeMessageService;
	}

	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}

	public INoticeSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(INoticeSearchService searchService) {
		this.searchService = searchService;
	}

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();

			System.out.println(address.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}