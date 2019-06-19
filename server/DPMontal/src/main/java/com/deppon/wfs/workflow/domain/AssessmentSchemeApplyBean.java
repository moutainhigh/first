
package com.deppon.wfs.workflow.domain; 

import java.util.Date;

/** 
 * @Title: AssessmentSchemeApplyBean.java
 * @Package com.deppon.wfs.workflow.domain 
 * @Description: 考核方案申请
 * @author yinrongping 
 * @date 2014-1-14 下午2:30:11 
 * @version V1.0 
 */
    public class AssessmentSchemeApplyBean extends Entity {
    	
    	/** 
    	* The Constant serialVersionUID. 
    	*/
    	private static final long serialVersionUID = 1L;
    	
    	/** 
    	* 业务表主键 
    	*/
    	private String busino;
    	
    	/** 
    	* 流程实例号 
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
    	* 申请人部门 
    	*/
    	private String dept;
    	
    	/** 
    	* 申请人部门的编码——用来存转储数据的这个字段 
    	*/
    	private String deptCode;
    	
    	/** 
    	* 考核年份 
    	*/
    	private String year;
    	
    	/** 
    	* 考核季度 
    	*/
    	private String season;
    	
    	/** 
    	* 申请原因 
    	*/
    	private String applyReason;
    	
    	/** 
    	* 部门性质 
    	*/
    	private String quality;
    	
    	/** 
    	* 考核小组名称 
    	*/
    	private String checkTeamName;
    	
    	/** 
    	* 考核小组标杆编码 
    	*/
    	private String checkTeamCode;
    	
    	/** 
    	* 考核专员/绩效管理员对应的部门名称 
    	*/
    	private String personMappingDeptName;
    	
    	/** 
    	* 考核专员/绩效管理员对应的部门标杆编码 
    	*/
    	private String personMappingDeptCode;
    	
    	/** 
    	* 工作流修改时间 
    	*/
    	private Date modifyTime;
    	
    	/** 
    	* 工作流创建时间 
    	*/
    	private Date createTime;
    	
    	/** 
    	* 业务状态，1表示逻辑存在，0表示逻辑删除 
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
    	* ��ȡ 业务表主键.
    	*
    	* @return 业务表主键.
    	*/
    	public String getBusino() {
    		return busino;
    	}

    	/**
    	* ���� 业务表主键.
    	*
    	* @param 业务表主键.
    	*/
    	public void setBusino(String busino) {
    		this.busino = busino;
    	}
    	
    	/**
    	* ��ȡ 流程实例号.
    	*
    	* @return 流程实例号.
    	*/
    	public Long getProcessinstid() {
    		return processinstid;
    	}

    	/**
    	* ���� 流程实例号.
    	*
    	* @param 流程实例号.
    	*/
    	public void setProcessinstid(Long processinstid) {
    		this.processinstid = processinstid;
    	}
    	
    	/**
    	* ��ȡ 申请人姓名.
    	*
    	* @return 申请人姓名.
    	*/
    	public String getApplyPersonName() {
    		return applyPersonName;
    	}

    	/**
    	* ���� 申请人姓名.
    	*
    	* @param 申请人姓名.
    	*/
    	public void setApplyPersonName(String applyPersonName) {
    		this.applyPersonName = applyPersonName;
    	}
    	
    	/**
    	* ��ȡ 申请人工号.
    	*
    	* @return 申请人工号.
    	*/
    	public String getApplyPersonId() {
    		return applyPersonId;
    	}

    	/**
    	* ���� 申请人工号.
    	*
    	* @param 申请人工号.
    	*/
    	public void setApplyPersonId(String applyPersonId) {
    		this.applyPersonId = applyPersonId;
    	}
    	
    	/**
    	* ��ȡ 申请人部门.
    	*
    	* @return 申请人部门.
    	*/
    	public String getDept() {
    		return dept;
    	}

    	/**
    	* ���� 申请人部门.
    	*
    	* @param 申请人部门.
    	*/
    	public void setDept(String dept) {
    		this.dept = dept;
    	}
    	
    	/**
    	* ��ȡ 申请人部门的编码——用来存转储数据的这个字段.
    	*
    	* @return 申请人部门的编码——用来存转储数据的这个字段.
    	*/
    	public String getDeptCode() {
    		return deptCode;
    	}

    	/**
    	* ���� 申请人部门的编码——用来存转储数据的这个字段.
    	*
    	* @param 申请人部门的编码——用来存转储数据的这个字段.
    	*/
    	public void setDeptCode(String deptCode) {
    		this.deptCode = deptCode;
    	}
    	
    	/**
    	* ��ȡ 考核年份.
    	*
    	* @return 考核年份.
    	*/
    	public String getYear() {
    		return year;
    	}

    	/**
    	* ���� 考核年份.
    	*
    	* @param 考核年份.
    	*/
    	public void setYear(String year) {
    		this.year = year;
    	}
    	
    	/**
    	* ��ȡ 考核季度.
    	*
    	* @return 考核季度.
    	*/
    	public String getSeason() {
    		return season;
    	}

    	/**
    	* ���� 考核季度.
    	*
    	* @param 考核季度.
    	*/
    	public void setSeason(String season) {
    		this.season = season;
    	}
    	
    	/**
    	* ��ȡ 申请原因.
    	*
    	* @return 申请原因.
    	*/
    	public String getApplyReason() {
    		return applyReason;
    	}

    	/**
    	* ���� 申请原因.
    	*
    	* @param 申请原因.
    	*/
    	public void setApplyReason(String applyReason) {
    		this.applyReason = applyReason;
    	}
    	
    	/**
    	* ��ȡ 部门性质.
    	*
    	* @return 部门性质.
    	*/
    	public String getQuality() {
    		return quality;
    	}

    	/**
    	* ���� 部门性质.
    	*
    	* @param 部门性质.
    	*/
    	public void setQuality(String quality) {
    		this.quality = quality;
    	}
    	
    	/**
    	* ��ȡ 考核小组名称.
    	*
    	* @return 考核小组名称.
    	*/
    	public String getCheckTeamName() {
    		return checkTeamName;
    	}

    	/**
    	* ���� 考核小组名称.
    	*
    	* @param 考核小组名称.
    	*/
    	public void setCheckTeamName(String checkTeamName) {
    		this.checkTeamName = checkTeamName;
    	}
    	
    	/**
    	* ��ȡ 考核小组标杆编码.
    	*
    	* @return 考核小组标杆编码.
    	*/
    	public String getCheckTeamCode() {
    		return checkTeamCode;
    	}

    	/**
    	* ���� 考核小组标杆编码.
    	*
    	* @param 考核小组标杆编码.
    	*/
    	public void setCheckTeamCode(String checkTeamCode) {
    		this.checkTeamCode = checkTeamCode;
    	}
    	
    	/**
    	* ��ȡ 考核专员/绩效管理员对应的部门名称.
    	*
    	* @return 考核专员/绩效管理员对应的部门名称.
    	*/
    	public String getPersonMappingDeptName() {
    		return personMappingDeptName;
    	}

    	/**
    	* ���� 考核专员/绩效管理员对应的部门名称.
    	*
    	* @param 考核专员/绩效管理员对应的部门名称.
    	*/
    	public void setPersonMappingDeptName(String personMappingDeptName) {
    		this.personMappingDeptName = personMappingDeptName;
    	}
    	
    	/**
    	* ��ȡ 考核专员/绩效管理员对应的部门标杆编码.
    	*
    	* @return 考核专员/绩效管理员对应的部门标杆编码.
    	*/
    	public String getPersonMappingDeptCode() {
    		return personMappingDeptCode;
    	}

    	/**
    	* ���� 考核专员/绩效管理员对应的部门标杆编码.
    	*
    	* @param 考核专员/绩效管理员对应的部门标杆编码.
    	*/
    	public void setPersonMappingDeptCode(String personMappingDeptCode) {
    		this.personMappingDeptCode = personMappingDeptCode;
    	}
    	
    	/**
    	* ��ȡ 工作流修改时间.
    	*
    	* @return 工作流修改时间.
    	*/
    	public Date getModifyTime() {
    		return modifyTime;
    	}

    	/**
    	* ���� 工作流修改时间.
    	*
    	* @param 工作流修改时间.
    	*/
    	public void setModifyTime(Date modifyTime) {
    		this.modifyTime = modifyTime;
    	}
    	
    	/**
    	* ��ȡ 工作流创建时间.
    	*
    	* @return 工作流创建时间.
    	*/
    	public Date getCreateTime() {
    		return createTime;
    	}

    	/**
    	* ���� 工作流创建时间.
    	*
    	* @param 工作流创建时间.
    	*/
    	public void setCreateTime(Date createTime) {
    		this.createTime = createTime;
    	}
    	
    	/**
    	* ��ȡ 业务状态，1表示逻辑存在，0表示逻辑删除.
    	*
    	* @return 业务状态，1表示逻辑存在，0表示逻辑删除.
    	*/
    	public String getIsseffective() {
    		return isseffective;
    	}

    	/**
    	* ���� 业务状态，1表示逻辑存在，0表示逻辑删除.
    	*
    	* @param 业务状态，1表示逻辑存在，0表示逻辑删除.
    	*/
    	public void setIsseffective(String isseffective) {
    		this.isseffective = isseffective;
    	}
    	
    	/**
    	* ��ȡ 备用字段1.
    	*
    	* @return 备用字段1.
    	*/
    	public Long getSpareField1() {
    		return spareField1;
    	}

    	/**
    	* ���� 备用字段1.
    	*
    	* @param 备用字段1.
    	*/
    	public void setSpareField1(Long spareField1) {
    		this.spareField1 = spareField1;
    	}
    	
    	/**
    	* ��ȡ 备用字段2.
    	*
    	* @return 备用字段2.
    	*/
    	public String getSpareField2() {
    		return spareField2;
    	}

    	/**
    	* ���� 备用字段2.
    	*
    	* @param 备用字段2.
    	*/
    	public void setSpareField2(String spareField2) {
    		this.spareField2 = spareField2;
    	}
    	
    	/**
    	* ��ȡ 备用字段3.
    	*
    	* @return 备用字段3.
    	*/
    	public String getSpareField3() {
    		return spareField3;
    	}

    	/**
    	* ���� 备用字段3.
    	*
    	* @param 备用字段3.
    	*/
    	public void setSpareField3(String spareField3) {
    		this.spareField3 = spareField3;
    	}
    	

    }
