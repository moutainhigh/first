package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 偏线代理合同实体类
 * @author Work Flow System
 * @Date 2013-09-06 16:47:49
 */
public class OtherSideLineProxy implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** 业务编号，主键 */
	private String busino;
	/** 申请人 */
	private String applyPersonName;
	/** 申请人工号 */
	private String applyPersonId;
	/** 工作流类别 */
	private String flowCategory;
	/** 外发部门名称 */
	private String startOrgName;
	/** 外发部门ID */
	private String startFinasyscode;
	/** 所属财务部 */
	private String finqnceCode;
	/** 所属事业部 */
	private String businessUnitsCode;
	/** 保证金金额 */
	private Long margin;
	/** 大区标准编码 */
	private String bigAreaFinasysCode;
	/** 大区负责人 */
	private String bigAreaManager;
	/** 保证金支付方式 */
	private String marginpayCategory;
	/** 外发成本支付方式 */
	private String startCostPayCategory;
	/** 代理名称 */
	private String agentName;
	/** 代理所在城市 */
	private String agentCity;
	/** 申请事由 */
	private String reason;
	/** 是否有效 */
	private String isseffective;
	/** 工作流号 */
	private Long processinstid;
	/**起草时间*/
	private Date draftDate;
	/**创建时间*/
	private Date createTime;
	/**修改时间 */
	private Date modifyTime;
	
	/**
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
	 * 
	* @MethodName: getApplyPersonName 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:51:53
	* @return String
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}
	/**
	 * 
	* @MethodName: setApplyPersonName 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:51:56
	* @param applyPersonName void
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	 * 
	* @MethodName: getApplyPersonId 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:51:59
	* @return String
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	 * 
	* @MethodName: setApplyPersonId 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:52:02
	* @param applyPersonId void
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	* 鑾峰彇 工作流类别.
	*
	* @return 工作流类别.
	*/
	public String getFlowCategory() {
		return flowCategory;
	}

	/**
	* 璁剧疆 工作流类别.
	*
	* @param 工作流类别.
	*/
	public void setFlowCategory(String flowCategory) {
		this.flowCategory = flowCategory;
	}
	/**
	* 鑾峰彇 外发部门名称.
	*
	* @return 外发部门名称.
	*/
	public String getStartOrgName() {
		return startOrgName;
	}

	/**
	* 璁剧疆 外发部门名称.
	*
	* @param 外发部门名称.
	*/
	public void setStartOrgName(String startOrgName) {
		this.startOrgName = startOrgName;
	}
	 
	public String getStartFinasyscode() {
		return startFinasyscode;
	}
	public void setStartFinasyscode(String startFinasyscode) {
		this.startFinasyscode = startFinasyscode;
	}
	/**
	* 鑾峰彇 所属财务部.
	*
	* @return 所属财务部.
	*/
	public String getFinqnceCode() {
		return finqnceCode;
	}

	/**
	* 璁剧疆 所属财务部.
	*
	* @param 所属财务部.
	*/
	public void setFinqnceCode(String finqnceCode) {
		this.finqnceCode = finqnceCode;
	}
	/**
	* 鑾峰彇 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getBusinessUnitsCode() {
		return businessUnitsCode;
	}

	/**
	* 璁剧疆 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setBusinessUnitsCode(String businessUnitsCode) {
		this.businessUnitsCode = businessUnitsCode;
	}
	/**
	* 鑾峰彇 大区标准编码.
	*
	* @return 大区标准编码.
	*/
	public String getBigAreaFinasysCode() {
		return bigAreaFinasysCode;
	}
	/**
	* 鑾峰彇 保证金金额.
	*
	* @return 保证金金额.
	*/
	public Long getMargin() {
		return margin;
	}
	/**
	* 璁剧疆 保证金金额.
	*
	* @param 保证金金额.
	*/
	
	public void setMargin(Long margin) {
		this.margin = margin;
	}

	/**
	* 璁剧疆 大区标准编码.
	*
	* @param 大区标准编码. 
	*/
	public void setBigAreaFinasysCode(String bigAreaFinasysCode) {
		this.bigAreaFinasysCode = bigAreaFinasysCode;
	}
	/**
	* 鑾峰彇 大区负责人.
	*
	* @return 大区负责人.
	*/
	public String getBigAreaManager() {
		return bigAreaManager;
	}

	/**
	* 璁剧疆 大区负责人.
	*
	* @param 大区负责人.
	*/
	public void setBigAreaManager(String bigAreaManager) {
		this.bigAreaManager = bigAreaManager;
	}
	/**
	* 鑾峰彇 保证金支付方式.
	*
	* @return 保证金支付方式.
	*/
	public String getMarginpayCategory() {
		return marginpayCategory;
	}

	/**
	* 璁剧疆 保证金支付方式.
	*
	* @param 保证金支付方式.
	*/
	public void setMarginpayCategory(String marginpayCategory) {
		this.marginpayCategory = marginpayCategory;
	}
	/**
	* 鑾峰彇 外发成本支付方式.
	*
	* @return 外发成本支付方式.
	*/
	public String getStartCostPayCategory() {
		return startCostPayCategory;
	}

	/**
	* 璁剧疆 外发成本支付方式.
	*
	* @param 外发成本支付方式.
	*/
	public void setStartCostPayCategory(String startCostPayCategory) {
		this.startCostPayCategory = startCostPayCategory;
	}
	/**
	* 鑾峰彇 代理名称.
	*
	* @return 代理名称.
	*/
	public String getAgentName() {
		return agentName;
	}

	/**
	* 璁剧疆 代理名称.
	*
	* @param 代理名称.
	*/
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	* 鑾峰彇 代理所在城市.
	*
	* @return 代理所在城市.
	*/
	public String getAgentCity() {
		return agentCity;
	}

	/**
	* 璁剧疆 代理所在城市.
	*
	* @param 代理所在城市.
	*/
	public void setAgentCity(String agentCity) {
		this.agentCity = agentCity;
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
	* 鑾峰彇 是否有效.
	*
	* @return 是否有效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 璁剧疆 是否有效.
	*
	* @param 是否有效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
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
	public Date getDraftDate() {
		return draftDate;
	}
	public void setDraftDate(Date draftDate) {
		this.draftDate = draftDate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
