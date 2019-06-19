package com.deppon.lsp.module.mobileworkflow.server.service;

import java.io.Serializable;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity;
import com.deppon.lsp.module.purchase.purchasecontact.share.domain.PurchaseContactDetailEntity;
import com.deppon.lsp.module.purchase.purchasecontact.share.vo.PurchaseContactVo;
///**
// * 采购合同变更单工作流业务数据
// */
public class WorkflowData implements Serializable {
	private static final long serialVersionUID = -1934837717109597589L;
	// 流程动态
	private ApprovalInfo[] approvalInfoList;
	// 基本信息
	private PurchaseContactVo purchaseContactVo;
	// 分录
	private PurchaseContactDetailEntity[] purchaseContactDetailEntityList;

	//单据附件列表
	private AttachEntity[] attachList;
		
	public PurchaseContactVo getPurchaseContactVo() {
		return purchaseContactVo;
	}

	public void setPurchaseContactVo(PurchaseContactVo purchaseContactVo) {
		this.purchaseContactVo = purchaseContactVo;
	}

	public ApprovalInfo[] getApprovalInfoList() {
		if (approvalInfoList == null){
			approvalInfoList = new  ApprovalInfo[0];
		}
		return approvalInfoList;
	}

	public void setApprovalInfoList(ApprovalInfo[] approvalInfoList) {
		this.approvalInfoList = approvalInfoList;
	}

	public PurchaseContactDetailEntity[] getPurchaseContactDetailEntityList() {
		if (purchaseContactDetailEntityList == null) {
			purchaseContactDetailEntityList = new PurchaseContactDetailEntity[0];
		}
		return purchaseContactDetailEntityList;
	}

	public void setPurchaseContactDetailEntityList(
			PurchaseContactDetailEntity[] purchaseContactDetailEntityList) {
		this.purchaseContactDetailEntityList = purchaseContactDetailEntityList;
	}

	public AttachEntity[] getAttachList() {
		if (attachList == null) {
			attachList = new AttachEntity[0];
		}
		return attachList;
	}

	public void setAttachList(AttachEntity[] attachList) {
		this.attachList = attachList;
	}

}
