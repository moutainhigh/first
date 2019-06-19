package com.deppon.fssc.module.remote.mobile.shared;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;

public class ApproveFssc extends ApprovalInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7063438101518534419L;


	private String stratTimeStr;
	
	
	private String approvedateStr;


	public String getStratTimeStr() {
		return stratTimeStr;
	}


	public void setStratTimeStr(String stratTimeStr) {
		this.stratTimeStr = stratTimeStr;
	}


	public String getApprovedateStr() {
		return approvedateStr;
	}


	public void setApprovedateStr(String approvedateStr) {
		this.approvedateStr = approvedateStr;
	}
}
