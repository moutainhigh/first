package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import com.deppon.ar.bamp.common.util.DateUtil;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IReserveManWorkService;
import com.deppon.dpm.module.management.server.service.IReserveSubmitSerivce;
import com.deppon.dpm.module.management.server.service.IUserService;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.shared.domain.ReserveSubmitEntity;
import com.deppon.dpm.module.management.shared.domain.TimeEntity;
import com.deppon.dpm.module.management.shared.vo.LoginUserVO;
import com.deppon.dpm.module.management.shared.vo.ResultVO;
import com.deppon.dpm.module.management.util.Constants;

/**
 * 预定提交 和 数据 监控Action
 * 
 * @author 王亚男
 * 
 */
public class ReserveSubmitAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -7759221856607318089L;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ReserveSubmitAction.class);

	/**
	 * reserveSubmitSerivce
	 */
	private IReserveSubmitSerivce reserveSubmitSerivce;
	/** 
	* @Fields reserveManWorkService 场地预订操作service
	*/ 
	private IReserveManWorkService reserveManWorkService;
	/**
	 * userServiceMs
	 */
	private IUserService userServiceMs;

	/**
	 * monitorCountInfoService
	 */
	private IMonitorCountInfoService monitorCountInfoService;

	/**
	 * 预定场地数据监控
	 */
	public static final int DATA_MONITOR_RESERVE = 43;

	/**
	 * 预定提交
	 */
	public void submitReserveDatetime() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		String str = "";

		ResultVO<Object> result = new ResultVO<Object>();
		try {
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			logger.info("预定场地提交得到前台APP参数是:" + str);

			if (StringUtils.isNotBlank(str)) {
				JSONObject json = JsonUtil.parseObject(str);
				// --校验--
				int isManager = json.getInteger("isManager");
				// --
				ReserveRecordEntity entity = JsonUtil.jsonToEntity(str,
						ReserveRecordEntity.class);
				// --判断开始时间 是否 已经不能预定 --所有用户
				Date nowTime = new Date();
					if (entity.getStartTime().getTime() > nowTime.getTime()) {
						//抽取公共方法，提供校验
						checkRule(result, isManager, entity);
					} else {
						logger.info("预定开始时间已经超时!");
						result.setResultFlag(false);
						result.setFailureReason("预定开始时间已经超时!");
					}


			} else {
				logger.info("获取参数为空!!");
				result.setResultFlag(false);
				result.setFailureReason("获取参数为空!");
			}

		} catch (Exception e) {
			// 捕获异常
			logger.info("has error");
			e.printStackTrace();
			result.setResultFlag(false);
			result.setFailureReason("系统出现异常！请稍候再试");
		}
		// 转json格式
		String res = JsonUtil.beanToJsonString(result);
		// 写入数据
		writeToPage(res);
	}



	private void checkRule(ResultVO<Object> result, int isManager,
			ReserveRecordEntity entity) throws ParseException {
		boolean maybe = true;
		if (isManager == 0) {
			// 普通用户预定规则
			// 1. 0.5h <= M <=2h AND 17:30 - 21:30
			ResultVO<Object> res = this.reserveTimeIsOk(entity);
			if (res.isResultFlag()) {
				// 2.该用户预定时间必须在规定时间内 8:00-21:30
				boolean canSubmit = this
						.isCanSubmitByThisTime();
				if (canSubmit) {
					// 普通用户预定规则
					// 3.该天预定时长不能超过2小时
					boolean canReserve = this.reserveSubmitSerivce
							.canBeReserve(entity);
					if (!canReserve) {
						result.setResultFlag(false);
						result.setFailureReason("该天预定总数时间已经超过两小时!请休息下!");
						maybe = false;
					}
				} else {
					result.setResultFlag(false);
					result.setFailureReason("该时间段不能进行场地预定!");
					maybe = false;
				}
			} else {
				result.setResultFlag(false);
				result.setFailureReason(res.getFailureReason());
				maybe = false;
			}

		}
		if (maybe) {
			synchronized(this){
				// --判断时间段是否可以预定 --所有用户
				boolean flag = this.reserveSubmitSerivce
						.isCanAdd(entity);
				if (flag) {
					LoginUserVO user = this.userServiceMs
							.getLoginUserVO(entity.getUserNo());
					entity.setUserName(user.getEmpname());
					entity.setUserphone(user.getMobileno());
					boolean insert = this.reserveSubmitSerivce
							.addReserveEntity(entity);
					if (insert) {
						// --判断 开始时间 是否有可能 略过 定时器 ; 如果略过定时器 则要发送消息通知

						result.setResultFlag(true);
						result.setMessage("预定场地成功！");
						logger.info("预定场地成功! 场地ID:"
								+ entity.getPlayRoomId()
								+ ",预定人工号:" + entity.getUserNo());
					}

					// --
				} else {
					logger.info("该时间段已经被预定!不能再次预定!");
					result.setResultFlag(false);
					result.setFailureReason("该场地在该时间段内已经被预定!请选择其它时间玩耍!");
				}
			}
			
		}
	}



	public void submitReserve() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		String str = "";

		ResultVO<Object> result = new ResultVO<Object>();
		try {
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			logger.info("预定场地提交得到前台APP参数是:" + str);

			if (StringUtils.isNotBlank(str)) {
				JSONObject json = JsonUtil.parseObject(str);
				// --校验--
				//int isManager = json.getInteger("isManager");
				int isManager = 0;
				ReserveSubmitEntity entity = JsonUtil.jsonToEntity(
						json.toString(), ReserveSubmitEntity.class);
				List<TimeEntity> timeList = entity.getDatatime();
				//校验是否是管理员
				if(checkIsAdmin(entity.getUserNo())){
					isManager = 1;
				}
				// 先对普通用户进行判断
				boolean maybe = true;
				// 所有用户 判断是否有选择时间
				maybe = checkUserDate(result, isManager, entity, timeList,
						maybe);

				// 所有用户 判断是否有选择时间
				if (maybe) {
					// 所有用户 判断是否在这些时间段里有被预定的
					synchronized(this){
						//抽取方法
						checkIsOkForTime(result, entity, timeList);
					}
					
				}
			}
		} catch (Exception e) {
			logger.info("has error");
			e.printStackTrace();
			result.setResultFlag(false);
			result.setFailureReason("系统出现异常！请稍候再试");
		}
		String res = JsonUtil.beanToJsonString(result);
		writeToPage(res);
	}



	private void checkIsOkForTime(ResultVO<Object> result,
			ReserveSubmitEntity entity, List<TimeEntity> timeList)
			throws ParseException {
		boolean isOkForTime = this.reserveSubmitSerivce
				.isCanAddList(timeList, entity.getPlayRoomId());
		if (isOkForTime) {
			// 合并参数并插入数据库
			LoginUserVO user = this.userServiceMs
					.getLoginUserVO(entity.getUserNo());
			// 对开始时间进行排序
			Collections.sort(timeList);
			Map<Date, ReserveRecordEntity> mapTime = new HashMap<Date, ReserveRecordEntity>();
			List<ReserveRecordEntity> records = new ArrayList<ReserveRecordEntity>();

			// 合并前后时间连续的时间记录
			// 合并时间

			for (TimeEntity time : timeList) {
				Date startTime = time.getStartTime();
				Date endTime = time.getEndTime();
				if (mapTime.containsKey(startTime)) {
					ReserveRecordEntity recordEntity = mapTime
							.get(startTime);
					recordEntity.setEndTime(endTime);
					mapTime.put(endTime, recordEntity);
				} else {
					ReserveRecordEntity recordEntity = new ReserveRecordEntity();
					recordEntity.setUserNo(entity.getUserNo());
					recordEntity.setStartTime(time.getStartTime());
					recordEntity.setEndTime(endTime);
					recordEntity.setPlayRoomId(entity
							.getPlayRoomId());
					recordEntity.setSiteMark(entity.getSiteMark());
					if (user != null) {
						recordEntity.setUserName(user.getEmpname());
						recordEntity.setUserphone(user
								.getMobileno());
					}
					mapTime.put(endTime, recordEntity);
					records.add(recordEntity);
				}
			}

			for (ReserveRecordEntity record : records) {
				boolean insert = this.reserveSubmitSerivce
						.addReserveEntity(record);
				if (insert) {
					// --判断 开始时间 是否有可能 略过 定时器 ; 如果略过定时器 则要发送消息通知
					result.setResultFlag(true);
					result.setMessage("预定场地成功！");
					logger.info("预定场地成功! 场地ID:"
							+ entity.getPlayRoomId() + ",预定人工号:"
							+ entity.getUserNo());
				}
			}
		} else {
			logger.info("该时间段已经被预定!不能再次预定!");
			result.setResultFlag(false);
			result.setFailureReason("该场地在该时间段内已经被预定!请选择其它时间玩耍!");
		}
	}



	private boolean checkUserDate(ResultVO<Object> result, int isManager,
			ReserveSubmitEntity entity, List<TimeEntity> timeList, boolean maybe)
			throws ParseException {
		if (timeList.size() > 0) {
			// 所有用户 判断开始时间是否有超时
			if (isTimeOut(timeList) ) {
				// 恩 没有超时的开始时间
				// 继续
				// 要分权限了
				if (isManager == 0) {
					// 普通用户预定规则
					// 1. 0.5h <= M <=2h AND 17:30 - 21:30===>前端定死 --
					// 暂不需要判断
					// 2.该用户预定时间必须在规定时间内 8:00-21:30
					//抽取方法
					maybe = checkFailReason(result, entity, timeList, maybe);
				
				}
			} else {
				logger.info("预定时间已经超过当前时间,请重新选择!");
				result.setResultFlag(false);
				result.setFailureReason("预定开始时间已经超时!");
				maybe = false;
			}
		} else {
			logger.info("没有时间选择参数!");
			result.setResultFlag(false);
			result.setFailureReason("没有时间选择参数!");
			maybe = false;
		}
		return maybe;
	}



	private boolean checkFailReason(ResultVO<Object> result,
			ReserveSubmitEntity entity, List<TimeEntity> timeList, boolean maybe)
			throws ParseException {
		if(checkDate(timeList)) {
			boolean canSubmit = this.isCanSubmitByThisTime();
			if (canSubmit) {
				// 3.该天预定时长不能超过2小时
				boolean canReserve = this.reserveSubmitSerivce
						.canBeReserveList(timeList,
								entity.getUserNo(),
								entity.getSiteMark());
				if (!canReserve) {
					result.setResultFlag(false);
					result.setFailureReason("该天预定总数时间已经超过两小时!请休息下!");
					maybe = false;
				}
			} else {
				result.setResultFlag(false);
				result.setFailureReason("该时间段不能进行场地预定!");
				maybe = false;
			}
			
		}else{
			result.setResultFlag(false);
			result.setFailureReason("嗨！宝贝！这时间段不能预订喲！!");
			maybe = false;
		}
		return maybe;
	}

	private boolean checkIsAdmin(String userNo) {

		HashMap<String, String> paramHashMap = new HashMap<String, String>();
		//员工号
		paramHashMap.put("userNO", userNo);
		//活动管理组
		paramHashMap.put("orgCode", "W01080101");
		//传入当前登录用户的员工号，如果是管理员就返回int类型数值1
		//-- 1: 普通用户
		//-- 2: 超级管理员
		//-- 3: 普通管理员
//		Constants cons = new Constants();
		int retInt = reserveManWorkService.checkIsAdmByOrgCode(paramHashMap);
		if (retInt==2||retInt==Constants.IS_ADMIN) {
			return true;
		} else{
			return false;
		}
		
	}



	/**
	 * 数据监控
	 */
	public void dataMonitorReserve() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		Date startDate = new Date();
		String userNo = getUserId();
		// 判断工号是否为null
		if (StringUtils.isBlank(userNo)) {
			logger.info("预定场地数据监控userNo是null");
		} else {
			Date endDate = new Date();
			// 保存监控
			this.monitorCountInfoService.saveMonitorCountInfo(userNo,
					startDate, endDate, DATA_MONITOR_RESERVE);
		}
		ResultVO<Object> result = new ResultVO<Object>();
		result.setResultFlag(true);
		// 转json格式
		String res = JsonUtil.beanToJsonString(result);
		// 写入数据
		writeToPage(res);
	}
	/**
	 * @Title: checkDate
	 * @Description: 校验时间
	 * @param @param stratDate 开始时间
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */

	public boolean checkDate(List<TimeEntity> list) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar starCa = Calendar.getInstance();
		Calendar endCa = Calendar.getInstance();
		try {
			for (TimeEntity time : list) {
				// 判断时间是否为null

				// 转为字符串日期
				String starDate = sdf.format(time.getStartTime().getTime());

				// 转为字符串日期
				String endDate = sdf.format(date);

				starCa.setTime(sdf.parse(starDate));
				endCa.setTime(sdf.parse(endDate));
				long time2 = starCa.getTimeInMillis();
				long time1 = endCa.getTimeInMillis();
				// 对时间进行判断
				long betweenDays = (time2 - time1)
						/ (com.deppon.dpm.module.common.server.util.Constants.RESERVE_TENHUNDRED
								* com.deppon.dpm.module.common.server.util.Constants.RESERVE_THREESIXHUNDRED * com.deppon.dpm.module.common.server.util.Constants.RESERVE_MEMBER);
				return ((betweenDays > 1) || ((betweenDays < 0)) ? false
						: true);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;

	}
	/**
	 * @param list
	 *            time
	 * @return 判断时间是否超时
	 */
	public boolean isTimeOut(List<TimeEntity> list) {
		// new 一个date
		Date now = new Date();
		// 循环判断
		for (TimeEntity time : list) {

			if (time.getStartTime().getTime() < now.getTime()) {
				return false;
			}

		}
		return true;
	}

	/**
	 * 普通用户提交规则 预定动作 必须在 08:00:00 - 21:30:00 触发
	 * 
	 * @return
	 * @throws ParseException
	 */
	public boolean isCanSubmitByThisTime() throws ParseException {
		// 时间格式转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new 一个新的date
		Date now = new Date();
		String date = DateUtil.getFormatDateTime(now, "yyyy-MM-dd");
		String startStr = date + " 08:00:00";
		String endStr = date + " 21:30:00";
		Date start = sdf.parse(startStr);
		Date end = sdf.parse(endStr);
		// 判断时间是否符合条件
		if (now.getTime() > start.getTime() && now.getTime() < end.getTime()) {
			return true;
		}
		return false;
	}

	/**
	 * 普通用户预定规则 0.5h <= M <= 2h 场地被预定的时间必须是 17:30:00-21:30:00
	 * 
	 * @param entity
	 * @return
	 * @throws ParseException
	 */
	public ResultVO<Object> reserveTimeIsOk(ReserveRecordEntity entity)
			throws ParseException {
		ResultVO<Object> result = new ResultVO<Object>();
		// 得到开始时间
		Long startTime = entity.getStartTime().getTime();
		// 得到结束时间
		Long endTime = entity.getEndTime().getTime();
		// 对时间进行判断
		if (endTime - startTime < Constants.CONSTANT_HALF_HOUR) {
			// 塞入数据
			result.setResultFlag(false);
			result.setFailureReason("预定时间必须在半小时以上!");
			// 返回result
			return result;
		}
		if (endTime - startTime > Constants.CONSTANT_TWO_HOUR) {
			result.setResultFlag(false);
			result.setFailureReason("预定时间必须在两小时以内!");
			return result;
		}
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new 一个date
		Date now = new Date();
		// 转时间格式
		String date = DateUtil.getFormatDateTime(now, "yyyy-MM-dd");
		// 时间算法
		String startStr = date + " 17:30:00";
		// 时间算法
		String endStr = date + " 21:30:00";
		// 时间算法
		Date start = sdf.parse(startStr);
		Date end = sdf.parse(endStr);
		// 判断时间
		if (startTime < start.getTime() || endTime > end.getTime()) {
			result.setResultFlag(false);
			result.setFailureReason("预定时间必须在 17:30:00 - 21:30:00 之间!");
			return result;
		}
		result.setResultFlag(true);
		// 返回结果
		return result;
	}

	/**
	 * @return reserveSubmitSerivce
	 */
	public IReserveSubmitSerivce getReserveSubmitSerivce() {
		return reserveSubmitSerivce;
	}

	/**
	 * @param reserveSubmitSerivce
	 */
	public void setReserveSubmitSerivce(
			IReserveSubmitSerivce reserveSubmitSerivce) {
		this.reserveSubmitSerivce = reserveSubmitSerivce;
	}

	/**
	 * @return userServiceMs
	 */
	public IUserService getUserServiceMs() {
		return userServiceMs;
	}

	/**
	 * @param userServiceMs
	 */
	public void setUserServiceMs(IUserService userServiceMs) {
		this.userServiceMs = userServiceMs;
	}

	/**
	 * @return monitorCountInfoService
	 */
	public IMonitorCountInfoService getMonitorCountInfoService() {
		return monitorCountInfoService;
	}

	/**
	 * @param monitorCountInfoService
	 */
	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}



	public IReserveManWorkService getReserveManWorkService() {
		return reserveManWorkService;
	}



	public void setReserveManWorkService(
			IReserveManWorkService reserveManWorkService) {
		this.reserveManWorkService = reserveManWorkService;
	}

}
