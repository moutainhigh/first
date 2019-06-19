package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 268101
 *  站点表
 *
 */
public class BusSiteInfo implements Serializable {
	/**
	 * 站点信息表主键ID
	 */
    private Integer id;
    /**
	 * 站点名称
	 */
    private String siteName;
    /**
	 * 站点地址
	 */
    private String address;
    /**
	 * 标准建筑图片地址
	 */
    private String buildAddress;
    /**
	 * 备注
	 */
    private String remark;
    /**
	 * 标志位
	 */
    private Integer isAct;
    /**
	 * 途经线路
	 */
    private String lineName;
    /**
	 * 联系人
	 */
    private String userName;
    /**
	 * 联系电话
	 */
    private String tel;

    /**
     * @return 站点信息表主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 站点信息表主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 站点名称
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * @param siteName 站点名称
     */ 
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * @return 站点地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 站点地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 标准建筑图片地址
     */
    public String getBuildAddress() {
        return buildAddress;
    }

    /**
     * @param buildAddress 标准建筑图片地址
     */
    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
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

    public Integer getIsAct() {
        return isAct;
    }

    public void setIsAct(Integer isAct) {
        this.isAct = isAct;
    }

	/**
	 * @return  途经线路
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * @param lineName  途经线路
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
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
    
}