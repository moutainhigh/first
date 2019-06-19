package com.deppon.wfs.workflow.domain;


import java.util.Date;


/**
* 资金运作实体
* @title: RunFinanceBean 
* @author： lihai
* @date： 2014-5-29 上午08:31:37
 */
public class RunFinanceBean extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String busino;
	
	/** 
	* 流程实例ID 
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
	* 所属部门 
	*/
	private String deptName;
	
	/** 
	* 申请人职位
	*/
	private String jobName;
	
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
	private String isseffective;
	
	/** 
	* 备注1 
	*/
	private Long sparefield1;
	
	/** 
	* 备注2 
	*/
	private String sparefield2;
	
	/** 
	* 备注3 
	*/
	private String sparefield3;

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the processinstid
	 */
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}

	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}

	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the isseffective
	 */
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * @param isseffective the isseffective to set
	 */
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}

	/**
	 * @return the sparefield1
	 */
	public Long getSparefield1() {
		return sparefield1;
	}

	/**
	 * @param sparefield1 the sparefield1 to set
	 */
	public void setSparefield1(Long sparefield1) {
		this.sparefield1 = sparefield1;
	}

	/**
	 * @return the sparefield2
	 */
	public String getSparefield2() {
		return sparefield2;
	}

	/**
	 * @param sparefield2 the sparefield2 to set
	 */
	public void setSparefield2(String sparefield2) {
		this.sparefield2 = sparefield2;
	}

	/**
	 * @return the sparefield3
	 */
	public String getSparefield3() {
		return sparefield3;
	}

	/**
	 * @param sparefield3 the sparefield3 to set
	 */
	public void setSparefield3(String sparefield3) {
		this.sparefield3 = sparefield3;
	}
	
	
	
}
