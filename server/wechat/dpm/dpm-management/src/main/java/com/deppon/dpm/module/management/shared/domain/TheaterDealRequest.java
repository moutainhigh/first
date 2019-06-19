package com.deppon.dpm.module.management.shared.domain;


/**
 * 任务处理
 * 
 * @author 245968
 * 
 */
public class TheaterDealRequest {
	/**
	 * 事件/问题编码
	 */
	private String orderCode;
	/**
	 * 原因分析
	 */
	private String resionAnalyse;
	/**
	 * 解决方案
	 */
	private String solution;
	/**
	 * 挂起备注
	 */
	private String hangupText;
	/**
	 * 转二线备注
	 */
	private String twohandleText;
	/**
	 * 处理方式 handleType 1 终端提交，2 终端挂起，3终端 转二线 4 挂起提交 5受理 6退回
	 */
	private int handleType;
	/**
	 * 当前处理人
	 */
	private String dealUserCode;
	/**
	 * 当前处理人(IT服务台定义的小写，为回退接口服务)
	 */
	private String dealUsercode;
	/**
	 * 当期操作人姓名
	 */
	private String dealUserName;

	/**
	 * 问题类型code
	 */
	private String faultCode;
	/**
	 * 事件类型
	 */
	private String faultName;
	/**
	 * 类型描述code
	 */
	private String faultSubcode;
	/**
	 * 类型描述
	 */
	private String faultDesc;
	/**
	 * 详细类别Code
	 */
	private String modulCode;
	/**
	 * 详细类别
	 */
	private String faultModul;
	/**
	 * 所属子模块
	 */
	private String subsystem;
	/**
	 * 当前工号状态
	 */
	private String statusCode;
	/**
	 * 上报人姓名
	 */
	private String reporterName;
	/**
	 * 上报人工号
	 */
	private String reporterCode;
	/**
	 * 事件类型附件
	 */
	private Attachment attachment;
	
	/**
	 * 退回处理意见
	 */
	private String dealAdvice;

	/**
	 * @return 事件/问题编码
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode 事件/问题编码
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * @return 原因分析
	 */
	public String getResionAnalyse() {
		return resionAnalyse;
	}

	/**
	 * @param resionAnalyse 原因分析
	 */
	public void setResionAnalyse(String resionAnalyse) {
		this.resionAnalyse = resionAnalyse;
	}

	/**
	 * @return 解决方案
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution 解决方案
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	/**
	 * @return 挂旗备注
	 */
	public String getHangupText() {
		return hangupText;
	}

	/**
	 * @param hangupText 挂旗备注
	 */
	public void setHangupText(String hangupText) {
		this.hangupText = hangupText;
	}

	/**
	 * @return 转二线备注
	 */
	public String getTwohandleText() {
		return twohandleText;
	}

	/**
	 * @param twohandleText 转二线备注
	 */
	public void setTwohandleText(String twohandleText) {
		this.twohandleText = twohandleText;
	}

	/**
	 * @return 处理方式 handleType 1 终端提交，2 终端挂起，3终端 转二线 4 挂起提交 5受理
	 */
	public int getHandleType() {
		return handleType;
	}

	/**
	 * @param handleType 处理方式 handleType 1 终端提交，2 终端挂起，3终端 转二线 4 挂起提交 5受理
	 */
	public void setHandleType(int handleType) {
		this.handleType = handleType;
	}

	/**
	 * @return 当前处理人
	 */
	public String getDealUserCode() {
		return dealUserCode;
	}

	/**
	 * @param dealUserCode 当前处理人
	 */
	public void setDealUserCode(String dealUserCode) {
		this.dealUserCode = dealUserCode;
	}

	/**
	 * @return 当期操作人姓名
	 */
	public String getDealUserName() {
		return dealUserName;
	}

	/**
	 * @param dealUserName 当期操作人姓名
	 */
	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	/**
	 * @return 问题类型code
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * @param faultCode 问题类型code
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * @return 事件类型
	 */
	public String getFaultName() {
		return faultName;
	}

	/**
	 * @param faultName 事件类型
	 */
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	/**
	 * @return 所属子模块
	 */
	public String getSubsystem() {
		return subsystem;
	}

	/**
	 * @param subsystem 所属子模块
	 */
	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	/**
	 * @return 类型描述
	 */
	public String getFaultDesc() {
		return faultDesc;
	}

	/**
	 * @param faultDesc 类型描述
	 */
	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	/**
	 * @return 详细类别code
	 */
	public String getModulCode() {
		return modulCode;
	}

	/**
	 * @param modulCode 详细类别code
	 */
	public void setModulCode(String modulCode) {
		this.modulCode = modulCode;
	}

	/**
	 * @return 详细类别
	 */
	public String getFaultModul() {
		return faultModul;
	}

	/**
	 * @param faultModul 详细类别
	 */
	public void setFaultModul(String faultModul) {
		this.faultModul = faultModul;
	}

	/**
	 * @return 类型描述code
	 */
	public String getFaultSubcode() {
		return faultSubcode;
	}

	/**
	 * @param faultSubcode 类型描述code
	 */
	public void setFaultSubcode(String faultSubcode) {
		this.faultSubcode = faultSubcode;
	}

	/**
	 * @return 事件类型附件
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment 事件类型附件
	 */
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return 当前工号状态
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode 当前工号状态
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return 上报人姓名
	 */
	public String getReporterName() {
		return reporterName;
	}

	/**
	 * @param reporterName 上报人姓名
	 */
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	/**
	 * @return 上报人工号
	 */
	public String getReporterCode() {
		return reporterCode;
	}

	/**
	 * @param reporterCode 上报人工号
	 */
	public void setReporterCode(String reporterCode) {
		this.reporterCode = reporterCode;
	}
	

	/**
	 * @return 退回处理意见
	 */
	public String getDealAdvice() {
		return dealAdvice;
	}

	/**
	 * @param dealAdvice 退回处理意见
	 */
	public void setDealAdvice(String dealAdvice) {
		this.dealAdvice = dealAdvice;
	}

	public String getDealUsercode() {
		return dealUsercode;
	}

	public void setDealUsercode(String dealUsercode) {
		this.dealUsercode = dealUsercode;
	}

	//组装
	@Override
	public String toString() {
		return "TheaterDealRequest [orderCode=" + orderCode
				+ ", resionAnalyse=" + resionAnalyse + ", solution=" + solution
				+ ", hangupText=" + hangupText + ", twohandleText="
				+ twohandleText + ", handleType=" + handleType
				+ ", dealUserCode=" + dealUserCode + ", dealUserName=" + dealUserName + ", faultCode=" + faultCode 
				+ ", faultName=" + faultName + ", faultSubcode=" + faultSubcode 
				+ ", faultDesc=" + faultDesc + ", modulCode=" + modulCode 
				+ ", faultModul=" + faultModul + ", subsystem=" + subsystem 
				+ ", statusCode=" + statusCode + ", reporterName=" + reporterName 
				+ ", reporterCode=" + reporterCode + ", dealAdvice=" + dealAdvice + "]";
	}
}
