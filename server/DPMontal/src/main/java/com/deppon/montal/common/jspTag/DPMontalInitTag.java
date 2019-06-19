package com.deppon.montal.common.jspTag;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.deppon.montal.util.InitDataServlet;

/**
 * @author 关波
 */
public class DPMontalInitTag  extends BodyTagSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7587997331290462471L;
	
	private static Logger logger = Logger.getLogger(DPMontalInitTag.class);
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		String basePath = getBasePath(this.pageContext);
		try {
			StringBuilder stringBuffer = new StringBuilder();
			//<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
			//<link rel="stylesheet" href="<%=basePath %>/css/ios/select_tdd.css" />
			stringBuffer.append("<script type=\"text/javascript\" src=\"").append(basePath).append("js/tag/selector.js\"></script>")
						.append("<script type=\"text/javascript\" src=\"").append(basePath).append("js/tag/radio.js\"></script>")
						.append("<script type=\"text/javascript\" src=\"").append(basePath).append("js/tag/date.js\"></script>")
						.append("<script type=\"text/javascript\" src=\"").append(basePath).append("js/tag/selectOption.js\"></script>")
			.append("<script type=\"text/javascript\" src=\"").append(basePath).append("js/tag/main.js\"></script>")
			.append("<link rel=\"stylesheet\" href=\"").append(basePath).append("/css/ios/select_tdd.css\" /> ")
			.append("<script type=\"text/javascript\" src=\"").append(basePath).append("js/My97DatePicker/WdatePicker.js\"></script>");
						//.append("<script type=\"text/javascript\">$(function() {initTagDPMontal();});</script>");
			 /*<script>
		   	 $(function(){
		   		 initTagDPMontal();
		   	 });
		   	 </script>*/
			/**
			 * 将stringBuffer输出到页面中
			 * 抛出异常信息
			 * 返回skip_body
			 */
			out.write(stringBuffer.toString());
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
	public static String getBasePath(PageContext pageContext) {
		//获得http请求的路径
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    	String path = request.getContextPath();  
    	String basePath = InitDataServlet.getValue("dpm_domain_url") + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    	return basePath;
	}
}
