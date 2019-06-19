/**
 * 
 */
package com.deppon.montal.module.addresslist.action;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.module.addresslist.service.AdresslistService;

/**
 * @yin 通讯录详情Action
 *
 */
public class AdresslistDetailAction extends AppDelegateAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger  = Logger.getLogger(AdresslistDetailAction.class);
	
	private AdresslistService adreesService = new AdresslistService();
	
	@Override
	protected void response() {
		//获取详细
		Long empid = Long.parseLong(reqPara.get("empid"));
		OmEmployee emp = adreesService.getEmployeeInfo(empid);
		request.setAttribute("emp", emp);
		try {

			//获取UI标记
			String ui_type = reqPara.get("ui_type");
			
			if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
				forward(F_Constants.IOS_FORWARD_PATH_ADDSDETAIL);
			}else{
				forward(F_Constants.FORWARD_PATH_ADDSDETAIL);
			}
			return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void mapParameters() {
		super.mapParameters();
	}
}
