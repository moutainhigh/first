package com.deppon.dpm.tongxunlu.server.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.CommonConstant;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.server.util.WhetherMonitorCutffPoint;
import com.deppon.dpm.module.common.shared.domain.EmpFurloughInfoEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.tongxunlu.server.service.IAppVersionConfigService;
import com.deppon.dpm.tongxunlu.server.service.IMyFavoritesService;
import com.deppon.dpm.tongxunlu.server.service.IOrgMonitorService;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.HotLine;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.dpm.tongxunlu.shared.vo.SearchResult;
import com.deppon.foss.framework.server.context.UserContext;

/**
 * 通讯录服务请求.
 */
public class TongxunluAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1397420409043898745L;
	/**
	 * log
	 */
	private static final Logger logger = Logger
			.getLogger(TongxunluAction.class);

	/**
	 * 操作系统类型
	 */
	private String osType = "android";
	/**
	 * app对应的名称
	 */
	private String appName;
	/**
	 * api版本.
	 */
	private String version;
	/**
	 * 查询主键.
	 */
	private String id;
	/**
	 * searchCode
	 */
	private String searchCode;
	/**
	 * 查询的对象.
	 */
	private String searchName;
	/**
	 * 查询的类型（1，查询人员，2，查询组织）
	 */
	private String searchType;
	
	private static final int PAGESIZE_50 = 50;
	private static final int PAGESIZE_20 = 20;
	/**
	 * 一页显示条数
	 */
	private int pageSize = PAGESIZE_50;
	/**
	 * 参数判断为是否为电话呼入
	 */
	private String wayIn;

	/**
	 * 数据监控的类型<br>
	 * 0 表示----通讯录访问<br>
	 * 1 表示----电话直播<br>
	 * 2 表示----短信发送<br>
	 * 3表示 ----表示请审批(工作流待办)<br>
	 * 4 表示----固定资产<br>
	 * 5表示 ----bi<br>
	 * 6表示 ----it服务上报<br>
	 * 7表示 ----日程---------------------------日程--------查看<br>
	 * 8表示 ----我的任务<br>
	 * 9表示 ----战略指标<br>
	 * 10表示----舆情动态<br>
	 * 11表示----同行信息<br>
	 * 12表示----自选指标<br>
	 * 13表示----实时更新<br>
	 * 14表示----人才选拔<br>
	 * 15表示----移动crm<br>
	 * 16表示----项目管理工具<br>
	 * 17表示----邮箱<br>
	 * 18表示----我的工资条<br>
	 * 19表示----差旅助手<br>
	 * 20表示----文化社区(德邦e站)<br>
	 * 21表示----班车<br>
	 * 22表示----收派助手<br>
	 * 23表示----工程管理<br>
	 * 24表示----考勤<br>
	 * 25表示----打卡<br>
	 * 26表示----发现<br>
	 * 27表示----收发室<br>
	 * 29表示----悬赏<br>
	 * 30表示----奖金 <br>
	 * 31表示----在线学习(微课堂)<br>
	 * 32表示----约吧搜索 <br>
	 * 33表示----约吧创建 <br>
	 * 34表示----IT提交<br>
	 * 35表示----IT挂起<br>
	 * 36表示----IT转二线<br>
	 * 37表示----知识库<br>
	 * 38表示----场地预定<br>
	 * 39表示----拼车吧<br>
	 * 40表示----IT服务台未受理列表<br>
	 * 41表示----IT服务台受理<br>
	 * 42表示----德邦e站分享<br>
	 * 43表示----TPS<br>
	 * 44表示----招聘<br>
	 * 45表示----营运安全<br>
	 * 46表示----刊物<br>
	 * 47表示----差错<br>
	 * 48表示----物资反馈<br>
	 * 49表示----访客系统<br>
	 * 50表示----智慧收派<br>
	 * 51表示----劳动合同<br>
	 * 52表示----新工作流（泛微）<br>
	 * ------------------------------------ <br>
	 * 100表示----点击通讯录搜索框<br>
	 * 101表示----点击下载通讯录<br>
	 * 102表示----点击发邮件<br>
	 * 103表示----通讯录查询（搜索）<br>
	 * 104表示----邮件删除<br>
	 * 
	 * 105表示----选拔（html5）<br>
	 * 106表示----抽签<br>
	 * 107表示----抽签提交<br>
	 * 
	 * 108表示----引导页<br>
	 * 109表示----广告栏监控<br>
	 * 110表示----广告栏差号<br>
	 * 111表示----广告栏确定(安装epp)<br>
	 * 112表示----直接跳转epp<br>
	 * 113表示----引导页跳过<br>
	 * 114表示----悬赏私信发送<br>
	 */
	private int monitorType;

	/**
	 * 服务接口.
	 */
	private ITongxunLuService tongxunLuService;

	/**
	 * 系统版本更新
	 */
	private IAppVersionConfigService appVersionConfigService;

	/**
	 * 头像接口
	 */
	private IPersonlyImageService personlyImageService;

	/**
	 * 常用联系人接口
	 */
	private IMyFavoritesService myFavoritesService;
	
	/**
	 * 组织相关监控的Service
	 */
	private IOrgMonitorService orgMonitorService;
	
	private RedisService redisService;
	
	private static List<String> jobLevelsForB8 = null;
	
	private static List<String> jobLevelsForB9 = null;

	/**
	 * 返回版本验证信息.
	 * requestType：1：登录后自动检测的请求  0：设置里面手动检测的请求
	 * 
	 * @author 231586 2015-09-28 改
	 */
	@CookieNotCheckedRequired
	public void seeVersion() {
		String userId = ServletActionContext.getRequest().getParameter("userId");
		String requestType = ServletActionContext.getRequest().getParameter("requestType");
		// 版本查询
		ServletContext servletContext = ServletActionContext.getServletContext();
		String dbVersion = appVersionConfigService.seeVersion(servletContext,requestType,userId,version,
				appName, osType);
		/*
		 * PrintWriter writer = null; try { HttpServletResponse response =
		 * ServletActionContext.getResponse();
		 * response.setContentType("text/html;charset=utf-8");
		 * response.setHeader("Access-Control-Allow-Origin", "*"); writer =
		 * response.getWriter(); writer.write(db_version); } catch (IOException
		 * e) { e.printStackTrace(); } finally { if (writer != null) {
		 * writer.close(); } }
		 */
		// 返回json
		writeToPage(dbVersion);
	}

	/**
	 * 进行数据的同步.
	 * 
	 * @author 231586 2015-09-28 改
	 */
	/*
	 * public void init() { new NewInitDatabase();
	 * writeToPage("正在后台操作中，请查看后台日志."); }
	 */
	
	/**
	 * 判断是否为合伙人
	 */
	private boolean judgePartner(){
		try {
			// 从ThreadLocal中获取当前登录人的岗位
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			String jobName = loginResult.getUserEntity().getEmployee().getJobName();
			// 判断是否为合伙人
			if("合伙人营业部经理".equals(jobName) || "合伙人收银员".equals(jobName) || "合伙人营业员".equals(jobName)){
				return true;
			}
		} catch (Exception e) {
			logger.error("userId:"+userId+"判断是否为合伙人出错!!!", e);
		}
		return false;
	}
	
	/**
	 * 保存用户点击该组织的次数
	 */
	private void saveOrgAccessCountForUserId() {
		try {
			orgMonitorService.saveOrgAccessCountForUserId(userId,id);
		} catch (Exception e) {
			logger.error("保存用户对组织访问次数出错>>>>{userId = "+userId+",orgid = "+id+"}",e);
		}
	}

	/**
	 * 根据上级组织id查询结果，含有人员列表和子组织机构列表.
	 */
	public void getChildByOrg() {
		
		// 监控用户点击该组织的次数
		this.saveOrgAccessCountForUserId();
		// 组织返回信息
		List<OrganizationVO> orgs = new ArrayList<OrganizationVO>();
		// 规定结果返回值
		Result<SearchResult> res = new Result<SearchResult>();
		// redis缓存获取对象
//		Object obj = DpmCacheManager.redisGet(getChildByOrgKey());
		// 组织id的可行性
//		if (StringUtils.isNumeric(id)) {
//			// 根据组织id查询人员
//			searchVo.setParentId(Integer.parseInt(id));
//		} else if ("-1".equals(id)) {
//			logger.info("getChildByOrg id：-1 ");
//			// 空处理，常用联系人对应的组织架构，只是为了可以继续往下执行
//		} else {
//			// 出错id
//			throw new IllegalArgumentException("传入参数组织id错误：" + id);
//		}
		// 校验组织id是否合法
		if(StringUtils.isBlank(id) || !StringUtils.isNumeric(id)){
			res.setErrorCode(Constants.WRONG_REQUEST);
			res.setErrorMessage("传入参数组织id错误：" + id);
			writeToPage(res);
			return;
		}
		// 拼接条件.
		OrganizationVO searchVo = new OrganizationVO();
		// 查询参数
		searchVo.setParentId(Integer.parseInt(id));
		// 拼接结果
		SearchResult result = new SearchResult();
		
		try {
			// 判断是否合伙人
			boolean isPartner = judgePartner();
			// 常用联系人查询
			if ("-1".equals(id)) {
				// 常用联系人
				List<EmployeeVO> favorites = myFavoritesService
						.getFavorites(userId);
				if(null != favorites && favorites.size() > 0){
					for (EmployeeVO employeeVO : favorites) {
						// 设置休假信息
						this.setFurlough(employeeVO);
						
						if(isPartner){
							this.setMobileAndTelForPartner(employeeVO);
						}
					}
				}
				// 设置常用联系人的状态设置
				favorites = extractedFavorites(favorites);
				// 常用联系人结果集设置
				result.setEmps(favorites);
			} else {
				// 查询下级组织
				if(isPartner){
					// 限制合伙人的通讯录权限
					orgs = tongxunLuService.searchOrgForPartner(searchVo, 0, -1);
				} else {
					orgs = tongxunLuService.searchOrg(searchVo, 0, -1);
				}
				// 领导人设置
				result.setEmps(getLeadEmps(isPartner));
			}
		} catch (FileNotFoundException e) {
			logger.error("通讯录常用联系人头像查询出错", e);
		}
		// 组织结果集设置
		result.setOrgs(orgs);
		// 结果设置
		res.setData(result);
		// 人数
//		res.setCount(tongxunLuService.getEmpByOrgIdCount(id));
		// 成功
		res.setErrorCode(Constants.SUCCESS);
//		DpmCacheManager.redisSet(getChildByOrgKey(), res);
		// 返回json
		writeToPage(res);
	}

	/**
	 * 数据监控<br>
	 * 点击一次，保存一条记录
	 */
	public void dataMonitor() {
		// 结果集的定义
		String result = null;
		// 判断userId是否为空
		if (userId == null) {
			// 从环境中获取userEntity
			UserEntity user = (UserEntity) UserContext.getCurrentUser();
			if (user != null) {
				// 获取工号
				userId = user.getEmpCode();
			}
		}
//		// 获取casCookie
//		String casCookie = ServletUtil.getRequest().getParameter("casCookie");
//		// 获取sessionId
//		String sessionId = ServletUtil.getRequest().getParameter("sessionId");
//		// 校验参数是否合法
//		boolean flag = checkParam(userId,casCookie,sessionId);
//		// 判断不合法
//		if(!flag){
//			// 返回
//			result = "{\"result\":\"1\",\"errorCode\":\"1\"}";
//			writeToPage(result);
//			return;
//		}
		try {
			// 工号为空，直接返回，不记录
			if (StringUtils.isEmpty(userId))
				return;
			// 数据监控
			tongxunLuService.dataMonitor(monitorType, userId,
					osType.toLowerCase());
			// 结果返回
			result = "{\"result\":\"0\",\"errorCode\":\"0\"}";
		} catch (Exception e) {
			// 结果返回
			result = "{\"result\":\"1\",\"errorCode\":\"1\"}";
		}
		// 前端展示
		writeToPage(result);
	}

	// 校验参数
//	private boolean checkParam(String userId,String casCookie, String sessionId) {
//		// 用以验证
//		LoginCheckBean bean = new LoginCheckBean(sessionId, casCookie);
//		// 获取验证信息
//		LoginCheckBean value = DpmCacheManager.getCookieAndSession(userId);
//		// 不为空且相等
//		if (value != null && value.equals(bean)) {
//			// 返回
//			return true;
//		}
//		// 返回
//		return false;
//	}

	/**
	 * 查询人员详情.
	 */
	public void getEmpDetail() {
		// 返回集合
		Result<EmployeeVO> res = new Result<EmployeeVO>();
		List<EmployeeVO> lists = new ArrayList<EmployeeVO>();
		logger.info("通讯录点击详情接口请求参数：：id---"+id+"---searchCode---"+searchCode);
		if(StringUtils.isEmpty(id)&&StringUtils.isEmpty(searchCode)){
			res.setErrorMessage("参数为空，请重新查询");
			// 无参数
			writeToPage(res);	
			return ;
		}
		// 通过id获取人员详情
		EmployeeVO empDetail = tongxunLuService.getEmpDetail(id,searchCode);
		if(empDetail != null) {
			// 设置休假信息
			this.setFurlough(empDetail);
			// 如果是合伙人，需要屏蔽一些领导的手机和电话
			if(judgePartner()){
				setMobileAndTelForPartner(empDetail);
			}
			// 将人员信息添加到集合中，主要是为了判断常用联系人的添加与否的状态
			lists.add(empDetail);

			// TODO 通讯录监控记录：搜索vp用户
			dealSearchInfo(empDetail,id+"--"+searchCode);
		}
		// 判断常用联系人的添加状态
		lists = extractedFavorites(lists);
		// 返回第一个
		res.setData(lists.size() > 0 ? lists.get(0) : null);
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 前端展示
		writeToPage(res);
	}
	
	/**
	 * 处理查询信息
	 * 
	 * @param empDetail
	 */
	private void dealSearchInfo(EmployeeVO empDetail,String remark){
		try{
			// 需要验证的empcodeList
			List<String> empCodeList = new ArrayList<String>();
			// 从redis中获取数据
			String empList = redisService.get(CommonConstant.REDIS_KEY_MONITOR_TONGXUNLU_VP_LIST);
			if(StringUtils.isNotEmpty(empList)){
				// 需要验证的empcodeList
				empCodeList = JSON.parseArray(empList, String.class);
			} else {
				empCodeList = tongxunLuService.queryMonitorEmpCodeList();
				// 将需要验证的empcodeList放入缓存中
				redisService.set(CommonConstant.REDIS_KEY_MONITOR_TONGXUNLU_VP_LIST, JSON.toJSONString(empCodeList), MagicNumber.NUM30000);
			}
			// 通讯录监控记录：搜索vp用户
			tongxunLuService.monitorSearchVpInfo(empCodeList,empDetail,remark);
		} catch (Exception e) {
			logger.error("保存通讯录被搜索的vp用户信息出错！", e);
		}
	}
	
	/**
	 * 判断通讯录查询参数是否正确
	 * @return
	 */
	private boolean checkSearchParm(){
		boolean type = true;
		// 参数是否为空
		if(StringUtils.isEmpty(searchName)){
			return type;
		}
		// 通讯录匹配正则表达式
		String reg = "[\u4e00-\u9fa5\\w【】（）\\[\\]()]+";
		
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(searchName);
		// 参数是否正确
		if(matcher.matches()){
			type = false;
		}
		return type;
	}
	
	/**
	 * 保存用户搜索组织的关键字
	 */
	private void saveSearchOrgKeywordsForUserId () {
		try {
			orgMonitorService.saveSearchOrgKeywordsForUserId(userId,searchName);
		} catch (Exception e) {
			logger.error("保存用户搜索组织的关键字出错>>>> {userId = "+userId+",searchName = "+searchName+"}", e);
		}
	}

	/**
	 * 搜索查询条件的方法.
	 */
	@WhetherMonitorCutffPoint
	public void search() {
		// 请求参数处理
		if(checkSearchParm()){
			// 错误的查询参数
			Result<Object> res = new Result<Object>();
			// errorCode
			res.setErrorCode(Constants.WRONG_REQUEST);
			// errorMessage
			res.setErrorMessage("请求参数出错");
			// 返回
			writeToPage(res);
			// 跳出
			return;
		}
		
		// 人员查询
		if ("1".equals(searchType)) {
			queryEmp(judgePartner());
			// 组织查询
		} else if ("2".equals(searchType)) {
			// 保存用户搜索组织的关键字
			this.saveSearchOrgKeywordsForUserId();
			
			queryOrg(judgePartner());
		} else if("3".equals(searchType)) {
			this.queryEmpByJobduty(judgePartner());
		} else {
			// 错误的查询参数
			Result<Object> res = new Result<Object>();
			// errorCode
			res.setErrorCode(Constants.WRONG_REQUEST);
			// errorMessage
			res.setErrorMessage("没有传入正确的搜索类型");
			// 返回
			writeToPage(res);
		}
	}

	/**
	 * 组织查询
	 */
	private void queryOrg(boolean isPartner) {
		// 结果集定义
		Result<Object> res = new Result<Object>();
		// redis缓存获取组织信息
//		List<?> list = (List<?>) DpmCacheManager.redisGet(getEmpOrgKey());
//		if (list != null) {
//			// 查询到的组织信息大小
//			res.setCount(list.size());
//			// 返回内容
//			res.setData(list);
//			// 前端返回
//			writeToPage(res);
//			return;
//		}
		
		List<OrganizationVO> list = new ArrayList<OrganizationVO>();

		// 查询组织机构信息.
		OrganizationVO searchVo = new OrganizationVO();
		// 全模糊查询
		searchVo.setOrgName("%" + searchName + "%");
		
		// 查询组织信息
		if(isPartner){
			list = tongxunLuService.searchOrgForPartner(searchVo, start, pageSize);
		} else {
			list = tongxunLuService.searchOrg(searchVo, start, pageSize);
		}
		res.setCount(list.size());
		// 设置结果查询
		res.setData(list);
		// 将查询条件和结果放入redis缓存中
//		DpmCacheManager.redisSet(getEmpOrgKey(), list);
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 前端返回
		writeToPage(res);
	}
	
	/**
	 * 设置休假信息
	 */
	private void setFurlough(EmployeeVO employeeVO) {
		String furlough = null;
		try {
			// 查询休假信息
			furlough = redisService.get(RedisService.DPM_TONGXUNLU_FURLOUGH_KEY + employeeVO.getEmpCode());
		} catch (Exception e) {
			logger.error("查询人员休假信息出错!!!",e);
		}
		
		if(StringUtils.isNotEmpty(furlough)) {
			// 休假信息对象
			EmpFurloughInfoEntity empFurInfo = JSON.parseObject(furlough, EmpFurloughInfoEntity.class);
			// 休假类型
			employeeVO.setFurlough(empFurInfo.getFurloughType());
			// 交接人姓名
			employeeVO.setHandoverPerson(empFurInfo.getHandoverEmpCode());
		}
	}
	
	
	/**
	 * 人员查询，根据职责搜索
	 */
	private void queryEmpByJobduty(boolean isPartner) {
		// 结果集
		Result<Object> res = new Result<Object>();
		
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO searchVo = new EmployeeVO();
		searchVo.setJobDuty("%" + searchName + "%");
		// 查询
		if(isPartner){
			list = tongxunLuService.searchEmpForPartner(searchVo, start, pageSize);
			// 对于合伙人需要设置一些领导的手机和电话为空
			for (EmployeeVO employeeVO : list) {
				this.setMobileAndTelForPartner(employeeVO);
				
				// 设置休假信息
				this.setFurlough(employeeVO);
			}
		} else {
			list = tongxunLuService.searchEmp(searchVo, start, pageSize);
			// 设置休假信息
			for (EmployeeVO employeeVO : list) {
				this.setFurlough(employeeVO);
			}
		}
		
		// 常用联系人状态设置
		extractedFavorites(list);
		// 设置返回数据
		res.setData(list);
		res.setCount(list.size());
		
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		
		// 前端返回
		writeToPage(res);
	}

	/**
	 * 人员查询
	 */
	private void queryEmp(boolean isPartner) {
		// 结果集
		Result<Object> res = new Result<Object>();
		// 根据查询条件通过redis缓存获取人员信息
//		List<EmployeeVO> list = (List<EmployeeVO>) DpmCacheManager
//				.redisGet(getEmpOrgKey());
//		if (list != null) {
//			// 设定查询结果
//			res.setData(list);
//			// 查询数量
//			res.setCount(list.size());
//			// 前端返回
//			writeToPage(res);
//			return;
//		}
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();

		EmployeeVO searchVo = new EmployeeVO();
		// 呼入电话调用号码查询
		if ("1".equals(wayIn)) {
			// 设置查询条件
			searchVo.setMobileNo(searchName);
			// 查询
			if(isPartner){
				list = tongxunLuService.searchEmpForPartner(searchVo, start, pageSize);
				// 对于合伙人需要设置一些领导的手机和电话为空
				for (EmployeeVO employeeVO : list) {
					this.setMobileAndTelForPartner(employeeVO);
					// 设置休假信息
					this.setFurlough(employeeVO);
				}
			} else {
				list = tongxunLuService.searchEmp(searchVo, start, pageSize);
				
				// 设置休假信息
				for (EmployeeVO employeeVO : list) {
					this.setFurlough(employeeVO);
				}
			}
			// 查询结果
			if (CollectionUtils.isEmpty(list)) {
				// 没查到
				res.setCount(0);
				// 返回信息
				res.setData("查无此人");
				// errorCode
				res.setErrorCode(Constants.WRONG_REQUEST);
				// errorMessage
				res.setErrorMessage("没有这个号码对应的信息");
			} else {
				res.setCount(1);
				// 返回第一条数据
				res.setData(list.get(0));
				// errorCode
				res.setErrorCode(Constants.SUCCESS);
			}
		} else {
			// 定义匹配类型
			Pattern p = Pattern.compile("\\d{11}");
			// 传入参数匹配
			Matcher m = p.matcher(searchName);
			// 如果是11位数字，就进行电话号码的查询
			if (m.matches()) {
				// 设置查询条件
				searchVo.setMobileNo(searchName);
//				// 查询
//				list = tongxunLuService.searchEmp(searchVo, start, pageSize);
//				// 头像添加
//				extracted(detailPath, list);
//				// 常用联系人状态设置
//				extractedFavorites(list);
//				// 设置返回数据
//				res.setData(list);
//				res.setCount(list.size());
			} else {
				// 定义匹配类型
				Pattern p2 = Pattern.compile("^\\d+$");
				// 传入参数匹配
				Matcher m2 = p2.matcher(searchName);
				// 如果是纯数字，就进行人员编号的查询
				if (m2.matches()) {
					// 设置查询条件
					searchVo.setEmpCode(searchName);
//					// 查询
//					list = tongxunLuService
//							.searchEmp(searchVo, start, pageSize);
//					// 头像添加
//					extracted(detailPath, list);
//					// 常用联系人状态设置
//					extractedFavorites(list);
//					// 设置返回数据
//					res.setData(list);
//					res.setCount(list.size());
				} else {// 否则就根据人员名称查询
					// 性能原因，以及实际情况，将全模糊查询换成半模糊查询
					// searchVo.setEmpName("%" + searchName + "%");
					searchVo.setEmpName(searchName + "%");
//					// 查询人员信息
//					list = tongxunLuService.searchEmp(searchVo, start, pageSize);
//					// 头像添加
//					extracted(detailPath, list);
//					// 常用联系人状态设置
//					extractedFavorites(list);
//					// 设置返回数据
//					res.setData(list);
//					res.setCount(list.size());
				}
			}
			
			// 查询
			if(isPartner){
				list = tongxunLuService.searchEmpForPartner(searchVo, start, pageSize);
				// 对于合伙人需要设置一些领导的手机和电话为空
				for (EmployeeVO employeeVO : list) {
					this.setMobileAndTelForPartner(employeeVO);
					
					// 设置休假信息
					this.setFurlough(employeeVO);
				}
			} else {
				list = tongxunLuService.searchEmp(searchVo, start, pageSize);
				
				// 设置休假信息
				for (EmployeeVO employeeVO : list) {
					this.setFurlough(employeeVO);
				}
			}
			
			// 常用联系人状态设置
			extractedFavorites(list);
			// 设置返回数据
			res.setData(list);
			res.setCount(list.size());
			
			// errorCode
			res.setErrorCode(Constants.SUCCESS);
		}
		
		
		// 将查询条件和查询结果存入redis中
//		DpmCacheManager.redisSet(getEmpOrgKey(), list);
		// 前端返回
		writeToPage(res);
	}

	/**
	 * 个人头像添加
	 * 
	 * @param detailPath
	 * @param list
	 * @return
	 */
//	private List<EmployeeVO> extracted(String detailPath, List<EmployeeVO> list) {
//		// 人员信息集合
//		if (null != list && list.size() > 0) {
//			// 循环
//			for (int i = 0; i < list.size(); i++) {
//				try {
//					// 根据工号获取人员头像url
//					detailPath = personlyImageService.downloadImage(list.get(i)
//							.getEmpCode());
//				} catch (FileNotFoundException e) {
//					logger.error("通讯录人员头像获取失败:", e);
//				}
//				// 设置头像属性
//				list.get(i).setHeadPhoto(detailPath);
//			}
//		}
//		// 返回
//		return list;
//	}

	/**
	 * 获取人员信息条件拼接，用以查询条件
	 * 
	 * @return
	 */
//	private String getEmpOrgKey() {
//		StringBuilder builder = new StringBuilder();
//		// 添加类信息
//		builder.append(TongxunluAction.class.getName()).append(":");
//		// 人员组织查询键
//		builder.append("getEmpOrgKey").append(":");
//		// 电话呼入状态
//		builder.append(wayIn).append(":");
//		// 查询参数
//		builder.append(searchName).append(":");
//		// 查询类型
//		builder.append(searchType).append(":");
//		// 开始条数
//		builder.append(start).append(":");
//		// 页面大小
//		builder.append(pageSize).append(":");
//		// 拼接成的查询条件，及redis的key
//		return builder.toString();
//	}

	/**
	 * 组织信息条件拼接，用以条件查询
	 * 
	 * @return
	 */
//	private String getChildByOrgKey() {
//		StringBuilder builder = new StringBuilder();
//		// 添加类信息
//		builder.append(TongxunluAction.class.getName()).append(":");
//		// 组织架构查询键
//		builder.append("getChildByOrgKey").append(":");
//		// 组织id
//		builder.append(id).append(":");
//		// 开始条数
//		builder.append(start).append(":");
//		// 页面大小
//		builder.append(pageSize).append(":");
//		// 拼接成的查询条件，及redis的key
//		return builder.toString();
//	}

	/**
	 * 后台推送界面传过来的json搜索人员的条件，获取员工列表
	 */
	private String json;

	/**
	 * 推送人员查询
	 */
	public void pushUser() {
		Object list = null;
		try {
			// 通过传入的json值查询组织人员
			list = tongxunLuService.queryPushUser(json);
		} catch (Exception e) {
			// log
			logger.error("推送人员查询出错:", e);
		}
		// 前端返回
		writeToPage(list);
	}

	/**
	 * 全员查询（老）
	 */
	public void getAllUser() {
		Object list = null;
		try {
			// 查询可以推送的全部人员
			list = tongxunLuService.getAllUser();
		} catch (Exception e) {
			// log
			logger.error("推送人员查询出错:", e);
		}
		// 前端返回
		writeToPage(list);
	}

	/**
	 * 获取通讯录热线
	 */
	public void hotLine() {
		Result<Object> result = new Result<Object>();
		try {
			// 热线电话获取
			List<HotLine> hotLine = tongxunLuService.hotLine();
			// 数据
			result.setData(hotLine);
			// errorMessage
			result.setErrorMessage("查询热线成功");
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage("查询热线失败");
		}
		// 返回
		writeToPage(result);
	}

	/**
	 * 获取通讯录上领导信息
	 */
	private List<EmployeeVO> getLeadEmps(boolean isPartner) throws FileNotFoundException {
		// 根据组织id获取领导信息
		List<EmployeeVO> list = tongxunLuService
				.getEmpByOrgId(id, start, limit);
		// 个人头像定义
		String picPath = null;
		if (null != list && list.size() > 0) {
			// 循环
			for (int i = 0; i < list.size(); i++) {
				EmployeeVO employeeVO = list.get(i);
				// 设置休假信息
				this.setFurlough(employeeVO);
				if(isPartner){
					setMobileAndTelForPartner(employeeVO);
				}
				// 查询个人头像
				picPath = personlyImageService.downloadImage(employeeVO.getEmpCode());
				// 设置头像属性
				list.get(i).setHeadPhoto(picPath);
			}
			// 设置常用联系人状态
			extractedFavorites(list);
		}
		// 返回
		return list;
	}
	
	/**
	 * 设置合伙人看不到营运事业群B8以上、事业合伙人本部B9以上、跨境业务拓展组B8以上人员的手机和电话
	 */
	private void setMobileAndTelForPartner(EmployeeVO employeeVO){
		if(null == jobLevelsForB8) {
			jobLevelsForB8 = new ArrayList<String>();
			jobLevelsForB8.add("08");
			jobLevelsForB8.add("09");
			jobLevelsForB8.add("10");
			jobLevelsForB8.add("C");
			jobLevelsForB8.add("D");
		}
		
		if(null == jobLevelsForB9) {
			jobLevelsForB9 = new ArrayList<String>();
			jobLevelsForB9.add("09");
			jobLevelsForB9.add("10");
			jobLevelsForB9.add("C");
			jobLevelsForB9.add("D");
		}
		
		String jobLevel = employeeVO.getJobLevel();
		String deptSeq = employeeVO.getDeptSeq();
		
		if(null != deptSeq) {
			if((deptSeq.indexOf(".103.104.491696.") != -1 && jobLevelsForB8.contains(jobLevel))
					||((deptSeq.indexOf(".103.104.482229.477595.") != -1 
							|| deptSeq.indexOf(".103.104.491697.486682.") != -1)
						&& jobLevelsForB9.contains(jobLevel))) {
				employeeVO.setMobileNo(null);
				employeeVO.setTel(null);
			}
		}
	}
	

	/**
	 * 常用联系人状态设置 TODO 重复代码
	 * 
	 * @param list
	 * @return
	 */
	private List<EmployeeVO> extractedFavorites(List<EmployeeVO> list) {
		if(CollectionUtils.isEmpty(list)){
			return list;
		}
		// 根据工号获取常用联系人
		List<EmployeeVO> favorites = myFavoritesService.getFavorites(userId);
		// 用以存储常用联系人工号
		List<String> str = new ArrayList<String>();
		// 循环
		for (EmployeeVO favorite : favorites) {
			// 工号添加
			str.add(favorite.getEmpCode());
		}
		// 循环传入list
		for (int i = 0; i < list.size(); i++) {
			if (str.contains(list.get(i).getEmpCode())) {
				// 包含则设置常用联系人状态为不可点
				list.get(i).setMyFavoritesStatus("Y");
			} else {
				// 不包含则设置常用联系人状态为可点
				list.get(i).setMyFavoritesStatus("N");
			}
		}
		// 返回信息
		return list;
	}

	/**
	 * 组织架构条件拼接
	 * 
	 * @return
	 */
//	private String getOrgArchitectureKey() {
//		StringBuilder builder = new StringBuilder();
//		// 类信息拼接
//		builder.append(TongxunluAction.class.getName()).append(":");
//		// 组织架构信息拼接
//		builder.append("getOrgArchitectureKey").append(":");
//		// 查询条件
//		builder.append(searchName).append(":");
//		// 返回redis的key
//		return builder.toString();
//	}

	/**
	 * 通讯录组织架构组件
	 */
	public void orgArchitecture() {
		// 结果集
		Result<Object> result = new Result<Object>();
		// 通过redis缓存查询
//		Object obj = DpmCacheManager.redisGet(getOrgArchitectureKey());
//		if (obj != null) {
//			// 查询到结果则返回
//			writeToPage(obj);
//			// 跳出
//			return;
//		}
		try {
			// 组织机构查询
			List<OrganizationEntity> orgs = tongxunLuService
					.searchOrgArchitecture(searchName);
			// 查询数量
			result.setCount(orgs.size());
			// 结果
			result.setData(orgs);
			// 设置查询条件和查询结果
//			DpmCacheManager.redisSet(getOrgArchitectureKey(), result);
		} catch (Exception e) {
			logger.error("组织机构查询出错信息", e);
			// errorCode
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage("查询失败");
		}
		// 结果集返回
		writeToPage(result);
	}

	/************* 点赞、扔鸡蛋接口 ***************/
	// 被操作工号
	private String desEmpcode;
	// 操作类型 praise 点赞 debase 鸡蛋
	private String operateType;
	// 操作类型确认 Y 确认 N 取消
	private String configType;
	// 随机查看头像
	private String chooseGender;
	// 查询人工号
	private String objId;

	/**
	 * 点赞以及扔鸡蛋（老）
	 */
	public void operate() {
		Result<String> result = new Result<String>();
		// 用以参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 工号
		map.put("userId", userId);
		// 目标工号
		map.put("desEmpcode", desEmpcode);
		// 操作类型
		map.put("operateType", operateType);
		// 确认
		map.put("configType", configType);
		// 操作
		int operate = tongxunLuService.operate(map);
		// 设置操作结果
		result.setCount(operate);
		// 大于0
		if (operate > 0) {
			// 如果是praise，点赞
			if ("praise".equals(operateType)) {
				if (null == configType || "Y".equals(configType)) {
					// Y表示点赞
					result.setData("点赞成功");
				} else if ("N".equals(configType)) {
					// N表示取消点赞
					result.setData("取消点赞成功");
				}
			}
			// 如果是debase，扔鸡蛋
			if ("debase".equals(operateType)) {
				if (null == configType || "Y".equals(configType)) {
					// N表示扔鸡蛋
					result.setData("扔鸡蛋成功");
				} else if ("N".equals(configType)) {
					// N表示取消扔鸡蛋
					result.setData("取消扔鸡蛋成功");
				}
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			// 返回前端
			writeToPage(result);
			// 跳出
			return;
		}
		// 操作结果
		result.setData("操作失败");
		// errorCode
		result.setErrorCode(Constants.ACTION_RESULT_ERROR);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_NO);
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 获取点赞数量以及鸡蛋数量
	 */
	public void getCount() {
		// 结果集
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		// 用以参数拼接
		Map<String, Object> paraMap = new HashMap<String, Object>();
		// 工号
		paraMap.put("userId", userId);
		// 目标工号
		paraMap.put("objId", objId);
		// 结果返回
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			// 数据库查询结果
			resultMap = tongxunLuService.getCount(userId, objId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("数据请求失败");
		}
		// count
		result.setCount(resultMap.size());
		// data
		result.setData(resultMap);
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 发现接口（老）
	 */
	@WhetherMonitorCutffPoint
	public void getPersonPics() {
		// 结果集
		Result<Object> result = new Result<Object>();
		// 每页显示条数
		pageSize = PAGESIZE_20;
		// 起始
		start = limit * pageSize;
		// 用以参数拼接
		Map<String, Object> map = new HashMap<String, Object>();
		// 工号
		map.put("userId", userId);
		// 起始
		map.put("start", start);
		// 大小
		map.put("pageSize", pageSize);
		// 性别查询
		if (null != chooseGender && "m".equals(chooseGender)) {
			// m表示男士
			map.put("chooseGender", "m");
		} else if ("f".equals(chooseGender)) {
			// f表示女士
			map.put("chooseGender", "f");
		}
		// 获取发现信息
		List<Map<String, Object>> resultList = tongxunLuService
				.getPersonPics(map);
		// 大小
		result.setCount(resultList.size());
		// data
		result.setData(resultList);
		// errorCode
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_YES);
		// 前端返回
		writeToPage(result);
	}
	
	/**
	 * 发现 性别筛选
	 */
	private String gender;

	/**
	 * 排序接口（老）
	 */
	@WhetherMonitorCutffPoint
	public void getSort() {
		// 结果
		Result<Object> result = new Result<Object>();
		// 用以参数拼接
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("gender", gender);
		// 获取排序信息
		List<Map<String, Object>> sort = tongxunLuService.getSort(map);
		// 获取排序的数量
		result.setCount(sort.size());
		// 获取数据
		result.setData(sort);
		// errorCode
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_YES);
		// 前端返回
		writeToPage(result);
	}

	/************* 点赞、扔鸡蛋接口 ***************/

	/************* 最美微笑所有接口 ***************/
	// 变量引用发现变量
	/**
	 * 最美微笑接口
	 */
	public void getSmilePersonPics() {
		// 定义返回的数组
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		// 结果集
		Result<Object> result = new Result<Object>();
		// 每页大小
		pageSize = PAGESIZE_20;
		// 起始
		start = limit * pageSize;
		// 用以参数拼接
		Map<String, Object> map = new HashMap<String, Object>();
		// 工号
		map.put("userId", userId);
		// 起始
		map.put("start", start);
		// 每页大小
		map.put("pageSize", pageSize);
		try {
			// 最美微笑内容
			resultList = tongxunLuService.getSmilePersonPics(map);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			logger.error("最美微笑获取数据失败", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("数据请求失败");
		}
		// 返回数量
		result.setCount(resultList.size());
		// 设置结果
		result.setData(resultList);
		// 前端返回
		writeToPage(result);
	}

	/**
	 * 最美微笑点赞和扔鸡蛋
	 */
	public void operateSmile() {

		Result<String> result = new Result<String>();
		// 用以参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 工号
		map.put("userId", userId);
		// 目标工号
		map.put("desEmpcode", desEmpcode);
		// 操作类型
		map.put("operateType", operateType);
		// 确认
		map.put("configType", configType);
		int operate = 0;
		try {
			// 操作
			operate = tongxunLuService.operateSmile(map);
		} catch (Exception e) {
			// 空处理
			logger.error("operateSmile::",e);
		}
		// 设置操作结果
		result.setCount(operate);
		// 大于0
		if (operate > 0) {
			// 如果是praise，点赞
			if ("praise".equals(operateType)) {
				// Y表示点赞
				if (null == configType || "Y".equals(configType)) {
					result.setData("点赞成功");
					// N表示取消点赞
				} else if ("N".equals(configType)) {
					result.setData("取消点赞成功");
				}
			}
			// 如果是debase，扔鸡蛋
			if ("debase".equals(operateType)) {
				if (null == configType || "Y".equals(configType)) {
					// Y表示扔鸡蛋
					result.setData("扔鸡蛋成功");
				} else if ("N".equals(configType)) {
					// N表示取消扔鸡蛋
					result.setData("取消扔鸡蛋成功");
				}
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			// 返回前端
			writeToPage(result);
			// 跳出
			return;
		}
		// 操作结果
		result.setData("操作失败");
		// errorCode
		result.setErrorCode(Constants.ACTION_RESULT_ERROR);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_NO);
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 最美微笑数量查询
	 */
	public void getSmileCount() {
		// 结果集定义
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		// 参数拼接
		Map<String, Object> paraMap = new HashMap<String, Object>();
		// 工号
		paraMap.put("userId", userId);
		// 对应工号
		paraMap.put("objId", objId);
		// 定义最美微笑查询
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			// 获取最美微笑count
			resultMap = tongxunLuService.getSmileCount(userId, objId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("数据请求失败");
		}
		// count
		result.setCount(resultMap.size());
		// data
		result.setData(resultMap);
		// 前端
		writeToPage(result);
	}

	/**
	 * 最美微笑排序接口
	 */
	public void getSmileSort() {
		// 定义结果集
		Result<Object> result = new Result<Object>();
		// 排序结果
		List<Map<String, Object>> sort = new ArrayList<Map<String, Object>>();
		try {
			// 排序结果
			sort = tongxunLuService.getSmileSort(userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("数据请求失败");
		}
		// count
		result.setCount(sort.size());
		// data
		result.setData(sort);
		// 前端
		writeToPage(result);
	}

	/************* 最美微笑所有接口 ***************/
	
	/**
	 * 通讯录leader列表
	 */
	public void dealEmpleaderConfig() {
		//searchType 操作   id 主键   userId 工号 osType 状态
		//新增
		if("add".equals(searchType) && StringUtils.isNotEmpty(userId)){
			Map<String, String> map = new HashMap<String,String>();
			//工号
			map.put("empcode", userId);
			//新增
			tongxunLuService.insertEmpleaderConfig(map);
		}else if("edit".equals(searchType)&& StringUtils.isNotEmpty(id)&& StringUtils.isNotEmpty(userId)){
			//编辑
			Map<String, String> map = new HashMap<String,String>();
			//工号
			map.put("empcode", userId);
			//主键
			map.put("id", id);
			if(StringUtils.isNotEmpty(osType)){
				//状态
				map.put("status", osType);
			}
			//编辑
			tongxunLuService.updateEmpleaderConfig(map);
		}else if("delete".equals(searchType)&& StringUtils.isNotEmpty(id)){
			//删除
			tongxunLuService.deleteEmpleaderConfig(id);
		}
	}

	// get
	public String getDesEmpcode() {
		return desEmpcode;
	}

	// set
	public void setDesEmpcode(String desEmpcode) {
		this.desEmpcode = desEmpcode;
	}

	// get
	public String getOperateType() {
		return operateType;
	}

	// set
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	// get
	public String getConfigType() {
		return configType;
	}

	// set
	public void setConfigType(String configType) {
		this.configType = configType;
	}

	// get
	public String getChooseGender() {
		return chooseGender;
	}

	// set
	public void setChooseGender(String chooseGender) {
		this.chooseGender = chooseGender;
	}

	// get
	public String getObjId() {
		return objId;
	}

	// set
	public void setObjId(String objId) {
		this.objId = objId;
	}

	// get
	public String getAppName() {
		return appName;
	}

	// set
	public void setAppName(String appName) {
		this.appName = appName;
	}

	// get
	public String getOsType() {
		return osType;
	}

	// set
	public void setOsType(String osType) {
		this.osType = osType;
	}

	// get
	public String getVersion() {
		return version;
	}

	// set
	public void setVersion(String version) {
		this.version = version;
	}

	// get
	public String getWayIn() {
		return wayIn;
	}

	// set
	public void setWayIn(String wayIn) {
		this.wayIn = wayIn;
	}

	// get
	public int getPageSize() {
		return pageSize;
	}

	// set
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// get
	public ITongxunLuService getTongxunLuService() {
		return tongxunLuService;
	}

	// set
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}

	// get
	public IAppVersionConfigService getAppVersionConfigService() {
		return appVersionConfigService;
	}

	/**
	 * 要设置的 appVersionConfigService
	 */
	// set
	public void setAppVersionConfigService(
			IAppVersionConfigService appVersionConfigService) {
		this.appVersionConfigService = appVersionConfigService;
	}

	// set
	public void setPersonlyImageService(
			IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}

	// get
	public String getId() {
		return id;
	}

	// set
	public void setId(String id) {
		this.id = id;
	}

	// get
	public String getSearchName() {
		return searchName;
	}

	// set
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	// get
	public String getSearchType() {
		return searchType;
	}

	// set
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	// get
	public int getMonitorType() {
		return monitorType;
	}

	// set
	public void setMonitorType(int monitorType) {
		this.monitorType = monitorType;
	}

	// set
	public void setMyFavoritesService(IMyFavoritesService myFavoritesService) {
		this.myFavoritesService = myFavoritesService;
	}

	// get
	public String getJson() {
		return json;
	}

	// set
	public void setJson(String json) {
		this.json = json;
	}

	/**
	 * get
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * setter
	 * @param orgMonitorService
	 */
	public void setOrgMonitorService(IOrgMonitorService orgMonitorService) {
		this.orgMonitorService = orgMonitorService;
	}

	/**
	 * set
	 * @param redisService
	 */
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

	/**
	 * get
	 * @return
	 */
	public String getSearchCode() {
		return searchCode;
	}

	/**
	 * set
	 * @param searchCode
	 */
	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

}
