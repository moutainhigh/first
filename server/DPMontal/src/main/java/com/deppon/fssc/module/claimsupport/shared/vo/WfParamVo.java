package com.deppon.fssc.module.claimsupport.shared.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *<pre>
 *功能: 工作流参数信息实体
 *作者：刘永涛
 *日期：2013-5-13上午11:31:04
 *</pre>
 */
public class WfParamVo implements Serializable{
	/**
	 * 序列化的版本标识
	 */
	private static final long serialVersionUID = -8328354864368641744L;
	/**
	 * 流程实例ID
	 */
	private Long wfProcInstId;
	/**
	 * 环节实例ID
	 */
	private Long wfStateInstId;
	/**
	 * 流程环节名称
	 */
	private String wfState;
	/**
	 * 流程环节中文名称
	 */
	private String wfStateCn;
	/**
	 * 下一个流程环节名称
	 */
	private String wfNextState;
	/**
	 * 当前工作项ID
	 */
	private Long wfWorkitemId;
	/**
	 * 报账单ID
	 */
	private String claimId;
	/**
	 * 报账单编号
	 */
	private String claimNo;
	/**
	 * 审批决策
	 */
	private String wfDecision;
	/**
	 * 审批意见
	 */
	private String wfOpinion;
	/**
	 * 当前有效的所有工作项ID
	 */
	private String workItemIds;
	/**
	 * 当前登录用户的岗位
	 */
	private String position;
	/**
	 * 是否需要总裁审批
	 */
	private String needPresident;
	/**
	 * 报账单来源
	 */
	private String origin;
	
	/**
	 * 当前状态是否为转报销
	 */
	private String isRefund;
	
	/**
	 * 当前环节是否为费用核算专员后的节点
	 */
	private String isAfterAccount;
	/**
	 * 收款方名称
	 * */
	private String accountName;
	
	/**
	 * 报账金额
	 * */
	private BigDecimal applyAmount;
	/**
	 * 是否存在重复付款
	 * */
	private long isRepeat;
	
	/**
	 * 是否借款
	 * */
	private String isLoan;
	/**
	 * 报账单模板编码
	 * */
	private String tpNo;
	/**
	 * 付款状态
	 */
	private String payStateCode;
	
	/**
	 * 付款金额
	 * */
	private BigDecimal payAmount;
	/**

	
	/**
	 * 获取流程实例ID
	 * @return wfProcInstId 流程实例ID
	 */
	public Long getWfProcInstId() {
		return wfProcInstId;
	}
	/**
	 * 设置流程实例ID
	 * @param wfProcInstId 流程实例ID
	 */
	public void setWfProcInstId(Long wfProcInstId) {
		this.wfProcInstId = wfProcInstId;
	}
	/**
	 * 获取环节实例ID
	 * @return wfStateInstId 环节实例ID
	 */
	public Long getWfStateInstId() {
		return wfStateInstId;
	}
	/**
	 * 设置环节实例ID
	 * @param wfStateInstId 环节实例ID
	 */
	public void setWfStateInstId(Long wfStateInstId) {
		this.wfStateInstId = wfStateInstId;
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
	 * 获取下一个流程环节名称
	 * @return wfNextState 下一个流程环节名称
	 */
	public String getWfNextState() {
		return wfNextState;
	}
	/**
	 * 设置下一个流程环节名称
	 * @param wfNextState 下一个流程环节名称
	 */
	public void setWfNextState(String wfNextState) {
		this.wfNextState = wfNextState;
	}
	/**
	 * 获取当前工作项ID
	 * @return wfWorkitemId 当前工作项ID
	 */
	public Long getWfWorkitemId() {
		return wfWorkitemId;
	}
	/**
	 * 设置当前工作项ID
	 * @param wfWorkitemId 当前工作项ID
	 */
	public void setWfWorkitemId(Long wfWorkitemId) {
		this.wfWorkitemId = wfWorkitemId;
	}
	/**
	 * 获取报账单ID
	 * @return claimId 报账单ID
	 */
	public String getClaimId() {
		return claimId;
	}
	/**
	 * 设置报账单ID
	 * @param claimId 报账单ID
	 */
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	/**
	 * 获取审批决策
	 * @return wfDecision 审批决策
	 */
	public String getWfDecision() {
		return wfDecision;
	}
	/**
	 * 设置审批决策
	 * @param wfDecision 审批决策
	 */
	public void setWfDecision(String wfDecision) {
		this.wfDecision = wfDecision;
	}
	/**
	 * 获取审批意见
	 * @return wfOpinion 审批意见
	 */
	public String getWfOpinion() {
		return wfOpinion;
	}
	/**
	 * 设置审批意见
	 * @param wfOpinion 审批意见
	 */
	public void setWfOpinion(String wfOpinion) {
		this.wfOpinion = wfOpinion;
	}
	/**
	 * 获取当前有效的所有工作项ID
	 * @return workItemIds 当前有效的所有工作项ID
	 */
	public String getWorkItemIds() {
		return workItemIds;
	}
	/**
	 * 设置当前有效的所有工作项ID
	 * @param workItemIds 当前有效的所有工作项ID
	 */
	public void setWorkItemIds(String workItemIds) {
		this.workItemIds = workItemIds;
	}
	

	/**
	 * 获取当前登录用户的岗位
	 * @return position 当前登录用户的岗位
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置当前登录用户的岗位
	 * @param position 当前登录用户的岗位
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取是否需要总裁审批
	 * @return needPresident 是否需要总裁审批
	 */
	public String getNeedPresident() {
		return needPresident;
	}
	/**
	 * 设置是否需要总裁审批
	 * @param needPresident 是否需要总裁审批
	 */
	public void setNeedPresident(String needPresident) {
		this.needPresident = needPresident;
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
	 * 获取报账单来源
	 * @return origin 报账单来源
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * 设置报账单来源
	 * @param origin 报账单来源
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * isRefund字段的getter方法
	 * @return 返回 isRefund字段的值
	 */
	public String getIsRefund() {
		return isRefund;
	}
	/**
	 * isRefund字段的setter方法
	 * @param isRefund 为 isRefund 字段设置的值
	 */
	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}
	/**
	 * isAfterAccount字段的getter方法
	 * @return 返回 isAfterAccount字段的值
	 */
	public String getIsAfterAccount() {
		return isAfterAccount;
	}
	/**
	 * isAfterAccount字段的setter方法
	 * @param isAfterAccount 为 isAfterAccount 字段设置的值
	 */
	public void setIsAfterAccount(String isAfterAccount) {
		this.isAfterAccount = isAfterAccount;
	}
	
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the applyAmount
	 */
	public BigDecimal getApplyAmount() {
		return applyAmount;
	}
	/**
	 * @param applyAmount the applyAmount to set
	 */
	public void setApplyAmount(BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}
	/**
	 * @return the isRepeat
	 */
	public long getIsRepeat() {
		return isRepeat;
	}
	/**
	 * @param isRepeat the isRepeat to set
	 */
	public void setIsRepeat(long isRepeat) {
		this.isRepeat = isRepeat;
	}
	/**
	 * @return the isLoan
	 */
	public String getIsLoan() {
		return isLoan;
	}
	/**
	 * @param isLoan the isLoan to set
	 */
	public void setIsLoan(String isLoan) {
		this.isLoan = isLoan;
	}
	/**
	 * @return the tpNo
	 */
	public String getTpNo() {
		return tpNo;
	}
	/**
	 * @param tpNo the tpNo to set
	 */
	public void setTpNo(String tpNo) {
		this.tpNo = tpNo;
	}
	/**
	 * 获取付款状态
	 * @return payStateCode 付款状态
	 */
	public String getPayStateCode() {
		return payStateCode;
	}
	/**
	 * 设置付款状态
	 * @param payStateCode 付款状态
	 */
	public void setPayStateCode(String payStateCode) {
		this.payStateCode = payStateCode;
	}
	/**
	 * 获取报账单编号
	 * @return claimNo 报账单编号
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 设置报账单编号
	 * @param claimNo 报账单编号
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * payAmount字段的getter方法
	 * @return 返回 payAmount字段的值
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	/**
	 * payAmount字段的setter方法
	 * @param payAmount 为 payAmount 字段设置的值
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	
}
