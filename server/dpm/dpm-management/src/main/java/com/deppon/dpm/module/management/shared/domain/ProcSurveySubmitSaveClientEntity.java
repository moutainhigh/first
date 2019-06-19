package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 勘测保存 实体
 * @author 274858
 *
 */
public class ProcSurveySubmitSaveClientEntity implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -616066852854870392L;

	/*
	 * id
	 */
	private int id;
	
	/**
	 * 任务id
	 */
	private int checkId;
	/**
	 * 项目名称
	 */
	private String checkName;
	/**
	 * 项目编码
	 */
	private String checkCode;
	/**
	 * 工号
	 */
	private String checkUserNo;
	/**
	 * 单号
	 */
	private String checkNo;
	/**
	 * 勘测部位code
	 */
	private String partCode;
	/**
	 * 勘测部位名称
	 */
	private String partName;
	/**
	 * 勘测项目code
	 */
	private String proCode;
	/**
	 * 勘测项目名称
	 */
	private String proName;
	/**
	 * 项目说明code
	 */
	private String explainCode;
	/**
	 * 项目说明名称
	 */
	private String explainName;
	/**
	 * 行标
	 */
	private int LineId;
	/**
	 * 排序
	 */
	
	/**
	 * 图片
	 */
	private List<String> attachments;
	/**
	 * 是否达到开点要求
	 */
	private int integratedEvaluation;
	/**
	 * 定位
	 */
	private String location;
	/**
	 * 备注
	 */
	private String specialNeeds;
	/**
	 * 工号
	 */
	private String userNo;
	/*
	 * 数据集合
	 */
	private List<ProcSurveySubmitSaveClientEntity> dateList;
	/*
	 * PC端返回是否成功
	 */
	private int isSuccess;
	/*
	 * PC端返回值说明
	 */
	private String message;
	
	/*
	 * 图片一
	 */
	private String photo1;
	/*
	 * 图片二
	 */
	private String photo2;
	/*
	 * 图片三
	 */
	private String photo3;
	/*
	 * 图片四
	 */
	private String photo4;
	/*
	 * 图片五
	 */
	private String photo5;
	/*
	 * 模块
	 */
	private String module;
	/*
	 * 提示信息
	 */
	private String pkyContent;
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public int getCheckId() {
		return checkId;
	}
	/**
	 * @param checkId
	 */
	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	/**
	 * @return
	 */
	public String getCheckName() {
		return checkName;
	}
	/**
	 * @param checkName
	 */
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	/**
	 * @return
	 */
	public String getCheckCode() {
		return checkCode;
	}
	/**
	 * @param checkCode
	 */
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	/**
	 * @return
	 */
	public String getCheckUserNo() {
		return checkUserNo;
	}
	/**
	 * @param checkUserNo
	 */
	public void setCheckUserNo(String checkUserNo) {
		this.checkUserNo = checkUserNo;
	}
	/**
	 * @return
	 */
	public String getCheckNo() {
		return checkNo;
	}
	/**
	 * @param checkNo
	 */
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	/**
	 * @return
	 */
	public String getPartCode() {
		return partCode;
	}
	/**
	 * @param partCode
	 */
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	/**
	 * @return
	 */
	public String getPartName() {
		return partName;
	}
	/**
	 * @param partName
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
	/**
	 * @return
	 */
	public String getProCode() {
		return proCode;
	}
	/**
	 * @param proCode
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return
	 */
	public String getExplainCode() {
		return explainCode;
	}
	/**
	 * @param explainCode
	 */
	public void setExplainCode(String explainCode) {
		this.explainCode = explainCode;
	}
	/**
	 * @return
	 */
	public String getExplainName() {
		return explainName;
	}
	/**
	 * @param explainName
	 */
	public void setExplainName(String explainName) {
		this.explainName = explainName;
	}
	/**
	 * @return
	 */
	public int getLineId() {
		return LineId;
	}
	/**
	 * @param lineId
	 */
	public void setLineId(int lineId) {
		LineId = lineId;
	}
	/**
	 * @return
	 */
	public List<String> getAttachments() {
		return attachments;
	}
	/**
	 * @param attachments
	 */
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	/**
	 * @return
	 */
	public int getIntegratedEvaluation() {
		return integratedEvaluation;
	}
	/**
	 * @param integratedEvaluation
	 */
	public void setIntegratedEvaluation(int integratedEvaluation) {
		this.integratedEvaluation = integratedEvaluation;
	}
	/**
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return
	 */
	public String getSpecialNeeds() {
		return specialNeeds;
	}
	/**
	 * @param specialNeeds
	 */
	public void setSpecialNeeds(String specialNeeds) {
		this.specialNeeds = specialNeeds;
	}
	/**
	 * @return
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return
	 */
	public List<ProcSurveySubmitSaveClientEntity> getDateList() {
		return dateList;
	}
	/**
	 * @param dateList
	 */
	public void setDateList(List<ProcSurveySubmitSaveClientEntity> dateList) {
		this.dateList = dateList;
	}
	/**
	 * @return
	 */
	public int getIsSuccess() {
		return isSuccess;
	}
	/**
	 * @param isSuccess
	 */
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return
	 */
	public String getPhoto1() {
		return photo1;
	}
	/**
	 * @param photo1
	 */
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	/**
	 * @return
	 */
	public String getPhoto2() {
		return photo2;
	}
	/**
	 * @param photo2
	 */
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	/**
	 * @return
	 */
	public String getPhoto3() {
		return photo3;
	}
	/**
	 * @param photo3
	 */
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	/**
	 * @return
	 */
	public String getPhoto4() {
		return photo4;
	}
	/**
	 * @param photo4
	 */
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	/**
	 * @return
	 */
	public String getPhoto5() {
		return photo5;
	}
	/**
	 * @param photo5
	 */
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
	/**
	 * @return
	 */
	public String getModule() {
		return module;
	}
	/**
	 * @param module
	 */
	public void setModule(String module) {
		this.module = module;
	}
	/**
	 * @return
	 */
	public String getPkyContent() {
		return pkyContent;
	}
	/**
	 * @param pkyContent
	 */
	public void setPkyContent(String pkyContent) {
		this.pkyContent = pkyContent;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProcSurveySubmitSaveClientEntity [id=" + id + ", checkId="
				+ checkId + ", checkName=" + checkName + ", checkCode="
				+ checkCode + ", checkUserNo=" + checkUserNo + ", checkNo="
				+ checkNo + ", partCode=" + partCode + ", partName=" + partName
				+ ", proCode=" + proCode + ", proName=" + proName
				+ ", explainCode=" + explainCode + ", explainName="
				+ explainName + ", LineId=" + LineId + ", attachments="
				+ attachments + ", integratedEvaluation="
				+ integratedEvaluation + ", location=" + location
				+ ", specialNeeds=" + specialNeeds + ", userNo=" + userNo
				+ ", dateList=" + dateList + ", isSuccess=" + isSuccess
				+ ", message=" + message + ", photo1=" + photo1 + ", photo2="
				+ photo2 + ", photo3=" + photo3 + ", photo4=" + photo4
				+ ", photo5=" + photo5 + ", module=" + module + ", pkyContent="
				+ pkyContent + "]";
	}
	
	
	
	
	
	
	
}
