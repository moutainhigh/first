package com.deppon.montal.module.workitems.service;

import com.deppon.montal.module.workitems.dao.IOperationLogDao;
import com.deppon.montal.module.workitems.dao.OperationLogDaoImpl;
import com.deppon.wfs.workflow.domain.OperationMessage;

public class OperationLogServiceImpl implements IOperationLogService {
	/**
	 * 
	* @MethodName: operationLog 
	* @description : 记录操作
	* @author：何玲菠 
	* @date： 2014-2-19 上午9:46:39
	* @param message
	* @return boolean
	 */
	@Override
	public boolean operationLog(OperationMessage message) {
		IOperationLogDao dao = new OperationLogDaoImpl();
		return dao.operationLog(message);
	}
}
