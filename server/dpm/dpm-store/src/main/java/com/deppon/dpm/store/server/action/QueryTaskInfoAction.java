package com.deppon.dpm.store.server.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.store.server.entity.QueryAppraisal;
import com.deppon.dpm.store.server.entity.QueryTaskInfo;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.service.IQueryTaskInfoService;
import com.deppon.dpm.store.server.service.IStoreTaskService;
import com.deppon.dpm.store.server.service.impl.QueryTaskInfoService;
import com.deppon.dpm.store.server.util.ListPageUtil;
import com.deppon.dpm.store.server.util.ResultData;
import com.deppon.dpm.store.server.util.UploadPic;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;

/**
 * 查询任务列表信息Action
 * 
 * @author RY
 * @date 2018年5月25日10:46:01
 */
public class QueryTaskInfoAction extends BaseAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	// 日志
	private static final Logger logger = LoggerFactory
			.getLogger(QueryTaskInfoAction.class);
	// 员工id
	private String creatorcode;
	// 查询任务信息service
	private IStoreTaskService storeTaskService;
	// 状态
	private String queryCondition;

	// 查询所有部门信息service
	private ISelectAllDeptService selectAllDeptService;
	// 前台获取当前领导下的所有部门信息，穿过来的值为领导的orgid
	private String parentorgid;
	// 前台获取事业部总裁需要传过来的值，默认为事业部总裁
	private String jobname;
	// 注入service
	private IQueryTaskInfoService queryTaskInfoService;
	// 执行id
	private String exeid;
	// 反馈说明
	private String feedbackinfo;
	// 图片接受字符串
	private String picString;
	// 当前页
	private Integer nowPage=1;
		
	//每页条数
	private Integer pageSize=50;
	
	//开始时间
	private String startTime;
	
	//结束时间
	private String endTime;
	
	//营业部名称
	private String taskName;
	
	//deptseq
	private String deptseq;
	
	//员工级别
	private String psnlevel;
	
	//查询执行人和营业部条件 员工名称 职位名称 地区名称
	private String searchInfo;
	
	//搜索框查询下属全部营业部时 返回全部数据 判断条件 mark null为正常 1为搜索框（返回全部数据）
	private Integer mark;
	
	// 定义任务列表每次查询的pagesize
	private Integer taskListPageSize = 10;
	/**
	 * 根据执行人查询下属营业部
	 * @author RY
	 * @date 2018年6月23日11:12:51
	 */
	//@CookieNotCheckedRequired
	public void selectAll(){
		// 定义返回json
		JSONObject jonum = new JSONObject();
		logger.info("查询执行人下属营业部开始");
			//根据员工等级和工号 查询出所有营业部信息
		List<SelectAllDeptVO> SelectAll = null;
		try{
			logger.info("查询执行人开始");
			SelectAll =selectAllDeptService.selectAll(creatorcode,deptseq,psnlevel,nowPage,pageSize,searchInfo,mark);
		}catch(Exception e){
			logger.error("根据执行人查询下属营业部接口 查询执行人失败");
		}
			//如果查询出来的营业部信息不为空
			if(SelectAll!=null){
				jonum = ResultData.success(SelectAll);
			}else{
				//调用统一返回接口
				jonum = ResultData.error("调用查询执行人接口失败");
			}
		// 返回页面数据
		writeToPage(jonum);
	}
	/**
	 * 查询执行人
	 * @author RY
	 * @2018年6月23日10:12:31
	 */
	@SuppressWarnings("unused")
	//@CookieNotCheckedRequired
	public void queryexeer(){
		// 定义返回json
		JSONObject jonum = new JSONObject();
		List<SelectAllDeptVO> SelectAllDept = new ArrayList<SelectAllDeptVO>();
		try{
			SelectAllDept =selectAllDeptService.selectUpInfo(deptseq, psnlevel,nowPage,pageSize,searchInfo);//得到下一级执行人信息
			if("05".equals(psnlevel)){
				//如果是营业部,把他同级的营业部经理筛选掉,不可以平级指派
				for (int i = 0; i < SelectAllDept.size(); i++) {
					if(!creatorcode.equals(SelectAllDept.get(i).getEmpcode())){
						SelectAllDept.remove(SelectAllDept.get(i));
					}
				}
			}
			//如果下一级执行人信息不为空
			if(SelectAllDept!=null&&!SelectAllDept.isEmpty()){
				//取出等级
				String level =SelectAllDept.get(0).getPsnlevel();
				Map<Object,Object> map = new HashMap<Object, Object>();
				//存储等级
				map.put("level", level);
				//存储是信息
				map.put("listNew", SelectAllDept);
				//调用统一返回接口
				jonum = ResultData.success(map);
			}else{
				//调用统一返回接口
				jonum = ResultData.success(SelectAllDept);
			}
		}catch(Exception e){
			logger.error("查询执行人接口失败");
			jonum=ResultData.error("调用查询执行人接口失败");
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	/**
	 * 根据工号查询智慧门店相关人员信息
	 * @author RY
	 * @date 2018年6月21日15:23:46
	 */
	//@CookieNotCheckedRequired
	public void queryPsnLevelByEmpCode(){
		// 定义返回json
		JSONObject jonum = new JSONObject();
		//存储人员级别 01为最高 05为最低 若为空则无法使用智能门店相关功能
		SelectAllDeptVO SelectAllDept = null;
		try{
			logger.info("查询登录人信息开始");
			SelectAllDept =selectAllDeptService.selectInfoByEmpCode(creatorcode);
		}catch(Exception e){
			logger.error("查询登录人信息失败");
		}
		//如果在视图中能查询出来信息
		if(SelectAllDept!=null){
			//如果头像为空
			if(SelectAllDept.getPictpath()==null){
				//给一个空字符串
				SelectAllDept.setPictpath("");
			}
			//取出等级
			String psnlevel = SelectAllDept.getPsnlevel();
			//如果等级不为空
			if(!"".equals(psnlevel)&& psnlevel!=null){
				//调用统一返回接口
				jonum = ResultData.success(SelectAllDept);
			}
		}else{
			//如果不是视图中的员工 判断是否是特殊权限人员
			SelectAllDeptEntity entity = new SelectAllDeptEntity();
			SelectAllDeptVO vo = new  SelectAllDeptVO();
			//给予不想关人员权限
			vo.setPsnlevel("06");
			//存储个人信息数据
			entity = selectAllDeptService.selectdpmAdmin(creatorcode);
			if(entity!=null){
				vo.setDeptseq("");
				vo.setEmpcode(entity.getEmpcode());
				vo.setEmpname(entity.getEmpname());
				vo.setJobname(entity.getJobname());
				vo.setOrgcode(entity.getOrgcode());
				vo.setOrgid(entity.getOrgid());
				vo.setOrgname(entity.getOrgname());
				vo.setParentorgid(entity.getParentorgid());
				if(entity.getPictpath()!=null){
					vo.setPictpath(entity.getPictpath());
				}else{
					vo.setPictpath("");
				}
				//调用统一返回接口 成功
				jonum = ResultData.success(vo);
			}else{
				//调用统一返回接口 失败
				jonum = ResultData.error("");
			}
		}
		// 返回页面数据
		writeToPage(jonum);
	}
	/**
	 * 查询所有模块信息
	 */
	//@CookieNotCheckedRequired
	public void queryAllModInfo() {
		// 定义返回json
		List<Map<String,Object>> jonum = new ArrayList<Map<String,Object>>();
		// 赋值
		try{
			logger.info("查询所有模块信息开始");
			jonum = queryTaskInfoService.queryAllModInfo();
		}catch(Exception e){
			logger.error("查询所有模块信息失败");
		}
		// 判断不为空
		if (jonum != null) {
			// 返回页面
			writeToPage(jonum);
		} else {
			JSONObject json = new JSONObject();
			json.put("msg", "error");
			// 返回页面数据
			writeToPage(json);
		}
	}

	/**
	 * 根据员工id查询任务列表信息
	 * 
	 * @author RY
	 * @date 2018年5月25日10:49:42
	 */
	/**
	 * @throws ParseException
	 * 
	 */
	//@CookieNotCheckedRequired
	public void queryByCreatorcode() throws ParseException {
		// 定义返回json
		JSONObject jonum = new JSONObject();
		List<QueryTaskInfo> list = new ArrayList<QueryTaskInfo>();
		// 将传值封装成map
		Map<String, Object> map = new HashMap<String, Object>();
		// 存储数据
		map.put("queryCondition",queryCondition);
		// 存储数据
		map.put("creatorcode", creatorcode);
		// 存储数据
		map.put("startTime",startTime);
		// 存储数据
		map.put("endTime", endTime);
		// 存储数据
		map.put("taskName",taskName);
		// 存储sql 计算已反馈的任务条数
		map.put("taskStatus1", "已反馈");
		// 存储sql 已完成
		map.put("taskStatus2", "已完成");
		// 存储sql 待考评
		map.put("taskStatus3", "待考评");
		// 存储数据
		map.put("rowBegin",nowPage==null?null:(nowPage-1)*taskListPageSize);
		// 存储数据
		map.put("pageSize",taskListPageSize);
		try{
			logger.info("查询任务信息开始");
			list = queryTaskInfoService.selcetTaskByQueryCondition(map);
		}catch(Exception e){
			logger.error("查询任务信息接口失败");
		}
		if(null!=list&&!list.isEmpty()){
		/*//调用统一返回接口 成功
			jonum = ResultData.success(list);*/
			// 存储数据
			jonum.put("data", list);
			// JSON存储
			jonum.put("msg", "该员工没有任务");
			// JSON存储
			jonum.put("state", 200);
		}else{
			// 存储数据
			jonum.put("data", "");
			// JSON存储
			jonum.put("msg", "该员工没有任务");
			// JSON存储
			jonum.put("state", 0);
		}
		// 返回页面数据
		writeToPage(jonum);
	}

	
	
	/**
	 * 添加反馈
	 * 
	 * @dare 2018年6月5日17:03:06
	 * @author RY
	 */
	//@CookieNotCheckedRequired
	public void insertFeedback() {
		// 定义返回json
		JSONObject jonum = new JSONObject();
		if (exeid != null && feedbackinfo != null&&picString!=null) {
			// 调用方法
			StringBuffer img = new StringBuffer();
			//非空判断
			if(!"".equals(picString)){
			//循环遍历
			String [] str = picString.split("-");
			for (String string : str) {
				//base64解密
				if("undefined".equals(string)){
					img=null;
				}else{
					String imgName = UploadPic.Base64ToImage(string);
					//分隔
					img.append(imgName);
					//分隔
					img.append("-");
					}
				}
			}
			String imgname=null;
			//如果img有值，则赋值，否则返回空
			if(img!=null){
				imgname=img.toString();
			}
			//调用添加反馈接口
			boolean bool= false;
			try{
				logger.info("调用添加反馈接口开始");
				bool= queryTaskInfoService.insertFeedback(Long.valueOf(exeid),feedbackinfo,imgname);
			}catch(Exception e){
				logger.error("调用反馈接口失败");
			}
			//如果成功则返回成功
			if (bool) {
				//存储成功
				jonum.put("msg", "success");
			} else {
				// 存储失败
				jonum.put("msg", "error");
			}
			// 返回页面显示
			writeToPage(jonum);
		} else {
			// 存储数据
			jonum.put("msg", "该反馈信息为空");
			// 返回页面显示
			writeToPage(jonum);
		}
	}

	/**
	 * 查询反馈
	 * 
	 * @dare 2018年6月5日17:03:06
	 * @author RY
	 */
	public Map<String,Object> queryFeedback() {
		//定义返回的json
		Map<String,Object> map = new HashMap<String, Object>();
		// 调用方法获取数据
		List<QueryAppraisal> list = null;
		try{
			logger.info("查询反馈信息开始");
			list= queryTaskInfoService.queryFeedback(Long.valueOf(exeid));
		}catch(Exception e){
			logger.error("调用查询反馈接口失败");
		}
		if (list != null) {
				// 定义返回json
				if(list.get(0).getPicpath()!=null){
					List<String> result = Arrays.asList(list.get(0).getPicpath()
							.split("-"));
					if (result != null) {
						map.put("picpath", result);
					}
				}
				map.put("feedbackinfo", list.get(0).getFeedbackinfo());
			}
		return map;
	}

	/**
	 * 根据执行id查询考评结果 创建人名称 开始时间 结束时间 逾期时间等
	 * 
	 * @author RY
	 * @throws ParseException
	 * @date 2018年6月5日09:15:54
	 */
	//@CookieNotCheckedRequired
	public void queryAppraisalByExeid() throws ParseException {
		// 定义返回json
		JSONObject jonum = new JSONObject();
		if(StringUtils.isNotEmpty(exeid)&&StringUtils.isNotEmpty(creatorcode)){
		// 定义任务详情实体类
		QueryTaskInfo queryTaskInfo = null;
		try{
			logger.info("根据执行id查询考评结果开始");
			queryTaskInfo = (QueryTaskInfo) queryTaskInfoService.queryAppraisalByExeid(Long.valueOf(exeid));
		}catch(Exception e){
			logger.error("根据执行id查询考评结果 调用接口失败");
		}
		// 定义考评结果实体类
		List<QueryAppraisal> list = null;
		try{
			logger.info("根据id查询反馈内容开始");
			list = queryTaskInfoService.queryAppraisal(Long.valueOf(exeid));
		}catch(Exception e){
			logger.error("调用查询反馈内容接口失败");
		}
		if (list != null) {
			// 存储考评结果
			jonum.put("appraisal", list);
		}
		// 如果内容不为空
		if (queryTaskInfo != null) {
			// 存储创建人名称
			jonum.put("taskcreator", queryTaskInfo.getTaskcreator());
			// 格式化时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 将string类型的时间转化为date
			Date startime = sdf.parse(queryTaskInfo.getStarttime());
			Date endtime = sdf.parse(queryTaskInfo.getEndtime());
			// 存储开始时间
			jonum.put("starttime", sdf.format(startime));
			// 存储截止日期
			jonum.put("endtime", sdf.format(endtime));
			// 存储任务名称
			jonum.put("taskname", queryTaskInfo.getTaskname());
			// 存储执行人名称
			jonum.put("exeer", queryTaskInfo.getExeer());
			// 存储营业部名称
			jonum.put("deptname", queryTaskInfo.getDeptname());
			// 存储分数
			jonum.put("testgrade", queryTaskInfo.getTestgrade());
			// 任务状态
			jonum.put("taskstatus", queryTaskInfo.getTaskstatus());
			//判断任务状态是否为待反馈，如若为待反馈，则返回状态值为1，否则返回0
			if("待反馈".equals(queryTaskInfo.getTaskstatus())){
				//判断当前登录人是否是本人(如果是本人才返回1)
				String deptapid=queryTaskInfoService.querydeptapidByExeid(Long.valueOf(exeid));
				if(deptapid!=null&&creatorcode.equals(deptapid)){
					jonum.put("fb", 1);
				}else{
					jonum.put("fb", 0);
				}
			}else{
				jonum.put("fb", 0);
			}
			// 根据执行人id查询执行人信息
			SelectAllDeptEntity selectAllDep = null;
			try{
				logger.info("查询执行人信息开始");
				selectAllDep= selectAllDeptService.selectAllDeptByempcode(queryTaskInfo.getExeerid());
			}catch(Exception e){
				logger.error("查询执行人信息失败");
			}
			// 非空判断
			if (selectAllDep != null) {
				// 组织名称
				jonum.put("orgname", selectAllDep.getOrgname());
				// 工作名称
				jonum.put("jobname", selectAllDep.getJobname());
			}
			/**
			 * 计算逾期时间
			 */
			// 计算当前时间是否大于主任务截止时间
			long time = overdueTime(queryTaskInfo.getEndtime());
			// 如果time小于0，则当前时间小于逾期时间
			if (time < 0) {
				// 如果逾期时间大于当前时间，则未逾期
				queryTaskInfo.setOverdueTime("未逾期");
				queryTaskInfo.setIsoverdue("0");
			} else {
				queryTaskInfo.setIsoverdue("1");
				// 按照任务结束时间来计算逾期时间
				time = differentDaysByMillisecond(queryTaskInfo.getEndtime(),
						queryTaskInfo.getSublistendtime());
				judgeOverdue(queryTaskInfo, time);
			}
			// 存储逾期状态
			jonum.put("isoverdue", queryTaskInfo.getIsoverdue());
			// 存储逾期时间
			jonum.put("overdueTime", queryTaskInfo.getOverdueTime());
			// 存储反馈数据
			jonum.put("feedbackinfo", queryFeedback().get("feedbackinfo"));
			jonum.put("feedbackpic",queryFeedback().get("picpath"));
			// 存储考评详情
			jonum.put("appraisal", queryTaskInfoService.queryAppraisal(Long.valueOf(exeid)));
			// 返回页面数据
			writeToPage(jonum);
			}else{
				// 存储数据
				jonum.put("msg", "调用根据执行id查询考评结果补充数据接口失败");
				// 返回页面数据
				writeToPage(jonum);
			}
		}else {
			// 存储数据
			jonum.put("msg", "调用根据执行id查询考评结果补充数据接口失败");
			// 返回页面数据
			writeToPage(jonum);
		}

	}
	/**
	 * 根据工号查询个人头像，职位，部门名称信息
	 * 
	 * @param queryTaskInfo
	 */
	private void queryDeptInfo(QueryTaskInfo queryTaskInfo) {
		// 非空判断
		if (creatorcode != null && !"".equals(creatorcode)) {
			// 调用方法，获取指定id的信息
			SelectAllDeptEntity selectAllDep =null;
			try{
				logger.info("根据工号查询个人头像，职位，部门名称信息开始");
				selectAllDep = selectAllDeptService.selectAllDeptByempcode(creatorcode);
			}catch(Exception e){
				logger.error("根据工号查询个人头像，职位，部门名称信息 接口失败");
			}
			// 非空判断
			if (selectAllDep != null) {
				// 职位
				queryTaskInfo.setJobname(selectAllDep.getJobname());
				// 部门名称
				queryTaskInfo.setOrgname(selectAllDep.getOrgname());
				// 若头像信息为空则储存空信息
				queryTaskInfo
						.setPictpath(selectAllDep.getPictpath() == null ? "null"
								: selectAllDep.getPictpath());
			}
		}
	}
	/**
	 * 判断逾期
	 * 
	 * @param queryTaskInfo
	 * @param dayDiff
	 */
	private void judgeOverdue(QueryTaskInfo queryTaskInfo, long dayDiff) {
		// 存储逾期时间
		// 若为负数则未逾期，若为正数则未逾期多少天
		if (dayDiff > 0) {
			queryTaskInfo.setIsoverdue("1");
			// 若大于0，则逾期超过一天
			if (dayDiff / (24 * 60 * 60) == 0) {
				// 等于0则未超过一天
				queryTaskInfo.setOverdueTime("逾期不到1天");
			} else {
				// 计算天数
				dayDiff = dayDiff / (24 * 60 * 60);
				// 存储逾期天数
				queryTaskInfo.setOverdueTime("逾期" + dayDiff + "天");
			}
		} else {
			queryTaskInfo.setIsoverdue("0");
			// 否则是未逾期
			queryTaskInfo.setOverdueTime("未逾期");
		}
	}

	/**
	 * 计算两个时间之间的秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	private long differentDaysByMillisecond(String str1, String str2)
			throws ParseException {
		// 格式化时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 转换类型
		Date date1 = format.parse(str1);
		// 转换类型
		Date date2 = format.parse(str2);
		// 计算时间差
		long days = (long) ((date2.getTime() - date1.getTime()) / (1000));
		// 返回
		return days;
	}

	/**
	 * 计算给定时间和当前时间之间的秒数
	 * 
	 * @param endtime
	 * @return
	 * @throws ParseException
	 */
	private long overdueTime(String endtime) throws ParseException {
		// 格式化时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 转换类型
		Date date1 = format.parse(endtime);
		// 获取当前时间
		Date date = new Date();
		// 计算秒数
		long dayDiff = (long) ((date.getTime() - date1.getTime()) / (1000));
		// 返回
		return dayDiff;
	}

	/**
	 * 
	 * @return
	 */
	public IStoreTaskService getStoreTaskService() {
		return storeTaskService;
	}

	/**
	 * 
	 * @param storeTaskService
	 */
	public void setStoreTaskService(IStoreTaskService storeTaskService) {
		this.storeTaskService = storeTaskService;
	}

	/**
	 * 
	 * @return
	 */
	public String getCreatorcode() {
		return creatorcode;
	}

	/**
	 * 
	 * @param creatorcode
	 */
	public void setCreatorcode(String creatorcode) {
		this.creatorcode = creatorcode;
	}

	/**
	 * 
	 * @return
	 */
	public String getQueryCondition() {
		return queryCondition;
	}

	/**
	 * 
	 * @param queryCondition
	 */
	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	/**
	 * 
	 * @return
	 */
	public ISelectAllDeptService getSelectAllDeptService() {
		return selectAllDeptService;
	}

	/**
	 * 
	 * @param selectAllDeptService
	 */
	public void setSelectAllDeptService(
			ISelectAllDeptService selectAllDeptService) {
		this.selectAllDeptService = selectAllDeptService;
	}

	/**
	 * 
	 * @return
	 */
	public String getParentorgid() {
		return parentorgid;
	}

	/**
	 * 
	 * 
	 * @param parentorgid
	 */
	public void setParentorgid(String parentorgid) {
		this.parentorgid = parentorgid;
	}

	/**
	 * 
	 * @return
	 */
	public String getJobname() {
		return jobname;
	}

	/**
	 * 
	 * @param jobname
	 */
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	/**
	 * 
	 * @return
	 */
	public IQueryTaskInfoService getQueryTaskInfoService() {
		return queryTaskInfoService;
	}

	/**
	 * 
	 * @param queryTaskInfoService
	 */
	public void setQueryTaskInfoService(
			IQueryTaskInfoService queryTaskInfoService) {
		this.queryTaskInfoService = queryTaskInfoService;
	}

	/**
	 * 
	 * @return
	 */
	public String getExeid() {
		return exeid;
	}

	/**
	 * 
	 * @param exeid
	 */
	public void setExeid(String exeid) {
		this.exeid = exeid;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeedbackinfo() {
		return feedbackinfo;
	}

	/**
	 * 
	 * @param feedbackinfo
	 */
	public void setFeedbackinfo(String feedbackinfo) {
		this.feedbackinfo = feedbackinfo;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getNowPage() {
		return nowPage;
	}
	/**
	 * 
	 * @param nowPage
	 */
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * 
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 
	 * @return
	 */
	public String getPicString() {
		return picString;
	}
	/**
	 * 
	 * @param picString
	 */
	public void setPicString(String picString) {
		this.picString = picString;
	}
	/**
	 * 
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 
	 * @return
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 
	 * @return
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * 
	 * @param taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptseq() {
		return deptseq;
	}
	/**
	 * 
	 * @param deptseq
	 */
	public void setDeptseq(String deptseq) {
		this.deptseq = deptseq;
	}
	/**
	 * 
	 * @return
	 */
	public String getPsnlevel() {
		return psnlevel;
	}
	/**
	 * 
	 * @param psnlevel
	 */
	public void setPsnlevel(String psnlevel) {
		this.psnlevel = psnlevel;
	}
	/**
	 * 
	 * @return
	 */
	public String getSearchInfo() {
		return searchInfo;
	}
	/**
	 * 
	 * @param searchInfo
	 */
	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getMark() {
		return mark;
	}
	/**
	 * 
	 * @param mark
	 */
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
}