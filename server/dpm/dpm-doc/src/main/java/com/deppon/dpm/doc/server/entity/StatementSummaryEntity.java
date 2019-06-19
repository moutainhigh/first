package com.deppon.dpm.doc.server.entity;

public class StatementSummaryEntity {
	
	private String company;
	
	private String money;
	
	private String workFlowStatus;
	
	private String workFlowNum;
	
	private String offTime;
	
	private String status;
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getMoney() {
		return money;
	}
	
	public void setMoney(String money) {
		this.money = money;
	}
	
	public String getWorkFlowStatus() {
		return workFlowStatus;
	}
	
	public void setWorkFlowStatus(String workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
	}
	
	public String getWorkFlowNum() {
		return workFlowNum;
	}
	
	public void setWorkFlowNum(String workFlowNum) {
		this.workFlowNum = workFlowNum;
	}
	
	public String getOffTime() {
		return offTime;
	}
	
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "StatementSummaryEntity [company=" + company + ", money="
				+ money + ", workFlowStatus=" + workFlowStatus
				+ ", workFlowNum=" + workFlowNum + ", offTime=" + offTime
				+ ", status=" + status + "]";
	}
	
}
