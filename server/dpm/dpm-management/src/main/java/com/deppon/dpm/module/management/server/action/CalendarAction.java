package com.deppon.dpm.module.management.server.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.WhetherMonitorCutffPoint;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.ICalendarService;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;
import com.deppon.dpm.module.management.util.CalendarDateUtil;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 日程
 * 
 * @author 245968
 * 
 */
public class CalendarAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9659283775248775L;
	/**
	 * log
	 */
	private static final Logger logger = Logger.getLogger(CalendarAction.class);

	/**
	 * 日程缓存14天
	 */
	private static final int ADDDAY_14 = 14;

	/**
	 * 日程缓存天数
	 */
	private String calendarDay;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 查询开始时间
	 */
	private Date searchdtStart;
	/**
	 * 查询结束时间
	 */
	private Date searchdtEnd;
	/**
	 * version==0 是老版本的日程，存放在我们的数据库中。<br>
	 * version==1是直接操作exchange server
	 */
	private int version;
	/**
	 * 会议id
	 */
	private String appointmentId;
	/**
	 * 时间
	 */
	private Date ymd;
	/**
	 * 前端传递的日程实体
	 */
	private CalendarInfo calendarInfo;
	/**
	 * set injection
	 */
	private ICalendarService calendarService;
	/**
	 * set injection
	 */
	private ITongxunLuService tongxunLuService;
	/**
	 * 区分 日程 和 会议 的参数
	 */
	private String meetingType;
	
	//以下两个字段没有使用，建议删除，连带着set/get方法
	/**
	 * set注入it终端查询地址
	 */
	//private String itQueryUrl;
	/**
	 * set注入pushUrl
	 */
	//private String pushUrl;

	// --------------------------------
	/**
	 * 创建会议同步到exchange server 新增加指派任务的级别限制
	 */
	@WhetherMonitorCutffPoint
	public void create() {
		// 结果集的定义
		Result<Object> result = new Result<Object>();
		// 获取主题,用于指派任务的等级判断
		String subject = calendarInfo.getSubject();
		// 发件人的等级和职位，收件人的等级和职位
		int sendGroups = 0, sendLevel = 0, receiveGroups = 0, receiveLevel = 0;
		// 获取收件人
		String sendTo = calendarInfo.getSendTo();
		// 收件人分离
		String[] splits = sendTo.split(",");
		// 查询条件
		EmployeeVO sendVo = new EmployeeVO();
		// 设置工号条件
		sendVo.setEmpCode(userId);
		// 查询结果
		List<EmployeeVO> sendEmp = tongxunLuService.searchEmp(sendVo, start,
				limit);
		// 用以条件查询
		EmployeeVO receiveVo = null;
		// 用以判断
		List<EmployeeVO> receiveEmp = null;
		// 截取主题
		if ("指派任务".equals(subject.substring(0, subject.indexOf(":")))) {
			// 发件人族群不为空
			if (!"".equals(sendEmp.get(0).getJobGroups())) {
				// 获取族群信息
				sendGroups = Integer.parseInt(sendEmp.get(0).getJobGroups());
			}
			// 发件人等级不为空
			if (!"".equals(sendEmp.get(0).getJobLevel())) {
				// 收件人等级
				sendLevel = Integer.parseInt(sendEmp.get(0).getJobLevel());
			}
			// 发件人工号
			calendarInfo.setSendName(userId);
			// 收件人列表，用以判断是不是越级指派
			for (String spilt : splits) {
				// 条件查询初始化
				receiveVo = new EmployeeVO();
				// 设置查询条件
				receiveVo.setEmailUserName(spilt);
				// 查询
				receiveEmp = tongxunLuService
						.searchEmp(receiveVo, start, limit);
				// 查询的等级不为空
				if (!"".equals(receiveEmp.get(0).getJobLevel())) {
					// 获取等级
					receiveLevel = Integer.parseInt(receiveEmp.get(0)
							.getJobLevel());
				}
				// 查询的族群不为空
				if (!"".equals(receiveEmp.get(0).getJobGroups())) {
					// 获取族群
					receiveGroups = Integer.parseInt(receiveEmp.get(0)
							.getJobGroups());
				}
				// 如果接收人的族群大于发送人的族群
				if (receiveGroups > sendGroups) {
					// errorCode
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
					result.setErrorMessage("选择的人中存在管理层");
					// 提示信息
					result.setData("创建失败");
					// log
					logger.info(JSON.toJSONString(result));
					// 返回前端
					writeToPage(result);
					// 跳出
					return;
				}
				// 如果接收人的族群不大于发送人的族群
				if (receiveGroups <= sendGroups) {
					// 族群相等并且等级偏低
					if (receiveGroups == sendGroups && receiveLevel > sendLevel) {
						// errorCode
						result.setErrorCode(Constants.ACTION_RESULT_ERROR);
						// errorMessage
						result.setErrorMessage("选择的人中存在等级大于你的人");
						// 提示信息
						result.setData("创建失败");
						// log
						logger.info(JSON.toJSONString(result));
						// 前端打印
						writeToPage(result);
						// 返回
						return;
					}
				}
			}
		}
		try {
			// 老版本
			if (version == 0) {
				// 存储数据库
				calendarService.createCalendarInfo(calendarInfo);
				// 新版本
			} else if (version == 1) {
				// 同步outLook
				result = calendarService
						.createAppointMent(userId, calendarInfo);
			}
		} catch (Exception e) {
			// 提示信息
			result.setData("创建失败");
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage(e.getMessage());
		}
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 创建会议同步到exchange 
	 * meetingType==0  日程
	 * meetingType==1  会议
	 */
	@WhetherMonitorCutffPoint
	public void createMeeting() {
		// 结果集的定义
		Result<Object> result = new Result<Object>();
		
		try {
			if(!"".equals(meetingType) && "0".equals(meetingType)){
				// 同步outLook 创建日程
				result = calendarService.createAppointMeeting(userId, calendarInfo, meetingType);
				
			}else if(!"".equals(meetingType) && "1".equals(meetingType)){
				// 同步outLook 创建会议
				result = calendarService.createAppointMeeting(userId, calendarInfo, meetingType);
			}else{
				// 同步outLook 创建其他
				result = calendarService.createAppointMent(userId, calendarInfo);
			}
		} catch (Exception e) {
			// 提示信息
			result.setData("创建失败");
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage(e.getMessage());
		}
		// 前端返回
		writeToPage(result);
	}
	
	@Deprecated
	public void find() {
		// 查询
		CalendarInfo info = calendarService.find(calendarInfo.getId());
		// 结果集
		Result<Object> result = new Result<Object>();
		// 设置
		result.setData(info);
		// 返回
		writeToPage(result);
	}

	/**
	 * 获取会议列表 前端定时请求，这里新增it服务台的小红点
	 */
	@WhetherMonitorCutffPoint
	public void search() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		// 传入时间
		if (ymd != null) {
			// 查询开始时间
			searchdtStart = CalendarDateUtil.getSdfDate("yyyy-MM-dd", ymd);
			// 默认14天缓存
			int day = ADDDAY_14;
			if (StringUtils.isNotEmpty(calendarDay)
					&& calendarDay.matches("^[0-9]*$")) {
				day = Integer.valueOf(calendarDay);
			}
			String time = CalendarDateUtil.addDay(ymd, day);
			// 查询结束时间
			searchdtEnd = CalendarDateUtil.convertStringToDate("yyyy-MM-dd",
					time);
		}
		// 结束时间大于开始时间
		if (searchdtEnd.getTime() <= searchdtStart.getTime()) {
			// errorCode
			result.setErrorCode(MagicNumber.NUM4);
			// 提示信息
			result.setErrorMessage("时间起始结束时间不正确");
			// 返回移动端
			writeToPage(result);
			// 跳出
			return;
		}
		// 获取指定时间内的日程信息
		String message = calendarService.getCalendarInfos(userId, password,
				searchdtStart, searchdtEnd);
		/*try {
			// 查询参数
			QueryTheaterInfoRequset qr = new QueryTheaterInfoRequset();
			// 工号
			qr.setDealUserCode(userId);
			// 开始值
			qr.setStart(0);
			// 条数
			qr.setLimit(1);
			// 查询类型
			qr.setTaskType(1);
			// 请求地址
//			String url = "http://lms.deppon.com.cn:9901/itsm/services/app/queryTheaterInfo";
			String url = itQueryUrl;
			// POST请求获取数据
			String responseStr = HttpUtil.postHttp(url, JSON.toJSONString(qr),
					"utf-8");
			// jsonStr-->jsonObject-->jsonArr
			JSONArray jsonArray = JSONObject.parseObject(responseStr)
					.getJSONArray("orderWrappers");
			// arr不为空
			if (null != jsonArray && jsonArray.size() > 0) {
				// map缓存中获取上一次最新的上报的时间
				Object it = DpmCacheManager.getIt(userId);
				// 获取上报详情
				TheaterOrderWrappers first = jsonArray.getObject(0,
						TheaterOrderWrappers.class);
				// it不为空
				if (null != it) {
					// 判断时间是不是相同，不相同推送小红点
					if (!it.equals(first.getReporterTime())) {
						// 推送地址
//						String push = "https://dpm.deppon.com:8881/dpm/dpm/tpush_pushMessage.action";
						String push = pushUrl+"dpm/tpush_pushMessage.action";
						// 推送参数
						String params = "pushUserId=" + userId
								+ "&taskId=3&type=4&isTextNews=1&isActive=0";
						// 显示小红点
						HttpUtil.getHttp(push, params, "utf-8");
						// 将新的时间存进去
						DpmCacheManager.setIt(userId, first.getReporterTime());
						// log
						logger.info("推送成功");
					}
				} else {
					// 为空存储上次信息
					DpmCacheManager.setIt(userId, first.getReporterTime());
				}
			}
		} catch (Exception e) {
			// log
			logger.error("IT推送出现错误", e);
		}*/
		// 前端返回
		writeToPage(message);
	}
	
	
	/**
	 * 首页设置中--添加会议 获取会议列表 前端定时请求，这里新增it服务台的小红点
	 */
	@WhetherMonitorCutffPoint
	public void searchThree() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		// 传入时间 当天时间的第二天 2019年5月24日星期六00:00:00
		if (ymd != null) {
			// 查询开始时间
			searchdtStart = CalendarDateUtil.getSdfDate("yyyy-MM-dd", ymd);
			// 默认14天缓存
			int day = ADDDAY_14;
			if (StringUtils.isNotEmpty(calendarDay)
					&& calendarDay.matches("^[0-9]*$")) {
				day = Integer.valueOf(calendarDay);
			}
			String time = CalendarDateUtil.addDay(ymd, day);//获取当前时间之后的第14天后日期：2019-06-07
			// 查询结束时间    转成date 2019年6月7日星期六00:00:00
			searchdtEnd = CalendarDateUtil.convertStringToDate("yyyy-MM-dd",
					time);
		}
		// 结束时间大于开始时间
		if (searchdtEnd.getTime() <= searchdtStart.getTime()) {
			// errorCode
			result.setErrorCode(MagicNumber.NUM4);
			// 提示信息
			result.setErrorMessage("时间起始结束时间不正确");
			// 返回移动端
			writeToPage(result);
			// 跳出
			return;
		}
		// 获取指定时间内的日程信息
		String message = calendarService.getCalendarInfosThree(userId, password,
				searchdtStart, searchdtEnd);
		
		// 前端返回
		writeToPage(message);
	}

	/**
	 * 获取会议的数量和日期
	 */
	public void selectCount() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		// 传入时间
		if (ymd != null) {
			// 查询开始时间
			searchdtStart = CalendarDateUtil.getCurrentMonthStartTime(ymd);
			// 查询结束时间
			searchdtEnd = CalendarDateUtil.getCurrentMonthEndTime(ymd);
		}
		// 结束时间大于开始时间
		if (searchdtEnd.getTime() <= searchdtStart.getTime()) {
			// errorCode
			result.setErrorCode(MagicNumber.NUM4);
			// errorMessage
			result.setErrorMessage("时间起始结束时间不正确");
			// 结果返回
			writeToPage(result);
			// 跳出
			return;
		}
		// 获取信息{"count":3,"data":["2019-05-01 00:00:00","2019-05-17 00:00:00","2019-05-20 00:00:00"],"errorCode":0,"errorMessage":"查询日程与会议成功"}
		String message = calendarService.getCalendarCount(userId, password,
				searchdtStart, searchdtEnd);
		// 前端返回
		writeToPage(message);
	}

	/**
	 * 根据会议的appointmentId取消自己创建的会议
	 */
	public void delete() {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		
		try {
			// 老版本
			if (version == 0) {
				
				//操作校验
				CalendarInfo cal = calendarService.find(calendarInfo.getId());
				if(!cal.getSendEmpId().equals(userId)){
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					   // errorMessage
					   result.setErrorMessage("非发件人，无法取消");
					   writeToPage(result);
					   return;
				}
				// 直接删除数据库中的约会信息
				calendarService.deleteCalendarInfo(calendarInfo.getId());
			} else if (version == 1) {
				// 取消约会
				if(ParamUtils.checkUserId(userId)){
					   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					   // errorMessage
					   result.setErrorMessage("工号错误，不符合规范");
					   writeToPage(result);
					   return;
					  }
				calendarService.cancelAppointment(userId, appointmentId);
			}
			// 提示信息
			result.setData("删除成功");
			// result
			result.setResult("删除成功");
			// errorMessage
			result.setErrorMessage("删除成功");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setData("删除失败");
			// result
			result.setResult("删除失败");
			// errorMessage
			result.setErrorMessage("删除失败");
		}
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 更新会议
	 */
	public void update() {
		// 结果集定义
		Result<Object> result = new Result<Object>();	

		try {
			// 老版本
			if (version == 0) {
				//操作校验
				CalendarInfo cal = calendarService.find(calendarInfo.getId());
				if(!cal.getSendEmpId().equals(userId)){
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
					result.setErrorMessage("非发件人，无法更新");
					writeToPage(result);
					return;
				}
				// 更新约会
				calendarService.updateCalendarInfo(calendarInfo);
			} else if (version == 1) {
				
				//操作校验
				CalendarInfo cal = calendarService.find(calendarInfo.getId());
				if(cal.getSendEmpId() != null && !cal.getSendEmpId().equals(userId)){
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
					result.setErrorMessage("非发件人，无法更新");
					writeToPage(result);
					return;
				}
				// 更新outlook上面约会
				if(ParamUtils.checkUserId(userId)){
					   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					   // errorMessage
					   result.setErrorMessage("工号错误，不符合规范");
					   writeToPage(result);
					   return;
					  }
				calendarService.updateAppointment(userId, calendarInfo);
			}
			// 提示信息
			result.setData("更新成功");
			// errorMessage
			result.setErrorMessage("更新成功");
			// result
			result.setResult("更新成功");
		} catch (Exception e) {
			result.setErrorCode(1);
			// 提示信息
			result.setData("更新失败");
			// result
			result.setResult("更新失败");
			// errorMessage
			result.setErrorMessage("更新失败");
		}
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 日程会议 -不参与 接口
	 */
	public void createRefuse(){
		// 结果集定义
		Result<Object> result = new Result<Object>();
		
		try {
			// 不参与 会议
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
				calendarService.createDecline(userId, appointmentId);
				//errorCode:0表示成
				result.setErrorCode(0);
				// 提示信息
				result.setData("不参加会议");
				// result
				result.setResult("不参加会议");
				// errorMessage
				result.setErrorMessage("不参加会议");
			
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setData("不参加会议失败");
			// result
			result.setResult("不参加会议失败");
			// errorMessage
			result.setErrorMessage("不参加会议失败");
		}
		// 前端返回
		writeToPage(result);
	}
	
	/**
	 * 日程会议 -参与 接口
	 */
	public void createAccept(){
		// 结果集定义
		Result<Object> result = new Result<Object>();
		
		try {
			// 参与 会议
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			calendarService.createAccept(userId, appointmentId);
			// 提示信息
			result.setData("参加会议");
			result.setErrorCode(0);
			// result
			result.setResult("参加会议");
			// errorMessage
			result.setErrorMessage("参加会议");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setData("参加会议失败");
			// result
			result.setResult("参加会议失败");
			// errorMessage
			result.setErrorMessage("参加会议失败");
		}
		// 前端返回
		writeToPage(result);
	}
	
	/**
	 * 日程会议 -暂定 不发送响应 接口
	 * 暂时不用 该接口
	 */
	public void createAcceptTentative(){
		// 结果集定义
		Result<Object> result = new Result<Object>();
		
		try {
			// 暂定 会议
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			calendarService.createAcceptTentative(userId, appointmentId);
			// 提示信息
			result.setData("暂定会议");
			result.setErrorCode(0);
			// result
			result.setResult("暂定会议");
			// errorMessage
			result.setErrorMessage("暂定会议");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// 提示信息
			result.setData("暂定会议失败");
			// result
			result.setResult("暂定会议失败");
			// errorMessage
			result.setErrorMessage("暂定会议失败");
		}
		// 前端返回
		writeToPage(result);
	}
	
	/**
	 * 保存或更新邮箱密码
	 */
	public void dpmEmail() {
		//参数校验
		if(ParamUtils.checkUserId(userId)){
			Result<Object> result = new Result<Object>();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
		}
		// 返回前端
		writeToPage(calendarService.insertOrUpdateEmail(userId, password));
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getYmd() {
		return ymd;
	}

	/**
	 * set
	 * 
	 * @param ymd
	 */
	public void setYmd(Date ymd) {
		this.ymd = ymd;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * set
	 * 
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppointmentId() {
		return appointmentId;
	}

	/**
	 * set
	 * 
	 * @param appointmentId
	 */
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * set
	 * 
	 * @param tongxunLuService
	 */
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getSearchdtStart() {
		return searchdtStart;
	}

	/**
	 * set
	 * 
	 * @param searchdtStart
	 */
	public void setSearchdtStart(Date searchdtStart) {
		this.searchdtStart = searchdtStart;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getSearchdtEnd() {
		return searchdtEnd;
	}

	/**
	 * set
	 * 
	 * @param searchdtEnd
	 */
	public void setSearchdtEnd(Date searchdtEnd) {
		this.searchdtEnd = searchdtEnd;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public CalendarInfo getCalendarInfo() {
		return calendarInfo;
	}

	/**
	 * set
	 * 
	 * @param calendarInfo
	 */
	public void setCalendarInfo(CalendarInfo calendarInfo) {
		this.calendarInfo = calendarInfo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ICalendarService getCalendarService() {
		return calendarService;
	}

	/**
	 * set
	 * 
	 * @param calendarService
	 */
	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCalendarDay() {
		return calendarDay;
	}

	/**
	 * set
	 * 
	 * @param calendarDay
	 */
	public void setCalendarDay(String calendarDay) {
		this.calendarDay = calendarDay;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	
//	/**
//	 * set
//	 * @param itQueryUrl
//	 */
//	public void setItQueryUrl(String itQueryUrl) {
//		this.itQueryUrl = itQueryUrl;
//	}
//
//	/**
//	 * set
//	 * @param pushUrl
//	 */
//	public void setPushUrl(String pushUrl) {
//		this.pushUrl = pushUrl;
//	}

}
