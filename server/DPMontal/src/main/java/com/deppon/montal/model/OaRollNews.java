package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  滚动新闻
 * @author yin
 *
 */
public class OaRollNews {

	/**公告ID*/
	private BigDecimal ggid;
	
	/**发布者*/
	private String fbr;
	
	/**图片说明**/
	private String tpsm;
	
	/**发布日期**/
	private Date fbdate;
	
	/**保存日期**/
	private Date savedate;
	
	/**公告标题**/
	private String header;
	
	/**公告图片文件名称**/
	private String filename;
	
	/**点击记录**/
	private BigDecimal ckbh;
	
	/**内容**/
	private String content;

	public BigDecimal getGgid() {
		return ggid;
	}

	public void setGgid(BigDecimal ggid) {
		this.ggid = ggid;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFbr() {
		return fbr;
	}

	public void setFbr(String fbr) {
		this.fbr = fbr;
	}

	public String getTpsm() {
		return tpsm;
	}

	public void setTpsm(String tpsm) {
		this.tpsm = tpsm;
	}

	public Date getFbdate() {
		return fbdate;
	}

	public void setFbdate(Date fbdate) {
		this.fbdate = fbdate;
	}

	public Date getSavedate() {
		return savedate;
	}

	public void setSavedate(Date savedate) {
		this.savedate = savedate;
	}

	public BigDecimal getCkbh() {
		return ckbh;
	}

	public void setCkbh(BigDecimal ckbh) {
		this.ckbh = ckbh;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
