package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
* 工程项目可行性评估分录实体
* @title: ProFasAssesEntryEntity 
* @author： lihai
* @date： 2013-12-25 上午11:06:37
 */
public class ProFasAssesEntryEntity extends BaseEntity implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	//单据分录序列号
	private int fseq;
	//id
	private String fid;
	//id
	private String fparentId;
	//风险类别
	private String cfdangertypeId;
	//风险事项
	private String cfdangermatterId;
	//风险描述
	private String cfdangerDescribe;
	//风险重要性
	private String cfdangerImportant;
	//风险发生频率
	private BigDecimal cfdangerRate;
	
	/**
	 * 页面显示字段
	 */
	
	//风险类别
	private String cfdangertype;
	
	//风险事项
	private String dangermatter;
	
	//风险重要性
	private String dangerImportantName;
	
	
	/**
	 * @return the dangerImportantName
	 */
	public String getDangerImportantName() {
		if (dangerImportantName == null) {
			return "";
		}
		return dangerImportantName;
	}
	/**
	 * @param dangerImportantName the dangerImportantName to set
	 */
	public void setDangerImportantName(String dangerImportantName) {
		this.dangerImportantName = dangerImportantName;
	}
	/**
	 * @return the cfdangertype
	 */
	public String getCfdangertype() {
		if (cfdangertype == null) {
			return "";
		}
		return cfdangertype;
	}
	/**
	 * @param cfdangertype the cfdangertype to set
	 */
	public void setCfdangertype(String cfdangertype) {
		this.cfdangertype = cfdangertype;
	}
	/**
	 * @return the dangermatter
	 */
	public String getDangermatter() {
		if (dangermatter == null) {
			return "";
		}
		return dangermatter;
	}
	/**
	 * @param dangermatter the dangermatter to set
	 */
	public void setDangermatter(String dangermatter) {
		this.dangermatter = dangermatter;
	}
	/**
	 * @return the fseq
	 */
	public int getFseq() {
		return fseq;
	}
	/**
	 * @param fseq the fseq to set
	 */
	public void setFseq(int fseq) {
		this.fseq = fseq;
	}
	/**
	 * @return the fid
	 */
	public String getFid() {
		if (fid == null) {
			return "";
		}
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * @return the fparentId
	 */
	public String getFparentId() {
		if (fparentId == null) {
			return "";
		}
		return fparentId;
	}
	/**
	 * @param fparentId the fparentId to set
	 */
	public void setFparentId(String fparentId) {
		this.fparentId = fparentId;
	}
	/**
	 * @return the cfdangertypeId
	 */
	public String getCfdangertypeId() {
		if (cfdangertypeId == null) {
			return "";
		}
		return cfdangertypeId;
	}
	/**
	 * @param cfdangertypeId the cfdangertypeId to set
	 */
	public void setCfdangertypeId(String cfdangertypeId) {
		this.cfdangertypeId = cfdangertypeId;
	}
	/**
	 * @return the cfdangermatterId
	 */
	public String getCfdangermatterId() {
		if (cfdangermatterId == null) {
			return "";
		}
		return cfdangermatterId;
	}
	/**
	 * @param cfdangermatterId the cfdangermatterId to set
	 */
	public void setCfdangermatterId(String cfdangermatterId) {
		this.cfdangermatterId = cfdangermatterId;
	}
	/**
	 * @return the cfdangerDescribe
	 */
	public String getCfdangerDescribe() {
		if (cfdangerDescribe == null) {
			return "";
		}
		return cfdangerDescribe;
	}
	/**
	 * @param cfdangerDescribe the cfdangerDescribe to set
	 */
	public void setCfdangerDescribe(String cfdangerDescribe) {
		this.cfdangerDescribe = cfdangerDescribe;
	}
	/**
	 * @return the cfdangerImportant
	 */
	public String getCfdangerImportant() {
		if (cfdangerImportant == null) {
			return "";
		}
		return cfdangerImportant;
	}
	/**
	 * @param cfdangerImportant the cfdangerImportant to set
	 */
	public void setCfdangerImportant(String cfdangerImportant) {
		this.cfdangerImportant = cfdangerImportant;
	}
	/**
	 * @return the cfdangerRate
	 */
	public BigDecimal getCfdangerRate() {
		return cfdangerRate;
	}
	/**
	 * @param cfdangerRate the cfdangerRate to set
	 */
	public void setCfdangerRate(BigDecimal cfdangerRate) {
		this.cfdangerRate = cfdangerRate;
	}

	
}
