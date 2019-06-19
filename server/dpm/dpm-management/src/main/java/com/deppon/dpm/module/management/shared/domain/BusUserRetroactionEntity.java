package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ClassName: BusUserRetroactionEntity
 * </p>
 * <p>
 * Description: 班车用户评价实体类
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-27
 * </p>
 */
public class BusUserRetroactionEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * Field id: 主键id
	 * </p>
	 */
	private int id;
	/**
	 * <p>
	 * Field userNo: 用户工号
	 * </p>
	 */
	private String userNo;
	/**
	 * <p>
	 * Field userScore: 用户评分
	 * </p>
	 */
	private int userScore;
	/**
	 * <p>
	 * Field content: 评论内容
	 * </p>
	 */
	private String content;
	/**
	 * <p>
	 * Field photo: 图片
	 * </p>
	 */
	private String photo;
	
	/**
	 * 图片2
	 */
	private String photo1;
	
	/**
	 * 图片3
	 */
	private String photo2;
	
	/**
	 * 图片4
	 */
	private String photo3;
	
	/**
	 * 图片5
	 */
	private String photo4;
	
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * <p>
	 * Field createDate: 创建时间
	 * </p>
	 */
	private Date createDate;
	
	/**
	 * 站点名称
	 */
	private String siteName;
	
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getUserScore() {
		return userScore;
	}
	

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public int getDelMark() {
		return delMark;
	}

	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}

	/**
	 * <p>
	 * Field createBy: 创建人
	 * </p>
	 */
	private String createBy;
	/**
	 * <p>
	 * Field delMark: 删除标志位 0未删除，1已删除
	 * </p>
	 */
	private int delMark;

}
