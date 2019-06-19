package com.deppon.lsp.module.mobileworkflow.server.service;

import java.io.Serializable;

	public class Auditparameters implements Serializable {
		private static final long serialVersionUID = 214030343632678379L;
		// 审批决策
		private String decisionState;
		// 审批意见
		private String auditAdvise;
		// 流程实例id-------- wfProcInstId
		private long wfInstanceId;
		// 工作项id ---------wfWorkitemId
		private long wfWorkItemId;
		// 当前活动定义ID --------activityDefId
		private String wfState;
		// 流水业务号  ------DLSPZCG-20130920-03461
		private String docId;
		// 单据FID
		private String docNo;
		// 审批人工号
		private String empCode;
		// 审批人名称
		private String empName;
		public String getDecisionState() {
			return decisionState;
		}
		public void setDecisionState(String decisionState) {
			this.decisionState = decisionState;
		}
		public String getAuditAdvise() {
			return auditAdvise;
		}
		public void setAuditAdvise(String auditAdvise) {
			this.auditAdvise = auditAdvise;
		}
		public long getWfInstanceId() {
			return wfInstanceId;
		}
		public void setWfInstanceId(long wfInstanceId) {
			this.wfInstanceId = wfInstanceId;
		}
		public long getWfWorkItemId() {
			return wfWorkItemId;
		}
		public void setWfWorkItemId(long wfWorkItemId) {
			this.wfWorkItemId = wfWorkItemId;
		}
		public String getWfState() {
			return wfState;
		}
		public void setWfState(String wfState) {
			this.wfState = wfState;
		}
		public String getDocId() {
			return docId;
		}
		public void setDocId(String docId) {
			this.docId = docId;
		}
		public String getDocNo() {
			return docNo;
		}
		public void setDocNo(String docNo) {
			this.docNo = docNo;
		}
		public String getEmpCode() {
			return empCode;
		}
		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		
	}
