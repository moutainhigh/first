package com.deppon.montal.module.notice.action;

import java.io.IOException;
import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.model.MonthLayoutEntity;
import com.deppon.montal.model.MonthPaperEntity;
import com.deppon.montal.module.notice.service.IMonthPlayoutService;
import com.deppon.montal.module.notice.service.MonthPlayoutService;

public class MonthPlayoutAction extends AppDelegateAction{

    
	   /**
	    * 
	    */
	    private static final long serialVersionUID = -1127239000341002862L;

	    @Override
	    protected void response() {
	    	
			int pid = Integer.parseInt(reqPara.get("pid"));
			int pageNum = Integer.parseInt(reqPara.get("pageNum"));
			int pageSize = Integer.parseInt(reqPara.get("pageSize"));
			IMonthPlayoutService monthPlayoutService = new MonthPlayoutService();
			
			List<MonthLayoutEntity> annList = monthPlayoutService.queryMonthPlayoutList(pid);

			JSONArray rspJstr =JSONArray.fromObject(annList.toArray()); 

			JSONObject newsJson = new JSONObject();
			newsJson.accumulate("layout", rspJstr);
			if(annList!=null&&annList.size()>0){
				List<MonthPaperEntity> newsList = monthPlayoutService.queryMonthPaperList(annList.get(0).getLayoutId(),pageNum,pageSize);
				rspJstr =JSONArray.fromObject(newsList.toArray()); 
				newsJson.accumulate("news", rspJstr);
				newsJson.accumulate("layoutId", annList.get(0).getLayoutId());
				if(newsList.size()<pageSize){
	            	newsJson.accumulate("noMoreData", "no");
	            }
			}
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
