package com.deppon.dpm.module.lsp.shared.domain;

/**
 * @author 268101 实体对象
 */
public class SynchronousStocktaskingInfo {

	/**
	 * 盘点状态
	 */
	private String stockStatus;
	/**
	 * 盘点单号
	 */
	private String billNo;
	/**
	 * 序列号
	 */
	private Long seq;
	/**
	 * 主键
	 */
	private String id;

	/*
	 * 管理编码
	 */
	private String managementCode;
	/*
	 * 资产名称
	 */
	private String fixedAssetsName;
	/*
	 * 差异数量
	 */
	private String differencesNum;
	/*
	 * 备注
	 */
	private String remark;
	/*
	 * 使用部门
	 */
	private String department;
	/*
	 * 资产编码
	 */
	private String assetCoding;
	/*
	 * 账面数量
	 */
	private String carryingAmount;
	/*
	 * 实盘数量
	 */
	private String realNum;
	/**
	 * 对分录行的操作类别 1新增，2删除 0正常更新
	 */
	private Integer operateCode;
	/*
	 * 分录行唯一标示符。
	 */
	private String entityid;
	/**
	 * 用户
	 */
	private String usePerson;

	/**
	 * @return 管理编码
	 */
	public String getManagementCode() {
		return managementCode;
	}

	/**
	 * @param managementCode 管理编码
	 */
	public void setManagementCode(String managementCode) {
		this.managementCode = managementCode;
	}

	/**
	 * @return fixedAssetsName
	 */
	public String getFixedAssetsName() {
		return fixedAssetsName;
	}

	/**
	 * @param fixedAssetsName fixedAssetsName
	 */
	public void setFixedAssetsName(String fixedAssetsName) {
		this.fixedAssetsName = fixedAssetsName;
	}

	/**
	 * @return 差异数量
	 */
	public String getDifferencesNum() {
		return differencesNum;
	}

	/**
	 * @param differencesNum 差异数量
	 */
	public void setDifferencesNum(String differencesNum) {
		this.differencesNum = differencesNum;
	}

	/**
	 * @return 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return 使用部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department 使用部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return 资产编码
	 */
	public String getAssetCoding() {
		return assetCoding;
	}

	/**
	 * @param assetCoding 资产编码
	 */
	public void setAssetCoding(String assetCoding) {
		this.assetCoding = assetCoding;
	}

	/**
	 * @return  账面数量
	 */
	public String getCarryingAmount() {
		return carryingAmount;
	}

	/**
	 * @param carryingAmount  账面数量
	 */
	public void setCarryingAmount(String carryingAmount) {
		this.carryingAmount = carryingAmount;
	}

	/**
	 * @return 实盘数量
	 */
	public String getRealNum() {
		return realNum;
	}

	/**
	 * @param realNum 实盘数量
	 */
	public void setRealNum(String realNum) {
		this.realNum = realNum;
	}

	/**
	 * @return 对分录行的操作类别 1新增，2删除 0正常更新
	 */
	public Integer getOperateCode() {
		return operateCode;
	}

	/**
	 * @param operateCode 对分录行的操作类别 1新增，2删除 0正常更新
	 */
	public void setOperateCode(Integer operateCode) {
		this.operateCode = operateCode;
	}

	/**
	 * @return 主键id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 主键id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 盘点状态
	 */ 
	public String getStockStatus() {
		return stockStatus;
	}

	/**
	 * @param stockStatus 盘点状态
	 */
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	/**
	 * @return  盘点单号
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * @param billNo  盘点单号
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getEntityid() {
		return entityid;
	}

	public void setEntityid(String entityid) {
		this.entityid = entityid;
	}

	/**
	 * @return 用户
	 */
	public String getUsePerson() {
		return usePerson;
	}

	/**
	 * @param usePerson 用户
	 */
	public void setUsePerson(String usePerson) {
		this.usePerson = usePerson;
	}

}
