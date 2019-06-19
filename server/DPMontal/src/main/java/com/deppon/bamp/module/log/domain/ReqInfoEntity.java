package com.deppon.bamp.module.log.domain;

import java.io.Serializable;

/**
 * @title: ReqInfoEntity 
 * @description: 请求信息实体
 * @author: wuyaqing
 * @date:  2014-4-18 下午4:44:29
 */
public class ReqInfoEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7624933178297339762L;

	//类全名+方法名
	private String methodName;
	//命名空间
	private String namespace;
	//用户账号
	private String empCode;
	//用户IP地址
	private String clientIp;
	//http请求url 
	private String requestUrl;
	//http请求参数信息
	private String requestPara;
	//http请求其他信息
	private String requestInfo;
	//业务系统IP地址
	private String serverIp;
	//服务请求时间
	private String reqTime;
	//服务响应时间
	private String respTime;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getRequestPara() {
		return requestPara;
	}
	public void setRequestPara(String requestPara) {
		this.requestPara = requestPara;
	}
	public String getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public String getRespTime() {
		return respTime;
	}
	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}
	
}
