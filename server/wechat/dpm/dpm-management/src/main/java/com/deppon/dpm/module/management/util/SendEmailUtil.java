package com.deppon.dpm.module.management.util;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.module.management.shared.domain.MyAuthenticator;

public class SendEmailUtil {
	private SendEmailUtil() {

	}

	/**
	 * 具有DataHandler的附件 1.若文件作为附件发送建立FileDataSource类型的附件数据源对象
	 * 2.若URL作为附件发送建立URLDataSource类型的附件数据源对象
	 * 
	 * @param mailInfo
	 * @return
	 * @throws MessagingException
	 */
	public static boolean sendTextMail(MailSenderInfo mailInfo, File file)
			throws MessagingException {
		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart multipart = new MimeMultipart();
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		// 获取发送实体信息
		Properties properties = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 若需要身份验证，则创建一个密码验证器
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件回话属性和邮件验证器构建一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(properties,
				authenticator);
		// 创建一个邮件实体
		Message mailMessage = new MimeMessage(sendMailSession);
		// 定义发件人地址
		Address from = new InternetAddress(mailInfo.getFromAddress());
		mailMessage.setFrom(from);
		// 定义收件人地址，是一个String数组
		Address[] to = new Address[mailInfo.getToAddress().size()];
		for (int i = 0; i < mailInfo.getToAddress().size(); i++) {
			to[i] = new InternetAddress(mailInfo.getToAddress().get(i));
		}
		// Message.RecipientType.TO：收信人
		// Message.RecipientType.CC：抄送
		// Message.RecipientType.BCC：暗抄送
		mailMessage.setRecipients(Message.RecipientType.TO, to);
		// mailMessage.setRecipients(Message.RecipientType.CC, to);
		// 设置主题
		mailMessage.setSubject(mailInfo.getSubject());
		// 设置时间
		mailMessage.setSentDate(new Date());
		// 附件
		if (null != file) {
			// 邮件体
			BodyPart messageBodyPart = new MimeBodyPart();
			// 附件地址
			// File file = new File(mailInfo.getAttachFileNames()[0]);
			// 加载文件资源
			DataSource source = new FileDataSource(file);
			// 将加载好的文件资源放入邮件体中
			messageBodyPart.setDataHandler(new DataHandler(source));
			// 设置附件名称
			messageBodyPart.setFileName(mailInfo.getAttachFileNames()[0]);
			// 加入邮件体中
			multipart.addBodyPart(messageBodyPart);
		}
		// 设置内容,在没有附件的情况下可直接使用
		// mailMessage.setText(mailInfo.getContent());
		/*
		 * 若发送带有附件内容的邮件，需要包含两个部分，邮件内容部分和DataHandler
		 */
		BodyPart messageBodyPart2 = new MimeBodyPart();
		// 附件状态下的邮件内容设置
		messageBodyPart2.setText(mailInfo.getContent()); // 发送文本内容
		// 设置html格式的内容
		// messageBodyPart2.setContent(mailInfo.getContent(),
		// "text/html; charset=utf-8");
		messageBodyPart2.addHeader("Access-Control-Allow-Origin", "*");
		// messageBodyPart2.setDescription("描述");
		// messageBodyPart2.setDisposition("Disposition");
		multipart.addBodyPart(messageBodyPart2);
		// 设置邮件体
		mailMessage.setContent(multipart);
		Transport.send(mailMessage);
		return true;
	}

}
