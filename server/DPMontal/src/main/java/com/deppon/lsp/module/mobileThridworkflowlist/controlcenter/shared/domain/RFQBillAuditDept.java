package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class RFQBillAuditDept extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**表头*/
	private String parent;
	
	/**部门编码*/
	private String departmentNumber;
	
	/**评审部门*/
	private String reviewDepartment;
	
	/**单据分录序列号*/
	private int seq;
	
	/**id*/
	private String fid;

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:36
	* @version：
	* @return String
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:39
	* @version：
	* @param parent void
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:43
	* @version：
	* @return String
	 */
	public String getDepartmentNumber() {
		return departmentNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:47
	* @version：
	* @param departmentNumber void
	 */
	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:50
	* @version：
	* @return String
	 */
	public String getReviewDepartment() {
		return reviewDepartment;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:56
	* @version：
	* @param reviewDepartment void
	 */
	public void setReviewDepartment(String reviewDepartment) {
		this.reviewDepartment = reviewDepartment;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:05:59
	* @version：
	* @return int
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:02
	* @version：
	* @param seq void
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:05
	* @version：
	* @return String
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:08
	* @version：
	* @param fid void
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}


}
