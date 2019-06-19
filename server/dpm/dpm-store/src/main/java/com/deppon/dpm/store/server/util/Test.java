package com.deppon.dpm.store.server.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author XiaoTian
 *
 */
public class Test
{	
	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        /**
         * 指定触发的时间      现在指定时间为   2013年10月27号  15点  43 分 1 秒时触发
         */
        calendar.set(Calendar.DAY_OF_MONTH,23);//设置日期为23号
        calendar.set(Calendar.MONTH, 4);//设置日期为5月份   这里4表示5月份    11就表示12月份
        calendar.set(Calendar.HOUR_OF_DAY, 11); //设置15点的时候触发
        calendar.set(Calendar.MINUTE, 35); //设置20分钟的时候触发
        calendar.set(Calendar.SECOND, 20); //设置第一秒的时候触发
        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time); 
        
        Calendar calendar1 = Calendar.getInstance();
        /**
         * 指定触发的时间      现在指定时间为   2013年10月27号  15点  43 分 1 秒时触发
         */
        calendar1.set(Calendar.DAY_OF_MONTH,23);//设置日期为23号
        calendar1.set(Calendar.MONTH, 4);//设置日期为5月份   这里4表示5月份    11就表示12月份
        calendar1.set(Calendar.HOUR_OF_DAY, 11); //设置15点的时候触发
        calendar1.set(Calendar.MINUTE, 35); //设置20分钟的时候触发
        calendar1.set(Calendar.SECOND, 21); //设置第一秒的时候触发
        Date time1 = calendar1.getTime();
        Timer timer1 = new Timer();
        timer.schedule(new RemindTask(), time1); 
    }
}

class RemindTask extends TimerTask {
	//设置多少时间触发方法
    public synchronized void run() {
    }
} 
