package com.deppon.dpm.module.anps.shared.vo;

public class GroupMemberVo {
	
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
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	@Override
	public String toString() {
		return "GroupMemberVo [memberCode=" + memberCode + ", memberName="
				+ memberName + ", memberType=" + memberType + ", positionDep="
				+ positionDep + ", codeType=" + codeType + "]";
	}
}
