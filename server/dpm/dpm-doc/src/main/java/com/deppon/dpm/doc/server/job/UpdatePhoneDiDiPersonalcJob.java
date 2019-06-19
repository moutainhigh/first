package com.deppon.dpm.doc.server.job;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.service.IPersonalCenterService;

public class UpdatePhoneDiDiPersonalcJob {
	
	private IPersonalCenterService personalCenterService;
	
	private static final Logger LOG = LoggerFactory.getLogger(UpdatePhoneDiDiPersonalcJob.class);

	/**
	 * 定时任务：每天0点根据离职人员信息表 更新欢行绑定的联系电话号码(didi_personalc),欢行离职人员的联系号码全部更新为1个1+10个0，即10000000000
	 */
	public void execute() {
		
		String runningHostAddress = getHostIp();
		if("10.249.5.99".equals(runningHostAddress)){
			return;
		}
		
		String current_date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());//格式如:2019-04-11
		LOG.info("==============开始启动定时任务"+current_date+":根据离职人员信息表 更新欢行绑定的联系电话号码(didi_personalc)==============");
		//查询离职表中当天离职人员的工号
		List<String> leaveEmpCodeList = personalCenterService.queryLeaveEmployees(current_date);
		if(leaveEmpCodeList != null){
			personalCenterService.batchInsertPersonalC(leaveEmpCodeList);
		}
		LOG.info("==============结束启动定时任务"+current_date+":根据离职人员信息表 更新欢行绑定的联系电话号码(didi_personalc)==============");
		
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
	
	public IPersonalCenterService getPersonalCenterService() {
		return personalCenterService;
	}

	public void setPersonalCenterService(
			IPersonalCenterService personalCenterService) {
		this.personalCenterService = personalCenterService;
	}
	
}
