package com.deppon.dpm.sendMsg.TaskService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.dpm.sendMsg.listener.JpushTaskListenner;
import com.deppon.montal.util.FormatUtil;
import com.deppon.montal.util.redis.util.JedisUtil;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class JpushTaskAction implements Job{
	private Logger logger = Logger.getLogger(JpushTaskAction.class);
	//异常数据最多推送次数 3次
	private static final int SENDMSGCOUNT = 3;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("开始执行调度("+JpushTaskListenner.PUSHJOB_NAME+")");
		try {
			Map valiMap = null;
			try {
				//判断时间节点
				valiMap = SendMsgTaskUtil.validTimeTask();
			} catch (ParseException e) {
				logger.error("定时任务 时间节点判断异常，异常信息：" + e.getMessage());
			}
			/**判断该节点  是否执行此任务*/
			boolean isTime = (Boolean) valiMap.get("isTime");
			boolean isRunning = false;
			String endDate = (String) valiMap.get("endTime");
			Jedis jedis = JedisUtil.createJedis();
			
			String switchOff = jedis.getSet("runngingState", "on&&" + endDate);
			
			logger.info("当前定时任务状态：************" + switchOff);
			if(switchOff == null){
				isRunning = false;
			}else{
				String[] states = switchOff.split("&&");
				if(states.length < 2 ){
					isRunning = true;
					jedis.getSet("runngingState", switchOff);
				}else{
					Date endDt = FormatUtil.formatStrTODate(endDate, "yyyy-MM-dd HH:mm:ss");
					Date statesDate = FormatUtil.formatStrTODate(states[1], "yyyy-MM-dd HH:mm:ss");
					int compare = endDt.compareTo(statesDate);
					if("on".equals(states[0]) && compare <= 0){
						//已经在运行中
						isRunning = true;
//						jedis.getSet("runngingState", "off&&");
					}else if("off".equals(states[0]) && compare <= 0){ //endDt <= statesDate  该endDt 已经推送过
						//未运行 但该时间节点已经运行了
						isRunning = true;
						jedis.getSet("runngingState", switchOff);
					}else{
						isRunning = false;
					}
				}
			}
			
			//定时  计划时间
			if(isTime && !isRunning){
				logger.info("查询工作流新增待办开始时间:【"+valiMap.get("fromDate")+"】  结束时间:【"+valiMap.get("endTime")+"】  【"+valiMap.get("isTime")+"】");
				SendMsgServiceImpl sendMsg = new SendMsgServiceImpl();
				//查询人员名单
				List users = sendMsg.queryAllUserCode();
				String userStr = sendMsg.parseUsers(users);
				
				//查询人员在该时间段内新增代办数量
				List<Map> pendNumList = null;
				try {
					//查询新增待办 时间节点
					String fromDate = (String) valiMap.get("fromDate");
					String endTime = (String) valiMap.get("endTime");
					pendNumList = sendMsg.queryPendNumByuserId(userStr,fromDate,endTime);
				} catch (ParseException e1) {
					logger.error(e1.getMessage());
				} catch (SQLException e2) {
					logger.error(e2.getMessage());
				}
				//消息推送
				sendMsg.sendPendMsg(pendNumList,SENDMSGCOUNT);
				
				jedis.getSet("runngingState", "off&&" + endDate);
			}
			
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
	}
	
}
