package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 基础信息表
 * @author 
 *
 */
public class ProcCheckScoreEntity implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * proc_check_record表ID
	 */
	private String recordid;
	/**
	 * 导航栏
	 */
	private String navName;
	/**
	 * 导航栏编码
	 */
	private String navCode;
	/**
	 * 门店地址	
	 */	
	private String address;
	/*
	 * 门店地址Code
	 */
	private String addressCode;
	/**
	 * 员工号	
	 */	
	private String userNo;
	/**
	 * 时间
	 */	
	private Date checkDate;
	
	/**
	 * 打分次数	
	 */	
	private int  submitNub;

	/**
	 * 检测方法	
	 */	
	private String  checkMethod;
	/**
	 * 是否重点检查	
	 */	
	private  String  isKeyPro;


	

	
	/**
	 * 打分表ID	
	 */
	private String scoreid;
	/**
	 * 记录表ID	
	 */
	private String checkrecordId;
	/**
	 * 评分名称
	 */
	private String origItemName;
	/**
	 * 评分ID
	 */
	private String origItemCode;
	/**
	 * 分数	
	 */
	private int score;
	/**
	 * 意见
	 */
	private String opinion;
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
	 * 打分表创建时间
	 */
	private Date scorecreateDate;	
	/**
	 * selectItem
	 */
	private String selectItem;
	/**
	 * 未选中项
	 */
	private String unSelectItem;
	/**
	 * 基础分数
	 */
	private int	staticScore;
	

	public String getSelectItem() {
		return selectItem;
	}
	public void setSelectItem(String selectItem) {
		this.selectItem = selectItem;
	}
	/**
	 * @return 未选中项
	 */
	public String getUnSelectItem() {
		return unSelectItem;
	}
	/**
	 * @param unSelectItem 未选中项
	 */
	public void setUnSelectItem(String unSelectItem) {
		this.unSelectItem = unSelectItem;
	}

	/**
	 * 总扣分分数
	 */
	private int totalScore;
	/**
	 * 扣分的个数
	 */
	private int  pointsItem;
	/*
	 * 门店检查状态
	 */
	private int branchIsCheck;
	
    /*
     * 初次分数
     */
	private String fristScore; 		
	/*
     * 最终分数
     */
	private String endScore;

	/**
	 * @return proc_check_record表ID
	 */
	public String getRecordid() {
		return recordid;
	}
	/**
	 * @param recordid proc_check_record表ID
	 */
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
	/**
	 * @return 导航栏
	 */
	public String getNavName() {
		return navName;
	}
	/**
	 * @param navName 导航栏
	 */
	public void setNavName(String navName) {
		this.navName = navName;
	}
	/**
	 * @return 导航栏编码
	 */
	public String getNavCode() {
		return navCode;
	}
	/**
	 * @param navCode 导航栏编码
	 */
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}
	/**
	 * @return 门店地址	
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 门店地址	
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return 门店地址Code
	 */
	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * @param addressCode  门店地址Code
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	/**
	 * @return 员工号	
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo 员工号	
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return 时间
	 */
	public Date getCheckDate() {
		return checkDate;
	}
	/**
	 * @param checkDate 时间
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	/**
	 * @return 打分次数	
	 */
	public int getSubmitNub() {
		return submitNub;
	}
	/**
	 * @param submitNub 打分次数	
	 */
	public void setSubmitNub(int submitNub) {
		this.submitNub = submitNub;
	}
	/**
	 * @return 是否重点检查	
	 */
	public String getIsKeyPro() {
		return isKeyPro;
	}
	/**
	 * @param isKeyPro 是否重点检查	
	 */
	public void setIsKeyPro(String isKeyPro) {
		this.isKeyPro = isKeyPro;
	}
	/**
	 * @return 检测方法	
	 */
	public String getCheckMethod() {
		return checkMethod;
	}
	/**
	 * @param checkMethod 检测方法	
	 */
	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}
	/**
	 * @return 打分表ID	
	 */
	public String getScoreid() {
		return scoreid;
	}
	/**
	 * @param scoreid 打分表ID	
	 */
	public void setScoreid(String scoreid) {
		this.scoreid = scoreid;
	}
	/**
	 * @return 记录表ID	
	 */
	public String getCheckrecordId() {
		return checkrecordId;
	}
	/**
	 * @param checkrecordId 记录表ID	
	 */
	public void setCheckrecordId(String checkrecordId) {
		this.checkrecordId = checkrecordId;
	}
	/**
	 * @return 评分名称
	 */
	public String getOrigItemName() {
		return origItemName;
	}
	/**
	 * @param origItemName 评分名称
	 */
	public void setOrigItemName(String origItemName) {
		this.origItemName = origItemName;
	}
	public String getOrigItemCode() {
		return origItemCode;
	}
	public void setOrigItemCode(String origItemCode) {
		this.origItemCode = origItemCode;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getImgOne() {
		return imgOne;
	}
	public void setImgOne(String imgOne) {
		this.imgOne = imgOne;
	}
	public String getImgTwo() {
		return imgTwo;
	}
	public void setImgTwo(String imgTwo) {
		this.imgTwo = imgTwo;
	}
	public String getImgThree() {
		return imgThree;
	}
	public void setImgThree(String imgThree) {
		this.imgThree = imgThree;
	}
	public String getImgFour() {
		return imgFour;
	}
	public void setImgFour(String imgFour) {
		this.imgFour = imgFour;
	}
	public String getImgFive() {
		return imgFive;
	}
	public void setImgFive(String imgFive) {
		this.imgFive = imgFive;
	}
	public Date getScorecreateDate() {
		return scorecreateDate;
	}
	public void setScorecreateDate(Date scorecreateDate) {
		this.scorecreateDate = scorecreateDate;
	}


	/**
	 * @return 基础分数
	 */
	public int getStaticScore() {
		return staticScore;
	}
	/**
	 * @param staticScore 基础分数
	 */
	public void setStaticScore(int staticScore) {
		this.staticScore = staticScore;
	}


	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getPointsItem() {
		return pointsItem;
	}
	public void setPointsItem(int pointsItem) {
		this.pointsItem = pointsItem;
	}
	public int getBranchIsCheck() {
		return branchIsCheck;
	}
	public void setBranchIsCheck(int branchIsCheck) {
		this.branchIsCheck = branchIsCheck;
	}
	public String getFristScore() {
		return fristScore;
	}
	public void setFristScore(String fristScore) {
		this.fristScore = fristScore;
	}
	public String getEndScore() {
		return endScore;
	}
	public void setEndScore(String endScore) {
		this.endScore = endScore;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	//组装
	public String toString() {
		return "ProcCheckScoreEntity [recordid=" + recordid + ", navName="
				+ navName + ", navCode=" + navCode + ", address=" + address
				+ ", addressCode=" + addressCode + ", userNo=" + userNo
				+ ", checkDate=" + checkDate + ", submitNub=" + submitNub
				+ ", isKeyPro=" + isKeyPro + ", checkMethod=" + checkMethod
				+ ", scoreid=" + scoreid + ", checkrecordId=" + checkrecordId
				+ ", origItemName=" + origItemName + ", origItemCode="
				+ origItemCode + ", score=" + score + ", opinion=" + opinion
				+ ", imgOne=" + imgOne + ", imgTwo=" + imgTwo + ", imgThree="
				+ imgThree + ", imgFour=" + imgFour + ", imgFive=" + imgFive
				+ ", scorecreateDate=" + scorecreateDate + ", selectItem="
				+ selectItem + ", unSelectItem=" + unSelectItem
				+ ", totalScore=" + totalScore + ", pointsItem=" + pointsItem
				+ ", branchIsCheck=" + branchIsCheck + ", fristScore="
				+ fristScore + ", endScore=" + endScore + "]";
	}

	
	
}
