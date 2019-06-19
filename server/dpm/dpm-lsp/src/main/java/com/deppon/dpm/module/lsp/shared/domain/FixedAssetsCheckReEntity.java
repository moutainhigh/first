package com.deppon.dpm.module.lsp.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 请求列表时传入的实体
 * @author 233357
 * @date 2015/03/19
 */
public class FixedAssetsCheckReEntity extends BaseEntity {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 701404200442943433L;
	
	/**
	 * ESB区分
	 */
	private String type;
	
	/**
	 * 请求实体
	 */
	private String requestEntity;

	/**
	 * @return ESB区分
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type ESB区分
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return  请求实体
	 */
	public String getRequestEntity() {
		return requestEntity;
	}

	/**
	 * @param requestEntity  请求实体
	 */
	public void setRequestEntity(String requestEntity) {
		this.requestEntity = requestEntity;
	}
	

}
