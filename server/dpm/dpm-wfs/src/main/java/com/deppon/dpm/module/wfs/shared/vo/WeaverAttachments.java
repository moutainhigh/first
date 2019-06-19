package com.deppon.dpm.module.wfs.shared.vo;

public class WeaverAttachments {
	/**
	 * 附件id
	 */
	private int docid;
	/**
	 * 附近名字
	 */
	private String filename;
	
	/**
	 * 附件地址
	 */
//	private String filepath;
	/**
	 * set
	 * @param docid
	 */
	public void setDocid(int docid) {
		this.docid = docid;
	}
	/**
	 * get
	 * @return
	 */
	public int getDocid() {
		return docid;
	}
	/**
	 * get
	 * @return
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * set
	 * @param filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * get
	 * @return 
	 *//*
	public String getFilepath() {
		return filepath;
	}
	*//**
	 * set
	 * @param filepath
	 *//*
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}*/
	
	
}
