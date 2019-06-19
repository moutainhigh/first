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
	<%@include file="/common_ios.jsp" %>
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
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li>工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		  合同销毁申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号：<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
					 
					  <li>所属事业部：<em>
					  <%=info.getAreaub()%></em>
				   </li>
				   
				   	  <li>合同类型 ：<em>
					  <%=info.getContractType()%></em>
				   </li>
					 
					 <li>销毁合同到期时间段开始：<em>
					  <%=FormatUtil.formatDate(info.getStartDate(),"yyyy-MM")%></em>
				   </li>
				    <li>销毁合同到期时间段结束：<em>
					  <%=FormatUtil.formatDate(info.getEndDate(),"yyyy-MM")%></em>
				   </li>
				   <li>申请事由:<em>
					  <%=info.getApplyReasons()%></em>
				   </li>
			 </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>