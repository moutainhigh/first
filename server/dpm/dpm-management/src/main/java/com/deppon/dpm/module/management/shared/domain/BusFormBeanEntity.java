package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ClassName: BusFormBeanEntity
 * </p>
 * <p>
 * Description: 辅助获得评价管理和历史反馈数据实体类
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-29
 * </p>
 */
public class BusFormBeanEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * Field openId: 开线建议表主键id
	 * </p>
	 */
	private int openId;
	/**
	 * <p>
	 * Field siteId: 站点主键id
	 * </p>
	 */
	private int siteId;
	/**
	 * <p>
	 * Field openUserNo: 开线建议者的用户工号
	 * </p>
	 */
	private String openUserNo;
	/**
	 * <p>
	 * Field openDate: 开线建议的时间
	 * </p>
	 */
	private Date openDate;
	/**
	 * <p>
	 * Field openStartTime: 把开线建议时间转换为String
	 * </p>
	 */
	private String openStartTime;

	/**
	 * <p>
	 * Field siteName: 站点名称
	 * </p>
	 */
	private String siteName;
	/**
	 * <p>
	 * Field adviceId: 评价管理建议表主键id
	 * </p>
	 */
	private int adviceId;
	/**
	 * <p>
	 * Field openReplyUserNo: 开线建议回复的工号
	 * </p>
	 */
	private String openReplyUserNo;
	/**
	 * <p>
	 * Field replyContent: 开线建议中回复的内容
	 * </p>
	 */
	private String openReplyContent;
	/**
	 * <p>
	 * Field openDelMark: 回复开线建议是否删除标志位
	 * </p>
	 */
	private int openDelMark;
	/**
	 * <p>
	 * Field centreMark: 标志位 (0 代表评价表1建议表)
	 * </p>
	 */
	private int centreMark;
	/**
	 * <p>
	 * Field arrOpenNo: 用户开线建议回复工号数组
	 * </p>
	 */
	private String arrOpenNo[];

	/**
	 * <p>
	 * Field arrAdviceId: 用户开线建议回复主键id数组
	 * </p>
	 */
	private String arrAdviceId[];
	/**
	 * <p>
	 * Field arrOpenContent: 用户开线建议回复内容数组
	 * </p>
	 */
	private String arrOpenContent[];
	/**
	 * <p>
	 * Field arrPhoto: 图片数组
	 * </p>
	 */
	private String arrPhoto[];

	/**
	 * <p>
	 * Field retId: 用户评价表主键id
	 * </p>
	 */
	private int retId;
	/**
	 * <p>
	 * Field userScore: 用户评分
	 * </p>
	 */
	private int userScore;
	/**
	 * <p>
	 * Field photo: 上传的图片
	 * </p>
	 */
	private String photo;
	/**
	 * <p>
	 * Field retrContent: 用户评价内容
	 * </p>
	 */
	private String retrContent;
	/**
	 * <p>
	 * Field manageId: 评价管理评价表id
	 * </p>
	 */
	private int manageId;
	/**
	 * <p>
	 * Field mark: 区分评价和建议标志位
	 * </p>
	 */
	private int mark;
	/**
	 * <p>
	 * Field userName: 用户姓名
	 * </p>
	 */
	private String userName;
	/**
	 * <p>
	 * Field photo: 上传的图片
	 * </p>
	 */
	private String photo1;
	/**
	 * <p>
	 * Field photo: 上传的图片
	 * </p>
	 */
	private String photo2;
	/**
	 * <p>
	 * Field photo: 上传的图片
	 * </p>
	 */
	private String photo3;
	/**
	 * <p>
	 * Field photo: 上传的图片
	 * </p>
	 */
	private String photo4;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getRetId() {
		return retId;
	}

	public void setRetId(int retId) {
		this.retId = retId;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRetrContent() {
		return retrContent;
	}

	public void setRetrContent(String retrContent) {
		this.retrContent = retrContent;
	}

	public int getManageId() {
		return manageId;
	}

	public void setManageId(int manageId) {
		this.manageId = manageId;
	}

	public String[] getArrOpenNo() {
		return arrOpenNo;
	}

	public void setArrOpenNo(String[] arrOpenNo) {
		this.arrOpenNo = arrOpenNo;
	}

	public String[] getArrAdviceId() {
		return arrAdviceId;
	}

	public void setArrAdviceId(String[] arrAdviceId) {
		this.arrAdviceId = arrAdviceId;
	}

	public String[] getArrOpenContent() {
		return arrOpenContent;
	}

	public void setArrOpenContent(String[] arrOpenContent) {
		this.arrOpenContent = arrOpenContent;
	}

	public int getOpenId() {
		return openId;
	}

	public void setOpenId(int openId) {
		this.openId = openId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getOpenUserNo() {
		return openUserNo;
	}

	public void setOpenUserNo(String openUserNo) {
		this.openUserNo = openUserNo;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getAdviceId() {
		return adviceId;
	}

	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}

	public String getOpenReplyUserNo() {
		return openReplyUserNo;
	}

	public void setOpenReplyUserNo(String openReplyUserNo) {
		this.openReplyUserNo = openReplyUserNo;
	}

	public String getOpenReplyContent() {
		return openReplyContent;
	}

	public void setOpenReplyContent(String openReplyContent) {
		this.openReplyContent = openReplyContent;
	}

	public int getOpenDelMark() {
		return openDelMark;
	}

	public void setOpenDelMark(int openDelMark) {
		this.openDelMark = openDelMark;
	}

	public int getCentreMark() {
		return centreMark;
	}

	public void setCentreMark(int centreMark) {
		this.centreMark = centreMark;
	}

	public String getOpenStartTime() {
		return openStartTime;
	}

	public void setOpenStartTime(String openStartTime) {
		this.openStartTime = openStartTime;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	public String[] getArrPhoto() {
		return arrPhoto;
	}

	public void setArrPhoto(String[] arrPhoto) {
		this.arrPhoto = arrPhoto;
	}

}
