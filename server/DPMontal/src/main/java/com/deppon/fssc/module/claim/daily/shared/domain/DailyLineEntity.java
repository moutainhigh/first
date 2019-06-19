package com.deppon.fssc.module.claim.daily.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.fssc.module.claimsupport.shared.domain.ClaimLineBaseEntity;

/**
 * 
 *<pre>
 *功能:日常报账单专用表Entity
 *作者：龚子洋
 *日期：2013-4-10下午3:09:57
 *</pre>
 */

public class DailyLineEntity extends ClaimLineBaseEntity implements Serializable{

	//序列化
	private static final long serialVersionUID = -4283473263390405759L;
	
	// Fields
	
	//报账单行ID
	private String claimLineId;
	
	//找点起始日期
	private Date findStartTime;
	
	//找点结束日期
	private Date findEndTime;
	
	//找点补贴金额
	private BigDecimal findSubsidy;
	
	//住宿补贴金额
	private BigDecimal staySubsidy;
	
	//话费补贴金额
	private BigDecimal phoneSubsidy;
	
	//新营业部名称
	private String newSalesDept;
	
	//工作流号
	private String workFlowId;
	
	//交通工具VALUE
	private String transportationValue;
	
	//起始地
	private String startPlace;
	
	//到达地
	private String endPlace;
	
	//陪同人
	private String accompanyEmp;
	
	//陪同人工号
	private String accompanyEmpCode;
	
	//押金项目TYPE_VALUE
	private String foregiftProjectValue;
	
	//押金项目TYPE_NAME
	private String foregiftProjectName;
	
	//责任人
	private String dutyEmp;
	
	//责任人工号
	private String dutyEmpCode;
	
	//责任部门标杆编码
	private String dutyDeptcode;
	
	//责任部门
	private String dutyDept;
	
	//收款方编码
	private String geterCode;
	
	//收取方名称
	private String geterName;
	
	//收取方身份证
	private String geterIdcard;
	
	//收取方电话
	private String geterPhone;
	
	//收取方地址
	private String geterAddress;
	
	//客户
	private String customer;
	
	//差错处理编号
	private String mistakeCode;
	
	//保证金项目TYPE_VALUE
	private String cautionProjectValue;
	
	//保证金项目TYPE_NAME
	private String cautionProjectName;
	
	//车牌号
	private String plateNumber;
	
	//车型TYPE_VALUE
	private String carTypeValue;
	
	//车型TYPE_NAME
	private String carTypeName;
	
	//出车性质TYPE_VALUE
	private String dctTypeValue;
	
	//出车性质TYPE_NAME
	private String dctTypeName;
	
	//线路TYPE_VALUE
	private String routeValue;
	
	//线路TYPE_NAME
	private String routeName;
	
	//所属子公司
	private String subjectionCompany;
	
	//所属部门
	private String subjectionDept;
	
	//公司承担部分
	private BigDecimal bearOfCompany;
	
	//个人承担部分
	private BigDecimal bearOfPersonal;
	
	//汇款编号
	private String remittanceNumber;
	
	//业务性质
	private String natureOfBusiness;
	
	//姓名
	private String empName;
	
	//工号
	private String empCode;
	
	//酒店名称
	private String hoteName;
	
	//是否协议酒店
	private String isPactHote;
	
	//洗车商名称
	private String carWashSupplier;
	
	//洗车商电话
	private String cwsPhone;
	
	//洗车次数
	private BigDecimal carWashCount;
	
	//是否摊销
	private String isAmorttization;
	
	//摊销总期数
	private BigDecimal amorttizationCount;
	
	//抵税成本类型VALUE
	private String offsetTaxValue;
	
	//抵税成本类型NAME
	private String offsetTaxName;
	
	//运单号
	private BigDecimal transportNumber;
	
	//项目VALUE
	private String projectValue;
	
	//项目NAME
	private String projectName;
	
	//交通工具NAME
	private String transportationName;
	
	//供应商名称VALUE
	private String suppliersValue;
	
	//供应商名称NAME
	private String suppliersName;
	
	//押金缴纳日
	private Date foregiftStartTime;
	
	//押金到期日
	private Date foregiftEndTime;
	
	//保证金缴纳日
	private Date promiseStartTime;
	
	//保证金到期日
	private Date promiseEndTime;
	
	//摊销开始期间
	private Date amorttizationBegin;
	
	//摊销结束期间
	private Date amorttizationEnd;
	
	//质保开始日期
	private Date qualityBegin;
	
	//质保结束日期
	private Date qualityEnd;
	
	//返还比例
	private BigDecimal rturnProportion;

	//本次应返金额
	private BigDecimal shouldReturn;
	
	//预计返还时间
	private Date predictRetime; 
	
	//累计实缴金额
	private BigDecimal accpaidin;
	
	//累计应返金额
	private BigDecimal accback;
		
	//累计实返金额
	private BigDecimal accrealback;
				
	//未返还金额
	private BigDecimal notreturn;
	
	//是否质保期间
	private String isquality;
	
	//是否理赔
	private String isclaims;
	
	//是否增值税专用发票
	private String isvat;
	
	//增值税发票号码
	private String invatnum;
		
	//不含税金额
	private BigDecimal taxfreeprice;
		
	//税额
	private BigDecimal taxprice;
	//差额
	private BigDecimal balanceprice;
	
	//客户编码
	private String customerCode;
	//岗位
	private String position;
	//入职日期
	private String indate;
	//补贴标准
	private String subsidy;
	//手机号码
	private String phoneNum;
	//外请申请人数
	private BigDecimal foreignAidNum;
	//外请预计费用
	private BigDecimal foreignAidAmount;
	//实际使用人数
	private BigDecimal realityNum;
	
	public String getClaimLineId() {
		return this.claimLineId;
	}

	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}


	public BigDecimal getFindSubsidy() {
		return this.findSubsidy;
	}

	public void setFindSubsidy(BigDecimal findSubsidy) {
		this.findSubsidy = findSubsidy;
	}

	public BigDecimal getStaySubsidy() {
		return this.staySubsidy;
	}

	public void setStaySubsidy(BigDecimal staySubsidy) {
		this.staySubsidy = staySubsidy;
	}

	public BigDecimal getPhoneSubsidy() {
		return this.phoneSubsidy;
	}

	public void setPhoneSubsidy(BigDecimal phoneSubsidy) {
		this.phoneSubsidy = phoneSubsidy;
	}

	public String getNewSalesDept() {
		return this.newSalesDept;
	}

	public void setNewSalesDept(String newSalesDept) {
		this.newSalesDept = newSalesDept;
	}

	public String getWorkFlowId() {
		return this.workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getTransportationValue() {
		return this.transportationValue;
	}

	public void setTransportationValue(String transportationValue) {
		this.transportationValue = transportationValue;
	}


	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return this.endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}


	public String getForegiftProjectValue() {
		return this.foregiftProjectValue;
	}

	public void setForegiftProjectValue(String foregiftProjectValue) {
		this.foregiftProjectValue = foregiftProjectValue;
	}

	public String getForegiftProjectName() {
		return this.foregiftProjectName;
	}

	public void setForegiftProjectName(String foregiftProjectName) {
		this.foregiftProjectName = foregiftProjectName;
	}


	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public String getCautionProjectValue() {
		return this.cautionProjectValue;
	}

	public void setCautionProjectValue(String cautionProjectValue) {
		this.cautionProjectValue = cautionProjectValue;
	}

	public String getCautionProjectName() {
		return this.cautionProjectName;
	}

	public void setCautionProjectName(String cautionProjectName) {
		this.cautionProjectName = cautionProjectName;
	}

	public String getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getCarTypeValue() {
		return this.carTypeValue;
	}

	public void setCarTypeValue(String carTypeValue) {
		this.carTypeValue = carTypeValue;
	}

	public String getCarTypeName() {
		return this.carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getDctTypeValue() {
		return this.dctTypeValue;
	}

	public void setDctTypeValue(String dctTypeValue) {
		this.dctTypeValue = dctTypeValue;
	}

	public String getDctTypeName() {
		return this.dctTypeName;
	}

	public void setDctTypeName(String dctTypeName) {
		this.dctTypeName = dctTypeName;
	}

	public String getRouteValue() {
		return this.routeValue;
	}

	public void setRouteValue(String routeValue) {
		this.routeValue = routeValue;
	}

	public String getRouteName() {
		return this.routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getSubjectionCompany() {
		return this.subjectionCompany;
	}

	public void setSubjectionCompany(String subjectionCompany) {
		this.subjectionCompany = subjectionCompany;
	}

	public String getSubjectionDept() {
		return this.subjectionDept;
	}

	public void setSubjectionDept(String subjectionDept) {
		this.subjectionDept = subjectionDept;
	}

	public BigDecimal getBearOfCompany() {
		return this.bearOfCompany;
	}

	public void setBearOfCompany(BigDecimal bearOfCompany) {
		this.bearOfCompany = bearOfCompany;
	}

	public BigDecimal getBearOfPersonal() {
		return this.bearOfPersonal;
	}

	public void setBearOfPersonal(BigDecimal bearOfPersonal) {
		this.bearOfPersonal = bearOfPersonal;
	}

	public String getRemittanceNumber() {
		return this.remittanceNumber;
	}

	public void setRemittanceNumber(String remittanceNumber) {
		this.remittanceNumber = remittanceNumber;
	}

	public String getNatureOfBusiness() {
		return this.natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getHoteName() {
		return this.hoteName;
	}

	public void setHoteName(String hoteName) {
		this.hoteName = hoteName;
	}

	public String getIsPactHote() {
		return this.isPactHote;
	}

	public void setIsPactHote(String isPactHote) {
		this.isPactHote = isPactHote;
	}

	public String getCarWashSupplier() {
		return this.carWashSupplier;
	}

	public void setCarWashSupplier(String carWashSupplier) {
		this.carWashSupplier = carWashSupplier;
	}

	public String getCwsPhone() {
		return this.cwsPhone;
	}

	public void setCwsPhone(String cwsPhone) {
		this.cwsPhone = cwsPhone;
	}

	public BigDecimal getCarWashCount() {
		return this.carWashCount;
	}

	public void setCarWashCount(BigDecimal carWashCount) {
		this.carWashCount = carWashCount;
	}

	public String getIsAmorttization() {
		return this.isAmorttization;
	}

	public void setIsAmorttization(String isAmorttization) {
		this.isAmorttization = isAmorttization;
	}

	public BigDecimal getAmorttizationCount() {
		return this.amorttizationCount;
	}

	public void setAmorttizationCount(BigDecimal amorttizationCount) {
		this.amorttizationCount = amorttizationCount;
	}

	public String getOffsetTaxValue() {
		return this.offsetTaxValue;
	}

	public void setOffsetTaxValue(String offsetTaxValue) {
		this.offsetTaxValue = offsetTaxValue;
	}

	public String getOffsetTaxName() {
		return this.offsetTaxName;
	}

	public void setOffsetTaxName(String offsetTaxName) {
		this.offsetTaxName = offsetTaxName;
	}

	public BigDecimal getTransportNumber() {
		return this.transportNumber;
	}

	public void setTransportNumber(BigDecimal transportNumber) {
		this.transportNumber = transportNumber;
	}

	public String getProjectValue() {
		return this.projectValue;
	}

	public void setProjectValue(String projectValue) {
		this.projectValue = projectValue;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTransportationName() {
		return this.transportationName;
	}

	public void setTransportationName(String transportationName) {
		this.transportationName = transportationName;
	}

	public String getSuppliersValue() {
		return this.suppliersValue;
	}

	public void setSuppliersValue(String suppliersValue) {
		this.suppliersValue = suppliersValue;
	}

	public String getSuppliersName() {
		return this.suppliersName;
	}

	public void setSuppliersName(String suppliersName) {
		this.suppliersName = suppliersName;
	}

	
	
	public Date getForegiftStartTime() {
		return foregiftStartTime;
	}

	public void setForegiftStartTime(Date foregiftStartTime) {
		this.foregiftStartTime = foregiftStartTime;
	}

	public Date getForegiftEndTime() {
		return foregiftEndTime;
	}

	public void setForegiftEndTime(Date foregiftEndTime) {
		this.foregiftEndTime = foregiftEndTime;
	}

	public Date getPromiseStartTime() {
		return promiseStartTime;
	}

	public void setPromiseStartTime(Date promiseStartTime) {
		this.promiseStartTime = promiseStartTime;
	}

	public Date getPromiseEndTime() {
		return promiseEndTime;
	}

	public void setPromiseEndTime(Date promiseEndTime) {
		this.promiseEndTime = promiseEndTime;
	}

	public Date getAmorttizationBegin() {
		return amorttizationBegin;
	}

	public void setAmorttizationBegin(Date amorttizationBegin) {
		this.amorttizationBegin = amorttizationBegin;
	}

	public Date getAmorttizationEnd() {
		return amorttizationEnd;
	}

	public void setAmorttizationEnd(Date amorttizationEnd) {
		this.amorttizationEnd = amorttizationEnd;
	}

	public Date getQualityBegin() {
		return qualityBegin;
	}

	public void setQualityBegin(Date qualityBegin) {
		this.qualityBegin = qualityBegin;
	}

	public Date getQualityEnd() {
		return qualityEnd;
	}

	public void setQualityEnd(Date qualityEnd) {
		this.qualityEnd = qualityEnd;
	}

	public Date getFindStartTime() {
		return findStartTime;
	}

	public void setFindStartTime(Date findStartTime) {
		this.findStartTime = findStartTime;
	}

	public Date getFindEndTime() {
		return findEndTime;
	}

	public void setFindEndTime(Date findEndTime) {
		this.findEndTime = findEndTime;
	}

	public String getAccompanyEmp() {
		return accompanyEmp;
	}

	public void setAccompanyEmp(String accompanyEmp) {
		this.accompanyEmp = accompanyEmp;
	}

	public String getAccompanyEmpCode() {
		return accompanyEmpCode;
	}

	public void setAccompanyEmpCode(String accompanyEmpCode) {
		this.accompanyEmpCode = accompanyEmpCode;
	}

	public String getDutyEmp() {
		return dutyEmp;
	}

	public void setDutyEmp(String dutyEmp) {
		this.dutyEmp = dutyEmp;
	}

	public String getDutyEmpCode() {
		return dutyEmpCode;
	}

	public void setDutyEmpCode(String dutyEmpCode) {
		this.dutyEmpCode = dutyEmpCode;
	}

	public String getDutyDeptcode() {
		return dutyDeptcode;
	}

	public void setDutyDeptcode(String dutyDeptcode) {
		this.dutyDeptcode = dutyDeptcode;
	}

	public String getDutyDept() {
		return dutyDept;
	}

	public void setDutyDept(String dutyDept) {
		this.dutyDept = dutyDept;
	}

	public String getGeterName() {
		return geterName;
	}

	public void setGeterName(String geterName) {
		this.geterName = geterName;
	}

	public String getGeterIdcard() {
		return geterIdcard;
	}

	public void setGeterIdcard(String geterIdcard) {
		this.geterIdcard = geterIdcard;
	}

	public String getGeterPhone() {
		return geterPhone;
	}

	public void setGeterPhone(String geterPhone) {
		this.geterPhone = geterPhone;
	}

	public String getGeterAddress() {
		return geterAddress;
	}

	public void setGeterAddress(String geterAddress) {
		this.geterAddress = geterAddress;
	}

	public String getMistakeCode() {
		return mistakeCode;
	}

	public void setMistakeCode(String mistakeCode) {
		this.mistakeCode = mistakeCode;
	}

	public BigDecimal getRturnProportion() {
		return rturnProportion;
	}

	public void setRturnProportion(BigDecimal rturnProportion) {
		this.rturnProportion = rturnProportion;
	}

	public BigDecimal getShouldReturn() {
		return shouldReturn;
	}

	public void setShouldReturn(BigDecimal shouldReturn) {
		this.shouldReturn = shouldReturn;
	}

	public Date getPredictRetime() {
		return predictRetime;
	}

	public void setPredictRetime(Date predictRetime) {
		this.predictRetime = predictRetime;
	}

	public BigDecimal getAccpaidin() {
		return accpaidin;
	}

	public void setAccpaidin(BigDecimal accpaidin) {
		this.accpaidin = accpaidin;
	}

	public BigDecimal getAccback() {
		return accback;
	}

	public void setAccback(BigDecimal accback) {
		this.accback = accback;
	}

	public BigDecimal getAccrealback() {
		return accrealback;
	}

	public void setAccrealback(BigDecimal accrealback) {
		this.accrealback = accrealback;
	}

	public BigDecimal getNotreturn() {
		return notreturn;
	}

	public void setNotreturn(BigDecimal notreturn) {
		this.notreturn = notreturn;
	}

	public String getIsquality() {
		return isquality;
	}

	public void setIsquality(String isquality) {
		this.isquality = isquality;
	}

	public String getIsclaims() {
		return isclaims;
	}

	public void setIsclaims(String isclaims) {
		this.isclaims = isclaims;
	}

	public String getIsvat() {
		return isvat;
	}

	public void setIsvat(String isvat) {
		this.isvat = isvat;
	}

	public String getInvatnum() {
		return invatnum;
	}

	public void setInvatnum(String invatnum) {
		this.invatnum = invatnum;
	}

	public BigDecimal getTaxfreeprice() {
		return taxfreeprice;
	}

	public void setTaxfreeprice(BigDecimal taxfreeprice) {
		this.taxfreeprice = taxfreeprice;
	}

	public BigDecimal getTaxprice() {
		return taxprice;
	}

	public void setTaxprice(BigDecimal taxprice) {
		this.taxprice = taxprice;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getGeterCode() {
		return geterCode;
	}

	public void setGeterCode(String geterCode) {
		this.geterCode = geterCode;
	}

	public BigDecimal getBalanceprice() {
		return balanceprice;
	}

	public void setBalanceprice(BigDecimal balanceprice) {
		this.balanceprice = balanceprice;
	}

	public String getPosition() {
		return position;
	}

	public String getIndate() {
		return indate;
	}

	public String getSubsidy() {
		return subsidy;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public BigDecimal getForeignAidNum() {
		return foreignAidNum;
	}

	public BigDecimal getForeignAidAmount() {
		return foreignAidAmount;
	}

	public BigDecimal getRealityNum() {
		return realityNum;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public void setSubsidy(String subsidy) {
		this.subsidy = subsidy;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setForeignAidNum(BigDecimal foreignAidNum) {
		this.foreignAidNum = foreignAidNum;
	}

	public void setForeignAidAmount(BigDecimal foreignAidAmount) {
		this.foreignAidAmount = foreignAidAmount;
	}

	public void setRealityNum(BigDecimal realityNum) {
		this.realityNum = realityNum;
	}
}

