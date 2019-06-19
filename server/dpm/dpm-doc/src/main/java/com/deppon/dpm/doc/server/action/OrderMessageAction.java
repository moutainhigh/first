package com.deppon.dpm.doc.server.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IOrderMessageService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 首页显示订单（服务中,预约订单信息）
 * 
 * @author gwl 20180305
 */
public class OrderMessageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(OrderMessageAction.class);
	private String userId;

	/**
	 * 构造方法
	 */
	public OrderMessageAction() {
		super();
	}

	/**
	 * 滴滴订单服务
	 */
	private IOrderMessageService orderMessageService;
	
	/**
	 * 获取没有完成的订单信息，供循环调用回调接口用
	 */
	public void getorderno(){
		logger.info("<<<<<<<<<<<获取订单信息开始>>>>>>>>>>>");
		List<DidiOrderEntity> orderMessageList = orderMessageService.findOrderMessage(userId);
		logger.info("<<<<<<<<<<<获取订单信息结束>>>>>>>>>>>");
		JSONObject jonum = new JSONObject();
		if (orderMessageList != null && orderMessageList.size() > 0) {
			List<String> ordernoList = new ArrayList<String>();
			for (DidiOrderEntity temp : orderMessageList) {
				ordernoList.add(temp.getBillno());
			}
			jonum.put("bishave", 0);
			jonum.put("orderno", ordernoList);
			jonum.put("msg", "存在进行中的订单，请调用回调接口");
		}else {
			jonum.put("bishave", 1);
			jonum.put("msg", "不存在进行中的订单，无需调用回调接口");
		}
		// 返回页面数据
		writeToPage(jonum);
	}

	/**
	 * 返回正在进行和预约中的订单信息
	 */
	@CookieNotCheckedRequired
	public void orderMessage() {
		JSONObject jonum = new JSONObject();
		logger.info("<<<<<<<<<<<获取订单信息开始>>>>>>>>>>>");
		List<DidiOrderEntity> orderMessageList = orderMessageService.findOrderMessage(userId);
		logger.info("<<<<<<<<<<<获取订单信息结束>>>>>>>>>>>");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowdatetime = format.format(System.currentTimeMillis());
		int day = (Integer.parseInt(nowdatetime.substring(8, 10)) + 1);
		String lastdatetime = nowdatetime.substring(0, 8) + day + " 00:00:00";
		List<DidiOrderEntity> nowentityList = new ArrayList<DidiOrderEntity>();// 今天小于10分鐘的訂單,进行中
		List<DidiOrderEntity> todayentityList = new ArrayList<DidiOrderEntity>();// 今天大于10分鐘的訂單
		List<DidiOrderEntity> tomorrowentityList = new ArrayList<DidiOrderEntity>();// 明天預約的訂單
		List<DidiOrderEntity> aftertomentityList = new ArrayList<DidiOrderEntity>();// 後天預約的訂單
		try {
			Date nowdate = format.parse(nowdatetime);// 当前时间
			Date lastdate = format.parse(lastdatetime);// 今天24:00:00
			long todaylms = lastdate.getTime() - nowdate.getTime();// 当前时间与今天24:00:00相差的毫秒数
			long todayhours = (todaylms / (60 * 60 * 1000));// 相差小时数

			for (DidiOrderEntity temp : orderMessageList) {
				String olddatetime = temp.getDeparturetime();
				if ("".equals(olddatetime)) {
					nowentityList.add(temp);
					continue;
				}
				Date olddate = format.parse(olddatetime);
				long truelms = olddate.getTime() - nowdate.getTime();// 当前时间与给定时间差的毫秒数
				// long days=truelms/(24*60*60*1000);//这个时间相差的天数整数
				long hours = (truelms / (60 * 60 * 1000));// 这个时间相差的减去天数的小时数
				long min = (truelms / (60 * 1000));// 相差的分钟数
				if (todayhours - hours >= 0 && todayhours > hours && min > 10) {
					todayentityList.add(temp);// //今天大于10分鐘的訂單
				}
				if (hours - todayhours >= 0 && todayhours + 24 - hours >= 0) {
					tomorrowentityList.add(temp);// 明天預約的訂單
				}
				if (hours - todayhours - 24 >= 0
						&& todayhours + 48 - hours >= 0) {
					aftertomentityList.add(temp);// 後天預約的訂單
				}
				else {
					nowentityList.add(temp);// 今天小于10分鐘的訂單 进行中
				}
			}
		} catch (ParseException e) {
			e.getMessage();
			logger.error("获取订单信息异常---------"+e.getMessage());
		}
		if (todayentityList.size() != 0) {
//			jonum.put("预约时间", "今天");
			jonum.put("msg", "1");
			jonum.put("orderdate", "今天");
			jonum.put("orderList", todayentityList);
		}
		if (tomorrowentityList.size() != 0) {
//			jonum.put("预约时间", "明天");
			jonum.put("msg", "1");
			jonum.put("orderdate", "明天");
			jonum.put("orderList", tomorrowentityList);
		}
		if (aftertomentityList.size() != 0) {
//			jonum.put("预约时间", "后天");
			jonum.put("msg", "1");
			jonum.put("orderdate", "后天");
			jonum.put("orderList", aftertomentityList);
		}
		if (nowentityList.size() != 0) {
//			jonum.put("预约时间", "进行中");
			jonum.put("msg", "1");
			jonum.put("orderdate", "进行中");
			jonum.put("orderList", nowentityList);
		}
		if (nowentityList.size() == 0 && aftertomentityList.size() == 0 && tomorrowentityList.size() == 0 && todayentityList.size() == 0) {
			jonum.put("msg", "1");
			jonum.put("orderdate", "");
			jonum.put("orderList", todayentityList);
		}
		// 返回页面数据
		
		writeToPage(jonum);
	}

	/**
	 * 返回当天完成的订单信息
	 */
	@CookieNotCheckedRequired
	public void orderSuccessMessage() {
		JSONObject jonum = new JSONObject();
		logger.info("<<<<<<<<<<<获取返回完成订单信息开始>>>>>>>>>>>");
		List<DidiOrderEntity> orderMessageList = orderMessageService.findTodayOrder(userId);
		logger.info("<<<<<<<<<<<获取返回完成订单信息结束>>>>>>>>>>>");
		float mileages = 0;// 总理程
		float totalcost = 0;// 总费用
		for (DidiOrderEntity temp : orderMessageList) {
			mileages = mileages + Float.parseFloat(temp.getNormalDistance());
			totalcost = totalcost + temp.getTotalPrice();
		}
		jonum.put("totalcost", totalcost);
		jonum.put("mileages", mileages);
		jonum.put("ordersize", orderMessageList.size());
		// 返回页面数据
		writeToPage(jonum);
	}

	/**
	 * @return the orderMessageService
	 */
	public IOrderMessageService getOrderMessageService() {
		return orderMessageService;
	}

	/**
	 * @param orderMessageService
	 *            the orderMessageService to set
	 */
	public void setOrderMessageService(IOrderMessageService orderMessageService) {
		this.orderMessageService = orderMessageService;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
