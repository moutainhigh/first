package com.deppon.dpm.module.common.shared.domain;

import java.io.File;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 欢迎页属性
 * 
 * @date 2015-08-22
 * @author 231586
 * 
 */
public class WelcomePageEntity extends BaseEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4965996046649633247L;
	/**
	 * 新建的引导页ID
	 */
	private String id;
	/**
	 * 主题
	 */
	private String subject;
	/**
	 * 图片文件
	 */
	private File file;
	/**
	 * 文件名称
	 */
	private String fileFileName;
	/**
	 * 开始时间
	 */
	private Date startDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	/**
	 * 操作时间
	 */
	private Date operateTime;
	/**
	 * 链接
	 */
	private String link;
	/**
	 * 是否超时
	 */
	private boolean timeOut;
	/**
	 * 显示时间 s
	 */
	private int existTime;

	/**
	 * get
	 */
	public String getId() {
		return id;
	}

	/**
	 * set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get
	 * 
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * set
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public File getFile() {
		return file;
	}

	/**
	 * set
	 * 
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFileFileName() {
		return fileFileName;
	}

	/**
	 * set
	 * 
	 * @param fileFileName
	 */
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * set
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * set
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getOperateTime() {
		return operateTime;
	}

	/**
	 * set
	 * 
	 * @param operateTime
	 */
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLink() {
		return link;
	}

	/**
	 * set
	 * 
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isTimeOut() {
		return timeOut;
	}

	/**
	 * set
	 * 
	 * @param timeOut
	 */
	public void setTimeOut(boolean timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getExistTime() {
		return existTime;
	}

	/**
	 * set
	 * 
	 * @param existTime
	 */
	public void setExistTime(int existTime) {
		this.existTime = existTime;
	}
}
