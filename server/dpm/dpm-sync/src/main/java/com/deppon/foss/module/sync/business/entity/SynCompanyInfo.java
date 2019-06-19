package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;

public class SynCompanyInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String id;
    protected String companyCode;
    protected String companyName;
    protected String shortName;
    protected String companyStandCode;
    protected String isHasAccount;
    protected String linkMan1;
    protected String fax1;
    protected String phone1;
    protected String zipCode;
    protected String postAddress;
    protected String saleAddress;
    protected String briefintro;
    protected Double ownerShareRate;
    protected boolean isWorkingUnit;
    protected boolean isSeal;
    protected String legalPerson;
    protected String changeType;
    protected String changeDate;

    public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isWorkingUnit() {
		return isWorkingUnit;
	}

	public void setWorkingUnit(boolean isWorkingUnit) {
		this.isWorkingUnit = isWorkingUnit;
	}

	public boolean isSeal() {
		return isSeal;
	}

	public void setSeal(boolean isSeal) {
		this.isSeal = isSeal;
	}

	public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String value) {
        this.companyCode = value;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String value) {
        this.companyName = value;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String value) {
        this.shortName = value;
    }

    public String getCompanyStandCode() {
        return companyStandCode;
    }

    public void setCompanyStandCode(String value) {
        this.companyStandCode = value;
    }

    public String getIsHasAccount() {
        return isHasAccount;
    }

    public void setIsHasAccount(String value) {
        this.isHasAccount = value;
    }

    public String getLinkMan1() {
        return linkMan1;
    }

    public void setLinkMan1(String value) {
        this.linkMan1 = value;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String value) {
        this.fax1 = value;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String value) {
        this.phone1 = value;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String value) {
        this.zipCode = value;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String value) {
        this.postAddress = value;
    }

    public String getSaleAddress() {
        return saleAddress;
    }

    public void setSaleAddress(String value) {
        this.saleAddress = value;
    }

    public String getBriefintro() {
        return briefintro;
    }

    public void setBriefintro(String value) {
        this.briefintro = value;
    }

    public Double getOwnerShareRate() {
        return ownerShareRate;
    }

    public void setOwnerShareRate(Double value) {
        this.ownerShareRate = value;
    }

    public boolean isIsWorkingUnit() {
        return isWorkingUnit;
    }

    public void setIsWorkingUnit(boolean value) {
        this.isWorkingUnit = value;
    }

    public boolean isIsSeal() {
        return isSeal;
    }

    public void setIsSeal(boolean value) {
        this.isSeal = value;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String value) {
        this.legalPerson = value;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String value) {
        this.changeType = value;
    }

}
