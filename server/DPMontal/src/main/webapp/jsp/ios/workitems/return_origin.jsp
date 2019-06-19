<%@page import="com.deppon.montal.model.OAReturnDomOfOrigin"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
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
					OAReturnDomOfOrigin origin = (OAReturnDomOfOrigin)request.getAttribute("origin");
					String jobLevel = origin.getJoblevel()==null?"":origin.getJoblevel();
				%>
				
				<li class="first">工作流号：<em><%=origin.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=origin.getProcessinstid()%>">
				</li>
				<li>工作流：<em>回原籍申请</em></li>
				
				<li>工号：<em><%=origin.getApplypersoncode()%></em></li>
				<li>申请人：<em><%=origin.getApplypersonname()%></em></li>
				<li>职位等级：<em><%=origin.getJoblevel()%></em></li>
				<li>异动性质：<em><%=origin.getProperty()%></em></li>
				<li>所属人事部：<em><%=origin.getHrdeptname()%></em></li>
				<li>籍贯：<em><%=origin.getNativeplace()%></em></li>
				<li>当前职位：<em><%=origin.getCurrentjob()%></em></li>
				<li>当前部门：<em><%=origin.getCurrentdept()%></em></li>
				<li>异动目标区域或地区：<em><%=origin.getInaeraname()%></em></li>
				<li>异入人事部：<em><%=origin.getIndeptname()%></em></li>				
				<li>当前岗位工作年限（月）：<em><%=origin.getWorkdata()%></em></li>
				<li>是否降级异动：<em><%=origin.getIsrelegation()%></em></li>
				
				<%
					if(jobLevel.equals("营运员工级") || jobLevel.equals("职能员工级")
							 || jobLevel.equals("营运直管职能员工级")){
				%>
				<li>近六个月内绩效考核：<em><%=origin.getPerformance()%></em></li>
				<%
					}else{
				%>
				<li>近半年胜任力排名：<em><%=origin.getCompetency()%></em></li>				
				<%
					}
				%>				
			    <li class="last">申请事由：<em><%=origin.getReason()==null?"":origin.getReason() %></em></li>
			    </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>