package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.ISendParcelSendSerice;
import com.deppon.dpm.module.management.shared.domain.ConstantClassField;
import com.deppon.foss.framework.shared.util.string.StringUtil;

public class SendParcelSendAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(SendParcelSendAction.class);
	 /**
	  * 注入对象
	  */
	ISendParcelSendSerice sendParcelSendService;
	
	
	public void setSendParcelSendService(ISendParcelSendSerice sendParcelSendService) {
		this.sendParcelSendService = sendParcelSendService;
	}
	
	
	/**
	 * 处理寄快递增删改查请求！寄快递的全部接口
	 */
	public void savaCheckSend(){
		//设置返回结果
		String res =ConstantClassField.RETURNVALUEFAIL;
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers","Origin, No-Cache, X-Requested-With," +
					" If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//读出数据
		    BufferedReader bufferedReader  = ServletActionContext.getRequest().getReader();
			//接收数据
		    String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bufferedReader);
			
			logger.info("ProcScoringAction_savaPassCheck"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				logger.debug("开始处理页面需求");
				 res = sendParcelSendService.getNeedManage(str);
				 logger.debug("流程完成");
			}else{
				res = ConstantClassField.RETURNVALUENULL;
			}
		    logger.info("ProcScoringAction_savaPassCheck"+res);	
		}catch(Exception e){
			logger.debug("服务器异常", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
		
	}
    
}
