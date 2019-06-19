<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaLeaveDetail"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@page import="com.deppon.montal.model.OaLeaveApply"%>
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
<body>
 <%
	OaLeaveApply info = (OaLeaveApply)request.getAttribute(Constants.PAGE_RESULT);

 %>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
			<ul>
			   <li class="first">工作流号：<em><%=info.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
				  	 <input type="hidden" id ="type_id" value="leaveapply">
				</li>
				<li>
    				工作流：<em>请假/调休申请</em>
    			</li>
    			<li>申请人姓名：<em><%=info.getApplyname() %></em></li>
			    <li>申请人工号：<em><%=info.getUserid()%></em></li>
			    <li>所属部门：<em><%=info.getOrgname() %></em></li>
			    <li>所属区域：<em><%=info.getArea() %></em></li>
			    <li>申请类别：<em><%=info.getApplycategory().equals("1")? "请假申请": 
			      		info.getApplycategory().equals("2")? "加班调休申请" : "销假申请" %>
			    </em></li>
			   <%
			   	if(!info.getApplycategory().equals("2")){
			   %>
			    <li>假期所属类型：<em><%=info.getDetailcategory().equals("0")?"无薪假":
			      info.getDetailcategory().equals("1")?"有薪假":
			      info.getDetailcategory().equals("2")?"病假":"产假"
			      %>
			    </em></li>
			   <%
			   	}
			    if(info.getApplycategory().equals("1")){
			   %>
			     <li>入职日期：<em><%=FormatUtil.formatDate(info.getEmployeetime())%></em></li>
			     <li>请假类型：<em><%= F_Constants.codeToString(info.getLeavecategory())%></em></li>
			   <%
			    }
			    if(info.getApplycategory().equals("2")){
			   %>	
			     <li>加班工作流号:<em><%=info.getWorkflowno() %></em></li>
			     <li>加班天数：<em><%=info.getOvertimedays()%></em></li>
			   
			   <%
			    }	
			    if(info.getApplycategory().equals("1") || info.getApplycategory().equals("2")){
			   %>				   
			     <li>请假/调休开始日期：<em><%=FormatUtil.formatDate(info.getDatestart()) %></em></li>
			     <li>请假/调休结束日期：<em><%=FormatUtil.formatDate(info.getDatefinsh()) %></em></li>
		       <%
			    }
			    if(info.getApplycategory().equals("3")){
			   %>
			      <li>入职日期：<em><%=FormatUtil.formatDate(info.getXiaojiaemployeetime()) %></em></li>
			      <li>销假类型:<em><%=F_Constants.codeToString(info.getXiaojia()) %></em></li>
			      <li>销假工作流号：<em><%=info.getXiaojiaprocessinstid() %></em></li>
			      <li>销假开始日期：<em><%=FormatUtil.formatDate(info.getDatestartxiaojia()) %></em></li>
			      <li>销假结束日期：<em><%=FormatUtil.formatDate(info.getDatefinshxiaojia())%></em></li>
			      
			      <%
				    }
			      %>
				   <li><em class="yellow">详细信息</em></li>
				   <% 
						List<OaLeaveDetail> detailList = (List<OaLeaveDetail>)request.getAttribute("detailList");
						int index = 0;
				   		for(OaLeaveDetail detail : detailList){
				   		 if(index ==0){
					%>
					<li>请假月份：<em>
					    <%=detail.getMonth() %>
				   </em></li>
					<% 
					}else{
					 %>
					 <li class="line">请假月份：<em>
					    <%=detail.getMonth() %>
				   </em></li>
					 <%} %>
				   <li>当月请假天数：<em><%=detail.getDays()%></em></li>
				   <%
				   }
				   %>
				   <li>请假/调休天数：<em><%=info.getDays() %></em></li>
				   <li>工作交接人：<em><%=info.getWorkto()%></em></li>
				   <li>申请理由：<em><%=info.getReason()== null ? "" : info.getReason()%></em></li>
				</ul>
		</div>
			<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>