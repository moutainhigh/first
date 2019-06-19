package com.deppon.dpm.module.management.server.app.test.service;

import java.io.File;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import microsoft.exchange.webservices.data.Attachment;
import microsoft.exchange.webservices.data.AttachmentCollection;
import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.FileAttachment;
import microsoft.exchange.webservices.data.FindItemsResults;
import microsoft.exchange.webservices.data.Folder;
import microsoft.exchange.webservices.data.HttpErrorException;
import microsoft.exchange.webservices.data.Item;
import microsoft.exchange.webservices.data.ItemView;
import microsoft.exchange.webservices.data.OffsetBasePoint;
import microsoft.exchange.webservices.data.PropertySet;
import microsoft.exchange.webservices.data.WebCredentials;
import microsoft.exchange.webservices.data.WellKnownFolderName;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.impl.EmailService;
import com.deppon.dpm.module.management.shared.domain.DpmMail;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.module.management.shared.exception.EmailNullPointException;
import com.deppon.dpm.module.management.shared.exception.EmailPasswordErrorException;
import com.deppon.dpm.module.management.shared.exception.EmailPasswordNullPointException;
import com.deppon.dpm.module.management.util.DES;

public class EmailServiceTest extends TestCase{
	
	protected ApplicationContext context; 
	
	private EmailService emailService;
	
	private JdbcTemplate jdbcTemplate;
	
	private String  serverHostPort = "http://10.224.196.107:8080/dpm/";
	
	private String host = "http://10.230.13.134/EWS/Exchange.asmx";
//	private String host = "http://mail.deppon.com/EWS/Exchange.asmx";
	
	
	@Override
	protected void setUp() throws Exception {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		emailService = (EmailService)context.getBean("emailService");
		jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
	}
	
	/**
	 * 通过邮箱和邮箱密码绑定exchage server
	 */
	private ExchangeService getExchangeService(String userId) throws Exception {
		String email = getEmail(userId);
		if (StringUtils.isEmpty(email)) {
			throw new EmailNullPointException(userId + "邮箱不存在");
		}

		String password = getPassword(userId);
		if (StringUtils.isEmpty(password)) {
			throw new EmailPasswordNullPointException("密码不存在");
		}

		try {
			password = new String(Base64.decodeBase64(DES.decryptDES(password)));
		} catch (Exception e) {
			throw new EmailPasswordErrorException("密码错误");
		}

		ExchangeService service = new ExchangeService(
				ExchangeVersion.Exchange2010);
		ExchangeCredentials credentials = new WebCredentials(email, password);
		service.setCredentials(credentials);
		service.setUrl(new URI(host));
		return service;
	}
	

	/**
	 * 根据工号获取邮箱地址
	 */
	private String getEmail(String userId) {
		if (StringUtils.isEmpty(userId))
			return null;
		String queryEmail = "select * from om_employee where empcode = '"
				+ userId + "'";
		String email = jdbcTemplate.query(queryEmail,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("oemail");
						}
						return null;
					}
				});
		return email;
	}

	/**
	 * 根据工号获取配置表的邮箱密码
	 * 
	 * @param userId
	 * @return
	 */
	private String getPassword(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return null;
		}

		String sql = "select * from om_email_config where user_id = '" + userId
				+ "'";
		String password = jdbcTemplate.query(sql,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("email_password");
						}
						return null;
					}
				});
		return password;
	}
	
	private List<String> getEmailIds(String userId){
		
		//获取邮件地址  /dpmfile/emailattachment/
		String path = "/dpmfile/emailattachment/";
		
		List<String> list = new ArrayList<String>();
		//返回的结果集
		final Result<Object> result = new Result<Object>();
		//封装邮件错误日志信息
		try {
			//交换机服务
			ExchangeService service = null;
			try {
				//根据用户id获取对应的交换机
				service = getExchangeService(userId);
			} catch (Exception e) {
				//交换机获取失败，将错误信息封装进结果集
				if (e instanceof EmailNullPointException) {
					result.setErrorCode(1);
					result.setData("邮箱为空");
				} else if (e instanceof EmailPasswordNullPointException) {
					result.setErrorCode(2);
					result.setData("邮箱密码为空");
				} else if (e instanceof EmailPasswordErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
			}
			Folder inbox = null;
			try {
				//收件箱
				inbox = Folder.bind(service, WellKnownFolderName.Inbox);
			} catch (Exception e) {
				//收件箱获取失败，封装错误信息
				if (e instanceof HttpErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
			}

			ItemView view = new ItemView(20, 20 * (1 - 1),
					OffsetBasePoint.Beginning);
			//分页获取邮件信息
			FindItemsResults<Item> findResults = service.findItems(
					inbox.getId(), view);

			//遍历
			for (Item item : findResults.getItems()) {
				//邮箱消息
				EmailMessage message = (EmailMessage) item;
				//加载邮件
				item.load(PropertySet.FirstClassProperties);
				//邮件实体对象
				DpmMail dpmMail = new DpmMail(message);
				
				//如果有附件
				if (message.getHasAttachments()
						|| message.getAttachments().getCount() > 0) {
					String pre = userId
							+ message.getDateTimeReceived().getTime() + "@";
					//将有附件的邮件id添加到集合中
					list.add(dpmMail.getEmailId());
					
					//获取附件
					AttachmentCollection attachments = message.getAttachments();
					//遍历所有附件
					for (Attachment attachment : attachments) {
						if (!(attachment instanceof FileAttachment))
							continue;//排除不是文件附件
						final FileAttachment fileAttachment = (FileAttachment) attachment;
						//加载附件
						fileAttachment.load();
						//附件名称
						String name = fileAttachment.getName();
						if (fileAttachment.isContactPhoto()
								|| fileAttachment.getIsInline()) {// 内嵌式图片
							String contentId = fileAttachment.getContentId();
							//处理文件名
							String fileName = null;
							if (contentId.indexOf("@") != -1) {
								String[] split = contentId.split("@");
								fileName = split[1] + "@" + split[0];
							} else {
								fileName = contentId + "@" + name;
							}
							//获取邮件内容
							String content = dpmMail.getContent();
							content = content.replaceAll("src=\"cid:"
									+ contentId, "src=\"" + serverHostPort
									+ "emailattachment/" + pre + fileName);
							dpmMail.setContent(content);
							//下载图片
							final File file = new File(path + pre + fileName);
							if (!file.exists()) {
								System.out.println(name);
								System.out.println(dpmMail.getEmailId());
							}
							}
						} 
				}
				
				
//				list.add(dpmMail.getEmailId());
//				for (String str : list) {
//					System.out.println(str);
//				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@Test
	public void testQueryList(){
		int page = 1;
		int pageSize = 20;
		String userId = "116250";
		Result<Object> list = emailService.queryList(page, pageSize, userId);
		System.out.println(list);
		
		//测试异常部分
		// 邮箱为空
		String userId2 = "039050";
		emailService.queryList(page, pageSize, userId2);
	}
	
	@Test
	public void testQueryListNew(){
		emailService.queryListNew(1, 20, "116250");
		
		emailService.queryListNew(1, 20, "039050");
	}
	
	@Test
	public void testQueryListByPage(){
		emailService.queryListByPage(1, 20, "116250");
		
		emailService.queryListByPage(1, 20, "039050");
	}
	
	@Test
	public void testSearchEmailByCondition(){
		emailService.searchEmailByCondition("116250", "subject", "单元测试", "no");
		emailService.searchEmailByCondition("116250", "subject", "单元测试", "yes");
		emailService.searchEmailByCondition("116250", "sendFrom", "祁磊", "no");
		emailService.searchEmailByCondition("116250", "sendFrom", "祁磊", "yes");
		emailService.searchEmailByCondition("116250", "all", "祁磊", "no");
		emailService.searchEmailByCondition("116250", "all", "祁磊", "yes");
		
		emailService.searchEmailByCondition("039050", "subject", "单元测试", "yes");
	}
	
	@Test
	public void testLoadEmailById(){
//		Result<Object> queryListNew = emailService.queryListNew(1, 5, "116250");
//		Object data = queryListNew.getData();
//		if(null != data){
//			List<NewDpmMail> list = (List<NewDpmMail>)data;
//			NewDpmMail newDpmMail = list.get(0);
//			if(null != newDpmMail){
//				emailService.loadEmailById("116250", newDpmMail.getEmailId());
//			}
//		}
		String emailId = "AAMkAGQ3MjhkNmRmLTg1YzUtNDkxMy04ZmNiLTE4NDdhNzJhY" +
				"TRkMwBGAAAAAABCaGg/53mzRIn2ntSn06LtBwDvZcDombXpRoVatAbiW4E0AA" +
				"AAulLgAADvZcDombXpRoVatAbiW4E0AAB71c+0AAA=";
		emailService.loadEmailById("116250", emailId);
		emailService.loadEmailById("116250", "115333313");
		emailService.loadEmailById("039050", "115333313");
	}
	
	@Test
	public void testReadAll() throws Exception{
		emailService.readAll("116250");
		emailService.readAll("039050");
	}
	
	/*@Test
	public void testDelete() throws Exception{
		String userId = "000090";
		List<String> list = getEmailIds(userId);
		String osType = "android";
		String[] emailIds = {list.get(0)};
		Result<Object> result = emailService.delete(userId, osType, emailIds);
		System.out.println(result);
	}*/

	@Test
	public void testRead() throws Exception{
		String userId1 = "000101";
		List<String> list = getEmailIds(userId1);
		if(null != list && list.size() > 0){
			String emailId1 = list.get(0);
			Result<Object> result = emailService.read(userId1, emailId1);
			System.out.println(result);
		}
		
		//测试异常部分
		String userId2 = "000155";
		String emailId2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		emailService.read(userId2, emailId2);
		
		emailService.read("039050", "1564531484513");
	}
	
	@SuppressWarnings(value = { "all" })
	@Test
	public void testDownLoad() throws Exception{
		String userId1 = "000101";
		String emailId1 = "AAMkAGQ3MjhkNmRmLTg1YzUtNDkxMy04ZmNiLTE4NDdhNz" +
				"JhYTRkMwBGAAAAAABCaGg/53mzRIn2ntSn06LtBwDvZcDombXpRoVatA" +
				"biW4E0AAAAulLgAADvZcDombXpRoVatAbiW4E0AAAvlffaAAA=";
		String attachmentName1 = "门户第11次迭代测试报告.docx";
		Result<Object> result1 = emailService.downLoad(userId1, emailId1, attachmentName1);
		System.out.println(result1.getData());
		
		//测试异常部分
		String userId2 = "090347";
		String emailId2 = "bgsdad24234242342dzcasada234";
		String attachmentName2 = "额呵呵";
		Result<Object> result2 = emailService.downLoad(userId2, emailId2, attachmentName2);
		System.out.println(result2.getData());
	}
	
	@Test
	public void testHasNew() throws Exception{
		
		String userId = "000090";
		Long lastTime = System.currentTimeMillis();
		Result<Object> result = emailService.hasNew(userId, lastTime);
		System.out.println(result);
		
		String userId1 = "000090";
		Long lastTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-2-1 00:00:00").getTime() /1000;
		Result<Object> result1 = emailService.hasNew(userId1, lastTime1);
		System.out.println(result1);
		
		//测试异常
		String userId2 = "090347";
		Long lastTime2 = System.currentTimeMillis();
		Result<Object> result2 = emailService.hasNew(userId2, lastTime2);
		System.out.println(result2);
		
		//测试异常
		String userId3 = "000060";
		Long lastTime3 = System.currentTimeMillis();
		Result<Object> result3 = emailService.hasNew(userId3, lastTime3);
		System.out.println(result3);
	}
	
	@Test
	public void testReply(){
		String userId = "000101";
		String emailId = "AAMkAGQ3MjhkNmRmLTg1YzUtNDkxMy04ZmNiLTE4NDdhNz" +
				"JhYTRkMwBGAAAAAABCaGg/53mzRIn2ntSn06LtBwDvZcDombXpRoVatA" +
				"biW4E0AAAAulLgAADvZcDombXpRoVatAbiW4E0AAAvlffaAAA=";
		String subject = "测试邮件";
		String replyContent = "嘻嘻呵呵哈哈^_^";
		Result<Object> result = emailService.reply(userId, emailId, subject, replyContent);
		System.out.println(result);
		
		//测试异常
		String userId2 = "090347";
		String emailId2 = "adafsgsdg23424242424dfsd23344";
		emailService.reply(userId2, emailId2, subject, replyContent);
		
		//测试异常
		String userId3 = "000086";
		String emailId3 = "adafsgsdg23424242424dfsd23344";
		emailService.reply(userId3, emailId3, subject, replyContent);
	}
	
	@Test
	public void testForward(){
		String userId = "000101";
		String emailId = "AAMkAGQ3MjhkNmRmLTg1YzUtNDkxMy04ZmNiLTE4NDdhNz" +
				"JhYTRkMwBGAAAAAABCaGg/53mzRIn2ntSn06LtBwDvZcDombXpRoVatA" +
				"biW4E0AAAAulLgAADvZcDombXpRoVatAbiW4E0AAAvlffaAAA=";
		String subject = "测试转发邮件";
		String emailTo = "cuiqi@deppon.com";
		String forwardContent = "测试转发^_^";
		Result<Object> result = emailService.forward(userId, emailId, subject, emailTo, null, forwardContent);
		System.out.println(result);
		
		//测试异常
		String userId2 = "090347";
		String emailId2 = "adafsgsdg23424242424dfsd23344";
		emailService.forward(userId2, emailId2, subject, emailTo, null, forwardContent);
		
		String userId3 = "000086";
		emailService.forward(userId3, emailId2, subject, emailTo, null,  forwardContent);
	}
	
	@Test
	public void testSendEmail() throws Exception{
		String subject = "测试发送邮件";
		String content = "测试发送邮件^_^";
		List<String> toAddress = new ArrayList<String>();
		toAddress.add("cuiqi@deppon.com");
		
		MailSenderInfo info = new MailSenderInfo();
		info.setSubject(subject);
		info.setContent(content);
		info.setToAddress(toAddress);
		String userId = "000090";
		File[] files = null;
		//没有附件
		Result<Object> result = emailService.sendEmail(info, userId, files);
		System.out.println(result);
		
		MailSenderInfo info2 = new MailSenderInfo();
		info2.setSubject(subject);
		info2.setContent(content);
		info2.setToAddress(toAddress);
		info2.setAttachFileNames(new String[]{"123"});
		
		List<String> list = new ArrayList<String>();
		list.add("qilei005@depponmail.com");
		info2.setToCcAddress(list);
		
		File[] files2 = new File[]{new File("D:/123.text")};
		//有附件
		emailService.sendEmail(info2, userId, files2);
		
		//测试异常
		String userId2 = "090347";
		emailService.sendEmail(info, userId2, files);
		
		String userId3 = "000086";
		emailService.sendEmail(info, userId3, files);
		
		
		/**********************测试发送邮件带单个附件******************************/
		
		MailSenderInfo info3 = new MailSenderInfo();
		info3.setSubject(subject);
		info3.setContent(content);
		info3.setToAddress(toAddress);
		info3.setAttachFileNames(new String[]{"123"});
		
		File file = null;
		emailService.sendEmail(info, userId, file);
		
		emailService.sendEmail(info3, userId3, new File("D:/123.text"));
		
		//测试异常
		emailService.sendEmail(info, userId2, file);
		
		emailService.sendEmail(info, userId3, file);
	}
	
	@Test
	public void testDelete() throws Exception{
		emailService.delete("116250", "ios", new String[]{"123545623"});
		emailService.delete("039050", "ios", new String[]{"841443443"});
	}
	
}
