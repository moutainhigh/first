package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @author songzhaoliang
 *@description 人员信息	
 */
public class MasterItemsEntity extends BaseEntity{

	/**
	 * serialVersionUID,long
	 */
	private static final long serialVersionUID = 3640947579535962573L;
	//主控细项id
	private String id;
	//主控细项名称
	private String name;
	//主控细项编号
	private String number;
	//主控部门
	private String condep;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCondep() {
		return condep;
	}
	public void setCondep(String condep) {
		this.condep = condep;
	}
	
}
