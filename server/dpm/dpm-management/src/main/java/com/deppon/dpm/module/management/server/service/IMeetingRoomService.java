package com.deppon.dpm.module.management.server.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.MeetingRoomEntity;
import com.deppon.dpm.module.management.shared.vo.MeetingResultVo;

public interface IMeetingRoomService {
	
	/**
	 * 获取会议室地址
	 * @throws IOException 
	 */
	public MeetingResultVo getAreaName() throws IOException;
	/**
	 * 根据会议室地址查询会议室名称
	 * @param areaName
	 * @return
	 * @throws IOException 
	 */
	public MeetingResultVo getmeetingRoomName(String areaName) throws IOException;
	/**
	 * 查询会议室
	 * @param curPage
	 * @param size
	 * @param beginDate
	 * @param areaName
	 * @param meetingRoomId
	 * @param status
	 * @return
	 * @throws IOException 
	 */
	public MeetingResultVo getMeetingOrder(String curPage, int size, String beginDate, String areaName, String meetingRoomId, String status) throws IOException;
	/**
	 * 查询最高参会人（非副总）
	 * @param loginId
	 * @param lastName
	 * @param departmentName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws IOException 
	 */
	public MeetingResultVo getAllUserInfo(String loginId, String lastName, String departmentName, int pageNum, int pageSize) throws IOException;
	/**
	 * 查询最高参会人（副总）
	 * @return
	 * @throws IOException 
	 */
	public MeetingResultVo getAllCEO() throws IOException;
	/**
	 * 会议室预定
	 * @param meetingroomid
	 * @param meetingdate
	 * @param ceologinid
	 * @param highloginid
	 * @param starttime
	 * @param endtime
	 * @param quantity
	 * @param putrequest
	 * @param motif
	 * @param ceoattend
	 * @return
	 * @throws IOException 
	 */
	public MeetingResultVo insertMeetingRoomBook(MeetingRoomEntity mrEntity) throws IOException;
	/**
	 * 查询已预订会议室
	 * @param currentLoginCode
	 * @param curPage
	 * @param size
	 * @return
	 */
	public MeetingResultVo getOrderedRoom(String mobileLoginCode, String curPage, int size) throws IOException;
	/**
	 * 会议室预定修改
	 * @param mrEntity
	 * @return
	 */
	public MeetingResultVo updateMeetingRoomBook(MeetingRoomEntity mrEntity) throws IOException;
	/**
	 * 会议室预定删除
	 * @param bookIds
	 * @return
	 */
	public MeetingResultVo delMeetingBookByBookId(String bookIds) throws IOException;
	/**
	 * 会议室预定提前结束
	 * @param bookid
	 * @param status
	 * @param isAhead
	 * @return
	 * @throws IOException
	 */
	public MeetingResultVo endMeetingRoomBook(String bookid, String status, String isAhead) throws IOException;
	/**
	 * 查询已预完会议室
	 * @param beginDate
	 * @param areaName
	 * @return
	 * @throws IOException
	 */
	public MeetingResultVo getMeetingOrdered(String beginDate, String areaName) throws IOException;
	/**
	 * 查询已预完会议室预订人明细
	 * @param meetingDate
	 * @param meetingRoomId
	 * @return
	 * @throws IOException
	 */
	public MeetingResultVo getAllOrderUser(String meetingDate, String meetingRoomId) throws IOException;
	/**
	 * 查询已预订会议室——通知中心
	 * @param mobileLoginCode
	 * @param curPage
	 * @param size
	 * @return
	 */
	public List<Map> getOrderedRoomForMP(String mobileLoginCode, String curPage, int size) throws IOException;
    /**
     * 获取预订人手机号
     * @param userId
     * @return
     */
	public String getMobileNum(String userId);
}
