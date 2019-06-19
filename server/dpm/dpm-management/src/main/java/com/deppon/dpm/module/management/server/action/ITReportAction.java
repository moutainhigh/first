package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IIssuesAndAddrsService;
import com.deppon.dpm.module.management.server.service.IQueryTheaterInfoService;
import com.deppon.dpm.module.management.server.service.IReportHistoryService;
import com.deppon.dpm.module.management.server.service.IReportService;
import com.deppon.dpm.module.management.server.service.ITheaterDealService;
import com.deppon.dpm.module.management.shared.domain.Attachment;
import com.deppon.dpm.module.management.shared.domain.OrderAddRequest;
import com.deppon.dpm.module.management.shared.domain.QueryTheaterInfoRequset;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * IT上报Action
 * 
 * @author 233357
 * @date 2015/04/01
 */
public class ITReportAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private int monitorType;

	/**
	 * 任务列表类型 1 已受理，2已挂起
	 */
	private int type;

	/**
	 * 问题类型和具体位置接口定义
	 */
	private IIssuesAndAddrsService issuesAndAddrsService;

	/**
	 * 上报问题历史接口定义
	 */
	private IReportHistoryService reportHistoryService;

	/**
	 * 移动办公IT服务台终端查询接口
	 */
	private IQueryTheaterInfoService queryTheaterService;

	/**
	 * 移动办公IT服务台终端任务处理接口
	 */
	private ITheaterDealService theaterDealService;
	private IReportService reportService;
	
	// 记录请求固定资产列表信息的访问时间服务
	private IMonitorCountInfoService monitorCountInfoService;

	/**
	 * 查询问题列表
	 */
	public void queryIssuesAndAddrs() {
		// 设置页面响应实体
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 返回参数
		String rs = issuesAndAddrsService.queryIssuesAndAddrs();
		writeToPage(response, rs);
	}

	/**
	 * 查询上报历史
	 */
	public void queryReportHistory() {
		// 设置页面响应实体
		// 开始时间
		Date startDt = new Date();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 返回参数
		String rs = reportHistoryService.queryReportHistory(userId);
		// 结束时间
		Date endDt = new Date();
		if (monitorType==1) {//如果是点击上报历史，则监控上报历史
			// 保存到数据库
			monitorCountInfoService.saveMonitorCountInfo(userId,startDt,endDt,Constants.REPORT_HISTORY);
		}
		writeToPage(response, rs);
	}

	/**
	 * 移动办公IT服务台终端查询接口
	 */
	public void ispQueryList() {
		// 设置页面响应实体
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		QueryTheaterInfoRequset qr = new QueryTheaterInfoRequset();
		qr.setDealUserCode(userId);
		qr.setStart(start);
		qr.setLimit(limit);
		qr.setTaskType(type);
		String requestEntity = JSON.toJSONString(qr);

		// String ispQueryList =
		// queryTheaterService.queryTheater(requestEntity);
		// ispQueryList = ispQueryList.replaceAll("\\", "");
		// Result<Object> result = new Result<Object>();
		// result.setData(ispQueryList);
		// result.setErrorMessage("移动办公IT服务台终端查询接口");
		writeToPage(response, queryTheaterService.queryTheater(requestEntity));
	}

	/**
	 * 移动办公IT服务台终端任务处理接口
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public void ispTaskHandle() throws IOException {
		// 1提交2挂起3转二线 4挂起提交
		
		BufferedReader bu = ServletActionContext.getRequest().getReader();
		StringBuffer str = new StringBuffer();
		String str1 = "";
		try {
			while ((str1 = bu.readLine()) != null) {
				str.append(str1);
				// 将文本打印到控制台
				//System.out.println(str);
			}

		} catch (Exception ce) {
         ce.printStackTrace();
		} finally {
			try {
				bu.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		JSONObject json = new JSONObject().parseObject(str.toString());
		

		int handleType = json.getIntValue("handleType");
		if (handleType == 1) {
			if (json.getString("resionAnalyse")== null) {
				//throw new RuntimeException("提交必须填写原因");
				//不能直接抛出RuntimeException
				throw new BusinessException("提交必须填写原因");
			}
			if (json.getString("solution") == null) {
				//throw new RuntimeException("提交必须填写方案");
				throw new BusinessException("提交必须填写方案");
			}
		} else if (handleType == 2) {
			if (json.getString("hangupText") == null) {
				//throw new RuntimeException("挂起必须填写挂起备注");
				throw new BusinessException("挂起必须填写挂起备注");
			}
		} else if (handleType == MagicNumber.NUM3) {
			// 转二线必须填写“转二线备注”
			if (json.getString("twohandleText") == null) {
				//throw new RuntimeException("挂起必须填写挂起备注");
				throw new BusinessException("挂起必须填写挂起备注");
			}
		}

		// 设置页面响应实体
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// String jsonString = JSON.toJSONString(dealRequest);
		// System.err.println(jsonString);
		String theaterDeal = theaterDealService.theaterDeal(str.toString());
		Result<Object> result = new Result<Object>();
		result.setErrorMessage("移动办公IT服务台终端任务处理接口");
		result.setData(theaterDeal);
		writeToPage(response, result);
	}

	/**
	 * 提交上报
	 * 
	 * @throws IOException
	 */
	public void submitReport() throws IOException {
		// 设置页面响应实体
		//开始时间
		  Date startDate=new Date();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// uid，提交类型，问题类型code,地址，详细地址，手机号码，是否总部职能，
		//String strJson2 = "{\"uid\":\"\",\"attachment\":[{\"attachmentName\":\"001.jpg\",\"attachmentUrl\":\"V1hwS1lXR\"}],\"orderRequest\":[{\"reporterCode\":\"237986\",\"addType\":2}]}";
		// 比传字段uid orderRequest中的addType 另新增attachmentsName附件名称数组单独传进来
		BufferedReader bu = null;
		String strJson = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			strJson=StringUtil.bufferString(bu);
		} catch (Exception ce) {
			ce.printStackTrace();
        } 
		String newName = null;
		String oldName = null;
		String result = "";
		if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(strJson)) {
		OrderAddRequest order=JsonUtil.jsonToEntity(JsonUtil.jsonStrToArray(strJson, "orderRequest"), OrderAddRequest.class);
		int addType = order.getAddType();// 事件上报类别，1 正常上报 2 只上报图片
		// 正常上报
			if (addType == 1) {// 如果是正常上报设置部门ID
				int deptId = reportService.queryDeptByEmpCode(userId);
				order.setDeptId(String.valueOf(deptId));
			}
			// 上报图片
			if (addType == 2) {
				Attachment att=JsonUtil.jsonToEntity(JsonUtil.jsonStrToArray(strJson, "attachment"), Attachment.class);
				oldName = att.getAttachmentName();// 传进来的原附件名
				String uid=JsonUtil.jsonGetValueBykey(strJson, "uid");
				int index = oldName.lastIndexOf(".");
				String suffis = oldName.substring(index + 1);// 获取后缀
				// 获取图片名及图片流
				// uid为空说明该用户提交的第一张图片
				if (uid.equals("")) {// uid为空则生成图片名并返回uid
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String nowTime = df.format(new Date());
					newName = userId + nowTime + "1" + "." + suffis;// 工号加当前时间加后缀生成图片名
				} else {// 若uid不为空则尾数加1并返回uid
					newName = uid.substring(0, MagicNumber.NUM20)
							+ (Integer.parseInt(uid.substring(MagicNumber.NUM20, MagicNumber.NUM21)) + 1) + "."
							+ suffis;
				}
				att.setAttachmentName(newName);
				order.setAttachment(att);
			}
			try {
				result = reportService.submitReport(order);
				if (result == null) {
					result = "{\"isSuccess\":\"N\",\"errMessage\":\"哎呀，请求出错，请稍后再试!\"}";
				} else {
					if (addType==1) {
				    	// 结束时间
					    Date endDate = new Date();
				    	//统计成功提交IT上报问题数
					    monitorCountInfoService.saveMonitorCountInfo(userId, startDate, endDate, Constants.SUCCESS_SUBMIT_REPORT);
			    	}
					else {// 如果是传送图片则返回newName,如果正常上报则直接返回
						result = "{\"isSuccess\":\"" + JsonUtil.jsonGetValueBykey(result,"isSuccess")
						+ "\",\"errMessage\":\"" + JsonUtil.jsonGetValueBykey(result,"errMessage")
						+ "\",\"uid\":\"" + newName + "\"}";
					}
				}
			//System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
				result = "{\"isSuccess\":\"N\",\"errMessage\":\"哎呀，请求出错，请稍后再试!\"}";
			}
			if (addType==1) {
		    	// 结束时间
			    Date endDate = new Date();
		    	//统计响应时长
			    monitorCountInfoService.saveMonitorCountInfo(userId, startDate, endDate, Constants.SUBMIT_REPORT);
	    	}
		}
		// 返回给页面
		writeToPage(response, result);
	}

	/**
	 * 查询登录用户是否有权限
	 */
	public void queryAuthority() {
		// 设置页面响应实体
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = null;
		// if (userId!=null) {
		res = reportService.queryAuthority(userId);
//		if (res == null) {
//			res = "{\"resultFlag\":\"N\",\"errorMsg\":\"哎呀，请求出错，请稍后再试!\",\"dealRole\":false}";
//		}
		// 返回给页面
		writeToPage(response, res);
	}

	public void setReportService(IReportService reportService) {
		this.reportService = reportService;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setIssuesAndAddrsService(
			IIssuesAndAddrsService issuesAndAddrsService) {
		this.issuesAndAddrsService = issuesAndAddrsService;
	}

	public void setReportHistoryService(
			IReportHistoryService reportHistoryService) {
		this.reportHistoryService = reportHistoryService;
	}

	public void setQueryTheaterService(
			IQueryTheaterInfoService queryTheaterService) {
		this.queryTheaterService = queryTheaterService;
	}

	public void setTheaterDealService(ITheaterDealService theaterDealService) {
		this.theaterDealService = theaterDealService;
	}

	public int getType() {
		return type;
	}
	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}

	public int getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(int monitorType) {
		this.monitorType = monitorType;
	}


	
}
