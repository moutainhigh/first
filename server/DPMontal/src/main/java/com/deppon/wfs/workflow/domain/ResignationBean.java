package com.deppon.wfs.workflow.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title: Resignation 
 * @description：辞职申请bean
 * @author： wuyaqing
 * @date： 2013-9-3 上午09:13:26
 */
/**
 * 流程定义 com.deppon.bpms.module.wfs.bpsdesign.personnel.resignation
 * */
public class ResignationBean extends Entity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -508332092625592458L;

	//主键ID
    private String busino;
	//流程实例ID
	private Long processinstid;
	//辞职申请人姓名
	private String applyPersonName;
	//辞职申请人工号
	private String applyPersonId;
	//申请人职位
	private String position;
	//申请人所属部门
	private String appDept;
	//申请人所属部门标杆编码
	private String appFinasyscode;
	//辞职人员所在人事部编码
	private String personnelDeptCode;
	//辞职类型（1-辞职 2-自离）
	private String resignType;
	//辞职人直接上级级别
	private String superiorDegree;
	//入职日期
	private Date joinDate;
	//辞职人员近六个月ABC
	private String abc;
	//辞职人现任岗位类型 1-职能 2-营运
	private String postsort;
	//辞职人是否参加储干
	private String isReserve;
	//第几届储干
	private String reserveDate;
	//储干名次
	private String reserveNo;
	//辞职人员是否评优
	private String isGood;
	//是否是管理岗位（1是，0否）
	private String isManager;
	//辞职人员工作年限
	private String workYears;
	//差错编号
	private String errorNo;
	//辞职主要原因
	private String resignReason;
	//申请事由
	private String applyReason;
	//联系电话
	private String telephone;
	//工资结算方式
	private String wageSettlement;
	//业务类型
	private String businessProce;
	//离职业务类型
	private String leaveBusinessProce;
	//计划离职日期
	private Date leaveDate;
	//银行卡号
	private String cardNo;
	//开户行名称
	private String cardBankname;
	//开户人姓名
	private String cardHolder;
	//开户行省份
	private String cardProvince;
	//开户行城市
	private String cardCity;
	//创建时间
	private Date createTime;
	//修改时间
	private Date modifyTime;
	//业务状态，是否有效（1-有效 0-无效）
	private String isEffective;
	//备注1
	private Long reserve1;
	//备注2
	private String reserve2;
	//备注3
	private String reserve3;
	
	
	/**
	 * vo字段
	 */
	//辞职类型名字
	private String resignTypeName;
	//直属上级级别
	private String superiorDegreeName;
	//所在人事部
	private String personnelDeptName;
	//岗位类型名字
	private String postsortName;
	//是否管理岗位
	private String isManagerName;
	
	public ResignationBean(){}
	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @return the processinstid
	 */
	public Long getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}
	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the appDept
	 */
	public String getAppDept() {
		return appDept;
	}
	/**
	 * @param appDept the appDept to set
	 */
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
	/**
	 * @return the appFinasyscode
	 */
	public String getAppFinasyscode() {
		return appFinasyscode;
	}
	/**
	 * @param appFinasyscode the appFinasyscode to set
	 */
	public void setAppFinasyscode(String appFinasyscode) {
		this.appFinasyscode = appFinasyscode;
	}
	/**
	 * @return the personnelDeptCode
	 */
	public String getPersonnelDeptCode() {
		return personnelDeptCode;
	}
	/**
	 * @param personnelDeptCode the personnelDeptCode to set
	 */
	public void setPersonnelDeptCode(String personnelDeptCode) {
		this.personnelDeptCode = personnelDeptCode;
		this.personnelDeptName = this.personnelDeptCode;
	}
	/**
	 * @return the resignType
	 */
	public String getResignType() {
		return resignType;
	}
	/**
	 * @param resignType the resignType to set
	 */
	public void setResignType(String resignType) {
		this.resignType = resignType;
		this.resignTypeName = this.resignType;
	}
	/**
	 * @return the superiorDegree
	 */
	public String getSuperiorDegree() {
		return superiorDegree;
	}
	/**
	 * @param superiorDegree the superiorDegree to set
	 */
	public void setSuperiorDegree(String superiorDegree) {
		this.superiorDegree = superiorDegree;
		this.superiorDegreeName = this.superiorDegree;
	}
	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}
	
	public String getJoinDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getJoinDate());
	}
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * @return the abc
	 */
	public String getAbc() {
		return abc;
	}
	/**
	 * @param abc the abc to set
	 */
	public void setAbc(String abc) {
		this.abc = abc;
	}
	/**
	 * @return the postsort
	 */
	public String getPostsort() {
		return postsort;
	}
	/**
	 * @param postsort the postsort to set
	 */
	public void setPostsort(String postsort) {
		this.postsort = postsort;
		this.postsortName = this.postsort;
	}
	/**
	 * @return the isReserve
	 */
	public String getIsReserve() {
		return isReserve;
	}
	/**
	 * @param isReserve the isReserve to set
	 */
	public void setIsReserve(String isReserve) {
		this.isReserve = isReserve;
	}
	/**
	 * @return the reserveDate
	 */
	public String getReserveDate() {
		return reserveDate;
	}
	/**
	 * @param reserveDate the reserveDate to set
	 */
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	/**
	 * @return the reserveNo
	 */
	public String getReserveNo() {
		return reserveNo;
	}
	/**
	 * @param reserveNo the reserveNo to set
	 */
	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}
	/**
	 * @return the isGood
	 */
	public String getIsGood() {
		return isGood;
	}
	/**
	 * @param isGood the isGood to set
	 */
	public void setIsGood(String isGood) {
		this.isGood = isGood;
	}
	/**
	 * @return the isManager
	 */
	public String getIsManager() {
		return isManager;
	}
	/**
	 * @param isManager the isManager to set
	 */
	public void setIsManager(String isManager) {
		this.isManager = isManager;
		this.isManagerName = this.isManager;
	}
	/**
	 * @return the workYears
	 */
	public String getWorkYears() {
		return workYears;
	}
	/**
	 * @param workYears the workYears to set
	 */
	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}
	/**
	 * @return the errorNo
	 */
	public String getErrorNo() {
		return errorNo;
	}
	/**
	 * @param errorNo the errorNo to set
	 */
	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}
	/**
	 * @return the resignReason
	 */
	public String getResignReason() {
		return resignReason;
	}
	/**
	 * @param resignReason the resignReason to set
	 */
	public void setResignReason(String resignReason) {
		this.resignReason = resignReason;
	}
	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		return applyReason;
	}
	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the wageSettlement
	 */
	public String getWageSettlement() {
		return wageSettlement;
	}
	/**
	 * @param wageSettlement the wageSettlement to set
	 */
	public void setWageSettlement(String wageSettlement) {
		this.wageSettlement = wageSettlement;
	}
	/**
	 * @return the businessProce
	 */
	public String getBusinessProce() {
		return businessProce;
	}
	/**
	 * @param businessProce the businessProce to set
	 */
	public void setBusinessProce(String businessProce) {
		this.businessProce = businessProce;
	}
	/**
	 * @return the leaveBusinessProce
	 */
	public String getLeaveBusinessProce() {
		return leaveBusinessProce;
	}
	/**
	 * @param leaveBusinessProce the leaveBusinessProce to set
	 */
	public void setLeaveBusinessProce(String leaveBusinessProce) {
		this.leaveBusinessProce = leaveBusinessProce;
	}
	/**
	 * @return the leaveDate
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}
	/**
	 * @param leaveDate the leaveDate to set
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the cardBankname
	 */
	public String getCardBankname() {
		return cardBankname;
	}
	/**
	 * @param cardBankname the cardBankname to set
	 */
	public void setCardBankname(String cardBankname) {
		this.cardBankname = cardBankname;
	}
	/**
	 * @return the cardHolder
	 */
	public String getCardHolder() {
		return cardHolder;
	}
	/**
	 * @param cardHolder the cardHolder to set
	 */
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	/**
	 * @return the cardProvince
	 */
	public String getCardProvince() {
		return cardProvince;
	}
	/**
	 * @param cardProvince the cardProvince to set
	 */
	public void setCardProvince(String cardProvince) {
		this.cardProvince = cardProvince;
	}
	/**
	 * @return the cardCity
	 */
	public String getCardCity() {
		return cardCity;
	}
	/**
	 * @param cardCity the cardCity to set
	 */
	public void setCardCity(String cardCity) {
		this.cardCity = cardCity;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the isEffective
	 */
	public String getIsEffective() {
		return isEffective;
	}
	/**
	 * @param isEffective the isEffective to set
	 */
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	/**
	 * @return the reserve1
	 */
	public Long getReserve1() {
		return reserve1;
	}
	/**
	 * @param reserve1 the reserve1 to set
	 */
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}
	/**
	 * @return the reserve2
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * @param reserve2 the reserve2 to set
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	/**
	 * @return the reserve3
	 */
	public String getReserve3() {
		return reserve3;
	}
	/**
	 * @param reserve3 the reserve3 to set
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	/**
	 * 
	* @MethodName: getResignTypeName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午09:20:10
	* @return String
	 */
	public String getResignTypeName() {
		return resignTypeName;
	}
	/**
	 * 
	* @MethodName: setResignTypeName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午09:20:05
	* @param resignTypeName void
	 */
	public void setResignTypeName(String resignTypeName) {
		this.resignTypeName = resignTypeName;
	}
	/**
	 * 
	* @MethodName: getSuperiorDegreeName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午09:20:01
	* @return String
	 */
	public String getSuperiorDegreeName() {
		return superiorDegreeName;
	}
	/**
	 * 
	* @MethodName: setSuperiorDegreeName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午09:19:58
	* @param superiorDegreeName void
	 */
	public void setSuperiorDegreeName(String superiorDegreeName) {
		this.superiorDegreeName = superiorDegreeName;
	}
	/**
	 * 
	* @MethodName: getPersonnelDeptName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午09:19:54
	* @return String
	 */
	public String getPersonnelDeptName() {
		return personnelDeptName;
	}
	/**
	 * 
	* @MethodName: setPersonnelDeptName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午09:19:49
	* @param personnelDeptName void
	 */
	public void setPersonnelDeptName(String personnelDeptName) {
		this.personnelDeptName = personnelDeptName;
	}
	/**
	 * 
	* @MethodName: getPostsortName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午10:01:03
	* @return String
	 */
	public String getPostsortName() {
		return postsortName;
	}
	/**
	 * 
	* @MethodName: setPostsortName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午10:01:07
	* @param postsortName void
	 */
	public void setPostsortName(String postsortName) {
		this.postsortName = postsortName;
	}
	/**
	 * 
	* @MethodName: getIsManagerName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午10:22:08
	* @return String
	 */
	public String getIsManagerName() {
		return isManagerName;
	}
	/**
	 * 
	* @MethodName: setIsManagerName 
	* @description : TODO
	* @author：liming
	* @date： 2013-11-30 上午10:22:12
	* @param isManagerName void
	 */
	public void setIsManagerName(String isManagerName) {
		this.isManagerName = isManagerName;
	}
	
	
}
