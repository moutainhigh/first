package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IPcKeepRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * @ClassName:PcKeepRecordAction
 * @author 吕德富
 * @Desciption:TODO(PC端备案查询接口)
 * @date:2018年4月3日10:33:47
 */
public class PcKeepRecordAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7586240443322095442L;

	
	/**
	 * 注入service
	 */
	private IPcKeepRecordService  pcKeepRecordService;

	//备案人工号
	private String userId;
	
	//备案人姓名
	private String userName;
	
	//备案人部门
	private String dept;
	
	//备案时间
	private String recordtime;
	
	//备案类型
	private String recordtype;
	
	//备案状态
	private String recordstate;
	
	//起始页数
	private int pageNum;

	//每页条数
	public int limit;
	
	//请求页面数据
	private int requestnum;
	
	//记录总页数
	private int totalnum;
	
	//开始日期
	private String starttime;
	
	//结束日期
	private String endtime;
	
	
	private String didi_picaddress;
	
	//成功返回的信息200,设置为静态常量
	public static final int code1 = 200;
	
	//失败返回的信息400,设置为静态常量
	public static final int code2 = 400;
	
	/**
	 * @Desciption:TODO(根据条件查询备案记录)
	 * @author: lvdf
	 * @date:2018年4月3日10:37:37
	 * @return null
	 */
	@CookieNotCheckedRequired
	public void queryKeepRecordPC(){
		JSONObject jonum = new JSONObject();
		//删除userId为null的字段
		pcKeepRecordService.deleteByUserId();
		String StartTime = null; //开始时间
		String Endtime = null; //结束时间
		if(StringUtils.isNotEmpty(starttime)){
			//处理starttime
			String newStartTime = starttime.substring(0, 10);
			String[] newStartTimeArray = newStartTime.split("/");
			StartTime = newStartTimeArray[0]+"-"+newStartTimeArray[1]+"-"+newStartTimeArray[2]+" "+"00:00:00";
		}
		if(StringUtils.isNotEmpty(endtime)){
			//处理endtime格式
			String newEndTime = endtime.substring(0, 10);
			String[] newEndTimeArray = newEndTime.split("/");
			Endtime = newEndTimeArray[0]+"-"+newEndTimeArray[1]+"-"+newEndTimeArray[2]+" "+"23:59:59";
		}
		//传入参数
		DiDiRecordVO diDiRecord = new DiDiRecordVO();
		diDiRecord.setUserId(userId);
		diDiRecord.setUserName(userName);
		diDiRecord.setDept(dept);
		diDiRecord.setRecordtime(recordtime);
		diDiRecord.setRecordtype(recordtype);
		diDiRecord.setRecordstate(recordstate);
		List<DiDiRecordVO> list=pcKeepRecordService.queryRecordAll(diDiRecord,StartTime,Endtime);
		int dataNumber =0;
		if(list==null){
			dataNumber=0;
		}else{
			dataNumber = list.size(); //数据总条数
		}
		if(dataNumber==0){
			//没有任何条件直接查询的话,显示空
			List<DiDiRecordVO> listEmpty = new ArrayList<DiDiRecordVO>();
			//失败400
			jonum.put("code", code2);
			jonum.put("msg", "没有查询到");
			jonum.put("reruestVOlist", 0);
			jonum.put("List", listEmpty);//返回一个[]的list
			// 返回页面数据
			writeToPage(jonum);
		}else{
			// 返回请求数据
			int requestbeginNum = getRecordIndex();// 定位请求的首条数据库位置
			totalnum=getTotalPage(list);//总页数
			jonum.put("totalnum", dataNumber);//返回总条数
			//根据条件和起始位置查询
			List<DiDiRecordVO> listOrder=pcKeepRecordService.queryRecordByCondition(diDiRecord,requestbeginNum,StartTime,Endtime,limit==0?10:limit);
			if(listOrder==null){
				//没有查询到返回空list
				List<DiDiRecordVO> listEmpty = new ArrayList<DiDiRecordVO>();
				//失败400
				jonum.put("code", code2);
				jonum.put("msg", "没有查询到");
				jonum.put("reruestVOlist", 0);
				jonum.put("List", listEmpty);//返回一个[]的list
				// 返回页面数据
				writeToPage(jonum);
			}else{
				//成功传200
				jonum.put("code", code1);
				jonum.put("imgurl", didi_picaddress);
				jonum.put("msg", "success");
				jonum.put("List", listOrder);
				// 返回页面数据
				writeToPage(jonum);
			}
		}
	}
	
	
	
	/**
	 * 当前页首条在数据库里的位置
	 * @author lvdf
	 * 2018年1月22日09:16:44
	 * @return
	 */
	public int getRecordIndex() {
		if(pageNum==0  || String.valueOf(pageNum)==null){
			pageNum=1;
		}
		return (pageNum - 1) * limit;
	}
	
	/**
	 * 获取总页数
	 * @author lvdf
	 * 2018年1月22日09:58:13
	 * @return
	 */
	public int getTotalPage(List<DiDiRecordVO> list) {
		if (list == null) {
			return 0;
		}
		if(limit==0 || String.valueOf(limit)==null){
			limit=10;
		}
		if (list.size() % limit == 0) {
			return list.size() / limit;
		}
		else {
			return list.size() / limit + 1;
		}
	}
	
	
	
	public IPcKeepRecordService getPcKeepRecordService() {
		return pcKeepRecordService;
	}


	public void setPcKeepRecordService(IPcKeepRecordService pcKeepRecordService) {
		this.pcKeepRecordService = pcKeepRecordService;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getRecordtime() {
		return recordtime;
	}


	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}


	public String getRecordtype() {
		return recordtype;
	}


	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}


	public String getRecordstate() {
		return recordstate;
	}


	public void setRecordstate(String recordstate) {
		this.recordstate = recordstate;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getRequestnum() {
		return requestnum;
	}


	public void setRequestnum(int requestnum) {
		this.requestnum = requestnum;
	}


	public int getTotalnum() {
		return totalnum;
	}


	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
	
}
