package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.DES;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.WhetherMonitorCutffPoint;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IEmailService;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * @author email actiion
 *
 */
public class EmailAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 8666763487418583775L;
	/**
	 * 日志
	 */
	private static final Logger logger = Logger.getLogger(EmailAction.class);

	/**
	 * 邮件id
	 */
	private String emailId;
	
	/**
	 * 附件id
	 */
	private String attachmentId;
	
	/**
	 * 附件下载地址
	 */
	private String attachmentUrl;
	
	/**
	 *   批量删除邮件id
	 */
	private String emailIds;

	/**
	 * 分页
	 */
	private int page = 1;

	/**
	 *  分页
	 */
	private static final int PAGESIZE_10 = 10;
	/**
	 * 分页
	 */
	private int pageSize = PAGESIZE_10;

	/**
	 * 附件个数
	 */
	private static final int FILENUM_5 = 5;
	/**
	 * 附件个数
	 */
	private static final int FILENUM_4 = 4;
	/**
	 * 附件个数
	 */
	private static final int FILENUM_3 = 3;
	/**
	 * 附件个数
	 */
	private static final int FILENUM_2 = 2;
	/**
	 * 附件个数
	 */
	private static final int FILENUM_1 = 1;
	/**
	 * 附件个数
	 */
	private static final int FILENUM_0 = 0;
	/**
	 * 错误的状态码
	 */
	private static final int ERRORCODE_3 = 3;

	/**
	 * subject
	 */
	private String subject;
	/**
	 * 0 表示android访问，1表示ios
	 */
	private int accessType;
	/**
	 *  附件名称
	 */
	private String attachmentName;
	/**
	 * android
	 */
	private String osType = "android";
	/**
	 * 客户端获取的最后一封邮件的时间，根据这个时间判断是否有新邮件
	 */
	private long lastTime;
	/**
	 * emailService 注入
	 */
	private IEmailService emailService;
	/**
	 * 回复内容
	 */
	private String replyContent;

	/**
	 * 转发
	 */
	private String fowardContent;
	/**
	 * email转向
	 */
	private String emailTo;
	
	/**
	 * 邮件所有类型
	 */
	private String searchType;
	
	/**
	 * 邮件搜索条件
	 */
	private String condition;
	
	/**
	 * 条件搜索的结果点击更多
	 */
	private String more;
	
	/**
	 * dlp附件解密url
	 */
	private String appInterfaceUrl;
	
	/**
	 * 项目路径
	 */
	private String serverHostPort;
	
	/**
	 * 允许解密的文件类型
	 */
	public static final List<String> FILE_TYPE = new ArrayList<String>();
	
	/**
	 * 允许解密的图片类型
	 */
	public static final List<String> PIC_TYPE = new ArrayList<String>();
	
	static {
		// 允许解密的文件类型
		FILE_TYPE.add("xls");
		FILE_TYPE.add("xlsx");
		FILE_TYPE.add("doc");
		FILE_TYPE.add("docx");
		FILE_TYPE.add("ppt");
		FILE_TYPE.add("pptx");
		FILE_TYPE.add("pdf");
		FILE_TYPE.add("txt");
		FILE_TYPE.add("png");
		FILE_TYPE.add("jpg");
		FILE_TYPE.add("jpeg");
		
		// 允许解密的图片类型
		PIC_TYPE.add("png");
		PIC_TYPE.add("jpg");
		PIC_TYPE.add("jpeg");
	}
	
	/**
	 * 加载邮件列表，做版本兼容
	 * version = 20160317
	 * 优化点击邮件时的加载速度
	 */
	public void list() {
		Result<Object> result = null;
		// 获取版本参数
		String version = ServletActionContext.getRequest().getParameter("version");
		if("20160317".equals(version) || "20160519".equals(version)){
			// 20160317迭代加载邮件时不全部加载，只加载部分邮件信息
			result = emailService.queryListNew(page, pageSize, userId);
		}else{
			// 其他的还是按照老版本的方式去加载
			emailService.queryList(page, pageSize, userId);
		}
		// 写入数据
		writeToPage(result);
	}
	
	/**
	 * 查询（优化邮件加载，不加载附件）
	 * 2016-03-03
	 */
	public void queryListByPage(){
		//得到email数据
		Result<Object> result = emailService.queryListByPage(page, pageSize, userId);
		//写入数据
		writeToPage(result);
	}
	
	/**
	 * 条件查询
	 */
	public void searchEmail(){
		//得到email列表数据（部分邮件字段数据）
		Result<Object> result = emailService.searchEmailByCondition(userId,searchType,condition,more);
		//写入数据
		writeToPage(result);
	}
	
	/**
	 * 根据邮件id加载附件
	 */
//	@WhetherMonitorCutffPoint
	public void loadEmailById(){
		Result<Object> result = emailService.loadEmailById(userId,emailId);
		//写入数据
		writeToPage(result);
	}
	

	/**
	 * 将邮件从收件箱移动到已删除邮件
	 */
//	@WhetherMonitorCutffPoint
	public void delete() {
		//声明一个数据
		String[] deleteIds = new String[] {};
		//判断什么机型
		if (accessType == 1) {
			try {
				HttpServletRequest request = ServletActionContext.getRequest();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						request.getInputStream()));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				//得到页面传过来数据
				String iosParam = buffer.toString().trim();
				//判断数据是否为Null
				if (StringUtils.isNotEmpty(iosParam)) {
					//转ｊｓｏｎ格式数据
					JSONObject jsonObject = com.alibaba.fastjson.JSON
							.parseObject(iosParam);
					//得到userId
					if(StringUtils.isBlank(userId)){
						userId = (String) jsonObject.get("userId");
					}
					//得到mail
					String mail = (String) jsonObject.get("emailIds");
					deleteIds = mail.split(",");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			deleteIds = emailIds.split(",");
		}

		Result<Object> result = new Result<Object>();
		try {
			//删除数据
			result = emailService.delete(userId, osType, deleteIds);
			result.setData("删除邮件成功");
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setData("删除邮件失败");
		}
		//写入数据
		writeToPage(result);
	}

	/**
	 * 读取一封邮件，更新成已读状态
	 */
//	@WhetherMonitorCutffPoint
	public void read() {
		//返回结果
		Result<Object> result = new Result<Object>();
		try {
			//读取邮件数据
			result = emailService.read(userId, emailId);
		} catch (Exception e) {
			e.printStackTrace();
			result.setErrorCode(ERRORCODE_3);
			result.setData("读取邮件失败");
		}
		//写入数据
		writeToPage(result);
	}
	
	/**
	 * 更新多封邮件成已读状态
	 * 2016-01-28
	 */
//	@WhetherMonitorCutffPoint
	public void readAll() {
		//返回结果
		Result<Object> result = new Result<Object>();
		try {
			//更新邮件已读状态
			result = emailService.readAll(userId);
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setData("更新邮件状态失败");
			//日志
			logger.error("更新多封邮件为已读状态出现异常>>>>>>>" +
					"{userId="+userId+",emailIds="+emailIds+"}",e);
		}
		//写入数据
		writeToPage(result);
	}

	/**
	 * 下载邮件中的附件
	 */
	@Deprecated
	public void downLoad() {
		//返回结果
		Result<Object> result = new Result<Object>();
		try {
			result = emailService.downLoad(userId, emailId, attachmentName);
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setData("下载附件失败");
		}
		//写入数据
		writeToPage(result);
	}
	
	/**
	 * 下载附件 （新）
	 */
	public void downloadAttachment(){
		//返回结果
		Result<Object> result = new Result<Object>();
		try {
			// 将附件下载到服务器本地
			result = emailService.downloadAttachment(userId, emailId, attachmentId,attachmentUrl);
			
			/************新增逻辑************/
			// 获取版本参数
			String version = ServletActionContext.getRequest().getParameter("version");
			// ios/android
			String deviceType = ServletActionContext.getRequest().getParameter("deviceType");
			// 版本兼容
			if("20160519".equals(version) && result.getErrorCode() == 0){
				// 附件真实路径
				String path = attachmentUrl.replaceAll(serverHostPort, "/dpmfile/");
				String filename = UUID.randomUUID().toString() + path.substring(path.lastIndexOf("."));
				File file = new File(path);
				if(!file.exists()){
					// 附件不存在
					writeToPage("40006");
					return;
				}
				// 解密附件
				decryptFile(userId,deviceType,filename,file);
				return;	
			}
			/****************************/
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setData("下载附件失败");
			//日志输出
			logger.error("下载邮件附件出现异常>>>>>>>" +
					"{userId="+userId+",emailId="+emailId+",attachmentId="+attachmentId+",attachmentUrl="+attachmentUrl+"}",e);
		}
		//写入数据
		writeToPage(result);
	}
	
	
	/**
	 * 下载附件,android专用
	 */
//	public void downloadAttachmentForAndroid(){
//		//返回结果
//		Result<Object> result = new Result<Object>();
//		try {
//			// 将附件下载到服务器本地
//			result = emailService.downloadAttachment(userId, emailId, attachmentId,attachmentUrl);
//			// 设置附件id
//			result.setData(attachmentId);
//			String deviceType = ServletActionContext.getRequest().getParameter("deviceType");
//			
//			if(result.getErrorCode() == 0){
//				// 附件真实路径
//				String path = attachmentUrl.replaceAll(serverHostPort, "/dpmfile/");
//				// 文件后缀
//				String fileSuffix = path.substring(path.lastIndexOf(".") + 1);
//				String filename = UUID.randomUUID().toString() + "." + fileSuffix;
//				File file = new File(path);
//				// 附件不存在
//				if(!file.exists()){
//					result.setErrorCode(MagicNumber.NUM1);
//					result.setErrorMessage("附件下载失败！");
//					writeToPage(result);
//					return;
//				}
//				
//				// 附件类型
//				if(!FILE_TYPE.contains(fileSuffix.toLowerCase())){
//					result.setErrorCode(MagicNumber.NUM1);
//					result.setErrorMessage("不支持该类型附件!");
//					writeToPage(result);
//					return;
//				}
//				
//				// 附件大小过大
//				if(file.length() > 8388608) {
//					result.setErrorCode(MagicNumber.NUM1);
//					result.setErrorMessage("附件过大，只支持8M以内的附件!");
//					writeToPage(result);
//					return;
//				}
//				
//				// 解密好的文件下载路径
//				String downLoadPDFurl = attachmentUrl;
//				
//				// 排除图片和txt
//				if(!PIC_TYPE.contains(fileSuffix.toLowerCase()) && !"txt".equals(fileSuffix.toLowerCase())){
//					downLoadPDFurl = attachmentUrl.replace(fileSuffix, "pdf");
//				}
//				// 转好的PDF下载地址
//				result.setResult(downLoadPDFurl); 
//				// 解密附件
//				decryptFileForAndroid(userId,deviceType,filename,file,result);
//			} else {
//				// 附件下载失败
//				result.setErrorCode(MagicNumber.NUM1);
//				result.setErrorMessage("附件下载失败!");
//			}
//		} catch (Exception e) {
//			result.setData(attachmentId);
//			result.setErrorCode(MagicNumber.NUM1);
//			result.setErrorMessage("附件下载异常!");
//			//日志输出
//			logger.error("下载邮件附件出现异常>>>>>>>" +
//					"{userId="+userId+",emailId="+emailId+",attachmentId="+attachmentId+",attachmentUrl="+attachmentUrl+"}",e);
//		}
//		//写入数据
//		writeToPage(result);
//	}
	
	
	// 附件解密，android专用
//	private void decryptFileForAndroid(String userId,String deviceType,String filename,File file,Result<Object> result) 
//			throws ClientProtocolException, IOException{
//		CloseableHttpClient httpClient = null;
//		CloseableHttpResponse response = null;
//		InputStream in = null;
//		BufferedOutputStream bos = null;
//		try {
//			httpClient = HttpClients.createDefault();
//			HttpPost httpPost = new HttpPost(appInterfaceUrl);
//			// 上传的文件
//			FileBody bin = new FileBody(file);
//			StringBody userIdParam = new StringBody(userId,ContentType.create("text/plain",Consts.UTF_8));
//			StringBody deviceTypeParam = new StringBody(deviceType,ContentType.create("text/plain",Consts.UTF_8));
//			StringBody filenameParam = new StringBody(filename,ContentType.create("text/plain",Consts.UTF_8));
//			// 构造表单
//			HttpEntity reqEntity = MultipartEntityBuilder.create()
//					.addPart("file", bin)
//					.addPart("userId", userIdParam)
//					.addPart("deviceType", deviceTypeParam)
//					.addPart("filename", filenameParam)
//					.build();
//			 // 设置参数
//		    RequestConfig config = RequestConfig.custom()
//					.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
//					.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
//					.setSocketTimeout(MagicNumber.NUM60000) // 数据传输的最长时间（1分钟）
//					.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
//					.build();
//		    // 设置参数
//			httpPost.setEntity(reqEntity);
//			httpPost.setConfig(config);
//		
//			// 请求dlp
//			response = httpClient.execute(httpPost);
//			if(response.getStatusLine().getStatusCode() == MagicNumber.NUM200){
//				// 获取响应数据
//				HttpEntity entity = response.getEntity();
//				if(null != entity){
//					in = entity.getContent();
//					int count = 0;
//					int len = 0;
//					byte[] buf = new byte[MagicNumber.NUM1024];
//					bos = new BufferedOutputStream(new FileOutputStream(new File(result.getResult().replaceAll(serverHostPort, "/dpmfile/"))));
//					while((len = in.read(buf)) != -1){
//						bos.write(buf,0,len);
//						count++;
//					}
//					// 代表返回的流数据小于1KB，证明文件解密失败
//					if(count < 1){
//						result.setErrorCode(1);
//					}
//				}
//			}
//		}finally {
//			// 释放资源
//			if(in != null){
//				try {
//					in.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			// 释放资源
//			if(bos != null){
//				try {
//					bos.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//			// 释放资源
//            if(response!=null){
//                try {
//					response.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//            }
//            
//            if(httpClient != null){
//            	try {
//            		// 关闭连接
//            		httpClient.close();
//            	} catch (IOException e) {
//            		e.printStackTrace();
//            	}
//            }
//		}
//	}
	
	// 附件解密
	private void decryptFile(String userId,String deviceType,String filename,File file){
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		ServletOutputStream out = null;
		InputStream in = null;
		try {
			// 获取response的输出流
			out = ServletActionContext.getResponse().getOutputStream();
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(appInterfaceUrl);
			// 上传的文件
			FileBody bin = new FileBody(file);
			StringBody userIdParam = new StringBody(userId,ContentType.create("text/plain",Consts.UTF_8));
			StringBody deviceTypeParam = new StringBody(deviceType,ContentType.create("text/plain",Consts.UTF_8));
			StringBody filenameParam = new StringBody(filename,ContentType.create("text/plain",Consts.UTF_8));
			// 构造表单
			HttpEntity reqEntity = MultipartEntityBuilder.create()
					.addPart("file", bin)
					.addPart("userId", userIdParam)
					.addPart("deviceType", deviceTypeParam)
					.addPart("filename", filenameParam)
					.build();
			 // 设置参数
		    RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
					.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
					.setSocketTimeout(MagicNumber.NUM60000) // 数据传输的最长时间（1分钟）
					.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
					.build();
		    // 设置参数
			httpPost.setEntity(reqEntity);
			httpPost.setConfig(config);
		
			// 请求dlp
			response = httpClient.execute(httpPost);
			byte[] buff = new byte[MagicNumber.NUM1024];
			int len = 0;
			if(response.getStatusLine().getStatusCode() == MagicNumber.NUM200){
				// 获取响应数据
				HttpEntity entity = response.getEntity();
				if(null != entity){
					in = entity.getContent();
					// 将解密后的文件数据写出
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
				}
			}
		} catch (Exception e) {
			logger.error("附件解密失败>>>>", e);
			try {
				if(null != out){
					// 异常返回
					out.write("40007".getBytes());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 释放资源
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 释放资源
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// 释放资源
            if(response!=null){
                try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            
            if(httpClient != null){
            	try {
            		// 关闭连接
            		httpClient.close();
            	} catch (IOException e) {
            		e.printStackTrace();
            	}
            }
		}
	}

	/**
	 * 判断是否有新邮件
	 */
	public void hasNew() {
		Result<Object> hasNew = null;
		try {
			hasNew = emailService.hasNew(userId, lastTime);
			writeToPage(hasNew);
		} catch (Exception e) {
			//日志输出
			logger.error("判断是否有新邮件出现异常>>>>>>>" +
					"{userId="+userId+"lastTime="+lastTime+"}",e);
			writeToPage(hasNew);
		}
	}

	/**
	 * 邮件回复
	 */
	public void reply() {
		Result<Object> result = null;
		try {
			result = emailService.reply(userId, emailId, subject, replyContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage(result);
	}
	
	/**
	 * 邮件回复全部
	 */
	public void replyAll() {
		Result<Object> result = null;
		try {
			result = emailService.replyAll(userId, emailId, subject, emailTo, replyContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage(result);
	}

	/**
	 * 邮件转发
	 */
	public void foward() {
		Result<Object> result = null;
		try {
			String emailToCc = ServletActionContext.getRequest().getParameter("emailToCc");
			result = emailService.forward(userId, emailId, subject, emailTo, emailToCc,
					fowardContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage(result);
	}

	/**
	 * 用于读取附件 单个附件
	 */
	private File file;
	private File file0;
	private File file1;
	private File file2;
	private File file3;
	private File file4;

	/**
	 * 用于读取附件 多个附件
	 */
	private File[] files;

	/**
	 * exchange service发邮件 多个附件 邮件发送新接口
	 */
	@CookieNotCheckedRequired
//	@WhetherMonitorCutffPoint
	public void newEmails() {
		Result<Object> result = new Result<Object>();
		MailSenderInfo mailSenderInfo = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		String parameter = request.getParameter("sendInfo");
		try {
			if (StringUtils.isNotEmpty(parameter)) {
				userId = JSONObject.parseObject(parameter).getString("userId");
				parameter = JSONObject.parseObject(parameter).getString(
						"mailSenderInfo");
				mailSenderInfo = JSONObject.parseObject(parameter,
						MailSenderInfo.class);
				if (null != mailSenderInfo.getSubject()) {
					mailSenderInfo.setSubject(URLDecoder.decode(
							mailSenderInfo.getSubject(), "UTF-8"));
				}
				mailSenderInfo.setContent(URLDecoder.decode(
						mailSenderInfo.getContent(), "UTF-8"));
				// android 多附件处理 限定5个附件
				files = new File[FILENUM_5];
				files[FILENUM_0] = file0;
				files[FILENUM_1] = file1;
				files[FILENUM_2] = file2;
				files[FILENUM_3] = file3;
				files[FILENUM_4] = file4;
				result.setCount(Constants.SUCCESS);
			} else {
				// ios后台处理
				Map<?,?> mailSenderInfoMap = request.getParameterMap();
				if (!CollectionUtils.isEmpty(mailSenderInfoMap)) {
					String[] infoStrs = (String[]) mailSenderInfoMap
							.get("mailSenderInfo");
					// json格式转换为info对象
					mailSenderInfo = JSONObject.parseObject(infoStrs[0],
							MailSenderInfo.class);
					result.setCount(Constants.SUCCESS);
				}
			}
			if (null != mailSenderInfo
					&& StringUtils.isNotEmpty(mailSenderInfo.getPassword())) {
				String password = new String(Base64.decodeBase64(DES
						.decryptDES(mailSenderInfo.getPassword())));
				mailSenderInfo.setPassword(password);
				// 多个附件
				result = emailService.sendEmail(mailSenderInfo, userId, files);
				result.setErrorMessage(Constants.ACTIVE_YES);
			} else {
				logger.info("邮件发送出错");
				result.setCount(Constants.WRONG_REQUEST);
				result.setErrorMessage(Constants.ACTIVE_NO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("邮件发送出错信息:" + e.getMessage());
			result.setCount(Constants.WRONG_REQUEST);
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		writeToPage(result);
	}

	/**
	 * exchange service发邮件
	 */
	@CookieNotCheckedRequired
	public void newEmail() {
		Result<Object> result = new Result<Object>();
		MailSenderInfo mailSenderInfo = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		String parameter = request.getParameter("sendInfo");
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {
			if (StringUtils.isNotEmpty(parameter)) {
				userId = JSONObject.parseObject(parameter).getString("userId");
				parameter = JSONObject.parseObject(parameter).getString(
						"mailSenderInfo");
				//json转换得到数据
				mailSenderInfo = JSONObject.parseObject(parameter,
						MailSenderInfo.class);
				//判断数据
				if (null != mailSenderInfo.getSubject()) {
					mailSenderInfo.setSubject(URLDecoder.decode(
							mailSenderInfo.getSubject(), "UTF-8"));
				}
				//塞入数据
				mailSenderInfo.setContent(URLDecoder.decode(
						mailSenderInfo.getContent(), "UTF-8"));
				//塞入数据
				result.setCount(Constants.SUCCESS);
			} else {
				//设置编码格式
				BufferedReader in = new BufferedReader(new InputStreamReader(
						request.getInputStream(), "utf-8"));
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
				//去除空格
				String param = sb.toString().trim();
				//json转换得到数据
				userId = JSONObject.parseObject(param).getString("userId");
				//json转换得到数据
				param = JSONObject.parseObject(param).getString(
						"mailSenderInfo");
				//json转换得到数据
				mailSenderInfo = JSONObject.parseObject(param,
						MailSenderInfo.class);
				result.setCount(Constants.SUCCESS);
			}
            //判断密码是否为null
			if (null != mailSenderInfo
					&& StringUtils.isNotEmpty(mailSenderInfo.getPassword())) {
				String password = new String(Base64.decodeBase64(DES
						.decryptDES(mailSenderInfo.getPassword())));
				mailSenderInfo.setPassword(password);
				// 单个附件 或无附件
				result = emailService.sendEmail(mailSenderInfo, userId, file);
				result.setErrorMessage(Constants.ACTIVE_YES);
			} else {
				logger.info("邮件发送出错");
				result.setCount(Constants.WRONG_REQUEST);
				result.setErrorMessage(Constants.ACTIVE_NO);
			}
		} catch (Exception e) {
			//抛出异常
			e.printStackTrace();
			logger.info("邮件发送出错信息:" + e.getMessage());
			result.setCount(Constants.WRONG_REQUEST);
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		//写入数据
		writeToPage(result);
	}

	/**
	 * 新建邮件()
	 */
	@CookieNotCheckedRequired
	/*
	 * public void newEmail() { MailSenderInfo mailSenderInfo = null;
	 * Result<Boolean> result = new Result<Boolean>(); HttpServletRequest
	 * request = ServletActionContext.getRequest(); String parameter =
	 * request.getParameter("sendInfo"); StringBuffer sb = new StringBuffer();
	 * String line = null; try { if (StringUtils.isNotEmpty(parameter)) {
	 * parameter = JSONObject.parseObject(parameter).getString(
	 * "mailSenderInfo"); mailSenderInfo = JSONObject.parseObject(parameter,
	 * MailSenderInfo.class); mailSenderInfo.setSubject(URLDecoder.decode(
	 * mailSenderInfo.getSubject(), "UTF-8"));
	 * mailSenderInfo.setContent(URLDecoder.decode( mailSenderInfo.getContent(),
	 * "UTF-8")); } else { BufferedReader in = new BufferedReader(new
	 * InputStreamReader( request.getInputStream(), "utf-8")); while ((line =
	 * in.readLine()) != null) { sb.append(line); } String param =
	 * sb.toString().trim(); result.setCount(0); param =
	 * JSONObject.parseObject(param).getString( "mailSenderInfo");
	 * mailSenderInfo = JSONObject.parseObject(param, MailSenderInfo.class); }
	 * String password = new String(Base64.decodeBase64(DES
	 * .decryptDES(mailSenderInfo.getPassword())));
	 * mailSenderInfo.setPassword(password); boolean res =
	 * SendEmailUtil.sendTextMail(mailSenderInfo, files); result.setData(res);
	 * if (res == true) { result.setErrorMessage("发送成功"); }
	 * result.setErrorCode(Constants.ACTION_RESULT_SUC); } catch
	 * (MessagingException e) { e.printStackTrace(); logger.info("邮件发送出错信息:" +
	 * e.getMessage()); result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	 * result.setErrorMessage("发送失败"); result.setData(false);
	 * result.setCount(0); } catch (Exception e) { e.printStackTrace();
	 * logger.info("解密+邮件发送出错信息:" + e.getMessage());
	 * result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	 * result.setErrorMessage("发送失败"); result.setData(false);
	 * result.setCount(0); } writeToPage(result); }
	 */
	/**
	 * setter
	 * @param lastTime
	 */
	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * getter
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * setter
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
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
	public String getFowardContent() {
		return fowardContent;
	}

	/**
	 * setter
	 * @param fowardContent
	 */
	public void setFowardContent(String fowardContent) {
		this.fowardContent = fowardContent;
	}

	/**
	 * getter
	 * @return
	 */
	public String getEmailTo() {
		return emailTo;
	}

	/**
	 * setter
	 * @param emailTo
	 */
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	/**
	 * setter
	 * @param replyContent
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	/**
	 * setter
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * setter
	 * @param attachmentName
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	/**
	 * getter
	 * @return
	 */
	public String getAttachmentId() {
		return attachmentId;
	}

	/**
	 * setter
	 * @param attachmentId
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * getter
	 * @return
	 */
	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	/**
	 * setter
	 * @param attachmentUrl
	 */
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	/**
	 * setter
	 * @param page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * setter
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * setter
	 * @param emailIds
	 */
	public void setEmailIds(String emailIds) {
		this.emailIds = emailIds;
	}

	/**
	 * setter
	 * @param accessType
	 */
	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}

	/**
	 * setter
	 * @param emailService
	 */
	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * getter
	 * @return
	 */
	public File getFile() {
		return file;
	}

	/**
	 * setter
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * getter
	 * @return
	 */
	public File[] getFiles() {
		return files;
	}

	/**
	 * setter
	 * @param files
	 */
	public void setFiles(File[] files) {
		this.files = files;
	}

	/**
	 * getter
	 * @return
	 */
	public File getFile1() {
		return file1;
	}

	/**
	 * setter
	 * @param file1
	 */
	public void setFile1(File file1) {
		this.file1 = file1;
	}

	/**
	 * getter
	 * @return
	 */
	public File getFile2() {
		return file2;
	}

	/**
	 * setter
	 * @param file2
	 */
	public void setFile2(File file2) {
		this.file2 = file2;
	}

	/**
	 * getter
	 * @return
	 */
	public File getFile3() {
		return file3;
	}

	/**
	 * setter
	 * @param file3
	 */
	public void setFile3(File file3) {
		this.file3 = file3;
	}

	/**
	 * getter
	 * @return
	 */
	public File getFile4() {
		return file4;
	}

	/**
	 * setter
	 * @param file4
	 */
	public void setFile4(File file4) {
		this.file4 = file4;
	}

	/**
	 * getter
	 * @return
	 */
	public File getFile0() {
		return file0;
	}

	/**
	 * setter
	 * @param file0
	 */
	public void setFile0(File file0) {
		this.file0 = file0;
	}

	/**
	 * getter
	 * @return
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * setter
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * getter
	 * @return
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * setter
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * getter
	 * @return
	 */
	public String getMore() {
		return more;
	}

	/**
	 * setter
	 * @param more
	 */
	public void setMore(String more) {
		this.more = more;
	}

	/**
	 * setter
	 */
	public void setAppInterfaceUrl(String appInterfaceUrl) {
		this.appInterfaceUrl = appInterfaceUrl;
	}

	/**
	 * setter
	 */
	public void setServerHostPort(String serverHostPort) {
		this.serverHostPort = serverHostPort;
	}
	
	
}
