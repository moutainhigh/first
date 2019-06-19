/**
 * 
 */
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 作者：刘长鸣-综合系统开发
 * 编写时间：2014年3月7日
 * 描述：分录轮胎信息
 * 更新记录：
 */
public class TyreInformationEntity extends BaseEntity{

	/**
	 * 序列号id
	 */
	private static final long serialVersionUID = -315489069793413925L;
	
	//轮胎编号
	private String tireNO;
	
	//轮胎位置
	private String location;
	
	//公里数
	private Integer evenNumber;
	
	//是否变卖
	private Boolean isSell;

	/**
	 * @return the tireNO
	 */
	public String getTireNO() {
		if (tireNO == null) {
			tireNO = "";
		}
		return tireNO;
	}

	/**
	 * @param tireNO the tireNO to set
	 */
	public void setTireNO(String tireNO) {
		this.tireNO = tireNO;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		if (location == null) {
			location = "";
		}
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the evenNumber
	 */
	public Integer getEvenNumber() {
		return evenNumber;
	}
	
	public String getEvenNumberStr() {
		if (evenNumber == null) {
			return "";
		}
		return (evenNumber + "");
	}

	/**
	 * @param evenNumber the evenNumber to set
	 */
	public void setEvenNumber(Integer evenNumber) {
		this.evenNumber = evenNumber;
	}

	/**
	 * @return the isSell
	 */
	public Boolean getIsSell() {
		return isSell;
	}
	
	public String getIsSellStr() {
		if (isSell == null) {
			return "";
		}
		if (isSell) {
			return "是";
		}else{
			return "否";
		}
	}

	/**
	 * @param isSell the isSell to set
	 */
	public void setIsSell(Boolean isSell) {
		this.isSell = isSell;
	}

	/**
	 * 作者：刘长鸣-综合系统开发
	 * 编写时间：2014年3月7日
	 * 描述：重写toString方法
	 */
	@Override
	public String toString() {
		return "TyreInformationEntity [tireNO=" + tireNO + ", location="
				+ location + ", evenNumber=" + evenNumber + ", isSell="
				+ isSell + "]";
	}
}
