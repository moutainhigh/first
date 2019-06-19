<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaPersonAddEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.model.OaPersonAdd"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
	OaPersonAdd person = (OaPersonAdd)request.getAttribute("personAdd");
	List<OaPersonAddEntry> pentryList = (List<OaPersonAddEntry>)request.getAttribute("pentryList");
	String res_title="";
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=person.getProcessinstid() %></td>
					</tr>
					<tr>
					   <th >工作流:</th>
					   <td>增补员申请(新)<input type="hidden" id="type_id" value="personadd"></td>
					</tr>

					<tr>
						<th>申请人姓名：</th>
						<td><%=person.getName() %></td>
					</tr>
				
					<tr>
						<th>申请人工号：</th>
						<td><%=person.getUserid()%></td>
					</tr>
					
					<tr>
						<th>部门性质：</th>
						<td><%=person.getDepttype() %></td>
					</tr>
				
					<tr>
						<th>当地人事部：</th>
						<td><%=person.getLocalpersonnel() %></td>
					</tr>
				
					<tr>
						<th>增补员原因：</th>
						<td><%=person.getAddreason() %></td>
					</tr>
					<%
						if(person.getAddreason().indexOf("离职") != -1){
							res_title = "离职工作流号：";
						}else if(person.getAddreason().indexOf("异动") != -1){
							res_title = "异动工作流号：";
						}else if(person.getAddreason().indexOf("工伤") != -1){
							res_title = "工伤、工亡处理编号：";
						}else if(person.getAddreason().indexOf("请长假") != -1){
							res_title = "请假工作流号：";
						}else{
							
						}
						
						if(!res_title.equals("")){
					%>
					<tr>
						<th><%=res_title %></th>					
						<td><%=person.getPsdata() %></td>
					</tr>
					<%
						}
					%>
					<tr>
						<th>增补员总人数：</th>
						<td><%=person.getAddnum() %></td>
					</tr>
				
				    <tr>
						<th>用人部门：</th>
						<td><%=person.getServent() %></td>
					</tr>
					
					<tr>
						<th colspan="2" class="yellow">增补员详细信息</th>
					</tr>
					<%
						for(int i=0;i<pentryList.size();i++){
							OaPersonAddEntry entry = pentryList.get(i);
					%>
					<tr class="topLine">
						<th>安排职位:</th>
						<td><%=entry.getAddposition() %></td>
					</tr>
					<tr>
						<th>增补员人数:</th>
						<td><%=entry.getAddnumber() %></td>
					</tr>
					<tr>
						<th>人数(男):</th>
						<td><%=entry.getMennumber() %></td>
					</tr>
					<tr>	
						<th>人数(女):</th>
						<td><%=entry.getWomennumber() %></td>
					</tr>
					<tr>
						<th >安排人员:</th>
						<td ><%=entry.getPersoninfos()==null?"":entry.getPersoninfos() %></td>
					</tr>
					<%
						}
					%>
					<tr class="topLine">
						<th>申请事由：</th>
						<td  style="word-wrap:break-word;word-break:break-all"><%=person.getReason()==null?"":person.getReason() %></td>
					</tr>
					 <%@include file="approve_process.jsp" %>
				</table>
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>