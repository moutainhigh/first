package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @author songzhaoliang
 *@description 主控事项信息	
 */
public class MasterEntity extends BaseEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1324598913952471211L;
	//主控事项id
	private String id;
	//主控事项名称
	private String name;
	//主控事项编号
	private String number;
	//控制单元
	private String control;
	/**
	 * get方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * set方法
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get方法
	 */
	public String getName() {
		return name;
	}
	/**
	 * set方法
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get方法
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * set方法
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * get方法
	 */
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	
	
}
