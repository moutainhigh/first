<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaFilePublish"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
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
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
					<th>工作流号：</th>
					<td id="workid"><%=publish.getProcessinstid() %></td>
				</tr>
				<tr>
					<th>工作流：</th>
					<td>
						文件发布申请
						<input type="hidden" id ="type_id" value="filepublish">
					</td>
				</tr>
				<tr>
				<th>申请人：</th>  
				<td><%=publish.getName() %></td>       
				</tr> 

	        	<tr>
					<th>申请类别：</th>  
	            	<td><%=publish.getApplytype().equals("1")?"人事任免类":"其他类" %></td>
				</tr> 
	        	<tr>
		            <th>文件类别：</th>  
		            <td><%=publish.getFiletype() %></td>  
				</tr> 
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
				<tr>
		          <th>任免类型：</th>  
		          <td><%=type %></td> 
		        </tr> 
		        <tr> 
		          <th>被任免人所在事业部：</th>  
		          <td><%=publish.getDivision() %></td>        
		        </tr> 
		        <%
					}
		        %>
		        <tr>
		          <th>责任部门：</th>  
		          <td><%=publish.getRespondepart() %></td> 
		        </tr> 
		        <tr> 
		          <th>责任者：</th>  
		          <td><%=publish.getResponpeople() %></td>        
		        </tr> 
		        
		        <tr>
		          <th>页数：</th>  
		          <td><%=publish.getCountpage() %></td> 
		        </tr> 
		        <tr>
		          <th>效力状态：</th>  
		          <td><%=state %></td>       
		        </tr> 
		
		        <tr>
		          <th>适用范围：</th>  
		          <td><%=publish.getScope() %></td>       
		        </tr> 
		        
		        <tr>
		          <th>文件编号：</th>  
		          <td><%=publish.getFilecode() %></td>      
		        </tr> 
		        
		        <tr>
		          <th>文件标题：</th>  
		          <td><%=publish.getFiletittle() %></td>     
		        </tr> 
		        
		        <tr>
		          <th>文件摘要：</th>  
		          <td><%=publish.getFileabstract() %></td>     
		        </tr>  
		        <tr>
		          <th>文件生效日期：</th>  
		          <td><%=FormatUtil.formatDate(publish.getEffectdate())%></td> 
		        </tr> 
		        <tr>
		          <th>文件过期日期：</th>  
		          <td><%=FormatUtil.formatDate(publish.getExpireddate()) %></td>        
		        </tr> 
		        <tr>
		          <th>备注：</th>
		          <td><%=publish.getWhyapply()==null?"":publish.getWhyapply() %></td>
		        </tr>
		        <%@include file="approve_process.jsp" %>
				</table>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>