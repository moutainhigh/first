package com.deppon.dpm.module.management.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 工程项目质量巡检记录单
 */
/**
 * @author 268101
 * 
 */
public class QualitypollingEntity extends BaseEntity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 3947822942374943896L;
	/**
	 * FID
	 */
	private String fid;
	/**
	 * 创建者
	 */
	private String fcreatorid;
	/**
	 * 创建时间
	 */
	private Date fcreatetime;
	/**
	 * 最后修改者
	 */
	private String flastupdateuserid;
	/**
	 * 最后修改时间
	 */
	private Date flastupdatetime;
	/**
	 * 控制单元
	 */
	private String fcontrolunitid;
	/**
	 * 单据编号
	 */
	private String fnumber;
	/**
	 * 业务日期
	 */
	private Date fbizdate;
	/**
	 * 经手人
	 */
	private String fhandlerid;
	/**
	 * 参考信息
	 */
	private String fdescription;
	/**
	 * 是否曾经生效
	 */
	private Long fhaseffected;
	/**
	 * 审核人
	 */
	private String fauditorid;
	/**
	 * 原始单据ID
	 */
	private String fsourcebillid;
	/**
	 * 来源功能
	 */
	private String fsourcefunction;
	/**
	 * 项目编号
	 */
	private String cfprojectnumberid;
	/**
	 * 工程项目名称
	 */
	private String cfprojectname;
	/**
	 * 所属工程部
	 */
	private String cfbelongprodeptidasname;
	/**
	 * 所属工程部ID
	 */
	private String cfbelongprodeptid;
	/**
	 * 检查人ID
	 */
	private String cfcheckpersonid;
	/**
	 * 检查人
	 */
	private String cfcheckpersonidasname;
	/**
	 * 总分
	 */
	private double cftotalscore;
	/**
	 * 定位
	 */
	private String cflackparts;
	/**
	 * 备注
	 */
	private String cfremake;

	/**
	 * @return FID
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid
	 *            FID
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return 创建者
	 */
	public String getFcreatorid() {
		return fcreatorid;
	}

	/**
	 * @param fcreatorid
	 *            创建者
	 */
	public void setFcreatorid(String fcreatorid) {
		this.fcreatorid = fcreatorid;
	}

	/**
	 * @return 创建时间
	 */
	public Date getFcreatetime() {
		return fcreatetime;
	}

	/**
	 * @param fcreatetime
	 *            创建时间
	 */
	public void setFcreatetime(Date fcreatetime) {
		this.fcreatetime = fcreatetime;
	}

	/**
	 * @return 最后修改者
	 */
	public String getFlastupdateuserid() {
		return flastupdateuserid;
	}

	/**
	 * @param flastupdateuserid
	 *            最后修改者
	 */
	public void setFlastupdateuserid(String flastupdateuserid) {
		this.flastupdateuserid = flastupdateuserid;
	}

	/**
	 * @return 最后修改时间
	 */
	public Date getFlastupdatetime() {
		return flastupdatetime;
	}

	/**
	 * @param flastupdatetime
	 *            最后修改时间
	 */
	public void setFlastupdatetime(Date flastupdatetime) {
		this.flastupdatetime = flastupdatetime;
	}

	/**
	 * @return 控制单元
	 */
	public String getFcontrolunitid() {
		return fcontrolunitid;
	}

	/**
	 * @param fcontrolunitid
	 *            控制单元
	 */
	public void setFcontrolunitid(String fcontrolunitid) {
		this.fcontrolunitid = fcontrolunitid;
	}

	/**
	 * @return 单据编号
	 */
	public String getFnumber() {
		return fnumber;
	}

	/**
	 * @param fnumber
	 *            单据编号
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	/**
	 * @return 业务日期
	 */
	public Date getFbizdate() {
		return fbizdate;
	}

	/**
	 * @param fbizdate
	 *            业务日期
	 */
	public void setFbizdate(Date fbizdate) {
		this.fbizdate = fbizdate;
	}

	/**
	 * @return 经手人
	 */
	public String getFhandlerid() {
		return fhandlerid;
	}

	/**
	 * @param fhandlerid
	 *            经手人
	 */
	public void setFhandlerid(String fhandlerid) {
		this.fhandlerid = fhandlerid;
	}

	/**
	 * @return 参考信息
	 */
	public String getFdescription() {
		return fdescription;
	}

	/**
	 * @param fdescription
	 *            参考信息
	 */
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}

	/**
	 * @return 是否曾经生效
	 */
	public Long getFhaseffected() {
		return fhaseffected;
	}

	/**
	 * @param fhaseffected
	 *            是否曾经生效
	 */
	public void setFhaseffected(Long fhaseffected) {
		this.fhaseffected = fhaseffected;
	}

	/**
	 * @return 审核人
	 */
	public String getFauditorid() {
		return fauditorid;
	}

	/**
	 * @param fauditorid
	 *            审核人
	 */
	public void setFauditorid(String fauditorid) {
		this.fauditorid = fauditorid;
	}

	/**
	 * @return 原始单所属id
	 */
	public String getFsourcebillid() {
		return fsourcebillid;
	}

	/**
	 * @param fsourcebillid
	 *            原始单所属id
	 */
	public void setFsourcebillid(String fsourcebillid) {
		this.fsourcebillid = fsourcebillid;
	}

	/**
	 * @return 来源功能
	 */
	public String getFsourcefunction() {
		return fsourcefunction;
	}

	/**
	 * @param fsourcefunction
	 *            来源功能
	 */
	public void setFsourcefunction(String fsourcefunction) {
		this.fsourcefunction = fsourcefunction;
	}

	/**
	 * @return 项目编号
	 */
	public String getCfprojectnumberid() {
		return cfprojectnumberid;
	}

	/**
	 * @param cfprojectnumberid
	 *            项目编号
	 */
	public void setCfprojectnumberid(String cfprojectnumberid) {
		this.cfprojectnumberid = cfprojectnumberid;
	}

	/**
	 * @return 工程项目名称
	 */
	public String getCfprojectname() {
		return cfprojectname;
	}

	/**
	 * @param cfprojectname
	 *            工程项目名称
	 */
	public void setCfprojectname(String cfprojectname) {
		this.cfprojectname = cfprojectname;
	}

	/**
	 * @return 所属工程部
	 */
	public String getCfbelongprodeptidasname() {
		return cfbelongprodeptidasname;
	}

	/**
	 * @param cfbelongprodeptidasname
	 *            所属工程部
	 */
	public void setCfbelongprodeptidasname(String cfbelongprodeptidasname) {
		this.cfbelongprodeptidasname = cfbelongprodeptidasname;
	}

	/**
	 * @return 所属工程部id
	 */
	public String getCfbelongprodeptid() {
		return cfbelongprodeptid;
	}

	/**
	 * @param cfbelongprodeptid
	 *            所属工程部id
	 */
	public void setCfbelongprodeptid(String cfbelongprodeptid) {
		this.cfbelongprodeptid = cfbelongprodeptid;
	}

	/**
	 * @return 检查人Id
	 */
	public String getCfcheckpersonid() {
		return cfcheckpersonid;
	}

	/**
	 * @param cfcheckpersonid
	 *            检查人Id
	 */
	public void setCfcheckpersonid(String cfcheckpersonid) {
		this.cfcheckpersonid = cfcheckpersonid;
	}

	/**
	 * @return 检查人
	 */
	public String getCfcheckpersonidasname() {
		return cfcheckpersonidasname;
	}

	/**
	 * @param cfcheckpersonidasname
	 *            检查人
	 */
	public void setCfcheckpersonidasname(String cfcheckpersonidasname) {
		this.cfcheckpersonidasname = cfcheckpersonidasname;
	}

	/**
	 * @return 总分
	 */
	public double getCftotalscore() {
		return cftotalscore;
	}

	/**
	 * @param cftotalscore
	 *            总分
	 */
	public void setCftotalscore(double cftotalscore) {
		this.cftotalscore = cftotalscore;
	}

	/**
	 * @return 定位
	 */
	public String getCflackparts() {
		return cflackparts;
	}

	/**
	 * @param cflackparts
	 *            定位
	 */
	public void setCflackparts(String cflackparts) {
		this.cflackparts = cflackparts;
	}

	/**
	 * @return 备注
	 */
	public String getCfremake() {
		return cfremake;
	}

	/**
	 * @param cfremake
	 *            备注
	 */
	public void setCfremake(String cfremake) {
		this.cfremake = cfremake;
	}

	@Override
	// 组装
	public String toString() {
		return "QualitypollingEntity [fid=" + fid + ", fcreatorid="
				+ fcreatorid + ", fcreatetime=" + fcreatetime
				+ ", flastupdateuserid=" + flastupdateuserid
				+ ", flastupdatetime=" + flastupdatetime + ", fcontrolunitid="
				+ fcontrolunitid + ", fnumber=" + fnumber + ", fbizdate="
				+ fbizdate + ", fhandlerid=" + fhandlerid + ", fdescription="
				+ fdescription + ", fhaseffected=" + fhaseffected
				+ ", fauditorid=" + fauditorid + ", fsourcebillid="
				+ fsourcebillid + ", fsourcefunction=" + fsourcefunction
				+ ", cfprojectnumberid=" + cfprojectnumberid
				+ ", cfprojectname=" + cfprojectname
				+ ", cfbelongprodeptidasname=" + cfbelongprodeptidasname
				+ ", cfbelongprodeptid=" + cfbelongprodeptid
				+ ", cfcheckpersonid=" + cfcheckpersonid
				+ ", cfcheckpersonidasname=" + cfcheckpersonidasname
				+ ", cftotalscore=" + cftotalscore + ", cflackparts="
				+ cflackparts + ", cfremake=" + cfremake + "]";
	}

}
