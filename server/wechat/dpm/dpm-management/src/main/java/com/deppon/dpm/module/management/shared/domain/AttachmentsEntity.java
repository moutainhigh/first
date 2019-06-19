package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.UUID;

/**
 * 
 * @author 王亚男
 * 向PC端推送数据 明细信息--附件
 */
public class AttachmentsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 75433750921415499L;
	
	private static final String IMG_EXT_NAME = ".jpg";
	
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件内容
	 */
	private String fileContent;
	
	/**
	 * 创建人工号
	 */
	private String createrCode;
	
	/**
	 * 修改人工号
	 */
	private String lastUpdaterCode;
	
	
	public AttachmentsEntity(){
		this.fileName = UUID.randomUUID().toString()+IMG_EXT_NAME;
	}
	
	//getter setter
	public String getFileName() {
		return fileName;
	}
	//getter setter
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	//getter setter
	public String getFileContent() {
		return fileContent;
	}
	//getter setter
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	//getter setter
	public String getCreaterCode() {
		return createrCode;
	}
	//getter setter
	public void setCreaterCode(String createrCode) {
		this.createrCode = createrCode;
	}
	//getter setter
	public String getLastUpdaterCode() {
		return lastUpdaterCode;
	}
	//getter setter
	public void setLastUpdaterCode(String lastUpdaterCode) {
		this.lastUpdaterCode = lastUpdaterCode;
	}
	

}
