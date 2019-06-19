package com.deppon.dmp.module.sdk.server.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.deppon.dmp.module.sdk.server.service.IUserService;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;

public class UserAction extends BaseAction {
	
	private static final long serialVersionUID = 6095549313710059931L;
	
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	private String sysCode;

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	@JSON
	public String queryAllUser() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<String> userIdList = userService.queryAllUser(sysCode);
		Result<List<String>> res = new Result<List<String>>();
		res.setData(userIdList);
		res.setErrorCode(Constants.SUCCESS);
		writeToPage(response, res);
		return null;
	}
	
}
