package com.deppon.dpm.module.wfs.shared.domain;

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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the workflowname
	 */
	public String getWorkflowname() {
		return workflowname;
	}
	/**
	 * @param workflowname the workflowname to set
	 */
	public void setWorkflowname(String workflowname) {
		this.workflowname = workflowname;
	}
	/**
	 * @return the jspname
	 */
	public String getJspname() {
		return jspname;
	}
	/**
	 * @param jspname the jspname to set
	 */
	public void setJspname(String jspname) {
		this.jspname = jspname;
	}
	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the syscode
	 */
	public String getSyscode() {
		return syscode;
	}
	/**
	 * @param syscode the syscode to set
	 */
	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}
	/**
	 * @return className
	 */
	public String getClassName() {
		return className == null?"":className;
	}
	/**
	 * @return the entryProperty
	 */
	public String getEntryProperty() {
		return entryProperty == null?"":entryProperty;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @param entryProperty the entryProperty to set
	 */
	public void setEntryProperty(String entryProperty) {
		this.entryProperty = entryProperty;
	}
}
