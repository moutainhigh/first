package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;
public class ProjectStatusEntity extends BaseEntity {
	
	private static final long serialVersionUID = 8272147177301794489L;
	private String fid;							//主键
	private String fcreatorId;					//创建者ID
	private Date fcreateTime;					//创建时间
	private String flastUpdateUserId;			//最后修改者ID
	private Date flastUpdateTime;				//最后修改时间
	private String fcontrolUnitId;				//控制单元ID(所属子公司)
	private String fnumber;						//单据编号
	private Date fbizDate;						//业务日期
	private String fhandlerId;					//经手人ID
	private String fdescription;				//参考信息
	private Long fhasEffected;					//是否曾经生效
	private String fauditorId;					//审核人ID
	private String fsourceBillId;				//原始单据ID
	private String fsourceFunction;				//来源功能
	private Long ffivouchered;					//是否生成凭证
	private String cfprojectNumberId;			//项目编号ID
	private String cfpetitionState;				//申请状态
	private String cfpetitionCause;				//申请原因
	private String cfpauseCause;				//暂停原因
	private Date cfpetitionDate;				//申请时间
	private String cfpetitionOrgId;				//申请部门ID
	private String cfstate;						//单据状态
	private String cfmeetingTheme;				//会议主题
	private Date cfjudgeDate;					//会审时间
	private String cfjudgereSolve;				//会审决议
	private String fprojectName;				//项目名称
	private String fjudgepersonId;				//会审人员ID
	private String fapplypersonId;				//申请人ID
	private String fprojectState;				//项目状态  --0筹备1立项2运行3暂停4重启5停止6验收7关闭8部分暂停9部分重启10部分停止
	private String fjudgepersonnal;				//会审人员ID
	private String fprojectType;				//项目类型  --1、网点,2、非网点 
	private String fcreatorIdAsName;			//创建者名称
	private String flastUpdateUserIdAsName;		//最后修改者名称
	private String fcontrolUnitIdAsName;		//控制单元名称
	private String fhandlerIdAsName;			//经手人名称
	private String fauditorIdAsName;			//审核人名称
	private String fsourceBillIdAsName;			//原始单据名称
	private String cfprojectNumberIdAsName;		//项目编号名称
	private String cfpetitionOrgIdAsName;		//申请部门名称
	private String fjudgepersonIdAsName;		//会审人员名称
	private String fapplypersonIdAsName;		//申请人名称
	private String dtetimestyle;			    //指定格式的时间1
	private String dtetimestyleDate;		    //指定格式的时间2
	private String cfstartDeptId;				//项目发起部门id
	private String cfstartDeptIdAsName;			//项目发起部门名称
	private String fjudgeContainer;				//会审容器
	private String fjudgeContainerAsName;        //会审人员
	/**
	 * 
	 * @Description : 执行操作getFcreatorId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFcreatorId() {
		return fcreatorId;
	}
	/**
	 * 
	 * @Description : 执行操作getFcreatorId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFcreatorId(String fcreatorId) {
		this.fcreatorId = fcreatorId;
	}
	/**
	 * 
	 * @Description : 执行操作getFcreateTime
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Date getFcreateTime() {
		return fcreateTime;
	}
	/**
	 * 
	 * @Description : 执行操作setFcreateTime
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	/**
	 * 
	 * @Description : 执行操作getFlastUpdateUserId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFlastUpdateUserId() {
		return flastUpdateUserId;
	}
	/**
	 * 
	 * @Description : 执行操作setFlastUpdateUserId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFlastUpdateUserId(String flastUpdateUserId) {
		this.flastUpdateUserId = flastUpdateUserId;
	}
	public Date getFlastUpdateTime() {
		return flastUpdateTime;
	}
	/**
	 * 
	 * @Description : 执行操作setFlastUpdateTime
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFlastUpdateTime(Date flastUpdateTime) {
		this.flastUpdateTime = flastUpdateTime;
	}
	/**
	 * 
	 * @Description : 执行操作getFcontrolUnitId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFcontrolUnitId() {
		return fcontrolUnitId;
	}
	/**
	 * 
	 * @Description : 执行操作setFcontrolUnitId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFcontrolUnitId(String fcontrolUnitId) {
		this.fcontrolUnitId = fcontrolUnitId;
	}
	/**
	 * 
	 * @Description : 执行操作getFnumber
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFnumber() {
		if (fnumber == null) {
			fnumber = "";
		}
		return fnumber;
	}
	/**
	 * 
	 * @Description : 执行操作setFnumber
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	/**
	 * 
	 * @Description : 执行操作getFbizDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Date getFbizDate() {
		return fbizDate;
	}
	/**
	 * 
	 * @Description : 执行操作setFbizDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFbizDate(Date fbizDate) {
		this.fbizDate = fbizDate;
	}
	/**
	 * 
	 * @Description : 执行操作getFhandlerId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFhandlerId() {
		return fhandlerId;
	}
	/**
	 * 
	 * @Description : 执行操作setFhandlerId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFhandlerId(String fhandlerId) {
		this.fhandlerId = fhandlerId;
	}
	/**
	 * 
	 * @Description : 执行操作getFdescription
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFdescription() {
		return fdescription;
	}
	/**
	 * 
	 * @Description : 执行操作setFdescription
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}
	/**
	 * 
	 * @Description : 执行操作getFhasEffected
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Long getFhasEffected() {
		return fhasEffected;
	}
	/**
	 * 
	 * @Description : 执行操作setFhasEffected
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFhasEffected(Long fhasEffected) {
		this.fhasEffected = fhasEffected;
	}
	/**
	 * 
	 * @Description : 执行操作getFauditorId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFauditorId() {
		return fauditorId;
	}
	/**
	 * 
	 * @Description : 执行操作setFauditorId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFauditorId(String fauditorId) {
		this.fauditorId = fauditorId;
	}
	/**
	 * 
	 * @Description : 执行操作getFsourceBillId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFsourceBillId() {
		return fsourceBillId;
	}
	/**
	 * 
	 * @Description : 执行操作setFsourceBillId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFsourceBillId(String fsourceBillId) {
		this.fsourceBillId = fsourceBillId;
	}
	/**
	 * 
	 * @Description : 执行操作getFsourceFunction
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFsourceFunction() {
		return fsourceFunction;
	}
	/**
	 * 
	 * @Description : 执行操作setFsourceFunction
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFsourceFunction(String fsourceFunction) {
		this.fsourceFunction = fsourceFunction;
	}
	/**
	 * 
	 * @Description : 执行操作getFid
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * @Description : 执行操作setFid
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * @Description : 执行操作getFfivouchered
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Long getFfivouchered() {
		return ffivouchered;
	}
	/**
	 * 
	 * @Description : 执行操作setFfivouchered
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFfivouchered(Long ffivouchered) {
		this.ffivouchered = ffivouchered;
	}
	/**
	 * 
	 * @Description : 执行操作getCfprojectNumberId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfprojectNumberId() {
		if (cfprojectNumberId == null) {
			cfprojectNumberId = "";
		}
		return cfprojectNumberId;
	}
	/**
	 * 
	 * @Description : 执行操作setCfprojectNumberId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfprojectNumberId(String cfprojectNumberId) {
		this.cfprojectNumberId = cfprojectNumberId;
	}
	/**
	 * 
	 * @Description : 执行操作getCfpetitionState
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfpetitionState() {
		if (cfpetitionState == null) {
			cfpetitionState = "";
		}
		return cfpetitionState;
	}
	/**
	 * 
	 * @Description : 执行操作setCfpetitionState
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfpetitionState(String cfpetitionState) {
		this.cfpetitionState = cfpetitionState;
	}
	/**
	 * 
	 * @Description : 执行操作getCfpetitionCause
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfpetitionCause() {
		if (cfpetitionCause == null) {
			cfpetitionCause = "";
		}
		return cfpetitionCause;
	}
	/**
	 * 
	 * @Description : 执行操作setCfpetitionCause
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfpetitionCause(String cfpetitionCause) {
		this.cfpetitionCause = cfpetitionCause;
	}
	/**
	 * 
	 * @Description : 执行操作getCfpauseCause
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfpauseCause() {
		if (cfpauseCause == null) {
			cfpauseCause = "";
		}
		return cfpauseCause;
	}
	/**
	 * 
	 * @Description : 执行操作setCfpauseCause
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfpauseCause(String cfpauseCause) {
		this.cfpauseCause = cfpauseCause;
	}
	/**
	 * 
	 * @Description : 执行操作getCfpetitionDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Date getCfpetitionDate() {
		return cfpetitionDate;
	}
	
	public String getCfpetitionDateStr() {
		return FormatUtil.formatDate(cfpetitionDate,"yyyy-MM-dd");
	}
	/**
	 * 
	 * @Description : 执行操作setCfpetitionDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfpetitionDate(Date cfpetitionDate) {
		this.cfpetitionDate = cfpetitionDate;
	}
	/**
	 * 
	 * @Description : 执行操作getCfpetitionOrgId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfpetitionOrgId() {
		return cfpetitionOrgId;
	}
	/**
	 * 
	 * @Description : 执行操作setCfpetitionOrgId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfpetitionOrgId(String cfpetitionOrgId) {
		this.cfpetitionOrgId = cfpetitionOrgId;
	}
	/**
	 * 
	 * @Description : 执行操作getCfstate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfstate() {
		return cfstate;
	}
	/**
	 * 
	 * @Description : 执行操作setCfstate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfstate(String cfstate) {
		this.cfstate = cfstate;
	}
	/**
	 * 
	 * @Description : 执行操作getCfmeetingTheme
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfmeetingTheme() {
		if (cfmeetingTheme == null) {
			cfmeetingTheme = "";
		}
		return cfmeetingTheme;
	}
	/**
	 * 
	 * @Description : 执行操作setCfmeetingTheme
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfmeetingTheme(String cfmeetingTheme) {
		this.cfmeetingTheme = cfmeetingTheme;
	}
	/**
	 * 
	 * @Description : 执行操作getCfjudgeDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public Date getCfjudgeDate() {
		return cfjudgeDate;
	}
	
	public String getCfjudgeDateStr() {
		return FormatUtil.formatDate(cfjudgeDate,"yyyy-MM-dd");
	}
	/**
	 * 
	 * @Description : 执行操作setCfjudgeDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfjudgeDate(Date cfjudgeDate) {
		this.cfjudgeDate = cfjudgeDate;
	}
	/**
	 * 
	 * @Description : 执行操作getCfjudgereSolve
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfjudgereSolve() {
		if (cfjudgereSolve == null) {
			cfjudgereSolve = "";
		}
		return cfjudgereSolve;
	}
	/**
	 * 
	 * @Description : 执行操作setCfjudgereSolve
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfjudgereSolve(String cfjudgereSolve) {
		this.cfjudgereSolve = cfjudgereSolve;
	}
	/**
	 * 
	 * @Description : 执行操作getFprojectName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFprojectName() {
		if (fprojectName == null) {
			fprojectName = "";
		}
		return fprojectName;
	}
	/**
	 * 
	 * @Description : 执行操作setFprojectName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFprojectName(String fprojectName) {
		this.fprojectName = fprojectName;
	}
	/**
	 * 
	 * @Description : 执行操作getFjudgepersonId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFjudgepersonId() {
		return fjudgepersonId;
	}
	/**
	 * 
	 * @Description : 执行操作setFjudgepersonId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFjudgepersonId(String fjudgepersonId) {
		this.fjudgepersonId = fjudgepersonId;
	}
	/**
	 * 
	 * @Description : 执行操作getFapplypersonId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFapplypersonId() {
		return fapplypersonId;
	}
	/**
	 * 
	 * @Description : 执行操作setFapplypersonId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFapplypersonId(String fapplypersonId) {
		this.fapplypersonId = fapplypersonId;
	}
	/**
	 * 
	 * @Description : 执行操作getFprojectState
	 * @author jianweiqiang  项目状态  --0筹备1立项2运行3暂停4重启5停止6验收7关闭8部分暂停9部分重启10部分停止
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFprojectState() {
		if ("0".equals(fprojectState)) {
			fprojectState = "筹备";
		}else if ("1".equals(fprojectState)) {
			fprojectState = "立项";
		}else if ("2".equals(fprojectState)) {
			fprojectState = "运行";
		}else if ("3".equals(fprojectState)) {
			fprojectState = "暂停";
		}else if ("4".equals(fprojectState)) {
			fprojectState = "重启";
		}else if ("5".equals(fprojectState)) {
			fprojectState = "停止";
		}else if ("6".equals(fprojectState)) {
			fprojectState = "验收";
		}else if ("7".equals(fprojectState)) {
			fprojectState = "关闭";
		}else if ("8".equals(fprojectState)) {
			fprojectState = "部分暂停";
		}else if ("9".equals(fprojectState)) {
			fprojectState = "部分重启";
		}else if ("10".equals(fprojectState)) {
			fprojectState = "部分停止";
		}else {
			//fprojectState == null
			fprojectState = "";
		}
		return fprojectState;
	}
	/**
	 * 
	 * @Description : 执行操作setFprojectState
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFprojectState(String fprojectState) {
		this.fprojectState = fprojectState;
	}
	/**
	 * 
	 * @Description : 执行操作getFjudgepersonnal
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFjudgepersonnal() {
		return fjudgepersonnal;
	}
	/**
	 * 
	 * @Description : 执行操作setFjudgepersonnal
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFjudgepersonnal(String fjudgepersonnal) {
		this.fjudgepersonnal = fjudgepersonnal;
	}
	/**
	 * 
	 * @Description : 执行操作getFprojectType
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFprojectType() {
		return fprojectType;
	}
	/**
	 * 
	 * @Description : 执行操作setFprojectType
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFprojectType(String fprojectType) {
		this.fprojectType = fprojectType;
	}
	/**
	 * 
	 * @Description : 执行操作getFcreatorId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFcreatorIdAsName() {
		return fcreatorIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFcreatorIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFcreatorIdAsName(String fcreatorIdAsName) {
		this.fcreatorIdAsName = fcreatorIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFlastUpdateUserIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFlastUpdateUserIdAsName() {
		return flastUpdateUserIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFlastUpdateUserIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFlastUpdateUserIdAsName(String flastUpdateUserIdAsName) {
		this.flastUpdateUserIdAsName = flastUpdateUserIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFcontrolUnitIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFcontrolUnitIdAsName() {
		return fcontrolUnitIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFcontrolUnitIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFcontrolUnitIdAsName(String fcontrolUnitIdAsName) {
		this.fcontrolUnitIdAsName = fcontrolUnitIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFhandlerIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFhandlerIdAsName() {
		return fhandlerIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFhandlerIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:45:03
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFhandlerIdAsName(String fhandlerIdAsName) {
		this.fhandlerIdAsName = fhandlerIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFauditorIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:25
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFauditorIdAsName() {
		return fauditorIdAsName;
	}
	public void setFauditorIdAsName(String fauditorIdAsName) {
		this.fauditorIdAsName = fauditorIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFsourceBillIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFsourceBillIdAsName() {
		if (fsourceBillIdAsName == null) {
			fsourceBillIdAsName = "";
		}
		return fsourceBillIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFsourceBillIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFsourceBillIdAsName(String fsourceBillIdAsName) {
		this.fsourceBillIdAsName = fsourceBillIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getCfprojectNumberIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfprojectNumberIdAsName() {
		if (cfprojectNumberIdAsName == null) {
			cfprojectNumberIdAsName = "";
		}
		return cfprojectNumberIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setCfprojectNumberIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfprojectNumberIdAsName(String cfprojectNumberIdAsName) {
		this.cfprojectNumberIdAsName = cfprojectNumberIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getCfpetitionOrgIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfpetitionOrgIdAsName() {
		if (cfpetitionOrgIdAsName == null) {
			cfpetitionOrgIdAsName = "";
		}
		return cfpetitionOrgIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setCfpetitionOrgIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfpetitionOrgIdAsName(String cfpetitionOrgIdAsName) {
		this.cfpetitionOrgIdAsName = cfpetitionOrgIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFjudgepersonIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFjudgepersonIdAsName() {
		if (fjudgepersonIdAsName == null) {
			fjudgepersonIdAsName = "";
		}
		return fjudgepersonIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFjudgepersonIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFjudgepersonIdAsName(String fjudgepersonIdAsName) {
		this.fjudgepersonIdAsName = fjudgepersonIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFapplypersonIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFapplypersonIdAsName() {
		if (fapplypersonIdAsName == null) {
			fapplypersonIdAsName = "";
		}
		return fapplypersonIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFapplypersonIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFapplypersonIdAsName(String fapplypersonIdAsName) {
		this.fapplypersonIdAsName = fapplypersonIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getDtetimestyle
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getDtetimestyle() {
		return dtetimestyle;
	}
	/**
	 * 
	 * @Description : 执行操作setDtetimestyle
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setDtetimestyle(String dtetimestyle) {
		this.dtetimestyle = dtetimestyle;
	}
	/**
	 * 
	 * @Description : 执行操作getCfstartDeptId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfstartDeptId() {
		return cfstartDeptId;
	}
	/**
	 * 
	 * @Description : 执行操作setCfstartDeptId
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfstartDeptId(String cfstartDeptId) {
		this.cfstartDeptId = cfstartDeptId;
	}
	/**
	 * 
	 * @Description : 执行操作getCfstartDeptIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getCfstartDeptIdAsName() {
		if (cfstartDeptIdAsName == null) {
			cfstartDeptIdAsName = "";
		}
		return cfstartDeptIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setCfstartDeptIdAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setCfstartDeptIdAsName(String cfstartDeptIdAsName) {
		this.cfstartDeptIdAsName = cfstartDeptIdAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getFjudgeContainer
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFjudgeContainer() {
		return fjudgeContainer;
	}
	/**
	 * 
	 * @Description : 执行操作setFjudgeContainer
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFjudgeContainer(String fjudgeContainer) {
		this.fjudgeContainer = fjudgeContainer;
	}
	/**
	 * 
	 * @Description : 执行操作getFjudgeContainerAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getFjudgeContainerAsName() {
		if (fjudgeContainerAsName == null) {
			fjudgeContainerAsName = "";
		}
		return fjudgeContainerAsName;
	}
	/**
	 * 
	 * @Description : 执行操作setFjudgeContainerAsName
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setFjudgeContainerAsName(String fjudgeContainerAsName) {
		this.fjudgeContainerAsName = fjudgeContainerAsName;
	}
	/**
	 * 
	 * @Description : 执行操作getDtetimestyleDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public String getDtetimestyleDate() {
		return dtetimestyleDate;
	}
	/**
	 * 
	 * @Description : 执行操作setDtetimestyleDate
	 * @author jianweiqiang
	 * @date 2014-2-20 上午9:52:39
	 * @return
	 * @see
	 * @version V 0.1
	 */
	public void setDtetimestyleDate(String dtetimestyleDate) {
		this.dtetimestyleDate = dtetimestyleDate;
	}
	/**
	 * 
	 * @Description:覆盖toString方法
	 * @author jianweiqiang
	 * @date 2014-1-15 上午9:51:32
	 * @return 
	 * @see java.lang.Object#toString()
	 * @version V1.0
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}

