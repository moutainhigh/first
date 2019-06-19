package com.deppon.dpm.module.wfs.server.action;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.service.IWorkflowPageService;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 获取移动端所有工作流列表
 *
 * @author 276344
 *
 */
public class NwfsAllWorkflowListAction extends BaseAction{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(NwfsAllWorkflowListAction.class);
	//工作流详情对应页面service
	private IWorkflowPageService pageService;
	@CookieNotCheckedRequired
	public void allWorkflows(){
		Result<HashMap<String, List<WorkflowPageInfo>>> result = new Result<HashMap<String, List<WorkflowPageInfo>>>();
		HashMap<String, List<WorkflowPageInfo>>  resultMap = new HashMap<String, List<WorkflowPageInfo>>();
		try {
			resultMap = pageService.allWorkflowList();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			//日志
			logger.error("------获取工作流待办列表失败-----"+e);
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(resultMap.size());
		// data
		result.setData(resultMap);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * set
	 * @param pageService
	 */
	public void setPageService(IWorkflowPageService pageService) {
		this.pageService = pageService;
	}
		
}
