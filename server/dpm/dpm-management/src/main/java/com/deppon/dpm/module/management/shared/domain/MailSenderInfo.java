package com.deppon.dpm.module.management.shared.domain;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * @date 2015-08-26
 * @author 231586 邮件实体类
 * 
 */
public class MailSenderInfo {
	// 邮件服务器地址
	private String mailServletHost;
	// 邮件服务端口
	private String mailServerPort;
	// 发件人地址
	private String fromAddress;
	// 收件人地址
	private List<String> toAddress;
	// 抄送人地址
	private List<String> toCcAddress;
	// 发件人邮箱名称
	private String userName;
	// 密码
	private String password;
	// 是否需要验证
	private boolean validate = false;
	// 主题
	private String subject;
	// 内容
	private String content;
	// 附件名称
	private String[] attachFileNames;
	// 附件
	private File file;
	//邮件id
	private String emailId;

	/**
	 * @return 返回
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", "mail.deppon.com");
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	/**
	 * @return  邮件服务器地址
	 */
	public String getMailServletHost() {
		return mailServletHost;
	}

	/**
	 * @param mailServletHost  邮件服务器地址
	 */ 
	public void setMailServletHost(String mailServletHost) {
		this.mailServletHost = mailServletHost;
	}

	/**
	 * @return 邮件服务端口
	 */
	public String getMailServerPort() {
		return mailServerPort;
	}

	/**
	 * @param mailServerPort 邮件服务端口
	 */
	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	/**
	 * @return 发件人地址
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * @param fromAddress 发件人地址
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	/**
	 * @return 收件人地址
	 */
	public List<String> getToAddress() {
		return toAddress;
	}

	/**
	 * @param toAddress 收件人地址
	 */
	public void setToAddress(List<String> toAddress) {
		this.toAddress = toAddress;
	}

	/**
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 是否需要验证
	 */
	public boolean isValidate() {
		return validate;
	}

	/**
	 * @param validate 是否需要验证
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

	public List<String> getToCcAddress() {
		return toCcAddress;
	}

	public void setToCcAddress(List<String> toCcAddress) {
		this.toCcAddress = toCcAddress;
	}

	/**
	 * @return 附件
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file 附件
	 */
	public void setFile(File file) {
		this.file = file;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
