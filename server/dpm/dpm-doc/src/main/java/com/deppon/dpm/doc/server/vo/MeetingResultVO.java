package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

public class MeetingResultVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public MeetingResultVO(){ 
		super();
	}
	//会议开始时间
	private String startdate ;
	//会议结束时间
	private String enddate ;
	//会议名称
	private String subjectname ;
	//会议类型
	private String subjecttype ;
	//会议发起人
	private String sendName ;

	/**
	 * @return the startdate
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * @return the enddate
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * @return the subjectname
	 */
	public String getSubjectname() {
		return subjectname;
	}

	/**
	 * @param subjectname the subjectname to set
	 */
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	/**
	 * @return the subjecttype
	 */
	public String getSubjecttype() {
		return subjecttype;
	}

	/**
	 * @param subjecttype the subjecttype to set
	 */
	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}

	/**
	 * @return the sendName
	 */
	public String getSendName() {
		return sendName;
	}

	/**
	 * @param sendName the sendName to set
	 */
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	
	

}
