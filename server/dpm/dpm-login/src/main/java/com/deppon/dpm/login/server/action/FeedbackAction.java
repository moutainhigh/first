package com.deppon.dpm.login.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.jfree.util.Log;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.login.server.domain.FeedbackEnum;
import com.deppon.dpm.login.server.service.IFeedbackService;
import com.deppon.dpm.login.server.service.ILoginService;
import com.deppon.dpm.login.server.util.ExcelExportUtil;
import com.deppon.dpm.login.server.vo.LoginResult;
import com.deppon.dpm.module.common.server.service.IUUMSRoleService;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.HxQuestionEntity;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackHxRecordEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackPushEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackProblemListEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackSearch;

/**
 * 意见反馈
 * 
 * @author 245968
 * 
 */
public class FeedbackAction extends BaseAction {
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(FeedbackAction.class);
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4565822472684533398L;
	/**
	 * set injection
	 */
	private IFeedbackService feedbackService;
	/**
	 * jsp reflection
	 */
	private List<FeedBackDetailsEntity> list;
	/**
	 * 意见反馈总条数
	 */
	private Integer count;
	/**
	 * 文件下载名称
	 */
	private String displayName = "feedback.xls";
	/**
	 * 文件路径
	 */
	private static String filePath = "/dpmfile/feedback.xls";
	private static final int ROWCELL_0 = 0;
	private static final int ROWCELL_1 = 1;
	private static final int ROWCELL_2 = 2;
	private static final int ROWCELL_3 = 3;
	private static final int ROWCELL_4 = 4;
	private static final int ROWCELL_5 = 5;
	private static final int ROWCELL_6 = 6;
	private static final int ROWCELL_7 = 7;
	private static final int ROWCELL_8 = 8;
	private static final int ROWCELL_9 = 9;
	private static final int ROWCELL_10 = 10;
	private static final int PAGESIZE_20 = 20;
	private static final String PAGESIZE_10 = "10";

	/**
	 * 总共的页数
	 */
	private int totalpage;
	/**
	 * 起始页
	 */
	private int currentPage = 1;
	/**
	 * 起始页App
	 */
	public String currentPageApp = "1";
	/**
	 * 页面显示数量
	 */
	private int pageSize = PAGESIZE_20;
	/**
	 * 页面显示数量App
	 */
	public String pageSizeApp = PAGESIZE_10;
	/**
	 * 设备类型
	 */
	private String osType;
	/**
	 * 意见反馈类型
	 */
	private String type;
	/**
	 * 是否解决
	 */
	private String isSolve;
	/**
	 * 反馈问题Id
	 */
	private String feedBackId;
	/**
	 * 上传的文件图片
	 */
	private File[] files;
	/**
	 * 上传文件的名称
	 */
	private String[] filesFileName;
	/**
	 * 意见反馈的内容
	 */
	private String content = "NULL";
	/**
	 * 欢行小服务台聊天记录内容
	 */
	private String contentHx = "NULL";
	/**
	 * 起始条数
	 */
	private int begin;
	/**
	 * 查询条件
	 */
	private FeedbackSearch search;
	/**
	 * 回复内容
	 */
	private String reply;
	/**
	 * 意见反馈实体类
	 */
	private FeedBackDetailsEntity feedBackDetailsEntity;
	
	/**
	 * 登陆账号
	 */
	private String loginId;
	
	/**
	 * 登陆密码
	 */
    private String loginPassword;
    
    /**
	 * 登录的服务
	 */
	private ILoginService loginService;

	/**
	 * 请求角色信息的service
	 */
	private IUUMSRoleService uUMSRoleService;
	
	/**
	 * RedisService
	 */
	private RedisService loginRedisService;
	
	/**
	 * 回复标题
	 */
	private String replyTitle;
	

	/**
	 * 消息推送实体类
	 */
	/*private FeedBackPushEntity pushEntity;*/

	private int detailId;
	
	// 意见反馈 消息推送 开始
	
	/**
	 *  set injection
	 */
	private IJPushNewService jPushService;

	
	

	/**
	 * 根据工号推送
	 */
	private static final int NUMBER_OF_THREE = 3;
	private static final int NUMBER_OF_FOUR = 4;
	public void pushByUserIds() {
		/**
		 *  实体类
		 */
		FeedBackPushEntity pushEntity = feedbackService.getSloverById(userId);
		if (pushEntity == null) {
			logger.info("查询问题反馈处理人失败 " + userId);
			return;
		}
		
		JPushParam entity = new JPushParam();
		entity.setUserIds(pushEntity.getExcEmpCode());
		entity.setContent(content);
		entity.setAlert("您收到一条问题反馈信息");
//		entity.setIsEcc(false);
		//无链接
		entity.setLinktype(NUMBER_OF_THREE);
		// 进消息中心
		entity.setIntoMC(true);
		Map<String,String> extras = new HashMap<String,String>();
		extras.put("detailId", pushEntity.getId());
		entity.setExtras(extras);
//		entity.setLinkaddr("");
		try {
			
			//推送
			//jPushService.pushByUserIds(entity);////德邦欢行后台反馈回复不推送 极光推送和消息中心
			
			//保存推送记录到消息中心
			entity.setPushConditionValue(entity.getUserIds());
			jPushService.saveToMsgCentre(entity, 0);
//			writeToPage("success");
		} catch (Exception e) {
			Log.error("根据工号推送失败!!! " + entity.toString(),e);	
		}
//		writeToPage("error");
		
	}
	
	/**
	 * 登陆意见反馈平台
	 */
	@CookieNotCheckedRequired
	public void loginFeedback(){
		// 定义返回结果
		final Result<Object> rstLogin = new Result<Object>();
        //检查是否是相关负责人
		boolean idcheck = feedbackService.checkExcEmpCode(loginId);
		//写死
/*		String loginId = "149994";
		String loginPassword = "qqqqqq";*/
	/*	String truePassword = new String("qqqqqq");*/
		if((idcheck == true) /*&& (loginPassword.equals(truePassword))*/){
			CasUserEntity casUserEntity = null;

			if(!loginId.equals("184185")){
				try{
					//走UUMS
					casUserEntity = loginService.userLoginFromUUMS(loginId, loginPassword);
				}catch(Exception e){
					// errorMessage
					rstLogin.setErrorMessage("验证用户名或密码错误");
					// errorCode
					rstLogin.setErrorCode(1);
					// 返回前端
					writeToPage(rstLogin);
					// 跳出
					return;
				}

			}else{
				try {
					// 获取cas实体类，走CAS
					casUserEntity = loginService.userLogin(loginId, loginPassword);
				} catch (Exception e) {
					// errorMessage
					rstLogin.setErrorMessage("验证用户名或密码错误");
					// errorCode
					rstLogin.setErrorCode(1);
					// 返回前端
					writeToPage(rstLogin);
					// 跳出
					return;
				}
			}
		  try{
			// 登陆结果实体
			LoginResult loginResult = new LoginResult();
			// 设置cookie
			loginResult.setCasCookie(casUserEntity.getCookie());
			// 设置sessionId
			loginResult.setSessionId(casUserEntity.getCasSessionId());
			// 返回前端封装
		    rstLogin.setData(loginResult);
			// errorCode
			rstLogin.setErrorCode(Constants.ACTION_RESULT_SUC);
			try {
				// 将登录信息存入redis缓存（时间为30分钟）
				loginRedisService.set(RedisService.DPM_LOGIN_LOGININFO_KEY + loginId, JSON.toJSONString(loginResult), MagicNumber.NUM1800);
			} catch (Exception e) {
				// errorCode
				rstLogin.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				rstLogin.setErrorMessage("系统发生异常，请稍后再试");
				// logger
				logger.error("[" + userId + "]登录发生异常>>>>",e);
			}
			// 前端返回
			this.writeToPage(rstLogin);
	    
		  }catch (Exception e) {
				// errorCode
				rstLogin.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				rstLogin.setErrorMessage(e.getMessage());
				// 前端返回
				this.writeToPage(rstLogin);
				// logger
				logger.error("[" + userId + "]登录发生异常>>>>",e);
			}
		}else{
			rstLogin.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			rstLogin.setErrorMessage("权限不足或密码输入错误");
			// 前端返回
			writeToPage(rstLogin);
			return;
		}
	}


	/**
	 * 保存意见反馈,后台可以查看提交用户的姓名，职位，工号，提交时间,内容，图片
	 */
	public void insert() {
		// 结果
		String result = null;
		try {
			// 存储信息
			feedbackService.feedback(files, filesFileName, content, userId,
					osType, type);
			// 返回信息
			result = "{\"result\":\"0\"}";
			// 返馈成功后 把相关信息推送到对应责任人
			this.pushByUserIds();
		} catch (Exception e) {
			// 返回信息
			result = "{\"result\":\"1\"}";
		}
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 获取意见反馈 问题类型列表
	 */
	public void getFeedBackProblemList() {
		Result<List<FeedbackProblemListEntity>> result = new Result<List<FeedbackProblemListEntity>>();
		List<FeedbackProblemListEntity> data = new ArrayList<FeedbackProblemListEntity>();
		try {
			data = feedbackService.problemList();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			//日志
			logger.info("获取问题列表失败" + e);
		}
		// count
		result.setCount(data.size());
		// data
		result.setData(data);
		writeToPage(result);
	}

	/**
	 * 根据处理人获取对应的处理列表
	 */
	public void getReportListByHandleId() {

		Result<List<FeedBackDetailsEntity>> result = new Result<List<FeedBackDetailsEntity>>();
		count = feedbackService.getReportListSize(userId, search);
		List<FeedBackDetailsEntity> reports = feedbackService.getReportListByHandleId(userId, currentPage, ROWCELL_10, search);
		result.setCount(count);
		result.setData(reports);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_YES);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		writeToPage(result);
	}
	
	/**
	 * 根据员工id获取意见反馈列表(包括常见问题)
	 */
	/*@WhetherMonitorCutffPoint*/
	public void getFeedbackByEmpCode() {
		// 结果集
		Result<Map<String, List<FeedBackDetailsEntity>>> result = new Result<Map<String, List<FeedBackDetailsEntity>>>();
		// 工号是否为空
		if (StringUtils.isNotEmpty(userId)
				&& currentPageApp.matches("^[0-9]*$")
				&& pageSizeApp.matches("^[0-9]*$")) {
			// 当前页
			int page = Integer.valueOf(currentPageApp);
			// 多少条
			int size = Integer.valueOf(pageSizeApp);
			// 开始
			begin = (page - 1) * size;
			// 获取意见反馈与常见问题列表
			Map<String, List<FeedBackDetailsEntity>> map = feedbackService
					.getFeedbackByEmpcode(begin, size, userId);
			// data
			result.setData(map);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} else {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求参数出错");
		}

		// 返回
		writeToPage(result);
	}
	
	/**
	 * 根据员工id判断该员工是否有未处理的【德邦欢行】意见反馈
	 */
	@CookieNotCheckedRequired
	public void hasUnsolvedProblem4doc() {
		// 结果集
		Result<Object> result = new Result<Object>();
		// 工号是否为空
		if (StringUtils.isNotEmpty(userId)
				&& currentPageApp.matches("^[0-9]*$")
				&& pageSizeApp.matches("^[0-9]*$")) {
			// 获取意见反馈与常见问题列表
			boolean hasUnsolvedProblem = feedbackService
					.hasUnsolvedProblem("德邦欢行", userId);
			// data
			result.setData(hasUnsolvedProblem);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} else {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求参数出错");
		}

		// 返回
		writeToPage(result);
	}

	/**
	 * 意见反馈是否解决
	 */
	public void feedbackIsSolve() {
		
		/**判断反馈类型是否为提成奖金，如果是提成奖金，则不保存数据库，调用接口将数据发送
		 * 
		 * 发送数据:意见反馈id、是否已解决isSolve(0,1)
		 * */
		
		// 结果集
		Result<String> result = new Result<String>();
		// 判断请求参数
		if (StringUtils.isNotEmpty(feedBackId)
				&& StringUtils.isNotEmpty(isSolve)
				&& feedBackId.matches("^[0-9]*$")) {
			// 创建对象
			FeedBackDetailsEntity feedBackDetailsEntity = new FeedBackDetailsEntity();
			// 意见反馈id
			feedBackDetailsEntity.setId(Integer.valueOf(feedBackId));
			// 是否解决
			feedBackDetailsEntity.setIsSolve(isSolve);
			feedBackDetailsEntity.setPlan(null);
			feedBackDetailsEntity.setExecutePerson(null);
			feedBackDetailsEntity.setPS(null);
			// 更新状态
			feedbackService.updateFeedback(feedBackDetailsEntity);
			// Count
			result.setCount(1);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("是否解决状态更新成功");
		} else {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求参数出错");
		}
		// 返回
		writeToPage(result);
	}

	/**
	 * 获取意见反馈
	 * 
	 * @return
	 */
	public String getFeedbackDetails() {
		// 分页获取意见反馈的数据
		list = feedbackService.getFeedbackDetails(getBegin(), pageSize,search);
		// 意见反馈的条数
		count = feedbackService.feedBackCount(search);
		// 总共多少页
		totalpage = getTotalpage();
		// 跳转jsp页面
		return "success";
	}

	/**
	 * 获取问题反馈详情
	 */
	@CookieNotCheckedRequired
	public void getFeedBackDetailsById() {

		Result<FeedBackDetailsEntity> result = new Result<FeedBackDetailsEntity>();
		FeedBackDetailsEntity data;
		data = feedbackService.getFeedBackDetailsById(this.detailId);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(data);
		writeToPage(result);
	}
	
	/**
	 * 更新意见反馈回复,并进行推送
	 */
	public void feedbackReply(){
		Result<FeedBackDetailsEntity> result = new Result<FeedBackDetailsEntity>();
		//更新反馈回复
		if(feedBackDetailsEntity.getReply()!= null){
			feedbackService.updateFeedbackReply(feedBackDetailsEntity);
		}else{
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			this.writeToPage(result);
			return;
		}
		//德邦欢行后台反馈回复不推送 极光推送和消息中心
		if(feedBackDetailsEntity!=null && "德邦欢行".equalsIgnoreCase(feedBackDetailsEntity.getType())){
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			this.writeToPage(result);
			return;
		}
		//反馈信息ID
		String pushid =  String.valueOf(feedBackDetailsEntity.getId());
		//推送实体
		FeedBackPushEntity pushEntity = new FeedBackPushEntity();
		pushEntity.setId(pushid);
		pushEntity.setExcEmpCode(feedBackDetailsEntity.getEmpCode());
		//无效的非空判断
//		if (pushEntity == null) {
//			logger.info("查询问题反馈处理人失败 " + userId);
//			return;
//		}
		JPushParam entity = new JPushParam();
		entity.setUserIds(pushEntity.getExcEmpCode());
		entity.setContent(feedBackDetailsEntity.getReply());
		entity.setAlert(replyTitle);
		//无链接
		entity.setLinktype(NUMBER_OF_FOUR);
		// 进消息中心
		entity.setIntoMC(true);
		Map<String,String> extras = new HashMap<String,String>();
		extras.put("detailId", pushEntity.getId());
		entity.setExtras(extras);
		try {
			//推送
			jPushService.pushByUserIds(entity);
			//保存推送记录到消息中心
			entity.setPushConditionValue(entity.getUserIds());
			jPushService.saveToMsgCentre(entity, 0);
		} catch (Exception e) {
			Log.error("根据工号推送失败!!! " + entity.toString(),e);	
		}
/*		FeedBackDetailsEntity fbEntity = new FeedBackDetailsEntity();
		fbEntity.setExecuteStatus("1");*/
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
	/*	result.setData(fbEntity);*/
		this.writeToPage(result);
	}
	

	/**
	 * 意见反馈页面更改保存
	 * 
	 * @return
	 */
	public String saveEditFeedback() {
		// 获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 意见反馈实体
		FeedBackDetailsEntity feedBackDetailsEntity = new FeedBackDetailsEntity();
		// 当前页数
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		// id数组
		String[] ids = request.getParameterValues("id");
		// 执行人数组
		String[] executePersons = request.getParameterValues("editInput1");
		// 意见数组
		String[] plans = request.getParameterValues("editInput2");
		// 备注数组
		String[] pss = request.getParameterValues("editInput3");
		// 执行状态数组
		String[] executeStatuss = request.getParameterValues("status");
		// 意见反馈时间
		Date submitTime = null;
		// 根据id存储
		if (null != ids && ids.length > 0) {
			// 循环存储
			for (int i = 0; i < ids.length; i++) {
				// 设置id
				feedBackDetailsEntity.setId(Integer.valueOf(ids[i]));
				// 设置处理人
				feedBackDetailsEntity.setExecutePerson(executePersons[i]);
				// 设置计划
				feedBackDetailsEntity.setPlan(plans[i]);
				// 设置处理意见
				feedBackDetailsEntity.setPS(pss[i]);
				// 设置处理状态
				feedBackDetailsEntity.setExecuteStatus(executeStatuss[i]);
				// 获取时间
				submitTime = feedbackService.getSubmitTimeById(Integer
						.valueOf(ids[i]));
				// 设置时间
				feedBackDetailsEntity.setSubmitTime(submitTime);
				// 更新意见反馈
				feedbackService.updateFeedback(feedBackDetailsEntity);
			}
		}
		// 跳转到jsp
		return getFeedbackDetails();
	}

	/**
	 * excel 下载
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public void exportExcel(){
		// 意见反馈实体
		FeedBackDetailsEntity feedBackDetailsEntity = null;
		// 获取意见反馈所有的条数
		count = feedbackService.feedBackCount(search);
		// 获取所有的意见反馈实体
		list = feedbackService.getFeedbackDetails(getBegin(), count,search);
		// 保存信息
		List<Object> lists = ExcelExportUtil.saveInformation("意见反馈", "序号",
				"工号", "姓名", "内容", "提交时间", "处理状态","处理意见", "是否解决", "处理人", "迭代安排", "设备", "问题类型");
		// 获得HSSFWorkbook实体类
		HSSFWorkbook workbook = (HSSFWorkbook) lists.get(0);
		// 获得HSSFSheet实体类
		HSSFSheet sheet = (HSSFSheet) lists.get(1);
		// 获得HSSFRow实体类
		HSSFRow row = (HSSFRow) lists.get(2);
		// 循环写出
		for (int i = 0; i < list.size(); i++) {
			// 获取每个意见反馈实体
			feedBackDetailsEntity = list.get(i);
			// 设置excel编号
			row = sheet.createRow(i + 1);
			// log
			logger.info("共" + list.size() + "条数据");
			// 工号
			row.createCell(ROWCELL_0).setCellValue(
					feedBackDetailsEntity.getEmpCode());
			// 姓名
			row.createCell(ROWCELL_1).setCellValue(
					feedBackDetailsEntity.getEmpName());
			// 内容
			row.createCell(ROWCELL_2).setCellValue(
					feedBackDetailsEntity.getContent());
			// 提交时间
			row.createCell(ROWCELL_3).setCellValue(
					feedBackDetailsEntity.getSubmitTime().toLocaleString());
			// 处理状态
			String executeStatus = StringUtils.isNotBlank(feedBackDetailsEntity.getExecuteStatus())?feedBackDetailsEntity.getExecuteStatus():"0";
			row.createCell(ROWCELL_4)
					.setCellValue(
							FeedbackEnum.getThisById(Integer
									.valueOf(executeStatus)));
			// 备注
			row.createCell(ROWCELL_5).setCellValue(
					feedBackDetailsEntity.getPS());
			//是否解决
			row.createCell(ROWCELL_6).setCellValue(getIsSolveInfo(
					feedBackDetailsEntity.getIsSolve()));
			// 处理人
			row.createCell(ROWCELL_7).setCellValue(
					feedBackDetailsEntity.getExecutePerson());
			// 迭代安排
			row.createCell(ROWCELL_8).setCellValue(
					feedBackDetailsEntity.getPlan());
			// 设备
			row.createCell(ROWCELL_9).setCellValue(feedBackDetailsEntity.getOsType());
			// 问题类型
			row.createCell(ROWCELL_10).setCellValue(feedBackDetailsEntity.getType());
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream os = null;
		try {
		    response.reset();
		    // 浏览器的下载框中自动显示的文件名
		    response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		    response.setHeader("Content-Type", "application/octet-stream");
		    response.addHeader("Content-Disposition", "attachment;filename=feedback.xls");
		    os = response.getOutputStream();
		    workbook.write(os);
		} catch (Exception e1) {
			// 打印错误
			logger.info("exportExcel+e1=="+e1);
		} finally {
			try {
				// 如果输出流不为null
				if (null != os) {
					os.close();
				}
			} catch (IOException e) {
				// 打印错误
				logger.info("exportExcel+e=="+e);
			}
		}
	}
	
	/**
	 * excel 下载
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public InputStream getInputStream() {
		// 意见反馈实体
		FeedBackDetailsEntity feedBackDetailsEntity = null;
		// 获取意见反馈所有的条数
		count = feedbackService.feedBackCount(search);
		// 获取所有的意见反馈实体
		list = feedbackService.getFeedbackDetails(getBegin(), count,search);
		// 保存信息
		List<Object> lists = ExcelExportUtil.saveInformation("意见反馈", "序号",
				"工号", "姓名", "内容", "提交时间", "处理状态","处理意见", "是否解决", "处理人", "迭代安排", "设备", "问题类型");
		// 获得HSSFWorkbook实体类
		HSSFWorkbook workbook = (HSSFWorkbook) lists.get(0);
		// 获得HSSFSheet实体类
		HSSFSheet sheet = (HSSFSheet) lists.get(1);
		// 获得HSSFRow实体类
		HSSFRow row = (HSSFRow) lists.get(2);
		// 循环写出
		for (int i = 0; i < list.size(); i++) {
			// 获取每个意见反馈实体
			feedBackDetailsEntity = list.get(i);
			// 设置excel编号
			row = sheet.createRow(i + 1);
			// log
			logger.info("共" + list.size() + "条数据");
			// 工号
			row.createCell(ROWCELL_0).setCellValue(
					feedBackDetailsEntity.getEmpCode());
			// 姓名
			row.createCell(ROWCELL_1).setCellValue(
					feedBackDetailsEntity.getEmpName());
			// 内容
			row.createCell(ROWCELL_2).setCellValue(
					feedBackDetailsEntity.getContent());
			// 提交时间
			row.createCell(ROWCELL_3).setCellValue(
					feedBackDetailsEntity.getSubmitTime().toLocaleString());
			// 处理状态
			String executeStatus = StringUtils.isNotBlank(feedBackDetailsEntity.getExecuteStatus())?feedBackDetailsEntity.getExecuteStatus():"0";
			row.createCell(ROWCELL_4)
					.setCellValue(
							FeedbackEnum.getThisById(Integer
									.valueOf(executeStatus)));
			// 备注
			row.createCell(ROWCELL_5).setCellValue(
					feedBackDetailsEntity.getPS());
			//是否解决
			row.createCell(ROWCELL_6).setCellValue(getIsSolveInfo(
					feedBackDetailsEntity.getIsSolve()));
			// 处理人
			row.createCell(ROWCELL_7).setCellValue(
					feedBackDetailsEntity.getExecutePerson());
			// 迭代安排
			row.createCell(ROWCELL_8).setCellValue(
					feedBackDetailsEntity.getPlan());
			// 设备
			row.createCell(ROWCELL_9).setCellValue(feedBackDetailsEntity.getOsType());
			// 问题类型
			row.createCell(ROWCELL_10).setCellValue(feedBackDetailsEntity.getType());
		}
		// 找文件
		File file = new File(filePath);
		// 不存在
		if (!file.exists())
			try {
				// 创建
				file.createNewFile();
			} catch (IOException e1) {
				// 打印错误
				e1.printStackTrace();
			}
		FileOutputStream fos = null;
		try {
			// 输出流
			fos = new FileOutputStream(file);
			// 写入
			workbook.write(fos);
		} catch (IOException e) {
			// 打印错误
			e.printStackTrace();
		} finally {
			try {
				// 如果输出流不为null
				if (null != fos) {
					fos.flush();
					// 关闭
					fos.close();
				}
			} catch (IOException e) {
				// 打印错误
				e.printStackTrace();
			}
		}
		// 定义输入流
		InputStream is = null;
		try {
			// 获取对应文件
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// 打印错误
			e.printStackTrace();
		}
		// 接受输入流，浏览器默认下载文件
		return is;
	}
	
	/**
	 * 是否解决 map
	 * @param isSolve
	 * @return
	 */
	private String getIsSolveInfo(String isSolve){
		Map<String, String> map = new HashMap<String,String>();
		//0解决 1未解决
		map.put("0", "已解决");
		map.put("1", "未解决");
		return map.get(isSolve);
	}
	
	/**
	 * 保存欢行意见反馈,后台可以查看提交用户的姓名，职位，工号，提交时间,内容，图片
	 */
	public void insertHx() {
		// 结果
		Result<Object> result = new Result<Object>();
		try {
			// 存储信息
			List<String> imgPath = feedbackService.feedbackHx(files, filesFileName, content, userId,
					osType, "德邦欢行");
			// 返回信息
			result.setData(imgPath);
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage("保存反馈信息成功!");
			// 返馈成功后 把相关信息推送到对应责任人
			this.pushByUserIds();
		} catch (Exception e) {
			// 返回信息
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("保存反馈信息失败!");
		}
		result.setCount(1);
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 获取欢行小服务台问题列表
	 * @since
	 * */
	@CookieNotCheckedRequired
	public void getHxQuestions(){
		Result<Object> result = new Result<Object>();
		List<HxQuestionEntity> hxQuestionList = feedbackService.getHxQuestions();
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(hxQuestionList);
		writeToPage(result);
		return;
	}
	
	/**
	 * 根据工号获取当前登录人的小服务台的消息记录
	 * 每个人在小服务台反馈信息表中只存储一条数据，消息记录是以JSON字符串形式保存
	 * @since 2019-04-13
	 * */
	@CookieNotCheckedRequired
	public void getHxChatRecordByUserId(){
		Result<Object> result = new Result<Object>();
		try {
			FeedBackHxRecordEntity entity = feedbackService.getHxChatRecordByUserId(userId);
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage("获取聊天记录成功!");
			result.setData(entity);
		} catch (Exception e) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("获取聊天记录失败!");
		}
		result.setCount(1);
		writeToPage(result);
	}
	
	/**
	 * 根据工号 修改 当前登录人的小服务台的消息记录
	 * 每个人在小服务台反馈信息表中只存储一条数据，消息记录是以JSON字符串形式保存
	 * @since 2019-04-13
	 * */
	@CookieNotCheckedRequired
	public void updateHxChatRecordByUserId(){
		Result<Object> result = new Result<Object>();
		try {
			FeedBackHxRecordEntity entity = feedbackService.getHxChatRecordByUserId(userId);
			if(entity ==null){
				feedbackService.insertHxChatRecord(userId,content,type);
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage("新增聊天记录成功!");
				result.setData(null);
			}else{
				feedbackService.updateHxChatRecord(userId,content);
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage("修改聊天记录成功!");
				result.setData(null);
			}
		} catch (Exception e) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("保存聊天记录失败!");
			e.printStackTrace();
			result.setData(null);
		}
		result.setCount(1);
		writeToPage(result);
	}

	/**
	 * 默认执行方法
	 * 
	 * @return
	 */
	public String execute() {
		// 跳转jsp
		return "success";
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
	public IFeedbackService getFeedbackService() {
		return feedbackService;
	}

	/**
	 * set
	 * 
	 * @param feedbackService
	 */
	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * set
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public File[] getFiles() {
		return files;
	}

	/**
	 * set
	 * 
	 * @param files
	 */
	public void setFiles(File[] files) {
		this.files = files;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String[] getFilesFileName() {
		return filesFileName;
	}

	/**
	 * set
	 * 
	 * @param filesFileName
	 */
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<FeedBackDetailsEntity> getList() {
		return list;
	}

	/**
	 * set
	 * 
	 * @param list
	 */
	public void setList(List<FeedBackDetailsEntity> list) {
		this.list = list;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * set
	 * 
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
		if (currentPage > getTotalpage()) {
			currentPage = getTotalpage();
		}
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * set
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	/**
	 * get
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * set
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * set
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * set
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIsSolve() {
		return isSolve;
	}

	/**
	 * set
	 * 
	 * @param isSolve
	 */
	public void setIsSolve(String isSolve) {
		this.isSolve = isSolve;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFeedBackId() {
		return feedBackId;
	}

	/**
	 * set
	 * 
	 * @param feedBackId
	 */
	public void setFeedBackId(String feedBackId) {
		this.feedBackId = feedBackId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCurrentPageApp() {
		return currentPageApp;
	}

	/**
	 * set
	 * 
	 * @param currentPageApp
	 */
	public void setCurrentPageApp(String currentPageApp) {
		this.currentPageApp = currentPageApp;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPageSizeApp() {
		return pageSizeApp;
	}

	/**
	 * set
	 * 
	 * @param pageSizeApp
	 */
	public void setPageSizeApp(String pageSizeApp) {
		this.pageSizeApp = pageSizeApp;
	}

	/**
	 * get
	 * @return
	 */
	public FeedbackSearch getSearch() {
		return search;
	}

	/**
	 * set
	 * @param search
	 */
	public void setSearch(FeedbackSearch search) {
		this.search = search;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	
	/**
	 * set
	 * @param jPushService
	 */
	public void setjPushService(IJPushNewService jPushService) {
		this.jPushService = jPushService;
	}

	/**
	 * get
	 * @return
	 */
	public FeedBackDetailsEntity getFeedBackDetailsEntity() {
		return feedBackDetailsEntity;
	}

	/**
	 * set
	 * @param feedBackDetailsEntity
	 */
	public void setFeedBackDetailsEntity(FeedBackDetailsEntity feedBackDetailsEntity) {
		this.feedBackDetailsEntity = feedBackDetailsEntity;
	}

	/**
	 * get
	 * @return
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * set
	 * @param reply
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * get
	 * @return
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * set
	 * @param loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * get
	 * @return
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * set
	 * @param loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	/**
	 * get
	 * @return
	 */
	public ILoginService getLoginService() {
		return loginService;
	}

	/**
	 * set
	 * @param loginService
	 */
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	
	public RedisService getLoginRedisService() {
		return loginRedisService;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}
	
	public IUUMSRoleService getuUMSRoleService() {
		return uUMSRoleService;
	}

	public void setuUMSRoleService(IUUMSRoleService uUMSRoleService) {
		this.uUMSRoleService = uUMSRoleService;
	}
	
	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	/**
	 * get
	 * @return
	 */
	/*public FeedBackPushEntity getPushEntity() {
		return pushEntity;
	}
*/
	/**
	 * set
	 * @param pushEntity
	 */
	/*public void setPushEntity(FeedBackPushEntity pushEntity) {
		this.pushEntity = pushEntity;
	}*/
	
	public String getContentHx() {
		return contentHx;
	}

	public void setContentHx(String contentHx) {
		this.contentHx = contentHx;
	}

}
