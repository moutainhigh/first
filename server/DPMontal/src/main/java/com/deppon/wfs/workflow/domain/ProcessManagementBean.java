package com.deppon.wfs.workflow.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * 流程管理工作流实体bean.
 *
 * @author guanbo
 * @Date 2014-01-19 11:54:38
 */
 
public class ProcessManagementBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 业务表主键. */
	private String busino;
	
	/** 流程实例号. */
	private Long processinstid;
	
	/** 申请人姓名，与老表的APPLYNAME对应. */
	private String applyPersonName;
	
	/** 申请人部门，与老表的APPLYDEPTNAME对应. */
	private String applydeptname;
	
	/** 申请人工号，与老表的APPLYUSERID对应. */
	private String applyPersonId;
	
	/** 流程名称，与老表的APPLYPROCESSNAME字段对应. */
	private String applyProcessName;
	
	/** 版本号，与老表的VERSIONNO对应. */
	private String versionno;
	
	/** 申请类型，与老表的APPLYTYPE对应. */
	private String applyType;
	
	/** 申请原因，与老表的APPLYREASON对应. */
	private String applyReason;
	
	/** 业务数据修改时间. */
	private Date modifyTime;
	
	/** 业务数据创建时间. */
	private Date createTime;
	
	/** 业务数据使用状态，1代表使用，0代表逻辑删除. */
	private String isseffective;
	
	/** 备用字段. */
	private Long spareField1;
	
	/** 备用字段. */
	private String spareField2;
	
	/** 备用字段. */
	private String spareField3;
	
	/** 清单级别. */
	private String billLevel;
	
	/** 清单类型. */
	private String billType;
	
	/** 入基线类型. */
	private String baselineType;
	
	/** 所属支撑组. */
	private String supportGroup;
	
	/** 是否流程优化. */
	private String processImprove;
	
	/** 是否涉及流程目标或绩效变更. */
	private String processGoalSalchange;
	
	/** 流程是否为三级以下. */
	private String under3level;
	
	/** 审批页面：清单类型——清单变更流向审批过程中添加的. */
	private String approvalBillType;
	
	/** 审批页面：流程入基线类型——流程入基线流向审批过程中添加的. */
	private String approvalInBaseLine;
	
	/** 审批页面：原文档名称——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalOriginalDOCName;
	
	/** 审批页面：原所属类别名称——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalOriginalTypeName;
	
	/** 审批页面：原所属类别id——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalOriginalTypeId;
	
	/** 审批页面：原发布部门名称——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalOriginalDeptName;
	
	/** 审批页面：原发布部门标杆编码——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalOriginalDeptCode;
	
	/** 审批页面：现文档名称——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalNowDOCName;
	
	/** 审批页面：现所属类别名称——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalNowTypeName;
	
	/** 审批页面：现所属类别id——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalNowTypeId;
	
	/** 审批页面：现发布部门名称——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalNowDeptName;
	
	/** 审批页面：现发布部门标杆编码——清单变更/流程入基线流向审批过程中添加的. */
	private String approvalNowDeptCode;
	
	/** 审批页面：是否需要评审——流程入基线流向审批过程中添加的. */
	private String approvalIsReview;
	
	/** 审批页面：涉及业务部门名称——流程入基线流向审批过程中添加的. */
	private String approvalRelateBusinessDeptName;
	
	/** 审批页面：涉及业务部门标杆编码——流程入基线流向审批过程中添加的. */
	private String approvalRelateBusinessDeptCode;
	
	/** 审批页面：涉及资源类型——流程入基线流向审批过程中添加的. */
	private String approvalRelateResourceType;
	
	/** 审批页面：所属系统分析组名称——流程入基线流向审批过程中添加的. */
	private String approvalBelongAnalysisGroupName;
	
	/** 审批页面：所属系统分析组标杆编码——清单变更/流程如基线流向审批过程中添加的. */
	private String approvalBelongAnalysisGroupCode;
	
	/** 审批页面：栏目名称——流程发布流向审批过程中添加的. */
	private String approvalColumnName;
	
	/** 审批页面：发布人——流程发布流向审批过程中添加的. */
	private String approvalPublisher;
	
	/** 审批页面：标题——流程发布流向审批过程中添加的. */
	private String approvalTitle;
	
	/** 审批页面：公告范围——流程发布流向审批过程中添加的. */
	private String approvalNoticeScope;
	
	/** 审批页面：流程发布最后一个节点，记录下审批人姓名，只为给接口传递参数，不存数据库中. */
	private String userNameParam;
	/**
	* 获取 业务表主键.
	*
	* @return 业务表主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	 * 设置 业务表主键.
	 *
	 * @param busino the new busino
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
	 * @param processinstid the new processinstid
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人姓名，与老表的APPLYNAME对应.
	*
	* @return 申请人姓名，与老表的APPLYNAME对应.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * 设置 申请人姓名，与老表的APPLYNAME对应.
	 *
	 * @param applyPersonName the new apply person name
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 申请人部门，与老表的APPLYDEPTNAME对应.
	*
	* @return 申请人部门，与老表的APPLYDEPTNAME对应.
	*/
	public String getApplydeptname() {
		return applydeptname;
	}

	/**
	 * 设置 申请人部门，与老表的APPLYDEPTNAME对应.
	 *
	 * @param applydeptname the new applydeptname
	 */
	public void setApplydeptname(String applydeptname) {
		this.applydeptname = applydeptname;
	}
	
	/**
	* 获取 申请人工号，与老表的APPLYUSERID对应.
	*
	* @return 申请人工号，与老表的APPLYUSERID对应.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * 设置 申请人工号，与老表的APPLYUSERID对应.
	 *
	 * @param applyPersonId the new apply person id
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 流程名称，与老表的APPLYPROCESSNAME字段对应.
	*
	* @return 流程名称，与老表的APPLYPROCESSNAME字段对应.
	*/
	public String getApplyProcessName() {
		return applyProcessName;
	}

	/**
	 * 设置 流程名称，与老表的APPLYPROCESSNAME字段对应.
	 *
	 * @param applyProcessName the new apply process name
	 */
	public void setApplyProcessName(String applyProcessName) {
		this.applyProcessName = applyProcessName;
	}
	
	/**
	* 获取 版本号，与老表的VERSIONNO对应.
	*
	* @return 版本号，与老表的VERSIONNO对应.
	*/
	public String getVersionno() {
		return versionno;
	}

	/**
	 * 设置 版本号，与老表的VERSIONNO对应.
	 *
	 * @param versionno the new versionno
	 */
	public void setVersionno(String versionno) {
		this.versionno = versionno;
	}
	
	/**
	* 获取 申请类型，与老表的APPLYTYPE对应.
	*
	* @return 申请类型，与老表的APPLYTYPE对应.
	*/
	public String getApplyType() {
		return applyType;
	}

	/**
	 * 设置 申请类型，与老表的APPLYTYPE对应.
	 *
	 * @param applyType the new apply type
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	/**
	* 获取 申请原因，与老表的APPLYREASON对应.
	*
	* @return 申请原因，与老表的APPLYREASON对应.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 设置 申请原因，与老表的APPLYREASON对应.
	 *
	 * @param applyReason the new apply reason
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* 获取 业务数据修改时间.
	*
	* @return 业务数据修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置 业务数据修改时间.
	 *
	 * @param modifyTime the new modify time
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
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务数据使用状态，1代表使用，0代表逻辑删除.
	*
	* @return 业务数据使用状态，1代表使用，0代表逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * 设置 业务数据使用状态，1代表使用，0代表逻辑删除.
	 *
	 * @param isseffective the new isseffective
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
	 * @param spareField1 the new spare field1
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
	 * @param spareField2 the new spare field2
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
	 * @param spareField3 the new spare field3
	 */
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	
	/**
	* 获取 清单级别.
	*
	* @return 清单级别.
	*/
	public String getBillLevel() {
		return billLevel;
	}

	/**
	 * 设置 清单级别.
	 *
	 * @param billLevel the new bill level
	 */
	public void setBillLevel(String billLevel) {
		this.billLevel = billLevel;
	}
	
	/**
	* 获取 清单类型.
	*
	* @return 清单类型.
	*/
	public String getBillType() {
		return billType;
	}

	/**
	 * 设置 清单类型.
	 *
	 * @param billType the new bill type
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}
	
	/**
	* 获取 入基线类型.
	*
	* @return 入基线类型.
	*/
	public String getBaselineType() {
		return baselineType;
	}

	/**
	 * 设置 入基线类型.
	 *
	 * @param baselineType the new baseline type
	 */
	public void setBaselineType(String baselineType) {
		this.baselineType = baselineType;
	}
	
	/**
	* 获取 所属支撑组.
	*
	* @return 所属支撑组.
	*/
	public String getSupportGroup() {
		return supportGroup;
	}

	/**
	 * 设置 所属支撑组.
	 *
	 * @param supportGroup the new support group
	 */
	public void setSupportGroup(String supportGroup) {
		this.supportGroup = supportGroup;
	}
	
	/**
	* 获取 是否流程优化.
	*
	* @return 是否流程优化.
	*/
	public String getProcessImprove() {
		return processImprove;
	}

	/**
	 * 设置 是否流程优化.
	 *
	 * @param processImprove the new process improve
	 */
	public void setProcessImprove(String processImprove) {
		this.processImprove = processImprove;
	}
	
	/**
	* 获取 是否涉及流程目标或绩效变更.
	*
	* @return 是否涉及流程目标或绩效变更.
	*/
	public String getProcessGoalSalchange() {
		return processGoalSalchange;
	}

	/**
	 * 设置 是否涉及流程目标或绩效变更.
	 *
	 * @param processGoalSalchange the new process goal salchange
	 */
	public void setProcessGoalSalchange(String processGoalSalchange) {
		this.processGoalSalchange = processGoalSalchange;
	}
	
	/**
	* 获取 流程是否为三级以下.
	*
	* @return 流程是否为三级以下.
	*/
	public String getUnder3level() {
		return under3level;
	}

	/**
	 * 设置 流程是否为三级以下.
	 *
	 * @param under3level the new under3level
	 */
	public void setUnder3level(String under3level) {
		this.under3level = under3level;
	}

	/**
	 * Gets the approval bill type.
	 *
	 * @return the approval bill type
	 */
	public String getApprovalBillType() {
		return approvalBillType;
	}

	/**
	 * Sets the approval bill type.
	 *
	 * @param approvalBillType the new approval bill type
	 */
	public void setApprovalBillType(String approvalBillType) {
		this.approvalBillType = approvalBillType;
	}

	/**
	 * Gets the approval in base line.
	 *
	 * @return the approval in base line
	 */
	public String getApprovalInBaseLine() {
		return approvalInBaseLine;
	}

	/**
	 * Sets the approval in base line.
	 *
	 * @param approvalInBaseLine the new approval in base line
	 */
	public void setApprovalInBaseLine(String approvalInBaseLine) {
		this.approvalInBaseLine = approvalInBaseLine;
	}

	/**
	 * Gets the approval original doc name.
	 *
	 * @return the approval original doc name
	 */
	public String getApprovalOriginalDOCName() {
		return approvalOriginalDOCName;
	}

	/**
	 * Sets the approval original doc name.
	 *
	 * @param approvalOriginalDOCName the new approval original doc name
	 */
	public void setApprovalOriginalDOCName(String approvalOriginalDOCName) {
		this.approvalOriginalDOCName = approvalOriginalDOCName;
	}

	/**
	 * Gets the approval original type name.
	 *
	 * @return the approval original type name
	 */
	public String getApprovalOriginalTypeName() {
		return approvalOriginalTypeName;
	}

	/**
	 * Sets the approval original type name.
	 *
	 * @param approvalOriginalTypeName the new approval original type name
	 */
	public void setApprovalOriginalTypeName(String approvalOriginalTypeName) {
		this.approvalOriginalTypeName = approvalOriginalTypeName;
	}

	/**
	 * Gets the approval original type id.
	 *
	 * @return the approval original type id
	 */
	public String getApprovalOriginalTypeId() {
		return approvalOriginalTypeId;
	}

	/**
	 * Sets the approval original type id.
	 *
	 * @param approvalOriginalTypeId the new approval original type id
	 */
	public void setApprovalOriginalTypeId(String approvalOriginalTypeId) {
		this.approvalOriginalTypeId = approvalOriginalTypeId;
	}

	/**
	 * Gets the approval original dept name.
	 *
	 * @return the approval original dept name
	 */
	public String getApprovalOriginalDeptName() {
		return approvalOriginalDeptName;
	}

	/**
	 * Sets the approval original dept name.
	 *
	 * @param approvalOriginalDeptName the new approval original dept name
	 */
	public void setApprovalOriginalDeptName(String approvalOriginalDeptName) {
		this.approvalOriginalDeptName = approvalOriginalDeptName;
	}

	/**
	 * Gets the approval original dept code.
	 *
	 * @return the approval original dept code
	 */
	public String getApprovalOriginalDeptCode() {
		return approvalOriginalDeptCode;
	}

	/**
	 * Sets the approval original dept code.
	 *
	 * @param approvalOriginalDeptCode the new approval original dept code
	 */
	public void setApprovalOriginalDeptCode(String approvalOriginalDeptCode) {
		this.approvalOriginalDeptCode = approvalOriginalDeptCode;
	}

	/**
	 * Gets the approval now doc name.
	 *
	 * @return the approval now doc name
	 */
	public String getApprovalNowDOCName() {
		return approvalNowDOCName;
	}

	/**
	 * Sets the approval now doc name.
	 *
	 * @param approvalNowDOCName the new approval now doc name
	 */
	public void setApprovalNowDOCName(String approvalNowDOCName) {
		this.approvalNowDOCName = approvalNowDOCName;
	}

	/**
	 * Gets the approval now type name.
	 *
	 * @return the approval now type name
	 */
	public String getApprovalNowTypeName() {
		return approvalNowTypeName;
	}

	/**
	 * Sets the approval now type name.
	 *
	 * @param approvalNowTypeName the new approval now type name
	 */
	public void setApprovalNowTypeName(String approvalNowTypeName) {
		this.approvalNowTypeName = approvalNowTypeName;
	}

	/**
	 * Gets the approval now type id.
	 *
	 * @return the approval now type id
	 */
	public String getApprovalNowTypeId() {
		return approvalNowTypeId;
	}

	/**
	 * Sets the approval now type id.
	 *
	 * @param approvalNowTypeId the new approval now type id
	 */
	public void setApprovalNowTypeId(String approvalNowTypeId) {
		this.approvalNowTypeId = approvalNowTypeId;
	}

	/**
	 * Gets the approval now dept name.
	 *
	 * @return the approval now dept name
	 */
	public String getApprovalNowDeptName() {
		return approvalNowDeptName;
	}

	/**
	 * Sets the approval now dept name.
	 *
	 * @param approvalNowDeptName the new approval now dept name
	 */
	public void setApprovalNowDeptName(String approvalNowDeptName) {
		this.approvalNowDeptName = approvalNowDeptName;
	}

	/**
	 * Gets the approval now dept code.
	 *
	 * @return the approval now dept code
	 */
	public String getApprovalNowDeptCode() {
		return approvalNowDeptCode;
	}

	/**
	 * Sets the approval now dept code.
	 *
	 * @param approvalNowDeptCode the new approval now dept code
	 */
	public void setApprovalNowDeptCode(String approvalNowDeptCode) {
		this.approvalNowDeptCode = approvalNowDeptCode;
	}

	/**
	 * Gets the approval is review.
	 *
	 * @return the approval is review
	 */
	public String getApprovalIsReview() {
		return approvalIsReview;
	}

	/**
	 * Sets the approval is review.
	 *
	 * @param approvalIsReview the new approval is review
	 */
	public void setApprovalIsReview(String approvalIsReview) {
		this.approvalIsReview = approvalIsReview;
	}

	/**
	 * Gets the approval relate business dept name.
	 *
	 * @return the approval relate business dept name
	 */
	public String getApprovalRelateBusinessDeptName() {
		return approvalRelateBusinessDeptName;
	}

	/**
	 * Sets the approval relate business dept name.
	 *
	 * @param approvalRelateBusinessDeptName the new approval relate business dept name
	 */
	public void setApprovalRelateBusinessDeptName(
			String approvalRelateBusinessDeptName) {
		this.approvalRelateBusinessDeptName = approvalRelateBusinessDeptName;
	}

	/**
	 * Gets the approval relate business dept code.
	 *
	 * @return the approval relate business dept code
	 */
	public String getApprovalRelateBusinessDeptCode() {
		return approvalRelateBusinessDeptCode;
	}

	/**
	 * Sets the approval relate business dept code.
	 *
	 * @param approvalRelateBusinessDeptCode the new approval relate business dept code
	 */
	public void setApprovalRelateBusinessDeptCode(
			String approvalRelateBusinessDeptCode) {
		this.approvalRelateBusinessDeptCode = approvalRelateBusinessDeptCode;
	}

	/**
	 * Gets the approval relate resource type.
	 *
	 * @return the approval relate resource type
	 */
	public String getApprovalRelateResourceType() {
		return approvalRelateResourceType;
	}

	/**
	 * Sets the approval relate resource type.
	 *
	 * @param approvalRelateResourceType the new approval relate resource type
	 */
	public void setApprovalRelateResourceType(String approvalRelateResourceType) {
		this.approvalRelateResourceType = approvalRelateResourceType;
	}

	/**
	 * Gets the approval belong analysis group name.
	 *
	 * @return the approval belong analysis group name
	 */
	public String getApprovalBelongAnalysisGroupName() {
		return approvalBelongAnalysisGroupName;
	}

	/**
	 * Sets the approval belong analysis group name.
	 *
	 * @param approvalBelongAnalysisGroupName the new approval belong analysis group name
	 */
	public void setApprovalBelongAnalysisGroupName(
			String approvalBelongAnalysisGroupName) {
		this.approvalBelongAnalysisGroupName = approvalBelongAnalysisGroupName;
	}

	/**
	 * Gets the approval belong analysis group code.
	 *
	 * @return the approval belong analysis group code
	 */
	public String getApprovalBelongAnalysisGroupCode() {
		return approvalBelongAnalysisGroupCode;
	}

	/**
	 * Sets the approval belong analysis group code.
	 *
	 * @param approvalBelongAnalysisGroupCode the new approval belong analysis group code
	 */
	public void setApprovalBelongAnalysisGroupCode(
			String approvalBelongAnalysisGroupCode) {
		this.approvalBelongAnalysisGroupCode = approvalBelongAnalysisGroupCode;
	}

	/**
	 * Gets the approval column name.
	 *
	 * @return the approval column name
	 */
	public String getApprovalColumnName() {
		return approvalColumnName;
	}

	/**
	 * Sets the approval column name.
	 *
	 * @param approvalColumnName the new approval column name
	 */
	public void setApprovalColumnName(String approvalColumnName) {
		this.approvalColumnName = approvalColumnName;
	}

	/**
	 * Gets the approval publisher.
	 *
	 * @return the approval publisher
	 */
	public String getApprovalPublisher() {
		return approvalPublisher;
	}

	/**
	 * Sets the approval publisher.
	 *
	 * @param approvalPublisher the new approval publisher
	 */
	public void setApprovalPublisher(String approvalPublisher) {
		this.approvalPublisher = approvalPublisher;
	}

	/**
	 * Gets the approval title.
	 *
	 * @return the approval title
	 */
	public String getApprovalTitle() {
		return approvalTitle;
	}

	/**
	 * Sets the approval title.
	 *
	 * @param approvalTitle the new approval title
	 */
	public void setApprovalTitle(String approvalTitle) {
		this.approvalTitle = approvalTitle;
	}

	/**
	 * Gets the approval notice scope.
	 *
	 * @return the approval notice scope
	 */
	public String getApprovalNoticeScope() {
		return approvalNoticeScope;
	}

	/**
	 * Sets the approval notice scope.
	 *
	 * @param approvalNoticeScope the new approval notice scope
	 */
	public void setApprovalNoticeScope(String approvalNoticeScope) {
		this.approvalNoticeScope = approvalNoticeScope;
	}

	/**
	 * Gets the user name param.
	 *
	 * @return the user name param
	 */
	public String getUserNameParam() {
		return userNameParam;
	}

	/**
	 * Sets the user name param.
	 *
	 * @param userNameParam the new user name param
	 */
	public void setUserNameParam(String userNameParam) {
		this.userNameParam = userNameParam;
	}
}
