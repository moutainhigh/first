package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import microsoft.exchange.webservices.data.Appointment;
import microsoft.exchange.webservices.data.AppointmentSchema;
import microsoft.exchange.webservices.data.AppointmentType;
import microsoft.exchange.webservices.data.Attendee;
import microsoft.exchange.webservices.data.AttendeeCollection;
import microsoft.exchange.webservices.data.BasePropertySet;
import microsoft.exchange.webservices.data.CalendarFolder;
import microsoft.exchange.webservices.data.CalendarView;
import microsoft.exchange.webservices.data.ConflictResolutionMode;
import microsoft.exchange.webservices.data.DeleteMode;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.FindItemsResults;
import microsoft.exchange.webservices.data.Folder;
import microsoft.exchange.webservices.data.Importance;
import microsoft.exchange.webservices.data.Item;
import microsoft.exchange.webservices.data.ItemId;
import microsoft.exchange.webservices.data.MeetingResponseType;
import microsoft.exchange.webservices.data.MessageBody;
import microsoft.exchange.webservices.data.PropertyDefinition;
import microsoft.exchange.webservices.data.PropertySet;
import microsoft.exchange.webservices.data.SendInvitationsMode;
import microsoft.exchange.webservices.data.SendInvitationsOrCancellationsMode;
import microsoft.exchange.webservices.data.WellKnownFolderName;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.dao.ICalendarDao;
import com.deppon.dpm.module.management.server.service.ICalendarService;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;
import com.deppon.dpm.module.management.shared.domain.Receiver;
import com.deppon.dpm.module.management.shared.domain.ResponseMeeting;
import com.deppon.dpm.module.management.util.CalendarDateUtil;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.module.management.util.DES;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 日程service实现层
 * 
 * @author 245968
 * 
 */
public class CalendarService extends OutlookService implements ICalendarService {
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(CalendarService.class);
	/**
	 * set injection
	 */
	private ICalendarDao calendarDao;
	/**
	 * set injection
	 */
	private ITongxunLuService tongxunLuService;
	/**
	 * 日程信息数组
	 */
	List<CalendarInfo> calList = new ArrayList<CalendarInfo>();
	/**
	 * 工号
	 */
	private String usrId;
	
	/**
	 * set injection
	 * 地址信息
	 */
	private String calendarPlanPath;
	
	/**
	 * esb编码
	 */
	private static final String ESB_CODE = "ESB_DPM2ESB_GET_ARRANGE_DATA";
	
	
	

	// --------------------------增删改业务逻辑--------------------------------
	/**
	 * 创建日程
	 */
	@Override
	@SuppressWarnings("deprecation")
	public void createCalendarInfo(CalendarInfo calendarInfo) {
		// 新建
		calendarDao.createCalendarInfo(calendarInfo);
	}

	/**
	 * 删除日程
	 */
	@Override
	@SuppressWarnings("deprecation")
	public void deleteCalendarInfo(int id) {
		// 根据id删除
		calendarDao.deleteCalendarInfo(id);
	}

	/**
	 * 更新日程
	 */
	@Override
	@SuppressWarnings("deprecation")
	public void updateCalendarInfo(CalendarInfo calendarInfo) {
		// 更新
		calendarDao.updateCalendarInfo(calendarInfo);
	}

	/**
	 * 查询日程
	 */
	@Override
	@SuppressWarnings("deprecation")
	public CalendarInfo find(int id) {
		// 根据id查询
		return calendarDao.find(id);
	}

	// --------------------------查询改业务逻辑--------------------------------
	/**
	 * 查询日程会议信息  返回 会议的详情信息 数量
	 */
	@Override
	public String getCalendarInfos(String userId, String password,
			Date searchdtStart, Date searchdtEnd) {//2019年5月25日星期六00:00:00   2019年5月25日(星期六)23:59:59
		// 结果集定义
		Result<Object> result = new Result<Object>();
	    //参数校验
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			return JSON.toJSONString(result);
		}
		// 获取日程和约会信息
		List<CalendarInfo> calendarInfos = getAppointmentAndCalendar(userId,
				result, searchdtStart, searchdtEnd, password, true);
		// 设置返回信息
		result.setData(calendarInfos);
		// 返回数量
		result.setCount(calendarInfos.size());
		// 返回前端
		return JSON.toJSONString(result);
	}
	/**
	 * 查询日程信息通知
	 */
	@Override
	public List<CalendarInfo>  getNoticeCalendarInfos(String userId, String password,
			Date searchdtStart, Date searchdtEnd) {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		// 获取日程和约会信息
		List<CalendarInfo> calendarInfos = getAppointmentAndCalendar(userId,
				result, searchdtStart, searchdtEnd, password, true);
		
		// 返回前端
		return calendarInfos;
	}
	
	/**
	 * 查询日程信息通知
	 */
	@Override
	public List<CalendarInfo>  getNoticeCalendarInfosOrderByCTime(String userId, String password,
			Date searchdtStart, Date searchdtEnd) {
		// 结果集定义
		Result<Object> result = new Result<Object>();
		// 获取日程和约会信息
		List<CalendarInfo> calendarInfos = getAppointmentAndCalendarOrderByCTime(userId,
				result, searchdtStart, searchdtEnd, password, true);
		
		// 返回前端
		return calendarInfos;
	}

	/**
	 * 查询今天的日程
	 */

	@Override
	public String getCalendarInfosThree(String userId, String password,
			Date searchdtStart, Date searchdtEnd) {
		// 结果集定义
		Result<Object> result = new Result<Object>();

		//List<CalendarSpInfo> calendarThree = new ArrayList<CalendarSpInfo>();
		List<CalendarInfo> calendar = new ArrayList<CalendarInfo>();

		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"HH:mm");
        //参数校验
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			return JSON.toJSONString(result);
		}
		// 获取日程和约会信息
		List<CalendarInfo> calendarInfos = getAppointmentAndCalendar(userId,
				result, searchdtStart, searchdtEnd, password, true);
		for (CalendarInfo calendarInfo : calendarInfos) {
			if(isNow(calendarInfo.getStart())){
			
			calendarInfo.setStoendDate(simpleDateFormat.format(calendarInfo
					.getStart())+ "-"+ simpleDateFormat.format(calendarInfo.getEnd()));
			calendar.add(calendarInfo);
			}
		}

		/*if (null != calendarsp && calendarsp.size() >= 3) {
			for (int i = 0; i < 3; i++) {
				calendarThree.add(calendarsp.get(i));
			}
			result.setData(calendarThree);
			result.setCount(calendarThree.size());
		} else {*/
			// 设置返回信息
			result.setData(calendar);
			// 返回数量
			result.setCount(calendar.size());
		

		// 返回前端
		return JSON.toJSONString(result);
	}

	/**
	 * 获取会议的日期和数量
	 */
	@Override
	public String getCalendarCount(String userId, String password,
			Date searchdtStart, Date searchdtEnd) {//2019年5月01日星期三00:00:00   2019年5月31日星期五23:59:00
		// 结果集定义
		Result<Object> result = new Result<Object>();
        //参数校验
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			return JSON.toJSONString(result);
		}
		// 获取日程和约会信息
		List<CalendarInfo> calendarInfos = getAppointmentAndCalendar(userId,
				result, searchdtStart, searchdtEnd, password, false);
		// 定义dateSet  循环有会议的信息 2019年5月20日星期一00:00:00
		Set<Date> dateSet = new HashSet<Date>();
		for (CalendarInfo calendarInfo : calendarInfos) {
			Date date = CalendarDateUtil.getSdfDate("yyyy-MM-dd",
					calendarInfo.getStart());
			// 时间处理
			dateSet.add(date);
		}
		// 设置返回信息  {Wed May 01 00:00:00 CST 2019=java.lang.Object@66fdf713, Fri May 17 00:00:00 CST 2019=java.lang.Object@66fdf713, Mon May 20 00:00:00 CST 2019=java.lang.Object@66fdf713}
		result.setData(dateSet);
		// 返回数量
		result.setCount(dateSet.size());
		// 返回前端
		return JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 从邮箱读取会议
	 */
	private List<CalendarInfo> readAppointmentFromEmail(String userId,
			Date searchdtStart, Date searchdtEnd, boolean sort) {
		List<CalendarInfo> list = new ArrayList<CalendarInfo>();
		try {
			// 获取exchangeService
			ExchangeService service = getExchangeService(userId);
			CalendarFolder calendarFolder = (CalendarFolder) Folder.bind(
					service, WellKnownFolderName.Calendar);
			CalendarView calendarView = new CalendarView(searchdtStart,
					searchdtEnd);//日历视图
			FindItemsResults<Appointment> apponitments = calendarFolder
					.findAppointments(calendarView);
			PropertySet detailedPropertySet = new PropertySet(
					BasePropertySet.FirstClassProperties);

			List<Boolean> lists = new ArrayList<Boolean>();

			// for 循环判断
			for (Item item : apponitments) {
				if (null == item) {
					lists.add(false);
				} else {
					lists.add(true);
				}
			}
			// 判断list是否包含true
			if (!lists.contains(true)) {
				return list;
			}
			// 得到srvice
			service.loadPropertiesForItems(apponitments, detailedPropertySet);
			// 循环判断
			for (Item item : apponitments) {
				Appointment appointment = (Appointment) item;
				CalendarInfo info = new CalendarInfo();
								
				//获取日程是  重要：High/普通：Normal
				info.setImportance(String.valueOf(appointment.getImportance()));
				info.setAppointmentId(appointment.getId().toString());
				info.setSubject(appointment.getSubject());
				info.setCalendarDate(DateUtils.addHours(
						appointment.getDateTimeReceived(), MagicNumber.NUM8));
				info.setReminderMinutesBeforeStart(String.valueOf(appointment
						.getReminderMinutesBeforeStart()));//开始前几分钟提醒
				info.setStart(DateUtils.addHours(appointment.getStart(),
						MagicNumber.NUM8));
				info.setEnd(DateUtils.addHours(appointment.getEnd(),
						MagicNumber.NUM8));
				info.setLocation(appointment.getLocation());
				info.setContent(appointment.getBody().toString());
				String displayTo = appointment.getDisplayTo();// 必选/发送
				info.setDisplayCc(appointment.getDisplayCc());// 可选/抄送
				if(StringUtil.isEmpty(displayTo)){
					//日程/约会：0
					info.setMeetingType("0");
				}else{
					//会议：1
					info.setMeetingType("1");
				}
				AttendeeCollection requiredAttendees = appointment
						.getRequiredAttendees();
				
				for (Attendee attendee : requiredAttendees) {
					String address = attendee.getAddress();
					String name = attendee.getName();
					//会议响应字段  未响应Unknown 同意Accept 谢绝Decline
					MeetingResponseType buttonJoin = attendee.getResponseType();
					//会议响应的集合列表
					info.getResponseList().add(new ResponseMeeting(name, buttonJoin, address));
					//接收人集合
					info.getReceivers().add(new Receiver(name, address));
				}
				info.setIsFromEmail(1);
				String jsonString = JSON.toJSONString(appointment
						.getOrganizer());//组织者
				String orgnaize = (String) JSON.parseObject(jsonString).get(
						"name");
				String orgnaizeEmail = (String) JSON.parseObject(jsonString)
						.get("address");
				info.setOrgnaizeEmail(orgnaizeEmail);
				info.setSendName(orgnaize);
				info.setDisplayTo(displayTo);
				Date start = appointment.getStart();
				System.out.println(start);
				if (searchdtStart.getTime() <= appointment.getStart().getTime()) {
					list.add(info);
				}

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//

		/**
		 * @author 046130
		 * @since 2015-08-12 插入日程到数据库，进行数据分析
		 */
		if (list.size() > 0 && sort) {
			// 必须给全局变量赋值，否则线程使用不了
			usrId = userId;
			calList = list;
			// 启动线程处理插入数据库
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						EmployeeVO params = new EmployeeVO();
						params.setEmpCode(usrId);
						// 获取当前人员信息
						EmployeeEntity employee = tongxunLuService
								.queryEmployeeByCode(params);
						// 只有级别为8、9、10 且为管理人员才记录日程信息
						if (employee != null
								&& employee.getJobLevel().matches(
										DpmConstants.DPM_IS_NUM)) {
							// 级别
							int jobLevel = Integer.parseInt(employee
									.getJobLevel());
							// 族群
							String jobGroups = employee.getJobGroups();
							// 当前使用人邮箱地址
							String email = employee.getoEmail();
							// 只监控总监级几以上人员

							if ((jobLevel > DpmConstants.MONITOR_LEVEL)
									&& jobGroups
											.equals(DpmConstants.MONITOR_GROUPS)) {
								// 调用DAO，存储数据
								calendarDao.storageCalendarInfo(calList, email);
							}

						}
					} catch (Exception e) {
						// 异常处理
						logger.debug("日程插入失败");
						e.printStackTrace();
					}
				}
			});
			t.start();

		}
		// 返回list
		return list;
	}

	/**
	 * 获取日程和约会信息
	 * 获取约会和日历
	 * @param userId
	 * @param result
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @param password
	 * @param sort
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	private List<CalendarInfo> getAppointmentAndCalendar(String userId,
			Result<Object> result, Date searchdtStart, Date searchdtEnd,
			String password, boolean sort) {
		// 根据工号查询员工信息sql
		String queryEmail = "select * from om_employee where EMPSTATUS = 'on' and empcode = '"
				+ userId + "'";
		// 获取该工号的邮箱
		String email = jdbcTemplate.query(queryEmail,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("oemail");
						}
						return null;
					}
				});
		// 没有企业邮箱，直接读取数据库的日程
		if (StringUtils.isEmpty(email)) {
			// errorMessage
			result.setErrorMessage("该工号没有企业内部邮箱");
			// errorCode
			result.setErrorCode(1);
			// 查询
			return calendarDao.getCalendarInfoFromDb(userId, searchdtStart,
					searchdtEnd);
			// 有企业邮箱
		} else {
			// 传过来的密码不为空
			if (StringUtils.isNotEmpty(password)) {
				// 抽取方法
				checkPassword(userId, result, password, email);
				// 从om_email_conifg中读取访问outlook的密码
			} else if (StringUtils.isEmpty(password)) {
				// 从数据库中查询邮箱密码
				String sql = "select * from om_email_config where user_id ='" + userId
				+ "'";
				// 密码获取
				password = jdbcTemplate.query(sql,
						new ResultSetExtractor<String>() {
							@Override
							public String extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								while (rs.next()) {
									return rs.getString("email_password");
								}
								return null;
							}
						});
				// 查不到邮箱密码，提示输入密码
				if (StringUtils.isEmpty(password)) {
					// errorMessage
					result.setErrorMessage("请输入企业邮箱密码");
					// errorCode
					result.setErrorCode(2);
				}
			}
		}
		// 验证成功，定义返回类型，用以保存查询到的值
		List<CalendarInfo> fromEmail = new ArrayList<CalendarInfo>();
		// 空处理
		if (StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(password)) {
			try {
				// 密码解密
				password = new String(Base64.decodeBase64(DES
						.decryptDES(password)));
				// 获取约会信息
				fromEmail = readAppointmentFromEmail(userId,
						DateUtils.addHours(searchdtStart,
								MagicNumber.NUMNEGATIVE8), DateUtils.addHours(
								searchdtEnd, MagicNumber.NUMNEGATIVE8), sort);
			} catch (Exception e) {
				// 错误打印
				e.printStackTrace();
				// errorCode
				result.setErrorCode(MagicNumber.NUM3);
				// log
				logger.error(e.getMessage());
				// errorMessage
				result.setErrorMessage("验证邮箱失败");
			}
		}
		// 从数据库获取日程信息
		List<CalendarInfo> fromDb = calendarDao.getCalendarInfoFromDb(userId,
				searchdtStart, searchdtEnd);
		// 拼接outlook和db数据   union：并集
		ArrayList<CalendarInfo> calendarInfos = new ArrayList<CalendarInfo>(
				CollectionUtils.union(fromEmail, fromDb));
		// 日程信息时间排序
		// 抽取方法
		checkSort(sort, calendarInfos);
		// 没有错误数据
		if (result.getErrorMessage() == null) {
			// errorMessage
			result.setErrorMessage("查询日程与会议成功");
		}
		// 返回日程信息
		return calendarInfos;
	}
	
	/**
	 * 获取日程和约会信息
	 * 按时间获取约会和日历订单
	 * @param userId
	 * @param result
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @param password
	 * @param sort
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	private List<CalendarInfo> getAppointmentAndCalendarOrderByCTime(String userId,
			Result<Object> result, Date searchdtStart, Date searchdtEnd,
			String password, boolean sort) {
		// 根据工号查询员工信息sql
		String queryEmail = "select * from om_employee where EMPSTATUS = 'on' and empcode = '"
				+ userId + "'";
		// 获取该工号的邮箱
		String email = jdbcTemplate.query(queryEmail,
				new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				while (rs.next()) {
					return rs.getString("oemail");
				}
				return null;
			}
		});
		// 没有企业邮箱，直接读取数据库的日程
		if (StringUtils.isEmpty(email)) {
			// errorMessage
			result.setErrorMessage("该工号没有企业内部邮箱");
			// errorCode
			result.setErrorCode(1);
			// 查询
			return calendarDao.getCalendarInfoFromDb(userId, searchdtStart,
					searchdtEnd);
			// 有企业邮箱
		} else {
			// 传过来的密码不为空
			if (StringUtils.isNotEmpty(password)) {
				// 抽取方法
				checkPassword(userId, result, password, email);
				// 从om_email_conifg中读取访问outlook的密码
			} else if (StringUtils.isEmpty(password)) {
				// 从数据库中查询邮箱密码
				String sql = "select * from om_email_config where user_id ='" + userId
				+ "'";
				// 密码获取
				password = jdbcTemplate.query(sql,
						new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("email_password");
						}
						return null;
					}
				});
				// 查不到邮箱密码，提示输入密码
				if (StringUtils.isEmpty(password)) {
					// errorMessage
					result.setErrorMessage("请输入企业邮箱密码");
					// errorCode
					result.setErrorCode(2);
				}
			}
		}
		// 验证成功，定义返回类型，用以保存查询到的值
		List<CalendarInfo> fromEmail = new ArrayList<CalendarInfo>();
		// 空处理
		if (StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(password)) {
			try {
				// 密码解密
				password = new String(Base64.decodeBase64(DES
						.decryptDES(password)));
				// 获取约会信息
				fromEmail = readAppointmentFromEmail(userId,
						DateUtils.addHours(searchdtStart,
								MagicNumber.NUMNEGATIVE8), DateUtils.addHours(
										searchdtEnd, MagicNumber.NUMNEGATIVE8), sort);
			} catch (Exception e) {
				// 错误打印
				e.printStackTrace();
				// errorCode
				result.setErrorCode(MagicNumber.NUM3);
				// log
				logger.error(e.getMessage());
				// errorMessage
				result.setErrorMessage("验证邮箱失败");
			}
		}
		// 从数据库获取日程信息
		List<CalendarInfo> fromDb = calendarDao.getCalendarInfoFromDb(userId,
				searchdtStart, searchdtEnd);
		// 拼接outlook和db数据
		ArrayList<CalendarInfo> calendarInfos = new ArrayList<CalendarInfo>(
				CollectionUtils.union(fromEmail, fromDb));
		// 日程信息时间排序
		// 抽取方法
		checkSortByCaleandarTime(sort, calendarInfos);
		// 没有错误数据
		if (result.getErrorMessage() == null) {
			// errorMessage
			result.setErrorMessage("查询日程与会议成功");
		}
		// 返回日程信息
		return calendarInfos;
	}

	private void checkSort(boolean sort, ArrayList<CalendarInfo> calendarInfos) {
		if (sort) {
			// 自定义排序
			Collections.sort(calendarInfos, new Comparator<CalendarInfo>() {
				@Override
				public int compare(CalendarInfo info1, CalendarInfo info2) {
					// 按照开始时间进行判断
					long time = info1.getStart().getTime()
							- info2.getStart().getTime();
					// > 0
					if (time > 0)
						return 1;
					else if (time == 0) {
						return 0;
					} else
						return -1;
				}
			});
		}
	}
	private void checkSortByCaleandarTime(boolean sort, ArrayList<CalendarInfo> calendarInfos) {
		if (sort) {
			// 自定义排序
			Collections.sort(calendarInfos, new Comparator<CalendarInfo>() {
				@Override
				public int compare(CalendarInfo info1, CalendarInfo info2) {
					// 按照开始时间进行判断
					long time = info1.getCalendarDate().getTime()
							- info2.getCalendarDate().getTime();
					// > 0
					if (time > 0)
						return 1;
					else if (time == 0) {
						return 0;
					} else
						return -1;
				}
			});
		}
	}

	private void checkPassword(String userId, Result<Object> result,
			String password, String email) {
		// 用户名密码验证是否正确
		boolean flag = validatePassword(password, email);
		// 验证错误
		if (!flag) {
			// errorCode
			result.setErrorCode(MagicNumber.NUM3);
			// errorMessage
			result.setErrorMessage("验证邮箱失败");
		} else {
			// 先查询
			String select = "select count(1) from om_email_config where user_id ='" + userId
				+ "'";
			// 查询对应的密码
			int ret = jdbcTemplate.queryForInt(select);
			// // 存在记录，则更新密码
			if (ret > 0) {
				// 更新sql
				String update = "update om_email_config set email_password = ? where user_id = ?";
				// 更新数据库
				jdbcTemplate.update(update, new Object[] { password, userId },
						new int[] { Types.VARCHAR, Types.VARCHAR });
				// 不存在记录，则新增记录
			} else {
				// 插入sql
				String insert = "insert into om_email_config values(?,?,?)";
				// 数据库插入
				jdbcTemplate.update(insert, new Object[] { userId, password,
						new Date() }, new int[] { Types.VARCHAR, Types.VARCHAR,
						Types.TIMESTAMP });
			}
		}
	}

	/**
	 * 创建会议
	 */
	public Result<Object> createAppointMent(String userId, CalendarInfo info) {
		Result<Object> result = new Result<Object>();
		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			Appointment appointment = new Appointment(service);
			// set 数据
			appointment.setSubject(info.getSubject());
			// set 数据
			appointment.setBody(new MessageBody(info.getContent()));
			// set 数据
			appointment.setIsAllDayEvent(false);
			// set 数据
			appointment.setStart(DateUtils.addHours(info.getStart(),
					MagicNumber.NUMNEGATIVE8));
			// set 数据
			appointment.setEnd(DateUtils.addHours(info.getEnd(),
					MagicNumber.NUMNEGATIVE8));
			// set 数据
			appointment.setLocation(info.getLocation());
			appointment.setReminderMinutesBeforeStart(Integer.parseInt(info
					.getReminderMinutesBeforeStart()));
			String sendTo = info.getSendTo();
			StringTokenizer tokenizer = new StringTokenizer(sendTo, ",");
			while (tokenizer.hasMoreElements()) {
				String email = (String) tokenizer.nextElement();
				if (StringUtils.isNotEmpty(email)) {
					appointment.getRequiredAttendees().add(email);
				}
			}
			// 保存数据
			appointment.save(SendInvitationsMode.SendToAllAndSaveCopy);
			result.setResult("创建会议成功");
			result.setData("创建会议成功");
			// errorMessage
			result.setErrorMessage("创建会议成功");
		} catch (Exception e) {
			// 提示信息
			result.setData("创建失败");
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage(e.getMessage());
		}

		// 返回结果集
		return result;
	}
	
	/**
	 * 创建会议 区分日程和会议
	 */
	public Result<Object> createAppointMeeting(String userId, CalendarInfo info, String meetingType) {
		Result<Object> result = new Result<Object>();
		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			Appointment appointment = new Appointment(service);
			
			//创建日程  -- 使用
			String importance = info.getImportance();
			// 发送人 -- 与会者
			String sendTo = info.getSendTo();
			if(!"".equals(meetingType) && "1".equals(meetingType)){
				//创建会议时  与会者不能为空
				if(StringUtil.isNotEmpty(sendTo)){
					// set 数据  -- 主题
					appointment.setSubject(info.getSubject());
					// set 数据 -- 内容
					appointment.setBody(new MessageBody(info.getContent()));
					// set 数据 -- 是否全天事件
					appointment.setIsAllDayEvent(false);
					// set 数据 -- 开始时间
					appointment.setStart(DateUtils.addHours(info.getStart(),
							MagicNumber.NUMNEGATIVE8));
					// set 数据 -- 结束时间
					appointment.setEnd(DateUtils.addHours(info.getEnd(),
							MagicNumber.NUMNEGATIVE8));
					// set 数据 -- 地址
					appointment.setLocation(info.getLocation());
					// 提醒时间
					appointment.setReminderMinutesBeforeStart(Integer.parseInt(info
							.getReminderMinutesBeforeStart()));
					
					StringTokenizer tokenizer = new StringTokenizer(sendTo, ",");
					while (tokenizer.hasMoreElements()) {
						String email = (String) tokenizer.nextElement();
						if (StringUtils.isNotEmpty(email)) {
							appointment.getRequiredAttendees().add(email);
						}
					}
					// 保存数据
					appointment.save(SendInvitationsMode.SendToAllAndSaveCopy);
					result.setResult("创建会议成功");
					result.setData("创建会议成功");
					// errorMessage
					result.setErrorMessage("创建会议成功");
					
				}else{
					result.setResult("无法创建该会议，与会人不能为空！");
					result.setData("创建会议失败！");
					// errorMessage
					result.setErrorMessage("创建会议失败！");
				}
			}else if(!"".equals(meetingType) && "0".equals(meetingType)){
				// set 数据  -- 主题
				appointment.setSubject(info.getSubject());
				// set 数据 -- 内容
				appointment.setBody(new MessageBody(info.getContent()));
				// set 数据 -- 是否全天事件
				appointment.setIsAllDayEvent(false);
				// set 数据 -- 开始时间
				appointment.setStart(DateUtils.addHours(info.getStart(),
						MagicNumber.NUMNEGATIVE8));
				// set 数据 -- 结束时间
				appointment.setEnd(DateUtils.addHours(info.getEnd(),
						MagicNumber.NUMNEGATIVE8));
				// set 数据 -- 地址
				appointment.setLocation(info.getLocation());
				// 判断日程 普通和重要性
				if(!"".equals(importance) && "Normal".equals(importance)){
					//普通约会
					appointment.setImportance(Importance.Normal);
				}else if(!"".equals(importance) && "High".equals(importance)){
					//重要约会
					appointment.setImportance(Importance.High);
				}
				// 提醒时间
				appointment.setReminderMinutesBeforeStart(Integer.parseInt(info
						.getReminderMinutesBeforeStart()));
				// 创建日程 没有 发送人 -- 与会者
				/*StringTokenizer tokenizer = new StringTokenizer(sendTo, ",");
				while (tokenizer.hasMoreElements()) {
					String email = (String) tokenizer.nextElement();
					if (StringUtils.isNotEmpty(email)) {
						appointment.getRequiredAttendees().add(email);
					}
				}*/
				// 保存数据
				appointment.save(SendInvitationsMode.SendToAllAndSaveCopy);
				result.setResult("创建日程成功");
				result.setData("创建日程成功");
				// errorMessage
				result.setErrorMessage("创建日程成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// 提示信息
			result.setData("创建失败");
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage(e.getMessage());
		}

		// 返回结果集
		return result;
	}

	/**
	 * 取消会议
	 */
	@Override
	public void cancelAppointment(String userId, String appointmentId) {
		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			ItemId itemId = new ItemId(appointmentId);
			Item item = null;
			item = Item.bind(service, itemId);
			// 判断item
			if (item instanceof Appointment) {
				Appointment appointment = (Appointment) item;
				// 执行删除语句
				appointment.delete(DeleteMode.HardDelete);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 参加会议
	 */
	@Override
	public void createAccept(String userId, String appointmentId) {
		// TODO Auto-generated method stub
		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			ItemId itemId = new ItemId(appointmentId);
			Item item = null;
			item = Item.bind(service, itemId);
			// 判断item
			if (item instanceof Appointment) {
				Appointment appointment = (Appointment) item;
				// 执行 同意参加会议 操作
				//true:接受会议 并且将响应发送给会议组织者
				//false:接受会议 但不向会议组织者发送响应
				appointment.accept(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拒绝参加会议
	 */
	@Override
	public void createDecline(String userId, String appointmentId) {
		// TODO Auto-generated method stub
		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			ItemId itemId = new ItemId(appointmentId);
			Item item = null;
			item = Item.bind(service, itemId);
			// 判断item
			if (item instanceof Appointment) {
				Appointment appointment = (Appointment) item;
				// 执行 拒绝参加会议 操作
				//true:拒绝会议 并且将响应发送给会议组织者
				//false:拒绝会议 但不向会议组织者发送响应
				//发送自定义的拒绝响应：appointment.createDeclineMessage();
//				DeclineMeetingInvitationMessage decline = appointment.createDeclineMessage();
				appointment.decline(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 暂定会议
	 * 暂时不用该接口
	 */
	@Override
	public void createAcceptTentative(String userId, String appointmentId) {
		// TODO Auto-generated method stub
		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			ItemId itemId = new ItemId(appointmentId);
			Item item = null;
			item = Item.bind(service, itemId);
			// 判断item
			if (item instanceof Appointment) {
				Appointment appointment = (Appointment) item;
				// 执行 参加会议 操作
				//true:暂定会议 并且将响应发送给会议组织者
				//false:暂定会议 但不向会议组织者发送响应
				appointment.acceptTentatively(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新会议
	 */
	public void updateAppointment(String userId, CalendarInfo info) {

		try {
			// 得到ExchangeService
			ExchangeService service = getExchangeService(userId);
			// new 一个新的对象
			ItemId itemId = new ItemId(info.getAppointmentId());
			// bind 执行
			Item item = Item.bind(service, itemId);
			// 判断item
			if (item instanceof Appointment) {
				// new 一个新的appointment
				Appointment appointment = (Appointment) item;
				// set 数据
				appointment.setSubject(info.getSubject());
				// set 数据
				appointment.setBody(new MessageBody(info.getContent()));
				// set 数据
				appointment.setStart(DateUtils.addHours(info.getStart(),
						MagicNumber.NUMNEGATIVE8));
				// set 数据
				appointment.setEnd(DateUtils.addHours(info.getEnd(),
						MagicNumber.NUMNEGATIVE8));
				// set 数据
				appointment.setLocation(info.getLocation());
				String sendTo = info.getSendTo();
				StringTokenizer tokenizer = new StringTokenizer(sendTo, ",");
				// while 判断
				while (tokenizer.hasMoreElements()) {
					String email = (String) tokenizer.nextElement();
					// 判断email是否为null
					if (StringUtils.isNotEmpty(email)) {
						appointment.getRequiredAttendees().add(email);
					}
				}
				// 更新数据
				appointment
						.update(ConflictResolutionMode.AlwaysOverwrite,
								SendInvitationsOrCancellationsMode.SendToAllAndSaveCopy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 判断时间是不是今天
	 * 
	 * @param date
	 * @return 是返回true，不是返回false
	 */
	@SuppressWarnings("unused")
	private static boolean isNow(Date date) {
		// 当前时间
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		// 获取今天的日期
		String nowDay = sf.format(now);

		// 对比的时间
		String day = sf.format(date);

		return day.equals(nowDay);

	}
	
	/**
	 * 获取日程排班信息
	 * @param map
	 * @return
	 */
	public String getCalendarPlan(Map<String, String> map){
		
		String data = "";
		try {
			data = HttpUtil.httpClient(JsonUtil.mapToJsonObject(map),
					calendarPlanPath, ESB_CODE);
			logger.info("获取日程排班：calendarPlanPath=" + calendarPlanPath +" map=" + map + " data=" + data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("获取日程排班：calendarPlanPath=" + calendarPlanPath + " e=" + e);
		}
		
		return data;
	}
	
	

	public String getCalendarPlanPath() {
		return calendarPlanPath;
	}

	public void setCalendarPlanPath(String calendarPlanPath) {
		this.calendarPlanPath = calendarPlanPath;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<CalendarInfo> getCalList() {
		return calList;
	}

	/**
	 * set
	 * 
	 * @param calList
	 */
	public void setCalList(List<CalendarInfo> calList) {
		this.calList = calList;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUsrId() {
		return usrId;
	}

	/**
	 * set
	 * 
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ITongxunLuService getTongxunLuService() {
		return tongxunLuService;
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
	 * set
	 * 
	 * @param calendarDao
	 */
	public void setCalendarDao(ICalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}

}