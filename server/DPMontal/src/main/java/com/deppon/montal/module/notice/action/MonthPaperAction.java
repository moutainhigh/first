package com.deppon.montal.module.notice.action;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.MonthPaperEntity;
import com.deppon.montal.module.notice.service.IMonthPaperService;
import com.deppon.montal.module.notice.service.MonthPaperService;
import com.deppon.montal.util.JSONUtil;

public class MonthPaperAction extends AppDelegateAction{

    
	   /**
	    * 
	    */
	    private static final long serialVersionUID = -1127239000341002862L;

	    @Override
	    protected void response() {
	    	
	    	int pageNum = Integer.parseInt(reqPara.get("pageNum"));
			int pageSize = Integer.parseInt(reqPara.get("pageSize"));
			int pid = Integer.parseInt(reqPara.get("pid"));
			String sessionId = getSessionId();
			LoginUser user = (LoginUser)getUserRedisService().getFromRedisBySession(sessionId);
//			  System.out.println(user+"============");
			  if(user==null){
				  try {
		    			response.getWriter().write("userisnull");
		    			return;
		    		} catch (IOException e) {
						e.printStackTrace();
					}
			  }
			JSONObject newsJson = new JSONObject();
			IMonthPaperService monthPaperService = new MonthPaperService();
			/*if(pageNum==1){
				List<MonthPaperEntity> pentity = monthPaperService.queryMonthPaperPicList(pid);
				newsJson.accumulate("picwenzhang", pentity);
			}*/
			List<MonthPaperEntity> annList = monthPaperService.queryMonthPaperList(pid,pageNum,pageSize);

	    	JSONArray jsonArray = new JSONArray();
	    	for(MonthPaperEntity entity : annList){
				  // 不返回内容, 量太大
	    		entity.setContent("");
				try {
					jsonArray.add(JSONUtil.encapsulateJsonObject(entity));
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			  }
//	    	System.out.println(annList.size()+"===sssssss======");
            if(annList.size()<pageSize){
            	newsJson.accumulate("noMoreData", "no");
            }
			newsJson.accumulate("wenzhang", jsonArray);
			
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
