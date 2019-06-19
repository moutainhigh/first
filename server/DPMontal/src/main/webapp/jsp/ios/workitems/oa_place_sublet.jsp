<%@page import="com.deppon.montal.model.OAPlaceSublet"%>
<%@page import="java.util.ArrayList"%>
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
	OAPlaceSublet info = (OAPlaceSublet)request.getAttribute("oa_place_sublet");
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="over_time">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
					<li>
					   工&nbsp;&nbsp;作&nbsp;&nbsp;流:
					   <em>场地转租<input type="hidden" id ="type_id" value="oa_place_sublet"></em>
					</li>
				   <li>
					  申请人:
					  <em><%=info.getEmpname()%></em>
				   </li>
					 <li>
					  工号:
					  <em><%=info.getEmpcode()%></em>
				   </li>
				   <li>
					  转租方式:
					  <em><%=info.getSign_type()%></em>
				   </li>
					 <li>
					  所属财务部:
					  <em><%=info.getFinance_dept()%></em>
				   </li>
					 <li>
					  所属事业部:
					  <em><%=info.getArea()%></em>
				   </li>
				   <li>
					  所属事务组:
					  <em><%=info.getMatter_team()%></em>
				   </li>
				   <li>
					  出租方名称:
					  <em><%=info.getRent_name()%></em>
				   </li>
				   <li>
					  承租方名称:
					  <em><%=info.getLease_name()%></em>
				   </li>
				   <li>
					  承租方主要业务:
					  <em><%=info.getLease_business()%></em>
				   </li>
				   
				   <li>
					  是否改造:
					  <em><%=info.getIs_change()%></em>
				   </li>
				   <li>
					  改造金额:
					  <em><%=info.getChange_amt()%></em>
				   </li>
				   <li>
					  转租部门:
					  <em><%=info.getSublet_dept()%></em>
				   </li>
				   <li>
					  付款月数:
					  <em><%=info.getPay_months()%>月</em>
				   </li>
				   
				   
				   <li>
					  原租赁面积:
					  <em><%=info.getOld_lease_area()%>平米</em>
				   </li>
				   <li>
					  原租赁单价:
					  <em><%=info.getOld_lease_price()%>元/平米/月</em>
				   </li>
				   <li>
					  现租赁面积:
					  <em><%=info.getNew_lease_area()%>平米</em>
				   </li>
				   <li>
					  现租赁单价:
					  <em><%=info.getNew_lease_price()%>元/平米/月</em>
				   </li>
				   				   <li>
					  租赁开始日期:
					  <em><%=info.getLease_start_date()%></em>
				   </li>
				   <li>
					  租赁结束日期:
					  <em><%=info.getLease_end_date()%></em>
				   </li>
				   <li>
					  申请事由:
					  <em><%=info.getApply_origin()==null?"":info.getApply_origin()%></em>
				   </li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>