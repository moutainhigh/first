package com.deppon.dpm.module.management.server.service;

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
	 * @throws Exception
	 */
	public String getItInfo(String jsonParam) throws Exception;

	/**
	 * 终端信息处理
	 * 
	 * @param jsonString
	 * @return
	 * @throws Exception
	 */
	public String getItDealInfo(String jsonString) throws Exception;
	
	/**
	 * 终端信息回退处理
	 * 
	 * @param jsonString
	 * @return
	 * @throws Exception
	 */
	public String getItBackDealInfo(String jsonString) throws Exception;

	/**
	 * 获取终端事件类型信息
	 * 
	 * @param jsonString
	 * @return
	 * @throws Exception
	 */
	public String getItEventInfo(String jsonString) throws Exception;

}
