package com.deppon.wfs.workflow.domain;

import java.util.Date;
/**
* @title: OnlineBean 
* @description：TODO 开线申请业务表数据实体
* @author： caibingbing
* @date： 2013-9-4 下午06:00:17
 */
public class OnlineBean {
	/**
	 * 业务编码，主键
	 */
	private String busino;
	/**
	 * 申请人名称
	 */
	private String applyPersonName;
	/**
	 * 申请人工号
	 */
	private String applyPersonId;
	/**
	 * 申请人部门
	 */
	private String applyDept;
	/**
	 * 出发外场
	 */
	private String outField;
	/**
	 * 出发外场部门编码
	 */
	private String outFieldCode;
	/**
	 *出发外场所在区域 
	 */
	private String outFieldAre;
	/**
	 * 到达外场
	 */
	private String inField;
	/**
	 * 到达外场部门编码
	 */
	private String inFieldCode;
	/**
	 * 到达外场所在区域
	 */
	private String inFieldAre;
	/**
	 * 车辆类型
	 */
	private String carType;
	/**
	 * 车辆型号
	 */
	private String carModel;
	/**
	 * 线路类型
	 */
	private String lineType;
	/**
	 * 计划开线时间
	 */
	private Date planOnlineTime;
	/**
	 * 车辆需求
	 */
	private String carNeed;
	/**
	 * 公里数
	 */
	private String killMeter;
	/**
	 * 申请事由
	 */
	private String reason;
	/**
	 * 是否有效
	 */
	private String isSeffective;
	/**
	 * 工作流号
	 */
	private Long processinstid;
	/**
	 *预期车辆数 
	 */
	private Integer carNum;
	/**
	 * 预期货柜数
	 */
	private Integer containerNumNeed;
	/**
	 * 实际车头数              
	 */
	private Integer carHeadNum;
	/**
	 * 实际货柜数
	 */
	private Integer containerNumActual;
	/**
	 * 所属车队               
	 */
	private String carGroup;
	/**
	 * 所属车队部门编码
	 */
	private String carGroupCode;
	/**
	 * 出发时间
	 */
	private String outTime;
	/**
	 * 到达时间
	 */
	private String inTime;
	/**
	 * 起草时间
	 */
	private Date draftDate;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 返程到达时间
	 */
	private String backInTime;
	/**
	 * 返程出发时间
	 */
	private String backOutTime;
	/**
	 * 
	* @MethodName: getBusino 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:17
	* @return String
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * 
	* @MethodName: setBusino 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:21
	* @param busino void
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * 
	* @MethodName: getApplyPersonName 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:27:48
	* @return String
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}
	/**
	 * 
	* @MethodName: setApplyPersonName 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:27:51
	* @param applyPersonName void
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	 * 
	* @MethodName: getApplyPersonId 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:27:56
	* @return String
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	 * 
	* @MethodName: setApplyPersonId 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-27 下午3:27:59
	* @param applyPersonId void
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	 * 
	* @MethodName: getApplyDept 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:39
	* @return String
	 */
	public String getApplyDept() {
		return applyDept;
	}
	/**
	 * 
	* @MethodName: setApplyDept 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:43
	* @param applyDept void
	 */
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	/**
	 * 
	* @MethodName: getOutField 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:46
	* @return String
	 */
	public String getOutField() {
		return outField;
	}
	/**
	 * 
	* @MethodName: setOutField 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:50
	* @param outField void
	 */
	public void setOutField(String outField) {
		this.outField = outField;
	}
	/**
	 * 
	* @MethodName: getOutFieldCode 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:53
	* @return String
	 */
	public String getOutFieldCode() {
		return outFieldCode;
	}
	/**
	 * 
	* @MethodName: setOutFieldCode 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:23:57
	* @param outFieldCode void
	 */
	public void setOutFieldCode(String outFieldCode) {
		this.outFieldCode = outFieldCode;
	}
	/**
	 * 
	* @MethodName: getOutFieldAre 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:00
	* @return String
	 */
	public String getOutFieldAre() {
		return outFieldAre;
	}
	/**
	 * 
	* @MethodName: setOutFieldAre 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:04
	* @param outFieldAre void
	 */
	public void setOutFieldAre(String outFieldAre) {
		this.outFieldAre = outFieldAre;
	}
	/**
	 * 
	* @MethodName: getInField 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:08
	* @return String
	 */
	public String getInField() {
		return inField;
	}
	/**
	 * 
	* @MethodName: setInField 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:12
	* @param inField void
	 */
	public void setInField(String inField) {
		this.inField = inField;
	}
	/**
	 * 
	* @MethodName: getInFieldCode 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:16
	* @return String
	 */
	public String getInFieldCode() {
		return inFieldCode;
	}
	/**
	 * 
	* @MethodName: setInFieldCode 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:21
	* @param inFieldCode void
	 */
	public void setInFieldCode(String inFieldCode) {
		this.inFieldCode = inFieldCode;
	}
	/**
	 * 
	* @MethodName: getInFieldAre 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:25
	* @return String
	 */
	public String getInFieldAre() {
		return inFieldAre;
	}
	/**
	 * 
	* @MethodName: setInFieldAre 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:30
	* @param inFieldAre void
	 */
	public void setInFieldAre(String inFieldAre) {
		this.inFieldAre = inFieldAre;
	}
	/**
	 * 
	* @MethodName: getCarType 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:33
	* @return String
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * 
	* @MethodName: setCarType 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:37
	* @param carType void
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * 
	* @MethodName: getCarModel 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:41
	* @return String
	 */
	public String getCarModel() {
		return carModel;
	}
	/**
	 * 
	* @MethodName: setCarModel 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:44
	* @param carModel void
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	/**
	 * 
	* @MethodName: getLineType 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:48
	* @return String
	 */
	public String getLineType() {
		return lineType;
	}
	/**
	 * 
	* @MethodName: setLineType 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:54
	* @param lineType void
	 */
	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
	/**
	 * 
	* @MethodName: getPlanOnlineTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:24:57
	* @return Date
	 */
	public Date getPlanOnlineTime() {
		return planOnlineTime;
	}
	/**
	 * 
	* @MethodName: setPlanOnlineTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:01
	* @param planOnlineTime void
	 */
	public void setPlanOnlineTime(Date planOnlineTime) {
		this.planOnlineTime = planOnlineTime;
	}
	/**
	 * 
	* @MethodName: getCarNeed 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:05
	* @return String
	 */
	public String getCarNeed() {
		return carNeed;
	}
	/**
	 * 
	* @MethodName: setCarNeed 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:09
	* @param carNeed void
	 */
	public void setCarNeed(String carNeed) {
		this.carNeed = carNeed;
	}
	/**
	 * 
	* @MethodName: getKillMeter 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:12
	* @return String
	 */
	public String getKillMeter() {
		return killMeter;
	}
	/**
	 * 
	* @MethodName: setKillMeter 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:17
	* @param killMeter void
	 */
	public void setKillMeter(String killMeter) {
		this.killMeter = killMeter;
	}
	/**
	 * 
	* @MethodName: getReason 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:21
	* @return String
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 
	* @MethodName: setReason 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:29
	* @param reason void
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 
	* @MethodName: getIsSeffective 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:34
	* @return String
	 */
	public String getIsSeffective() {
		return isSeffective;
	}
	/**
	 * 
	* @MethodName: setIsSeffective 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:37
	* @param isSeffective void
	 */
	public void setIsSeffective(String isSeffective) {
		this.isSeffective = isSeffective;
	}
	/**
	 * 
	* @MethodName: getProcessinstid 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:45
	* @return Long
	 */
	public Long getProcessinstid() {
		return processinstid;
	}
	/**
	 * 
	* @MethodName: setProcessinstid 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:49
	* @param processinstid void
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	 * 
	* @MethodName: getCarNum 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:25:53
	* @return Integer
	 */
	public Integer getCarNum() {
		return carNum;
	}
	/**
	 * 
	* @MethodName: setCarNum 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:00
	* @param carNum void
	 */
	public void setCarNum(Integer carNum) {
		this.carNum = carNum;
	}
	/**
	 * 
	* @MethodName: getContainerNumNeed 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:04
	* @return Integer
	 */
	public Integer getContainerNumNeed() {
		return containerNumNeed;
	}
	/**
	 * 
	* @MethodName: setContainerNumNeed 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:07
	* @param containerNumNeed void
	 */
	public void setContainerNumNeed(Integer containerNumNeed) {
		this.containerNumNeed = containerNumNeed;
	}
	/**
	 * 
	* @MethodName: getCarHeadNum 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:11
	* @return Integer
	 */
	public Integer getCarHeadNum() {
		return carHeadNum;
	}
	/**
	 * 
	* @MethodName: setCarHeadNum 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:32
	* @param carHeadNum void
	 */
	public void setCarHeadNum(Integer carHeadNum) {
		this.carHeadNum = carHeadNum;
	}
	/**
	 * 
	* @MethodName: getContainerNumActual 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:35
	* @return Integer
	 */
	public Integer getContainerNumActual() {
		return containerNumActual;
	}
	/**
	 * 
	* @MethodName: setContainerNumActual 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:38
	* @param containerNumActual void
	 */
	public void setContainerNumActual(Integer containerNumActual) {
		this.containerNumActual = containerNumActual;
	}
	/**
	 * 
	* @MethodName: getCarGroup 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:42
	* @return String
	 */
	public String getCarGroup() {
		return carGroup == null?"":carGroup;
	}
	/**
	 * 
	* @MethodName: setCarGroup 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:46
	* @param carGroup void
	 */
	public void setCarGroup(String carGroup) {
		this.carGroup = carGroup;
	}
	/**
	 * 
	* @MethodName: getCarGroupCode 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:52
	* @return String
	 */
	public String getCarGroupCode() {
		return carGroupCode;
	}
	/**
	 * 
	* @MethodName: setCarGroupCode 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:55
	* @param carGroupCode void
	 */
	public void setCarGroupCode(String carGroupCode) {
		this.carGroupCode = carGroupCode;
	}
	/**
	 * 
	* @MethodName: getOutTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:26:59
	* @return String
	 */
	public String getOutTime() {
		return outTime;
	}
	/**
	 * 
	* @MethodName: setOutTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:27:02
	* @param outTime void
	 */
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	/**
	 * 
	* @MethodName: getInTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:27:06
	* @return String
	 */
	public String getInTime() {
		return inTime;
	}
	/**
	 * 
	* @MethodName: setInTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:24
	* @param inTime void
	 */
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	/**
	 * 
	* @MethodName: getDraftDate 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:28
	* @return Date
	 */
	public Date getDraftDate() {
		return draftDate;
	}
	/**
	 * 
	* @MethodName: setDraftDate 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:31
	* @param draftDate void
	 */
	public void setDraftDate(Date draftDate) {
		this.draftDate = draftDate;
	}
	/**
	 * 
	* @MethodName: getCreateTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:38
	* @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 
	* @MethodName: setCreateTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:41
	* @param createTime void
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 
	* @MethodName: getModifyTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:44
	* @return Date
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 
	* @MethodName: setModifyTime 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2013-9-22 上午9:28:47
	* @param modifyTime void
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * getter
	 */
	public String getBackInTime() {
		return backInTime;
	}
	/**
	 * setter
	 */
	public void setBackInTime(String backInTime) {
		this.backInTime = backInTime;
	}
	/**
	 * getter
	 */
	public String getBackOutTime() {
		return backOutTime;
	}
	/**
	 * setter
	 */
	public void setBackOutTime(String backOutTime) {
		this.backOutTime = backOutTime;
	}
}