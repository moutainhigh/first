package com.deppon.dpm.module.wfs.server.util.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailUtil {
	private static Logger logger  = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 发送html邮件
     * @param toEmail  邮件接收人
     * @param subject  主题
     * @param htmlContent 
     * @param host 邮件服务器 公司邮箱地址
     * @param from 邮件发送方 邮局小天使
     * @param username 邮件 用户名
     * @param password 密码
     */
    public static void sendMail(String[] toEmail, String subject,
                                String htmlContent,String host,String from,String username,String password) {

    	JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

        // 发送邮箱的邮件服务器
        senderImpl.setHost(host);

        // 建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        // 为防止乱码，添加编码集设置
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,
                "UTF-8");

        try {
            // 接收方邮箱
            messageHelper.setTo(toEmail);
            // 发送方邮箱
            messageHelper.setFrom(from);
            // 设置邮件消息的主题
            messageHelper.setSubject(subject);
            // true 表示启动HTML格式的邮件
            messageHelper.setText(htmlContent, true);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.auth", "true");
        // 超时时间
        prop.put("mail.smtp.timeout", "25000");

        // 添加验证
        MyAuthenticator auth = new MyAuthenticator(username,
                password);

        Session session = Session.getDefaultInstance(prop, auth);
        senderImpl.setSession(session);

        // senderImpl.setJavaMailProperties(prop);
        // 发送邮件
        senderImpl.send(mailMessage);
        logger.info("报错预警邮件发送成功-------"+htmlContent);

    }

    public static void main(String[] args) {
    	String[] toEmail={"gaochunling@deppon.com","biwenbing@deppon.com","fengyingchao@deppon.com"};
//        MailUtil.sendMail(toEmail, "xxx", "OOOO");
    }
}
