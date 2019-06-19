package com.deppon.dpm.module.management.shared.domain;

import java.util.Arrays;

/**
 * 功能描述：事件上报请求实体
 * @date 2015-04-03 上午11:10:55
 */
public class OrderAddRequest {
	//上报人工号
	private String reporterCode;
	//上报人部门编号
	private String deptId;
	//手机号码
	private String reporterMobile;
	//电话号码
	private String reporterPhone;
	//是否总部职能       是：true   否：false
	private boolean zbzn;
	//地址
	private String address;
	//详细地址
	private String detailAddress;
	//问题类型编码
	private String faultCode;
	//事件描述
	private String description;
	/**
	 * 事件上报类别，1 正常上报 2 只上报图片
	 */
	private int addType;
	/**
	 * 附件名称数组
	 */
	private String[] attachmentsName;
	/**
	 * 单个附件 Attachment
	 */
	private Attachment attachment;
	/** 
	 * @return attachment 
	 */
	public Attachment getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	/**
	 * @return 事件上报类别，1 正常上报 2 只上报图片
	 */
	public int getAddType() {
		return addType;
	}
	/**
	 * @param addType 事件上报类别，1 正常上报 2 只上报图片
	 */
	public void setAddType(int addType) {
		this.addType = addType;
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
	 * @return 手机号码
	 */
	public String getReporterMobile() {
		return reporterMobile;
	}
	/**
	 * @param reporterMobile 手机号码
	 */
	public void setReporterMobile(String reporterMobile) {
		this.reporterMobile = reporterMobile;
	}
	public String getReporterPhone() {
		return reporterPhone;
	}
	public void setReporterPhone(String reporterPhone) {
		this.reporterPhone = reporterPhone;
	}
	public boolean isZbzn() {
		return zbzn;
	}
	public void setZbzn(boolean zbzn) {
		this.zbzn = zbzn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String[] getAttachmentsName() {
		return attachmentsName;
	}
	public void setAttachmentsName(String[] attachmentsName) {
		this.attachmentsName = attachmentsName;
	}
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	/** 
	* @Title: toString 
	* @Description: 重写toString方法
	* @param @return
	* @author 123240
	* @date 2015-4-2 下午2:18:44  
	* @version V1.0    
	* @return
	* @throws 
	*/ 
	
	@Override
	public String toString() {
		return "OrderAddRequest [reporterCode=" + reporterCode + ", deptId="
				+ deptId + ", reporterMobile=" + reporterMobile
				+ ", reporterPhone=" + reporterPhone + ", zbzn=" + zbzn
				+ ", address=" + address + ", detailAddress=" + detailAddress
				+ ", faultCode=" + faultCode + ", description=" + description
				+ ", addType=" + addType + ", attachmentsName="
				+ Arrays.toString(attachmentsName) + ", attachment="
				+ attachment + "]";
	}
}
