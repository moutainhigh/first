package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @title: YardRentInfo 
 * @description：场地租赁合同申请信息实体（场地租赁/转租合同起草工作流）
 * @author： wuyaqing
 * @date： 2013-9-5 下午05:10:23
 */
/**
 * 命名空间
 */

public class YardRentBean implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -9204469580651639740L;
	
	/**
	 * 主键ID
	 */
	//注解

	private String busino;
	/**
	 * 流程实例ID
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
	 * 业务类型
	 */
	private String busiType;
	/**
	 * 所属财务部标杆编码
	 */
	private String financeCode;
	/**
	 * 租赁开始日期
	 */
	private Date startDate;
	/**
	 * 租赁结束日期
	 */
	private Date endDate;
	/**
	 * 所属事业部标杆编码
	 */
	private String divisionCode;
	/**
	 * 所属公共事务组标杆编码
	 */
	private String affairsCode;
	/**
	 * 签订类型
	 */
	private String signType;
	/**
	 * 所属子公司标准编码
	 */
	private String subComCode;
	/**
	 * 租赁出租方名称
	 */
	private String yrentName;
	/**
	 * 转租出租方名称
	 */
	private String prentName;
	/**
	 * 承租方名称
	 */
	private String leaseName;
	/**
	 * 承租部门
	 */
	private String leaseDept;
	/**
	 * 承租房屋面积
	 */
	private String leaseArea;
	/**
	 * 每年租金
	 */
	private String yearRental;
	/**
	 * 总金额
	 */
	private String totalAmount;
	/**
	 * 付款方式
	 */
	private String payType;
	/**
	 * 免租开始日期
	 */
	private Date freeStartDate;
	/**
	 * 免租结束日期
	 */
	private Date freeEndDdate;
	/**
	 * 租赁类型
	 */
	private String leaseType;
	/**
	 * 工程项目编号
	 */
	private String projectID;
	/**
	 * 工程项目名称
	 */
	private String projectName;
	/**
	 * 押金金额
	 */
	private String depositAmount;
	/**
	 * 优先盖章方
	 */
	private String yfirstChop;
	/**
	 * 优先盖章方
	 */
	private String pfirstChop;
	/**
	 * 申请事由
	 */
	private String applyReason;
	/**
	 * 承租方主要业务
	 */
	private String leaseBussiness;
	/**
	 * 是否改造（1-是，2-否）
	 */
	private String isChange;
	/**
	 * 改造金额
	 */
	private BigDecimal changeAmt;
	/**
	 * 转租部门
	 */
	private String subletDept;
	/**
	 * 转租部门代码
	 */
	private String subletDeptCode;
	/**
	 * 付款月数
	 */
	private Long payMonths;
	/**
	 * 原租赁面积
	 */
	private BigDecimal oldLeaseArea;
	/**
	 * 原租赁单价
	 */
	private BigDecimal oldLeasePrice;
	/**
	 * 现租赁面积
	 */
	private BigDecimal newLeaseArea;
	/**
	 * 现租赁单价
	 */
	private BigDecimal newLeasePrice;
	/**
	 * 原合同编号
	 */
	private String oldContarctNO;
	/**
	 * 所属区域(旧有新无)
	 */
	private String area;
	/**
	 * 同意时间(旧有新无)
	 */
	private Date argreeTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 业务状态，是否有效（1-有效 0-无效）
	 */
	private String isEffective;
	/**
	 * 备注1
	 */
	private Long reserve1;
	/**
	 * 备注2
	 */
	private String reserve2;
	/**
	 * 备注3
	 */
	private String reserve3;
	
	/**
	 * vo
	 */
	//业务类型
	private String busiTypeName;
	//所属财务部
	private String financeName;
	//所属事业部
	private String divisionName;
	//所属公共事务组
	private String affairsName;
	//签订类型
	private String signTypeName;
	//所属子公司
	private String subComName;
	//承租方名称
	private String leaseNameText;
	//优先盖章方
	private String yfirstChopName;
	//租赁类型
	private String leaseTypeName;
	//付款方式
	private String payTypeName;
	
	//出租方名称
	private String prentNameText;
	//是否改造
	private String isChangeName;
	//转租部门
	private String subletDeptCodeName;
	public YardRentBean(){}
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
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	 * @return the yrentName
	 */
	public String getYrentName() {
		return yrentName;
	}
	/**
	 * @param yrentName the yrentName to set
	 */
	public void setYrentName(String yrentName) {
		this.yrentName = yrentName;
	}
	/**
	 * @return the prentName
	 */
	public String getPrentName() {
		return prentName;
	}
	/**
	 * @param prentName the prentName to set
	 */
	public void setPrentName(String prentName) {
		this.prentName = prentName;
		this.prentNameText = this.prentName;
	}
	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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
	 * @return the leaseBussiness
	 */
	public String getLeaseBussiness() {
		return leaseBussiness;
	}
	/**
	 * @param leaseBussiness the leaseBussiness to set
	 */
	public void setLeaseBussiness(String leaseBussiness) {
		this.leaseBussiness = leaseBussiness;
	}
	/**
	 * @return the isChange
	 */
	public String getIsChange() {
		return isChange;
	}
	/**
	 * @param isChange the isChange to set
	 */
	public void setIsChange(String isChange) {
		this.isChange = isChange;
		this.isChangeName = this.isChange;
	}
	/**
	 * @return the changeAmt
	 */
	public BigDecimal getChangeAmt() {
		return changeAmt;
	}
	/**
	 * @param changeAmt the changeAmt to set
	 */
	public void setChangeAmt(BigDecimal changeAmt) {
		this.changeAmt = changeAmt;
	}
	/**
	 * @return the subletDept
	 */
	public String getSubletDept() {
		return subletDept;
	}
	/**
	 * @param subletDept the subletDept to set
	 */
	public void setSubletDept(String subletDept) {
		this.subletDept = subletDept;
	}
	/**
	 * @return the subletDeptCode
	 */
	public String getSubletDeptCode() {
		return subletDeptCode;
	}
	/**
	 * @param subletDeptCode the subletDeptCode to set
	 */
	public void setSubletDeptCode(String subletDeptCode) {
		this.subletDeptCode = subletDeptCode;
	}
	/**
	 * @return the payMonths
	 */
	public Long getPayMonths() {
		return payMonths;
	}
	/**
	 * @param payMonths the payMonths to set
	 */
	public void setPayMonths(Long payMonths) {
		this.payMonths = payMonths;
	}
	/**
	 * @return the oldLeaseArea
	 */
	public BigDecimal getOldLeaseArea() {
		return oldLeaseArea;
	}
	/**
	 * @param oldLeaseArea the oldLeaseArea to set
	 */
	public void setOldLeaseArea(BigDecimal oldLeaseArea) {
		this.oldLeaseArea = oldLeaseArea;
	}
	/**
	 * @return the oldLeasePrice
	 */
	public BigDecimal getOldLeasePrice() {
		return oldLeasePrice;
	}
	/**
	 * @param oldLeasePrice the oldLeasePrice to set
	 */
	public void setOldLeasePrice(BigDecimal oldLeasePrice) {
		this.oldLeasePrice = oldLeasePrice;
	}
	/**
	 * @return the newLeaseArea
	 */
	public BigDecimal getNewLeaseArea() {
		return newLeaseArea;
	}
	/**
	 * @param newLeaseArea the newLeaseArea to set
	 */
	public void setNewLeaseArea(BigDecimal newLeaseArea) {
		this.newLeaseArea = newLeaseArea;
	}
	/**
	 * @return the pfirstChop
	 */
	public String getPfirstChop() {
		return pfirstChop;
	}
	/**
	 * @param pfirstChop the pfirstChop to set
	 */
	public void setPfirstChop(String pfirstChop) {
		this.pfirstChop = pfirstChop;
	}
	/**
	 * @return the newLeasePrice
	 */
	public BigDecimal getNewLeasePrice() {
		return newLeasePrice;
	}
	/**
	 * @param newLeasePrice the newLeasePrice to set
	 */
	public void setNewLeasePrice(BigDecimal newLeasePrice) {
		this.newLeasePrice = newLeasePrice;
	}
	
	/**
	 * @return the busiType
	 */
	public String getBusiType() {
		return busiType;
	}
	/**
	 * @param busiType the busiType to set
	 */
	public void setBusiType(String busiType) {
		this.busiType = busiType;
		this.busiTypeName = this.busiType;
	}
	/**
	 * @return the financeCode
	 */
	public String getFinanceCode() {
		return financeCode;
	}
	/**
	 * @param financeCode the financeCode to set
	 */
	public void setFinanceCode(String financeCode) {
		this.financeCode = financeCode;
		this.financeName = this.financeCode;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	public String getStartDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getStartDate());
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	public String getEndDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getEndDate());
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the division_code
	 */
	public String getDivisionCode() {
		return divisionCode;
	}
	/**
	 * @param division_code the division_code to set
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
		this.divisionName = this.divisionCode;
	}
	/**
	 * @return the affairs_code
	 */
	public String getAffairsCode() {
		return affairsCode;
	}
	/**
	 * @param affairs_code the affairs_code to set
	 */
	public void setAffairsCode(String affairsCode) {
		this.affairsCode = affairsCode;
		this.affairsName = this.affairsCode;
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
		this.signTypeName = this.signType;
	}
	/**
	 * @return the subComCode
	 */
	public String getSubComCode() {
		return subComCode;
	}
	/**
	 * @param subComCode the subComCode to set
	 */
	public void setSubComCode(String subComCode) {
		this.subComCode = subComCode;
		this.subComName = this.subComCode;
	}
	/**
	 * @return the leaseName
	 */
	public String getLeaseName() {
		return leaseName;
	}
	/**
	 * @param leaseName the leaseName to set
	 */
	public void setLeaseName(String leaseName) {
		this.leaseName = leaseName;
		this.leaseNameText = this.leaseName;
	}
	/**
	 * @return the leaseDept
	 */
	public String getLeaseDept() {
		return leaseDept;
	}
	/**
	 * @param leaseDept the leaseDept to set
	 */
	public void setLeaseDept(String leaseDept) {
		this.leaseDept = leaseDept;
	}
	/**
	 * @return the leaseArea
	 */
	public String getLeaseArea() {
		return leaseArea;
	}
	/**
	 * @param leaseArea the leaseArea to set
	 */
	public void setLeaseArea(String leaseArea) {
		this.leaseArea = leaseArea;
	}
	/**
	 * @return the yearRental
	 */
	public String getYearRental() {
		return yearRental;
	}
	/**
	 * @param yearRental the yearRental to set
	 */
	public void setYearRental(String yearRental) {
		this.yearRental = yearRental;
	}
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
		this.payTypeName = this.payType;
	}
	/**
	 * @return the freeStartDate
	 */
	public Date getFreeStartDate() {
		return freeStartDate;
	}
	/**
	 * 
	* @MethodName: getFreeStartDateStr 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午06:07:29
	* @return String
	 */
	public String getFreeStartDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getFreeStartDate());
	}
	/**
	 * @param freeStartDate the freeStartDate to set
	 */
	public void setFreeStartDate(Date freeStartDate) {
		this.freeStartDate = freeStartDate;
	}
	/**
	 * @return the rentFreeEndDdate
	 */
	public Date getFreeEndDdate() {
		return freeEndDdate;
	}
	/**
	 * 
	* @MethodName: getFreeEndDdateStr 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午06:08:11
	* @return String
	 */
	public String getFreeEndDdateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getFreeEndDdate());
	}
	/**
	 * @param freeEndDdate the freeEndDdate to set
	 */
	public void setFreeEndDdate(Date freeEndDdate) {
		this.freeEndDdate = freeEndDdate;
	}
	/**
	 * @return the leaseType
	 */
	public String getLeaseType() {
		return leaseType;
	}
	/**
	 * @param leaseType the leaseType to set
	 */
	public void setLeaseType(String leaseType) {
		this.leaseType = leaseType;
		this.leaseTypeName = this.leaseType;
	}
	/**
	 * @return the projectID
	 */
	public String getProjectID() {
		return projectID;
	}
	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(String projectID) {
		this.projectID = projectID;
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
	 * @return the depositAmount
	 */
	public String getDepositAmount() {
		return depositAmount;
	}
	/**
	 * @param depositAmount the depositAmount to set
	 */
	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}
	/**
	 * @return the yfirstChop
	 */
	public String getYfirstChop() {
		return yfirstChop;
	}
	/**
	 * @param yfirstChop the yfirstChop to set
	 */
	public void setYfirstChop(String yfirstChop) {
		this.yfirstChop = yfirstChop;
		this.yfirstChopName = this.yfirstChop;
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
	 * @return the oldContarctNO
	 */
	public String getOldContarctNO() {
		return oldContarctNO;
	}
	/**
	 * @param oldContarctNO the oldContarctNO to set
	 */
	public void setOldContarctNO(String oldContarctNO) {
		this.oldContarctNO = oldContarctNO;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the argreeTime
	 */
	public Date getArgreeTime() {
		return argreeTime;
	}
	/**
	 * @param argreeTime the argreeTime to set
	 */
	public void setArgreeTime(Date argreeTime) {
		this.argreeTime = argreeTime;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 * @return the isEffective
	 */
	public String getIsEffective() {
		return isEffective;
	}
	/**
	 * @param isEffective the isEffective to set
	 */
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	/**
	 * @return the reserve1
	 */
	public Long getReserve1() {
		return reserve1;
	}
	/**
	 * @param reserve1 the reserve1 to set
	 */
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}
	/**
	 * @return the reserve2
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * @param reserve2 the reserve2 to set
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	/**
	 * @return the reserve3
	 */
	public String getReserve3() {
		return reserve3;
	}
	/**
	 * @param reserve3 the reserve3 to set
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	
	/**
	 * @MethodName: hashCode 
	 * @description: 重载hashCode方法
	 * @author： wuyaqing 
	 * @date： 2013年9月17日 下午4:40:55
	 * @return
	 */
	@Override
	public int hashCode() {
		//定义常量
		final int prime = 31;
		//定义结果变量，并初始化为1
		int result = 1;
		//计算结果加上所属公共事务组标杆编码
		result = prime * result + ((affairsCode == null) ? 0 : affairsCode.hashCode());
		//计算结果加上申请人工号
		result = prime * result + ((applyPersonId == null) ? 0 : applyPersonId.hashCode());
		//计算结果加上申请人姓名
		result = prime * result + ((applyPersonName == null) ? 0 : applyPersonName.hashCode());
		//计算结果加上申请事由
		result = prime * result + ((applyReason == null) ? 0 : applyReason.hashCode());
		//计算结果加上所属区域
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		//计算结果加上同意时间
		result = prime * result + ((argreeTime == null) ? 0 : argreeTime.hashCode());
		//计算结果加上业务类型
		result = prime * result + ((busiType == null) ? 0 : busiType.hashCode());
		//计算结果加上主键ID
		result = prime * result + ((busino == null) ? 0 : busino.hashCode());
		//计算结果加上改造金额
		result = prime * result + ((changeAmt == null) ? 0 : changeAmt.hashCode());
		//计算结果加上创建时间
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		//计算结果加上押金金额
		result = prime * result + ((depositAmount == null) ? 0 : depositAmount.hashCode());
		//计算结果加上所属事业部标杆编码
		result = prime * result + ((divisionCode == null) ? 0 : divisionCode.hashCode());
		//计算结果加上租赁结束日期
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		//计算结果加上所属财务部标杆编码
		result = prime * result + ((financeCode == null) ? 0 : financeCode.hashCode());
		//计算结果加上免租结束日期
		result = prime * result + ((freeEndDdate == null) ? 0 : freeEndDdate.hashCode());
		//计算结果加上免租开始日期
		result = prime * result + ((freeStartDate == null) ? 0 : freeStartDate.hashCode());
		//计算结果加上是否改造（1-是，2-否）
		result = prime * result + ((isChange == null) ? 0 : isChange.hashCode());
		//计算结果加上业务状态，是否有效（1-有效 0-无效）
		result = prime * result + ((isEffective == null) ? 0 : isEffective.hashCode());
		//计算结果加上承租房屋面积
		result = prime * result + ((leaseArea == null) ? 0 : leaseArea.hashCode());
		//计算结果加上承租方主要业务
		result = prime * result + ((leaseBussiness == null) ? 0 : leaseBussiness.hashCode());
		//计算结果加上承租部门
		result = prime * result + ((leaseDept == null) ? 0 : leaseDept.hashCode());
		//计算结果加上承租方名称
		result = prime * result + ((leaseName == null) ? 0 : leaseName.hashCode());
		//计算结果加上租赁类型
		result = prime * result + ((leaseType == null) ? 0 : leaseType.hashCode());
		//计算结果加上修改时间
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		//计算结果加上现租赁面积
		result = prime * result + ((newLeaseArea == null) ? 0 : newLeaseArea.hashCode());
		//计算结果加上现租赁单价
		result = prime * result + ((newLeasePrice == null) ? 0 : newLeasePrice.hashCode());
		//计算结果加上原合同编号
		result = prime * result + ((oldContarctNO == null) ? 0 : oldContarctNO.hashCode());
		//计算结果加上原租赁面积
		result = prime * result + ((oldLeaseArea == null) ? 0 : oldLeaseArea.hashCode());
		//计算结果加上原租赁单价
		result = prime * result + ((oldLeasePrice == null) ? 0 : oldLeasePrice.hashCode());
		//计算结果加上付款月数
		result = prime * result + ((payMonths == null) ? 0 : payMonths.hashCode());
		//计算结果加上付款方式
		result = prime * result + ((payType == null) ? 0 : payType.hashCode());
		//计算结果加上优先盖章方
		result = prime * result + ((pfirstChop == null) ? 0 : pfirstChop.hashCode());
		//计算结果加上转租出租方名称
		result = prime * result + ((prentName == null) ? 0 : prentName.hashCode());
		//计算结果加上流程实例ID
		result = prime * result + ((processinstid == null) ? 0 : processinstid.hashCode());
		//计算结果加上工程项目编号
		result = prime * result + ((projectID == null) ? 0 : projectID.hashCode());
		//计算结果加上工程项目名称
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		//计算结果加上备注1
		result = prime * result + ((reserve1 == null) ? 0 : reserve1.hashCode());
		//计算结果加上备注2
		result = prime * result + ((reserve2 == null) ? 0 : reserve2.hashCode());
		//计算结果加上备注3
		result = prime * result + ((reserve3 == null) ? 0 : reserve3.hashCode());
		//计算结果加上签订类型
		result = prime * result + ((signType == null) ? 0 : signType.hashCode());
		//计算结果加上租赁开始日期
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		//计算结果加上所属子公司标准编码
		result = prime * result + ((subComCode == null) ? 0 : subComCode.hashCode());
		//计算结果加上转租部门
		result = prime * result + ((subletDept == null) ? 0 : subletDept.hashCode());
		//计算结果加上转租部门代码
		result = prime * result + ((subletDeptCode == null) ? 0 : subletDeptCode.hashCode());
		//计算结果加上总金额总金额
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		//计算结果加上每年租金
		result = prime * result + ((yearRental == null) ? 0 : yearRental.hashCode());
		//计算结果加上优先盖章方
		result = prime * result + ((yfirstChop == null) ? 0 : yfirstChop.hashCode());
		//计算结果加上租赁出租方名称
		result = prime * result + ((yrentName == null) ? 0 : yrentName.hashCode());
		//返回计算结果
		return result;
	}

	/**
	 * @MethodName: toString 
	 * @description: 重载toString方法
	 * @author： wuyaqing 
	 * @date： 2013-9-5 下午05:32:33
	 * @return 
	 */
	@Override
	public String toString() {
		//返回结果
		return 
				//主键ID
				"YardRentBean [busino=" + busino 
				//流程实例ID
				+ ", processinstid=" + processinstid 
				//申请人姓名
				+ ", applyPersonName=" + applyPersonName
				//申请人工号
				+ ", applyPersonId=" + applyPersonId 
				//业务类型
				+ ", busiType=" + busiType
				//所属财务部标杆编码
				+ ", financeCode=" + financeCode 
				//租赁开始日期
				+ ", startDate=" + startDate
				//租赁结束日期
				+ ", endDate=" + endDate 
				//所属事业部标杆编码
				+ ", divisionCode=" + divisionCode
				//所属公共事务组标杆编码
				+ ", affairsCode=" + affairsCode 
				//签订类型
				+ ", signType=" + signType
				//所属子公司标准编码
				+ ", subComCode=" + subComCode 
				//租赁出租方名称
				+ ", yrentName=" + yrentName
				//转租出租方名称
				+ ", prentName=" + prentName 
				//承租方名称
				+ ", leaseName=" + leaseName
				//承租部门
				+ ", leaseDept=" + leaseDept 
				//承租房屋面积
				+ ", leaseArea=" + leaseArea
				//每年租金
				+ ", yearRental=" + yearRental 
				//总金额
				+ ", totalAmount=" + totalAmount
				//付款方式
				+ ", payType=" + payType 
				//免租开始日期
				+ ", freeStartDate=" + freeStartDate
				//免租结束日期
				+ ", freeEndDdate=" + freeEndDdate 
				//租赁类型
				+ ", leaseType=" + leaseType
				//工程项目编号
				+ ", projectID=" + projectID 
				//工程项目名称
				+ ", projectName=" + projectName
				//押金金额
				+ ", depositAmount=" + depositAmount 
				//优先盖章方
				+ ", yfirstChop=" + yfirstChop 
				//优先盖章方
				+ ", pfirstChop=" + pfirstChop 
				//申请事由
				+ ", applyReason=" + applyReason 
				//承租方主要业务
				+ ", leaseBussiness=" + leaseBussiness
				//是否改造（1-是，2-否）
				+ ", isChange=" + isChange 
				//改造金额
				+ ", changeAmt=" + changeAmt
				//转租部门转租部门
				+ ", subletDept=" + subletDept 
				//转租部门代码
				+ ", subletDeptCode=" + subletDeptCode 
				//付款月数
				+ ", payMonths=" + payMonths
				//原租赁面积
				+ ", oldLeaseArea=" + oldLeaseArea 
				//原租赁单价
				+ ", oldLeasePrice=" + oldLeasePrice 
				//现租赁面积
				+ ", newLeaseArea=" + newLeaseArea
				//现租赁单价
				+ ", newLeasePrice=" + newLeasePrice 
				//原合同编号
				+ ", oldContarctNO=" + oldContarctNO 
				//所属区域
				+ ", area=" + area 
				//同意时间
				+ ", argreeTime=" + argreeTime 
				//创建时间
				+ ", createTime="  + createTime 
				//修改时间
				+ ", modifyTime=" + modifyTime 
				//业务状态，是否有效（1-有效 0-无效）
				+ ", isEffective=" + isEffective 
				//备注1
				+ ", reserve1=" + reserve1 
				//备注2
				+ ", reserve2=" + reserve2 
				//备注3
				+ ", reserve3=" + reserve3 + "]";
	}
	
	/**
	 * @MethodName: equals 
	 * @description: 重载equals方法
	 * @author： wuyaqing 
	 * @date： 2013年9月17日 下午4:41:44
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		//参与比较的引用同一个对象，返回true
		if (this == obj)
			//返回true
			return true;
		//Object为空，返回false
		if (obj == null)
			//返回false
			return false;
		//参与比较的不属于同一个类名时
		if (getClass() != obj.getClass())
			//返回false
			return false;
		//参数obj是该对象的一个引用，所以强制转换成YardRentBean不会报错
		YardRentBean other = (YardRentBean) obj;
		//该对象的affairsCode为空
		if (affairsCode == null) {
			//参数对象的affairsCode不为空，返回false
			if (other.affairsCode != null)
				//返回false
				return false;
		} else if (!affairsCode.equals(other.affairsCode))
			//参数的affairsCode与该对象的affairsCode不相等时
			//返回false
			return false;
		//该对象的applyPersonId为空
		if (applyPersonId == null) {
			//参数的applyPersonId不为空
			if (other.applyPersonId != null)
				//返回false
				return false;
		} else if (!applyPersonId.equals(other.applyPersonId))
			//参数的applyPersonId与该对象的applyPersonId不相等
			//返回false
			return false;
		//该对象的applyPersonName为空
		if (applyPersonName == null) {
			//参数的applyPersonName不为空
			if (other.applyPersonName != null)
				//返回false
				return false;
		} else if (!applyPersonName.equals(other.applyPersonName))
			//参数的applyPersonName与该对象的applyPersonName不相等时
			//返回false
			return false;
		//该对象的applyReason为空
		if (applyReason == null) {
			//参数的applyReason不为空
			if (other.applyReason != null)
				//返回false
				return false;
		} else if (!applyReason.equals(other.applyReason))
			//参数的applyReason与该对象的applyReason不相等
			//返回false
			return false;
		//该对象的area为空
		if (area == null) {
			//参数的area不为空
			if (other.area != null)
				//返回false
				return false;
		} else if (!area.equals(other.area))
			//参数的area与该对象的area不相等
			//返回false
			return false;
		//该对象的argreeTime为空
		if (argreeTime == null) {
			//参数的argreeTime不为空
			if (other.argreeTime != null)
				//返回false
				return false;
		} else if (!argreeTime.equals(other.argreeTime))
			//参数的argreeTime与该对象的argreeTime不相等
			//返回false
			return false;
		//该对象的busiType为空
		if (busiType == null) {
			//参数的busiType不为空
			if (other.busiType != null)
				//返回false
				return false;
		} else if (!busiType.equals(other.busiType))
			//参数的busiType与该对象的busiType不相等
			//返回false
			return false;
		//该对象的busino为空
		if (busino == null) {
			//参数的busino不为空
			if (other.busino != null)
				//返回false
				return false;
		} else if (!busino.equals(other.busino))
			//参数的busino与该对象的busino不相等
			//返回false
			return false;
		//该对象的changeAmt为空
		if (changeAmt == null) {
			//参数的changeAmt不为空
			if (other.changeAmt != null)
				//返回false
				return false;
		} else if (!changeAmt.equals(other.changeAmt))
			//参数的changeAmt与该对象的changeAmt不相等
			//返回false
			return false;
		//该对象的createTime为空
		if (createTime == null) {
			//参数的createTime不为空
			if (other.createTime != null)
				//返回false
				return false;
		} else if (!createTime.equals(other.createTime))
			//参数的createTime与该对象的createTime不相等
			//返回false
			return false;
		//该对象的depositAmount为空
		if (depositAmount == null) {
			//参数的depositAmount不为空
			if (other.depositAmount != null)
				//返回false
				return false;
		} else if (!depositAmount.equals(other.depositAmount))
			//参数的depositAmount与该对象的depositAmount不相等
			//返回false
			return false;
		//该对象的divisionCode为空
		if (divisionCode == null) {
			//参数的divisionCode不为空
			if (other.divisionCode != null)
				//返回false
				return false;
		} else if (!divisionCode.equals(other.divisionCode))
			//参数的divisionCode与该对象的divisionCode不相等
			//返回false
			return false;
		//该对象的endDate为空
		if (endDate == null) {
			//参数的endDate不为空
			if (other.endDate != null)
				//返回false
				return false;
		} else if (!endDate.equals(other.endDate))
			//参数的endDate与该对象的endDate不相等
			//返回false
			return false;
		//该对象的financeCode为空
		if (financeCode == null) {
			//参数的financeCode不为空
			if (other.financeCode != null)
				//返回false
				return false;
		} else if (!financeCode.equals(other.financeCode))
			//参数的financeCode与该对象的financeCode不相等
			//返回false
			return false;
		//该对象的freeEndDdate为空
		if (freeEndDdate == null) {
			//参数的freeEndDdate不为空
			if (other.freeEndDdate != null)
				//返回false
				return false;
		} else if (!freeEndDdate.equals(other.freeEndDdate))
			//参数的freeEndDdate与该对象的freeEndDdate不相等
			//返回false
			return false;
		//该对象的freeStartDate为空
		if (freeStartDate == null) {
			//参数的freeStartDate不为空
			if (other.freeStartDate != null)
				//返回false
				return false;
		} else if (!freeStartDate.equals(other.freeStartDate))
			//参数的freeStartDate与该对象的freeStartDate不相等
			//返回false
			return false;
		//该对象的isChange为空
		if (isChange == null) {
			//参数的isChange不为空
			if (other.isChange != null)
				//返回false
				return false;
		} else if (!isChange.equals(other.isChange))
			//参数的isChange与该对象的isChange不相等
			//返回false
			return false;
		//该对象的isEffective为空
		if (isEffective == null) {
			//参数的isEffective不为空
			if (other.isEffective != null)
				//返回false
				return false;
		} else if (!isEffective.equals(other.isEffective))
			//参数的isEffective与该对象的isEffective不相等
			//返回false
			return false;
		//该对象的leaseArea为空
		if (leaseArea == null) {
			//参数的leaseArea不为空
			if (other.leaseArea != null)
				//返回false
				return false;
		} else if (!leaseArea.equals(other.leaseArea))
			//参数的leaseArea与该对象的leaseArea不相等
			//返回false
			return false;
		//该对象的leaseBussiness为空
		if (leaseBussiness == null) {
			//参数的leaseBussiness不为空
			if (other.leaseBussiness != null)
				//返回false
				return false;
		} else if (!leaseBussiness.equals(other.leaseBussiness))
			//参数的leaseBussiness与该对象的leaseBussiness不相等
			//返回false
			return false;
		//该对象的leaseDept为空
		if (leaseDept == null) {
			//参数的leaseDept不为空
			if (other.leaseDept != null)
				//返回false
				return false;
		} else if (!leaseDept.equals(other.leaseDept))
			//参数的leaseDept与该对象的leaseDept不相等
			//返回false
			return false;
		//该对象的leaseName为空
		if (leaseName == null) {
			//参数的leaseName不为空
			if (other.leaseName != null)
				//返回false
				return false;
		} else if (!leaseName.equals(other.leaseName))
			//参数的leaseName与该对象的leaseName不相等
			//返回false
			return false;
		//该对象的leaseType为空
		if (leaseType == null) {
			//参数的leaseType不为空
			if (other.leaseType != null)
				//返回false
				return false;
		} else if (!leaseType.equals(other.leaseType))
			//参数的leaseType与该对象的leaseType不相等
			//返回false
			return false;
		//该对象的modifyTime为空
		if (modifyTime == null) {
			//参数的modifyTime不为空
			if (other.modifyTime != null)
				//返回false
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			//参数的modifyTime与该对象的modifyTime不相等
			//返回false
			return false;
		//该对象的newLeaseArea为空
		if (newLeaseArea == null) {
			//参数的newLeaseArea不为空
			if (other.newLeaseArea != null)
				//返回false
				return false;
		} else if (!newLeaseArea.equals(other.newLeaseArea))
			//参数的newLeaseArea与该对象的newLeaseArea不相等
			//返回false
			return false;
		//该对象的newLeasePrice为空
		if (newLeasePrice == null) {
			//参数的newLeasePrice不为空
			if (other.newLeasePrice != null)
				//返回false
				return false;
		} else if (!newLeasePrice.equals(other.newLeasePrice))
			//参数的newLeasePrice与该对象的newLeasePrice不相等
			//返回false
			return false;
		//该对象的oldContarctNO为空
		if (oldContarctNO == null) {
			//参数的oldContarctNO不为空
			if (other.oldContarctNO != null)
				//返回false
				return false;
		} else if (!oldContarctNO.equals(other.oldContarctNO))
			//参数的oldContarctNO与该对象的oldContarctNO不相等
			//返回false
			return false;
		//该对象的oldLeaseArea为空
		if (oldLeaseArea == null) {
			//参数的oldLeaseArea不为空
			if (other.oldLeaseArea != null)
				//返回false
				return false;
		} else if (!oldLeaseArea.equals(other.oldLeaseArea))
			//参数的oldLeaseArea与该对象的oldLeaseArea不相等
			//返回false
			return false;
		//该对象的oldLeasePrice为空
		if (oldLeasePrice == null) {
			//参数的oldLeasePrice不为空
			if (other.oldLeasePrice != null)
				//返回false
				return false;
		} else if (!oldLeasePrice.equals(other.oldLeasePrice))
			//参数的oldLeasePrice与该对象的oldLeasePrice不相等
			//返回false
			return false;
		//该对象的payMonths为空
		if (payMonths == null) {
			//参数的payMonths不为空
			if (other.payMonths != null)
				//返回false
				return false;
		} else if (!payMonths.equals(other.payMonths))
			//参数的payMonths与该对象的payMonths不相等
			//返回false
			return false;
		//该对象的payType为空
		if (payType == null) {
			//参数的payType不为空
			if (other.payType != null)
				//返回false
				return false;
		} else if (!payType.equals(other.payType))
			//参数的payType与该对象的payType不相等
			//返回false
			return false;
		//该对象的pfirstChop为空
		if (pfirstChop == null) {
			//参数的pfirstChop不为空
			if (other.pfirstChop != null)
				//返回false
				return false;
		} else if (!pfirstChop.equals(other.pfirstChop))
			//参数的pfirstChop与该对象的pfirstChop不相等
			//返回false
			return false;
		//该对象的prentName为空
		if (prentName == null) {
			//参数的prentName不为空
			if (other.prentName != null)
				//返回false
				return false;
		} else if (!prentName.equals(other.prentName))
			//参数的prentName与该对象的prentName不相等
			//返回false
			return false;
		//该对象的processinstid为空
		if (processinstid == null) {
			//参数的processinstid不为空
			if (other.processinstid != null)
				//返回false
				return false;
		} else if (!processinstid.equals(other.processinstid))
			//参数的processinstid与该对象的processinstid不相等
			//返回false
			return false;
		//该对象的projectID为空
		if (projectID == null) {
			//参数的projectID不为空
			if (other.projectID != null)
				//返回false
				return false;
		} else if (!projectID.equals(other.projectID))
			//参数的projectID与该对象的projectID不相等
			//返回false
			return false;
		//该对象的projectName为空
		if (projectName == null) {
			//参数的projectName不为空
			if (other.projectName != null)
				//返回false
				return false;
		} else if (!projectName.equals(other.projectName))
			//参数的projectName与该对象的projectName不相等
			//返回false
			return false;
		//该对象的reserve1为空
		if (reserve1 == null) {
			//参数的reserve1不为空
			if (other.reserve1 != null)
				//返回false
				return false;
		} else if (!reserve1.equals(other.reserve1))
			//参数的reserve1与该对象的reserve1不相等
			//返回false
			return false;
		//该对象的reserve2为空
		if (reserve2 == null) {
			//参数的reserve2为空
			if (other.reserve2 != null)
				//返回false
				return false;
		} else if (!reserve2.equals(other.reserve2))
			//参数的reserve2与该对象的reserve2不相等
			//返回false
			return false;
		//该对象的reserve3为空
		if (reserve3 == null) {
			//参数的reserve3不为空
			if (other.reserve3 != null)
				//返回false
				return false;
		} else if (!reserve3.equals(other.reserve3))
			//参数的reserve3与该对象的reserve3不相等
			//返回false
			return false;
		//该对象的signType为空
		if (signType == null) {
			//参数的signType不为空
			if (other.signType != null)
				//返回false
				return false;
		} else if (!signType.equals(other.signType))
			//参数的signType与该对象的signType不相等
			//返回false
			return false;
		//该对象的startDate为空
		if (startDate == null) {
			//参数的startDate不为空
			if (other.startDate != null)
				//返回false
				return false;
		} else if (!startDate.equals(other.startDate))
			//参数的startDate与该对象的startDate不相等
			//返回false
			return false;
		//该对象的subComCode为空
		if (subComCode == null) {
			//参数的subComCode不为空
			if (other.subComCode != null)
				//返回false
				return false;
		} else if (!subComCode.equals(other.subComCode))
			//参数的subComCode与该对象的subComCode不相等
			//返回false
			return false;
		//该对象的subletDept为空
		if (subletDept == null) {
			//参数的subletDept不为空
			if (other.subletDept != null)
				//返回false
				return false;
		} else if (!subletDept.equals(other.subletDept))
			//参数的subletDept与该对象的subletDept不相等
			//返回false
			return false;
		//该对象的subletDeptCode为空
		if (subletDeptCode == null) {
			//参数的subletDeptCode不为空
			if (other.subletDeptCode != null)
				//返回false
				return false;
		} else if (!subletDeptCode.equals(other.subletDeptCode))
			//参数的subletDeptCode与该对象的subletDeptCode不相等
			//返回false
			return false;
		//该对象的totalAmount为空
		if (totalAmount == null) {
			//参数的totalAmount不为空
			if (other.totalAmount != null)
				//返回false
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			//参数的totalAmount与该对象的totalAmount不相等
			//返回false
			return false;
		//该对象的yearRental为空
		if (yearRental == null) {
			//参数的yearRental不为空
			if (other.yearRental != null)
				//返回false
				return false;
		} else if (!yearRental.equals(other.yearRental))
			//参数的yearRental与该对象的yearRental不相等
			//返回false
			return false;
		//该对象的yfirstChop为空
		if (yfirstChop == null) {
			//参数的yfirstChop不为空
			if (other.yfirstChop != null)
				//返回false
				return false;
		} else if (!yfirstChop.equals(other.yfirstChop))
			//参数的yfirstChop与该对象的yfirstChop不相等
			//返回false
			return false;
		//该对象的yrentName为空
		if (yrentName == null) {
			//参数的yrentName不为空
			if (other.yrentName != null)
				//返回false
				return false;
		} else if (!yrentName.equals(other.yrentName))
			//参数的yrentName与该对象的yrentName不相等
			//返回false
			return false;
		//上述情况都不满足时，参数对象和该对象就相等
		//返回true
		return true;
	}
	/**
	 * 
	* @MethodName: getBusiTypeName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午03:49:09
	* @return String
	 */
	public String getBusiTypeName() {
		return busiTypeName;
	}
	/**
	 * 
	* @MethodName: setBusiTypeName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午03:49:13
	* @param busiTypeName void
	 */
	public void setBusiTypeName(String busiTypeName) {
//		this.busiTypeName = busiTypeName;
	}
	/**
	 * 
	* @MethodName: getFinanceName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午03:57:03
	* @return String
	 */
	public String getFinanceName() {
		return financeName;
	}
	/**
	 * 
	* @MethodName: setFinanceName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午03:57:07
	* @param financeName void
	 */
	public void setFinanceName(String financeName) {
//		this.financeName = financeName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
//		this.divisionName = divisionName;
	}
	public String getAffairsName() {
		return affairsName;
	}
	public void setAffairsName(String affairsName) {
//		this.affairsName = affairsName;
	}
	public String getSignTypeName() {
		return signTypeName;
	}
	public void setSignTypeName(String signTypeName) {
		this.signTypeName = signTypeName;
	}
	public String getSubComName() {
		return subComName;
	}
	public void setSubComName(String subComName) {
		this.subComName = subComName;
	}
	public String getLeaseNameText() {
		return leaseNameText;
	}
	public void setLeaseNameText(String leaseNameText) {
		this.leaseNameText = leaseNameText;
	}
	public String getYfirstChopName() {
		return yfirstChopName;
	}
	/**
	 * 
	* @MethodName: setYfirstChopName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 下午06:10:23
	* @param yfirstChopName void
	 */
	public void setYfirstChopName(String yfirstChopName) {
		this.yfirstChopName = yfirstChopName;
	}
	public String getLeaseTypeName() {
		return leaseTypeName;
	}
	public void setLeaseTypeName(String leaseTypeName) {
		this.leaseTypeName = leaseTypeName;
	}
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	public String getPrentNameText() {
		return prentNameText;
	}
	public void setPrentNameText(String prentNameText) {
		this.prentNameText = prentNameText;
	}
	public String getIsChangeName() {
		return isChangeName;
	}
	public void setIsChangeName(String isChangeName) {
		this.isChangeName = isChangeName;
	}
	public String getSubletDeptCodeName() {
		return subletDeptCodeName;
	}
	public void setSubletDeptCodeName(String subletDeptCodeName) {
		this.subletDeptCodeName = subletDeptCodeName;
	}	
}
