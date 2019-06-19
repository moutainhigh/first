package com.deppon.dpm.module.main.server.job;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.deppon.ar.bamp.common.util.DateUtil;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.main.server.dao.IMainPageDao;
import com.deppon.dpm.module.main.shared.domain.NoticeDetailEntity;
import com.deppon.dpm.module.management.server.service.IReserveSubmitSerivce;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;

/**
 * 预定场地 提前10-15分钟消息通知
 * 
 * @author 王亚男
 *
 */
public class NoticePushJob {

	/**
	 * 按顺序 <value> 秒 分 小时 日期 月份 星期 年 </value>
	 */
	public static Logger logger = LoggerFactory.getLogger(NoticePushJob.class);

	/**
	 * 推送消息方法
	 */
	private IJPushNewService jPushNewService;

	private IMainPageDao mainPageDao;

	/**
	 * 每天5点推送最新未读的一条
	 */
	@SuppressWarnings("all")
	public void execute() {
		String hostIp = this.getHostIp();
		//10.249.5.15/16/98/99/74/75
		if (hostIp.equals("10.249.5.99")) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "7");
			// map.put("userId", userId);
			map.put("isRead", "0");
			// 查询通知详情表是否存在该条通知
			try {
				List<NoticeDetailEntity> nds = mainPageDao
						.getNoticeTodayList(map);
				StringBuffer sb = new StringBuffer();
				Set<String> tmSet = new HashSet<String>();
				for (NoticeDetailEntity nd : nds) {

					tmSet.add(nd.getUserId());

				}
				for (String set : tmSet) {
					sb.append(set).append(",");
				}
				String userIds = sb.toString().replaceAll(",$", "");
				JPushParam entity = new JPushParam();
				entity.setUserIds(userIds);
				entity.setAlert("您有未读的工资通知消息，请阅读");
				entity.setContent("");
				entity.setIntoMC(false);
				entity.setIsEcc(false);
				// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
				entity.setLinktype(0);
				//entity.setLinkaddr("");
				jPushNewService.pushByUserIds(entity);
				// 保存推送记录到消息中心
				entity.setPushConditionValue(entity.getUserIds());
				jPushNewService.saveToMsgCentre(entity, 0);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("推送工资消息消息发生异常", e);
			}

			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.put("type", "8");
			// map.put("userId", userId);
			newMap.put("isRead", "0");
			// 查询通知详情表是否存在该条通知
			try {
				List<NoticeDetailEntity> nds = mainPageDao
						.getNoticeTodayList(newMap);
				StringBuffer sb = new StringBuffer();
				Set<String> tmSet = new HashSet<String>();
				for (NoticeDetailEntity nd : nds) {

					tmSet.add(nd.getUserId());

				}
				for (String set : tmSet) {
					sb.append(set).append(",");
				}
				String userIds = sb.toString().replaceAll(",$", "");
				JPushParam entity = new JPushParam();
				entity.setUserIds(userIds);
				entity.setAlert("您有未读的考勤通知消息，请阅读");
				entity.setContent("");
				entity.setIntoMC(false);
				entity.setIsEcc(false);
				// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
				entity.setLinktype(0);
			    //entity.setLinkaddr("app_package/ANPS/index.html");
				//entity.setLinkaddr("");
				jPushNewService.pushByUserIds(entity);
				// 保存推送记录到消息中心
				entity.setPushConditionValue(entity.getUserIds());
				jPushNewService.saveToMsgCentre(entity, 0);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("推送考勤消息发生异常", e);
			}

		}

	}

	private static String getHostIp() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface
					.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
						.nextElement();
				Enumeration<InetAddress> addresses = netInterface
						.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address
							&& !ip.isLoopbackAddress() // loopback地址即本机地址，IPv4的loopback范围是127.0.0.0
														// ~ 127.255.255.255
							&& ip.getHostAddress().indexOf(":") == -1) {
						System.out.println("本机的IP = " + ip.getHostAddress());
						logger.info("本机的IP = " + ip.getHostAddress());
						return ip.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	public IMainPageDao getMainPageDao() {
		return mainPageDao;
	}

	public void setMainPageDao(IMainPageDao mainPageDao) {
		this.mainPageDao = mainPageDao;
	}

	public static void main(String[] args) {
		String hostIp = getHostIp();
		System.out.println(hostIp);
	}
}
