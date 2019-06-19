package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IMailReceiveSendFunctionService;

/**
 * 收发室
 * @author 274858
 *
 */
public class MailReceiveSendFunctionAction extends BaseAction{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -6275104886054282743L;

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(MailReceiveSendFunctionAction.class);
    /*
     * 服务层
     */
	private IMailReceiveSendFunctionService mailReceiveSendFunctionService;
	//mailReceiveSendFunctionService get set
	public void setMailReceiveSendFunctionService(
			IMailReceiveSendFunctionService mailReceiveSendFunctionService) {
		this.mailReceiveSendFunctionService = mailReceiveSendFunctionService;
	}



	/**
	 * <p>Description:签收、拒收接口</p>
	 */
	public void updateRacState(){
		//设置变量
		String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//接收参数
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转为字符串
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("MailReceiveSendFunctionAction_updateRacState()"+str);
			//判断是否非空
			if(!"".equals(str)){
				res = mailReceiveSendFunctionService.updateRecInfo(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("MailReceiveSendFunctionAction_updateRacState()()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	
}
