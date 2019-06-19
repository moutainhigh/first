package com.deppon.lsp.module.mobileworkflow.shared.domain;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;

public class ApprovalInfoVo extends ApprovalInfo {
	private static final long serialVersionUID = 6724945744001694344L;
	
		// 审批时间
		private String approvedateStr;
		//开始时间
		private String starttimeStr;
		public String getApprovedateStr() {
			return approvedateStr;
		}
		public void setApprovedateStr(String approvedateStr) {
			this.approvedateStr = approvedateStr;
		}
		public String getStarttimeStr() {
			return starttimeStr;
		}
		public void setStarttimeStr(String starttimeStr) {
			this.starttimeStr = starttimeStr;
		}
}
