package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 活动报名申请实体Bean
 * @author Work Flow System
 * @Date 2013-12-26 10:26:48
 */
 
public class ActRegistrationBean extends Entity {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6250286189184132844L;

	/** 
	* 主键 
	*/
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
	* 所属部门 
	*/
	private String deptName;
	
	/** 
	* 所属部门编码 
	*/
	private String deptCode;
	
	/** 
	* 所属事业部编码 
	*/
	private String divisionCode;
	
	/** 
	* 入职日期 
	*/
	private Date joinDate;
	
	/** 
	* 申请人职位 
	*/
	private String position;
	
	/** 
	* 申请人电话 
	*/
	private String telephone;
	
	/** 
	* 申请项目 
	*/
	private String applyProject;
	
	/** 
	* 结婚证领取日期 
	*/
	private Date marrylicenseDate;
	
	/** 
	* 参加婚礼地点 
	*/
	private String weddingAddress;
	
	/** 
	* 身份证号码 
	*/
	private String cardno;
	
	/** 
	* 配偶是否德邦员工 
	*/
	private String isInternalStaff;
	
	/** 
	* 配偶姓名
	*/
	private String spouseName;
	
	/** 
	* 配偶工号 
	*/
	private String spouseCode;
	
	/** 
	* 配偶部门 
	*/
	private String spouseDept;
	
	/** 
	* 配偶部门编码 
	*/
	private String spouseDeptCode;
	
	/** 
	* 配偶所属事业部编码 
	*/
	private String spouseDivisionCode;
	
	/** 
	* 配偶入职时间 
	*/
	private Date spouseJoinDate;
	
	/** 
	* 配偶职位 
	*/
	private String spousePosition;
	
	/** 
	* 配偶电话 
	*/
	private String spouseTel;
	
	/** 
	* 身份证号（配偶） 
	*/
	private String spouseId;
	
	/** 
	* 工作单位 
	*/
	private String workUnit;
	
	/** 
	* 家属姓名 
	*/
	private String relationName;
	
	/** 
	* 与家属关系
	*/
	private String relationShip;
				   
	/** 
	* 家属电话 
	*/
	private String relationTel;
	
	/** 
	* 固定电话 
	*/
	private String fixedLine;
	
	/** 
	* 邮编 
	*/
	private String zipCode;
	
	/** 
	* 省份 
	*/
	private String province;
	
	/** 
	* 省份编码
	*/
	private String provinceCode;
	
	/** 
	* 城市 
	*/
	private String city;
	
	/** 
	* 城市编码
	*/
	private String cityCode;
	
	/** 
	* 区/县 
	*/
	private String districtCounty;
	
	/** 
	* 区/县编码 
	*/
	private String countyCode;
	
	/** 
	* 街道 
	*/
	private String street;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
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
	* 获取 主键.
	*
	* @return 主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 主键.
	*
	* @param 主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例ID.
	*
	* @return 流程实例ID.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例ID.
	*
	* @param 流程实例ID.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
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
	* 获取 所属部门.
	*
	* @return 所属部门.
	*/
	public String getDeptName() {
		return deptName;
	}

	/**
	* 设置 所属部门.
	*
	* @param 所属部门.
	*/
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	* 获取 所属部门编码.
	*
	* @return 所属部门编码.
	*/
	public String getDeptCode() {
		return deptCode;
	}

	/**
	* 设置 所属部门编码.
	*
	* @param 所属部门编码.
	*/
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	/**
	* 获取 所属事业部编码.
	*
	* @return 所属事业部编码.
	*/
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	* 设置 所属事业部编码.
	*
	* @param 所属事业部编码.
	*/
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	/**
	* 获取 入职日期.
	*
	* @return 入职日期.
	*/
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	* 设置 入职日期.
	*
	* @param 入职日期.
	*/
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
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
	* 获取 申请人电话.
	*
	* @return 申请人电话.
	*/
	public String getTelephone() {
		return telephone;
	}

	/**
	* 设置 申请人电话.
	*
	* @param 申请人电话.
	*/
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	* 获取 申请项目.
	*
	* @return 申请项目.
	*/
	public String getApplyProject() {
		return applyProject;
	}

	/**
	* 设置 申请项目.
	*
	* @param 申请项目.
	*/
	public void setApplyProject(String applyProject) {
		this.applyProject = applyProject;
	}
	
	/**
	* 获取 结婚证领取日期.
	*
	* @return 结婚证领取日期.
	*/
	public Date getMarrylicenseDate() {
		return marrylicenseDate;
	}

	/**
	* 设置 结婚证领取日期.
	*
	* @param 结婚证领取日期.
	*/
	public void setMarrylicenseDate(Date marrylicenseDate) {
		this.marrylicenseDate = marrylicenseDate;
	}
	
	/**
	* 获取 参加婚礼地点.
	*
	* @return 参加婚礼地点.
	*/
	public String getWeddingAddress() {
		return weddingAddress;
	}

	/**
	* 设置 参加婚礼地点.
	*
	* @param 参加婚礼地点.
	*/
	public void setWeddingAddress(String weddingAddress) {
		this.weddingAddress = weddingAddress;
	}
	
	/**
	* 获取 身份证号码.
	*
	* @return 身份证号码.
	*/
	public String getCardno() {
		return cardno;
	}

	/**
	* 设置 身份证号码.
	*
	* @param 身份证号码.
	*/
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	
	/**
	* 获取 配偶是否德邦员工.
	*
	* @return 配偶是否德邦员工.
	*/
	public String getIsInternalStaff() {
		return isInternalStaff;
	}

	/**
	* 设置 配偶是否德邦员工.
	*
	* @param 配偶是否德邦员工.
	*/
	public void setIsInternalStaff(String isInternalStaff) {
		this.isInternalStaff = isInternalStaff;
	}
	
	/**
	* 获取 配偶姓名（内部员工）.
	*
	* @return 配偶姓名（内部员工）.
	*/
	public String getSpouseName() {
		return spouseName;
	}

	/**
	* 设置 配偶姓名（内部员工）.
	*
	* @param 配偶姓名（内部员工）.
	*/
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	
	/**
	* 获取 配偶工号.
	*
	* @return 配偶工号.
	*/
	public String getSpouseCode() {
		return spouseCode;
	}

	/**
	* 设置 配偶工号.
	*
	* @param 配偶工号.
	*/
	public void setSpouseCode(String spouseCode) {
		this.spouseCode = spouseCode;
	}
	
	/**
	* 获取 配偶部门.
	*
	* @return 配偶部门.
	*/
	public String getSpouseDept() {
		return spouseDept;
	}

	/**
	* 设置 配偶部门.
	*
	* @param 配偶部门.
	*/
	public void setSpouseDept(String spouseDept) {
		this.spouseDept = spouseDept;
	}
	
	/**
	* 获取 配偶部门编码.
	*
	* @return 配偶部门编码.
	*/
	public String getSpouseDeptCode() {
		return spouseDeptCode;
	}

	/**
	* 设置 配偶部门编码.
	*
	* @param 配偶部门编码.
	*/
	public void setSpouseDeptCode(String spouseDeptCode) {
		this.spouseDeptCode = spouseDeptCode;
	}
	
	/**
	* 获取 配偶所属事业部编码.
	*
	* @return 配偶所属事业部编码.
	*/
	public String getSpouseDivisionCode() {
		return spouseDivisionCode;
	}

	/**
	* 设置 配偶所属事业部编码.
	*
	* @param 配偶所属事业部编码.
	*/
	public void setSpouseDivisionCode(String spouseDivisionCode) {
		this.spouseDivisionCode = spouseDivisionCode;
	}
	
	/**
	* 获取 配偶入职时间.
	*
	* @return 配偶入职时间.
	*/
	public Date getSpouseJoinDate() {
		return spouseJoinDate;
	}

	/**
	* 设置 配偶入职时间.
	*
	* @param 配偶入职时间.
	*/
	public void setSpouseJoinDate(Date spouseJoinDate) {
		this.spouseJoinDate = spouseJoinDate;
	}
	
	/**
	* 获取 配偶职位.
	*
	* @return 配偶职位.
	*/
	public String getSpousePosition() {
		return spousePosition;
	}

	/**
	* 设置 配偶职位.
	*
	* @param 配偶职位.
	*/
	public void setSpousePosition(String spousePosition) {
		this.spousePosition = spousePosition;
	}
	
	/**
	* 获取 配偶电话.
	*
	* @return 配偶电话.
	*/
	public String getSpouseTel() {
		return spouseTel;
	}

	/**
	* 设置 配偶电话.
	*
	* @param 配偶电话.
	*/
	public void setSpouseTel(String spouseTel) {
		this.spouseTel = spouseTel;
	}
	
	/**
	* 获取 身份证号（配偶）.
	*
	* @return 身份证号（配偶）.
	*/
	public String getSpouseId() {
		return spouseId;
	}

	/**
	* 设置 身份证号（配偶）.
	*
	* @param 身份证号（配偶）.
	*/
	public void setSpouseId(String spouseId) {
		this.spouseId = spouseId;
	}
	
	/**
	* 获取 工作单位.
	*
	* @return 工作单位.
	*/
	public String getWorkUnit() {
		return workUnit;
	}

	/**
	* 设置 工作单位.
	*
	* @param 工作单位.
	*/
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	
	/**
	* 获取 家属姓名.
	*
	* @return 家属姓名.
	*/
	public String getRelationName() {
		return relationName;
	}

	/**
	* 设置 与家属关系.
	*
	* @param 与家属关系.
	*/
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	
	/**
	* 获取 与家属关系.
	*
	* @return 与家属关系.
	*/
	public String getRelationShip() {
		return relationShip;
	}

	/**
	* 设置 家属姓名.
	*
	* @param 家属姓名.
	*/
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	
	/**
	* 获取 家属电话.
	*
	* @return 家属电话.
	*/
	public String getRelationTel() {
		return relationTel;
	}

	/**
	* 设置 家属电话.
	*
	* @param 家属电话.
	*/
	public void setRelationTel(String relationTel) {
		this.relationTel = relationTel;
	}
	
	/**
	* 获取 固定电话.
	*
	* @return 固定电话.
	*/
	public String getFixedLine() {
		return fixedLine;
	}

	/**
	* 设置 固定电话.
	*
	* @param 固定电话.
	*/
	public void setFixedLine(String fixedLine) {
		this.fixedLine = fixedLine;
	}
	
	/**
	* 获取 邮编.
	*
	* @return 邮编.
	*/
	public String getZipCode() {
		return zipCode;
	}

	/**
	* 设置 邮编.
	*
	* @param 邮编.
	*/
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	* 获取 省份.
	*
	* @return 省份.
	*/
	public String getProvince() {
		return province;
	}

	/**
	* 设置 省份.
	*
	* @param 省份.
	*/
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	* 获取 省份编码.
	*
	* @return 省份编码.
	*/
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	* 设置 省份.
	*
	* @param 省份编码.
	*/
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	* 获取 城市编码.
	*
	* @return 城市编码.
	*/
	public String getCityCode() {
		return cityCode;
	}

	/**
	* 设置 城市编码.
	*
	* @param 城市编码.
	*/
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	* 获取 区县编码.
	*
	* @return 区县编码.
	*/
	public String getCountyCode() {
		return countyCode;
	}

	/**
	* 设置 区县编码.
	*
	* @param 区县编码.
	*/
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	
	/**
	* 获取 城市.
	*
	* @return 城市.
	*/
	public String getCity() {
		return city;
	}

	/**
	* 设置 城市.
	*
	* @param 城市.
	*/
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	* 获取 区/县.
	*
	* @return 区/县.
	*/
	public String getDistrictCounty() {
		return districtCounty;
	}

	/**
	* 设置 区/县.
	*
	* @param 区/县.
	*/
	public void setDistrictCounty(String districtCounty) {
		this.districtCounty = districtCounty;
	}
	
	/**
	* 获取 街道.
	*
	* @return 街道.
	*/
	public String getStreet() {
		return street;
	}

	/**
	* 设置 街道.
	*
	* @param 街道.
	*/
	public void setStreet(String street) {
		this.street = street;
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
	* 获取 业务状态，是否有效（1-有效 0-无效）.
	*
	* @return 业务状态，是否有效（1-有效 0-无效）.
	*/
	public String getIsEffective() {
		return isEffective;
	}

	/**
	* 设置 业务状态，是否有效（1-有效 0-无效）.
	*
	* @param 业务状态，是否有效（1-有效 0-无效）.
	*/
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	
	/**
	* 获取 备注1.
	*
	* @return 备注1.
	*/
	public Long getReserve1() {
		return reserve1;
	}

	/**
	* 设置 备注1.
	*
	* @param 备注1.
	*/
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}
	
	/**
	* 获取 备注2.
	*
	* @return 备注2.
	*/
	public String getReserve2() {
		return reserve2;
	}

	/**
	* 设置 备注2.
	*
	* @param 备注2.
	*/
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	
	/**
	* 获取 备注3.
	*
	* @return 备注3.
	*/
	public String getReserve3() {
		return reserve3;
	}

	/**
	* 设置 备注3.
	*
	* @param 备注3.
	*/
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	

}
