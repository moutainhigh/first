package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 人事授权申请工作流实体Bean
* @title: WarrantEntityBean 
* @description：TODO
* @author： 柳发勇
* @date： 2013-11-27 上午8:58:46
 */
public class WarrantEntityBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
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
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 备用字段1 
	*/
	private String spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 被授权人姓名 
	*/
	private String impowerto;
	
	/** 
	* 被授权人工号 
	*/
	private String impowerid;
	
	/** 
	* 授权开始时间 
	*/
	private Date impowerstarttime;
	
	/** 
	* 授权结束时间 
	*/
	private Date impowerendtime;
	
	/** 
	* 申请内容 
	*/
	private String reason;
	
	
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
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public String getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(String spareField1) {
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
	* 获取 被授权人姓名.
	*
	* @return 被授权人姓名.
	*/
	public String getImpowerto() {
		return impowerto;
	}

	/**
	* 设置 被授权人姓名.
	*
	* @param 被授权人姓名.
	*/
	public void setImpowerto(String impowerto) {
		this.impowerto = impowerto;
	}
	
	/**
	* 获取 被授权人工号.
	*
	* @return 被授权人工号.
	*/
	public String getImpowerid() {
		return impowerid;
	}

	/**
	* 设置 被授权人工号.
	*
	* @param 被授权人工号.
	*/
	public void setImpowerid(String impowerid) {
		this.impowerid = impowerid;
	}
	
	/**
	* 获取 授权开始时间.
	*
	* @return 授权开始时间.
	*/
	public Date getImpowerstarttime() {
		return impowerstarttime;
	}


	/**
	* 设置 授权开始时间.
	*
	* @param 授权开始时间.
	*/
	
	public void setImpowerstarttime(Date impowerstarttime) {
		this.impowerstarttime = impowerstarttime;
	}
	
	/**
	* 获取 授权结束时间.
	*
	* @return 授权结束时间.
	*/
	public Date getImpowerendtime() {
		return impowerendtime;
	}

	/**
	* 设置 授权结束时间.
	*
	* @param 授权结束时间.
	*/
	public void setImpowerendtime(Date impowerendtime) {
		this.impowerendtime = impowerendtime;
	}
	
	/**
	* 获取 申请内容.
	*
	* @return 申请内容.
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 设置 申请内容.
	*
	* @param 申请内容.
	*/
	public void setReason(String reason) {
		this.reason = reason;
	}
}
