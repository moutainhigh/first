<%@page import="com.deppon.montal.model.OAQualificationAuth"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
<%
	OAQualificationAuth apply = (OAQualificationAuth)request.getAttribute("authApply");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
				</li>
				<li>申请类型:<em><%=apply.getApptype().equals("1")?"任职资格报名":"任职资格复审"%> </em></li>
				<li>申请人：<em><%=apply.getName() %></em></li>
				<li>申请人所在部门：<em><%=apply.getDepartment() %></em></li>
				<li>申请人职位：<em><%=apply.getPosition() %></em></li>
				<li>申请人工号：<em><%=apply.getUserid()%></em></li>
				<li>申请人性别：<em><%=apply.getSex() %></em></li>
				<li>申请人身份证号：<em><%=apply.getPincodes()%></em></li>
				<li>入职时间：<em><%=apply.getIncompanytime() %></em></li>
				<li>入申报岗位时间：<em><%=apply.getInapplytime()%></em></li>
				<%
					if(apply.getApptype().equals("1")){
				%>
				
				<li>目前公司薪资标准：<em><%=apply.getSalaryNow()==null?"":apply.getSalaryNow() %></em></li>
				<li>申请公司薪资标准：<em><%=apply.getSalaryNew()==null?"":apply.getSalaryNew() %></em></li>
				<li>当前绩效考核：<em><%=apply.getPerformanceNow()==null?"":apply.getPerformanceNow() %></em></li>
				<li>申请绩效考核：<em><%=apply.getPerformanceNew()==null?"":apply.getPerformanceNew() %></em></li>
				<%		
					}
				%>
				<li>学历：<em><%=apply.getDegree() %></em></li>
				<li>近12/6个月绩效：<em><%=apply.getPerformance()==null?"":apply.getPerformance() %></em></li>
				<%
					if(apply.getApptype().equals("1")){
				%>
				
				<li>是否总监推荐：<em><%=apply.getIsrecommend() %></em></li>
				<li>是否有专业外部经验：<em><%=apply.getIsoutexperience()==null?"":apply.getIsoutexperience()%></em></li>
				<% 
					if(null != apply.getIsoutexperience() && apply.getIsoutexperience().equals("是")){
				%>
				<li>专业外部经验月数：<em><%=apply.getOutexperience()==null?"":apply.getOutexperience()%></em></li>
				<%		
					}
				%>
				<%		
					}
				%>
				
				<li>现属等级：<em><%=apply.getAppchannellevel()%></em></li>
				<li>管理级别：<em><%=apply.getManagementlevel()%></em></li>
				
				<%
					if(apply.getApptype().equals("1")){
				%>
				<li>申请通道工作时间：<em><%=apply.getAppchannelworktime()%>（个月）</em></li>
				<li>申请专业岗位：<em><%=apply.getAppprofessionalpost()%></em></li>
				<li>申请通道：<em><%=apply.getAppchannel()%></em></li>
				<li>申请等级：<em><%=apply.getApplevel()%></em></li>
				<%		
					}else if(apply.getApptype().equals("2")){
				%>
				<li>认证通过时间：<em><%=apply.getCertificationpasstime()%></em></li>
				<li>复审通道工作时间：<em><%=apply.getReexaminationtime()%>（个月）</em></li>
				<li>复审通道：<em><%=apply.getReexaminationchannel()%></em></li>
				<li>复审专业岗位：<em><%=apply.getReexaminationprofesspost()%></em></li>
				<li>复审等级：<em><%=apply.getReexaminationlevel()%></em></li>
				<%		
					}
				%>
			    <li>申请理由：<em><%=apply.getReason()==null?"":apply.getReason()%></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>