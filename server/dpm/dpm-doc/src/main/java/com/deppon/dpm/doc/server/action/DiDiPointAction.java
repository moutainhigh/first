package com.deppon.dpm.doc.server.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IDiDiPointService;
import com.deppon.dpm.doc.server.vo.DiDiPointVo;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class DiDiPointAction extends BaseAction{
	
	/**
	 * 构造方法
	 */
	public DiDiPointAction(){
		super();
	}
	private static final Logger logger = LoggerFactory.getLogger(DoubtfulExAuditAction.class);
	
	private static final long serialVersionUID = 1L;
	
	private static final int PAGESIZE_10 = 10;
	
	private IDiDiPointService didiPointService;
	
	private IExternalMethodService externalMethodService;

	private String date;

	private String content;

	private String joblevel;

	private String empCode;

	/**
	 * 页面显示数量
	 */
	private int pageSize = PAGESIZE_10;	
	/**
	 * 总共的页数
	 */
	private int totalpage;
	/**
	 * 起始页
	 */
	private int currentPage = 1;
	/**
	 * 起始条数
	 */
	private int begin;
	/**
	 * 总条数
	 */
	private int count;

	private int pointId;
	

	/**
	 * 首页提示功能
	 */
	@CookieNotCheckedRequired
	public void getPoint(){
		JSONObject jonum = new JSONObject();
		try {
 			DiDiPointVo pointVo = new DiDiPointVo();
			pointVo = didiPointService.getPoint();
			int mark = 0;
			if(pointVo.getId() == 1){
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		    	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		    	String day = sdf1.format(System.currentTimeMillis());
		    	String time = sdf2.format(System.currentTimeMillis());
 
		    	Date date1 = sdf1.parse(day);
				Date date2 = sdf1.parse("2018-09-08");
		        Date date3 = sdf1.parse("2018-09-15");
		        Date date4 = sdf2.parse(time);
		        Date date5 = sdf2.parse("23:00:00");
		        Date date6 = sdf2.parse("5:00:59");
		        
	            //返回 0 表示时间日期相同
	            //返回 1 表示日期1>日期2
	            //返回 -1 表示日期1<日期2         
	            
				if(date1.compareTo(date2) >= 0 && date1.compareTo(date3) <= 0){
					if(date1.compareTo(date2) == 0){
						if(date4.compareTo(date5) >= 0){
							mark = 1;
						}
					}else if(date1.compareTo(date3) == 0){
						if(date4.compareTo(date6) <= 0){
							mark = 1;
						}
					}else{
						if(date4.compareTo(date5) >= 0 || date4.compareTo(date6) <= 0){
							mark = 1;
						}
					}				
				}
			}
			
  			if(pointVo != null){
				EmployeeVO empVo = externalMethodService.getEmpInfo(empCode);
				if(StringUtils.isNotBlank(pointVo.getJoblevel())){
					if(empVo.getJobLevel().equals(pointVo.getJoblevel())){
						mark = dealDate(pointVo.getStartdate(), pointVo.getEnddate());
					}
				}else{
					mark = dealDate(pointVo.getStartdate(), pointVo.getEnddate());
				}
			}
			jonum.put("mark", mark);
			
			if(pointVo != null){
				jonum.put("content", pointVo.getContent());
			}
			logger.info("查询首页提示结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",pointVo);
		} catch (Exception e) {
			logger.info("查询首页提示异常>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "查询首页提示发生异常>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	private int dealDate(Date startdate, Date enddate){
		int mark = 0;
		if(!(startdate == null && enddate == null)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	String day = sdf.format(System.currentTimeMillis());
	    	
	    	try {
				Date today = sdf.parse(day);
				//返回 0 表示时间日期相同
	            //返回 1 表示日期1>日期2
	            //返回 -1 表示日期1<日期2     
				if(today.compareTo(startdate) >= 0 && today.compareTo(enddate) <= 0){
					mark = 1;				
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mark;
        
	}
	
	
	/**
	 * 查询所有已添加通知
	 */
	@CookieNotCheckedRequired
	public void getAllPoint(){
		
		JSONObject jonum = new JSONObject();
		try {
			List<DiDiPointVo> polist = new ArrayList<DiDiPointVo>();
			polist = didiPointService.getAllPoint(getBegin(), pageSize);
			// 意见反馈的条数
			count = didiPointService.getCount();
			// 总共多少页
			totalpage = getTotalpage();
			
			if(polist != null){
				jonum.put("errorCode", 0);
				jonum.put("errmsg", "");
				jonum.put("pointlist", polist);
				jonum.put("count", count);
				jonum.put("totalpage", totalpage);
			}
			
		} catch (Exception e) {
			logger.info("查询所有已添加通知异常>>>>>>>>>" + e.getMessage());
			jonum.put("errorCode", 1);
			jonum.put("errmsg", "查询所有已添加通知异常>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	/**
	 * 添加通知
	 */
	@CookieNotCheckedRequired
	public void insertPoint(){
		
		JSONObject jonum = new JSONObject();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String pointdate = date;
			Date startdate = sf.parse(pointdate.substring(0,11));
			Date enddate = sf.parse(pointdate.
					substring(pointdate.length()-10,pointdate.length()));
			
			DiDiPointVo poVo = new DiDiPointVo();
			poVo.setContent(content);
			poVo.setJoblevel(joblevel);
			poVo.setStartdate(startdate);
			poVo.setEnddate(enddate);
			int i = didiPointService.insertPoint(poVo);

			jonum.put("return:", i);
		} catch (Exception e) {
			logger.info("添加通知异常>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "添加通知异常>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	/**
	 * 更新状态
	 */
	@CookieNotCheckedRequired
	public void updatePointState(){
		
		JSONObject jonum = new JSONObject();
		try {
			int i = didiPointService.updateState(pointId);
			jonum.put("return", i);
		} catch (Exception e) {
			logger.info("更新提示状态异常>>>>>>>>>" + e.getMessage());
			jonum.put("errno", 1);
			jonum.put("errmsg", "更新提示状态异常>>>>>>>>>" + e.getMessage());
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	
	

	public IDiDiPointService getDidiPointService() {
		return didiPointService;
	}

	public void setDidiPointService(IDiDiPointService didiPointService) {
		this.didiPointService = didiPointService;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getJoblevel() {
		return joblevel;
	}


	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}


	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}


	public void setExternalMethodService(IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}


	public String getEmpCode() {
		return empCode;
	}


	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	/**
	 * get
	 * 
	 * @return
	 */
	public int getBegin() {
		// 起始条数
		begin = (currentPage - 1) * pageSize;
		return begin;
	}

	/**
	 * set
	 * 
	 * @param begin
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getTotalpage() {
		if (0 == count % pageSize) {
			totalpage = count / pageSize;
		} else {
			totalpage = count / pageSize + 1;
		}
		return totalpage;
	}

	/**
	 * set
	 * 
	 * @param totalpage
	 */
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPointId() {
		return pointId;
	}

	public void setPointId(int pointId) {
		this.pointId = pointId;
	}
	
	

}
