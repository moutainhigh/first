package com.deppon.dpm.tongxunlu.server.util;
/**
 * 智能门店返回数据
 * @author XiaoTian
 *
 */
public class CodeMsg{
	
	private int code;
	private String msg;
	//角色
	public static CodeMsg Role_NULL_ERROR = new CodeMsg(203, "获取当前角色信息失败");
	//通用成功
	public static CodeMsg SUCCESS = new CodeMsg(200, "success");
	//通用的错误码
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");

	public static CodeMsg Mark_JSON_pric = new CodeMsg(500304, "图片参数不能为空");

	/**
	 * 私有构造器
	 */
	private CodeMsg(String mag) {
	}
	
	/**
	 * 	私有构造器
	 * @param code
	 * @param msg
	 */
	public CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCode() {
		return code;
	}
	
	/** 
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	
	/**
	 * 
	 * @param args
	 * @return
	 */
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}
	
	/**
	 * 输出
	 */
	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
		
}
