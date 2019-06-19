package com.deppon.dpm.doc.server.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IPageFunctionService;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;

/**
 * 分页功能开发
 * 
 * @author gwl
 * 
 */
public class PageFunctionAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private IPageFunctionService pagefunctionservice;
	// 查询员工是否部门负责人服务
	private IReceiveObjectService receiveobjectservice;
	
	
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(PageFunctionAction.class);

	/**
	 * 闲的蛋疼加个SB构造方法
	 */
	public PageFunctionAction(){
		super();
	}
	
	/** 记录总数 **/
	private int totalnum;

	/** 页数 **/
	private int pageNum = 1;

	/** 每页记录数 **/
	public static final int pageSize = 10;

	List<DidiOrderVO> orderList;

	/** 请求页面数据 **/
	private int requestnum;

	private String ismonth;
	
	//年
	private String year;
	
	//月
	private String month;
	
	//事由
	private String remark;
	
	//员工姓名
	private String employee;
	
	
	/**
	 * 注入dpm提供的接口
	 */
	private IExternalMethodService eExternalMethodService;
	
	/**
	 * 根据用户ID查询出订单
	 * 
	 */
	public void queryOrderByUserId(){
		JSONObject jonum = new JSONObject();
		orderList = pagefunctionservice.totalRecord(userId, pageSize,false,null);
		//判断是否明细表请求，返回全部数据
		if (pageNum == -1) {
			if("true".equals(ismonth)){
				jonum.put("reruestVOlist", getonMonth(orderList));
			}else{
				jonum.put("reruestVOlist", orderList);
			}
		} else {
			totalnum = orderList.size();// 总数
//					pageNum = getTotalPage();// 返回页数
			if(totalnum == 0){
				jonum.put("reruestVOlist", 0);
			}else{
				// 返回请求数据
				int requestbeginnum = getRecordIndex();// 定位请求的首条数据库位置
				jonum.put("totalnum", getTotalPage());
				List<DidiOrderVO> reruestVOlist = pagefunctionservice.pageMsg(userId, requestbeginnum);
				
				jonum.put("reruestVOlist", reruestVOlist);
			}

		}
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
	}
	
	
	/**
	 * 记录总数 1.根据用户ID查询出所有的订单
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@CookieNotCheckedRequired
	public void totalRecord1() throws UnsupportedEncodingException {
		
		JSONObject jonum = new JSONObject();
		
		// 调用接口判断当前登录人是不是部门负责人
		List<String> psndeptList = receiveobjectservice.isLead(userId);
		
		// 如果是部门负责人，查询部门下所有人的当月打车记录
		if (psndeptList != null && psndeptList.size()>0 && "0".equals(psndeptList.get(0))) {
			orderList = pagefunctionservice.totalRecord(userId, pageSize,true,psndeptList.get(1));
			jonum.put("islead", true);
		}else {// 如果是普通员工，查询本人打车记录
			orderList = pagefunctionservice.totalRecord(userId, pageSize,false,null);
			jonum.put("islead", false);
		}
		
		//判断是否明细表请求，返回全部数据
		if (pageNum == -1) {
			if("true".equals(ismonth)){
				jonum.put("reruestVOlist", getonMonth(orderList));
			}else{
				jonum.put("reruestVOlist", orderList);
			}
		} else {
			totalnum = orderList.size();// 总数
//			pageNum = getTotalPage();// 返回页数
			if(totalnum == 0){
				jonum.put("reruestVOlist", 0);
			}else{
				// 返回请求数据
				int requestbeginnum = getRecordIndex();// 定位请求的首条数据库位置
				jonum.put("totalnum", getTotalPage());
				List<DidiOrderVO> reruestVOlist = pagefunctionservice.pageMsg(userId, requestbeginnum);
				
				jonum.put("reruestVOlist", reruestVOlist);
			}

		}
		// 返回页面数据
		writeToPage(jonum);
		logger.debug("success");
//		outMessage(jonum);
	}
	
	
	
	/**
	 * @Desciption:TODO(个人当月打车消费记录)
	 * @author lvdefu
	 * @date:2018年4月8日15:38:30
	 */
	@CookieNotCheckedRequired
	public void individualTaxi(){
		JSONObject jonum = new JSONObject();
		if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(year) && StringUtils.isNotEmpty(month)){
			//根据年和月,拼接传入的日期参数
			String startDate=year+"-"+month+"-"+"01"+" "+"00:00:00"; //当月起始日期
			String endDate=year+"-"+month+"-"+"31"+" "+"23:59:59"; //当月终止日期
			List<DidiOrderVO> list=pagefunctionservice.queryDetailByDate(userId,startDate,endDate,remark);
			if(list==null){
				//list为null返回一个空的list
				List listDetail=new ArrayList();
				jonum.put("reruestVOlist", listDetail);
				jonum.put("msg", "success");
				// 返回页面数据
				writeToPage(jonum);
			}else{
				jonum.put("reruestVOlist", list);
				jonum.put("msg", "success");
				// 返回页面数据
				writeToPage(jonum);
			}
		}else{
			//list为null返回一个空的list
			List listDetail=new ArrayList();
			jonum.put("reruestVOlist", listDetail);
			jonum.put("msg", "fail,员工号,年,月不能为空");
			// 返回页面数据
			writeToPage(jonum);
		}
		
	}
	
	
	
	/**
	 * @Desciption:TODO(根据年月领导查询部门打车明细)
	 * @author lvdefu
	 * @date:2018年4月8日17:44:27
	 */
	@CookieNotCheckedRequired
	public void departmentTaxi(){
		JSONObject jonum = new JSONObject();
		//根据年和月,拼接传入的日期参数
		String startDate=year+"-"+month+"-"+"01"+" "+"00:00:00"; //当月起始日期
		String endDate=year+"-"+month+"-"+"31"+" "+"23:59:59"; //当月终止日期
		//调用DPM接口查询,查看是大领导还是小领导
		List<MyConsumptionRequestEntity> ListDeptByLeader =eExternalMethodService.getDeptInfo(userId);
		if(ListDeptByLeader==null){
			jonum.put("msg", "该员工不存在");
			//list为null返回一个空的list
			List listDetail=new ArrayList();
			jonum.put("reruestVOlist", listDetail);
			jonum.put("msg", "fail");
			// 返回页面数据
			writeToPage(jonum);
		}else{
			String order = ListDeptByLeader.get(0).getOrder(); //List的第一位是领导信息
			if("2".equals(order)){//2表示小领导
				String deptName = ListDeptByLeader.get(0).getDeptName();//小部门领导负责的部门
				List<String> deptNameList = new ArrayList<String>();
				deptNameList.add(deptName);//放入deptNameList该领导管理的部门名称
				//根据部门,年,月查询明细
				List<DidiOrderVO> listDetail=pagefunctionservice.departmentTaxi(deptNameList,startDate,endDate,remark,employee);
				if(listDetail==null){
					//list为null返回一个空的list
					List list=new ArrayList();
					jonum.put("reruestVOlist", list);
					jonum.put("msg", "该部门该月没有打车订单");
					jonum.put("msg", "fail");
					// 返回页面数据
					writeToPage(jonum);
				}else{
					jonum.put("reruestVOlist", listDetail);
					jonum.put("msg", "success");
					// 返回页面数据
					writeToPage(jonum);
				}
			}else if("1".equals(order)){//1表示大领导，查询大领导负责的全部部门
				logger.info("拿到该大部门下所有子部门,及子部门下属全部部门的list开始---------------------------------------");
				//先写死一个部门名称list，
				ArrayList<String> deptNameList = new ArrayList<String>();
				deptNameList.add(ListDeptByLeader.get(0).getDeptName()); //先把大部门放入
				//把该领导所管理的子部门放入deptNameList
				for (int i = 0; i < ListDeptByLeader.size(); i++) { //这里不判空的原因是,既然判断是大部门领导了,那么他下属一定有子部门
					if("2".equals(ListDeptByLeader.get(i).getOrder())){
						Map<String, String> mapChild = ListDeptByLeader.get(i).getAllchilddep();//获得子部门的map
						if(mapChild!=null){
							for (String v : mapChild.values()) { //遍历所有子部门的map放入deptNameList
								deptNameList.add(v);
							}
						}
					}	
				}
				//根据部门,年,月查询明细
				List<DidiOrderVO> listDetail=pagefunctionservice.departmentTaxi(deptNameList,startDate,endDate,remark,employee);
				if(listDetail==null){
					//list为null返回一个空的list
					List list=new ArrayList();
					jonum.put("reruestVOlist", list);
					jonum.put("msg", "fail");
					jonum.put("msg", "该部门该月无订单");
					// 返回页面数据
					writeToPage(jonum);
				}else{
					jonum.put("reruestVOlist", listDetail);
					jonum.put("msg", "success");
					// 返回页面数据
					writeToPage(jonum);
				}	
			}else{
				jonum.put("msg", "fail");
				jonum.put("msg", "该员工不是领导");
				// 返回页面数据
				writeToPage(jonum);
			}
		}
	}
	
	
	

	/**
	 * 返回当月的数据
	 */
	public List<DidiOrderVO> getonMonth(List<DidiOrderVO> reruestVOlist){
		
		List<DidiOrderVO> newOrderVO = new ArrayList<DidiOrderVO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ufdate = sdf.format(System.currentTimeMillis());
		String month = ufdate.substring(0,7);
		for(DidiOrderVO temp : reruestVOlist){
			if(temp.getTaxidate() != null && temp.getTaxidate().startsWith(month)){
				newOrderVO.add(temp);
			}
		}
		return newOrderVO;
	}
	
	/**
	 * 当前页首条在数据库里的位置
	 * 
	 * @return
	 */
	public int getRecordIndex() {
		return (pageNum - 1) * pageSize;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		if (orderList == null) {
			return 0;
		}
		if (orderList.size() % pageSize == 0) {
			return orderList.size() / pageSize;
		}
		else {
			return orderList.size() / pageSize + 1;
		}
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPagefunctionservice(IPageFunctionService pagefunctionservice) {
		this.pagefunctionservice = pagefunctionservice;
	}

	public int getRequestnum() {
		return requestnum;
	}

	public void setRequestnum(int requestnum) {
		this.requestnum = requestnum;
	}

	public IReceiveObjectService getReceiveobjectservice() {
		return receiveobjectservice;
	}

	public void setReceiveobjectservice(IReceiveObjectService receiveobjectservice) {
		this.receiveobjectservice = receiveobjectservice;
	}

	public String getIsmonth() {
		return ismonth;
	}

	public void setIsmonth(String ismonth) {
		this.ismonth = ismonth;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public IExternalMethodService geteExternalMethodService() {
		return eExternalMethodService;
	}



	public void seteExternalMethodService(
			IExternalMethodService eExternalMethodService) {
		this.eExternalMethodService = eExternalMethodService;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getEmployee() {
		return employee;
	}



	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	

//	private void outMessage(JSONObject jsonobject) {
//		// 返回页面数据
//		PrintWriter printwriter = null;
//		try {
//			HttpServletResponse response = ServletActionContext.getResponse();
//			// 设置响应类型
//			response.setContentType("text/html;charset=utf-8");
//			// 跨域设置
//			response.setHeader("Access-Control-Allow-Origin", "*");
//
//			// 获取一个printWriter对象
//			printwriter = response.getWriter();
//			// 打印,将null值输出为空字符串
//			printwriter.println(JSON.toJSONString(jsonobject,
//					SerializerFeature.WriteNullStringAsEmpty));
//		} catch (IOException e) {
//			// 错误打印
//			LOG.debug(e.getMessage());
//		} finally {
//			if (printwriter != null) {
//				printwriter.flush();
//				printwriter.close();
//			}
//		}
//		LOG.debug("success");
//	}
}
