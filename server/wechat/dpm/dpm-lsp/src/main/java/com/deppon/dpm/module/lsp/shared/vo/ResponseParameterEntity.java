package com.deppon.dpm.module.lsp.shared.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 268101
 * 实体对象
 * @param <T>
 */
@XmlRootElement(name="ResponseParameterEntity")
public class ResponseParameterEntity<T>{

	//公共返回参数集合
	private T responseEntity;
	//是否成功标志
	private boolean resultFlag;
	//失败原因
	private String failureReason;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * @return 是否成功标志
	 */
	public boolean isResultFlag() {
		return resultFlag;
	}
	/**
	 * @param resultFlag 是否成功标志
	 */
	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}
	/**
	 * @return 失败原因
	 */
	public String getFailureReason() {
		return failureReason;
	}
	/**
	 * @param failureReason 失败原因
	 */
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	/**
	 * @return 公共返回参数集合
	 */
	public T getResponseEntity() {
		return responseEntity;
	}
	/**
	 * @param responseEntity 公共返回参数集合
	 */
	public void setResponseEntity(T responseEntity) {
		this.responseEntity = responseEntity;
	}
	/**
	 * @return 描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description 描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
