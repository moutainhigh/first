<%@page import="com.deppon.montal.model.CCOnbusiness"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%CCOnbusiness info  =(CCOnbusiness)request.getAttribute("CCOnbusiness");%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%" >
	    	<tr> <th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
	  		<tr> <th>工作流:</th><td>出差申请<td>
	    	<tr> <th>申请人姓名:</th><td><%=info.getApplypersonname()%></td></tr>
	    	<tr> <th>申请人工号:</th><td><%=info.getApplypersonnumber()%></td></tr>
		    <tr> <th>申请人部门:</th><td><%=info.getApplydept()%></td></tr>
		    <tr> <th>工作交接人:</th><td><%=info.getHandoverperson()%></td></tr>
		    <tr> <th>出差地点:</th><td><%=info.getOnbusinessplace()%></td></tr>
		    <tr> <th>同行人:</th><td><%=info.getAssociate()%></td></tr>
		    <tr> <th>出差日期:</th><td><%=info.getOnbusinessdate()%></td></tr>
		    <tr> <th>截止日期:</th><td><%=info.getDeadline()%></td></tr>
		    <tr> <th>出差事由:</th><td><%=info.getApplyreason()%></td></tr>
	    	</table>
	    	 <%@include file="approve_process.jsp" %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<!-- <script type="text/javascript">
// window.onload = function(){
// 	loadXMLDoc();
// }
// function loadXMLDoc(){
// 	var xmlhttp;
// 	var workID = document.getElementById("workid").value;
// 	if (window.XMLHttpRequest)
// 	  {// code for IE7+, Firefox, Chrome, Opera, Safari
// 	  	xmlhttp=new XMLHttpRequest();
// 	  }
// 	else
// 	  {// code for IE6, IE5
// 	  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
// 	  }
// 	xmlhttp.onreadystatechange=function(){
// 		if (xmlhttp.readyState==4 && xmlhttp.status==200){
// 			 document.getElementById("travle_info_id").innerHTML=xmlhttp.responseText;
// 		}
// 	}
var url = "<%=basePathBut%>/getTravelInfo?workId="+workID;
// 	xmlhttp.open("GET",url,true);
// 	xmlhttp.send(null);
// }

</script> -->
</html>