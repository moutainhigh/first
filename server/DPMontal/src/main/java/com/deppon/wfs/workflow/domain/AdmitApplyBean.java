package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 接待申请数据实体bean
 * @author guanbo
 * @Date 2014-03-25 08:58:04
 */
 
public class AdmitApplyBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编号 
	*/
	private String busino;
	
	/** 
	* 流程实例号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人部门 
	*/
	private String dept;
	
	/** 
	* 申请人职位 
	*/
	private String position;
	
	/** 
	* 来访对象 
	*/
	private String visitors;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务数据创建时间 
	*/
	private Date createTime;
	
	/** 
	* 业务数据状态，1存在，0删除 
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
	* 当地办公室，老表数据兼容 
	*/
	private String localOffice;
	
	
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
	* 获取 流程实例号.
	*
	* @return 流程实例号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例号.
	*
	* @param 流程实例号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
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
	* 获取 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人姓名.
	*
	* @param 申请人姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getDept() {
		return dept;
	}

	/**
	* 设置 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/**
	* 获取 申请人职位.
	*
	* @return 申请人职位.
	*/
	public String getPosition() {
		return position;
	}

	/**
	* 设置 申请人职位.
	*
	* @param 申请人职位.
	*/
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	* 获取 来访对象.
	*
	* @return 来访对象.
	*/
	public String getVisitors() {
		return visitors;
	}

	/**
	* 设置 来访对象.
	*
	* @param 来访对象.
	*/
	public void setVisitors(String visitors) {
		this.visitors = visitors;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
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
	* 获取 业务数据创建时间.
	*
	* @return 业务数据创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 业务数据创建时间.
	*
	* @param 业务数据创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务数据状态，1存在，0删除.
	*
	* @return 业务数据状态，1存在，0删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务数据状态，1存在，0删除.
	*
	* @param 业务数据状态，1存在，0删除.
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
	* 获取 当地办公室，老表数据兼容.
	*
	* @return 当地办公室，老表数据兼容.
	*/
	public String getLocalOffice() {
		return localOffice;
	}

	/**
	* 设置 当地办公室，老表数据兼容.
	*
	* @param 当地办公室，老表数据兼容.
	*/
	public void setLocalOffice(String localOffice) {
		this.localOffice = localOffice;
	}
	

}
