package com.deppon.dpm.module.management.shared.domain;

/**
 * @author ccf
 * 
 *         AttachmentEntity 实体类
 */
public class AttachmentEntity {
	/**
	 * 附件名称
	 */
	private String fileName;
	/**
	 * 附件内容
	 */
	private String fileContent;

	/**
	 * @return 附件名称
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param 附件名称
	 *
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return 附件内容
	 */
	public String getFileContent() {
		return fileContent;
	}

	/**
	 * @param 附件内容
	 *           
	 */
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

}
