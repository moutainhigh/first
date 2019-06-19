package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ClassName: BusMessageEntity
 * </p>
 * <p>
 * Description: 班车消息实体类
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-27
 * </p>
 */
public class BusMessageEntity implements Serializable {

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
	 * Field content: 消息内容
	 * </p>
	 */
	private String content;
	/**
	 * <p>
	 * Field createDate: 创建时间
	 * </p>
	 */
	private Date createDate;
	/**
	 * <p>
	 * Field createDate: 时间String
	 * </p>
	 */
	private String strDate;
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
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}