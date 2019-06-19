package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;

import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.management.server.service.IItTerminalInformationService;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 终端信息service实现层
 * 
 * @date 2015-09-23
 * @author 231586
 * 
 */
public class ItTerminalInformationService implements
		IItTerminalInformationService {
	/**
	 * set注入it终端查询地址
	 */
	private String itQueryUrl;
	/**
	 * set注入it终端处理地址
	 */
	private String itDealUrl;
	/**
	 * set注入it终端退回处理地址
	 */
	private String itBackDealUrl;
	/**
	 * set注入it终端事件类型处理地址
	 */
	private String itFaultUrl;

	@Override
	public String getItInfo(String jsonParam) throws BusinessException, IOException {
		// http请求获取终端信息数据
		return HttpUtil.postHttp(itQueryUrl, jsonParam, "utf-8");
	}

	@Override
	public String getItDealInfo(String jsonString) throws BusinessException, IOException {
		// http请求获取终端处理结果数据
		return HttpUtil.postHttp(itDealUrl, jsonString, "utf-8");
	}

	@Override
	public String getItBackDealInfo(String jsonString) throws BusinessException, IOException {
		// http请求获取终端处理结果数据
		return HttpUtil.postHttp(itBackDealUrl, jsonString, "utf-8");
	}

	@Override
	public String getItEventInfo(String jsonString) throws BusinessException, IOException {
		// http请求获取终端处理结果数据
		return HttpUtil.postHttp(itFaultUrl, jsonString, "utf-8");
	}

	/**
	 * set注入
	 * 
	 * @param itQueryUrl
	 */
	public void setItQueryUrl(String itQueryUrl) {
		this.itQueryUrl = itQueryUrl;
	}

	/**
	 * set注入
	 * 
	 * @param itDealUrl
	 */
	public void setItDealUrl(String itDealUrl) {
		this.itDealUrl = itDealUrl;
	}

	/**
	 * set注入
	 * 
	 * @param itFaultUrl
	 */
	public void setItFaultUrl(String itFaultUrl) {
		this.itFaultUrl = itFaultUrl;
	}

	/**
	 * set注入
	 * 
	 * @param itFaultUrl
	 */
	public void setItBackDealUrl(String itBackDealUrl) {
		this.itBackDealUrl = itBackDealUrl;
	}

}
