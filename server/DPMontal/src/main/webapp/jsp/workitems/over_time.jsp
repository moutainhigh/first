<%@page import="java.util.ArrayList"%>
<%@page import="com.deppon.montal.model.OvertimeInfo"%>
<%@page import="com.deppon.montal.model.OAOvertimeApply"%>
<%@page import="com.deppon.montal.model.CCBobenefits"%>
<%@page import="com.deppon.montal.model.CCPorent"%>
<%@page import="com.deppon.montal.model.CCExpenseClaim"%>
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
	OAOvertimeApply info = (OAOvertimeApply)request.getAttribute("over_time");
	List<OvertimeInfo> oinfo = new ArrayList<OvertimeInfo>();
	Object o = request.getAttribute("overinfo");
	if(o!=null){
		oinfo = (List<OvertimeInfo>)request.getAttribute("overinfo");		
	}
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
					   <td>加班/加班工资申请<input type="hidden" id ="type_id" value="over_time"></td>
					</tr>
				   <tr>
					  <th>申请人姓名:</th>
					  <td><%=info.getName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getUserid()%></td>
				   </tr>
				   <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getDept()%></td>
				   </tr>
					 <tr>
					  <th>申请人职位:</th>
					  <td><%=info.getPosition()%></td>
				   </tr>
					 <tr>
					  <th>申请类型:</th>
					  <td><%=info.getApplytype()%></td>
				   </tr>
				   <tr>
					  <th>所属人事部:</th>
					  <td><%=info.getPersonneldept()%></td>
				   </tr>
				   
				   <%if("加班工资申请".equals(info.getApplytype())){%>
					   <tr>
						  <th>加班工作流号:</th>
						  <td><%=info.getOtapplyno()%></td>
					   </tr>
				   <% } %>
				   <%if(!"管理人员晚班".equals(info.getApplytype())){%>
					   <tr>
						  <th>平时加班总天数:</th>
						  <td><%=info.getWorkdays()%></td>
					   </tr>
					   <tr>
					  	<th>周末加班总天数:</th>
					  	<td><%=info.getHolidays()%></td>
				  	 	</tr>
				   <%} %>
				   <%if(oinfo!=null){%>
				   <%for(OvertimeInfo temp:oinfo){%>
					 <tr>
					  <th>加班类型:</th>
					  <td><%=temp.getOttype()%></td>
				   </tr>
				   <tr>
					  <th>加班开始日期:</th>
					  <td><%=temp.getBegindate()%></td>
				   </tr>
				   <tr>
					  <th>加班结束日期:</th>
					  <td><%=temp.getEnddate()%></td>
				   </tr>
				   <%} %>
				    <%} %>
				   
				   <%if("管理人员晚班".equals(info.getApplytype())){%>
					   <tr>
					  <th>晚班开始日期:</th>
					  <td><%=info.getNbegindate()%></td>
				   </tr>
				   <tr>
					  <th>晚班结束日期:</th>
					  <td><%=info.getNenddate()%></td>
				   </tr>
				   <tr>
					  <th>晚班总天数:</th>
					  <td><%=info.getNightdays()%></td>
				   </tr>
				   <tr>
					  <th>证明人:</th>
					  <td><%=info.getNwitness()%></td>
				   </tr>
				  <% } %>
				   <tr>
					  <th>加班原因:</th>
					  <td><%=info.getReason()==null?"":info.getReason()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>