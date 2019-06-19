package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;

/** 
* @ClassName: OccupyBudgetResponseEntity 
* @Description: TODO(预算占用返回参数) 
* @author 287306
* @date 2017-11-21 下午8:59:11 
*  
*/
public class OccupyBudgetResponseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//打车id
	private String businessId;
	//是否成功  y n
	private String isSuccess;
	//失败原因
	private String failReason;
	
	/**
	 * 构造方法
	 */
	public OccupyBudgetResponseEntity(){
		super();
	}
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	
}
