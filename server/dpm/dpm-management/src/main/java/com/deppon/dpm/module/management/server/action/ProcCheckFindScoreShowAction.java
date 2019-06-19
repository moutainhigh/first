package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcCheckFindScoreShowService;

/**
 * 工程巡检
 * @author  谢贻东（274858)
 *
 */
public class ProcCheckFindScoreShowAction extends BaseAction{

	/**
	 * 版本号
	 */	
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcCheckFindScoreShowAction.class);
    /*
     * 服务层
     */
	private IProcCheckFindScoreShowService procCheckFindScoreShowService;
	public void setProcCheckFindScoreShowService(
			IProcCheckFindScoreShowService procCheckFindScoreShowService) {
		this.procCheckFindScoreShowService = procCheckFindScoreShowService;
	}

	/**
	 * 查询历史检查项的历史分数
	 */
	public void getHisScoreFind(){
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
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("BusMsgAssNewsAction_getHisScoreFind()"+str);
			if(!"".equals(str)){
				res = procCheckFindScoreShowService.getHisScoreFind(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("BusMsgAssNewsAction_getHisScoreFind()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
		
	}
	
	/**
	 * 统计扣分项和总分数
	 */
	public void getCountScore(){
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
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("BusMsgAssNewsAction_getCountScore()"+str);
			if(!"".equals(str)){
				res = procCheckFindScoreShowService.getCountScore(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("BusMsgAssNewsAction_getCountScore()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
		
	}
	/**
	 *检查项明细的显示
	 */
	public void getFindListView(){
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
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("BusMsgAssNewsAction_getFindListView()"+str);
			if(!"".equals(str)){
				res = procCheckFindScoreShowService.getFindListView(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("BusMsgAssNewsAction_getFindListView()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
		
	}

	/**
	 * 工程巡检扣分项
	 *//*
	public void setProcCheckSave(){
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
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("BusMsgAssNewsAction_setProcCheckSave()"+str);
			if(!"".equals(str)){
				res = procCheckFindScoreShowService.setProcCheckSave(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("BusMsgAssNewsAction_setProcCheckSave()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
		
	}
*/
}
