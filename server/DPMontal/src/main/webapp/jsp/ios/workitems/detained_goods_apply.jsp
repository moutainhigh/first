<%@page import="com.deppon.montal.model.OAKouhuoApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%
OAKouhuoApply info = (OAKouhuoApply)request.getAttribute("detained_goods_apply");

%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="detained_goods_apply">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
          <li>工作流:<em>扣货申请<input type="hidden" id ="type_id" value="use_seal_apply"></em></li>
					<li>
					  扣货单号:
					  <em><%=info.getKouhuodanhao()%></em></li>
				   
					 <li>
					  货物扣留所在部门:
					  <em><%=info.getGoodsdetaininorgname()%></em></li>
				   
				   <li>
					  保价金额:
					  <em><%=info.getInsuredamout()%></em></li>
				   
					 <li>
					  代收款金额:
					  <em><%=info.getCollectionamout()%></em></li>
				   
				   <li>
					  申请事由:
					  <em><%=info.getWhyapply()==null?"":info.getWhyapply()%></em></li>
				   
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>