package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.action.MeetingRoomAction;
import com.deppon.dpm.module.management.server.dao.IMeetingRoomDao;
import com.deppon.dpm.module.management.server.service.IMeetingRoomService;
import com.deppon.dpm.module.management.shared.domain.MeetingRoomEntity;
import com.deppon.dpm.module.management.shared.vo.MeetingResultVo;
import com.deppon.dpm.module.management.util.HttpClientUtil;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class MeetingRoomService implements IMeetingRoomService {
	
	/**
	 * 日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MeetingRoomService.class);
	
	private IMeetingRoomDao meetingRoomDao;

	private String meetingRoomHost;
	
	private IExternalMethodService externalMethodService;
	
	/**
	 * 获取会议室地址
	 * @throws IOException 
	 */
	public MeetingResultVo getAreaName() throws IOException{
		
		String getareanameUrl = meetingRoomHost + "/notice/meetingOrder/getMeetingAddress";
		
		MeetingResultVo meetingResVo = new MeetingResultVo();
		String resultstr = "";
		
			resultstr = HttpClientUtil.httpPost(getareanameUrl,"");
			//String resultstr = "{\"success\":true,\"flag\":\"\",\"message\":\"success\",\"code\":0,\"data\":[{\"ADDRESS\":\"江苏事业部\"},{\"ADDRESS\":\"沈阳转运中心\"},{\"ADDRESS\":\"陈村二号办公楼\"},{\"ADDRESS\":\"重庆大区\"}]}";
			System.out.println(resultstr);
			
			//List<Map> addresslist = new ArrayList<Map>();
			if(resultstr != null && resultstr != ""){
				meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
				//addresslist = JSONArray.parseArray(meetingResVo.getData().toString(), Map.class);
				//System.out.println(addresslist);
			}
			
			
		return meetingResVo;
	}
	
	/**
	 * 根据会议室地址查询会议室名称
	 */
	public MeetingResultVo getmeetingRoomName(String areaName) throws IOException{
		String getmrnameUrl = meetingRoomHost + "/notice/meetingOrder/getRoomByAddr"; //+ "areaId=" + areaName;
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(getmrnameUrl + "?areaId="+ URLEncoder.encode(areaName, "utf-8"),"");	
		/*HttpClient client = new HttpClient();
	        PostMethod post = new PostMethod(getmrnameUrl+ "?areaId="+URLEncoder.encode(areaName, "utf-8"));
	        client.executeMethod(post);
	        String responseBody = post.getResponseBodyAsString();
	        System.out.println(responseBody);*/

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}
	
	/**
	 * 查询会议室
	 */
	public MeetingResultVo getMeetingOrder(
			String curPage, int size, String beginDate, String areaName, String meetingRoomId, String status) throws IOException{
		String getmeetingOrderUrl = meetingRoomHost + "/notice/meetingOrder/getMeetingOrder";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();
		
		String json = "?"
		        + "curPage=" + curPage
				+ "&size=" + size
				+ "&beginDate=" + beginDate
				+ "&status=" + status;
		
		if(areaName != null && !areaName.equals("")){
			json = json + "&areaId=" + URLEncoder.encode(areaName, "utf-8");
		}
		if(meetingRoomId != null && !meetingRoomId.equals("")){
			json = json + "&meetingRoomId=" + meetingRoomId;
		}
		
		LOGGER.info("------查询会议室-----json：" + json);

		resultstr = HttpClientUtil.httpPost(getmeetingOrderUrl + json,"");

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}
	
	
	/**
	 * 查询最高参会人（非副总）
	 */
	public MeetingResultVo getAllUserInfo(String loginId, String lastName, String departmentName, int pageNum, int pageSize) throws IOException{
		String getalluserUrl = meetingRoomHost + "/notice/hrmResource/getAllUserInfo";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();
		
		String json = "?"
				+ "pageNum=" + pageNum
				+ "&pageSize=" + pageSize;
		
		if(loginId != null && !loginId.equals("")){
			json = json + "&loginId=" + loginId;
		}
		if(lastName != null && !lastName.equals("")){
			json = json + "&lastName=" + URLEncoder.encode(lastName, "utf-8");
		}
		if(departmentName != null && !departmentName.equals("")){
			json = json + "&departmentName=" + URLEncoder.encode(departmentName, "utf-8");
		}
		
		resultstr = HttpClientUtil.httpPost(getalluserUrl + json,"");

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}
	
	/**
	 * 查询最高参会人（副总）
	 */
	public MeetingResultVo getAllCEO() throws IOException{
		String getallceoUrl = meetingRoomHost + "/notice/hrmResource/getAllCEO";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(getallceoUrl,"");

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}

	    return meetingResVo;
	}
	
	/**
	 * 会议室预定
	 * String meetingroomid,String meetingdate,String ceologinid,String highloginid,
			String starttime,String endtime,Long quantity,String putrequest,String motif,String ceoattend
	 */
	public MeetingResultVo insertMeetingRoomBook(MeetingRoomEntity mrEntity) throws IOException{
		
		String roomBookUrl = meetingRoomHost + "/notice/meetingRoomBook/insertMeetingRoomBook";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		String json = "?"
				+ "meetingroomid=" + mrEntity.getMeetingRoomId()
				+ "&meetingdate=" + mrEntity.getMeetingDate()
				+ "&orderuserid=" + mrEntity.getOrderUserId()
				+ "&starttime=" + mrEntity.getStartTime()
				+ "&endtime=" + mrEntity.getEndTime()
				+ "&quantity=" + mrEntity.getQuantity()
				+ "&putrequest=" + URLEncoder.encode(mrEntity.getPutreOuest(), "utf-8")
				+ "&motif=" + URLEncoder.encode(mrEntity.getMotif(), "utf-8")
				+ "&ceoattend=" + mrEntity.getCeoAttend();
		
		if(mrEntity.getCeoLoginId() != null && !mrEntity.getCeoLoginId().equals("")){
			json = json + "&ceologinid=" + mrEntity.getCeoLoginId();
		}
		if(mrEntity.getHighLoginId() != null && !mrEntity.getHighLoginId().equals("")){
			json = json + "&highloginid=" + mrEntity.getHighLoginId();
		}		
		LOGGER.info("------" + mrEntity.getOrderUserId() +  "会议室预定-----json：" + json);
		
		resultstr = HttpClientUtil.httpPost(roomBookUrl + json,"");
		LOGGER.info("------" + mrEntity.getOrderUserId() +  "会议室预定-----resultstr：" + resultstr);
		
		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
		
	    return meetingResVo;
	}
	
	
	/**
	 * 查询已预订会议室
	 */
	public MeetingResultVo getOrderedRoom(String mobileLoginCode, String curPage, int size) throws IOException{
		
		String getOrderedRoomUrl = meetingRoomHost + "/notice/meetingOrder/getOrderedRoom";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(getOrderedRoomUrl + "?"
				+ "mobileLoginCode=" + mobileLoginCode
				+ "&curPage=" + curPage
				+ "&size=" + size
				,"");
		LOGGER.info("------" + mobileLoginCode +  "查询已预订会议室-----resultstr：" + resultstr);
		
		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
		
	    return meetingResVo;
	}
	
	
	
	/**
	 * 会议室预定修改
	 */
	public MeetingResultVo updateMeetingRoomBook(MeetingRoomEntity mrEntity) throws IOException{
		
		String uproomBookUrl = meetingRoomHost + "/notice/meetingRoomBook/insertMeetingRoomBook";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(uproomBookUrl + "?"
				+ "meetingroomid=" + mrEntity.getMeetingRoomId()
				+ "&bookid=" + mrEntity.getBookId()
				+ "&orderuserid=" + mrEntity.getOrderUserId()
				+ "&meetingdate=" + mrEntity.getMeetingDate()
				+ "&ceologinid=" + mrEntity.getCeoLoginId()
				+ "&highloginid=" + mrEntity.getHighLoginId()
				+ "&starttime=" + mrEntity.getStartTime()
				+ "&endtime=" + mrEntity.getEndTime()
				+ "&quantity=" + mrEntity.getQuantity()
				+ "&putrequest=" + URLEncoder.encode(mrEntity.getPutreOuest(), "utf-8")
				+ "&motif=" + URLEncoder.encode(mrEntity.getMotif(), "utf-8")
				+ "&ceoattend=" + mrEntity.getCeoAttend()
				,"");
		LOGGER.info("------" + mrEntity.getOrderUserId() +  "会议室预定修改-----resultstr：" + resultstr);

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}
	
	
	/**
	 * 会议室预定删除
	 */
	public MeetingResultVo delMeetingBookByBookId(String bookIds)  throws IOException{
		
		String delroomBookUrl = meetingRoomHost + "/notice/meetingRoomBook/delMeetingBookByBookId";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(delroomBookUrl + "?"
				+ "bookIds=" + bookIds
				,"");
		LOGGER.info("------" + bookIds +  "会议室预定删除-----resultstr：" + resultstr);
		
		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}	
	
	/**
	 * 会议室预定提前结束
	 */
	public MeetingResultVo endMeetingRoomBook(String bookid, String status, String isAhead) throws IOException{
		
		String uproomBookUrl = meetingRoomHost + "/notice/meetingRoomBook/updateMeetingRoomBook";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(uproomBookUrl + "?"
				+ "bookid=" + bookid
				+ "&status=" + URLEncoder.encode(status, "utf-8")
				+ "&isAhead=" + isAhead
				,"");
		LOGGER.info("------" + bookid +  "会议室预定提前结束-----resultstr：" + resultstr);

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}
	
	/**
	 * 查询已预完会议室
	 */
	public MeetingResultVo getMeetingOrdered(String beginDate, String areaName) throws IOException{
		
		String getmeetingOrderedUrl = meetingRoomHost + "/notice/meetingOrder/getOrderMeetingMobile";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();
		
		String json = "?"
				+ "beginDate=" + beginDate;
		
		if(areaName != null && !areaName.equals("")){
			json = json + "&areaId=" + URLEncoder.encode(areaName, "utf-8");
		}
		/*if(meetingRoomId != null && !meetingRoomId.equals("")){
			json = json + "&meetingRoomId=" + meetingRoomId;
		}*/
		
		LOGGER.info("------查询已预完会议室-----json：" + json);

		resultstr = HttpClientUtil.httpPost(getmeetingOrderedUrl + json,"");

		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
				
	    return meetingResVo;
	}
	
	/**
	 * 查询已预完会议室预订人明细
	 */
	public MeetingResultVo getAllOrderUser(String meetingDate, String meetingRoomId) throws IOException{
		
		String getOrderUserUrl = meetingRoomHost + "/notice/meetingOrder/queryMeetingroomMobile";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(getOrderUserUrl + "?"
				+ "meetingDate=" + meetingDate
				+ "&meetingRoomId=" + meetingRoomId
				,"");
		LOGGER.info("------" + meetingRoomId +  "查询已预完会议室预订人明细-----resultstr：" + resultstr);
		
		if(resultstr != null && resultstr != ""){
			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
		
	    return meetingResVo;
	}
	
	
	/**
	 * 查询已预订会议室——通知中心
	 */
	public List<Map> getOrderedRoomForMP(String mobileLoginCode, String curPage, int size) throws IOException{
		
		String getOrderedRoomUrl = meetingRoomHost + "/notice/meetingOrder/getOrderedRoom";
		
		String resultstr = "";
		MeetingResultVo meetingResVo = new MeetingResultVo();

		resultstr = HttpClientUtil.httpPost(getOrderedRoomUrl + "?"
				+ "mobileLoginCode=" + mobileLoginCode
				+ "&curPage=" + curPage
				+ "&size=" + size
				,"");

		if(resultstr != null && resultstr != ""){

			meetingResVo = JSON.parseObject(resultstr, MeetingResultVo.class);
		}
		
		JSONObject jsonObj = JSONObject.parseObject(meetingResVo.getData().toString());
		JSONArray jsonArr= JSON.parseArray(jsonObj.getString("list").toString());
		List<Map> orlist = JSONArray.parseArray(jsonArr.toJSONString(), Map.class);
		
		List<Map> orderedRoomlist = new ArrayList<Map>();
		
	    Date dt = new Date();   
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");   
	    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");   
	    String nowdate = sdf1.format(dt);
	    String nowtime = sdf2.format(dt);
	    
		for(Map room : orderedRoomlist){
			
			if(room.get("meetingDate").toString().equals(nowdate)){
				int diff = 0;
				try {
					Date date1 = sdf2.parse(nowtime);
					Date date2 = sdf2.parse(room.get("startTime").toString());
					diff = (int)((date2.getTime() - date1.getTime()) / 1000);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(diff > 0 && diff <= 600){
					orderedRoomlist.add(room);
				}				
			}		
		}
		
	    return orderedRoomlist;
	}
	
	/**
	 * 获取预订人手机号
	 * @param userId
	 * @return
	 */
	public String getMobileNum(String userId){
		
		String mobile = "";
		EmployeeVO emp = externalMethodService.getEmpInfo(userId);
		if(emp != null && emp.getMobileNo() != null && emp.getMobileNo() != ""){
			mobile = emp.getMobileNo();
		}else{
			mobile = "00000000000";
		}
		return mobile;
	}
	
	
	
	
	
	public IMeetingRoomDao getMeetingRoomDao() {
		return meetingRoomDao;
	}

	public void setMeetingRoomDao(IMeetingRoomDao meetingRoomDao) {
		this.meetingRoomDao = meetingRoomDao;
	}


	public String getMeetingRoomHost() {
		return meetingRoomHost;
	}


	public void setMeetingRoomHost(String meetingRoomHost) {
		this.meetingRoomHost = meetingRoomHost;
	}

	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	public void setExternalMethodService(IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}
	
	

}
