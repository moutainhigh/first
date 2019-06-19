package com.deppon.dpm.module.anps.shared.domain;

import java.util.Date;

import com.deppon.dpm.module.anps.shared.vo.GroupMemberVo;

public class NoticeGroupEntity {
	
	private int id;
	/**
	 * 群组id
	 */
	private String groupId;
	/**
	 * 群组名
	 */
	private String groupName;
	/**
	 * 群主
	 */
	private String groupOwner;
	/**
	 * 群组成员实体
	 */
	private GroupMemberVo groupMemberVo;
	/**
	 * 成员编号
	 */
	private String memberCode;
	/**
	 * 成员名
	 */
	private String memberName;
	/**
	 * 成员类型
	 */
	private String memberType;
	/**
	 * 岗位的部门
	 */
	private String positionDep;
	/**
	 * 编号类型
	 */
	private String codeType;
	/**
	 * 拼接岗位名
	 */
	private String positionName;
	/**
	 * 员工部门
	 */
	private String empOrgname;
	/**
	 * 成员人数（每一条）
	 */
	private int number;
	/**
	 * 群组总人数
	 */
	private int totalNumber;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 排序
	 */
	private String groupOrder;
	
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupOwner() {
		return groupOwner;
	}
	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getPositionDep() {
		return positionDep;
	}
	public void setPositionDep(String positionDep) {
		this.positionDep = positionDep;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getGroupOrder() {
		return groupOrder;
	}
	public void setGroupOrder(String groupOrder) {
		this.groupOrder = groupOrder;
	}
	public GroupMemberVo getGroupMemberVo() {
		return groupMemberVo;
	}
	public void setGroupMemberVo(GroupMemberVo groupMemberVo) {
		this.groupMemberVo = groupMemberVo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getEmpOrgname() {
		return empOrgname;
	}
	public void setEmpOrgname(String empOrgname) {
		this.empOrgname = empOrgname;
	}
	@Override
	public String toString() {
		return "NoticeGroupEntity [id=" + id + ", groupId=" + groupId
				+ ", groupName=" + groupName + ", groupOwner=" + groupOwner
				+ ", groupMemberVo=" + groupMemberVo + ", memberCode="
				+ memberCode + ", memberName=" + memberName + ", memberType="
				+ memberType + ", positionDep=" + positionDep + ", codeType="
				+ codeType + ", positionName=" + positionName + ", empOrgname="
				+ empOrgname + ", number=" + number + ", totalNumber="
				+ totalNumber + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", groupOrder=" + groupOrder + "]";
	}
}
