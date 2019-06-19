package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 文件上传实体bean
 * @author Work Flow System
 * @Date 2013-09-13 19:58:24
 */
public class Fileupload implements Serializable {
	
	/** 
	 * The Constant serialVersionUID. 
	 * */
	private static final long serialVersionUID = 1L;

	/**
	 *  The fileId 
	 *  */
	private String fileId;
	/**
	 *  The fileName 
	 *  */
	private String fileName;
	/** 
	 * The fileNewName 
	 * */
	private String fileNewName;
	/** 
	 * The filePath 
	 * */
	private String filePath;
	/** 
	 * The fileSize 
	 * */
	private BigDecimal fileSize;
	/** 
	 * The fileType 
	 * */
	private String fileType;
	/** 
	 * The fileTime 
	 * */
	private Date fileTime;
	/** 
	 * The operatorid 
	 * */
	private String operatorid;
	/** 
	 * The operatorname 
	 * */
	private String operatorname;
	/** 
	 * The busino 
	 * */
	private String busino;
	/** 
	 * The groupId 
	 * */
	private String groupId;
	/** 
	 * The reserveOne 
	 * */
	private Long reserveOne;
	/** 
	 * The reserveTwo 
	 * */
	private String reserveTwo;
	/** 
	 * The reserveThree 
	 * */
	private String reserveThree;
	
	/**
	* Gets the fileId.
	*
	* @return the fileId.
	*/
	public String getFileId() {
		return fileId;
	}

	/**
	* Sets the fileId.
	*
	* @param fileId the new fileId.
	*/
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	* Gets the fileName.
	*
	* @return the fileName.
	*/
	public String getFileName() {
		return fileName;
	}

	/**
	* Sets the fileName.
	*
	* @param fileName the new fileName.
	*/
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	* Gets the fileNewName.
	*
	* @return the fileNewName.
	*/
	public String getFileNewName() {
		return fileNewName;
	}

	/**
	* Sets the fileNewName.
	*
	* @param fileNewName the new fileNewName.
	*/
	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}
	/**
	* Gets the filePath.
	*
	* @return the filePath.
	*/
	public String getFilePath() {
		return filePath;
	}

	/**
	* Sets the filePath.
	*
	* @param filePath the new filePath.
	*/
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * @return the fileSize
	 */
	public BigDecimal getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	/**
	* Gets the fileType.
	*
	* @return the fileType.
	*/
	public String getFileType() {
		return fileType;
	}

	/**
	* Sets the fileType.
	*
	* @param fileType the new fileType.
	*/
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	* Gets the fileTime.
	*
	* @return the fileTime.
	*/
	public Date getFileTime() {
		return fileTime;
	}

	/**
	* Sets the fileTime.
	*
	* @param fileTime the new fileTime.
	*/
	public void setFileTime(Date fileTime) {
		this.fileTime = fileTime;
	}
	/**
	* Gets the operatorid.
	*
	* @return the operatorid.
	*/
	public String getOperatorid() {
		return operatorid;
	}

	/**
	* Sets the operatorid.
	*
	* @param operatorid the new operatorid.
	*/
	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}
	/**
	* Gets the operatorname.
	*
	* @return the operatorname.
	*/
	public String getOperatorname() {
		return operatorname;
	}

	/**
	* Sets the operatorname.
	*
	* @param operatorname the new operatorname.
	*/
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	/**
	* Gets the busino.
	*
	* @return the busino.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* Sets the busino.
	*
	* @param busino the new busino.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	* Gets the groupId.
	*
	* @return the groupId.
	*/
	public String getGroupId() {
		return groupId;
	}

	/**
	* Sets the groupId.
	*
	* @param groupId the new groupId.
	*/
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	* Gets the reserveOne.
	*
	* @return the reserveOne.
	*/
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	* Sets the reserveOne.
	*
	* @param reserveOne the new reserveOne.
	*/
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}
	/**
	* Gets the reserveTwo.
	*
	* @return the reserveTwo.
	*/
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	* Sets the reserveTwo.
	*
	* @param reserveTwo the new reserveTwo.
	*/
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	/**
	* Gets the reserveThree.
	*
	* @return the reserveThree.
	*/
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	* Sets the reserveThree.
	*
	* @param reserveThree the new reserveThree.
	*/
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}

}
