package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;
import java.util.Date;
import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/**
 * @ClassName: SonApplicationNeedsEntity 
 * @Description: 子需求申请单实体
 * @author Jianghaibin
 * @date 2013-11-4 下午3:03:16
 */
public class SonApplicationNeedsEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String fid;						//主键
	private String fcreatorId;				//创建者
	private Date fcreateTime;				//创建时间
	private String flastUpdateUserId;		//最后修改者
	private Date flastUpdateTime;			//最后修改者
	private String fcontrolUnitId;			//控制单元
	private String fnumber;					//单据编号
	private Date fbizDate;					//业务日期
	private String fhandlerId;				//经手人
	private String fdescription;			//参考信息
	private Long fhasEffected;				//是否曾经生效
	private String fauditorId;				//审核人
	private String fsourceBillId;			//原始单据ID
	private String fsourceFunction;			//来源功能
	private Long ffivouchered;				//是否生成凭证
	private Date cfauditTime;				//审核时间
	private String cfapplicantId;			//申请人
	private String cfapplicantdepsId;		//申请部门
	private String cfsubOrdinateWareh;		//所属仓库
	private String cfdeliveryDepartme;		//送货部门
	private String cfaddress;				//地址
	private String cfphone;					//电话
	private String cfsubOrdSubsiDiary;		//所属子公司
	private Long cfchangeRepleni;			//是否换／补货
	private String cfexpenseBeaDepart;		//费用承担部门
	private Long cfcandidPointStan;			//是否新点标配
	private Long cfunplanPurchases;			//是否计划外采购
	private String cfstate;					//状态
	private String cfcarDepartmType;		//配车部门类型
	private String cfbimudf0058;			//文本
	private String cfsubOrdSubsiId;			//所属子公司
	private String cfapplicationMethods;	//申请方式
	private String cftype;					//类型
	private String cfmistakesNumbers;		//差错编号
	private String cfclaimNumbers;			//认领编号
	private String cfremake;				//备注
	private String fcreatOrgId;				//创建部门
	private Long fsonNeedList;				//子需求申请单
	private Long fswcNeedList;				//商务车需求申请单
	private Long fgfneedList;				//工服申请单
	private Long fgcneedLsit;				//购车申请单
	private String fproNumberId;			//项目编号
	private String fproName;				//项目名称
	private Long fisl;						//是否积分礼品
	private String ftickedOrgId;			//费用承担部门
	private String fneedType;				//需求类型
	private Long fisPur;					//是否计划外采购
	private String cfmaterialBelongId;		//物料属性
	private String cfwarehousezzId;			//库存组织
	private String cfpurOrderUnitId;		//采购组织
	private String fcostCenterId;			//成本中心
	private String cfcurrencyId;			//币别
	private String fcompanyId;				//公司
	private String fcostCenterLastId;		//成本中心后台
	private Long cfisDesignCls;				//是否设计类
	private BigDecimal cftotalApplyAmount;	//总金额
	private String cfpersonCount;			//部门人数(LMS为String类型)
	private BigDecimal cfcapitaAmount;		//人均金额
	private Long cffunifiedapp;				//是否统一申请
	private String cfcarType;				//车辆类型  车辆类型： 0代表营运车 1代表商务车
	
	
	///10.12
	private String cfisexpress; // 是否是快递点部门申请
	private String cfisB2B;//是否电商类采购
	private String address;
	private String addressId;
	private String cfarrivaldepartment;
	private String cfarrivaldepartmentid; 
	private String cfdetailaddress; 

	private String cfdeliveryDepartmeasName;
	
	
	/**
	 * @return the cfisexpress
	 */
	public String getCfisexpress() {
		return cfisexpress;
	}
	/**
	 * @param cfisexpress
	 */
	public void setCfisexpress(String cfisexpress) {
		this.cfisexpress = cfisexpress;
	}
	/**
	 * @return the cfisB2B
	 */
	public String getCfisB2B() {
		return cfisB2B;
	}
	/**
	 * @param cfisB2B
	 */
	public void setCfisB2B(String cfisB2B) {
		this.cfisB2B = cfisB2B;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the cfarrivaldepartment
	 */
	public String getCfarrivaldepartment() {
		return cfarrivaldepartment;
	}
	/**
	 * @param cfarrivaldepartment
	 */
	public void setCfarrivaldepartment(String cfarrivaldepartment) {
		this.cfarrivaldepartment = cfarrivaldepartment;
	}
	/**
	 * @return the cfarrivaldepartmentid
	 */
	public String getCfarrivaldepartmentid() {
		return cfarrivaldepartmentid;
	}
	/**
	 * @param cfarrivaldepartmentid
	 */
	public void setCfarrivaldepartmentid(String cfarrivaldepartmentid) {
		this.cfarrivaldepartmentid = cfarrivaldepartmentid;
	}
	/**
	 * @return the cfdetailaddress
	 */
	public String getCfdetailaddress() {
		return cfdetailaddress;
	}
	/**
	 * @param cfdetailaddress
	 */
	public void setCfdetailaddress(String cfdetailaddress) {
		this.cfdetailaddress = cfdetailaddress;
	}
	/**
	 * @return the cfdeliveryDepartmeasName
	 */
	public String getCfdeliveryDepartmeasName() {
		return cfdeliveryDepartmeasName;
	}
	/**
	 * @param cfdeliveryDepartmeasName
	 */
	public void setCfdeliveryDepartmeasName(String cfdeliveryDepartmeasName) {
		this.cfdeliveryDepartmeasName = cfdeliveryDepartmeasName;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFcreatorId() {
		return fcreatorId;
	}
	public void setFcreatorId(String fcreatorId) {
		this.fcreatorId = fcreatorId;
	}
	public Date getFcreateTime() {
		return fcreateTime;
	}
	
	public String getFcreateTimeStr() {
		return FormatUtil.formatDate(fcreateTime,"yyyy-MM-dd");
	}
	
	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	public String getFlastUpdateUserId() {
		return flastUpdateUserId;
	}
	public void setFlastUpdateUserId(String flastUpdateUserId) {
		this.flastUpdateUserId = flastUpdateUserId;
	}
	public Date getFlastUpdateTime() {
		return flastUpdateTime;
	}
	public void setFlastUpdateTime(Date flastUpdateTime) {
		this.flastUpdateTime = flastUpdateTime;
	}
	public String getFcontrolUnitId() {
		return fcontrolUnitId;
	}
	public void setFcontrolUnitId(String fcontrolUnitId) {
		this.fcontrolUnitId = fcontrolUnitId;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public Date getFbizDate() {
		return fbizDate;
	}
	public void setFbizDate(Date fbizDate) {
		this.fbizDate = fbizDate;
	}
	public String getFhandlerId() {
		return fhandlerId;
	}
	public void setFhandlerId(String fhandlerId) {
		this.fhandlerId = fhandlerId;
	}
	public String getFdescription() {
		return fdescription;
	}
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	public Long getFhasEffected() {
		return fhasEffected;
	}
	public void setFhasEffected(Long fhasEffected) {
		this.fhasEffected = fhasEffected;
	}
	public String getFauditorId() {
		return fauditorId;
	}
	public void setFauditorId(String fauditorId) {
		this.fauditorId = fauditorId;
	}
	public String getFsourceBillId() {
		return fsourceBillId;
	}
	public void setFsourceBillId(String fsourceBillId) {
		this.fsourceBillId = fsourceBillId;
	}
	public String getFsourceFunction() {
		return fsourceFunction;
	}
	public void setFsourceFunction(String fsourceFunction) {
		this.fsourceFunction = fsourceFunction;
	}
	public Long getFfivouchered() {
		return ffivouchered;
	}
	public void setFfivouchered(Long ffivouchered) {
		this.ffivouchered = ffivouchered;
	}
	public Date getCfauditTime() {
		return cfauditTime;
	}
	public void setCfauditTime(Date cfauditTime) {
		this.cfauditTime = cfauditTime;
	}
	public String getCfapplicantId() {
		return cfapplicantId;
	}
	public void setCfapplicantId(String cfapplicantId) {
		this.cfapplicantId = cfapplicantId;
	}
	public String getCfapplicantdepsId() {
		return cfapplicantdepsId;
	}
	public void setCfapplicantdepsId(String cfapplicantdepsId) {
		this.cfapplicantdepsId = cfapplicantdepsId;
	}
	public String getCfsubOrdinateWareh() {
		return cfsubOrdinateWareh;
	}
	public void setCfsubOrdinateWareh(String cfsubOrdinateWareh) {
		this.cfsubOrdinateWareh = cfsubOrdinateWareh;
	}
	public String getCfdeliveryDepartme() {
		return cfdeliveryDepartme;
	}
	public void setCfdeliveryDepartme(String cfdeliveryDepartme) {
		this.cfdeliveryDepartme = cfdeliveryDepartme;
	}
	public String getCfaddress() {
		return cfaddress;
	}
	public void setCfaddress(String cfaddress) {
		this.cfaddress = cfaddress;
	}
	public String getCfphone() {
		return cfphone;
	}
	public void setCfphone(String cfphone) {
		this.cfphone = cfphone;
	}
	public String getCfsubOrdSubsiDiary() {
		return cfsubOrdSubsiDiary;
	}
	public void setCfsubOrdSubsiDiary(String cfsubOrdSubsiDiary) {
		this.cfsubOrdSubsiDiary = cfsubOrdSubsiDiary;
	}
	public Long getCfchangeRepleni() {
		return cfchangeRepleni;
	}
	public void setCfchangeRepleni(Long cfchangeRepleni) {
		this.cfchangeRepleni = cfchangeRepleni;
	}
	public String getCfexpenseBeaDepart() {
		return cfexpenseBeaDepart;
	}
	public void setCfexpenseBeaDepart(String cfexpenseBeaDepart) {
		this.cfexpenseBeaDepart = cfexpenseBeaDepart;
	}
	public Long getCfcandidPointStan() {
		return cfcandidPointStan;
	}
	public void setCfcandidPointStan(Long cfcandidPointStan) {
		this.cfcandidPointStan = cfcandidPointStan;
	}
	public Long getCfunplanPurchases() {
		return cfunplanPurchases;
	}
	public void setCfunplanPurchases(Long cfunplanPurchases) {
		this.cfunplanPurchases = cfunplanPurchases;
	}
	public String getCfstate() {
		return cfstate;
	}
	public void setCfstate(String cfstate) {
		this.cfstate = cfstate;
	}
	public String getCfcarDepartmType() {
		return cfcarDepartmType;
	}
	
	public String getCfcarDepartmTypeStr() {
		if ("10".equals(cfcarDepartmType)) {
			return "营业部配车";
		}else if ("20".equals(cfcarDepartmType)) {
			return "车队配车";
		}else if ("30".equals(cfcarDepartmType)) {
			return "预算配车";
		}
		return "";
	}
	public void setCfcarDepartmType(String cfcarDepartmType) {
		this.cfcarDepartmType = cfcarDepartmType;
	}
	public String getCfbimudf0058() {
		return cfbimudf0058;
	}
	public void setCfbimudf0058(String cfbimudf0058) {
		this.cfbimudf0058 = cfbimudf0058;
	}
	public String getCfsubOrdSubsiId() {
		return cfsubOrdSubsiId;
	}
	public void setCfsubOrdSubsiId(String cfsubOrdSubsiId) {
		this.cfsubOrdSubsiId = cfsubOrdSubsiId;
	}
	public String getCfapplicationMethods() {
		return cfapplicationMethods;
	}
	public void setCfapplicationMethods(String cfapplicationMethods) {
		this.cfapplicationMethods = cfapplicationMethods;
	}
	public String getCftype() {
		return cftype;
	}
	public void setCftype(String cftype) {
		this.cftype = cftype;
	}
	public String getCfmistakesNumbers() {
		return cfmistakesNumbers;
	}
	public void setCfmistakesNumbers(String cfmistakesNumbers) {
		this.cfmistakesNumbers = cfmistakesNumbers;
	}
	public String getCfclaimNumbers() {
		return cfclaimNumbers;
	}
	public void setCfclaimNumbers(String cfclaimNumbers) {
		this.cfclaimNumbers = cfclaimNumbers;
	}
	public String getCfremake() {
		return cfremake;
	}
	public void setCfremake(String cfremake) {
		this.cfremake = cfremake;
	}
	public String getFcreatOrgId() {
		return fcreatOrgId;
	}
	public void setFcreatOrgId(String fcreatOrgId) {
		this.fcreatOrgId = fcreatOrgId;
	}
	public Long getFsonNeedList() {
		return fsonNeedList;
	}
	public void setFsonNeedList(Long fsonNeedList) {
		this.fsonNeedList = fsonNeedList;
	}
	public Long getFswcNeedList() {
		return fswcNeedList;
	}
	public void setFswcNeedList(Long fswcNeedList) {
		this.fswcNeedList = fswcNeedList;
	}
	public Long getFgfneedList() {
		return fgfneedList;
	}
	public void setFgfneedList(Long fgfneedList) {
		this.fgfneedList = fgfneedList;
	}
	public Long getFgcneedLsit() {
		return fgcneedLsit;
	}
	public void setFgcneedLsit(Long fgcneedLsit) {
		this.fgcneedLsit = fgcneedLsit;
	}
	public String getFproNumberId() {
		return fproNumberId;
	}
	public void setFproNumberId(String fproNumberId) {
		this.fproNumberId = fproNumberId;
	}
	public String getFproName() {
		return fproName;
	}
	public void setFproName(String fproName) {
		this.fproName = fproName;
	}
	public Long getFisl() {
		return fisl;
	}
	public void setFisl(Long fisl) {
		this.fisl = fisl;
	}
	public String getFtickedOrgId() {
		return ftickedOrgId;
	}
	public void setFtickedOrgId(String ftickedOrgId) {
		this.ftickedOrgId = ftickedOrgId;
	}
	public String getFneedType() {
		return fneedType;
	}
	public void setFneedType(String fneedType) {
		this.fneedType = fneedType;
	}
	public Long getFisPur() {
		return fisPur;
	}
	//1表示是,0表示否
	public String getFisPurStr() {
		if (fisPur != null) {
			if (fisPur==1){
				return "是";
			}else {
				return "否";
			}
		}else {
			return "";
		}
		
	}
	public void setFisPur(Long fisPur) {
		this.fisPur = fisPur;
	}
	public String getCfmaterialBelongId() {
		return cfmaterialBelongId;
	}
	public void setCfmaterialBelongId(String cfmaterialBelongId) {
		this.cfmaterialBelongId = cfmaterialBelongId;
	}
	public String getCfwarehousezzId() {
		return cfwarehousezzId;
	}
	public void setCfwarehousezzId(String cfwarehousezzId) {
		this.cfwarehousezzId = cfwarehousezzId;
	}
	public String getCfpurOrderUnitId() {
		return cfpurOrderUnitId;
	}
	public void setCfpurOrderUnitId(String cfpurOrderUnitId) {
		this.cfpurOrderUnitId = cfpurOrderUnitId;
	}
	public String getFcostCenterId() {
		return fcostCenterId;
	}
	public void setFcostCenterId(String fcostCenterId) {
		this.fcostCenterId = fcostCenterId;
	}
	public String getCfcurrencyId() {
		return cfcurrencyId;
	}
	public void setCfcurrencyId(String cfcurrencyId) {
		this.cfcurrencyId = cfcurrencyId;
	}
	public String getFcompanyId() {
		return fcompanyId;
	}
	public void setFcompanyId(String fcompanyId) {
		this.fcompanyId = fcompanyId;
	}
	public String getFcostCenterLastId() {
		return fcostCenterLastId;
	}
	public void setFcostCenterLastId(String fcostCenterLastId) {
		this.fcostCenterLastId = fcostCenterLastId;
	}
	public Long getCfisDesignCls() {
		return cfisDesignCls;
	}
	public void setCfisDesignCls(Long cfisDesignCls) {
		this.cfisDesignCls = cfisDesignCls;
	}
	public BigDecimal getCftotalApplyAmount() {
		return cftotalApplyAmount;
	}
	public void setCftotalApplyAmount(BigDecimal cftotalApplyAmount) {
		this.cftotalApplyAmount = cftotalApplyAmount;
	}
	public String getCfpersonCount() {
		return cfpersonCount;
	}
	public void setCfpersonCount(String cfpersonCount) {
		this.cfpersonCount = cfpersonCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getCfcapitaAmount() {
		return cfcapitaAmount;
	}
	public void setCfcapitaAmount(BigDecimal cfcapitaAmount) {
		this.cfcapitaAmount = cfcapitaAmount;
	}
	public Long getCffunifiedapp() {
		return cffunifiedapp;
	}
	public void setCffunifiedapp(Long cffunifiedapp) {
		this.cffunifiedapp = cffunifiedapp;
	}
	public String getCfcarType() {
		return cfcarType;
	}
	//车辆类型： 0代表营运车 1代表商务车
	public String getCfcarTypeStr() {
		if ("0".equals(cfcarType)) {
			return "营运车";
		}else if ("1".equals(cfcarType)) {
			return "商务车";
		}
		return "";
	}
	public void setCfcarType(String cfcarType) {
		this.cfcarType = cfcarType;
	}
}

