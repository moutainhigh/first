<%@page import="com.deppon.wfs.workflow.domain.DestroyContractBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
DestroyContractBean info = (DestroyContractBean)request.getAttribute("entity");
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<body>
<div id="list">
<%@include file="../wf_head_win8.jsp" %>
   <!--div2 S-->
 <div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
			   <tr><th>工作流号:
			        </th><td><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</td>
			   </tr>
			   <tr><th>工作流:</th><td>
		   		  合同销毁申请
			   </td></tr>
					  <tr><th>申请人:</th><td>
					  <%=info.getApplyPersonName()%></td>
				   </tr>
					 
					  <tr><th>申请人工号：</th><td>
					  <%=info.getApplyPersonId()%></td>
				   </tr>
					 
					  <tr><th>所属事业部：</th><td>
					  <%=info.getAreaub()%></td>
				   </tr>
				   
				   	  <tr><th>合同类型 ：</th><td>
					  <%=info.getContractType()%></td>
				   </tr>
					 
					 <tr><th>销毁合同到期时间段开始：</th><td>
					  <%=FormatUtil.formatDate(info.getStartDate(),"yyyy-MM")%></td>
				   </tr>
				    <tr><th>销毁合同到期时间段结束：</th><td>
					  <%=FormatUtil.formatDate(info.getEndDate(),"yyyy-MM")%></td>
				   </tr>
				   <tr><th>申请事由:</th><td>
					  <%=info.getApplyReasons()%></td>
			<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>