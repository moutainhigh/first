package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 设计变更单核算明细Vo
 * @author jiafangyao
 *
 */
public class DesignChangee2Vo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8855371471370423663L;
	private Long seq;
	/**
	 * 父分录ID
	 */
	private String parentId;
	/**
	 * 单据分录序列号
	 */
	private Long cfSeq;
	/**
	 * 费用类型
	 */
	private String expenseTypeId;
	/**
	 * 费用类型
	 */
	private String expenseTypeName;
	/**
	 * 概算金额
	 */
	private Double budgetAmount;
	/**
	 * 费用名称ID
	 */
	private String expenseNameId;

	/**
	 * 费用名称
	 */
	private String expenseName;

	public Long getSeq() {
		return seq;
	}

	public String getSeqStr() {
		if (seq == null) {
			return "";
		}
		return (seq + "");
	}
	
	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Long getCfSeq() {
		return cfSeq;
	}

	public void setCfSeq(Long cfSeq) {
		this.cfSeq = cfSeq;
	}

	public String getExpenseTypeId() {
		return expenseTypeId;
	}

	public void setExpenseTypeId(String expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}

	public String getExpenseTypeName() {
		if (expenseTypeName == null) {
			expenseTypeName = "";
		}
		return expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}

	public Double getBudgetAmount() {
		return budgetAmount;
	}
	
	public String getBudgetAmountStr() {
		if (budgetAmount == null) {
			return "";
		}
		return (budgetAmount + "");
	}

	public void setBudgetAmount(Double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public String getExpenseNameId() {
		return expenseNameId;
	}

	public void setExpenseNameId(String expenseNameId) {
		this.expenseNameId = expenseNameId;
	}

	public String getExpenseName() {
		if (expenseName == null) {
			expenseName = "";
		}
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
