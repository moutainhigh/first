package com.deppon.dpm.module.management.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * TODO(维修类别实体类)
 * 
 * @author jianweiqiang
 * @date 2013-8-29 上午11:44:12
 * @since
 * @version V 0.1
 */
public class MtypeEntity extends BaseEntity implements java.io.Serializable {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 5059549839005725540L;
	// 维修类别id
	private String mtid;
	// 维修类别名称
	private String mtname;
	// 维修类别工号
	private String mtnumber;
	// 维修类别描述
	private String mtdesc;
	public String getMtid() {
		return mtid;
	}
	public void setMtid(String mtid) {
		this.mtid = mtid;
	}
	public String getMtname() {
		return mtname;
	}
	public void setMtname(String mtname) {
		this.mtname = mtname;
	}
	public String getMtnumber() {
		return mtnumber;
	}
	public void setMtnumber(String mtnumber) {
		this.mtnumber = mtnumber;
	}
	public String getMtdesc() {
		return mtdesc;
	}
	public void setMtdesc(String mtdesc) {
		this.mtdesc = mtdesc;
	}


}
