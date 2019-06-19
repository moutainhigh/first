package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.ILoginInfoService;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;

public class LoginInfoPcAction extends BaseAction{
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginInfoPcAction.class);
	
	// 注入service
	private ILoginInfoService loginInfoService;
	
	/**
	 * 根据工号查询用户历史登录的设备信息
	 * @param empCode
	 */
	public void queryLoginInfoByEmpCode(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String empCode = request.getParameter("empCode");
			if(StringUtils.isEmpty(empCode)){
				return;
			}
			// 当前页
			int page = Integer.parseInt(request.getParameter("page"));
			// 每页条数
			int rows = Integer.parseInt(request.getParameter("rows"));
			int start = 0;
			if(page != 0) {
				start = (page -1) * rows;
			}
			
			// 查询
			List<EmpExtensionEntity> list = loginInfoService.queryAllLoginInfoByEmpCode(empCode,start,rows);
			// 总条数
			long count = loginInfoService.queryCountByEmpCode(empCode);
			result.put("total", count);
			result.put("rows", list);
		} catch (Exception e) {
			LOG.error("分页查询用户历史登录的设备信息出错!!!",e);
		}
		
		// 列表数据
		writeToPage(result);
	}

	/**
	 * setter
	 * @param loginInfoService
	 */
	public void setLoginInfoService(ILoginInfoService loginInfoService) {
		this.loginInfoService = loginInfoService;
	}

}
