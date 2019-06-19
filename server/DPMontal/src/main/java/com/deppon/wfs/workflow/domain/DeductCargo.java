package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
* @title: Deductcargo 
* @description：扣货申请
* @author： 赵慧
* @date： 2014-1-15 上午10:07:24
*/
public class DeductCargo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.BUSINO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String busino;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.PROCESSINSTID
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private Long processinstid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.APPLY_PERSON_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String applyPersonName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.APPLY_PERSON_ID
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String applyPersonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.DEDUCT_CARGO_NO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private Long deductCargoNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.DEPARTMENT
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String department;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.DEPARTMENT_SYSCODE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String departmentSyscode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.SEND_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String sendName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.RECEIVE_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String receiveName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.KEEP_VALUE_MONEY
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private BigDecimal keepValueMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.AGENCY_MONEY
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private BigDecimal agencyMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.CONTRACT_NO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String contractNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.APPLY_REASON
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String applyReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.CREATE_TIME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.MODIFY_TIME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.ISSEFFECTIVE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String isseffective;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.RESERVE_ONE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private BigDecimal reserveOne;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.RESERVE_TWO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String reserveTwo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WFS_DEDUCTCARGO.RESERVE_THREE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    private String reserveThree;

    private String businessDept;
    /**
     * 原扣货单号，用于存储老数据
     */
    private String oldNo;
    
    
    public String getOldNo() {
		return oldNo;
	}

	public void setOldNo(String oldNo) {
		this.oldNo = oldNo;
	}

	public String getBusinessDept() {
		return businessDept;
	}

	public void setBusinessDept(String businessDept) {
		this.businessDept = businessDept;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.BUSINO
     *
     * @return the value of T_WFS_DEDUCTCARGO.BUSINO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getBusino() {
        return busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.BUSINO
     *
     * @param busino the value for T_WFS_DEDUCTCARGO.BUSINO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setBusino(String busino) {
        this.busino = busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.PROCESSINSTID
     *
     * @return the value of T_WFS_DEDUCTCARGO.PROCESSINSTID
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public Long getProcessinstid() {
        return processinstid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.PROCESSINSTID
     *
     * @param processinstid the value for T_WFS_DEDUCTCARGO.PROCESSINSTID
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setProcessinstid(Long processinstid) {
        this.processinstid = processinstid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.APPLY_PERSON_NAME
     *
     * @return the value of T_WFS_DEDUCTCARGO.APPLY_PERSON_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getApplyPersonName() {
        return applyPersonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.APPLY_PERSON_NAME
     *
     * @param applyPersonName the value for T_WFS_DEDUCTCARGO.APPLY_PERSON_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setApplyPersonName(String applyPersonName) {
        this.applyPersonName = applyPersonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.APPLY_PERSON_ID
     *
     * @return the value of T_WFS_DEDUCTCARGO.APPLY_PERSON_ID
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getApplyPersonId() {
        return applyPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.APPLY_PERSON_ID
     *
     * @param applyPersonId the value for T_WFS_DEDUCTCARGO.APPLY_PERSON_ID
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setApplyPersonId(String applyPersonId) {
        this.applyPersonId = applyPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.DEDUCT_CARGO_NO
     *
     * @return the value of T_WFS_DEDUCTCARGO.DEDUCT_CARGO_NO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public Long getDeductCargoNo() {
        return deductCargoNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.DEDUCT_CARGO_NO
     *
     * @param deductCargoNo the value for T_WFS_DEDUCTCARGO.DEDUCT_CARGO_NO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setDeductCargoNo(Long deductCargoNo) {
        this.deductCargoNo = deductCargoNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.DEPARTMENT
     *
     * @return the value of T_WFS_DEDUCTCARGO.DEPARTMENT
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.DEPARTMENT
     *
     * @param department the value for T_WFS_DEDUCTCARGO.DEPARTMENT
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.DEPARTMENT_SYSCODE
     *
     * @return the value of T_WFS_DEDUCTCARGO.DEPARTMENT_SYSCODE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getDepartmentSyscode() {
        return departmentSyscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.DEPARTMENT_SYSCODE
     *
     * @param departmentSyscode the value for T_WFS_DEDUCTCARGO.DEPARTMENT_SYSCODE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setDepartmentSyscode(String departmentSyscode) {
        this.departmentSyscode = departmentSyscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.SEND_NAME
     *
     * @return the value of T_WFS_DEDUCTCARGO.SEND_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.SEND_NAME
     *
     * @param sendName the value for T_WFS_DEDUCTCARGO.SEND_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.RECEIVE_NAME
     *
     * @return the value of T_WFS_DEDUCTCARGO.RECEIVE_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.RECEIVE_NAME
     *
     * @param receiveName the value for T_WFS_DEDUCTCARGO.RECEIVE_NAME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.KEEP_VALUE_MONEY
     *
     * @return the value of T_WFS_DEDUCTCARGO.KEEP_VALUE_MONEY
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public BigDecimal getKeepValueMoney() {
        return keepValueMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.KEEP_VALUE_MONEY
     *
     * @param keepValueMoney the value for T_WFS_DEDUCTCARGO.KEEP_VALUE_MONEY
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setKeepValueMoney(BigDecimal keepValueMoney) {
        this.keepValueMoney = keepValueMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.AGENCY_MONEY
     *
     * @return the value of T_WFS_DEDUCTCARGO.AGENCY_MONEY
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public BigDecimal getAgencyMoney() {
        return agencyMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.AGENCY_MONEY
     *
     * @param agencyMoney the value for T_WFS_DEDUCTCARGO.AGENCY_MONEY
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setAgencyMoney(BigDecimal agencyMoney) {
        this.agencyMoney = agencyMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.CONTRACT_NO
     *
     * @return the value of T_WFS_DEDUCTCARGO.CONTRACT_NO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.CONTRACT_NO
     *
     * @param contractNo the value for T_WFS_DEDUCTCARGO.CONTRACT_NO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.APPLY_REASON
     *
     * @return the value of T_WFS_DEDUCTCARGO.APPLY_REASON
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.APPLY_REASON
     *
     * @param applyReason the value for T_WFS_DEDUCTCARGO.APPLY_REASON
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.CREATE_TIME
     *
     * @return the value of T_WFS_DEDUCTCARGO.CREATE_TIME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.CREATE_TIME
     *
     * @param createTime the value for T_WFS_DEDUCTCARGO.CREATE_TIME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.MODIFY_TIME
     *
     * @return the value of T_WFS_DEDUCTCARGO.MODIFY_TIME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.MODIFY_TIME
     *
     * @param modifyTime the value for T_WFS_DEDUCTCARGO.MODIFY_TIME
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.ISSEFFECTIVE
     *
     * @return the value of T_WFS_DEDUCTCARGO.ISSEFFECTIVE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getIsseffective() {
        return isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.ISSEFFECTIVE
     *
     * @param isseffective the value for T_WFS_DEDUCTCARGO.ISSEFFECTIVE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setIsseffective(String isseffective) {
        this.isseffective = isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.RESERVE_ONE
     *
     * @return the value of T_WFS_DEDUCTCARGO.RESERVE_ONE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public BigDecimal getReserveOne() {
        return reserveOne;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.RESERVE_ONE
     *
     * @param reserveOne the value for T_WFS_DEDUCTCARGO.RESERVE_ONE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setReserveOne(BigDecimal reserveOne) {
        this.reserveOne = reserveOne;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.RESERVE_TWO
     *
     * @return the value of T_WFS_DEDUCTCARGO.RESERVE_TWO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getReserveTwo() {
        return reserveTwo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.RESERVE_TWO
     *
     * @param reserveTwo the value for T_WFS_DEDUCTCARGO.RESERVE_TWO
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setReserveTwo(String reserveTwo) {
        this.reserveTwo = reserveTwo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_DEDUCTCARGO.RESERVE_THREE
     *
     * @return the value of T_WFS_DEDUCTCARGO.RESERVE_THREE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public String getReserveThree() {
        return reserveThree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_DEDUCTCARGO.RESERVE_THREE
     *
     * @param reserveThree the value for T_WFS_DEDUCTCARGO.RESERVE_THREE
     *
     * @mbggenerated Wed Jan 15 10:04:52 CST 2014
     */
    public void setReserveThree(String reserveThree) {
        this.reserveThree = reserveThree;
    }
}