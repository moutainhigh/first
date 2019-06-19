package com.deppon.dpm.doc.server.action;
//create by limh
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IAttendMeetingService;
import com.deppon.dpm.doc.server.service.IDidiOrderService;
import com.deppon.dpm.doc.server.vo.MeetingResultVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.management.server.service.ICalendarService;
import com.deppon.dpm.module.management.util.CalendarDateUtil;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * @className:AttendMeetingAction
 * @author lvdfs-2----------
 * @date 2018年3月3日09:46:44
 * @Desciption:TODO(参加会议Action)
 */
public class AttendMeetingAction extends BaseAction {

	private static final long serialVersionUID = 6190822442686272783L;

	// 参加会议service
	private IAttendMeetingService attendMeetingService;

	// 日程日期
	private String date;

	// 员工号
	private String userId;

	// 日程接口sdfsdf
	private ICalendarService calendarService;
	
	private IDidiOrderService didiOrderService;
	private static final Logger logger = LoggerFactory.getLogger(ChoosePersonAction.class);
	public static final int tomorrowday = 2;

	/**
	 * 根据工号,日期查询日程
	 * 
	 * @author lvdf
	 * @throws ParseException
	 * @date 2018年3月3日13:48:37
	 */
	@SuppressWarnings("rawtypes")
	public void querySchedule() {
		logger.info("参加会议querySchedule()开始-------------");
		JSONObject jonum = new JSONObject();
		try{
		if (StringUtils.isNotEmpty(userId)) {
			// 字符串类型日期转换成Date
			
			// 查询开始时间
			Date aa = new Date();
			Date searchdtStart = CalendarDateUtil.getSdfDate("yyyy-MM-dd", aa);
			// 默认14天缓存
			int day = 1;
			String time = CalendarDateUtil.addDay(aa, day);
			// 查询结束时间
			Date searchdtEnd = CalendarDateUtil.convertStringToDate("yyyy-MM-dd",
					time);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ufdate = sdf.format(System.currentTimeMillis());
			String currdatestring = ufdate.substring(0, 10);
			logger.info("调用日程接口-------------");
			String calenderInfos = calendarService.getCalendarInfos(userId, "",searchdtStart, searchdtEnd);
			logger.info("调用日程接口-----"+userId+"--------");
			logger.info("日程接口信息-------------",calenderInfos);
			List<MeetingResultVO> meetingvoList = new ArrayList<MeetingResultVO>();
			Map jsonmap = (Map) JSONObject.parse(calenderInfos);
			if(jsonmap != null){
				logger.info("解析日程-------------",jsonmap);
				JSONArray dataArray = (JSONArray) jsonmap.get("data");
				logger.info("获得日程信息-------------",dataArray);
				for(int i = 0; i < dataArray.size(); i++){
					String subjecti = ((JSONObject)dataArray.get(i)).getString("subject");//會議類型，名稱
					if(!(subjecti.contains("会议") || subjecti.contains("例会") || subjecti.contains("汇报") || 
							subjecti.contains("研讨") || subjecti.contains("讨论") || subjecti.contains("访谈"))){//subjecti.indexOf(":")
						continue;
					}
					/*
					 * 調用接口
					 * 1根據時間和會議名稱查詢訂單信息
					 * 2如果同一時間包含兩次會議名稱的訂單,則不返回該會議名稱
					 * 
					 */
					String meetingname = subjecti.substring(subjecti.indexOf(":")+1,subjecti.length());//會議名稱
					logger.info("根据会议名称和日期返回订单数据-------------",meetingname);
					List<DidiOrderEntity> orderList = didiOrderService.Querymeeting(userId, meetingname, currdatestring);
					logger.info("根据会议返回订单信息-------------",orderList);
					if(orderList != null && orderList.size()>=2){
						continue;
					}
					String starti = ((JSONObject)dataArray.get(i)).getString("start");//會議開始時間
					String sendNamei = ((JSONObject)dataArray.get(i)).getString("sendName");//發起人
					String endi = ((JSONObject)dataArray.get(i)).getString("end");//會議結束時間
					MeetingResultVO resultvo = new MeetingResultVO();
					resultvo.setEnddate(endi);
					resultvo.setSendName(sendNamei);
					resultvo.setStartdate(starti);
					resultvo.setSubjectname(subjecti);
					resultvo.setSubjectname(subjecti.substring(subjecti.indexOf(":")+1,subjecti.length()));
					meetingvoList.add(resultvo);
				}
			}
			if(meetingvoList.size()>0){
				jonum.put("meeting", meetingvoList);
				jonum.put("meetingsize", meetingvoList.size());
				jonum.put("msg", "success");
				
			}else{
				jonum.put("meeting", meetingvoList);
				jonum.put("meetingsize", meetingvoList.size());
				jonum.put("msg", "kong");
			}
		} else {
			jonum.put("msg", "工号不能为空");
			writeToPage(jonum);
		}
		}catch(Exception e){
			logger.error("---------调用日程接口异常--------", e.getMessage());
			jonum.put("msg", e.getMessage());
			e.getMessage();
		}
		writeToPage(jonum);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the didiOrderService
	 */
	public IDidiOrderService getDidiOrderService() {
		return didiOrderService;
	}

	/**
	 * @param didiOrderService the didiOrderService to set
	 */
	public void setDidiOrderService(IDidiOrderService didiOrderService) {
		this.didiOrderService = didiOrderService;
	}

	public ICalendarService getCalendarService() {
		return calendarService;
	}

	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
	}

	public IAttendMeetingService getAttendMeetingService() {
		return attendMeetingService;
	}

	public void setAttendMeetingService(
			IAttendMeetingService attendMeetingService) {
		this.attendMeetingService = attendMeetingService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
