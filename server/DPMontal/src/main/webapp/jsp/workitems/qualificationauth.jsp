<%@page import="com.deppon.montal.model.OAQualificationAuth"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
	OAQualificationAuth apply = (OAQualificationAuth)request.getAttribute("authApply");
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
				   <td id="workid"><%=apply.getProcessinstid() %></td>
				</tr>
				<tr>
				   <th >申请类型:</th>
				   <td>
						<%=apply.getApptype().equals("1")?"任职资格报名":"任职资格复审"%>
				   </td>
				</tr>
				<tr>
				   <th >申请人:</th>
				   <td><%=apply.getName() %></td>
				</tr>
				
			    <tr>
				  <th >申请人所在部门:</th>
				  <td><%=apply.getDepartment() %></td>
			   </tr>
				 <tr>
				  <th >申请人职位:</th>
				  <td><%=apply.getPosition() %></td>
			   </tr>
			   <tr>
				  <th >申请人工号:</th>
				  <td><%=apply.getUserid()%></td>
			   </tr>
				 <tr>
				  <th >申请人性别:</th>
				  <td><%=apply.getSex() %></td>
			   </tr>
				 <tr>
				  <th>申请人身份证号:</th>
				  <td><%=apply.getPincodes()%></td>
			   </tr>	
				<tr>
					<th>入职时间:</th>
					<td><%=apply.getIncompanytime() %></td>
				</tr>		
				<tr>
					<th>入申报岗位时间:</th>
					<td><%=apply.getInapplytime()%></td>
				</tr>
				<%
					if(apply.getApptype().equals("1")){
				%>
				<tr>
					<th>目前公司薪资标准:</th>
					<td><%=apply.getSalaryNow()==null?"":apply.getSalaryNow() %></td>
				</tr>
				<tr>
					<th>申请公司薪资标准:</th>
					<td><%=apply.getSalaryNew()==null?"":apply.getSalaryNew() %></td>
				</tr>
				<tr>
					<th>当前绩效考核:</th>
					<td><%=apply.getPerformanceNow()==null?"":apply.getPerformanceNow() %></td>
				</tr>
				<tr>
					<th>申请绩效考核:</th>
					<td><%=apply.getPerformanceNew()==null?"":apply.getPerformanceNew() %></td>
				</tr>
				<%		
					}
				%>
				<tr>
					<th>学历:</th>
					<td><%=apply.getDegree() %></td>
				</tr>
				<tr>
					<th>近12/6个月绩效:</th>
					<td><%=apply.getPerformance()==null?"":apply.getPerformance() %></td>
				</tr>
				<%
					if(apply.getApptype().equals("1")){
				%>
				<tr>
					<th>是否总监推荐:</th>
					<td><%=apply.getIsrecommend()%></td>
				</tr>
				<tr>
					<th>是否有专业外部经验:</th>
					<td><%=apply.getIsoutexperience()==null?"":apply.getIsoutexperience() %></td>
				</tr>
				<% 
					if(null != apply.getIsoutexperience() && apply.getIsoutexperience().equals("是")){
				%>
				<tr>
					<th>专业外部经验月数:</th>
					<td><%=apply.getOutexperience()==null?"":apply.getOutexperience() %></td>
				</tr>
				<% 
					}
				%>
				<%		
					}
				%>
				<tr>
					<th>现属等级:</th>
					<td><%=apply.getAppchannellevel() %></td>
				</tr>
				<tr>
					<th>管理级别:</th>
					<td><%=apply.getManagementlevel()%></td>
				</tr>
				
				<%
					if(apply.getApptype().equals("1")){
				%>
				<tr>
					<th>申请通道工作时间:</th>
					<td><%=apply.getAppchannelworktime() %>（个月）</td>
				</tr>
				<tr>
					<th>申请专业岗位:</th>
					<td><%=apply.getAppprofessionalpost() %></td>
				</tr>
				<tr>
					<th>申请通道:</th>
					<td><%=apply.getAppchannel() %></td>
				</tr>
				<tr>
					<th>申请等级:</th>
					<td><%=apply.getApplevel() %></td>
				</tr>
				<%		
					}else if(apply.getApptype().equals("2")){
				%>
				<tr>
					<th>认证通过时间:</th>
					<td><%=apply.getCertificationpasstime() %></td>
				</tr>
				<tr>
					<th>复审通道工作时间:</th>
					<td><%=apply.getReexaminationtime() %>（个月）</td>
				</tr>
				<tr>
					<th>复审通道:</th>
					<td><%=apply.getReexaminationchannel() %></td>
				</tr>
				<tr>
					<th>复审专业岗位:</th>
					<td><%=apply.getReexaminationprofesspost() %></td>
				</tr>
				<tr>
					<th>复审等级:</th>
					<td><%=apply.getReexaminationlevel() %></td>
				</tr>
				<%		
					}
				%>
			    <tr>
				  <th >申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=apply.getReason()==null?"":apply.getReason() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>