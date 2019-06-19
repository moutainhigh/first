package com.deppon.dpm.store.server.entity;

import java.util.Date;
/**
 * 点赞信息日志
 * @author XiaoTian
 *
 */
public class StoreLikelog {
	/**
	 * id
	 */
    private Integer likelogid;
    /**
     * 创建人编码（员工号）
     */
    private String creatorcode;
    /**
     * 营业部编号
     */
    private String deptnum;
    /**
     * 时间
     */
    private Date likelogtime;
    /**
     * 类型
     */
    private Integer likelogtype;
    /**
     * 构造器
     */
    
    public StoreLikelog() {

	}
    /**
     * 
     * @param likelogid
     * @param creatorcode
     * @param deptnum
     * @param likelogtype
     */
	public StoreLikelog(String creatorcode, String deptnum,
			Integer likelogtype,Date likelogtime,Integer dr,Date ts) {
		super();
		this.creatorcode = creatorcode;
		this.deptnum = deptnum;
		this.likelogtype = likelogtype;
		this.likelogtime = likelogtime;
		this.dr = dr;
		this.ts = ts;
	}

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
    public Integer getLikelogid() {
		return likelogid;
	}
    /**
     * 
     * @param likelogid
     */
	public void setLikelogid(Integer likelogid) {
		this.likelogid = likelogid;
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
    public Date getLikelogtime() {
        return likelogtime;
    }
    /**
     * 
     * @param likelogtime
     */
    public void setLikelogtime(Date likelogtime) {
        this.likelogtime = likelogtime;
    }
    /**
     * 
     * @return
     */
    public Integer getLikelogtype() {
        return likelogtype;
    }
    /**
     * 
     * @param likelogtype
     */
    public void setLikelogtype(Integer likelogtype) {
        this.likelogtype = likelogtype;
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
}