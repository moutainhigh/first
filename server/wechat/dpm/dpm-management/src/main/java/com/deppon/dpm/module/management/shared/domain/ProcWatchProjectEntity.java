package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 268101 ProcWatchProjectEntity 实体类
 * 
 */
public class ProcWatchProjectEntity implements Serializable {
	/**
	 * 构造方法
	 */
	private ProcWatchProjectEntity() {

	}

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int watchid;
	/**
	 * 部门CODE
	 */
	private String procode;
	/**
	 * 部门名字
	 */
	private String proname;
	/**
	 * 数量
	 */
	private int pronum;
	/**
	 * 总数
	 */
	private int procount;

	/**
	 * 时间
	 */
	private Date updatedate;



	/**
	 * @return 主键id
	 */
	public int getWatchid() {
		return watchid;
	}

	/**
	 * @param watchid 主键id
	 */
	public void setWatchid(int watchid) {
		this.watchid = watchid;
	}

	/**
	 * @return 部门CODE
	 */
	public String getProcode() {
		return procode;
	}

	/**
	 * @param procode 部门CODE
	 */
	public void setProcode(String procode) {
		this.procode = procode;
	}

	/**
	 * @return 部门名字
	 */
	public String getProname() {
		return proname;
	}

	/**
	 * @param proname 部门名字
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}

	/**
	 * @return 数量
	 */
	public int getPronum() {
		return pronum;
	}

	/**
	 * @param pronum 数量
	 */
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	/**
	 * @return  总数
	 */
	public int getProcount() {
		return procount;
	}

	/**
	 * @param procount  总数
	 */
	public void setProcount(int procount) {
		this.procount = procount;
	}

	/**
	 * @return 更新时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}

	/**
	 * @param updatedate 更新时间
	 */ 
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

}
