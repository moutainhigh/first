package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;

/**
 * RFQ单封装实体信息和分录信息
 * @author 148122
 *
 */
public class RfqBillVo {

	 //RFQ单表头对象，用来存储JS界面的RFQ单的表头信息
	private RFQBill rfqBill;
	//	 RFQ单分录  询价物品对象集合
	private List<RFQBillEntry> rfqBillEntryList;
    //	 RFQ单分录 技术评审对象集合
	private List<RFQBillAuditDept> rfqBillAuditDeptList;
	
	/**
	 * @author 148122
	 * @return rfqBill
	 */
    public RFQBill getRfqBill() {
		return rfqBill;
	}
    /**
	 * @author 148122
	 * @return 
	 */
	public void setRfqBill(RFQBill rfqBill) {
		this.rfqBill = rfqBill;
	}
	
	/**
	 * @author 148122
	 * @return rfqBillEntryList
	 */
	public List<RFQBillEntry> getRfqBillEntryList() {
		return rfqBillEntryList;
	}
	
	/**
	 * @author 148122
	 * @return 
	 */
	public void setRfqBillEntryList(List<RFQBillEntry> rfqBillEntryList) {
		this.rfqBillEntryList = rfqBillEntryList;
	}
	
	/**
	 * @author 148122
	 * @return rfqBillAuditDeptList
	 */
	public List<RFQBillAuditDept> getRfqBillAuditDeptList() {
		return rfqBillAuditDeptList;
	}
	
	/**
	 * @author 148122
	 * @return 
	 */
	public void setRfqBillAuditDeptList(List<RFQBillAuditDept> rfqBillAuditDeptList) {
		this.rfqBillAuditDeptList = rfqBillAuditDeptList;
	}
}
