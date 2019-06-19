package com.deppon.dpm.doc.server.job;

import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.module.anps.server.service.INoticeGroupService;
import com.deppon.dpm.module.anps.server.service.INoticeMessageService;
import com.deppon.dpm.module.anps.server.service.INoticeSearchService;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.domain.NoticeMessageDetail;
import com.deppon.dpm.module.anps.shared.domain.ReadPeopleDetail;
import com.deppon.dpm.module.management.server.service.IEmailService;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

@SuppressWarnings("all")
public class UpdateRecordStateJob {

	private static final Logger LOG = LoggerFactory
			.getLogger(UpdateRecordStateJob.class);

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private IOtherOffDutiesService otherOffDutiesService;

	private IDoubtfulExAuditService doubtfulExAuditService;

	/**
	 * 跟新异常数据
	 */
	public void execute() {
		
		String runningHostAddress = getHostIp();
		if("10.249.5.99".equals(runningHostAddress)){
			return;
		}
		
		LOG.info("开始任务..." + DATE_FORMAT.format(new Date()));
		try {
			otherOffDutiesService.updateRecordErrorStatus();
		} catch (Exception e) {
			LOG.error("{跟新表失败}",e);
			e.printStackTrace();
		}
		try {
		    doubtfulExAuditService.updateRecordErrorStatus();
		} catch (Exception e) {
			LOG.error("{跟新表失败}",e);
			e.printStackTrace();
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

	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}

	public void setOtherOffDutiesService(
			IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}

	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}

	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}

}