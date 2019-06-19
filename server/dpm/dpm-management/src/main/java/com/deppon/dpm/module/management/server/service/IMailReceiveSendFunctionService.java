package com.deppon.dpm.module.management.server.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 274858
 *
 */
public interface IMailReceiveSendFunctionService {

	/**
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String updateRecInfo(String str) throws BusinessException, HttpException, IOException; 
	
	
}
