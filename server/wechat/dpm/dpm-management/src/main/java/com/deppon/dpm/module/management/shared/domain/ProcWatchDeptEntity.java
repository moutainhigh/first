package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据监控检查部门数量
 * 
 * @author 袁中华
 * @date 2015.7.27 关联 proc_watch_dept表
 */
public class ProcWatchDeptEntity implements Serializable {

	/**
	 * 构造方法
	 */
	private ProcWatchDeptEntity() {

	}

	/**
	 * 实现序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int deptid;
	/**
	 * 部门代码
	 */
	private String deptcode;
	/**
	 * 部门名字
	 */
	private String deptname;
	/**
	 * 时间
	 */
	private Date updatedate;
	/**
	 * 时间
	 */

	private String date;

	/**
	 * @return id主键
	 */
	public int getDeptid() {
		return deptid;
	}

	/**
	 * @param deptid
	 *            id主键
	 */
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	/**
	 * @return 部门代码
	 */
	public String getDeptcode() {
		return deptcode;
	}

	/**
	 * @param deptcode
	 *            部门代码
	 */
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	/**
	 * @return 部门名字
	 */
	public String getDeptname() {
		return deptname;
	}

	/**
	 * @param deptname
	 *            部门名字
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	/**
	 * @return 时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}

	/**
	 * @param updatedate
	 *            时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	/**
	 * @return 时间
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            时间
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
