package com.deppon.fssc.module.claim.salary.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.deppon.fssc.module.claimsupport.shared.domain.ClaimLineBaseEntity;

/**
 * 
 * <pre>
 * 功能:薪酬报账单专用的明细信息表 
 * 作者：刘崇丛
 * 日期：2013-3-25上午9:32:31
 * </pre>
 */
public class ClaimLineSalaryEntity extends ClaimLineBaseEntity implements Serializable{
	
	// 序列化2013-04-18 
	private static final long serialVersionUID = 5416651621008027492L;
	
	// 原发放类型
	private String oldIssueType;
	// 原发放失败原因
	private String oldFailReason;
	// 关联单据编号
	private String relativeClaimNo;
	// 社保主体编码
	private String securityCode;
	// 社保主体单位
	private String securityUnits;
	// 应发工资
	private BigDecimal grossSalary;
	// 社保扣款
	private BigDecimal securityDeduct;
	// 应发辞退福利金额
	private BigDecimal dismissWelfare;
	// 辞退福利税金
	private BigDecimal dismissWelfareTaxes;
	// 派遣公司编码
	private String dispatchCompNo;
	// 派遣公司名称
	private String dispatchCompName;
	// 单位社保总计
	private BigDecimal compTotSocialSecurity;
	// 个人社保总计
	private BigDecimal personalTotSocialSecurity;
	// 管理费
	private BigDecimal manageFee;
	// 社保卡扣款--
	private BigDecimal socialSecurityCardFee;
	// 实发保险金额
	private BigDecimal netPayInsurance;
	// 认领编号
	private String applyNo;
	// 认领金额
	private BigDecimal applyMoney;
	// 生育津贴
	private BigDecimal maternityAllowance;
	// 产假工资
	private BigDecimal maternityPay;
	// 单位养老金
	private BigDecimal compPension;
	// 单位失业保险
	private BigDecimal compUnemployInsur;
	// 单位大病医疗统筹
	private BigDecimal compIllness;
	// 单位生育保险
	private BigDecimal compMaternityInsur;
	// 单位工伤保险
	private BigDecimal compInjuryInsur;
	// 单位医疗保险
	private BigDecimal compHealthInsur;
	// 是否社保补缴
	private String socialSecurityBack;
	// 单位住房公积金
	private BigDecimal compHousingFund;
	// 个人住房公积金
	private BigDecimal personalHousingFund;
	// 认领人
	private String applyUser;
	// 小数点差异调整
	private BigDecimal pointAdjust;
	// 工伤日期
	private Date injuryDate;
	// 工伤差错处理编号
	private String injuryMistakeDisposeNo;
	// 医疗费用
	private BigDecimal hospitalCost;
	// 住院陪护费
	private BigDecimal hospitalEscortFee;
	// 住院伙食补助
	private BigDecimal hospitalFoodAllowance;
	// 其他费用
	private BigDecimal otherFee;
	// 预算类型
	private String budgetType;
	// 人数
	private int noOfPeople;
	// 配偶姓名
	private String spouseName;
	// 是否公司员工
	private String isStaff;
	// 配偶工号
	private String spouseJobno;
	// 管理人员转正工作流号
	private String regularWfNo;
	// 认证人员等级编码
	private String certifiedGradeCode;
	// 认证人员等级
	private String certifiedGradeName;
	// 小孩出生日期
	private Date childBirthday;

	// 新增的 34 个 begin
	// 住宿扣款--
	private BigDecimal accommodationDeduction;
	// 实发离职补偿金--
	private BigDecimal actualLeaveCompensation;
	// 实发工资取整--
	private BigDecimal actualSalary;
	// 预支工资--
	private BigDecimal advanceSalary;
	
	// 商务车扣款--
	private BigDecimal bussinessVehicleDM;
	// 赔偿损失--
	private BigDecimal compensateLoss;
	// 补偿金税金--
	private BigDecimal compensationTaxes;
	// 合同借支--
	private BigDecimal contractLoan;
	// 代扣个人借款--
	private BigDecimal deductionPersonLoan;
	// 代扣个人所得税--
	private BigDecimal deductionPIncomeTax;
	// 代扣住房公积金--
	private BigDecimal deductionReverse;
	// 代扣个人社保--
	private BigDecimal deductionSs;
	
	
	// 代付内部公积金--
	private BigDecimal depositeRF;
	// 员工手册扣款 --
	private BigDecimal employeeManualDeduction;
	// 违纪罚款--
	private BigDecimal fineDiscipline;
	// 工牌制作费--
	private BigDecimal identificationDeduction;
	// 工伤扣款--
	private BigDecimal industrialInjuryDeduction;
	// 身份证号码 --
	private String leavePersonCertificate;
	// 离职工资金额--
	private BigDecimal leavePersonSalary;
	
	// 其他扣款备注--
	private String otherDeductionRemark;
	// 其他扣款--
	private BigDecimal otherDeduction;
	// 党费扣款--
	private BigDecimal partyDeduction;
	// 代付话费--
	private BigDecimal payingPhoneCharge;
	// 代付亲情1+1--
	private BigDecimal payRelationship;
	// 绩效罚款--
	private BigDecimal performancePenalty;
	// 人事代理费--
	private BigDecimal personnelAgencyFee;
	// 代还个人借款--
	private BigDecimal replacePersonLoan;
	// 奖励小计--
	private BigDecimal rewardSum;
	// 应发离职补偿金--
	private BigDecimal shouldLeaveCompensation;
	// 应发合计--
	private BigDecimal shouldSum;
	// 工资暂扣--
	private BigDecimal temporarySeizure;
	// 工服扣款--
	private BigDecimal workClothDeduction;

	// 新增的 24 个 end
	//探望人级别 编码
	private String visitationLevelCode;
	//探望人级别名称
	private String visitationLevelName;
	//家属是否为德邦员工
	private String familyIsDepponEmployee;
	//结婚日期
	private Date marryDate;
	//家属姓名
	private String familyName;
	//家属关系code
	private String familyRelationCode;
	//家属关系名称
	private String familyRelationName;
	//家属所在城市
	private String familyCityName;
	//异动工作流
	private String transactionWorkflow;
	//异动日期
	private Date transactionDate;
	//家属随迁日期
	private Date familyTrailingDate;
	
	//是否进入公司账户
	private String intoCompanyAccount;

	// 工资个人所得税
	private BigDecimal payPersonTax;
	// 年终奖个人所得税
	private BigDecimal annualBonusPersonTax;

	// 学车报名工作流
	private String learnCarApplyWF;
	// 学车毕业日期
	private Date learnCarGraduDate;
	// 学车金额
	private BigDecimal learnCarAmount;

	// 一次性伤残补助金
	private BigDecimal oneDisabilityBenefit;
	// 一次性医疗补助金
	private BigDecimal oneMedicaltreatment;
	// 一次性就业补助金
	private BigDecimal oneObtainEmployment;
	// 经济补偿金
	private BigDecimal economicCompensation;
	// 人性化补贴
	private BigDecimal humanizedSubsidie;
	// 所属系统 名称
	private String belongSystemName;
	// 所属系统 编码
	private String belongSystemCode;

	/**
	 * get 原发放类型
	 * @return
	 */
	public String getOldIssueType() {
		return oldIssueType;
	}
	/**
	 * set 原发放类型
	 * @param oldIssueType
	 */
	public void setOldIssueType(String oldIssueType) {
		this.oldIssueType = (oldIssueType==null)?"":oldIssueType;
	}
	/**
	 * get 原发放失败原因
	 * @return
	 */
	public String getOldFailReason() {
		return oldFailReason;
	}
	/**
	 * set 原发放失败原因
	 * @param oldFailReason
	 */
	public void setOldFailReason(String oldFailReason) {
		this.oldFailReason = (oldFailReason==null)?"":oldFailReason;
	}
	/**
	 * get 关联单据编号
	 * @return
	 */
	public String getRelativeClaimNo() {
		return relativeClaimNo;
	}
	/**
	 * set 关联单据编号
	 * @param relativeClaimNo
	 */
	public void setRelativeClaimNo(String relativeClaimNo) {
		this.relativeClaimNo = (relativeClaimNo==null)?"":relativeClaimNo;
	}
	/**
	 * get 社保主体编码
	 * @return
	 */
	public String getSecurityCode() {
		return securityCode;
	}
	/**
	 * set 社保主体编码
	 * @param securityCode
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	/**
	 * get 社保主体单位
	 * @return
	 */
	public String getSecurityUnits() {
		return securityUnits;
	}
	/**
	 * set 社保主体单位
	 * @param securityUnits
	 */
	public void setSecurityUnits(String securityUnits) {
		this.securityUnits = (securityUnits==null)?"":securityUnits;
	}
	/**
	 * get 应发工资
	 * @return
	 */
	public BigDecimal getGrossSalary() {
		return grossSalary;
	}
	/**
	 * set 应发工资
	 * @param grossSalary
	 */
	public void setGrossSalary(BigDecimal grossSalary) {
		this.grossSalary = grossSalary;
	}
	/**
	 * get 社保扣款
	 * @return
	 */
	public BigDecimal getSecurityDeduct() {
		return securityDeduct;
	}
	/**
	 * set 社保扣款
	 * @param securityDeduct
	 */
	public void setSecurityDeduct(BigDecimal securityDeduct) {
		this.securityDeduct = securityDeduct;
	}
	/**
	 * get 应发辞退福利金额
	 * @return
	 */
	public BigDecimal getDismissWelfare() {
		return dismissWelfare;
	}
	/**
	 * set 应发辞退福利金额
	 * @param dismissWelfare
	 */
	public void setDismissWelfare(BigDecimal dismissWelfare) {
		this.dismissWelfare = dismissWelfare;
	}
	/**
	 * get 辞退福利税金
	 * @return
	 */
	public BigDecimal getDismissWelfareTaxes() {
		return dismissWelfareTaxes;
	}
	/**
	 * set 辞退福利税金
	 * @param dismissWelfareTaxes
	 */
	public void setDismissWelfareTaxes(BigDecimal dismissWelfareTaxes) {
		this.dismissWelfareTaxes = dismissWelfareTaxes;
	}
	/**
	 * get 派遣公司编码
	 * @return
	 */
	public String getDispatchCompNo() {
		return dispatchCompNo;
	}
	/**
	 * set 派遣公司编码
	 * @param dispatchCompNo
	 */
	public void setDispatchCompNo(String dispatchCompNo) {
		this.dispatchCompNo = (dispatchCompNo==null)?"":dispatchCompNo;
	}
	/**
	 * get 派遣公司名称
	 * @return
	 */
	public String getDispatchCompName() {
		return dispatchCompName;
	}
	/**
	 * set 派遣公司名称
	 * @param dispatchCompName
	 */
	public void setDispatchCompName(String dispatchCompName) {
		this.dispatchCompName = (dispatchCompName==null)?"":dispatchCompName;
	}
	/**
	 * get 单位社保总计
	 * @return
	 */
	public BigDecimal getCompTotSocialSecurity() {
		return compTotSocialSecurity;
	}
	/**
	 * set 单位社保总计
	 * @param compTotSocialSecurity
	 */
	public void setCompTotSocialSecurity(BigDecimal compTotSocialSecurity) {
		this.compTotSocialSecurity = compTotSocialSecurity;
	}
	/**
	 * get 个人社保总计
	 * @return
	 */
	public BigDecimal getPersonalTotSocialSecurity() {
		return personalTotSocialSecurity;
	}
	/**
	 * set 个人社保总计
	 * @param personalTotSocialSecurity
	 */
	public void setPersonalTotSocialSecurity(
			BigDecimal personalTotSocialSecurity) {
		this.personalTotSocialSecurity = personalTotSocialSecurity;
	}
	/**
	 * get 管理费
	 * @return
	 */
	public BigDecimal getManageFee() {
		return manageFee;
	}
	/**
	 * set 管理费
	 * @param manageFee
	 */
	public void setManageFee(BigDecimal manageFee) {
		this.manageFee = manageFee;
	}
	/**
	 * get 社保卡扣款
	 * @return
	 */
	public BigDecimal getSocialSecurityCardFee() {
		return socialSecurityCardFee;
	}
	/**
	 * set 社保卡扣款
	 * @param socialSecurityCardFee
	 */
	public void setSocialSecurityCardFee(BigDecimal socialSecurityCardFee) {
		this.socialSecurityCardFee = socialSecurityCardFee;
	}
	/**
	 * get 实发保险金额
	 * @return
	 */
	public BigDecimal getNetPayInsurance() {
		return netPayInsurance;
	}
	/**
	 * set 实发保险金额
	 * @param netPayInsurance
	 */
	public void setNetPayInsurance(BigDecimal netPayInsurance) {
		this.netPayInsurance = netPayInsurance;
	}
	/**
	 * get 认领编号
	 * @return
	 */
	public String getApplyNo() {
		return applyNo;
	}
	/**
	 * set 认领编号
	 * @param applyNo
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = (applyNo==null)?"":applyNo;
	}
	/**
	 * get 认领金额
	 * @return
	 */
	public BigDecimal getApplyMoney() {
		return applyMoney;
	}
	/**
	 * set 认领金额
	 * @param applyMoney
	 */
	public void setApplyMoney(BigDecimal applyMoney) {
		this.applyMoney = applyMoney;
	}
	/**
	 * get 生育津贴
	 * @return
	 */
	public BigDecimal getMaternityAllowance() {
		return maternityAllowance;
	}
	/**
	 * set 生育津贴
	 * @param maternityAllowance
	 */
	public void setMaternityAllowance(BigDecimal maternityAllowance) {
		this.maternityAllowance = maternityAllowance;
	}

	public BigDecimal getMaternityPay() {
		return maternityPay;
	}

	public void setMaternityPay(BigDecimal maternityPay) {
		this.maternityPay = maternityPay;
	}

	public BigDecimal getCompPension() {
		return compPension;
	}

	public void setCompPension(BigDecimal compPension) {
		this.compPension = compPension;
	}

	public BigDecimal getCompUnemployInsur() {
		return compUnemployInsur;
	}

	public void setCompUnemployInsur(BigDecimal compUnemployInsur) {
		this.compUnemployInsur = compUnemployInsur;
	}

	public BigDecimal getCompIllness() {
		return compIllness;
	}

	public void setCompIllness(BigDecimal compIllness) {
		this.compIllness = compIllness;
	}

	public BigDecimal getCompMaternityInsur() {
		return compMaternityInsur;
	}

	public void setCompMaternityInsur(BigDecimal compMaternityInsur) {
		this.compMaternityInsur = compMaternityInsur;
	}

	public BigDecimal getCompInjuryInsur() {
		return compInjuryInsur;
	}

	public void setCompInjuryInsur(BigDecimal compInjuryInsur) {
		this.compInjuryInsur = compInjuryInsur;
	}

	public BigDecimal getCompHealthInsur() {
		return compHealthInsur;
	}

	public void setCompHealthInsur(BigDecimal compHealthInsur) {
		this.compHealthInsur = compHealthInsur;
	}

	public String getSocialSecurityBack() {
		return socialSecurityBack;
	}

	public void setSocialSecurityBack(String socialSecurityBack) {
		this.socialSecurityBack = (socialSecurityBack==null)?"":socialSecurityBack;
	}

	public BigDecimal getCompHousingFund() {
		return compHousingFund;
	}

	public void setCompHousingFund(BigDecimal compHousingFund) {
		this.compHousingFund = compHousingFund;
	}

	public BigDecimal getPersonalHousingFund() {
		return personalHousingFund;
	}

	public void setPersonalHousingFund(BigDecimal personalHousingFund) {
		this.personalHousingFund = personalHousingFund;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = (applyUser==null)?"":applyUser;
	}

	public BigDecimal getPointAdjust() {
		return pointAdjust;
	}

	public void setPointAdjust(BigDecimal pointAdjust) {
		this.pointAdjust = pointAdjust;
	}

	public Date getInjuryDate() {
		return injuryDate;
	}

	public void setInjuryDate(Date injuryDate) {
		this.injuryDate = injuryDate;
	}

	public String getInjuryMistakeDisposeNo() {
		return injuryMistakeDisposeNo;
	}

	public void setInjuryMistakeDisposeNo(String injuryMistakeDisposeNo) {
		this.injuryMistakeDisposeNo = (injuryMistakeDisposeNo==null)?"":injuryMistakeDisposeNo;
	}

	public BigDecimal getHospitalCost() {
		return hospitalCost;
	}

	public void setHospitalCost(BigDecimal hospitalCost) {
		this.hospitalCost = hospitalCost;
	}

	public BigDecimal getHospitalEscortFee() {
		return hospitalEscortFee;
	}

	public void setHospitalEscortFee(BigDecimal hospitalEscortFee) {
		this.hospitalEscortFee = hospitalEscortFee;
	}

	public BigDecimal getHospitalFoodAllowance() {
		return hospitalFoodAllowance;
	}

	public void setHospitalFoodAllowance(BigDecimal hospitalFoodAllowance) {
		this.hospitalFoodAllowance = hospitalFoodAllowance;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public String getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(String budgetType) {
		this.budgetType = (budgetType==null)?"":budgetType;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = (spouseName==null)?"":spouseName;
	}

	public String getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(String isStaff) {
		this.isStaff = (isStaff==null)?"":isStaff;
	}

	public String getSpouseJobno() {
		return spouseJobno;
	}

	public void setSpouseJobno(String spouseJobno) {
		this.spouseJobno = (spouseJobno==null)?"":spouseJobno;
	}

	public String getRegularWfNo() {
		return regularWfNo;
	}

	public void setRegularWfNo(String regularWfNo) {
		this.regularWfNo = (regularWfNo==null)?"":regularWfNo;
	}

	public String getCertifiedGradeCode() {
		return certifiedGradeCode;
	}

	public void setCertifiedGradeCode(String certifiedGradeCode) {
		this.certifiedGradeCode = (certifiedGradeCode==null)?"":certifiedGradeCode;
	}

	public String getCertifiedGradeName() {
		return certifiedGradeName;
	}

	public void setCertifiedGradeName(String certifiedGradeName) {
		this.certifiedGradeName = (certifiedGradeName==null)?"":certifiedGradeName;
	}

	public Date getChildBirthday() {
		return childBirthday;
	}

	public void setChildBirthday(Date childBirthday) {
		this.childBirthday = childBirthday;
	}

	public BigDecimal getAccommodationDeduction() {
		return accommodationDeduction;
	}

	public void setAccommodationDeduction(BigDecimal accommodationDeduction) {
		this.accommodationDeduction = accommodationDeduction;
	}

	public BigDecimal getActualLeaveCompensation() {
		return actualLeaveCompensation;
	}

	public void setActualLeaveCompensation(BigDecimal actualLeaveCompensation) {
		this.actualLeaveCompensation = actualLeaveCompensation;
	}

	public BigDecimal getActualSalary() {
		return actualSalary;
	}

	public void setActualSalary(BigDecimal actualSalary) {
		this.actualSalary = actualSalary;
	}

	public BigDecimal getAdvanceSalary() {
		return advanceSalary;
	}

	public void setAdvanceSalary(BigDecimal advanceSalary) {
		this.advanceSalary = advanceSalary;
	}

	public BigDecimal getOtherDeduction() {
		return otherDeduction;
	}

	public void setOtherDeduction(BigDecimal otherDeduction) {
		this.otherDeduction = otherDeduction;
	}

	public BigDecimal getBussinessVehicleDM() {
		return bussinessVehicleDM;
	}

	public void setBussinessVehicleDM(BigDecimal bussinessVehicleDM) {
		this.bussinessVehicleDM = bussinessVehicleDM;
	}

	public BigDecimal getCompensateLoss() {
		return compensateLoss;
	}

	public void setCompensateLoss(BigDecimal compensateLoss) {
		this.compensateLoss = compensateLoss;
	}

	public BigDecimal getCompensationTaxes() {
		return compensationTaxes;
	}

	public void setCompensationTaxes(BigDecimal compensationTaxes) {
		this.compensationTaxes = compensationTaxes;
	}

	public BigDecimal getContractLoan() {
		return contractLoan;
	}

	public void setContractLoan(BigDecimal contractLoan) {
		this.contractLoan = contractLoan;
	}

	public BigDecimal getDeductionPersonLoan() {
		return deductionPersonLoan;
	}

	public void setDeductionPersonLoan(BigDecimal deductionPersonLoan) {
		this.deductionPersonLoan = deductionPersonLoan;
	}

	public BigDecimal getDeductionPIncomeTax() {
		return deductionPIncomeTax;
	}

	public void setDeductionPIncomeTax(BigDecimal deductionPIncomeTax) {
		this.deductionPIncomeTax = deductionPIncomeTax;
	}

	public BigDecimal getDeductionReverse() {
		return deductionReverse;
	}

	public void setDeductionReverse(BigDecimal deductionReverse) {
		this.deductionReverse = deductionReverse;
	}

	public BigDecimal getDeductionSs() {
		return deductionSs;
	}

	public void setDeductionSs(BigDecimal deductionSs) {
		this.deductionSs = deductionSs;
	}

	public BigDecimal getDepositeRF() {
		return depositeRF;
	}

	public void setDepositeRF(BigDecimal depositeRF) {
		this.depositeRF = depositeRF;
	}

	public BigDecimal getEmployeeManualDeduction() {
		return employeeManualDeduction;
	}

	public void setEmployeeManualDeduction(BigDecimal employeeManualDeduction) {
		this.employeeManualDeduction = employeeManualDeduction;
	}

	public BigDecimal getFineDiscipline() {
		return fineDiscipline;
	}

	public void setFineDiscipline(BigDecimal fineDiscipline) {
		this.fineDiscipline = fineDiscipline;
	}

	public BigDecimal getIdentificationDeduction() {
		return identificationDeduction;
	}

	public void setIdentificationDeduction(BigDecimal identificationDeduction) {
		this.identificationDeduction = identificationDeduction;
	}

	public BigDecimal getIndustrialInjuryDeduction() {
		return industrialInjuryDeduction;
	}

	public void setIndustrialInjuryDeduction(BigDecimal industrialInjuryDeduction) {
		this.industrialInjuryDeduction = industrialInjuryDeduction;
	}

	public String getLeavePersonCertificate() {
		return leavePersonCertificate;
	}

	public void setLeavePersonCertificate(String leavePersonCertificate) {
		this.leavePersonCertificate = (leavePersonCertificate==null)?"":leavePersonCertificate;
	}

	public BigDecimal getLeavePersonSalary() {
		return leavePersonSalary;
	}

	public void setLeavePersonSalary(BigDecimal leavePersonSalary) {
		this.leavePersonSalary = leavePersonSalary;
	}
	public String getOtherDeductionRemark() {
		return otherDeductionRemark;
	}

	public void setOtherDeductionRemark(String otherDeductionRemark) {
		this.otherDeductionRemark = (otherDeductionRemark==null)?"":otherDeductionRemark;
	}

	public BigDecimal getPartyDeduction() {
		return partyDeduction;
	}

	public void setPartyDeduction(BigDecimal partyDeduction) {
		this.partyDeduction = partyDeduction;
	}

	public BigDecimal getPayingPhoneCharge() {
		return payingPhoneCharge;
	}

	public void setPayingPhoneCharge(BigDecimal payingPhoneCharge) {
		this.payingPhoneCharge = payingPhoneCharge;
	}

	public BigDecimal getPayRelationship() {
		return payRelationship;
	}

	public void setPayRelationship(BigDecimal payRelationship) {
		this.payRelationship = payRelationship;
	}

	public BigDecimal getPerformancePenalty() {
		return performancePenalty;
	}

	public void setPerformancePenalty(BigDecimal performancePenalty) {
		this.performancePenalty = performancePenalty;
	}

	public BigDecimal getPersonnelAgencyFee() {
		return personnelAgencyFee;
	}

	public void setPersonnelAgencyFee(BigDecimal personnelAgencyFee) {
		this.personnelAgencyFee = personnelAgencyFee;
	}

	public BigDecimal getReplacePersonLoan() {
		return replacePersonLoan;
	}

	public void setReplacePersonLoan(BigDecimal replacePersonLoan) {
		this.replacePersonLoan = replacePersonLoan;
	}

	public BigDecimal getRewardSum() {
		return rewardSum;
	}

	public void setRewardSum(BigDecimal rewardSum) {
		this.rewardSum = rewardSum;
	}

	public BigDecimal getShouldLeaveCompensation() {
		return shouldLeaveCompensation;
	}

	public void setShouldLeaveCompensation(BigDecimal shouldLeaveCompensation) {
		this.shouldLeaveCompensation = shouldLeaveCompensation;
	}

	public BigDecimal getShouldSum() {
		return shouldSum;
	}

	public void setShouldSum(BigDecimal shouldSum) {
		this.shouldSum = shouldSum;
	}

	public BigDecimal getTemporarySeizure() {
		return temporarySeizure;
	}

	public void setTemporarySeizure(BigDecimal temporarySeizure) {
		this.temporarySeizure = temporarySeizure;
	}

	public BigDecimal getWorkClothDeduction() {
		return workClothDeduction;
	}

	public void setWorkClothDeduction(BigDecimal workClothDeduction) {
		this.workClothDeduction = workClothDeduction;
	}

	public String getVisitationLevelCode() {
		return visitationLevelCode;
	}

	public void setVisitationLevelCode(String visitationLevelCode) {
		this.visitationLevelCode = visitationLevelCode;
	}

	public String getVisitationLevelName() {
		return visitationLevelName;
	}

	public void setVisitationLevelName(String visitationLevelName) {
		this.visitationLevelName = visitationLevelName;
	}

	public String getFamilyIsDepponEmployee() {
		return familyIsDepponEmployee;
	}

	public void setFamilyIsDepponEmployee(String familyIsDepponEmployee) {
		this.familyIsDepponEmployee = familyIsDepponEmployee;
	}

	public Date getMarryDate() {
		return marryDate;
	}

	public void setMarryDate(Date marryDate) {
		this.marryDate = marryDate;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyRelationCode() {
		return familyRelationCode;
	}

	public void setFamilyRelationCode(String familyRelationCode) {
		this.familyRelationCode = familyRelationCode;
	}

	public String getFamilyRelationName() {
		return familyRelationName;
	}

	public void setFamilyRelationName(String familyRelationName) {
		this.familyRelationName = familyRelationName;
	}

	public String getFamilyCityName() {
		return familyCityName;
	}

	public void setFamilyCityName(String familyCityName) {
		this.familyCityName = familyCityName;
	}

	public String getTransactionWorkflow() {
		return transactionWorkflow;
	}

	public void setTransactionWorkflow(String transactionWorkflow) {
		this.transactionWorkflow = transactionWorkflow;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getFamilyTrailingDate() {
		return familyTrailingDate;
	}

	public void setFamilyTrailingDate(Date familyTrailingDate) {
		this.familyTrailingDate = familyTrailingDate;
	}
	
	public String getIntoCompanyAccount() {
		return intoCompanyAccount;
	}
	
	public void setIntoCompanyAccount(String intoCompanyAccount) {
		this.intoCompanyAccount = intoCompanyAccount;
	}
	public BigDecimal getPayPersonTax() {
		return payPersonTax;
	}
	public BigDecimal getAnnualBonusPersonTax() {
		return annualBonusPersonTax;
	}
	public String getLearnCarApplyWF() {
		return learnCarApplyWF;
	}
	public Date getLearnCarGraduDate() {
		return learnCarGraduDate;
	}
	public BigDecimal getLearnCarAmount() {
		return learnCarAmount;
	}
	public BigDecimal getOneDisabilityBenefit() {
		return oneDisabilityBenefit;
	}
	public BigDecimal getOneMedicaltreatment() {
		return oneMedicaltreatment;
	}
	public BigDecimal getOneObtainEmployment() {
		return oneObtainEmployment;
	}
	public BigDecimal getEconomicCompensation() {
		return economicCompensation;
	}
	public BigDecimal getHumanizedSubsidie() {
		return humanizedSubsidie;
	}
	public String getBelongSystemName() {
		return belongSystemName;
	}
	public String getBelongSystemCode() {
		return belongSystemCode;
	}
	public void setPayPersonTax(BigDecimal payPersonTax) {
		this.payPersonTax = payPersonTax;
	}
	public void setAnnualBonusPersonTax(BigDecimal annualBonusPersonTax) {
		this.annualBonusPersonTax = annualBonusPersonTax;
	}
	public void setLearnCarApplyWF(String learnCarApplyWF) {
		this.learnCarApplyWF = learnCarApplyWF;
	}
	public void setLearnCarGraduDate(Date learnCarGraduDate) {
		this.learnCarGraduDate = learnCarGraduDate;
	}
	public void setLearnCarAmount(BigDecimal learnCarAmount) {
		this.learnCarAmount = learnCarAmount;
	}
	public void setOneDisabilityBenefit(BigDecimal oneDisabilityBenefit) {
		this.oneDisabilityBenefit = oneDisabilityBenefit;
	}
	public void setOneMedicaltreatment(BigDecimal oneMedicaltreatment) {
		this.oneMedicaltreatment = oneMedicaltreatment;
	}
	public void setOneObtainEmployment(BigDecimal oneObtainEmployment) {
		this.oneObtainEmployment = oneObtainEmployment;
	}
	public void setEconomicCompensation(BigDecimal economicCompensation) {
		this.economicCompensation = economicCompensation;
	}
	public void setHumanizedSubsidie(BigDecimal humanizedSubsidie) {
		this.humanizedSubsidie = humanizedSubsidie;
	}
	public void setBelongSystemName(String belongSystemName) {
		this.belongSystemName = belongSystemName;
	}
	public void setBelongSystemCode(String belongSystemCode) {
		this.belongSystemCode = belongSystemCode;
	}
}
