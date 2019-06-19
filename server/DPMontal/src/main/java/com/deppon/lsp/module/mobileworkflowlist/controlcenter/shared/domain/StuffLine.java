/**   
* @Title: StuffLine.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-11-5 下午1:32:52  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/** 
 * @ClassName: StuffLine 
 * @Description: TODO(材料清单明细) 
 * @author 徐丁钉
 * @date 2013-11-5 下午1:32:52 
 *  
 */
public class StuffLine extends BaseEntity{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	private String fId;            
	private String fSeq;
	private String fParentId;
	private String cfSeq;
	//费用名称ID
	private String cfCostNameId;
	//费用名称
	private String cfCostName;
	//材料名称ID
	private String cfMaterialNameId;
	//材料名称
	private String cfMaterialName;
	//规格
	private String cfStandard;
	//型号；
	private String cfModel;
	//品牌
	private String cfTradeMark;
	//备注；
	private String cfRemark;
	//材料附图；
	private String cfMaterialBook;
/**********************************************getter/setter******************************************/
	/**
	 * @return the fId
	 */
	public String getfId() {
		return fId;
	}
	/**
	 * @param fId the fId to set
	 */
	public void setfId(String fId) {
		this.fId = fId;
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
	 * @return the cfCostNameId
	 */
	public String getCfCostNameId() {
		return cfCostNameId;
	}
	/**
	 * @param cfCostNameId the cfCostNameId to set
	 */
	public void setCfCostNameId(String cfCostNameId) {
		this.cfCostNameId = cfCostNameId;
	}
	/**
	 * @return the cfCostName
	 */
	public String getCfCostName() {
		if (cfCostName == null) {
			cfCostName = "";
		}
		return cfCostName;
	}
	/**
	 * @param cfCostName the cfCostName to set
	 */
	public void setCfCostName(String cfCostName) {
		this.cfCostName = cfCostName;
	}
	/**
	 * @return the cfMaterialNameId
	 */
	public String getCfMaterialNameId() {
		return cfMaterialNameId;
	}
	/**
	 * @param cfMaterialNameId the cfMaterialNameId to set
	 */
	public void setCfMaterialNameId(String cfMaterialNameId) {
		this.cfMaterialNameId = cfMaterialNameId;
	}
	/**
	 * @return the cfMaterialName
	 */
	public String getCfMaterialName() {
		if (cfMaterialName == null) {
			cfMaterialName = "";
		}
		return cfMaterialName;
	}
	/**
	 * @param cfMaterialName the cfMaterialName to set
	 */
	public void setCfMaterialName(String cfMaterialName) {
		this.cfMaterialName = cfMaterialName;
	}
	/**
	 * @return the cfStandard
	 */
	public String getCfStandard() {
		if (cfStandard == null) {
			cfStandard = "";
		}
		return cfStandard;
	}
	/**
	 * @param cfStandard the cfStandard to set
	 */
	public void setCfStandard(String cfStandard) {
		this.cfStandard = cfStandard;
	}
	/**
	 * @return the cfModel
	 */
	public String getCfModel() {
		if (cfModel == null) {
			cfModel = "";
		}
		return cfModel;
	}
	/**
	 * @param cfModel the cfModel to set
	 */
	public void setCfModel(String cfModel) {
		this.cfModel = cfModel;
	}
	/**
	 * @return the cfTradeMark
	 */
	public String getCfTradeMark() {
		if (cfTradeMark == null){
			cfTradeMark = "";
		}
		return cfTradeMark;
	}
	/**
	 * @param cfTradeMark the cfTradeMark to set
	 */
	public void setCfTradeMark(String cfTradeMark) {
		this.cfTradeMark = cfTradeMark;
	}
	/**
	 * @return the cfRemark
	 */
	public String getCfRemark() {
		if (cfRemark == null) {
			cfRemark = "";
		}
		return cfRemark;
	}
	/**
	 * @param cfRemark the cfRemark to set
	 */
	public void setCfRemark(String cfRemark) {
		this.cfRemark = cfRemark;
	}
	/**
	 * @return the cfMaterialBook
	 */
	public String getCfMaterialBook() {
		if (cfMaterialBook == null) {
			cfMaterialBook = "";
		}
		return cfMaterialBook;
	}
	/**
	 * @param cfMaterialBook the cfMaterialBook to set
	 */
	public void setCfMaterialBook(String cfMaterialBook) {
		this.cfMaterialBook = cfMaterialBook;
	}
	
	
	
	
}
