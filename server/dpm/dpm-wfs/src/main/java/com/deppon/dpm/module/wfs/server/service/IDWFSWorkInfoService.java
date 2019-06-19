package com.deppon.dpm.module.wfs.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.wfs.shared.domain.DepEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmpEntity;


public interface IDWFSWorkInfoService {
	/**
	 * 申报部门查询
	 */
	public String departmentQeury(Map<String, String> departmentmap );
	//public String disposeQuery(String busino,String processDefName,String processInstId);
	public String disposeQuery(String json);
	public String approval(String mobileWorkApprovalInfo);
	public List<DepEntity> getDepList(String text);
	//合同部门查询
	public List<EmpEntity> getEmpList(String emp);
	/**
	 * @param 产品线查询
	 * @return 
	 */
	public String getSystemList(String systemName,String pid) ;
}
