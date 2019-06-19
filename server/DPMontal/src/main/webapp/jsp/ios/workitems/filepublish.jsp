<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaFilePublish"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
				<ul>
				 <%
					OaFilePublish publish = (OaFilePublish)request.getAttribute("filepublish");
					String state = "";
					if(publish.getEffectstate().equals("1")){
						state = "有效";
					}else if(publish.getEffectstate().equals("2")){
						state = "部门有效";
					}else{
						state = "废止";
					} 
	
				 %>
					   <li class="first">工作流号：<em><%=publish.getProcessinstid() %></em>
					  	 <input type="hidden" id="workid" value="<%=publish.getProcessinstid()%>">
					  	 <input type="hidden" id="type_id" value="filepublish">
					   </li>
					   <li>工作流：<em>文件发布申请</em></li>
					   <li>申请人：<em><%=publish.getName() %></em></li>
					   <li>申请类别：<em><%=publish.getApplytype().equals("1")?"人事任免类":"其他类" %></em></li>
					   <li>文件类别：<em><%=publish.getFiletype() %></em></li>
				<%
					if(publish.getApplytype().equals("1")){
						String type = "";
						if(publish.getAppointedtype().equals("1")){
							type = "总监级及以上";
						}else if(publish.getAppointedtype().equals("2")){
							type = "职能高级经理/经理级任免";
						}else if(publish.getAppointedtype().equals("3")){
							type = "营运区域经理级任免";
						}else if(publish.getAppointedtype().equals("4")){
							type = "营运经理/副经理级任免";	
						}
				%>					   
					   <li>任免类型：<em><%=type %></em></li>					
					   <li>被任免人所在事业部：<em><%=publish.getDivision()%></em></li>
		        <%
					}
		        %>						
					   <li>责任部门：<em><%=publish.getRespondepart()%></em></li>
					   <li>责任者：<em><%=publish.getResponpeople() %></em></li>
					   <li>页数：<em><%=publish.getCountpage() %></</em></li>
				       <li>效力状态：<em><%=state %></em></li>
					   <li>适用范围：<em><%=publish.getScope()%></em></li>
			    	   <li>文件编号：<em><%=publish.getFilecode()%></em></li>
			    	   <li>文件标题：<em><%=publish.getFiletittle()%></em></li>
			    	   <li>文件摘要：<em><%=publish.getFileabstract()%></em></li>
			    	   <li>文件生效日期：<em><%=FormatUtil.formatDate(publish.getEffectdate())%></em></li>
			    	   <li>文件过期日期：<em><%=FormatUtil.formatDate(publish.getExpireddate())%></em></li>
					   <li>备注：<em><%=publish.getWhyapply()==null?"":publish.getWhyapply()%></em></li>
					</ul>
					</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>