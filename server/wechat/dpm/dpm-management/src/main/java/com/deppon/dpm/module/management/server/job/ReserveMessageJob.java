package com.deppon.dpm.module.management.server.job;


import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.deppon.ar.bamp.common.util.DateUtil;
import com.deppon.dpm.module.management.server.service.IReserveSubmitSerivce;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;

/**
 * 预定场地 提前10-15分钟消息通知
 * @author 王亚男
 *
 */
@Component
public class ReserveMessageJob {
	
	/**
	 * 按顺序 <value> 秒 分   小时   日期 月份 星期 年 </value>
	 */
	
	Logger logger = LoggerFactory.getLogger(ReserveMessageJob.class);
	
	/**
	 * 设置时间段
	 */
	public static final String TIME_START = "17:30:00";
	
	/**
	 * 设置时间段
	 */
	public static final String TIME_END = "21:30:00";
	
	/**
	 * 推送消息方法
	 */
	private TpushNewsService tpushNewsService;
	
	
	/**
	 * reserveSubmitSerivce service接口
	 */
	private IReserveSubmitSerivce reserveSubmitSerivce;
	
	/**
	 * 19
	 */
	private final static int PUSH_MASSAGE_APLICATION_MARK = 19;
	
	@Scheduled(cron="0 15/30 17-21 * * ?")
	public void messageJob(){
		//@Scheduled   每天17点到21点  从 17:15 开始每隔30分钟跑一次
		//(cron="0 15/30 9-21 * * ?")
		//(cron="0/10 * * * * ?")
		//--查询
		//--定义时间段   15 - 45  or 45 - 15
		NewsCenterEntity nce = null;
		//得到系统时间
		long fromLong = System.currentTimeMillis();
		//得到系统时间
		Long toLong =  System.currentTimeMillis() + Constants.CONSTANT_HALF_HOUR;
		//格式化时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//转换时间
		String from = df.format(fromLong);
		//转换时间
		String to = df.format(toLong);
		logger.info("from:" + from+";toTime:" + to);
		//获取指定时间段内 记录信息
		List<ReserveRecordEntity> list = this.reserveSubmitSerivce.getReserveRecordList(from, to);
		//new 对象
		nce = new NewsCenterEntity("32", PUSH_MASSAGE_APLICATION_MARK, 0, 1, "场地预定");
	    //对list 判断
		if(list.size()>0){
			logger.info("发送消息通知总共"+list.size()+"条！");
			int i = 0 ;
			//循环赋值判断
			for( i = 0 ; i < list.size() ; i++){
				logger.info("发送索引为"+i+"的数据消息!");
				ReserveRecordEntity recordEntity = list.get(i);
				String message = getMessage(recordEntity);
				logger.info("对用户"+recordEntity.getUserNo()+recordEntity.getUserName()+"发送场地预定消息通知");
				try{
					String resutltMessage = tpushNewsService.pushUserNews(recordEntity.getUserNo(),
							"场地预定通知", message, nce);
					logger.info("消息通知返回信息:"+resutltMessage);
					logger.info("对用户"+recordEntity.getUserNo()+"推送成功！");
				}catch (Exception e) {
					logger.info("tpushNewsService.pushUserNews() has ERROR");
					logger.info("向"+recordEntity.getUserNo()+";"+recordEntity.getUserName()+"推送消息通知出现异常");
					logger.info("继续下一条推送");
					e.printStackTrace();
				}
				
			}
		}
		
	}

	
	/**
	 * @param entity 得到消息
	 * @return message
	 */
	public String getMessage(ReserveRecordEntity entity){
		//拼接消息体
		StringBuffer sb = new StringBuffer();
		sb.append("亲爱滴小主~运动时间到咯!我是您预定的");
		sb.append(entity.getAreaName());
		sb.append(entity.getRoomName());
		sb.append(entity.getSiteName());
		sb.append(",");
		sb.append(DateUtil.getFormatDateTime(entity.getStartTime(), "HH:mm"));
		sb.append("-");
		sb.append(DateUtil.getFormatDateTime(entity.getEndTime(), "HH:mm"));
		sb.append("是您的专属时段。");
		//判断是否符合
		if(entity.getSiteMark()==0){
			sb.append("为了小主能更好的享受羽毛球的乐趣,记得穿上帅气的运动服、舒适的运动鞋来羽动青春吧,");
		}
		sb.append("请准时到来、不见不散哦!欢迎来电详询:18721490859");
		//返回消息体
		return sb.toString();
	}

	/**
	 * @return reserveSubmitSerivce
	 */
	public IReserveSubmitSerivce getReserveSubmitSerivce() {
		return reserveSubmitSerivce;
	}

	/**
	 * @param reserveSubmitSerivce reserveSubmitSerivce
	 */
	public void setReserveSubmitSerivce(IReserveSubmitSerivce reserveSubmitSerivce) {
		this.reserveSubmitSerivce = reserveSubmitSerivce;
	}


	/**
	 * @return tpushNewsService
	 */
	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}
	/**
	 * @param tpushNewsService tpushNewsService
	 */
	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}
	
	
	
	
}
