package com.deppon.dpm.module.wfs.server.dao;

import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;

/**
 * 工作流详情页
 * @author 276344
 *
 */

public interface IWorkflowPageDao {
	/**
	 * 查询不同类型对应的跳转页面信息
	 * @return
	 */
	public List<WorkflowPageInfo> pageInfo();
	/**
	 * 获取所有工作流
	 */
	public HashMap<String, List<WorkflowPageInfo>> allWorkflow();
}
