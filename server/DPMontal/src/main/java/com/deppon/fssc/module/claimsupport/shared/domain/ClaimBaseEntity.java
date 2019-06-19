package com.deppon.fssc.module.claimsupport.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.fssc.module.claim.daily.shared.domain.DailyLineEntity;

/**
 *<pre>
 *功能:报账单表头公共Entity
 *作者：刘崇丛
 *日期：2013-3-25上午9:30:10
 *修改zlz 添加字段 20141227
 *</pre>
 */
public class ClaimBaseEntity extends BaseEntity implements Serializable{
	//序列化
	private static final long serialVersionUID = -3975995025722964342L;
	//缺失未核销金额、付款日期，发票抬头不知存的编码还是名称
	/**
	 * 单据ID
	 */
	private String claimId;
	/**
	 * 单据编号
	 */
	private String claimNo;
	/**
	 * 起草时间
	 */
	private Date draftTime;
	/**
	 * 申请日期
	 */
	private Date applyDate;
	/**
	 * 申请人工号
	 */
	private String applyEmpCode;
	/**
	 * 申请人名称
	 */
	private String applyEmpName;
	/**
	 * 申请人所在部门标杆编码
	 */
	private String applyDeptStandcode;
	/**
	 * 申请人所在部门名称
	 */
	private String applyDeptName;
	/**
	 * 申请人所在公司编码
	 */
	private String applyCompCode;
	/**
	 * 申请人所在公司名称
	 */
	private String applyCompName;
	/**
	 * 报账单模板编码
	 */
	private String tpNo;
	/**
	 * 报账单模板名称
	 */
	private String tpName;
	/**
	 * 业务大类编码
	 * 工作流名称
	 */
	private String mcNo;
	/**
	 * 业务大类名称
	 * 工作流名称
	 */
	private String mcName;
	/**
	 * 发票抬头
	 */
	private String invoiceTitle;
	/**
	 * 做账公司编码(发票抬头编码)
	 */
	private String invoiceTitleCode;
	/**
	 * 发票抬头是否独立核算
	 */
	private String isIndAcc;
		
	/**
	 * 收款方名称
	 */
	private String accountName;
	/**
	 * 账户性质
	 */
	private String accountNature;
	/**
	 * 账户性质
	 */
	private String accountNatureCode;
	/**
	 * 账户类型
	 */
	private String accountType;
	/**
	 * 收款方账号
	 */
	private String account;	
	/**
	 * 开户行省份编码
	 */
	private String bankProvinceId;	
	/**
	 * 开户行省份名称
	 */
	private String bankProvinceName;	
	/**
	 * 开户行城市编码
	 */
	private String bankCityId;	
	/**
	 * 开户行城市名称
	 */
	private String bankCityName;	
	/**
	 * 开户银行编码
	 */
	private String bankId;	
	/**
	 * 开户银行
	 */
	private String bankName;	
	/**
	 * 开户支行编码
	 */
	private String subbankId;	
	/**
	 * 开户支行名称
	 */
	private String subbankName;	
	/**
	 * 国际银行代码
	 */
	private String itnBankCode;
	/**
	 * 报账总金额
	 */
	private BigDecimal applyAmount;	
	/**
	 * 本位币报账金额
	 */
	private BigDecimal applyAmountStd;	
	/**
	 * 核定金额
	 */
	private BigDecimal ratifyAmount;	
	/**
	 * 核定本位币金额
	 */
	private BigDecimal ratifyAmountStd;	
	/**
	 * 付款金额
	 */
	private BigDecimal payAmount;	
	/**
	 * 本位币付款金额
	 */
	private BigDecimal payAmountStd;	
	/**
	 * 付款金额大写
	 */
	private String payAmountCn;	
	/**
	 * 最迟汇款日期
	 */
	private Date latestRemitDate;	
	/**
	 * 联系方式
	 */
	private String contactInfo;	
	/**
	 * 币种编码
	 */
	private String currencyCode;
	/**
	 * 币种
	 */
	private String currency;
	/**
	 * 汇率
	 */
	private BigDecimal exchangeRate;
	/**
	 * 支付方式编码
	 */
	private String payTypeCode;
	/**
	 * 支付方式
	 */
	private String payType;
	/**
	 * 粘贴单张数
	 */
	private Integer attachCount;
	/**
	 * 费用说明
	 */
	private String costExplain;
	/**
	 * 事前申请单号
	 */
	private String priorClaimNo;
	/**
	 * 项目类型编码
	 */
	private String projectTypeCode;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 项目名称编码
	 */
	private String projectNameCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 业务类型编码
	 */
	private String bizTypeCode;
	/**
	 * 业务类型
	 */
	private String bizType;
	/**
	 * 业务名称编码
	 */
	private String bizNameCode;
	/**
	 * 业务名称
	 */
	private String bizName;
	/**
	 * 报账单来源
	 */
	private String origin;
	/**
	 * 预提类型编码
	 */
	private String accruedTypeCode;
	/**
	 * 预提类型
	 */
	private String accruedType;
	/**
	 * 费用所属月份
	 */
	private String costMonth;
	/**
	 * 已核销金额
	 */
	private BigDecimal alreadyWritedAmount;
	/**
	 * 核销中金额
	 */
	private BigDecimal writingAmount;
	/**
	 * 付款部门标杆编码
	 */
	private String payDeptStandcode;
	/**
	 * 付款部门名称
	 */
	private String payDeptName;
	/**
	 * 是否借款
	 */
	private String isLoan;
	/**
	 * 部门性质
	 */
	private String deptNature;
	/**
	 * 预计金额
	 */
	private BigDecimal planAmount;
	/**
	 * 预计本位币金额
	 */
	private BigDecimal planAmountStd;
	/**
	 * 是否自动冲借支
	 */
	private String isAutoWrited;
	/**
	 * 业务数据唯一标识
	 */
	private String bizDataUuid;
	/**
	 * 状态编码
	 */
	private String stateCode;
	/**
	 * 状态描述
	 */
	private String state;
	/**
	 * 流程状态编码
	 */
	private String procStateCode;
	/**
	 * 流程状态
	 */
	private String procState;
	/**
	 * 审批状态编码
	 */
	private String auditStateCode;
	/**
	 * 审批状态
	 */
	private String auditState;
	/**
	 * 凭证状态编码
	 */
	private String voucherStateCode;
	/**
	 * 凭证状态
	 */
	private String voucherState;
	/**
	 * 付款状态编码
	 */
	private String payStateCode;
	/**
	 * 付款状态
	 */
	private String payState;
	/**
	 * 凭证编码
	 */
	private String voucherCode;
	/**
	 * 凭证生成日期
	 */
	private Date voucherCreateDate;
	/**
	 * 付款日期
	 */
	private Date payDate;
	/**
	 * 影像文件编号
	 */
	private String imgFileNum;
	/**
	 * 影像状态
	 */
	private String imgState;
	/**
	 * 影像文件数量
	 */
	private Integer imgFileCount;
	/**
	 * 影像最后修改人
	 */
	private String imgModifyUser;
	/**
	 * 是否包含特殊附件
	 */
	private String isInclSpecAtt;
	/**
	 * 特殊附件页码
	 */
	private String specAttPage;
	/**
	 * 影像调阅地址
	 */
	private String imgAccessUrl;
	/**
	 * 审核会计已修改
	 */
	private String accountModify;
	/**
	 * 预算状态
	 */
	private String budgetState;
	/**
	 * 预算主表ID
	 */
	private String budgetId;
	/**
	 * 记账日期
	 */
	private Date tallyDate;
	/**
	 * 所属财务部编码
	 */
	private String financialDeptCode;
	/**
	 * 所属财务部
	 */
	private String financialDept;
	/**
	 * 财务部岗位编码
	 */
	private String finPostCode;
	/**
	 * 财务部岗位名称
	 */
	private String finPostName;
	/**
	 * 所属事业部编码
	 */
	private String businessDeptCode;
	/**
	 * 所属事业部
	 */
	private String businessDept;
	/**
	 * 薪酬组编码
	 */
	private String salaryGroupCode;
	/**
	 * 薪酬组名称
	 */
	private String salaryGroupName;
	/**
	 * 客户编码
	 */
	private String clientCode;
	/**
	 * 客户名称
	 */
	private String clientName;
	/**
	 * 所属车队编码
	 */
	private String motorcadeCode;
	/**
	 * 所属车队
	 */
	private String motorcade;
	/**
	 * 是否超预计金额
	 */
	private String isExceedPlan;
	/**
	 * 退票状态
	 */
	private String refundState;
	/**
	 * 是否被撤销
	 */
	private String isRepeal;
	/**
	 * 会计员工工号
	 */
	private String crewEmpcode;
	/**
	 * 会计小组编码
	 */
	private String groupCode;
	/**
	 * 成本中心编码
	 */
	private String costCenterNo;
	/**
	 * 成本中心名称
	 */
	private String costCenterName;
	/**
	 * 成本中心属性ID
	 */
	private String costCenterProid;
	/**
	 * 原始单据工作流编码
	 */
	private String origMcNo;
	/**
	 * 原始单据工作流名称
	 */
	private String origMcName;
	/**
	 * 原始单据claimID,因需求有变，改为保存原始单据报账单号
	 */
	private String origClaimId;
	/**
	 * 原账户性质
	 */
	private String origAccountNature;
	/**
	 * 撤销事由
	 */
	private String repealReason;
	/**
	 * 是否超过3000行
	 */
	private String isThousand;
	/**
	 * 流程结束时间
	 */
	private Date processEndTime;
	/**
	 * 流程实例ID
	 */
	private Long wfInstanceId;
	/**
	 * 流程环节实例ID
	 */
	private String wfStateInstanceId;
	/**
	 * 流程环节名称
	 */
	private String wfState;
	/**
	 * 流程环节中文名称
	 */
	private String wfStateCn;
	/**
	 * 流程上一环节名称
	 */
	private String wfPrevState;
	/**
	 * 流程上一环节中文名称
	 */
	private String wfPrevStateCn;
	/**
	 * 流程当前工作项ID
	 */
	private String wfWorkitemId;
	/**
	 * 流程当前处理人工号
	 */
	private String wfCurActorEmpcode;
	/**
	 * 流程当前处理人名称
	 */
	private String wfCurActorName;
	/**
	 * 流程当前人接收时间
	 */
	private Date wfCurReceiveDate;
	/**
	 * 是否冲借支完毕
	 */
	private String isWriteOver;
	private String versionNumber;
	/**
	 * 
	 * 关联单号
	 */
	private String refundClaimMo;
	
	/**
	 * 是否承兑： Y-已承兑   | N(null)未承兑(包括不需要承兑)
	 */
	private String isHonour;
	
	/**
	 * 红冲凭证编号
	 */
	private String redPunchVoucherNo;
	
	/**
	 * 收款方做账公司名称
	 */
	private String receiverCompanyName;
	/**
	 * 收款方做账公司编码
	 */
	private String receiverCompanyCode;
	
	/**
	 * 导入eas标记：0未导入 | 1正在导入
	 */
	private String importFlag;
	
	//是否经过审核会计审核
	private String isAfterAccount;
	/**
	 * 是否为新增单据
	 */
	private String isAdded;
	
	/**
	 * 是否需要总裁审批      4.15
	 */
	private String ispresident;

	public String getIspresident() {
		return ispresident;
	}
	public void setIspresident(String ispresident) {
		this.ispresident = ispresident;
	}
	
	/**
	 * 是否生成损益凭证，Y：是，N：否
	 */
	private String isCredit;
	
	/**
	 *    招聘岗位类别 jobType       
	 */
	private String jobType;
	/**
	 * 主招岗位 mainJobs
	 */
	private String mainJobs;
	
	/**
	 *    招聘岗位类别 jobType       
	 */
	private String jobTypeName;
	/**
	 * 主招岗位 mainJobs
	 */
	private String mainJobsName;
	
	/**
	 * 报销主体
	 */
	private String mainBody;
	/**
	 * 报销主体名称
	 */
	private String mainBodyName;
	/**
	 * 所属事业部
	 */
	private String belongGroup;
	/**
	 * 所属事业部编码
	 */
	private String belongGroupCode;
	
	/**
	 * zlz ....新加------------------------
	 */
	/**
	 * 是否正常类税金
	 */
	private String isNormalTax;
	/**
	 * 是否加急
	 */
	private String urgent;
	/**
	 * 加急时间
	 */
	private String urgentTime;
	/**
	 * zlz ....新加------------------------
	 */
	
	
	private DailyLineEntity dailyDateEntity;
	/**
	 * 费用类型   
	 * zlz添加注释： scName为多出字段，陈道兵解释不用删除
	 */
	private String scName;
	
	   /**
     * 报销时效是否超时
     */
    private String expenseIsOvertime;
    
    /**
     * 差错编号
     */
    private String mistakeCode;
    
	/**  
	 * 获取isAdded  
	 * @return isAdded isAdded  
	 */
	public String getIsAdded() {
		return isAdded;
	}
	/**  
	 * 设置isAdded  
	 * @param isAdded isAdded  
	 */
	public void setIsAdded(String isAdded) {
		this.isAdded = isAdded;
	}
	/**
	 * 获取单据ID
	 * @return claimId 单据ID
	 */
	public String getClaimId() {
		return claimId;
	}
	/**
	 * 设置单据ID
	 * @param claimId 单据ID
	 */
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	/**
	 * 获取单据编号
	 * @return claimNo 单据编号
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 设置单据编号
	 * @param claimNo 单据编号
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * 获取起草时间
	 * @return draftTime 起草时间
	 */
	public Date getDraftTime() {
		return draftTime;
	}
	/**
	 * 设置起草时间
	 * @param draftTime 起草时间
	 */
	public void setDraftTime(Date draftTime) {
		this.draftTime = draftTime;
	}
	/**
	 * 获取申请日期
	 * @return applyDate 申请日期
	 */
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * 设置申请日期
	 * @param applyDate 申请日期
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 获取申请人工号
	 * @return applyEmpCode 申请人工号
	 */
	public String getApplyEmpCode() {
		return applyEmpCode;
	}
	/**
	 * 设置申请人工号
	 * @param applyEmpCode 申请人工号
	 */
	public void setApplyEmpCode(String applyEmpCode) {
		this.applyEmpCode = applyEmpCode;
	}
	/**
	 * 获取申请人名称
	 * @return applyEmpName 申请人名称
	 */
	public String getApplyEmpName() {
		return applyEmpName;
	}
	/**
	 * 设置申请人名称
	 * @param applyEmpName 申请人名称
	 */
	public void setApplyEmpName(String applyEmpName) {
		this.applyEmpName = applyEmpName;
	}
	/**
	 * 获取申请人所在部门标杆编码
	 * @return applyDeptStandcode 申请人所在部门标杆编码
	 */
	public String getApplyDeptStandcode() {
		return applyDeptStandcode;
	}
	/**
	 * 设置申请人所在部门标杆编码
	 * @param applyDeptStandcode 申请人所在部门标杆编码
	 */
	public void setApplyDeptStandcode(String applyDeptStandcode) {
		this.applyDeptStandcode = applyDeptStandcode;
	}
	/**
	 * 获取申请人所在部门名称
	 * @return applyDeptName 申请人所在部门名称
	 */
	public String getApplyDeptName() {
		return applyDeptName;
	}
	/**
	 * 设置申请人所在部门名称
	 * @param applyDeptName 申请人所在部门名称
	 */
	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}
	/**
	 * 获取申请人所在公司编码
	 * @return applyCompCode 申请人所在公司编码
	 */
	public String getApplyCompCode() {
		return applyCompCode;
	}
	/**
	 * 设置申请人所在公司编码
	 * @param applyCompCode 申请人所在公司编码
	 */
	public void setApplyCompCode(String applyCompCode) {
		this.applyCompCode = applyCompCode;
	}
	/**
	 * 获取申请人所在公司名称
	 * @return applyCompName 申请人所在公司名称
	 */
	public String getApplyCompName() {
		return applyCompName;
	}
	/**
	 * 设置申请人所在公司名称
	 * @param applyCompName 申请人所在公司名称
	 */
	public void setApplyCompName(String applyCompName) {
		this.applyCompName = applyCompName;
	}
	/**
	 * 获取报账单模板编码
	 * @return tpNo 报账单模板编码
	 */
	public String getTpNo() {
		return tpNo;
	}
	/**
	 * 设置报账单模板编码
	 * @param tpNo 报账单模板编码
	 */
	public void setTpNo(String tpNo) {
		this.tpNo = tpNo;
	}
	/**
	 * 获取报账单模板名称
	 * @return tpName 报账单模板名称
	 */
	public String getTpName() {
		return tpName;
	}
	/**
	 * 设置报账单模板名称
	 * @param tpName 报账单模板名称
	 */
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	/**
	 * 获取业务大类编码
	 * @return mcNo 业务大类编码
	 */
	public String getMcNo() {
		return mcNo;
	}
	/**
	 * 设置业务大类编码
	 * @param mcNo 业务大类编码
	 */
	public void setMcNo(String mcNo) {
		this.mcNo = mcNo;
	}
	/**
	 * 获取业务大类名称
	 * @return mcName 业务大类名称
	 */
	public String getMcName() {
		return mcName;
	}
	/**
	 * 设置业务大类名称
	 * @param mcName 业务大类名称
	 */
	public void setMcName(String mcName) {
		this.mcName = mcName;
	}
	/**
	 * 获取发票抬头
	 * @return invoiceTitle 发票抬头
	 */
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	/**
	 * 设置发票抬头
	 * @param invoiceTitle 发票抬头
	 */
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	/**
	 * 获取收款方名称
	 * @return accountName 收款方名称
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 设置收款方名称
	 * @param accountName 收款方名称
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * 获取账户性质
	 * @return accountNature 账户性质
	 */
	public String getAccountNature() {
		return accountNature;
	}
	/**
	 * 设置账户性质
	 * @param accountNature 账户性质
	 */
	public void setAccountNature(String accountNature) {
		this.accountNature = accountNature;
	}
	/**
	 * 获取收款方账号
	 * @return account 收款方账号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置收款方账号
	 * @param account 收款方账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取开户行省份编码
	 * @return bankProvinceId 开户行省份编码
	 */
	public String getBankProvinceId() {
		return bankProvinceId;
	}
	/**
	 * 设置开户行省份编码
	 * @param bankProvinceId 开户行省份编码
	 */
	public void setBankProvinceId(String bankProvinceId) {
		this.bankProvinceId = bankProvinceId;
	}
	/**
	 * 获取开户行省份名称
	 * @return bankProvinceName 开户行省份名称
	 */
	public String getBankProvinceName() {
		return bankProvinceName;
	}
	/**
	 * 设置开户行省份名称
	 * @param bankProvinceName 开户行省份名称
	 */
	public void setBankProvinceName(String bankProvinceName) {
		this.bankProvinceName = bankProvinceName;
	}
	/**
	 * 获取开户行城市编码
	 * @return bankCityId 开户行城市编码
	 */
	public String getBankCityId() {
		return bankCityId;
	}
	/**
	 * 设置开户行城市编码
	 * @param bankCityId 开户行城市编码
	 */
	public void setBankCityId(String bankCityId) {
		this.bankCityId = bankCityId;
	}
	/**
	 * 获取开户行城市名称
	 * @return bankCityName 开户行城市名称
	 */
	public String getBankCityName() {
		return bankCityName;
	}
	/**
	 * 设置开户行城市名称
	 * @param bankCityName 开户行城市名称
	 */
	public void setBankCityName(String bankCityName) {
		this.bankCityName = bankCityName;
	}
	/**
	 * 获取开户银行
	 * @return bankName 开户银行
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置开户银行
	 * @param bankName 开户银行
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取开户支行编码
	 * @return subbankId 开户支行编码
	 */
	public String getSubbankId() {
		return subbankId;
	}
	/**
	 * 设置开户支行编码
	 * @param subbankId 开户支行编码
	 */
	public void setSubbankId(String subbankId) {
		this.subbankId = subbankId;
	}
	/**
	 * 获取开户支行名称
	 * @return subbankName 开户支行名称
	 */
	public String getSubbankName() {
		return subbankName;
	}
	/**
	 * 设置开户支行名称
	 * @param subbankName 开户支行名称
	 */
	public void setSubbankName(String subbankName) {
		this.subbankName = subbankName;
	}
	/**
	 * 获取国际银行代码
	 * @return itnBankCode 国际银行代码
	 */
	public String getItnBankCode() {
		return itnBankCode;
	}
	/**
	 * 设置国际银行代码
	 * @param itnBankCode 国际银行代码
	 */
	public void setItnBankCode(String itnBankCode) {
		this.itnBankCode = itnBankCode;
	}
	/**
	 * 获取报账总金额
	 * @return applyAmount 报账总金额
	 */
	public BigDecimal getApplyAmount() {
		return applyAmount;
	}
	/**
	 * 设置报账总金额
	 * @param applyAmount 报账总金额
	 */
	public void setApplyAmount(BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}
	/**
	 * 获取本位币报账金额
	 * @return applyAmountStd 本位币报账金额
	 */
	public BigDecimal getApplyAmountStd() {
		return applyAmountStd;
	}
	/**
	 * 设置本位币报账金额
	 * @param applyAmountStd 本位币报账金额
	 */
	public void setApplyAmountStd(BigDecimal applyAmountStd) {
		this.applyAmountStd = applyAmountStd;
	}
	/**
	 * 获取核定金额
	 * @return ratifyAmount 核定金额
	 */
	public BigDecimal getRatifyAmount() {
		return ratifyAmount;
	}
	/**
	 * 设置核定金额
	 * @param ratifyAmount 核定金额
	 */
	public void setRatifyAmount(BigDecimal ratifyAmount) {
		this.ratifyAmount = ratifyAmount;
	}
	/**
	 * 获取核定本位币金额
	 * @return ratifyAmountStd 核定本位币金额
	 */
	public BigDecimal getRatifyAmountStd() {
		return ratifyAmountStd;
	}
	/**
	 * 设置核定本位币金额
	 * @param ratifyAmountStd 核定本位币金额
	 */
	public void setRatifyAmountStd(BigDecimal ratifyAmountStd) {
		this.ratifyAmountStd = ratifyAmountStd;
	}
	/**
	 * 获取付款金额
	 * @return payAmount 付款金额
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	/**
	 * 设置付款金额
	 * @param payAmount 付款金额
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * 获取本位币付款金额
	 * @return payAmountStd 本位币付款金额
	 */
	public BigDecimal getPayAmountStd() {
		return payAmountStd;
	}
	/**
	 * 设置本位币付款金额
	 * @param payAmountStd 本位币付款金额
	 */
	public void setPayAmountStd(BigDecimal payAmountStd) {
		this.payAmountStd = payAmountStd;
	}
	/**
	 * 获取付款金额大写
	 * @return payAmountCn 付款金额大写
	 */
	public String getPayAmountCn() {
		return payAmountCn;
	}
	/**
	 * 设置付款金额大写
	 * @param payAmountCn 付款金额大写
	 */
	public void setPayAmountCn(String payAmountCn) {
		this.payAmountCn = payAmountCn;
	}
	/**
	 * 获取最迟汇款日期
	 * @return latestRemitDate 最迟汇款日期
	 */
	public Date getLatestRemitDate() {
		return latestRemitDate;
	}
	/**
	 * 设置最迟汇款日期
	 * @param latestRemitDate 最迟汇款日期
	 */
	public void setLatestRemitDate(Date latestRemitDate) {
		this.latestRemitDate = latestRemitDate;
	}
	/**
	 * 获取联系方式
	 * @return contactInfo 联系方式
	 */
	public String getContactInfo() {
		return contactInfo;
	}
	/**
	 * 设置联系方式
	 * @param contactInfo 联系方式
	 */
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	/**
	 * 获取币种编码
	 * @return currencyCode 币种编码
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}
	/**
	 * 设置币种编码
	 * @param currencyCode 币种编码
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	/**
	 * 获取币种
	 * @return currency 币种
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 设置币种
	 * @param currency 币种
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * 获取支付方式编码
	 * @return payTypeCode 支付方式编码
	 */
	public String getPayTypeCode() {
		return payTypeCode;
	}
	/**
	 * 设置支付方式编码
	 * @param payTypeCode 支付方式编码
	 */
	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}
	/**
	 * 获取支付方式
	 * @return payType 支付方式
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置支付方式
	 * @param payType 支付方式
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取粘贴单张数
	 * @return attachCount 粘贴单张数
	 */
	public Integer getAttachCount() {
		return attachCount;
	}
	/**
	 * 设置粘贴单张数
	 * @param attachCount 粘贴单张数
	 */
	public void setAttachCount(Integer attachCount) {
		this.attachCount = attachCount;
	}
	/**
	 * 获取费用说明
	 * @return costExplain 费用说明
	 */
	public String getCostExplain() {
		return costExplain;
	}
	/**
	 * 设置费用说明
	 * @param costExplain 费用说明
	 */
	public void setCostExplain(String costExplain) {
		this.costExplain = costExplain;
	}
	/**
	 * 获取事前申请单号
	 * @return priorClaimNo 事前申请单号
	 */
	public String getPriorClaimNo() {
		return priorClaimNo;
	}
	/**
	 * 设置事前申请单号
	 * @param priorClaimNo 事前申请单号
	 */
	public void setPriorClaimNo(String priorClaimNo) {
		this.priorClaimNo = priorClaimNo;
	}
	/**
	 * 获取项目类型编码
	 * @return projectTypeCode 项目类型编码
	 */
	public String getProjectTypeCode() {
		return projectTypeCode;
	}
	/**
	 * 设置项目类型编码
	 * @param projectTypeCode 项目类型编码
	 */
	public void setProjectTypeCode(String projectTypeCode) {
		this.projectTypeCode = projectTypeCode;
	}
	/**
	 * 获取项目类型
	 * @return projectType 项目类型
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * 设置项目类型
	 * @param projectType 项目类型
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取项目名称编码
	 * @return projectNameCode 项目名称编码
	 */
	public String getProjectNameCode() {
		return projectNameCode;
	}
	/**
	 * 设置项目名称编码
	 * @param projectNameCode 项目名称编码
	 */
	public void setProjectNameCode(String projectNameCode) {
		this.projectNameCode = projectNameCode;
	}
	/**
	 * 获取项目名称
	 * @return projectName 项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置项目名称
	 * @param projectName 项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取业务类型编码
	 * @return bizTypeCode 业务类型编码
	 */
	public String getBizTypeCode() {
		return bizTypeCode;
	}
	/**
	 * 设置业务类型编码
	 * @param bizTypeCode 业务类型编码
	 */
	public void setBizTypeCode(String bizTypeCode) {
		this.bizTypeCode = bizTypeCode;
	}
	/**
	 * 获取业务类型
	 * @return bizType 业务类型
	 */
	public String getBizType() {
		return bizType;
	}
	/**
	 * 设置业务类型
	 * @param bizType 业务类型
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	/**
	 * 获取业务名称编码
	 * @return bizNameCode 业务名称编码
	 */
	public String getBizNameCode() {
		return bizNameCode;
	}
	/**
	 * 设置业务名称编码
	 * @param bizNameCode 业务名称编码
	 */
	public void setBizNameCode(String bizNameCode) {
		this.bizNameCode = bizNameCode;
	}
	/**
	 * 获取业务名称
	 * @return bizName 业务名称
	 */
	public String getBizName() {
		return bizName;
	}
	/**
	 * 设置业务名称
	 * @param bizName 业务名称
	 */
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	/**
	 * 获取origin
	 * @return origin origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * 设置origin
	 * @param origin origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * 获取预提类型编码
	 * @return accruedTypeCode 预提类型编码
	 */
	public String getAccruedTypeCode() {
		return accruedTypeCode;
	}
	/**
	 * 设置预提类型编码
	 * @param accruedTypeCode 预提类型编码
	 */
	public void setAccruedTypeCode(String accruedTypeCode) {
		this.accruedTypeCode = accruedTypeCode;
	}
	/**
	 * 获取预提类型
	 * @return accruedType 预提类型
	 */
	public String getAccruedType() {
		return accruedType;
	}
	/**
	 * 设置预提类型
	 * @param accruedType 预提类型
	 */
	public void setAccruedType(String accruedType) {
		this.accruedType = accruedType;
	}
	/**
	 * 获取费用所属月份
	 * @return costMonth 费用所属月份
	 */
	public String getCostMonth() {
		return costMonth;
	}
	/**
	 * 设置费用所属月份
	 * @param costMonth 费用所属月份
	 */
	public void setCostMonth(String costMonth) {
		this.costMonth = costMonth;
	}
	/**
	 * 获取已核销金额
	 * @return alreadyWritedAmount 已核销金额
	 */
	public BigDecimal getAlreadyWritedAmount() {
		return alreadyWritedAmount;
	}
	/**
	 * 设置已核销金额
	 * @param alreadyWritedAmount 已核销金额
	 */
	public void setAlreadyWritedAmount(BigDecimal alreadyWritedAmount) {
		this.alreadyWritedAmount = alreadyWritedAmount;
	}
	/**
	 * 获取付款部门标杆编码
	 * @return payDeptStandcode 付款部门标杆编码
	 */
	public String getPayDeptStandcode() {
		return payDeptStandcode;
	}
	/**
	 * 设置付款部门标杆编码
	 * @param payDeptStandcode 付款部门标杆编码
	 */
	public void setPayDeptStandcode(String payDeptStandcode) {
		this.payDeptStandcode = payDeptStandcode;
	}
	/**
	 * 获取付款部门名称
	 * @return payDeptName 付款部门名称
	 */
	public String getPayDeptName() {
		return payDeptName;
	}
	/**
	 * 设置付款部门名称
	 * @param payDeptName 付款部门名称
	 */
	public void setPayDeptName(String payDeptName) {
		this.payDeptName = payDeptName;
	}
	/**
	 * 获取是否借款
	 * @return isLoan 是否借款
	 */
	public String getIsLoan() {
		return isLoan;
	}
	/**
	 * 设置是否借款
	 * @param isLoan 是否借款
	 */
	public void setIsLoan(String isLoan) {
		this.isLoan = isLoan;
	}
	/**
	 * 获取部门性质
	 * @return deptNature 部门性质
	 */
	public String getDeptNature() {
		return deptNature;
	}
	/**
	 * 设置部门性质
	 * @param deptNature 部门性质
	 */
	public void setDeptNature(String deptNature) {
		this.deptNature = deptNature;
	}
	/**
	 * 获取预计金额
	 * @return planAmount 预计金额
	 */
	public BigDecimal getPlanAmount() {
		return planAmount;
	}
	/**
	 * 设置预计金额
	 * @param planAmount 预计金额
	 */
	public void setPlanAmount(BigDecimal planAmount) {
		this.planAmount = planAmount;
	}
	/**
	 * 获取是否自动冲借支
	 * @return isAutoWrited 是否自动冲借支
	 */
	public String getIsAutoWrited() {
		return isAutoWrited;
	}
	/**
	 * 设置是否自动冲借支
	 * @param isAutoWrited 是否自动冲借支
	 */
	public void setIsAutoWrited(String isAutoWrited) {
		this.isAutoWrited = isAutoWrited;
	}
	/**
	 * 获取业务数据唯一标识
	 * @return bizDataUuid 业务数据唯一标识
	 */
	public String getBizDataUuid() {
		return bizDataUuid;
	}
	/**
	 * 设置业务数据唯一标识
	 * @param bizDataUuid 业务数据唯一标识
	 */
	public void setBizDataUuid(String bizDataUuid) {
		this.bizDataUuid = bizDataUuid;
	}
	/**
	 * 获取状态编码
	 * @return stateCode 状态编码
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * 设置状态编码
	 * @param stateCode 状态编码
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * 获取状态描述
	 * @return state 状态描述
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置状态描述
	 * @param state 状态描述
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取流程状态编码
	 * @return procStateCode 流程状态编码
	 */
	public String getProcStateCode() {
		return procStateCode;
	}
	/**
	 * 设置流程状态编码
	 * @param procStateCode 流程状态编码
	 */
	public void setProcStateCode(String procStateCode) {
		this.procStateCode = procStateCode;
	}
	/**
	 * 获取流程状态
	 * @return procState 流程状态
	 */
	public String getProcState() {
		return procState;
	}
	/**
	 * 设置流程状态
	 * @param procState 流程状态
	 */
	public void setProcState(String procState) {
		this.procState = procState;
	}
	/**
	 * 获取审批状态编码
	 * @return auditStateCode 审批状态编码
	 */
	public String getAuditStateCode() {
		return auditStateCode;
	}
	/**
	 * 设置审批状态编码
	 * @param auditStateCode 审批状态编码
	 */
	public void setAuditStateCode(String auditStateCode) {
		this.auditStateCode = auditStateCode;
	}
	/**
	 * 获取审批状态
	 * @return auditState 审批状态
	 */
	public String getAuditState() {
		return auditState;
	}
	/**
	 * 设置审批状态
	 * @param auditState 审批状态
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	/**
	 * 获取凭证状态编码
	 * @return voucherStateCode 凭证状态编码
	 */
	public String getVoucherStateCode() {
		return voucherStateCode;
	}
	/**
	 * 设置凭证状态编码
	 * @param voucherStateCode 凭证状态编码
	 */
	public void setVoucherStateCode(String voucherStateCode) {
		this.voucherStateCode = voucherStateCode;
	}
	/**
	 * 获取凭证状态
	 * @return voucherState 凭证状态
	 */
	public String getVoucherState() {
		return voucherState;
	}
	/**
	 * 设置凭证状态
	 * @param voucherState 凭证状态
	 */
	public void setVoucherState(String voucherState) {
		this.voucherState = voucherState;
	}
	/**
	 * 获取付款状态编码
	 * @return payStateCode 付款状态编码
	 */
	public String getPayStateCode() {
		return payStateCode;
	}
	/**
	 * 设置付款状态编码
	 * @param payStateCode 付款状态编码
	 */
	public void setPayStateCode(String payStateCode) {
		this.payStateCode = payStateCode;
	}
	/**
	 * 获取付款状态
	 * @return payState 付款状态
	 */
	public String getPayState() {
		return payState;
	}
	/**
	 * 设置付款状态
	 * @param payState 付款状态
	 */
	public void setPayState(String payState) {
		this.payState = payState;
	}
	/**
	 * 获取流程实例ID
	 * @return wfInstanceId 流程实例ID
	 */
	public Long getWfInstanceId() {
		return wfInstanceId;
	}
	/**
	 * 设置流程实例ID
	 * @param wfInstanceId 流程实例ID
	 */
	public void setWfInstanceId(Long wfInstanceId) {
		this.wfInstanceId = wfInstanceId;
	}
	/**
	 * 获取流程环节实例ID
	 * @return wfStateInstanceId 流程环节实例ID
	 */
	public String getWfStateInstanceId() {
		return wfStateInstanceId;
	}
	/**
	 * 设置流程环节实例ID
	 * @param wfStateInstanceId 流程环节实例ID
	 */
	public void setWfStateInstanceId(String wfStateInstanceId) {
		this.wfStateInstanceId = wfStateInstanceId;
	}
	/**
	 * 获取流程环节名称
	 * @return wfState 流程环节名称
	 */
	public String getWfState() {
		return wfState;
	}
	/**
	 * 设置流程环节名称
	 * @param wfState 流程环节名称
	 */
	public void setWfState(String wfState) {
		this.wfState = wfState;
	}
	/**
	 * 获取流程上一环节名称
	 * @return wfPrevState 流程上一环节名称
	 */
	public String getWfPrevState() {
		return wfPrevState;
	}
	/**
	 * 设置流程上一环节名称
	 * @param wfPrevState 流程上一环节名称
	 */
	public void setWfPrevState(String wfPrevState) {
		this.wfPrevState = wfPrevState;
	}
	/**
	 * 获取流程当前工作项ID
	 * @return wfWorkitemId 流程当前工作项ID
	 */
	public String getWfWorkitemId() {
		return wfWorkitemId;
	}
	/**
	 * 设置流程当前工作项ID
	 * @param wfWorkitemId 流程当前工作项ID
	 */
	public void setWfWorkitemId(String wfWorkitemId) {
		this.wfWorkitemId = wfWorkitemId;
	}
	/**
	 * 获取流程当前处理人工号
	 * @return wfCurActorEmpcode 流程当前处理人工号
	 */
	public String getWfCurActorEmpcode() {
		return wfCurActorEmpcode;
	}
	/**
	 * 设置流程当前处理人工号
	 * @param wfCurActorEmpcode 流程当前处理人工号
	 */
	public void setWfCurActorEmpcode(String wfCurActorEmpcode) {
		this.wfCurActorEmpcode = wfCurActorEmpcode;
	}
	/**
	 * 获取流程当前处理人名称
	 * @return wfCurActorName 流程当前处理人名称
	 */
	public String getWfCurActorName() {
		return wfCurActorName;
	}
	/**
	 * 设置流程当前处理人名称
	 * @param wfCurActorName 流程当前处理人名称
	 */
	public void setWfCurActorName(String wfCurActorName) {
		this.wfCurActorName = wfCurActorName;
	}
	/**
	 * 获取流程当前人接收时间
	 * @return wfCurReceiveDate 流程当前人接收时间
	 */
	public Date getWfCurReceiveDate() {
		return wfCurReceiveDate;
	}
	/**
	 * 设置流程当前人接收时间
	 * @param wfCurReceiveDate 流程当前人接收时间
	 */
	public void setWfCurReceiveDate(Date wfCurReceiveDate) {
		this.wfCurReceiveDate = wfCurReceiveDate;
	}
	/**
	 * 获取开户银行编码
	 * @return bankId 开户银行编码
	 */
	public String getBankId() {
		return bankId;
	}
	/**
	 * 设置开户银行编码
	 * @param bankId 开户银行编码
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	/**
	 * 获取凭证编码
	 * @return voucherCode 凭证编码
	 */
	public String getVoucherCode() {
		return voucherCode;
	}
	/**
	 * 设置凭证编码
	 * @param voucherCode 凭证编码
	 */
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	/**
	 * 获取凭证生成日期
	 * @return voucherCreateDate 凭证生成日期
	 */
	public Date getVoucherCreateDate() {
		return voucherCreateDate;
	}
	/**
	 * 设置凭证生成日期
	 * @param voucherCreateDate 凭证生成日期
	 */
	public void setVoucherCreateDate(Date voucherCreateDate) {
		this.voucherCreateDate = voucherCreateDate;
	}
	/**
	 * 获取付款日期
	 * @return payDate 付款日期
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 设置付款日期
	 * @param payDate 付款日期
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	/**
	 * 获取影像文件编号
	 * @return imgFileNum 影像文件编号
	 */
	public String getImgFileNum() {
		return imgFileNum;
	}
	/**
	 * 设置影像文件编号
	 * @param imgFileNum 影像文件编号
	 */
	public void setImgFileNum(String imgFileNum) {
		this.imgFileNum = imgFileNum;
	}
	/**
	 * 获取影像状态
	 * @return imgState 影像状态
	 */
	public String getImgState() {
		return imgState;
	}
	/**
	 * 设置影像状态
	 * @param imgState 影像状态
	 */
	public void setImgState(String imgState) {
		this.imgState = imgState;
	}
	/**
	 * 获取影像文件数量
	 * @return imgFileCount 影像文件数量
	 */
	public Integer getImgFileCount() {
		return imgFileCount;
	}
	/**
	 * 设置影像文件数量
	 * @param imgFileCount 影像文件数量
	 */
	public void setImgFileCount(Integer imgFileCount) {
		this.imgFileCount = imgFileCount;
	}
	/**
	 * 获取影像最后修改人
	 * @return imgModifyUser 影像最后修改人
	 */
	public String getImgModifyUser() {
		return imgModifyUser;
	}
	/**
	 * 设置影像最后修改人
	 * @param imgModifyUser 影像最后修改人
	 */
	public void setImgModifyUser(String imgModifyUser) {
		this.imgModifyUser = imgModifyUser;
	}
	/**
	 * 获取是否包含特殊附件
	 * @return isInclSpecAtt 是否包含特殊附件
	 */
	public String getIsInclSpecAtt() {
		return isInclSpecAtt;
	}
	/**
	 * 设置是否包含特殊附件
	 * @param isInclSpecAtt 是否包含特殊附件
	 */
	public void setIsInclSpecAtt(String isInclSpecAtt) {
		this.isInclSpecAtt = isInclSpecAtt;
	}
	/**
	 * 获取特殊附件页码
	 * @return specAttPage 特殊附件页码
	 */
	public String getSpecAttPage() {
		return specAttPage;
	}
	/**
	 * 设置特殊附件页码
	 * @param specAttPage 特殊附件页码
	 */
	public void setSpecAttPage(String specAttPage) {
		this.specAttPage = specAttPage;
	}
	/**
	 * 获取影像调阅地址
	 * @return imgAccessUrl 影像调阅地址
	 */
	public String getImgAccessUrl() {
		return imgAccessUrl;
	}
	/**
	 * 设置影像调阅地址
	 * @param imgAccessUrl 影像调阅地址
	 */
	public void setImgAccessUrl(String imgAccessUrl) {
		this.imgAccessUrl = imgAccessUrl;
	}
	/**
	 * 获取审核会计已修改
	 * @return accountModify 审核会计已修改
	 */
	public String getAccountModify() {
		return accountModify;
	}
	/**
	 * 设置审核会计已修改
	 * @param accountModify 审核会计已修改
	 */
	public void setAccountModify(String accountModify) {
		this.accountModify = accountModify;
	}
	/**
	 * 获取预算状态
	 * @return budgetState 预算状态
	 */
	public String getBudgetState() {
		return budgetState;
	}
	/**
	 * 设置预算状态
	 * @param budgetState 预算状态
	 */
	public void setBudgetState(String budgetState) {
		this.budgetState = budgetState;
	}
	/**
	 * 获取预算主表ID
	 * @return budgetId 预算主表ID
	 */
	public String getBudgetId() {
		return budgetId;
	}
	/**
	 * 设置预算主表ID
	 * @param budgetId 预算主表ID
	 */
	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}
	/**
	 * 获取记账日期
	 * @return tallyDate 记账日期
	 */
	public Date getTallyDate() {
		return tallyDate;
	}
	/**
	 * 设置记账日期
	 * @param tallyDate 记账日期
	 */
	public void setTallyDate(Date tallyDate) {
		this.tallyDate = tallyDate;
	}
	/**
	 * 获取所属财务部编码
	 * @return financialDeptCode 所属财务部编码
	 */
	public String getFinancialDeptCode() {
		return financialDeptCode;
	}
	/**
	 * 设置所属财务部编码
	 * @param financialDeptCode 所属财务部编码
	 */
	public void setFinancialDeptCode(String financialDeptCode) {
		this.financialDeptCode = financialDeptCode;
	}
	/**
	 * 获取所属财务部
	 * @return financialDept 所属财务部
	 */
	public String getFinancialDept() {
		return financialDept;
	}
	/**
	 * 设置所属财务部
	 * @param financialDept 所属财务部
	 */
	public void setFinancialDept(String financialDept) {
		this.financialDept = financialDept;
	}
	/**
	 * 获取所属事业部编码
	 * @return businessDeptCode 所属事业部编码
	 */
	public String getBusinessDeptCode() {
		return businessDeptCode;
	}
	/**
	 * 设置所属事业部编码
	 * @param businessDeptCode 所属事业部编码
	 */
	public void setBusinessDeptCode(String businessDeptCode) {
		this.businessDeptCode = businessDeptCode;
	}
	/**
	 * 获取所属事业部
	 * @return businessDept 所属事业部
	 */
	public String getBusinessDept() {
		return businessDept;
	}
	/**
	 * 设置所属事业部
	 * @param businessDept 所属事业部
	 */
	public void setBusinessDept(String businessDept) {
		this.businessDept = businessDept;
	}
	/**
	 * 获取客户编码
	 * @return clientCode 客户编码
	 */
	public String getClientCode() {
		return clientCode;
	}
	/**
	 * 设置客户编码
	 * @param clientCode 客户编码
	 */
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	/**
	 * 获取客户名称
	 * @return clientName 客户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置客户名称
	 * @param clientName 客户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取所属车队编码
	 * @return motorcadeCode 所属车队编码
	 */
	public String getMotorcadeCode() {
		return motorcadeCode;
	}
	/**
	 * 设置所属车队编码
	 * @param motorcadeCode 所属车队编码
	 */
	public void setMotorcadeCode(String motorcadeCode) {
		this.motorcadeCode = motorcadeCode;
	}
	/**
	 * 获取所属车队
	 * @return motorcade 所属车队
	 */
	public String getMotorcade() {
		return motorcade;
	}
	/**
	 * 设置所属车队
	 * @param motorcade 所属车队
	 */
	public void setMotorcade(String motorcade) {
		this.motorcade = motorcade;
	}
	/**
	 * 获取是否超预计金额
	 * @return isExceedPlan 是否超预计金额
	 */
	public String getIsExceedPlan() {
		return isExceedPlan;
	}
	/**
	 * 设置是否超预计金额
	 * @param isExceedPlan 是否超预计金额
	 */
	public void setIsExceedPlan(String isExceedPlan) {
		this.isExceedPlan = isExceedPlan;
	}
	/**
	 * 获取退票状态
	 * @return refundState 退票状态
	 */
	public String getRefundState() {
		return refundState;
	}
	/**
	 * 设置退票状态
	 * @param refundState 退票状态
	 */
	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}
	/**
	 * 获取是否被撤销
	 * @return isRepeal 是否被撤销
	 */
	public String getIsRepeal() {
		return isRepeal;
	}
	/**
	 * 设置是否被撤销
	 * @param isRepeal 是否被撤销
	 */
	public void setIsRepeal(String isRepeal) {
		this.isRepeal = isRepeal;
	}
	/**
	 * 获取预计本位币金额
	 * @return planAmountStd 预计本位币金额
	 */
	public BigDecimal getPlanAmountStd() {
		return planAmountStd;
	}
	/**
	 * 设置预计本位币金额
	 * @param planAmountStd 预计本位币金额
	 */
	public void setPlanAmountStd(BigDecimal planAmountStd) {
		this.planAmountStd = planAmountStd;
	}
	/**
	 * 获取会计员工工号
	 * @return crewEmpcode 会计员工工号
	 */
	public String getCrewEmpcode() {
		return crewEmpcode;
	}
	/**
	 * 设置会计员工工号
	 * @param crewEmpcode 会计员工工号
	 */
	public void setCrewEmpcode(String crewEmpcode) {
		this.crewEmpcode = crewEmpcode;
	}
	/**
	 * 获取会计小组编码
	 * @return groupCode 会计小组编码
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * 设置会计小组编码
	 * @param groupCode 会计小组编码
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	/**
	 * 获取做账公司编码(发票抬头编码)
	 * @return invoiceTitleCode 做账公司编码(发票抬头编码)
	 */
	public String getInvoiceTitleCode() {
		return invoiceTitleCode;
	}
	/**
	 * 设置做账公司编码(发票抬头编码)
	 * @param invoiceTitleCode 做账公司编码(发票抬头编码)
	 */
	public void setInvoiceTitleCode(String invoiceTitleCode) {
		this.invoiceTitleCode = invoiceTitleCode;
	}
	/**
	 * 获取成本中心编码
	 * @return costCenterNo 成本中心编码
	 */
	public String getCostCenterNo() {
		return costCenterNo;
	}
	/**
	 * 设置成本中心编码
	 * @param costCenterNo 成本中心编码
	 */
	public void setCostCenterNo(String costCenterNo) {
		this.costCenterNo = costCenterNo;
	}
	/**
	 * 获取成本中心属性ID
	 * @return costCenterProid 成本中心属性ID
	 */
	public String getCostCenterProid() {
		return costCenterProid;
	}
	/**
	 * 设置成本中心属性ID
	 * @param costCenterProid 成本中心属性ID
	 */
	public void setCostCenterProid(String costCenterProid) {
		this.costCenterProid = costCenterProid;
	}
	/**
	 * 获取流程结束时间
	 * @return processEndTime 流程结束时间
	 */
	public Date getProcessEndTime() {
		return processEndTime;
	}
	/**
	 * 设置流程结束时间
	 * @param processEndTime 流程结束时间
	 */
	public void setProcessEndTime(Date processEndTime) {
		this.processEndTime = processEndTime;
	}
	/**
	 * 获取汇率
	 * @return exchangeRate 汇率
	 */
	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * 设置汇率
	 * @param exchangeRate 汇率
	 */
	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	/**
	 * 获取原始单据工作流编码
	 * @return origMcNo 原始单据工作流编码
	 */
	public String getOrigMcNo() {
		return origMcNo;
	}
	/**
	 * 设置原始单据工作流编码
	 * @param origMcNo 原始单据工作流编码
	 */
	public void setOrigMcNo(String origMcNo) {
		this.origMcNo = origMcNo;
	}
	/**
	 * 获取原始单据工作流名称
	 * @return origMcName 原始单据工作流名称
	 */
	public String getOrigMcName() {
		return origMcName;
	}
	/**
	 * 设置原始单据工作流名称
	 * @param origMcName 原始单据工作流名称
	 */
	public void setOrigMcName(String origMcName) {
		this.origMcName = origMcName;
	}
	/**
	 * 获取原账户性质
	 * @return origAccountNature 原账户性质
	 */
	public String getOrigAccountNature() {
		return origAccountNature;
	}
	/**
	 * 设置原账户性质
	 * @param origAccountNature 原账户性质
	 */
	public void setOrigAccountNature(String origAccountNature) {
		this.origAccountNature = origAccountNature;
	}
	/**
	 * 获取成本中心名称
	 * @return costCenterName 成本中心名称
	 */
	public String getCostCenterName() {
		return costCenterName;
	}
	/**
	 * 设置成本中心名称
	 * @param costCenterName 成本中心名称
	 */
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
	/**
	 * 获取撤销事由
	 * @return repealReason 撤销事由
	 */
	public String getRepealReason() {
		return repealReason;
	}
	/**
	 * 设置撤销事由
	 * @param repealReason 撤销事由
	 */
	public void setRepealReason(String repealReason) {
		this.repealReason = repealReason;
	}
	/**
	 * 获取财务部岗位编码
	 * @return finPostCode 财务部岗位编码
	 */
	public String getFinPostCode() {
		return finPostCode;
	}
	/**
	 * 设置财务部岗位编码
	 * @param finPostCode 财务部岗位编码
	 */
	public void setFinPostCode(String finPostCode) {
		this.finPostCode = finPostCode;
	}
	/**
	 * 获取财务部岗位名称
	 * @return finPostName 财务部岗位名称
	 */
	public String getFinPostName() {
		return finPostName;
	}
	/**
	 * 设置财务部岗位名称
	 * @param finPostName 财务部岗位名称
	 */
	public void setFinPostName(String finPostName) {
		this.finPostName = finPostName;
	}
	/**
	 * 获取薪酬组编码
	 * @return salaryGroupCode 薪酬组编码
	 */
	public String getSalaryGroupCode() {
		return salaryGroupCode;
	}
	/**
	 * 设置薪酬组编码
	 * @param salaryGroupCode 薪酬组编码
	 */
	public void setSalaryGroupCode(String salaryGroupCode) {
		this.salaryGroupCode = salaryGroupCode;
	}
	/**
	 * 获取薪酬组名称
	 * @return salaryGroupName 薪酬组名称
	 */
	public String getSalaryGroupName() {
		return salaryGroupName;
	}
	/**
	 * 设置薪酬组名称
	 * @param salaryGroupName 薪酬组名称
	 */
	public void setSalaryGroupName(String salaryGroupName) {
		this.salaryGroupName = salaryGroupName;
	}
	/**
	 * 获取原始单据claimId，需求有变，改为原始单据报账单号
	 *@return  origClaimId;
	 */
	public String getOrigClaimId() {
		return origClaimId;
	}
	/**
	 * 设置原始单据claimId，需求有变，改为原始单据报账单号
	 * @param origClaimId : set the property origClaimId.
	 */
	public void setOrigClaimId(String origClaimId) {
		this.origClaimId = origClaimId;
	}
	/**
	 * 获取是否超过3000行
	 * @return isThousand 是否超过3000行
	 */
	public String getIsThousand() {
		return isThousand;
	}
	/**
	 * 设置是否超过3000行
	 * @param isThousand 是否超过3000行
	 */
	public void setIsThousand(String isThousand) {
		this.isThousand = isThousand;
	}
	/**  
	 * 获取isWriteOver  
	 * @return isWriteOver isWriteOver  
	 */
	public String getIsWriteOver() {
		return isWriteOver;
	}
	/**  
	 * 设置isWriteOver  
	 * @param isWriteOver isWriteOver  
	 */
	public void setIsWriteOver(String isWriteOver) {
		this.isWriteOver = isWriteOver;
	}
	/**  
	 * 获取accountNatureCode  
	 * @return accountNatureCode accountNatureCode  
	 */
	public String getAccountNatureCode() {
		return accountNatureCode;
	}
	/**
	 * 获取账户类型
	 * @return  账户类型
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 设置账户类型
	 * @param accountType 账户类型
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**  
	 * 设置accountNatureCode  
	 * @param accountNatureCode accountNatureCode  
	 */
	public void setAccountNatureCode(String accountNatureCode) {
		this.accountNatureCode = accountNatureCode;
	}
	/**  
	 * 获取isIndAcc  
	 * @return isIndAcc isIndAcc  
	 */
	public String getIsIndAcc() {
		return isIndAcc;
	}
	/**  
	 * 设置isIndAcc  
	 * @param isIndAcc isIndAcc  
	 */
	public void setIsIndAcc(String isIndAcc) {
		this.isIndAcc = isIndAcc;
	}
	
	public String getRefundClaimMo() {
		return refundClaimMo;
	}
	public void setRefundClaimMo(String refundClaimMo) {
		this.refundClaimMo = refundClaimMo;
	}
	public String getIsAfterAccount() {
		return isAfterAccount;
	}
	public void setIsAfterAccount(String isAfterAccount) {
		this.isAfterAccount = isAfterAccount;
	}
	/**
	 * 获取流程环节中文名称
	 * @return wfStateCn 流程环节中文名称
	 */
	public String getWfStateCn() {
		return wfStateCn;
	}
	/**
	 * 设置流程环节中文名称
	 * @param wfStateCn 流程环节中文名称
	 */
	public void setWfStateCn(String wfStateCn) {
		this.wfStateCn = wfStateCn;
	}
	/**
	 * 获取流程上一环节中文名称
	 * @return wfPrevStateCn 流程上一环节中文名称
	 */
	public String getWfPrevStateCn() {
		return wfPrevStateCn;
	}
	/**
	 * 设置流程上一环节中文名称
	 * @param wfPrevStateCn 流程上一环节中文名称
	 */
	public void setWfPrevStateCn(String wfPrevStateCn) {
		this.wfPrevStateCn = wfPrevStateCn;
	}
	
	/**
	 * 获取是否承兑
	 * @return 是否承兑
	 */
	public String getIsHonour() {
		return isHonour;
	}
	
	/**
	 * 设置是否承兑
	 * @param isHonour 是否承兑
	 */
	public void setIsHonour(String isHonour) {
		this.isHonour = isHonour;
	}
	
	/**
	 * 获取红冲凭证编号
	 * @return 红冲凭证编号
	 */
	public String getRedPunchVoucherNo() {
		return redPunchVoucherNo;
	}
	
	/**
	 * 设置红冲凭证编号
	 * @param redPunchVoucherNo 红冲凭证编号
	 */
	public void setRedPunchVoucherNo(String redPunchVoucherNo) {
		this.redPunchVoucherNo = redPunchVoucherNo;
	}
	
	/**
	 * 获取导入eas标记
	 * @return 导入eas标记
	 */
	public String getImportFlag() {
		return importFlag;
	}
	
	/**
	 * 设置导入eas标记
	 * @param importFlag 导入eas标记
	 */
	public void setImportFlag(String importFlag) {
		this.importFlag = importFlag;
	}
	/**
	 * @return the writingAmount
	 */
	public BigDecimal getWritingAmount() {
		return writingAmount;
	}
	/**
	 * @param writingAmount the writingAmount to set
	 */
	public void setWritingAmount(BigDecimal writingAmount) {
		this.writingAmount = writingAmount;
	}
	
	/**
	 * 获取收款方做账公司名称
	 * @return 收款方做账公司名称
	 */
	public String getReceiverCompanyName() {
		return receiverCompanyName;
	}
	
	/**
	 * 设置收款方做账公司名称 
	 * @param receiverCompanyName 收款方做账公司名称
	 */
	public void setReceiverCompanyName(String receiverCompanyName) {
		this.receiverCompanyName = receiverCompanyName;
	}
	
	/**
	 * 获取收款方做账公司编码
	 * @return receiverCompanyCode
	 */
	public String getReceiverCompanyCode() {
		return receiverCompanyCode;
	}
	
	/**
	 * 设置收款方做账公司编码
	 * @param receiverCompanyCode
	 */
	public void setReceiverCompanyCode(String receiverCompanyCode) {
		this.receiverCompanyCode = receiverCompanyCode;
	}
	public DailyLineEntity getDailyDateEntity() {
		return dailyDateEntity;
	}
	public void setDailyDateEntity(DailyLineEntity dailyDateEntity) {
		this.dailyDateEntity = dailyDateEntity;
	}
	public String getIsCredit() {
		return isCredit;
	}
	public void setIsCredit(String isCredit) {
		this.isCredit = isCredit;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getMainJobs() {
		return mainJobs;
	}
	public void setMainJobs(String mainJobs) {
		this.mainJobs = mainJobs;
	}
	public String getJobTypeName() {
		return jobTypeName;
	}
	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	public String getMainJobsName() {
		return mainJobsName;
	}
	public void setMainJobsName(String mainJobsName) {
		this.mainJobsName = mainJobsName;
	}
	public String getMainBody() {
		return mainBody;
	}
	public void setMainBody(String mainBody) {
		this.mainBody = mainBody;
	}
	public String getMainBodyName() {
		return mainBodyName;
	}
	public void setMainBodyName(String mainBodyName) {
		this.mainBodyName = mainBodyName;
	}
	public String getBelongGroup() {
		return belongGroup;
	}
	public void setBelongGroup(String belongGroup) {
		this.belongGroup = belongGroup;
	}
	public String getBelongGroupCode() {
		return belongGroupCode;
	}
	public void setBelongGroupCode(String belongGroupCode) {
		this.belongGroupCode = belongGroupCode;
	}
	/**
	 * @return the scName
	 */
	public String getScName() {
		return scName;
	}
	/**
	 * @param scName the scName to set
	 */
	public void setScName(String scName) {
		this.scName = scName;
	}
	/**
	 * @return the versionNumber
	 */
	public String getVersionNumber() {
		return versionNumber;
	}
	/**
	 * @param versionNumber the versionNumber to set
	 */
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public String getIsNormalTax() {
		return isNormalTax;
	}
	public void setIsNormalTax(String isNormalTax) {
		this.isNormalTax = isNormalTax;
	}
	public String getUrgent() {
		return urgent;
	}
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	public String getUrgentTime() {
		return urgentTime;
	}
	public void setUrgentTime(String urgentTime) {
		this.urgentTime = urgentTime;
	}
    public String getExpenseIsOvertime() {
        return expenseIsOvertime;
    }
    public void setExpenseIsOvertime(String expenseIsOvertime) {
        this.expenseIsOvertime = expenseIsOvertime;
    }
    public String getMistakeCode() {
        return mistakeCode;
    }
    public void setMistakeCode(String mistakeCode) {
        this.mistakeCode = mistakeCode;
    }	
	
}