package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcSurveySubmitSaveClientService;

/**
 * 提交保存接口
 * @author 274858
 *
 */
public class ProcSurveySubmitSaveClientAction extends BaseAction{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1335652386086302180L;
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcSurveySubmitSaveClientAction.class);
	
	/*
	 * 服务层
	 */
	private IProcSurveySubmitSaveClientService procSurveySubmitSaveClientService;
	//get set
	public void setProcSurveySubmitSaveClientService(
			IProcSurveySubmitSaveClientService procSurveySubmitSaveClientService) {
		this.procSurveySubmitSaveClientService = procSurveySubmitSaveClientService;
	}

	/**
	 * 提交保存接口
	 */
	public void saveBaseDate(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"提交数据失败！\"}";
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//接收到的参数
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转为字符串
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("procSurveySubmitSaveClientAction——saveBaseDate()"+str);
			//判断是否为null
			if(str !=null && !"".equals(str)){
				//得到结果集
				res = procSurveySubmitSaveClientService.saveBaseDate(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("procSurveySubmitSaveClientAction——saveBaseDate()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，提交数据失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
}
