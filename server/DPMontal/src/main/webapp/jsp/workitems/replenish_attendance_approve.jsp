<%@page import="com.deppon.montal.model.PorentCarOutside"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	PorentCarOutside info = (PorentCarOutside)request.getAttribute("outsideCar");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>补考勤申请<input type="hidden" id ="type_id" value="rentCarOutsides"> </td>
					</tr>
				   <tr>
					  <th>申请人姓名:</th>
					  <td><%=info.getApplypersonname()%></td>
				   </tr>
					 <tr>
					  <th>所属区域:</th>
					  <td><%=info.getApplydept()%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				 <tr class="yellow"><th colspan="2">补考勤信息</tr>
				 <tr id="rep_atten_id"><th colspan="2">查询中,请稍等...</th></tr>
				  <tr>
					  <th>补考勤人员:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				  <tr>
					  <th>所在的部门:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				  <tr>
					  <th>未打卡日期:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				  <tr>
					  <th>补考勤类型:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				  <tr>
					  <th>补考勤事由:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				  <tr>
					  <th>证明人姓名:</th>
					  <td><%=info.getDiscription()%></td>
				   </tr>
				 <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
function showReplenishAtt(){
	var workId = $("#workid").html();
	$.ajax({
		type:"GET",
		url:"<%=basePath%>/getOutsideCarEntry",
		data:"workId="+workId+"&timestamp=" + new Date().getTime(),
	   	cache:false,
		success:function(msg){
			var html = msg;
			if (html == ""){
				html = "无详细信息";
			}
			$("#rep_atten_id").hide();
			$("#rep_atten_id").after(html);
		}
	});
}
setTimeout(showReplenishAtt,100);
</script>
</html>