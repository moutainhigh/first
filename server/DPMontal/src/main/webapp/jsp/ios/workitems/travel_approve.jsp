<%@page import="com.deppon.montal.model.CCOnbusiness"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%CCOnbusiness info  =(CCOnbusiness)request.getAttribute("CCOnbusiness");%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			    <li class="first">工作流号:<em><%=info.getProcessinstid() %></em></li>
		  		<li>工作流:<em>出差申请</em><input type="hidden" id="workid" value="<%=info.getProcessinstid()%>"></li>
		    	<li>申请人姓名:<em><%=info.getApplypersonname()%></em></li>
		    	<li>申请人工号:<em><%=info.getApplypersonnumber()%></em></li>
			    <li>申请人部门:<em><%=info.getApplydept()%></em></li>
			    <li>工作交接人:<em><%=info.getHandoverperson()%></em></li>
			    <li>出差地点:<em><%=info.getOnbusinessplace()%></em></li>
			    <li>同行人:<em><%=info.getAssociate()%></em></li>
			    <li>出差日期:<em><%=info.getOnbusinessdate()%></em></li>
			    <li>截止日期:<em><%=info.getDeadline()%></em></li>
			    <li>出差事由:<em><%=info.getApplyreason()%></em></li>
	    	</ul>
	    </div>
	    <%@include file="approve_process.jsp" %>
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