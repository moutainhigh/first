package com.deppon.dpm.doc.server.vo;


/**
*@Description:事前申请单差旅费VO对象
*@Date:2018/10/9_18:37
*/
public class TravelVo {
	
	private String empCode;

    // 起草时间
    private String draftTime;

    // 业务开始时间
    private String startDate;

    // 业务结束时间
    private String endDate;

    // 查询是否成功
    private String isSuccess;

    // 审批状态码
    private String auditStateCode;

    // 目的地
    private String destination;

    // 费用类型编码
    private String scName;

    //失败原因
    private String failReason;

    public String getAuditStateCode() {
        return auditStateCode;
    }

    public void setAuditStateCode(String auditStateCode) {
        this.auditStateCode = auditStateCode;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getDraftTime() {
        return draftTime;
    }

    public void setDraftTime(String draftTime) {
        this.draftTime = draftTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

}
