package com.deppon.dpm.store.server.result;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
/**
 * 
 * @author XiaoTian
 *
 * @param <T>
 */
@SuppressWarnings({ "unused", "hiding" })
public class Result<T> {

	private String msg;
	private T data;
	private int state;
	
	/**
	 *  成功时候的调用
	 * */
	public static <T> Result<T> success(T data){
		return new Result<T>(data);
	}
	
	/**
	 *  失败时候的调用
	 * */
	public static  <T> Result<T> error(BaseResult data){
		return new Result<T>(data);
	}
	/**
	 * 
	 * @param data
	 */
	private Result(T data){
		this.msg = "success";
		this.state = 200 ;
		this.data = data;
	}
	/**
	 * 
	 * @param data
	 */
	private Result(BaseResult data){
		if (null != data) {
			this.msg = data.getMsg();
			this.state = data.getCode() ;
			this.data = (T) data.getData();
		}
	}
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Result [msg=" + msg + ", data=" + data + ", state=" + state
				+ "]";
	}
}
