package com.deppon.dpm.module.wfs.server.service;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.httpclient.HttpException;

public interface INetWorkPlanService {

	/**
	 * 查询工作流信息
	 * 
	 * @param paramMap
	 *            网点规划系统的接口参数
	 * @return
	 */
	public String queryNetWorkPlanInfo (String jsonStr) throws HttpException, IOException ;
	
	/**
	 * 审批工作流
	 * @return
	 * @throws Exception
	 */
	public String approve(String jsonStr) throws HttpException, IOException;
	
	/**
	 * 
	 */
	public String departmentQeury(HashMap<String, Object> departmentmap )throws HttpException, IOException;
}
