package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 
 * @author 王亚男
 * 向PC端推送数据 明细信息--分录
 */
public class EntriesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6744170162463198319L;
	/**
	 * 区域编码
	 */
	private String part;
	
	/**
	 * 区域名称
	 */
	private String partName;
	
	/**
	 * 事项编码
	 */
	private String matter;
	
	/**
	 * 事项名称
	 */
	private String matterName;
	
	/**
	 * 验收扣分
	 */
	private double acceptancePoint;
	
	/**
	 * 备注
	 */
	private String comment;	
	
	/**
	 * getter
	 * @return
	 */
	public String getPart() {
		return part;
	}
	/**
	 * setter
	 * @param part
	 */
	public void setPart(String part) {
		this.part = part;
	}
	/**
	 * getter
	 * @return
	 */
	public String getPartName() {
		return partName;
	}
	/**
	 * setter
	 * @param partName
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
	/**
	 * getter
	 * @return
	 */
	public String getMatter() {
		return matter;
	}
	/**
	 * setter
	 * @param matter
	 */
	public void setMatter(String matter) {
		this.matter = matter;
	}
	/**
	 * getter
	 * @return
	 */
	public String getMatterName() {
		return matterName;
	}
	/**
	 * setter
	 * @param matterName
	 */
	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}
	/**
	 * getter
	 * @return
	 */
	public double getAcceptancePoint() {
		return acceptancePoint;
	}
	/**
	 * setter
	 * @param acceptancePoint
	 */
	public void setAcceptancePoint(double acceptancePoint) {
		this.acceptancePoint = acceptancePoint;
	}
	/**
	 * getter
	 * @return
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * setter
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
