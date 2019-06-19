package com.deppon.dpm.module.management.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 工程项目质量巡检记录单分录
 */
public class QualitypollingentryEntity extends BaseEntity {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 6268413982048992891L;
	/**
	 * //FID
	 */
	private String fid;
	/**
	 * //序列
	 */
	private Long fseq;
	/**
	 * //父ID
	 */
	private String fparentid;
	/**
	 * //检查区域
	 */
	private String cfcheckarea;
	/**
	 * //检查项目
	 */
	private String cfcheckaproject;
	/**
	 * //分值
	 */
	private double cfscore;
	/**
	 * //扣分
	 */
	private double cfpoints;
	/**
	 * //得分
	 */
	private double cfaccount;
	/**
	 * //问题描述
	 */
	private String cfproblemcontent;
	/**
	 * //原因调查
	 */
	private String cfcause;

	/**
	 * @return fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid fid
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return 序列
	 */
	public Long getFseq() {
		return fseq;
	}

	/**
	 * @param fseq 序列
	 */
	public void setFseq(Long fseq) {
		this.fseq = fseq;
	}

	/**
	 * @return 父id
	 */
	public String getFparentid() {
		return fparentid;
	}

	/**
	 * @param fparentid 父id
	 */
	public void setFparentid(String fparentid) {
		this.fparentid = fparentid;
	}

	/**
	 * @return 检查区域
	 */
	public String getCfcheckarea() {
		return cfcheckarea;
	}

	/**
	 * @param cfcheckarea 检查区域
	 */
	public void setCfcheckarea(String cfcheckarea) {
		this.cfcheckarea = cfcheckarea;
	}

	/**
	 * @return 检查项目
	 */
	public String getCfcheckaproject() {
		return cfcheckaproject;
	}

	/**
	 * @param cfcheckaproject 检查项目
	 */
	public void setCfcheckaproject(String cfcheckaproject) {
		this.cfcheckaproject = cfcheckaproject;
	}

	/**
	 * @return 分值
	 */
	public double getCfscore() {
		return cfscore;
	}

	/**
	 * @param cfscore 分值
	 */
	public void setCfscore(double cfscore) {
		this.cfscore = cfscore;
	}

	/**
	 * @return 扣分
	 */
	public double getCfpoints() {
		return cfpoints;
	}

	/**
	 * @param cfpoints 扣分
	 */
	public void setCfpoints(double cfpoints) {
		this.cfpoints = cfpoints;
	}

	/**
	 * @return 得分
	 */
	public double getCfaccount() {
		return cfaccount;
	}

	/**
	 * @param cfaccount 得分
	 */
	public void setCfaccount(double cfaccount) {
		this.cfaccount = cfaccount;
	}

	/** 
	 * @return 问题描述
	 */
	public String getCfproblemcontent() {
		return cfproblemcontent;
	}

	/**
	 * @param cfproblemcontent 问题描述
	 */
	public void setCfproblemcontent(String cfproblemcontent) {
		this.cfproblemcontent = cfproblemcontent;
	}

	/**
	 * @return 原因调查
	 */
	public String getCfcause() {
		return cfcause;
	}

	/**
	 * @param cfcause 原因调查
	 */
	public void setCfcause(String cfcause) {
		this.cfcause = cfcause;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//组装
	public String toString() {
		return "QualitypollingentryEntity [fid=" + fid + ", fseq=" + fseq
				+ ", fparentid=" + fparentid + ", cfcheckarea=" + cfcheckarea
				+ ", cfcheckaproject=" + cfcheckaproject + ", cfscore="
				+ cfscore + ", cfpoints=" + cfpoints + ", cfaccount="
				+ cfaccount + ", cfproblemcontent=" + cfproblemcontent
				+ ", cfcause=" + cfcause + "]";
	}

}
