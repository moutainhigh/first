/**   
* @Title: NonConstructionType.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-12-20 下午3:03:34  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.montal.util.FormatUtil;

/** 
 * @ClassName: NonConstructionType 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 徐丁钉
 * @date 2013-12-20 下午3:03:34 
 *  
 */
public class NonConstructionType  {
	
	private String fid;
	private String fSeq;
	private String fParentId;
	private String cfSeq;
	//比例
	private String cfRatio;
	//金额
	private String cfConstructAmount;
	//费用名称ID
	private String fPayNamesId;
	//费用名称
	private String fPayNamesName;
	//费用类型；
	private String cfType;
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
	 * @return the cfRatio
	 */
	public String getCfRatio() {
		return FormatUtil.formatDouble("###.00", cfRatio);
	}
	/**
	 * @param cfRatio the cfRatio to set
	 */
	public void setCfRatio(String cfRatio) {
		this.cfRatio = cfRatio;
	}
	/**
	 * @return the cfConstructAmount
	 */
	public String getCfConstructAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfConstructAmount);
	}
	/**
	 * @param cfConstructAmount the cfConstructAmount to set
	 */
	public void setCfConstructAmount(String cfConstructAmount) {
		this.cfConstructAmount = cfConstructAmount;
	}
	/**
	 * @return the fPayNamesId
	 */
	public String getfPayNamesId() {
		return fPayNamesId;
	}
	/**
	 * @param fPayNamesId the fPayNamesId to set
	 */
	public void setfPayNamesId(String fPayNamesId) {
		this.fPayNamesId = fPayNamesId;
	}
	/**
	 * @return the fPayNamesName
	 */
	public String getfPayNamesName() {
		return fPayNamesName;
	}
	/**
	 * @param fPayNamesName the fPayNamesName to set
	 */
	public void setfPayNamesName(String fPayNamesName) {
		this.fPayNamesName = fPayNamesName;
	}
	/**
	 * @return the cfType
	 */
	public String getCfType() {
		return cfType;
	}
	/**
	 * @param cfType the cfType to set
	 */
	public void setCfType(String cfType) {
		this.cfType = cfType;
	}
	
	
	
}
