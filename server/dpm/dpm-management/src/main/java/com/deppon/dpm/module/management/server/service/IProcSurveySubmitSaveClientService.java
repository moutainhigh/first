package com.deppon.dpm.module.management.server.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 274858
 *
 */
public interface IProcSurveySubmitSaveClientService {

	/**
	 * 数据保存
	 * @param str
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public String saveBaseDate(String str) throws BusinessException, HttpException, IOException;
}
