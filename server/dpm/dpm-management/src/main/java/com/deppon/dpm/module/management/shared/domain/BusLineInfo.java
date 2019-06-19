package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 268101
 *线路表
 */
public class BusLineInfo implements Serializable { 
	/**
	 * 线路信息表主键ID
	 */
    private Integer id;
    /**
	 * 线路名称
	 */
    private String lineName;

    /**
	 * 供应商
	 */
    private String applyName;

    /**
	 * 联系人
	 */
    private String userName;

    /**
	 * 联系电话
	 */
    private String tel;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 起始时间
	 */
    private Date startDate;

    /**
     * @return 线路信息表主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 线路信息表主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 线路名称
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * @param lineName 线路名称
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * @return 供应商
     */
    public String getApplyName() {
        return applyName;
    }

    /**
     * @param applyName 供应商
     */
    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    /**
     * @return 联系人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 联系人
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 起始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate 起始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}