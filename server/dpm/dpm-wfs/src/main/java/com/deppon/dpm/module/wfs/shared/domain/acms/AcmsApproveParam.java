package com.deppon.dpm.module.wfs.shared.domain.acms;

import java.io.Serializable;

public class AcmsApproveParam implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//审批人工号
    private String appCode;
    //审批人名字
    private String appName;
    //判断工作流类型
    private int flag;
    //审批参数
    private AcmsApproveSubParam approvelEntity;
    //工作流业务编码
    private String busino;
	/**
	 * @return the appCode
	 */
	public String getAppCode() {
		return appCode;
	}
	/**
	 * @param appCode the appCode to set
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @return the approvelEntity
	 */
	public AcmsApproveSubParam getApprovelEntity() {
		return approvelEntity;
	}
	/**
	 * @param approvelEntity the approvelEntity to set
	 */
	public void setApprovelEntity(AcmsApproveSubParam approvelEntity) {
		this.approvelEntity = approvelEntity;
	}
}
