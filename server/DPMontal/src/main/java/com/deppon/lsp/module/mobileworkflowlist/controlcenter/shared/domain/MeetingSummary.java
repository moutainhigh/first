/**   
* @Title: MeetingSummary.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-12-21 上午11:59:26  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

/** 
 * @ClassName: MeetingSummary 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 徐丁钉
 * @date 2013-12-21 上午11:59:26 
 *  
 */
public class MeetingSummary {
	private String fid;
    private String fseq;
    private String fParentId;
    private String cfseq;
    private String cfBackLog;//代办事项
    private String cfPrincipalId;//负责人ID
    private String cfPrincipalName;//负责人
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
	 * @return the cfBackLog
	 */
	public String getCfBackLog() {
		return cfBackLog;
	}
	/**
	 * @param cfBackLog the cfBackLog to set
	 */
	public void setCfBackLog(String cfBackLog) {
		this.cfBackLog = cfBackLog;
	}
	/**
	 * @return the cfPrincipalId
	 */
	public String getCfPrincipalId() {
		return cfPrincipalId;
	}
	/**
	 * @param cfPrincipalId the cfPrincipalId to set
	 */
	public void setCfPrincipalId(String cfPrincipalId) {
		this.cfPrincipalId = cfPrincipalId;
	}
	/**
	 * @return the cfPrincipalName
	 */
	public String getCfPrincipalName() {
		return cfPrincipalName;
	}
	/**
	 * @param cfPrincipalName the cfPrincipalName to set
	 */
	public void setCfPrincipalName(String cfPrincipalName) {
		this.cfPrincipalName = cfPrincipalName;
	}
    
    
    
}
