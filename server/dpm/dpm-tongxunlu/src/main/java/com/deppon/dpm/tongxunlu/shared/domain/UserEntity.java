/*******************************************************************************
 * Copyright 2013 BSE TEAM
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * PROJECT NAME	: bse-baseinfo-api
 * 
 * FILE PATH        	: src/main/java/com/deppon/foss/module/base/baseinfo/api/shared/domain/UserEntity.java
 * 
 * FILE NAME        	: UserEntity.java
 * 
 * AUTHOR			: FOSS综合管理开发组
 * 
 * HOME PAGE		:  http://www.deppon.com
 * 
 * COPYRIGHT		: Copyright (c) 2013  Deppon All Rights Reserved.
 ******************************************************************************/
package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.foss.framework.entity.IRole;
import com.deppon.foss.framework.entity.IUser;

/**
 * 用来存储交互“用户信息”的数据库对应实体 ClassName: UserEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:18:45 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class UserEntity extends BaseEntity implements IUser {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -3967231350438160812L;

	/**
	 * 职员编号
	 */
	private String empCode;

	/**
	 * 用户登录名
	 */
	private String userName;

	/**
	 * 用户登录密码
	 */
	private String password;

	/**
	 * 用户所拥有的角色信息ID集合
	 */
	private Set<String> roleids;

	/**
	 * 用户当前部门对应权限编码
	 */
	private Set<String> orgResCodes;

	/**
	 * 用户当前部门对应权限Uri
	 */
	private Set<String> orgResUris;

	/**
	 * 用户最后登录时间
	 */
	private Date lastLogin;

	/**
	 * 职位名称
	 */
	private String title;

	/**
	 * 用户状态(N:未启用 Y：启用)
	 */
	private String active;

	/**
	 * 用户生效时间
	 */
	private Date beginDate;

	/**
	 * 用户失效时间
	 */
	private Date endDate;

	/**
	 * 职员对象
	 */
	private EmployeeEntity employee;
	/**
	 * 组织信息
	 */
	private OrganizationEntity organization;

	/**
	 * 版本控制号
	 */
	private Long version;

	/**
	 * 用户姓名
	 */
	private String empName;

	@Override
	public Set<String> getRoleids() {
		return roleids;
	}

	@Override
	@Deprecated
	public List<IRole> getRoles() {
		return null;
	}

	@Override
	public void setRoleids(Set<String> roleids) {
		this.roleids = roleids;
	}

	@Override
	@Deprecated
	public void setRoles(List<IRole> roles) {
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public Set<String> queryAccessUris() {
		return this.orgResUris;
	}

	/**
	 * @return empCode
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<String> getOrgResCodes() {
		return orgResCodes;
	}

	public void setOrgResCodes(Set<String> orgResCodes) {
		this.orgResCodes = orgResCodes;
	}

	public Set<String> getOrgResUris() {
		return orgResUris;
	}

	public void setOrgResUris(Set<String> orgResUris) {
		this.orgResUris = orgResUris;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}
}
