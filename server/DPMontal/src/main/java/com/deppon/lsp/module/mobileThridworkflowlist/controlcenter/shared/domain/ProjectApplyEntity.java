package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 作者（修改人）：YangMing
 * 修改时间：2013-9-2 下午5:09:25
 * 描述：工程项目申请单表头 实体
 * 更新记录：
 */
public class ProjectApplyEntity extends BaseEntity implements Serializable{
	
	/**序列号*/
	private static final long serialVersionUID = -724278951429834964L;
	/**创建者*/
	private String fcreatorid;
	/**创建时间*/
	private Date fcreatetime;
	/**最后修改者id*/
	private String flastupdateuserid;
	/**最后修改时间*/
	private Date flastupdatetime;
	/**控制单元*/
	private String fcontrolunitid;
	/**工程编号*/
	private String fnumber;
	/**申请时间*/
	private Date fbizdate;
	/**经手人id*/
	private String fhandlerid;
	/**参考信息*/
	private String fdescription;
	/**是否曾经生效*/
	private BigDecimal fhaseffected;
	/**审核人*/
	private String fauditorid;
	/**原始单据id*/
	private String fsourcebillid;
	/**来源功能*/
	private String fsourcefunction;
	/**单据id*/
	private String fid;
	/**是否生成凭证*/
	private BigDecimal ffivouchered; 
	
	/**项目类型*/
	private String cfprojecttype;
	/**工程项目名称*/
	private String cfprojectname;
	/**非网点分类*/
	private String cfbranchtypeid;
	/**项目级别*/
	private String cfprojectlevel;
	/**施工类型*/
	private String cfconstructtypeid;
	/**项目所在地*/
	private String cfprojectplace;
	/**所属区域*/
	private String cfregionid;
	/**所属事业部*/
	private String cfbusinessdivision;
	/**项目负责部门*/
	private String cfprojectdepartmen;
	/**评分值*/
	private BigDecimal cfgrade; 
	/**工程项目经理*/
	private String cfprojectmanagerid;
	/**所属子公司*/
	private String cfkaleidescopeid;
	/**是否深化设计*/
	private BigDecimal cfdeependesign;
	/**出发*/
	private BigDecimal cfstart; 
	/**备注*/
	private String cfremark;
	/**布尔*/
	private BigDecimal cfbimudf0023; 
	/**派送*/
	private BigDecimal cfsend;
	/**自提*/
	private BigDecimal cftake;
	/**集中接货 */
	private BigDecimal cfreceipt;
	/**泡货*/
	private BigDecimal cflightcargo;
	/**重货*/
	private BigDecimal cfheavycargo;
	/**场外需要提货柜台*/
	private BigDecimal cfouttake;
	/**场外柜台需要强弱电位*/
	private BigDecimal cfoutdoor;
	/**地磅*/
	private BigDecimal cfweighbridge;
	/**电子秤*/
	private BigDecimal cfelectronic;
	/**会议室*/
	private BigDecimal cfconferenceroom;
	/**客服办公区*/
	private BigDecimal cfservicearea;
	/**卫生间*/
	private BigDecimal cfwashroom;
	/**宿舍*/
	private BigDecimal cfbreedroom;
	/**打印机配置*/
	private BigDecimal cfmarking;
	/**柜台*/
	private BigDecimal cfcounter;
	/**审核时间*/
	private Date cfaudittime;
	/**制单日期*/
	private Date cfmakeadddate;
	/**项目编号*/
	private String cfprojectnumberid;
	/**单据状态*/
	private String fstate;
	/**制单人*/
	private String flistperosnid;
	/**制单部门*/
	private String fpersondepartmenti;
	/**项目状态*/
	private String fprojectty;
	/**备注*/
	private String fremake;
	/**施工类型*/
	private String fconttype;
	/**叉车秤*/
	private BigDecimal fforkliftscales;
	/**是否补录数据*/
	private BigDecimal cfishistorydata;
	/**场地*/
	private BigDecimal cfyard;
	/**区域*/
	private BigDecimal cfparea;
	/**所属区域*/
	private AdminOrgUnit cfregion ;
	/**所属事业部*/
	private AdminOrgUnit cfbusinessdivisionName ;
	/**所属子公司*/
	private AdminOrgUnit cfkaleidescope ;
	/**项目负责部门*/
	private AdminOrgUnit cfprojectdepartmenName ;
	/**项目经理*/
	private Person cfprojectmanager ;
	/**非网店分类*/
	private NotPointEntity cfbranchtype ;
	/**申请人*/
	private Person flistperson ;
	/**申请人部门*/
	private AdminOrgUnit fpersondept ;
	/**是否全国供应商 */
	private BigDecimal cfIsNationalSupplier;
	/**是否卫星点部*/
	private String fissatellitePoint;
	/**计划网点年份*/
	private String cfplanyear;
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
	/**
	 * 
	 * @return
	 */
	
	
	/****************************************新加字段为BigDecimal对应的转换**************************/
	/**是否曾经生效***/
	private String fhaseffectedDto;
	/**是否生成凭证***/
	private String ffivoucheredDto;
	/****评分值************/
	private String cfgradeDto;
	/**是否深化设计*/
	/**出发*/
	private String cfdeependesignDto; 
	private String cfstartDto; 
	/**备注*/
	private String cfremarkDto;
	/**布尔*/
	private String cfbimudf0023Dto; 
	/**派送*/
	private String cfsendDto;
	/**自提*/
	private String cftakeDto;
	/**集中接货 */
	private String cfreceiptDto;
	/**泡货*/
	private String cflightcargoDto;
	/**重货*/
	private String cfheavycargoDto;
	/**场外需要提货柜台*/
	private String cfouttakeDto;
	/**场外柜台需要强弱电位*/
	private String cfoutdoorDto;
	/**地磅*/
	private String cfweighbridgeDto;
	/**电子秤*/
	private String cfelectronicDto;
	/**会议室*/
	private String cfconferenceroomDto;
	/**客服办公区*/
	private String cfserviceareaDto;
	/**卫生间*/
	private String cfwashroomDto;
	/**宿舍*/
	private String cfbreedroomDto;
	/**打印机配置*/
	private String cfmarkingDto;
	/**柜台*/
	private String cfcounterDto;
	
	
	
	

	public String getCfplanyear() {
		return cfplanyear;
	}
	/**
	 * 
	 * @param cfplanyear
	 */
	public void setCfplanyear(String cfplanyear) {
		this.cfplanyear = cfplanyear;
	}
	/**
	 * 
	 * 描述： 用户名称
	 * @author yangming
	 * @date 2013-9-27 上午10:02:54
	 * @return
	 * 更新记录：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 * 描述： 用户名称 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:02:54
	 * @return
	 * 更新记录：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * 描述： 部门标杆编码
	 * @author yangming
	 * @date 2013-9-27 上午10:03:17
	 * @return
	 * 更新记录：
	 */
	public String getDeptStandCode() {
		return deptStandCode;
	}
	/**
	 * 
	 * 描述： 部门标杆编码 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:03:17
	 * @return
	 * 更新记录：
	 */
	public void setDeptStandCode(String deptStandCode) {
		this.deptStandCode = deptStandCode;
	}
	/**
	 * 
	 * 描述： 部门名称
	 * @author yangming
	 * @date 2013-9-27 上午10:03:33
	 * @return
	 * 更新记录：
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 
	 * 描述： 部门名称
	 * @author yangming
	 * @date 2013-9-27 上午10:03:33
	 * @return
	 * 更新记录：
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 
	 * 描述： 用户编码
	 * @author yangming
	 * @date 2013-9-27 上午10:03:33
	 * @return
	 * 更新记录：
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 
	 * 描述： 用户编码 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:03:33
	 * @return
	 * 更新记录：
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 
	 * 描述： 创建者
	 * @author yangming
	 * @date 2013-9-27 上午10:04:09
	 * @param fcreatorid
	 * 更新记录：
	 */
	public void setFcreatorid(String fcreatorid){
		this.fcreatorid=fcreatorid;
	}
	/**
	 * 
	 * 描述： 创建者
	 * @author yangming
	 * @date 2013-9-27 上午10:04:09
	 * @param fcreatorid
	 * 更新记录：
	 */
	public String getFcreatorid(){
		return fcreatorid;
	}
	/**
	 * 
	 * 描述： 创建时间
	 * @author yangming
	 * @date 2013-9-27 上午10:04:09
	 * @param fcreatorid
	 * 更新记录：
	 */
	public void setFcreatetime(Date fcreatetime){
		this.fcreatetime=fcreatetime;
	}
	/**
	 * 
	 * 描述： 创建时间 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:04:09
	 * @param fcreatorid
	 * 更新记录：
	 */
	public Date getFcreatetime(){
		return fcreatetime;
	}
	/**
	 * 
	 * 描述： 最后修改者
	 * @author yangming
	 * @date 2013-9-27 上午10:04:39
	 * @param flastupdateuserid
	 * 更新记录：
	 */
	public void setFlastupdateuserid(String flastupdateuserid){
		this.flastupdateuserid=flastupdateuserid;
	}
	/**
	 * 
	 * 描述： 最后修改者 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:04:39
	 * @param flastupdateuserid
	 * 更新记录：
	 */
	public String getFlastupdateuserid(){
		return flastupdateuserid;
	}
	/**
	 * 
	 * 描述： 最后修改时间
	 * @author yangming
	 * @date 2013-9-27 上午10:05:04
	 * @param flastupdatetime
	 * 更新记录：
	 */
	public void setFlastupdatetime(Date flastupdatetime){
		this.flastupdatetime=flastupdatetime;
	}
	/**
	 * 
	 * 描述： 最后修改时间 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:05:04
	 * @param flastupdatetime
	 * 更新记录：
	 */
	public Date getFlastupdatetime(){
		return flastupdatetime;
	}
	/**
	 * 
	 * 描述： 控制单元
	 * @author yangming
	 * @date 2013-9-27 上午10:11:35
	 * @param fcontrolunitid
	 * 更新记录：
	 */
	public void setFcontrolunitid(String fcontrolunitid){
		this.fcontrolunitid=fcontrolunitid;
	}
	/**
	 * 
	 * 描述： 控制单元 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:11:35
	 * @param fcontrolunitid
	 * 更新记录：
	 */
	public String getFcontrolunitid(){
		return fcontrolunitid;
	}
	/**
	 * 
	 * 描述： 单据编码
	 * @author yangming
	 * @date 2013-9-27 上午10:12:04
	 * @param fnumber
	 * 更新记录：
	 */
	public void setFnumber(String fnumber){
		this.fnumber=fnumber;
	}
	/**
	 * 
	 * 描述： 单据编码 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:12:04
	 * @param fnumber
	 * 更新记录：
	 */
	public String getFnumber(){
		return fnumber;
	}
	/**
	 * 
	 * 描述： 申请时间 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:12:04
	 * @param fnumber
	 * 更新记录：
	 */
	public void setFbizdate(Date fbizdate){
		this.fbizdate=fbizdate;
	}
	/**
	 * 
	 * 描述： 申请时间 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:13:24
	 * @return
	 * 更新记录：
	 */
	public Date getFbizdate(){
		return fbizdate;
	}
	/**
	 * 
	 * 描述： 经手人id
	 * @author yangming
	 * @date 2013-9-27 上午10:14:07
	 * @param fhandlerid
	 * 更新记录：
	 */
	public void setFhandlerid(String fhandlerid){
		this.fhandlerid=fhandlerid;
	}
	/**
	 * 
	 * 描述： 经手人id getter
	 * @author yangming
	 * @date 2013-9-27 上午10:14:07
	 * @param fhandlerid
	 * 更新记录：
	 */
	public String getFhandlerid(){
		return fhandlerid;
	}
	/**
	 * 
	 * 描述： 参考信息
	 * @author yangming
	 * @date 2013-9-27 上午10:14:39
	 * @param fdescription
	 * 更新记录：
	 */
	public void setFdescription(String fdescription){
		this.fdescription=fdescription;
	}
	/**
	 * 
	 * 描述： 参考信息
	 * @author yangming
	 * @date 2013-9-27 上午10:14:59
	 * @return
	 * 更新记录：
	 */
	public String getFdescription(){
		return fdescription;
	}
	/**
	 * 
	 * 描述： 是否曾经生效
	 * @author yangming
	 * @date 2013-9-27 上午10:15:11
	 * @param fhaseffected
	 * 更新记录：
	 */
	public void setFhaseffected(BigDecimal fhaseffected){
		this.fhaseffected=fhaseffected;
	}
	
	
	/**
	 * 
	 * 描述： 是否曾经生效 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:15:11
	 * @param fhaseffected
	 * 更新记录：
	 */
	public BigDecimal getFhaseffected(){
		return fhaseffected;
	}
	/**
	 * 
	 * 描述： 审核人
	 * @author yangming
	 * @date 2013-9-27 上午10:15:32
	 * @param fauditorid
	 * 更新记录：
	 */
	public void setFauditorid(String fauditorid){
		this.fauditorid=fauditorid;
	}
	/**
	 * 
	 * 描述： 审核人 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:15:44
	 * @return
	 * 更新记录：
	 */
	public String getFauditorid(){
		return fauditorid;
	}
	/**
	 * 
	 * 描述： 原始单据id setter
	 * @author yangming
	 * @date 2013-9-27 上午10:15:57
	 * @param fsourcebillid
	 * 更新记录：
	 */
	public void setFsourcebillid(String fsourcebillid){
		this.fsourcebillid=fsourcebillid;
	}
	/**
	 * 
	 * 描述： 原始单据id getter
	 * @author yangming
	 * @date 2013-9-27 上午10:16:14
	 * @return
	 * 更新记录：
	 */
	public String getFsourcebillid(){
		return fsourcebillid;
	}
	/**
	 * 
	 * 描述： 来源功能
	 * @author yangming
	 * @date 2013-9-27 上午10:16:26
	 * @param fsourcefunction
	 * 更新记录：
	 */
	public void setFsourcefunction(String fsourcefunction){
		this.fsourcefunction=fsourcefunction;
	}
	/**
	 * 
	 * 描述： 来源功能
	 * @author yangming
	 * @date 2013-9-27 上午10:16:26
	 * @param fsourcefunction
	 * 更新记录：
	 */
	public String getFsourcefunction(){
		return fsourcefunction;
	}
	/**
	 * 
	 * 描述： 单据fid
	 * @author yangming
	 * @date 2013-9-27 上午10:16:44
	 * @param fid
	 * 更新记录：
	 */
	public void setFid(String fid){
		this.fid=fid;
	}
	/**
	 *  
	 * 描述： 单据fid getter
	 * @author yangming
	 * @date 2013-9-27 上午10:16:44
	 * @param fid
	 * 更新记录：
	 */
	public String getFid(){
		return fid;
	}
	/**
	 *  
	 * 描述： 是否生成凭证 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:16:44 
	 * @param fid
	 * 更新记录：
	 */
	public void setFfivouchered(BigDecimal ffivouchered){
		this.ffivouchered=ffivouchered;
	}
	/**
	 *  
	 * 描述： 是否生成凭证 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:16:44 
	 * @param fid
	 * 更新记录：
	 */
	public BigDecimal getFfivouchered(){
		return ffivouchered;
	}
	/**
	 * 
	 * 描述： 项目类型
	 * @author yangming
	 * @date 2013-9-27 上午10:17:39
	 * @param cfprojecttype
	 * 更新记录：
	 */
	public void setCfprojecttype(String cfprojecttype){
		this.cfprojecttype=cfprojecttype;
	}
	/**
	 * 
	 * 描述： 项目类型
	 * @author yangming
	 * @date 2013-9-27 上午10:17:51
	 * @return
	 * 更新记录：
	 */
	public String getCfprojecttype(){
		return cfprojecttype;
	}
	/**
	 * 
	 * 描述： 工程项目名称
	 * @author yangming
	 * @date 2013-9-27 上午10:17:57
	 * @param cfprojectname
	 * 更新记录：
	 */
	public void setCfprojectname(String cfprojectname){
		this.cfprojectname=cfprojectname;
	}
	/**
	 * 
	 * 描述： 工程项目名称
	 * @author yangming
	 * @date 2013-9-27 上午10:17:57
	 * @param cfprojectname
	 * 更新记录：
	 */
	public String getCfprojectname(){
		return cfprojectname;
	}
	/**
	 * 
	 * 描述： 非网点分类
	 * @author yangming
	 * @date 2013-9-27 上午10:17:57
	 * @param cfprojectname
	 * 更新记录：
	 */
	public void setCfbranchtypeid(String cfbranchtypeid){
		this.cfbranchtypeid=cfbranchtypeid;
	}
	/**
	 * 
	 * 描述： 非网点分类
	 * @author yangming
	 * @date 2013-9-27 上午10:17:57
	 * @param cfprojectname
	 * 更新记录：
	 */
	public String getCfbranchtypeid(){
		return cfbranchtypeid;
	}
	/**
	 * 
	 * 描述： 项目级别
	 * @author yangming
	 * @date 2013-9-27 上午10:18:26
	 * @param cfprojectlevel
	 * 更新记录：
	 */
	public void setCfprojectlevel(String cfprojectlevel){
		this.cfprojectlevel=cfprojectlevel;
	}
	/**
	 * 
	 * 描述： 项目级别 get
	 * @author yangming
	 * @date 2013-9-27 上午10:18:26
	 * @param cfprojectlevel
	 * 更新记录：
	 */
	public String getCfprojectlevel(){
		return cfprojectlevel;
	}
	/**
	 * 
	 * 描述： 施工类型 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:18:45
	 * @param cfconstructtypeid
	 * 更新记录：
	 */
	public void setCfconstructtypeid(String cfconstructtypeid){
		this.cfconstructtypeid=cfconstructtypeid;
	}
	/**
	 * 
	 * 描述： 施工类型 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:18:57
	 * @return
	 * 更新记录：
	 */
	public String getCfconstructtypeid(){
		return cfconstructtypeid;
	}
	/**
	 * 
	 * 描述： 项目所在地
	 * @author yangming
	 * @date 2013-9-27 上午10:19:08
	 * @param cfprojectplace
	 * 更新记录：
	 */
	public void setCfprojectplace(String cfprojectplace){
		this.cfprojectplace=cfprojectplace;
	}
	/**
	 * 
	 * 描述： cfprojectplace getter
	 * @author yangming
	 * @date 2013-9-27 上午10:19:18
	 * @return
	 * 更新记录：
	 */
	public String getCfprojectplace(){
		return cfprojectplace;
	}
	/**
	 * 
	 * 描述： 所属区域
	 * @author yangming
	 * @date 2013-9-27 上午10:19:32
	 * @param cfregionid
	 * 更新记录：
	 */
	public void setCfregionid(String cfregionid){
		this.cfregionid=cfregionid;
	}
	/**
	 * 
	 * 描述：  所属区域 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:19:43
	 * @return
	 * 更新记录：
	 */
	public String getCfregionid(){
		return cfregionid;
	}
	/**
	 * 
	 * 描述： 所属事业部
	 * @author yangming
	 * @date 2013-9-27 上午10:19:56
	 * @param cfbusinessdivision
	 * 更新记录：
	 */
	public void setCfbusinessdivision(String cfbusinessdivision){
		this.cfbusinessdivision=cfbusinessdivision;
	}
	/**
	 * 
	 * 描述： 所属事业部
	 * @author yangming
	 * @date 2013-9-27 上午10:20:08
	 * @return
	 * 更新记录：
	 */
	public String getCfbusinessdivision(){
		return cfbusinessdivision;
	}
	/**
	 * 
	 * 描述： 项目负责部门
	 * @author yangming
	 * @date 2013-9-27 上午10:20:08
	 * @return
	 * 更新记录：
	 */
	public void setCfprojectdepartmen(String cfprojectdepartmen){
		this.cfprojectdepartmen=cfprojectdepartmen;
	}
	/**
	 * 
	 * 描述：项目负责部门 
	 * @author yangming
	 * @date 2013-9-27 上午10:20:47
	 * @return
	 * 更新记录：
	 */
	public String getCfprojectdepartmen(){
		return cfprojectdepartmen;
	}
	/**
	 * 
	 * 描述： 评分值
	 * @author yangming
	 * @date 2013-9-27 上午10:20:52
	 * @param cfgrade
	 * 更新记录：
	 */
	public void setCfgrade(BigDecimal cfgrade){
		this.cfgrade=cfgrade;
	}
	/**
	 * 
	 * 描述： 评分值 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:21:04
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfgrade(){
		return cfgrade;
	}
	/**
	 * 
	 * 描述： 工程项目经理
	 * @author yangming
	 * @date 2013-9-27 上午10:21:14
	 * @param cfprojectmanagerid
	 * 更新记录：
	 */
	public void setCfprojectmanagerid(String cfprojectmanagerid){
		this.cfprojectmanagerid=cfprojectmanagerid;
	}
	/**
	 * 
	 * 描述： 工程项目经理
	 * @author yangming
	 * @date 2013-9-27 上午10:21:23
	 * @return
	 * 更新记录：
	 */
	public String getCfprojectmanagerid(){
		return cfprojectmanagerid;
	}
	/**
	 * 
	 * 描述： 所属子公司
	 * @author yangming
	 * @date 2013-9-27 上午10:21:35
	 * @param cfkaleidescopeid
	 * 更新记录：
	 */
	public void setCfkaleidescopeid(String cfkaleidescopeid){
		this.cfkaleidescopeid=cfkaleidescopeid;
	}
	/**
	 * 
	 * 描述： 所属子公司
	 * @author yangming
	 * @date 2013-9-27 上午10:21:46
	 * @return
	 * 更新记录：
	 */
	public String getCfkaleidescopeid(){
		return cfkaleidescopeid;
	}
	/**
	 * 
	 * 描述： 是否深化设计
	 * @author yangming
	 * @date 2013-9-27 上午10:21:54
	 * @param cfdeependesign
	 * 更新记录：
	 */
	public void setCfdeependesign(BigDecimal cfdeependesign){
		this.cfdeependesign=cfdeependesign;
	}
	/**
	 * 
	 * 描述： 是否深化设计 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:22:05
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfdeependesign(){
		return cfdeependesign;
	}
	/**
	 * 
	 * 描述： 出发
	 * @author yangming
	 * @date 2013-9-27 上午10:22:21
	 * @param cfstart
	 * 更新记录：
	 */
	public void setCfstart(BigDecimal cfstart){
		this.cfstart=cfstart;
	}
	/**
	 * 
	 * 描述： 出发
	 * @author yangming
	 * @date 2013-9-27 上午10:22:31
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfstart(){
		return cfstart;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午10:22:41
	 * @param cfremark
	 * 更新记录：
	 */
	public void setCfremark(String cfremark){
		this.cfremark=cfremark;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午10:22:50
	 * @return
	 * 更新记录：
	 */
	public String getCfremark(){
		return cfremark;
	}
	/**
	 * 
	 * 描述： 预留字段
	 * @author yangming
	 * @date 2013-9-27 上午10:22:58
	 * @param cfbimudf0023
	 * 更新记录：
	 */
	public void setCfbimudf0023(BigDecimal cfbimudf0023){
		this.cfbimudf0023=cfbimudf0023;
	}
	/**
	 * 
	 * 描述： 预留字段
	 * @author yangming
	 * @date 2013-9-27 上午10:22:58
	 * @param cfbimudf0023
	 * 更新记录：
	 */
	public BigDecimal getCfbimudf0023(){
		return cfbimudf0023;
	}
	/**
	 * 
	 * 描述： 派送
	 * @author yangming
	 * @date 2013-9-27 上午10:23:13
	 * @param cfsend
	 * 更新记录：
	 */
	public void setCfsend(BigDecimal cfsend){
		this.cfsend=cfsend;
	}
	/**
	 * 
	 * 描述： 派送 get
	 * @author yangming
	 * @date 2013-9-27 上午10:23:21
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfsend(){
		return cfsend;
	}
	/**
	 * 
	 * 描述： 自提
	 * @author yangming
	 * @date 2013-9-27 上午10:23:33
	 * @param cftake
	 * 更新记录：
	 */
	public void setCftake(BigDecimal cftake){
		this.cftake=cftake;
	}
	/**
	 * 
	 * 描述： 自提 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:23:46
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCftake(){
		return cftake;
	}
	/**
	 * 
	 * 描述： 集中接货
	 * @author yangming
	 * @date 2013-9-27 上午10:23:59
	 * @param cfreceipt
	 * 更新记录：
	 */
	public void setCfreceipt(BigDecimal cfreceipt){
		this.cfreceipt=cfreceipt;
	}
	/**
	 * 
	 * 描述： 集中接货 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:23:59
	 * @param cfreceipt
	 * 更新记录：
	 */
	public BigDecimal getCfreceipt(){
		return cfreceipt;
	}
	/**
	 * 
	 * 描述： 泡货
	 * @author yangming
	 * @date 2013-9-27 上午10:24:27
	 * @param cflightcargo
	 * 更新记录：
	 */
	public void setCflightcargo(BigDecimal cflightcargo){
		this.cflightcargo=cflightcargo;
	}
	/**
	 * 
	 * 描述： 泡货
	 * @author yangming
	 * @date 2013-9-27 上午10:24:27
	 * @param cflightcargo
	 * 更新记录：
	 */
	public BigDecimal getCflightcargo(){
		return cflightcargo;
	}
	/**
	 * 
	 * 描述： 重货
	 * @author yangming
	 * @date 2013-9-27 上午10:24:45
	 * @param cfheavycargo
	 * 更新记录：
	 */
	public void setCfheavycargo(BigDecimal cfheavycargo){
		this.cfheavycargo=cfheavycargo;
	}
	/**
	 * 
	 * 描述： 重货
	 * @author yangming
	 * @date 2013-9-27 上午10:24:45
	 * @param cfheavycargo
	 * 更新记录：
	 */
	public BigDecimal getCfheavycargo(){
		return cfheavycargo;
	}
	/**
	 * 
	 * 描述： 场外需要提货柜台
	 * @author yangming
	 * @date 2013-9-27 上午10:25:06
	 * @param cfouttake
	 * 更新记录：
	 */
	public void setCfouttake(BigDecimal cfouttake){
		this.cfouttake=cfouttake;
	}
	/**
	 * 
	 * 描述： 场外需要提货柜台
	 * @author yangming
	 * @date 2013-9-27 上午10:25:06
	 * @param cfouttake
	 * 更新记录：
	 */
	public BigDecimal getCfouttake(){
		return cfouttake;
	}
	/**
	 * 
	 * 描述： 场外柜台需要强弱电位
	 * @author yangming
	 * @date 2013-9-27 上午10:27:02
	 * @param cfoutdoor
	 * 更新记录：
	 */
	public void setCfoutdoor(BigDecimal cfoutdoor){
		this.cfoutdoor=cfoutdoor;
	}
	/**
	 * 
	 * 描述： 场外柜台需要强弱电位 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:27:02
	 * @param cfoutdoor
	 * 更新记录：
	 */
	public BigDecimal getCfoutdoor(){
		return cfoutdoor;
	}
	/**
	 * 
	 * 描述： 地磅
	 * @author yangming
	 * @date 2013-9-27 上午10:27:19
	 * @param cfweighbridge
	 * 更新记录：
	 */
	public void setCfweighbridge(BigDecimal cfweighbridge){
		this.cfweighbridge=cfweighbridge;
	}
	/**
	 * 
	 * 描述： 地磅 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:27:29
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfweighbridge(){
		return cfweighbridge;
	}
	/**
	 * 
	 * 描述： 电子秤
	 * @author yangming
	 * @date 2013-9-27 上午10:27:40
	 * @param cfelectronic
	 * 更新记录：
	 */
	public void setCfelectronic(BigDecimal cfelectronic){
		this.cfelectronic=cfelectronic;
	}
	/**
	 * 
	 * 描述： 电子秤
	 * @author yangming
	 * @date 2013-9-27 上午10:27:49
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfelectronic(){
		return cfelectronic;
	}
	/**
	 * 
	 * 描述： 会议室
	 * @author yangming
	 * @date 2013-9-27 上午10:27:56
	 * @param cfconferenceroom
	 * 更新记录：
	 */
	public void setCfconferenceroom(BigDecimal cfconferenceroom){
		this.cfconferenceroom=cfconferenceroom;
	}
	/**
	 * 
	 * 描述： 会议室
	 * @author yangming
	 * @date 2013-9-27 上午10:28:05
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfconferenceroom(){
		return cfconferenceroom;
	}
	/**
	 * 
	 * 描述： 客服办公区
	 * @author yangming
	 * @date 2013-9-27 上午10:28:16
	 * @param cfservicearea
	 * 更新记录：
	 */
	public void setCfservicearea(BigDecimal cfservicearea){
		this.cfservicearea=cfservicearea;
	}
	/**
	 * 
	 * 描述： 客服办公区 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:31:02
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfservicearea(){
		return cfservicearea;
	}
	/**
	 * 
	 * 描述： 卫生间
	 * @author yangming
	 * @date 2013-9-27 上午10:31:11
	 * @param cfwashroom
	 * 更新记录：
	 */
	public void setCfwashroom(BigDecimal cfwashroom){
		this.cfwashroom=cfwashroom;
	}
	/**
	 * 
	 * 描述： 卫生间 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:31:11
	 * @param cfwashroom
	 * 更新记录：
	 */
	public BigDecimal getCfwashroom(){
		return cfwashroom;
	}
	/**
	 * 
	 * 描述： 宿舍
	 * @author yangming
	 * @date 2013-9-27 上午10:31:27
	 * @param cfbreedroom
	 * 更新记录：
	 */
	public void setCfbreedroom(BigDecimal cfbreedroom){
		this.cfbreedroom=cfbreedroom;
	}
	/**
	 * 
	 * 描述： 宿舍
	 * @author yangming
	 * @date 2013-9-27 上午10:31:40
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfbreedroom(){
		return cfbreedroom;
	}
	/**
	 * 
	 * 描述： 打印机配置
	 * @author yangming
	 * @date 2013-9-27 上午10:31:47
	 * @param cfmarking
	 * 更新记录：
	 */
	public void setCfmarking(BigDecimal cfmarking){
		if(cfmarking == null){
			cfmarking = BigDecimal.valueOf(0);
		}
		this.cfmarking=cfmarking;
	}
	/**
	 * 
	 * 描述：打印机配置 
	 * @author yangming
	 * @date 2013-9-27 上午10:31:58
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfmarking(){
		return cfmarking;
	}
	/**
	 * 
	 * 描述： 柜台
	 * @author yangming
	 * @date 2013-9-27 上午10:32:11
	 * @param cfcounter
	 * 更新记录：
	 */
	public void setCfcounter(BigDecimal cfcounter){
		this.cfcounter=cfcounter;
	}
	/**
	 * 
	 * 描述： 柜台
	 * @author yangming
	 * @date 2013-9-27 上午10:32:20
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfcounter(){
		return cfcounter;
	}
	/**
	 * 
	 * 描述： 审核时间
	 * @author yangming
	 * @date 2013-9-27 上午10:32:28
	 * @param cfaudittime
	 * 更新记录：
	 */
	public void setCfaudittime(Date cfaudittime){
		this.cfaudittime=cfaudittime;
	}
	/**
	 * 
	 * 描述： 审核时间
	 * @author yangming
	 * @date 2013-9-27 上午10:32:28
	 * @param cfaudittime
	 * 更新记录：
	 */
	public Date getCfaudittime(){
		return cfaudittime;
	}
	/**
	 * 
	 * 描述： 制单时间
	 * @author yangming
	 * @date 2013-9-27 上午10:32:28
	 * @param cfaudittime
	 * 更新记录：
	 */
	public void setCfmakeadddate(Date cfmakeadddate){
		this.cfmakeadddate=cfmakeadddate;
	}
	/**
	 * 
	 * 描述： 制单时间 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:32:28
	 * @param cfaudittime
	 * 更新记录：
	 */
	public Date getCfmakeadddate(){
		return cfmakeadddate;
	}
	/**
	 * 
	 * 描述： 项目编号
	 * @author yangming
	 * @date 2013-9-27 上午10:33:03
	 * @param cfprojectnumberid
	 * 更新记录：
	 */
	public void setCfprojectnumberid(String cfprojectnumberid){
		this.cfprojectnumberid=cfprojectnumberid;
	}
	/**
	 * 
	 * 描述： 项目编号
	 * @author yangming
	 * @date 2013-9-27 上午10:33:03
	 * @param cfprojectnumberid
	 * 更新记录：
	 */
	public String getCfprojectnumberid(){
		return cfprojectnumberid;
	}
	/**
	 * 
	 * 描述： 单据状态
	 * @author yangming
	 * @date 2013-9-27 上午10:33:03
	 * @param cfprojectnumberid
	 * 更新记录：
	 */
	public void setFstate(String fstate){
		this.fstate=fstate;
	}
	/**
	 * 
	 * 描述： 单据状态 getter
	 * @author yangming
	 * @date 2013-9-27 上午10:33:03
	 * @param cfprojectnumberid
	 * 更新记录：
	 */
	public String getFstate(){
		return fstate;
	}
	/**
	 * 
	 * 描述： 制单人
	 * @author yangming
	 * @date 2013-9-27 上午10:33:35
	 * @param flistperosnid
	 * 更新记录：
	 */
	public void setFlistperosnid(String flistperosnid){
		this.flistperosnid=flistperosnid;
	}
	/**
	 * 
	 * 描述： 制单人
	 * @author yangming
	 * @date 2013-9-27 上午10:33:45
	 * @return
	 * 更新记录：
	 */
	public String getFlistperosnid(){
		return flistperosnid;
	}
	/**
	 * 
	 * 描述：制单部门 
	 * @author yangming
	 * @date 2013-9-27 上午10:33:55
	 * @param fpersondepartmenti
	 * 更新记录：
	 */
	public void setFpersondepartmenti(String fpersondepartmenti){
		this.fpersondepartmenti=fpersondepartmenti;
	}
	/**
	 * 
	 * 描述： 制单部门 
	 * @author yangming
	 * @date 2013-9-27 上午10:34:05
	 * @return
	 * 更新记录：
	 */
	public String getFpersondepartmenti(){
		return fpersondepartmenti;
	}
	/**
	 * 
	 * 描述： 项目状态
	 * @author yangming
	 * @date 2013-9-27 上午10:34:13
	 * @param fprojectty
	 * 更新记录：
	 */
	public void setFprojectty(String fprojectty){
		this.fprojectty=fprojectty;
	}
	/**
	 * 
	 * 描述： 项目状态
	 * @author yangming
	 * @date 2013-9-27 上午10:34:31
	 * @return
	 * 更新记录：
	 */
	public String getFprojectty(){
		return fprojectty;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午10:34:36
	 * @param fremake
	 * 更新记录：
	 */
	public void setFremake(String fremake){
		this.fremake=fremake;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午10:34:36
	 * @param fremake
	 * 更新记录：
	 */
	public String getFremake(){
		return fremake;
	}
	/**
	 * 
	 * 描述： 施工类型
	 * @author yangming
	 * @date 2013-9-27 上午10:34:52
	 * @param fconttype
	 * 更新记录：
	 */
	public void setFconttype(String fconttype){
		this.fconttype=fconttype;
	}
	/**
	 * 
	 * 描述： 施工类型 get
	 * @author yangming
	 * @date 2013-9-27 上午10:34:52
	 * @param fconttype
	 * 更新记录：
	 */
	public String getFconttype(){
		return fconttype;
	}
	/**
	 * 
	 * 描述： 叉车秤
	 * @author yangming
	 * @date 2013-9-27 上午10:35:15
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getFforkliftscales() {
		return fforkliftscales;
	}
	/**
	 * 
	 * 描述： 叉车秤
	 * @author yangming
	 * @date 2013-9-27 上午10:35:36
	 * @param fforkliftscales
	 * 更新记录：
	 */
	public void setFforkliftscales(BigDecimal fforkliftscales) {
		this.fforkliftscales = fforkliftscales;
	}
	/**
	 * 
	 * 描述： 是否补录数据
	 * @author yangming
	 * @date 2013-9-27 上午10:35:40
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfishistorydata() {
		return cfishistorydata;
	}
	/**
	 * 
	 * 描述： 是否补录数据
	 * @author yangming
	 * @date 2013-9-27 上午10:35:40
	 * @return
	 * 更新记录：
	 */
	public void setCfishistorydata(BigDecimal cfishistorydata) {
		this.cfishistorydata = cfishistorydata;
	}
	/**
	 * 
	 * 描述： 场地
	 * @author yangming
	 * @date 2013-9-27 上午10:35:54
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfyard() {
		return cfyard;
	}
	/**
	 * 
	 * 描述： 场地 set
	 * @author yangming
	 * @date 2013-9-27 上午10:35:54
	 * @return
	 * 更新记录：
	 */
	public void setCfyard(BigDecimal cfyard) {
		this.cfyard = cfyard;
	}
	/**
	 * 
	 * 描述： 区域
	 * @author yangming
	 * @date 2013-9-27 上午10:36:10
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfparea() {
		return cfparea;
	}
	/**
	 * 
	 * 描述： 区域 set
	 * @author yangming
	 * @date 2013-9-27 上午10:36:10
	 * @return
	 * 更新记录：
	 */
	public void setCfparea(BigDecimal cfparea) {
		this.cfparea = cfparea;
	}
	/**
	 * 
	 * 描述： 所属区域 
	 * @author yangming
	 * @date 2013-9-27 上午10:36:44
	 * @return 
	 * 更新记录：
	 */
	public AdminOrgUnit getCfregion() {
		return cfregion;
	}
	/**
	 * 
	 * 描述： 所属区域 
	 * @author yangming
	 * @date 2013-9-27 上午10:36:44
	 * @return 
	 * 更新记录：
	 */
	public void setCfregion(AdminOrgUnit cfregion) {
		this.cfregion = cfregion;
	}
	/**
	 * 
	 * 描述： 所属事业部
	 * @author yangming
	 * @date 2013-9-27 上午10:37:23
	 * @return
	 * 更新记录：
	 */
	public AdminOrgUnit getCfbusinessdivisionName() {
		return cfbusinessdivisionName;
	}
	/**
	 * 
	 * 描述： 所属事业部
	 * @author yangming
	 * @date 2013-9-27 上午10:37:23
	 * @return
	 * 更新记录：
	 */
	public void setCfbusinessdivisionName(AdminOrgUnit cfbusinessdivisionName) {
		this.cfbusinessdivisionName = cfbusinessdivisionName;
	}
	/**
	 * 
	 * 描述： 所属子公司
	 * @author yangming
	 * @date 2013-9-27 上午10:37:37
	 * @return
	 * 更新记录：
	 */
	public AdminOrgUnit getCfkaleidescope() {
		return cfkaleidescope;
	}
	/**
	 * 
	 * 描述： 所属子公司
	 * @author yangming
	 * @date 2013-9-27 上午10:37:53
	 * @param cfkaleidescope
	 * 更新记录：
	 */
	public void setCfkaleidescope(AdminOrgUnit cfkaleidescope) {
		this.cfkaleidescope = cfkaleidescope;
	}
	/**
	 * 
	 * 描述： 项目负责部门
	 * @author yangming
	 * @date 2013-9-27 上午10:38:08
	 * @return
	 * 更新记录：
	 */
	public AdminOrgUnit getCfprojectdepartmenName() {
		return cfprojectdepartmenName;
	}
	/**
	 * 
	 * 描述： 项目负责部门 set
	 * @author yangming
	 * @date 2013-9-27 上午10:38:08
	 * @return
	 * 更新记录：
	 */
	public void setCfprojectdepartmenName(AdminOrgUnit cfprojectdepartmenName) {
		this.cfprojectdepartmenName = cfprojectdepartmenName;
	}
	/**
	 * 
	 * 描述： 项目经理
	 * @author yangming
	 * @date 2013-9-27 上午10:38:24
	 * @return
	 * 更新记录：
	 */
	public Person getCfprojectmanager() {
		return cfprojectmanager;
	}
	/**
	 * 
	 * 描述： 项目经理 setter
	 * @author yangming
	 * @date 2013-9-27 上午10:38:24
	 * @return
	 * 更新记录：
	 */
	public void setCfprojectmanager(Person cfprojectmanager) {
		this.cfprojectmanager = cfprojectmanager;
	}
	/**
	 * 
	 * 描述： 非网店分类
	 * @author yangming
	 * @date 2013-9-27 上午10:38:43
	 * @return
	 * 更新记录：
	 */
	public NotPointEntity getCfbranchtype() {
		return cfbranchtype;
	}
	/**
	 * 
	 * 描述： 非网店分类
	 * @author yangming
	 * @date 2013-9-27 上午10:38:43
	 * @return
	 * 更新记录：
	 */
	public void setCfbranchtype(NotPointEntity cfbranchtype) {
		this.cfbranchtype = cfbranchtype;
	}
	/**
	 * 
	 * 描述：申请人*
	 * @author yangming
	 * @date 2013-9-27 上午10:38:43
	 * @return
	 * 更新记录：
	 */
	public Person getFlistperson() {
		return flistperson;
	}
	/**
	 * 
	 * 描述：申请人
	 * @author yangming
	 * @date 2013-9-27 上午10:38:43
	 * @return
	 * 更新记录：
	 */
	public void setFlistperson(Person flistperson) {
		this.flistperson = flistperson;
	}
	/**
	 * 
	 * 描述： 申请人部门
	 * @author yangming
	 * @date 2013-9-27 上午10:39:17
	 * @return
	 * 更新记录：
	 */
	public AdminOrgUnit getFpersondept() {
		return fpersondept;
	}
	/**
	 * 
	 * 描述： 申请人部门
	 * @author yangming
	 * @date 2013-9-27 上午10:39:17
	 * @return
	 * 更新记录：
	 */
	public void setFpersondept(AdminOrgUnit fpersondept) {
		this.fpersondept = fpersondept;
	}
	/**
	 * 
	 * 描述：获取”是否全国供应商“
	 * @author yangming
	 * @date 2013-11-27 下午6:20:29
	 * 更新记录：
	 */
	public BigDecimal getCfIsNationalSupplier() {
		return cfIsNationalSupplier;
	}
	/**
	 * 
	 * 描述：设置”是否全国供应商“
	 * @author yangming
	 * @date 2013-11-27 下午6:20:51
	 * 更新记录：
	 */
	
	
	public void setCfIsNationalSupplier(BigDecimal cfIsNationalSupplier) {
		this.cfIsNationalSupplier = cfIsNationalSupplier;
	}
	public String getFhaseffectedDto() {
		return fhaseffectedDto;
	}
	public void setFhaseffectedDto(String fhaseffectedDto) {
		this.fhaseffectedDto = fhaseffectedDto;
	}
	public String getFfivoucheredDto() {
		return ffivoucheredDto;
	}
	public void setFfivoucheredDto(String ffivoucheredDto) {
		this.ffivoucheredDto = ffivoucheredDto;
	}
	public String getCfgradeDto() {
		return cfgradeDto;
	}
	public void setCfgradeDto(String cfgradeDto) {
		this.cfgradeDto = cfgradeDto;
	}
	public String getCfdeependesignDto() {
		return cfdeependesignDto;
	}
	public void setCfdeependesignDto(String cfdeependesignDto) {
		this.cfdeependesignDto = cfdeependesignDto;
	}
	public String getCfstartDto() {
		return cfstartDto;
	}
	public void setCfstartDto(String cfstartDto) {
		this.cfstartDto = cfstartDto;
	}
	public String getCfremarkDto() {
		return cfremarkDto;
	}
	public void setCfremarkDto(String cfremarkDto) {
		this.cfremarkDto = cfremarkDto;
	}
	public String getCfbimudf0023Dto() {
		return cfbimudf0023Dto;
	}
	public void setCfbimudf0023Dto(String cfbimudf0023Dto) {
		this.cfbimudf0023Dto = cfbimudf0023Dto;
	}
	public String getCfsendDto() {
		return cfsendDto;
	}
	public void setCfsendDto(String cfsendDto) {
		this.cfsendDto = cfsendDto;
	}
	public String getCftakeDto() {
		return cftakeDto;
	}
	public void setCftakeDto(String cftakeDto) {
		this.cftakeDto = cftakeDto;
	}
	public String getCfreceiptDto() {
		return cfreceiptDto;
	}
	public void setCfreceiptDto(String cfreceiptDto) {
		this.cfreceiptDto = cfreceiptDto;
	}
	public String getCflightcargoDto() {
		return cflightcargoDto;
	}
	public void setCflightcargoDto(String cflightcargoDto) {
		this.cflightcargoDto = cflightcargoDto;
	}
	public String getCfheavycargoDto() {
		return cfheavycargoDto;
	}
	public void setCfheavycargoDto(String cfheavycargoDto) {
		this.cfheavycargoDto = cfheavycargoDto;
	}
	public String getCfouttakeDto() {
		return cfouttakeDto;
	}
	public void setCfouttakeDto(String cfouttakeDto) {
		this.cfouttakeDto = cfouttakeDto;
	}
	public String getCfoutdoorDto() {
		return cfoutdoorDto;
	}
	public void setCfoutdoorDto(String cfoutdoorDto) {
		this.cfoutdoorDto = cfoutdoorDto;
	}
	public String getCfweighbridgeDto() {
		return cfweighbridgeDto;
	}
	public void setCfweighbridgeDto(String cfweighbridgeDto) {
		this.cfweighbridgeDto = cfweighbridgeDto;
	}
	public String getCfelectronicDto() {
		return cfelectronicDto;
	}
	public void setCfelectronicDto(String cfelectronicDto) {
		this.cfelectronicDto = cfelectronicDto;
	}
	public String getCfconferenceroomDto() {
		return cfconferenceroomDto;
	}
	public void setCfconferenceroomDto(String cfconferenceroomDto) {
		this.cfconferenceroomDto = cfconferenceroomDto;
	}
	public String getCfserviceareaDto() {
		return cfserviceareaDto;
	}
	public void setCfserviceareaDto(String cfserviceareaDto) {
		this.cfserviceareaDto = cfserviceareaDto;
	}
	public String getCfwashroomDto() {
		return cfwashroomDto;
	}
	public void setCfwashroomDto(String cfwashroomDto) {
		this.cfwashroomDto = cfwashroomDto;
	}
	public String getCfbreedroomDto() {
		return cfbreedroomDto;
	}
	public void setCfbreedroomDto(String cfbreedroomDto) {
		this.cfbreedroomDto = cfbreedroomDto;
	}
	public String getCfmarkingDto() {
		return cfmarkingDto;
	}
	public void setCfmarkingDto(String cfmarkingDto) {
		this.cfmarkingDto = cfmarkingDto;
	}
	public String getCfcounterDto() {
		return cfcounterDto;
	}
	public void setCfcounterDto(String cfcounterDto) {
		this.cfcounterDto = cfcounterDto;
	}
	public String getFissatellitePoint() {
		return fissatellitePoint;
	}
	public void setFissatellitePoint(String fissatellitePoint) {
		this.fissatellitePoint = fissatellitePoint;
	}
	
	
	
}

