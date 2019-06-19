package com.deppon.dpm.store.server.result;
/**
 * 
 * @author XiaoTian
 *
 */
public class CodeMsg extends BaseResult{
	
	private int code;
	private String msg;
	//角色
	public static CodeMsg Role_NULL_ERROR = new CodeMsg(203, "获取当前角色信息失败");
	//通用成功
	public static CodeMsg SUCCESS = new CodeMsg(200, "success");
	//通用的错误码
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
	//任务模块 5002XX
	public static CodeMsg Task_BIND_ERROR = new CodeMsg(500200, "下发任务参数校验异常：%s");
	public static CodeMsg Task_TASKNAME_ERROR = new CodeMsg(500201, "任务名称不能为空");
	public static CodeMsg Task_TASKINFO_ERROR = new CodeMsg(500202, "任务描述不能为空");
	public static CodeMsg Task_TASKTYPE_ERROR = new CodeMsg(500203, "任务类型不能为空");
	public static CodeMsg Task_STARTTIME_ERROR = new CodeMsg(500204, "任务开始日期不能为空");
	public static CodeMsg Task_ENDTIME_ERROR = new CodeMsg(500205, "任务截至日期不能为空");
	public static CodeMsg Task_ERROR = new CodeMsg(500206, "创建任务失败");
	public static CodeMsg Task_JSON_ERROR = new CodeMsg(500207, "任务JSON转换失败");
	//任务打分模块 5003XX
	public static CodeMsg Mark__ERROR = new CodeMsg(500300, "任务模块打分失败");
	public static CodeMsg Mark_Task_ERROR = new CodeMsg(500301, "任务巡检模块参数校验异常");
	public static CodeMsg Mark_JSON_ERROR = new CodeMsg(500302, "JSON对象异常参数校验异常");
	public static CodeMsg Mark_JSON_exist = new CodeMsg(500303, "模块打分已经记录不能重复打分");
	public static CodeMsg Mark_JSON_pric = new CodeMsg(500304, "图片参数不能为空");
	//榜单模块 5004xx
	public static CodeMsg List__ERROR = new CodeMsg(500400, "榜单查询异常");
	public static CodeMsg List_SD__ERROR = new CodeMsg(500401, "查询专业部门异常");
	public static CodeMsg List_NULL__SUCCESS = new CodeMsg(200, "查询信息为空");
	public static CodeMsg List_PARAMETER_NULL = new CodeMsg(500403, "榜单操作传入参数为空");
	public static CodeMsg List_WARNING_NULL = new CodeMsg(500404, "点赞警告操作异常");
	public static CodeMsg List_LIKENUM_SUCCESS = new CodeMsg(500405, "点赞或警告操作成功");
	public static CodeMsg List_LIKENUM_ERROR = new CodeMsg(500406, "点赞或者警告失败");
	public static CodeMsg List_Like_ERROR = new CodeMsg(500407, "点赞或者警告失败");
	public static CodeMsg List_Like_exist = new CodeMsg(500408, "点赞或者警告信息存在");
	/**
	 * 私有构造器
	 */
	private CodeMsg(String mag) {
		super(mag);
	}
	
	/**
	 * 	私有构造器
	 * @param code
	 * @param msg
	 */
	public CodeMsg( int code,String msg ) {
		super(code, msg);
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
