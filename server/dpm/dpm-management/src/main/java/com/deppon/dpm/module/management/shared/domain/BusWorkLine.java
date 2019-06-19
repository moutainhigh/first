package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 268101
 * BusWorkLine 班车线路表
 *
 */
public class BusWorkLine implements Serializable {
	/**
	 * 上下班站点主键ID
	 */
    private Integer id;

    /**
	 * 站点ID 
	 */
    private Integer siteId;

    /**
	 * 是否上班
	 */
    private Integer isGoWork;

    /**
	 * 是否开通
	 */
    private Integer isAct;

    /**
	 * 备注
	 */
    private String remark;

    /**
     * @return 下班站点主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 下班站点主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 站点ID 
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * @param siteId 站点ID 
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     * @return 是否上班
     */ 
    public Integer getIsGoWork() {
        return isGoWork;
    }

    /**
     * @param isGoWork 是否上班
     */
    public void setIsGoWork(Integer isGoWork) {
        this.isGoWork = isGoWork;
    }

    /**
     * @return 是否开通
     */
    public Integer getIsAct() {
        return isAct;
    }

    /**
     * @param isAct 是否开通
     */
    public void setIsAct(Integer isAct) {
        this.isAct = isAct;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}