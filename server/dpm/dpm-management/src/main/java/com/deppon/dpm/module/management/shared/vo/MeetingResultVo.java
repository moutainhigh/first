package com.deppon.dpm.module.management.shared.vo;

public class MeetingResultVo {
	
	private String success;
	
	private String flag;
	
	private String message;
	
	private int code;
	
	private Object data;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MeetingResultVo [success=" + success + ", flag=" + flag
				+ ", message=" + message + ", code=" + code + ", data=" + data
				+ "]";
	}
	
	

}
