package com.deppon.lsp.module.mobileworkflow.server.service;

import java.io.Serializable;

import com.deppon.lsp.module.mobileworkflow.shared.domain.PayApplyVo;
import com.deppon.lsp.module.mobileworkflow.shared.domain.ApprovalInfoVo;
import com.deppon.lsp.module.mobileworkflow.shared.domain.PayApplyEntryVo;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity;

public class PayApplyWorkflowData implements Serializable{
	private static final long serialVersionUID = 5558321461807352742L;
	
		// 流程动态
		private ApprovalInfoVo[] ApprovalInfoVoList;
		
		// 基本信息
		private PayApplyVo payApplyVo;
		
		// 分录
		private PayApplyEntryVo[] PayApplyEntryVoList;
		
		//单据附件列表
		private AttachEntity[] attachList;
		
		public ApprovalInfoVo[] getApprovalInfoVoList() {
			return ApprovalInfoVoList;
		}
		public void setApprovalInfoVoList(ApprovalInfoVo[] approvalInfoVoList) {
			ApprovalInfoVoList = approvalInfoVoList;
		}
		public PayApplyVo getPayApplyVo() {
			return payApplyVo;
		}
		public void setPayApplyVo(PayApplyVo payApplyVo) {
			this.payApplyVo = payApplyVo;
		}
		public PayApplyEntryVo[] getPayApplyEntryVoList() {
			return PayApplyEntryVoList;
		}
		public void setPayApplyEntryVoList(PayApplyEntryVo[] payApplyEntryVoList) {
			PayApplyEntryVoList = payApplyEntryVoList;
		}
		public AttachEntity[] getAttachList() {
			return attachList;
		}
		public void setAttachList(AttachEntity[] attachList) {
			this.attachList = attachList;
		}
}
