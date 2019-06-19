package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcMaintainRightControlService;

/**
 * @author 274858
 *
 */
public class ProcMaintainRightControlAction extends BaseAction{

	
	/**
	 * 版本号
	 */	
	private static final long serialVersionUID = 1115552180311922331L;
	
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcMaintainRightControlAction.class);
	/*
	 * 服务层变量
	 */
	private IProcMaintainRightControlService procMaintainRightControlService;
	
	//get set
	public void setProcMaintainRightControlService(
			IProcMaintainRightControlService procMaintainRightControlService) {
		this.procMaintainRightControlService = procMaintainRightControlService;
	}


	/**
	 * <p>Description:权限控制</p>
	 */
	public void checkRightControl(){
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
			//得到数据
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转换数据
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("ProcMaintainRightControlAction_checkRightControl()"+str);
			//对参数进行非空判断a
			if(str !=null && !"".equals(str)){
				//得到结果集
				res = procMaintainRightControlService.checkRightControl(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("ProcMaintainRightControlAction_checkRightControl()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	
	
}
