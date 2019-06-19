/**   
* @Title: WithHoldLine.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-12-20 下午4:22:49  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

/** 
 * @ClassName: WithHoldLine 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 徐丁钉
 * @date 2013-12-20 下午4:22:49 
 *  
 */
public class WithHoldLine {
	
	private String fid;
	private String fSeq;
	private String fParentId;
	private String cfSeq;
	private String cfWithHoldMatterId; //扣款事项；
	private String cfWithHoldMatterName;
	private BigDecimal cfWithHoldAmount;//扣款金额；
	private Date cfWithHoldDate;//扣款日期
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
	 * @return the fSeq
	 */
	public String getfSeq() {
		return fSeq;
	}
	/**
	 * @param fSeq the fSeq to set
	 */
	public void setfSeq(String fSeq) {
		this.fSeq = fSeq;
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
	 * @return the cfSeq
	 */
	public String getCfSeq() {
		return cfSeq;
	}
	/**
	 * @param cfSeq the cfSeq to set
	 */
	public void setCfSeq(String cfSeq) {
		this.cfSeq = cfSeq;
	}
	/**
	 * @return the cfWithHoldMatterId
	 */
	public String getCfWithHoldMatterId() {
		return cfWithHoldMatterId;
	}
	/**
	 * @param cfWithHoldMatterId the cfWithHoldMatterId to set
	 */
	public void setCfWithHoldMatterId(String cfWithHoldMatterId) {
		this.cfWithHoldMatterId = cfWithHoldMatterId;
	}
	/**
	 * @return the cfWithHoldMatterName
	 */
	public String getCfWithHoldMatterName() {
		return cfWithHoldMatterName;
	}
	/**
	 * @param cfWithHoldMatterName the cfWithHoldMatterName to set
	 */
	public void setCfWithHoldMatterName(String cfWithHoldMatterName) {
		this.cfWithHoldMatterName = cfWithHoldMatterName;
	}
	/**
	 * @return the cfwithHoldAmount
	 */
	public BigDecimal getCfWithHoldAmount() {
		return cfWithHoldAmount;
	}
	/**
	 * @param cfwithHoldAmount the cfwithHoldAmount to set
	 */
	public void setCfWithHoldAmount(BigDecimal cfWithHoldAmount) {
		this.cfWithHoldAmount = cfWithHoldAmount;
	}
	public Date getCfWithHoldDate() {
		return cfWithHoldDate;
	}
	public void setCfWithHoldDate(Date cfWithHoldDate) {
		this.cfWithHoldDate = cfWithHoldDate;
	}
	
}
