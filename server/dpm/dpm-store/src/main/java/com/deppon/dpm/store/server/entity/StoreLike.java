package com.deppon.dpm.store.server.entity;

import java.util.Date;
/**
 * 点赞信息
 * @author XiaoTian
 *
 */
public class StoreLike {
	/**
	 * id
	 */
    private Integer listid;
    /**
     * 点赞数量
     */
    private Long likenum;
    /**
     * 警告数量
     */
    private Long warningnum;
    /**
     * 营业部编号
     */
    private String deptnum;
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