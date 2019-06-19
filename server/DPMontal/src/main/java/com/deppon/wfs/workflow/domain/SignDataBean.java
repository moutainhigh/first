package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: SignDataBean 
 * @description： 法定代表人/负责人签字申请签字资料实体Bean
 * @author： wuyaqing
 * @date： 2013年11月26日 下午1:59:53
 */
/**
 * 命名空间
 */
public class SignDataBean implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8730095704787901837L;

	/** 
	* 业务编码 
	*/
	private String legalsignno;
	
	/** 
	* 外键 
	*/
	private String busino;
	
	/** 
	* 签字资料份数 
	*/
	private String signdataNum;
	
	/** 
	* 签字资料名称 
	*/
	private String signdataName;
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
	* 是否有效 
	*/
	private String isseffective;
	
	
	
	/**
	* 获取 外键.
	*
	* @return 外键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 外键.
	*
	* @param 外键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
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
	* 获取 主键.
	*
	* @return 主键.
	*/
	public String getLegalsignno() {
		return legalsignno;
	}

	/**
	* 设置 主键.
	*
	* @param 主键.
	*/
	public void setLegalsignno(String legalsignno) {
		this.legalsignno = legalsignno;
	}
	
	/**
	* 获取 签字资料份数.
	*
	* @return 签字资料份数.
	*/
	public String getSigndataNum() {
		return signdataNum;
	}

	/**
	* 设置 签字资料份数.
	*
	* @param 签字资料份数.
	*/
	public void setSigndataNum(String signdataNum) {
		this.signdataNum = signdataNum;
	}
	
	/**
	* 获取 签字资料名称.
	*
	* @return 签字资料名称.
	*/
	public String getSigndataName() {
		return signdataName;
	}

	/**
	* 设置 签字资料名称.
	*
	* @param 签字资料名称.
	*/
	public void setSigndataName(String signdataName) {
		this.signdataName = signdataName;
	}
	

}
