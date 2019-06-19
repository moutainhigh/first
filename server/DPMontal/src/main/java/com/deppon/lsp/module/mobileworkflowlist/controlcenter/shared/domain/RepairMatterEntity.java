/**
 * 
 */
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

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
public class RepairMatterEntity extends BaseEntity  {

	
	private static final long serialVersionUID = 1778222867214317731L;
	// 事项id
	private String mid;
	// 事项名称
	private String mname;
	// 事项工号
	private String mnumber;
	//事项类别
	private String mtype;
	//事项ID
	private String tid;
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		if (mname == null) {
			mname = "";
		}
		return mname;
	}

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

}
