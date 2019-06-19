package com.deppon.montal.module.notice.action;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.model.BusAssistantMent;
import com.deppon.montal.module.notice.service.BusAssistantMentService;
import com.deppon.montal.module.notice.service.IBusAssistantMentService;
import com.deppon.montal.util.JSONUtil;
/**
 * 
* @ClassName: AnnouncementDetailAction 
* @Description: 出差小助手明细action
* @author dpyuanwwx@deppon.com/092039
* @date 2014年9月2日 上午9:34:08 
*
 */
public class ToBusAssistantDetailAction extends AppDelegateAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8140621618794423725L;

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */

	

	@Override
	protected void response() {
		IBusAssistantMentService announceMentService = new BusAssistantMentService();
		// 取出页面回传参数ggId
		String id = reqPara.get("Id");
		String unread = reqPara.get("unread");

		// 查询公告详细
		if (id != null) {
			BusAssistantMent oaAnn = announceMentService.queryById(id);
			String rtn = "";
			try {
				rtn = JSONUtil.encapsulateJsonObject(oaAnn);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {

				// ajax不缓存
				response.setHeader("Pragma", "no-cache");
				response.addHeader("Cache-Control", "must-revalidate");
				response.addHeader("Cache-Control", "no-cache");
				response.addHeader("Cache-Control", "no-store");
				response.setDateHeader("Expires", 0);
				// String strResp = jsObj.toString();
				response.getWriter().write(rtn);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// request.setAttribute("oaAnn", oaAnn);
		}
		// forward(F_Constants.HTML5_FORWARD_PATH_ANNDETAIL);
		// 获取UI标记
		/*
		 * String ui_type = reqPara.get("ui_type");
		 * 
		 * if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){ //ios风格
		 * forward(F_Constants.IOS_FORWARD_PATH_ANNDETAIL); }else{ //win8风格
		 * forward(F_Constants.FORWARD_PATH_ANNDETAIL); } return;
		 */

	}

	@Override
	protected void mapParameters() {
		super.mapParameters();
	}

}
