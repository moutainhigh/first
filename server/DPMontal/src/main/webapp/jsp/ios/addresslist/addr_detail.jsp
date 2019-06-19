<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.model.OmEmployee"%>
<%@ page language="java"  import="com.deppon.montal.*" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-通讯录</title>
	<%@include file="/common_ios.jsp"%>
</head>
<%
	OmEmployee emp = (OmEmployee)request.getAttribute("emp");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String tel ="无";
	if(emp.getMobileNo()!=null){
		tel = emp.getMobileNo().replace(";", "</br>");
	}
%>
<body>
	<div id="list">
	    <%@include file="/jsp/ios/work_items_head.jsp" %>
	    <div id="div2">
    		<div class="tableBox">
				<table>
					<tr>
					   <th width="40%">姓名：</th>
					   <td><%=emp.getEmpName() %></td>
					</tr>
					<tr >
					   <th>工号：</th>
					   <td ><%=emp.getUserId() %></td>
					</tr>
					<tr class="border">
					   <th>手机：</th>
					   <td><%=tel%></td>
					</tr>
					<tr >
					   <th>办公电话：</th>
					   <td><%=emp.getTelephone()==null?"无": emp.getTelephone()%></td>
					</tr>
					<tr >
					   <th>邮箱：</th>
					   <td><%=emp.getEmail()==null?"无": emp.getEmail()%></td>
					</tr>
					<tr >
					   <th>部门：</th>
					   <td><%=emp.getOrgName()==null?"无":emp.getOrgName() %></td>
					</tr>
					<tr >
					   <th>职位：</th>
					   <td><%=emp.getJobName()==null?"无":emp.getJobName() %></td>
					</tr>
					<tr class="border">
					   <th>工作职责：</th>
					   <td><%=emp.getWorkExp()==null?"无":emp.getWorkExp() %></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script>
$(function(){
	$("#to_showMain").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
	
});
window.onload = function(){
  	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/addr_tit.png");
  	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
  	$(".home").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_home.png");
  }
</script>
</body>

</html>