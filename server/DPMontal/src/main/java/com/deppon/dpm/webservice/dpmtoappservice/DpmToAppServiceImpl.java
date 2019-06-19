package com.deppon.dpm.webservice.dpmtoappservice;

import javax.xml.ws.Holder;

import com.deppon.dpm.webservice.domain.QueryWorkflowItemsRequest;
import com.deppon.dpm.webservice.domain.QueryWorkflowItemsResponse;
import com.deppon.esb.header.ESBHeader;
import com.deppon.montal.login.service.UserLoginService;

public class DpmToAppServiceImpl implements DpmToAppService {
	
	public UserLoginService userLoginService = new UserLoginService();
	public QueryWorkflowItemsResponse response = new QueryWorkflowItemsResponse();

	@Override
	public QueryWorkflowItemsResponse queryWorkflowItems(
			QueryWorkflowItemsRequest request, Holder<ESBHeader> esbHeader)
			throws CommException {
		
		if(request == null) {
			response.setIsSucess(false);
			response.setFailReason("客户端请求参数为空，请排查！");
			
		}else {
			int count = Integer.parseInt(userLoginService.getWorkFlowCountByUserId(request.getUserNo(), ""));
			response.setWorkflowItems(count);
			response.setIsSucess(true);
		}
		return response;
	}

}
