package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 
 * 营销活动申请实体bean
 * @author Work Flow System
 * @Date 2013-10-25 20:36:43
 */
public class MarketActivityBean extends Entity{
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编号，主键 
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
	* 申请人工号 
	*/
	private String applyPersonId;
	/** 
	* 所属事业部 
	*/
	private String subOrdinateDivision;
	/**
	 * 部门使用数
	 */
	private Integer useDeptNum; 
	/** 
	* 营销所属类型 
	*/
	private String marketType;
	private String type;
	/** 
	* 宣传线路类型 
	*/
	private String propagandalineType;
	/** 
	* 宣传业务类型 
	*/
	private String propagandaBusType;
	/** 
	* 宣传行业类型 
	*/
	private String propagandainDustryType;
	/** 
	* 宣传空运类型 
	*/
	private String propaganDaairType;
	/** 
	* 宣传主题 
	*/
	private String propagandaTheme;
	/** 
	* 是否为现有资料补做 
	*/
	private String isRedo;
	/** 
	* 开展大区 
	*/
	private String regionin;
	/** 
	* 开展小区 
	*/
	private String conductsCommunity;
	/** 
	* 活动开始时间 
	*/
	private Date activityStartTime;
	/** 
	* 活动结束时间 
	*/
	private Date activityEndTime;
	/** 
	* 第一个月目标 
	*/
	private String firstTarget;
	/** 
	* 第二个月目标 
	*/
	private String secondTarget;
	/** 
	* 第三个月目标 
	*/
	private String thirdTarget;
	/** 
	* 申请数量 
	*/
	private Long applyNumber;
	/** 
	* 针对人群 
	*/
	private String accordingTocrowd;
	/** 
	* 对接人 
	*/
	private String dockingPeople;
	/** 
	* 联系电话 
	*/
	private String telphone;
	/** 
	* 设计类型 
	*/
	private String designType;
	/** 
	* 申请事由 
	*/
	private String reason;
	/** 
	* 是否有效 1：有效 0：无效 
	*/
	private String isseffective;
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
	/**
	 *可提货时间
	 */
	private String deliveryTime; 
	/**
	 *到达城市
	 */
	private String toCity;
    /**
     * 出发城市
     */
	private String fromCity; 
	
	/**
	* 可提货时间
	*
	* @return 可提货时间
	*/
	public String getDeliveryTime() {
		return deliveryTime;
	}
	/**
	 * 
	*可提货时间
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	/**
	* 到达城市
	*
	* @return 到达城市
	*/
	public String getToCity() {
		return toCity;
	}
	/**
	*到达城市
	*/
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	/**
	* 出发城市
	*
	* @return 出发城市
	*/
	public String getFromCity() {
		return fromCity;
	}
	/**
	*出发城市
	*
	* @return 出发城市
	*/
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	/** 
	 * 
	 * 鑾峰彇 业务编号，主键.
	*
	* @return 业务编号，主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 璁剧疆 业务编号，主键.
	*
	* @param 业务编号，主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	* 鑾峰彇 工作流号.
	*
	* @return 工作流号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 璁剧疆 工作流号.
	*
	* @param 工作流号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	* 鑾峰彇 申请人.
	*
	* @return 申请人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 璁剧疆 申请人.
	*
	* @param 申请人.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	* 鑾峰彇 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	* 璁剧疆 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	* 鑾峰彇 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getSubOrdinateDivision() {
		return subOrdinateDivision;
	}

	/**
	* 璁剧疆 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setSubOrdinateDivision(String subOrdinateDivision) {
		this.subOrdinateDivision = subOrdinateDivision;
	}
	/**
	* 鑾峰彇 营销所属类型.
	*
	* @return 营销所属类型.
	*/
	public String getMarketType() {
		return marketType;
	}

	/**
	* 璁剧疆 营销所属类型.
	*
	* @param 营销所属类型.
	*/
	public void setMarketType(String marketType) {
		this.marketType = marketType;
		this.type = this.marketType;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	/**
	* 鑾峰彇 宣传线路类型.
	*
	* @return 宣传线路类型.
	*/
	public String getPropagandalineType() {
		return propagandalineType;
	}

	/**
	* 璁剧疆 宣传线路类型.
	*
	* @param 宣传线路类型.
	*/
	public void setPropagandalineType(String propagandalineType) {
		this.propagandalineType = propagandalineType;
	}
	/**
	* 鑾峰彇 宣传业务类型.
	*
	* @return 宣传业务类型.
	*/
	public String getPropagandaBusType() {
		return propagandaBusType;
	}

	/**
	* 璁剧疆 宣传业务类型.
	*
	* @param 宣传业务类型.
	*/
	public void setPropagandaBusType(String propagandaBusType) {
		this.propagandaBusType = propagandaBusType;
	}
	/**
	* 鑾峰彇 宣传行业类型.
	*
	* @return 宣传行业类型.
	*/
	public String getPropagandainDustryType() {
		return propagandainDustryType;
	}

	/**
	* 璁剧疆 宣传行业类型.
	*
	* @param 宣传行业类型.
	*/
	public void setPropagandainDustryType(String propagandainDustryType) {
		this.propagandainDustryType = propagandainDustryType;
	}
	/**
	* 鑾峰彇 宣传空运类型.
	*
	* @return 宣传空运类型.
	*/
	public String getPropaganDaairType() {
		return propaganDaairType;
	}

	/**
	* 璁剧疆 宣传空运类型.
	*
	* @param 宣传空运类型.
	*/
	public void setPropaganDaairType(String propaganDaairType) {
		this.propaganDaairType = propaganDaairType;
	}
	/**
	* 鑾峰彇 宣传主题.
	*
	* @return 宣传主题.
	*/
	public String getPropagandaTheme() {
		return propagandaTheme;
	}

	/**
	* 璁剧疆 宣传主题.
	*
	* @param 宣传主题.
	*/
	public void setPropagandaTheme(String propagandaTheme) {
		this.propagandaTheme = propagandaTheme;
	}
	/**
	* 鑾峰彇 是否为现有资料补做.
	*
	* @return 是否为现有资料补做.
	*/
	public String getIsRedo() {
		return isRedo;
	}

	/**
	* 璁剧疆 是否为现有资料补做.
	*
	* @param 是否为现有资料补做.
	*/
	public void setIsRedo(String isRedo) {
		this.isRedo = isRedo;
	}
	/**
	* 鑾峰彇 开展大区.
	*
	* @return 开展大区.
	*/
	public String getRegionin() {
		return regionin;
	}

	/**
	* 璁剧疆 开展大区.
	*
	* @param 开展大区.
	*/
	public void setRegionin(String regionin) {
		this.regionin = regionin;
	}
	/**
	* 鑾峰彇 开展小区.
	*
	* @return 开展小区.
	*/
	public String getConductsCommunity() {
		return conductsCommunity;
	}

	/**
	* 璁剧疆 开展小区.
	*
	* @param 开展小区.
	*/
	public void setConductsCommunity(String conductsCommunity) {
		this.conductsCommunity = conductsCommunity;
	}
	/**
	* 鑾峰彇 活动开始时间.
	*
	* @return 活动开始时间.
	*/
	public Date getActivityStartTime() {
		return activityStartTime;
	}

	/**
	* 璁剧疆 活动开始时间.
	*
	* @param 活动开始时间.
	*/
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	/**
	* 鑾峰彇 活动结束时间.
	*
	* @return 活动结束时间.
	*/
	public Date getActivityEndTime() {
		return activityEndTime;
	}

	/**
	* 璁剧疆 活动结束时间.
	*
	* @param 活动结束时间.
	*/
	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	/**
	* 鑾峰彇 第一个月目标.
	*
	* @return 第一个月目标.
	*/
	public String getFirstTarget() {
		return firstTarget;
	}

	/**
	* 璁剧疆 第一个月目标.
	*
	* @param 第一个月目标.
	*/
	public void setFirstTarget(String firstTarget) {
		this.firstTarget = firstTarget;
	}
	/**
	* 鑾峰彇 第二个月目标.
	*
	* @return 第二个月目标.
	*/
	public String getSecondTarget() {
		return secondTarget;
	}

	/**
	* 璁剧疆 第二个月目标.
	*
	* @param 第二个月目标.
	*/
	public void setSecondTarget(String secondTarget) {
		this.secondTarget = secondTarget;
	}
	/**
	* 鑾峰彇 第三个月目标.
	*
	* @return 第三个月目标.
	*/
	public String getThirdTarget() {
		return thirdTarget;
	}

	/**
	* 璁剧疆 第三个月目标.
	*
	* @param 第三个月目标.
	*/
	public void setThirdTarget(String thirdTarget) {
		this.thirdTarget = thirdTarget;
	}
	/**
	* 鑾峰彇 申请数量.
	*
	* @return 申请数量.
	*/
	public Long getApplyNumber() {
		return applyNumber;
	}

	/**
	* 璁剧疆 申请数量.
	*
	* @param 申请数量.
	*/
	public void setApplyNumber(Long applyNumber) {
		this.applyNumber = applyNumber;
	}
	/**
	* 鑾峰彇 针对人群.
	*
	* @return 针对人群.
	*/
	public String getAccordingTocrowd() {
		return accordingTocrowd;
	}

	/**
	* 璁剧疆 针对人群.
	*
	* @param 针对人群.
	*/
	public void setAccordingTocrowd(String accordingTocrowd) {
		this.accordingTocrowd = accordingTocrowd;
	}
	/**
	* 鑾峰彇 对接人.
	*
	* @return 对接人.
	*/
	public String getDockingPeople() {
		return dockingPeople;
	}

	/**
	* 璁剧疆 对接人.
	*
	* @param 对接人.
	*/
	public void setDockingPeople(String dockingPeople) {
		this.dockingPeople = dockingPeople;
	}
	/**
	* 鑾峰彇 联系电话.
	*
	* @return 联系电话.
	*/
	public String getTelphone() {
		return telphone;
	}

	/**
	* 璁剧疆 联系电话.
	*
	* @param 联系电话.
	*/
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	/**
	* 鑾峰彇 设计类型.
	*
	* @return 设计类型.
	*/
	public String getDesignType() {
		return designType;
	}

	/**
	* 璁剧疆 设计类型.
	*
	* @param 设计类型.
	*/
	public void setDesignType(String designType) {
		this.designType = designType;
	}
	/**
	* 鑾峰彇 申请事由.
	*
	* @return 申请事由.
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 璁剧疆 申请事由.
	*
	* @param 申请事由.
	*/
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	* 鑾峰彇 是否有效 1：有效 0：无效.
	*
	* @return 是否有效 1：有效 0：无效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 璁剧疆 是否有效 1：有效 0：无效.
	*
	* @param 是否有效 1：有效 0：无效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	/**
	* 鑾峰彇 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 璁剧疆 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	* 鑾峰彇 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 璁剧疆 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	* 鑾峰彇 备用字段1.
	*
	* @return 备用字段1.
	*/
	public String getSpareField1() {
		return spareField1;
	}

	/**
	* 璁剧疆 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(String spareField1) {
		this.spareField1 = spareField1;
	}
	/**
	* 鑾峰彇 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 璁剧疆 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	/**
	* 部门使用数 
	* 
	*/
	public Integer getUseDeptNum() {
		return useDeptNum;
	}
	/**
	* 部门使用数 
	*/
	public void setUseDeptNum(Integer useDeptNum) {
		this.useDeptNum = useDeptNum;
	}
}
