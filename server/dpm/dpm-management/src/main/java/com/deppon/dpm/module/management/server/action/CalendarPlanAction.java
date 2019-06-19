package com.deppon.dpm.module.management.server.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.ICalendarService;
import com.deppon.dpm.module.management.util.Constants;

/**
 * 日程排班
 * 
 * @author 231586
 * 
 */
public class CalendarPlanAction extends BaseAction {
	/**
	 * log
	 */
	private static Logger logger = Logger.getLogger(CalendarPlanAction.class);
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2839891664104225558L;
	/**
	 * esb编码
	 */
	private static final String ESB_CODE = "ESB_DPM2ESB_GET_ARRANGE_DATA";
	/**
	 * 查询年份
	 */
	private String year;
	/**
	 * 查询月份
	 */
	private String month;
	/**
	 * set injection
	 * 地址信息
	 */
	//private String calendarPlanPath;
	
	/**
	 * set injection
	 */
	private ICalendarService calendarService;
	
	/**
	 * 获取日程排班信息
	 */
	public void getCalendarPlan() {
		// 返回结果集定义
		Result<Object> result = new Result<Object>();
		// 用以参数拼接
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 工号
			map.put("empCode", userId);
			// 年份
			map.put("year", year);
			// 月份
			map.put("month", month);
			// log
			logger.info("日程排班插入参数:" + JSON.toJSONString(map));
			// http请求，数据返回
			String data = calendarService.getCalendarPlan(map);
			/*String data = HttpUtil.httpClient(JsonUtil.mapToJsonObject(map),
					calendarPlanPath, ESB_CODE);*/
			// log
			logger.info("日程排班获取值:" + JSON.toJSONString(data));
			try {
				// json-->object
				JSONObject object = JSON.parseObject(data);
				// count
				result.setCount(Constants.ACTION_RESULT_SUC);
				// errorCode
				result.setErrorCode(Constants.SUCCESS);
				// errorMessage
				result.setErrorMessage("");
				// 返回日程排班日期
				result.setData(object != null ? object.get("scheduleInfoEntity"):"");
			} catch (Exception e) {
				// log
				logger.error("传入JSON格式不正确");
				// count
				result.setCount(Constants.ACTION_RESULT_ERROR);
				// errorCode
				result.setErrorCode(Constants.WRONG_REQUEST);
				// errorMessage
				result.setErrorMessage("数据解析异常");
				// 返回信息
				result.setData("");
			}
			// 前端返回
			writeToPage(result);
		} catch (Exception e) {
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// errorCode
			result.setErrorCode(Constants.WRONG_REQUEST);
			// errorMessage
			result.setErrorMessage("获取数据出错,请稍后再试");
			// data
			result.setData("");
			// 错误打印
			e.printStackTrace();
			// 前端返回
			writeToPage(result);
		}
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * set
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * set
	 * 
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * set
	 * 
	 * @param calendarPlanPath
	 */
	/*public void setCalendarPlanPath(String calendarPlanPath) {
		this.calendarPlanPath = calendarPlanPath;
	}*/

	public ICalendarService getCalendarService() {
		return calendarService;
	}

	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
	}

}
