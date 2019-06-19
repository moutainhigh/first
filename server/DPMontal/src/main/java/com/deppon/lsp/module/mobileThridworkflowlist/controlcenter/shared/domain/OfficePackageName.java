package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;



import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @author songzhaoliang
 *@description 配套部门信息实体类	
 */
public class OfficePackageName extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 512477133406962296L;

	//配套名称id
	private String id;
	//配套名称名称
	private String name;
	//配套名称编号
	private String number;
	//简称
	private String fsName;
	
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
	public String getFsName() {
		return fsName;
	}
	public void setFsName(String fsName) {
		this.fsName = fsName;
	}
	
	
	
	
}
