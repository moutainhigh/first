package com.deppon.app.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

/**
 * 日志操作记录工具类.
* @ClassName: LogUtil
* @Description: TODO
* @date 2014-5-12 下午03:09:37
*
 */
public class LogUtil {// 日志变量
	private static Logger logger = Logger.getLogger(LogUtil.class);

	/**
	 * @Description 获取带参数的请求url
	 * @param request
	 * @return
	 */
	public static String getFullRequestUrl(HttpServletRequest request) {
		String queryString = request.getQueryString();
		if (queryString == null) {
			queryString = "";
		} else {
			queryString = "?" + queryString;
		}
		String requestUrl = request.getRequestURL() + queryString;
		return requestUrl;
	}

	public static void main(String[] args) {
		insertReqInfo(null, 12345, "test.xml", "140930", "2014-05-04 12:12:12");
	}

	/**
	 * 插入解密文件的日志操作记录.
	 * @Title: insertReqInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param reqInfo
	 * @param @param fileSize
	 * @param @param fileName
	 * @param @param userId
	 * @param @param startDate
	 * @return void
	 * @throws
	 */
	public static void insertReqInfo(HttpServletRequest reqInfo, int fileSize,
			String fileName, String userId, String startDate) {
		// 通过url获取客户端资源
		ClientResource client = new ClientResource(LogClientUtil.SYS_REQ_URL);
		// 构造参数
		Form form = new Form();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
		// 调用接口密码 仅第一条数据传送
		form.add(LogClientUtil.PASSWORD, LogClientUtil.PWD);
		// 应用英文简称 仅第一条数据传送
		form.add(LogClientUtil.APPCODE, LogClientUtil.APP_CODE); 
		// 用户账号
		form.add(LogClientUtil.EMPCODE, reqInfo.getParameter("userId"));
		// 用户IP地址
		form.add(LogClientUtil.CLIENTIP, LogClientUtil.serverIp);
		// http请求url
//		form.add(LogClientUtil.REQUESTURL, reqInfo.getRequestURL().toString());
		// http请求参数信息
//		form.add(LogClientUtil.REQUESTPARA, "user=123");// reqInfo.getQueryString());
		// http请求其他信息
		form.add(LogClientUtil.REQUESTINFO, "解密人:" + userId + ",文件大小:"
				+ fileSize + ",文件名:" + fileName + ",开始时间:" + startDate
				+ ",结束时间:" + sdf.format(d));
		// 业务系统IP地址
		form.add(LogClientUtil.SERVERIP, LogClientUtil.serverIp); 
		// 操作时间
		form.add("OperationTime", sdf.format(d));
		// 模块名称
		form.add("ModuleName", "dlp");
		// 操作内容
		form.add("OperationContent",
				"解密人:" + userId + ",文件大小:" + fileSize + ",文件名:" + fileName
						+ ",开始时间:" + startDate + ",结束时间:" + sdf.format(d));

		try {
			logger.info("【dlpserver---->insertReqInfo--->开始调用BAMP日志接口：】");
			String result = client.post(form.getWebRepresentation()).getText();
			logger.info("调用BAMP日志接口保存请求信息的结果为： " + result);
		} catch (ResourceException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		} catch (IOException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		}
	}
}
