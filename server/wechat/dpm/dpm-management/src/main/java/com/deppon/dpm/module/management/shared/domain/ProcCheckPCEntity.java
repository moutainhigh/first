package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 向PC端推送数据中间插件
 * @author 王亚男
 *
 */
public class ProcCheckPCEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3423067823104645891L;
	
	/**
	 * 营业部code
	 */
	private String navCode;
	/**
	 * 营业部名称
	 */
	private String navName;
	/**
	 * 用户工号
	 */
	private String userNo;
	/**
	 * 明细code
	 */
	private String origItemCode;
	/**
	 * 明细名称
	 */
	private String origItemName;
	/**
	 * 图片1
	 */
	private String imgOne;
	/**
	 * 图片2
	 */
	private String imgTwo;
	/**
	 * 图片3
	 */
	private String imgThree;
	/**
	 * 图片4
	 */
	private String imgFour;
	/**
	 * 图片5
	 */
	private String imgFive;
	/**
	 * 分数
	 */
	private int score;
	/**
	 * 意见
	 */
	private String opinion;
	
	//getter setter
	public String getOpinion() {
		return opinion;
	}
	//getter setter
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	//getter setter
	public int getScore() {
		return score;
	}
	//getter setter
	public void setScore(int score) {
		this.score = score;
	}
	//getter setter
	public String getNavCode() {
		return navCode;
	}
	//getter setter
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}
	//getter setter
	public String getNavName() {
		return navName;
	}
	//getter setter
	public void setNavName(String navName) {
		this.navName = navName;
	}
	//getter setter
	public String getUserNo() {
		return userNo;
	}
	//getter setter
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	//getter setter
	public String getOrigItemCode() {
		return origItemCode;
	}
	//getter setter
	public void setOrigItemCode(String origItemCode) {
		this.origItemCode = origItemCode;
	}
	//getter setter
	public String getOrigItemName() {
		return origItemName;
	}
	//getter setter
	public void setOrigItemName(String origItemName) {
		this.origItemName = origItemName;
	}
	//getter setter
	public String getImgOne() {
		return imgOne;
	}
	//getter setter
	public void setImgOne(String imgOne) {
		this.imgOne = imgOne;
	}
	//getter setter
	public String getImgTwo() {
		return imgTwo;
	}
	//getter setter
	public void setImgTwo(String imgTwo) {
		this.imgTwo = imgTwo;
	}
	//getter setter
	public String getImgThree() {
		return imgThree;
	}
	//getter setter
	public void setImgThree(String imgThree) {
		this.imgThree = imgThree;
	}
	//getter setter
	public String getImgFour() {
		return imgFour;
	}
	//getter setter
	public void setImgFour(String imgFour) {
		this.imgFour = imgFour;
	}
	//getter setter
	public String getImgFive() {
		return imgFive;
	}
	//getter setter
	public void setImgFive(String imgFive) {
		this.imgFive = imgFive;
	}
	
}
