package com.deppon.dpm.module.management.shared.vo;

import java.util.ArrayList;
import java.util.List;

public class ResultVO<T> {
	//标志位
	private boolean resultFlag = false;
	//信息
	private String message;
	//时间list
	private List<T> data = new ArrayList<T>();
	//T
	private T domain;
	//错误信息
	private String errorMessage;
	//错误原因
	private String failureReason;
	//总数
	private int count;
     //get set
	public boolean isResultFlag() {
		return resultFlag;
	}
    //get set
	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}
    //get set
	public String getMessage() {
		return message;
	}
    //get set
	public void setMessage(String message) {
		this.message = message;
	}
    //get set
	public List<T> getData() {
		return data;
	}
    //get set
	public void setData(List<T> data) {
		this.data = data;
		if(this.data != null){
			setCount(this.data.size());
		}
		setResultFlag(true);
	}
    //get set
	public T getDomain() {
		return domain;
	}
    //get set
	public void setDomain(T domain) {
		this.domain = domain;
		setResultFlag(true);
	}
    //get set
	public int getCount() {
		return count;
	}
    //get set
	public void setCount(int count) {
		this.count = count;
	}
    //get set
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    //get set
	public String getFailureReason() {
		return failureReason;
	}
    //get set
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
}
