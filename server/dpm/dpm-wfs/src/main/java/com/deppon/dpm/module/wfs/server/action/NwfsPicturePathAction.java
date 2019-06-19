package com.deppon.dpm.module.wfs.server.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.service.INwfsPicpathService;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
/**
 * 根据工号数组 获取头像地址
 * @author 276344
 *
 */

public class NwfsPicturePathAction extends BaseAction{
	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(NwfsPicturePathAction.class);
	private static final long serialVersionUID = 1L;
	/**
	 * service
	 */
	private INwfsPicpathService picService;
	//接收前端传来的工号  格式："11111,22222,34444"
	private String empCodeList;
	

	//根据工号数组获取头像地址数组
	@CookieNotCheckedRequired
	public void picPath() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		
		//工号字符串转数组
		String[] arr = empCodeList.split(",");
		//数组转List
		List<String> userIDs = java.util.Arrays.asList(arr);
		//结果集
		Result<List<NwfsPicPathEntity>> result = new Result<List<NwfsPicPathEntity>>();
		
		List<NwfsPicPathEntity> entitys = new ArrayList<NwfsPicPathEntity>();
		try {
			entitys = picService.picturePaths(userIDs);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			logger.error("工号：" + userId +" 获取头像地址请求出错 reason:" + e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(entitys.size());
		// data
		result.setData(entitys);
		// 返回给前端
		writeToPage(result);
		
	}
	
	/**
	 * set
	 * @param picService
	 */
	public void setPicService(INwfsPicpathService picService) {
		this.picService = picService;
	}
	/**
	 * set
	 * @param empCodeList
	 */
	public void setEmpCodeList(String empCodeList) {
		this.empCodeList = empCodeList;
	}

	@Override
	public String toString() {
		return "NwfsPicturePathAction [picService=" + picService
				+ ", empCodeList=" + empCodeList + "]";
	}
	
}
