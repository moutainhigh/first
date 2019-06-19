package com.deppon.montal.module.notice.action;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;


import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.model.MonthPaperEntity;
import com.deppon.montal.module.notice.service.IMonthPaperService;
import com.deppon.montal.module.notice.service.MonthPaperService;
import com.deppon.montal.util.JSONUtil;

public class MonthPaperDetailAction extends AppDelegateAction{

    
	   /**
	    * 
	    */
	    private static final long serialVersionUID = -1127239000341002862L;

	    @Override
	    protected void response() {
			int id = Integer.parseInt(reqPara.get("id"));
			IMonthPaperService monthPaperService = new MonthPaperService();
			MonthPaperEntity entity = monthPaperService.queryMonthPaperInformation(id);
//			String content = ImgUtil.filterHtmlImg(entity.getContent());
//			entity.setContent(content);
			String rtn = "";
			try {
				rtn = JSONUtil.encapsulateJsonObject(entity);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {

				response.getWriter().write(rtn);
			} catch (IOException e) {
				e.printStackTrace();
			}

	    }
	    
	    
	    @Override
	    protected void mapParameters() {
	        super.mapParameters();
	    }
}
