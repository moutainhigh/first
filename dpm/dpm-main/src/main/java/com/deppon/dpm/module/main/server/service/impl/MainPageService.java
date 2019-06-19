package com.deppon.dpm.module.main.server.service.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.anps.server.service.INoticeMessageService;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessage;
import com.deppon.dpm.module.main.server.action.MainPageAction;
import com.deppon.dpm.module.main.server.dao.IMainPageDao;
import com.deppon.dpm.module.main.server.service.IMainPageService;
import com.deppon.dpm.module.main.shared.domain.NoticeCenterEntity;
import com.deppon.dpm.module.main.shared.domain.NoticeCenterIsTop;
import com.deppon.dpm.module.main.shared.domain.NoticeDetailEntity;
import com.deppon.dpm.module.management.server.service.ICalendarService;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;
import com.deppon.dpm.module.management.util.CalendarDateUtil;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.service.IWorkItemsListService;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.dpm.module.wfs.util.Constants;

//import com.deppon.dpm.doc.server.service.IAddMessageService;

@Transactional
public class MainPageService implements IMainPageService {

	/**
	 * 查询开始时间
	 */
	private Date searchdtStart;
	/**
	 * 查询结束时间
	 */
	private Date searchdtEnd;

	/**
	 * 日程缓存14天
	 */
	private static final int ADDDAY_14 = 1;

	/**
	 * 日程缓存天数
	 */
	private String calendarDay;
	
	/**
	 * set injection
	 */
	private IMainPageDao mainPageDao;
	/**
	 * emailService 注入
	 */
	// private IEmailService emailService;

	private IAddMessageService addmessageservice;
	
    private IDoubtfulExAuditService doubtfulExAuditService;
	
	private IOtherOffDutiesService otherOffDutiesService;

	private IWeaverWfsService weaverService;
	
	private IWorkItemsListService workItemsListService;

	private INoticeMessageService noticeMessageService;

	/**
	 * set injection
	 */
	private ICalendarService calendarService;
	
	private static Logger logger = LoggerFactory.getLogger(MainPageService.class);
	

	/**
	 * 卡片ID对应 就用 1：通知中心 2：常用应用 3：待审批 4：会议
	 */
	@Override
	public String cardDetailByUserId(String userId) {
		// TODO Auto-generated method stub
		// 每个用户默认所有拥有的卡片
		String defaultCards = "1,2,3,4";
		// 从数据库中查询用户所拥有的自己定制的卡片ID 因前端暂时没做这个功能 所以这一步先省略 以后做的话只要建张表 （工号，卡片ID,修改时间）
		// 从里面查即可
		// String cardUser = ;
		return defaultCards;
	}
	
	/**
	 * 如果查询数据为空，则不返回该卡片（现在只有3工作流4会议需要判断）
	 */
	public Map<String,Object> cardshow(String userId, String password, String pageNo, Date ymd){
		
		//List<String> nocard = new ArrayList<String>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("workflowCount", 0);
		map.put("calendarCount", 0);
		//前端展示的卡片id
		List<String> cardlist = mainPageDao.getShowCard();
		
		//判断工作流是否为空
		if(cardlist.contains("3")){
			int num = this.searchWorkflow(userId,pageNo);
			//一句话提示所需数据
			map.put("workflowCount", num);
			if(!(num > 0)){
				//nocard.add("3");
				//无数据，去除此卡片
				int index = cardlist.indexOf("3");
				cardlist.remove(index);
			}	
		}
	
		//判断会议是否为空
		if(cardlist.contains("4")){
			String str = this.searchMeeting(userId, password, ymd);
			//处理json
			String string = JSONObject.parseObject(str).getString("data");
			List<CalendarInfo> parseArray = JSONObject.parseArray(string,CalendarInfo.class);
			System.out.println(string);
			if(parseArray == null || parseArray.size() <= 0){
				//nocard.add("4");
				//无数据，去除此卡片
				int index = cardlist.indexOf("4");
				cardlist.remove(index);
			}else{
				//一句话提示所需数据
				map.put("calendarCount", parseArray.size());
			}
		}

        //前端展示的卡片id
		//List<String> cardlist = mainPageDao.getShowCard(nocard);
		
		String cardStr = "";
		StringBuffer sb = new StringBuffer();    
		for(String cardnum : cardlist){
			sb.append(cardnum + ",");
		}
		cardStr = sb.substring(0,sb.length() - 1);
		map.put("cardStr", cardStr);
		System.out.println(cardStr);
		return map;
	}
	
	/**
	 * 判断首页工作流接口是否为空------卡片
	 * @throws RemoteException 
	 */
	private int searchWorkflow(String userId, String pageNo){
		int num = 0;
		//获取新工作流
		List<WorkflowListEntity> newlist = new ArrayList<WorkflowListEntity>();
		try {
			newlist = weaverService.workflowList(userId,"", pageNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("首页待审批接口异常:" + e.toString());
			return 0;
		}
		
		//老工作流列表
		WorkItemsDto dto = new WorkItemsDto();
		dto.setUserId(userId);
		//获取老工作流
		List<OaWorkItem> oldlist;
		try {
			oldlist = workItemsListService.workitemslist1(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		int newcount = 0;
		int oldcount = 0;
		if(newlist != null && newlist.size() > 0){
			newcount = newlist.size();
		}else if(oldlist != null && oldlist.size() > 0){
			oldcount = oldlist.size();
		}
		num = newcount + oldcount;
		return num;
	}
	
	/**
	 * 判断首页会议接口是否为空-------卡片
	 * @return
	 */
	private String searchMeeting(String userId, String password, Date ymd){
		
		String message= "";
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
		if (searchdtEnd.getTime() >= searchdtStart.getTime()) {
			// 获取指定时间内的日程信息
			message = calendarService.getCalendarInfosThree(userId, password,
					searchdtStart, searchdtEnd);
		}
		return message;
	}


	/**
	 * 获取消息类型
	 */
	@Override
	public List<NoticeCenterEntity> getType(String userId) {
		List<NoticeCenterEntity> nclist = new ArrayList<NoticeCenterEntity>();
		List<Integer> mark = new ArrayList<Integer>();
		nclist = mainPageDao.getType();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (NoticeCenterEntity ncEntity : nclist) {
  
			if (ncEntity.getType().equals("1")) {
                /*日程通知*/
				//调接口获取所有日程
				List<CalendarInfo> noticeCalendarInfos = dealParam(userId);
              
				if (null != noticeCalendarInfos && noticeCalendarInfos.size() > 0) {
					//处理数据
					ncEntity = dealCalenarInfoList(sdf,noticeCalendarInfos,ncEntity,userId);
					if(ncEntity.getCount() <= 0){
						//所有日程都已读
						mark.add(nclist.indexOf(ncEntity));
					}
				} else { // 无日程通知
					mark.add(nclist.indexOf(ncEntity));
				}

			} else if (ncEntity.getType().equals("2")) {
				// 邮件通知
				mark.add(nclist.indexOf(ncEntity));

			} else if (ncEntity.getType().equals("3")) {
				/* 欢行通知 */
				List<PushMessageVO> msgList = addmessageservice.queryMessage(userId);
				// 欢行通知（未读+已读）
				if (msgList != null && msgList.size() != 0) {
					// 获取未读通知信息
					ncEntity = this.docNotice(ncEntity, msgList,userId);
					//无通知或所有通知已读
					if (ncEntity.getCount() <= 0) {
						// 无未读通知
						mark.add(nclist.indexOf(ncEntity));
					}

				} else {
					// 无通知
					mark.add(nclist.indexOf(ncEntity));
				}

			} else if (ncEntity.getType().equals("4")) {
				/* 公文通知 */
				List<NoticeMessage> nmlist = noticeMessageService.getNoReadNotice(userId);
				if (nmlist != null && nmlist.size() > 0) {
					//查询未读通知
					ncEntity = this.anpsNotice(ncEntity, nmlist, userId);
					//无通知或所有通知已读
					if (ncEntity.getCount() <= 0) {
						// 无未读通知
						mark.add(nclist.indexOf(ncEntity));
					}
				} else {
					// 无公文通知
					mark.add(nclist.indexOf(ncEntity));
				}

			}else if (ncEntity.getType().equals("5")) { 
				/*
				 * 审批通知
				 */
				List<Object> workflow = weaverService.workflowNoticeList(userId, "1"); 
				if(workflow != null && workflow.size() > 0) { 
					//查询未读通知
					ncEntity = this.workflowNotice(ncEntity, workflow, userId);
					//无通知或所有通知已读
					if (ncEntity.getCount() <= 0) {
						// 无未读通知
						mark.add(nclist.indexOf(ncEntity));
					}
			    } else { 
			    	// 无待审批  
			    	mark.add(nclist.indexOf(ncEntity));
				} 
		    }else if(ncEntity.getType().equals("6")){
		    	/*
		    	 * 欢行未审批
		    	 */
		    	//疑似异常数据（待审核，带我审核）
				List<AbnormalOrderEntity> exList = doubtfulExAuditService.allList(userId);
				//其他公务数据（待审核，带我审核）
				List<OtherOffDutiesEntity> otherList = otherOffDutiesService.allList(userId);
				if(exList != null && otherList != null) { 
					//查询未读通知
					ncEntity = this.docAuditNotice(ncEntity, exList, otherList, userId);
					//无通知或所有通知已读
					if (ncEntity.getCount() <= 0) {
						// 无未读通知
						mark.add(nclist.indexOf(ncEntity));
					}
			    } else { 
			    	// 无待审批  
			    	mark.add(nclist.indexOf(ncEntity));
				} 
				/**
				 * 工资核对通知
				 */
		    }else if(ncEntity.getType().equals("7")){
		    	Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", "7");
				map.put("userId", userId);
				map.put("isRead", "0");
				//查询通知详情表是否存在该条通知
				NoticeDetailEntity nd = mainPageDao.getNoticeCenter(map);
				List<NoticeDetailEntity> ndList = mainPageDao.getNoticeDetailList(map);
				if(null!=nd&&ndList.size()>0){
				ncEntity.setCount(ndList.size());
				ncEntity.setTitle(nd.getTitle());
				ncEntity.setUserName(nd.getCreatorName());
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(sdf.format(nd.getInsertTime())));
				ncEntity.setCreateTimeSort(nd.getInsertTime());
				//mark.add(nclist.indexOf(ncEntity));
				}else{
					mark.add(nclist.indexOf(ncEntity));
				}
				/**
				 * 考勤核对通知
				 */
		    }else if(ncEntity.getType().equals("8")){
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("type", "8");
				map.put("userId", userId);
				map.put("isRead", "0");
				//查询通知详情表是否存在该条通知
				NoticeDetailEntity nd = mainPageDao.getNoticeCenter(map);
				List<NoticeDetailEntity> ndList = mainPageDao.getNoticeDetailList(map);
				
				if(null!=nd&&ndList.size()>0){
				ncEntity.setCount(ndList.size());	
				ncEntity.setTitle(nd.getTitle());
				ncEntity.setUserName(nd.getCreatorName());
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(sdf.format(nd.getInsertTime())));
				ncEntity.setCreateTimeSort(nd.getInsertTime());
				//mark.add(nclist.indexOf(ncEntity));
				}else{
					mark.add(nclist.indexOf(ncEntity));
				}
		    }else if(ncEntity.getType().equals("9")){
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("type", "9");
				map.put("userId", userId);
				map.put("isRead", "0");
				//查询通知详情表是否存在该条通知
				NoticeDetailEntity nd = mainPageDao.getNoticeCenter(map);
				List<NoticeDetailEntity> ndList = mainPageDao.getNoticeDetailList(map);
				
				if(null!=nd&&ndList.size()>0){
				ncEntity.setCount(ndList.size());	
				ncEntity.setTitle(nd.getTitle());
				ncEntity.setUserName(nd.getCreatorName());
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(sdf.format(nd.getInsertTime())));
				ncEntity.setCreateTimeSort(nd.getInsertTime());
				//mark.add(nclist.indexOf(ncEntity));
				}else{
					mark.add(nclist.indexOf(ncEntity));
				}
				/**
				 * 全国打卡位置新增提醒审核的通知类型10
				 * 全国打卡位置审核退回/通过的通知类型11
				 * */
		    }else if(ncEntity.getType().equals("10") || ncEntity.getType().equals("11") || ncEntity.getType().equals("12")|| ncEntity.getType().equals("13") ){
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("type", ncEntity.getType());
				map.put("userId", userId);
				map.put("isRead", "0");
				//查询通知详情表是否存在该条通知
				NoticeDetailEntity nd = mainPageDao.getNoticeCenter(map);
				List<NoticeDetailEntity> ndList = mainPageDao.getNoticeDetailList(map);
				
				if(null!=nd&&ndList.size()>0){
				ncEntity.setCount(ndList.size());	
				ncEntity.setTitle(nd.getTitle());
				ncEntity.setUserName(nd.getCreatorName());
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(sdf.format(nd.getInsertTime())));
				ncEntity.setCreateTimeSort(nd.getInsertTime());
				//mark.add(nclist.indexOf(ncEntity));
				}else{
					mark.add(nclist.indexOf(ncEntity));
				}
		    }
		}
		// 去除空的通知实体
		for (int i = mark.size() - 1; i >= 0; i--) {
			nclist.remove(nclist.get(mark.get(i)));
		}
		
		/*List<NoticeCenterIsTop> sortList = mainPageDao
				.selectNoticeIsTop(userId);
		List<NoticeCenterEntity> list = new ArrayList<NoticeCenterEntity>();

		if (sortList.size() == 0) {
			return nclist;
		} else {
			for (NoticeCenterIsTop nc : sortList) {
				for (NoticeCenterEntity noticeCenter : nclist) {
                       if(noticeCenter.getType().equals(nc.getType())){
                    	   noticeCenter.setIsTop(nc.getIsTop());
                    	   list.add(noticeCenter);
                    	   continue;
                       }
				}
			}
		}*/
		//按最新通知排序
		listSort(nclist);
		
		return nclist; 

	}
	
	//通知中心排序
	public static void listSort(List<NoticeCenterEntity> list){
		Collections.sort(list, new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try{
					Date dt1 = new Date();
					Date dt2 = new Date();
					dt1 = ((NoticeCenterEntity)o1).getCreateTimeSort();
					dt2 = ((NoticeCenterEntity)o2).getCreateTimeSort();
					
					if (dt1.getTime() < dt2.getTime()) {
						return 1;
					} else if (dt1.getTime() > dt2.getTime()) {
						return -1;
					} else {
						return 0;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				return 0;
			}
		});	
	}
    
	/**
	 * 获取通知列表 
	 */
	@Override
	public List<NoticeDetailEntity> getNoticeDetail(String userId, String type) {
		List<NoticeDetailEntity> noticeDetailList = new ArrayList<NoticeDetailEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (type.equals("1")) {
			// 获取日程通知
			List<CalendarInfo> noticeCalendarInfos = dealParam(userId);
			if (null != noticeCalendarInfos && noticeCalendarInfos.size() > 0) {
				for (CalendarInfo calendarInfo : noticeCalendarInfos) {
					noticeDetailList = dealCalenarInfo(noticeDetailList,calendarInfo,userId);
				}
			}

		} else if (type.equals("2")) {
			// 邮件通知

		} else if (type.equals("3")) {
			/* 欢行通知 */
			List<PushMessageVO> msgList = addmessageservice.queryMessage(userId);
			// 欢行通知（未读+已读）
			if (msgList != null && msgList.size() != 0) {
				// 获取未读通知信息
				noticeDetailList = this.docNoticeDetail(noticeDetailList,msgList,userId);
			}

		} else if (type.equals("4")) {
			/* 公文通知 */
			List<NoticeMessage> nmlist = noticeMessageService.getNoReadNotice(userId);

			if (nmlist != null && nmlist.size() > 0) {
				// 获取未读通知信息
				noticeDetailList = this.anpsNoticeDetail(noticeDetailList, nmlist, userId);
			}

		}else if (type.equals("5")) {
			/*审批通知*/
			List<Object> workflowList = weaverService.workflowNoticeList(userId, "1");
			
			if(workflowList != null && workflowList.size() > 0){
				// 获取未读通知信息
				noticeDetailList = this.workflowNoticeDetail(noticeDetailList, workflowList, userId);
			}
		}else if(type.equals("6")){
			//疑似异常数据（待审核，带我审核）
			List<AbnormalOrderEntity> exList = doubtfulExAuditService.allList(userId);
			//其他公务数据（待审核，带我审核）
			List<OtherOffDutiesEntity> otherList = otherOffDutiesService.allList(userId);
			// 获取未读通知信息
			noticeDetailList = this.docAuditNoticeDetail(noticeDetailList, exList, otherList, userId);
		}else if(type.equals("7")){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "7");
			map.put("userId", userId);
			map.put("isRead", "0");
			//查询通知详情表是否存在该条通知
			noticeDetailList = mainPageDao.getNoticeDetailList(map);
			for (NoticeDetailEntity noticeDetailEntity : noticeDetailList) {
				noticeDetailEntity.setCreateTime(this.transformDate(noticeDetailEntity.getCreateTime()));
			}
		}else if(type.equals("8")){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "8");
			map.put("userId", userId);
			map.put("isRead", "0");
			//查询通知详情表是否存在该条通知
			noticeDetailList = mainPageDao.getNoticeDetailList(map);
			for (NoticeDetailEntity noticeDetailEntity : noticeDetailList) {
				noticeDetailEntity.setCreateTime(this.transformDate(noticeDetailEntity.getCreateTime()));
			}
		}else if(type.equals("9")){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "9");
			map.put("userId", userId);
			map.put("isRead", "0");
			//查询通知详情表是否存在该条通知
			noticeDetailList = mainPageDao.getNoticeDetailList(map);
			for (NoticeDetailEntity noticeDetailEntity : noticeDetailList) {
				noticeDetailEntity.setCreateTime(this.transformDate(noticeDetailEntity.getCreateTime()));
			}
		}else if(type.equals("10") || type.equals("11") || type.equals("12")|| type.equals("13") ){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", type);
			map.put("userId", userId);
			map.put("isRead", "0");
			//查询通知详情表是否存在该条通知
			noticeDetailList = mainPageDao.getNoticeDetailList(map);
			for (NoticeDetailEntity noticeDetailEntity : noticeDetailList) {
				noticeDetailEntity.setCreateTime(this.transformDate(noticeDetailEntity.getCreateTime()));
			}
		}
		 
		//处理已读未读状态，新增未读通知存入数据库
		this.dealNoticeDetail(noticeDetailList);

		return noticeDetailList;
	}

	/* 当天的格式为hh:mm，前一天的格式为昨天hh:mm，昨天之前的为X月X日hh:mm */
	private String transformDate(String createTime) {

		String today = String.format("%tF", System.currentTimeMillis());
		String yesterday = String.format("%tF", System.currentTimeMillis()
				- Constants.HOUR_MIN * Constants.THOUSAND * Constants.DAY_HOUR);
		String ct = "";
		if (createTime.indexOf(today) != -1) {
			// 当天和昨天
			ct = createTime.substring(11, 16);
		} else if (createTime.indexOf(yesterday) != -1) {
			ct = "昨天" + createTime.substring(11, 16);
		} else {
			// 昨天之前
			ct = createTime.substring(5, 16);
		}
		return ct;
	}
	
	/**
	 *  处理请求参数，获取日程
	 * @param userId
	 * @return
	 */
	private List<CalendarInfo> dealParam(String userId) {
		searchdtStart = CalendarDateUtil.getSdfDate("yyyy-MM-dd", new Date());
		// 默认14天缓存
		int day = ADDDAY_14;
		if (StringUtils.isNotEmpty(calendarDay)
				&& calendarDay.matches("^[0-9]*$")) {
			day = Integer.valueOf(calendarDay);
		}
		String time = CalendarDateUtil.addDay(new Date(), day);
		// 查询结束时间
		searchdtEnd = CalendarDateUtil.convertStringToDate("yyyy-MM-dd", time);
		// 日程通知
		List<CalendarInfo> noticeCalendarInfos = calendarService
				.getNoticeCalendarInfosOrderByCTime(userId, "", searchdtStart,searchdtEnd);
		return noticeCalendarInfos;

	}

	/**
	 * 处理日程通知列表-----日程通知列表
	 * 
	 * @param noticeDetailList
	 * @param calendarInfo
	 * @return
	 */
	private List<NoticeDetailEntity> dealCalenarInfo(
			List<NoticeDetailEntity> noticeDetailList, CalendarInfo calendarInfo, String userId) {
		NoticeDetailEntity noticeDetail = new NoticeDetailEntity();
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendarInfo.getCalendarDate());
		noticeDetail.setCreateTime(this.transformDate(format));
		String content = calendarInfo.getContent();
		if (content.contains("备注为空")) {
			noticeDetail.setContent("内容为空");
		} else {
			dealContent(noticeDetail, content);
		}
		noticeDetail.setTitle(calendarInfo.getSubject());
		noticeDetail.setType("1");
		noticeDetail.setNoticeId(calendarInfo.getAppointmentId());
		noticeDetail.setCreatorName(calendarInfo.getSendName());
		noticeDetail.setUserId(userId);
		noticeDetail.setLocation(calendarInfo.getLocation());
		//处理会议时间 
		String startdate = new SimpleDateFormat("MM月dd日").format(calendarInfo.getStart());
		String startTime = new SimpleDateFormat("HH:mm").format(calendarInfo.getStart());
		String endTime = new SimpleDateFormat("HH:mm").format(calendarInfo.getEnd());
		noticeDetail.setMeetingDate(startdate);
		noticeDetail.setMeetingTime(startTime + "~" + endTime);
		
		noticeDetailList.add(noticeDetail);
		return noticeDetailList;

	}

	/**
	 * 正则匹配日程
	 * 
	 * @param noticeDetail
	 * @param content
	 */
	private void dealContent(NoticeDetailEntity noticeDetail, String content) {
		Pattern p = Pattern.compile("<div>.+</div>");
		Matcher m = p.matcher(content.replace("&nbsp;", ""));
		if (m.find()) {
			String group = m.group().replaceAll("<div>", "")
					.replaceAll("</div>", "");
			if (group.length() >= 50) {
				noticeDetail.setContent(group.substring(0, 50));
			} else {
				noticeDetail.setContent(group);
			}
		}

	}
	/**
	 * 处理获取 日程只有一条------首页
	 * 
	 * @param noticeDetailList
	 * @param calendarInfo
	 * @return
	 */
	private NoticeCenterEntity dealCalenarInfoList(SimpleDateFormat sdf,
			List<CalendarInfo> noticeCalendarInfos,NoticeCenterEntity ncEntity,String userId) {
		int index = -1;
		int mark = 0;
		int num = noticeCalendarInfos.size();
		for(CalendarInfo cal : noticeCalendarInfos){
			//封装实体
			ncEntity.setUserId(userId);
			ncEntity.setNoticeId(cal.getAppointmentId());
			
			//判断是否已读
			boolean isread = this.dealNoticeCenter(ncEntity);
			//若已读，数量减1，判断下个日程;未读则标记位置
			if(isread == false){
				//标记第几个实体是最新未读的一条
				if(index < 0){
					index = mark;
				}
			}else{
				num = num - 1;
				ncEntity.setCount(num);
			}
			mark = mark + 1;
		}
		//有未读通知，封装实体
		if(index >= 0){
			ncEntity.setCount(num);
			ncEntity.setTitle(noticeCalendarInfos.get(index).getSubject());
			String content = noticeCalendarInfos.get(index).getContent();
			if (content.contains("备注为空")) {
				ncEntity.setContent("内容为空");
			} else {
				dealCalenarContent( ncEntity, content);
			}
			ncEntity.setUserId(userId);
			ncEntity.setUserName(noticeCalendarInfos.get(index).getSendName());
			String format = sdf.format(noticeCalendarInfos.get(index).getCalendarDate());
			ncEntity.setCreateTime(this.transformDate(format));
			ncEntity.setCreateTimeSort(noticeCalendarInfos.get(index).getCalendarDate());
			ncEntity.setNoticeId(noticeCalendarInfos.get(index).getAppointmentId());	
		}
		return ncEntity;
	}

	/**
	 * 正则匹配日程内容
	 * 
	 * @param noticeDetail
	 * @param content
	 */
	private void dealCalenarContent(NoticeCenterEntity ncEntity, String content) {
		Pattern p = Pattern.compile("<div>.+</div>");
		Matcher m = p.matcher(content.replace("&nbsp;", ""));
		if (m.find()) {
			String group = m.group().replaceAll("<div>", "")
					.replaceAll("</div>", "");
			if (group.length() >= 50) {
				ncEntity.setContent(group.substring(0, 50));
			} else {
				ncEntity.setContent(group);
			}
		}

	}

	/**
	 * 获取欢行未读通知-----首页
	 * 
	 * @param ncEntity
	 * @param msgList
	 * @return
	 */
	@SuppressWarnings("unused")
	private NoticeCenterEntity docNotice(NoticeCenterEntity ncEntity,
			List<PushMessageVO> msgList,String userId) {
		// 存放未读通知
		List<PushMessageVO> wlList = new ArrayList<PushMessageVO>();
		for (PushMessageVO temp : msgList) {
			// 未读通知
			if (temp.getState().equals("0")) {
				PushMessageVO pmvo = temp;
				pmvo.setId(temp.getId());
				pmvo.setBillno(temp.getBillno() == null ? "" : temp.getBillno());// 订单号
				pmvo.setAbnormalrule(temp.getAbnormalrule() == null ? "" : temp
						.getAbnormalrule());// 异常规则
				wlList.add(pmvo);
			}
		}
		if (wlList != null && wlList.size() != 0) {
			// 存入实体
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int index = -1;
			int mark = 0;
			int num = wlList.size();
			for(PushMessageVO pm : wlList){
				//封装实体
				ncEntity.setUserId(userId);
				ncEntity.setNoticeId(pm.getId().toString());
				//判断是否已读
				boolean isread = this.dealNoticeCenter(ncEntity);
				//若已读，数量减1，判断下个通知;未读则标记位置
				if(isread == false){
					//标记第几个实体是最新未读的一条
					if(index < 0){
						index = mark;
					}
				}else{
					num = num - 1;
					ncEntity.setCount(num);
				}
				mark = mark + 1;
			}
			//有未读通知，封装实体
			if(index >= 0){
				ncEntity.setCount(num);
				ncEntity.setTitle(wlList.get(index).getMsgtitle());
				ncEntity.setContent(wlList.get(index).getMessage());
				ncEntity.setUserId(userId);
				String ct = this.transformDate(wlList.get(index).getSavetime());
				ncEntity.setCreateTime(ct);		
				try {
					ncEntity.setCreateTimeSort(sdf.parse(wlList.get(index).getSavetime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ncEntity;
	}

	/**
	 * 获取欢行未读通知 ----欢行通知列表
	 * 
	 * @param ncEntity
	 * @param msgList
	 * @return
	 */
	private List<NoticeDetailEntity> docNoticeDetail(
			List<NoticeDetailEntity> noticeDetailList,List<PushMessageVO> msgList,String userId) {
		// 存放未读通知
		List<PushMessageVO> wlList = new ArrayList<PushMessageVO>();
		for (PushMessageVO temp : msgList) {
			// 未读通知
			if (temp.getState().equals("0")) {
				PushMessageVO pmvo = temp;
				pmvo.setId(temp.getId());
				pmvo.setBillno(temp.getBillno() == null ? "" : temp.getBillno());// 订单号
				pmvo.setAbnormalrule(temp.getAbnormalrule() == null ? "" : temp
						.getAbnormalrule());// 异常规则
				wlList.add(pmvo);
			}
		}
		if (wlList != null && wlList.size() != 0) {

			for (PushMessageVO pushMessageVO : wlList) {
				NoticeDetailEntity ncEntity = new NoticeDetailEntity();
				// 存入实体
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// ncEntity.setCount(wlList.size());
				ncEntity.setTitle(pushMessageVO.getMsgtitle());
				ncEntity.setContent(pushMessageVO.getMessage());
				ncEntity.setType("3");
				ncEntity.setCreateTime(this.transformDate(wlList.get(0).getSavetime()));
				ncEntity.setNoticeId(pushMessageVO.getId().toString());
				ncEntity.setUserId(userId);
				noticeDetailList.add(ncEntity);
			}
		}
		return noticeDetailList;
	}
	
	/**
	 * 获取公文未读通知 ------首页
	 * @param ndList
	 * @param nmlist
	 * @param userId
	 * @return
	 */
	private NoticeCenterEntity anpsNotice(NoticeCenterEntity ncEntity,List<NoticeMessage> nmlist,String userId){
		int num = nmlist.size();
		int index = -1;
		int mark = 0;
		for (NoticeMessage noticeMessage : nmlist) {
			//封装实体
			ncEntity.setUserId(userId);
			ncEntity.setUserName(noticeMessage.getUserName());
			ncEntity.setNoticeId(noticeMessage.getNoticeId().toString());
			//判断是否已读
			boolean isread = this.dealNoticeCenter(ncEntity);
			//若已读，数量减1，判断下个通知;未读则标记位置
			if(isread == false){
				//标记第几个实体是最新未读的一条
				if(index < 0){
					index = mark;
				}
			}else{
				num = num - 1;
				ncEntity.setCount(num);
			}
			mark = mark + 1;
		}
		//有未读通知，封装实体
		if(index >= 0){
			ncEntity.setCount(num);
			ncEntity.setTitle(nmlist.get(index).getNoticeTitle());
			String content = nmlist.get(index).getNoticeContent()
					.replaceAll("<br>", "").replaceAll("<div>", "")
					.replaceAll("</div>", "").replaceAll("&nbsp;", "");
			if (content.length() >= 50) {
				ncEntity.setContent(content);
			} else {
				ncEntity.setContent(content);
			}
			ncEntity.setUserId(userId);
			ncEntity.setUserName(nmlist.get(index).getUserName());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = sdf.format(nmlist.get(index).getCreateTime());
			String ct = this.transformDate(dateString);
			ncEntity.setCreateTime(ct);
			ncEntity.setCreateTimeSort(nmlist.get(index).getCreateTime());
		}
		return ncEntity;
	}
	
	/**
	 * 获取公文未读通知 ----公文通知列表
	 * @param ndList
	 * @param nmlist
	 * @param userId
	 * @return
	 */
	private List<NoticeDetailEntity> anpsNoticeDetail(List<NoticeDetailEntity> ndList,List<NoticeMessage> nmlist,String userId){
		for (NoticeMessage noticeMessage : nmlist) {
			NoticeDetailEntity noticeDetail = new NoticeDetailEntity();
			noticeDetail.setTitle(noticeMessage.getNoticeTitle());
			String content = noticeMessage.getNoticeContent()
					.replaceAll("<br>", "").replaceAll("<div>", "")
					.replaceAll("</div>", "").replaceAll("&nbsp;", "");
			if (content.length() >= 50) {
				noticeDetail.setContent(content.substring(0, 50));
			} else {
				noticeDetail.setContent(content);
			}
			String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(noticeMessage.getCreateTime());
			noticeDetail.setCreateTime(this.transformDate(format));
			noticeDetail.setType("4");
			noticeDetail.setNoticeId(noticeMessage.getNoticeId().toString());
			noticeDetail.setCreatorName(noticeMessage.getUserName());
			noticeDetail.setUserId(userId);
			ndList.add(noticeDetail);
		}
		return ndList;
	}
	
	/**
	 * 获取工作流未读通知 ----首页
	 * @param ndList
	 * @param nmlist
	 * @param userId
	 * @return
	 */
	private NoticeCenterEntity workflowNotice(NoticeCenterEntity ncEntity,List<Object> workflow,String userId){
		int num = workflow.size();
		int index = -1;
		int mark = 0;
		for (Object wfEntity : workflow) {
			//封装实体
			if(wfEntity.getClass() == WorkflowListEntity.class) { 
				//新工作流
				ncEntity.setUserId(userId);
				ncEntity.setNoticeId(((WorkflowListEntity)wfEntity).getRequestInfo().getRequestId());
			} else if(wfEntity.getClass() == OaWorkItem.class) { 
				// 老工作流
				ncEntity.setUserId(userId);
				ncEntity.setNoticeId(((OaWorkItem)wfEntity).getBusino());
			}
			//判断是否已读
			boolean isread = this.dealNoticeCenter(ncEntity);
			//若已读，数量减1，判断下个通知;未读则标记位置
			if(isread == false){
				//标记第几个实体是最新未读的一条
				if(index < 0){
					index = mark;
				}
			}else{
				num = num - 1;
				ncEntity.setCount(num);
			}
			mark = mark + 1;
		}
		//有未读通知，封装实体
		if(index >= 0){
			if(workflow.get(index).getClass() == WorkflowListEntity.class) { 
				//新工作流 
				WorkflowListEntity wf = (WorkflowListEntity) workflow.get(index); 
				ncEntity.setCount(num);
				ncEntity.setTitle(wf.getRequestInfo().getRequestName());
				ncEntity.setUserName(wf.getRequestInfo() .getCreatorName()); 
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(wf.getRequestInfo() .getCreateTime()));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					ncEntity.setCreateTimeSort(sdf.parse(wf.getRequestInfo() .getCreateTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if(workflow.get(index).getClass() == OaWorkItem.class) { 
				// 老工作流
				OaWorkItem ow =  (OaWorkItem) workflow.get(index);
				ncEntity.setCount(num);
				ncEntity.setTitle(ow.getProcessinstname());
				ncEntity.setUserName(ow.getAppler());
				ncEntity.setUserId(userId);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = sdf.format(ow.getCreatetime());
				String ct = this.transformDate(dateString);
				ncEntity.setCreateTime(ct); 
				ncEntity.setCreateTimeSort(ow.getCreatetime());
			}	
		}
		return ncEntity;
	}
	
	/**
	 * 获取工作流未读通知 ----工作流通知列表
	 * @param ndList
	 * @param nmlist
	 * @param userId
	 * @return
	 */
	private List<NoticeDetailEntity> workflowNoticeDetail(List<NoticeDetailEntity> ndList,List<Object> workflowList,String userId){
		
		for(Object workflow : workflowList){
			   //结果实体
			   NoticeDetailEntity noticeDetail = new NoticeDetailEntity();
			   if(workflow.getClass() == WorkflowListEntity.class) { 
					//新工作流 
					WorkflowListEntity wf = (WorkflowListEntity) workflow; 
					
					noticeDetail.setCreateTime(this.transformDate(wf.getRequestInfo() .getCreateTime()));
					noticeDetail.setType("5");
					noticeDetail.setNoticeId(wf.getRequestInfo().getRequestId());
					noticeDetail.setTitle(wf.getRequestInfo().getRequestName());
					noticeDetail.setContent(wf.getRequestInfo().getCurrentNodeName());
					noticeDetail.setCreatorName(wf.getRequestInfo().getCreatorName());
					noticeDetail.setUserId(userId);
					noticeDetail.setNewWorkflow(wf);
					ndList.add(noticeDetail);

				} else if(workflow.getClass() == OaWorkItem.class) { 
					// 老工作流
					OaWorkItem ow = (OaWorkItem) workflow;
					
					String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ow.getCreatetime());
					noticeDetail.setCreateTime(this.transformDate(format));
					noticeDetail.setType("5");
					noticeDetail.setNoticeId(ow.getBusino());
					noticeDetail.setTitle(ow.getProcessinstname());
					noticeDetail.setContent("");
					noticeDetail.setCreatorName(ow.getAppler());
					noticeDetail.setUserId(userId);
					noticeDetail.setOldWorkflow(ow);
					ndList.add(noticeDetail);
				}   
		   }
		return ndList;
	}
	

	
	/**
	 * 获取欢行未审核通知-----首页
	 * 
	 * @param ncEntity
	 * @param msgList
	 * @return
	 */
	@SuppressWarnings("unused")
	private NoticeCenterEntity docAuditNotice(NoticeCenterEntity ncEntity,
			List<AbnormalOrderEntity> exList,List<OtherOffDutiesEntity> otherList,String userId) {
		//拼装实体
		List<Object> dutieList = new ArrayList<Object>();
		if(exList != null && exList.size() != 0){
			dutieList.addAll((exList));
		}
		if(otherList != null && otherList.size() != 0){
			dutieList.addAll(otherList);
		}
		
		//存入实体
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int index = -1;
		int mark = 0;
		int num = 0;
		if(dutieList != null){
			num = dutieList.size();
		}
		 //循环处理
		for(Object du : dutieList){
			//封装实体
			if(du.getClass() == AbnormalOrderEntity.class) { 
				//疑似异常
				ncEntity.setUserId(userId);
				ncEntity.setNoticeId(((AbnormalOrderEntity)du).getId()+"ysyc");
			} else if(du.getClass() == OtherOffDutiesEntity.class) { 
				//其他公务
				ncEntity.setUserId(userId);
				ncEntity.setNoticeId(((OtherOffDutiesEntity)du).getId()+"qtgw");
			}
			//判断是否已读
			boolean isread = this.dealNoticeCenter(ncEntity);
			//若已读，数量减1，判断下个通知;未读则标记位置
			if(isread == false){
				//标记第几个实体是最新未读的一条
				if(index < 0){
					index = mark;
				}
			}else{
				num = num - 1;
				ncEntity.setCount(num);
			}
			mark = mark + 1;
		}
		//有未读通知，封装实体
		if(index >= 0){
			if(dutieList.get(index).getClass() == AbnormalOrderEntity.class) { 
				//疑似异常
				AbnormalOrderEntity ao = (AbnormalOrderEntity) dutieList.get(index); 
				ncEntity.setCount(num);
				ncEntity.setTitle("疑似异常-" + ao.getRemark());
				ncEntity.setUserName(ao.getUserName()); 
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(ao.getTaxidate()));
				try {
					ncEntity.setCreateTimeSort(sdf.parse(ao.getTaxidate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if(dutieList.get(index).getClass() == OtherOffDutiesEntity.class) { 
				//其他公务
				OtherOffDutiesEntity od =  (OtherOffDutiesEntity) dutieList.get(index);
				ncEntity.setCount(num);
				ncEntity.setTitle(od.getRemark());
				ncEntity.setUserName(od.getUserName());
				ncEntity.setUserId(userId);
				ncEntity.setCreateTime(this.transformDate(od.getTaxidate()));
				try {
					ncEntity.setCreateTimeSort(sdf.parse(od.getTaxidate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return ncEntity;
	}
	
	/**
	 * 获取欢行未审核通知 ----欢行未审核通知列表
	 * @param ndList
	 * @param nmlist
	 * @param userId
	 * @return
	 */
	private List<NoticeDetailEntity> docAuditNoticeDetail(List<NoticeDetailEntity> ndList,
			List<AbnormalOrderEntity> exList,List<OtherOffDutiesEntity> otherList,String userId){
		//拼装实体
		List<Object> dutieList = new ArrayList<Object>();
		if(exList != null && exList.size() != 0){
			dutieList.addAll(exList);
		}
		if(otherList != null && otherList.size() != 0){
			dutieList.addAll(otherList);
		}
		for(Object dutie : dutieList){
			   //结果实体
			   NoticeDetailEntity noticeDetail = new NoticeDetailEntity();
			   if(dutie.getClass() == AbnormalOrderEntity.class) { 
					//疑似异常
				    AbnormalOrderEntity ao = (AbnormalOrderEntity) dutie; 
				    
					noticeDetail.setCreateTime(this.transformDate(ao.getTaxidate()));
					noticeDetail.setType("6");
					noticeDetail.setNoticeId(ao.getId()+"ysyc");
					noticeDetail.setTitle("疑似异常-" + ao.getRemark());
					noticeDetail.setContent(ao.getErrorrule());
					noticeDetail.setCreatorName(ao.getUserName());
					noticeDetail.setUserId(userId);
					ndList.add(noticeDetail);

				} else if(dutie.getClass() == OtherOffDutiesEntity.class) { 
					//其他公务
					OtherOffDutiesEntity od = (OtherOffDutiesEntity) dutie;
					
					noticeDetail.setCreateTime(this.transformDate(od.getTaxidate()));
					noticeDetail.setType("6");
					noticeDetail.setNoticeId(od.getId()+"qtgw");
					noticeDetail.setTitle(od.getRemark());
					noticeDetail.setContent(od.getCarremark());
					noticeDetail.setCreatorName(od.getUserName());
					noticeDetail.setUserId(userId);
					ndList.add(noticeDetail);
				}   
		   }
		return ndList;
	}
	
	
	/**
	 * 通知中心
	 * 若调接口查出的通知数据为未读，而通知详情表为已读，则不传给前端
	 * @param noticeDetailList
	 * @return
	 */
	private Boolean dealNoticeCenter(NoticeCenterEntity noticeDetail){

        Boolean isread = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("noticeId", noticeDetail.getNoticeId());
		map.put("type", noticeDetail.getType());
		map.put("userId", noticeDetail.getUserId());
		//查询通知详情表是否存在该条通知
		NoticeDetailEntity nd = mainPageDao.getNoticeDetail(map);
		if(nd != null){
			if(nd.getIsread().equals("1")){
				isread = true;
			}
		}
        return isread;
	}
	
	/**
	 * 通知详情
	 * 查询通知详情表是否存在该通知，若不存在则插入
	 * 若调接口查出的通知数据为未读，而通知详情表为已读，则不传给前端
	 * @param noticeDetailList
	 * @return
	 */
	private void dealNoticeDetail(List<NoticeDetailEntity> noticeDetailList){
		//存储需要去除的实体位置
		List<Integer> mark = new ArrayList<Integer>();
		for(NoticeDetailEntity ndEntity : noticeDetailList){
			Map<String, String> map = new HashMap<String, String>();
			map.put("noticeId", ndEntity.getNoticeId());
			map.put("type", ndEntity.getType());
			map.put("userId", ndEntity.getUserId());
			//查询通知详情表是否存在该条通知
			NoticeDetailEntity nd = mainPageDao.getNoticeDetail(map);
			if(nd != null){
				if(nd.getIsread().equals("1")){
					//标记已读的通知位置
					mark.add(noticeDetailList.indexOf(ndEntity));
				}
			}else{
				//插入通知详情表
				map.put("createTime", ndEntity.getCreateTime());
				map.put("title", ndEntity.getTitle());
				map.put("content", ndEntity.getContent());
				map.put("creatorName", ndEntity.getCreatorName());
				int num = mainPageDao.addNoticeDetail(map);
			}
		}
		// 去除在通知中心已读，但是在应用内仍未读/未处理的通知
		for (int i = mark.size() - 1; i >= 0; i--) {
			noticeDetailList.remove(noticeDetailList.get(mark.get(i)));
		}
	}
	
	/**
	 * 未读变已读
	 * @param type
	 * @param status
	 */
	public Boolean noticeIsread(String type, String noticeId, String userId){
		Boolean res = false;
		Map<String, String> map = new HashMap<String, String>();
		if(type.equals("1")){
			noticeId=noticeId.replaceAll(" ", "+");
		}
		map.put("noticeId", noticeId);
		map.put("type", type);
		map.put("userId", userId);
		int num = mainPageDao.updateIsread(map);
		if(num > 0 ){
			res = true;
		}
		return res;
	}

	/**
	 * 更改通知类型状态
	 */
	@Override
	public Boolean updateType(String type, String status) {
		Boolean issuccess = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("status", status);
		try {
			int num = mainPageDao.updateType(map);
			if (num > 0) {
				issuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return issuccess;
	}

	/**
	 * 添加通知类型
	 */
	@Override
	public Boolean addType(String type, String typename, String status) {
		Boolean issuccess = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("typename", typename);
		map.put("status", status);
		try {
			int num = mainPageDao.addType(map);
			if (num > 0) {
				issuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return issuccess;
	}

	/**
	 * 删除通知类型
	 */
	@Override
	public Boolean delType(String type, String typename) {
		Boolean issuccess = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("typename", typename);
		;
		try {
			int num = mainPageDao.delType(map);
			if (num > 0) {
				issuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return issuccess;
	}
	
	/**
	 * 通知置顶功能
	 * @param map
	 * @return
	 */
	public List<NoticeCenterEntity> setTop(String userId,String type){
		List<NoticeCenterEntity> NoticeCenterEntity = this.getType(userId);
		if(NoticeCenterEntity.size()==0){
			return NoticeCenterEntity;
		}
		List<NoticeCenterEntity> list = new ArrayList<NoticeCenterEntity>();
		List<NoticeCenterIsTop> sortList = mainPageDao.selectNoticeIsTop(userId);
		String[] typeList={"1","3","4","5","6","7","8","9","10"};
		if(sortList.size()==0){
		for (String typeAll : typeList) {
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("type", typeAll);
			map.put("userId", userId);
			map.put("isTop", "0");
			mainPageDao.insertNoticeIsTop(map);
		}
		}
		//把置顶的状态改为1
		if (null != NoticeCenterEntity && NoticeCenterEntity.size() > 0) {
			for (NoticeCenterEntity notice : NoticeCenterEntity) {
				if(notice.getType().equals(type)){
					HashMap<String, Object> map = new HashMap<String,Object>();
					map.put("type", notice.getType());
					map.put("userId", userId);
					map.put("isTop", "1");
					map.put("updateTime", new Date());
					mainPageDao.updateNoticeIsTop(map);
				}
			}
		}
		//根据置顶状态排序
		this.sort(userId, NoticeCenterEntity, list);
		return list;
		
	}
	
	
	

	
	
	/**
	 * 取消置顶功能
	 * @param map
	 * @return
	 */
	public List<NoticeCenterEntity> notsetTop(String userId,String type){
       List<NoticeCenterEntity> NoticeCenterEntity = this.getType(userId);
       if(NoticeCenterEntity.size()==0){
			return NoticeCenterEntity;
		}
		List<NoticeCenterEntity> list = new ArrayList<NoticeCenterEntity>();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("type", type);
		map.put("userId", userId);
		map.put("isTop", "0");
		map.put("updateTime", new Date());
		mainPageDao.updateNoticeIsTop(map);
		//根据置顶顺序排序
		this.sort(userId, NoticeCenterEntity, list);
		return list;
		
		
	}
	/**
	 * 跟新卡片开关状态
	 */
	public Boolean updateCardType(String type, String status){
		Boolean issuccess = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("status", status);
		try {
			int num = mainPageDao.updateCardType(map);
			if (num > 0) {
				issuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return issuccess;
	}
	
	

	/**
	 * 根据置顶顺序排序
	 * @param userId
	 * @param NoticeCenterEntity
	 * @param list
	 */
	public void sort(String userId,List<NoticeCenterEntity> NoticeCenterEntity,List<NoticeCenterEntity> list){
		//根据置顶状态排序
				List<NoticeCenterIsTop> noticeSort = mainPageDao.selectNoticeIsTop(userId);
					for (NoticeCenterIsTop nc : noticeSort) {
						for (NoticeCenterEntity noticeCenter : NoticeCenterEntity) {
		                       if(noticeCenter.getType().equals(nc.getType())){
		                    	   noticeCenter.setIsTop(nc.getIsTop());
		                    	   list.add(noticeCenter);
		                    	   continue;
		                       }
						}
					}
	}
	/**
	 * 同步通知
	 * @param map
	 * @return
	 */
	@Override
	public int addNoticeDetail(Map<String, String> map) {
		// TODO Auto-generated method stub
		return  mainPageDao.addNoticeDetail(map);
	}

	public IMainPageDao getMainPageDao() {
		return mainPageDao;
	}

	public void setMainPageDao(IMainPageDao mainPageDao) {
		this.mainPageDao = mainPageDao;
	}

	public IAddMessageService getAddmessageservice() {
		return addmessageservice;
	}

	public void setAddmessageservice(IAddMessageService addmessageservice) {
		this.addmessageservice = addmessageservice;
	}

	public IWeaverWfsService getWeaverService() {
		return weaverService;
	}

	public void setWeaverService(IWeaverWfsService weaverService) {
		this.weaverService = weaverService;
	}

	public INoticeMessageService getNoticeMessageService() {
		return noticeMessageService;
	}

	public void setNoticeMessageService(
			INoticeMessageService noticeMessageService) {
		this.noticeMessageService = noticeMessageService;
	}

	public ICalendarService getCalendarService() {
		return calendarService;
	}

	public void setCalendarService(ICalendarService calendarService) {
		this.calendarService = calendarService;
	}

	public IWorkItemsListService getWorkItemsListService() {
		return workItemsListService;
	}

	public void setWorkItemsListService(IWorkItemsListService workItemsListService) {
		this.workItemsListService = workItemsListService;
	}

	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}

	public void setDoubtfulExAuditService(IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}

	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}

	public void setOtherOffDutiesService(IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}



	



}
