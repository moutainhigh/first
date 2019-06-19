package com.deppon.dpm.module.wfs.shared.domain.dwfs;

import java.io.Serializable;
import java.util.List;

public class DwfsEntity  implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String processDefName;
    private String empCode;
    private String empName;
    private String flag;
    private String actitvityID;
    private String approveOpinion;
    private String currentActivityInstId;
    private String workItemId;
    private String processinstid;
    private String operateInfo;
    private String isAgree;
    private List<TaxDwfsEntity> bussinessBean;
	/**
	 * @return the processDefName
	 */
	public String getProcessDefName() {
		return processDefName;
	}
	/**
	 * @param processDefName the processDefName to set
	 */
	public void setProcessDefName(String processDefName) {
		this.processDefName = processDefName;
	}
	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the actitvityID
	 */
	public String getActitvityID() {
		return actitvityID;
	}
	/**
	 * @param actitvityID the actitvityID to set
	 */
	public void setActitvityID(String actitvityID) {
		this.actitvityID = actitvityID;
	}
	/**
	 * @return the approveOpinion
	 */
	public String getApproveOpinion() {
		return approveOpinion;
	}
	/**
	 * @param approveOpinion the approveOpinion to set
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}
	/**
	 * @return the currentActivityInstId
	 */
	public String getCurrentActivityInstId() {
		return currentActivityInstId;
	}
	/**
	 * @param currentActivityInstId the currentActivityInstId to set
	 */
	public void setCurrentActivityInstId(String currentActivityInstId) {
		this.currentActivityInstId = currentActivityInstId;
	}
	/**
	 * @return the workItemId
	 */
	public String getWorkItemId() {
		return workItemId;
	}
	/**
	 * @param workItemId the workItemId to set
	 */
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}
	/**
	 * @return the processinstid
	 */
	public String getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(String processinstid) {
		this.processinstid = processinstid;
	}
	/**
	 * @return the operateInfo
	 */
	public String getOperateInfo() {
		return operateInfo;
	}
	/**
	 * @param operateInfo the operateInfo to set
	 */
	public void setOperateInfo(String operateInfo) {
		this.operateInfo = operateInfo;
	}
	/**
	 * @return the isAgree
	 */
	public String getIsAgree() {
		return isAgree;
	}
	/**
	 * @param isAgree the isAgree to set
	 */
	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}
	/**
	 * @return the bussinessBean
	 */
	public List<TaxDwfsEntity> getBussinessBean() {
		return bussinessBean;
	}
	/**
	 * @param bussinessBean the bussinessBean to set
	 */
	public void setBussinessBean(List<TaxDwfsEntity> bussinessBean) {
		this.bussinessBean = bussinessBean;
	}
   
}
