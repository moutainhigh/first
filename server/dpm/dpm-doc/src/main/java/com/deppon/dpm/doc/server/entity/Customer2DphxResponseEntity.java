package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;

/**
 * className:Customer2DphxResponseEntity
 * @author:吕德富
 * @date: 2018年3月6日16:06:03
 * @Description:TODO(老客户查询返回参数)
 */
public class Customer2DphxResponseEntity implements Serializable{
	

	private static final long serialVersionUID = -1225772648393126020L;

	//成功
	private String ifSuccess;
	
	//失败
    private String errorMsg;
    
    private Object iMember;

	public String getIfSuccess() {
		return ifSuccess;
	}

	public void setIfSuccess(String ifSuccess) {
		this.ifSuccess = ifSuccess;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getiMember() {
		return iMember;
	}

	public void setiMember(Object iMember) {
		this.iMember = iMember;
	}

	
	
}
