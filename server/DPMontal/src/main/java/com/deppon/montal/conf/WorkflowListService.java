package com.deppon.montal.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.montal.conf.domain.WorkflowInfo;
import com.deppon.montal.util.redis.service.impl.InitWorkflowInfo;

public class WorkflowListService {
	private static WorkflowListService _instance;
	private WorkflowListService() {
	}
	public static WorkflowListService getInstance() {
		if (_instance == null) {
			 synchronized(WorkflowListService.class) {
				 if (_instance == null) {
					 _instance = new WorkflowListService();
				 }
			 }
		}
		return _instance;
	}
	public void syncWorkflow() {
		StringBuilder dipoa = new StringBuilder();
		StringBuilder fssc = new StringBuilder();
		StringBuilder lsp = new StringBuilder();
		StringBuilder dwfs = new StringBuilder();
		//CRM系统工作流定义名称
		StringBuilder icrm = new StringBuilder();
		//财务自助工作流定义名称
		StringBuffer finSelf = new StringBuffer();
		//hr工作流定义名称
		StringBuffer hr = new StringBuffer();
		//wdgh工作流定义名称
		StringBuffer wdgh = new StringBuffer();
		//证照系统工作流流程定义名称
		StringBuffer acms = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		List<WorkflowInfo> list = InitWorkflowInfo.getAllWorkflowFromRedis();
		for (WorkflowInfo workflow : list) {
			if (workflow.getSyscode().equals(F_Constants.DIPOA_WORKFLOW_SYSCODE)) {
				dipoa.append(",'" + workflow.getWorkflowname()+"'");
			} else if (workflow.getSyscode().equals(F_Constants.FSSC_WORKFLOW_SYSCODE)){
				fssc.append(",'" + workflow.getWorkflowname()+"'");
			} else if (workflow.getSyscode().equals(F_Constants.DLSP_WORKFLOW_SYSCODE)) {
				lsp.append(",'" + workflow.getWorkflowname()+"'");
			} else if (workflow.getSyscode().equals(F_Constants.DWFS_WORKFLOW_SYSCODE)) {
				dwfs.append(",'" + workflow.getWorkflowname()+"'");
			} else if(workflow.getSyscode().equals(F_Constants.CRM_WORKFLOW_SYSCODE)){
				//CRM系统
				icrm.append(",'" + workflow.getWorkflowname()+"'");
			}else if(F_Constants.FIN_SELF_WORKFLOW_SYSCODE.equals(workflow.getSyscode())){
				//fin_self财务自助系统
				finSelf.append(",'" + workflow.getWorkflowname() + "'");
			}else if(F_Constants.HR_WORKFLOW_SYSCODE.equals(workflow.getSyscode())) {
				//nhr系统
				hr.append(",'" + workflow.getWorkflowname() + "'");
			}else if(F_Constants.WDGH_WORKFLOW_SYSCODE.equals(workflow.getSyscode())){
				//网点规划系统 WDGH
				wdgh.append(",'" + workflow.getWorkflowname() + "'");
			}else if(F_Constants.ACMS_WORKFLOW_SYSCODE.equals(workflow.getSyscode())){
				//证照系统系统 ACMS
				acms.append(",'" + workflow.getWorkflowname() + "'");
			}
			
			map.put(workflow.getWorkflowname(), workflow.getJspname());
		}
		F_Constants.ALL_WORKFLOW_TYPES = dipoa.toString().length()>0?dipoa.toString().substring(1):"''";
		F_Constants.ALL_WORKFLOW_TYPES_FSSC = fssc.toString().length()>0?fssc.toString().substring(1):"''";
		F_Constants.ALL_WORKFLOW_TYPES_LSP = lsp.toString().length()>0?lsp.toString().substring(1):"''";
		F_Constants.ALL_WORKFLOW_TYPES = dipoa.toString().length()>0?dipoa.toString().substring(1):"''";
		F_Constants.ALL_WORKFLOW_TYPES_DWFS = dwfs.toString().length()>0?dwfs.toString().substring(1):"''";
		F_Constants.ALL_WORKFLOW_TYPES_ICRM = icrm.toString().length()>0?icrm.toString().substring(1):"''";
		F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF = finSelf.toString().length() > 0 ? finSelf.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_HR = hr.toString().length() > 0 ? hr.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_WDGH = wdgh.toString().length() > 0 ? wdgh.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_ACMS = acms.toString().length() > 0 ? acms.toString().substring(1) : "''";
		F_Constants.WF_FORWARD_MAP = map;
	}
	public String getAllWorkflow() {
		StringBuilder str = new StringBuilder();
		List<WorkflowInfo> list = InitWorkflowInfo.getAllWorkflowFromRedis();
		for (WorkflowInfo workflow : list) {
			str.append(",'" + workflow.getWorkflowname()+"'");
		}
		return str.toString().length()>0?str.toString().substring(1):"''";
	}
	public String getWorkflowStr(String syscode) {
		StringBuilder str = new StringBuilder();
		List<WorkflowInfo> list = InitWorkflowInfo.getAllWorkflowFromRedis();
		for (WorkflowInfo workflow : list) {
			if (workflow.getSyscode().equals(syscode))
				str.append(",'" + workflow.getWorkflowname()+"'");
		}
		return str.toString().length()>0?str.toString().substring(1):"''";
	}
	public Map<String, String> getWorkflowMap() {
		Map<String, String> map = new HashMap<String, String>();
		List<WorkflowInfo> list = InitWorkflowInfo.getAllWorkflowFromRedis();
		for (WorkflowInfo workflow : list) {
			map.put(workflow.getWorkflowname(), workflow.getJspname());
		}
		return map;
	}
	
}
