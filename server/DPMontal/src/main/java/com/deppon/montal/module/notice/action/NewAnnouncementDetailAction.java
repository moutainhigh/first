package com.deppon.montal.module.notice.action;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaAnnounceMent;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.ImgUtil;
import com.deppon.montal.util.JSONUtil;

/**
 * Servlet implementation class NewAnnouncementDetailAction
 */
public class NewAnnouncementDetailAction extends AppDelegateAction {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -1127239000241002862L;

	@Override
	protected void response() {
		IAnnounceMentService announceMentService = new AnnounceMentService();
		// 取出页面回传参数ggId
		String ggId = reqPara.get("ggId");
		String unread = reqPara.get("unread");
		if (unread != null) {
			// 未读
			if (unread.equals("0")) {
				// LoginUser login =
				// (LoginUser)request.getSession().getAttribute("loginUser");
				LoginUser login = (LoginUser) getUserRedisService()
						.getFromRedisBySession(getSessionId());
				announceMentService.insertBulletinClick(ggId, login.getEmpId(),
						login.getEmpName());
			}
		}

		// 查询公告详细
		if (ggId != null) {
			OaAnnounceMent oaAnn = announceMentService.queryById(ggId);
			String content = ImgUtil.filterHtmlImg(oaAnn.getContent());
			oaAnn.setContent(content);
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

				response.getWriter().write(rtn);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void mapParameters() {
		super.mapParameters();
	}
}
