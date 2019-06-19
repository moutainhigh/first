package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.IWorkflowPageDao;
import com.deppon.dpm.module.wfs.server.service.IWorkflowPageService;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;

public class WorkflowPageService implements IWorkflowPageService {
	/**
	 * set inject
	 */
	private IWorkflowPageDao workflowDao;
	
	@Override
	public List<WorkflowPageInfo> pageInfomation() {
		
		return workflowDao.pageInfo();
	}
	//获取所有工作流 + 分类
	@Override
	public HashMap<String, List<WorkflowPageInfo>> allWorkflowList() {
		return workflowDao.allWorkflow();
	}
	/**
	 * get
	 * @return
	 */
	public IWorkflowPageDao getWorkflowDao() {
		return workflowDao;
	}
	/**
	 * set
	 * @param workflowDao
	 */
	public void setWorkflowDao(IWorkflowPageDao workflowDao) {
		this.workflowDao = workflowDao;
	}


}
