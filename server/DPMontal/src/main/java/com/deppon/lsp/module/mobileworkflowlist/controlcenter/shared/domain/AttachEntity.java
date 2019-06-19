package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

public class AttachEntity {
	//附件名称
	private String fileName;
	//附件大小
	private String filseSize;
	//附件下载地址
	private String fileURL;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilseSize() {
		return filseSize;
	}
	public void setFilseSize(String filseSize) {
		this.filseSize = filseSize;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	
}
