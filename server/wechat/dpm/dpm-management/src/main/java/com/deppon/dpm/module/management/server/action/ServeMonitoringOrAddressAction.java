package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IServeMonitoringOrAddressService;

/**
 * 监控与地址查询
 * 谢贻东
 * @author 274858
 *
 */
public class ServeMonitoringOrAddressAction extends BaseAction{

	/**
	 * 版本号
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志
	 * 
	 * 
	 */
	Logger log = LoggerFactory.getLogger(ServeMonitoringOrAddressAction.class);
    /*
     * 服务层
     * 
     * 
     */
	private IServeMonitoringOrAddressService serveMonitoringOrAddressService;
	public void setServeMonitoringOrAddressService(
			IServeMonitoringOrAddressService serveMonitoringOrAddressService) {
		this.serveMonitoringOrAddressService = serveMonitoringOrAddressService;
	}
	/**
	 * <p>Description:查询省市地址详细列表
	 * 
	 * 
	 * </p>
	 */
	public void queryAddressNationwide(){
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
			//BufferedReader bu = ServletActionContext.getRequest().getReader();
			//String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("ServeMonitoringOrAddressService_queryAddressNationwide()");
			//if(str !=null && !"".equals(str)){
			res = serveMonitoringOrAddressService.queryAddressNationwide();
			//}else{
			//	res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			//}
		    log.info("ServeMonitoringOrAddressService_queryAddressNationwide()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
	}
	

	/**
	 *  数据监控
	 *  
	 *  
	 *  
	 */
	public void saveMonitoring(){
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
			log.info("serveMonitoringOrAddressService——saveMonitoring()"+str);
			if(str !=null && !"".equals(str)){
				res = serveMonitoringOrAddressService.saveMonitoring(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("serveMonitoringOrAddressService——saveMonitoring()"+res);	
		}catch(Exception e){
			log.debug("系统异常，保存信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
	}
	/**
	 * <p>Description:拼车小红点
	 * 
	 * 
	 * </p>
	 */
	public void queryServeTask(){
		String res = "{\"count\":0,\"errorCode\":1}";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = null; 
		try{
			String userNo = request.getParameter("userNo");
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//BufferedReader bu = ServletActionContext.getRequest().getReader();
			//String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("ServeMonitoringOrAddressService_queryServeTask()");
			
			//if(str !=null && !"".equals(str)){
			
			res = serveMonitoringOrAddressService.queryServeTask(userNo);
			/*}else{
			
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}*/
		    log.info("ServeMonitoringOrAddressService_queryAddressNationwide()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
	}
	/**
	 * <p>
	 * Description:勘测小红点
	 * 
	 * 
	 * </p>
	 */
	public void queryProcTask(){
		String res = "{\"resultFlag\":0,\"failureReason\":\"获取信息失败！\"}";
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
			log.info("ServeMonitoringOrAddressService_queryProcTask()");
			if(str !=null && !"".equals(str)){
			
				res = serveMonitoringOrAddressService.queryProcTask(str);
			}else{
				
				res = "{\"resultFlag\":0,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("ServeMonitoringOrAddressService_queryAddressNationwide()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
	}
}
