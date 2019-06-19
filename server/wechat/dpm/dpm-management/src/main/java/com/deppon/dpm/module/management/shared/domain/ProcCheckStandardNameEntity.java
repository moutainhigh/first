package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 268101
 * ProcCheckStandardNameEntity 实体类
 *
 */
public class ProcCheckStandardNameEntity implements Serializable{
	
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *门店地址
	 */
	private String addressCode;
	/**
	 * 打分数据
	 */
	private String standardName;
	/**
	 * 导航栏code
	 */
	private String navCode;
	/**
	 * 检查项code
	 */
	private String origItemCode;
	/**
	 * 已选
	 */
	private String selectItem;
	/**
	 * 未选择
	 */
	private String unSelectItem;
	/**
	 * 状态
	 */
	private int submitNub;
	/**
	 * 图片一
	 */
	private String imgOne;
	/**
	 * 图片二
	 */
	private String imgTwo;
	/**
	 * 图片三
	 */
	private String imgThree;
	/**
	 * 图片四
	 */
	private String imgFour;
	/**
	 * 图片五
	 */
	private String imgFive;
	/**
	 * 验收意见
	 */
	private String opinion;
	
	/**
	 * 是否提交PC
	 */
	private String isSubmit;
	
	
	/**
	 * @return 是否提交PC
	 */
	public String getIsSubmit() {
		return isSubmit;
	}

	/**
	 * @param isSubmit 是否提交PC
	 */
	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	/**
	 * @return 打分数据
	 */
	public String getStandardName() {
		return standardName;
	}

	/**
	 * @param standardName 打分数据
	 */
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	/**
	 * @return 检查项code
	 */
	public String getOrigItemCode() {
		return origItemCode;
	}

	/**
	 * @param origItemCode 检查项code
	 */
	public void setOrigItemCode(String origItemCode) {
		this.origItemCode = origItemCode;
	}

	/**
	 * @return 导航栏code
	 */
	public String getNavCode() {
		return navCode;
	}

	/**
	 * @param navCode 导航栏code
	 */
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}

	/**
	 * @return 已选
	 */
	public String getSelectItem() {
		return selectItem;
	}

	/**
	 * @param selectItem 已选
	 */
	public void setSelectItem(String selectItem) {
		this.selectItem = selectItem;
	}

	/**
	 * @return 未选择
	 */
	public String getUnSelectItem() {
		return unSelectItem;
	}

	/**
	 * @param unSelectItem 未选择
	 */
	public void setUnSelectItem(String unSelectItem) {
		this.unSelectItem = unSelectItem;
	}

	/**
	 * @return 状态
	 */
	public int getSubmitNub() {
		return submitNub;
	}

	/**
	 * @param submitNub 状态
	 */ 
	public void setSubmitNub(int submitNub) {
		this.submitNub = submitNub;
	}

	/**
	 * @return 门店地址
	 */
	public String getAddressCode() {
		return addressCode;
	}

	/**
	 * @param addressCode 门店地址
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	/**
	 * @return 图片1
	 */
	public String getImgOne() {
		return imgOne;
	}

	/**
	 * @param imgOne 图片1
	 */
	public void setImgOne(String imgOne) {
		this.imgOne = imgOne;
	}

	/**
	 * @return 图片2
	 */
	public String getImgTwo() {
		return imgTwo;
	}

	/**
	 * @param imgTwo 图片2
	 */
	public void setImgTwo(String imgTwo) {
		this.imgTwo = imgTwo;
	}

	/**
	 * @return  图片3
	 */
	public String getImgThree() {
		return imgThree;
	}

	/**
	 * @param imgThree 图片3
	 */
	public void setImgThree(String imgThree) {
		this.imgThree = imgThree;
	}

	/**
	 * @return 图片4
	 */
	public String getImgFour() {
		return imgFour;
	}

	/**
	 * @param imgFour 图片4
	 */
	public void setImgFour(String imgFour) {
		this.imgFour = imgFour;
	}

	/**
	 * @return 图片5
	 */
	public String getImgFive() {
		return imgFive;
	}

	/**
	 * @param imgFive 图片5
	 */
	public void setImgFive(String imgFive) {
		this.imgFive = imgFive;
	}

	/**
	 * @return 验收意见
	 */
	public String getOpinion() {
		return opinion;
	}

	/**
	 * @param opinion 验收意见
	 */ 
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
    
}
