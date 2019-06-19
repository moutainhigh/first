package com.deppon.wfs.workflow.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * 数据申请审批工作流.
 *
 * @author guanbo
 * @Date 2013-10-15 15:26:00
 */
 
public class DataProvideApproval extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 业务表的编号. */
	private String busino;
	
	/** 流程实例的id. */
	private Long processinstid;
	
	/** 申请人姓名. */
	private String applyPersonName;
	
	/** 申请人工号. */
	private String applyPersonId;
	
	/** 起草人职级。登陆后传递过来的（01-总经理,02-副总经理,03-部长,04-总监:EOS_DICT_ENTRY表中查询dicttypeid = 'ABF_POST_LEVEL'）. */
	private String applyPersonDegree;
	
	/** 存数据提供给的对象，与老数据的TARGET对应。业务字典中的类型项代码(存放业务字典中的dictId). */
	private String target;
	
	/** 存数据提供给的对象的名称。业务字典中的类型项名称. */
	private String targetName;
	
	/** 所属事业部，与老数据的area对应。业务字典中的类型项代码（部门的标杆编码），为了在后期判断选择参与者，营业部经理调薪时候才会出现这个字段. */
	private String area;
	
	/** 所属事业部的名称. */
	private String areaName;
	

	/** 所属组织标杆编码. */
	private String oragnization;

	/** 所属组织名称. */
	private String oragnizationName;
	
	/** 申请事由. */
	private String applyReason;
	
	/** 工作流修改时间. */
	private Date modifyTime;
	
	/** 工作流创建时间. */
	private Date createTime;
	
	/** 业务状态,1表示存在，0逻辑删除. */
	private char isseffective;
	
	/** 备用字段. */
	private Long spareField1;
	
	/** 备用字段. */
	private String spareField2;
	
	/** 备用字段. */
	private String spareField3;
	
	/**
	* 获取 业务表的编号.
	*
	* @return 业务表的编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	 * 设置 业务表的编号.
	 *
	 * @param busino the new busino
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例的id.
	*
	* @return 流程实例的id.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * 设置 流程实例的id.
	 *
	 * @param processinstid the new processinstid
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * 设置 申请人姓名.
	 *
	 * @param applyPersonName the new apply person name
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * 设置 申请人工号.
	 *
	 * @param applyPersonId the new apply person id
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 起草人职级。登陆后传递过来的（01-总经理,02-副总经理,03-部长,04-总监:EOS_DICT_ENTRY表中查询dicttypeid = 'ABF_POST_LEVEL'）  .
	*
	* @return 起草人职级。登陆后传递过来的（01-总经理,02-副总经理,03-部长,04-总监:EOS_DICT_ENTRY表中查询dicttypeid = 'ABF_POST_LEVEL'）  .
	*/
	public String getApplyPersonDegree() {
		return applyPersonDegree;
	}

	/**
	 * 设置 起草人职级。登陆后传递过来的（01-总经理,02-副总经理,03-部长,04-总监:EOS_DICT_ENTRY表中查询dicttypeid = 'ABF_POST_LEVEL'）  .
	 *
	 * @param applyPersonDegree the new apply person degree
	 */
	public void setApplyPersonDegree(String applyPersonDegree) {
		this.applyPersonDegree = applyPersonDegree;
	}
	
	/**
	* 获取 存数据提供给的对象，与老数据的TARGET对应。业务字典中的类型项代码(存放业务字典中的dictId).
	*
	* @return 存数据提供给的对象，与老数据的TARGET对应。业务字典中的类型项代码(存放业务字典中的dictId).
	*/
	public String getTarget() {
		return target;
	}

	/**
	 * 设置 存数据提供给的对象，与老数据的TARGET对应。业务字典中的类型项代码(存放业务字典中的dictId).
	 *
	 * @param target the new target
	 */
	
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	* 获取 存数据提供给的对象的名称。业务字典中的类型项名称.
	*
	* @return 存数据提供给的对象的名称。业务字典中的类型项名称.
	*/
	
	public String getTargetName() {
		return targetName;
	}

	/**
	 * 设置 存数据提供给的对象的名称。业务字典中的类型项名称.
	 *
	 * @param targetName the new target name
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
	/**
	* 获取 所属组织，与老数据的area对应。业务字典中的类型项代码（部门的标杆编码），为了在后期判断选择参与者，营业部经理调薪时候才会出现这个字段 .
	*
	* @return 所属组织，与老数据的area对应。业务字典中的类型项代码（部门的标杆编码），为了在后期判断选择参与者，营业部经理调薪时候才会出现这个字段 .
	*/
	public String getArea() {
		return area;
	}

	/**
	 * 设置 所属组织，与老数据的area对应。业务字典中的类型项代码（部门的标杆编码），为了在后期判断选择参与者，营业部经理调薪时候才会出现这个字段 .
	 *
	 * @param area the new area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 所属组织的名称.
	*
	* @return 所属组织的名称.
	*/
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置 所属组织的名称.
	 *
	 * @param areaName the new area name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 设置 申请事由.
	 *
	 * @param applyReason the new apply reason
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* 获取 工作流修改时间.
	*
	* @return 工作流修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置 工作流修改时间.
	 *
	 * @param modifyTime the new modify time
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 工作流创建时间.
	*
	* @return 工作流创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 工作流创建时间.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务状态,1表示存在，0逻辑删除.
	*
	* @return 业务状态,1表示存在，0逻辑删除.
	*/
	public char getIsseffective() {
		return isseffective;
	}

	/**
	 * 设置 业务状态,1表示存在，0逻辑删除.
	 *
	 * @param isseffective the new isseffective
	 */
	public void setIsseffective(char isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	 * 设置 备用字段.
	 *
	 * @param spareField1 the new spare field1
	 */
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	 * 设置 备用字段.
	 *
	 * @param spareField2 the new spare field2
	 */
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	 * 设置 备用字段.
	 *
	 * @param spareField3 the new spare field3
	 */
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}

	/**
	 * Gets the oragnization.
	 *
	 * @return the oragnization
	 */
	public String getOragnization() {
		return oragnization;
	}

	/**
	 * Sets the oragnization.
	 *
	 * @param oragnization the new oragnization
	 */
	public void setOragnization(String oragnization) {
		this.oragnization = oragnization;
	}

	/**
	 * Gets the oragnization name.
	 *
	 * @return the oragnization name
	 */
	public String getOragnizationName() {
		return oragnizationName;
	}

	/**
	 * Sets the oragnization name.
	 *
	 * @param oragnizationName the new oragnization name
	 */
	public void setOragnizationName(String oragnizationName) {
		this.oragnizationName = oragnizationName;
	}

}
