<%@page import="java.util.ArrayList"%>
<%@page import="com.deppon.montal.model.OvertimeInfo"%>
<%@page import="com.deppon.montal.model.OAOvertimeApply"%>
<%@page import="com.deppon.montal.model.CCBobenefits"%>
<%@page import="com.deppon.montal.model.CCPorent"%>
<%@page import="com.deppon.montal.model.CCPorentEntry"%>
<%@page import="com.deppon.montal.model.CCExpenseClaim"%>
<%@page import="com.deppon.montal.model.CCWelfareexpense"%>
<%@page import="com.deppon.montal.model.PorentCarOutside"%>
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
	OAOvertimeApply info = (OAOvertimeApply)request.getAttribute("over_time");
	List<OvertimeInfo> oinfo = new ArrayList<OvertimeInfo>();
	Object o = request.getAttribute("overinfo");
	if(o!=null){
		oinfo = (List<OvertimeInfo>)request.getAttribute("overinfo");		
	}
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
          <li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>加班/加班工资申请<input type="hidden" id ="type_id" value="over_time"></em></li>
           <li>申请人姓名:<em><%=info.getName()%></em></li>
           <li>申请人工号:<em><%=info.getUserid()%></em></li>
           <li>申请人部门:<em><%=info.getDept()%></em></li>
           <li>申请人职位:<em><%=info.getPosition()%></em></li>
           <li>申请类型:<em><%=info.getApplytype()%></em></li>
           <li> 所属人事部:<em><%=info.getPersonneldept()%></em></li>
           <%if("加班工资申请".equals(info.getApplytype())){%>
             <li> 加班工作流号:<em><%=info.getOtapplyno()%></em></li>
           <% } %>
           <%if(!"管理人员晚班".equals(info.getApplytype())){%>
             <li>平时加班总天数:<em><%=info.getWorkdays()%></em></li>
             <li>周末加班总天数:<em><%=info.getHolidays()%></em></li>
           <%} %>
           <%if(oinfo!=null){%>
           <%for(OvertimeInfo temp:oinfo){%>
           <li> 加班类型:<em><%=temp.getOttype()%></em></li>
           <li>加班开始日期:<em><%=temp.getBegindate()%></em></li>
           <li>加班结束日期:<em><%=temp.getEnddate()%></em></li>
           <%} %>
            <%} %>
           <%if("管理人员晚班".equals(info.getApplytype())){%>
             <li>晚班开始日期:<em><%=info.getNbegindate()%></em></li>
           <li>晚班结束日期:<em><%=info.getNenddate()%></em></li>
           <li>晚班总天数:<em><%=info.getNightdays()%></em></li>
           <li>证明人:<em><%=info.getNwitness()%></em></li>
          <% } %>
           <li>加班原因:<em><%=info.getReason()==null?"":info.getReason()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>