package com.deppon.wfs.workflow.domain;


import java.util.Date;

   /** 
   * @ClassName: DiscountapplyBean 
   * @Description:(折扣申请) 
   * @author 廖建雄 
   * @date 2014-1-16 下午4:48:04 
   * 
   */
public class DiscountapplyBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编号 
	*/
	private String busino;
	
	/** 
	* 工作流号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人部门 
	*/
	private String department;
	
	/** 
	* 折扣类型 
	*/
	private String discountType;
	
	/** 
	* 申请事由 
	*/
	private String reason;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 所属事业部 
	*/
	private String divisionCode;
	
	/** 
	* 表中数据的状态，0表示逻辑删除，1表示正在使用，默认为1 
	*/
	private String isseffective;
	
	/** 
	* 备用字段 
	*/
	private Long spareField1;
	
	/** 
	* 备用字段 
	*/
	private String spareField2;
	
	/** 
	* 备用字段 
	*/
	private String spareField3;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	
	/** 
	* 折扣类型中文输出
	*/
	private String discountTypeCN;
	
	public DiscountapplyBean(){}
	
	/**
	* 获取 业务编号.
	*
	* @return 业务编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务编号.
	*
	* @param 业务编号.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 工作流号.
	*
	* @return 工作流号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 工作流号.
	*
	* @param 工作流号.
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
	* 获取 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* 设置 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	* 获取 折扣类型.
	*
	* @return 折扣类型.
	*/
	public String getDiscountType() {
		return discountType;
	}

	/**
	* 设置 折扣类型.
	*
	* @param 折扣类型.
	*/
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
		this.discountTypeCN = this.discountType;
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
	* 获取 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	/**
	* 获取 表中数据的状态，0表示逻辑删除，1表示正在使用，默认为1.
	*
	* @return 表中数据的状态，0表示逻辑删除，1表示正在使用，默认为1.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 表中数据的状态，0表示逻辑删除，1表示正在使用，默认为1.
	*
	* @param 表中数据的状态，0表示逻辑删除，1表示正在使用，默认为1.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
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

	public String getDiscountTypeCN() {
	
	    return discountTypeCN;
	}

	public void setDiscountTypeCN(String discountTypeCN) {
	
	    this.discountTypeCN = discountTypeCN;
	}
	

}
