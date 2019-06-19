<%@page import="com.deppon.montal.model.OAReturnDomOfOrigin"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.text.Format"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%

	OAReturnDomOfOrigin origin = (OAReturnDomOfOrigin)request.getAttribute("origin");
	String jobLevel = origin.getJoblevel()==null?"":origin.getJoblevel();
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=origin.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>回原籍申请</td>
				</tr>
				<tr>
				   <th>工号:</th>
				   <td><%=origin.getApplypersoncode()%></td>
				</tr>
				<tr>
					<th>申请人:</th>
					<td><%=origin.getApplypersonname()%></td>
				</tr>			    
				
				<tr>
				   <th>职位等级:</th>
				   <td><%=origin.getJoblevel()%></td>
				</tr>
				<tr>
				   <th>异动性质:</th>
				   <td><%=origin.getProperty()%></td>
				</tr>
				<tr>
				   <th>所属人事部:</th>
				   <td><%=origin.getHrdeptname()%></td>
				</tr>
				<tr>
				   <th>籍贯:</th>
				   <td><%=origin.getNativeplace()%></td>
				</tr>
				
				<tr>
				   <th>当前职位:</th>
				   <td><%=origin.getCurrentjob()%></td>
				</tr>
				<tr>
				   <th>当前部门:</th>
				   <td><%=origin.getCurrentdept()%></td>
				</tr>
				<tr>
				   <th>异动目标区域或地区:</th>
				   <td><%=origin.getInaeraname()%></td>
				</tr>
				<tr>
				   <th>异入人事部:</th>
				   <td><%=origin.getIndeptname()%></td>
				</tr>
				<tr>
				   <th>当前岗位工作年限（月）:</th>
				   <td><%=origin.getWorkdata()%></td>
				</tr>
				<tr>
				   <th>是否降级异动:</th>
				   <td><%=origin.getIsrelegation()%></td>
				</tr>
				<%
					if(jobLevel.equals("营运员工级") || jobLevel.equals("职能员工级")
							 || jobLevel.equals("营运直管职能员工级")){
				%>
				<tr>
				   <th>近六个月内绩效考核:</th>
				   <td><%=origin.getPerformance()%></td>
				</tr>
				<%
					}else{
				%>
				<tr>
				   <th>近半年胜任力排名:</th>
				   <td><%=origin.getCompetency()%></td>
				</tr>	
				<%
					}
				%>				
			    <tr>
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=origin.getReason()==null?"":origin.getReason() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>