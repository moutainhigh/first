package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IBusMessageByFindService;
import com.deppon.dpm.module.management.server.service.IBusOpenLineAndNewsSiteService;
import com.deppon.dpm.module.management.server.service.IBusRedPointService;
import com.deppon.dpm.module.management.server.service.IBusUserRetroactionAddService;
import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 显示新增消息信息的action
 * 
 * @author 曹嵩
 * @date 2015.06.29
 * 
 */
public class BusMessageByFindAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusMessageByFindAction.class);
	
    //注入的service
	private IBusUserRetroactionAddService buraService;
	 //注入的service
	private IBusMessageByFindService busMessageByFindService;
	 //注入的service
	private IBusOpenLineAndNewsSiteService busOpenLineAndNewsSiteService;
	 //注入的service
	private IBusRedPointService busRedPointService;
    //get set
	public IBusRedPointService getBusRedPointService() {
		return busRedPointService;
	}
	//get set
	public void setBusRedPointService(IBusRedPointService busRedPointService) {
		this.busRedPointService = busRedPointService;
	}
	//get set
	public IBusOpenLineAndNewsSiteService getBusOpenLineAndNewsSiteService() {
		return busOpenLineAndNewsSiteService;
	}
	//get set
	public void setBusOpenLineAndNewsSiteService(
			IBusOpenLineAndNewsSiteService busOpenLineAndNewsSiteService) {
		this.busOpenLineAndNewsSiteService = busOpenLineAndNewsSiteService;
	}
	//get set
	public IBusUserRetroactionAddService getBuraService() {
		return buraService;
	}
	//get set
	public void setBuraService(IBusUserRetroactionAddService buraService) {
		this.buraService = buraService;
	}
	//get set
	public IBusMessageByFindService getBusMessageByFindService() {
		return busMessageByFindService;
	}
	//get set
	public void setBusMessageByFindService(
			IBusMessageByFindService busMessageByFindService) {
		this.busMessageByFindService = busMessageByFindService;
	}

	/**
	 * 显示所有消息信息
	 */
	public void getBusMessageByFind() {
		// 设置页面响应实体
		String res = "";
		List<BusMessageEntity> newList = new ArrayList<BusMessageEntity>();// 用来存放时间转换后的list集合
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
           //得到班车数据
			List<BusMessageEntity> busMessageList = busMessageByFindService
					.getBusMessageByFind();
			//对班车数据进行循环处理
			for (BusMessageEntity b : busMessageList) {
				b.setStrDate(sdf.format(b.getCreateDate()));
				newList.add(b);
			}
			//转换json格式数据
			res = JsonUtil.beanToJsonString(newList);
			logger.info("getBusMessageByFind-----" + res);
		} catch (Exception ce) {
			logger.info("getBusMessageByFind-----出错了！" + res);
			ce.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}

	/**
	 * 添加用户评价信息
	 */
	public void addBusUserRetroaction() {
		// 设置页面响应实体
		String res = "";
		BufferedReader bu = null;
		String str = "";
		logger.info(">>>>>>>>>BusMessageByFindAction中的strJson:" + str);
		// String str =
		// "{"userNo":"268102","userScore":"5","content":"我是小绵阳","photo":"","siteName":"育才路","createBy":"小嵩嵩"}";
		int flag = 0;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//得到页面传过来的数据
			bu = ServletActionContext.getRequest().getReader();
			//对数据进行处理
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			//判断是否为空
			if (!StringUtil.isEmpty(str)) {
				try {
					//保存数据
					flag = buraService.saveBusUserRetroaction(str);
					//判断是否保存了数据
					if (flag > 0) {
						res = "{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
					} else {
						res = "{\"resultFlag\":\"false\",\"failureReason\":\"saveBusUserRetroaction-----添加数据失败\"}";
					}
				} catch (Exception ce) {
					res = "{\"resultFlag\":\"false\",\"failureReason\":\"saveBusUserRetroaction----出现异常----添加数据失败\"}";
					ce.printStackTrace();
				}
			}
		} catch (Exception ce) {
			logger.info("bufferdReader报错" + bu);
			ce.printStackTrace();
		}
		//写入数据
			writeToPage(response, res);
	}

	/**
	 * 显示所有的建议站点信息
	 */
	public void getBusOpenLineAndNewsSite() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		//几种请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//对数据进行处理
			res = JsonUtil.beanToJsonString(busOpenLineAndNewsSiteService
					.querySiteAll());
			logger.info("BusMessageByFindAction-----getBusOpenLineAndNewsSite(显示所有的建议站点信息)-----res:"
					+ res);
		} catch (Exception ce) {
			logger.info("BusMessageByFindAction-----getBusOpenLineAndNewsSite(显示所有的建议站点信息)-----出错了-----res:"
					+ res);
			ce.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
    //标志位，判断是否有权限
	private String isAdmin;

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
    //得到总数
	public void getRedPointCount() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//处理数据
			res = JsonUtil.beanToJsonString(busRedPointService
					.getCount(isAdmin,userId));
			logger.info("BusMessageByFindAction-----getRedPointCount-----res:"
					+ res);
		} catch (Exception ce) {
			logger.info("BusMessageByFindAction-----getRedPointCount-----res:"
					+ res);
			ce.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);
	}
}
