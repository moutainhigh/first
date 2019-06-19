package com.deppon.dpm.tongxunlu.server.job;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.tongxunlu.server.service.IJpushMsgCentreService;


public class MsgCentreCleanJob {
	
	private static final Logger LOG = LoggerFactory.getLogger(MsgCentreCleanJob.class);
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private IJpushMsgCentreService msgCentreService;
	
	/**
	 * 清理2周之前的数据
	 */
	public void execute() {
		LOG.info("开始清理消息中心..." + DATE_FORMAT.format(new Date()));
		System.out.println("开始清理消息中心..." + DATE_FORMAT.format(new Date()));
		try {
			String hostAddress = this.getHostIp();
			if (hostAddress.equals("10.249.5.99")) {
			
			msgCentreService.cleanExpireData();
			}
		} catch (Exception e) {
			LOG.error("清理消息中心出错!!!",e);
		}
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

	public void setMsgCentreService(IJpushMsgCentreService msgCentreService) {
		this.msgCentreService = msgCentreService;
	}
	
	
}