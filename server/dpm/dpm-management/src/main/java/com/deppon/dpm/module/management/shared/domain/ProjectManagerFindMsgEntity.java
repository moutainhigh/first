package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 268101 工程实体类
 * 
 */
public class ProjectManagerFindMsgEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 区域id
	 */
	private String areaId;
	/**
	 * 门店地址
	 */
	private String proAdress;
	/**
	 * 工号
	 */
	private String userNo;
	/**
	 * 员工名字
	 */
	private String empname;
	/**
	 * 员工所属部门id
	 */
	private String orgid;
	/**
	 * 员工所属部门code
	 */
	private String orgCode;
	/**
	 * 员工所属部门
	 */
	private String orgname;
	/**
	 * 检查区域名字
	 */
	private String fcheckArea;
	/**
	 * 检查区域名cede
	 */
	private String fcheckAreaCode;
	/**
	 * 检查项目的cede
	 */
	private String fcheckProjectCode;
	/**
	 * 检查项目
	 */
	private String fcheckProject;
	/**
	 * 检查项目的分数
	 */
	private Double hisFscore;
	/**
	 * 检查项目的扣分项目
	 */
	private String fscoreStandard;
	/**
	 * 损坏原因
	 */
	private String damageReason;
	/**
	 * 维修事项
	 */
	private String frepairMatter;
	/**
	 * 图片
	 */
	private String photo;
	/**
	 * 图片
	 */
	private String photo2;
	/**
	 * 图片
	 */
	private String photo3;
	/**
	 * 图片
	 */
	private String photo4;
	/**
	 * 图片
	 */
	private String photo5;

	/**
	 * @return 区域id
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId
	 *            区域id
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return 门店地址
	 */
	public String getProAdress() {
		return proAdress;
	}

	/**
	 * @param proAdress
	 *            门店地址
	 */
	public void setProAdress(String proAdress) {
		this.proAdress = proAdress;
	}

	/**
	 * @return 工号
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo
	 *            工号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return 员工名字
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * @param empname
	 *            员工名字
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	/**
	 * @return 员工所属部门id
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * @param orgid
	 *            员工所属部门id
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * @return 员工所属部门code
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode
	 *            员工所属部门code
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return 员工所属部门
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @param orgname
	 *            员工所属部门
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * @return 检查区域
	 */
	public String getFcheckArea() {
		return fcheckArea;
	}

	/**
	 * @param fcheckArea
	 *            检查区域
	 */
	public void setFcheckArea(String fcheckArea) {
		this.fcheckArea = fcheckArea;
	}

	/**
	 * @return 检查区域code
	 */
	public String getFcheckAreaCode() {
		return fcheckAreaCode;
	}

	/**
	 * @param fcheckAreaCode
	 *            检查区域code
	 */
	public void setFcheckAreaCode(String fcheckAreaCode) {
		this.fcheckAreaCode = fcheckAreaCode;
	}

	/**
	 * @return 检查项目的code
	 */
	public String getFcheckProjectCode() {
		return fcheckProjectCode;
	}

	/**
	 * @param fcheckProjectCode
	 *            检查项目的code
	 */
	public void setFcheckProjectCode(String fcheckProjectCode) {
		this.fcheckProjectCode = fcheckProjectCode;
	}

	/**
	 * @return 检查项目
	 */
	public String getFcheckProject() {
		return fcheckProject;
	}

	/**
	 * @param fcheckProject
	 *            检查项目
	 */
	public void setFcheckProject(String fcheckProject) {
		this.fcheckProject = fcheckProject;
	}

	/**
	 * @return 检查项目分数
	 */
	public Double getHisFscore() {
		return hisFscore;
	}

	/**
	 * @param hisFscore
	 *            检查项目分数
	 */
	public void setHisFscore(Double hisFscore) {
		this.hisFscore = hisFscore;
	}

	/**
	 * @return 检查项目的扣分项目
	 */
	public String getFscoreStandard() {
		return fscoreStandard;
	}

	/**
	 * @param fscoreStandard
	 *            检查项目的扣分项目
	 */
	public void setFscoreStandard(String fscoreStandard) {
		this.fscoreStandard = fscoreStandard;
	}

	/**
	 * @return 损坏原因
	 */
	public String getDamageReason() {
		return damageReason;
	}

	/**
	 * @param damageReason
	 *            损坏原因
	 */
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}

	/**
	 * @return 维修事项
	 */
	public String getFrepairMatter() {
		return frepairMatter;
	}

	/**
	 * @param frepairMatter
	 *            维修事项
	 */
	public void setFrepairMatter(String frepairMatter) {
		this.frepairMatter = frepairMatter;
	}

	/**
	 * @return 图片
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            图片
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return 图片
	 */
	public String getPhoto2() {
		return photo2;
	}

	/**
	 * @param photo2
	 *            图片
	 */
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	/**
	 * @return 图片
	 */
	public String getPhoto3() {
		return photo3;
	}

	/**
	 * @param photo3
	 *            图片
	 */
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	/**
	 * @return 图片
	 */
	public String getPhoto4() {
		return photo4;
	}

	/**
	 * @param photo4
	 *            图片
	 */
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	/**
	 * @return 图片
	 */
	public String getPhoto5() {
		return photo5;
	}

	/**
	 * @param photo5
	 *            图片
	 */
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	// 组装
	public String toString() {
		return "ProjectManagerFindMsgEntity [areaId=" + areaId + ", proAdress="
				+ proAdress + ", userNo=" + userNo + ", empname=" + empname
				+ ", orgid=" + orgid + ", orgCode=" + orgCode + ", orgname="
				+ orgname + ", fcheckArea=" + fcheckArea + ", fcheckAreaCode="
				+ fcheckAreaCode + ", fcheckProjectCode=" + fcheckProjectCode
				+ ", fcheckProject=" + fcheckProject + ", hisFscore="
				+ hisFscore + ", fscoreStandard=" + fscoreStandard
				+ ", damageReason=" + damageReason + ", frepairMatter="
				+ frepairMatter + ", photo=" + photo + ", photo2=" + photo2
				+ ", photo3=" + photo3 + ", photo4=" + photo4 + ", photo5="
				+ photo5 + "]";
	}

}
