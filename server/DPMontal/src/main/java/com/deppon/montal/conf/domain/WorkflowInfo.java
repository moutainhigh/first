package com.deppon.montal.conf.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作流信息
 * @author shangxu
 *
 */
public class WorkflowInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3564698896516283153L;
	/**
	 * id主键
	 */
	private String id;
	/**
	 * 工作流类型（流程定义名称）
	 */
	private String workflowname;
	/**
	 * jsp文件名称（不同的系统共用一个jsp名称）
	 */
	private String jspname;
	/**
	 * 插入时间
	 */
	private Date createtime;
	/**
	 * 系统编号
	 */
	private String syscode;
	/**
	 * 类名
	 */
	private String className;
	/**
	 * 业务实体属性对应的业务字典名称
	 */
	private String entryProperty;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkflowname() {
		return workflowname;
	}
	public void setWorkflowname(String workflowname) {
		this.workflowname = workflowname;
	}
	public String getJspname() {
		return jspname;
	}
	public void setJspname(String jspname) {
		this.jspname = jspname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getSyscode() {
		return syscode;
	}
	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}
	public String getClassName() {
		return className == null?"":className;
	}
	public String getEntryProperty() {
		return entryProperty == null?"":entryProperty;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setEntryProperty(String entryProperty) {
		this.entryProperty = entryProperty;
	}
}
