package com.deppon.dpm.store.server.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 榜单表
 * @author XiaoTian
 *
 */
public class StoreList {
	//id
	private Integer listid;
	//营业部名称
	private String deptname;
	//营业部负责人名称
	private String deptlerdername;
	//营业部编号
	private String deptnum;
	//更新时间
    private Date updatetime;
	//排名
	private String ranking;
	//排名上升下降
	private String rankingnum;
	//营业部头像
	private String depticon;
	//营业部分数
	private BigDecimal grade;
	//子任务id
	private Long exeid;
	//主任务状态
	private String taskstatus;
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
	public BigDecimal getGrade() {
		return grade;
	}
	/**
	 * 
	 * @param grade
	 */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getListid() {
		return listid;
	}
	/**
	 * 
	 * @param listid
	 */
	public void setListid(Integer listid) {
		this.listid = listid;
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
    public String getRanking() {
        return ranking;
    }
    /**
     * 
     * @param ranking
     */
    public void setRanking(String ranking) {
        this.ranking = ranking == null ? null : ranking.trim();
    }
    /**
     * 
     * @return
     */
    public String getRankingnum() {
        return rankingnum;
    }
    /**
     * 
     * @param rankingnum
     */
    public void setRankingnum(String rankingnum) {
        this.rankingnum = rankingnum == null ? null : rankingnum.trim();
    }
    /**
     * 
     * @return
     */
    public String getDepticon() {
        return depticon;
    }
    /**
     * 
     * @param depticon
     */
    public void setDepticon(String depticon) {
        this.depticon = depticon == null ? null : depticon.trim();
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
	public String getTaskstatus() {
		return taskstatus;
	}
	/**
	 * 
	 * @param taskstatus
	 */
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public Long getExeid() {
		return exeid;
	}
	public void setExeid(Long exeid) {
		this.exeid = exeid;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}