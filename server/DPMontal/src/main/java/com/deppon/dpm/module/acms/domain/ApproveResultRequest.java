package com.deppon.dpm.module.acms.domain;

public class ApproveResultRequest {

    protected String appCode;
    protected String appName;
    protected ApprovelEntity approvelEntity;
    
    public ApproveResultRequest() {
		super();
	}

	public ApproveResultRequest(String appCode, String appName,
			ApprovelEntity approvelEntity) {
		super();
		this.appCode = appCode;
		this.appName = appName;
		this.approvelEntity = approvelEntity;
	}

	/**
     * Gets the value of the appCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * Sets the value of the appCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppCode(String value) {
        this.appCode = value;
    }

    /**
     * Gets the value of the appName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Sets the value of the appName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

    /**
     * Gets the value of the approvelEntity property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovelEntity }
     *     
     */
    public ApprovelEntity getApprovelEntity() {
        return approvelEntity;
    }

    /**
     * Sets the value of the approvelEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovelEntity }
     *     
     */
    public void setApprovelEntity(ApprovelEntity value) {
        this.approvelEntity = value;
    }

}
