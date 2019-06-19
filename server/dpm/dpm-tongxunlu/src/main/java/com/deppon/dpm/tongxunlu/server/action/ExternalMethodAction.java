package com.deppon.dpm.tongxunlu.server.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;


public class ExternalMethodAction extends BaseAction{
	
    private static Logger logger  = LoggerFactory.getLogger(ExternalMethodAction.class);
    
    private List<String> moblist;
	
	private IExternalMethodService externalMethodService;
	
	/**
	 * 根据手机号获取工号(无人车)
	 */
	@CookieNotCheckedRequired
	public void getEmpcodebyTel(){
		this.solveCrossDomain();
		//结果集
		Result<List<String>> result = new Result<List<String>>();
		List<String> emplist = new ArrayList<String>();
		try {
			emplist = externalMethodService.getEmpcodebyTel(moblist);
			System.out.println(emplist);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("根据手机号获取工号异常:" + e);
			e.printStackTrace();
			logger.error("根据手机号获取工号异常:" + e.toString());
		}
		// data
		result.setData(emplist);
		// 返回
		writeToPage(result);
		
	}
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public List<String> getMoblist() {
		return moblist;
	}

	public void setMoblist(List<String> moblist) {
		this.moblist = moblist;
	}

	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	public void setExternalMethodService(IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}

}
