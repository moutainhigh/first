
    package com.deppon.montal.module.workitems.action; 

import java.io.IOException;
import java.util.List;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.model.PorentCarOutsideEntry;
import com.deppon.montal.module.workitems.service.IPorentCarOutsideService;
import com.deppon.montal.module.workitems.service.PorentCarOutsideService;
   /** 
 * @Title: GetOutSideCarEntryAction.java
 * @Package com.deppon.montal.module.workitems.action 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-15 下午3:48:12 
 * @version V1.0 
 */
public class GetOutsideCarEntryAction extends AppDelegateAction {

    
       /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
       */
    
    private static final long serialVersionUID = -4046350386243380285L;
    
    @Override
    protected void response() {
	IPorentCarOutsideService service = new PorentCarOutsideService();
	String workId = reqPara.get("workId");
	List<PorentCarOutsideEntry> carOutsideEntries = service.getCarOutsideEntry(workId);
	StringBuffer empHtml = new StringBuffer();
	//获取UI标记
	String ui_type = reqPara.get("ui_type");
	        
	if(null != ui_type && ui_type.equals(F_Constants.UI_IOS)){
	    int index = 0;
	    for (PorentCarOutsideEntry entry : carOutsideEntries) {
		if(index == 0){
        	    empHtml.append(" <li>费用类型:</th><td>").append(entry.getExpensetype()).append("</em></li>");
		}else{
        	    empHtml.append(" <li class=\"line\">费用类型:<em>").append(entry.getExpensetype()).append("</em></li>");
		}
        	    empHtml.append(" <li>费用说明:<em>").append(entry.getDiscription()).append("</em></li>");
        	    empHtml.append(" <li>发生日期:<em>").append(entry.getBizdate()).append("</em></li>");
        	    empHtml.append(" <li>付款金额:<em>").append(entry.getAmount()).append("</em></li>");
        	    empHtml.append(" <li>核定金额:<em>").append(entry.getAmountapproved()).append("</em></li>");
        	    empHtml.append(" <li>费用承担部门:<em>").append(entry.getCostdept()).append("</em></li>");
        	    empHtml.append(" <li>备注:<em>").append(entry.getRemark()).append("</em></li>");
        	    index++;
	    }
			    
	} else {
	    int index = 0;
	    for (PorentCarOutsideEntry entry : carOutsideEntries) {
		if(index == 0){
        	    empHtml.append(" <tr><th>费用类型:</th><td>").append(entry.getExpensetype()).append("</td></tr>");
		}else{
        	    empHtml.append(" <tr class=\"topLine\"><th>费用类型:</th><td>").append(entry.getExpensetype()).append("</td></tr>");
		}
		    empHtml.append(" <tr><th>费用说明:</th><td>").append(entry.getDiscription()).append("</td></tr>");
        	    empHtml.append(" <tr><th>发生日期:</th><td>").append(entry.getBizdate()).append("</td></tr>");
        	    empHtml.append(" <tr><th>付款金额:</th><td>").append(entry.getAmount()).append("</td></tr>");
        	    empHtml.append(" <tr><th>核定金额:</th><td>").append(entry.getAmountapproved()).append("</td></tr>");
        	    empHtml.append(" <tr><th>费用承担部门:</th><td>").append(entry.getCostdept()).append("</td></tr>");
        	    empHtml.append(" <tr><th>备注:</th><td>").append(entry.getRemark()).append("</td></tr>");
        	    index++;
	    }
	}
        	
	try {
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

