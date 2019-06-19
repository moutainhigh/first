package com.deppon.dpm.module.wfs.server.service;

import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;
/**
 * 工作流详情页面
 * @author 276344
 *
 */
public interface IWorkflowPageService {
	/**
	 * 工作流详情页面
	 * @return
	 */
	public List<WorkflowPageInfo> pageInfomation();
	/**
	 * 获取所有工作流 按系统分类
	 */
	public HashMap<String, List<WorkflowPageInfo>> allWorkflowList();
}
