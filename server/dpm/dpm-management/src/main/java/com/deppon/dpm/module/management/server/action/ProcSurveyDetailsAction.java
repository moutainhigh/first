package com.deppon.dpm.module.management.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.IProcSurveyDetailsService;
import com.deppon.dpm.module.management.server.service.impl.ProcSurveyDetailsService;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 工程勘测查询任务详情action
 * 
 */
public class ProcSurveyDetailsAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * service接口
	 */
	private IProcSurveyDetailsService procSurveyDetailsService;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProcSurveyDetailsService.class);

	/**
	 * 勘测部位code
	 */
	private String partCode;
	/**
	 * checkId
	 */
	private String checkId;

	/**
	 * 得到勘测任务详情接口
	 */
	public void getProcDeatils() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = "{\"resultFlag\":false,\"failureReason\":\"工程勘测得到详情数据有误！！\"}";
		try {

			logger.info("工程勘测<<<<<<<<<<<<<<<partCode" + partCode);
			// 判断参数是否为null
			if (!StringUtil.isEmpty(partCode)) {
				// 得到勘测详情数据
				res = this.procSurveyDetailsService.getProcDeatils(partCode , checkId);
			}

		} catch (Exception e) {
			res = "{\"resultFlag\":false,\"failureReason\":\"工程勘测得到详情数据有误！！\"}";
			logger.info("工程勘测出现错误<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		// 写入数据
		writeToPage(response, res);
	}
   
	/**
	 * 得到综合的详细数据
	 */
	public void getPhotoDetail() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = "{\"resultFlag\":false,\"failureReason\":\"工程勘测得到详情数据有误！！\"}";
		try {

			logger.info("工程勘测<<<<<<<<<<<<<<<checkId" + checkId);
			// 判断参数是否为null
			if (!StringUtil.isEmpty(checkId)) {
				// 得到勘测详情数据
				res = this.procSurveyDetailsService.getPhotoDetail(checkId);
			}

		} catch (Exception e) {
			res = "{\"resultFlag\":false,\"failureReason\":\"综合数据有误！！\"}";
			logger.info("工程勘测出现错误<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		// 写入数据
		writeToPage(response, res);
	}
	

	/**
	 * @return 勘测部位code
	 */
	public String getPartCode() {
		return partCode;
	}

	/**
	 * @param partCode
	 *            勘测部位code
	 */
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public void setProcSurveyDetailsService(
			IProcSurveyDetailsService procSurveyDetailsService) {
		this.procSurveyDetailsService = procSurveyDetailsService;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

}
