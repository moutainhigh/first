package com.deppon.dpm.module.management.shared.domain;

import microsoft.exchange.webservices.data.MeetingResponseType;

/**
 * 封装 响应数据
 * 
 * @author 
 * 
 */
public class ResponseMeeting {
	/**
	 * 被邀请人姓名
	 */
	private String InviteeName;
	
	/**
	 * 响应状态   未响应Unknown 同意Accept 谢绝Decline
	 */
	private MeetingResponseType buttonJoin;
	
	private String emailAddress;
	/**
	 * 响应人 总数
	 */
//	private String respondents;

	

	public String getInviteeName() {
		return InviteeName;
	}

	public void setInviteeName(String inviteeName) {
		InviteeName = inviteeName;
	}

	public MeetingResponseType getButtonJoin() {
		return buttonJoin;
	}

	public void setButtonJoin(MeetingResponseType buttonJoin) {
		this.buttonJoin = buttonJoin;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ResponseMeeting(String inviteeName, MeetingResponseType buttonJoin,
			String emailAddress) {
		super();
		InviteeName = inviteeName;
		this.buttonJoin = buttonJoin;
		this.emailAddress = emailAddress;
	}

	public ResponseMeeting() {
		super();
	}
}
