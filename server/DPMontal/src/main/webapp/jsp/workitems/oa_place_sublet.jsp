<%@page import="com.deppon.montal.model.OAPlaceSublet"%>
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
	OAPlaceSublet info = (OAPlaceSublet)request.getAttribute("oa_place_sublet");
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
					   <td>场地转租<input type="hidden" id ="type_id" value="oa_place_sublet"></td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getEmpname()%></td>
				   </tr>
					 <tr>
					  <th>工号:</th>
					  <td><%=info.getEmpcode()%></td>
				   </tr>
				   <tr>
					  <th>转租方式:</th>
					  <td><%=info.getSign_type()%></td>
				   </tr>
					 <tr>
					  <th>所属财务部:</th>
					  <td><%=info.getFinance_dept()%></td>
				   </tr>
					 <tr>
					  <th>所属事业部:</th>
					  <td><%=info.getArea()%></td>
				   </tr>
				   <tr>
					  <th>所属事务组:</th>
					  <td><%=info.getMatter_team()%></td>
				   </tr>
				   <tr>
					  <th>出租方名称:</th>
					  <td><%=info.getRent_name()%></td>
				   </tr>
				   <tr>
					  <th>承租方名称:</th>
					  <td><%=info.getLease_name()%></td>
				   </tr>
				   <tr>
					  <th>承租方主要业务:</th>
					  <td><%=info.getLease_business()%></td>
				   </tr>
				   
				   <tr>
					  <th>是否改造:</th>
					  <td><%=info.getIs_change()%></td>
				   </tr>
				   <tr>
					  <th>改造金额:</th>
					  <td><%=info.getChange_amt()%></td>
				   </tr>
				   <tr>
					  <th>转租部门:</th>
					  <td><%=info.getSublet_dept()%></td>
				   </tr>
				   <tr>
					  <th>付款月数:</th>
					  <td><%=info.getPay_months()%>月</td>
				   </tr>
				   
				   
				   <tr>
					  <th>原租赁面积:</th>
					  <td><%=info.getOld_lease_area()%>平米</td>
				   </tr>
				   <tr>
					  <th>原租赁单价:</th>
					  <td><%=info.getOld_lease_price()%>元/平米/月</td>
				   </tr>
				   <tr>
					  <th>现租赁面积:</th>
					  <td><%=info.getNew_lease_area()%>平米</td>
				   </tr>
				   <tr>
					  <th>现租赁单价:</th>
					  <td><%=info.getNew_lease_price()%>元/平米/月</td>
				   </tr>
				   				   <tr>
					  <th>租赁开始日期:</th>
					  <td><%=info.getLease_start_date()%></td>
				   </tr>
				   <tr>
					  <th>租赁结束日期:</th>
					  <td><%=info.getLease_end_date()%></td>
				   </tr>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApply_origin()==null?"":info.getApply_origin()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>