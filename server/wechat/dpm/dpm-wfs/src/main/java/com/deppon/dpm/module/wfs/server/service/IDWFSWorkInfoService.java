package com.deppon.dpm.module.wfs.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.wfs.shared.domain.DepEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmpEntity;


public interface IDWFSWorkInfoService {
	/**
	 * 申报部门查询
	 */
	public String departmentQeury(Map<String, String> departmentmap )throws Exception;
	//public String disposeQuery(String busino,String processDefName,String processInstId)throws Exception;
	public String disposeQuery(String json)throws Exception;
	public String approval(String mobileWorkApprovalInfo)throws Exception;
	public List<DepEntity> getDepList(String text)throws Exception;
	//合同部门查询
	public List<EmpEntity> getEmpList(String emp)throws Exception;
	/**
	 * @param 产品线查询
	 * @return 
	 */
	public String getSystemList(String systemName,String pid) throws Exception;
}
