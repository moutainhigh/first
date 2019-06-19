package com.deppon.dpm.doc.server.entity;

/**
 * @className:Member2DphxEntity
 * @author: lvdf
 * @date:2018年3月6日17:13:40
 * @Description:TODO(老客户信息查询返回参数实体)
 * */
public class Member2DphxEntity{
	/**
	 * 客户编码
	 */
    private String custCode;
    /**
	 * 客户名称
	 */
    private String custName;
    /**
  	 * 潜客PC_CUSTOMER 散客SC_CUSTOMER 固定客户RC_CUSTOMER 
  	 */
    private String custType;
    /**
  	 * 客户状态  Y：有效 N：无效
  	 */
    private String custStatus;
    
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	
}
