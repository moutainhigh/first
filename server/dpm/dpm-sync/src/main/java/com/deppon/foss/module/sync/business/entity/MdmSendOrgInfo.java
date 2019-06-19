package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;

public class MdmSendOrgInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8998243297473798132L;
	//ID
	private String orgChangeId;
	//机构id
	private int orgId;
	//机构编码
	private String orgCode;
	//机构名称
	private String orgName;
	//机构性质
	private String deptAttribute;
	//机构性质对应编码
	private String orgBenchmarkCode;
	//组织负责人工号
	private String orgManager;
	//部门联系电话
	private String orgPhone;
	//部门传真
	private String orgFax;
	//上级机构id
	private int parentOrgId;
	//上级机构组织标杆编码
	private String parentOrgStandCode;
	//所属子公司名称
	private String subCompName;
	//所属子公司编码
	private String orgCompanyCode;
	//邮编号码
	private String orgZipCode;
	//组织邮箱
	private String orgEmail;
	//部门地址
	private String orgAddress;
	//组织状态
	private int orgStatus;
	//是否事业部
	private String isDivision;
	//部门所有上级组织的id
	private String deptSeq;
	//部门层级
	private int orgLevel;
	//部门描述
	private String deptDesc;
	//是否为叶子节点
	private boolean isLeaf;
	//财务部门性质
	private String finDeptAttribute;
	//是否空运总调
	private String airDispatch;
	//理货业务类型
	private String arrangeBizType;
	//理货部门服务外场组织编码
	private String arrangeOutField;
	//是否集中开单组
	private String billingGroup;
	//补码简称
	private String complementSimpleName;
	//国家地区
	private String countryRegion;
	//派送排单服务外场组织编码
	private String deliverOutField;
	//部门服务区坐标编号
	private String depCoordinate;
	//部门面积
	private Double deptArea;
	//城市编码
	private String cityCode;
	//区县编码
	private String countyCode;
	//省份编码
	private String provCode;
	//是否车队调度组
	private String dispatchTeam;
	//是否可空运配载
	private String doAirDispatch;
	//是否快递大区
	private String isExpressRegion;
	//是否快递分部
	private String isExpressBranch;
	//是否快递点部
	private String isExpressPart;
	//是否快递虚拟营业部
	private String isvirualLading;
	//是否快递分拎
	private String isExpressSorting;
	//是否理货
	private String isArrangeGoods;
	//是否派送排单
	private String isDeliverSchedule;
	//是否实体财务部
	private String isEntityFinance;
	//是否营业大区
	private String bigRegion;
	//是否保安组
	private String isSecurity;
	//是否营业小区
	private String smallRegion;
	//组织拼音
	private String pinYin;
	//是否营业部派送部
	private String salesDepartment;
	//是否车队
	private String transDepartment;
	//是否车队组
	private String transTeam;
	//是否外场
	private String transferCenter;
	//是否启用
	private String active;
	//开始时间
	private String beginTime;
	//创建人
	private String createUser;
	//创建时间
	private String createDate;
	//结束时间
	private String endTime;
	//最后修改时间
	private String modifyDate;
	//最后修改人
	private String modifyUser;
	//上级组织编码
	private String parentOrgCode;
	//上级组织名称
	private String parentOrgName;
	//部门简称
	private String deptShortName;
	//组织性质编码
	private int deptAttributeNo;
	//事业部编码
	private String divisionCode;
	//机构编码
	private String deptStandCode;
	//是否合伙人
	private String isPartner;
	//是否外发网点
	private String isExternalPoint;
	//是否境外网点
	private String isOutlets;
	//是否显示
	private String isShow;
	//是否合作网点
	private String isNetwork;
	//备用字段
	private String spare;
	//是否虚拟部门
	private String isVirtualDepartment;
	
	public String getIsPartner() {
		return isPartner;
	}
	public void setIsPartner(String isPartner) {
		this.isPartner = isPartner;
	}
	public String getIsExternalPoint() {
		return isExternalPoint;
	}
	public void setIsExternalPoint(String isExternalPoint) {
		this.isExternalPoint = isExternalPoint;
	}
	public String getIsOutlets() {
		return isOutlets;
	}
	public void setIsOutlets(String isOutlets) {
		this.isOutlets = isOutlets;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getIsNetwork() {
		return isNetwork;
	}
	public void setIsNetwork(String isNetwork) {
		this.isNetwork = isNetwork;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public String getIsVirtualDepartment() {
		return isVirtualDepartment;
	}
	public void setIsVirtualDepartment(String isVirtualDepartment) {
		this.isVirtualDepartment = isVirtualDepartment;
	}
	public String getDeptStandCode() {
		return deptStandCode;
	}
	public void setDeptStandCode(String deptStandCode) {
		this.deptStandCode = deptStandCode;
	}
	public String getOrgChangeId() {
		return orgChangeId;
	}
	public void setOrgChangeId(String orgChangeId) {
		this.orgChangeId = orgChangeId;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getDeptAttribute() {
		return deptAttribute;
	}
	public void setDeptAttribute(String deptAttribute) {
		this.deptAttribute = deptAttribute;
	}
	public String getOrgBenchmarkCode() {
		return orgBenchmarkCode;
	}
	public void setOrgBenchmarkCode(String orgBenchmarkCode) {
		this.orgBenchmarkCode = orgBenchmarkCode;
	}
	public String getOrgManager() {
		return orgManager;
	}
	public void setOrgManager(String orgManager) {
		this.orgManager = orgManager;
	}
	public String getOrgPhone() {
		return orgPhone;
	}
	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}
	public String getOrgFax() {
		return orgFax;
	}
	public void setOrgFax(String orgFax) {
		this.orgFax = orgFax;
	}
	public int getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(int parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	public String getParentOrgStandCode() {
		return parentOrgStandCode;
	}
	public void setParentOrgStandCode(String parentOrgStandCode) {
		this.parentOrgStandCode = parentOrgStandCode;
	}
	public String getSubCompName() {
		return subCompName;
	}
	public void setSubCompName(String subCompName) {
		this.subCompName = subCompName;
	}
	public String getOrgCompanyCode() {
		return orgCompanyCode;
	}
	public void setOrgCompanyCode(String orgCompanyCode) {
		this.orgCompanyCode = orgCompanyCode;
	}
	public String getOrgZipCode() {
		return orgZipCode;
	}
	public void setOrgZipCode(String orgZipCode) {
		this.orgZipCode = orgZipCode;
	}
	public String getOrgEmail() {
		return orgEmail;
	}
	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
	public String getOrgAddress() {
		return orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	public int getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(int orgStatus) {
		this.orgStatus = orgStatus;
	}
	public String getIsDivision() {
		return isDivision;
	}
	public void setIsDivision(String isDivision) {
		this.isDivision = isDivision;
	}
	public String getDeptSeq() {
		return deptSeq;
	}
	public void setDeptSeq(String deptSeq) {
		this.deptSeq = deptSeq;
	}
	public int getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(int orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getFinDeptAttribute() {
		return finDeptAttribute;
	}
	public void setFinDeptAttribute(String finDeptAttribute) {
		this.finDeptAttribute = finDeptAttribute;
	}
	public String getAirDispatch() {
		return airDispatch;
	}
	public void setAirDispatch(String airDispatch) {
		this.airDispatch = airDispatch;
	}
	public String getArrangeBizType() {
		return arrangeBizType;
	}
	public void setArrangeBizType(String arrangeBizType) {
		this.arrangeBizType = arrangeBizType;
	}
	public String getArrangeOutField() {
		return arrangeOutField;
	}
	public void setArrangeOutField(String arrangeOutField) {
		this.arrangeOutField = arrangeOutField;
	}
	public String getBillingGroup() {
		return billingGroup;
	}
	public void setBillingGroup(String billingGroup) {
		this.billingGroup = billingGroup;
	}
	public String getComplementSimpleName() {
		return complementSimpleName;
	}
	public void setComplementSimpleName(String complementSimpleName) {
		this.complementSimpleName = complementSimpleName;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getDeliverOutField() {
		return deliverOutField;
	}
	public void setDeliverOutField(String deliverOutField) {
		this.deliverOutField = deliverOutField;
	}
	public String getDepCoordinate() {
		return depCoordinate;
	}
	public void setDepCoordinate(String depCoordinate) {
		this.depCoordinate = depCoordinate;
	}
	public Double getDeptArea() {
		return deptArea;
	}
	public void setDeptArea(Double deptArea) {
		this.deptArea = deptArea;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getProvCode() {
		return provCode;
	}
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}
	public String getDispatchTeam() {
		return dispatchTeam;
	}
	public void setDispatchTeam(String dispatchTeam) {
		this.dispatchTeam = dispatchTeam;
	}
	public String getDoAirDispatch() {
		return doAirDispatch;
	}
	public void setDoAirDispatch(String doAirDispatch) {
		this.doAirDispatch = doAirDispatch;
	}
	public String getIsExpressRegion() {
		return isExpressRegion;
	}
	public void setIsExpressRegion(String isExpressRegion) {
		this.isExpressRegion = isExpressRegion;
	}
	public String getIsExpressBranch() {
		return isExpressBranch;
	}
	public void setIsExpressBranch(String isExpressBranch) {
		this.isExpressBranch = isExpressBranch;
	}
	public String getIsExpressPart() {
		return isExpressPart;
	}
	public void setIsExpressPart(String isExpressPart) {
		this.isExpressPart = isExpressPart;
	}
	public String getIsvirualLading() {
		return isvirualLading;
	}
	public void setIsvirualLading(String isvirualLading) {
		this.isvirualLading = isvirualLading;
	}
	public String getIsExpressSorting() {
		return isExpressSorting;
	}
	public void setIsExpressSorting(String isExpressSorting) {
		this.isExpressSorting = isExpressSorting;
	}
	public String getIsArrangeGoods() {
		return isArrangeGoods;
	}
	public void setIsArrangeGoods(String isArrangeGoods) {
		this.isArrangeGoods = isArrangeGoods;
	}
	public String getIsDeliverSchedule() {
		return isDeliverSchedule;
	}
	public void setIsDeliverSchedule(String isDeliverSchedule) {
		this.isDeliverSchedule = isDeliverSchedule;
	}
	public String getIsEntityFinance() {
		return isEntityFinance;
	}
	public void setIsEntityFinance(String isEntityFinance) {
		this.isEntityFinance = isEntityFinance;
	}
	public String getBigRegion() {
		return bigRegion;
	}
	public void setBigRegion(String bigRegion) {
		this.bigRegion = bigRegion;
	}
	public String getIsSecurity() {
		return isSecurity;
	}
	public void setIsSecurity(String isSecurity) {
		this.isSecurity = isSecurity;
	}
	public String getSmallRegion() {
		return smallRegion;
	}
	public void setSmallRegion(String smallRegion) {
		this.smallRegion = smallRegion;
	}
	public String getPinYin() {
		return pinYin;
	}
	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}
	public String getSalesDepartment() {
		return salesDepartment;
	}
	public void setSalesDepartment(String salesDepartment) {
		this.salesDepartment = salesDepartment;
	}
	public String getTransDepartment() {
		return transDepartment;
	}
	public void setTransDepartment(String transDepartment) {
		this.transDepartment = transDepartment;
	}
	public String getTransTeam() {
		return transTeam;
	}
	public void setTransTeam(String transTeam) {
		this.transTeam = transTeam;
	}
	public String getTransferCenter() {
		return transferCenter;
	}
	public void setTransferCenter(String transferCenter) {
		this.transferCenter = transferCenter;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public String getParentOrgCode() {
		return parentOrgCode;
	}
	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}
	public String getParentOrgName() {
		return parentOrgName;
	}
	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}
	public String getDeptShortName() {
		return deptShortName;
	}
	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName;
	}
	public int getDeptAttributeNo() {
		return deptAttributeNo;
	}
	public void setDeptAttributeNo(int deptAttributeNo) {
		this.deptAttributeNo = deptAttributeNo;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
