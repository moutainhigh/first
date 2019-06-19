package com.deppon.dpm.module.projecttools.shared.domain;

import java.io.Serializable;

/**
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:150976,date:2014-11-28 下午8:01:07,content:TODO
 * </p>
 * 
 * @since 项目名称： 类描述： 创建人：邓汉超 创建时间：2014-11-28 下午8:01:07 修改人：邓汉超 修改时间：2014-11-28
 *        下午8:01:07 修改备注：
 * @version V1.0
 * @Copyright 2014 德邦物流 Inc. All rights reserved.
 */
public class SysDemandInfoEntity implements Serializable {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 1L;
	// 表id
	private long sysdemandid;
	// 需求编号
	private String sysdemandCode;
	// 用户需求编号
	private String userdemandCode;
	// 系统需求分类
	private String demandcatetory;
	// 需求跟踪人工号
	private String demandfollowempcode;
	// 需求跟踪人姓名
	private String demandfollowempname;
	// 系统需求接受时间
	private String demandacceptdate;
	// 系统需求类型
	private String demandtype;
	// 需求成效类型
	private String demandeffecttype;
	// 是否是主系统需求（默认1：是，0：不是）
	private int ismaindemand;
	// 备注
	private String remark;
	// 需求人提出工号
	private String sysdemandempcode;
	// 需求人提出名字
	private String sysdemandempname;
	// 需求人提出部门编号
	private String sysdemanddeptcode;
	// 需求人提出部门名字
	private String sysdemanddeptname;
	// 工作项id
	private String workid;
	// 流程表id
	private String processid;
	// 所属系统编码
	private String subsyscode;
	// 所属系统名字
	private String subsysname;
	// 系统分析人工号
	private String sysfenxicode;
	// 系统分析人名字
	private String sysfenxiname;
	// 涉及备注
	private String shejibeizhu;
	// 系统经办人工号
	private String sysjingbanrencode;
	// 系统经办人姓名
	private String sysjingbanrenname;
	// 系统需求类型中文名字
	private String demandtypename;
	//版本号
	private String sysversion;
	//邮箱
	private String sysfenxiemail;
	//计划开始时间
	private String planbegindate;
	//计划结束时间
	private String planenddate;
	//功能点
	private String funcPoint; 
	
	

	/**
	 * @return the funcPoint
	 */
	public String getFuncPoint() {
		return funcPoint;
	}

	/**
	 * @param funcPoint
	 */
	public void setFuncPoint(String funcPoint) {
		this.funcPoint = funcPoint;
	}

	/**
	 * @return the planbegindate
	 */
	public String getPlanbegindate() {
		return planbegindate;
	}

	/**
	 * @param planbegindate
	 */
	public void setPlanbegindate(String planbegindate) {
		this.planbegindate = planbegindate;
	}

	/**
	 * @return the planenddate
	 */
	public String getPlanenddate() {
		return planenddate;
	}

	/**
	 * @param planenddate
	 */
	public void setPlanenddate(String planenddate) {
		this.planenddate = planenddate;
	}

	/**
	 * @return the sysfenxiemail
	 */
	public String getSysfenxiemail() {
		return sysfenxiemail;
	}

	/**
	 * @param sysfenxiemail
	 */
	public void setSysfenxiemail(String sysfenxiemail) {
		this.sysfenxiemail = sysfenxiemail;
	}

	/**
	 * @return the sysversion
	 */
	public String getSysversion() {
		return sysversion;
	}

	/**
	 * @param sysversion
	 */
	public void setSysversion(String sysversion) {
		this.sysversion = sysversion;
	}

	/**
	 * @return the sysdemandid
	 */
	public long getSysdemandid() {
		return sysdemandid;
	}

	/**
	 * @param sysdemandid
	 *            the sysdemandid to set
	 */
	public void setSysdemandid(long sysdemandid) {
		this.sysdemandid = sysdemandid;
	}

	/**
	 * @return the sysdemandCode
	 */
	public String getSysdemandCode() {
		return sysdemandCode;
	}

	/**
	 * @param sysdemandCode
	 *            the sysdemandCode to set
	 */
	public void setSysdemandCode(String sysdemandCode) {
		this.sysdemandCode = sysdemandCode;
	}

	/**
	 * @return the userdemandCode
	 */
	public String getUserdemandCode() {
		return userdemandCode;
	}

	/**
	 * @param userdemandCode
	 *            the userdemandCode to set
	 */
	public void setUserdemandCode(String userdemandCode) {
		this.userdemandCode = userdemandCode;
	}

	/**
	 * @return the demandcatetory
	 */
	public String getDemandcatetory() {
		return demandcatetory;
	}

	/**
	 * @param demandcatetory
	 *            the demandcatetory to set
	 */
	public void setDemandcatetory(String demandcatetory) {
		this.demandcatetory = demandcatetory;
	}

	/**
	 * @return the demandfollowempcode
	 */
	public String getDemandfollowempcode() {
		return demandfollowempcode;
	}

	/**
	 * @param demandfollowempcode
	 *            the demandfollowempcode to set
	 */
	public void setDemandfollowempcode(String demandfollowempcode) {
		this.demandfollowempcode = demandfollowempcode;
	}

	/**
	 * @return the demandfollowempname
	 */
	public String getDemandfollowempname() {
		return demandfollowempname;
	}

	/**
	 * @param demandfollowempname
	 *            the demandfollowempname to set
	 */
	public void setDemandfollowempname(String demandfollowempname) {
		this.demandfollowempname = demandfollowempname;
	}

	/**
	 * @return the demandacceptdate
	 */
	public String getDemandacceptdate() {
		return demandacceptdate;
	}

	/**
	 * @param demandacceptdate
	 *            the demandacceptdate to set
	 */
	public void setDemandacceptdate(String demandacceptdate) {
		this.demandacceptdate = demandacceptdate;
	}

	/**
	 * @return the demandtype
	 */
	public String getDemandtype() {
		return demandtype;
	}

	/**
	 * @param demandtype
	 *            the demandtype to set
	 */
	public void setDemandtype(String demandtype) {
		this.demandtype = demandtype;
	}

	/**
	 * @return the demandeffecttype
	 */
	public String getDemandeffecttype() {
		return demandeffecttype;
	}

	/**
	 * @param demandeffecttype
	 *            the demandeffecttype to set
	 */
	public void setDemandeffecttype(String demandeffecttype) {
		this.demandeffecttype = demandeffecttype;
	}

	/**
	 * @return the ismaindemand
	 */
	public int getIsmaindemand() {
		return ismaindemand;
	}

	/**
	 * @param ismaindemand
	 *            the ismaindemand to set
	 */
	public void setIsmaindemand(int ismaindemand) {
		this.ismaindemand = ismaindemand;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the sysdemandempcode
	 */
	public String getSysdemandempcode() {
		return sysdemandempcode;
	}

	/**
	 * @param sysdemandempcode
	 *            the sysdemandempcode to set
	 */
	public void setSysdemandempcode(String sysdemandempcode) {
		this.sysdemandempcode = sysdemandempcode;
	}

	/**
	 * @return the sysdemandempname
	 */
	public String getSysdemandempname() {
		return sysdemandempname;
	}

	/**
	 * @param sysdemandempname
	 *            the sysdemandempname to set
	 */
	public void setSysdemandempname(String sysdemandempname) {
		this.sysdemandempname = sysdemandempname;
	}

	/**
	 * @return the sysdemanddeptcode
	 */
	public String getSysdemanddeptcode() {
		return sysdemanddeptcode;
	}

	/**
	 * @param sysdemanddeptcode
	 *            the sysdemanddeptcode to set
	 */
	public void setSysdemanddeptcode(String sysdemanddeptcode) {
		this.sysdemanddeptcode = sysdemanddeptcode;
	}

	/**
	 * @return the sysdemanddeptname
	 */
	public String getSysdemanddeptname() {
		return sysdemanddeptname;
	}

	/**
	 * @param sysdemanddeptname
	 *            the sysdemanddeptname to set
	 */
	public void setSysdemanddeptname(String sysdemanddeptname) {
		this.sysdemanddeptname = sysdemanddeptname;
	}

	/**
	 * @return the workid
	 */
	public String getWorkid() {
		return workid;
	}

	/**
	 * @param workid
	 *            the workid to set
	 */
	public void setWorkid(String workid) {
		this.workid = workid;
	}

	/**
	 * @return the processid
	 */
	public String getProcessid() {
		return processid;
	}

	/**
	 * @param processid
	 *            the processid to set
	 */
	public void setProcessid(String processid) {
		this.processid = processid;
	}

	/**
	 * @return the subsyscode
	 */
	public String getSubsyscode() {
		return subsyscode;
	}

	/**
	 * @param subsyscode
	 *            the subsyscode to set
	 */
	public void setSubsyscode(String subsyscode) {
		this.subsyscode = subsyscode;
	}

	/**
	 * @return the subsysname
	 */
	public String getSubsysname() {
		return subsysname;
	}

	/**
	 * @param subsysname
	 *            the subsysname to set
	 */
	public void setSubsysname(String subsysname) {
		this.subsysname = subsysname;
	}

	/**
	 * @return the sysfenxicode
	 */
	public String getSysfenxicode() {
		return sysfenxicode;
	}

	/**
	 * @param sysfenxicode
	 *            the sysfenxicode to set
	 */
	public void setSysfenxicode(String sysfenxicode) {
		this.sysfenxicode = sysfenxicode;
	}

	/**
	 * @return the sysfenxiname
	 */
	public String getSysfenxiname() {
		return sysfenxiname;
	}

	/**
	 * @param sysfenxiname
	 *            the sysfenxiname to set
	 */
	public void setSysfenxiname(String sysfenxiname) {
		this.sysfenxiname = sysfenxiname;
	}

	/**
	 * @return the shejibeizhu
	 */
	public String getShejibeizhu() {
		return shejibeizhu;
	}

	/**
	 * @param shejibeizhu
	 *            the shejibeizhu to set
	 */
	public void setShejibeizhu(String shejibeizhu) {
		this.shejibeizhu = shejibeizhu;
	}

	/**
	 * @return the sysjingbanrencode
	 */
	public String getSysjingbanrencode() {
		return sysjingbanrencode;
	}

	/**
	 * @param sysjingbanrencode
	 *            the sysjingbanrencode to set
	 */
	public void setSysjingbanrencode(String sysjingbanrencode) {
		this.sysjingbanrencode = sysjingbanrencode;
	}

	/**
	 * @return the sysjingbanrenname
	 */
	public String getSysjingbanrenname() {
		return sysjingbanrenname;
	}

	/**
	 * @param sysjingbanrenname
	 *            the sysjingbanrenname to set
	 */
	public void setSysjingbanrenname(String sysjingbanrenname) {
		this.sysjingbanrenname = sysjingbanrenname;
	}

	/**
	 * @return the demandtypename
	 */
	public String getDemandtypename() {
		return demandtypename;
	}

	/**
	 * @param demandtypename
	 *            the demandtypename to set
	 */
	public void setDemandtypename(String demandtypename) {
		this.demandtypename = demandtypename;
	}

}
