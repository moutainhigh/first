package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 定标变更单评委清单分录实体
 * 
 * 
 * @author wangmingzhao
 * @date 2014-2-25 下午2:54:18
 * @since
 * @version
 */
public class CalibrateBillChangeFourEntryEntity extends BaseEntity{

	/**
	 * 序列
	 */  
	 
	private static final long serialVersionUID = 5622909523075971652L;
	/**
	 * 评委库编码
	 */
	private String judgeLibrary;
	/**
	 * 评委姓名
	 */
	private String judgeName;
	/**
	 * 评委类别
	 */
	private String judgeType;
	/**
	 * 评委专长
	 */
	private String judgeExpertise;
	/**
	 * 是否评标组长
	 */
	private boolean ifGroupleader;
	/**
	 * 授权信息
	 */
	private String grantInformation;
	/**
	 * 定标变更单表头ID
	 */
	private String parentId;
	/**
	 *
	 * @return the judgeLibrary
	 *
	 */
	public String getJudgeLibrary() {
		return judgeLibrary;
	}
	/**
	 *
	 * @param judgeLibrary the judgeLibrary to set
	 *
	 */
	public void setJudgeLibrary(String judgeLibrary) {
		this.judgeLibrary = judgeLibrary;
	}
	/**
	 *
	 * @return the judgeName
	 *
	 */
	public String getJudgeName() {
		return judgeName;
	}
	/**
	 *
	 * @param judgeName the judgeName to set
	 *
	 */
	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}
	/**
	 *
	 * @return the judgeType
	 *
	 */
	public String getJudgeType() {
		return judgeType;
	}
	/**
	 *
	 * @param judgeType the judgeType to set
	 *
	 */
	public void setJudgeType(String judgeType) {
		this.judgeType = judgeType;
	}
	/**
	 *
	 * @return the judgeExpertise
	 *
	 */
	public String getJudgeExpertise() {
		return judgeExpertise;
	}
	/**
	 *
	 * @param judgeExpertise the judgeExpertise to set
	 *
	 */
	public void setJudgeExpertise(String judgeExpertise) {
		this.judgeExpertise = judgeExpertise;
	}
	
	/**
	 *
	 * @return the grantInformation
	 *
	 */
	public String getGrantInformation() {
		return grantInformation;
	}
	/**
	 *
	 * @param grantInformation the grantInformation to set
	 *
	 */
	public void setGrantInformation(String grantInformation) {
		this.grantInformation = grantInformation;
	}
	/**
	 *
	 * @return the parentId
	 *
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 *
	 * @param parentId the parentId to set
	 *
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 *
	 * @return the ifGroupleader
	 *
	 */
	public boolean isIfGroupleader() {
		return ifGroupleader;
	}
	/**
	 *
	 * @param ifGroupleader the ifGroupleader to set
	 *
	 */
	public void setIfGroupleader(boolean ifGroupleader) {
		this.ifGroupleader = ifGroupleader;
	}
	
	
	
	
}
