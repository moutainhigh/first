package com.deppon.lsp.module.purchase.purchasecontact.share.domain;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
   * @ClassName: PurchaseContactEntity 
   * @Description:TODO(采购合同表头信息) 
   * @author 何玲菠 
   * @date 2013-11-7 下午2:31:53 
   *
 */
public class PurchaseContactEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	//ID
	private String fid;
	//申请人
	private String fcreatorid;
	//创建时间
	private Date fcreatetime;
	//最后更新人
	private String flastupdateuserid;
	//最后更新时间
	private Date flastupdatetime;
	//控制单元
	private String fcontrolunitid;
	//单据编号
	private String fnumber;
	//业务日期
	private Date fbizdate;
	//经手人
	private String fhandlerid;
	//参考信息
	private String fdescription;
	//是否曾经生效
	private Long fhaseffected;
	//审核人
	private String fauditorid;
	//源单据ID
	private String fsourcebillid;
	//来源功能
	private String fsourcefunction;
	//审核时间
	private Date faudittime;
	//单据状态
	private Long fbasestatus;
	//业务类型：用于控制业务流程
	private String fbiztypeid;
	//来源单据类型
	private String fsourcebilltypeid;
	//单据类型
	private String fbilltypeid;
	//业务年度
	private Long fyear;
	//业务期间
	private Long fperiod;
	//修改人
	private String fmodifierid;
	//修改时间
	private Date fmodificationtime;
	//是否系统单据
	private Long fissysbill;
	//是否含税
	private Long fisintax;
	//汇率
	private Long fexchangerate;
	//折算方式
	private Long fconvertmode;
	//金额
	private Long ftotalamount;
	//金额本位币合计
	private Long flocaltotalamount;
	//税额
	private Long ftotaltax;
	//本位币税额
	private Long flocaltotaltax;
	//价税合计本位币
	private Long flocaltotaltaxamount;
	//价税合计
	private Long ftotaltaxamount;
	//币别
	private String fcurrencyid;
	//部门
	private String fadminorgunitid;
	//公司单元
	private String fcompanyorgunitid;
	//供应商
	private String fsupplierid;
	//采购组织单元
	private String fpurorgunitid;
	//采购组
	private String fpurgroopid;
	//交货方式
	private String fdeliverytypeid;
	//付款方式
	private String fpaymenttypeid;
	//现金折扣
	private String fcashdiscountid;
	//结算方式
	private String fsettlementtypeid;
	//合同类型
	private String fcontracttypeid;
	//采购员
	private String fpurpersonid;
	//签订地点
	private String fsignedaddress;
	//有效期至
	private Date feffecteddate;
	//交货地址
	private String fdeliveryaddress;
	//预付比率
	private Long fprepayrate;
	//预付金额
	private Long fprepayamount;
	//采购提前期
	private Long fpuradvancedays;
	//内部采购
	private Long fisinnerpurchase;
	//版本
	private Long fversion;
	//变更时间
	private Date falterdate;
	//变更人
	private String falterperson;
	//原ID
	private String foldid;
	//旧的状态值
	private Long foldstatus;
	//付款条件
	private String fpaymentconditionid;
	//项目编号
	private String fprojectnumberid;
	//项目名称
	private String fprojectname;
	//采购申请单号
	private String fapplynumberid;
	//区域
	private String fareaid;
	//合同类别
	private String ftypeid;
	//合同名称
	private String fcontractname;
	//RFQ单号
	private String frfqnumberid;
	//税率
	private Long ftaxrate;
	//合同起始日期
	private Date fbegindate;
	//合同终止日期
	private Date fenddate;
	//收货时间
	private Date freceivedate;
	//乙方（供应商）
	private String fpartybid;
	//甲方
	private String fpartyfirstid;
	//丙方
	private String fpartyc;
	//合同金额
	private Long fcontractamount;
	//签订类型
	private String fsignedtypeid;
	//签订部门
	private String fsigneddepartmenti;
	//供应商地址
	private String fsupplieraddress;
	//供应商联系人
	private String flinkedperson;
	//供应商传真
	private String fsupplierfax;
	//供应商电话
	private String fsuppliertel;
	//供应商email
	private String femail;
	//丙方地址
	private String fpartycaddress;
	//丙方联系人
	private String fpartyclinkedperson;
	//丙方传真
	private String fpartycfax;
	//丙方电话
	private String fpartyctel;
	//丙方email
	private String fpartycemail;
	//备注
	private String fremak;
	//所属事业部
	private String fdivisionid;
	//签订部门
	private String cfsigneddeptmentar;
	//签收部门所属事业部
	private String cfsignareaid;
	//是否先盖章
	private Long cfisseal;
	//是否会签
	private Long cfiscountersign;
	//会签人
	private String cfcounterperson;
	
	
	public Long getCfisseal() {
		return cfisseal;
	}
	public void setCfisseal(Long cfisseal) {
		this.cfisseal = cfisseal;
	}
	public Long getCfiscountersign() {
		return cfiscountersign;
	}
	public void setCfiscountersign(Long cfiscountersign) {
		this.cfiscountersign = cfiscountersign;
	}
	public String getCfcounterperson() {
		return cfcounterperson;
	}
	public void setCfcounterperson(String cfcounterperson) {
		this.cfcounterperson = cfcounterperson;
	}
	public void setFid(String fid){
		this.fid=fid;
	}
	public String getFid(){
		return fid;
	}
	public void setFcreatorid(String fcreatorid){
		this.fcreatorid=fcreatorid;
	}
	public String getFcreatorid(){
		return fcreatorid;
	}
	public void setFcreatetime(Date fcreatetime){
		this.fcreatetime=fcreatetime;
	}
	public Date getFcreatetime(){
		return fcreatetime;
	}
	public void setFlastupdateuserid(String flastupdateuserid){
		this.flastupdateuserid=flastupdateuserid;
	}
	public String getFlastupdateuserid(){
		return flastupdateuserid;
	}
	public void setFlastupdatetime(Date flastupdatetime){
		this.flastupdatetime=flastupdatetime;
	}
	public Date getFlastupdatetime(){
		return flastupdatetime;
	}
	public void setFcontrolunitid(String fcontrolunitid){
		this.fcontrolunitid=fcontrolunitid;
	}
	public String getFcontrolunitid(){
		return fcontrolunitid;
	}
	public void setFnumber(String fnumber){
		this.fnumber=fnumber;
	}
	public String getFnumber(){
		return fnumber;
	}
	public void setFbizdate(Date fbizdate){
		this.fbizdate=fbizdate;
	}
	public Date getFbizdate(){
		return fbizdate;
	}
	public void setFhandlerid(String fhandlerid){
		this.fhandlerid=fhandlerid;
	}
	public String getFhandlerid(){
		return fhandlerid;
	}
	public void setFdescription(String fdescription){
		this.fdescription=fdescription;
	}
	public String getFdescription(){
		return fdescription;
	}
	public void setFhaseffected(Long fhaseffected){
		this.fhaseffected=fhaseffected;
	}
	public Long getFhaseffected(){
		return fhaseffected;
	}
	public void setFauditorid(String fauditorid){
		this.fauditorid=fauditorid;
	}
	public String getFauditorid(){
		return fauditorid;
	}
	public void setFsourcebillid(String fsourcebillid){
		this.fsourcebillid=fsourcebillid;
	}
	public String getFsourcebillid(){
		return fsourcebillid;
	}
	public void setFsourcefunction(String fsourcefunction){
		this.fsourcefunction=fsourcefunction;
	}
	public String getFsourcefunction(){
		return fsourcefunction;
	}
	public void setFaudittime(Date faudittime){
		this.faudittime=faudittime;
	}
	public Date getFaudittime(){
		return faudittime;
	}
	public void setFbasestatus(Long fbasestatus){
		this.fbasestatus=fbasestatus;
	}
	public Long getFbasestatus(){
		return fbasestatus;
	}
	public void setFbiztypeid(String fbiztypeid){
		this.fbiztypeid=fbiztypeid;
	}
	public String getFbiztypeid(){
		return fbiztypeid;
	}
	public void setFsourcebilltypeid(String fsourcebilltypeid){
		this.fsourcebilltypeid=fsourcebilltypeid;
	}
	public String getFsourcebilltypeid(){
		return fsourcebilltypeid;
	}
	public void setFbilltypeid(String fbilltypeid){
		this.fbilltypeid=fbilltypeid;
	}
	public String getFbilltypeid(){
		return fbilltypeid;
	}
	public void setFyear(Long fyear){
		this.fyear=fyear;
	}
	public Long getFyear(){
		return fyear;
	}
	public void setFperiod(Long fperiod){
		this.fperiod=fperiod;
	}
	public Long getFperiod(){
		return fperiod;
	}
	public void setFmodifierid(String fmodifierid){
		this.fmodifierid=fmodifierid;
	}
	public String getFmodifierid(){
		return fmodifierid;
	}
	public void setFmodificationtime(Date fmodificationtime){
		this.fmodificationtime=fmodificationtime;
	}
	public Date getFmodificationtime(){
		return fmodificationtime;
	}
	public void setFissysbill(Long fissysbill){
		this.fissysbill=fissysbill;
	}
	public Long getFissysbill(){
		return fissysbill;
	}
	public void setFisintax(Long fisintax){
		this.fisintax=fisintax;
	}
	public Long getFisintax(){
		return fisintax;
	}
	public void setFexchangerate(Long fexchangerate){
		this.fexchangerate=fexchangerate;
	}
	public Long getFexchangerate(){
		return fexchangerate;
	}
	public void setFconvertmode(Long fconvertmode){
		this.fconvertmode=fconvertmode;
	}
	public Long getFconvertmode(){
		return fconvertmode;
	}
	public void setFtotalamount(Long ftotalamount){
		this.ftotalamount=ftotalamount;
	}
	public Long getFtotalamount(){
		return ftotalamount;
	}
	public void setFlocaltotalamount(Long flocaltotalamount){
		this.flocaltotalamount=flocaltotalamount;
	}
	public Long getFlocaltotalamount(){
		return flocaltotalamount;
	}
	public void setFtotaltax(Long ftotaltax){
		this.ftotaltax=ftotaltax;
	}
	public Long getFtotaltax(){
		return ftotaltax;
	}
	public void setFlocaltotaltax(Long flocaltotaltax){
		this.flocaltotaltax=flocaltotaltax;
	}
	public Long getFlocaltotaltax(){
		return flocaltotaltax;
	}
	public void setFlocaltotaltaxamount(Long flocaltotaltaxamount){
		this.flocaltotaltaxamount=flocaltotaltaxamount;
	}
	public Long getFlocaltotaltaxamount(){
		return flocaltotaltaxamount;
	}
	public void setFtotaltaxamount(Long ftotaltaxamount){
		this.ftotaltaxamount=ftotaltaxamount;
	}
	public Long getFtotaltaxamount(){
		return ftotaltaxamount;
	}
	public void setFcurrencyid(String fcurrencyid){
		this.fcurrencyid=fcurrencyid;
	}
	public String getFcurrencyid(){
		return fcurrencyid;
	}
	public void setFadminorgunitid(String fadminorgunitid){
		this.fadminorgunitid=fadminorgunitid;
	}
	public String getFadminorgunitid(){
		return fadminorgunitid;
	}
	public void setFcompanyorgunitid(String fcompanyorgunitid){
		this.fcompanyorgunitid=fcompanyorgunitid;
	}
	public String getFcompanyorgunitid(){
		return fcompanyorgunitid;
	}
	public void setFsupplierid(String fsupplierid){
		this.fsupplierid=fsupplierid;
	}
	public String getFsupplierid(){
		return fsupplierid;
	}
	public void setFpurorgunitid(String fpurorgunitid){
		this.fpurorgunitid=fpurorgunitid;
	}
	public String getFpurorgunitid(){
		return fpurorgunitid;
	}
	public void setFpurgroopid(String fpurgroopid){
		this.fpurgroopid=fpurgroopid;
	}
	public String getFpurgroopid(){
		return fpurgroopid;
	}
	public void setFdeliverytypeid(String fdeliverytypeid){
		this.fdeliverytypeid=fdeliverytypeid;
	}
	public String getFdeliverytypeid(){
		return fdeliverytypeid;
	}
	public void setFpaymenttypeid(String fpaymenttypeid){
		this.fpaymenttypeid=fpaymenttypeid;
	}
	public String getFpaymenttypeid(){
		return fpaymenttypeid;
	}
	public void setFcashdiscountid(String fcashdiscountid){
		this.fcashdiscountid=fcashdiscountid;
	}
	public String getFcashdiscountid(){
		return fcashdiscountid;
	}
	public void setFsettlementtypeid(String fsettlementtypeid){
		this.fsettlementtypeid=fsettlementtypeid;
	}
	public String getFsettlementtypeid(){
		return fsettlementtypeid;
	}
	public void setFcontracttypeid(String fcontracttypeid){
		this.fcontracttypeid=fcontracttypeid;
	}
	public String getFcontracttypeid(){
		return fcontracttypeid;
	}
	public void setFpurpersonid(String fpurpersonid){
		this.fpurpersonid=fpurpersonid;
	}
	public String getFpurpersonid(){
		return fpurpersonid;
	}
	public void setFsignedaddress(String fsignedaddress){
		this.fsignedaddress=fsignedaddress;
	}
	public String getFsignedaddress(){
		return fsignedaddress;
	}
	public void setFeffecteddate(Date feffecteddate){
		this.feffecteddate=feffecteddate;
	}
	public Date getFeffecteddate(){
		return feffecteddate;
	}
	public void setFdeliveryaddress(String fdeliveryaddress){
		this.fdeliveryaddress=fdeliveryaddress;
	}
	public String getFdeliveryaddress(){
		return fdeliveryaddress;
	}
	public void setFprepayrate(Long fprepayrate){
		this.fprepayrate=fprepayrate;
	}
	public Long getFprepayrate(){
		return fprepayrate;
	}
	public void setFprepayamount(Long fprepayamount){
		this.fprepayamount=fprepayamount;
	}
	public Long getFprepayamount(){
		return fprepayamount;
	}
	public void setFpuradvancedays(Long fpuradvancedays){
		this.fpuradvancedays=fpuradvancedays;
	}
	public Long getFpuradvancedays(){
		return fpuradvancedays;
	}
	public void setFisinnerpurchase(Long fisinnerpurchase){
		this.fisinnerpurchase=fisinnerpurchase;
	}
	public Long getFisinnerpurchase(){
		return fisinnerpurchase;
	}
	public void setFversion(Long fversion){
		this.fversion=fversion;
	}
	public Long getFversion(){
		return fversion;
	}
	public void setFalterdate(Date falterdate){
		this.falterdate=falterdate;
	}
	public Date getFalterdate(){
		return falterdate;
	}
	public void setFalterperson(String falterperson){
		this.falterperson=falterperson;
	}
	public String getFalterperson(){
		return falterperson;
	}
	public void setFoldid(String foldid){
		this.foldid=foldid;
	}
	public String getFoldid(){
		return foldid;
	}
	public void setFoldstatus(Long foldstatus){
		this.foldstatus=foldstatus;
	}
	public Long getFoldstatus(){
		return foldstatus;
	}
	public void setFpaymentconditionid(String fpaymentconditionid){
		this.fpaymentconditionid=fpaymentconditionid;
	}
	public String getFpaymentconditionid(){
		return fpaymentconditionid;
	}
	public void setFprojectnumberid(String fprojectnumberid){
		this.fprojectnumberid=fprojectnumberid;
	}
	public String getFprojectnumberid(){
		return fprojectnumberid;
	}
	public void setFprojectname(String fprojectname){
		this.fprojectname=fprojectname;
	}
	public String getFprojectname(){
		return fprojectname;
	}
	public void setFapplynumberid(String fapplynumberid){
		this.fapplynumberid=fapplynumberid;
	}
	public String getFapplynumberid(){
		return fapplynumberid;
	}
	public void setFareaid(String fareaid){
		this.fareaid=fareaid;
	}
	public String getFareaid(){
		return fareaid;
	}
	public void setFtypeid(String ftypeid){
		this.ftypeid=ftypeid;
	}
	public String getFtypeid(){
		return ftypeid;
	}
	public void setFcontractname(String fcontractname){
		this.fcontractname=fcontractname;
	}
	public String getFcontractname(){
		return fcontractname;
	}
	public void setFrfqnumberid(String frfqnumberid){
		this.frfqnumberid=frfqnumberid;
	}
	public String getFrfqnumberid(){
		return frfqnumberid;
	}
	public void setFtaxrate(Long ftaxrate){
		this.ftaxrate=ftaxrate;
	}
	public Long getFtaxrate(){
		return ftaxrate;
	}
	public void setFbegindate(Date fbegindate){
		this.fbegindate=fbegindate;
	}
	public Date getFbegindate(){
		return fbegindate;
	}
	public void setFenddate(Date fenddate){
		this.fenddate=fenddate;
	}
	public Date getFenddate(){
		return fenddate;
	}
	public void setFreceivedate(Date freceivedate){
		this.freceivedate=freceivedate;
	}
	public Date getFreceivedate(){
		return freceivedate;
	}
	public void setFpartybid(String fpartybid){
		this.fpartybid=fpartybid;
	}
	public String getFpartybid(){
		return fpartybid;
	}
	public void setFpartyfirstid(String fpartyfirstid){
		this.fpartyfirstid=fpartyfirstid;
	}
	public String getFpartyfirstid(){
		return fpartyfirstid;
	}
	public void setFpartyc(String fpartyc){
		this.fpartyc=fpartyc;
	}
	public String getFpartyc(){
		return fpartyc;
	}
	public void setFcontractamount(Long fcontractamount){
		this.fcontractamount=fcontractamount;
	}
	public Long getFcontractamount(){
		return fcontractamount;
	}
	public void setFsignedtypeid(String fsignedtypeid){
		this.fsignedtypeid=fsignedtypeid;
	}
	public String getFsignedtypeid(){
		return fsignedtypeid;
	}
	public void setFsigneddepartmenti(String fsigneddepartmenti){
		this.fsigneddepartmenti=fsigneddepartmenti;
	}
	public String getFsigneddepartmenti(){
		return fsigneddepartmenti;
	}
	public void setFsupplieraddress(String fsupplieraddress){
		this.fsupplieraddress=fsupplieraddress;
	}
	public String getFsupplieraddress(){
		return fsupplieraddress;
	}
	public void setFlinkedperson(String flinkedperson){
		this.flinkedperson=flinkedperson;
	}
	public String getFlinkedperson(){
		return flinkedperson;
	}
	public void setFsupplierfax(String fsupplierfax){
		this.fsupplierfax=fsupplierfax;
	}
	public String getFsupplierfax(){
		return fsupplierfax;
	}
	public void setFsuppliertel(String fsuppliertel){
		this.fsuppliertel=fsuppliertel;
	}
	public String getFsuppliertel(){
		return fsuppliertel;
	}
	public void setFemail(String femail){
		this.femail=femail;
	}
	public String getFemail(){
		return femail;
	}
	public void setFpartycaddress(String fpartycaddress){
		this.fpartycaddress=fpartycaddress;
	}
	public String getFpartycaddress(){
		return fpartycaddress;
	}
	public void setFpartyclinkedperson(String fpartyclinkedperson){
		this.fpartyclinkedperson=fpartyclinkedperson;
	}
	public String getFpartyclinkedperson(){
		return fpartyclinkedperson;
	}
	public void setFpartycfax(String fpartycfax){
		this.fpartycfax=fpartycfax;
	}
	public String getFpartycfax(){
		return fpartycfax;
	}
	public void setFpartyctel(String fpartyctel){
		this.fpartyctel=fpartyctel;
	}
	public String getFpartyctel(){
		return fpartyctel;
	}
	public void setFpartycemail(String fpartycemail){
		this.fpartycemail=fpartycemail;
	}
	public String getFpartycemail(){
		return fpartycemail;
	}
	public void setFremak(String fremak){
		this.fremak=fremak;
	}
	public String getFremak(){
		return fremak;
	}
	public void setFdivisionid(String fdivisionid){
		this.fdivisionid=fdivisionid;
	}
	public String getFdivisionid(){
		return fdivisionid;
	}
	public void setCfsigneddeptmentar(String cfsigneddeptmentar){
		this.cfsigneddeptmentar=cfsigneddeptmentar;
	}
	public String getCfsigneddeptmentar(){
		return cfsigneddeptmentar;
	}
	public void setCfsignareaid(String cfsignareaid){
		this.cfsignareaid=cfsignareaid;
	}
	public String getCfsignareaid(){
		return cfsignareaid;
	}
}

