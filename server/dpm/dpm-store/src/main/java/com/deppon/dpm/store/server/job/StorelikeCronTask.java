package com.deppon.dpm.store.server.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author XiaoTian
 *
 */
@Component
public class StorelikeCronTask {
	
	//定时器
	private static final Logger logger = LoggerFactory.getLogger(StorelikeCronTask.class);  
    
//    @Scheduled(cron="0/5 * * * * ?")  
//    public void staticCronTask() {  
//        logger.debug("staticCronTask is running..."); 
//        System.out.println("开始");
//    }  
  
}
