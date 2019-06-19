package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AdminOrgUnit;
/**
 * 
 * 工程项目结算单主表实体
 * @author hesiwei
 * @date 2013-10-25 上午09:45:57
 * @since
 * @version
 *
 */
public class ProjectClearEntity extends BaseEntity implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 5324236780931740344L;
	/**创建者*/
	private String fcreatorid;
	/**创建时间*/
	private Date fcreatetime;
	/**最后修改者*/
	private String flastupdateuserid;
	/**最后修改时间*/
	private Date flastupdatetime;
	/**控制单元*/
	private String fcontrolunitid;
	/**单据编号*/
	private String fnumber;
	/**业务日期*/
	private Date fbizdate;
	/**经手人*/
	private String fhandlerid;
	/**参考信息*/
	private String fdescription;
	/**是否曾经生效*/
	private Integer fhaseffected;
	/**审核人*/
	private String fauditorid;
	/**原始单据ID*/
	private String fsourcebillid;
	/**来源功能*/
	private String fsourcefunction;
	/**主键*/
	private String fid;
	/**是否生成凭证*/
	private Integer ffivouchered;
	/**项目编码ID*/
	private String cfprojectnoid;
	/**单据状态*/
	private String cfstate;
	/**工程项目名称*/
	private String cfprojectname;
	/**合同编号*/
	private String cfcontractno;
	/**合同名称*/
	private String cfcontractname;
	/**合同版本号*/
	private String cfcontractversionnumber;
	/**所属子公司*/
	private String cfsubordinatesubsi;
	/**合同总金额*/
	private BigDecimal cfcontractgrandtotal;
	/**已支付金额*/
	private BigDecimal cfalreadyamountpaid;
	/**结算类型ID*/
	private String cfseetlementstypes;
	/**本次结算金额*/
	private BigDecimal cfsettlementamount;
	/**本次支付比例*/
	private BigDecimal cfpayscale;
	/**已支付比例*/
	private BigDecimal cfalreadypayscale;
	/**完成百分比*/
	private BigDecimal cfpercentcomplete;
	/**结算日期*/
	private Date cfbalancedate;
	/**备注*/
	private String cfnote;
	/**审核时间*/
	private Date cfaudittime;
	/**创建部门ID*/
	private String fcreatorgid;
	/**预算项目类型ID*/
	private String fbudgetnameid;
	/**供应商ID*/
	private String fsupplierid;
	/**公司（财务组织）ID*/
	private String fcompanymid;
	
	//******配合界面显示新增字段**start*************************************
	/**所属子公司*/
	private AdminOrgUnit cfkaleidescope ;
	/**创建人工号*/
	private String applyPersonNo;
	/**创建人名称*/
	private String applyPersonName;
	/**创建人部门ID*/
	private String applyDeptId ;
	/**创建人部门名称*/
	private String applyDeptName ;
	
	/**结算类型名称*/
	private String cfseetlementstypesName;
	/**预算项目类型*/
	private String fbudgetname;
	/**供应商名称*/
	private String fsupplierName;
	/**公司（财务组织）名称*/
	private String fcompanyName;
	/**项目编码*/
	private String projectcode;
	//******配合界面显示新增字段**end****************************************
	
	//******************以下为借用字段，非表字段*****start********************
	/** 用户编码 */
	private String userCode ;
	/** 用户名称 */
	private String userName ;
	/** 部门标杆编码 */
	private String deptStandCode ;
	/** 部门名称 */
	private String deptName ;
	//******************以下为借用字段，非表字段*****end********************
	
	public String getFcreatorid() {
		return fcreatorid;
	}
	public void setFcreatorid(String fcreatorid) {
		this.fcreatorid = fcreatorid;
	}
	public Date getFcreatetime() {
		return fcreatetime;
	}
	public void setFcreatetime(Date fcreatetime) {
		this.fcreatetime = fcreatetime;
	}
	public String getFlastupdateuserid() {
		return flastupdateuserid;
	}
	public void setFlastupdateuserid(String flastupdateuserid) {
		this.flastupdateuserid = flastupdateuserid;
	}
	public Date getFlastupdatetime() {
		return flastupdatetime;
	}
	public void setFlastupdatetime(Date flastupdatetime) {
		this.flastupdatetime = flastupdatetime;
	}
	public String getFcontrolunitid() {
		return fcontrolunitid;
	}
	public void setFcontrolunitid(String fcontrolunitid) {
		this.fcontrolunitid = fcontrolunitid;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public Date getFbizdate() {
		return fbizdate;
	}
	public void setFbizdate(Date fbizdate) {
		this.fbizdate = fbizdate;
	}
	public String getFhandlerid() {
		return fhandlerid;
	}
	public void setFhandlerid(String fhandlerid) {
		this.fhandlerid = fhandlerid;
	}
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	public Integer getFhaseffected() {
		return fhaseffected;
	}
	public void setFhaseffected(Integer fhaseffected) {
		this.fhaseffected = fhaseffected;
	}
	public String getFauditorid() {
		return fauditorid;
	}
	public void setFauditorid(String fauditorid) {
		this.fauditorid = fauditorid;
	}
	public String getFsourcebillid() {
		return fsourcebillid;
	}
	public void setFsourcebillid(String fsourcebillid) {
		this.fsourcebillid = fsourcebillid;
	}
	public String getFsourcefunction() {
		return fsourcefunction;
	}
	public void setFsourcefunction(String fsourcefunction) {
		this.fsourcefunction = fsourcefunction;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Integer getFfivouchered() {
		return ffivouchered;
	}
	public void setFfivouchered(Integer ffivouchered) {
		this.ffivouchered = ffivouchered;
	}
	public String getCfprojectnoid() {
		return cfprojectnoid;
	}
	public void setCfprojectnoid(String cfprojectnoid) {
		this.cfprojectnoid = cfprojectnoid;
	}
	public String getCfstate() {
		return cfstate;
	}
	public void setCfstate(String cfstate) {
		this.cfstate = cfstate;
	}
	public String getCfprojectname() {
		return cfprojectname;
	}
	public void setCfprojectname(String cfprojectname) {
		this.cfprojectname = cfprojectname;
	}
	public String getCfcontractno() {
		return cfcontractno;
	}
	public void setCfcontractno(String cfcontractno) {
		this.cfcontractno = cfcontractno;
	}
	public String getCfcontractname() {
		return cfcontractname;
	}
	public void setCfcontractname(String cfcontractname) {
		this.cfcontractname = cfcontractname;
	}
	public String getCfcontractversionnumber() {
		return cfcontractversionnumber;
	}
	public void setCfcontractversionnumber(String cfcontractversionnumber) {
		this.cfcontractversionnumber = cfcontractversionnumber;
	}
	public String getCfsubordinatesubsi() {
		return cfsubordinatesubsi;
	}
	public void setCfsubordinatesubsi(String cfsubordinatesubsi) {
		this.cfsubordinatesubsi = cfsubordinatesubsi;
	}
	public BigDecimal getCfcontractgrandtotal() {
		return cfcontractgrandtotal;
	}
	public void setCfcontractgrandtotal(BigDecimal cfcontractgrandtotal) {
		this.cfcontractgrandtotal = cfcontractgrandtotal;
	}
	public BigDecimal getCfalreadyamountpaid() {
		return cfalreadyamountpaid;
	}
	public void setCfalreadyamountpaid(BigDecimal cfalreadyamountpaid) {
		this.cfalreadyamountpaid = cfalreadyamountpaid;
	}
	public String getCfseetlementstypes() {
		return cfseetlementstypes;
	}
	public void setCfseetlementstypes(String cfseetlementstypes) {
		this.cfseetlementstypes = cfseetlementstypes;
	}
	public BigDecimal getCfsettlementamount() {
		return cfsettlementamount;
	}
	public void setCfsettlementamount(BigDecimal cfsettlementamount) {
		this.cfsettlementamount = cfsettlementamount;
	}
	public BigDecimal getCfpayscale() {
		return cfpayscale;
	}
	public void setCfpayscale(BigDecimal cfpayscale) {
		this.cfpayscale = cfpayscale;
	}
	public BigDecimal getCfalreadypayscale() {
		return cfalreadypayscale;
	}
	public void setCfalreadypayscale(BigDecimal cfalreadypayscale) {
		this.cfalreadypayscale = cfalreadypayscale;
	}
	public BigDecimal getCfpercentcomplete() {
		return cfpercentcomplete;
	}
	public void setCfpercentcomplete(BigDecimal cfpercentcomplete) {
		this.cfpercentcomplete = cfpercentcomplete;
	}
	public Date getCfbalancedate() {
		return cfbalancedate;
	}
	public void setCfbalancedate(Date cfbalancedate) {
		this.cfbalancedate = cfbalancedate;
	}
	public String getCfnote() {
		return cfnote;
	}
	public void setCfnote(String cfnote) {
		this.cfnote = cfnote;
	}
	public Date getCfaudittime() {
		return cfaudittime;
	}
	public void setCfaudittime(Date cfaudittime) {
		this.cfaudittime = cfaudittime;
	}
	public String getFcreatorgid() {
		return fcreatorgid;
	}
	public void setFcreatorgid(String fcreatorgid) {
		this.fcreatorgid = fcreatorgid;
	}
	public String getFbudgetnameid() {
		return fbudgetnameid;
	}
	public void setFbudgetnameid(String fbudgetnameid) {
		this.fbudgetnameid = fbudgetnameid;
	}
	public String getFsupplierid() {
		return fsupplierid;
	}
	public void setFsupplierid(String fsupplierid) {
		this.fsupplierid = fsupplierid;
	}
	public String getFcompanymid() {
		return fcompanymid;
	}
	public void setFcompanymid(String fcompanymid) {
		this.fcompanymid = fcompanymid;
	}
	public String getApplyDeptId() {
		return applyDeptId;
	}
	public void setApplyDeptId(String applyDeptId) {
		this.applyDeptId = applyDeptId;
	}
	public String getApplyDeptName() {
		return applyDeptName;
	}
	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}
	public AdminOrgUnit getCfkaleidescope() {
		return cfkaleidescope;
	}
	public void setCfkaleidescope(AdminOrgUnit cfkaleidescope) {
		this.cfkaleidescope = cfkaleidescope;
	}
	public String getFcompanyName() {
		return fcompanyName;
	}
	public void setFcompanyName(String fcompanyName) {
		this.fcompanyName = fcompanyName;
	}
	public String getFsupplierName() {
		return fsupplierName;
	}
	public void setFsupplierName(String fsupplierName) {
		this.fsupplierName = fsupplierName;
	}
	public String getCfseetlementstypesName() {
		return cfseetlementstypesName;
	}
	public void setCfseetlementstypesName(String cfseetlementstypesName) {
		this.cfseetlementstypesName = cfseetlementstypesName;
	}
	public String getApplyPersonNo() {
		return applyPersonNo;
	}
	public void setApplyPersonNo(String applyPersonNo) {
		this.applyPersonNo = applyPersonNo;
	}
	public String getApplyPersonName() {
		return applyPersonName;
	}
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	public String getFbudgetname() {
		return fbudgetname;
	}
	public void setFbudgetname(String fbudgetname) {
		this.fbudgetname = fbudgetname;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptStandCode() {
		return deptStandCode;
	}
	public void setDeptStandCode(String deptStandCode) {
		this.deptStandCode = deptStandCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
}
