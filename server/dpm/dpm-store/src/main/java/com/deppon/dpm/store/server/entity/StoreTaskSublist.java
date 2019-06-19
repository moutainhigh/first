package com.deppon.dpm.store.server.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author XiaoTian
 *
 */
public class StoreTaskSublist {
	/**
	 * 
	 */
	public StoreTaskSublist() {
		
	}
	/**
	 * 执行人id 和 状态
	 * @param exeid
	 * @param taskstatus
	 */
	public StoreTaskSublist(Long exeid, String taskstatus, BigDecimal retaingrade,Date appraisaltime) {
		this.exeid = exeid;
		this.taskstatus = taskstatus;
		this.testgrade = retaingrade;
		this.appraisaltime = appraisaltime;
	}

	/**
	 * 执行id
	 */
	private Long exeid;
	/**
	 * 任务id
	 */
	private Integer taskid;
	/**
	 * 执行人
	 */
	private String exeer;
	/**
	 * 营业部名称
	 */
	private String deptname;
	/**
	 * 自检得分
	 */
	private BigDecimal testgrade;
	/**
	 * 营业部负责人名称
	 */
	private String deptlerdername;
	/**
	 * 点赞数量
	 */
	private Long likenum;
	/**
	 * 警告数量
	 */
	private Long warningnum;
	/**
	 * 开始时间
	 */
	private Date starttime;
	/**
	 * 结束时间
	 */
	private Date endtime;
	/**
	 * 营业部编号
	 */
	private String deptnum;
	/**
	 * 审核得分
	 */
	private BigDecimal checkgrade;
	/**
	 * 任务状态
	 */
	private String taskstatus;
	/**
	 * 反馈提交时间
	 */
	private Date submittime;
	/**
	 * 考评提交时间
	 * 
	 */
	private Date appraisaltime;
	/**
	 * 执行人工号
	 */
	private String exeerid;
	/**
	 * 部门负责人id
	 */
	private String deptapid;
	/**
	 * 部门负责人名扯
	 */
	private String deptapname;
	/**
	 * 自定义记录状态
	 */
	private Integer dr;
	/**
	 * 自定义时间
	 */
	private Date ts;
	/**
     * 自定义项
     */
    private CustomNape customNape;
    /**
     * 
     * @return
     */
    public CustomNape getCustomNape() {
		return customNape;
	}
    /**
     * 
     * @param customNape
     */
	public void setCustomNape(CustomNape customNape) {
		this.customNape = customNape;
	}
	/**
	 * 
	 * @return
	 */
	public Long getExeid() {
		return exeid;
	}
	/**
	 * 
	 * @param exeid
	 */
	public void setExeid(Long exeid) {
		this.exeid = exeid;
	}
	/**
	 * 
	 * @return
	 */
	public BigDecimal getCheckgrade() {
		return checkgrade;
	}
	/**
	 * 
	 * @return
	 */
    public Integer getTaskid() {
		return taskid;
	}
    /**
     * 
     * @param taskid
     */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	/**
     * 
     * @return
     */
    public String getExeer() {
        return exeer;
    }
    /**
     * 
     * @param exeer
     */
    public void setExeer(String exeer) {
        this.exeer = exeer == null ? null : exeer.trim();
    }
    /**
     * 
     * @return
     */
    public String getDeptname() {
        return deptname;
    }
    /**
     * 
     * @param deptname
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }
    /**
     * 
     * @return
     */
    public BigDecimal getTestgrade() {
		return testgrade;
	}
    /**
     * 
     * @param testgrade
     */
	public void setTestgrade(BigDecimal testgrade) {
		this.testgrade = testgrade;
	}
	/**
	 * 
	 * @param checkgrade
	 */
	public void setCheckgrade(BigDecimal checkgrade) {
		this.checkgrade = checkgrade;
	}
	/**
     * 
     * @return
     */
    public String getDeptlerdername() {
        return deptlerdername;
    }
    /**
     * 
     * @param deptlerdername
     */
    public void setDeptlerdername(String deptlerdername) {
        this.deptlerdername = deptlerdername == null ? null : deptlerdername.trim();
    }
    /**
     * 
     * @return
     */
    public Long getLikenum() {
        return likenum;
    }
    /**
     * 
     * @param likenum
     */
    public void setLikenum(Long likenum) {
        this.likenum = likenum;
    }
    /**
     * 
     * @return
     */
    public Long getWarningnum() {
        return warningnum;
    }
    /**
     * 
     * @param warningnum
     */
    public void setWarningnum(Long warningnum) {
        this.warningnum = warningnum;
    }
   
    /**
     * 
     * @return
     */
    public String getDeptnum() {
        return deptnum;
    }
    /**
     * 
     * @param deptnum
     */
    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum == null ? null : deptnum.trim();
    }
    /**
     * 
     * @return
     */
    public String getTaskstatus() {
        return taskstatus;
    }
    /**
     * 
     * @param taskstatus
     */
    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus == null ? null : taskstatus.trim();
    }
    /**
     * 
     * @return
     */
    public Integer getDr() {
        return dr;
    }
    /**
     * 
     * @param dr
     */
    public void setDr(Integer dr) {
        this.dr = dr;
    }
    /**
     * 
     * @return
     */
	public Date getTs() {
		return ts;
	}
	/**
	 * 
	 * @param ts
	 */
	public void setTs(Date ts) {
		this.ts = ts;
	}
	/**
	 * 
	 * @return
	 */
	public String getExeerid() {
		return exeerid;
	}
	/**
	 * 
	 * @param exeerid
	 */
	public void setExeerid(String exeerid) {
		this.exeerid = exeerid;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptapid() {
		return deptapid;
	}
	/**
	 * 
	 * @param deptapid
	 */
	public void setDeptapid(String deptapid) {
		this.deptapid = deptapid;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptapname() {
		return deptapname;
	}
	/**
	 * 
	 * @param deptapname
	 */
	public void setDeptapname(String deptapname) {
		this.deptapname = deptapname;
	}
	
	@Override
	public String toString() {
		return "StoreTaskSublist [exeid=" + exeid + ", taskid=" + taskid
				+ ", exeer=" + exeer + ", deptname=" + deptname
				+ ", testgrade=" + testgrade + ", deptlerdername="
				+ deptlerdername + ", likenum=" + likenum + ", warningnum="
				+ warningnum + ", starttime=" + starttime + ", endtime="
				+ endtime + ", deptnum=" + deptnum + ", checkgrade="
				+ checkgrade + ", taskstatus=" + taskstatus + ", submittime="
				+ submittime + ", exeerid=" + exeerid + ", deptapid="
				+ deptapid + ", dr=" + dr + "]";
	}
	/**
	 * 
	 * @return
	 */
	public Date getAppraisaltime() {
		return appraisaltime;
	}
	/**
	 * 
	 * @param appraisaltime
	 */
	public void setAppraisaltime(Date appraisaltime) {
		this.appraisaltime = appraisaltime;
	}
	/**
	 * 
	 * @param submittime
	 */
	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}
	/**
	 * 
	 * @return
	 */
	public Date getSubmittime() {
		return submittime;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
    
}