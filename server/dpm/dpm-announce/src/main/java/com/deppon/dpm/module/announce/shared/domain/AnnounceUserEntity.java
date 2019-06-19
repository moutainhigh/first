/**
 * Entity开发规范
 * 1.必须继承com.deppon.foss.framework.entity.BaseEntity
 * 2.类名必须以Entity结尾
 * 3.必须生成serialVersionUID
 * 4.建议属性名称与数据库字段命名规则一致
 */
package com.deppon.dpm.module.announce.shared.domain;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: AnnounceUserEntity
 * @Description: 公告用户实体
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午4:48:49
 * 
 */
public class AnnounceUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	// 公告id
	private String id;
	// 类型(COLLECTION:收藏;PRAISE:点赞;READ:阅读)
	private String type;
	// 用户工号
	private String empCode;
	// 公告ID
	private String appAnnounceId;
	// 标题
	private String title;
	// 创建人工号
	private String createUserCode;
	// 创建人
	private String createUserName;
	// 创建时间
	private Date createTime;
	// 公告类型
	private String announceType;
	// 显示发布时间
	private String pubTimeStr;

	// get
	public String getType() {
		return type;
	}

	// set
	public void setType(String type) {
		this.type = type;
	}

	// get
	public String getEmpCode() {
		return empCode;
	}

	// set
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	// get
	public String getAppAnnounceId() {
		return appAnnounceId;
	}

	// set
	public void setAppAnnounceId(String appAnnounceId) {
		this.appAnnounceId = appAnnounceId;
	}

	// get
	public String getCreateUserCode() {
		return createUserCode;
	}

	// set
	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	// get
	public String getCreateUserName() {
		return createUserName;
	}

	// set
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	// get
	public Date getCreateTime() {
		return createTime;
	}

	// set
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// get
	public String getId() {
		return id;
	}

	// set
	public void setId(String id) {
		this.id = id;
	}

	// get
	public String getTitle() {
		return title;
	}

	// set
	public void setTitle(String title) {
		this.title = title;
	}

	// get
	public String getAnnounceType() {
		return announceType;
	}

	// set
	public void setAnnounceType(String announceType) {
		this.announceType = announceType;
	}

	// get
	public String getPubTimeStr() {
		return pubTimeStr;
	}

	// set
	public void setPubTimeStr(String pubTimeStr) {
		this.pubTimeStr = pubTimeStr;
	}

	/**
	 * 重写toString方法
	 */
	public String toString() {
		return JSON.toJSONString(this);
	}
}