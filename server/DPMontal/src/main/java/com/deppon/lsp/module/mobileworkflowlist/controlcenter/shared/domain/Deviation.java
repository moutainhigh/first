/**   
* @Title: Deviation.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-12-21 下午2:33:00  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.montal.util.FormatUtil;

/** 
 * @ClassName: Deviation 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 徐丁钉
 * @date 2013-12-21 下午2:33:00 
 *  
 */
public class Deviation {
	private String fid;
    private String fseq;
    private String fParentId;
    private String cfseq;
    private String cfPartProjectId;//设计项目名单
    private String cfPartProjectName;//设计项目名单名称
    private String cfAcreage;//面积
    private String cfDirectAmount;//直接费用
    private String cfAcreageAmount;//单位面积费用
    
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
	 * @return the cfPartProjectId
	 */
	public String getCfPartProjectId() {
		return cfPartProjectId;
	}
	/**
	 * @param cfPartProjectId the cfPartProjectId to set
	 */
	public void setCfPartProjectId(String cfPartProjectId) {
		this.cfPartProjectId = cfPartProjectId;
	}
	/**
	 * @return the cfPartProjectName
	 */
	public String getCfPartProjectName() {
		return cfPartProjectName;
	}
	/**
	 * @param cfPartProjectName the cfPartProjectName to set
	 */
	public void setCfPartProjectName(String cfPartProjectName) {
		this.cfPartProjectName = cfPartProjectName;
	}
	/**
	 * @return the cfAcreage
	 */
	public String getCfAcreage() {
		return cfAcreage;
	}
	/**
	 * @param cfAcreage the cfAcreage to set
	 */
	public void setCfAcreage(String cfAcreage) {
		this.cfAcreage = cfAcreage;
	}
	/**
	 * @return the cfDirectAmount
	 */
	public String getCfDirectAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfDirectAmount);
	}
	/**
	 * @param cfDirectAmount the cfDirectAmount to set
	 */
	public void setCfDirectAmount(String cfDirectAmount) {
		this.cfDirectAmount = cfDirectAmount;
	}
	/**
	 * @return the cfAcreageAmount
	 */
	public String getCfAcreageAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfAcreageAmount);
	}
	/**
	 * @param cfAcreageAmount the cfAcreageAmount to set
	 */
	public void setCfAcreageAmount(String cfAcreageAmount) {
		this.cfAcreageAmount = cfAcreageAmount;
	}
    
    
    
}
