package com.deppon.dpm.doc.server.job;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.entity.QueryRquestBudgetEntity;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.ISendWechartOfficialService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.anps.server.job.NoticeMessageJob;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;


public class ScheduleMessagePushJob {
	
	// 推送消息服务
	private IJPushNewService jPushNewService;
	
	private ISendWechartOfficialService sendWechartOfficialService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleMessagePushJob.class);
	
	private IDoubtfulExAuditService doubtfulExAuditService;
	/**
	 * 定时任务：每天10,14,16点推送预算不足通知
	 */
	public void execute() {
		
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
		
		// 获取主机地址
		//String hostAddress = address.getHostAddress();
			
		String hostAddress = this.getHostIp();
		System.out.println(hostAddress);
		LOG.info("服务器ip：" + hostAddress);
		if (hostAddress.equals("10.249.5.99")) {
			/*10.249.5.99*/
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;
        int today = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int hour = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        
        System.out.println("人力未传输排班信息消息推送开始..."+ month + today + hour);
        LOG.info("人力未传输排班信息消息推送开始..."+ month + today + hour  + "____月日时");
        
        
        int result = doubtfulExAuditService.selectScheduleState();
        
        
		if (result==0) {
			JPushParam paramuser = new JPushParam();
			paramuser.setAlert("未收到人力传过来的排班数据，请排查");// 消息弹出的内容
			paramuser.setContent("未收到人力传过来的排班数据，请排查");
			paramuser.setUserIds("633728,265564");
			//paramuser.setUserIds("245102,275309,274727");
			// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
			paramuser.setLinktype(2);
			paramuser.setLinkaddr("app_package/doc/index.html");
			paramuser.getExtras().put("toNews", "true");

			
				LOG.info("企业微信发送开始>>>>>>");
				String str = sendWechartOfficialService.sendWechartOfficial("未收到人力传过来的排班数据，请排查","265564");
				String str1 = sendWechartOfficialService.sendWechartOfficial("未收到人力传过来的排班数据，请排查","633728");
				LOG.info("未收到人力传过来的排班数据，请排查");
				LOG.info("企业微信发送结果>>>>>>" + str);
		}else{
			//删除前15天的排班数据
			doubtfulExAuditService.deleteScheduleState();
		}
        System.out.println("人力未传输排班信息消息推送结束...");
        LOG.info("人力未传输排班信息消息推送结束...");

    }
	} catch (Exception e) {
		LOG.error("人力未传输排班信息消息推送通知出错!!!", e);
	}
	LOG.info("人力未传输排班信息消息推送通知成功");
		
	}
	
	private String getHostIp(){
		try{
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()){
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()){
					InetAddress ip = (InetAddress) addresses.nextElement();
					if (ip != null 
							&& ip instanceof Inet4Address
                    		&& !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                    		&& ip.getHostAddress().indexOf(":") == -1){
						System.out.println("本机的IP = " + ip.getHostAddress());
						LOG.info("本机的IP = " + ip.getHostAddress());
						return ip.getHostAddress();
					} 
				}
			}
		}catch(Exception e){
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

	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}

	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}

	public ISendWechartOfficialService getSendWechartOfficialService() {
		return sendWechartOfficialService;
	}

	public void setSendWechartOfficialService(
			ISendWechartOfficialService sendWechartOfficialService) {
		this.sendWechartOfficialService = sendWechartOfficialService;
	}
	
}
