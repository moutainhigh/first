package com.deppon.montal.module.workitems.service;

import com.deppon.wfs.workflow.domain.OperationMessage;

public interface IOperationLogService {
	/**
	 * 
	* @MethodName: operationLog 
	* @description : 记录操作
	* @author：何玲菠 
	* @date： 2014-2-19 上午9:46:39
	* @param message
	* @return boolean
	 */
	boolean operationLog(OperationMessage message);
}
