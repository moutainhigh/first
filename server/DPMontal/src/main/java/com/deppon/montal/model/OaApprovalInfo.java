/**
 * 
 */
package com.deppon.montal.model;

import com.deppon.montal.conf.F_Constants;

/**
 * @yin 审批处理记录
 *
 */
public class OaApprovalInfo {

	private String approver;
	
	private String approvedate;
	
	private String approverver;
	
	private String isagree;

	public String getApprover() {
		return F_Constants.chageNull(approver);
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApprovedate() {
		return F_Constants.chageNull(approvedate);
	}

	public void setApprovedate(String approvedate) {
		this.approvedate = approvedate;
	}

	public String getApproverver() {
		return F_Constants.chageNull(approverver);
	}

	public void setApproverver(String approverver) {
		this.approverver = approverver;
	}

	public String getIsagree() {
		return F_Constants.chageNull(isagree);
	}

	public void setIsagree(String isagree) {
		this.isagree = isagree;
	}
	
	
}
