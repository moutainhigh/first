package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @author songzhaoliang
 *@description 计量单位实体类	
 */
public class MeasureUnit extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6753017052657664594L;
	//单位id
	private String id;
	//单位名称
	private String name;
	//单位编号
	private String number;
	//是否基础单位
	private String isbaseunit;
	//单位系数
	private float coefficient;
	//单位所属类别
	private String groupunit;
	
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
	public String getIsbaseunit() {
		return isbaseunit;
	}
	public void setIsbaseunit(String isbaseunit) {
		this.isbaseunit = isbaseunit;
	}
	
	public float getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	public String getGroupunit() {
		return groupunit;
	}
	public void setGroupunit(String groupunit) {
		this.groupunit = groupunit;
	}
	
	
	
	
	
}
