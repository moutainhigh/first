package com.deppon.montal.module.news.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.module.news.action.NewsListHtml5Action;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.redis.util.JedisUtil;

/**
 * 
 * 负责不间断的请求图片并进行压缩
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:219390,date:2015-1-8 上午9:25:19,content:TODO </p>
 * @author 219390
 * @date 2015-1-8 上午9:25:19
 * @since
 * @version
 */
public class ImageCompressJob{
	  Jedis jedis = JedisUtil.createJedis();
	  private static final long serialVersionUID = 1L;
	  private static IAnnounceMentService announceMentService = new AnnounceMentService();
		/**
		 * 日志
		 */
	  private ImageCompressJob(){}
	  public static ImageCompressJob getInstance(){
		  return new ImageCompressJob();
	  }
	  private static int count =0;
	  private static Logger logger = Logger.getLogger(NewsListHtml5Action.class);
	  public  void compressJob(){
		  String startDate=null;
		  String endDate =null;
		  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  if(count==0){
		     Calendar calendar = Calendar.getInstance();
		     Date oldDate = new Date();
		     calendar.setTime(oldDate);
	         calendar.add(Calendar.MONTH, -1);
	         Date newDate = new Date(calendar.getTimeInMillis());
	         startDate= sim.format(newDate);
	         endDate =sim.format(oldDate);
	         logger.info("开始查询："+startDate+"至"+endDate);
		  }else{
			  if(jedis.get("publishDate")==null){
				  logger.info("第一次查询无结果！使用预设时间2015-01-01");
				  jedis.getSet("publishDate", "2015-01-01 00:00:00.0");
			    }
				  startDate = jedis.get("publishDate");
				  logger.info("获取上一次新闻发布时间："+startDate);
				  if(startDate.lastIndexOf(".")>-1){
					  startDate = startDate.substring(0,startDate.lastIndexOf("."));
				  }
				  
			      endDate = sim.format(new Date());
		  }
		  List<OaRollNews> newsList = announceMentService.queryNewsByDate(startDate, endDate);
		  if(newsList!=null&&newsList.size()!=0){
			  jedis.getSet("publishDate", newsList.get(0).getFbdate().toString());
			  logger.info("将上一次新闻发布时间："+startDate+" 放入redis缓存");
		  }
		  ImageService imsgeService = new ImageService();
//		  String absolutePath =Thread.currentThread().getContextClassLoader().getResource("/").getPath();
		  String absolutePath = ImageCompressJob.class.getResource("").getPath();
		  if(StringUtils.isNotEmpty(absolutePath)){
			  absolutePath = absolutePath.substring(0, absolutePath.indexOf("/WEB-INF/"));
			  logger.info("获取war包的绝对路径："+absolutePath);
		  }
		  for (int i = 0; i < newsList.size(); i++) {
			imsgeService.imageHandler(absolutePath+"/", newsList.get(i).getFilename());
		  }
			count=1;
	  }
}
