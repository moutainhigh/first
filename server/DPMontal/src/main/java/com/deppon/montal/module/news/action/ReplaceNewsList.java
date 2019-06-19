package com.deppon.montal.module.news.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.module.news.service.ImageService;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.JSONUtil;

/**
 * Servlet implementation class CatLikeNewsList
 */
public class ReplaceNewsList extends AppDelegateAction  {
	  private static final long serialVersionUID = 1L;
	  private static IAnnounceMentService announceMentService = new AnnounceMentService();
		/**
		 * 日志
		 */
	  private static Logger logger = Logger.getLogger(ReplaceNewsList.class);
	  protected void response() {
		  logger.info("读取和压缩历史图片");
		  String startDate = reqPara.get("startDate").toString();
		  String endDate = reqPara.get("endDate").toString();	  

		  logger.info("时间段:"+startDate+"至"+endDate);
		  String absolutePath = request.getSession().getServletContext().getRealPath("/");
		  List<OaRollNews> newsList = announceMentService.queryNewsByDate(startDate, endDate);
		  
		  logger.info("获取到"+newsList.size()+"条数据");
		  ImageService imsgeService = new ImageService();
		  for (int i = 0; i < newsList.size(); i++) {
			imsgeService.imageHandler(absolutePath, newsList.get(i).getFilename());
		  }
		 JSONArray jsonArray = new JSONArray();
		  for(OaRollNews rollnew : newsList){
			  rollnew.setContent("");
			  try {
				jsonArray.add(JSONUtil.encapsulateJsonObject(rollnew));
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		JSONObject newsJson = new JSONObject();
		newsJson.accumulate("news", jsonArray);
		  try {			  
			 response.getWriter().write(newsJson.toString());
		  } catch (IOException e) {
			 e.printStackTrace();
		  }
	  }
	 
	
	  
	  @Override
	  protected void mapParameters() {
	      super.mapParameters();
	  }
}
