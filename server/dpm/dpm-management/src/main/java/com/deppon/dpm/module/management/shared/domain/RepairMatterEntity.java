package com.deppon.dpm.module.management.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * TODO(事项实体类)
 * 
 * @author jianweiqiang
 * @date 2013-8-29 上午11:44:12
 * @since
 * @version V 0.1
 */
public class RepairMatterEntity extends BaseEntity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1778222867214317731L;
	// 事项id
	private String mid;
	// 事项名称
	private String mname;
	// 事项工号
	private String mnumber;
	// 事项类别
	private String mtype;
	// 事项ID
	private String tid;
	// 质保期
	private String warrantyDate;

	/**
	 * @return 事项id
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * @param mid
	 *            事项id
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * @return 事项名称
	 */
	public String getMname() {
		return mname;
	}

	/**
	 * @param mname
	 *            事项名称
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMnumber() {
		return mnumber;
	}

	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * @return the warrantyDate
	 */
	public String getWarrantyDate() {
		return warrantyDate;
	}

	/**
	 * @param warrantyDate
	 *            the warrantyDate to set
	 */
	public void setWarrantyDate(String warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() 构造方法
	 */
	@Override
	public String toString() {
		return "RepairMatterEntity [mid=" + mid + ", mname=" + mname
				+ ", mnumber=" + mnumber + ", mtype=" + mtype + ", tid=" + tid
				+ ", warrantyDate=" + warrantyDate + "]";
	}

}
