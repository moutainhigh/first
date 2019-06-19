package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;
public class NewsalesmaterialapplyEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8895967837454460809L;
	//单据编号
	private String billnumber;
	//创建人
	private String creatorid;
	//创建人部门id
	private String createDeptId;
	//创建人部门名称
	private String createDept;
	//修改人id
	private String modiforid;
	//部门人数
	private int deptNumber;
	//cuid
	private String controlCuid;
	//子公司名成
	private String controlName;
	//申请日期
	private Date applydate;
	//单据状态
	private String billstatus;
	//采购组织id
	private String purchaseOrgUnitId;
	//采购组织名称
	private String purchaseOrgUnitName;
	//库存组织id
	private String storageOrgUnitId;
	//库存组织名称storageOrgUnit
	private String storageOrgUnitName;
	//费用承担部门id
	private String expenseDeptId;
	//费用承担部门
	private String expenseDeptName;
	//到货部门id
	private String receiveDeptId;
	//到货部门名称
	private String receiveDeptName;
	//到货地址
	private String receiveaddress;
	//联系电话
	private String phonenumber;
	//申请总金额
	private BigDecimal applyamount;
	//项目id
	private String projectid;
	//项目编号
	private String projectNumber;
	//项目名称
	private String projectname;
	//是否换补货
	private int isexchange;
	//是否计划外采购
	private int isunplanned;
	//部门属性
	private String deptProperties;
	//文职人数
	private String civilian;
	//营业厅面积
	private String deptArea;
	//仓库面积
	private String warehouseArea;
	//部门自有车辆
	private String carcount;
	//到达车型
	private String cartype;
	//门脸是否朝街
	private String isNorthStreet;
	//门脸是否朝街
	private String willNightWork;
	//招聘字大小
	private String signSize;
	//背景墙长度
	private String willWidth;
	//货架大小
	private String shelfSize;
	//可安装地磅台数
	private String balanceNumber;
	//备注
	private String remark;
	//物料属性
	private String materilAttid;
	private String sourceBillid;
	//1，表示有效数据
	//0,表示无效数据在LMS中无法推式生成采购申请单.
	private int effective;
	//公司字段
	private String companyId;
	//币别
	private String currencyid;
	//自行采购物料
	private String cfcomment;
	//是否是预算回收的单据
	private String cfisnewpoint;
	
	//判断预算是否被回收过 add by Alax Liu 1 表示没有回收，2表示预算回收过
	private String budgeRecovery;
	
	//丁朋加  营业部面积、是否安装有线固定电话 
	//  营业部面积
	private String cfbusinessarea;
	//是否安装有线固定电话 
	private String cfwiretetelephone;
	
	public String getCfbusinessarea() {
		return cfbusinessarea;
	}
	public void setCfbusinessarea(String cfbusinessarea) {
		this.cfbusinessarea = cfbusinessarea;
	}
	public String getCfwiretetelephone() {
		return cfwiretetelephone;
	}
	public void setCfwiretetelephone(String cfwiretetelephone) {
		this.cfwiretetelephone = cfwiretetelephone;
	}
	public String getBudgeRecovery() {
		return budgeRecovery;
	}
	public void setBudgeRecovery(String budgeRecovery) {
		this.budgeRecovery = budgeRecovery;
	}
	public String getCfisnewpoint() {
		return cfisnewpoint;
	}
	public void setCfisnewpoint(String cfisnewpoint) {
		this.cfisnewpoint = cfisnewpoint;
	}
	/**
	 * cfcomment
	 *
	 * @return  the cfcomment
	 * @since   1.0.0
	 */
	
	public String getCfcomment() {
		return cfcomment;
	}
	/**
	 * @param cfcomment the cfcomment to set
	 */
	public void setCfcomment(String cfcomment) {
		this.cfcomment = cfcomment;
	}
	/**
	 * currencyid
	 *
	 * @return  the currencyid
	 * @since   1.0.0
	 */
	
	public String getCurrencyid() {
		return currencyid;
	}
	/**
	 * @param currencyid the currencyid to set
	 */
	public void setCurrencyid(String currencyid) {
		this.currencyid = currencyid;
	}
	/**
	 * companyId
	 *
	 * @return  the companyId
	 * @since   1.0.0
	 */
	
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/** effective
	 *
	 * @return  the effective
	 * @since   1.0.0
	 */
	
	public int getEffective() {
		return effective;
	}
	/**
	 * @param effective the effective to set
	 */
	public void setEffective(int effective) {
		this.effective = effective;
	}
	
	/**
	 * sourceBillid
	 *
	 * @return  the sourceBillid
	 * @since   1.0.0
	 */
	
	public String getSourceBillid() {
		return sourceBillid;
	}
	/**
	 * @param sourceBillid the sourceBillid to set
	 */
	public void setSourceBillid(String sourceBillid) {
		this.sourceBillid = sourceBillid;
	}
	/**
	 * materilAttid
	 *
	 * @return  the materilAttid
	 * @since   1.0.0
	 */
	
	public String getMaterilAttid() {
		return materilAttid;
	}
	/**
	 * @param materilAttid the materilAttid to set
	 */
	public void setMaterilAttid(String materilAttid) {
		this.materilAttid = materilAttid;
	}
	public String getBillnumber() {
		return billnumber;
	}
	/**
	 * @param billnumber the billnumber to set
	 */
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}
	/**
	 * creatorid
	 *
	 * @return  the creatorid
	 * @since   1.0.0
	 */
	
	public String getCreatorid() {
		return creatorid;
	}
	/**
	 * @param creatorid the creatorid to set
	 */
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	/**
	 * createDeptId
	 *
	 * @return  the createDeptId
	 * @since   1.0.0
	 */
	
	public String getCreateDeptId() {
		return createDeptId;
	}
	/**
	 * @param createDeptId the createDeptId to set
	 */
	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}
	/**
	 * createDept
	 *
	 * @return  the createDept
	 * @since   1.0.0
	 */
	
	public String getCreateDept() {
		return createDept;
	}
	/**
	 * @param createDept the createDept to set
	 */
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	/**
	 * modiforid
	 *
	 * @return  the modiforid
	 * @since   1.0.0
	 */
	
	public String getModiforid() {
		return modiforid;
	}
	/**
	 * @param modiforid the modiforid to set
	 */
	public void setModiforid(String modiforid) {
		this.modiforid = modiforid;
	}
	/**
	 * deptNumber
	 *
	 * @return  the deptNumber
	 * @since   1.0.0
	 */
	
	public int getDeptNumber() {
		return deptNumber;
	}
	/**
	 * @param deptNumber the deptNumber to set
	 */
	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
	}
	/**
	 * controlCuid
	 *
	 * @return  the controlCuid
	 * @since   1.0.0
	 */
	
	public String getControlCuid() {
		return controlCuid;
	}
	/**
	 * @param controlCuid the controlCuid to set
	 */
	public void setControlCuid(String controlCuid) {
		this.controlCuid = controlCuid;
	}
	/**
	 * controlName
	 *
	 * @return  the controlName
	 * @since   1.0.0
	 */
	
	public String getControlName() {
		return controlName;
	}
	/**
	 * @param controlName the controlName to set
	 */
	public void setControlName(String controlName) {
		this.controlName = controlName;
	}
	
	/**
	 * applydate
	 *
	 * @return  the applydate
	 * @since   1.0.0
	 */
	
	public Date getApplydate() {
		return applydate;
	}
	/**
	 * @param applydate the applydate to set
	 */
	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}
	/**
	 * billstatus
	 *
	 * @return  the billstatus
	 * @since   1.0.0
	 */
	
	public String getBillstatus() {
		return billstatus;
	}
	/**
	 * @param billstatus the billstatus to set
	 */
	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}
	/**
	 * purchaseOrgUnitId
	 *
	 * @return  the purchaseOrgUnitId
	 * @since   1.0.0
	 */
	
	public String getPurchaseOrgUnitId() {
		return purchaseOrgUnitId;
	}
	/**
	 * @param purchaseOrgUnitId the purchaseOrgUnitId to set
	 */
	public void setPurchaseOrgUnitId(String purchaseOrgUnitId) {
		this.purchaseOrgUnitId = purchaseOrgUnitId;
	}
	/**
	 * purchaseOrgUnitName
	 *
	 * @return  the purchaseOrgUnitName
	 * @since   1.0.0
	 */
	
	public String getPurchaseOrgUnitName() {
		return purchaseOrgUnitName;
	}
	/**
	 * @param purchaseOrgUnitName the purchaseOrgUnitName to set
	 */
	public void setPurchaseOrgUnitName(String purchaseOrgUnitName) {
		this.purchaseOrgUnitName = purchaseOrgUnitName;
	}
	/**
	 * storageOrgUnitId
	 *
	 * @return  the storageOrgUnitId
	 * @since   1.0.0
	 */
	
	public String getStorageOrgUnitId() {
		return storageOrgUnitId;
	}
	/**
	 * @param storageOrgUnitId the storageOrgUnitId to set
	 */
	public void setStorageOrgUnitId(String storageOrgUnitId) {
		this.storageOrgUnitId = storageOrgUnitId;
	}
	/**
	 * storageOrgUnitName
	 *
	 * @return  the storageOrgUnitName
	 * @since   1.0.0
	 */
	
	public String getStorageOrgUnitName() {
		return storageOrgUnitName;
	}
	/**
	 * @param storageOrgUnitName the storageOrgUnitName to set
	 */
	public void setStorageOrgUnitName(String storageOrgUnitName) {
		this.storageOrgUnitName = storageOrgUnitName;
	}
	/**
	 * expenseDeptId
	 *
	 * @return  the expenseDeptId
	 * @since   1.0.0
	 */
	
	public String getExpenseDeptId() {
		return expenseDeptId;
	}
	/**
	 * @param expenseDeptId the expenseDeptId to set
	 */
	public void setExpenseDeptId(String expenseDeptId) {
		this.expenseDeptId = expenseDeptId;
	}
	/**
	 * expenseDeptName
	 *
	 * @return  the expenseDeptName
	 * @since   1.0.0
	 */
	
	public String getExpenseDeptName() {
		return expenseDeptName;
	}
	/**
	 * @param expenseDeptName the expenseDeptName to set
	 */
	public void setExpenseDeptName(String expenseDeptName) {
		this.expenseDeptName = expenseDeptName;
	}
	/**
	 * receiveDeptId
	 *
	 * @return  the receiveDeptId
	 * @since   1.0.0
	 */
	
	public String getReceiveDeptId() {
		return receiveDeptId;
	}
	/**
	 * @param receiveDeptId the receiveDeptId to set
	 */
	public void setReceiveDeptId(String receiveDeptId) {
		this.receiveDeptId = receiveDeptId;
	}
	/**
	 * receiveDeptName
	 *
	 * @return  the receiveDeptName
	 * @since   1.0.0
	 */
	
	public String getReceiveDeptName() {
		return receiveDeptName;
	}
	/**
	 * @param receiveDeptName the receiveDeptName to set
	 */
	public void setReceiveDeptName(String receiveDeptName) {
		this.receiveDeptName = receiveDeptName;
	}
	/**
	 * receiveaddress
	 *
	 * @return  the receiveaddress
	 * @since   1.0.0
	 */
	
	public String getReceiveaddress() {
		return receiveaddress;
	}
	/**
	 * @param receiveaddress the receiveaddress to set
	 */
	public void setReceiveaddress(String receiveaddress) {
		this.receiveaddress = receiveaddress;
	}
	/**
	 * phonenumber
	 *
	 * @return  the phonenumber
	 * @since   1.0.0
	 */
	
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * applyamount
	 *
	 * @return  the applyamount
	 * @since   1.0.0
	 */
	
	public BigDecimal getApplyamount() {
		return applyamount;
	}
	/**
	 * @param applyamount the applyamount to set
	 */
	public void setApplyamount(BigDecimal applyamount) {
		this.applyamount = applyamount;
	}
	/**
	 * projectid
	 *
	 * @return  the projectid
	 * @since   1.0.0
	 */
	
	public String getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	/**
	 * projectNumber
	 *
	 * @return  the projectNumber
	 * @since   1.0.0
	 */
	
	public String getProjectNumber() {
		return projectNumber == null?"":projectNumber;
	}
	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	/**
	 * projectname
	 *
	 * @return  the projectname
	 * @since   1.0.0
	 */
	
	public String getProjectname() {
		return projectname==null?"":projectname;
	}
	/**
	 * @param projectname the projectname to set
	 */
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	/**
	 * isexchange
	 *
	 * @return  the isexchange
	 * @since   1.0.0
	 */
	
	public int getIsexchange() {
		return isexchange;
	}
	/**
	 * @param isexchange the isexchange to set
	 */
	public void setIsexchange(int isexchange) {
		this.isexchange = isexchange;
	}
	/**
	 * isunplanned
	 *
	 * @return  the isunplanned
	 * @since   1.0.0
	 */
	
	public int getIsunplanned() {
		return isunplanned;
	}
	/**
	 * @param isunplanned the isunplanned to set
	 */
	public void setIsunplanned(int isunplanned) {
		this.isunplanned = isunplanned;
	}
	/**
	 * deptProperties
	 *
	 * @return  the deptProperties
	 * @since   1.0.0
	 */
	
	public String getDeptProperties() {
		return deptProperties;
	}
	/**
	 * @param deptProperties the deptProperties to set
	 */
	public void setDeptProperties(String deptProperties) {
		this.deptProperties = deptProperties;
	}
	/**
	 * civilian
	 *
	 * @return  the civilian
	 * @since   1.0.0
	 */
	
	public String getCivilian() {
		return civilian;
	}
	/**
	 * @param civilian the civilian to set
	 */
	public void setCivilian(String civilian) {
		this.civilian = civilian;
	}
	/**
	 * deptArea
	 *
	 * @return  the deptArea
	 * @since   1.0.0
	 */
	
	public String getDeptArea() {
		return deptArea;
	}
	/**
	 * @param deptArea the deptArea to set
	 */
	public void setDeptArea(String deptArea) {
		this.deptArea = deptArea;
	}
	/**
	 * warehouseArea
	 *
	 * @return  the warehouseArea
	 * @since   1.0.0
	 */
	
	public String getWarehouseArea() {
		return warehouseArea;
	}
	/**
	 * @param warehouseArea the warehouseArea to set
	 */
	public void setWarehouseArea(String warehouseArea) {
		this.warehouseArea = warehouseArea;
	}
	/**
	 * carcount
	 *
	 * @return  the carcount
	 * @since   1.0.0
	 */
	
	public String getCarcount() {
		return carcount;
	}
	/**
	 * @param carcount the carcount to set
	 */
	public void setCarcount(String carcount) {
		this.carcount = carcount;
	}
	/**
	 * cartype
	 *
	 * @return  the cartype
	 * @since   1.0.0
	 */
	
	public String getCartype() {
		return cartype;
	}
	/**
	 * @param cartype the cartype to set
	 */
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	/**
	 * isNorthStreet
	 *
	 * @return  the isNorthStreet
	 * @since   1.0.0
	 */
	
	public String getIsNorthStreet() {
		return isNorthStreet;
	}
	/**
	 * @param isNorthStreet the isNorthStreet to set
	 */
	public void setIsNorthStreet(String isNorthStreet) {
		this.isNorthStreet = isNorthStreet;
	}
	/**
	 * willNightWork
	 *
	 * @return  the willNightWork
	 * @since   1.0.0
	 */
	
	public String getWillNightWork() {
		return willNightWork;
	}
	/**
	 * @param willNightWork the willNightWork to set
	 */
	public void setWillNightWork(String willNightWork) {
		this.willNightWork = willNightWork;
	}
	/**
	 * signSize
	 *
	 * @return  the signSize
	 * @since   1.0.0
	 */
	
	public String getSignSize() {
		return signSize;
	}
	/**
	 * @param signSize the signSize to set
	 */
	public void setSignSize(String signSize) {
		this.signSize = signSize;
	}
	/**
	 * willWidth
	 *
	 * @return  the willWidth
	 * @since   1.0.0
	 */
	
	public String getWillWidth() {
		return willWidth;
	}
	/**
	 * @param willWidth the willWidth to set
	 */
	public void setWillWidth(String willWidth) {
		this.willWidth = willWidth;
	}
	/**
	 * shelfSize
	 *
	 * @return  the shelfSize
	 * @since   1.0.0
	 */
	
	public String getShelfSize() {
		return shelfSize;
	}
	/**
	 * @param shelfSize the shelfSize to set
	 */
	public void setShelfSize(String shelfSize) {
		this.shelfSize = shelfSize;
	}
	/**
	 * balanceNumber
	 *
	 * @return  the balanceNumber
	 * @since   1.0.0
	 */
	
	public String getBalanceNumber() {
		return balanceNumber;
	}
	/**
	 * @param balanceNumber the balanceNumber to set
	 */
	public void setBalanceNumber(String balanceNumber) {
		this.balanceNumber = balanceNumber;
	}
	/**
	 * remark
	 *
	 * @return  the remark
	 * @since   1.0.0
	 */
	
	public String getRemark() {
		return remark==null?"":remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

