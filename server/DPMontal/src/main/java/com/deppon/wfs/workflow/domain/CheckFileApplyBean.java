package com.deppon.wfs.workflow.domain;


import java.math.BigDecimal;
import java.util.Date;

/**
* @title: CheckFileApplyBean 
* @description：管理文件发布申请
* @author： 高雅哲
* @date： 2014-1-11 下午4:28:01
*/
public class CheckFileApplyBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 流程序号，主键 
	*/
	private String busino;
	
	/** 
	* 流程实例ID 
	*/
	private Long processinstid;
	
	/** 
	* 申请人员工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人ID，EMP表的主键 
	*/
	private BigDecimal empid;

	/** 
	* 文件名称
	*/
	private String fileName;
	/** 
	* 申请类别 
	*/
	private String appType;
	/** 
	* 申请类别编码 
	*/
	private String appTypeCode;
	
	/** 
	* 文件责任部门(申请人所在部门) 
	*/
	private String applydept;
	/** 
	* 文件类别 
	*/
	private String fileCategory;
	/** 
	* 文件类别 编码
	*/
	private String fileCategoryCode;
	/** 
	* 文件页数 
	*/
	private BigDecimal fliePage;
	
	/** 
	* 文件过期日期 
	*/
	private Date fileOverdueDate;
	
	/** 
	* 适用范围 
	*/
	private String usearea;
	/** 
	* 适用范围 编码
	*/
	private String useareaCode;
	
	/** 
	* 原文件名称 
	*/
	private String prevFilename;
	
	/** 
	* 修改次数 
	*/
	private BigDecimal editFileNum;
	
	/** 
	* 文件摘要 
	*/
	private String fileSummary;
	
	/** 
	* 申请事由 
	*/
	private String remarks;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务状态 
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
	* 数字字段（扩展） 
	*/
	private BigDecimal subnumber;
	/** 
	* 审批用：文件编号
	*/
	private String fileCode;
	/** 
	* 审批用：涉及部门
	*/
	private String relatedDepartments;
	/** 
	* 审批用：涉及部门标杆编码
	*/
	private String relatedDepartmentsCode;
	
	/**
	* 获取 流程序号，主键.
	*
	* @return 流程序号，主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 流程序号，主键.
	*
	* @param 流程序号，主键.
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
	* 获取 申请人员工号.
	*
	* @return 申请人员工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 申请人员工号.
	*
	* @param 申请人员工号.
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
	* 获取 申请人ID，EMP表的主键.
	*
	* @return 申请人ID，EMP表的主键.
	*/
	public BigDecimal getEmpid() {
		return empid;
	}

	/**
	* 设置 申请人ID，EMP表的主键.
	*
	* @param 申请人ID，EMP表的主键.
	*/
	public void setEmpid(BigDecimal empid) {
		this.empid = empid;
	}
	
	/**
	* 获取 申请类别.
	*
	* @return 申请类别.
	*/
	public String getAppType() {
		return appType;
	}

	/**
	* 设置 申请类别.
	*
	* @param 申请类别.
	*/
	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	/**
	* 获取 文件责任部门(申请人所在部门).
	*
	* @return 文件责任部门(申请人所在部门).
	*/
	public String getApplydept() {
		return applydept;
	}

	/**
	* 设置 文件责任部门(申请人所在部门).
	*
	* @param 文件责任部门(申请人所在部门).
	*/
	public void setApplydept(String applydept) {
		this.applydept = applydept;
	}
	
	/**
	* 获取 文件类别.
	*
	* @return 文件类别.
	*/
	public String getFileCategory() {
		return fileCategory;
	}

	/**
	* 设置 文件类别.
	*
	* @param 文件类别.
	*/
	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}
	
	/**
	* 获取 文件页数.
	*
	* @return 文件页数.
	*/
	public BigDecimal getFliePage() {
		return fliePage;
	}

	/**
	* 设置 文件页数.
	*
	* @param 文件页数.
	*/
	public void setFliePage(BigDecimal fliePage) {
		this.fliePage = fliePage;
	}
	
	/**
	* 获取 文件过期日期.
	*
	* @return 文件过期日期.
	*/
	public Date getFileOverdueDate() {
		return fileOverdueDate;
	}

	/**
	* 设置 文件过期日期.
	*
	* @param 文件过期日期.
	*/
	public void setFileOverdueDate(Date fileOverdueDate) {
		this.fileOverdueDate = fileOverdueDate;
	}
	
	/**
	* 获取 适用范围.
	*
	* @return 适用范围.
	*/
	public String getUsearea() {
		return usearea;
	}

	/**
	* 设置 适用范围.
	*
	* @param 适用范围.
	*/
	public void setUsearea(String usearea) {
		this.usearea = usearea;
	}
	
	/**
	* 获取 原文件名称.
	*
	* @return 原文件名称.
	*/
	public String getPrevFilename() {
		return prevFilename;
	}

	/**
	* 设置 原文件名称.
	*
	* @param 原文件名称.
	*/
	public void setPrevFilename(String prevFilename) {
		this.prevFilename = prevFilename;
	}
	
	/**
	* 获取 修改次数.
	*
	* @return 修改次数.
	*/
	public BigDecimal getEditFileNum() {
		return editFileNum;
	}

	/**
	* 设置 修改次数.
	*
	* @param 修改次数.
	*/
	public void setEditFileNum(BigDecimal editFileNum) {
		this.editFileNum = editFileNum;
	}
	
	/**
	* 获取 文件摘要.
	*
	* @return 文件摘要.
	*/
	public String getFileSummary() {
		return fileSummary;
	}

	/**
	* 设置 文件摘要.
	*
	* @param 文件摘要.
	*/
	public void setFileSummary(String fileSummary) {
		this.fileSummary = fileSummary;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getRemarks() {
		return remarks;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	* 获取 业务状态.
	*
	* @return 业务状态.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态.
	*
	* @param 业务状态.
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
	* 获取 数字字段（扩展）.
	*
	* @return 数字字段（扩展）.
	*/
	public BigDecimal getSubnumber() {
		return subnumber;
	}

	/**
	* 设置 数字字段（扩展）.
	*
	* @param 数字字段（扩展）.
	*/
	public void setSubnumber(BigDecimal subnumber) {
		this.subnumber = subnumber;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the appTypeCode
	 */
	public String getAppTypeCode() {
		return appTypeCode;
	}

	/**
	 * @param appTypeCode the appTypeCode to set
	 */
	public void setAppTypeCode(String appTypeCode) {
		this.appTypeCode = appTypeCode;
	}

	/**
	 * @return the fileCategoryCode
	 */
	public String getFileCategoryCode() {
		return fileCategoryCode;
	}

	/**
	 * @param fileCategoryCode the fileCategoryCode to set
	 */
	public void setFileCategoryCode(String fileCategoryCode) {
		this.fileCategoryCode = fileCategoryCode;
	}

	/**
	 * @return the useareaCode
	 */
	public String getUseareaCode() {
		return useareaCode;
	}

	/**
	 * @param useareaCode the useareaCode to set
	 */
	public void setUseareaCode(String useareaCode) {
		this.useareaCode = useareaCode;
	}

	/**
	 * @return the fileCode
	 */
	public String getFileCode() {
		return fileCode;
	}

	/**
	 * @param fileCode the fileCode to set
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	/**
	 * @return the relatedDepartments
	 */
	public String getRelatedDepartments() {
		return relatedDepartments;
	}

	/**
	 * @param relatedDepartments the relatedDepartments to set
	 */
	public void setRelatedDepartments(String relatedDepartments) {
		this.relatedDepartments = relatedDepartments;
	}

	/**
	 * @return the relatedDepartmentsCode
	 */
	public String getRelatedDepartmentsCode() {
		return relatedDepartmentsCode;
	}

	/**
	 * @param relatedDepartmentsCode the relatedDepartmentsCode to set
	 */
	public void setRelatedDepartmentsCode(String relatedDepartmentsCode) {
		this.relatedDepartmentsCode = relatedDepartmentsCode;
	}
	public CheckFileApplyBean(){}

}
