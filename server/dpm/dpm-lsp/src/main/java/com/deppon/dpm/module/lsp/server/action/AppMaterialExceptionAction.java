package com.deppon.dpm.module.lsp.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.lsp.module.materialexception.materialexceptionapply.server.service.IDPMMaterialExceptionService;
/**
 * 物资异常反馈Action
 * @author 275050
 *
 */
public class AppMaterialExceptionAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(AppMaterialExceptionAction.class);	
	
	/**
	 * 注入物资异常反馈Service
	 */
	@Autowired
	private IDPMMaterialExceptionService dpmMaterialExceptionService;
    
	/**
	 * @author 275050
	 * 物资异常反馈--物料信息查询
	 */
	public void appQueryMaterial(){
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resultJson = "{\"resultFlag\":false,\"failureReason\":\"物资异常反馈查询物料信息失败，请稍后重试！\"}";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			//读取前台发送的流
    		BufferedReader bu = request.getReader();
			//编码转换
			String parameterJson = java.net.URLDecoder.decode(com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu), "utf-8");
			resultJson = dpmMaterialExceptionService.appQueryMaterial(parameterJson);
			writeToPage(response, resultJson);
		} catch (Exception e) {
			logger.info("AppMaterialExceptionAction--appQueryMaterial--物资异常反馈查询物料信息失败:"+e);
			writeToPage(response, resultJson);
		}
	}
	
	/**
	 * @author 275050
	 * 物资异常反馈提交方法
	 */
	public void appSubmit() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resultJson = "{\"resultFlag\":false,\"failureReason\":\"提交请求响应超时，请稍等5分钟左右后检查是否存在提交信息后重试！\"}";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			//读取前台发送的流
    		BufferedReader bu = request.getReader();
			//编码转换
			//String parameterJson = java.net.URLDecoder.decode(com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu), "utf-8");
    		String  parameterJson = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			resultJson = dpmMaterialExceptionService.appSubmit(parameterJson);
			writeToPage(response, resultJson);
		} catch (Exception e) {
			logger.info("AppMaterialExceptionAction--appSubmit--物资异常反馈提交失败:"+e);
			writeToPage(response, resultJson);
		}
	
	}
	
	/**
	 * @author 275050
	 * 查询物资异常历史记录
	 */
	public void appQueryMaterialExceptionHistory(){
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String resultJson = "{\"resultFlag\":false,\"failureReason\":\"查询物资异常历史记录失败，请稍后重试！\"}";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			//读取前台发送的流
    		BufferedReader bu = request.getReader();
			//编码转换
			String parameterJson = java.net.URLDecoder.decode(com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu), "utf-8");
			resultJson = dpmMaterialExceptionService.appQueryMaterialExceptionHistory(parameterJson);
			writeToPage(response, resultJson);
		} catch (Exception e) {
			logger.info("AppMaterialExceptionAction--appSubmit--查询物资异常历史记录失败:"+e);
			writeToPage(response, resultJson);
		}
	}

	/**
	 * @author 275050
	 * set the dpmMaterialExceptionService
	 * @param dpmMaterialExceptionService
	 */
	public void setDpmMaterialExceptionService(
			IDPMMaterialExceptionService dpmMaterialExceptionService) {
		this.dpmMaterialExceptionService = dpmMaterialExceptionService;
	}
	
	

}
