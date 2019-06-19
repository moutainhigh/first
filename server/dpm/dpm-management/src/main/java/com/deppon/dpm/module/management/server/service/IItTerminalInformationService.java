package com.deppon.dpm.module.management.server.service;

import java.io.IOException;

import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.service.IService;

/**
 * IT终端service层
 * 
 * @date 2015-09-23
 * @author 231586
 * 
 */
public interface IItTerminalInformationService extends IService {

	/**
	 * 获取终端信息
	 * 
	 * @param jsonParam
	 * @return
	 * @throws BusinessException
	 */
	public String getItInfo(String jsonParam) throws BusinessException, IOException;

	/**
	 * 终端信息处理
	 * 
	 * @param jsonString
	 * @return
	 * @throws BusinessException
	 */
	public String getItDealInfo(String jsonString) throws BusinessException, IOException;
	
	/**
	 * 终端信息回退处理
	 * 
	 * @param jsonString
	 * @return
	 * @throws BusinessException
	 */
	public String getItBackDealInfo(String jsonString) throws BusinessException, IOException;

	/**
	 * 获取终端事件类型信息
	 * 
	 * @param jsonString
	 * @return
	 * @throws BusinessException
	 */
	public String getItEventInfo(String jsonString) throws BusinessException, IOException;

}
