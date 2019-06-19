package com.deppon.bamp.module.log.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.deppon.bamp.module.log.domain.BusiOperEntity;
import com.deppon.bamp.module.log.domain.ReqInfoEntity;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.montal.util.redis.service.impl.UserRedisService;

/**
 * @title: LogRestServiceClient 
 * @description: 调用BAMP日志rest webservice接口客户端
 * @author: wuyaqing
 * @date:  2014-4-17 下午5:41:25
 */
public class LogRestServiceClient extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//日志变量
	private static Logger logger = Logger.getLogger(UserRedisService.class);
	//客户端
	private static ClientResource client = null;
	
	/**
	 * @MethodName: init 
	 * @description: 初始化日志接口客户端
	 * @author: wuyaqing 
	 * @date: 2014-5-13 下午2:58:13
	 */
	@Override
	public void init() throws ServletException {
		logger.info("【LogRestServiceClient---->init--->开始初始化BAMP日志接口客户端】");
		//通过url获取客户端资源
		if(client == null) {
			client = new ClientResource(LogClientUtil.SYS_REQ_URL);
		}
		logger.info("【LogRestServiceClient---->init--->初始化BAMP日志接口客户端结束】");
	}
	
	/**
	 * @MethodName: saveReqInfos 
	 * @description: 批量保存请求信息到BAMP日志
	 * @author: wuyaqing 
	 * @date: 2014-4-22 上午11:11:08
	 * @param loglist void
	 */
	public static void saveReqInfos(List<ReqInfoEntity> loglist) {
		if(client == null) {
			client = new ClientResource(LogClientUtil.SYS_REQ_URL);
		}
		//构造参数
		Form form = new Form();
		
		//调用接口密码 仅第一条数据传送
		form.add(LogClientUtil.PASSWORD, LogClientUtil.PWD);
		//应用英文简称 仅第一条数据传送
		form.add(LogClientUtil.APPCODE, LogClientUtil.APP_CODE);
		
		for(ReqInfoEntity entity : loglist) {
			//类名+方法名 
			form.add(LogClientUtil.METHODNAME, entity.getMethodName());  
			//命名空间
			form.add(LogClientUtil.NAMESPACE, entity.getNamespace());
			//用户账号
			form.add(LogClientUtil.EMPCODE, entity.getEmpCode());
			//用户IP地址
			form.add(LogClientUtil.CLIENTIP, entity.getClientIp());
			//http请求url
			form.add(LogClientUtil.REQUESTURL, entity.getRequestUrl());
			//http请求参数信息
			form.add(LogClientUtil.REQUESTPARA, entity.getRequestPara());
			//http请求其他信息
			form.add(LogClientUtil.REQUESTINFO, entity.getRequestInfo());
			//业务系统IP地址
			form.add(LogClientUtil.SERVERIP, entity.getServerIp());
			//服务请求时间
			form.add(LogClientUtil.REQTIME, entity.getReqTime());
			//服务响应时间
			form.add(LogClientUtil.RESPTIME, entity.getRespTime());
		}
		
		try {
			logger.info("【LogRestServiceClient---->recordAccessLog--->开始调用BAMP日志接口：】");
			String result = client.post(form.getWebRepresentation()).getText();
			logger.info("调用BAMP日志接口保存请求信息的结果为： " + result);
		} catch (ResourceException e) {
			e.printStackTrace();
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		} catch (IOException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * @MethodName: insertReqInfo 
	 * @description: 实时调用BAMP接口保存请求信息
	 * @author: wuyaqing 
	 * @date: 2014-4-22 上午11:14:03
	 * @param reqInfo void
	 */
	public static void insertReqInfo(ReqInfoEntity reqInfo) {
		if(client == null) {
			client = new ClientResource(LogClientUtil.SYS_REQ_URL);
		}
		//构造参数
		Form form = new Form();
		
		//调用接口密码 仅第一条数据传送
		form.add(LogClientUtil.PASSWORD, LogClientUtil.PWD);
		//应用英文简称 仅第一条数据传送
		form.add(LogClientUtil.APPCODE, LogClientUtil.APP_CODE);
		//类名+方法名 
		form.add(LogClientUtil.METHODNAME, reqInfo.getMethodName()); 
		//命名空间 
		form.add(LogClientUtil.NAMESPACE, reqInfo.getNamespace());
		//用户账号
		form.add(LogClientUtil.EMPCODE, reqInfo.getEmpCode());
		//用户IP地址
		form.add(LogClientUtil.CLIENTIP, reqInfo.getClientIp());
		//http请求url
		form.add(LogClientUtil.REQUESTURL, reqInfo.getRequestUrl());
		//http请求参数信息
		form.add(LogClientUtil.REQUESTPARA, reqInfo.getRequestPara());
		//http请求其他信息
		form.add(LogClientUtil.REQUESTINFO, reqInfo.getRequestInfo());
		//业务系统IP地址
		form.add(LogClientUtil.SERVERIP, reqInfo.getServerIp());
		//服务请求时间
		form.add(LogClientUtil.REQTIME, reqInfo.getReqTime());
		//服务响应时间
		form.add(LogClientUtil.RESPTIME, reqInfo.getRespTime());
		
		try {
			logger.info("【LogRestServiceClient---->insertReqInfo--->开始调用BAMP日志接口：】");
			String result = client.post(form.getWebRepresentation()).getText();
			logger.info("调用BAMP日志接口保存请求信息的结果为： " + result);
		} catch (ResourceException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		} catch (IOException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		}
	}
	
	/**
	 * @MethodName: insertBusiOperInfo 
	 * @description: 实时保存业务操作方法
	 * @author: wuyaqing 
	 * @date: 2014-4-23 上午11:10:08
	 * @param entity void
	 */
	public static void insertBusiOperInfo(BusiOperEntity entity) {
		if(client == null) {
			client = new ClientResource(LogClientUtil.SYS_REQ_URL);
		}
		//构造参数
		Form form = new Form();
		
		//调用接口密码 仅第一条数据传送
		form.add("PassWord", LogClientUtil.PWD);
		//应用英文简称 仅第一条数据传送
		form.add("AppCode", LogClientUtil.APP_CODE);
		//用户工号
		form.add("EmpCode", entity.getEmpCode());
		//操作时间
		form.add("OperationTime", entity.getOperationTime());
		//模块名称
		form.add("ModuleName", entity.getModuleName());
		//操作内容
		form.add("OperationContent", entity.getOperationContent());
		
		try {
			logger.info("【LogRestServiceClient---->insertBusiOperInfo--->开始调用BAMP日志接口：】");
			String result = client.post(form.getWebRepresentation()).getText();
			logger.info("调用BAMP日志接口保存请求信息的结果为： " + result);
		} catch (ResourceException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		} catch (IOException e) {
			logger.error("调用BAMP接口出错，具体的错误信息为： " + e.getMessage());
		}
	}

}
