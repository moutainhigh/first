package com.deppon.wfs.workflow.domain;

import java.util.Date;
import java.util.List;

/**
 * 长途司机时效减免申请bean
 * @author wuguiping
 * @Date 2013-12-25 17:47:12
 */
 
public class LongDisDriverAgingBreaksBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 长途司机时效减免申请分录信息. */
	private List<LongDisDriversDataDellBean> dataCells;
	
	/** 长途司机时效减免申请分录信息的json字符串. */
	private String longDisDriversDataDells;
	
	/** 
	* 业务编码 
	*/
	private String busino;
	
	/** 
	* 工作流序号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 部门 
	*/
	private String applyDept;
	
	/** 
	* 部门ID 
	*/
	private String applyDeptId;
	
	/** 
	* 联系方式 
	*/
	private String contact;
	
	/** 
	* 是否涉及安全 
	*/
	private String isInvolvingSecurity;
	
	/** 
	* 申请事由 
	*/
	private String reason;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 备用字段1 
	*/
	private Long spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 备用字段3 
	*/
	private String spareField3;
	
	
	/**
	* 获取 业务编码.
	*
	* @return 业务编码.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务编码.
	*
	* @param 业务编码.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 工作流序号.
	*
	* @return 工作流序号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 工作流序号.
	*
	* @param 工作流序号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人.
	*
	* @return 申请人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人.
	*
	* @param 申请人.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 部门.
	*
	* @return 部门.
	*/
	public String getApplyDept() {
		return applyDept;
	}

	/**
	* 设置 部门.
	*
	* @param 部门.
	*/
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	
	/**
	* 获取 部门ID.
	*
	* @return 部门ID.
	*/
	public String getApplyDeptId() {
		return applyDeptId;
	}

	/**
	* 设置 部门ID.
	*
	* @param 部门ID.
	*/
	public void setApplyDeptId(String applyDeptId) {
		this.applyDeptId = applyDeptId;
	}
	
	/**
	* 获取 联系方式.
	*
	* @return 联系方式.
	*/
	public String getContact() {
		return contact;
	}

	/**
	* 设置 联系方式.
	*
	* @param 联系方式.
	*/
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	* 获取 是否涉及安全.
	*
	* @return 是否涉及安全.
	*/
	public String getIsInvolvingSecurity() {
		return isInvolvingSecurity;
	}

	/**
	* 设置 是否涉及安全.
	*
	* @param 是否涉及安全.
	*/
	public void setIsInvolvingSecurity(String isInvolvingSecurity) {
		this.isInvolvingSecurity = isInvolvingSecurity;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	* 获取 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 设置 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 是否有效.
	*
	* @return 是否有效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 是否有效.
	*
	* @param 是否有效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 设置 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}

	/**
	* 获取 长途司机时效减免申请分录信息.
	*
	* @return长途司机时效减免申请分录信息.
	*/
	public List<LongDisDriversDataDellBean> getDataCells() {
		return dataCells;
	}

	/**
	* 设置 长途司机时效减免申请分录信息.
	*
	* @param 长途司机时效减免申请分录信息.
	*/
	public void setDataCells(List<LongDisDriversDataDellBean> dataCells) {
		this.dataCells = dataCells;
	}

	/**
	* 获取 长途司机时效减免申请分录信息的json字符串.
	*
	* @return 长途司机时效减免申请分录信息的json字符串.
	*/
	public String getLongDisDriversDataDells() {
		return longDisDriversDataDells;
	}

	/**
	* 设置 长途司机时效减免申请分录信息的json字符串.
	*
	* @param 长途司机时效减免申请分录信息的json字符串.
	*/
	public void setLongDisDriversDataDells(String longDisDriversDataDells) {
		this.longDisDriversDataDells = longDisDriversDataDells;
	}
}
