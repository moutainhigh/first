package com.deppon.dpm.doc.server.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IKeepOnRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
/**
 * 备案记录查询接口
 * @author lvdf
 * @2018年1月18日14:52:37
 *
 */

public class KeepOnRecordAction extends BaseAction{

	private static final Logger logger = LoggerFactory.getLogger(KeepOnRecordAction.class);
	
	private static final long serialVersionUID = 4781837917115427801L;
	
	//备案人接口
	private IKeepOnRecordService keepOnRecordService;
	
	//备案人ID
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
	public int limit = 10;
	
	//请求页面数据
	private int requestnum;
	
	//记录总数
	private int totalnum;
	
	//开始日期
	private String starttime;
	
	//结束日期
	private String endtime;
	
	private String didi_picaddress;
	public static final int code1 = 200; 
	public static final int code2 = 400;
	/**
	 * 我的备案审核结果
	 */
	@CookieNotCheckedRequired
	public void resultStateRecord(){
		JSONObject jonum = new JSONObject();
		int beginNum = getRecordIndex();// 定位请求的首条数据库位置
		List<DiDiRecordVO> listall = keepOnRecordService.queryRecordAll(userId, recordtype, recordstate);
		List<DiDiRecordVO> querylist= keepOnRecordService.query(userId, recordtype, recordstate, beginNum, limit);
		for (int i = 0; i < querylist.size(); i++) {
			//拆分图片的字符串
			String recordpic = querylist.get(i).getRecordpic();
			String[] recordpicArray = recordpic.split(",");
			querylist.get(i).setRecordpicArray(recordpicArray);
			//设置备案状态
			String recordstate=querylist.get(i).getRecordstate();
			if(recordstate.equals("1")){
				querylist.get(i).setRecordstate("通过");
			}else if(recordstate.equals("2")){
				querylist.get(i).setRecordstate("不通过");
			}else{
				querylist.get(i).setRecordstate("待审核");
			}
			//设置备案类型
			String recordtype=querylist.get(i).getRecordtype();
			if(recordtype.equals("1")){
				querylist.get(i).setRecordtype("系统异常");
			}else{
				querylist.get(i).setRecordtype("未配置预算");
			}
		}
		jonum.put("msg", "success");
		jonum.put("querylist", querylist);
		jonum.put("pageNum", getTotalPage(listall));
		jonum.put("count", listall.size());
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	
	/**
	 * 根据备案人ID查询全部信息
	 * 2018年1月20日10:51:30
	 * @author lvdf
	 */
	
	@CookieNotCheckedRequired
	public void queryKeepOnRecordById(){
		JSONObject jonum = new JSONObject();
		if(userId==null){
			List<DiDiRecordVO> list=keepOnRecordService.queryAllDidiRecord();
			jonum.put("List", list);
		}else{
			List<DiDiRecordVO> list=keepOnRecordService.queryKeepRecordById(userId);
			if(list==null){
				jonum.put("msg", "");
			}else{
				jonum.put("List", list);
			}	
		}
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	
	/**
	 * 根据条件分页查询
	 * 2018年1月20日10:51:38
	 * @author lvdf
	 */
	@CookieNotCheckedRequired
	public void queryRecordByCondition(){
		JSONObject jonum = new JSONObject();
		//将空参数全部制空
		if("".equals(userId)){
			userId=null;
		}if("".equals(userName)){
			userName=null;
		}if("".equals(dept)){
			dept=null;
		}if("".equals(recordtime)){
			recordtime=null;
		}if("".equals(recordtype)){
			recordtype=null;
		}if("".equals(recordstate)){
			recordstate=null;
		}if("".equals(starttime)){
			starttime=null;
		}if("".equals(endtime)){
			endtime=null;
		}if("".equals(limit) || limit==0){
			limit=10;
		}
		if(pageNum==-1){
			//直接查询全部
			List<DiDiRecordVO>  list=keepOnRecordService.queryAllDidiRecord();
			for (int i = 0; i < list.size(); i++) {
				//拆分图片的字符串
				String recordpic = list.get(i).getRecordpic();
				String[] recordpicArray = recordpic.split(",");
				list.get(i).setRecordpicArray(recordpicArray);
				//设置备案状态
				String recordstate=list.get(i).getRecordstate();
				if(recordstate.equals("1")){
					list.get(i).setRecordstate("通过");
				}else if(recordstate.equals("2")){
					list.get(i).setRecordstate("不通过");
				}else{
					list.get(i).setRecordstate("待审核");
				}
				//设置备案类型
				String recordtype=list.get(i).getRecordtype();
				if(recordtype.equals("1")){
					list.get(i).setRecordtype("系统异常");
				}else{
					list.get(i).setRecordtype("未配置预算");
				}
			}
			jonum.put("code", code1);
			jonum.put("msg", "");
			jonum.put("imgurl", didi_picaddress);
			jonum.put("List", list);
		}else{
			if((starttime==null || endtime.length()==0)  && (endtime==null || endtime.length()==0)){
				//走移动端的查询 根据条件返回总条数
				DiDiRecordVO diDiRecord = new DiDiRecordVO();
				diDiRecord.setUserId(userId);
				diDiRecord.setUserName(userName);
				diDiRecord.setDept(dept);
				diDiRecord.setRecordtime(recordtime);
				diDiRecord.setRecordtype(recordtype);
				diDiRecord.setRecordstate(recordstate);
				List<DiDiRecordVO> list=keepOnRecordService.queryAllDidiRecordByConditionIntMobile(diDiRecord);
				totalnum=list.size();//数据总条数
				if(totalnum==0){
					//失败400
					jonum.put("msg", "success");
					jonum.put("List", list);
					jonum.put("count", totalnum);
				}else{
					// 返回请求数据
					int requestbeginNum = getRecordIndex();// 定位请求的首条数据库位置
					jonum.put("totalnum", getTotalPage(list));//返回总页数
					//移动端根据条件和起始位置进行分页查询
					List<DiDiRecordVO> listOrder=keepOnRecordService.queryRecordByConditionMobile(diDiRecord,requestbeginNum,limit);
					for (int i = 0; i < listOrder.size(); i++) {
						//拆分图片字符串，穿成数组
						String recordpic = listOrder.get(i).getRecordpic();
						String[] recordpicArray = recordpic.split(",");
						listOrder.get(i).setRecordpicArray(recordpicArray);
						//设置备案状态
						String recordstate=listOrder.get(i).getRecordstate();
						if(recordstate.equals("1")){
							listOrder.get(i).setRecordstate("通过");
						}else if(recordstate.equals("2")){
							listOrder.get(i).setRecordstate("不通过");
						}else{
							listOrder.get(i).setRecordstate("待审核");
						}
						//设置备案类型
						String recordtype=listOrder.get(i).getRecordtype();
						if(recordtype.equals("1")){
							listOrder.get(i).setRecordtype("系统异常");
						}else{
							listOrder.get(i).setRecordtype("未配置预算");
						}
					}
					//成功200
					jonum.put("code", code1);
					jonum.put("msg", "");
					jonum.put("imgurl", didi_picaddress);
					jonum.put("List", listOrder);
					jonum.put("count", totalnum);
				}	
			}else{
				//走PC端查询
				//传入所有参数全传(根据PC端全部条件查出数据总数)
				DiDiRecordVO diDiRecord = new DiDiRecordVO();
				diDiRecord.setUserId(userId);
				diDiRecord.setUserName(userName);
				diDiRecord.setDept(dept);
				diDiRecord.setRecordtime(recordtime);
				diDiRecord.setRecordtype(recordtype);
				diDiRecord.setRecordstate(recordstate);
				List<DiDiRecordVO> list=keepOnRecordService.queryAllDidiRecordByConditionIntPC(diDiRecord,starttime,endtime);
				totalnum=list.size();//数据总条数
				if(totalnum==0){
					//失败400
					jonum.put("code", code2);
					jonum.put("msg", "没有查询到");
					jonum.put("reruestVOlist", 0);
				}else{
					// 返回请求数据
					int requestbeginNum = getRecordIndex();// 定位请求的首条数据库位置
					jonum.put("totalnum", getTotalPage(list));//返回总页数
					//pc端根据条件和起始位置查询
					List<DiDiRecordVO> listOrder=keepOnRecordService.queryRecordByConditionPC(diDiRecord,requestbeginNum,starttime,endtime,limit);
					for (int i = 0; i < listOrder.size(); i++) {
						String recordpic = listOrder.get(i).getRecordpic();
						String[] recordpicArray = recordpic.split(",");
						listOrder.get(i).setRecordpicArray(recordpicArray);
						//设置备案状态
						String recordstate=listOrder.get(i).getRecordstate();
						if(recordstate.equals("1")){
							listOrder.get(i).setRecordstate("通过");
						}else if(recordstate.equals("2")){
							listOrder.get(i).setRecordstate("不通过");
						}else{
							listOrder.get(i).setRecordstate("待审核");
						}
						//设置备案类型
						String recordtype=listOrder.get(i).getRecordtype();
						if(recordtype.equals("1")){
							listOrder.get(i).setRecordtype("系统异常");
						}else{
							listOrder.get(i).setRecordtype("未配置预算");
						}
					}
					//成功传200
					jonum.put("code", code1);
					jonum.put("imgurl", didi_picaddress);
					jonum.put("msg", "success");
					jonum.put("List", listOrder);
				}
			}
		}	
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	
	
	/**
	 * 当前页首条在数据库里的位置
	 * @author lvdf
	 * 2018年1月22日09:16:44
	 * @return
	 */
	public int getRecordIndex() {
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
		if (list.size() % limit == 0) {
			return list.size() / limit;
		}
		else {
			return list.size() / limit + 1;
		}
	}
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public IKeepOnRecordService getKeepOnRecordService() {
		return keepOnRecordService;
	}

	public void setKeepOnRecordService(IKeepOnRecordService keepOnRecordService) {
		this.keepOnRecordService = keepOnRecordService;
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

	/**
	 * @return the didi_picaddress
	 */
	public String getDidi_picaddress() {
		return didi_picaddress;
	}

	/**
	 * @param didi_picaddress the didi_picaddress to set
	 */
	public void setDidi_picaddress(String didi_picaddress) {
		this.didi_picaddress = didi_picaddress;
	}
	
	
	
}
