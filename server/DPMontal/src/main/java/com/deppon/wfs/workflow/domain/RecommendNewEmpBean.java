package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 推荐新员工申请实体Bean
 * @author wuguiping
 * @Date 2013-11-27 19:27:02
 */
 
public class RecommendNewEmpBean extends Entity {
	
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
	* 备用字段3 
	*/
	private Long spareField3;
	
	/** 
	* 被推荐人姓名
	*/
	private String recommendedName;
	
	/** 
	* 与推荐人关系 
	*/
	private String relation;
	
	/**
	 * 被推荐人性别
	 */
	private String recommendedSex;
	
	/** 
	* 被推荐人学历
	*/
	private String recommendedEdu;
	
	/** 
	* 毕业院校 
	*/
	private String graduateCollege;
	
	/** 
	* 毕业年限 
	*/
	private String graduateYears;
	
	/** 
	* 推荐类型 
	*/
	private String recommendedType;
	
	
	/** 
	* 被推荐人欲入职区域 
	*/
	private String recommendedArea;
	
	/** 
	* 推荐入职部门
	*/
	private String recommendedDept;
	
	/** 
	* 申请事由 
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
	* 获取 被推荐人姓名
	*
	* @return 被推荐人姓名.
	*/
	public String getRecommendedName() {
		return recommendedName;
	}

	/**
	* 设置被推荐人姓名.
	*
	* @return 被推荐人姓名.
	*/
	public void setRecommendedName(String recommendedName) {
		this.recommendedName = recommendedName;
	}

	/**
	* 获取 与申请人关系.
	*
	* @return 与申请人关系.
	*/
	public String getRelation() {
		return relation;
	}

	/**
	* 设置与申请人关系
	*
	* @return 与申请人关系.
	*/
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	* 获取 被推荐人性别.
	*
	* @return 被推荐人性别.
	*/
	public String getRecommendedSex() {
		return recommendedSex;
	}

	/**
	* 设置被推荐人性别.
	*
	* @return 被推荐人性别.
	*/
	public void setRecommendedSex(String recommendedSex) {
		this.recommendedSex = recommendedSex;
	}

	/**
	* 获取 被推荐人学历.
	*
	* @return 被推荐人学历.
	*/
	public String getRecommendedEdu() {
		return recommendedEdu;
	}

	/**
	* 设置被推荐人学历.
	*
	* @return 被推荐人学历.
	*/
	public void setRecommendedEdu(String recommendedEdu) {
		this.recommendedEdu = recommendedEdu;
	}

	/**
	* 获取 毕业院校.
	*
	* @return 毕业院校.
	*/
	public String getGraduateCollege() {
		return graduateCollege;
	}

	/**
	* 设置毕业院校.
	*
	* @return 毕业院校.
	*/
	public void setGraduateCollege(String graduateCollege) {
		this.graduateCollege = graduateCollege;
	}

	/**
	* 获取 毕业年限.
	*
	* @return 毕业年限.
	*/
	public String getGraduateYears() {
		return graduateYears;
	}
	
	/**
	* 设置毕业年限.
	*
	* @return 毕业年限.
	*/
	public void setGraduateYears(String graduateYears) {
		this.graduateYears = graduateYears;
	}

	/**
	* 获取 推荐类型.
	*
	* @return 推荐类型.
	*/
	public String getRecommendedType() {
		return recommendedType;
	}

	/**
	* 设置推荐类型.
	*
	* @return 推荐类型.
	*/
	public void setRecommendedType(String recommendedType) {
		this.recommendedType = recommendedType;
	}

	/**
	* 获取被推荐人欲入职大区.
	*
	* @return 被推荐人欲入职大区.
	*/
	public String getRecommendedArea() {
		return recommendedArea;
	}

	/**
	* 设置被推荐人欲入职大区.
	*
	* @return 被推荐人欲入职大区.
	*/
	public void setRecommendedArea(String recommendedArea) {
		this.recommendedArea = recommendedArea;
	}

	/**
	* 获取被推荐人欲入职部门名称.
	*
	* @return 被推荐人欲入职部门名称.
	*/
	public String getRecommendedDept() {
		return recommendedDept;
	}

	/**
	* 设置被推荐人欲入职部门名称.
	*
	* @return 被推荐人欲入职部门名称.
	*/
	public void setRecommendedDept(String recommendedDept) {
		this.recommendedDept = recommendedDept;
	}
}
