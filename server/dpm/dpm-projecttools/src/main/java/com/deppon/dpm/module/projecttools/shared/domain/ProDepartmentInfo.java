package com.deppon.dpm.module.projecttools.shared.domain;

/**
 * <p>ClassName: 部门信息</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-8-19</p>
 */
public class ProDepartmentInfo {
//部门编号
private String id;

//部门名称
private String name;

//项目数目
private int counts;


public int getCounts() {
	return counts;
}
public void setCounts(int counts) {
	this.counts = counts;
}
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

}
