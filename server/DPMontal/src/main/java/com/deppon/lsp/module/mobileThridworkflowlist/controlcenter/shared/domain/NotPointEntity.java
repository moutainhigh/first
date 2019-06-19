package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * TODO(非网点分类)
 * 
 * @author jianweiqiang
 * @date 2013-9-13 下午4:56:21
 * @since
 * @version V 0.1
 */
public class NotPointEntity extends BaseEntity {

	/**
	 * serialVersion
	 */
	private static final long serialVersionUID = -5601071037525715063L;
	/**
	 * id
	 */
	private String nid;
	/**
	 * 单据编号
	 */
	private String npnumber;
	/**
	 * 简称
	 */
	private String simpleName;
	/**
	 * 创建者
	 */
	private String createName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后修改者
	 */
	private String lastUpdateUser;
	/**
	 * 最后修改时间
	 */
	private Date lastUpdatTime;
	/**
	 * 控制单元
	 */
	private String controlUnit;
	/**
	 * 名称
	 */
	private String npname;
	/**
	 * 中文名称
	 */
	private String simpleChinese;
	/**
	 * 繁体名称
	 */
	private String traChinese;
	/**
	 * 描述
	 */
	private String descname;
	/**
	 * 中文描述
	 */
	private String descSimpleChinese;
	/**
	 * 繁体描述
	 */
	private String descTraChinese;

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNpnumber() {
		return npnumber;
	}

	public void setNpnumber(String npnumber) {
		this.npnumber = npnumber;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	
	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdatTime() {
		return lastUpdatTime;
	}

	public void setLastUpdatTime(Date lastUpdatTime) {
		this.lastUpdatTime = lastUpdatTime;
	}

	public String getControlUnit() {
		return controlUnit;
	}

	public void setControlUnit(String controlUnit) {
		this.controlUnit = controlUnit;
	}

	public String getNpname() {
		return npname;
	}

	public void setNpname(String npname) {
		this.npname = npname;
	}

	public String getSimpleChinese() {
		return simpleChinese;
	}

	public void setSimpleChinese(String simpleChinese) {
		this.simpleChinese = simpleChinese;
	}

	public String getTraChinese() {
		return traChinese;
	}

	public void setTraChinese(String traChinese) {
		this.traChinese = traChinese;
	}

	public String getDescname() {
		return descname;
	}

	public void setDescname(String descname) {
		this.descname = descname;
	}

	public String getDescSimpleChinese() {
		return descSimpleChinese;
	}

	public void setDescSimpleChinese(String descSimpleChinese) {
		this.descSimpleChinese = descSimpleChinese;
	}

	public String getDescTraChinese() {
		return descTraChinese;
	}

	public void setDescTraChinese(String descTraChinese) {
		this.descTraChinese = descTraChinese;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
