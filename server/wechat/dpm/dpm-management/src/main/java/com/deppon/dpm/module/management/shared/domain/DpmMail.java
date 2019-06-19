package com.deppon.dpm.module.management.shared.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.ServiceLocalException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * @author ccf
 * DpmMail 实体类
 *
 */
public class DpmMail {

	/**
	 * 邮箱唯一id（主键）
	 */
	private String emailId;

	/**
	 * 发件人
	 */
	private String sender;

	/**
	 * 收件人
	 */
	private String receiver;

	/**
	 * 抄送
	 */
	private String cc;

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 收件时间
	 */
	private String receiveTime;

	/**
	 * 收件内容
	 */
	private String content;

	/**
	 * 是否阅读
	 */
	private boolean isRead;

	/**
	 * 是否有附件
	 */
	private boolean hasAttachments;

	/**
	 * 附件
	 */
	private List<String> attachments = new ArrayList<String>();

	/**
	 * @return 邮箱唯一id（主键）
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId 邮箱唯一id（主键）
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return 发件人
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender 发件人
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * getter
	 * @return
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * setter
	 * @param receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * getter
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * setter
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * getter
	 * @return
	 */
	public String getReceiveTime() {
		return receiveTime;
	}

	/**
	 * setter
	 * @param receiveTime
	 */
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * getter
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * setter
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * getter
	 * @return
	 */
	public boolean isRead() {
		return isRead;
	}

	/**
	 * setter
	 * @param isRead
	 */
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	/**
	 * getter
	 * @return
	 */
	public boolean isHasAttachments() {
		return hasAttachments;
	}

	/**
	 * setter
	 * @param hasAttachments
	 */
	public void setHasAttachments(boolean hasAttachments) {
		this.hasAttachments = hasAttachments;
	}

	/**
	 * getter
	 * @return
	 */
	public List<String> getAttachments() {
		return attachments;
	}

	/**
	 * setter
	 * @param attachments
	 */
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}

	/**
	 * getter
	 * @return
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * setter
	 * @param cc
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * @param message 信息
	 * @throws ServiceLocalException 抛出异常
	 */
	public DpmMail(EmailMessage message) throws ServiceLocalException {
		//得到emailId
		this.emailId = message.getId().getUniqueId();
		//得到发件人
		this.sender = message.getSender().getName();
		String displayTo = message.getDisplayTo();
		//判断字符是否为null
		if (StringUtils.isNotEmpty(displayTo)) {
			//三目运算符判断
			this.receiver = displayTo.replace("; ???", "").replace("; ??", "");
		} else {
			this.receiver = null;
		}
		//主题
		this.subject = message.getSubject();
		//是否阅读
		this.isRead = message.getIsRead();
		//收件内容
		this.content = message.getBody().toString();
		String displayCc = message.getDisplayCc();
		//判断字符
		if (StringUtils.isNotEmpty(displayCc)) {
			this.cc = displayCc.replace("; ???", "").replace("; ??", "");
		} else {
			this.cc = null;
		}
		//设置时间格式
		this.receiveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(DateUtils.addHours(message.getDateTimeReceived(), MagicNumber.NUM8));
		//附件
		this.hasAttachments = message.getHasAttachments();
	}

}
