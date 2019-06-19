package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页提示
 * @author 
 *
 */
public class DiDiPointVo implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public DiDiPointVo(){
			super();
	}
		
	//备案人ID
	private int id ;//
	//备案人
	private String content ;
	//备案部门
	private String status ;
	//用户头像
	private Date createtime ;
	
	private Date startdate;
	
	private Date enddate;
	
	private String joblevel;
	
	private Date updatetime;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getJoblevel() {
		return joblevel;
	}
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}
