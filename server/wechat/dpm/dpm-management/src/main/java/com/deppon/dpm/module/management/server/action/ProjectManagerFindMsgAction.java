package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService;

/**
* @ClassName: ProjectManagerFindMsgAction
* @Description: ProjectManagerFindMsgAction action
* @author A18ccms a18ccms_gmail_com
* @date 2016-4-8 上午10:17:10
* 
*/

public class ProjectManagerFindMsgAction extends BaseAction{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProjectManagerFindMsgAction.class);
	/**
	* @Fields projectManagerFindMsgService : 注入service
	*/
	private IProjectManagerFindMsgService projectManagerFindMsgService; 
	
	/** 
	* @Title: setProjectManagerFindMsgService 
	* @Description:get set
	* @param @param projectManagerFindMsgService    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setProjectManagerFindMsgService(
			IProjectManagerFindMsgService projectManagerFindMsgService) {
		this.projectManagerFindMsgService = projectManagerFindMsgService;
	}

	/**
	 * <p>Description:界面数据获取接口</p>
	 */
	public void getProjectMsg(){
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
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转为字符串
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_getProjectMsg()"+str);
			//判断非空
			if(!"".equals(str)){
				//得到结果集
				res = projectManagerFindMsgService.getProjectMsg(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_getProjectMsg()"+res);	
		}catch(Exception e){
			//捕获异常
			logger.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	/**
	 * <p>Description:查询历史记录</p>
	 */
	public void getSigHistoryInfo(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			//跨域表头
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//字符转换
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//字符转换
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_getAreaHistoryInfo()"+str);
			//判断非空
			if(!"".equals(str)){
				res = projectManagerFindMsgService.getSigHistoryInfo(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_getAreaHistoryInfo()"+res);	
		}catch(Exception e){
			logger.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	/**
	 * <p>Description:保存数据到PC端</p>
	 */
	public void setToPcRecord(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			//跨域表头
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//接收数据格式
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转换数据格式
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_setToPcRecord()"+str);
			//判断非空
			if(!"".equals(str)){
				res = projectManagerFindMsgService.setToPcRecord(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_setToPcRecord()"+res);	
		}catch(Exception e){
			logger.debug("系统异常，保存信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	/**
	 * <p>Description:提交校验</p>
	 */
	public void checkSubmit(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"提交信息失败！\",\"isSubmit\":false}";
		HttpServletResponse response = null; 
		try{
			//跨域表头
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//接收数据格式
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_checkSubmit()"+str);
			if(!"".equals(str)){
			    //数据结果集
				res = projectManagerFindMsgService.checkSubmit(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\",\"isSubmit\":false}";
			}
		    logger.info("BusMsgAssNewsAction_checkSubmit()"+res);	
		}catch(Exception e){
			//捕获异常
			logger.debug("系统异常，提交信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
}
