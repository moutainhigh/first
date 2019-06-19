package com.deppon.dpm.module.wfs.server.service;

import java.util.Map;

import com.deppon.dpm.module.wfs.shared.domain.WorkflowBusinessData;
import com.deppon.dpm.module.wfs.shared.domain.dlsp.Auditparameters;
/**
 * 
 * 同步盘点资产信息 Interface
 **/
public interface IDLspWorkInfoService {
	public String departmentQeury(Map<String, String> departmentmap )throws Exception;
	public String queryWorkInfo(WorkflowBusinessData workflowInfo);
	public String approveWorkInfo(Object audit);
	//资产查询 2016-4-22
	public String assetsQeury(Object json);
	//部门code查询 2016-4-25
	public String deptCodeQuery(String userId);
} 
