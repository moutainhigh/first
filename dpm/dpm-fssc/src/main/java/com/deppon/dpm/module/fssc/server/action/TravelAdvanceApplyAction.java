package com.deppon.dpm.module.fssc.server.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.fssc.server.service.ITravelAdvanceApplyService;

/**
 * @author 268101、
 * 
 *TravelAdvanceApplyAction
 */
public class TravelAdvanceApplyAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(TravelAdvanceApplyAction.class);

	/**
	 * service接口
	 */
	private ITravelAdvanceApplyService travelAdvanceApplyService;

	/**
	 * @return service接口
	 */
	public ITravelAdvanceApplyService getTravelAdvanceApplyService() {
		return travelAdvanceApplyService;
	}

	/**
	 * @param travelAdvanceApplyService
	 *            service接口
	 */
	public void setTravelAdvanceApplyService(
			ITravelAdvanceApplyService travelAdvanceApplyService) {
		this.travelAdvanceApplyService = travelAdvanceApplyService;
	}

	/**
	 * 事前申请单单点登录
	 */
	public void queryTravelAdvanceApply() {
		// 日志
		logger.info("TravelAdvanceApplyAction>>>>>>>>>"+userId+"进入事前申请单单点登录");
		String rs = "";
		HttpServletRequest requst = ServletActionContext.getRequest();
		// 设置页面响应实体
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 返回参数
		if ("POST".equals(requst.getMethod())) {
			try {
				// 返回参数
				rs = travelAdvanceApplyService.queryTravelAdvanceApply();
			} catch (Exception ce) {
				// 抛出异常
				logger.error("TravelAdvanceApplyAction>>>>>>>>>"+userId+"进入事前申请单单点登录异常",ce);
			}
		}
		// 写入数据
		writeToPage(response, rs);
	}

}
