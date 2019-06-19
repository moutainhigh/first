package com.deppon.dpm.module.management.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IpunchClockService;
import com.deppon.dpm.module.management.shared.domain.PunchClockEntity;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 外包打卡考勤
 * 
 * @author 276344
 *
 */
public class PunchClockAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory
			.getLogger(PunchClockAction.class);
	/**
	 * 外包工号
	 */
	private String userId;
	/**
	 * 0:上班卡 1：下班卡 2:昨天的下班卡
	 */
	private String workFlag;

	/**
	 * 0:定位失败 1：定位成功
	 */
	private int isposition;

	/**
	 * 打卡心情 5/4/3/2/1 棒极了/还不错/一般/不开心/糟透了
	 */
	private String moodScore;

	private IpunchClockService punchClockService;

	/**
	 * RedisService
	 */
	private RedisService loginRedisService;

	/**
	 * 打卡互题标识
	 */
	private String sessionId;

	/**
	 * 考勤记录
	 */
	@SuppressWarnings("unused")
	@CookieNotCheckedRequired
	// public void syncRecord(HttpServletRequest request,HttpServletResponse
	// response){
	public void syncRecord() {
		// localhost:8080/dpm/dpm-management/punchClock_syncRecord.action
		this.solveCrossDomain();

		Result<Object> result = new Result<Object>();
		PunchClockEntity entity = new PunchClockEntity();
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat simpleDate2 = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat simpleDate3 = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (isposition != 1) {
			// 定位失败
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
			writeToPage(result);
			return;
		}
		try {
			/*
			 * if ("0".equals(isposition)) { //定位失败 String ipAddress =
			 * RealUserIp.getIpAddress(request);
			 * logger.info(userId+" 手动打卡ip:"+ipAddress); //if
			 * (!DataMonitorMonthJob.IPLIST.contains(ipAddress)) { if
			 * ((!"58.40.17.70"
			 * .equals(ipAddress))&&(!"58.40.17.71".equals(ipAddress)) &&
			 * (!"58.40.17.72".equals(ipAddress))) { //返回参数 //返回给页面
			 * writeToPage(response, "{\"errorCode\":6}"); return null; } }
			 */
			int count = 0;
			if (workFlag.equals("0")) {
				Map<String, Object> map = new HashMap<String, Object>();
				// 获取当前时间
				String clockTime = simpleDate2.format(new Date());
				map.put("empCode", userId);
				map.put("clockTime", clockTime);
				// 判断今天又没有打卡
				entity = punchClockService.getPunchClockRecord(map);
				Map<String, Object> insertmap = new HashMap<String, Object>();
				// 上班时间
				String goWorkTime = sd.format(new Date());
				insertmap.put("empCode", userId);
				insertmap.put("goWorkTime", goWorkTime);
				insertmap.put("clockTime", clockTime);
				if (null == entity) {
					insertmap.put("goMoodScore", moodScore);
					count = punchClockService.createRecord(insertmap);
				} else if (null!=entity&&StringUtils.isNotBlank(entity.getOffWorkTime())&&
						StringUtils.isBlank(entity.getGoWorkTime())) {
					insertmap.put("goMoodScore", moodScore);
					count = punchClockService.updateRecord(insertmap);
				} else {
					result.setErrorCode(Constants.ACTION_RESULT_SUC);
					// errorMessage
					result.setErrorMessage(Constants.ACTIVE_YES);
					// 返回
					writeToPage(result);
					return;
				}

			} else if (workFlag.equals("1")) {
				Map<String, Object> map = new HashMap<String, Object>();
				int hours = 0;
				String clockTime = simpleDate2.format(new Date());
				map.put("empCode", userId);
				map.put("clockTime", clockTime);
				entity = punchClockService.getPunchClockRecord(map);
				Map<String, Object> insertmap = new HashMap<String, Object>();
				/*
				 * String fromDate = simpleDate3.format(new Date());
				 * if(null==entity){
				 * 
				 * String lock=clockTime+" 08:00:00"; //String toDate =
				 * simpleDate3.format(lock); long from =
				 * simpleDate3.parse(fromDate).getTime(); long to =
				 * simpleDate3.parse(lock).getTime(); hours = (int) ((from -
				 * to)/(1000 * 60 * 60)); }else{
				 * if(null==entity.getGoWorkTime()){ String
				 * lock=clockTime+" 08:00:00"; //String toDate =
				 * simpleDate3.format(lock); long from =
				 * simpleDate3.parse(fromDate).getTime(); long to =
				 * simpleDate3.parse(lock).getTime(); hours = (int) ((from -
				 * to)/(1000 * 60 * 60)); }else{ String toDate
				 * =clockTime+" "+entity.getGoWorkTime(); long from =
				 * simpleDate3.parse(fromDate).getTime(); long to =
				 * simpleDate3.parse(toDate).getTime(); hours = (int) ((from -
				 * to)/(1000 * 60 * 60)); } } if(hours<9.5){
				 * result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				 * result.setErrorMessage("打卡时长不足9.5小时"); result.setData("");
				 * writeToPage(result); return; }
				 */

				String offWorkTime = sd.format(new Date());
				insertmap.put("empCode", userId);
				insertmap.put("offWorkTime", offWorkTime);
				insertmap.put("clockTime", clockTime);
				if (null == entity) {
					insertmap.put("offMoodScore", moodScore);
					count = punchClockService.createRecord(insertmap);
				} else {
					insertmap.put("offMoodScore", moodScore);
					count = punchClockService.updateRecord(insertmap);
				}
			} else if (workFlag.equals("2")) {
				// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DAY_OF_MONTH, -1);

				Map<String, Object> map = new HashMap<String, Object>();

				String clockTime = simpleDate2.format(c.getTime());

				map.put("empCode", userId);
				map.put("clockTime", clockTime);
				entity = punchClockService.getPunchClockRecord(map);
				Map<String, Object> insertmap = new HashMap<String, Object>();

				String offWorkTime = sd.format(new Date());
				offWorkTime.substring(0, 2);
				int parseInt = Integer.parseInt(offWorkTime.substring(0, 2)) + 24;
				String oldOffWorkTime = String.valueOf(parseInt)
						+ offWorkTime.substring(2);
				insertmap.put("empCode", userId);
				insertmap.put("offWorkTime", oldOffWorkTime);
				insertmap.put("clockTime", clockTime);
				if (null == entity) {
					insertmap.put("offMoodScore", moodScore);
					count = punchClockService.createRecord(insertmap);
				} else {
					insertmap.put("offMoodScore", moodScore);
					count = punchClockService.updateRecord(insertmap);
				}
			}
			if (count > 0) {
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			} else {
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("打卡失败");
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("导入考勤信息工号：" + userId + "的出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData("");
		// 返回
		writeToPage(result);

	}

	/**
	 * 查询打卡考勤记录
	 */
	@CookieNotCheckedRequired
	public void getPunchClockRecord() {
		// localhost:8080/dpm/dpm-management/yearSummary_summary.action
		this.solveCrossDomain();
		// 结果集
		Result<Object> result = new Result<Object>();
		List<PunchClockEntity> entity = new ArrayList<PunchClockEntity>();
		try {
			// 获取考勤列表
			entity = punchClockService.getPunchClockRecordList(userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询工号为" + userId + "的考勤记录出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(entity);
		// 返回
		writeToPage(result);
	}

	/**
	 * 获取上班时长
	 */
	@CookieNotCheckedRequired
	public void getPunkClockDetail() {
		Boolean flag = false;

		// localhost:8080/dpm/dpm-management/yearSummary_summary.action
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		try {
			PunchClockEntity entity = new PunchClockEntity();
			SimpleDateFormat simpleDate2 = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDate3 = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> map = new HashMap<String, Object>();
			// int hours=0;
			String clockTime = simpleDate2.format(new Date());
			map.put("empCode", userId);
			map.put("clockTime", clockTime);
			entity = punchClockService.getPunchClockRecord(map);
			// String fromDate = simpleDate3.format(new Date());

			/**
		     * 
		     */
			if (null == entity || StringUtils.isEmpty(entity.getGoWorkTime())) {
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("没有打上班卡，没有时长");
				writeToPage(result);
				return;

			}

			if (!StringUtils.isEmpty(entity.getOffWorkTime())) {

				Map<Object, Object> hashMap = new HashMap<Object, Object>();
				hashMap.put("curdate", clockTime);
				hashMap.put("curtimebegin", entity.getGoWorkTime());
				hashMap.put("curtimeend", entity.getOffWorkTime());
				hashMap.put("isKicOut", flag);
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage(Constants.ACTIVE_YES);
				result.setData(hashMap);
				writeToPage(result);

			} else {
				Map<Object, Object> hashMap = new HashMap<Object, Object>();
				hashMap.put("curdate", clockTime);
				hashMap.put("curtimebegin", entity.getGoWorkTime());
				hashMap.put("curtimeend", null);
				hashMap.put("isKicOut", flag);
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage(Constants.ACTIVE_YES);
				result.setData(hashMap);
				writeToPage(result);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("工号：" + userId + "获取打卡时长出错 原因为：" + e.toString());
		}

		// 返回

	}

	/**
	 * 获取系统时间
	 */
	@CookieNotCheckedRequired
	public void getSysTime() {
		// localhost:8080/dpm/dpm-management/yearSummary_summary.action
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		long time = new Date().getTime();

		// count
		result.setCount(1);
		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
		hashMap.put("data", time);
		hashMap.put("flag", true);
		// data
		result.setData(hashMap);
		result.setErrorCode(0);

		// 返回
		writeToPage(null, result);
	}
	
	/**
	 * 踢出判断
	 */
	@CookieNotCheckedRequired
	public void iskitOut() {
		//Boolean flag = false;

		// localhost:8080/dpm/dpm-management/yearSummary_summary.action
		//跨域处理
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		//获取登录人信息
		String data = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
		if (null != data) {
			LoginResult loginResult = JSONObject.parseObject(data,
					LoginResult.class);
			String outToken = loginResult.getOutToken();
			//踢出
			if (!outToken.equals(sessionId)) {
				result.setErrorCode(9999);
				result.setData("");
				writeToPage(null, result);
				return;
			}
			//踢出
		}else{
			result.setErrorCode(9999);
			result.setData("");
			writeToPage(null, result);
			return;
		}
		// data
		result.setData("");
		result.setErrorCode(0);

		// 返回
		writeToPage(null, result);
	}
	
	

	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public IpunchClockService getPunchClockService() {
		return punchClockService;
	}

	public void setPunchClockService(IpunchClockService punchClockService) {
		this.punchClockService = punchClockService;
	}

	
	
	public RedisService getLoginRedisService() {
		return loginRedisService;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

	public String getWorkFlag() {
		return workFlag;
	}

	public void setWorkFlag(String workFlag) {
		this.workFlag = workFlag;
	}

	public String getMoodScore() {
		return moodScore;
	}

	public void setMoodScore(String moodScore) {
		this.moodScore = moodScore;
	}

	public int getIsposition() {
		return isposition;
	}

	public void setIsposition(int isposition) {
		this.isposition = isposition;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	

}
