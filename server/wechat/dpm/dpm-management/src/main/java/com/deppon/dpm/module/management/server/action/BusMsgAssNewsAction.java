package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService;

/**
 * <!-- 异常信息的查询、新增，评价建议的回复、删除，开线建议统计、新增-->
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:xieyidong,date:2015-6-29 上午11:28:20,content:TODO </p>
 * @author xieyidong
 * @date 2015-6-29 上午11:28:20
 * @since
 * @version
 */

public class BusMsgAssNewsAction extends BaseAction{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusMsgAssNewsAction.class);
	/*
	 * service层
	 */
	public IBusMsgAssNewsService busMsgAssNewsService;
	//get set
	public void setBusMsgAssNewsService(IBusMsgAssNewsService busMsgAssNewsService) {
		this.busMsgAssNewsService = busMsgAssNewsService;
	}
	//get set
	public IBusMsgAssNewsService getBusMsgAssNewsService() {
		return busMsgAssNewsService;
	}

	/**
	 * <p>Description:获取消息表数据</p>
	 */
	public void getGustyMessage(){
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
			//获取数据
			res = busMsgAssNewsService.getGustyMessage();
			
			
		}catch(Exception e){
			//捕获异常
			logger.debug("获取信息失败", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	

	/**
	 * <p>保存消息表</p> 
	 * @author xieyidong
	 * @date 2015-6-29 下午1:49:29
	 * @see
	 */
	public void saveGustyMessage(){
		//设置变量
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
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
			logger.info("BusMsgAssNewsAction_saveGustyMessage()"+str);
			//判断数据是否非空
			if(!"".equals(str)){
				res = busMsgAssNewsService.saveGustyMessage(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_saveGustyMessage()"+res);	
		}catch(Exception e){
			//捕获异常
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	/**
	 * <p>点击量保存</p> 
	 * @author xieyidong
	 * @date 2015-6-30 上午10:11:36
	 * @see
	 */
	public void saveHits(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//数据的接收
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转为字符串
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_saveHits()"+str);
			//判断是否非空
			if(!"".equals(str)){
				res = busMsgAssNewsService.saveHits(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_saveSite()"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	/**
	 * <p>保存建议站点</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:46:17
	 * @see
	 */
	public void saveSite(){
		//设置变量
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//数据的接收
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转字符串
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_saveSite()"+str);
			//判断数据是否非空
			if(!"".equals(str)){
				res = busMsgAssNewsService.saveSite(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_saveSite()"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	/**
	 * <p>删除评价回复</p> 
	 * @author xieyidong
	 * @date 2015-7-1 下午6:58:09
	 * @see
	 */
	public void deleteReply(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"删除信息失败！\"}";
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
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_deleteReplySugg()"+str);
			if(!"".equals(str)){
				//删除评价回复结果集
				res = busMsgAssNewsService.deleteReply(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_deleteReplySugg()"+res);	
		}catch(Exception e){
			logger.debug("删除信息失败", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
	}
	
	
	/**
	 * <p>Description:保存建议评价回复</p>
	 */
	public void saveReply(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
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
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("BusMsgAssNewsAction_saveReply()"+str);
			if(!"".equals(str)){
				//保存建议评价回复
				res = busMsgAssNewsService.saveReply(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    logger.info("BusMsgAssNewsAction_saveReply()"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	
}
