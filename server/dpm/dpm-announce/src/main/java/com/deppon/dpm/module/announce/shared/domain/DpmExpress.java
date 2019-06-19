package com.deppon.dpm.module.announce.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.dpm.module.common.server.util.MagicNumber;

public class DpmExpress {
	// 主键
	private int issuedId;
	// 发布时间
	@JSONField(format = "yyyy-MM-dd")
	private Date learnDate;
	// 事业部聚焦标题
	private String quoContent;
	// 事业部名称
	private String divisionName;
	// 今日聚焦标题
	private String taTitle;
	// 今日聚焦标题内容
	private String taTitleContent;
	// 今日聚焦内容
	private String taContent;
	// 今日聚焦学习状态 0 未学习，1已学习
	private int taStatus;
	// 专业知识标题
	private String buTitle;
	// 专业知识标题内容
	private String buTitleContent;
	// 专业知识内容
	private String buContent;
	// 专业知识学习状态 0 未学习，1已学习
	private int buStatus;
	// 案例焦点学习标题（标准知识）
	private String jiaoTitle;
	// 案例焦点学习标题内容（标准知识）
	private String jiaoTitleContent;
	// 案例焦点学习内容（标准知识）
	private String jiaoContent;
	// 标准知识学习状态 0 未学习，1已学习
	private int jiaoStatus;
	// 是否学习完成 0未完成，1完成
	@SuppressWarnings("unused")
	private int finishLearn;
	// 早安快递类型
	private String morningType;

	/**
	 * get
	 * @return
	 */
	public int getIssuedId() {
		return issuedId;
	}

	/**
	 * set
	 * @param issuedId
	 */
	public void setIssuedId(int issuedId) {
		this.issuedId = issuedId;
	}

	/**
	 * get
	 * @return
	 */
	public String getMorningType() {
		return morningType;
	}

	/**
	 * set
	 * @param morningType
	 */
	public void setMorningType(String morningType) {
		this.morningType = morningType;
	}

	/**
	 * get
	 * @return
	 */
	public Date getLearnDate() {
		return learnDate;
	}

	/**
	 * set
	 * @param learnDate
	 */
	public void setLearnDate(Date learnDate) {
		this.learnDate = learnDate;
	}

	/**
	 * get
	 * @return
	 */
	public String getQuoContent() {
		return quoContent;
	}

	/**
	 * set
	 * @param quoContent
	 */
	public void setQuoContent(String quoContent) {
		this.quoContent = quoContent;
	}

	/**
	 * get
	 * @return
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * set
	 * @param divisionName
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * get
	 * @return
	 */
	public String getTaTitleContent() {
		return taTitleContent;
	}

	/**
	 * set
	 * @param taTitleContent
	 */
	public void setTaTitleContent(String taTitleContent) {
		this.taTitleContent = taTitleContent;
	}

	/**
	 * get
	 * @return
	 */
	public String getTaContent() {
		return taContent;
	}

	/**
	 * set
	 * @param taContent
	 */
	public void setTaContent(String taContent) {
		this.taContent = taContent;
	}

	/**
	 * get
	 * @return
	 */
	public String getBuTitleContent() {
		return buTitleContent;
	}

	/**
	 * set
	 * @param buTitleContent
	 */
	public void setBuTitleContent(String buTitleContent) {
		this.buTitleContent = buTitleContent;
	}

	/**
	 * get
	 * @return
	 */
	public String getBuContent() {
		return buContent;
	}

	/**
	 * set
	 * @param buContent
	 */
	public void setBuContent(String buContent) {
		this.buContent = buContent;
	}

	/**
	 * get
	 * @return
	 */
	public String getJiaoTitleContent() {
		return jiaoTitleContent;
	}

	/**
	 * set
	 * @param jiaoTitleContent
	 */
	public void setJiaoTitleContent(String jiaoTitleContent) {
		this.jiaoTitleContent = jiaoTitleContent;
	}

	/**
	 * get
	 * @return
	 */
	public String getJiaoContent() {
		return jiaoContent;
	}

	/**
	 * set
	 * @param jiaoContent
	 */
	public void setJiaoContent(String jiaoContent) {
		this.jiaoContent = jiaoContent;
	}

	/**
	 * get
	 * @return
	 */
	public int getTaStatus() {
		return taStatus;
	}

	/**
	 * set
	 * @param taStatus
	 */
	public void setTaStatus(int taStatus) {
		this.taStatus = taStatus;
	}

	/**
	 * get
	 * @return
	 */
	public int getBuStatus() {
		return buStatus;
	}

	/**
	 * set
	 * @param buStatus
	 */
	public void setBuStatus(int buStatus) {
		this.buStatus = buStatus;
	}

	/**
	 * get
	 * @return
	 */
	public int getJiaoStatus() {
		return jiaoStatus;
	}

	/**
	 * set
	 * @param jiaoStatus
	 */
	public void setJiaoStatus(int jiaoStatus) {
		this.jiaoStatus = jiaoStatus;
	}

	/**
	 * get
	 * @return
	 */
	public int getFinishLearn() {
		return (buStatus + taStatus + jiaoStatus == MagicNumber.NUM3) ? 1 : 0;
	}

	/**
	 * set
	 * @param finishLearn
	 */
	public void setFinishLearn(int finishLearn) {
		this.finishLearn = finishLearn;
	}

	/**
	 * get
	 * @return
	 */
	public String getTaTitle() {
		return taTitle;
	}

	/**
	 * set
	 * @param taTitle
	 */
	public void setTaTitle(String taTitle) {
		this.taTitle = taTitle;
	}

	/**
	 * get
	 * @return
	 */
	public String getBuTitle() {
		return buTitle;
	}

	/**
	 * set
	 * @param buTitle
	 */
	public void setBuTitle(String buTitle) {
		this.buTitle = buTitle;
	}

	/**
	 * get
	 * @return
	 */
	public String getJiaoTitle() {
		return jiaoTitle;
	}

	/**
	 * set
	 * @param jiaoTitle
	 */
	public void setJiaoTitle(String jiaoTitle) {
		this.jiaoTitle = jiaoTitle;
	}
}
