package com.deppon.wfs.workflow.domain;



import java.util.Date;


/**
 * 刻章申请子表
 * @author gaoyazhe 
 * @Date 2014-06-07 16:49:29
 */
 
public class SealCarveApplyDetailBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 父表的主键 
	*/

	private String busino;
	
	/** 
	* 印章名称 
	*/
	private String sealName;
	
	/** 
	* 是否首次刻制
	*/
	private String firstCarve;
	
	/** 
	* 发证日期(营业执照) 
	*/
	private Date provideTime;
	
	/** 
	* 发放单位(仅迁移)
	*/
	private String provideCom;
	
	/** 
	* 是否在公安局备案(仅迁移)
	*/
	private String recordInps;
	
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
	private String spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 备用字段3 
	*/
	private Long spareField3;
	
	/**
	* 获取 父表的主键.
	*
	* @return 父表的主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 父表的主键.
	*
	* @param 父表的主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	* 获取 印章名称.
	*
	* @return 印章名称.
	*/
	public String getSealName() {
		return sealName;
	}

	/**
	* 设置 是否首次刻制.
	*
	* @param 是否首次刻制.
	*/
	public void setSealName(String sealName) {
		this.sealName = sealName;
	}

	/**
	* 获取 是否首次刻制.
	*
	* @return 是否首次刻制.
	*/
	public String getFirstCarve() {
		return firstCarve;
	}

	/**
	* 设置 是否首次刻制.
	*
	* @param 是否首次刻制.
	*/
	public void setFirstCarve(String firstCarve) {
		this.firstCarve = firstCarve;
	}

	/**
	* 获取 发证日期(营业执照) .
	*
	* @return 发证日期(营业执照) .
	*/
	public Date getProvideTime() {
		return provideTime;
	}

	/**
	* 设置 发证日期(营业执照) .
	*
	* @param 发证日期(营业执照) .
	*/
	public void setProvideTime(Date provideTime) {
		this.provideTime = provideTime;
	}

	/**
	* 获取 发放单位(仅迁移).
	*
	* @return 发放单位(仅迁移).
	*/
	public String getProvideCom() {
		return provideCom;
	}

	/**
	* 设置 发放单位(仅迁移).
	*
	* @param 发放单位(仅迁移).
	*/
	public void setProvideCom(String provideCom) {
		this.provideCom = provideCom;
	}

	/**
	* 获取 是否在公安局备案(仅迁移).
	*
	* @return 是否在公安局备案(仅迁移).
	*/
	public String getRecordInps() {
		return recordInps;
	}

	/**
	* 设置 是否在公安局备案(仅迁移).
	*
	* @param 是否在公安局备案(仅迁移).
	*/
	public void setRecordInps(String recordInps) {
		this.recordInps = recordInps;
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
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public Long getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setSpareField3(Long spareField3) {
		this.spareField3 = spareField3;
	}
}
