package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcCheckScoreService;
import com.deppon.dpm.module.management.shared.domain.ConstantClassField;
import com.deppon.foss.framework.shared.util.string.StringUtil;

public class ProcCheckScoreAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	private	Logger logger=LoggerFactory.getLogger(ProcCheckScoreAction.class);
	/**
	 * 对象注入
	 */
	IProcCheckScoreService procCheckScoreService;
	/**
	 * 对象注入
	 */
	public void setProcCheckScoreService(
			IProcCheckScoreService procCheckScoreService) {
		this.procCheckScoreService = procCheckScoreService;
	}

	/**
	 * 保存合格
	 */
	public void savaPassCheck(){
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
				 res = procCheckScoreService.savaPassCheck(str);
				 logger.debug("流程完成");
			}else{
				res = ConstantClassField.RETURNVALUENULL;
			}
		    logger.info("ProcScoringAction_savaPassCheck"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
		
	}

   /**
    * 初次保存修改状态
    */
	public void updateCheckRecordAll(){
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
//		    String  str =  "{ \"addressCode\": \"XY0023\",\"userNo\": \"296487\"}";
			logger.info("updateCheckRecordAll"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = procCheckScoreService.updateCheckRecordAll(str);
				 logger.debug("流程完成");
			}else{
				res = ConstantClassField.RETURNVALUENULL;
			}
		    logger.info("updateCheckRecordAll"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
		
	}
	/**
	 * 工程验收详情数据拉取的一个数据拉取
	 */
	public void getProcCheckStandard(){
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
//			 String  str = "{\"navCode\": \"YSBW0001-1\", \"addressCode\": \"SDAS6466\", \"submitNub\": \"0\",\"origItemCode\": \"YSSX0001-54\"}";	

			logger.info("getProcCheckStandard"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = procCheckScoreService.getProcCheckStandard(str);
				 logger.debug("流程完成");
			}else{
				res = ConstantClassField.RETURNVALUENULL;
			}
		    logger.info("getProcCheckStandard"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
	}
	
	/**
	 * 工程验收访问量的数据监控
	 */
	public void getProcCheckControl(){
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
//			//接收数据
		    String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bufferedReader);
//			 String str =  "{ \"type\": 30,\"userId\": \"296487\"}";	

			logger.info("getProcCheckStandard"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = procCheckScoreService.savaCheckControl(str);
				 logger.debug("流程完成");
			}else{
				res = ConstantClassField.RETURNVALUENULL;
			}
		    logger.info("getProcCheckStandard"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
	}
	


}
