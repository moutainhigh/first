/**   
 * @Title: FinalAccountEntriesEntity.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 徐丁钉   
 * @date 2013-12-12 下午5:50:48  
 */
package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

/**
 * @ClassName: FinalAccountEntriesEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 徐丁钉
 * @date 2013-12-12 下午5:50:48
 * 
 */
public class FinalAccountEntriesEntity {
	private String fSeq; //
	private String fId; // 表ID
	private String fParentId;// 父ID
	private String cfMatterId;// 事项
	private String cfAcceptMatter;// 验收情况
	private String cfCompletelreCord;// 军统档案
	private String cfMatterName;// 事项名称
	private String cfRemark;// 备注

	/**
	 * @return the fSeq
	 */
	public String getfSeq() {
		return fSeq;
	}

	/**
	 * @param fSeq
	 *            the fSeq to set
	 */
	public void setfSeq(String fSeq) {
		this.fSeq = fSeq;
	}

	/**
	 * @return the fId
	 */
	public String getfId() {
		return fId;
	}

	/**
	 * @param fId
	 *            the fId to set
	 */
	public void setfId(String fId) {
		this.fId = fId;
	}

	/**
	 * @return the fParentId
	 */
	public String getfParentId() {
		return fParentId;
	}

	/**
	 * @param fParentId
	 *            the fParentId to set
	 */
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}

	/**
	 * @return the cfMatterId
	 */
	public String getCfMatterId() {
		return cfMatterId;
	}

	/**
	 * @param cfMatterId
	 *            the cfMatterId to set
	 */
	public void setCfMatterId(String cfMatterId) {
		this.cfMatterId = cfMatterId;
	}

	/**
	 * @return the cfAcceptMatter
	 */
	public String getCfAcceptMatter() {
		return cfAcceptMatter;
	}

	/**
	 * @param cfAcceptMatter
	 *            the cfAcceptMatter to set
	 */
	public void setCfAcceptMatter(String cfAcceptMatter) {
		this.cfAcceptMatter = cfAcceptMatter;
	}

	/**
	 * @return the cfCompletelreCord
	 */
	public String getCfCompletelreCord() {
		return cfCompletelreCord;
	}

	/**
	 * @param cfCompletelreCord
	 *            the cfCompletelreCord to set
	 */
	public void setCfCompletelreCord(String cfCompletelreCord) {
		this.cfCompletelreCord = cfCompletelreCord;
	}

	/**
	 * @return the cfMatterName
	 */
	public String getCfMatterName() {
		return cfMatterName;
	}

	/**
	 * @param cfMatterName
	 *            the cfMatterName to set
	 */
	public void setCfMatterName(String cfMatterName) {
		this.cfMatterName = cfMatterName;
	}

	/**
	 * @return the cfRemark
	 */
	public String getCfRemark() {
		return cfRemark;
	}

	/**
	 * @param cfRemark
	 *            the cfRemark to set
	 */
	public void setCfRemark(String cfRemark) {
		this.cfRemark = cfRemark;
	}

}
