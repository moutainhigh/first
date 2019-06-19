<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common.jsp" %>
</head>
<body>
	<div data-role="page" id="iosworkItemsview">
		<div data-role="content">
			<div>
				<font style="color: #FAAF19;font-size: 35px;font-weight: bold;">审批工作流</font>
			</div>
			<div class="content-primary">
				 <div class="content-secondary">
				<ul data-role="listview" id="ulist" data-inset="ture" data-theme="c" data-dividertheme="b">
					   <li>工作流号：1234567890</li>
					   <li>工&nbsp;&nbsp;作&nbsp;&nbsp;流：费用报销申请</li>
					   <li>申&nbsp;&nbsp;请&nbsp;&nbsp;人：张三</li>
					   <li>申请部门：IT需求管理部</li>
					   <li>申请理由：XXXXXX，业务需求，望领导批准！</li>
					   <li>
					       <textarea name="textarea-a" id="textarea-a" style="width: 100%;text-align: left;" disabled="disabled">
						   	同意，请找XX联系相关事宜
						   </textarea>
					   </li>
					</ul>
			</div>
			</div><!--/content-primary -->		
		</div>
	</div>
</body>
</html>