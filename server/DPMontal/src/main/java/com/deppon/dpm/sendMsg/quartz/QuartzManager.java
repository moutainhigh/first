package com.deppon.dpm.sendMsg.quartz;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.deppon.dpm.sendMsg.listener.JpushTaskListenner;
public class QuartzManager {
	private static Logger logger = Logger.getLogger(QuartzManager.class);
	private static SchedulerFactory sf = new StdSchedulerFactory();
	private static String JOB_GROUP_NAME = "group1";
	private static String TRIGGER_GROUP_NAME = "trigger1";
	 /** *//** 
	    *  添加一个定时任务，使用默认的任务组名，触发器名，触发器组名 
	 * @param <T>
	    * @param jobName 任务名 
	    * @param job     任务 
	    * @param time    时间设置，参考quartz说明文档 
	    * @throws SchedulerException 
	    * @throws ParseException 
	    */  
	   public static <T> void addJob(String jobName,Class<? extends Job> job,int second)   
	                               throws SchedulerException, ParseException{  
	       JobDetail jobDetail =  JobBuilder.newJob(job)
	    		   .withIdentity(jobName,JOB_GROUP_NAME)
	    		   .build();
	       Trigger trigger= TriggerBuilder
	                .newTrigger()
	                .withIdentity(jobName,TRIGGER_GROUP_NAME)
	                .startNow()
	                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
	                        .withIntervalInSeconds(second) //时间间隔
	                        .repeatForever()
	                        )
	                .build();
	       Scheduler sched = sf.getScheduler();
	        sched.scheduleJob(jobDetail,trigger);
	        sched.start();
	        logger.info("调度("+jobName+")添加成功  ("+JpushTaskListenner.INTERVAL+")分钟执行一次调度");
	   }  
	     
	   /** *//** 
	    * 添加一个定时任务 
	    * @param jobName 任务名 
	    * @param jobGroupName 任务组名 
	    * @param triggerName  触发器名 
	    * @param triggerGroupName 触发器组名 
	    * @param job     任务 
	    * @param time    时间设置，参考quartz说明文档 
	    * @throws SchedulerException 
	    * @throws ParseException 
	    */  
	   public static void addJob(String jobName,String jobGroupName,  
	                             String triggerName,String triggerGroupName,  
	                             Job job,String time)   
	                               throws SchedulerException, ParseException{  
//	       Scheduler sched = sf.getScheduler();  
//	       JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job.getClass());//任务名，任务组，任务执行类  
//	       //触发器  
//	       CronTrigger  trigger =   
//	            new CronTrigger(triggerName, triggerGroupName);//触发器名,触发器组  
//	       trigger.setCronExpression(time);//触发器时间设定  
//	       sched.scheduleJob(jobDetail,trigger);  
//	       if(!sched.isShutdown())  
//	          sched.start();  
	   }  
	     
	   /** *//** 
	    * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名) 
	    * @param jobName 
	    * @param time 
	    * @throws SchedulerException 
	    * @throws ParseException 
	    */  
	   public static void modifyJobTime(String jobName,String time)   
	                                  throws SchedulerException, ParseException{  
//	       Scheduler sched = sf.getScheduler();  
//	       Trigger trigger =  sched.getTrigger(jobName,TRIGGER_GROUP_NAME);  
//	       if(trigger != null){  
//	           CronTrigger  ct = (CronTrigger)trigger;  
//	           ct.setCronExpression(time);  
//	           sched.resumeTrigger(jobName,TRIGGER_GROUP_NAME);  
//	       }  
	   }  
	     
	   /** *//** 
	    * 修改一个任务的触发时间 
	    * @param triggerName 
	    * @param triggerGroupName 
	    * @param time 
	    * @throws SchedulerException 
	    * @throws ParseException 
	    */  
	   public static void modifyJobTime(String triggerName,String triggerGroupName,  
	                                    String time)   
	                                  throws SchedulerException, ParseException{  
//	       Scheduler sched = sf.getScheduler();  
//	       Trigger trigger =  sched.getTrigger(triggerName,triggerGroupName);  
//	       if(trigger != null){  
//	           CronTrigger  ct = (CronTrigger)trigger;  
//	           //修改时间  
//	           ct.setCronExpression(time);  
//	           //重启触发器  
//	           sched.resumeTrigger(triggerName,triggerGroupName);  
//	       }  
	   }  
	     
	   /** *//** 
	    * 移除一个任务(使用默认的任务组名，触发器名，触发器组名) 
	    * @param jobName 
	    * @throws SchedulerException 
	    */  
	   public static void removeJob(String jobName)   
	                               throws SchedulerException{  
//	       Scheduler sched = sf.getScheduler();  
//	       sched.pauseTrigger(jobName,TRIGGER_GROUP_NAME);//停止触发器  
//	       sched.unscheduleJob(jobName,TRIGGER_GROUP_NAME);//移除触发器  
//	       sched.deleteJob(jobName,JOB_GROUP_NAME);//删除任务  
	   }  
	     
	   /** *//** 
	    * 移除一个任务 
	    * @param jobName 
	    * @param jobGroupName 
	    * @param triggerName 
	    * @param triggerGroupName 
	    * @throws SchedulerException 
	    */  
	   public static void removeJob(String jobName,String jobGroupName,  
	                                String triggerName,String triggerGroupName)   
	                               throws SchedulerException{  
//	       Scheduler sched = sf.getScheduler();  
//	       sched.pauseTrigger(triggerName,triggerGroupName);//停止触发器  
//	       sched.unscheduleJob(triggerName,triggerGroupName);//移除触发器  
//	       sched.deleteJob(jobName,jobGroupName);//删除任务  
	   }  
}
