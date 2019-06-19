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
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
		<ul data-role="listview" id="ulist" data-inset="ture" data-theme="c" data-dividertheme="b">
		 <%
			OaPersonAdd person = (OaPersonAdd)request.getAttribute("personAdd");
			List<OaPersonAddEntry> pentryList = (List<OaPersonAddEntry>)request.getAttribute("pentryList");
			String res_title="";
	     %>
			   <li class="first">工作流号：<em><%=person.getProcessinstid() %>
			  	 <input type="hidden" id="workid" value="<%=person.getProcessinstid()%>">
			  	 <input type="hidden" id="type_id" value="personadd">
			   </em></li>
			   <li>工作流：<em>增补员申请(新)</em></li>
			   <li>申请人姓名：<em><%=person.getName() %></em></li>
			   <li>申请人工号：<em><%=person.getUserid() %></em></li>
			   <li>部门性质：<em><%=person.getDepttype() %></em></li>
			   <li>当地人事部：<em><%=person.getLocalpersonnel() %></em></li>
			   <li>增补员原因：<em><%=person.getAddreason() %></em></li>
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
			  <li><%=res_title %></li>
			  <li><%=person.getPsdata() %></li>
			<%
				}
			%>			  
			   <li>增补员总人数：<em><%=person.getAddnum()%></em></li>
                     <li>用人部门：<em><%=person.getServent()%></em></li>
			   <li><em class="yellow">详细信息</em></li>
			<%
				for(int i=0;i<pentryList.size();i++){
					OaPersonAddEntry entry = pentryList.get(i);
					if(i==0){
			%>
				<li>安排职位：<em><%=entry.getAddposition()%></em></li>
			<%}else{ %>					   
			   <li class="line">安排职位：<em><%=entry.getAddposition()%></em></li>	
			<%} %>			   
			   <li>增补员人数：<em><%=entry.getAddnumber()%></em></li>
			   <li>人数(男)：<em><%=entry.getMennumber()%></em></li>
			   <li>人数(女)：<em><%=entry.getWomennumber()%></em></li>
			   <li>安排人员：<em><%=entry.getPersoninfos()==null?"":entry.getPersoninfos() %></em></li>
			<%
				}
			%>					   
			   <li class="last">申请事由：<em><%=person.getReason()==null?"":person.getReason() %></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>