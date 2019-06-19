package com.deppon.dpm.doc.server.job;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 定时任务修改员工直属上级信息
 * 
 * @author Administrator
 *
 */
public class UpdateLeaderMethord {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateLeaderMethord.class);

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private IOtherOffDutiesService otherOffDutiesService;

	private IDoubtfulExAuditService doubtfulExAuditService;
	//根据工号查询直属上级jiekou
	private IExternalMethodService externalMethodService;
	String ufdate = DATE_FORMAT.format(System.currentTimeMillis());
	String month = ufdate.substring(0,7);
	/**
	 * 定时任务：修改审核数据直属上级
	 */
	public void execute() {
		String runningHostAddress = getHostIp();
		if("10.249.5.99".equals(runningHostAddress)){
			return;
		}
		LOG.info("审核数据修改直属上级开始..." + DATE_FORMAT.format(new Date()));
		try{
			//其他公务
			
			//1.根据如期查询出当月的未审核数据存入map key:工号；value：领导人工号
			List<OtherOffDutiesEntity> oldList = otherOffDutiesService.queryBydate(month);
			Map<String,String> userMap = new HashMap<String,String>();
			//这一步是为了去除重复的工号，减少调用直属上级接口次数
			for(OtherOffDutiesEntity temp : oldList){
				if(temp.getUserId() != null && temp.getLeadernum() != null){
					userMap.put(temp.getUserId(), temp.getLeadernum());
				}
			}
			//2.根据map的key值即工号查询出直属上级工号姓名
			for(String temp : userMap.keySet()){
				EmployeeVO evo = externalMethodService.getLeaderInfo(temp);
				String leadernum = "";//转办直属上级工号
				String leadernumName = "";//转办直属上级姓名
				if(evo != null){
					leadernum = evo.getEmpCode();
					leadernumName = evo.getEmpName();
					LOG.info("其他公务转办直属上级>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",leadernum);
				}
				//3.如果直属上级不同，则更新数据库直属上级信息。
				if(leadernum != null){
					LOG.info("调用转办接口开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					int update = otherOffDutiesService.transferMethod(temp, leadernum ,leadernumName);
					LOG.info("调用转办接口结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",update);
				}
			}
		}catch(Exception e){
			LOG.info("其他公务转办发生异常>>>>>>>>>" + e.getMessage());
		}
		
		try{
			//疑似异常
			//1.根据如期查询出当月的未审核数据存入map key:工号；value：领导人工号
			List<AbnormalOrderEntity> oldList = doubtfulExAuditService.queryBydate(month);
			Map<String,String> userMap = new HashMap<String,String>();
			//这一步是为了去除重复的工号，减少调用直属上级接口次数
			for(AbnormalOrderEntity temp : oldList){
				if(temp.getUserId() != null && temp.getLeadernum() != null){
					userMap.put(temp.getUserId(), temp.getLeadernum());
				}
			}
			//2.根据map的key值即工号查询出直属上级工号姓名
			for(String temp : userMap.keySet()){
				EmployeeVO evo = externalMethodService.getLeaderInfo(temp);
				String leadernum = "";//转办直属上级工号
				String leadernumName = "";//转办直属上级姓名
				if(evo != null){
					leadernum = evo.getEmpCode();
					leadernumName = evo.getEmpName();
					LOG.info("其他公务转办直属上级>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",leadernum);
				}
				//3.如果直属上级不同，则更新数据库直属上级信息。
				if(leadernum != null){
					LOG.info("调用转办接口开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					int update = doubtfulExAuditService.transferMethod(temp, leadernum ,leadernumName);
					LOG.info("调用转办接口结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",update);
				}
			}
		}catch(Exception e){
			LOG.info("其他公务转办发生异常>>>>>>>>>" + e.getMessage());
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
	
	/**
	 * @return the otherOffDutiesService
	 */
	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}
	/**
	 * @return the doubtfulExAuditService
	 */
	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}
	/**
	 * @param otherOffDutiesService the otherOffDutiesService to set
	 */
	public void setOtherOffDutiesService(
			IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}
	/**
	 * @param doubtfulExAuditService the doubtfulExAuditService to set
	 */
	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}
	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}
	/**
	 * @param externalMethodService the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}
	
}
