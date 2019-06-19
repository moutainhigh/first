package com.deppon.dpm.module.main.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.main.server.service.IMainPageService;
import com.deppon.dpm.module.main.shared.domain.NoticeCenterEntity;
import com.deppon.dpm.module.main.shared.domain.NoticeDetailEntity;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class MainPageAction extends BaseAction {

	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory
			.getLogger(MainPageAction.class);
	private static final long serialVersionUID = 1L;

	private IMainPageService mainPageService;

	/**
	 * 通知类型
	 */
	private String type;
	/**
	 * 状态开关
	 */
	private String status;
	/**
	 * 类型名
	 */
	private String typename;
	/**
	 * 每条通知唯一id
	 */
	private String noticeId;
	
	/**
	 * 工号
	 */
	private String userId;
	
	/**
	 * 默认传1
	 */
	private String pageNo;
	/**
	 * 默认传1
	 */
	private ITongxunLuService tongxunLuService;

	/**
	 * 查询每个人所拥有的卡片信息----仅用于0605版本
	 */
	//@CookieNotCheckedRequired
	public void cardDetail() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		String cards = "";
		try {
			cards = mainPageService.cardDetailByUserId(userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取卡片信息异常:" + e);
			e.printStackTrace();
			logger.error("获取卡片信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(cards);
		// 返回
		writeToPage(result);

	}

	/**
	 * 查询每个人所拥有的卡片信息-----若无数据，不返回该卡片
	 */
	//@CookieNotCheckedRequired
	public void cardshow() {
		this.solveCrossDomain();
		// 结果集
		Result<Object> result = new Result<Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		String cards = "";
		EmployeeVO params = new EmployeeVO();
		params.setEmpCode(userId);
		EmployeeEntity emp = tongxunLuService.queryEmployeeByCode(params);
		Calendar now = Calendar.getInstance();	   
        String date=dealDate(now);
        String content ="";
		if(null!=emp){
		 content = date + emp.getEmpName();
		}
		String noticeContent = "你有";
		
	

		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			map1 = mainPageService.cardshow(userId, "", pageNo, new Date());
			int workflowCount = Integer.parseInt(String.valueOf(map1.get("workflowCount")));
			int calendarCount = Integer.parseInt(String.valueOf(map1.get("calendarCount")));
			if (workflowCount >0) {
				noticeContent += workflowCount + "个未审批工作流,";
			} else if (calendarCount>0) {
				noticeContent += calendarCount + "个会议,";
			}else {
				if(noticeContent.equals("你有")){
				noticeContent="";
			}
			}
			noticeContent=noticeContent.replaceAll(",$", "");
			
			map.put("content", content);
			map.put("noticeContent", noticeContent);
			
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取卡片信息异常:" + e);
			e.printStackTrace();
			logger.error("获取卡片信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		map.put("cards", map1.get("cardStr"));
		// data
		result.setData(map);
		// 返回
		writeToPage(result);
	}
   /**
    * 获取当前时间
    * @param now
    */
	private String dealDate(Calendar now) {
		    int nowHours = now.get(Calendar.HOUR_OF_DAY);  
	        int nowMinutes = now.get(Calendar.MINUTE);  
	        String salutatoryH4 = "";
		    if (6 <= nowHours && nowHours < 8) {
			   salutatoryH4 = "早安，";
			   //salutatoryP = '新的一天，美美的';
			  } else if (8 <= nowHours && nowHours < 12) {
			   salutatoryH4 = "上午好，";
			  // salutatoryP = '奋斗是一种风景';
			  } else if (12 <= nowHours && nowHours < 13) {
			   salutatoryH4 = "午安，";
			   //salutatoryP = '好好吃饭，好好休息';
			  } else if (13 <= nowHours && nowHours < 14 && nowMinutes < 30) {
			   salutatoryH4 = "午安，";
			  // salutatoryP = '好好吃饭，好好休息';
			  } else if (13 <= nowHours && nowHours < 14 && nowMinutes >= 30) {
			   salutatoryH4 = "下午好，";
			   //salutatoryP = '人、车、场的热闹，有你也有我';
			  } else if (14 <= nowHours && nowHours < 19) {
			   salutatoryH4 = "下午好，";
			  // salutatoryP = '人、车、场的热闹，有你也有我';
			  } else if (19 <= nowHours && nowHours < 22) {
			   salutatoryH4 = "晚上好，";
			  // salutatoryP = '夜深了，也亮了';
			  } else if (22 <= nowHours && nowHours < 23) {
			   salutatoryH4 = "晚安，";
			 //  salutatoryP = '晚安，你不孤单';
			  } else if (23 <= nowHours && nowHours < 24) {
			   salutatoryH4 = "晚安，";
			  // salutatoryP = '晚安，你不孤单';
			  } else if (0 <= nowHours && nowHours < 6) {
			   salutatoryH4 = "晚安，";
			  // salutatoryP = '晚安，你不孤单';
			  }
		    return salutatoryH4;
	}

	//@CookieNotCheckedRequired
	/**
	 * 通知中心首页
	 */
	public void noticeCenter() {
		this.solveCrossDomain();
		// 结果集
		Result<List<NoticeCenterEntity>> result = new Result<List<NoticeCenterEntity>>();
		List<NoticeCenterEntity> nclist = new ArrayList<NoticeCenterEntity>();
		try {
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			
			
			nclist = mainPageService.getType(userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取通知中心异常:" + e);
			e.printStackTrace();
			logger.error("获取通知中心异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(nclist);
		// 返回
		writeToPage(result);

	}
	
	

	/**
	 * 获取通知详情
	 * 
	 * @param ncEntity
	 * @param msgList
	 * @return
	 */
	//@CookieNotCheckedRequired
	public void getnoticeDetail() {
		this.solveCrossDomain();
		// 结果集
		Result<Object> result = new Result<Object>();
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		// 结果集
		List<NoticeDetailEntity> nclist = new ArrayList<NoticeDetailEntity>();
		nclist = mainPageService.getNoticeDetail(userId, type);
		// data
		result.setData(nclist);
		// 返回
		writeToPageforwfs(result);
	}

	/**
	 * 列表置顶功能
	 */
	//@CookieNotCheckedRequired
	public void noticeTop() {
		this.solveCrossDomain();
		
		// 结果集
		Result<List<NoticeCenterEntity>> result = new Result<List<NoticeCenterEntity>>();
		List<NoticeCenterEntity> nclist = new ArrayList<NoticeCenterEntity>();
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		try {
			nclist = mainPageService.setTop(userId, type);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取通知中心异常:" + e);
			e.printStackTrace();
			logger.error("获取通知中心异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(nclist);
		// 返回
		writeToPage(result);

	}
	/**
	 * 列表取消置顶功能
	 */
	//@CookieNotCheckedRequired
	public void noticeNotTop() {
		this.solveCrossDomain();
		// 结果集
		Result<List<NoticeCenterEntity>> result = new Result<List<NoticeCenterEntity>>();
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		List<NoticeCenterEntity> nclist = new ArrayList<NoticeCenterEntity>();
		try {
			nclist = mainPageService.notsetTop(userId, type );
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取通知中心异常:" + e);
			e.printStackTrace();
			logger.error("获取通知中心异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(nclist);
		// 返回
		writeToPage(result);
		
	}

	/**
	 * 更改通知已读
	 */
	//@CookieNotCheckedRequired
	public void noticeIsread() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		boolean res = false;
		try {
			res = mainPageService.noticeIsread(type, noticeId, userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("更改通知已读异常:" + e);
			e.printStackTrace();
			logger.error("更改通知已读异常:" + e.toString());
		}
		// data
		result.setData("更改通知已读结果：" + res);
		// 返回
		writeToPage(result);
	}

	/**
	 * 更改通知类型状态
	 */
	@CookieNotCheckedRequired
	public void updateType() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		boolean res = false;
		try {
			res = mainPageService.updateType(type, status);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取通知中心异常:" + e);
			e.printStackTrace();
			logger.error("获取通知中心异常:" + e.toString());
		}
		// data
		result.setData("更改通知类型结果：" + res);
		// 返回
		writeToPage(result);
	}

	/**
	 * 添加通知类型
	 */
	@CookieNotCheckedRequired
	public void addType() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		boolean res = false;
		try {
			res = mainPageService.addType(type, typename, status);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("添加通知类型异常:" + e);
			e.printStackTrace();
			logger.error("添加通知类型异常:" + e.toString());
		}
		// data
		result.setData("添加通知类型结果：" + res);
		// 返回
		writeToPage(result);
	}

	/**
	 * 删除通知类型
	 */
	@CookieNotCheckedRequired
	public void delType() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		boolean res = false;
		try {
			res = mainPageService.delType(type, typename);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("删除通知类型异常:" + e);
			e.printStackTrace();
			logger.error("删除通知类型异常:" + e.toString());
		}
		// data
		result.setData("删除通知类型结果：" + res);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 更改首页小卡片开关
	 */
	@CookieNotCheckedRequired
	public void updateCardType() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		boolean res = false;
		try {
			res = mainPageService.updateCardType(type, status);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("更改卡片状态异常:" + e);
			e.printStackTrace();
			logger.error("更改卡片状态异常:" + e.toString());
		}
		// data
		result.setData("更改卡片状态结果：" + res);
		// 返回
		writeToPage(result);
	}
	
	//一键已读
	//@CookieNotCheckedRequired
	public void readAllNotice(){
		//处理h5跨域
		this.solveCrossDomain();
		// 结果集
	   Result<String> result = new Result<String>();
	   if(ParamUtils.checkUserId(userId)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		//一键已读
		Boolean flag = mainPageService.noticeIsread(type, null, userId);
		if(flag){
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			// 返回
			writeToPage(result);
		}else{
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("一键读取失败");
			logger.error("一键读取失败的用时是:" + userId+"用户type是"+type);
			writeToPage(result);
		}
	}
	
	
	/**
	 * 通知中心同步接口：7工资  8 考勤
	 */
	@CookieNotCheckedRequired
	public void syncNotice() {
		//处理h5跨域
		this.solveCrossDomain();
		// 结果集
	   Result<String> result = new Result<String>();
		BufferedReader bu;
		try {
			bu = ServletActionContext.getRequest().getReader();
			// 编码转换
			String str = java.net.URLDecoder.decode(
					StringUtil.bufferString(bu), "utf-8");
			// json转换得到数据
			if (StringUtils.isNotBlank(str)) {
				List<NoticeDetailEntity> notice = JSONObject.parseArray(str,NoticeDetailEntity.class);
				for (NoticeDetailEntity ndEntity : notice) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("noticeId", ndEntity.getNoticeId());
					map.put("type", ndEntity.getType());
					map.put("userId", ndEntity.getUserId());
					map.put("createTime", ndEntity.getCreateTime());
					map.put("title", ndEntity.getTitle());
					map.put("content", ndEntity.getContent());
					map.put("creatorName", ndEntity.getCreatorName());
					int num = mainPageService.addNoticeDetail(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("同步失败:",e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(e.getMessage());
			writeToPage(result);
			return;
		}
		
		// errorCode
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_YES);
		writeToPage(result);
	}
	
	
	

	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	
	/**
	 * 重写writeToPage
	 */
	protected void writeToPageforwfs(Object result) {
		// 定义输出流
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置响应类型
			response.setContentType("text/html;charset=utf-8");
			// 跨域设置
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 获取一个printWriter对象
			writer = response.getWriter();
			// 打印,将null值输出为空字符串
			// writer.write(JSON.toJSONString(result,
			// SerializerFeature.WriteNullStringAsEmpty));
			writer.write(JSON.toJSONString(result,
					SerializerFeature.DisableCircularReferenceDetect));
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			if (writer != null) {
				// 关闭流
				writer.close();
			}
		}
	}

	public IMainPageService getMainPageService() {
		return mainPageService;
	}

	public void setMainPageService(IMainPageService mainPageService) {
		this.mainPageService = mainPageService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ITongxunLuService getTongxunLuService() {
		return tongxunLuService;
	}

	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}
	
	

}
