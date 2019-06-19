package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IBusManagerService;
import com.deppon.dpm.module.management.shared.domain.BusFormBeanEntity;
import com.deppon.dpm.module.management.shared.domain.BusLineInfo;
import com.deppon.dpm.module.management.shared.domain.BusLineOfSite;
import com.deppon.dpm.module.management.shared.domain.BusManagerView;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * <p>
 * ClassName: BusManagerAction
 * </p>
 * <p>
 * Description: 班车管理和评价管理action
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-29
 * </p>
 */
public class BusManagerAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusManagerAction.class);
	/**
	 * 班车管理service接口
	 */

	private IBusManagerService busManagerService;
	/**
	 * 线路id
	 */
	private String lineId;
	/**
	 * <p>
	 * Field userNo: 用户工号
	 * </p>
	 */
	private String userNo;


	/**
	 * 得到路线调整数据
	 */
	public void getWayMessage() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			List<BusManagerView> listManagerView = busManagerService
					.getWayMessage(); // 得到线路调整的数据
			//转json
			res = JsonUtil.beanToJsonString(listManagerView);
			logger.info("线路调整数据查出成功!" + res);

		} catch (Exception ce) {
			res = "{\"resultFlag\":false,\"failureReason\":\"没有数据！\"}";
			ce.printStackTrace();
		}
		writeToPage(response, res);

	}

	/**
	 * 得到一条线路的详细信息
	 */
	public void getOneMessage() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//根据线路id查询线路详情
			List<BusMessageView> listManagerView = busManagerService
					.getOneMessage(lineId);
			//判断线路是否有数据
			if (listManagerView.size() > 0) {
				res = JsonUtil.beanToJsonString(listManagerView);
				logger.info("得到一条线路的详细数据!" + res);
			} else {
				res = "{\"resultFlag\":false,\"failureReason\":\"此线路没有数据！\"}";
			}

		} catch (Exception ce) {
			res = "{\"resultFlag\":false,\"failureReason\":\"此线路没有数据！\"}";
			ce.printStackTrace();
		}
		writeToPage(response, res);

	}

	/**
	 * <p>
	 * Description: 保存新增的线路
	 * </p>
	 * 
	 * @throws Exception
	 */
	
	public void saveLine() throws BusinessException {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = "";

		BusLineInfo lineInfo = new BusLineInfo();
		//判断参数是否为空
		if (!StringUtil.isEmpty(lineId)) {
			logger.info("进入新增新路action,传过来的线路id为" + lineId);
			lineInfo.setId(Integer.valueOf(lineId));
			//得到参数
			res = busManagerService.saveLineInfo(lineInfo);
		} else {
			res = "{\"resultFlag\":false,\"failureReason\":\"保存数据出错！\"}";
		}
		writeToPage(response, res);
	}

	/**
	 * <p>
	 * Description: 更新线路时间
	 * </p>
	 * 
	 * @throws Exception
	 *             抛出异常
	 */
	public void updateLineTime() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			//得到页面传来的参数
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			// str =
			// "{\"lineSiteId\":16,\"isAct\":0,\"lineId\":50,\"startDate\":\"09:30\"}";
			//判断参数是否为空
			if (!StringUtil.isEmpty(str)) {
                //转json
				JSONObject json = new JSONObject().parseObject(str);
				logger.info("更新线路站点页面传过来的参数为:" + json);
                //从json中得到参数数据
				String startDate = json.getString("startDate"); // 出发时间
				String newLineId = json.getString("lineId"); // 线路id
				if (!StringUtil.isEmpty(startDate)
						&& !StringUtil.isEmpty(newLineId)) {
					//正则表达式
					String el = "^([01]\\d|2[01234]):([0-5]\\d|60)$";
					//判断参数是否符合正则表达式
					Pattern p = Pattern.compile(el);
					Matcher m = p.matcher(startDate);
					boolean valDate = m.matches();
					if (valDate) {
						// 转时间格式
						SimpleDateFormat dateFormat = new SimpleDateFormat(
								"HH:mm");
						Date de = dateFormat.parse(startDate);
						BusLineInfo lineInfo = new BusLineInfo(); // 线路信息表
						lineInfo.setId(Integer.valueOf(newLineId));
						lineInfo.setStartDate(de);
						//得到更新线路的信息
						res = busManagerService.updateLineTime(lineInfo);
						logger.info("更新线路站点成功:" + res);

					} else {
						res = "{\"resultFlag\":false,\"failureReason\":\"时间参数出错！\"}";
					}

				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"站点更新传参出错！\"}";
				}

			} else {
				res = "{\"resultFlag\":false,\"failureReason\":\"站点更新传参出错！\"}";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("更新线路站点失败");
			e.printStackTrace();
		}
		writeToPage(response, res);

	}

	/**
	 * 更新线路的站点，状态， 也即对一条线路的站点进行开启，和关闭维护
	 * 
	 * @throws Exception
	 *             抛出异常
	 */
	public void updateStation() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			//得到参数
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			// str =
			// "{\"lineSiteId\":16,\"isAct\":0,\"lineId\":50,\"startDate\":\"09:30\"}";
			//判断参数是否为空
			if (!StringUtil.isEmpty(str)) {
                //把参数转为json格式
				JSONObject json = new JSONObject().parseObject(str);
				logger.info("更新线路站点页面传过来的参数为:" + json);
                //根据转换的json，得到数据
				int id = json.getInteger("lineSiteId"); // 站点id
				int act = json.getInteger("isAct"); // 站点是否开启标志位
                //对参数进行判断
				if (id > 0 && act >= 0) {
					//把参数放到对象中
					BusLineOfSite busOfSite = new BusLineOfSite(); // 线路站点表
					busOfSite.setId(json.getInteger("lineSiteId"));
					busOfSite.setIsAct(json.getInteger("isAct"));
                    //更新线路信息
					res = busManagerService.updateStation(busOfSite);
					logger.info("更新线路站点成功:" + res);
				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"站点更新传参出错！\"}";
				}

			} else {
				res = "{\"resultFlag\":false,\"failureReason\":\"站点更新传参出错！\"}";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("更新线路站点失败");
			e.printStackTrace();
		}
		writeToPage(response, res);

	}

	/**
	 * <p>
	 * Description: 得到评价建议列表接口
	 * </p>
	 */
	public void getEvaManData() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//得到评价建议数据
			res = busManagerService.getEvaManData();
			//判断得到的评价建议数据是否为空
			if (StringUtil.isEmpty(res)) {
				res = "{\"resultFlag\":false,\"failureReason\":\"没有数据！\"}";
			}
			

		} catch (Exception ce) {
			res = "{\"resultFlag\":false,\"failureReason\":\"没有数据！\"}";
			ce.printStackTrace();
		}
		writeToPage(response, res);

	}

	/**
	 * <p>
	 * Description: 获取历史反馈数据
	 * </p>
	 */
	public void getHistoryData() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
		/*	Map<String, Object> mapData = busManagerService
					.getHistoryData(userNo);*/
			//得到历史反馈的数据
			res =busManagerService
					.getHistoryData(userNo);
			//判断数据是否为空
			if (StringUtil.isEmpty(res)) {
				res = "{\"resultFlag\":false,\"failureReason\":\"没有数据！\"}";
			}
			

		} catch (Exception ce) {
			ce.printStackTrace();
		}
		writeToPage(response, res);
	}

	/**
	 * <p>
	 * Description: 删除回复
	 * </p>
	 * 
	 * @throws Exception
	 */
	public void delReply() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String res = "";
		BufferedReader bu = null;
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			//得到参数
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			logger.info("进入删除回复action:");
			//判断参数是否为空
			if (!StringUtil.isEmpty(str)) {
                //转json
				JSONObject json = new JSONObject().parseObject(str);
				logger.info("删除回复页面传过来的参数为:" + json);
				//从json中取出数据
				int replyId = json.getInteger("replyId"); // 回复id
				int mark = json.getInteger("mark"); // 区别建议和评价标志位 1是建议 0评价
				//判断参数是否符合条件
				if (replyId > 0) {
					BusFormBeanEntity beanEntity = new BusFormBeanEntity();
					beanEntity.setAdviceId(replyId);
					beanEntity.setMark(mark);
					//删除回复
					res = busManagerService.delReply(beanEntity);
				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"删除回复页面传参出错！\"}";
				}

			} else {
				res = "{\"resultFlag\":false,\"failureReason\":\"删除回复页面传参出错！\"}";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("删除回复失败");
			e.printStackTrace();
		}
		writeToPage(response, res);
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public void setBusManagerService(IBusManagerService busManagerService) {
		this.busManagerService = busManagerService;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


}
