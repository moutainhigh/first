package com.deppon.dpm.module.acms.domain;

public class ApprovelEntity {

    protected long workItemId;
    protected Long processinstid;
    //审批意见
    protected String approveOpinion;
    //审批结果
    protected String isAgree;

    public ApprovelEntity() {
		super();
	}

	public ApprovelEntity(long workItemId, Long processinstid,
			String approveOpinion, String isAgree) {
		super();
		this.workItemId = workItemId;
		this.processinstid = processinstid;
		this.approveOpinion = approveOpinion;
		this.isAgree = isAgree;
	}

	/**
     * Gets the value of the workItemId property.
     * 
     */
    public long getWorkItemId() {
        return workItemId;
    }

    /**
     * Sets the value of the workItemId property.
     * 
     */
    public void setWorkItemId(long value) {
        this.workItemId = value;
    }

    /**
     * Gets the value of the processinstid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProcessinstid() {
        return processinstid;
    }

    /**
     * Sets the value of the processinstid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProcessinstid(Long value) {
        this.processinstid = value;
    }

    /**
     * Gets the value of the approveOpinion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * Sets the value of the approveOpinion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOpinion(String value) {
        this.approveOpinion = value;
    }

    /**
     * Gets the value of the isAgree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAgree() {
        return isAgree;
    }

    /**
     * Sets the value of the isAgree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAgree(String value) {
        this.isAgree = value;
    }

}
