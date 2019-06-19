package com.deppon.dpm.sendMsg.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.deppon.dpm.sendMsg.TaskService.SendMsgTaskAction;
import com.deppon.montal.util.redis.util.JedisUtil;

public class SendMsgTaskListener implements ServletContextListener{
	private Timer timer = null;
	private Logger logger = Logger.getLogger(SendMsgTaskListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
//		event.getServletContext().log("定时器销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		/**
		 * 计算整点时间   并延迟至整点执行 定时任务
		 */
		//获取当前时间
		Calendar calendar = Calendar.getInstance();  
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		
		//设置的定时格式
		String timeType = JedisUtil.getValue("sendMsg.Time.type");
		String[] timeTypes = timeType.split(":");
		String type = timeTypes[0];
		int spaceTime = Integer.parseInt(timeTypes[1]);
		//定时：小时
		if("hour".equals(type)){
			calendar.set(Calendar.HOUR_OF_DAY, hour+1);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
		}else if("minute".equals(type)){
		//定时 分钟
			if(minute >= spaceTime){
				//当前分钟 大于 定时分钟数    40 >  30分推送一次  开始时间 60分钟
				int tt = minute/spaceTime;
				int mm = (tt + 1) * spaceTime;
				calendar.set(Calendar.MINUTE, mm);
			}else{
//				calendar.set(Calendar.HOUR_OF_DAY, hour);
				calendar.set(Calendar.MINUTE, spaceTime);
			}
			calendar.set(Calendar.SECOND, 0);
		}
		
		Date date=calendar.getTime();
		logger.info("=======================消息推送定时器注册时间:"+new Date()+"=========首次推送时间:"+date);
        timer.schedule(new SendMsgTaskAction(), date,Long.valueOf(JedisUtil.getValue("sendMsg.Time.space")).longValue());//1小时调用一次
		
	}
}
