package com.deppon.dpm.store.server.entity;

import java.util.Date;

/**
 * 任务主表实体类
 * @author XiaoTian
 *
 */
public class StoreTask {  
	/**
	 * 任务id
	 */
	private Integer taskid;
	/**
	 * 任务名称
	 */
	private String taskname;
	/**
	 * 任务描述
	 */
	private String taskinfo;
	/**
	 * 创建人编号
	 */
	private String creatorcode;

	/**
	 * 创建人
	 */
	private String creatorname;
	/**
	 * 任务类型
	 */
	private String tasktype;
	/**
	 * 任务开始日期
	 */
	private Date starttime;
	/**
	 * 任务截至日期
	 */
	private Date endtime;
	/**
	 * 设置提醒
	 */
	private Date tasktime;
	/**
	 * 任务状态
	 */
	private String taskstatus;

	/**
	 * 附件
	 */
	private String attachment;
	/**
	 * 完成时间
	 */
	private Date finishtime;
	/**
     * 自定义项
     */
    private CustomNape customNape;
    /**
     * 开始时间,字符串形式
     */
    private String startTime;
    /**
     * 结束时间,字符串形式
     */
    private String endTime;
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

	
	/**用作逾期的属性**/
	private String isoverdue;
	
	private String overdueTime;
	
	/**
     * 组织名称
     */
	private String orgName;
	/**
	 * 创建人职位
	 */
	private String Jobname;
		
	/**
	 * 自定义记录状态
	 */
	private Integer dr;
	/**
	 * 自定义时间
	 */
	private Date ts;
	/**
	 * 
	 */
    private String taskcreator;
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
    public String getTaskname() {
        return taskname;
    }
    /**
     * 
     * @param taskname
     */
    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }
    /**
     * 
     * @return
     */
    public String getTaskinfo() {
        return taskinfo;
    }
    /**
     * 
     * @param taskinfo
     */
    public void setTaskinfo(String taskinfo) {
        this.taskinfo = taskinfo == null ? null : taskinfo.trim();
    }
    /**
     * 
     * @return
     */
    public String getCreatorcode() {
        return creatorcode;
    }
    /**
     * 
     * @param creatorcode
     */
    public void setCreatorcode(String creatorcode) {
        this.creatorcode = creatorcode == null ? null : creatorcode.trim();
    }
    /**
     * 
     * @return
     */
    public String getCreatorname() {
        return creatorname;
    }
    /**
     * 
     * @param creatorname
     */
    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname == null ? null : creatorname.trim();
    }
    /**
     * 
     * @return
     */
    public String getTasktype() {
        return tasktype;
    }
    /**
     * 
     * @param tasktype
     */
    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
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
    public String getAttachment() {
        return attachment;
    }
    /**
     * 
     * @param attachment
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
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
    public String getTaskcreator() {
        return taskcreator;
    }
    /**
     * 
     * @param taskcreator
     */
    public void setTaskcreator(String taskcreator) {
        this.taskcreator = taskcreator == null ? null : taskcreator.trim();
    }
    /**
     * 
     * @return
     */
	public String getIsoverdue() {
		return isoverdue;
	}
	/**
	 * 
	 * @param isoverdue
	 */
	public void setIsoverdue(String isoverdue) {
		this.isoverdue = isoverdue;
	}
	/**
	 * 
	 * @return
	 */
	public String getOverdueTime() {
		return overdueTime;
	}
	/**
	 * 
	 * @param overdueTime
	 */
	public void setOverdueTime(String overdueTime) {
		this.overdueTime = overdueTime;
	}
	/**
	 * 
	 * @return
	 */
	public Date getStarttime() {
		return starttime;
	}
	/**
	 * 
	 * @param starttime
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	/**
	 * 
	 * @return
	 */
	public Date getEndtime() {
		return endtime;
	}
	/**
	 * 
	 * @param endtime
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 * 
	 * @return
	 */
	public Date getTasktime() {
		return tasktime;
	}
	/**
	 * 
	 * @param tasktime
	 */
	public void setTasktime(Date tasktime) {
		this.tasktime = tasktime;
	}
	/**
	 * 
	 * @return
	 */
	public Date getFinishtime() {
		return finishtime;
	}
	/**
	 * 
	 * @param finishtime
	 */
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getJobname() {
		return Jobname;
	}
	public void setJobname(String jobname) {
		Jobname = jobname;
	}
	
	
}