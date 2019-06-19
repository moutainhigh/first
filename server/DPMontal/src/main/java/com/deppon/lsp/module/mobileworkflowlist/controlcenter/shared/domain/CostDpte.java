/**   
* @Title: CostDpte.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-12-21 下午3:33:16  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.montal.util.FormatUtil;

/** 
 * @ClassName: CostDpte 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 徐丁钉
 * @date 2013-12-21 下午3:33:16 
 *  
 */
public class CostDpte {

	private String fid;
	private String fseq;
	private String fParentId;
	private String cfseq;
	private String cfCostdeptId; //费用承担部门
	private String cfCostdeptName;//费用承担部门
	private String cfProPortion;//费用比例
	private String cfAmountDept;//金额
	private String cfinvoiceid;//发票抬头
	private String cfinvoicename;//发票抬头
	
	public String getCfinvoiceid() {
		return cfinvoiceid;
	}
	public void setCfinvoiceid(String cfinvoiceid) {
		this.cfinvoiceid = cfinvoiceid;
	}
	public String getCfinvoicename() {
		return cfinvoicename;
	}
	public void setCfinvoicename(String cfinvoicename) {
		this.cfinvoicename = cfinvoicename;
	}
	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * @return the fseq
	 */
	public String getFseq() {
		return fseq;
	}
	/**
	 * @param fseq the fseq to set
	 */
	public void setFseq(String fseq) {
		this.fseq = fseq;
	}
	/**
	 * @return the fParentId
	 */
	public String getfParentId() {
		return fParentId;
	}
	/**
	 * @param fParentId the fParentId to set
	 */
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}
	/**
	 * @return the cfseq
	 */
	public String getCfseq() {
		return cfseq;
	}
	/**
	 * @param cfseq the cfseq to set
	 */
	public void setCfseq(String cfseq) {
		this.cfseq = cfseq;
	}
	/**
	 * @return the cfCostdeptId
	 */
	public String getCfCostdeptId() {
		return cfCostdeptId;
	}
	/**
	 * @param cfCostdeptId the cfCostdeptId to set
	 */
	public void setCfCostdeptId(String cfCostdeptId) {
		this.cfCostdeptId = cfCostdeptId;
	}
	/**
	 * @return the cfCostdeptName
	 */
	public String getCfCostdeptName() {
		return cfCostdeptName;
	}
	/**
	 * @param cfCostdeptName the cfCostdeptName to set
	 */
	public void setCfCostdeptName(String cfCostdeptName) {
		this.cfCostdeptName = cfCostdeptName;
	}
	/**
	 * @return the cfProPortion
	 */
	public String getCfProPortion() {
		return cfProPortion;
	}
	/**
	 * @param cfProPortion the cfProPortion to set
	 */
	public void setCfProPortion(String cfProPortion) {
		this.cfProPortion = cfProPortion;
	}
	/**
	 * @return the cfAmountDept
	 */
	public String getCfAmountDept() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfAmountDept);
	}
	/**
	 * @param cfAmountDept the cfAmountDept to set
	 */
	public void setCfAmountDept(String cfAmountDept) {
		this.cfAmountDept = cfAmountDept;
	}
	
	
	
	
}
