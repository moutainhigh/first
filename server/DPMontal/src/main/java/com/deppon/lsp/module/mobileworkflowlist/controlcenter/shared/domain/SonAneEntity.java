package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/**
 * @ClassName: SonAneEntity 
 * @Description: 子需求申请单分录
 * @author Jianghaibin
 * @date 2013-11-4 下午3:06:39
 */
public class SonAneEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;
	private Long fseq;						//单据分录序列号
	private String fparentId;				//父ID
	private String cfmaterialNumId;			//物品编码
	private String cfmaterialName;			//物品名称
	private String cfmaterialTypes;			//物品类别
	private String cfspecifications;		//规格型号
	private Long cfquantity;				//数量
	private BigDecimal cfreferencePrice;	//参考单价
	private BigDecimal cfreferenceAmount;	//参考金额
	private String cfattribute;				//申请原因
	private String cfscrapApplication;		//报废申请编号
	private String cfremake;				//备注
	private Long cfalreadyShipment;			//已发货数量
	private String cfoutBoundNum;			//出库单号
	private String cfbatchNum;				//批次号
	private String fmaterialMentId;			//物料属性
	private Long ftransferNum;				//调拨数量
	private String cfsubordinateDivis;		//所属事业部
	private String cfregistrationSites;		//上牌地点
	private String cfregistrationLoan;		//上牌和贷款公司
	private String cfgongHaowuId;			//工号
	private String cfnames;					//姓名
	private String cfgender;				//性别
	private String cfpostNameId;			//岗位名称
	private String cforiginalPostName;		//原岗位名称
	private Date cfentryTime;				//入职时间
	private String cfdepartmentId;			//部门
	private String cfdeparproper;			//部门性质
	private String cfclothingType;			//服装类型
	private Long cfconfigurationNumber;		//最高配置数量
	private Date cfstartingDate;			//到职日期
	private String cfunitId;				//单位
	private String cfissueTyep;				//发放类型
	private String cfissueconArea;			//发送配置区域
	private String cflicenceType;			//牌照类型
	private String cfteamcontactId;			//车队联系人
	private Date cfshouldPlace;				//需到位日期
	private String cfcontact;				//车队联系方式
	private String cfsecurityContacti;		//安全员联系人
	private String cfapplyReasons;			//申请事由
	private String cfrelationMethod;		//安全员联系方式
	private String cfuseDepartmentId;		//使用部门
	private String cfcarModel;				//车型
	private Long cfsignAmount;				//未签收数量
	private Long ffactNumber;				//实际申请数量
	private String fprojectBudgetId;		//预算项目
	private Long cfexportNumber;			// 出库数量
	private Long cfappbalance;				//数量
	private String cfpurOrderUnitId;		//采购组织
//	private String cfoutqty;				//
	
	private String cfpurorderunitid;        //采购组织ID
	
	
	
	/**
	 * @return the cfpurorderunitid
	 */
	public String getCfpurorderunitid() {
		return cfpurorderunitid;
	}
	/**
	 * @param cfpurorderunitid
	 */
	public void setCfpurorderunitid(String cfpurorderunitid) {
		this.cfpurorderunitid = cfpurorderunitid;
	}
	public String getCfpurOrderUnitId() {
		return cfpurOrderUnitId;
	}
	public void setCfpurOrderUnitId(String cfpurOrderUnitId) {
		this.cfpurOrderUnitId = cfpurOrderUnitId;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Long getFseq() {
		return fseq;
	}
	public void setFseq(Long fseq) {
		this.fseq = fseq;
	}
	public String getFparentId() {
		return fparentId;
	}
	public void setFparentId(String fparentId) {
		this.fparentId = fparentId;
	}
	public String getCfmaterialNumId() {
		return cfmaterialNumId;
	}
	public void setCfmaterialNumId(String cfmaterialNumId) {
		this.cfmaterialNumId = cfmaterialNumId;
	}
	public String getCfmaterialName() {
		return cfmaterialName;
	}
	public void setCfmaterialName(String cfmaterialName) {
		this.cfmaterialName = cfmaterialName;
	}
	public String getCfmaterialTypes() {
		return cfmaterialTypes;
	}
	public void setCfmaterialTypes(String cfmaterialTypes) {
		this.cfmaterialTypes = cfmaterialTypes;
	}
	public String getCfspecifications() {
		return cfspecifications;
	}
	public void setCfspecifications(String cfspecifications) {
		this.cfspecifications = cfspecifications;
	}
	public Long getCfquantity() {
		return cfquantity;
	}
	public void setCfquantity(Long cfquantity) {
		this.cfquantity = cfquantity;
	}
	
	public BigDecimal getCfreferencePrice() {
		return cfreferencePrice;
	}
	public void setCfreferencePrice(BigDecimal cfreferencePrice) {
		this.cfreferencePrice = cfreferencePrice;
	}
	public BigDecimal getCfreferenceAmount() {
		return cfreferenceAmount;
	}
	public void setCfreferenceAmount(BigDecimal cfreferenceAmount) {
		this.cfreferenceAmount = cfreferenceAmount;
	}
	public String getCfattribute() {
		return cfattribute;
	}
	public void setCfattribute(String cfattribute) {
		this.cfattribute = cfattribute;
	}
	public String getCfscrapApplication() {
		return cfscrapApplication;
	}
	public void setCfscrapApplication(String cfscrapApplication) {
		this.cfscrapApplication = cfscrapApplication;
	}
	public String getCfremake() {
		return cfremake;
	}
	public void setCfremake(String cfremake) {
		this.cfremake = cfremake;
	}
	public Long getCfalreadyShipment() {
		return cfalreadyShipment;
	}
	public void setCfalreadyShipment(Long cfalreadyShipment) {
		this.cfalreadyShipment = cfalreadyShipment;
	}
	public String getCfoutBoundNum() {
		return cfoutBoundNum;
	}
	public void setCfoutBoundNum(String cfoutBoundNum) {
		this.cfoutBoundNum = cfoutBoundNum;
	}
	public String getCfbatchNum() {
		return cfbatchNum;
	}
	public void setCfbatchNum(String cfbatchNum) {
		this.cfbatchNum = cfbatchNum;
	}
	public String getFmaterialMentId() {
		return fmaterialMentId;
	}
	public void setFmaterialMentId(String fmaterialMentId) {
		this.fmaterialMentId = fmaterialMentId;
	}
	public Long getFtransferNum() {
		return ftransferNum;
	}
	public void setFtransferNum(Long ftransferNum) {
		this.ftransferNum = ftransferNum;
	}
	public String getCfsubordinateDivis() {
		return cfsubordinateDivis;
	}
	public void setCfsubordinateDivis(String cfsubordinateDivis) {
		this.cfsubordinateDivis = cfsubordinateDivis;
	}
	public String getCfregistrationSites() {
		return cfregistrationSites;
	}
	public void setCfregistrationSites(String cfregistrationSites) {
		this.cfregistrationSites = cfregistrationSites;
	}
	public String getCfregistrationLoan() {
		return cfregistrationLoan;
	}
	public void setCfregistrationLoan(String cfregistrationLoan) {
		this.cfregistrationLoan = cfregistrationLoan;
	}
	public String getCfgongHaowuId() {
		return cfgongHaowuId;
	}
	public void setCfgongHaowuId(String cfgongHaowuId) {
		this.cfgongHaowuId = cfgongHaowuId;
	}
	public String getCfnames() {
		return cfnames;
	}
	public void setCfnames(String cfnames) {
		this.cfnames = cfnames;
	}
	public String getCfgender() {
		return cfgender;
	}
	public void setCfgender(String cfgender) {
		this.cfgender = cfgender;
	}
	public String getCfpostNameId() {
		return cfpostNameId;
	}
	public void setCfpostNameId(String cfpostNameId) {
		this.cfpostNameId = cfpostNameId;
	}
	public String getCforiginalPostName() {
		return cforiginalPostName;
	}
	public void setCforiginalPostName(String cforiginalPostName) {
		this.cforiginalPostName = cforiginalPostName;
	}
	public Date getCfentryTime() {
		return cfentryTime;
	}
	public void setCfentryTime(Date cfentryTime) {
		this.cfentryTime = cfentryTime;
	}
	public String getCfdepartmentId() {
		return cfdepartmentId;
	}
	public void setCfdepartmentId(String cfdepartmentId) {
		this.cfdepartmentId = cfdepartmentId;
	}
	public String getCfdeparproper() {
		return cfdeparproper;
	}
	public void setCfdeparproper(String cfdeparproper) {
		this.cfdeparproper = cfdeparproper;
	}
	public String getCfclothingType() {
		return cfclothingType;
	}
	public void setCfclothingType(String cfclothingType) {
		this.cfclothingType = cfclothingType;
	}
	public Long getCfconfigurationNumber() {
		return cfconfigurationNumber;
	}
	public void setCfconfigurationNumber(Long cfconfigurationNumber) {
		this.cfconfigurationNumber = cfconfigurationNumber;
	}
	public Date getCfstartingDate() {
		return cfstartingDate;
	}
	public void setCfstartingDate(Date cfstartingDate) {
		this.cfstartingDate = cfstartingDate;
	}
	public String getCfunitId() {
		return cfunitId;
	}
	public void setCfunitId(String cfunitId) {
		this.cfunitId = cfunitId;
	}
	public String getCfissueTyep() {
		return cfissueTyep;
	}
	public void setCfissueTyep(String cfissueTyep) {
		this.cfissueTyep = cfissueTyep;
	}
	public String getCfissueconArea() {
		return cfissueconArea;
	}
	public void setCfissueconArea(String cfissueconArea) {
		this.cfissueconArea = cfissueconArea;
	}
	public String getCflicenceType() {
		return cflicenceType;
	}
	
	public String getCflicenceTypeStr() {
		if ("10".equals(cflicenceType)) {
			return "黄牌货运";
		}else if ("20".equals(cflicenceType)) {
			return "蓝牌货运";
		}else if ("30".equals(cflicenceType)) {
			return "黄牌客运";
		}else if ("40".equals(cflicenceType)) {
			return "蓝牌客运";
		}else
		return "";
	}
	public void setCflicenceType(String cflicenceType) {
		this.cflicenceType = cflicenceType;
	}
	public String getCfteamcontactId() {
		return cfteamcontactId;
	}
	public void setCfteamcontactId(String cfteamcontactId) {
		this.cfteamcontactId = cfteamcontactId;
	}
	public Date getCfshouldPlace() {
		return cfshouldPlace;
	}
	
	public String getCfshouldPlaceStr() {
		return FormatUtil.formatDate(cfshouldPlace,"yyyy-MM-dd");
	}
	public void setCfshouldPlace(Date cfshouldPlace) {
		this.cfshouldPlace = cfshouldPlace;
	}
	public String getCfcontact() {
		return cfcontact;
	}
	public void setCfcontact(String cfcontact) {
		this.cfcontact = cfcontact;
	}
	public String getCfsecurityContacti() {
		return cfsecurityContacti;
	}
	public void setCfsecurityContacti(String cfsecurityContacti) {
		this.cfsecurityContacti = cfsecurityContacti;
	}
	public String getCfapplyReasons() {
		return cfapplyReasons;
	}
	public void setCfapplyReasons(String cfapplyReasons) {
		this.cfapplyReasons = cfapplyReasons;
	}
	public String getCfrelationMethod() {
		return cfrelationMethod;
	}
	public void setCfrelationMethod(String cfrelationMethod) {
		this.cfrelationMethod = cfrelationMethod;
	}
	public String getCfuseDepartmentId() {
		return cfuseDepartmentId;
	}
	public void setCfuseDepartmentId(String cfuseDepartmentId) {
		this.cfuseDepartmentId = cfuseDepartmentId;
	}
	public String getCfcarModel() {
		return cfcarModel;
	}
	public void setCfcarModel(String cfcarModel) {
		this.cfcarModel = cfcarModel;
	}
	public Long getCfsignAmount() {
		return cfsignAmount;
	}
	public void setCfsignAmount(Long cfsignAmount) {
		this.cfsignAmount = cfsignAmount;
	}
	public Long getFfactNumber() {
		return ffactNumber;
	}
	public void setFfactNumber(Long ffactNumber) {
		this.ffactNumber = ffactNumber;
	}
	public String getFprojectBudgetId() {
		return fprojectBudgetId;
	}
	public void setFprojectBudgetId(String fprojectBudgetId) {
		this.fprojectBudgetId = fprojectBudgetId;
	}
	public Long getCfexportNumber() {
		return cfexportNumber;
	}
	public void setCfexportNumber(Long cfexportNumber) {
		this.cfexportNumber = cfexportNumber;
	}
	public Long getCfappbalance() {
		return cfappbalance;
	}
	public void setCfappbalance(Long cfappbalance) {
		this.cfappbalance = cfappbalance;
	}
//	public String getCfoutqty() {
//		return cfoutqty;
//	}
//	public void setCfoutqty(String cfoutqty) {
//		this.cfoutqty = cfoutqty;
//	}
}

