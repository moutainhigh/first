package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcScoringService;
import com.deppon.foss.framework.shared.util.string.StringUtil;


/**
 * 保存得分
 * 保存损坏原因
 * @author 袁中华
 * @date 2015.07.14
 */

public class ProcScoringAction extends BaseAction {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 值为空
	 */
	private final static String RETURNVALUENULL="{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}";
	
	/**
	 * 保存失败
	 */
	private final static String RETURNVALUEFAIL="{\"resultFlag\":false,\"failureReason\":\"失败！\"}";
	/**
	 * 日志
	 */
	private	Logger logger=LoggerFactory.getLogger(ProcScoringAction.class);
	 /**
	  * 注入
	  */
	private	IProcScoringService engScoringService;
	
	
	public void setEngScoringService(IProcScoringService engScoringService) {
		this.engScoringService = engScoringService;
	}
    /**
     * 5分保存
     */
	public void savaRcoring(){
		//设置返回结果
		String res = RETURNVALUEFAIL;
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
			logger.info("ProcScoringAction_savaRcoring()"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = engScoringService.savaScoring(str);
				 logger.debug("流程完成");
			}else{
				res = RETURNVALUENULL;
			}
		    logger.info("ProcScoringAction_savaRcoring()"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
		
	}
    /**
      * 0分保存
      */
	public void savaMessageReason(){
		//设置返回结果
		String res = RETURNVALUEFAIL;
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
		
			logger.info("ProcScoringAction_savaMessageReason()"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = engScoringService.savaMessageReason(str);
				 logger.debug("流程完成");
			}else{
				res = RETURNVALUENULL;
			}
		    logger.info("ProcScoringAction_savaMessageReason()"+res);	
		}catch(Exception e){
			logger.debug("保存信息失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		writeToPage(response, res);
		
	}
	/**
	 * 部门营业部数量数据监控
	 */
	public void savaProcWatchDept(){
		//设置返回结果
		String res = RETURNVALUEFAIL;
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers","Origin, No-Cache, X-Requested-With," +
					" If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
//			//读出数据
			BufferedReader bufferedReader  = ServletActionContext.getRequest().getReader();
//			//接收数据
//		
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bufferedReader);	
			
//			String  str = "{ \"deptcode\": \"ABC123456\", \"deptname\": \"徐泾东\"}";
			logger.info("ProcScoringAction_savaMessageReason()"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = engScoringService.savaProcWatchDept(str);
				 logger.info("流程完成");
			}else{
				res = RETURNVALUENULL;
				
			}
		    logger.info("ProcScoringAction_savaMessageReason()"+res);	
		}catch(Exception e){
			logger.debug("监控失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		logger.info("监控成立");
		writeToPage(response, res);
		
	}
      /**
       * 对部门数量不合格的数据监控
       */
	public void savaProcWatchProject(){
		//设置返回结果
		String res = RETURNVALUEFAIL;
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
////		
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bufferedReader);	
			//String  str ="[{ \"procode\": \"BBB123456\", \"proname\": \"天安\", \"pronum\": 5, \"procount\": 20 },{\"procode\": \"AAA123456\",\"proname\": \"A天安\", \"pronum\": 50,\"procount\": 20},{\"procode\": \"CCC123456\",\"proname\": \"C天安\",\"pronum\": 500,\"procount\": 20}]";

			logger.info("ProcScoringAction_savaMessageReason()"+str);
			//判断
			if(StringUtil.isNotEmpty(str)){
			     //调用方法
				 res = engScoringService.savaProcWatchProject(str);
				 logger.info("流程完成");
			}else{
				res = RETURNVALUENULL;
				
			}
		    logger.info("ProcScoringAction_savaMessageReason()"+res);	
		}catch(Exception e){
			logger.debug("监控失败", e);
			e.printStackTrace();
		}
         //	把处理结构返回页面
		logger.info("监控成立");
		writeToPage(response, res);
		
	}

}
