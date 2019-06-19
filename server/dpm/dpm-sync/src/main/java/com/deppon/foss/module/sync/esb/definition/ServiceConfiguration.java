package com.deppon.foss.module.sync.esb.definition;

import com.deppon.foss.module.sync.esb.process.ICallBackProcess;
import com.deppon.foss.module.sync.esb.process.IProcess;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;

/**
 * 通道实体类
 * 
 * @author 231586
 * 
 */
public class ServiceConfiguration {
	/**
	 * 请求
	 */
	@SuppressWarnings("rawtypes")
	private IMessageTransform reqConvertor;
	/**
	 * 响应
	 */
	@SuppressWarnings("rawtypes")
	private IMessageTransform resConvertor;
	/**
	 * 处理类
	 */
	private IProcess processor;
	/**
	 * 回调处理类
	 */
	private ICallBackProcess callBackProcess;
	/**
	 * 请求队列
	 */
	private String requestQueue;
	/**
	 * 相应队列
	 */
	private String responseQueue;
	/**
	 * esb状态队列
	 */
	private String esbStatusQueue;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEsbStatusQueue() {
		return esbStatusQueue;
	}

	/**
	 * set
	 * 
	 * @param esbStatusQueue
	 */
	public void setEsbStatusQueue(String esbStatusQueue) {
		this.esbStatusQueue = esbStatusQueue;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRequestQueue() {
		return requestQueue;
	}

	/**
	 * set
	 * 
	 * @param requestQueue
	 */
	public void setRequestQueue(String requestQueue) {
		this.requestQueue = requestQueue;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getResponseQueue() {
		return responseQueue;
	}

	/**
	 * set
	 * 
	 * @param responseQueue
	 */
	public void setResponseQueue(String responseQueue) {
		this.responseQueue = responseQueue;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public IMessageTransform getReqConvertor() {
		return reqConvertor;
	}

	/**
	 * set
	 * 
	 * @param reqConvertor
	 */
	@SuppressWarnings("rawtypes")
	public void setReqConvertor(IMessageTransform reqConvertor) {
		this.reqConvertor = reqConvertor;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public IMessageTransform getResConvertor() {
		return resConvertor;
	}

	/**
	 * set
	 * 
	 * @param resConvertor
	 */
	@SuppressWarnings("rawtypes")
	public void setResConvertor(IMessageTransform resConvertor) {
		this.resConvertor = resConvertor;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IProcess getProcessor() {
		return processor;
	}

	/**
	 * set
	 * 
	 * @param processor
	 */
	public void setProcessor(IProcess processor) {
		this.processor = processor;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ICallBackProcess getCallBackProcess() {
		return callBackProcess;
	}

	/**
	 * set
	 * 
	 * @param callBackProcess
	 */
	public void setCallBackProcess(ICallBackProcess callBackProcess) {
		this.callBackProcess = callBackProcess;
	}
}
