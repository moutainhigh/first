/**
 * 
 */
package com.deppon.montal.module.addresslist.action;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.module.addresslist.service.AdresslistService;
import com.deppon.montal.util.InitDataServlet;

/**
 * @yin 通讯录查询Action
 *
 */
public class AdresslistQueryAction extends AppDelegateAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger  = Logger.getLogger(AdresslistQueryAction.class);
	
	private AdresslistService adreesService = new AdresslistService();

	@Override
	protected void response() {
		String key = reqPara.get("key");
		int pageNum = Integer.parseInt(reqPara.get("pageNum"));
		List<OmEmployee> list = adreesService.queryAddresslist(key, pageNum);
		//request.setAttribute("addressList", list);
		StringBuffer empHtml = new StringBuffer();
		//拼接
		
		String path = request.getContextPath();   
	    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
	            + request.getServerName() + ":" + request.getServerPort()   
	            + path;
	    

		//获取UI标记
		String ui_type = reqPara.get("ui_type");
	    
	    if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
		int index = 0 ;
	    	//ios风格
	    	for(OmEmployee emp:list){
	    	     String listr = "";
	    	     if(index == 0 && pageNum ==1){
	    		listr = "<li class=\"first\" onclick=\"adressDetaul("+emp.getEmpId()+")\" >";
	    		index++;
	    	     }else {
		    	listr = "<li onclick=\"adressDetaul("+emp.getEmpId()+")\" >";
	    	     }
				empHtml.append(listr);
				empHtml.append("<p><em class=\"fyy-fl\">").append(emp.getEmpName()).append("</em>");
				empHtml.append("<em class=\"fyy-fr\">").append(emp.getJobName()).append("</em></p>");
				empHtml.append("<p>").append(emp.getOrgName()).append("</p>");
				empHtml.append("</li>");
		}
	    }else{
	    	//win8风格
	    	for(OmEmployee emp:list){
				empHtml.append("<tr id=\""+emp.getEmpId() + "\" style=\"height: 50px;\">");
				empHtml.append("<th style=\"width:70%\">"+emp.getEmpName()+"<br/>");
				empHtml.append("<em >"+emp.getOrgName()+"</em></th>");
				empHtml.append("<td class=\"fyy-textRt\">"+emp.getJobName()+"<br/></td>");
				empHtml.append("</tr>");
			}
	    }
		try {
			
			//ajax不缓存
    		    	response.setHeader( "Pragma", "no-cache" );
    		    	response.addHeader( "Cache-Control", "must-revalidate" );
    		    	response.addHeader( "Cache-Control", "no-cache" );
    		    	response.addHeader( "Cache-Control", "no-store" );
    		    	response.setDateHeader("Expires", 0); 
			
			response.getWriter().write(empHtml.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void mapParameters() {
		super.mapParameters();
	}

}
