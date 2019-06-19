package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

/**
 * 采购合同工作流
 * 对接移动端工作流接口--含新老流程
 * 数据查询接口
 * 审批接口
 * 
 * @author 275050
 *
 */
public interface IWeaverAndBPSMobileWorkflowService {
	
	/**
	 * 详细数据获取方法
	 * @param parameterJson
	 * 请求参数字json符串
	 * {
	 *   "docId":"工作流编号",
	 *   "empCode":"操作人工号",
	 *   "empName":"操作人姓名"
	 *   
	 * }
	 * @return
	 * 返回详细数据json字符串
	 * {
	 *   "billInfo":"单据信息"
	 *   "processDynamics":"流程动态信息"
	 * }
	 */
    public String queryDetailInfo(String parameterJson);
    /**
     * 单据审批方法
     * @param processJson：流程审批标准参数，具体json格式如下
     * {"approveOption":"审批意见",
     *  "wfProcInstId":"流程实例id",
     *  "wfWorkItemId":"工作项Id",
     *  "activityDefId":"当前活动定义ID",
     *  "docId":"流水号",
     *  "docNo":"单据Id",
     *  "transferCode":"转交人工号",
     *  "transferName":"转交人姓名",
     *  "empCode":"审批人工号",
     *  "empName":"审批人姓名",
     *  "wfDecision":"审批决策：如同意（agree）、退回（back）、不同意（disAgree）"
     *  }
     * @param billJson：业务单据json字符串，若审批过程中需要填写数据，封装成json字符串作为请求参数，若审批无数据编辑，则传null
     * @return
     */
    public String auditBill(String processJson,String billJson);

}
