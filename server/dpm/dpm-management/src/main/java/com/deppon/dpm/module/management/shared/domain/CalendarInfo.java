package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import microsoft.exchange.webservices.data.Importance;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 日程
 * 
 * @author 245968
 * 
 */
public class CalendarInfo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1984375907328519188L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 每条约会对应的id
	 */
	private String appointmentId;
	/**
	 * 约会类型
	 */
	private String type = "";
	/**
	 * 区分 日程和会议的字段
	 */
	private String meetingType; 
	/**
	 * 发送人
	 */
	private String sendTo = "";
	/**
	 * 主题
	 */
	private String subject = "";
	/**
	 * 接收或创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date calendarDate;
	/**
	 * 发件人姓名/创建日程工号（插入数据时，用工号，返回使用姓名）
	 */
	private String sendName = "";
	/**
	 * 发件人工号
	 */
	private String sendEmpId = "";
	/**
	 * 组织邮箱
	 */
	private String orgnaizeEmail;
	/**
	 * 抄送
	 */
	private String displayCc = "";
	/**
	 * 收件人
	 */
	private String displayTo = "";
	/**
	 * 提醒时间
	 */
	private String reminderMinutesBeforeStart = "null";
	/**
	 * 起始时间-结束时间
	 */
	private String stoendDate;
	
	
	/**
	 * 起始时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date start;
	/**
	 * 结束时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date end;
	/**
	 * 地址
	 */
	private String location = "";
	/**
	 * 内容
	 */
	private String content = "";
	/**
	 * 是否是从email获得的数据<br>
	 * 0 不是 <br>
	 * 1 是
	 */
	private int isFromEmail;
	/**
	 * 接收人结果集
	 */
	private List<Receiver> receivers = new ArrayList<Receiver>();
	/**
	 * 会议响应 的结果集
	 */
	private List<ResponseMeeting> responseList = new ArrayList<ResponseMeeting>();
	
	/**
	 * 重要
	 */
	private String importance;
	
	/**
	 * 附件列表  
	 * 是否有附件HasAttachments
	 * 是否为附件IsAttachment
	 * 前端实现不了 暂时不用
	 */
//	private String attachments;
	
	/**
	 * get
	 * 
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * set
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getCalendarDate() {
		return calendarDate;
	}

	/**
	 * set
	 * 
	 * @param calendarDate
	 */
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSendName() {
		return sendName;
	}

	/**
	 * set
	 * 
	 * @param sendName
	 */
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDisplayCc() {
		return displayCc;
	}

	/**
	 * set
	 * 
	 * @param displayCc
	 */
	public void setDisplayCc(String displayCc) {
		this.displayCc = displayCc;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDisplayTo() {
		return displayTo;
	}

	/**
	 * set
	 * 
	 * @param displayTo
	 */
	public void setDisplayTo(String displayTo) {
		this.displayTo = displayTo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getReminderMinutesBeforeStart() {
		return reminderMinutesBeforeStart;
	}

	/**
	 * set
	 * 
	 * @param reminderMinutesBeforeStart
	 */
	public void setReminderMinutesBeforeStart(String reminderMinutesBeforeStart) {
		this.reminderMinutesBeforeStart = reminderMinutesBeforeStart;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * set
	 * 
	 * @param start
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * set
	 * 
	 * @param end
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * set
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * set
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * set
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getIsFromEmail() {
		return isFromEmail;
	}

	/**
	 * set
	 * 
	 * @param isFromEmail
	 */
	public void setIsFromEmail(int isFromEmail) {
		this.isFromEmail = isFromEmail;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * set
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSendTo() {
		return sendTo;
	}

	/**
	 * set
	 * 
	 * @param sendTo
	 */
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppointmentId() {
		return appointmentId;
	}

	/**
	 * set
	 * 
	 * @param appointmentId
	 */
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<Receiver> getReceivers() {
		return receivers;
	}

	/**
	 * set
	 * 
	 * @param receivers
	 */
	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrgnaizeEmail() {
		return orgnaizeEmail;
	}

	/**
	 * set
	 * 
	 * @param orgnaizeEmail
	 */
	public void setOrgnaizeEmail(String orgnaizeEmail) {
		this.orgnaizeEmail = orgnaizeEmail;
	}

	public String getStoendDate() {
		return stoendDate;
	}

	public void setStoendDate(String stoendDate) {
		this.stoendDate = stoendDate;
	}
	
	public CalendarInfo() {
		super();
		}

	public String getSendEmpId() {
		return sendEmpId;
	}

	public void setSendEmpId(String sendEmpId) {
		this.sendEmpId = sendEmpId;
	}

	public List<ResponseMeeting> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<ResponseMeeting> responseList) {
		this.responseList = responseList;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

}
