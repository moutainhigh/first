package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;
public class StoreRent{
	
	/**
	* 
	*/
	private static final long serialVersionUID = -8284026633402856105L;
	/**
	* 主键
	*/
    private String busino;
    /**
    * 工作流号
    */
    private Long processinstid;
    /**
    * 申请人姓名
    */
    private String applyPersonName;
    /**
    * 申请人工号
    */
    private String applyPersonId;
    /**
    * 签订类型
    */
    private String signType;
    /**
    * 业务类型
    */
    private String businessType;
    /**
    * 原合同编号
    */
    private String originalPactNo;
    /**
    *是否开设新点或搬迁旧点
    */
    private String startOrMove;
    /**
    * 所属财务部
    */
    private String belongFinanceDepartment;
    /**
    * 优先盖章方
    */
    private String priorSeal;
    /**
    * 所属事业部
    */
    private String belongBusinessDepartment;
    /**
    * 所属子公司
    */
    private String belongSubsidiary;
    /**
    * 出租方名称
    */
    private String leaser;
    /**
    * 承租方名称
    */
    private String lessee;
    /**
    * 承租部门/转租部门
    */
    private String department;
    /**
    * 承租房屋面积/转租房屋面积
    */
    private String floorSpace;
    /**
    * 每年租金
    */
    private BigDecimal charterMoney;
    /**
    * 付款方式
    */
    private String paymentType;
    /**
    * 租赁开始日期
    */
    private Date rentStartDate;
    /**
    * 租赁结束日期
    */
    private Date rentEndDate;
    /**
    * 免租开始日期
    */
    private Date freeRentStartDate;
    /**
    * 免租结束日期
    */
    private Date freeRentEndDate;
    /**
    * 租赁类型
    */
    private String rentType;
    /**
    * 押金金额
    */
    private BigDecimal antecedentMoney;
    /**
    * 工程项目编号
    */
    private String projectNo;
    /**
    * 工程项目名称
    */
    private String projectName;
    /**
    * 申请事由
    */
    private String applyReason;
    /**
    * 财务部标杆编码
    */
    private String financeFinaSysCode;
    /**
    * 事业部标杆编码
    */
    private String businessFinaSysCode;
    /**
    * 开设新点的工作流号
    */
    private Long ifStartPro;

    /**
    * 创建时间
    */
    private Date creatTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 业务状态（默认1）
     */
    private String isseffective;

    /**
     * 备用字段1
     */
    private long reserveOne;

    /**
     * 备用字段2
     */
    private String lesseeInput;

    /**
     * 备用字段3
     */
    private String departmentFinaSysCode;

    /**
     * 老表添加
     * */
    private Date allAgreeTime;
	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the processinstid
	 */
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}

	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}

	/**
	 * @return the applyPersonNumber
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * @param applyPersonNumber the applyPersonNumber to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}

	/**
	 * @return the signType
	 */
	public String getSignType() {
		return signType;
	}

	/**
	 * @param signType the signType to set
	 */
	public void setSignType(String signType) {
		this.signType = signType;
	}

	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * @return the originalPactNo
	 */
	public String getOriginalPactNo() {
		return originalPactNo;
	}

	/**
	 * @param originalPactNo the originalPactNo to set
	 */
	public void setOriginalPactNo(String originalPactNo) {
		this.originalPactNo = originalPactNo;
	}


	/**
	 * @return the belongFinanceDepartment
	 */
	public String getBelongFinanceDepartment() {
		return belongFinanceDepartment;
	}

	/**
	 * @param belongFinanceDepartment the belongFinanceDepartment to set
	 */
	public void setBelongFinanceDepartment(String belongFinanceDepartment) {
		this.belongFinanceDepartment = belongFinanceDepartment;
	}

	/**
	 * @return the priorSeal
	 */
	public String getPriorSeal() {
		return priorSeal;
	}

	/**
	 * @param priorSeal the priorSeal to set
	 */
	public void setPriorSeal(String priorSeal) {
		this.priorSeal = priorSeal;
	}

	/**
	 * @return the belongBusinessDepartment
	 */
	public String getBelongBusinessDepartment() {
		return belongBusinessDepartment;
	}

	/**
	 * @param belongBusinessDepartment the belongBusinessDepartment to set
	 */
	public void setBelongBusinessDepartment(String belongBusinessDepartment) {
		this.belongBusinessDepartment = belongBusinessDepartment;
	}

	/**
	 * @return the belongSubsidiary
	 */
	public String getBelongSubsidiary() {
		return belongSubsidiary;
	}

	/**
	 * @param belongSubsidiary the belongSubsidiary to set
	 */
	public void setBelongSubsidiary(String belongSubsidiary) {
		this.belongSubsidiary = belongSubsidiary;
	}

	/**
	 * @return the leaser
	 */
	public String getLeaser() {
		return leaser;
	}

	/**
	 * @param leaser the leaser to set
	 */
	public void setLeaser(String leaser) {
		this.leaser = leaser;
	}

	/**
	 * @return the lessee
	 */
	public String getLessee() {
		return lessee;
	}

	/**
	 * @param lessee the lessee to set
	 */
	public void setLessee(String lessee) {
		this.lessee = lessee;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the floorSpace
	 */
	public String getFloorSpace() {
		return floorSpace;
	}

	/**
	 * @param floorSpace the floorSpace to set
	 */
	public void setFloorSpace(String floorSpace) {
		this.floorSpace = floorSpace;
	}

	/**
	 * @return the charterMoney
	 */
	public BigDecimal getCharterMoney() {
		return charterMoney;
	}

	/**
	 * @param charterMoney the charterMoney to set
	 */
	public void setCharterMoney(BigDecimal charterMoney) {
		this.charterMoney = charterMoney;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the rentStartDate
	 */
	public Date getRentStartDate() {
		return rentStartDate;
	}

	/**
	 * @param rentStartDate the rentStartDate to set
	 */
	public void setRentStartDate(Date rentStartDate) {
		this.rentStartDate = rentStartDate;
	}

	/**
	 * @return the rentEndDate
	 */
	public Date getRentEndDate() {
		return rentEndDate;
	}

	/**
	 * @param rentEndDate the rentEndDate to set
	 */
	public void setRentEndDate(Date rentEndDate) {
		this.rentEndDate = rentEndDate;
	}

	/**
	 * @return the freeRentStartDate
	 */
	public Date getFreeRentStartDate() {
		return freeRentStartDate;
	}

	/**
	 * @param freeRentStartDate the freeRentStartDate to set
	 */
	public void setFreeRentStartDate(Date freeRentStartDate) {
		this.freeRentStartDate = freeRentStartDate;
	}

	/**
	 * @return the freeRentEndDate
	 */
	public Date getFreeRentEndDate() {
		return freeRentEndDate;
	}

	/**
	 * @param freeRentEndDate the freeRentEndDate to set
	 */
	public void setFreeRentEndDate(Date freeRentEndDate) {
		this.freeRentEndDate = freeRentEndDate;
	}

	/**
	 * @return the rentType
	 */
	public String getRentType() {
		return rentType;
	}

	/**
	 * @param rentType the rentType to set
	 */
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	/**
	 * @return the antecedentMoney
	 */
	public BigDecimal getAntecedentMoney() {
		return antecedentMoney;
	}

	/**
	 * @param antecedentMoney the antecedentMoney to set
	 */
	public void setAntecedentMoney(BigDecimal antecedentMoney) {
		this.antecedentMoney = antecedentMoney;
	}

	/**
	 * @return the projectNo
	 */
	public String getProjectNo() {
		return projectNo;
	}

	/**
	 * @param projectNo the projectNo to set
	 */
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	/**
	 * @return the financeFinaSysCode
	 */
	public String getFinanceFinaSysCode() {
		return financeFinaSysCode;
	}

	/**
	 * @param financeFinaSysCode the financeFinaSysCode to set
	 */
	public void setFinanceFinaSysCode(String financeFinaSysCode) {
		this.financeFinaSysCode = financeFinaSysCode;
	}

	/**
	 * @return the businessFinaSysCode
	 */
	public String getBusinessFinaSysCode() {
		return businessFinaSysCode;
	}

	/**
	 * @param businessFinaSysCode the businessFinaSysCode to set
	 */
	public void setBusinessFinaSysCode(String businessFinaSysCode) {
		this.businessFinaSysCode = businessFinaSysCode;
	}

	/**
	 * @return the creatTime
	 */
	public Date getCreatTime() {
		return creatTime;
	}

	/**
	 * @param creatTime the creatTime to set
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the reserveOne
	 */
	public long getReserveOne() {
		return reserveOne;
	}

	/**
	 * @param reserveOne the reserveOne to set
	 */
	public void setReserveOne(long reserveOne) {
		this.reserveOne = reserveOne;
	}



	/**
	 * @return the startOrMove
	 */
	public String getStartOrMove() {
		return startOrMove;
	}

	/**
	 * @param startOrMove the startOrMove to set
	 */
	public void setStartOrMove(String startOrMove) {
		this.startOrMove = startOrMove;
	}

	/**
	 * @return the isseffective
	 */
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * @param isseffective the isseffective to set
	 */
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}

	/**
	 * @return the ifStartPro
	 */
	public Long getIfStartPro() {
		return ifStartPro;
	}

	/**
	 * @param ifStartPro the ifStartPro to set
	 */
	public void setIfStartPro(Long ifStartPro) {
		this.ifStartPro = ifStartPro;
	}

	/**
	 * @return the lesseeInput
	 */
	public String getLesseeInput() {
		return lesseeInput;
	}

	/**
	 * @param lesseeInput the lesseeInput to set
	 */
	public void setLesseeInput(String lesseeInput) {
		this.lesseeInput = lesseeInput;
	}

	/**
	 * @return the departmentFinaSysCode
	 */
	public String getDepartmentFinaSysCode() {
		return departmentFinaSysCode;
	}

	/**
	 * @param departmentFinaSysCode the departmentFinaSysCode to set
	 */
	public void setDepartmentFinaSysCode(String departmentFinaSysCode) {
		this.departmentFinaSysCode = departmentFinaSysCode;
	}

	/**
	 * @return the allAgreeTime
	 */
	public Date getAllAgreeTime() {
		return allAgreeTime;
	}

	/**
	 * @param allAgreeTime the allAgreeTime to set
	 */
	public void setAllAgreeTime(Date allAgreeTime) {
		this.allAgreeTime = allAgreeTime;
	}

    
}