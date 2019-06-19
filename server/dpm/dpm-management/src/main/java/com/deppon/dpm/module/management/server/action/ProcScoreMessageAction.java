package com.deppon.dpm.module.management.server.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IProcScoreMessageService;
import com.deppon.dpm.module.management.server.service.IProcUserScoreAndAddressService;

/**
 * 根据id查找评分详细的Action层
 * @author 曹嵩
 * @date 2015.7.17
 */
public class ProcScoreMessageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProcScoreMessageAction.class);
	
	// procScoreMessageService 注入
	private IProcScoreMessageService procScoreMessageService;
	//procUserScoreAndAddressService 注入
	private IProcUserScoreAndAddressService procUserScoreAndAddressService;
	
	/**
	 * 页面传过来的用户工号
	 */
	private String userNo;
	
	/**
	 * 页面传过来的部门地址
	 */
	private String proAdress;
	
	/**
	 * 页面传过来的id
	 */
	private String userScoreid;
    //get set
	public IProcScoreMessageService getProcScoreMessageService() {
		return procScoreMessageService;
	}
	 //get set
	public void setProcScoreMessageService(
			IProcScoreMessageService procScoreMessageService) {
		this.procScoreMessageService = procScoreMessageService;
	}
	 //get set
	public IProcUserScoreAndAddressService getProcUserScoreAndAddressService() {
		return procUserScoreAndAddressService;
	}

	public void setProcUserScoreAndAddressService(
			IProcUserScoreAndAddressService procUserScoreAndAddressService) {
		this.procUserScoreAndAddressService = procUserScoreAndAddressService;
	}

	public String getUserScoreid() {
		return userScoreid;
	}

	public void setUserScoreid(String userScoreid) {
		this.userScoreid = userScoreid;
	}
	 //get set
	public String getUserNo() {
		return userNo;
	}
	 //get set
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getProAdress() {
		return proAdress;
	}
	 //get set
	public void setProAdress(String proAdress) {
		this.proAdress = proAdress;
	}

	public void queryprocScoreMess(){
		logger.info(">>>>>>>>进入procScoreMessageAction的queryprocScoreMess方法");
		// 设置页面响应实体 // 设置页面响应实体
				String res = "";
				HttpServletResponse response = ServletActionContext.getResponse();

				response.setHeader("Access-Control-Allow-Origin", "*");
				response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
				response.addHeader(
						"Access-Control-Allow-Headers",
						"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
				try {
					//根据id查找评分详细信息
					List<Object> psmeList = procScoreMessageService.queryprocScoreMess(userScoreid);
					//转json
					res = JsonUtil.beanToJsonString(psmeList);
					logger.info(">>>>queryprocScoreMess方法显示成功"+res);
					
				} catch (Exception e) {
					logger.info(">>>>queryprocScoreMess异常"+res);
					e.printStackTrace();
				}
				//写入数据
				writeToPage(response, res);
	}
	
	
	/**
	 * 组装所有0分项显示信息.
	 */
	public void getProcUserScoreAndAddressInfo(){
		logger.info(">>>>>>>>进入procScoreMessageAction的getProcUserScoreAndAddressInfo方法");
		
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//得到 所有0分项显示信息.
			res = JsonUtil.beanToJsonString(procUserScoreAndAddressService.getProcUserScoreAndAddressInfo(userNo.trim(), proAdress.trim()));
			logger.info(">>>>getProcUserScoreAndAddressInfo方法显示成功"+res);
			
		} catch (Exception e) {
			logger.info(">>>>getProcUserScoreAndAddressInfo异常"+res);
			e.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}

}
