package com.deppon.montal.module.notice.action;
import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.MonthPeriodicalEntity;
import com.deppon.montal.module.notice.service.IMonthPeriodicalService;
import com.deppon.montal.module.notice.service.MonthPeriodicalService;

public class MonthPeriodicalAction extends AppDelegateAction{

	   /**
	    * 
	    */
	    private static final long serialVersionUID = -1127239000341002862L;

	    @Override
	    protected void response() {
	    	
	    	int pageNum = Integer.parseInt(reqPara.get("pageNum"));
			int pageSize = Integer.parseInt(reqPara.get("pageSize"));
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
			IMonthPeriodicalService monthPeriodicalService = new MonthPeriodicalService();
			List<MonthPeriodicalEntity> annList = monthPeriodicalService.queryMonthPeriodicalList(pageNum,pageSize);
//            System.out.println(annList.size()+"---qikansize");
	    	JSONArray rspJstr =JSONArray.fromObject(annList.toArray()); 

			JSONObject newsJson = new JSONObject();
			newsJson.accumulate("qikan", rspJstr);
//			if(annList.size()<pageSize){
//            	newsJson.accumulate("noMoreData", "no");
//            }
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
