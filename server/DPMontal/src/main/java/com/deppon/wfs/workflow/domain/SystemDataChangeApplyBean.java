package com.deppon.wfs.workflow.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.deppon.montal.conf.domain.DictEntry;
import com.deppon.montal.util.EntryTable;
import com.deppon.montal.util.EntryTable.SonTable;

// TODO: Auto-generated Javadoc
/**
 * 系统数据申请实体bean.
 *
 * @author guanbo
 * @Date 2014-01-14 15:29:27
 */
 
public class SystemDataChangeApplyBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 业务表的主键. */
	private String busino;
	
	/** 流程实例号，对应老表的PROCESSINSTID. */
	private Long processinstid;
	
	/** 申请人姓名，对应老表的APPLYNAME. */
	private String applyPersonName;
	
	/** 提示信息，对应老表的MESSAGE. */
	private String message;
	
	/** 操作流程，对应老表的PROCESS. */
	private String process;
	
	/** 申请事由，对应老表的REASON. */
	private String applyReason;
	
	/** 申请人工号，对应老表的EMPID. */
	private String applyPersonId;
	
	/** 是否涉及财务，0——代表是，1——代表否，对应老表的ISFINANCIAL. */
	private String financialStatus;
	
	/** 问题所属系统，对应老表的SYSTEMID. */
	private String systemId;
	
	/** 问题所属系统名称. */
	private String systemName;
	
	/** 所涉及业务的标杆编码. */
	private String businessCode;
	
	/** 所涉及业务的名称. */
	private String businessName;
	
	/** 业务数据修改时间. */
	private Date modifyTime;
	
	/** 业务数据创建时间. */
	private Date createTime;
	
	/** 业务数据状态，1代表存在，0代表逻辑删除. */
	private String isseffective;
	
	/** 备用字段. */
	private Long spareField1;
	
	/** 备用字段. */
	private String spareField2;
	
	/** 备用字段. */
	private String spareField3;
	
	/** 对应系统. */
	private String correspondingSystem;
	
	/** 对应系统名称. */
	private	String correspondingSystemName;
	
	/** 开发组标杆编码. */
	private String developmentTeamCode;
	
	/** 开发组名称. */
	private String developmentTeamName;
	
	/** 开发组成员id. */
	private String developersId;
	
	/** 开发组成员姓名. */
	private String developersName;
	
	/** 是否本系统，0-表是，1表否. */
	private String referSystem;
	
	/** 这个字段主要是为了装载是否涉及财务的业务字段的value值，页面还用这个来判断，因为在服务层中转换了财务字段赋值为key值了，页面用value判断. */
	private String financialDicValue;
	
	/** The financial dict. */
	@EntryTable(isSonTable=SonTable.NO)
	private List<DictEntry> financialDict;
	
	/** 这个是为了处理是否设计本系统把业务字典的键值对存入这里面. */
	@EntryTable(isSonTable=SonTable.NO)
	private List<DictEntry> systemList;
	
	/**
	 * 这个是为了处理是否设计本系统把业务字典的键值对存入这里面.
	 *
	 * @return the busino
	 */
	/**
	* 获取 业务表的主键.
	*
	* @return 业务表的主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	 * 设置 业务表的主键.
	 *
	 * @param busino the new busino
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例号，对应老表的PROCESSINSTID.
	*
	* @return 流程实例号，对应老表的PROCESSINSTID.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * 设置 流程实例号，对应老表的PROCESSINSTID.
	 *
	 * @param processinstid the new processinstid
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人姓名，对应老表的APPLYNAME.
	*
	* @return 申请人姓名，对应老表的APPLYNAME.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * 设置 申请人姓名，对应老表的APPLYNAME.
	 *
	 * @param applyPersonName the new apply person name
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 提示信息，对应老表的MESSAGE.
	*
	* @return 提示信息，对应老表的MESSAGE.
	*/
	public String getMessage() {
		return message;
	}

	/**
	 * 设置 提示信息，对应老表的MESSAGE.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	* 获取 操作流程，对应老表的PROCESS.
	*
	* @return 操作流程，对应老表的PROCESS.
	*/
	public String getProcess() {
		return process;
	}

	/**
	 * 设置 操作流程，对应老表的PROCESS.
	 *
	 * @param process the new process
	 */
	public void setProcess(String process) {
		this.process = process;
	}
	
	/**
	* 获取 申请事由，对应老表的REASON.
	*
	* @return 申请事由，对应老表的REASON.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 设置 申请事由，对应老表的REASON.
	 *
	 * @param applyReason the new apply reason
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* 获取 申请人工号，对应老表的EMPID.
	*
	* @return 申请人工号，对应老表的EMPID.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * 设置 申请人工号，对应老表的EMPID.
	 *
	 * @param applyPersonId the new apply person id
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 是否涉及财务，0——代表是，1——代表否，对应老表的ISFINANCIAL.
	*
	* @return 是否涉及财务，0——代表是，1——代表否，对应老表的ISFINANCIAL.
	*/
	public String getFinancialStatus() {
		return financialStatus;
	}

	/**
	 * 设置 是否涉及财务，0——代表是，1——代表否，对应老表的ISFINANCIAL.
	 *
	 * @param financialStatus the new financial status
	 */
	public void setFinancialStatus(String financialStatus) {
		this.financialStatus = financialStatus;
		this.financialDicValue = this.financialStatus;
	}
	
	/**
	* 获取 问题所属系统，对应老表的SYSTEMID.
	*
	* @return 问题所属系统，对应老表的SYSTEMID.
	*/
	public String getSystemId() {
		return systemId;
	}

	/**
	 * 设置 问题所属系统，对应老表的SYSTEMID.
	 *
	 * @param systemId the new system id
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
	/**
	* 获取 问题所属系统名称.
	*
	* @return 问题所属系统名称.
	*/
	public String getSystemName() {
		return systemName;
	}

	/**
	 * 设置 问题所属系统名称.
	 *
	 * @param systemName the new system name
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	/**
	* 获取 所涉及业务的标杆编码.
	*
	* @return 所涉及业务的标杆编码.
	*/
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * 设置 所涉及业务的标杆编码.
	 *
	 * @param businessCode the new business code
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	
	/**
	* 获取 所涉及业务的名称.
	*
	* @return 所涉及业务的名称.
	*/
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 设置 所涉及业务的名称.
	 *
	 * @param businessName the new business name
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
	* 获取 业务数据状态，1代表存在，0代表逻辑删除.
	*
	* @return 业务数据状态，1代表存在，0代表逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * 设置 业务数据状态，1代表存在，0代表逻辑删除.
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
	* 获取 开发组标杆编码.
	*
	* @return 开发组标杆编码.
	*/
	public String getDevelopmentTeamCode() {
		return developmentTeamCode;
	}

	/**
	 * 设置 开发组标杆编码.
	 *
	 * @param developmentTeamCode the new development team code
	 */
	public void setDevelopmentTeamCode(String developmentTeamCode) {
		this.developmentTeamCode = developmentTeamCode;
	}
	
	/**
	* 获取 开发组名称.
	*
	* @return 开发组名称.
	*/
	public String getDevelopmentTeamName() {
		return developmentTeamName;
	}

	/**
	 * 设置 开发组名称.
	 *
	 * @param developmentTeamName the new development team name
	 */
	public void setDevelopmentTeamName(String developmentTeamName) {
		this.developmentTeamName = developmentTeamName;
	}
	
	/**
	* 获取 开发组成员id.
	*
	* @return 开发组成员id.
	*/
	public String getDevelopersId() {
		return developersId;
	}

	/**
	 * 设置 开发组成员id.
	 *
	 * @param developersId the new developers id
	 */
	public void setDevelopersId(String developersId) {
		this.developersId = developersId;
	}
	
	/**
	* 获取 开发组成员姓名.
	*
	* @return 开发组成员姓名.
	*/
	public String getDevelopersName() {
		return developersName;
	}

	/**
	 * 设置 开发组成员姓名.
	 *
	 * @param developersName the new developers name
	 */
	public void setDevelopersName(String developersName) {
		this.developersName = developersName;
	}

	/**
	 * Gets the refer system.
	 *
	 * @return the refer system
	 */
	public String getReferSystem() {
		return referSystem;
	}

	/**
	 * Sets the refer system.
	 *
	 * @param referSystem the new refer system
	 */
	public void setReferSystem(String referSystem) {
		this.referSystem = referSystem;
	}

	/**
	 * Gets the corresponding system.
	 *
	 * @return the corresponding system
	 */
	public String getCorrespondingSystem() {
		return correspondingSystem;
	}

	/**
	 * Sets the corresponding system.
	 *
	 * @param correspondingSystem the new corresponding system
	 */
	public void setCorrespondingSystem(String correspondingSystem) {
		this.correspondingSystem = correspondingSystem;
	}

	/**
	 * Gets the corresponding system name.
	 *
	 * @return the corresponding system name
	 */
	public String getCorrespondingSystemName() {
		return correspondingSystemName;
	}

	/**
	 * Sets the corresponding system name.
	 *
	 * @param correspondingSystemName the new corresponding system name
	 */
	public void setCorrespondingSystemName(String correspondingSystemName) {
		this.correspondingSystemName = correspondingSystemName;
	}

	/**
	 * Gets the financial dic value.
	 *
	 * @return the financial dic value
	 */
	public String getFinancialDicValue() {
		return financialDicValue;
	}

	/**
	 * Sets the financial dic value.
	 *
	 * @param financialDicValue the new financial dic value
	 */
	public void setFinancialDicValue(String financialDicValue) {
		this.financialDicValue = financialDicValue;
	}

	/**
	 * Gets the system list.
	 *
	 * @return the system list
	 */
	public List<DictEntry> getSystemList() {
		return systemList == null? new ArrayList<DictEntry>():systemList;
	}

	/**
	 * Sets the system list.
	 *
	 * @param systemList the new system list
	 */
	public void setSystemList(List<DictEntry> systemList) {
		this.systemList = systemList;
	}

	/**
	 * Gets the financial dict.
	 *
	 * @return the financial dict
	 */
	public List<DictEntry> getFinancialDict() {
		return financialDict == null? new ArrayList<DictEntry>():financialDict;
	}

	/**
	 * Sets the financial dict.
	 *
	 * @param financialDict the new financial dict
	 */
	public void setFinancialDict(List<DictEntry> financialDict) {
		this.financialDict = financialDict;
	}
}
