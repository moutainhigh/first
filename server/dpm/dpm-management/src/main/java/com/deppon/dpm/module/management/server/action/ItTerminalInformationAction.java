package com.deppon.dpm.module.management.server.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IItTerminalInformationService;
import com.deppon.dpm.module.management.shared.domain.Attachment;
import com.deppon.dpm.module.management.shared.domain.ItTerminalEnum;
import com.deppon.dpm.module.management.shared.domain.QueryTheaterInfoRequset;
import com.deppon.dpm.module.management.shared.domain.TheaterDealRequest;
import com.deppon.dpm.module.management.shared.domain.TheaterEventInfo;
import com.deppon.dpm.module.management.shared.domain.TheaterOrderWrappers;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.module.management.util.FileUploadUtil;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * IT信息处理
 * 
 * @date 2015-09-16
 * @author 231586
 * 
 */
public class ItTerminalInformationAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	// 日志
	private static final Logger logger = Logger
			.getLogger(ItTerminalInformationAction.class);
	// 图片类型
	private static final String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
	// 任务列表类型 0-未受理;1-已受理;2-已挂起
	private Integer taskType = 0;
	// 事件类型信息
	private TheaterEventInfo enventInfo;
	// 事件/问题编码
	private String orderCode;
	// 事件类型id
	private String faultCode;
	// 类型描述id
	private String faultSubcode;
	// 是否有效
	private String isavilabled;
	// 事件类型附件
	private File file;
	// 附件名称
	private String faultFileName;
	// 查询起始页数
	private Integer page = 0;
	// 实体类
	private TheaterDealRequest dealRequest;
	// set注入
	private IItTerminalInformationService itTerminalInformationService;
	// set注入
	private String hostPort;

	/**
	 * 请求IT PC终端获取列表信息
	 */
	@CookieNotCheckedRequired
	public void getAndSaveTerminalInfo() {
		// 返回实体类
		Result<List<TheaterOrderWrappers>> result = new Result<List<TheaterOrderWrappers>>();
		// 一页请求数据量
		int limit = Constants.CONSTANT_FIVE;
		// 查询起始条数
		int start = limit * page;
		// 用map拼接参数
		QueryTheaterInfoRequset qr = new QueryTheaterInfoRequset();
		qr.setDealUserCode(userId);
		qr.setStart(start);
		qr.setLimit(limit);
		qr.setTaskType(taskType);
		// 转换为JSON，PC端接收
		String jsonParam = JSON.toJSONString(qr);
		// 定义返回数据
		String responseStr = null;
		// 定义返回结果集
		List<TheaterOrderWrappers> lists = new ArrayList<TheaterOrderWrappers>();
		try {
			// POST请求获取数据
			responseStr = itTerminalInformationService.getItInfo(jsonParam);
			// 打印数据
			logger.info("从PC端获取的IT终端信息:" + jsonParam);
			// 数据格式转换
			JSONObject object = JSONObject.parseObject(responseStr);
			// 如果返回的isSuccess为Y，表示成功
			if (null != object
					&& "Y".equalsIgnoreCase(object.getString("resultFlag"))) {
				// 将获取数据转换为实体类
				JSONArray jsonArray = object.getJSONArray("orderWrappers");
				if (null != jsonArray && jsonArray.size() > 0) {
					// 实体类
					TheaterOrderWrappers wrapper = null;
					for (int i = 0; i < jsonArray.size(); i++) {
						// 获取对应实体
						wrapper = jsonArray.getObject(i,
								TheaterOrderWrappers.class);
						// 处理查询返回参数
						wrapper = dealTheaterOrderWrappers(wrapper);
						// 添加实体类
						lists.add(wrapper);
					}
				}
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			} else {
				// 返回出错信息
				result.setErrorMessage("IT服务台数据异常");
				// 出错编码
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			}
		} catch (Exception e) {
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 输入日志
			logger.info("从PC端获取的IT终端(已受理)出错信息:" + responseStr, e);
		}
		// 设置返回数量
		result.setCount(lists.size());
		// 返回实体类
		result.setData(lists);
		// 前台接受
		writeToPage(result);
	}

	/**
	 * 事件类型处理
	 */
	@CookieNotCheckedRequired
	public void handlerEventInfo() {
		// 返回实体类
		Result<List<TheaterEventInfo>> result = new Result<List<TheaterEventInfo>>();
		// 请求参数处理
		dealRequestParam(result);
		// 请求类型 1：事件类型；2：类型描述；3：详细类别
		String queryType = "1";
		// 请求编码
		String parentCode = "";
		if (StringUtils.isNotEmpty(orderCode) && StringUtils.isEmpty(faultCode)
				&& StringUtils.isEmpty(faultSubcode)) {
			// 事件类型
			parentCode = null;
			queryType = "1";
		} else if (StringUtils.isNotEmpty(faultCode)
				&& StringUtils.isEmpty(faultSubcode)) {
			// 类型描述
			parentCode = faultCode;
			queryType = "2";
		} else if (StringUtils.isNotEmpty(faultSubcode)) {
			// 详细类别
			parentCode = faultSubcode;
			queryType = "3";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("parentCode", parentCode);
		map.put("queryType", queryType);
		// IT服务台写死，不需要传
		// map.put("isavilabled", isavilabled);
		// 转换为JSON，PC端接收
		String jsonParam = JSON.toJSONString(map);
		// 定义返回数据
		String responseStr = null;
		// 定义返回结果集
		List<TheaterEventInfo> lists = new ArrayList<TheaterEventInfo>();
		try {
			// POST请求获取数据
			responseStr = itTerminalInformationService
					.getItEventInfo(jsonParam);
			// 打印数据
			logger.info("从PC端获取的事件类型:" + responseStr);
			// 数据格式转换
			JSONObject object = JSONObject.parseObject(responseStr);
			// 如果返回的isSuccess为Y，表示成功
			if (null != object
					&& "Y".equalsIgnoreCase(object.getString("isSuccess"))) {
				// 将获取数据转换为实体类
				JSONArray jsonArray = object.getJSONArray("faultInfo");

				if (null != jsonArray && jsonArray.size() > 0) {
					for (int i = 0; i < jsonArray.size(); i++) {
						// 获取对应实体
						TheaterEventInfo eventInfo = jsonArray.getObject(i,
								TheaterEventInfo.class);
						TheaterEventInfo info = new TheaterEventInfo();
						if ("1".equals(queryType)) {
							info.setFaultCode(eventInfo.getFaultCode());
							info.setFaultName(eventInfo.getFaultName());
						} else if ("2".equals(queryType)) {
							info.setFaultSubcode(eventInfo.getFaultCode());
							info.setFaultDesc(eventInfo.getFaultName());
						} else if ("3".equals(queryType)) {
							info.setModulCode(eventInfo.getFaultCode());
							info.setFaultModul(eventInfo.getFaultName());
						}
						// 添加实体类
						lists.add(info);
					}
				}

				// 事件类型排序 桌面维护，DLP顺序在前 id会变，根据名字来判断
				if ("1".equals(queryType)) {
					dealEventInfo(lists);
				}

				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			} else {
				// 返回出错信息
				result.setErrorMessage("IT服务台数据异常");
				// 出错编码
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			}
		} catch (Exception e) {
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 输入日志
			logger.info("从PC端获取的事件类型出错信息:" + responseStr, e);
		}
		// 设置返回数量
		result.setCount(lists.size());
		// 返回实体类
		result.setData(lists);
		// 前台接受
		writeToPage(result);
	}

	/**
	 * 终端处理接口
	 * 
	 */
	@CookieNotCheckedRequired
	public void handlerTerminalInfo() {
		// 返回实体类
		Result<String> result = new Result<String>();
		// 定义返回数据
		String responseStr = null;
		try {
			// 处理事件类型附件
			dealFaultFile();
			String json = JSON.toJSONString(dealRequest);
			// 判断处理类型
			if (dealRequest.getHandleType() == MagicNumber.NUM6) {
				// 已受理数据退回处理
				responseStr = handlerBackInfo();
			} else {
				// POST请求获取数据
				responseStr = itTerminalInformationService.getItDealInfo(json);
			}
			if (null != responseStr) {
				// 打印数据
				logger.info("从PC端获取的IT终端信息:" + responseStr);
				// 数据格式转换
				JSONObject object = JSONObject.parseObject(responseStr);
				// 如果返回的isSuccess为Y，表示成功
				if ("Y".equalsIgnoreCase(object.getString("isSuccess"))) {
					// handleType返回值为1，表示提交成功
					if (dealRequest.getHandleType() == 1) {
						result.setData("提交成功");
					}
					// handleType返回值为2，表示挂起成功
					if (dealRequest.getHandleType() == 2) {
						result.setData("挂起成功");
					}
					// handleType返回值为3，表示转二线成功
					if (dealRequest.getHandleType() == Constants.CONSTANT_THREE) {
						result.setData("转二线成功");
					}
					// handleType返回值为4，表示挂起提交成功
					if (dealRequest.getHandleType() == Constants.CONSTANT_FOUR) {
						result.setData("挂起提交成功");
					}
					// handleType返回值为5，表示受理成功
					if (dealRequest.getHandleType() == Constants.CONSTANT_FIVE) {
						result.setData("受理成功");
					}
					// handleType返回值为6，表示退回成功
					if (dealRequest.getHandleType() == Constants.CONSTANT_SIX) {
						result.setData("退回成功");
					}
					// 定义count 成功为0
					result.setCount(0);
					// 出错编码
					result.setErrorCode(Constants.ACTION_RESULT_SUC);
					// 返回出错信息
					result.setErrorMessage(Constants.ACTIVE_YES);
					// 如果返回的isSuccess为N，表示失败
				} else {
					// 定义count
					result.setCount(1);
					// 返回出错信息
					result.setData(object.getString("errMessage"));
					// 返回出错信息
					result.setErrorMessage("操作失败");
					// 出错编码
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				}
			} else {
				// 定义count 成功为0
				result.setCount(0);
				// 返回出错信息
				result.setErrorMessage("操作失败");
				// 出错编码
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			}
		} catch (Exception e) {
			// 定义count 失败为1
			result.setCount(1);
			// 返回出错信息
			result.setData("操作失败");
			// 返回出错信息
			result.setErrorMessage("操作失败");
			// 出错编码
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 打印出错日志信息
			logger.info("从PC端获取的IT终端(已受理)出错信息:" + responseStr, e);
		}
		// 返回信息给前端
		writeToPage(result);
	}

	/**
	 * 已受理页面退回处理接口
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	private String handlerBackInfo() throws IOException {
		TheaterDealRequest backDealRequest = new TheaterDealRequest();
		// 参数处理
		backDealRequest.setOrderCode(dealRequest.getOrderCode());
		backDealRequest.setDealUsercode(dealRequest.getDealUserCode());
		backDealRequest.setStatusCode(ItTerminalEnum.getThisByName(dealRequest.getStatusCode()));
		backDealRequest.setDealAdvice(dealRequest.getDealAdvice());
		String json = JSON.toJSONString(backDealRequest);
		// 定义返回数据
		String responseStr = itTerminalInformationService
				.getItBackDealInfo(json);
		return responseStr;
	}

	/**
	 * 处理事件类型附件
	 */
	private void dealFaultFile() {
		// 处理事件类型附件
		if (null != file && StringUtils.isNotEmpty(faultFileName)) {
			Attachment att = new Attachment();
			// 调用工具类 file转二进制
			byte[] faultBy = FileUploadUtil.file2byte(file);
			// 二进制转字符串
			String faultAttachment = FileUploadUtil.byte2hex(faultBy);
			att.setAttachmentName(faultFileName);
			att.setAttachmentUrl(faultAttachment);
			// 附件
			dealRequest.setAttachment(att);
			// 清空附件
			file = null;
			faultFileName = null;
		} else {
			Attachment att = new Attachment();
			att.setAttachmentName("");
			att.setAttachmentUrl("");
			dealRequest.setAttachment(att);
		}
	}

	/**
	 * 处理查询返回参数
	 * 
	 * @param wrapper
	 * @return
	 */
	private TheaterOrderWrappers dealTheaterOrderWrappers(
			TheaterOrderWrappers wrapper) {
		// 附件接受
		List<Map<String, String>> attPath = null;
		// 前端接受字典
		Map<String, String> map = null;
		// 对应状态，枚举值
		wrapper.setStatusCode(ItTerminalEnum.getThisById(wrapper
				.getStatusCode()));
		// 时间格式化
		wrapper.setTheaterTime(format(wrapper.getTheaterTime()));
		// 时间格式化
		wrapper.setReporterTime(format(wrapper.getReporterTime()));
		// 获取附件
		List<Attachment> list = wrapper.getAttachments();
		// 不用每次请求都存附件（防止中文名）
		if (null != list && list.size() > 0) {
			// 每次循环清空附件
			attPath = new ArrayList<Map<String, String>>();
			// 循环
			for (Attachment att : list) {
				// 判断
				if (null != att.getAttachmentUrl()
						&& att.getAttachmentUrl().length() > 0) {
					// 每次循环清空字典
					map = new HashMap<String, String>();

					// 附件判断，前台只接收图片类型附件
					Pattern pattern = Pattern.compile(reg);
					Matcher matcher = pattern.matcher(att.getAttachmentName()
							.toLowerCase());
					if (matcher.find()) {
						// 处理过后的附件名
						String imgp = dealAttachmentName(att
								.getAttachmentName());
						// 文件字符串上传服务器
						attachmentsPath(att.getAttachmentUrl(), imgp);

						// 字典值设置(文件名)
						map.put("name", imgp);
						// 字典值设置(路径)
						map.put("path", hostPort + "it/" + imgp);
						// 添加字典值
						attPath.add(map);
					}
				}
			}
			// 设置字典属性
			wrapper.setAttPath(attPath);
		}
		// 清空2进制字符串
		wrapper.setAttachment(null);
		wrapper.setAttachments(null);
		return wrapper;
	}

	/**
	 * 处理附件名
	 * 
	 * @return
	 */
	private String dealAttachmentName(String fileName) {
		if (StringUtils.isNotBlank(fileName)) {
			String name = fileName.substring(0, fileName.indexOf("@AS@P"));
			// 如果附件名为空,则随机生成附件名
			if (StringUtils.isBlank(name)) {
				name = UUID.randomUUID().toString();
			}
			String type = fileName.substring(fileName.lastIndexOf("."));
			fileName = name + type;
		}
		return fileName;
	}
	
	/**
	 * 处理事件类型排序 桌面维护，DLP顺序在前 id会变，根据名字来判断
	 * 
	 * @param lists
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void dealEventInfo(List<TheaterEventInfo> lists) {
		Collections.sort(lists, new Comparator() {
			@Override
			public int compare(Object arg0, Object arg1) {
				TheaterEventInfo obj1 = (TheaterEventInfo) arg1;
				if ("桌面维护".equals(obj1.getFaultName())
						|| "DLP问题".equals(obj1.getFaultName()) 
						|| "DLP".equals(obj1.getFaultName())) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	/**
	 * 格式化时间
	 * 
	 * @param time
	 * @return
	 */
	private String format(String time) {
		if (null != time) {
			// string-->long
			long parseLong = Long.parseLong(time);
			// 格式转换并返回
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(
					parseLong));
		}
		return null;
	}

	/**
	 * 请求参数处理
	 * 
	 * @param result
	 */
	private void dealRequestParam(Result<List<TheaterEventInfo>> result) {
		// 请求参数处理
		if (StringUtils.isEmpty(orderCode)
				|| (StringUtils.isEmpty(faultCode) && StringUtils
						.isNotEmpty(faultSubcode))) {
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 输入日志
			logger.info("请求参数出错！");
			// 设置返回数量
			result.setCount(0);
			// 返回实体类
			result.setData(new ArrayList<TheaterEventInfo>());
			// 前台接受
			writeToPage(result);
		}
	}

	/**
	 * 附件下载
	 * 
	 * @param url
	 * @param name
	 */
	private void attachmentsPath(String url, String name) {
		try {
			// 调用工具类上传附件
			FileUploadUtil.uploadFile(name, url);
		} catch (Exception e) {
			// log
			logger.info("上传附件时出现错误", e);
		}
	}

	// get
	public Integer getTaskType() {
		return taskType;
	}

	// set
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	// get
	public Integer getPage() {
		return page;
	}

	// set
	public void setPage(Integer page) {
		this.page = page;
	}

	// set
	public void setItTerminalInformationService(
			IItTerminalInformationService itTerminalInformationService) {
		this.itTerminalInformationService = itTerminalInformationService;
	}

	// get
	public TheaterDealRequest getDealRequest() {
		return dealRequest;
	}

	// set
	public void setDealRequest(TheaterDealRequest dealRequest) {
		this.dealRequest = dealRequest;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * set
	 * 
	 * @param orderCode
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public TheaterEventInfo getEnventInfo() {
		return enventInfo;
	}

	/**
	 * set
	 * 
	 * @param enventInfo
	 */
	public void setEnventInfo(TheaterEventInfo enventInfo) {
		this.enventInfo = enventInfo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * set
	 * 
	 * @param faultCode
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * set
	 * 
	 * @param hostPort
	 */
	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFaultSubcode() {
		return faultSubcode;
	}

	public void setFaultSubcode(String faultSubcode) {
		this.faultSubcode = faultSubcode;
	}

	public String getIsavilabled() {
		return isavilabled;
	}

	public void setIsavilabled(String isavilabled) {
		this.isavilabled = isavilabled;
	}

	public String getFaultFileName() {
		return faultFileName;
	}

	public void setFaultFileName(String faultFileName) {
		this.faultFileName = faultFileName;
	}

}
