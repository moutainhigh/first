package com.deppon.lsp.module.purchase.purchasecontact.share.domain;

import com.deppon.foss.framework.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
public class PurchaseContactDetailEntity extends BaseEntity {
	private static final long serialVersionUID = 8825934514847231096L;
	private String fid;
	private Long fseq;
	private String fmaterialid;
	private String fmatNumber;
	private String fassistpropertyid;
	private String funitid;
	private String fsourcebillid;
	private String fsourcebillnumber;
	private String fsourcebillentryid;
	private Long fsourcebillentryseq;
	private Long fasscoefficient;
	private Long fbasestatus;
	private BigDecimal fassociateqty;
	private String fsourcebilltypeid;
	private String fbaseunitid;
	private String fassistunitid;
	private String fremark;
	private String freasoncodeid;
	private Long fispresent;
	private BigDecimal fqty;
	private BigDecimal fbaseqty;
	private BigDecimal fassistqty;
	private Double fprice;
	private BigDecimal famount;
	private BigDecimal flocalamount;
	private BigDecimal ftaxrate;
	private BigDecimal ftaxprice;
	private BigDecimal ftax;
	private BigDecimal flocaltax;
	private BigDecimal ftaxamount;
	private BigDecimal flocaltaxamount;
	private BigDecimal fdiscountcondition;
	private Long fdiscounttype;
	private Long fdiscount;
	private BigDecimal factualprice;
	private BigDecimal factualtaxprice;
	private BigDecimal fdiscountamount;
	private Date fclosedate;
	private String fmaterialgroupid;
	private String fstorageorgunitid;
	private String fwarehouseid;
	private String fparentid;
	private Date fconsigndate;
	private Date fdeliverydate;
	private BigDecimal freceiveoverrate;
	private BigDecimal freceiveowingrate;
	private Long freceiveadvancedays;
	private Long freceivedeferraldays;
	private Long fqualityunctrl;
	private Long ftimeunctrl;
	private Long famountunctrl;
	private BigDecimal ftotalorderamount;
	private BigDecimal ftotalpaidamount;
	private BigDecimal ftotalorderqty;
	private String freason;
	private Long fversion;
	private String foldid;
	private Long foldstatus;
	private String fqistandardid;
	private String frowtypeid;
	private String fmaterialname;
	private BigDecimal ftotalreqpayamt;
	private String fnonummaterialmodel;
	private String fqcstandardid;
	private String fqualityorgid;
	private BigDecimal fprotectprice;
	private String fadminorgunitid;
	private String freceivetype;
	private String fprojectid;
	private String ftracknumberid;
	private String fpurrequestid;
	private String fpurrequestentryid;
	public void setFid(String fid){
		this.fid=fid;
	}
	public String getFid(){
		return fid;
	}
	public void setFseq(Long fseq){
		this.fseq=fseq;
	}
	public Long getFseq(){
		return fseq;
	}
	public void setFmaterialid(String fmaterialid){
		this.fmaterialid=fmaterialid;
	}
	public String getFmaterialid(){
		return fmaterialid;
	}
	public void setFassistpropertyid(String fassistpropertyid){
		this.fassistpropertyid=fassistpropertyid;
	}
	public String getFassistpropertyid(){
		return fassistpropertyid;
	}
	public void setFunitid(String funitid){
		this.funitid=funitid;
	}
	public String getFunitid(){
		return funitid;
	}
	public void setFsourcebillid(String fsourcebillid){
		this.fsourcebillid=fsourcebillid;
	}
	public String getFsourcebillid(){
		return fsourcebillid;
	}
	public void setFsourcebillnumber(String fsourcebillnumber){
		this.fsourcebillnumber=fsourcebillnumber;
	}
	public String getFsourcebillnumber(){
		return fsourcebillnumber;
	}
	public void setFsourcebillentryid(String fsourcebillentryid){
		this.fsourcebillentryid=fsourcebillentryid;
	}
	public String getFsourcebillentryid(){
		return fsourcebillentryid;
	}
	public void setFsourcebillentryseq(Long fsourcebillentryseq){
		this.fsourcebillentryseq=fsourcebillentryseq;
	}
	public Long getFsourcebillentryseq(){
		return fsourcebillentryseq;
	}
	public void setFasscoefficient(Long fasscoefficient){
		this.fasscoefficient=fasscoefficient;
	}
	public Long getFasscoefficient(){
		return fasscoefficient;
	}
	public void setFbasestatus(Long fbasestatus){
		this.fbasestatus=fbasestatus;
	}
	public Long getFbasestatus(){
		return fbasestatus;
	}
	public void setFassociateqty(BigDecimal fassociateqty){
		this.fassociateqty=fassociateqty;
	}
	public BigDecimal getFassociateqty(){
		return fassociateqty;
	}
	public void setFsourcebilltypeid(String fsourcebilltypeid){
		this.fsourcebilltypeid=fsourcebilltypeid;
	}
	public String getFsourcebilltypeid(){
		return fsourcebilltypeid;
	}
	public void setFbaseunitid(String fbaseunitid){
		this.fbaseunitid=fbaseunitid;
	}
	public String getFbaseunitid(){
		return fbaseunitid;
	}
	public void setFassistunitid(String fassistunitid){
		this.fassistunitid=fassistunitid;
	}
	public String getFassistunitid(){
		return fassistunitid;
	}
	public void setFremark(String fremark){
		this.fremark=fremark;
	}
	public String getFremark(){
		return fremark;
	}
	public void setFreasoncodeid(String freasoncodeid){
		this.freasoncodeid=freasoncodeid;
	}
	public String getFreasoncodeid(){
		return freasoncodeid;
	}
	public void setFispresent(Long fispresent){
		this.fispresent=fispresent;
	}
	public Long getFispresent(){
		return fispresent;
	}
	public void setFqty(BigDecimal fqty){
		this.fqty=fqty;
	}
	public BigDecimal getFqty(){
		return fqty;
	}
	public void setFbaseqty(BigDecimal fbaseqty){
		this.fbaseqty=fbaseqty;
	}
	public BigDecimal getFbaseqty(){
		return fbaseqty;
	}
	public void setFassistqty(BigDecimal fassistqty){
		this.fassistqty=fassistqty;
	}
	public BigDecimal getFassistqty(){
		return fassistqty;
	}
	public void setFprice(Double fprice){
		this.fprice=fprice;
	}
	public Double getFprice(){
		return fprice;
	}
	public void setFamount(BigDecimal famount){
		this.famount=famount;
	}
	public BigDecimal getFamount(){
		return famount;
	}
	public void setFlocalamount(BigDecimal flocalamount){
		this.flocalamount=flocalamount;
	}
	public BigDecimal getFlocalamount(){
		return flocalamount;
	}
	public void setFtaxrate(BigDecimal ftaxrate){
		this.ftaxrate=ftaxrate;
	}
	public BigDecimal getFtaxrate(){
		return ftaxrate;
	}
	public void setFtaxprice(BigDecimal ftaxprice){
		this.ftaxprice=ftaxprice;
	}
	public BigDecimal getFtaxprice(){
		return ftaxprice;
	}
	public void setFtax(BigDecimal ftax){
		this.ftax=ftax;
	}
	public BigDecimal getFtax(){
		return ftax;
	}
	public void setFlocaltax(BigDecimal flocaltax){
		this.flocaltax=flocaltax;
	}
	public BigDecimal getFlocaltax(){
		return flocaltax;
	}
	public void setFtaxamount(BigDecimal ftaxamount){
		this.ftaxamount=ftaxamount;
	}
	public BigDecimal getFtaxamount(){
		return ftaxamount;
	}
	public void setFlocaltaxamount(BigDecimal flocaltaxamount){
		this.flocaltaxamount=flocaltaxamount;
	}
	public BigDecimal getFlocaltaxamount(){
		return flocaltaxamount;
	}
	public void setFdiscountcondition(BigDecimal fdiscountcondition){
		this.fdiscountcondition=fdiscountcondition;
	}
	public BigDecimal getFdiscountcondition(){
		return fdiscountcondition;
	}
	public void setFdiscounttype(Long fdiscounttype){
		this.fdiscounttype=fdiscounttype;
	}
	public Long getFdiscounttype(){
		return fdiscounttype;
	}
	public void setFdiscount(Long fdiscount){
		this.fdiscount=fdiscount;
	}
	public Long getFdiscount(){
		return fdiscount;
	}
	public void setFactualprice(BigDecimal factualprice){
		this.factualprice=factualprice;
	}
	public BigDecimal getFactualprice(){
		return factualprice;
	}
	public void setFactualtaxprice(BigDecimal factualtaxprice){
		this.factualtaxprice=factualtaxprice;
	}
	public BigDecimal getFactualtaxprice(){
		return factualtaxprice;
	}
	public void setFdiscountamount(BigDecimal fdiscountamount){
		this.fdiscountamount=fdiscountamount;
	}
	public BigDecimal getFdiscountamount(){
		return fdiscountamount;
	}
	public void setFclosedate(Date fclosedate){
		this.fclosedate=fclosedate;
	}
	public Date getFclosedate(){
		return fclosedate;
	}
	public void setFmaterialgroupid(String fmaterialgroupid){
		this.fmaterialgroupid=fmaterialgroupid;
	}
	public String getFmaterialgroupid(){
		return fmaterialgroupid;
	}
	public void setFstorageorgunitid(String fstorageorgunitid){
		this.fstorageorgunitid=fstorageorgunitid;
	}
	public String getFstorageorgunitid(){
		return fstorageorgunitid;
	}
	public void setFwarehouseid(String fwarehouseid){
		this.fwarehouseid=fwarehouseid;
	}
	public String getFwarehouseid(){
		return fwarehouseid;
	}
	public void setFparentid(String fparentid){
		this.fparentid=fparentid;
	}
	public String getFparentid(){
		return fparentid;
	}
	public void setFconsigndate(Date fconsigndate){
		this.fconsigndate=fconsigndate;
	}
	public Date getFconsigndate(){
		return fconsigndate;
	}
	public void setFdeliverydate(Date fdeliverydate){
		this.fdeliverydate=fdeliverydate;
	}
	public Date getFdeliverydate(){
		return fdeliverydate;
	}
	public void setFreceiveoverrate(BigDecimal freceiveoverrate){
		this.freceiveoverrate=freceiveoverrate;
	}
	public BigDecimal getFreceiveoverrate(){
		return freceiveoverrate;
	}
	public void setFreceiveowingrate(BigDecimal freceiveowingrate){
		this.freceiveowingrate=freceiveowingrate;
	}
	public BigDecimal getFreceiveowingrate(){
		return freceiveowingrate;
	}
	public void setFreceiveadvancedays(Long freceiveadvancedays){
		this.freceiveadvancedays=freceiveadvancedays;
	}
	public Long getFreceiveadvancedays(){
		return freceiveadvancedays;
	}
	public void setFreceivedeferraldays(Long freceivedeferraldays){
		this.freceivedeferraldays=freceivedeferraldays;
	}
	public Long getFreceivedeferraldays(){
		return freceivedeferraldays;
	}
	public void setFqualityunctrl(Long fqualityunctrl){
		this.fqualityunctrl=fqualityunctrl;
	}
	public Long getFqualityunctrl(){
		return fqualityunctrl;
	}
	public void setFtimeunctrl(Long ftimeunctrl){
		this.ftimeunctrl=ftimeunctrl;
	}
	public Long getFtimeunctrl(){
		return ftimeunctrl;
	}
	public void setFamountunctrl(Long famountunctrl){
		this.famountunctrl=famountunctrl;
	}
	public Long getFamountunctrl(){
		return famountunctrl;
	}
	public void setFtotalorderamount(BigDecimal ftotalorderamount){
		this.ftotalorderamount=ftotalorderamount;
	}
	public BigDecimal getFtotalorderamount(){
		return ftotalorderamount;
	}
	public void setFtotalpaidamount(BigDecimal ftotalpaidamount){
		this.ftotalpaidamount=ftotalpaidamount;
	}
	public BigDecimal getFtotalpaidamount(){
		return ftotalpaidamount;
	}
	public void setFtotalorderqty(BigDecimal ftotalorderqty){
		this.ftotalorderqty=ftotalorderqty;
	}
	public BigDecimal getFtotalorderqty(){
		return ftotalorderqty;
	}
	public void setFreason(String freason){
		this.freason=freason;
	}
	public String getFreason(){
		return freason;
	}
	public void setFversion(Long fversion){
		this.fversion=fversion;
	}
	public Long getFversion(){
		return fversion;
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
	public void setFqistandardid(String fqistandardid){
		this.fqistandardid=fqistandardid;
	}
	public String getFqistandardid(){
		return fqistandardid;
	}
	public void setFrowtypeid(String frowtypeid){
		this.frowtypeid=frowtypeid;
	}
	public String getFrowtypeid(){
		return frowtypeid;
	}
	public void setFmaterialname(String fmaterialname){
		this.fmaterialname=fmaterialname;
	}
	public String getFmaterialname(){
		return fmaterialname;
	}
	public void setFtotalreqpayamt(BigDecimal ftotalreqpayamt){
		this.ftotalreqpayamt=ftotalreqpayamt;
	}
	public BigDecimal getFtotalreqpayamt(){
		return ftotalreqpayamt;
	}
	public void setFnonummaterialmodel(String fnonummaterialmodel){
		this.fnonummaterialmodel=fnonummaterialmodel;
	}
	public String getFnonummaterialmodel(){
		return fnonummaterialmodel;
	}
	public void setFqcstandardid(String fqcstandardid){
		this.fqcstandardid=fqcstandardid;
	}
	public String getFqcstandardid(){
		return fqcstandardid;
	}
	public void setFqualityorgid(String fqualityorgid){
		this.fqualityorgid=fqualityorgid;
	}
	public String getFqualityorgid(){
		return fqualityorgid;
	}
	public void setFprotectprice(BigDecimal fprotectprice){
		this.fprotectprice=fprotectprice;
	}
	public BigDecimal getFprotectprice(){
		return fprotectprice;
	}
	public void setFadminorgunitid(String fadminorgunitid){
		this.fadminorgunitid=fadminorgunitid;
	}
	public String getFadminorgunitid(){
		return fadminorgunitid;
	}
	public void setFreceivetype(String freceivetype){
		this.freceivetype=freceivetype;
	}
	public String getFreceivetype(){
		return freceivetype;
	}
	public void setFprojectid(String fprojectid){
		this.fprojectid=fprojectid;
	}
	public String getFprojectid(){
		return fprojectid;
	}
	public void setFtracknumberid(String ftracknumberid){
		this.ftracknumberid=ftracknumberid;
	}
	public String getFtracknumberid(){
		return ftracknumberid;
	}
	public void setFpurrequestid(String fpurrequestid){
		this.fpurrequestid=fpurrequestid;
	}
	public String getFpurrequestid(){
		return fpurrequestid;
	}
	public void setFpurrequestentryid(String fpurrequestentryid){
		this.fpurrequestentryid=fpurrequestentryid;
	}
	public String getFpurrequestentryid(){
		return fpurrequestentryid;
	}
	/**
	 * @return the fmatNumber
	 */
	public String getFmatNumber() {
		return fmatNumber;
	}
	/**
	 * @param fmatNumber the fmatNumber to set
	 */
	public void setFmatNumber(String fmatNumber) {
		this.fmatNumber = fmatNumber;
	}

}