package com.deppon.dpm.module.management.server.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.service.IMeetingRoomService;
import com.deppon.dpm.module.management.shared.domain.MeetingRoomEntity;
import com.deppon.dpm.module.management.shared.vo.MeetingResultVo;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

public class MeetingRoomAction extends BaseAction{
	
	/**
	 * 日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MeetingRoomAction.class);
	
	private IMeetingRoomService meetingRoomService;
	
	private MeetingRoomEntity meetingRoomEntity;
	
	private static int zero = 0;
	private static int one = 1;
	
	/**
	 * 会议室地址名
	 */
	private String areaName;

    /**
     * 当前页
     */
	private String curPage;
	/**
     * 每页数量
     */
	private int size;
	/**
     * 开始时间
     */
	private String beginDate;
	/**
     * 会议室名称
     */
	private String meetingRoomId;
	/**
     * 会议室状态
     */
	private String status;
	/**
	 * 查询参会人工号
	 */
	private String loginId;
	/**
	 * 查询参会人姓名
	 */
	private String lastName;
	/**
	 * 查询参会人部门
	 */
	private String departmentName;
	/**
	 * 页数
	 */
	private int pageNum;
	/**
	 * 每页数量
	 */
	private int pageSize;

	/**
	 * 登陆工号
	 */
	private String mobileLoginCode;

	/**
	 * 预定id
	 */
	private String bookIds;
	/**
	 * 预定时间
	 */
	private String meetingDate;
    /**
     * 预订人工号
     */
	private String orderUserId;
	/**
	 * ceo参会工号
	 */
	private String ceoLoginId;
	/**
	 * 最高参会人工号
	 */
	private String highLoginId;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 参会人数
	 */
	private Long quantity;
	/**
	 * 会议主题
	 */
	private String putreOuest;
	/**
	 * 备注
	 */
	private String motif;
	/**
	 * ceo是否参会
	 */
	private String ceoAttend;
    /**
     * 预定id
     */
	private BigDecimal bookId;
	/**
	 * 是否提前
	 */
	private String isAhead;
	
	
	
	/**
	 * 首页选择会议室地址
	 */
	public void getAreaNameList(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		List<Map> addresslist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getAreaName();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------"  + userId + "查询会议室地址异常-----" + e.getMessage());
		}
		
		if(meetingResVo != null && meetingResVo.getData() != null){
			addresslist = JSONArray.parseArray(meetingResVo.getData().toString(), Map.class);
			
			jsonObject.put("addresslist", addresslist);
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询会议室地址为空-----");
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 根据会议室地址查询会议室名称
	 */
	public void getmeetingRoomName(){
		
		this.solveCrossDomain();
		System.out.println(ServletActionContext.getRequest().getMethod());	
		
		JSONObject jsonObject = new JSONObject();
		List<Map> meetingRoomlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getmeetingRoomName(areaName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室名称异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室名称异常-----参数：areaName=" + areaName);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){
			meetingRoomlist = JSONArray.parseArray(meetingResVo.getData().toString(), Map.class);
			
			jsonObject.put("meetingRoomlist", meetingRoomlist);
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询会议室名称为空-----");
			LOGGER.info("------" + userId +  "查询会议室名称为空-----参数：areaName=" + areaName);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 查询会议室
	 */
	public void getMeetingOrder(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		List<Map> meetingOrderlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getMeetingOrder(curPage, size, beginDate, areaName, meetingRoomId, status);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室异常-----参数：beginDate=" + beginDate
					+ " areaName=" + areaName + " meetingRoomId=" + meetingRoomId);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){
			
			JSONObject jsonObj = JSONObject.parseObject(meetingResVo.getData().toString());
			if(jsonObj != null){
				JSONArray jsonArr= JSON.parseArray(jsonObj.getString("list").toString());
				meetingOrderlist = JSONArray.parseArray(jsonArr.toJSONString(), Map.class);
			}

			System.out.println(meetingOrderlist);

			jsonObject.put("meetingOrderlist", meetingOrderlist);
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
			jsonObject.put("totalRecords", jsonObj.getString("totalRecords").toString());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询会议室为空-----");
			LOGGER.info("------" + userId +  "查询会议室为空-----参数：beginDate=" + beginDate
					+ " areaName=" + areaName + " meetingRoomId=" + meetingRoomId);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 查询最高参会人（非副总）
	 */
	public void getAllUserInfo(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		List<Map> allUserlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getAllUserInfo(loginId, lastName, departmentName, pageNum, pageSize);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询最高参会人非副总异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "查询最高参会人非副总异常-----参数：loginId=" + loginId
					+ " lastName=" + lastName + " departmentName=" + departmentName);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){
			
			JSONObject jsonObj = JSONObject.parseObject(meetingResVo.getData().toString());
			if(jsonObj != null){
				JSONArray jsonArr= JSON.parseArray(jsonObj.getString("list").toString());
				allUserlist = JSONArray.parseArray(jsonArr.toJSONString(), Map.class);
			}

			System.out.println(allUserlist);

			jsonObject.put("allUserlist", allUserlist);
			jsonObject.put("totalRecords", jsonObj.getString("totalRecords").toString());
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询最高参会人非副总为空-----");
			LOGGER.info("------" + userId +  "查询最高参会人非副总为空-----参数：loginId=" + loginId
					+ " lastName=" + lastName + " departmentName=" + departmentName);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 查询最高参会人（副总）
	 */
	public void getAllCEO(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		List<Map> allCEOlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getAllCEO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询最高参会人副总异常-----" + e.getMessage());
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			allCEOlist = JSONArray.parseArray(meetingResVo.getData().toString(), Map.class);
			
			jsonObject.put("allCEOlist", allCEOlist);
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询最高参会人副总为空-----");
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 会议室预定
	 * @return
	 */
	public void insertMeetingRoomBook(){
		
		this.solveCrossDomain();
		System.out.println(ServletActionContext.getRequest().getMethod());	
		
		JSONObject jsonObject = new JSONObject();
		
		//操作校验
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		if(userId != null && !userId.equals(orderUserId)){
			Result<String> res = new Result<String>();
			
			jsonObject.put("code", 1);
			jsonObject.put("message", "非登录工号，无操作权限");
	        writeToPage(jsonObject);
		}
		
		//List<Map> allCEOlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			
			MeetingRoomEntity meetingRoomEntity = new MeetingRoomEntity();
			meetingRoomEntity.setMeetingRoomId(meetingRoomId);
			meetingRoomEntity.setMeetingDate(meetingDate);
			meetingRoomEntity.setOrderUserId(orderUserId);
			meetingRoomEntity.setCeoLoginId(ceoLoginId);
			meetingRoomEntity.setHighLoginId(highLoginId);
			meetingRoomEntity.setStartTime(startTime);
			meetingRoomEntity.setEndTime(endTime);
			meetingRoomEntity.setQuantity(quantity);
			meetingRoomEntity.setPutreOuest(putreOuest);
			meetingRoomEntity.setMotif(motif);
			meetingRoomEntity.setCeoAttend(ceoAttend);
			
			meetingResVo = meetingRoomService.insertMeetingRoomBook(meetingRoomEntity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定异常-----参数：meetingRoomId=" + meetingRoomId
					+ " meetingDate=" + meetingDate + " orderUserId=" + orderUserId
					+ " ceoLoginId=" + ceoLoginId + " highLoginId=" + highLoginId
					+ " startTime=" + startTime + " endTime=" + endTime
					+ " quantity=" + quantity + " ceoAttend=" + ceoAttend);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			jsonObject.put("code", meetingResVo.getCode());
			jsonObject.put("message", meetingResVo.getMessage());
			jsonObject.put("msg", meetingResVo.getSuccess());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "会议室预定为空-----");
			LOGGER.info("------" + userId +  "会议室预定为空-----参数：meetingRoomId=" + meetingRoomId
					+ " meetingDate=" + meetingDate + " orderUserId=" + orderUserId
					+ " ceoLoginId=" + ceoLoginId + " highLoginId=" + highLoginId
					+ " startTime=" + startTime + " endTime=" + endTime
					+ " quantity=" + quantity + " ceoAttend=" + ceoAttend);
		}
		writeToPage(jsonObject);
	}
	
	
	/**
	 * 查询已预订会议室
	 * @return
	 */
	public void getOrderedRoom(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		List<Map> orderedRoomlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getOrderedRoom(mobileLoginCode, curPage, size);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询已预订会议室异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "查询已预订会议室异常-----参数：mobileLoginCode=" + mobileLoginCode);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			JSONObject jsonObj = JSONObject.parseObject(meetingResVo.getData().toString());
			if(jsonObj != null){
				JSONArray jsonArr= JSON.parseArray(jsonObj.getString("list").toString());
				orderedRoomlist = JSONArray.parseArray(jsonArr.toJSONString(), Map.class);
			}
					
			jsonObject.put("orderedRoomlist", orderedRoomlist);
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询已预订会议室为空-----");
			LOGGER.info("------" + userId +  "查询已预订会议室为空-----参数：mobileLoginCode=" + mobileLoginCode);
		}
		writeToPage(jsonObject);
	}
	
	
	/**
	 * 会议室预定修改
	 * @return
	 */
	public void updateMeetingRoomBook(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		
		//操作校验
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		if(userId != null && !userId.equals(orderUserId)){
			Result<String> res = new Result<String>();
			jsonObject.put("code", 1);
			jsonObject.put("message", "非登录工号，无操作权限");
			writeToPage(jsonObject);
		}		
		
		//List<Map> allCEOlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			
			MeetingRoomEntity meetingRoomEntity = new MeetingRoomEntity();
			meetingRoomEntity.setMeetingRoomId(meetingRoomId);
			meetingRoomEntity.setBookId(bookId);
			meetingRoomEntity.setMeetingDate(meetingDate);
			meetingRoomEntity.setOrderUserId(orderUserId);
			meetingRoomEntity.setCeoLoginId(ceoLoginId);
			meetingRoomEntity.setHighLoginId(highLoginId);
			meetingRoomEntity.setStartTime(startTime);
			meetingRoomEntity.setEndTime(endTime);
			meetingRoomEntity.setQuantity(quantity);
			meetingRoomEntity.setPutreOuest(putreOuest);
			meetingRoomEntity.setMotif(motif);
			meetingRoomEntity.setCeoAttend(ceoAttend);
			
			meetingResVo = meetingRoomService.updateMeetingRoomBook(meetingRoomEntity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定修改异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定修改异常-----参数：meetingRoomId=" + meetingRoomId + " bookId=" + bookId
					+ " meetingDate=" + meetingDate + " orderUserId=" + orderUserId
					+ " ceoLoginId=" + ceoLoginId + " highLoginId=" + highLoginId
					+ " startTime=" + startTime + " endTime=" + endTime
					+ " quantity=" + quantity + " ceoAttend=" + ceoAttend);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			jsonObject.put("code", meetingResVo.getCode());
			jsonObject.put("message", meetingResVo.getMessage());
			jsonObject.put("msg", meetingResVo.getSuccess());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "会议室预定修改为空-----");
			LOGGER.info("------" + userId +  "会议室预定修改为空-----参数：meetingRoomId=" + meetingRoomId + " bookId=" + bookId
					+ " meetingDate=" + meetingDate + " orderUserId=" + orderUserId
					+ " ceoLoginId=" + ceoLoginId + " highLoginId=" + highLoginId
					+ " startTime=" + startTime + " endTime=" + endTime
					+ " quantity=" + quantity + " ceoAttend=" + ceoAttend);
		}
		writeToPage(jsonObject);
	}
	
	
	/**
	 * 会议室预定删除
	 * @return
	 */
	public void delMeetingBookByBookId(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		//操作校验
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		if(userId != null && !userId.equals(orderUserId)){
			Result<String> res = new Result<String>();
			jsonObject.put("code", 1);
			jsonObject.put("message", "非登录工号，无操作权限");
			writeToPage(jsonObject);
		}		
		
		//List<Map> allCEOlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.delMeetingBookByBookId(bookIds);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定删除异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定删除异常-----参数：bookIds=" + bookIds);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			jsonObject.put("code", meetingResVo.getCode());
			jsonObject.put("message", meetingResVo.getMessage());
			jsonObject.put("msg", meetingResVo.getSuccess());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "会议室预定删除为空-----");
			LOGGER.info("------" + userId +  "会议室预定删除为空-----参数：bookIds=" + bookIds);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 会议室预定提前结束
	 * @return
	 */
	public void endMeetingRoomBook(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();	
		
		//List<Map> allCEOlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.endMeetingRoomBook(bookIds, userId, isAhead);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定删除异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "会议室预定删除异常-----参数：bookIds=" + bookIds);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			jsonObject.put("code", meetingResVo.getCode());
			jsonObject.put("message", meetingResVo.getMessage());
			jsonObject.put("msg", meetingResVo.getSuccess());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "会议室预定删除为空-----");
			LOGGER.info("------" + userId +  "会议室预定删除为空-----参数：bookIds=" + bookIds);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 查询已预完会议室
	 */
	public void getMeetingOrdered(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		List<Map> meetingOrderedlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getMeetingOrdered(beginDate, areaName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室异常-----参数：beginDate=" + beginDate
					+ " areaName=" + areaName);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){
			
			JSONObject jsonObj = JSONObject.parseObject(meetingResVo.getData().toString());
			if(jsonObj != null){
				JSONArray jsonArr= JSON.parseArray(jsonObj.getString("list").toString());
				meetingOrderedlist = JSONArray.parseArray(jsonArr.toJSONString(), Map.class);
			}

			System.out.println(meetingOrderedlist);

			jsonObject.put("list", meetingOrderedlist);
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询会议室已预完为空-----");
			LOGGER.info("------" + userId +  "查询会议室已预完为空-----参数：beginDate=" + beginDate
					+ " areaName=" + areaName);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 查询已预完会议室预订人明细
	 */
	public void getAllOrderUser(){
		
		this.solveCrossDomain();
		
		JSONObject jsonObject = new JSONObject();
		//List<Map> meetingOrderedlist = new ArrayList<Map>();
		MeetingResultVo meetingResVo = null;
		try {
			meetingResVo = meetingRoomService.getAllOrderUser(meetingDate, meetingRoomId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室预订人明细异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "查询会议室预订人明细异常-----参数：meetingDate=" + meetingDate
					+ " meetingRoomId=" + meetingRoomId);
		}
		if(meetingResVo != null && meetingResVo.getData() != null){

			jsonObject.put("list", meetingResVo.getData());
			jsonObject.put("msg", meetingResVo.getSuccess());
			jsonObject.put("code", meetingResVo.getCode());
		}else{
			jsonObject.put("msg", "查询结果为空");
			LOGGER.info("------" + userId +  "查询会议室预订人明细为空-----");
			LOGGER.info("------" + userId +  "查询会议室预订人明细为空-----参数：meetingDate=" + meetingDate
					+ " meetingRoomId=" + meetingRoomId);
		}
		writeToPage(jsonObject);
	}
	
	/**
	 * 获取预订人手机号
	 */
	public void getMobileNum(){
		
        this.solveCrossDomain();	
		JSONObject jsonObject = new JSONObject();
		String mobile = "";
		try {
			mobile = meetingRoomService.getMobileNum(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("e", "抛异常");
			jsonObject.put("exception", e.getMessage());
			jsonObject.put("code", one);
			LOGGER.info("------" + userId +  "获取预订人手机号异常-----" + e.getMessage());
			LOGGER.info("------" + userId +  "获取预订人手机号异常-----");
		}
		jsonObject.put("data", mobile);
		jsonObject.put("code", zero);
		writeToPage(jsonObject);
	}
	
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	
	
	
	public IMeetingRoomService getMeetingRoomService() {
		return meetingRoomService;
	}

	public void setMeetingRoomService(IMeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getMeetingRoomId() {
		return meetingRoomId;
	}

	public void setMeetingRoomId(String meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public MeetingRoomEntity getMeetingRoomEntity() {
		return meetingRoomEntity;
	}

	public void setMeetingRoomEntity(MeetingRoomEntity meetingRoomEntity) {
		this.meetingRoomEntity = meetingRoomEntity;
	}

	public String getMobileLoginCode() {
		return mobileLoginCode;
	}

	public void setMobileLoginCode(String mobileLoginCode) {
		this.mobileLoginCode = mobileLoginCode;
	}

	public String getBookIds() {
		return bookIds;
	}

	public void setBookIds(String bookIds) {
		this.bookIds = bookIds;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}

	public String getCeoLoginId() {
		return ceoLoginId;
	}

	public void setCeoLoginId(String ceoLoginId) {
		this.ceoLoginId = ceoLoginId;
	}

	public String getHighLoginId() {
		return highLoginId;
	}

	public void setHighLoginId(String highLoginId) {
		this.highLoginId = highLoginId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getPutreOuest() {
		return putreOuest;
	}

	public void setPutreOuest(String putreOuest) {
		this.putreOuest = putreOuest;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getCeoAttend() {
		return ceoAttend;
	}

	public void setCeoAttend(String ceoAttend) {
		this.ceoAttend = ceoAttend;
	}

	public BigDecimal getBookId() {
		return bookId;
	}

	public void setBookId(BigDecimal bookId) {
		this.bookId = bookId;
	}

	public String getIsAhead() {
		return isAhead;
	}

	public void setIsAhead(String isAhead) {
		this.isAhead = isAhead;
	}
	

}
