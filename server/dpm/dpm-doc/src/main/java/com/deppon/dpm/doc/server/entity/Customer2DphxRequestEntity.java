package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;

/**
 * @ClassName:Customer2DphxRequestEntity
 * @author: lvdf
 * @date:2018年3月6日15:41:59
 * @Description:TODO(老客户信息查询请求参数)
 */
public class Customer2DphxRequestEntity implements Serializable{
	

	private static final long serialVersionUID = 8136963252654468507L;
	//老客户电话号
	private String tel;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
