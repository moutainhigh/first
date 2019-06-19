package com.deppon.dmp.module.sdk.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;

public class WsAction extends BaseAction {

	private static final long serialVersionUID = -3113176403726825453L;
	
//	private DpmToAppService oaService;
	private IWorkItemsListService workItemsListService;
//	public void setOaService(DpmToAppService oaService) {
//		this.oaService = oaService;
//	}
	
	public void setWorkItemsListService(IWorkItemsListService workItemsListService) {
		this.workItemsListService = workItemsListService;
	}

	private String userId;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JSON
	public String queryWorkflowItems() {
		HttpServletResponse response = ServletActionContext.getResponse();
//		QueryWorkflowItemsRequest request = new QueryWorkflowItemsRequest();
//		request.setUserNo(userId);
//		ESBHeader header = new ESBHeader(); 
//		header.setVersion("1.0");
//		header.setBusinessId(request.getUserNo());
//		header.setRequestId(UUID.randomUUID().toString());
//		header.setSourceSystem("WFS");
//		header.setEsbServiceCode("ESB_WFS2ESB_PUSH_BACKLOG");
//		header.setMessageFormat("SOAP");
//		header.setExchangePattern(1);
//		Holder<ESBHeader> holder	= new Holder<ESBHeader>();
//		holder.value = header;
		Result<Integer> res = new Result<Integer>();
		try {
//			QueryWorkflowItemsResponse temp = oaService.queryWorkflowItems(request, holder);
			int count = workItemsListService.queryWorkflowItems(userId);
			res.setData(count);
			res.setErrorCode(Constants.SUCCESS);
		} catch (Exception e) {
			res.setErrorMessage("获取信息失败！");
			res.setErrorCode(Constants.SERVICE_ERROR);
		}
		writeToPage(response, res);
		return null;
	}

}
