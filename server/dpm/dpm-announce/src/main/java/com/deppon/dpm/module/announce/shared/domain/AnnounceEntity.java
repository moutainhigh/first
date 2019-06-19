/**
 * Entity开发规范
 * 1.必须继承com.deppon.foss.framework.entity.BaseEntity
 * 2.类名必须以Entity结尾
 * 3.必须生成serialVersionUID
 * 4.建议属性名称与数据库字段命名规则一致
 */
package com.deppon.dpm.module.announce.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 公告表实体
 * 
 * @author 045925
 * 
 */
public class AnnounceEntity extends BaseEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 公告类型(ANNOUNCE:任免公告;NEWS:动态新闻;LEADER_NOTES:高管随笔)
	 */
	private String type;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 正文内容
	 */
	private String content;
	/**
	 * 收藏数
	 */
	private Integer collectionNum;
	/**
	 * 阅读数
	 */
	private Integer readNum;
	/**
	 * 点赞数
	 */
	private Integer praiseNum;
	/**
	 * 正文图片路径
	 */
	private String attachmentPath;
	/**
	 * 创建人工号
	 */
	private String createUserCode;
	/**
	 * 创建人
	 */
	private String createUserName;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;
	/**
	 * 修改人工号
	 */
	private String modifyUserCode;
	/**
	 * 修改人
	 */
	private String modifyUserName;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 状态值(用来显示是否已经点赞状态 用于返回界面进行判断)
	 */
	private String praiseStatus;
	/**
	 * 状态值(用来显示是否已经收藏状态 用于返回界面进行判断)
	 */
	private String collectionStatus;
	/**
	 * 显示发布时间
	 */
	private String pubTimeStr;
	/**
	 * 滚动图片路径
	 */
	private String srcollImagPath;
	/**
	 * OAID
	 */
	private String oaId;
	/**
	 * 正文图片名称
	 */
	private String conImgName;
	/**
	 * 滚动图片名称
	 */
	private String scrollImgName;
	/**
	 * app正文图片路径
	 */
	private String appConImgPath;
	/**
	 * app滚动图片路径
	 */
	private String appScrollImgPath;

	// get
	public String getType() {
		return type;
	}

	// set
	public void setType(String type) {
		this.type = type;
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
	public Date getPublishTime() {
		return publishTime;
	}

	// set
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	// get
	public String getContent() {
		return content;
	}

	// set
	public void setContent(String content) {
		this.content = content;
	}

	// get
	public Integer getCollectionNum() {
		return collectionNum;
	}

	// set
	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}

	// get
	public Integer getReadNum() {
		return readNum;
	}

	// set
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	// get
	public Integer getPraiseNum() {
		return praiseNum;
	}

	// set
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	// get
	public String getAttachmentPath() {
		return attachmentPath;
	}

	// set
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
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
	public String getModifyUserCode() {
		return modifyUserCode;
	}

	// set
	public void setModifyUserCode(String modifyUserCode) {
		this.modifyUserCode = modifyUserCode;
	}

	// get
	public String getModifyUserName() {
		return modifyUserName;
	}

	// set
	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	// get
	public Date getModifyTime() {
		return modifyTime;
	}

	// set
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	// get
	public String getPraiseStatus() {
		return praiseStatus;
	}

	// set
	public void setPraiseStatus(String praiseStatus) {
		this.praiseStatus = praiseStatus;
	}

	// get
	public String getCollectionStatus() {
		return collectionStatus;
	}

	// set
	public void setCollectionStatus(String collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	// get
	public String getPubTimeStr() {
		return pubTimeStr;
	}

	// set
	public void setPubTimeStr(String pubTimeStr) {
		this.pubTimeStr = pubTimeStr;
	}

	// get
	public String getSrcollImagPath() {
		return srcollImagPath;
	}

	// set
	public void setSrcollImagPath(String srcollImagPath) {
		this.srcollImagPath = srcollImagPath;
	}

	// get
	public String getOaId() {
		return oaId;
	}

	// set
	public void setOaId(String oaId) {
		this.oaId = oaId;
	}

	// get
	public String getConImgName() {
		return conImgName;
	}

	// set
	public void setConImgName(String conImgName) {
		this.conImgName = conImgName;
	}

	// get
	public String getScrollImgName() {
		return scrollImgName;
	}

	// set
	public void setScrollImgName(String scrollImgName) {
		this.scrollImgName = scrollImgName;
	}

	// get
	public String getAppConImgPath() {
		return appConImgPath;
	}

	// set
	public void setAppConImgPath(String appConImgPath) {
		this.appConImgPath = appConImgPath;
	}

	// get
	public String getAppScrollImgPath() {
		return appScrollImgPath;
	}

	// set
	public void setAppScrollImgPath(String appScrollImgPath) {
		this.appScrollImgPath = appScrollImgPath;
	}

	/**
	 * 重写toString
	 */
	public String toString() {
		return JSON.toJSONString(this);
	}
}