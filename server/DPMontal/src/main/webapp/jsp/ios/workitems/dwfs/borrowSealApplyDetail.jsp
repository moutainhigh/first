<%@page import="com.deppon.wfs.workflow.domain.BorrowSealApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
<%
	BorrowSealApplyBean info = (BorrowSealApplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>借章申请</em></li>
				<li>姓名:<em><%=info.getApplyPersonName()%></em></li>
				<li>工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>部门:<em><%=info.getDept()==null ? "":info.getDept()%></em></li>
				<li>所属事业部:<em><%=info.getArea()==null ? "":info.getArea()%></em></li>
				<li>印章名称:<em><%=info.getSealName()==null ? "":info.getSealName()%></em></li>
				<li>印章类型:<em><%=info.getSealType()==null ? "":info.getSealType()%></em></li>
				<li>印章序号:<em><%=info.getSealSequenceCode()==null ? "":info.getSealSequenceCode()%></em></li>
				<li>借阅份数:<em><%=info.getSealBrrowCounts()==null ? "":info.getSealBrrowCounts()%></em></li>
				<li>章全宗号:<em><%=info.getSealGeneralCode()==null ? "":info.getSealGeneralCode()%></em></li>
				<li>印章档号:<em><%=info.getSealArchivalCode()==null ? "":info.getSealArchivalCode()%></em></li>
				<li>印章所属:<em><%=info.getSealDept()==null ? "":info.getSealDept()%></em></li>
				<li>印章财务部:<em><%=info.getSealBrief()==null ? "":info.getSealBrief()%></em></li>
				<li>保管部门:<em><%=info.getSealAsaveDept()==null ? "":info.getSealAsaveDept()%></em></li>
				<li>印章编号:<em><%=info.getSealCode()==null ? "":info.getSealCode()%></em></li>
				<li>借阅天数:<em><%=info.getBorrowDays()==null ? "":info.getBorrowDays()%></em></li>
				<li>申请日期:<em><%=info.getStartDate()==null ? "":info.getStartDate()%></em></li>
				<li>带章去处:<em><%=info.getSealTaketo()==null ? "":info.getSealTaketo()%></em></li>
				<li>归还时间:<em><%=info.getReturnDate()==null ? "":info.getReturnDate()%></em></li>
				<li>申请事由:<em><%=info.getApplyReason()==null ? "":info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#rollback_but").hide();
	});
</script>
</html>