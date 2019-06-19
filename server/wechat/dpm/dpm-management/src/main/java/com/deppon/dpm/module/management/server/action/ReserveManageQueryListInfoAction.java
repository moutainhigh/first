package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService;

/**
 * @author 274858
 *
 */
public class ReserveManageQueryListInfoAction extends BaseAction{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -2849192525139150999L;
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ReserveManageQueryListInfoAction.class);
	//reserveManageQueryListInfoService的注入
	private IReserveManageQueryListInfoService reserveManageQueryListInfoService;
	
	
	/** 
	* @Title: getReserveManageQueryListInfoService 
	* @Description:service 的get set
	* @param @return    设定文件 
	* @return IReserveManageQueryListInfoService    返回类型 
	* @throws 
	*/ 
	
	public IReserveManageQueryListInfoService getReserveManageQueryListInfoService() {
		return reserveManageQueryListInfoService;
	}


	/** 
	* @Title: setReserveManageQueryListInfoService 
	* @Description: service 的get set
	* @param @param reserveManageQueryListInfoService    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setReserveManageQueryListInfoService(
			IReserveManageQueryListInfoService reserveManageQueryListInfoService) {
		this.reserveManageQueryListInfoService = reserveManageQueryListInfoService;
	}


	/**
	 * <p>Description:查询羽毛球瑜伽室详细列表</p>
	 */
	public void querySiteLeisureList(){
		String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			//接收数据的处理
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//接收页面传过来的数据
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//转为字符串
			String  str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			log.info("ReserveManageQueryListInfoAction_querySiteLeisureList()"+str);
			//判断是否非null
			if(str !=null && !"".equals(str)){
				//得到结果集
				res = reserveManageQueryListInfoService.querySiteLeisureList(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("ReserveManageQueryListInfoAction_querySiteLeisureList()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	/**
	 * <p>Description:查询管理员</p>
	 */
	public void queryAdmin(){
		//先设定结果
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询信息失败！\"}";
		HttpServletResponse response = null; 
		try{
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//得到管理员结果
			res = reserveManageQueryListInfoService.queryAdmin();
		
		    log.info("ReserveManageQueryListInfoAction_querySiteLeisureList()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	
	/**
	 *  保存管理员信息
	 */
	public void saveAdminInfo(){
		//先设定结果
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\",\"resTab\":0}";
		HttpServletResponse response = null; 
		try{
			//跨域的一个请求
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
			log.info("ReserveManageQueryListInfoAction_saveAdminInfo()"+str);
			//判断接收过来的参数是否非Null
			if(str !=null && !"".equals(str)){
				res = reserveManageQueryListInfoService.saveAdminInfo(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\",\"resTab\":1}";
			}
		    log.info("ReserveManageQueryListInfoAction_saveAdminInfo()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	/**
	 *  delete管理员信息
	 */
	public void deleteAdminInfo(){
		//设置参数
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
			log.info("ReserveManageQueryListInfoAction_saveAdminInfo()"+str);
			//判断非空
			if(str !=null && !"".equals(str)){
				//得到结果集
				res = reserveManageQueryListInfoService.deleteAdminInfo(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("ReserveManageQueryListInfoAction_saveAdminInfo()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
	/**
	 *  场地信息
	 */
	public void querySiteInfo(){
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
			log.info("ReserveManageQueryListInfoAction_querySiteInfo()"+str);
			if(str !=null && !"".equals(str)){
				res = reserveManageQueryListInfoService.querySiteInfo(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("ReserveManageQueryListInfoAction_querySiteInfo()"+res);	
		}catch(Exception e){
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);
	}
    /** 
    * @Title: querySiteDateList 
    * @Description: 具体房间的详细预定信息
    * @param     设定文件 
    * @return void    返回类型 
    * @throws 
    */ 
    
    public void querySiteDateList(){
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
			log.info("ReserveManageQueryListInfoAction_querySiteDateList()"+str);
			//判断接收过来的参数是否非空
			if(str !=null && !"".equals(str)){
				res = reserveManageQueryListInfoService.querySiteDateList(str);
			}else{
				res = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NUll！\"}";
			}
		    log.info("ReserveManageQueryListInfoAction_querySiteDateList()"+res);	
		}catch(Exception e){
			//捕获异常
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}

}
