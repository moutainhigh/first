package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 王亚男
 * 用户 预定场地
 */
public class ReserveSubmitEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5004910808575083905L;
	/**
	 * 预定场地的ID
	 */
	private int playRoomId;
	
	/**
	 * 用户工号
	 */
	private String userNo;
	
	/**
	 * 预定类型标志（0羽毛球室，1瑜伽室）
	 */
	private int siteMark;
	
	/**
	 * 管理员标记  0-普通用户,1-管理员
	 */
	private int isManager;
	
	/**
	 * 时间类List  记录开始时间和结束时间
	 */
	private List<TimeEntity> datatime = new ArrayList<TimeEntity>();
	//getter setter
	public int getPlayRoomId() {
		return playRoomId;
	}
	//getter setter
	public void setPlayRoomId(int playRoomId) {
		this.playRoomId = playRoomId;
	}
	//getter setter
	public String getUserNo() {
		return userNo;
	}
	//getter setter
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	//getter setter
	public int getSiteMark() {
		return siteMark;
	}
	//getter setter
	public void setSiteMark(int siteMark) {
		this.siteMark = siteMark;
	}
	//getter setter
	public int getIsManager() {
		return isManager;
	}
	//getter setter
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	//getter setter
	public List<TimeEntity> getDatatime() {
		return datatime;
	}
	//getter setter
	public void setDatatime(List<TimeEntity> datatime) {
		this.datatime = datatime;
	}
}
