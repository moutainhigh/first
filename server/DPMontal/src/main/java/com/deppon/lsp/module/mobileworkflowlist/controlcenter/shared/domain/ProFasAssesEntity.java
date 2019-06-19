package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/**
 * 
* 工程项目可行性评估实体类
* @title: ProFasAssesEntity 
* @author： lihai
* @date： 2013-12-25 上午11:03:24
 */
public class ProFasAssesEntity extends BaseEntity implements Serializable{
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	//创建者
	private String fcreatorId;
	//创建时间
	private Date fcreateTime;
	//最后修改者
	private String flastUpdateuserId;
	//最后修改时间
	private Date flastUpdateTime;
	//控制单元
	private String fcontrolUnitId;
	//单据编号
	private String fnumber;
	//业务日期
	private Date fbizDate;
	//经手人
	private String fhandlerId;
	//参考信息
	private String fdescription;
	//是否曾经生效
	private int fhaseffected;
	//审核人
	private String fauditorId;
	//原始单据ID
	private String fsourceBillId;
	//来源功能
	private String fsourceFunction;
	//id
	private String fid;
	//是否生成凭证
	private int ffivouchered;
	//项目级别
	private String cfprojectLevel;
	//项目所在地
	private String cfprojectSeat;
	//设计评定预计难度
	private String cfassessdifficult;
	//项目类型
	private String cfprojectType;
	//项目发起日期
	private Date cfstartTime;
	//评估分数
	private BigDecimal cfratingValue;
	//金额
	private BigDecimal cfreportedAmount;
	//评估意见
	private String cfassessIdea;
	//是否可以施工
	private String cfisconstruction;
	//备注(申请事由)
	private String cfassessideatow;
	//非网点分类
	private String cfnotpionttypeId;
	//项目编码ID
	private String fprojectNumberId;
	//项目名称
	private String fprojectName;
	//所属事业部
	private String fdivisionId;
	//单据状态
	private String fstate;
	//创建部门
	private String fcreateorgId;
	//施工类型
	private String fconstructionType;
	//项目发起部门
	private String cfstartDeptId;
	
	
	
	/**
	 * 页面显示字段
	 */
	//申请人姓名
	private String applyerName;
	//申请人部门
	private String applyDeptName;
	//所属事业部
	private String busDivision;
	//项目编号
	private String fprojectNumber;
	//项目级别
	private String cfprojectLevelName;
	//施工类型
	private String fconstructionTypeName;
	//项目类型
	private String cfprojectTypeName;
	//非网点分类
	private String cfnotpionttypeName;
	//项目发起部门
	private String cfstartDeptName;
	//项目发起部门标杆编码
	private String cfstartDeptFinasysCode;
	
	
	
	/**
	 *以下为借用字段，非表字段
	 */
	/** 用户编码 */
	private String userCode ;
	/** 用户名称 */
	private String userName ;
	/** 部门标杆编码 */
	private String deptStandCode ;
	/** 部门名称 */
	private String deptName ;
	
	
	
	
	/**
	 * @return the cfstartDeptFinasysCode
	 */
	public String getCfstartDeptFinasysCode() {
		if (cfstartDeptFinasysCode == null) {
			cfstartDeptFinasysCode = "";
		}
		return cfstartDeptFinasysCode;
	}
	/**
	 * @param cfstartDeptFinasysCode the cfstartDeptFinasysCode to set
	 */
	public void setCfstartDeptFinasysCode(String cfstartDeptFinasysCode) {
		this.cfstartDeptFinasysCode = cfstartDeptFinasysCode;
	}
	/**
	 * @return the cfstartDeptId
	 */
	public String getCfstartDeptId() {
		if (cfstartDeptId == null) {
			cfstartDeptId = "";
		}
		return cfstartDeptId;
	}
	/**
	 * @param cfstartDeptId the cfstartDeptId to set
	 */
	public void setCfstartDeptId(String cfstartDeptId) {
		this.cfstartDeptId = cfstartDeptId;
	}
	/**
	 * @return the cfstartDeptName
	 */
	public String getCfstartDeptName() {
		if (cfstartDeptName == null) {
			cfstartDeptName = "";
		}
		return cfstartDeptName;
	}
	/**
	 * @param cfstartDeptName the cfstartDeptName to set
	 */
	public void setCfstartDeptName(String cfstartDeptName) {
		this.cfstartDeptName = cfstartDeptName;
	}
	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		if (userCode == null) {
			userCode = "";
		}
		return userCode;
	}
	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		if (userName == null) {
			userName = "";
		}
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the deptStandCode
	 */
	public String getDeptStandCode() {
		if (deptStandCode == null) {
			deptStandCode = "";
		}
		return deptStandCode;
	}
	/**
	 * @param deptStandCode the deptStandCode to set
	 */
	public void setDeptStandCode(String deptStandCode) {
		this.deptStandCode = deptStandCode;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		if (deptName == null) {
			deptName = "";
		}
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return the cfnotpionttypeName
	 */
	public String getCfnotpionttypeName() {
		if (cfnotpionttypeName == null) {
			cfnotpionttypeName = "";
		}
		return cfnotpionttypeName;
	}
	/**
	 * @param cfnotpionttypeName the cfnotpionttypeName to set
	 */
	public void setCfnotpionttypeName(String cfnotpionttypeName) {
		this.cfnotpionttypeName = cfnotpionttypeName;
	}
	/**
	 * @return the cfprojectLevelName
	 */
	public String getCfprojectLevelName() {
		if (cfprojectLevelName == null) {
			cfprojectLevelName = "";
		}
		return cfprojectLevelName;
	}
	/**
	 * @param cfprojectLevelName the cfprojectLevelName to set
	 */
	public void setCfprojectLevelName(String cfprojectLevelName) {
		this.cfprojectLevelName = cfprojectLevelName;
	}
	/**
	 * @return the fconstructionTypeName
	 */
	public String getFconstructionTypeName() {
		if (fconstructionTypeName == null) {
			fconstructionTypeName = "";
		}
		return fconstructionTypeName;
	}
	/**
	 * @param fconstructionTypeName the fconstructionTypeName to set
	 */
	public void setFconstructionTypeName(String fconstructionTypeName) {
		this.fconstructionTypeName = fconstructionTypeName;
	}
	/**
	 * @return the cfprojectTypeName
	 */
	public String getCfprojectTypeName() {
		if (cfprojectTypeName == null) {
			cfprojectTypeName = "";
		}
		return cfprojectTypeName;
	}
	/**
	 * @param cfprojectTypeName the cfprojectTypeName to set
	 */
	public void setCfprojectTypeName(String cfprojectTypeName) {
		this.cfprojectTypeName = cfprojectTypeName;
	}
	/**
	 * @return the applyerName
	 */
	public String getApplyerName() {
		if (applyerName == null) {
			applyerName = "";
		}
		return applyerName;
	}
	/**
	 * @param applyerName the applyerName to set
	 */
	public void setApplyerName(String applyerName) {
		this.applyerName = applyerName;
	}
	/**
	 * @return the applyDeptName
	 */
	public String getApplyDeptName() {
		if (applyDeptName == null) {
			applyDeptName = "";
		}
		return applyDeptName;
	}
	/**
	 * @param applyDeptName the applyDeptName to set
	 */
	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}
	/**
	 * @return the busDivision
	 */
	public String getBusDivision() {
		if (busDivision == null) {
			busDivision = "";
		}
		return busDivision;
	}
	/**
	 * @param busDivision the busDivision to set
	 */
	public void setBusDivision(String busDivision) {
		this.busDivision = busDivision;
	}
	/**
	 * @return the fprojectNumber
	 */
	public String getFprojectNumber() {
		if (fprojectNumber == null) {
			fprojectNumber = "";
		}
		return fprojectNumber;
	}
	/**
	 * @param fprojectNumber the fprojectNumber to set
	 */
	public void setFprojectNumber(String fprojectNumber) {
		this.fprojectNumber = fprojectNumber;
	}
	/**
	 * @return the fcreatorId
	 */
	public String getFcreatorId() {
		if (fcreatorId == null) {
			fcreatorId = "";
		}
		return fcreatorId;
	}
	/**
	 * @param fcreatorId the fcreatorId to set
	 */
	public void setFcreatorId(String fcreatorId) {
		this.fcreatorId = fcreatorId;
	}
	/**
	 * @return the fcreateTime
	 */
	public Date getFcreateTime() {
		return fcreateTime;
	}
	
	public String getFcreateTimeStr(){
		return FormatUtil.formatDate(fcreateTime,"yyyy-MM-dd");
	}
	/**
	 * @param fcreateTime the fcreateTime to set
	 */
	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	/**
	 * @return the flastUpdateuserId
	 */
	public String getFlastUpdateuserId() {
		if (flastUpdateuserId == null) {
			flastUpdateuserId = "";
		}
		return flastUpdateuserId;
	}
	/**
	 * @param flastUpdateuserId the flastUpdateuserId to set
	 */
	public void setFlastUpdateuserId(String flastUpdateuserId) {
		this.flastUpdateuserId = flastUpdateuserId;
	}
	/**
	 * @return the flastUpdateTime
	 */
	public Date getFlastUpdateTime() {
		return flastUpdateTime;
	}
	/**
	 * @param flastUpdateTime the flastUpdateTime to set
	 */
	public void setFlastUpdateTime(Date flastUpdateTime) {
		this.flastUpdateTime = flastUpdateTime;
	}
	/**
	 * @return the fcontrolUnitId
	 */
	public String getFcontrolUnitId() {
		if (fcontrolUnitId == null) {
			fcontrolUnitId = "";
		}
		return fcontrolUnitId;
	}
	/**
	 * @param fcontrolUnitId the fcontrolUnitId to set
	 */
	public void setFcontrolUnitId(String fcontrolUnitId) {
		this.fcontrolUnitId = fcontrolUnitId;
	}
	/**
	 * @return the fnumber
	 */
	public String getFnumber() {
		if (fnumber == null) {
			fnumber = "";
		}
		return fnumber;
	}
	/**
	 * @param fnumber the fnumber to set
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	/**
	 * @return the fbizDate
	 */
	public Date getFbizDate() {
		return fbizDate;
	}
	/**
	 * @param fbizDate the fbizDate to set
	 */
	public void setFbizDate(Date fbizDate) {
		this.fbizDate = fbizDate;
	}
	/**
	 * @return the fhandlerId
	 */
	public String getFhandlerId() {
		if (fhandlerId == null) {
			fhandlerId = "";
		}
		return fhandlerId;
	}
	/**
	 * @param fhandlerId the fhandlerId to set
	 */
	public void setFhandlerId(String fhandlerId) {
		this.fhandlerId = fhandlerId;
	}
	/**
	 * @return the fdescription
	 */
	public String getFdescription() {
		if (fdescription == null) {
			fdescription = "";
		}
		return fdescription;
	}
	/**
	 * @param fdescription the fdescription to set
	 */
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	/**
	 * @return the fhaseffected
	 */
	public int getFhaseffected() {
		return fhaseffected;
	}
	/**
	 * @param fhaseffected the fhaseffected to set
	 */
	public void setFhaseffected(int fhaseffected) {
		this.fhaseffected = fhaseffected;
	}
	/**
	 * @return the fauditorId
	 */
	public String getFauditorId() {
		if (fauditorId == null) {
			fauditorId = "";
		}
		return fauditorId;
	}
	/**
	 * @param fauditorId the fauditorId to set
	 */
	public void setFauditorId(String fauditorId) {
		this.fauditorId = fauditorId;
	}
	/**
	 * @return the fsourceBillId
	 */
	public String getFsourceBillId() {
		if (fsourceBillId == null) {
			fsourceBillId = "";
		}
		return fsourceBillId;
	}
	/**
	 * @param fsourceBillId the fsourceBillId to set
	 */
	public void setFsourceBillId(String fsourceBillId) {
		this.fsourceBillId = fsourceBillId;
	}
	/**
	 * @return the fsourceFunction
	 */
	public String getFsourceFunction() {
		if (fsourceFunction == null) {
			fsourceFunction = "";
		}
		return fsourceFunction;
	}
	/**
	 * @param fsourceFunction the fsourceFunction to set
	 */
	public void setFsourceFunction(String fsourceFunction) {
		this.fsourceFunction = fsourceFunction;
	}
	
	/**
	 * @return the fid
	 */
	public String getFid() {
		if (fid == null) {
			fid = "";
		}
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * @return the ffivouchered
	 */
	public int getFfivouchered() {
		return ffivouchered;
	}
	/**
	 * @param ffivouchered the ffivouchered to set
	 */
	public void setFfivouchered(int ffivouchered) {
		this.ffivouchered = ffivouchered;
	}
	/**
	 * @return the cfprojectLevel
	 */
	public String getCfprojectLevel() {
		if (cfprojectLevel == null) {
			cfprojectLevel = "";
		}
		return cfprojectLevel;
	}
	/**
	 * @param cfprojectLevel the cfprojectLevel to set
	 */
	public void setCfprojectLevel(String cfprojectLevel) {
		this.cfprojectLevel = cfprojectLevel;
	}
	/**
	 * @return the cfprojectSeat
	 */
	public String getCfprojectSeat() {
		if (cfprojectSeat == null) {
			cfprojectSeat = "";
		}
		return cfprojectSeat;
	}
	/**
	 * @param cfprojectSeat the cfprojectSeat to set
	 */
	public void setCfprojectSeat(String cfprojectSeat) {
		this.cfprojectSeat = cfprojectSeat;
	}
	/**
	 * @return the cfassessdifficult
	 */
	public String getCfassessdifficult() {
		if (cfassessdifficult == null) {
			cfassessdifficult = "";
		}
		return cfassessdifficult;
	}
	/**
	 * @param cfassessdifficult the cfassessdifficult to set
	 */
	public void setCfassessdifficult(String cfassessdifficult) {
		this.cfassessdifficult = cfassessdifficult;
	}
	/**
	 * @return the cfprojectType
	 */
	public String getCfprojectType() {
		if (cfprojectType == null) {
			cfprojectType = "";
		}
		return cfprojectType;
	}
	/**
	 * @param cfprojectType the cfprojectType to set
	 */
	public void setCfprojectType(String cfprojectType) {
		this.cfprojectType = cfprojectType;
	}
	/**
	 * @return the cfstartTime
	 */
	public Date getCfstartTime() {
		return cfstartTime;
	}
	
	public String getCfstartTimeStr() {
		return FormatUtil.formatDate(cfstartTime,"yyyy-MM-dd");
	}
	
	/**
	 * @param cfstartTime the cfstartTime to set
	 */
	public void setCfstartTime(Date cfstartTime) {
		this.cfstartTime = cfstartTime;
	}
	/**
	 * @return the cfratingValue
	 */
	public BigDecimal getCfratingValue() {
		return cfratingValue;
	}
	/**
	 * @param cfratingValue the cfratingValue to set
	 */
	public void setCfratingValue(BigDecimal cfratingValue) {
		this.cfratingValue = cfratingValue;
	}
	/**
	 * @return the cfreportedAmount
	 */
	public BigDecimal getCfreportedAmount() {
		return cfreportedAmount;
	}
	/**
	 * @param cfreportedAmount the cfreportedAmount to set
	 */
	public void setCfreportedAmount(BigDecimal cfreportedAmount) {
		this.cfreportedAmount = cfreportedAmount;
	}
	/**
	 * @return the cfassessIdea
	 */
	public String getCfassessIdea() {
		if (cfassessIdea == null) {
			cfassessIdea = "";
		}
		return cfassessIdea;
	}
	/**
	 * @param cfassessIdea the cfassessIdea to set
	 */
	public void setCfassessIdea(String cfassessIdea) {
		this.cfassessIdea = cfassessIdea;
	}
	/**
	 * @return the cfisconstruction
	 */
	public String getCfisconstruction() {
		if (cfisconstruction == null) {
			cfisconstruction = "";
		}
		return cfisconstruction;
	}
	/**
	 * @param cfisconstruction the cfisconstruction to set
	 */
	public void setCfisconstruction(String cfisconstruction) {
		this.cfisconstruction = cfisconstruction;
	}
	/**
	 * @return the cfassessideatow
	 */
	public String getCfassessideatow() {
		if (cfassessideatow == null) {
			cfassessideatow = "";
		}
		return cfassessideatow;
	}
	/**
	 * @param cfassessideatow the cfassessideatow to set
	 */
	public void setCfassessideatow(String cfassessideatow) {
		this.cfassessideatow = cfassessideatow;
	}
	/**
	 * @return the cfnotpionttypeId
	 */
	public String getCfnotpionttypeId() {
		if (cfnotpionttypeId == null) {
			cfnotpionttypeId = "";
		}
		return cfnotpionttypeId;
	}
	/**
	 * @param cfnotpionttypeId the cfnotpionttypeId to set
	 */
	public void setCfnotpionttypeId(String cfnotpionttypeId) {
		this.cfnotpionttypeId = cfnotpionttypeId;
	}
	/**
	 * @return the fprojectNumberId
	 */
	public String getFprojectNumberId() {
		if (fprojectNumberId == null) {
			fprojectNumberId = "";
		}
		return fprojectNumberId;
	}
	/**
	 * @param fprojectNumberId the fprojectNumberId to set
	 */
	public void setFprojectNumberId(String fprojectNumberId) {
		this.fprojectNumberId = fprojectNumberId;
	}
	/**
	 * @return the fprojectName
	 */
	public String getFprojectName() {
		if (fprojectName == null) {
			fprojectName = "";
		}
		return fprojectName;
	}
	/**
	 * @param fprojectName the fprojectName to set
	 */
	public void setFprojectName(String fprojectName) {
		this.fprojectName = fprojectName;
	}
	/**
	 * @return the fdivisionId
	 */
	public String getFdivisionId() {
		if (fdivisionId == null) {
			fdivisionId = "";
		}
		return fdivisionId;
	}
	/**
	 * @param fdivisionId the fdivisionId to set
	 */
	public void setFdivisionId(String fdivisionId) {
		this.fdivisionId = fdivisionId;
	}
	/**
	 * @return the fstate
	 */
	public String getFstate() {
		if (fstate == null) {
			fstate = "";
		}
		return fstate;
	}
	/**
	 * @param fstate the fstate to set
	 */
	public void setFstate(String fstate) {
		this.fstate = fstate;
	}
	/**
	 * @return the fcreateorgId
	 */
	public String getFcreateorgId() {
		if (fcreateorgId == null) {
			fcreateorgId = "";
		}
		return fcreateorgId;
	}
	/**
	 * @param fcreateorgId the fcreateorgId to set
	 */
	public void setFcreateorgId(String fcreateorgId) {
		this.fcreateorgId = fcreateorgId;
	}
	/**
	 * @return the fconstructionYype
	 */
	public String getFconstructionType() {
		if (fconstructionType == null) {
			fconstructionType = "";
		}
		return fconstructionType;
	}
	/**
	 * @param fconstructionYype the fconstructionYype to set
	 */
	public void setFconstructionType(String fconstructionType) {
		this.fconstructionType = fconstructionType;
	}
	
	
	
}
