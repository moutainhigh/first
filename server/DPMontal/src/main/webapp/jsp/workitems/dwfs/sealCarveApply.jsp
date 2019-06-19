<%@page import="com.deppon.wfs.workflow.domain.SealCarveApplyBean"%>
<%@page import="com.deppon.wfs.workflow.domain.SealCarveApplyDetailBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
SealCarveApplyBean info = (SealCarveApplyBean)request.getAttribute("entity");
List<SealCarveApplyDetailBean> line = info.getSealCarveDetail();
%>
<body>
<div id="list">
<%@include file="../wf_head_win8.jsp" %>
   <!--div2 S-->
 <input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th>
			        <td><%=request.getAttribute("processinstid") %>
			   		</td>
			   </tr>
			   <tr><th>工作流:</th><td>
		   		  刻章申请
			   </td></tr>
					  <tr><th>申请人:</th><td>
					  <%=info.getApplyPersonName()%></td>
				   </tr>
					 
					  <tr><th>申请人工号：</th><td>
					  <%=info.getApplyPersonId()%></td>
				   </tr>
					 
					  <tr><th>部门：</th><td>
					  <%=info.getDeptName()%></td>
				   </tr>
				   
				   	  <tr><th>所属事业部 ：</th><td>
					  <%=info.getDivision()%></td>
				   </tr>
				     <tr><th>所属财务部:</th><td>
					  <%=info.getFinanceDept()%></td>
				   </tr>
				    <tr><th>所属公共事务组:</th><td>
					  <%=info.getAffairsSection()%></td>
				   </tr>
					 <%if("".equals(info.getSubcom()) || info.getSubcom() == null) {%>
					  <tr><th>印章类型：</th><td>
					  <%=info.getSealType()%></td>
				   </tr>
					 <%} else {%>
					  <tr><th>所属子公司：</th><td>
					  <%=info.getSubcom()%></td>
				   </tr>
				   
				   	  <tr><th>印章类型 ：</th><td>
					  <%=info.getSealType()%></td>
				   </tr>
				   <%}%>
				  <tr><th class="yellow">刻章申请明细</th></tr>
				    <%for (int i = 0 ;i < line.size() ; i ++ ) {%>
					   <tr <%= i == 0 ? "" :  "class='topLine'"%> ><th>印章名称:</th><td><%=line.get(i).getSealName()%></td></tr>	
					   
					   <tr><th>是否首次刻制:</th><td><%=line.get(i).getFirstCarve()%></td></tr>	
					   <tr><th>发证日期(营业执照):</th><td><%=FormatUtil.formatDate(line.get(i).getProvideTime())%></td></tr>	
			    <%} %>
				   	
				     <tr><th>申请事由:</th><td>
					  <%=info.getApplyReason()%></td>
					  </tr>
			<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>